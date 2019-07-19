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
import com.cn.entity.TblRSNow;
import com.cn.entity.TblRSTime;

@Controller
@RequestMapping("/rSTime")
public class TblRSTimeController {

	@Autowired
	private TblRSTimeBiz tblRSTimeBiz;
	
	/**
	 * 查询所有机械手数量及首页效率
	 * @param apikey
	 * @return
	 */
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
	public @ResponseBody Map selectRSTimeByTypeRobotNo(String apikey,String factoryArea, @Param("area")String area, @Param("building")String building, @Param("floor")String floor, @Param("startTime")String startTime,
			@Param("overTime")String overTime) throws ParseException{
		
		System.out.println("开始时间"+startTime+"结束时间"+overTime);

		Map map = new HashMap();
		String productivity="";
		if (!apikey.equals("nnjj_0944547748")) {
					
			map.put("flag", "0");
			map.put("msg", "非法请求！");
		}else {
			
			/*try {
				startTime = new String(startTime.getBytes("ISO-8859-1"), "utf-8");
				overTime = new String(overTime.getBytes("ISO-8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			//tblRSTimes = tblRSTimeBiz.selectByRSTimeFun();
			Integer robotNo = tblRSTimeBiz.selectByRobotNoFun();
			Integer robotNoCount = tblRSTimeBiz.RobotNoCountTypeFun(area,building,floor,startTime,overTime);
			Integer robotNoRunCount = tblRSTimeBiz.RobotNoRunCountTypeFun(area,building,floor,startTime,overTime);
			
			System.out.println("总数："+robotNo+"所有记录数："+robotNoCount+"运行记录数："+robotNoRunCount);
			
			DecimalFormat df = new DecimalFormat("0.000");
			productivity = df.format((double)robotNoRunCount/robotNoCount);
			map = new HashMap();
			
			map.put("flag", "1");
			map.put("robotNo", robotNo);
			map.put("robotNoCount", robotNoCount);
			map.put("robotNoRunCount", robotNoRunCount);
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
