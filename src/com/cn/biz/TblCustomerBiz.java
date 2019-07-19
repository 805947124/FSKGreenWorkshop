package com.cn.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.entity.TblCustomer;
import com.cn.entity.TblRSTime;
import com.cn.mapper.TblCustomerMapper;

@Service
public class TblCustomerBiz {

	@Autowired
	private TblCustomerMapper tblCustomerMapper;

	public List<TblCustomer> selectAllFun() {
		List<TblCustomer> tblCustomers = tblCustomerMapper.selectAll();
		return tblCustomers;
	}
	
	
}
