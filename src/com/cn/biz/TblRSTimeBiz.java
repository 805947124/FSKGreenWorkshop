package com.cn.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.entity.TblRSTime;
import com.cn.mapper.TblRSTimeMapper;

@Service
public class TblRSTimeBiz {

	@Autowired
	private TblRSTimeMapper tblRSTimeMapper;

	public List<TblRSTime> selectByRSTimeFun() {
		// TODO Auto-generated method stub
		List<TblRSTime> tblRSTimes = tblRSTimeMapper.selectAll();
		return tblRSTimes;
	}

	public int selectByRobotNoFun() {
		// TODO Auto-generated method stub
		int num = tblRSTimeMapper.selectRobotNo();
		return num;
	}

	public int RobotNoCountFun() {
		int num = tblRSTimeMapper.selectRobotNoCount();
		return num;
	}
	public int RobotNoRunCountFun() {
		int num = tblRSTimeMapper.selectRobotNoRunCount();
		return num;
	}
	
	public Integer selectByRobotNoTypeFun(String area, String building, String floor,String startTime, String overTime) {
		Integer num = tblRSTimeMapper.selectRobotNoType(area,building,floor,startTime,overTime);
		return num;
	}

	public Integer RobotNoCountTypeFun(String area, String building, String floor,String startTime, String overTime) {
		Integer num = tblRSTimeMapper.selectRobotNoCountType(area,building,floor,startTime,overTime);
		return num;
	}

	public Integer RobotNoRunCountTypeFun(String area, String building, String floor,String startTime, String overTime) {
		Integer num = tblRSTimeMapper.selectRobotNoRunCountType(area,building,floor,startTime,overTime);
		return num;
	}

	public int selectRobotRunCount(String robotno) {
		// TODO Auto-generated method stub
		Integer numInteger = tblRSTimeMapper.selectRobotRunCount(robotno);
		return numInteger;
	}

	public int selectRobotAllCount(String robotno) {
		// TODO Auto-generated method stub
		Integer numInteger = tblRSTimeMapper.selectRobotAllCount(robotno);
		return numInteger;
	}

	public Integer RobotNoStandbyTimeCountTypeFun(String area, String building, String floor, String startTime,
			String overTime) {
		Integer num = tblRSTimeMapper.selectRobotNoStandbyTimeCountType(area,building,floor,startTime,overTime);
		return num;
	}

	public Integer RobotNoErroTimeCountTypeFun(String area, String building, String floor, String startTime,
			String overTime) {
		Integer num = tblRSTimeMapper.selectRobotNoErroTimeCountType(area,building,floor,startTime,overTime);
		return num;
	}
}
