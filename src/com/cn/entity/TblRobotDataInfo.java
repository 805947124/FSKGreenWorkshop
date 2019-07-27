package com.cn.entity;

public class TblRobotDataInfo {
	private Integer FixName;
	private String Tester_IP;
	private Integer Tester_Status;
	private double RepairTime;
	private Integer RepairNum;
	private Integer INPUT;
	private Integer OUTPUT;
	private Integer FailNum;
	private Integer SFCErrNum;
	private double PS_NG;
	private double PUT_NG;
	
	public TblRobotDataInfo(Integer fixName, String tester_IP, Integer tester_Status, double repairTime,
			Integer repairNum, Integer iNPUT, Integer oUTPUT, Integer failNum, Integer sFCErrNum, double pS_NG,
			double pUT_NG) {
		super();
		FixName = fixName;
		Tester_IP = tester_IP;
		Tester_Status = tester_Status;
		RepairTime = repairTime;
		RepairNum = repairNum;
		INPUT = iNPUT;
		OUTPUT = oUTPUT;
		FailNum = failNum;
		SFCErrNum = sFCErrNum;
		PS_NG = pS_NG;
		PUT_NG = pUT_NG;
	}

	public Integer getFixName() {
		return FixName;
	}

	public void setFixName(Integer fixName) {
		FixName = fixName;
	}

	public String getTester_IP() {
		return Tester_IP;
	}

	public void setTester_IP(String tester_IP) {
		Tester_IP = tester_IP;
	}

	public Integer getTester_Status() {
		return Tester_Status;
	}

	public void setTester_Status(Integer tester_Status) {
		Tester_Status = tester_Status;
	}

	public double getRepairTime() {
		return RepairTime;
	}

	public void setRepairTime(double repairTime) {
		RepairTime = repairTime;
	}

	public Integer getRepairNum() {
		return RepairNum;
	}

	public void setRepairNum(Integer repairNum) {
		RepairNum = repairNum;
	}

	public Integer getINPUT() {
		return INPUT;
	}

	public void setINPUT(Integer iNPUT) {
		INPUT = iNPUT;
	}

	public Integer getOUTPUT() {
		return OUTPUT;
	}

	public void setOUTPUT(Integer oUTPUT) {
		OUTPUT = oUTPUT;
	}

	public Integer getFailNum() {
		return FailNum;
	}

	public void setFailNum(Integer failNum) {
		FailNum = failNum;
	}

	public Integer getSFCErrNum() {
		return SFCErrNum;
	}

	public void setSFCErrNum(Integer sFCErrNum) {
		SFCErrNum = sFCErrNum;
	}

	public double getPS_NG() {
		return PS_NG;
	}

	public void setPS_NG(double pS_NG) {
		PS_NG = pS_NG;
	}

	public double getPUT_NG() {
		return PUT_NG;
	}

	public void setPUT_NG(double pUT_NG) {
		PUT_NG = pUT_NG;
	}
	
	
}
