package com.cn.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.biz.TblRSSTimeBiz;
import com.cn.entity.TblRSSTime;

@Controller
@RequestMapping("/rSSTime")
public class TblRSSTimeController {
		
		@Autowired
		private TblRSSTimeBiz tblRSSTimeBiz;
		
		/**
		 * 
		 * @param 
		 * @param 
		 * @return 返回任务集合，json数据
		 */
		@RequestMapping("/selectRSSTime")
		public @ResponseBody Map selectRSSTime( String apikey){
			
			Map map = new HashMap();
			List<TblRSSTime> tblRSSTimes = null;
			if (!apikey.equals("nnjj_0944547748")) {
						
				map.put("flag", "0");
				map.put("msg", "非法请求！");
			}else {
				tblRSSTimes = tblRSSTimeBiz.selectByRSSTimeFun();
				
				map = new HashMap();
				
				map.put("flag", "1");
				map.put("tblRSSTimes", tblRSSTimes);
				
				
			}
			
			return map;
		}
}
