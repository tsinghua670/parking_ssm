package com.parking.ssm.service;

import com.parking.ssm.domain.Role;
import com.parking.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    //查询用户所不具有的角色
    public List<Role> findRoleByUserId(Integer id) throws Exception;

    //给用户添加角色
    public void addRoleToUser(Integer[] ids,Integer userId) throws Exception;

    //查询所有用户信息
    public List<UserInfo> findAll(Integer page,Integer pageSize) throws Exception;

    //精准查询
    public UserInfo findPrecision(String userId) throws Exception;

    //根据id查询用户信息
    public UserInfo findById(Integer id) throws Exception;

    //添加用户
    public void save(UserInfo userInfo) throws Exception;

    //更新用户信息
    public void updateById(UserInfo userInfo) throws Exception;

    //更新用户密码
    public void updatePassword(UserInfo userInfo) throws Exception;

    //删除用户
    public void deleteById(Integer id) throws Exception;

    //删除用户所具角色
    public void deleteRoleByUserId(Integer id) throws Exception;

    //根据用户名查询个人信息
    public UserInfo findUserByName(String username) throws Exception;

}
