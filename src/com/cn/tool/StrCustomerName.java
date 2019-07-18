package com.cn.tool;

import java.util.ArrayList;
import java.util.List;

import com.cn.entity.TblUser;
import com.cn.util.TblUserBean;

public class StrCustomerName {

	public TblUserBean<String> strCustomerNameList(TblUser tblUser){
		List<String> strCustomerList = new ArrayList<String>();
		TblUserBean<String> tblUserBean = new TblUserBean<String>();
		String[] strCustomer = tblUser.getCustomername().split(";");
		for (int i = 0; i < strCustomer.length; i++) {
			strCustomerList.add(strCustomer[i]);
		}
		tblUserBean.setId(tblUser.getId());
		tblUserBean.setJobnumber(tblUser.getJobnumber());
		tblUserBean.setPassword(tblUser.getPassword());
		tblUserBean.setName(tblUser.getName());
		tblUserBean.setGrade(tblUser.getGrade());
		tblUserBean.setCustomerList(strCustomerList);
		return tblUserBean;
		
	}
}
