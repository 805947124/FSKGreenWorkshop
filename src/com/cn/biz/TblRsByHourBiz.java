package com.cn.biz;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.entity.TblRSByHour;
import com.cn.entity.TblRSNow;
import com.cn.mapper.TblRSByHourMapper;

@Service
public class TblRsByHourBiz {

	@Autowired
	private TblRSByHourMapper tblRSByHourMapper;

	public List<TblRSByHour> selectByRSByHoueFun() {
		List<TblRSByHour> tblRSByHours = tblRSByHourMapper.selectAll();
		return tblRSByHours;
	}

	public List<TblRSByHour> selectByStatusFun() {
		List<TblRSByHour> tblRSByHours = tblRSByHourMapper.selectByStatus();
		return tblRSByHours;
	}

	public Integer selectByRobotNoFun() {
		int num = tblRSByHourMapper.selectByRobotNo();
		return num;
	}

	public Integer RobotNoRunCountFun() {
		int num = tblRSByHourMapper.selectByRunRobotNo();
		return num;
	}

	public Integer RobotNoStanbyCountFun() {
		int num = tblRSByHourMapper.selectByStanbyRobotNo();
		return num;
	}

	public Integer RobotNoErroCountFun() {
		int num = tblRSByHourMapper.selectByErroRobotNo();
		return num;
	}

	public Integer RobotNoShutdownCountFun() {
		int num = tblRSByHourMapper.selectByShutdownRobotNo();
		return num;
	}

	public List selectModelNameFun() {
		List<String> ModelName = tblRSByHourMapper.selectModelNameFun();
		return ModelName;
	}

	public List selectRobotNoFun(String modelName) {
		List<String> RobotNo = tblRSByHourMapper.selectRobotNoFun(modelName);
		return RobotNo;
	}

	public Date selectMaxDate() {
		// TODO Auto-generated method stub
		Date date = tblRSByHourMapper.selectByHourMaxDate();
		return date;
	}

	public List<TblRSByHour> selectAllRobotNoByCustomerName(String customername) {
		List<TblRSByHour> tblRsByHour = tblRSByHourMapper.selectAllRobotNoByCustomerName(customername);
		return tblRsByHour;
	}

	public List<TblRSByHour> selectAllRunRobotNoByCustomerName(String customername) {
		List<TblRSByHour> tblRsByHour = tblRSByHourMapper.selectAllRunRobotNoByCustomerName(customername);
		return tblRsByHour;
	}

	public List<TblRSByHour> selectAllStanbyRobotNoByCustomerName(String customername) {
		List<TblRSByHour> tblRsByHour = tblRSByHourMapper.selectAllStanbyRobotNoByCustomerName(customername);
		return tblRsByHour;
	}

	public List<TblRSByHour> selectAllErrorRobotNoByCustomerName(String customername) {
		List<TblRSByHour> tblRsByHour = tblRSByHourMapper.selectAllErrorRobotNoByCustomerName(customername);
		return tblRsByHour;
	}

	public List<TblRSByHour> selectAllShutdownRobotNoByCustomerName(String customername) {
		List<TblRSByHour> tblRsByHour = tblRSByHourMapper.selectAllShutdownRobotNoByCustomerName(customername);
		return tblRsByHour;
	}

	public List<TblRSByHour> selectByCustomerName(String customername) {
		// TODO Auto-generated method stub
		List<TblRSByHour> tblRSByHours = tblRSByHourMapper.selectByCunstomerName(customername);
		return tblRSByHours;
	}


	public Integer RobotNoRunTimeCountFun() {
		// TODO Auto-generated method stub
		Integer runTime = tblRSByHourMapper.selectByRunTimeCount();
		return runTime;
	}

	public Integer RobotNoStandbyTimeCountFun() {
		Integer stadbyTime = tblRSByHourMapper.selectByStandbyTimeCount();
		return stadbyTime;
	}

	public Integer RobotNoErroTimeCountFun() {
		Integer ErroTime = tblRSByHourMapper.selectByErroTimeCount();
		return ErroTime;
	}

	public int selectRobotRunTimeCount(String robotno) {
		Integer runTime = tblRSByHourMapper.selectByRunTimeTypeCount(robotno);
		return runTime;
	}
	
	public Integer RobotNoStandbyTimeTypeCountFun(String robotno) {
		Integer stadbyTime = tblRSByHourMapper.selectByStandbyTimeTypeCount(robotno);
		return stadbyTime;
	}

	public Integer RobotNoErroTimeTypeCountFun(String robotno) {
		Integer ErroTime = tblRSByHourMapper.selectByErroTimeTypeCount(robotno);
		return ErroTime;
	}
	public Double selectRunTimes(String robotNo) {
		Double runTimes = tblRSByHourMapper.selectRunTimes(robotNo);
		return runTimes;
	}

	public Double selectStandbyTimes(String robotNo) {
		Double StandbyTimes = tblRSByHourMapper.selectStandbyTimes(robotNo);
		return StandbyTimes;
	}

	public Double selectErrorTimes(String robotNo) {
		Double ErrorTimes = tblRSByHourMapper.selectErrorTimes(robotNo);
		return ErrorTimes;
	}
}
