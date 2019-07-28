package com.cn.entity;

public class TblTesterStatus {
	private String Tester_IP;
	private String status;
	private Integer PassNum;
	public String getTester_IP() {
		return Tester_IP;
	}
	public void setTester_IP(String tester_IP) {
		Tester_IP = tester_IP;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getPassNum() {
		return PassNum;
	}
	public void setPassNum(Integer passNum) {
		PassNum = passNum;
	}
}
