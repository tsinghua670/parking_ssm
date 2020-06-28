package com.parking.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.parking.ssm.domain.Role;
import com.parking.ssm.domain.UserInfo;
import com.parking.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    //1.给用户添加角色（查询用户所不具有的角色）
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) Integer id) throws Exception {
        ModelAndView mv = new ModelAndView();
        //先根据id查询用户信息
        UserInfo userInfo = userService.findById(id);
        //根据查出来的用户信息来查询用户所没有的角色，查users_role表
        List<Role> roleList = userService.findRoleByUserId(id);
        mv.addObject("userInfo",userInfo);
        mv.addObject("roleList",roleList);
        mv.setViewName("user-role-add");
        return mv;
    }

    //2.给用户添加角色（给用户添加角色）
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) Integer userId,@RequestParam(name = "ids",required = true) Integer[] roleIds) throws Exception {
        userService.addRoleToUser(roleIds,userId);
        return "redirect:findAll.do";
    }

    //查询所有用户信息
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,@RequestParam(name = "pageSize",required = true,defaultValue = "4") Integer pageSize) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userInfoList = userService.findAll(page,pageSize);
        PageInfo pageInfo = new PageInfo(userInfoList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("user-page-list");
        return mv;
    }

    //根据id查询用户信息
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)Integer id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("sex",userInfo.getSex());
        mv.addObject("status",userInfo.getStatus());
        mv.addObject("userInfo",userInfo);
        mv.setViewName("user-update");
        return mv;
    }

    //查看用户详情
    @RequestMapping("/findDetilById.do")
    public ModelAndView findDetilById(@RequestParam(name = "id",required = true) Integer id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("sex",userInfo.getSex());
        mv.addObject("status",userInfo.getStatus());
        mv.addObject("userInfo",userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    //查看个人信息(普通用户)
    @RequestMapping("/findUserByName.do")
    public ModelAndView findUserByName() throws Exception {
        ModelAndView mv = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.out.println("当前用户名：" + currentPrincipalName);
        UserInfo userInfo = userService.findUserByName(currentPrincipalName);
        mv.addObject("sex",userInfo.getSex());
        mv.addObject("status",userInfo.getStatus());
        mv.addObject("userInfo",userInfo);
        mv.setViewName("user-own-show");
        return mv;
    }

    //添加用户
    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) throws Exception {
        userService.save(userInfo);
        return "redirect:findAll.do";
    }


    //更新用户信息
    @RequestMapping("/updateById.do")
    public String updateById(UserInfo userInfo) throws Exception {
        userService.updateById(userInfo);
        return "redirect:findAll.do";
    }

    //根据username查询用户信息
    @RequestMapping("/findByusername.do")
    public ModelAndView findByusername() throws Exception {
        ModelAndView mv = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        UserInfo userInfo = userService.findUserByName(currentPrincipalName);
        mv.addObject("sex",userInfo.getSex());
        mv.addObject("status",userInfo.getStatus());
        mv.addObject("userInfo",userInfo);
        mv.setViewName("user-own-update");
        return mv;
    }
    //更新用户信息(个人)
    @RequestMapping("/updateOwnById.do")
    public String updateOwnById(UserInfo userInfo) throws Exception {
        userService.updateById(userInfo);
        return "redirect:/seats/findAllByNull.do";
    }

    //删除用户信息
    @RequestMapping("/deleteById.do")
    public String deleteById(Integer id) throws Exception {
        userService.deleteRoleByUserId(id);
        userService.deleteById(id);
        return "redirect:findAll.do";
    }

    //修改密码(获取当前用户名)
    @RequestMapping("/preUpdatePassword.do")
    public ModelAndView preUpdatePassword() {
        ModelAndView mv = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.out.println("当前用户名：" + currentPrincipalName);
        mv.addObject("currentPrincipalName",currentPrincipalName);
        mv.setViewName("user-password-update");
        return mv;
    }

    //修改密码(修改)
    @RequestMapping("/updatePassword.do")
    public String updatePassword(UserInfo userInfo) throws Exception{
        userService.updatePassword(userInfo);
        return "redirect:/pages/main.jsp";
    }



}
