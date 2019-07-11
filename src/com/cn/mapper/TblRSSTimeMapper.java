package com.cn.mapper;

import com.cn.entity.TblRSSTime;
import java.util.List;

public interface TblRSSTimeMapper {
    int insert(TblRSSTime record);

    List<TblRSSTime> selectAll();
}