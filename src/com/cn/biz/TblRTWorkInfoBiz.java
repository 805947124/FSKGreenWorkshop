package com.cn.biz;

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
}
