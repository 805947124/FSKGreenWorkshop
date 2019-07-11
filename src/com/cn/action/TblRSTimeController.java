package com.cn.action;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.biz.TblRSTimeBiz;
import com.cn.entity.TblRSNow;
import com.cn.entity.TblRSTime;

@Controller
@RequestMapping("/rSTime")
public class TblRSTimeController {

	@Autowired
	private TblRSTimeBiz tblRSTimeBiz;
	
	@RequestMapping("/selectRSTimeByRobotNo")
	public @ResponseBody Map selectRSTimeByRobotNo(String apikey){
		
		Map map = new HashMap();
		List<TblRSTime> tblRSTimes = null;
		String productivity="";
		if (!apikey.equals("nnjj_0944547748")) {
					
			map.put("flag", "0");
			map.put("msg", "非法请求！");
		}else {
			//tblRSTimes = tblRSTimeBiz.selectByRSTimeFun();
			int robotNo = tblRSTimeBiz.selectByRobotNoFun();
			int robotNoCount = tblRSTimeBiz.RobotNoCountFun();
			int robotNoRunCount = tblRSTimeBiz.RobotNoRunCountFun();
			
			DecimalFormat df = new DecimalFormat("0.000");
			productivity = df.format((double)robotNoRunCount/robotNoCount);
			map = new HashMap();
			
			map.put("flag", "1");
			map.put("robotNo", robotNo);
			map.put("robotNoCount", robotNoCount);
			map.put("robotNoRunCount", robotNoRunCount);
			map.put("productivity", productivity);
			map.put("tblRSTimes", tblRSTimes);
			
			
		}
		
		return map;
	}
	
	@RequestMapping("/selectRSTime")
	public @ResponseBody Map selectRSTime(String apikey){
		
		Map map = new HashMap();
		List<TblRSTime> tblRSTimes = null;
		if (!apikey.equals("nnjj_0944547748")) {
					
			map.put("flag", "0");
			map.put("msg", "非法请求！");
		}else {
			tblRSTimes = tblRSTimeBiz.selectByRSTimeFun();
			
			map = new HashMap();
			
			map.put("flag", "1");
			map.put("tblRSTimes", tblRSTimes);
			
			
		}
		
		return map;
	}
}
