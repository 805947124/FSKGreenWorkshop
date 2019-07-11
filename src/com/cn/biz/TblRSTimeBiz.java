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
	
	
}
