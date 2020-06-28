package com.parking.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.parking.ssm.domain.Cars;
import com.parking.ssm.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    ICarService carService;

    //查询全部车辆信息
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name = "pageSize",required = true,defaultValue = "4") Integer pageSize) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Cars> carsList = carService.findAll(page,pageSize);
        PageInfo pageInfo = new PageInfo(carsList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("car-page-list");
        return mv;
    }

    //根据id查询车辆信息
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) Integer id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Cars cars = carService.findById(id);
        mv.addObject("cars",cars);
        mv.setViewName("car-update");
        return mv;
    }

    //添加车辆信息
    @RequestMapping("/save.do")
    public String save(Cars cars) throws Exception {
        carService.save(cars);
        return "redirect:findAll.do";
    }

    //更新车辆信息
    @RequestMapping("/updateById.do")
    public String updateById(Cars cars) throws Exception {

        System.out.println(cars.getCarNum() + "---" + cars.getCarBrand() + cars.getDesces());

        carService.updateById(cars);
        return "redirect:findAll.do";
    }

    //删除单条信息
    @RequestMapping("/deleteById.do")
    public String deleteById(@RequestParam(name = "id",required = true) Integer id) throws Exception {
        carService.deleteById(id);
        return "redirect:findAll.do";
    }

}
