package com.cn.mapper;

import com.cn.entity.TblUser;
import java.util.List;

public interface TblUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TblUser record);

    TblUser selectByPrimaryKey(Integer id);

    List<TblUser> selectAll();

    int updateByPrimaryKey(TblUser record);
}