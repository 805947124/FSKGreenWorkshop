package com.cn.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.biz.TblCustomerBiz;
import com.cn.biz.TblModelTypeBiz;
import com.cn.entity.TblCustomer;
import com.cn.entity.TblModelType;

@Controller
@RequestMapping("/condition")
public class TblConditionController {

	@Autowired
	private TblModelTypeBiz tblModelTypeBiz;
	@Autowired
	private TblCustomerBiz tblCustomerBiz;
	
	/**
	 * 查询所有机种及手臂编号
	 * @param apikey
	 * @return
	 */
	@RequestMapping("/selectCondition")
	public @ResponseBody Map selectCondition(String apikey){
		
		Map map = new HashMap();
		List<TblCustomer> tblCustomers = null;
		List<TblModelType> tblModelTypes = null;
		if (!apikey.equals("nnjj_0944547748")) {
					
			map.put("flag", "0");
			map.put("msg", "非法请求！");
		}else {
			tblCustomers = tblCustomerBiz.selectAllFun();
			tblModelTypes = tblModelTypeBiz.selectAllFun();
			
			map.put("flag", "1");
			map.put("tblCustomers", tblCustomers);
			map.put("tblModelTypes", tblModelTypes);
			
		}
		
		return map;
	}
}
