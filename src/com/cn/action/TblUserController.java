package com.cn.action;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.biz.TblUserBiz;
import com.cn.entity.TblRSByHour;
import com.cn.entity.TblUser;
import com.cn.tool.StrCustomerName;
import com.cn.util.TblUserBean;

@Controller
@RequestMapping("/tblUser")
public class TblUserController {
	
	@Autowired
	private TblUserBiz tblUserBiz;
	
	@RequestMapping("/userLogin")
	public @ResponseBody Map userLogin(String apikey,String jobnumber,String pwd){
		
		Map map = new HashMap();
		TblUser tblUser = null;
		String msg = "";
		TblUserBean<String> tblUserBean = new TblUserBean<String>();
		StrCustomerName strCustomerName = new StrCustomerName();
		if (!apikey.equals("nnjj_0944547748")) {
			msg="非法请求";
			map.put("flag", "0");
			map.put("msg", msg);
		}else {
			
			try {
				jobnumber = new String(jobnumber.getBytes("ISO-8859-1"), "utf-8");
				pwd = new String(pwd.getBytes("ISO-8859-1"), "utf-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			tblUser = tblUserBiz.selectByUserNameFun(jobnumber,pwd);
			if (tblUser==null) {
				msg="登陆失败";
				map.put("flag", "2");
				map.put("msg", msg);
			}else {
				tblUserBean = strCustomerName.strCustomerNameList(tblUser);
				map.put("flag", "1");
				msg = "登陆成功";
				map.put("msg", msg);
				map.put("tblUserBean", tblUserBean);
			}
			
			
		}
		return map;
	}

}
