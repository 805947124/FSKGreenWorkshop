package com.cn.entity;

public class TblProduceByHour {
	
	private String RobotNo;
	private int hour;
	private Integer PassNum;
	
	public TblProduceByHour(String robotNo, int hour, Integer passNum) {
		super();
		RobotNo = robotNo;
		this.hour = hour;
		PassNum = passNum;
	}
	public String getRobotNo() {
		return RobotNo;
	}
	public void setRobotNo(String robotNo) {
		RobotNo = robotNo;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public Integer getPassNum() {
		return PassNum;
	}
	public void setPassNum(Integer passNum) {
		PassNum = passNum;
	}
}
