package com.example.tuosha.service;

import com.example.tuosha.model.HkjsEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-25 09:38:58
 */
public interface HkjsService {
	
	HkjsEntity queryObject(Integer id);
	
	List<HkjsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(HkjsEntity hkjs);
	
	int update(HkjsEntity hkjs);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);
}
