package com.example.tuosha.service;

import com.example.tuosha.model.JieQiansEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-25 09:38:58
 */
public interface JieQiansService {
	
	JieQiansEntity queryObject(Integer id);
	
	List<JieQiansEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(JieQiansEntity jieQians);
	
	int update(JieQiansEntity jieQians);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);
}
