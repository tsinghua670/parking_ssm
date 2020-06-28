package com.parking.ssm.service;

import com.parking.ssm.domain.Seats;

import java.util.List;

public interface ISeatService {

    //查询全部车位
    public List<Seats> findAll(int page, int pageSize) throws Exception;

    //查询空闲车位
    public List<Seats> findAllByNull(int page,int pageSize) throws Exception;

    //根据ID查询
    public Seats findById(String id) throws Exception;

    //根据seatNum查询
    public Seats findByseatNum(String seatNum) throws Exception;

    //添加车位信息
    public void save(Seats seats) throws Exception;

    //更新车位信息
    public void updateById(Seats seats) throws Exception;

    //更新车位状态
    public void updateStateById(String id) throws Exception;

    //更新车位状态信息
    public void updateSeatStateById(Seats seats) throws Exception;

    //删除单条信息
    public void deleteById(String id) throws Exception;

}
