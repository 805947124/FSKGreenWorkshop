package com.cn.mapper;

import com.cn.entity.TblRCWorkInfo;
import java.util.List;

public interface TblRCWorkInfoMapper {
    int insert(TblRCWorkInfo record);

    List<TblRCWorkInfo> selectAll();
}