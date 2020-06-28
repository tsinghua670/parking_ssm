package com.parking.ssm.dao;

import com.parking.ssm.domain.Notices;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface INoticeDao {

    //查询所有公告信息
    @Select("select * from notices")
    public List<Notices> findAll() throws Exception;

    //根据id查询公告信息
    @Select("select * from notices where id=#{id}")
    public Notices findById(Integer id) throws Exception;

    //添加公告
    @Insert("insert into notices(title,content,releaseTime) values(#{title},#{content},#{releaseTime})")
    public void save(Notices notices) throws Exception;

    //更新公告
    @Update("update notices set title=#{title},content=#{content},releaseTime=#{releaseTime} where id=#{id}")
    public void updateById(Notices notices) throws Exception;

    //删除公告
    @Delete("delete from notices where id=#{id}")
    public void deleteById(Integer id) throws Exception;
}
