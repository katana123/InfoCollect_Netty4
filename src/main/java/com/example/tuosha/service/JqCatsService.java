package com.example.tuosha.service;

import com.example.tuosha.model.JqCatsEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-25 09:38:57
 */
public interface JqCatsService {
	
	JqCatsEntity queryObject(Integer id);
	
	List<JqCatsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(JqCatsEntity jqCats);
	
	int update(JqCatsEntity jqCats);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);
}
