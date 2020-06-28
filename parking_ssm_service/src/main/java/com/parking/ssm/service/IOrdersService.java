package com.parking.ssm.service;

import com.parking.ssm.domain.Orders;

import java.util.List;

public interface IOrdersService {

    //查询所有订单
    public List<Orders> findAll(Integer page,Integer pageSize) throws Exception;

    //查询所有订单
    public List<Orders> findAll2() throws Exception;

    //根据id查询订单详情
    public Orders findById(Integer id) throws Exception;

    //根据orderNum查询订单详情
    public Orders findByorderNum(String orderNum) throws Exception;

    //根据carId查询订单详情
    public Orders findByCarId(Integer carId) throws Exception;

    //根据username查询订单详情
    public List<Orders> findByUsername(Integer page,Integer pageSize,Integer consumerId) throws Exception;

    //根据id删除订单
    public void deleteById(Integer id) throws Exception;

    //根据id更新订单状态
    public void updateById(Orders orders) throws Exception;

    //增加一条订单
    public void save(Orders orders) throws Exception;
}
