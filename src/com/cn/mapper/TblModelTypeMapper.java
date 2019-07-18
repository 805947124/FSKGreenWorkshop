package com.cn.mapper;

import com.cn.entity.TblModelType;
import java.util.List;

public interface TblModelTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TblModelType record);

    TblModelType selectByPrimaryKey(Integer id);

    List<TblModelType> selectAll();

    int updateByPrimaryKey(TblModelType record);
}