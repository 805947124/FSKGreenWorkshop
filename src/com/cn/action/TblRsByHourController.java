package com.cn.action;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.FontUIResource;

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
import com.cn.biz.TblRTWorkInfoBiz;
import com.cn.entity.TblCustomer;
import com.cn.entity.TblRSByHour;
import com.cn.entity.TblRSNow;
import com.cn.entity.TblRTWorkInfo;
import com.cn.entity.TblRobotInfo;
import com.cn.util.TblRankingDate;

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
	@Autowired
	private TblRTWorkInfoBiz tblRTWorkInfoBiz;
	
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
	 * 根据Customername区分查询所有手臂信息的接口
	 * @param apikey
	 * @return
	 */
	@RequestMapping("/selectAllRobotNo")
	public @ResponseBody Map selectAllRobotNo(String apikey){
		
		Map map = new HashMap();
		Map customerMap = new HashMap();
		String msg = "";
		
		List<TblCustomer> tblCustomers = null;
		List<TblRSByHour> tblRSByHour = new ArrayList<TblRSByHour>();
		
		TblCustomer tblCustomer = null;
		
		if (!apikey.equals("nnjj_0944547748")){
			msg = "非法请求！";
			map.put("flag", "0");
			map.put("msg", msg);
		}else{
			tblCustomers = tblCustomerBiz.selectAllFun();
			int indexCustomer = tblCustomers.size()-1;
			
			for (int i = 0; i <= indexCustomer; i++){
				tblCustomer = tblCustomers.get(i);
				tblRSByHour = tblRsByHourBiz.selectAllRobotNoByCustomerName(tblCustomer.getCustomername());
				
				tblCustomer.setId(tblCustomers.get(i).getId());
				tblCustomer.setCustomername(tblCustomers.get(i).getCustomername());
				tblCustomer.setTblRsByHour(tblRSByHour);
			}
			map.put("flag", "1");
			map.put("tblCustomers", tblCustomers);
			map.put("msg", msg);
		}
		return map;
	}
	
	/**
	 * 根据Customername区分查询所有  正在运行  手臂信息的接口
	 * @param apikey
	 * @return
	 */
	@RequestMapping("/selectAllRunRobotNo")
	public @ResponseBody Map selectAllRunRobotNo(String apikey){
		
		Map map = new HashMap();
		Map customerMap = new HashMap();
		String msg = "";
		
		List<TblCustomer> tblCustomers = null;
		List<TblRSByHour> tblRSByHour = new ArrayList<TblRSByHour>();
		
		TblCustomer tblCustomer = null;
		
		if (!apikey.equals("nnjj_0944547748")){
			msg = "非法请求！";
			map.put("flag", "0");
			map.put("msg", msg);
		}else{
			tblCustomers = tblCustomerBiz.selectAllFun();
			int indexCustomer = tblCustomers.size()-1;
			
			for (int i = 0; i <= indexCustomer; i++){
				tblCustomer = tblCustomers.get(i);
				tblRSByHour = tblRsByHourBiz.selectAllRunRobotNoByCustomerName(tblCustomer.getCustomername());
				
				tblCustomer.setId(tblCustomers.get(i).getId());
				tblCustomer.setCustomername(tblCustomers.get(i).getCustomername());
				tblCustomer.setTblRsByHour(tblRSByHour);
			}
			map.put("flag", "1");
			map.put("tblCustomers", tblCustomers);
			map.put("msg", msg);
		}
		return map;
	}
	
	/**
	 * 根据Customername区分查询所有  待机  手臂信息的接口
	 * @param apikey
	 * @return
	 */
	@RequestMapping("/selectAllStanbyRobotNo")
	public @ResponseBody Map selectAllStanbyRobotNo(String apikey){
		
		Map map = new HashMap();
		Map customerMap = new HashMap();
		String msg = "";
		
		List<TblCustomer> tblCustomers = null;
		List<TblRSByHour> tblRSByHour = new ArrayList<TblRSByHour>();
		
		TblCustomer tblCustomer = null;
		
		if (!apikey.equals("nnjj_0944547748")){
			msg = "非法请求！";
			map.put("flag", "0");
			map.put("msg", msg);
		}else{
			tblCustomers = tblCustomerBiz.selectAllFun();
			int indexCustomer = tblCustomers.size()-1;
			
			for (int i = 0; i <= indexCustomer; i++){
				tblCustomer = tblCustomers.get(i);
				tblRSByHour = tblRsByHourBiz.selectAllStanbyRobotNoByCustomerName(tblCustomer.getCustomername());
				
				tblCustomer.setId(tblCustomers.get(i).getId());
				tblCustomer.setCustomername(tblCustomers.get(i).getCustomername());
				tblCustomer.setTblRsByHour(tblRSByHour);
			}
			map.put("flag", "1");
			map.put("tblCustomers", tblCustomers);
			map.put("msg", msg);
		}
		return map;
	}
	
	/**
	 * 根据Customername区分查询所有  故障  手臂信息的接口
	 * @param apikey
	 * @return
	 */
	@RequestMapping("/selectAllErrorRobotNo")
	public @ResponseBody Map selectAllErrorRobotNo(String apikey){
		
		Map map = new HashMap();
		Map customerMap = new HashMap();
		String msg = "";
		
		List<TblCustomer> tblCustomers = null;
		List<TblRSByHour> tblRSByHour = new ArrayList<TblRSByHour>();
		
		TblCustomer tblCustomer = null;
		
		if (!apikey.equals("nnjj_0944547748")){
			msg = "非法请求！";
			map.put("flag", "0");
			map.put("msg", msg);
		}else{
			tblCustomers = tblCustomerBiz.selectAllFun();
			int indexCustomer = tblCustomers.size()-1;
			
			for (int i = 0; i <= indexCustomer; i++){
				tblCustomer = tblCustomers.get(i);
				tblRSByHour = tblRsByHourBiz.selectAllErrorRobotNoByCustomerName(tblCustomer.getCustomername());
				
				tblCustomer.setId(tblCustomers.get(i).getId());
				tblCustomer.setCustomername(tblCustomers.get(i).getCustomername());
				tblCustomer.setTblRsByHour(tblRSByHour);
			}
			map.put("flag", "1");
			map.put("tblCustomers", tblCustomers);
			map.put("msg", msg);
		}
		return map;
	}
	
	/**
	 * 根据Customername区分查询所有  停机保养  手臂信息的接口
	 * @param apikey
	 * @return
	 */
	@RequestMapping("/selectAllShutdownRobotNo")
	public @ResponseBody Map selectAllShutdownRobotNo(String apikey){
		
		Map map = new HashMap();
		Map customerMap = new HashMap();
		String msg = "";
		
		List<TblCustomer> tblCustomers = null;
		List<TblRSByHour> tblRSByHour = new ArrayList<TblRSByHour>();
		
		TblCustomer tblCustomer = null;
		
		if (!apikey.equals("nnjj_0944547748")){
			msg = "非法请求！";
			map.put("flag", "0");
			map.put("msg", msg);
		}else{
			tblCustomers = tblCustomerBiz.selectAllFun();
			int indexCustomer = tblCustomers.size()-1;
			
			for (int i = 0; i <= indexCustomer; i++){
				tblCustomer = tblCustomers.get(i);
				tblRSByHour = tblRsByHourBiz.selectAllShutdownRobotNoByCustomerName(tblCustomer.getCustomername());
				
				tblCustomer.setId(tblCustomers.get(i).getId());
				tblCustomer.setCustomername(tblCustomers.get(i).getCustomername());
				tblCustomer.setTblRsByHour(tblRSByHour);
			}
			map.put("flag", "1");
			map.put("tblCustomers", tblCustomers);
			map.put("msg", msg);
		}
		return map;
	}
	
	/**
	 * Robot查询机械手状态按区域划分列表
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
		
		List<TblCustomer> tblCustomers = null;

		TblCustomer tblCustomer = null;
		List<TblRSNow> tblRSNows =new ArrayList<TblRSNow>();
		List<TblRSByHour> tblRSByHours = null;
		DecimalFormat df = new DecimalFormat("0.00");
		double productivity = 0.00;
		
		if (!apikey.equals("nnjj_0944547748")) {
			msg = "非法请求！";
			map.put("flag", "0");
			map.put("msg", msg);
		}else {
			tblCustomers = tblCustomerBiz.selectAllFun();
			int indexCustomer = tblCustomers.size()-1;

			for (int i = 0; i <= indexCustomer; i++) {
				tblCustomer = tblCustomers.get(i);
				tblRSByHours = tblRsByHourBiz.selectByCustomerName(tblCustomer.getCustomername());
				tblCustomer.setId(tblCustomers.get(i).getId());
				tblCustomer.setCustomername(tblCustomers.get(i).getCustomername());
				tblCustomer.setTblRsByHour(tblRSByHours);
				tblCustomer.setTblRSNows(tblRSNows);
				}
			
			map.put("flag", "1");
			map.put("tblCustomers", tblCustomers);
			map.put("msg", msg);
		}
		return map;
	}
	
	
	/**
	 * Robot查询效率监控页面机械手效率排行
	 * @param apikey
	 * @return map
	 * @throws ParseException
	 */
	@RequestMapping("/selectByRobotRanking")
	public @ResponseBody Map selectByRobotRanking(String apikey){
		
		Map map = new HashMap();
		Map robotNoMap = new HashMap();
		String msg = "";
		
		Date date  = new Date();
		Date endDate =new Date();
		
		List<TblRSNow> tblRSNows = null;
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		date = tblRsByHourBiz.selectMaxDate();
		
		Calendar calendar = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		
		calendar.setTime(date);
		calendar2.setTime(date);
		
		calendar.add(calendar.DATE, 0);
		
		calendar2.set(Calendar.HOUR,23);
		calendar2.set(Calendar.MINUTE,59);
		calendar2.set(Calendar.SECOND,59);
		calendar2.add(calendar.DATE,0);
		
		date=calendar.getTime();
		String startDate = f.format(date);
		
		endDate = calendar2.getTime();
		String finishDate =f.format(endDate);
		
		
		
		
		
		double productivity = 0.00;
		
		if (!apikey.equals("nnjj_0944547748")) {
			msg = "非法请求！";
			map.put("flag", "0");
			map.put("msg", msg);
		}else {
				Double runCount=0.0;
				Double standbyCount=0.0;
				Double erroCount=0.0;
				tblRSNows = tblRSNowBiz.selectByRSNoweFun();
				int indexTblRSNow = tblRSNows.size();
				for (int j = 0; j < indexTblRSNow; j++) {
					
					
					if (tblRSNows!=null) {
						 runCount = tblRsByHourBiz.selectRobotRunTimeCount(tblRSNows.get(j).getRobotno(),startDate,finishDate);
						 standbyCount = tblRsByHourBiz.RobotNoStandbyTimeTypeCountFun(tblRSNows.get(j).getRobotno(),startDate,finishDate);
						 erroCount = tblRsByHourBiz.RobotNoErroTimeTypeCountFun(tblRSNows.get(j).getRobotno(),startDate,finishDate);
					}
					if (runCount!=null || standbyCount!=null || erroCount!=null) {
						productivity = (double)runCount/(runCount+standbyCount+erroCount);
					}
					String strRobot = tblRSNows.get(j).getRobotno();
					
					String[] str = strRobot.split("R");
					if (str[0].equals("CPEB042FM")|| str[0].equals("CPEB042FF")) {
						strRobot = "R"+str[1];
					}else {
						str = strRobot.split("-");
						strRobot = "TAKO"+str[3];
					}
					
					tblRSNows.get(j).setShortName(strRobot);
					tblRSNows.get(j).setEfficiency(productivity);
				}
				
				Collections.sort(tblRSNows, new Comparator<TblRSNow>(){
		            /*
		             * int compare(Person p1, Person p2) 返回一个基本类型的整型，
		             * 返回负数表示：p1 小于p2，
		             * 返回0 表示：p1和p2相等，
		             * 返回正数表示：p1大于p2
		             */
					@Override
					public int compare(TblRSNow o1, TblRSNow o2) {
						  //按照Person的年龄进行升序排列
		                if(o1.getEfficiency() > o2.getEfficiency()){
		                    return 1;
		                }
		                if(o1.getEfficiency() == o2.getEfficiency()){
		                    return 0;
		                }
		                return -1;
					}
		        });
		
			System.out.println("开始时间："+startDate+"\n结束时间："+finishDate);
			map.put("flag", "1");
			map.put("tblRSNows", tblRSNows);
			map.put("msg", msg);
		}
		return map;
	}
	
	/**
	 * 按日期查询默认所有手臂一天24小时运行时间趋势
	 * @param apikey
	 * @return map
	 * @throws ParseException
	 */
	@RequestMapping("/selectByRobotHourRanking")
	public @ResponseBody Map selectByRobotHourRanking(String apikey,String startDate) throws ParseException{
		
		Map map = new HashMap();
		Map robotNoMap = new HashMap();
		String msg = "";
		List<TblRSNow> tblRSNows = null;
		TblRSNow tblRSNow = null;
		List<TblRSByHour> tblRSByHours =null;
		
		
		double productivity = 0.00;
		
		if (!apikey.equals("nnjj_0944547748")) {
			msg = "非法请求！";
			map.put("flag", "0");
			map.put("msg", msg);
		}else {
				Double runCount=0.0;
				Double standbyCount=0.0;
				Double erroCount=0.0;
				tblRSNows = tblRSNowBiz.selectByRSNoweFun();
				String roobot = "";
				int indexTblRSNow = tblRSNows.size();
				String datei = "";
				
				double num = 0.0;
				for (int j = 0; j < indexTblRSNow; j++) {
					tblRSNow =tblRSNows.get(j);
					tblRSByHours = tblRsByHourBiz.selectByDateAndRobotNo(tblRSNow.getRobotno(),startDate);
					/*List<TblRankingDate> tblRankingDates = new ArrayList<TblRankingDate>();
					int indeHour =  tblRSByHours.size();
					for (int i = 0; i <indeHour; i++) {
					num = tblRSByHours.get(i).getRuntimes()/60;
					datei = i+"";
					TblRankingDate tblRankingDate = new TblRankingDate(datei, num);
					tblRankingDates.add(tblRankingDate);
					}*/
					
					
					String strRobot = tblRSNows.get(j).getRobotno();
					
					String[] str = strRobot.split("R");
					if (str[0].equals("CPEB042FM")|| str[0].equals("CPEB042FF")) {
						strRobot = "R"+str[1];
					}else {
						str = strRobot.split("-");
						strRobot = "TAKO"+str[3];
					}
					
					tblRSNows.get(j).setShortName(strRobot);
					
					tblRSNows.get(j).setTblRSByHour(tblRSByHours);
				}
					
				
			map.put("flag", "1");
			map.put("tblRSNowsList", tblRSNows);
			map.put("msg", msg);
		}
		return map;
	}
	
	
	/**
	 * 按日期查询单个手臂号一天24小时运行时间趋势
	 * @param apikey
	 * @return map
	 * @throws ParseException
	 */
	@RequestMapping("/selectByRobotHourRankingType")
	public @ResponseBody Map selectByRobotHourRankingType(String apikey,String robotno,String startDate) throws ParseException{
		
		Map map = new HashMap();
		Map robotNoMap = new HashMap();
		String msg = "";
		List<TblRSNow> tblRSNows = null;
		TblRSNow tblRSNow = null;
		List<TblRSByHour> tblRSByHours =null;
		
		
		double productivity = 0.00;
		
		if (!apikey.equals("nnjj_0944547748")) {
			msg = "非法请求！";
			map.put("flag", "0");
			map.put("msg", msg);
		}else {
					tblRSByHours = tblRsByHourBiz.selectByDateAndRobotNo(robotno,startDate);
					/*List<TblRankingDate> tblRankingDates = new ArrayList<TblRankingDate>();
					int indeHour =  tblRSByHours.size();
					for (int i = 0; i <indeHour; i++) {
					num = tblRSByHours.get(i).getRuntimes()/60;
					datei = i+"";
					TblRankingDate tblRankingDate = new TblRankingDate(datei, num);
					tblRankingDates.add(tblRankingDate);
					}*/
				
					
				
			map.put("flag", "1");
			map.put("tblRSByHours", tblRSByHours);
			map.put("msg", msg);
		}
		return map;
	}
	
	
	/**
	 * Robot查询效率监控页面按一周日期折线图查询
	 * @param apikey
	 * @return map
	 * @throws ParseException
	 */
	@RequestMapping("/selectByRobotRankingDate")
	public @ResponseBody Map selectByRobotRankingDate(String apikey){
		
		Map map = new HashMap();
		String msg = "";
		List<TblRSNow> tblRSNows = null;
		Date date  = new Date();
		Date endDate =new Date();
		
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		date = tblRsByHourBiz.selectMaxDate();
		
		Calendar calendar = Calendar.getInstance();
		Calendar calendar2 = calendar.getInstance();
		
		calendar.setTime(date);
		calendar2.setTime(date);
		
		List<String> StartdateList =new ArrayList<String>();
		List<String> enddateList = new ArrayList<String>();
		
		calendar.add(calendar.DATE, 0);
		
		calendar2.set(Calendar.HOUR,23);
		calendar2.set(Calendar.MINUTE,59);
		calendar2.set(Calendar.SECOND,59);
		calendar2.add(calendar.DATE,0);
		
		endDate = calendar2.getTime();
		enddateList.add(f.format(endDate));
		
		date=calendar.getTime();
		StartdateList.add(f.format(date));
		
		for (int i = 0; i < 14; i++) {
			
			calendar.add(calendar.DATE, -1);
			date=calendar.getTime();
			StartdateList.add(f.format(date));
		}
		
		for (int i = 0; i < 14; i++) {
			
			calendar2.add(calendar.DATE, -1);
			endDate=calendar2.getTime();
			enddateList.add(f.format(endDate));
		}
		
		double productivity = 0.00;
		Double runTimes = 0.0;
		Double erroTimes = 0.0;
		Double standbyTimes = 0.0;
		
		List<TblRankingDate> tblRankingDates = new ArrayList<TblRankingDate>();
		TblRankingDate tblRankingDate = null;
		if (!apikey.equals("nnjj_0944547748")) {
			msg = "非法请求！";
			map.put("flag", "0");
			map.put("msg", msg);
		}else {
			int num = StartdateList.size();
			
			for (int i = 0; i < StartdateList.size(); i++) {
				runTimes = tblRsByHourBiz.selectRunTimesFun(StartdateList.get(i),enddateList.get(i));
				erroTimes = tblRsByHourBiz.selectErrorTimesFun(StartdateList.get(i),enddateList.get(i));
				standbyTimes = tblRsByHourBiz.selectStandbyTimesFun(StartdateList.get(i),enddateList.get(i));	
				
				if (runTimes!=null || erroTimes!=null || standbyTimes!=null) {
					if (runTimes+erroTimes+standbyTimes==0) {
						productivity=0.00;
					}else {
						productivity =runTimes/(runTimes+erroTimes+standbyTimes);

					}
				}
				
				tblRankingDate = new TblRankingDate(StartdateList.get(i), productivity);
				tblRankingDates.add(tblRankingDate);
				
			}
			
			
				
			map.put("flag", "1");
			map.put("tblRankingDates", tblRankingDates);
			map.put("msg", msg);
		}
		return map;
	}
	
	
	/**
	 * Robot查询效率监控页面按一周日期折线图查询
	 * @param apikey
	 * @return map
	 * @throws ParseException
	 */
	@RequestMapping("/selectByRobotRankingDateType")
	public @ResponseBody Map selectByRobotRankingDateType(String apikey,String robotno){
		
		Map map = new HashMap();
		String msg = "";
		List<TblRSNow> tblRSNows = null;
		Date date  = new Date();
		Date endDate =new Date();
		
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		date = tblRsByHourBiz.selectMaxDate();
		
		Calendar calendar = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		
		calendar.setTime(date);
		calendar2.setTime(date);
		
		List<String> StartdateList =new ArrayList<String>();
		List<String> enddateList = new ArrayList<String>();
		
		calendar.add(calendar.DATE, 0);
		
		calendar2.set(Calendar.HOUR,23);
		calendar2.set(Calendar.MINUTE,59);
		calendar2.set(Calendar.SECOND,59);
		calendar2.add(calendar.DATE,0);
		
		endDate = calendar2.getTime();
		enddateList.add(f.format(endDate));
		
		date=calendar.getTime();
		StartdateList.add(f.format(date));
		
		for (int i = 0; i < 14; i++) {
			
			calendar.add(calendar.DATE, -1);
			date=calendar.getTime();
			StartdateList.add(f.format(date));
		}
		
		for (int i = 0; i < 14; i++) {
			
			calendar2.add(calendar.DATE, -1);
			endDate=calendar2.getTime();
			enddateList.add(f.format(endDate));
		}
		
		double productivity = 0.00;
		double runTimes = 0.0;
		double erroTimes = 0.0;
		double standbyTimes = 0.0;
		
		List<TblRankingDate> tblRankingDates = new ArrayList<TblRankingDate>();
		TblRankingDate tblRankingDate = null;
		if (!apikey.equals("nnjj_0944547748")) {
			msg = "非法请求！";
			map.put("flag", "0");
			map.put("msg", msg);
		}else {
			int num = StartdateList.size();
			
			for (int i = 0; i < StartdateList.size(); i++) {
				runTimes = tblRsByHourBiz.selectRunTimesTypeFun(StartdateList.get(i),enddateList.get(i),robotno);
				erroTimes = tblRsByHourBiz.selectErrorTimesTypeFun(StartdateList.get(i),enddateList.get(i),robotno);
				standbyTimes = tblRsByHourBiz.selectStandbyTimesTypeFun(StartdateList.get(i),enddateList.get(i),robotno);	
				
				if (runTimes!=0 || erroTimes!=0 || standbyTimes!=0) {
					if (runTimes+erroTimes+standbyTimes==0) {
						productivity=0.00;
					}else {
						productivity =runTimes/(runTimes+erroTimes+standbyTimes);

					}
				}
				
				tblRankingDate = new TblRankingDate(StartdateList.get(i), productivity);
				tblRankingDates.add(tblRankingDate);
				
			}
			
			
				
			map.put("flag", "1");
			map.put("tblRankingDates", tblRankingDates);
			map.put("msg", msg);
		}
		return map;
	}
	
	
	/**
	 * Robot查询效率监控页面产出得分
	 * @param apikey
	 * @return map
	 * @throws ParseException
	 */
	@RequestMapping("/selectByRobotOutput")
	public @ResponseBody Map selectByRobotOutput(String apikey,String robotno){
		
		Map map = new HashMap();
		String msg = "";
		List<TblRSNow> tblRSNows = null;
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startDate  = new Date();
		Date endDate = new Date();
		startDate = tblRsByHourBiz.selectMaxDate();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		calendar.add(calendar.DATE,0);
		startDate=calendar.getTime();
		
		System.out.println(f.format(startDate));
		
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(startDate);
		calendar2.set(Calendar.HOUR,23);
		calendar2.set(Calendar.MINUTE,59);
		calendar2.set(Calendar.SECOND,59);
		calendar2.add(calendar.DATE,0);
		endDate = calendar2.getTime();
		System.out.println(f.format(endDate));
		double productivity = 0.00;
		
		if (!apikey.equals("nnjj_0944547748")) {
			msg = "非法请求！";
			map.put("flag", "0");
			map.put("msg", msg);
		}else {

			Integer passNum = tblRTWorkInfoBiz.selectPassNumFun(robotno,f.format(startDate),f.format(endDate));
			Integer putNg = tblRTWorkInfoBiz.selectputNgFun(robotno,f.format(startDate),f.format(endDate));
			Integer failNum = tblRTWorkInfoBiz.selectfailNumFun(robotno,f.format(startDate),f.format(endDate));	
			
			if (passNum!=null || putNg!=null || failNum!=null) {
				if (passNum+putNg+failNum==0) {
					productivity=0.00;
				}else {
					productivity = (double)passNum/(passNum+putNg+failNum);

				}
			}
			
			map.put("flag", "1");
			map.put("productivity", productivity);
			map.put("passNum", passNum);
			map.put("putNg", putNg);
			map.put("failNum", failNum);
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
	
	/**
	 * 按区域划分条件查询手臂列表
	 * @param apikey
	 * @param modelName
	 * @param robotNo
	 * @return
	 */
	@RequestMapping("/selectByTypeByRsByHourNo")
	public @ResponseBody Map selectByTypeByRsByHourNo(String apikey,String modelName,String robotNo){
		
		Map map = new HashMap();
		Map NumMap = new HashMap();
		Map customerMap = new HashMap();
		Map robotNoMap = new HashMap();
		String msg = "";
		
		List<TblCustomer> tblCustomers = null;

		TblCustomer tblCustomer = null;
		List<TblRSNow> tblRSNows =new ArrayList<TblRSNow>();
		List<TblRSByHour> tblRSByHours = null;
		DecimalFormat df = new DecimalFormat("0.00");
		double productivity = 0.00;
		
		if (!apikey.equals("nnjj_0944547748")) {
			msg = "非法请求！";
			map.put("flag", "0");
			map.put("msg", msg);
		}else {
			tblCustomers = tblCustomerBiz.selectAllFun();
			int indexCustomer = tblCustomers.size()-1;
			
			for (int i = 0; i <= indexCustomer; i++) {
				
				if(robotNo.equals("All")){
					
					tblCustomer = tblCustomers.get(i);
					tblRSNows = tblRSNowBiz.selectByCustomerNameByModelName(tblCustomer.getCustomername(),modelName);
					
					tblCustomer.setId(tblCustomers.get(i).getId());
					tblCustomer.setCustomername(tblCustomers.get(i).getCustomername());
					tblCustomer.setTblRsByHour(tblRSByHours);
					tblCustomer.setTblRSNows(tblRSNows);
					
				}else{
					
					tblCustomer = tblCustomers.get(i);
					tblRSNows = tblRSNowBiz.selectByCustomerNameByType(tblCustomer.getCustomername(),modelName,robotNo);
					
					tblCustomer.setId(tblCustomers.get(i).getId());
					tblCustomer.setCustomername(tblCustomers.get(i).getCustomername());
					tblCustomer.setTblRsByHour(tblRSByHours);
					tblCustomer.setTblRSNows(tblRSNows);
				}
			}
			map.put("flag", "1");
			map.put("tblCustomers", tblCustomers);
			map.put("msg", msg);
		}
		return map;
	}
	
	/**
	 * 查询运行得分接口
	 * @param apikey
	 * @param robotNo
	 * @return
	 */
	@RequestMapping("/selectRunScore")
	public @ResponseBody Map selectRunScore(String apikey,String robotNo){
		
		Map map = new HashMap();
		String msg = "";
		
		if (!apikey.equals("nnjj_0944547748")) {
			msg = "非法请求！";
			map.put("flag", "0");
			map.put("msg", msg);
		}else{
			
			Double RunTimes = tblRsByHourBiz.selectRunTimes(robotNo);
			Double StandbyTimes = tblRsByHourBiz.selectStandbyTimes(robotNo);
			Double ErrorTimes = tblRsByHourBiz.selectErrorTimes(robotNo);
			
			Double RunScore = RunTimes/(RunTimes+StandbyTimes+ErrorTimes);
			
			System.out.println("运行时间："+RunTimes+"/n待机时间："+StandbyTimes+"/n停机时间："+ErrorTimes+"/n运行得分："+RunScore);
			
			map.put("flag", "1");
			map.put("msg", msg);
			map.put("robotNo", robotNo);
			map.put("RunTimes", RunTimes);
			map.put("StandbyTimes", StandbyTimes);
			map.put("ErrorTimes", ErrorTimes);
			map.put("RunScore", RunScore);
		}
		return map;
	}
	
	/**
	 * 手臂运行时间趋势接口
	 * @param apikey
	 * @param robotNo
	 * @return
	 */
	@RequestMapping("/selectRobotNoRunTimeTrend")
	public @ResponseBody Map selectRobotNoRunTimeTrend(String apikey,String robotNo){
		
		Map map = new HashMap();
		List<TblRSByHour> tblRSByHours = new ArrayList<TblRSByHour>();
		String msg = "";
		
		if (!apikey.equals("nnjj_0944547748")) {
			msg = "非法请求！";
			map.put("flag", "0");
			map.put("msg", msg);
		}else{
			tblRSByHours = tblRsByHourBiz.selectRobotNoRunTimeTrend(robotNo);
			String modelname = tblRSByHours.get(1).getModelname();
			
			if(tblRSByHours.size() < 24){
				for(int i = tblRSByHours.size();i < 24;i++){
					TblRSByHour tblRSByHour = new TblRSByHour();
					tblRSByHour.setHour(String.valueOf(i));
					tblRSByHour.setModelname(modelname);
					tblRSByHour.setRobotno(robotNo);
					tblRSByHours.add(tblRSByHour);
				}
			}
			
			map.put("flag", "1");
			map.put("msg", msg);
			map.put("tblRSByHours", tblRSByHours);
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
			map.put("flag", "1");
			map.put("tblRSByHours", tblRSByHours);
			
		}
		return map;
	}
}
