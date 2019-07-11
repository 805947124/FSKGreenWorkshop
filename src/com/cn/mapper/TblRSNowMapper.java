package com.cn.mapper;

import com.cn.entity.TblRSNow;
import java.util.List;

public interface TblRSNowMapper {
    int insert(TblRSNow record);

    List<TblRSNow> selectAll();
}