package com.parking.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.parking.ssm.dao.IDriverDao;
import com.parking.ssm.domain.Drivers;
import com.parking.ssm.service.IDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DriverServiceImpl implements IDriverService {

    @Autowired
    IDriverDao driverDao;

    //查询所有驾驶员信息
    @Override
    public List<Drivers> findAll(Integer page,Integer pageSize) throws Exception {
        //pageNum是頁碼值，pageSize是每頁顯示的條數
        //在真正執行sql前加上此行代碼，即可实现分页
        PageHelper.startPage(page,pageSize);
        return driverDao.findAll();
    }

    //根据id查询驾驶员信息
    @Override
    public Drivers findById(Integer id) throws Exception {
        return driverDao.findById(id);
    }

    //根据idCard查询驾驶员信息
    @Override
    public Drivers findByIdCard(String idCard) throws Exception {
        return driverDao.findByIdCard(idCard);
    }

    //增加一条信息
    @Override
    public void save(Drivers drivers) throws Exception {
        driverDao.save(drivers);
    }

    //更新一条信息
    @Override
    public void updateById(Drivers drivers) throws Exception {
        driverDao.updateById(drivers);
    }

    //根据id删除
    @Override
    public void deleteById(Integer id) throws Exception {
        driverDao.deleteById(id);
    }


}
