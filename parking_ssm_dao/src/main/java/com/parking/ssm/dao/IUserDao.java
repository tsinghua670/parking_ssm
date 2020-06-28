package com.parking.ssm.dao;

import com.parking.ssm.domain.Role;
import com.parking.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {

    //查询用户所不具有的角色
    @Select("select * from role where id not in (select roleId from role_user where UserId=#{id})")
    public List<Role> findRoleByUserId(Integer id) throws Exception;

    //给用户添加角色
    @Insert("insert into role_user(roleId,userId) values(#{roleId},#{userId})")
    public void addRoleToUser(@Param("roleId") Integer roleId,@Param("userId") Integer userId) throws Exception;

    //查询所有用户信息
    @Select("select * from user")
    public List<UserInfo> findAll() throws Exception;

    //根据id进行查询
    @Select("select * from user where id=#{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "userId",property = "userId"),
            @Result(column = "username",property = "username"),
            @Result(column = "realName",property = "realName"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "password",property = "password"),
            @Result(column = "userPhone",property = "userPhone"),
            @Result(column = "address",property = "address"),
            @Result(column = "status",property = "status"),
            @Result(column = "id",property = "roles",javaType = java.util.List.class,many = @Many(select = "com.parking.ssm.dao.IRoleDao.findByUserId"))
    })
    public UserInfo findById(Integer id) throws Exception;

    //根据userId进行查询
    @Select("select * from user where userId=#{userId}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "userId",property = "userId"),
            @Result(column = "username",property = "username"),
            @Result(column = "realName",property = "realName"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "password",property = "password"),
            @Result(column = "userPhone",property = "userPhone"),
            @Result(column = "address",property = "address"),
            @Result(column = "status",property = "status"),
            @Result(column = "id",property = "roles",javaType = java.util.List.class,many = @Many(select = "com.parking.ssm.dao.IRoleDao.findByUserId"))
    })
    public UserInfo findByUserId2(String userId) throws Exception;

    //根据username进行查询
    @Select("select * from user where username=#{username}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "userId",property = "userId"),
            @Result(column = "username",property = "username"),
            @Result(column = "realName",property = "realName"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "password",property = "password"),
            @Result(column = "userPhone",property = "userPhone"),
            @Result(column = "address",property = "address"),
            @Result(column = "status",property = "status"),
            @Result(column = "id",property = "roles",javaType = java.util.List.class,many = @Many(select = "com.parking.ssm.dao.IRoleDao.findByUserId"))
    })
    public UserInfo findUserByName(String username) throws  Exception;

    //添加用户
    @Insert("insert into user(userId,username,realName,sex,password,userPhone,address,status)" +
            " values(#{userId},#{username},#{realName},#{sex},#{password},#{userPhone},#{address},#{status})")
    public void save(UserInfo userInfo) throws Exception;

    //更新用户信息
    @Update("update user set userId=#{userId},username=#{username},realName=#{realName},sex=#{sex},password=#{password},userPhone=#{userPhone},address=#{address},status=#{status} where id=#{id}")
    public void updateById(UserInfo userInfo) throws Exception;

    //更新用户密码
    @Update("update user set password=#{password} where username=#{username}")
    public void updatePassword(UserInfo userInfo) throws Exception;

    //根据ID进行查询
    @Select("select * from user where id=#{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "userId",property = "userId"),
            @Result(column = "username",property = "username"),
            @Result(column = "realName",property = "realName"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "password",property = "password"),
            @Result(column = "userPhone",property = "userPhone"),
            @Result(column = "address",property = "address"),
            @Result(column = "status",property = "status"),
            @Result(column = "id",property = "roles",javaType = java.util.List.class,many = @Many(select = "com.parking.ssm.dao.IRoleDao.findByUserId"))
    })
    public UserInfo findByUserId(Integer id) throws Exception;


    //根据username进行查询（登录逻辑需要）
    @Select("select * from user where username=#{username}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "userId",property = "userId"),
            @Result(column = "username",property = "username"),
            @Result(column = "realName",property = "realName"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "password",property = "password"),
            @Result(column = "userPhone",property = "userPhone"),
            @Result(column = "address",property = "address"),
            @Result(column = "status",property = "status"),
            @Result(column = "id",property = "roles",javaType = java.util.List.class,many = @Many(select = "com.parking.ssm.dao.IRoleDao.findByUserId"))
    })
    public UserInfo findByUsername(String username) throws Exception;

    //删除用户
    @Delete("delete from user where id=#{id}")
    public void deleteById(Integer id) throws Exception;

    //删除用户所具角色
    @Delete("delete from role_user where userId in (select id from user where id=#{id})")
    public void deleteRoleByUserId(Integer id) throws Exception;
}
