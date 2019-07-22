package com.cn.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.entity.TblRSSTime;
import com.cn.mapper.TblRSSTimeMapper;

@Service
public class TblRSSTimeBiz {
	@Autowired
	private TblRSSTimeMapper tblRSSTimeMapper;

	public List<TblRSSTime> selectByRSSTimeFun() {
		// TODO Auto-generated method stub
		List<TblRSSTime> tblRSSTimes = tblRSSTimeMapper.selectAll();
		return tblRSSTimes;
	}
}
