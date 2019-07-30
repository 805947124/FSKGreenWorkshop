package com.cn.entity;

public class TblWorkInfoSumData {
	private String TesterNum;
	private double RepairTime;
	private Integer PassNum;
	private Integer Put_NG;
	private Integer FailNum;
	private Integer SFCErrNum;
	private Integer FirstPS_NG;
	private Integer Put_OK = 0;
	
	
	public String getTesterNum() {
		return TesterNum;
	}
	public void setTesterNum(String testerNum) {
		TesterNum = testerNum;
	}
	public double getRepairTime() {
		return RepairTime;
	}
	public void setRepairTime(double repairTime) {
		RepairTime = repairTime;
	}
	public Integer getPassNum() {
		return PassNum;
	}
	public void setPassNum(Integer passNum) {
		PassNum = passNum;
	}
	public Integer getPut_NG() {
		return Put_NG;
	}
	public void setPut_NG(Integer put_NG) {
		Put_NG = put_NG;
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
	public Integer getFirstPS_NG() {
		return FirstPS_NG;
	}
	public void setFirstPS_NG(Integer firstPS_NG) {
		FirstPS_NG = firstPS_NG;
	}
	public Integer getPut_OK() {
		return Put_OK;
	}
	public void setPut_OK(Integer put_OK) {
		Put_OK = put_OK;
	};
	
}
