package com.parking.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.parking.ssm.domain.SysLog;
import com.parking.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    ISysLogService sysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,@RequestParam(name = "pageSize",required = true,defaultValue = "4") Integer pageSize) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<SysLog> sysLogList = sysLogService.findAll(page,pageSize);
        PageInfo pageInfo = new PageInfo(sysLogList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("syslog-page-list");
        return modelAndView;
    }
}
