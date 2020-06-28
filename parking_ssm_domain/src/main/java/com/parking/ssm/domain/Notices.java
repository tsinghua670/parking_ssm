package com.parking.ssm.domain;

import com.parking.ssm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Notices {
    private Integer id;
    private String title;
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date releaseTime;   //公告发布时间
    private String releaseTimeStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReleaseTime() { return releaseTime; }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getReleaseTimeStr() {
        if (releaseTime != null) {
            releaseTimeStr = DateUtils.dateToString(releaseTime,"yyyy-mm-dd HH:mm:ss");
        }
        return releaseTimeStr;
    }

    public void setReleaseTimeStr(String releaseTimeStr) {
        this.releaseTimeStr = releaseTimeStr;
    }
}
