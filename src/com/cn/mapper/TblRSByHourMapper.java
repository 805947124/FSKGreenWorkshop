package com.cn.mapper;

import com.cn.entity.TblRSByHour;
import java.util.List;

public interface TblRSByHourMapper {
    int insert(TblRSByHour record);

    List<TblRSByHour> selectAll();
}