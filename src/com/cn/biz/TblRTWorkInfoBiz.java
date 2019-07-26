package com.cn.biz;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public Integer selectPassNumbyHour(String robotNo, String startDate, String endDate) {
		Integer PassNum = tblRTWorkInfoMapper.selectPassNumbyHour(robotNo,startDate,endDate);
		return PassNum;
	}

	public Integer selectFailNumbyHour(String robotNo, String startDate, String endDate) {
		Integer FailNum = tblRTWorkInfoMapper.selectFailNumbyHour(robotNo,startDate,endDate);
		return FailNum;
	}

	public Integer selectPut_NGbyHour(String robotNo, String startDate, String endDate) {
		Integer Put_NG = tblRTWorkInfoMapper.selectPut_NGbyHour(robotNo,startDate,endDate);
		return Put_NG;
	}
}
