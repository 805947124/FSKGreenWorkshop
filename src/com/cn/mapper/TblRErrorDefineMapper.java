package com.cn.mapper;

import com.cn.entity.TblRErrorDefine;
import java.util.List;

public interface TblRErrorDefineMapper {
    int insert(TblRErrorDefine record);

    List<TblRErrorDefine> selectAll();
}