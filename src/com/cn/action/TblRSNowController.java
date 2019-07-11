package com.cn.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.biz.TblRSNowBiz;
import com.cn.entity.TblRSNow;
import com.cn.entity.TblRSSTime;

@Controller
@RequestMapping("/rsNow")
public class TblRSNowController {

	@Autowired
	private TblRSNowBiz tblRSNowBiz;
	
	
	
	@RequestMapping("/selectRSNow")
	public @ResponseBody Map selectRSNow( String apikey){
		
		Map map = new HashMap();
		List<TblRSNow> tblRSNows = null;
		if (!apikey.equals("nnjj_0944547748")) {
					
			map.put("flag", "0");
			map.put("msg", "∑«∑®«Î«Û£°");
		}else {
			tblRSNows = tblRSNowBiz.selectByRSNoweFun();
			
			map = new HashMap();
			
			map.put("flag", "1");
			map.put("tblRSNows", tblRSNows);
			
			
		}
		
		return map;
	}
}
