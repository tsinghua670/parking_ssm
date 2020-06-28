package com.parking.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.parking.ssm.domain.Seats;
import com.parking.ssm.service.ISeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/seats")
public class SeatController {

    @Autowired
    ISeatService seatService;

    //查询所有车位信息
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                                @RequestParam(name = "pageSize",required = true,defaultValue = "4")Integer pageSize) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Seats> seatsList = seatService.findAll(page,pageSize);
        //PageInfo就是一個分頁的Bean
        PageInfo pageInfo = new PageInfo(seatsList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("seat-page-list");
        return mv;
    }

    //查询所有空闲车位
    @RequestMapping("/findAllByNull.do")
    public ModelAndView findAllByNull(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                      @RequestParam(name = "pageSize",required = true,defaultValue = "4") Integer pageSize) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Seats> allByNull = seatService.findAllByNull(page, pageSize);
        //PageInfo就是一個分頁的Bean
        PageInfo pageInfo = new PageInfo(allByNull);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("seat-null-page-list");
        return mv;
    }

    //根据id查询车位信息
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Seats seat = seatService.findById(id);
        mv.addObject("seat_Tag",seat.getSeatTag());
        mv.addObject("seat_State",seat.getSeatState());
        mv.addObject("seat_Size",seat.getSeatSize());
        mv.addObject("seat",seat);
        mv.setViewName("seat-update");
        return mv;
    }

    //更新信息
    @RequestMapping("/updateById.do")
    public String updateById(Seats seats) throws Exception {
        seatService.updateById(seats);
        return "redirect:findAll.do";
    }

    //增加车位信息
    @RequestMapping("/save.do")
    public String save(Seats seats) throws Exception {
        seatService.save(seats);
        return "redirect:findAll.do";
    }

    //删除单条信息
    @RequestMapping("/deleteById.do")
    public String deleteById(String id) throws Exception {
       seatService.deleteById(id);
       return "redirect:findAll.do";
    }
}
