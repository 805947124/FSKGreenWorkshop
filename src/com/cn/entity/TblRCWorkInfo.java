package com.cn.entity;

import java.util.Date;

public class TblRCWorkInfo {
    private String robotno;

    private String clawNum;

    private Integer scanNg;

    private Integer putNg;

    private Integer firstpsNg;

    private Integer putOk;

    private Date dateTime;

    public String getRobotno() {
        return robotno;
    }

    public void setRobotno(String robotno) {
        this.robotno = robotno;
    }

    public String getClawNum() {
        return clawNum;
    }

    public void setClawNum(String clawNum) {
        this.clawNum = clawNum;
    }

    public Integer getScanNg() {
        return scanNg;
    }

    public void setScanNg(Integer scanNg) {
        this.scanNg = scanNg;
    }

    public Integer getPutNg() {
        return putNg;
    }

    public void setPutNg(Integer putNg) {
        this.putNg = putNg;
    }

    public Integer getFirstpsNg() {
        return firstpsNg;
    }

    public void setFirstpsNg(Integer firstpsNg) {
        this.firstpsNg = firstpsNg;
    }

    public Integer getPutOk() {
        return putOk;
    }

    public void setPutOk(Integer putOk) {
        this.putOk = putOk;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}