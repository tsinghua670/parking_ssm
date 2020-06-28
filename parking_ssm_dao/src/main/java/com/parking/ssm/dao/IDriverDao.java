package com.parking.ssm.dao;

import com.parking.ssm.domain.Drivers;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IDriverDao {

    //查询所有信息
    @Select("select * from drivers")
    public List<Drivers> findAll() throws Exception;

    //根据idCard查询驾驶员信息
    @Select("select * from drivers where idCard=#{idCard}")
    public Drivers findByIdCard(String idCard) throws Exception;

    //根据id查询驾驶员信息
    @Select("select * from drivers where id=#{id}")
    public Drivers findById(Integer id) throws Exception;

    //增加一条信息
    @Insert("insert into drivers(driverName,sex,idCard,phoneNum,desces) values(#{driverName},#{sex},#{idCard},#{phoneNum},#{desces})")
    public void save(Drivers drivers) throws Exception;

    //更新一条信息
    @Update("update drivers set driverName=#{driverName},sex=#{sex},idCard=#{idCard},phoneNum=#{phoneNum},desces=#{desces} where id=#{id}")
    public void updateById(Drivers drivers) throws Exception;

    //根据id删除
    @Delete("delete from drivers where id=#{id}")
    public void deleteById(Integer id) throws Exception;
}
