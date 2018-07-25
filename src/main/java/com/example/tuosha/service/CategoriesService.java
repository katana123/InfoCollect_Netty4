package com.example.tuosha.service;

import com.example.tuosha.model.CategoriesEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-25 09:38:58
 */
public interface CategoriesService {
	
	CategoriesEntity queryObject(Integer id);
	
	List<CategoriesEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CategoriesEntity categories);
	
	int update(CategoriesEntity categories);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);
}
