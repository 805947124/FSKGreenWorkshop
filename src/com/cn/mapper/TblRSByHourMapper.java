package com.cn.mapper;

import com.cn.entity.TblRSByHour;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TblRSByHourMapper {
    int insert(TblRSByHour record);

    List<TblRSByHour> selectAll();

	List<TblRSByHour> selectByStatus();

	int selectByRobotNo();

	int selectByRunRobotNo();

	int selectByStanbyRobotNo();

	int selectByErroRobotNo();

	int selectByShutdownRobotNo();

	List<String> selectModelNameFun();

	List<String> selectRobotNoFun(String modelName);

	Date selectByHourMaxDate();

	List<TblRSByHour> selectAllRobotNoByCustomerName(@Param("customername")String customername);

	List<TblRSByHour> selectAllRunRobotNoByCustomerName(@Param("customername")String customername);

	List<TblRSByHour> selectAllStanbyRobotNoByCustomerName(@Param("customername")String customername);

	List<TblRSByHour> selectAllErrorRobotNoByCustomerName(@Param("customername")String customername);

	List<TblRSByHour> selectAllShutdownRobotNoByCustomerName(@Param("customername")String customername);

}