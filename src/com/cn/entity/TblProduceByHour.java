package com.cn.entity;

public class TblProduceByHour {
	
	private String RobotNo;
	private Integer PassNum;
	private Integer hour;
	
	
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
