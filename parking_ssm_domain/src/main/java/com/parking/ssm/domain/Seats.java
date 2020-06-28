package com.parking.ssm.domain;

public class Seats {
    private String id;
    private String seatNum;
    private String seatSection;
    private Integer seatState;  //车位状态（0 占用，1 空闲）
    private  String seatStateStr;
    private String seatTag;
    private Integer seatSize;   //车位大小（0 小型车， 1 中型车， 2 大型车）
    private String  seatSizeStr;
    private String seatPrice;

    public String getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(String seatPrice) {
        this.seatPrice = seatPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }

    public String getSeatSection() {
        return seatSection;
    }

    public void setSeatSection(String seatSection) {
        this.seatSection = seatSection;
    }

    public Integer getSeatState() {
        return seatState;
    }

    public void setSeatState(Integer seatState) {
        this.seatState = seatState;
    }

    public String getSeatStateStr() {
        //车位状态（0 占用，1 空闲）
        if (seatState != null) {
            if (seatState == 0) {
                seatStateStr = "占用";
            }else if (seatState == 1) {
                seatStateStr = "空闲";
            }
        }
        return seatStateStr;
    }

    public void setSeatStateStr(String seatStateStr) {
        this.seatStateStr = seatStateStr;
    }

    public String getSeatTag() {
        return seatTag;
    }

    public void setSeatTag(String seatTag) {
        this.seatTag = seatTag;
    }

    public Integer getSeatSize() {
        return seatSize;
    }

    public void setSeatSize(Integer seatSize) {
        this.seatSize = seatSize;
    }

    public String getSeatSizeStr() {
        //车位大小（0 小型车， 1 中型车， 2 大型车）
        if (seatSize != null) {
            if (seatSize == 0) {
                seatSizeStr = "小型车";
            }else if (seatSize == 1) {
                seatSizeStr = "中型车";
            }else if (seatSize == 2) {
                seatSizeStr = "大型车";
            }
        }
        return seatSizeStr;
    }

    public void setSeatSizeStr(String seatSizeStr) {
        this.seatSizeStr = seatSizeStr;
    }
}
