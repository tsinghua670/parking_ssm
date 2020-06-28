package com.parking.ssm.domain;

import com.parking.ssm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Orders {
    private Integer id;
    private String orderNum;    //订单编号
    private String orderName;   //订单名称
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date orderTime;  //订单创建时间
    private String orderTimeStr;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date inTime;    //停放开始时间
    private String inTimeStr;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date outTime;   //停放结束时间
    private String outTimeStr;
    private String amounts;     // 价格
    private Integer payType;     //支付类型（0 支付宝 ， 1 微信 ，2 其它）
    private String payTypeStr;
    private Integer orderStatus;    //订单状态（0 未支付，1 已支付）
    private String orderStatusStr;
    private String desces;    //备注
    private UserInfo consumer;  //下单用户
    private Cars car;     //车辆
    private Seats seat;   //车位
    private Drivers driver;   //驾驶员




    private Integer carId;  //车辆id
    private String seatId;  //车位id
    private Integer driverId;   //驾驶员id
    private Integer consumerId;     //下单用户


    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public Integer getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Integer consumerId) {
        this.consumerId = consumerId;
    }




    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderTimeStr() {
        if (orderTime != null) {
            orderTimeStr = DateUtils.dateToString(orderTime,"yyyy-MM-dd HH:mm:ss");
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public String getInTimeStr() {
        if (inTime != null) {
            inTimeStr = DateUtils.dateToString(inTime,"yyyy-MM-dd HH:mm:ss");
        }
        return inTimeStr;
    }

    public void setInTimeStr(String inTimeStr) {
        this.inTimeStr = inTimeStr;
    }

    public String getOutTimeStr() {
        if (outTime != null) {
            outTimeStr = DateUtils.dateToString(outTime,"yyyy-MM-dd HH:mm:ss");
        }
        return outTimeStr;
    }

    public void setOutTimeStr(String outTimeStr) {
        this.outTimeStr = outTimeStr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public UserInfo getConsumer() {
        return consumer;
    }

    public void setConsumer(UserInfo consumer) {
        this.consumer = consumer;
    }

    public String getAmounts() {
        return amounts;
    }

    public void setAmounts(String amounts) {
        this.amounts = amounts;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        //支付类型（0 支付宝 ， 1 微信 ，2 其它）
        if (payType != null) {
            if (payType == 0) {
                payTypeStr = "支付宝";
            }else if (payType == 1) {
                payTypeStr = "微信";
            }else if (payType == 2) {
                payTypeStr = "其它";
            }
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusStr() {
        //订单状态（0 未支付，1 已支付）
        if (orderStatus != null) {
            if (orderStatus == 0) {
                orderStatusStr = "未支付";
            }else if (orderStatus == 1) {
                orderStatusStr = "已支付";
            }
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public String getDesces() {
        return desces;
    }

    public void setDesces(String desces) {
        this.desces = desces;
    }

    public Cars getCar() {
        return car;
    }

    public void setCar(Cars car) {
        this.car = car;
    }

    public Seats getSeat() {
        return seat;
    }

    public void setSeat(Seats seat) {
        this.seat = seat;
    }

    public Drivers getDriver() {
        return driver;
    }

    public void setDriver(Drivers driver) {
        this.driver = driver;
    }
}
