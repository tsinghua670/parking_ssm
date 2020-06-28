package com.parking.ssm.dao;

import com.parking.ssm.domain.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IRoleDao {

    //查询所有角色信息
    @Select("select * from role")
    public List<Role> findAll() throws Exception;

    //根据id查询角色信息
    @Select("select * from role where id=#{id}")
    public Role findById(Integer id) throws Exception;

    //根据UserId查询角色信息（登录）
    @Select("select * from role where id in (select roleId from role_user where userId=#{userId})")
    public List<Role> findByUserId(Integer userId) throws Exception;


    //添加角色
    @Insert("insert into role(roleName,roleDesces) values(#{roleName},#{roleDesces})")
    public void save(Role role) throws Exception;

    //修改角色信息
    @Update("update role set roleName=#{roleName},roleDesces=#{roleDesces} where id=#{id}")
    public void updateById(Role role) throws Exception;

    //删除角色
    @Delete("delete from role where id=#{id}")
    public void deleteById(Integer id) throws Exception;

    //删除角色所赋予的用户
    @Delete("delete from role_user where roleId in (select id from role where id=#{id})")
    public void deleteRoleByRoleId(Integer id) throws Exception;
}
