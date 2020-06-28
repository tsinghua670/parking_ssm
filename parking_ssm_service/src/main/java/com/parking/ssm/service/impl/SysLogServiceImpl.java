package com.parking.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.parking.ssm.dao.ISysLogDao;
import com.parking.ssm.domain.SysLog;
import com.parking.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    ISysLogDao sysLogDao;

    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll(Integer page,Integer pageSize) throws Exception {
        PageHelper.startPage(page,pageSize);
        return sysLogDao.findAll();
    }
}
