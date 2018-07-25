package com.example.tuosha.service;

import com.example.tuosha.model.ProcessesEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-25 09:38:57
 */
public interface ProcessesService {
	
	ProcessesEntity queryObject(Integer id);
	
	List<ProcessesEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ProcessesEntity processes);
	
	int update(ProcessesEntity processes);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);
}
