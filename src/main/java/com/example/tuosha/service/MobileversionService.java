package com.example.tuosha.service;

import com.example.tuosha.model.MobileversionEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-25 09:38:57
 */
public interface MobileversionService {
	
	MobileversionEntity queryObject(Integer id);
	
	List<MobileversionEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(MobileversionEntity mobileversion);
	
	int update(MobileversionEntity mobileversion);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);
}
