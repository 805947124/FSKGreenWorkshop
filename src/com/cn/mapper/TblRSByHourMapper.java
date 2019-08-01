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

	

	Double selectByRunTimeCount();

	Double selectByStandbyTimeCount();

	Double selectByErroTimeCount();

	Double selectByRunTimeTypeCount(@Param("robotno")String robotno, @Param("startDate")String startDate, @Param("finishDate")String finishDate);

	Double selectByStandbyTimeTypeCount(@Param("robotno")String robotno, @Param("startDate")String startDate, @Param("finishDate")String finishDate);

	Double selectByErroTimeTypeCount(@Param("robotno")String robotno, @Param("startDate")String startDate, @Param("finishDate")String finishDate);
	

	Double selectRunTimes(@Param("robotNo")String robotNo);

	Double selectStandbyTimes(@Param("robotNo")String robotNo);

	Double selectErrorTimes(@Param("robotNo")String robotNo);
	
	

	Double selectRunTimesFun(@Param("startDate")String startDate,@Param("endDate")String endDate);

	Double selectErrorTimesFun(@Param("startDate")String startDate,@Param("endDate")String endDate);

	Double selectStandbyTimesFun(@Param("startDate")String startDate,@Param("endDate")String endDate);

	List<TblRSByHour> selectRobotNoRunTimeTrend(@Param("robotNo")String robotNo);

	Double selectRunTimesTypeFun(@Param("startDate")String startDate,@Param("endDate")String endDate, @Param("robotno")String robotno);

	Double selectErrorTimesTypeFun(@Param("startDate")String startDate,@Param("endDate")String endDate, @Param("robotno")String robotno);

	Double selectStandbyTimesTypeFun(@Param("startDate")String startDate,@Param("endDate")String endDate, @Param("robotno")String robotno);

	List<TblRSByHour> selectDateAndRobotNo(@Param("robotno")String robotno, @Param("startDate")String startDate);

	List<TblRSByHour> selectByCustomerByMdoelName(@Param("customername")String customername, @Param("modelName")String modelName);

	List<TblRSByHour> selectByCustomerByType(@Param("customername")String customername, @Param("modelName")String modelName, @Param("robotNo")String robotNo);

	Double selectRunTimesModelFun(@Param("startDate")String startDate,@Param("endDate")String endDate, @Param("modelName")String modelName);

	Double selectErrorTimesModelFun(@Param("startDate")String startDate,@Param("endDate")String endDate, @Param("modelName")String modelName);

	Double selectStandByTimesModelFun(@Param("startDate")String startDate,@Param("endDate")String endDate, @Param("modelName")String modelName);

	List<TblRSByHour> selectDateAndModelName(@Param("modelName")String modelName, @Param("startDate")String startDate);

}