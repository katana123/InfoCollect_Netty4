package com.example.tuosha.service;

import com.example.tuosha.model.MigrationsEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-25 09:38:58
 */
public interface MigrationsService {
	
	MigrationsEntity queryObject(Integer id);
	
	List<MigrationsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(MigrationsEntity migrations);
	
	int update(MigrationsEntity migrations);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);
}
