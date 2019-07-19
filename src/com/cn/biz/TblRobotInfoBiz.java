package com.cn.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.entity.TblRobotInfo;
import com.cn.mapper.TblRobotInfoMapper;

@Service
public class TblRobotInfoBiz {
	
	@Autowired
	private TblRobotInfoMapper tblRobotInfoMapper;

	public List<TblRobotInfo> selectByName(String customername) {
		List<TblRobotInfo> tblRobotInfo = tblRobotInfoMapper.selectByName(customername);
		return tblRobotInfo;
	}

}
