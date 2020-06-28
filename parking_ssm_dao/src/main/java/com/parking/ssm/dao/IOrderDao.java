package com.parking.ssm.dao;

import com.parking.ssm.domain.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrderDao {

    //增加一条订单
    @Insert("insert into orders(orderNum,orderName,orderTime,inTime,outTime,consumerId,amounts,payType,orderStatus,desces,carId,seatId,driverId)" +
            " values(#{orderNum},#{orderName},#{orderTime},#{inTime},#{outTime},#{consumerId},#{amounts},#{payType},#{orderStatus},#{desces},#{carId},#{seatId},#{driverId})")
    public void save(Orders orders) throws Exception;

    //查询所有订单
    @Select("select * from orders")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderName",property = "orderName"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "inTime",property = "inTime"),
            @Result(column = "outTime",property = "outTime"),
            @Result(column = "amounts",property = "amounts"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "desces",property = "desces"),
            @Result(column = "consumerId",property = "consumer",javaType = UserInfo.class,one = @One(select = "com.parking.ssm.dao.IUserDao.findById")),
            @Result(column = "carId",property = "car",javaType = Cars.class,one = @One(select = "com.parking.ssm.dao.ICarDao.findById")),
            @Result(column = "seatId",property = "seat",javaType = Seats.class,one = @One(select = "com.parking.ssm.dao.ISeatDao.findById")),
            @Result(column = "driverId",property = "driver",javaType = Drivers.class,one = @One(select = "com.parking.ssm.dao.IDriverDao.findById"))
    })
    public List<Orders> findAll() throws Exception;

    //根据id查询订单详情
    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderName",property = "orderName"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "inTime",property = "inTime"),
            @Result(column = "outTime",property = "outTime"),
            @Result(column = "amounts",property = "amounts"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "desces",property = "desces"),
            @Result(column = "consumerId",property = "consumer",javaType = UserInfo.class,one = @One(select = "com.parking.ssm.dao.IUserDao.findById")),
            @Result(column = "carId",property = "car",javaType = Cars.class,one = @One(select = "com.parking.ssm.dao.ICarDao.findById")),
            @Result(column = "seatId",property = "seat",javaType = Seats.class,one = @One(select = "com.parking.ssm.dao.ISeatDao.findById")),
            @Result(column = "driverId",property = "driver",javaType = Drivers.class,one = @One(select = "com.parking.ssm.dao.IDriverDao.findById"))
    })
    public Orders findById(Integer id) throws Exception;

    //根据orderNum查询订单详情
    @Select("select * from orders where orderNum=#{orderNum}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderName",property = "orderName"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "inTime",property = "inTime"),
            @Result(column = "outTime",property = "outTime"),
            @Result(column = "amounts",property = "amounts"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "desces",property = "desces"),
            @Result(column = "consumerId",property = "consumer",javaType = UserInfo.class,one = @One(select = "com.parking.ssm.dao.IUserDao.findById")),
            @Result(column = "carId",property = "car",javaType = Cars.class,one = @One(select = "com.parking.ssm.dao.ICarDao.findById")),
            @Result(column = "seatId",property = "seat",javaType = Seats.class,one = @One(select = "com.parking.ssm.dao.ISeatDao.findById")),
            @Result(column = "driverId",property = "driver",javaType = Drivers.class,one = @One(select = "com.parking.ssm.dao.IDriverDao.findById"))
    })
    public Orders findByorderNum(String orderNum) throws Exception;

    //根据carID查询订单详情
    @Select("select * from orders where carId=#{carId}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderName",property = "orderName"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "inTime",property = "inTime"),
            @Result(column = "outTime",property = "outTime"),
            @Result(column = "amounts",property = "amounts"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "desces",property = "desces"),
            @Result(column = "consumerId",property = "consumer",javaType = UserInfo.class,one = @One(select = "com.parking.ssm.dao.IUserDao.findById")),
            @Result(column = "carId",property = "car",javaType = Cars.class,one = @One(select = "com.parking.ssm.dao.ICarDao.findById")),
            @Result(column = "seatId",property = "seat",javaType = Seats.class,one = @One(select = "com.parking.ssm.dao.ISeatDao.findById")),
            @Result(column = "driverId",property = "driver",javaType = Drivers.class,one = @One(select = "com.parking.ssm.dao.IDriverDao.findById"))
    })
    public Orders findByCarId(Integer carId) throws Exception;

    //根据consumerId查询订单详情
    @Select("select * from orders where consumerId=#{consumerId}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderName",property = "orderName"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "inTime",property = "inTime"),
            @Result(column = "outTime",property = "outTime"),
            @Result(column = "amounts",property = "amounts"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "desces",property = "desces"),
            @Result(column = "consumerId",property = "consumer",javaType = UserInfo.class,one = @One(select = "com.parking.ssm.dao.IUserDao.findById")),
            @Result(column = "carId",property = "car",javaType = Cars.class,one = @One(select = "com.parking.ssm.dao.ICarDao.findById")),
            @Result(column = "seatId",property = "seat",javaType = Seats.class,one = @One(select = "com.parking.ssm.dao.ISeatDao.findById")),
            @Result(column = "driverId",property = "driver",javaType = Drivers.class,one = @One(select = "com.parking.ssm.dao.IDriverDao.findById"))
    })
    public List<Orders> findByUsername(Integer consumerId) throws Exception;

    //根据id删除订单
    @Delete("delete from orders where id=#{id}")
    public void deleteById(Integer id) throws Exception;

    //根据id更新订单状态
    @Update("update orders set orderStatus=#{orderStatus} where id=#{id}")
    public void updateById(Orders orders) throws Exception;
}
