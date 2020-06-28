package com.parking.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.parking.ssm.dao.ICarDao;
import com.parking.ssm.dao.IDriverDao;
import com.parking.ssm.dao.IOrderDao;
import com.parking.ssm.dao.ISeatDao;
import com.parking.ssm.domain.Orders;
import com.parking.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    IOrderDao orderDao;

    //查询所有订单
    @Override
    public List<Orders> findAll(Integer page,Integer pageSize) throws Exception {
        //pageNum是頁碼值，pageSize是每頁顯示的條數
        //在真正執行sql前加上此行代碼，即可实现分页
        PageHelper.startPage(page,pageSize);
        return orderDao.findAll();
    }

    //查询所有订单
    @Override
    public List<Orders> findAll2() throws Exception {
        return orderDao.findAll();
    }

    //根据id查询订单详情
    @Override
    public Orders findById(Integer id) throws Exception {
        return orderDao.findById(id);
    }

    //根据orderNum查询订单详情
    @Override
    public Orders findByorderNum(String orderNum) throws Exception {
        return orderDao.findByorderNum(orderNum);
    }

    //根据carId查询订单详情
    @Override
    public Orders findByCarId(Integer carId) throws Exception {
        return orderDao.findByCarId(carId);
    }

    //根据consumerId查询订单
    @Override
    public List<Orders> findByUsername(Integer page,Integer pageSize,Integer consumerId) throws Exception {
        return orderDao.findByUsername(consumerId);
    }

    //根据id删除订单
    @Override
    public void deleteById(Integer id) throws Exception {
        orderDao.deleteById(id);
    }

    //根据id更新订单状态
    @Override
    public void updateById(Orders orders) throws Exception {
        orderDao.updateById(orders);
    }

    //增加一条订单
    @Override
    public void save(Orders orders) throws Exception {
        orderDao.save(orders);
    }

}
