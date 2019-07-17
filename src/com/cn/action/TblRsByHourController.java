package com.cn.action;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter.Magenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.biz.TblRsByHourBiz;
import com.cn.entity.TblRSByHour;
import com.cn.entity.TblRSNow;

@Controller
@RequestMapping("/rsByHour")
public class TblRsByHourController {

	@Autowired
	private TblRsByHourBiz tblRsByHourBiz;
	
	
	
	/**
	 * Robot״̬���Ĭ�ϲ�ѯ
	 * @param apikey
	 * @return map
	 * @throws ParseException
	 */
	@RequestMapping("/selectByRsByHourNo")
	public @ResponseBody Map selectByRsByHourNo(String apikey){
		
		Map map = new HashMap();
		Map shujuMap = new HashMap();
		Integer SAMStatus = 0;
		String msg = "";
		List<TblRSByHour> tblRSByHours = null;
		if (!apikey.equals("nnjj_0944547748")) {
			msg = "�Ƿ�����";
			map.put("flag", "0");
			map.put("msg", msg);
		}else {
			
			tblRSByHours = tblRsByHourBiz.selectByStatusFun();
			Integer robotNo = tblRsByHourBiz.selectByRobotNoFun();
			Integer robotNoRunCount = tblRsByHourBiz.RobotNoRunCountFun();
			Integer robotNoStanbyCount = tblRsByHourBiz.RobotNoStanbyCountFun();
			Integer robotNoErroCount = tblRsByHourBiz.RobotNoErroCountFun();
			Integer robotNoShutdownCount = tblRsByHourBiz.RobotNoShutdownCountFun();
			
			System.out.println("�ֱ�������"+robotNo+"����״̬����"+robotNoRunCount+"����״̬����"
			+robotNoStanbyCount+"����״̬����"+robotNoErroCount);
			
			msg = "�ֱ�����(robotNo)��"+robotNo+"����״̬��(robotNoRunCount)��"+robotNoRunCount+"����״̬��(robotNoStanbyCount)��"
					+robotNoStanbyCount+"����״̬��(robotNoErroCount)��"+robotNoErroCount+"ͣ������(robotNoShutdownCount)��"+robotNoShutdownCount;
			
			map = new HashMap();
			
			map.put("flag", "1");
			
			
			shujuMap.put("robotNo", robotNo);
			shujuMap.put("robotNoRunCount", robotNoRunCount);
			shujuMap.put("robotNoStanbyCount", robotNoStanbyCount);
			shujuMap.put("robotNoErroCount", robotNoErroCount);
			shujuMap.put("robotNoShutdownCount", robotNoShutdownCount);
			map.put("tblRSByHours", tblRSByHours);
			map.put("shujuMap", shujuMap);
			map.put("msg", msg);
		}
		return map;
	}
	
	
	@RequestMapping("/selectRSByHour")
	public @ResponseBody Map selectRSByHour(String apikey){
		
		Map map = new HashMap();
		List<TblRSByHour> tblRSByHours = null;
		if (!apikey.equals("nnjj_0944547748")) {

			map.put("flag", "0");
			map.put("msg", "�Ƿ�����");
		}else {
			tblRSByHours = tblRsByHourBiz.selectByRSByHoueFun();
			
			map = new HashMap();
			
			map.put("flag", "1");
			map.put("tblRSByHours", tblRSByHours);
			
		}
		return map;
	}
}
