package com.cn.mapper;

import com.cn.entity.TblRSTime;
import java.util.List;

public interface TblRSTimeMapper {
    int insert(TblRSTime record);

    List<TblRSTime> selectAll();

	int selectRobotNo();

	int selectRobotNoRunCount();

	int selectRobotNoCount();
}