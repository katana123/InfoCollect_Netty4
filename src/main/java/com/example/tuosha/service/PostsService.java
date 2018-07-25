package com.example.tuosha.service;

import com.example.tuosha.model.PostsEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-25 09:38:57
 */
public interface PostsService {
	
	PostsEntity queryObject(Integer id);
	
	List<PostsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(PostsEntity posts);
	
	int update(PostsEntity posts);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);
}
