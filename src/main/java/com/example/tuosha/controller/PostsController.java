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
import com.example.tuosha.model.PostsEntity;
import com.example.tuosha.service.PostsService;
 
/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-25 09:38:57
 */
@Controller
@RequestMapping("posts")
public class PostsController extends BaseController{
	@Autowired
	private PostsService postsServiceImpl;
	
	/**
	 * 页面
	 */
	@RequestMapping("/page")
	public String page(@RequestParam Map<String, Object> params){
		return "posts";
	}
	/**
	 * 列表
	 */
	@RequestMapping(value="/list", produces="text/html;charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public Object list(@RequestParam Map<String, Object> params){
	    Query query = new Query(params);
		List<PostsEntity> postsList = postsServiceImpl.queryList(query);
		int total = postsServiceImpl.queryTotal(query);
		return putMsgToJsonString(Constants.WebSite.SUCCESS,"",total,postsList);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping(value="/info/{id}", produces="text/html;charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public Object info(@PathVariable("id") Integer id){
		PostsEntity posts = postsServiceImpl.queryObject(id);
		return putMsgToJsonString(Constants.WebSite.SUCCESS,"",0,posts);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value="/save", produces="text/html;charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public Object save(@ModelAttribute PostsEntity posts){
		postsServiceImpl.save(posts);
		return putMsgToJsonString(Constants.WebSite.SUCCESS,"",0,posts);
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value="/update", produces="text/html;charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public Object update(@ModelAttribute PostsEntity posts){
		int result = postsServiceImpl.update(posts);
		return putMsgToJsonString(result,"",0,"");
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value="/delete", produces="text/html;charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public Object delete(@RequestParam Integer[] ids){
		int result = postsServiceImpl.deleteBatch(ids);
		return putMsgToJsonString(result,"",0,"");
	}
	
}
