package com.cn.mapper;

import com.cn.entity.TblCustomer;
import java.util.List;

public interface TblCustomerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TblCustomer record);

    TblCustomer selectByPrimaryKey(Integer id);

    List<TblCustomer> selectAll();

    int updateByPrimaryKey(TblCustomer record);
}