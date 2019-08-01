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


	public Double RobotNoRunTimeCountFun() {
		// TODO Auto-generated method stub
		Double runTime = tblRSByHourMapper.selectByRunTimeCount();
		return runTime;
	}

	public Double RobotNoStandbyTimeCountFun() {
		Double stadbyTime = tblRSByHourMapper.selectByStandbyTimeCount();
		return stadbyTime;
	}

	public Double RobotNoErroTimeCountFun() {
		Double ErroTime = tblRSByHourMapper.selectByErroTimeCount();
		return ErroTime;
	}

	public Double selectRobotRunTimeCount(String robotno, String startDate, String finishDate) {
		Double runTime = tblRSByHourMapper.selectByRunTimeTypeCount(robotno,startDate,finishDate);
		return runTime;
	}
	
	public Double RobotNoStandbyTimeTypeCountFun(String robotno, String startDate, String finishDate) {
		Double stadbyTime = tblRSByHourMapper.selectByStandbyTimeTypeCount(robotno,startDate,finishDate);
		return stadbyTime;
	}

	public Double RobotNoErroTimeTypeCountFun(String robotno, String startDate, String finishDate) {
		Double ErroTime = tblRSByHourMapper.selectByErroTimeTypeCount(robotno,startDate,finishDate);
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

	
	public Double selectRunTimesFun(String startDate, String endDate) {
		Double runTimes = tblRSByHourMapper.selectRunTimesFun(startDate,endDate);
		return runTimes;
	}

	public Double selectErrorTimesFun(String startDate, String endDate) {
		Double errorTimes = tblRSByHourMapper.selectErrorTimesFun(startDate,endDate);
		return errorTimes;
	}

	public Double selectStandbyTimesFun(String startDate, String endDate) {
		Double standbyTimes = tblRSByHourMapper.selectStandbyTimesFun(startDate,endDate);
		return standbyTimes;
	}
	public List<TblRSByHour> selectRobotNoRunTimeTrend(String robotNo) {
		List<TblRSByHour> RobotNoRunTimeTrend = tblRSByHourMapper.selectRobotNoRunTimeTrend(robotNo);
		return RobotNoRunTimeTrend;

	}
	

	public double selectRunTimesTypeFun(String startDate, String endDate, String robotno) {
		Double runTimes = tblRSByHourMapper.selectRunTimesTypeFun(startDate,endDate,robotno);
		if (runTimes==null) {
			return 0.0;
		}else {
			return runTimes;
		}
		
	}

	public double selectErrorTimesTypeFun(String startDate, String endDate, String robotno) {
		Double errorTimes = tblRSByHourMapper.selectErrorTimesTypeFun(startDate,endDate,robotno);
		if (errorTimes==null) {
			return 0.0;
		}else {
			return errorTimes;
		}
	}

	public double selectStandbyTimesTypeFun(String startDate, String endDate, String robotno) {
		Double standbyTimes = tblRSByHourMapper.selectStandbyTimesTypeFun(startDate,endDate,robotno);
		if (standbyTimes==null) {
			return 0.0;
		}else {
			return standbyTimes;
		}
	}

	public List<TblRSByHour> selectByDateAndRobotNo(String robotno, String startDate) {
		// TODO Auto-generated method stub
		List<TblRSByHour> tblRSByHours = tblRSByHourMapper.selectDateAndRobotNo(robotno,startDate);
		return tblRSByHours;
	}

	public List<TblRSByHour> selectByCustomerNameByModelName(String customername, String modelName) {
		List<TblRSByHour> tblRSByHour = tblRSByHourMapper.selectByCustomerByMdoelName(customername,modelName);
		return tblRSByHour;
	}

	public List<TblRSByHour> selectByCustomerNameByType(String customername, String modelName, String robotNo) {
		List<TblRSByHour> tblRSByHour = tblRSByHourMapper.selectByCustomerByType(customername,modelName,robotNo);
		return tblRSByHour;
	}

	public double selectRunTimesModelFun(String startDate, String endDate, String modelName) {
		Double runTimes = tblRSByHourMapper.selectRunTimesModelFun(startDate,endDate,modelName);
		if (runTimes==null) {
			return 0.0;
		}else {
			return runTimes;
		}
	}

	public double selectErrorTimesModelFun(String startDate, String endDate, String modelName) {
		Double errorTimes = tblRSByHourMapper.selectErrorTimesModelFun(startDate,endDate,modelName);
		if (errorTimes==null) {
			return 0.0;
		}else {
			return errorTimes;
		}
	}

	public double selectStandbyTimesModelFun(String startDate, String endDate, String modelName) {
		Double standByTimes = tblRSByHourMapper.selectStandByTimesModelFun(startDate,endDate,modelName);
		if (standByTimes==null) {
			return 0.0;
		}else {
			return standByTimes;
		}
	}

	public List<TblRSByHour> selectByDateAndModelName(String modelName, String startDate) {
		// TODO Auto-generated method stub
				List<TblRSByHour> tblRSByHours = tblRSByHourMapper.selectDateAndModelName(modelName,startDate);
				return tblRSByHours;
	}
}
