package com.parking.ssm.service;

import com.parking.ssm.domain.Notices;

import java.util.List;

public interface INoticeService {

    //查询所有公告信息
    public List<Notices> findAll(Integer page,Integer pageSize) throws Exception;

    //根据id查询公告信息
    public Notices findById(Integer id) throws Exception;

    //添加公告
    public void save(Notices notices) throws Exception;

    //更新公告
    public void updateById(Notices notices) throws Exception;

    //删除公告
    public void deleteById(Integer id) throws Exception;
}
