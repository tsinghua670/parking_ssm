package com.parking.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.parking.ssm.dao.IUserDao;
import com.parking.ssm.domain.Role;
import com.parking.ssm.domain.UserInfo;
import com.parking.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDao userDao;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    //查询用户所不具有的角色
    @Override
    public List<Role> findRoleByUserId(Integer id) throws Exception {
        return userDao.findRoleByUserId(id);
    }

    //给用户添加角色
    @Override
    public void addRoleToUser(Integer[] ids,Integer userId) throws Exception {
        for (Integer roleId:ids) {
            userDao.addRoleToUser(roleId,userId);
        }
    }


    //查询所有用户信息
    @Override
    public List<UserInfo> findAll(Integer page,Integer pageSize) throws Exception {
        PageHelper.startPage(page,pageSize);
        return userDao.findAll();
    }

    //精准查询
    @Override
    public UserInfo findPrecision(String userId) throws Exception {
        return userDao.findByUserId2(userId);
    }

    //根据id查询用户信息
    @Override
    public UserInfo findById(Integer id) throws Exception {
        return userDao.findById(id);
    }

    //添加用户
    @Override
    public void save(UserInfo userInfo) throws Exception {
        //对密码进行加密
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    //更新用户信息
    @Override
    public void updateById(UserInfo userInfo) throws Exception {
        //对密码进行加密
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.updateById(userInfo);
    }

    //更新用户密码
    @Override
    public void updatePassword(UserInfo userInfo) throws Exception {
        //对密码进行加密
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.updatePassword(userInfo);
    }

    //删除用户
    @Override
    public void deleteById(Integer id) throws Exception {
        userDao.deleteById(id);
    }

    //删除用户所具角色
    @Override
    public void deleteRoleByUserId(Integer id) throws Exception {
        userDao.deleteRoleByUserId(id);
    }

    //根据用户名查询个人信息
    @Override
    public UserInfo findUserByName(String username) throws Exception {
        return userDao.findUserByName(username);
    }


    //登录
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
           userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Role> roleList = userInfo.getRoles();
        List<SimpleGrantedAuthority> authorities = getAuthority(roleList);

        //處理自己的用戶對象封裝成UserDetails
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus() == 0 ? false : true,
                true,true,true,authorities);
        return user;
    }

    //作用就是返回一個List集合，集合中裝入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }

}
