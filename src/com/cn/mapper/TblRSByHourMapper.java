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

	List<TblRSByHour> selectByCunstomerName(@Param("customername")String customername);

	

	Integer selectByRunTimeCount();

	Integer selectByStandbyTimeCount();

	Integer selectByErroTimeCount();

	Integer selectByRunTimeTypeCount(String robotno);

	Integer selectByStandbyTimeTypeCount(String robotno);

	Integer selectByErroTimeTypeCount(String robotno);
	

	Double selectRunTimes(@Param("robotNo")String robotNo);

	Double selectStandbyTimes(@Param("robotNo")String robotNo);

	Double selectErrorTimes(@Param("robotNo")String robotNo);
	
	

	Double selectRunTimesFun(@Param("startDate")String startDate,@Param("endDate")String endDate);

	Double selectErrorTimesFun(@Param("startDate")String startDate,@Param("endDate")String endDate);

	Double selectStandbyTimesFun(@Param("startDate")String startDate,@Param("endDate")String endDate);

	List<TblRSByHour> selectRobotNoRunTimeTrend(@Param("robotNo")String robotNo);

}