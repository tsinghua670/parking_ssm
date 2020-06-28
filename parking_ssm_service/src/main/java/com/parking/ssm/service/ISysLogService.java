package com.parking.ssm.service;

import com.parking.ssm.domain.SysLog;

import java.util.List;

public interface ISysLogService {

    public void save(SysLog sysLog) throws Exception;

    public List<SysLog> findAll(Integer page,Integer pageSize) throws Exception;
}
