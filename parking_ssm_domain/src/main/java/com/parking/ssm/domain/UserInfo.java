package com.parking.ssm.domain;

import java.util.List;

public class UserInfo {
    private Integer id;
    private String userId;
    private String username;
    private String realName;
    private Integer sex; //性别（0 女 ， 1 男）
    private String sexStr;
    private String password;
    private String userPhone;
    private String address;
    private Integer status; //状态0 未开启 1 开启
    private String statusStr;
    private List<Role> roles;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusStr() {
        //状态0 未开启 1 开启
        if (status == 0) {
            statusStr = "未开启";
        }else if (status == 1) {
            statusStr = "开启";
        }
        return statusStr;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSexStr() {
        //性别（0 女 ， 1 男）
        if (sex != null) {
            if (sex == 0) {
                sexStr = "女";
            }else if (sex == 1) {
                sexStr = "男";
            }
        }
        return sexStr;
    }

    public void setSexStr(String sexStr) {
        this.sexStr = sexStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
