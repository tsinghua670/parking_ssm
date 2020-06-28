package com.parking.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.parking.ssm.domain.Notices;
import com.parking.ssm.service.INoticeService;
import com.parking.ssm.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    INoticeService noticeService;

    //查看所有公告
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,@RequestParam(name = "pageSize",required = true,defaultValue = "4") Integer pageSize) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Notices> noticesList = noticeService.findAll(page,pageSize);
        PageInfo pageInfo = new PageInfo(noticesList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("notice-page-list");
        return mv;
    }

    //查看所有公告
    @RequestMapping("/findAllNotice.do")
    public ModelAndView findAllNotice(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,@RequestParam(name = "pageSize",required = true,defaultValue = "4") Integer pageSize) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Notices> noticesList = noticeService.findAll(page,pageSize);
        PageInfo pageInfo = new PageInfo(noticesList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("notice-own-page-list");
        return mv;
    }

    //根据id查询公告内容详情
    @RequestMapping("/findDetilById.do")
    public ModelAndView findDetilById(@RequestParam(name = "id",required = true) Integer id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Notices notices = noticeService.findById(id);
        mv.addObject("notices",notices);
        mv.setViewName("notice-show");
        return mv;
    }

    //根据id查询公告内容
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) Integer id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Notices notices = noticeService.findById(id);
        mv.addObject("notices",notices);
        mv.setViewName("notice-update");
        return mv;
    }

    //添加公告
    @RequestMapping("/save.do")
    public String save(Notices notices) throws Exception {
        noticeService.save(notices);
        return "redirect:findAll.do";
    }

    //更新公告
    @RequestMapping("/updateById.do")
    public String updateById(Notices notices) throws Exception {
        noticeService.updateById(notices);
        return "redirect:findAll.do";
    }

    //删除公告
    @RequestMapping("/deleteById.do")
    public String deleteById(@RequestParam(name = "id",required = true) Integer id) throws Exception {
        noticeService.deleteById(id);
        return "redirect:findAll.do";
    }

}
