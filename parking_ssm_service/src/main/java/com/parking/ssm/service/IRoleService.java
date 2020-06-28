package com.parking.ssm.service;

import com.parking.ssm.domain.Role;

import java.util.List;

public interface IRoleService {

    //查询所有信息
    public List<Role> findAll(Integer page,Integer pageSize) throws Exception;

    //根据id查询角色信息
    public Role findById(Integer id) throws Exception;

    //添加信息
    public void save(Role role) throws Exception;

    //修改角色信息
    public void updateById(Role role) throws Exception;

    //删除角色
    public void deleteById(Integer id) throws Exception;

    //删除角色所赋予的用户
    public void deleteRoleByRoleId(Integer id) throws Exception;

}
