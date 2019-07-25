package com.cn.mapper;

import com.cn.entity.TblRTWorkInfo;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TblRTWorkInfoMapper {
    int insert(TblRTWorkInfo record);

    List<TblRTWorkInfo> selectAll();

	Integer selectPassNum(@Param("robotno")String robotno, @Param("starDate")String starDate, @Param("endDate")String endDate);

	Integer selectPutNg(@Param("robotno")String robotno, @Param("starDate")String starDate, @Param("endDate")String endDate);

	Integer selectFailNum(@Param("robotno")String robotno, @Param("starDate")String starDate, @Param("endDate")String endDate);
}