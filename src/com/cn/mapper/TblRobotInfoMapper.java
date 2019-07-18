package com.cn.mapper;

import com.cn.entity.TblRobotInfo;
import java.util.List;

public interface TblRobotInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TblRobotInfo record);

    TblRobotInfo selectByPrimaryKey(Integer id);

    List<TblRobotInfo> selectAll();

    int updateByPrimaryKey(TblRobotInfo record);
}