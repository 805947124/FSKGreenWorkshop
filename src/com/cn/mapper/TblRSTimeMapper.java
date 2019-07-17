package com.cn.mapper;

import com.cn.entity.TblRSTime;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TblRSTimeMapper {
    int insert(TblRSTime record);

    List<TblRSTime> selectAll();

	int selectRobotNo();

	int selectRobotNoRunCount();

	int selectRobotNoCount();

	Integer selectRobotNoType(@Param("area")String area, @Param("building")String building, @Param("floor")String floor, @Param("startTime")String startTime,@Param("overTime")String overTime);

	Integer selectRobotNoCountType(@Param("area")String area, @Param("building")String building, @Param("floor")String floor, @Param("startTime")String startTime,@Param("overTime")String overTime);

	Integer selectRobotNoRunCountType(@Param("area")String area, @Param("building")String building, @Param("floor")String floor, @Param("startTime")String startTime,@Param("overTime")String overTime);
	
	
	
	
	
}