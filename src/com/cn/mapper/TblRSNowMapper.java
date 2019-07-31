package com.cn.mapper;

import com.cn.entity.TblRSByHour;
import com.cn.entity.TblRSNow;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TblRSNowMapper {
    int insert(TblRSNow record);

    List<TblRSNow> selectAll();

	List<TblRSNow> selectByCustomer(@Param("customername")String customername);

	List<TblRSByHour> selectByCustomerByType(@Param("customername")String customername, @Param("modelName")String modelName, @Param("robotNo")String robotNo);

	List<TblRSByHour> selectByCustomerByMdoelName(@Param("customername")String customername, @Param("modelName")String modelName);
	
}