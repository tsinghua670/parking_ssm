package com.parking.ssm.dao;

import com.parking.ssm.domain.Cars;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ICarDao {

    //查询所有车辆信息
    @Select("select * from cars")
    public List<Cars> findAll() throws Exception;

    //根据id查询车辆信息
    @Select("select * from cars where id=#{id}")
    public Cars findById(Integer id) throws Exception;

    //根据carNum查询车辆信息
    @Select("select * from cars where carNum=#{carNum}")
    public Cars findBycarNum(String carNum) throws Exception;

    //添加车辆信息
    @Insert("insert into cars(carNum,carBrand,carModel,desces) values(#{carNum},#{carBrand},#{carModel},#{desces})")
    public void save(Cars cars) throws Exception;

    //更新车辆信息
    @Update("update cars set carNum=#{carNum},carBrand=#{carBrand},carModel=#{carModel},desces=#{desces} where id=#{id}")
    public void updateById(Cars cars) throws Exception;

    //删除单条信息
    @Delete("delete from cars where id=#{id}")
    public void deleteById(Integer id) throws Exception;
}
