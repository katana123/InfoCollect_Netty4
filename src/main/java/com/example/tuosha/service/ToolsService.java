package com.example.tuosha.service;

import com.example.tuosha.model.ToolsEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-25 09:38:57
 */
public interface ToolsService {
	
	ToolsEntity queryObject(Integer id);
	
	List<ToolsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ToolsEntity tools);
	
	int update(ToolsEntity tools);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);
}
