package com.parking.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.parking.ssm.dao.IRoleDao;
import com.parking.ssm.domain.Role;
import com.parking.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    IRoleDao roleDao;

    //查询所有信息
    @Override
    public List<Role> findAll(Integer page,Integer pageSize) throws Exception {
        PageHelper.startPage(page,pageSize);
        return roleDao.findAll();
    }

    //根据id查询角色信息
    @Override
    public Role findById(Integer id) throws Exception {
        return roleDao.findById(id);
    }

    //添加角色
    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    //修改角色信息
    public void updateById(Role role) throws Exception {
        roleDao.updateById(role);
    }

    //删除角色
    @Override
    public void deleteById(Integer id) throws Exception {
        roleDao.deleteById(id);
    }

    //删除角色所赋予的用户
    @Override
    public void deleteRoleByRoleId(Integer id) throws Exception {
        roleDao.deleteRoleByRoleId(id);
    }

}
