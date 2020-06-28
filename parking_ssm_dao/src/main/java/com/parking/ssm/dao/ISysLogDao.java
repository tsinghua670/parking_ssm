package com.parking.ssm.dao;

import com.parking.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ISysLogDao {

    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method}) ")
    public void save(SysLog sysLog) throws Exception;


    @Select("select * from sysLog")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "visitTime",property = "visitTime"),
            @Result(column = "username",property = "username"),
            @Result(column = "ip",property = "ip"),
            @Result(column = "url",property = "url"),
            @Result(column = "executionTime",property = "executionTime"),
            @Result(column = "method",property = "method"),
    })
    public List<SysLog> findAll() throws Exception;
}
