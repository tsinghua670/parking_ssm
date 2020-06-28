package com.parking.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.parking.ssm.domain.Role;
import com.parking.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    IRoleService roleService;

    //查询所有信息
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,@RequestParam(name = "pageSize",required = true,defaultValue = "4") Integer pageSize) throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findAll(page,pageSize);
        PageInfo pageInfo = new PageInfo(roleList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("role-page-list");
        return mv;
    }

    //根据id查询角色信息
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) Integer roleId) throws Exception{
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(roleId);
        mv.addObject("role",role);
        mv.setViewName("role-update");
        return mv;
    }

    //添加角色
    @RequestMapping("/save.do")
    public String save(Role role) throws Exception {
        roleService.save(role);
        return "redirect:findAll.do";
    }

    //修改角色信息
    @RequestMapping("/updateById.do")
    public String updateById(Role role) throws Exception {
        roleService.updateById(role);
        return "redirect:findAll.do";
    }

    //删除角色
    @RequestMapping("/deleteById.do")
    public String deleteById(Integer id) throws Exception {
        roleService.deleteRoleByRoleId(id);
        roleService.deleteById(id);
        return "redirect:findAll.do";
    }


}
