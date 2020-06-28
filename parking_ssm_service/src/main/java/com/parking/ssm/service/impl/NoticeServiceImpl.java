package com.parking.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.parking.ssm.dao.INoticeDao;
import com.parking.ssm.domain.Notices;
import com.parking.ssm.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NoticeServiceImpl implements INoticeService {

    @Autowired
    INoticeDao noticeDao;


    //查询所有公告信息
    @Override
    public List<Notices> findAll(Integer page,Integer pageSize) throws Exception {
        PageHelper.startPage(page,pageSize);
        return noticeDao.findAll();
    }

    //根据id查询公告信息
    @Override
    public Notices findById(Integer id) throws Exception {
        return noticeDao.findById(id);
    }

    //添加公告
    @Override
    public void save(Notices notices) throws Exception {
        noticeDao.save(notices);
    }

    //更新公告
    @Override
    public void updateById(Notices notices) throws Exception {
        noticeDao.updateById(notices);
    }

    //删除公告
    @Override
    public void deleteById(Integer id) throws Exception {
        noticeDao.deleteById(id);
    }


}
