package com.cn.entity;

import java.util.Date;

public class TblRSByHour {
    private Date recordTime;

    private String modelname;

    private String stationname;

    private String robotno;

    private String building;

    private String floor;

    private String area;

    private Double runtimes;

    private Double standbytimes;

    private Double errortimes;

    private Date date;

    private String hour;

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname;
    }

    public String getStationname() {
        return stationname;
    }

    public void setStationname(String stationname) {
        this.stationname = stationname;
    }

    public String getRobotno() {
        return robotno;
    }

    public void setRobotno(String robotno) {
        this.robotno = robotno;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Double getRuntimes() {
        return runtimes;
    }

    public void setRuntimes(Double runtimes) {
        this.runtimes = runtimes;
    }

    public Double getStandbytimes() {
        return standbytimes;
    }

    public void setStandbytimes(Double standbytimes) {
        this.standbytimes = standbytimes;
    }

    public Double getErrortimes() {
        return errortimes;
    }

    public void setErrortimes(Double errortimes) {
        this.errortimes = errortimes;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }
}