package com.example.tuosha.service;

import com.example.tuosha.model.DaikuansEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-25 09:38:58
 */
public interface DaikuansService {
	
	DaikuansEntity queryObject(Integer id);
	
	List<DaikuansEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(DaikuansEntity daikuans);
	
	int update(DaikuansEntity daikuans);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);
}
