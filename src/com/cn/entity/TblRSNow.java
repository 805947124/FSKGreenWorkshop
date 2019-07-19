package com.cn.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TblRSNow {
    private Date recordTime;

    private String modelname;

    private String stationname;

    private String robotno;

    private String building;

    private String floor;

    private String area;

    private String errorinfo;

    private String robotstatus;
    
    private String efficiency;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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

    public String getErrorinfo() {
        return errorinfo;
    }

    public void setErrorinfo(String errorinfo) {
        this.errorinfo = errorinfo;
    }

    public String getRobotstatus() {
        return robotstatus;
    }

    public void setRobotstatus(String robotstatus) {
        this.robotstatus = robotstatus;
    }
    
    

	public String getEfficiency() {
		return efficiency;
	}

	public void setEfficiency(String efficiency) {
		this.efficiency = efficiency;
	}

	@Override
	public String toString() {
		return "TblRSNow [recordTime=" + recordTime + ", modelname=" + modelname + ", stationname=" + stationname
				+ ", robotno=" + robotno + ", building=" + building + ", floor=" + floor + ", area=" + area
				+ ", errorinfo=" + errorinfo + ", robotstatus=" + robotstatus + "]";
	}
    
    
    
}