package com.example.tuosha.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import com.example.tuosha.constant.Constants;
import com.example.tuosha.Util.Query;
import com.example.tuosha.base.controller.BaseController;
import com.example.tuosha.model.PasswordResetsEntity;
import com.example.tuosha.service.PasswordResetsService;
 
/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-25 09:38:57
 */
@Controller
@RequestMapping("passwordresets")
public class PasswordResetsController extends BaseController{
	@Autowired
	private PasswordResetsService passwordResetsServiceImpl;
	
	/**
	 * 页面
	 */
	@RequestMapping("/page")
	public String page(@RequestParam Map<String, Object> params){
		return "passwordresets";
	}
	/**
	 * 列表
	 */
	@RequestMapping(value="/list", produces="text/html;charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public Object list(@RequestParam Map<String, Object> params){
	    Query query = new Query(params);
		List<PasswordResetsEntity> passwordResetsList = passwordResetsServiceImpl.queryList(query);
		int total = passwordResetsServiceImpl.queryTotal(query);
		return putMsgToJsonString(Constants.WebSite.SUCCESS,"",total,passwordResetsList);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping(value="/info/{email}", produces="text/html;charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public Object info(@PathVariable("email") String email){
		PasswordResetsEntity passwordResets = passwordResetsServiceImpl.queryObject(email);
		return putMsgToJsonString(Constants.WebSite.SUCCESS,"",0,passwordResets);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value="/save", produces="text/html;charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public Object save(@ModelAttribute PasswordResetsEntity passwordResets){
		passwordResetsServiceImpl.save(passwordResets);
		return putMsgToJsonString(Constants.WebSite.SUCCESS,"",0,passwordResets);
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value="/update", produces="text/html;charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public Object update(@ModelAttribute PasswordResetsEntity passwordResets){
		int result = passwordResetsServiceImpl.update(passwordResets);
		return putMsgToJsonString(result,"",0,"");
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value="/delete", produces="text/html;charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public Object delete(@RequestParam String[] emails){
		int result = passwordResetsServiceImpl.deleteBatch(emails);
		return putMsgToJsonString(result,"",0,"");
	}
	
}
