package com.example.tuosha.service;

import com.example.tuosha.model.NoticesEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-25 09:38:57
 */
public interface NoticesService {
	
	NoticesEntity queryObject(Integer id);
	
	List<NoticesEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(NoticesEntity notices);
	
	int update(NoticesEntity notices);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);
}
