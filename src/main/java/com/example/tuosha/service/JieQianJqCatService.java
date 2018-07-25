package com.example.tuosha.service;

import com.example.tuosha.model.JieQianJqCatEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-25 09:38:58
 */
public interface JieQianJqCatService {
	
	JieQianJqCatEntity queryObject(Integer id);
	
	List<JieQianJqCatEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(JieQianJqCatEntity jieQianJqCat);
	
	int update(JieQianJqCatEntity jieQianJqCat);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);
}
