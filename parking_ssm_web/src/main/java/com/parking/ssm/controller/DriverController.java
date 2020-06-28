package com.parking.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.parking.ssm.domain.Drivers;
import com.parking.ssm.service.IDriverService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    IDriverService driverService;

    //查询所有信息
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,@RequestParam(name = "pageSize",required = true,defaultValue = "4") Integer pageSize) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Drivers> driversList = driverService.findAll(page,pageSize);
        PageInfo pageInfo = new PageInfo(driversList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("driver-page-list");
        return mv;
    }

    //根据id查询信息
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) Integer id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Drivers drivers = driverService.findById(id);
        Integer sex = drivers.getSex();
        mv.addObject("sex",sex);
        mv.addObject("drivers",drivers);
        mv.setViewName("driver-update");
        return mv;
    }

    //增加信息
    @RequestMapping("/save.do")
    public String save(Drivers drivers) throws Exception {
        driverService.save(drivers);
        return "redirect:findAll.do";
    }

    //更新一条信息
    @RequestMapping("/updateById.do")
    public String updateById(Drivers drivers) throws Exception{
        driverService.updateById(drivers);
        return "redirect:findAll.do";
    }

    //删除一条信息
    @RequestMapping("/deleteById.do")
    public String deleteById(@RequestParam(name = "id",required = true) Integer id) throws Exception {
        driverService.deleteById(id);
        return "redirect:findAll.do";
    }

}
