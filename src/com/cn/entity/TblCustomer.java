package com.cn.entity;

import java.util.List;

import javax.management.loading.PrivateClassLoader;

public class TblCustomer {
    private Integer id;

    private String customername;
    
    private List<TblRSNow> tblRSNows;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

	public List<TblRSNow> getTblRSNows() {
		return tblRSNows;
	}

	public void setTblRSNows(List<TblRSNow> tblRSNows) {
		this.tblRSNows = tblRSNows;
	}
    
    
}