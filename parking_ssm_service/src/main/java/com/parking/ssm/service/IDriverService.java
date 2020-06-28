package com.parking.ssm.service;

import com.parking.ssm.domain.Drivers;

import java.util.List;

public interface IDriverService {

    //查询所有驾驶员信息
    public List<Drivers> findAll(Integer page,Integer pageSize) throws Exception;

    //根据id查询驾驶员信息
    public Drivers findById(Integer id) throws Exception;

    //根据idCard查询驾驶员信息
    public Drivers findByIdCard(String idCard) throws Exception;

    //增加一条信息
    public void save(Drivers drivers) throws Exception;

    //更新一条信息
    public void updateById(Drivers drivers) throws Exception;

    //根据id删除
    public void deleteById(Integer id) throws Exception;
}
