package com.parking.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.parking.ssm.dao.ISeatDao;
import com.parking.ssm.domain.Seats;
import com.parking.ssm.service.ISeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SeatServiceImpl implements ISeatService {

    @Autowired
    ISeatDao seatDao;

    //查询全部车位信息
    @Override
    public List<Seats> findAll(int page, int pageSize) throws Exception {

        //pageNum是頁碼值，pageSize是每頁顯示的條數
        //在真正執行sql前加上此行代碼，即可实现分页
        PageHelper.startPage(page,pageSize);
        return seatDao.findAll();
    }

    //查询空闲车位
    @Override
    public List<Seats> findAllByNull(int page, int pageSize) throws Exception {
        //pageNum是頁碼值，pageSize是每頁顯示的條數
        //在真正執行sql前加上此行代碼，即可实现分页
        PageHelper.startPage(page,pageSize);
        return seatDao.findAllByNull();
    }

    //根据ID查询
    public Seats findById(String id) throws Exception{
        return seatDao.findById(id);
    }

    //根据seatNum查询
    @Override
    public Seats findByseatNum(String seatNum) throws Exception {
        return seatDao.findByseatNum(seatNum);
    }

    //添加车位信息
    public void save(Seats seats) throws Exception {
        seatDao.save(seats);
    }

    //更新车位信息
    public void updateById(Seats seats) throws Exception {
        seatDao.updateById(seats);
    }

    //更新车位状态
    public void updateStateById(String id) throws Exception{
        seatDao.updateStateById(id);
    }

    //更新车位状态信息
    @Override
    public void updateSeatStateById(Seats seats) throws Exception {
        seatDao.updateSeatStateById(seats);
    }


    //删除单条信息
    public void deleteById(String id) throws Exception {
        seatDao.deleteById(id);
    }
}
