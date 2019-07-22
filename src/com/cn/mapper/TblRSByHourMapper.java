package com.cn.mapper;

import com.cn.entity.TblRSByHour;
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

	List<TblRSByHour> selectAllRobotNoByCustomerName(@Param("customername")String customername);
}