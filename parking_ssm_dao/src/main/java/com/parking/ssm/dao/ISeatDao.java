package com.parking.ssm.dao;

import com.parking.ssm.domain.Seats;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ISeatDao {

    //查询全部
    @Select("select * from seats")
    public List<Seats> findAll() throws Exception;

    //查询空闲车位
    @Select("select * from seats where seatState = 1")
    public List<Seats> findAllByNull() throws Exception;

    //根据ID查询
    @Select("select * from seats where id=#{id}")
    public Seats findById(String id) throws Exception;

    //根据seatNum查询
    @Select("select * from seats where seatNum=#{seatNum}")
    public Seats findByseatNum(String seatNum) throws Exception;

    //增加车位信息
    @Insert("insert into seats(id,seatNum,seatSection,seatState,seatTag,seatSize,seatPrice) " +
            "values(#{id},#{seatNum},#{seatSection},#{seatState},#{seatTag},#{seatSize},#{seatPrice})")
    public void save(Seats seats) throws Exception;

    //更新车位信息
    @Update("update seats set " +
            "seatNum=#{seatNum},seatSection=#{seatSection},seatState=#{seatState},seatTag=#{seatTag},seatSize=#{seatSize},seatPrice=#{seatPrice} " +
            "where id=#{id}")
    public void updateById(Seats seats) throws Exception;

    //更新车位状态
    @Update("update seats set seatState='0' where id=#{id}")
    public void updateStateById(String id) throws Exception;

    //更新车位状态信息
    @Update("update seats set " +
            "seatNum=#{seatNum},seatSection=#{seatSection},seatState=#{seatState},seatTag=#{seatTag},seatSize=#{seatSize},seatPrice=#{seatPrice} " +
            "where id=#{id}")
    public void updateSeatStateById(Seats seats) throws Exception;

    //删除单条信息
    @Delete("delete from seats where id=#{id}")
    public void deleteById(String id) throws Exception;
}
