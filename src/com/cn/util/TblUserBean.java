package com.cn.util;

import java.util.List;

public class TblUserBean<String> {

	private Integer id;

    private String jobnumber;

    private String password;

    private String name;

    private String grade;
    
    private List<String> customerList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJobnumber() {
		return jobnumber;
	}

	public void setJobnumber(String jobnumber) {
		this.jobnumber = jobnumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public List<String> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<String> customerList) {
		this.customerList = customerList;
	}
    
    
    
    
}
