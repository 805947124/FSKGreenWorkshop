package com.cn.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.biz.TblRTWorkInfoBiz;
import com.cn.entity.RepairNum;
import com.cn.entity.TblProduceByHour;
import com.cn.entity.TblRSByHour;
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
		
		
			calendar.add(calendar.DATE, 0);
			calendar.set(Calendar.HOUR_OF_DAY,0);
			calendar.set(Calendar.MINUTE,0);
			calendar.set(Calendar.SECOND,0);
			date = calendar.getTime();
			startDateList.add(f.format(date));
		
	
			calendar2.add(calendar2.DATE, 1);
			calendar2.set(Calendar.HOUR_OF_DAY,0);
			calendar2.set(Calendar.MINUTE,0);
			calendar2.set(Calendar.SECOND,0);
			date = calendar2.getTime();
			endDateList.add(f.format(date));
		
		
		Integer PassNum = 0;
		
		List<TblProduceByHour> tblProduceByHour = null;
		
		if (!apikey.equals("nnjj_0944547748")) {
			msg = "非法请求！";
			map.put("flag", "0");
			map.put("msg", msg);
		}else {
			int indexDate = startDateList.size();
	
			tblProduceByHour = tblRTWorkInfoBiz.selectPassNumbyHour(RobotNo,
							startDateList.get(0),endDateList.get(0));
			
			if(tblProduceByHour.size() < 24){
				for(int i = tblProduceByHour.size();i < 24;i++){
					TblProduceByHour tblProduceByHour2 = new TblProduceByHour();
					tblProduceByHour2.setHour(i);
					tblProduceByHour.add(tblProduceByHour2);
				}
			}
		
			map.put("flag", "1");
			map.put("tblProduceByHours", tblProduceByHour);
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
		
		calendar2.add(calendar2.DATE, 0);
		calendar2.set(Calendar.HOUR_OF_DAY,23);
		calendar2.set(Calendar.MINUTE,59);
		calendar2.set(Calendar.SECOND,59);
		date = calendar2.getTime();
		endTime = f.format(date);
		
		String TesterNum;
		Integer Tester_Status;
		double RepairTime;
		Integer RepairNum = 0;
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
		
		TblRobotDataInfo tblRobotDataInfo = null;
		List<TblTesterStatus> tblTesterStatus = new ArrayList<TblTesterStatus>();
		List<TblWorkInfoSumData> tblWorkInfoSumDatas = new ArrayList<TblWorkInfoSumData>();
		List<RepairNum> RepairNums = new ArrayList<RepairNum>();
		List<TblRobotDataInfo> tblRobotDataInfos = new ArrayList<TblRobotDataInfo>();
		
		if (!apikey.equals("nnjj_0944547748")) {
			msg = "非法请求！";
			map.put("flag", "0");
			map.put("msg", msg);
		}else {
			

			Date newDayTime = tblRTWorkInfoBiz.selectNewDayTimeByDay(RobotNo);
			String strNewDayTime = f.format(newDayTime);
			
			tblTesterStatus = tblRTWorkInfoBiz.selectTesterStatus(strNewDayTime,RobotNo);
			tblWorkInfoSumDatas = tblRTWorkInfoBiz.selectWorkInfoSum(startTime,endTime,RobotNo);
			RepairNums = tblRTWorkInfoBiz.selectTesterRepairNum(startTime,endTime,RobotNo);
			
			for(int i = 0;i < tblTesterStatus.size();i++){
				if(tblTesterStatus.get(i).getStatus().equals("OffLine") && tblTesterStatus.get(i).getPassNum() == 0){
					Tester_Status = 0;
				}else{
					Tester_Status = 1;
				}
				
				TesterNum = tblWorkInfoSumDatas.get(i).getTesterNum();
				RepairTime = tblWorkInfoSumDatas.get(i).getRepairTime();
				PassNum = tblWorkInfoSumDatas.get(i).getPassNum();
				Put_NG = tblWorkInfoSumDatas.get(i).getPut_NG();
				Put_OK = tblWorkInfoSumDatas.get(i).getPut_OK();
				FailNum = tblWorkInfoSumDatas.get(i).getFailNum();
				SFCErrNum = tblWorkInfoSumDatas.get(i).getSFCErrNum();
				FirstPS_NG = tblWorkInfoSumDatas.get(i).getFirstPS_NG();
				OUTPUT = tblWorkInfoSumDatas.get(i).getPassNum();
				INPUT = PassNum+Put_NG+FailNum;
				
				if(Put_NG+Put_OK != 0){
					PS_NG = (double)FirstPS_NG/((double)Put_NG+(double)Put_OK);
					PUT_NG = (double)Put_NG/((double)Put_NG+(double)Put_OK);
				}else{
					PS_NG = 0.00;
					PUT_NG = 0.00;
				}
				
				for(int j = 0;j < RepairNums.size();j++){
					if(tblWorkInfoSumDatas.get(i).getTesterNum().equals(RepairNums.get(j).getTesterNum())){
						RepairNum = RepairNums.get(j).getRepairNum();
					}
				}
				tblRobotDataInfo = new TblRobotDataInfo(TesterNum, tblTesterStatus.get(i).getTester_IP(), Tester_Status,RepairTime ,RepairNum, INPUT, OUTPUT, FailNum, SFCErrNum, PS_NG, PUT_NG);
				tblRobotDataInfos.add(tblRobotDataInfo);
				RepairNum = 0;
			}
			
			map.put("flag", "1");
			map.put("tblRobotDataInfos", tblRobotDataInfos);
			map.put("msg", msg);
		}
		return map;
	}
	
	/**
	 * 最新一天andByHour的手臂/机台数据明细接口
	 * @param apikey
	 * @param RobotNo
	 * @param hour
	 * @return
	 */
	@RequestMapping("/selectRobotDataInfoByHour")
	public @ResponseBody Map selectRobotDataInfoByHour(String apikey,String RobotNo,int hour){
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
		calendar.set(Calendar.HOUR_OF_DAY,hour);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		date = calendar.getTime();
		startTime = f.format(date);
		System.out.println("---------------------------------startTime:"+startTime);
		
		calendar2.add(calendar2.DATE, 0);
		calendar2.set(Calendar.HOUR_OF_DAY,hour);
		calendar2.set(Calendar.MINUTE,59);
		calendar2.set(Calendar.SECOND,59);
		date = calendar2.getTime();
		endTime = f.format(date);
		
		String TesterNum;
		Integer Tester_Status;
		double RepairTime;
		Integer RepairNum = 0;
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
		
		TblRobotDataInfo tblRobotDataInfo = null;
		List<TblTesterStatus> tblTesterStatus = new ArrayList<TblTesterStatus>();
		List<TblWorkInfoSumData> tblWorkInfoSumDatas = new ArrayList<TblWorkInfoSumData>();
		List<RepairNum> RepairNums = new ArrayList<RepairNum>();
		List<TblRobotDataInfo> tblRobotDataInfos = new ArrayList<TblRobotDataInfo>();
		
		if (!apikey.equals("nnjj_0944547748")) {
			msg = "非法请求！";
			map.put("flag", "0");
			map.put("msg", msg);
		}else {
			
			Date newHourTime = tblRTWorkInfoBiz.selectNewDayTimeByHour(RobotNo,startTime,endTime);
			String strNewHourTime = f.format(newHourTime);
			
			tblTesterStatus = tblRTWorkInfoBiz.selectTesterStatus(strNewHourTime,RobotNo);
			tblWorkInfoSumDatas = tblRTWorkInfoBiz.selectWorkInfoSum(startTime,endTime,RobotNo);
			RepairNums = tblRTWorkInfoBiz.selectTesterRepairNum(startTime,endTime,RobotNo);
			
			for(int i = 0;i < tblTesterStatus.size();i++){
				
				if(tblTesterStatus.get(i).getStatus().equals("OffLine") && tblTesterStatus.get(i).getPassNum() == 0){
					Tester_Status = 0;
				}else{
					Tester_Status = 1;
				}
				
				TesterNum = tblWorkInfoSumDatas.get(i).getTesterNum();
				RepairTime = tblWorkInfoSumDatas.get(i).getRepairTime();
				PassNum = tblWorkInfoSumDatas.get(i).getPassNum();
				Put_NG = tblWorkInfoSumDatas.get(i).getPut_NG();
				Put_OK = tblWorkInfoSumDatas.get(i).getPut_OK();
				FailNum = tblWorkInfoSumDatas.get(i).getFailNum();
				SFCErrNum = tblWorkInfoSumDatas.get(i).getSFCErrNum();
				FirstPS_NG = tblWorkInfoSumDatas.get(i).getFirstPS_NG();
				OUTPUT = tblWorkInfoSumDatas.get(i).getPassNum();
				INPUT = PassNum+Put_NG+FailNum;
				
				if(Put_NG+Put_OK != 0){
					PS_NG = (double)FirstPS_NG/((double)Put_NG+(double)Put_OK);
					PUT_NG = (double)Put_NG/((double)Put_NG+(double)Put_OK);
				}else{
					PS_NG = 0.00;
					PUT_NG = 0.00;
				}
				
				for(int j = 0;j < RepairNums.size();j++){
					if(tblWorkInfoSumDatas.get(i).getTesterNum().equals(RepairNums.get(j).getTesterNum())){
						RepairNum = RepairNums.get(j).getRepairNum();
					}
				}
				tblRobotDataInfo = new TblRobotDataInfo(TesterNum, tblTesterStatus.get(i).getTester_IP(), Tester_Status,RepairTime ,RepairNum, INPUT, OUTPUT, FailNum, SFCErrNum, PS_NG, PUT_NG);
				tblRobotDataInfos.add(tblRobotDataInfo);
				RepairNum = 0;
			}
			
			map.put("flag", "1");
			map.put("tblRobotDataInfos", tblRobotDataInfos);
			map.put("msg", msg);
		}
		return map;
	}
	
}
