package com.cn.mapper;

import com.cn.entity.TblRTWorkInfo;
import java.util.List;

public interface TblRTWorkInfoMapper {
    int insert(TblRTWorkInfo record);

    List<TblRTWorkInfo> selectAll();
}