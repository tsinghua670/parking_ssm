package com.parking.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.parking.ssm.domain.*;
import com.parking.ssm.service.*;
import com.parking.ssm.utils.DateUtils;
import com.parking.ssm.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    IOrdersService ordersService;

    @Autowired
    ISeatService seatService;

    @Autowired
    IUserService userService;

    @Autowired
    IDriverService driverService;

    @Autowired
    ICarService carService;


    //查询所有订单信息
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize",required = true,defaultValue = "4") Integer pageSize) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(page,pageSize);
        PageInfo pageInfo = new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    //根据consumerId查询订单信息
    @RequestMapping("/findordersByusername.do")
    public ModelAndView findordersByusername(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                             @RequestParam(name = "pageSize",required = true,defaultValue = "4") Integer pageSize) throws Exception {
        ModelAndView mv = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        UserInfo userInfo = userService.findUserByName(userName);
        List<Orders> ordersList = ordersService.findByUsername(page,pageSize,userInfo.getId());
        PageInfo pageInfo = new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-own-page-list");
        return mv;
    }

    //根据id查询订单详情
    @RequestMapping("/findById.do")
    public ModelAndView findById(Integer id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(id);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }

    //根据id查询订单
    @RequestMapping("/findById_2.do")
    public ModelAndView findById_2(Integer id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(id);
        mv.addObject("OrderStatus",orders.getOrderStatus());
        mv.addObject("orders",orders);
        mv.setViewName("orders-update");
        return mv;
    }

    //根据id查询订单详情(普通用户查询)
    @RequestMapping("/findOwnById.do")
    public ModelAndView findOwnById(Integer id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(id);
        mv.addObject("orders",orders);
        mv.setViewName("orders-own-show");
        return mv;
    }

    //更新订单状态
    @RequestMapping("/updateById.do")
    public String updateById(Orders orders) throws Exception {
        System.out.println("测试打印" + orders.getId());
        System.out.println("测试打印" + orders.getOrderStatus());
        ordersService.updateById(orders);
        return "redirect:findAll.do";
    }

    //1.添加订单(查询车位)
    @RequestMapping("/findSeat.do")
    public ModelAndView findSeat(@RequestParam(name = "id") String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Seats seats = seatService.findById(id);
        mv.addObject("seats",seats);
        mv.setViewName("orders-add");
        return mv;
    }

    //2.添加订单
    @RequestMapping("/addOrders.do")
    public String addOrders(@RequestParam(name = "seatId") String id,Cars cars, Drivers drivers,Orders orders) throws Exception {

        //添加汽车信息
        carService.save(cars);
        //添加驾驶员信息
        driverService.save(drivers);
        //更新车位状态为占有
        seatService.updateStateById(id);

        //查询车位信息
        Seats seats = seatService.findById(id);

        /**
         * 生成订单
         */
        //查询新增加的车辆信息与驾驶员信息
        Cars addCar = carService.findBycarNum(cars.getCarNum());
        Drivers addDriver = driverService.findByIdCard(drivers.getIdCard());

        //获取当前用户名
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        UserInfo userInfo= userService.findUserByName(userName);

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String year = sdf.format(date);
        orders.setOrderNum(year + RandomUtils.getRandom(7));
        orders.setOrderName(seats.getSeatTag());
        orders.setInTime(date);
        orders.setOrderTime(date);
        orders.setOrderStatus(0);
        orders.setConsumerId(userInfo.getId());
        orders.setCarId(addCar.getId());
        orders.setDriverId(addDriver.getId());
        System.out.println("出库时间" + orders.getOutTime());
        //计算支付金额
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String outStr = sdf2.format(orders.getOutTime());
        Date out = sdf2.parse(outStr);
        String inStr = sdf2.format(date);
        Date in = sdf2.parse(inStr);
        long outTime = out.getTime();
        long inTime = in.getTime();
        System.out.println("时间----------" + outTime +"inTime------------" + inTime);
        int hours = (int) ((outTime - inTime) / (1000 * 60 * 60));
        System.out.println("时间差----------" + hours);
        int seatPrice = Integer.parseInt(seats.getSeatPrice());
        System.out.println("价格----------" + seatPrice);
        Integer sum = seatPrice * hours;
        orders.setAmounts(String.valueOf(sum));
        System.out.println("计算成功----------" + sum);
        //添加一条订单到数据库
        ordersService.save(orders);

        return "redirect:/seats/findAllByNull.do";
    }

    //删除一条订单
    @RequestMapping("/deleteById.do")
    public String deleteById(Integer id) throws Exception {
        Orders orders = ordersService.findById(id);
        driverService.deleteById(orders.getDriver().getId());
        carService.deleteById(orders.getCar().getId());
        orders.getSeat().setSeatState(1);
        seatService.updateSeatStateById(orders.getSeat());
        ordersService.deleteById(id);
//        return "redirect:/pages/main.jsp";
        return "redirect:findAll.do";
    }

    //统计收入
    @RequestMapping("/findMoney.do")
    public ModelAndView findMoney() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Orders> allOrder = ordersService.findAll2();
        int count = 0 ;
        for (int i = 0; i < allOrder.size(); i++) {
            Orders orders = allOrder.get(i);
            count += Integer.parseInt(orders.getAmounts());
        }
        mv.addObject("OrdersCount" , count);
        mv.setViewName("orders-count");
        return mv;
    }

}
