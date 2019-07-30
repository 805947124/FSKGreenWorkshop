package com.cn.biz;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cn.entity.TblProduceByHour;
import com.cn.entity.RepairNum;
import com.cn.entity.TblTesterStatus;
import com.cn.entity.TblWorkInfoSumData;
import com.cn.mapper.TblRTWorkInfoMapper;

@Service
public class TblRTWorkInfoBiz {

	@Autowired
	private TblRTWorkInfoMapper tblRTWorkInfoMapper;

	public Integer selectPassNumFun(String robotno, String starDate, String endDate) {
		// TODO Auto-generated method stub
		Integer passNum = tblRTWorkInfoMapper.selectPassNum(robotno,starDate,endDate);
		return passNum;
	}

	public Integer selectputNgFun(String robotno, String starDate, String endDate) {
		Integer putNg = tblRTWorkInfoMapper.selectPutNg(robotno,starDate,endDate);
		return putNg;
	}

	public Integer selectfailNumFun(String robotno, String starDate, String endDate) {
		Integer failNum = tblRTWorkInfoMapper.selectFailNum(robotno,starDate,endDate);
		return failNum;
	}

	public Date selectMaxDate() {
		Date date = tblRTWorkInfoMapper.selectMaxDate();
		return date;
	}

	public List<TblProduceByHour> selectPassNumbyHour(String robotNo, String startDate, String endDate) {
		List<TblProduceByHour> tblProduceByHours = tblRTWorkInfoMapper.selectPassNumbyHour(robotNo,startDate,endDate);
		return tblProduceByHours;
	}

	public Integer selectFailNumbyHour(String robotNo, String startDate, String endDate) {
		Integer FailNum = tblRTWorkInfoMapper.selectFailNumbyHour(robotNo,startDate,endDate);
		return FailNum;
	}

	public Integer selectPut_NGbyHour(String robotNo, String startDate, String endDate) {
		Integer Put_NG = tblRTWorkInfoMapper.selectPut_NGbyHour(robotNo,startDate,endDate);
		return Put_NG;
	}

	public Date selectNewDayTimeByDay(String robotNo) {
		Date NewDayTime = tblRTWorkInfoMapper.selectNewDayTimeByDay(robotNo);
		return NewDayTime;
	}

	public List<TblTesterStatus> selectTesterStatus(String strNewDayTime,String robotNo) {
		List<TblTesterStatus> tblTesterStatus = tblRTWorkInfoMapper.selectTesterStatus(strNewDayTime,robotNo);
		return tblTesterStatus;
	}

	public List<TblWorkInfoSumData> selectWorkInfoSum(String startTime, String endTime, String robotNo) {
		List<TblWorkInfoSumData> tblWorkInfoSumData = tblRTWorkInfoMapper.selectWorkInfoSum(startTime,endTime,robotNo);
		return tblWorkInfoSumData;
	}

	public List<RepairNum> selectTesterRepairNum(String startTime, String endTime, String robotNo) {
		List<RepairNum> RepairNum = tblRTWorkInfoMapper.selectTesterRepairNum(startTime,endTime,robotNo);
		return RepairNum;
	}

	public Date selectNewDayTimeByHour(String robotNo, String startTime, String endTime) {
		Date NewHourTime = tblRTWorkInfoMapper.selectNewDayTimeByHour(robotNo,startTime,endTime);
		return NewHourTime;
	}
}
