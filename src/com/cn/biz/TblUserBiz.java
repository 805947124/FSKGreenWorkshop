package com.cn.biz;

import org.apache.tools.ant.taskdefs.condition.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.entity.TblUser;
import com.cn.mapper.TblUserMapper;

@Service
public class TblUserBiz {
	
	@Autowired
	private TblUserMapper tblUserMapper;

	public TblUser selectByUserNameFun(String jobnumber, String pwd) {
		// TODO Auto-generated method stub
		TblUser tblUser = tblUserMapper.selectByName(jobnumber);
		if (tblUser!=null && tblUser.getPassword().equals(pwd)) {
			return tblUser;
		}else {
			return null;
		}
	}
}
