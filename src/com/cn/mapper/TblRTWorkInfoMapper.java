package com.cn.mapper;

import com.cn.entity.TblProduceByHour;

import com.cn.entity.RepairNum;
import com.cn.entity.TblRTWorkInfo;
import com.cn.entity.TblTesterStatus;
import com.cn.entity.TblWorkInfoSumData;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TblRTWorkInfoMapper {
    int insert(TblRTWorkInfo record);

    List<TblRTWorkInfo> selectAll();

	Integer selectPassNum(@Param("robotno")String robotno, @Param("starDate")String starDate, @Param("endDate")String endDate);

	Integer selectPutNg(@Param("robotno")String robotno, @Param("starDate")String starDate, @Param("endDate")String endDate);

	Integer selectFailNum(@Param("robotno")String robotno, @Param("starDate")String starDate, @Param("endDate")String endDate);

	Date selectMaxDate();

	List<TblProduceByHour> selectPassNumbyHour(@Param("robotno")String robotno, @Param("startDate")String starDate, @Param("endDate")String endDate);

	Integer selectFailNumbyHour(@Param("robotno")String robotno, @Param("startDate")String starDate, @Param("endDate")String endDate);

	Integer selectPut_NGbyHour(@Param("robotno")String robotno, @Param("startDate")String starDate, @Param("endDate")String endDate);

	Date selectNewDayTimeByDay(@Param("robotno")String robotNo);

	List<TblTesterStatus> selectTesterStatus(@Param("strNewDayTime")String strNewDayTime, @Param("robotno")String robotNo);

	List<TblWorkInfoSumData> selectWorkInfoSum(@Param("startTime")String startTime, @Param("endTime")String endTime, @Param("robotNo")String robotNo);

	List<RepairNum> selectTesterRepairNum(@Param("startTime")String startTime, @Param("endTime")String endTime, @Param("robotNo")String robotNo);

	Date selectNewDayTimeByHour(@Param("robotNo")String robotNo, @Param("startTime")String startTime, @Param("endTime")String endTime);
}