package com.cn.mapper;

import com.cn.entity.TblRSNow;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TblRSNowMapper {
    int insert(TblRSNow record);

    List<TblRSNow> selectAll();

	List<TblRSNow> selectByCustomer(@Param("customername")String customername);

}