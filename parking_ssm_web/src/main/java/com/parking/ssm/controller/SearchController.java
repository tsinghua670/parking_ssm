package com.parking.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.parking.ssm.domain.*;
import com.parking.ssm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    IUserService userService;

    @Autowired
    IOrdersService ordersService;

    @Autowired
    IDriverService driverService;

    @Autowired
    ICarService carService;

    @Autowired
    ISeatService seatService;

    //精准查询
    @RequestMapping("/findPrecision.do")
    public ModelAndView findPrecision(@RequestParam(name = "item", required = true) Integer item ,
                                      @RequestParam(name = "search", required = true) String search) throws Exception {
        ModelAndView mv = new ModelAndView();

        switch (item) {
            case 1 :
                Drivers driver = driverService.findByIdCard(search);
                mv.addObject("driver" , driver);
                mv.setViewName("driver-one-page");
                break;
            case 2 :
                Cars cars = carService.findBycarNum(search);
                Orders byCarId = ordersService.findByCarId(cars.getId());
                mv.addObject("orders",byCarId);
                mv.setViewName("orders-one-page");
                break;
            case 3 :
                Seats seat = seatService.findByseatNum(search);
                mv.addObject("seat" , seat);
                mv.setViewName("seat-one-page");
                break;
            case 4 :
                UserInfo precision = userService.findPrecision(search);
                mv.addObject("user",precision);
                mv.setViewName("user-one-page");
                break;
            case 5 :
                Orders orders = ordersService.findByorderNum(search);
                mv.addObject("orders" , orders);
                mv.setViewName("orders-one-page");
                break;
        }

        return mv;
    }

}
