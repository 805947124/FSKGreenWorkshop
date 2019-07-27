package com.cn.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.biz.TblRTWorkInfoBiz;
import com.cn.entity.TblProduceByHour;
import com.cn.entity.TblRobotDataInfo;
import com.cn.entity.TblTesterStatus;
import com.cn.entity.TblWorkInfoSumData;

@Controller
@RequestMapping("/RTWorkInfo")
public class TblRTWorkInfoController {
	
	@Autowired
	private TblRTWorkInfoBiz tblRTWorkInfoBiz;
	
	/**
	 * 每小时产出及生产效率接口
	 * @param apikey
	 * @param RobotNo
	 * @return
	 */
	@RequestMapping("/selectRobotByHourProduce")
	public @ResponseBody Map selectRobotByHourProduce(String apikey,String RobotNo){
		
		Map map = new HashMap();
		String msg = "";
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date  = new Date();
		
		date = tblRTWorkInfoBiz.selectMaxDate();
		
		Calendar calendar = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		
		calendar.setTime(date);
		calendar2.setTime(date);
		
		List<String> startDateList =new ArrayList<String>();
		List<String> endDateList = new ArrayList<String>();
		
		for(int i = 0;i < 24;i++){
			calendar.add(calendar.DATE, 0);
			calendar.set(Calendar.HOUR_OF_DAY,i);
			calendar.set(Calendar.MINUTE,0);
			calendar.set(Calendar.SECOND,0);
			date = calendar.getTime();
			startDateList.add(f.format(date));
		}
		
		for(int i = 0;i < 24;i++){
			calendar2.add(calendar2.DATE, 0);
			calendar2.set(Calendar.HOUR_OF_DAY,i);
			calendar2.set(Calendar.MINUTE,59);
			calendar2.set(Calendar.SECOND,59);
			date = calendar2.getTime();
			endDateList.add(f.format(date));
		}
		
		Integer PassNum = 0;
		
		TblProduceByHour tblProduceByHour = null;
		List<TblProduceByHour> tblProduceByHours = new ArrayList<TblProduceByHour>();
		
		if (!apikey.equals("nnjj_0944547748")) {
			msg = "非法请求！";
			map.put("flag", "0");
			map.put("msg", msg);
		}else {
			
			for(int i = 0;i < startDateList.size();i++){
				PassNum = tblRTWorkInfoBiz.selectPassNumbyHour(RobotNo,startDateList.get(i),endDateList.get(i));
				
				tblProduceByHour = new TblProduceByHour(RobotNo, i, PassNum);
				tblProduceByHours.add(tblProduceByHour);
			}
			map.put("flag", "1");
			map.put("tblProduceByHours", tblProduceByHours);
			map.put("msg", msg);
		}
		return map;
	}
	
	/**
	 * 默认最新一天的手臂/机台数据明细接口
	 * @param apikey
	 * @param RobotNo
	 * @return
	 */
	@RequestMapping("/selectRobotDataInfoByDay")
	public @ResponseBody Map selectRobotDataInfoByDay(String apikey,String RobotNo){
		
		Map map = new HashMap();
		String msg = "";
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date date  = new Date();
		date = tblRTWorkInfoBiz.selectMaxDate();
		
		Calendar calendar = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		calendar.setTime(date);
		calendar2.setTime(date);
		
		String startTime = null;
		String endTime = null;
		
		calendar.add(calendar.DATE, 0);
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		date = calendar.getTime();
		startTime = f.format(date);
		System.out.println("---------------------------------startTime:"+startTime);
		
		calendar2.add(calendar2.DATE, 0);
		calendar2.set(Calendar.HOUR_OF_DAY,23);
		calendar2.set(Calendar.MINUTE,59);
		calendar2.set(Calendar.SECOND,59);
		date = calendar2.getTime();
		endTime = f.format(date);
		System.out.println("---------------------------------endTime:"+endTime);
		
		Integer Tester_Status;
		double RepairTime;
		Integer RepairNum;
		Integer PassNum;
		Integer Put_NG;
		Integer FailNum;
		Integer SFCErrNum;
		Integer FirstPS_NG;
		Integer Put_OK = 0;
		Integer INPUT = 0;
		Integer OUTPUT = 0;
		double PS_NG = 0.00;
		double PUT_NG = 0.00;
		
		TblTesterStatus tblTesterStatus = null;
		TblRobotDataInfo tblRobotDataInfo = null;
		TblWorkInfoSumData tblWorkInfoSumData = null;
		List<TblRobotDataInfo> tblRobotDataInfos = new ArrayList<TblRobotDataInfo>();
		
		
		if (!apikey.equals("nnjj_0944547748")) {
			msg = "非法请求！";
			map.put("flag", "0");
			map.put("msg", msg);
		}else {
			
			for(int i = 1;i<=12;i++){
				Date newDayTime = tblRTWorkInfoBiz.selectNewDayTimeByDay(RobotNo,i);
				String strNewDayTime = f.format(newDayTime);
				
				tblTesterStatus = tblRTWorkInfoBiz.selectTesterStatus(strNewDayTime,RobotNo,i);
				
				if(tblTesterStatus.getStatus().equals("OffLine") && tblTesterStatus.getPassNum() == 0){
					Tester_Status = 0;
				}else{
					Tester_Status = 1;
				}
				
				tblWorkInfoSumData = tblRTWorkInfoBiz.selectWorkInfoSum(startTime,endTime,RobotNo,i);
				RepairTime = tblWorkInfoSumData.getRepairTime();
				PassNum = tblWorkInfoSumData.getPassNum();
				Put_NG = tblWorkInfoSumData.getPut_NG();
				Put_OK = tblWorkInfoSumData.getPut_OK();
				FailNum = tblWorkInfoSumData.getFailNum();
				SFCErrNum = tblWorkInfoSumData.getSFCErrNum();
				FirstPS_NG = tblWorkInfoSumData.getFirstPS_NG();
				OUTPUT = tblWorkInfoSumData.getPassNum();
				INPUT = PassNum+Put_NG+FailNum;
				
				if(Put_NG+Put_OK != 0){
					PS_NG = (double)FirstPS_NG/((double)Put_NG+(double)Put_OK);
					PUT_NG = (double)Put_NG/((double)Put_NG+(double)Put_OK);
				}
				
				RepairNum = tblRTWorkInfoBiz.selectTesterRepairNum(startTime,endTime,RobotNo,i);
				
				tblRobotDataInfo = new TblRobotDataInfo(i, tblTesterStatus.getTester_IP(), Tester_Status,RepairTime , RepairNum, INPUT, OUTPUT, FailNum, SFCErrNum, PS_NG, PUT_NG);
				tblRobotDataInfos.add(tblRobotDataInfo);
			}
			
			map.put("flag", "1");
			map.put("tblRobotDataInfos", tblRobotDataInfos);
			map.put("msg", msg);
		}
		return map;
	}
	
}
