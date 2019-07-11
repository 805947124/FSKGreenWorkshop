package com.cn.entity;

import java.util.Date;

public class TblRTWorkInfo {
    private String robotno;

    private String testernum;

    private String testerIp;

    private String status;

    private Integer totaltest;

    private Integer passnum;

    private Integer failnum;

    private Integer fenum;

    private Integer sfcerrnum;

    private Double repairtime;

    private Integer putNg;

    private Integer firstpsNg;

    private Integer putOk;

    private Date dateTime;

    private String station;

    private String model;

    public String getRobotno() {
        return robotno;
    }

    public void setRobotno(String robotno) {
        this.robotno = robotno;
    }

    public String getTesternum() {
        return testernum;
    }

    public void setTesternum(String testernum) {
        this.testernum = testernum;
    }

    public String getTesterIp() {
        return testerIp;
    }

    public void setTesterIp(String testerIp) {
        this.testerIp = testerIp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotaltest() {
        return totaltest;
    }

    public void setTotaltest(Integer totaltest) {
        this.totaltest = totaltest;
    }

    public Integer getPassnum() {
        return passnum;
    }

    public void setPassnum(Integer passnum) {
        this.passnum = passnum;
    }

    public Integer getFailnum() {
        return failnum;
    }

    public void setFailnum(Integer failnum) {
        this.failnum = failnum;
    }

    public Integer getFenum() {
        return fenum;
    }

    public void setFenum(Integer fenum) {
        this.fenum = fenum;
    }

    public Integer getSfcerrnum() {
        return sfcerrnum;
    }

    public void setSfcerrnum(Integer sfcerrnum) {
        this.sfcerrnum = sfcerrnum;
    }

    public Double getRepairtime() {
        return repairtime;
    }

    public void setRepairtime(Double repairtime) {
        this.repairtime = repairtime;
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

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}