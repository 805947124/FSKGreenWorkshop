package com.cn.mapper;

import com.cn.entity.TblModelSTD;
import java.util.List;

public interface TblModelSTDMapper {
    int insert(TblModelSTD record);

    List<TblModelSTD> selectAll();
}