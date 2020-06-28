package com.parking.ssm.domain;

public class Cars {
    private Integer id;
    private String carNum;
    private String carBrand;
    private String carModel;    //车的型号
    private String desces;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getDesces() {
        return desces;
    }

    public void setDesces(String desces) {
        this.desces = desces;
    }
}
