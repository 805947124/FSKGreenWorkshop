package com.cn.action;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.biz.TblRSTimeBiz;
import com.cn.biz.TblRsByHourBiz;
import com.cn.entity.TblRSNow;
import com.cn.entity.TblRSTime;

@Controller
@RequestMapping("/rSTime")
public class TblRSTimeController {

	@Autowired
	private TblRSTimeBiz tblRSTimeBiz;
	
	@Autowired
	private TblRsByHourBiz TblRsByHourBiz;
	
	/**
	 * 查询所有机械手数量及首页效率
	 * @param apikey
	 * @return
	 */
	@RequestMapping("/selectRSTimeByRobotNo")
	public @ResponseBody Map selectRSTimeByRobotNo(String apikey){
		
		Map map = new HashMap();
		List<TblRSTime> tblRSTimes = null;
		double productivity=0.00;
		if (!apikey.equals("nnjj_0944547748")) {
					
			map.put("flag", "0");
			map.put("msg", "非法请求！");
		}else {
			//tblRSTimes = tblRSTimeBiz.selectByRSTimeFun();
			int robotNo = tblRSTimeBiz.selectByRobotNoFun();
			
			Double robotNoRunCount = TblRsByHourBiz.RobotNoRunTimeCountFun();
			Double robotNoStandbyTimeCount = TblRsByHourBiz.RobotNoStandbyTimeCountFun();
			Double robotNoErroTimeCount = TblRsByHourBiz.RobotNoErroTimeCountFun();
			
			if (robotNoRunCount!=null||robotNoStandbyTimeCount!=null||robotNoErroTimeCount!=null||(robotNoRunCount+robotNoStandbyTimeCount+robotNoErroTimeCount)!=0) {
				productivity = robotNoRunCount/(robotNoRunCount+robotNoStandbyTimeCount+robotNoErroTimeCount);
			}
			map = new HashMap();
			
			map.put("flag", "1");
			map.put("robotNo", robotNo);
			map.put("robotNoRunCount", robotNoRunCount);
			map.put("robotNoStandbyTimeCount", robotNoStandbyTimeCount);
			map.put("robotNoErroTimeCount", robotNoErroTimeCount);
			map.put("productivity", productivity);
			
			
		}
		
		return map;
	}
	
	
	/**
	 * 首页条件查询所有机械手数量及首页效率
	 * @param apikey
	 * @param factoryArea
	 * @param area
	 * @param building
	 * @param floor
	 * @param startTime
	 * @param overTime
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/selectRSTimeByTypeRobotNo")
	public @ResponseBody Map selectRSTimeByTypeRobotNo(String apikey,String factoryArea, @Param("area")String area, @Param("buildingFloor")String buildingFloor, @Param("startTime")String startTime,
			@Param("overTime")String overTime) throws ParseException{
		
		System.out.println("开始时间"+startTime+"结束时间"+overTime);
		
		String[] BF = new String[20];
		BF = buildingFloor.split("-");
		String building = BF[0];
		String floor = BF[1];

		Map map = new HashMap();
		double productivity=0.00;
		if (!apikey.equals("nnjj_0944547748")) {
					
			map.put("flag", "0");
			map.put("msg", "非法请求！");
		}else {
			
			

			
			
			
			
			Integer robotNo = tblRSTimeBiz.selectByRobotNoFun();
			
			Integer robotNoRunCount = tblRSTimeBiz.RobotNoRunCountTypeFun(area,building,floor,startTime,overTime);
			Integer robotNoStandbyTimeCount = tblRSTimeBiz.RobotNoStandbyTimeCountTypeFun(area,building,floor,startTime,overTime);
			Integer robotNoErroTimeCount = tblRSTimeBiz.RobotNoErroTimeCountTypeFun(area,building,floor,startTime,overTime);
			
			if (robotNoRunCount!=null || robotNoStandbyTimeCount!=null || robotNoErroTimeCount!=null) {
				productivity = (double)robotNoRunCount/(robotNoRunCount+robotNoStandbyTimeCount+robotNoErroTimeCount);

			}
			
			
			map = new HashMap();
			
			map.put("flag", "1");
			map.put("robotNo", robotNo);
			map.put("robotNoRunCount", robotNoRunCount);
			map.put("robotNoStandbyTimeCount", robotNoStandbyTimeCount);
			map.put("robotNoErroTimeCount", robotNoErroTimeCount);
			map.put("productivity", productivity);
		}
		return map;
	}
	
	/**
	 * 查询RSTime表所有数据
	 * @param apikey
	 * @return
	 */
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
