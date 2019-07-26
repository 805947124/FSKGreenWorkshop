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
		Date endDate = new Date();
		
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
		Integer FailNum = 0;
		Integer Put_NG = 0;
		double productivity = 0.00;
		
		TblProduceByHour tblProduceByHour = null;
		List<TblProduceByHour> tblProduceByHours = new ArrayList<TblProduceByHour>();
		
		if (!apikey.equals("nnjj_0944547748")) {
			msg = "非法请求！";
			map.put("flag", "0");
			map.put("msg", msg);
		}else {
			
			for(int i = 0;i < startDateList.size();i++){
				PassNum = tblRTWorkInfoBiz.selectPassNumbyHour(RobotNo,startDateList.get(i),endDateList.get(i));
				FailNum = tblRTWorkInfoBiz.selectFailNumbyHour(RobotNo,startDateList.get(i),endDateList.get(i));
				Put_NG = tblRTWorkInfoBiz.selectPut_NGbyHour(RobotNo,startDateList.get(i),endDateList.get(i));
				
				if (PassNum !=null || FailNum !=null || Put_NG !=null) {
					if (PassNum+PassNum+PassNum==0) {
						productivity=0.00;
					}else {
						productivity =(double)PassNum/((double)PassNum+(double)FailNum+(double)Put_NG);
					}
				}
				
				tblProduceByHour = new TblProduceByHour(RobotNo, i, PassNum, productivity);
				tblProduceByHours.add(tblProduceByHour);
			}
			map.put("flag", "1");
			map.put("tblProduceByHours", tblProduceByHours);
			map.put("msg", msg);
		}
		return map;
	}
}
