package com.cn.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.entity.TblCustomer;
import com.cn.entity.TblModelType;
import com.cn.mapper.TblModelTypeMapper;

@Service
public class TblModelTypeBiz {

	@Autowired
	private TblModelTypeMapper tblModelTypeMapper;

	public List<TblModelType> selectAllFun() {
		List<TblModelType> tblModelTypes = tblModelTypeMapper.selectAll();
		return tblModelTypes;
	}
	
}
