package com.cn.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.entity.TblRSNow;
import com.cn.mapper.TblRSNowMapper;

@Service
public class TblRSNowBiz {
	
	@Autowired
	private TblRSNowMapper tblRSNowMapper;

	public List<TblRSNow> selectByRSNoweFun() {
		// TODO Auto-generated method stub
		List<TblRSNow> tblRSNows = tblRSNowMapper.selectAll();
		return tblRSNows;
	}

	public List<TblRSNow> selectByCustomerName(String customername) {
		// TODO Auto-generated method stub
		List<TblRSNow> tblRSNows = tblRSNowMapper.selectByCustomer(customername);
		return tblRSNows;
		
		
	}

	
	
	
}
