package com.parking.ssm.domain;

public class Drivers {
    private Integer id;
    private  String driverName;
    private Integer sex;    //性别（0 女 ， 1 男）
    private String sexStr;
    private String idCard;  //身份证
    private String phoneNum;
    private String desces;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSexStr() {
        //性别（0 女 ， 1 男）
        if (sex != null){
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getDesces() {
        return desces;
    }

    public void setDesces(String desces) {
        this.desces = desces;
    }
}
