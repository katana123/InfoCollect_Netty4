package com.example.tuosha.service;

import com.example.tuosha.model.EDusEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-25 09:38:58
 */
public interface EDusService {
	
	EDusEntity queryObject(Integer id);
	
	List<EDusEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(EDusEntity eDus);
	
	int update(EDusEntity eDus);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);
}
