package com.cn.action;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter.Magenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.biz.TblRobotInfoBiz;
import com.cn.biz.TblRsByHourBiz;
import com.cn.biz.TblCustomerBiz;
import com.cn.biz.TblRSNowBiz;
import com.cn.biz.TblRSTimeBiz;
import com.cn.entity.TblCustomer;
import com.cn.entity.TblRSByHour;
import com.cn.entity.TblRSNow;
import com.cn.entity.TblRobotInfo;

@Controller
@RequestMapping("/rsByHour")
public class TblRsByHourController {

	@Autowired
	private TblRsByHourBiz tblRsByHourBiz;
	@Autowired 
	private TblRobotInfoBiz tblRobotInfoBiz;
	@Autowired
	private TblCustomerBiz tblCustomerBiz;
	@Autowired
	private TblRSNowBiz tblRSNowBiz;
	@Autowired
	private TblRSTimeBiz tblRSTimeBiz;
	
	/**
	 * Robot查询状态数
	 * @param apikey
	 * @return map
	 * @throws ParseException
	 */
	@RequestMapping("/selectByStatusNo")
	public @ResponseBody Map selectByStatusNo(String apikey){
		
		Map map = new HashMap();
		Map NumMap = new HashMap();
		Integer SAMStatus = 0;
		String msg = "";
		if (!apikey.equals("nnjj_0944547748")) {
			msg = "非法请求！";
			map.put("flag", "0");
			map.put("msg", msg);
		}else {
			
			Integer robotNo = tblRsByHourBiz.selectByRobotNoFun();
			Integer robotNoRunCount = tblRsByHourBiz.RobotNoRunCountFun();
			Integer robotNoStanbyCount = tblRsByHourBiz.RobotNoStanbyCountFun();
			Integer robotNoErroCount = tblRsByHourBiz.RobotNoErroCountFun();
			Integer robotNoShutdownCount = tblRsByHourBiz.RobotNoShutdownCountFun();
			
			System.out.println("手臂总数："+robotNo+"运行状态数："+robotNoRunCount+"待机状态数："
			+robotNoStanbyCount+"故障状态数："+robotNoErroCount);
			
			msg = "手臂总数(robotNo)："+robotNo+"运行状态数(robotNoRunCount)："+robotNoRunCount+"待机状态数(robotNoStanbyCount)："
					+robotNoStanbyCount+"故障状态数(robotNoErroCount)："+robotNoErroCount+"停机保养(robotNoShutdownCount)："+robotNoShutdownCount;
			
			map = new HashMap();
			
			map.put("flag", "1");
			
			
			NumMap.put("robotNo", robotNo);
			NumMap.put("robotNoRunCount", robotNoRunCount);
			NumMap.put("robotNoStanbyCount", robotNoStanbyCount);
			NumMap.put("robotNoErroCount", robotNoErroCount);
			NumMap.put("robotNoShutdownCount", robotNoShutdownCount);
			map.put("NumMap", NumMap);
			map.put("msg", msg);
		}
		return map;
	}
	
	/**
	 * Robot查询机械手按区域划分列表
	 * @param apikey
	 * @return map
	 * @throws ParseException
	 */
	@RequestMapping("/selectByRsByHourNo")
	public @ResponseBody Map selectByRsByHourNo(String apikey){
		
		Map map = new HashMap();
		Map NumMap = new HashMap();
		Map customerMap = new HashMap();
		Map robotNoMap = new HashMap();
		String msg = "";
		
		
		List<TblRSByHour> tblRSByHours = null;
		List<TblCustomer> tblCustomers = null;
		TblCustomer tblCustomer = null;
		List<TblRSNow> tblRSNows =new ArrayList<TblRSNow>();
		TblRSNow tblRSNow = null;
		DecimalFormat df = new DecimalFormat("0.00");
		String productivity = "";
		
		if (!apikey.equals("nnjj_0944547748")) {
			msg = "非法请求！";
			map.put("flag", "0");
			map.put("msg", msg);
		}else {
			tblCustomers = tblCustomerBiz.selectAllFun();
			int indexCustomer = tblCustomers.size()-1;
			
			for (int i = 1; i <= indexCustomer; i++) {
				tblCustomer = tblCustomers.get(i);
				tblRSNows = tblRSNowBiz.selectByCustomerName(tblCustomer.getCustomername());
				
				tblCustomer.setId(tblCustomers.get(i).getId());
				tblCustomer.setCustomername(tblCustomers.get(i).getCustomername());
				tblCustomer.setTblRSNows(tblRSNows);
				int indexTblRSNow = tblRSNows.size();
				for (int j = 0; j < indexTblRSNow; j++) {
					int runCount = tblRSTimeBiz.selectRobotRunCount(tblRSNows.get(j).getRobotno());
					int allCount = tblRSTimeBiz.selectRobotAllCount(tblRSNows.get(j).getRobotno());
					
					productivity = df.format((double)runCount/allCount);
					
					tblRSNows.get(j).setEfficiency(productivity);
				}
				
				customerMap.put(tblCustomer.getCustomername(),tblCustomer);
				
				
			}

			//tblRSByHours = tblRsByHourBiz.selectByStatusFun();
			
			map.put("flag", "1");
			map.put("tblCustomers", customerMap);
			//map.put("tblRSByHours", tblRSByHours);
			map.put("NumMap", NumMap);
			map.put("msg", msg);
		}
		return map;
	}
	
	
	/**
	 * 级联菜单：查询机种
	 * @param apikey
	 * @return
	 */
	@RequestMapping("/selectModelName")
	public @ResponseBody Map selectModelName(String apikey){
		
		Map map = new HashMap();
		List ModelName = new ArrayList<String>();
		
		if (!apikey.equals("nnjj_0944547748")) {

			map.put("flag", "0");
			map.put("msg", "非法请求！");
		}else {
			ModelName = tblRsByHourBiz.selectModelNameFun();
			
			map = new HashMap();
			
			map.put("flag", "1");
			map.put("ModelName", ModelName);
		}
		return map;
	}
	
	/**
	 * 级联菜单：根据机种查询手臂号
	 * @param apikey
	 * @param modelName
	 * @return
	 */
	@RequestMapping("/selectRobotNo")
	public @ResponseBody Map selectRobotNo(String apikey,String modelName){
		
		Map map = new HashMap();
		List RobotNo = new ArrayList<String>();
		
		if (!apikey.equals("nnjj_0944547748")) {

			map.put("flag", "0");
			map.put("msg", "非法请求！");
		}else {
			RobotNo = tblRsByHourBiz.selectRobotNoFun(modelName);
			
			map = new HashMap();
			
			map.put("flag", "1");
			map.put("RobotNo", RobotNo);
		}
		return map;
	}
	
	@RequestMapping("/selectByTypeByRsByHourNo")
	public @ResponseBody Map selectByTypeByRsByHourNo(String apikey,String modelName,String robotNo){
		
		Map map = new HashMap();
		Map NumMap = new HashMap();
		Map customerMap = new HashMap();
		Map robotNoMap = new HashMap();
		String msg = "";
		
		
		List<TblRSByHour> tblRSByHours = null;
		List<TblCustomer> tblCustomers = null;
		TblCustomer tblCustomer = null;
		List<TblRSNow> tblRSNows =new ArrayList<TblRSNow>();
		TblRSNow tblRSNow = null;
		DecimalFormat df = new DecimalFormat("0.00");
		String productivity = "";
		
		if (!apikey.equals("nnjj_0944547748")) {
			msg = "非法请求！";
			map.put("flag", "0");
			map.put("msg", msg);
		}else {
			tblCustomers = tblCustomerBiz.selectAllFun();
			int indexCustomer = tblCustomers.size()-1;
			
			for (int i = 1; i <= indexCustomer; i++) {
				
				if(robotNo.equals("All")){
					
					tblCustomer = tblCustomers.get(i);
					tblRSNows = tblRSNowBiz.selectByCustomerNameByModelName(tblCustomer.getCustomername(),modelName);
					
					tblCustomer.setId(tblCustomers.get(i).getId());
					tblCustomer.setCustomername(tblCustomers.get(i).getCustomername());
					tblCustomer.setTblRSNows(tblRSNows);
					int indexTblRSNow = tblRSNows.size();
					for (int j = 0; j < indexTblRSNow; j++) {
						int runCount = tblRSTimeBiz.selectRobotRunCount(tblRSNows.get(j).getRobotno());
						int allCount = tblRSTimeBiz.selectRobotAllCount(tblRSNows.get(j).getRobotno());
						
						productivity = df.format((double)runCount/allCount);
						
						tblRSNows.get(j).setEfficiency(productivity);
					}
					
					customerMap.put(tblCustomer.getCustomername(),tblCustomer);
					
				}else{
					
					tblCustomer = tblCustomers.get(i);
					tblRSNows = tblRSNowBiz.selectByCustomerNameByType(tblCustomer.getCustomername(),modelName,robotNo);
					
					tblCustomer.setId(tblCustomers.get(i).getId());
					tblCustomer.setCustomername(tblCustomers.get(i).getCustomername());
					tblCustomer.setTblRSNows(tblRSNows);
					int indexTblRSNow = tblRSNows.size();
					for (int j = 0; j < indexTblRSNow; j++) {
						int runCount = tblRSTimeBiz.selectRobotRunCount(tblRSNows.get(j).getRobotno());
						int allCount = tblRSTimeBiz.selectRobotAllCount(tblRSNows.get(j).getRobotno());
						
						productivity = df.format((double)runCount/allCount);
						
						tblRSNows.get(j).setEfficiency(productivity);
					}
					customerMap.put(tblCustomer.getCustomername(),tblCustomer);
				}
			}

			//tblRSByHours = tblRsByHourBiz.selectByStatusFun();
			
			map.put("flag", "1");
			map.put("tblCustomers", customerMap);
			//map.put("tblRSByHours", tblRSByHours);
			map.put("NumMap", NumMap);
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
			map.put("msg", "非法请求！");
		}else {
			tblRSByHours = tblRsByHourBiz.selectByRSByHoueFun();
			
			map = new HashMap();
			
			map.put("flag", "1");
			map.put("tblRSByHours", tblRSByHours);
			
		}
		return map;
	}
}
