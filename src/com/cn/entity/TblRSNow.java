package com.cn.entity;

import java.util.Date;
import java.util.List;

import com.cn.util.TblRankingDate;
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
    
    private double efficiency;
    
    private String shortName;
    
    private List<TblRankingDate> TblRankingDate;
    private List<TblRSByHour> TblRSByHour;
    

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
    
	

	public double getEfficiency() {
		return efficiency;
	}

	public void setEfficiency(double efficiency) {
		this.efficiency = efficiency;
	}
	
	
	

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	
	
	public List<TblRankingDate> getTblRankingDate() {
		return TblRankingDate;
	}

	public void setTblRankingDate(List<TblRankingDate> tblRankingDate) {
		TblRankingDate = tblRankingDate;
	}
	
	
	

	public List<TblRSByHour> getTblRSByHour() {
		return TblRSByHour;
	}

	public void setTblRSByHour(List<TblRSByHour> tblRSByHour) {
		TblRSByHour = tblRSByHour;
	}

	@Override
	public String toString() {
		return "TblRSNow [recordTime=" + recordTime + ", modelname=" + modelname + ", stationname=" + stationname
				+ ", robotno=" + robotno + ", building=" + building + ", floor=" + floor + ", area=" + area
				+ ", errorinfo=" + errorinfo + ", robotstatus=" + robotstatus + "]";
	}
    
    
}