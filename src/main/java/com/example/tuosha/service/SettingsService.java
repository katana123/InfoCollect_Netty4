package com.example.tuosha.service;

import com.example.tuosha.model.SettingsEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-25 09:38:57
 */
public interface SettingsService {
	
	SettingsEntity queryObject(Integer id);
	
	List<SettingsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SettingsEntity settings);
	
	int update(SettingsEntity settings);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);
}
