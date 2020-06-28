package com.parking.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.parking.ssm.dao.ICarDao;
import com.parking.ssm.domain.Cars;
import com.parking.ssm.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements ICarService {

    @Autowired
    ICarDao carDao;

    //查询所有车辆
    @Override
    public List<Cars> findAll(int page, int pageSize) throws Exception {
        //pageNum是頁碼值，pageSize是每頁顯示的條數
        //在真正執行sql前加上此行代碼，即可实现分页
        PageHelper.startPage(page,pageSize);
        return carDao.findAll();
    }

    //根据id查询车辆信息
    @Override
    public Cars findById(Integer id) throws Exception {
        return carDao.findById(id);
    }

    //根据carNum查询车辆信息
    @Override
    public Cars findBycarNum(String carNum) throws Exception {
        return carDao.findBycarNum(carNum);
    }

    //添加车辆信息
    @Override
    public void save(Cars cars) throws Exception {
        carDao.save(cars);
    }

    //更新车辆信息
    @Override
    public void updateById(Cars cars) throws Exception {
        carDao.updateById(cars);
    }


    //删除单条信息
    @Override
    public void deleteById(Integer id) throws Exception {
        carDao.deleteById(id);
    }
}
