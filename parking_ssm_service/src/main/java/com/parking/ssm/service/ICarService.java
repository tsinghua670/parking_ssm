package com.parking.ssm.service;

import com.parking.ssm.domain.Cars;

import java.util.List;

public interface ICarService {

    //查询所有车辆
    public List<Cars> findAll(int page, int pageSize) throws Exception;

    //根据id查询车辆信息
    public Cars findById(Integer id) throws Exception;

    //根据carNum查询车辆信息
    public Cars findBycarNum(String carNum) throws Exception;

    //添加车辆信息
    public void save(Cars cars) throws Exception;

    //更新车辆信息
    public void updateById(Cars cars) throws Exception;

    //删除单条信息
    public void deleteById(Integer id) throws Exception;
}
