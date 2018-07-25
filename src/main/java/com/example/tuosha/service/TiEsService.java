package com.example.tuosha.service;

import com.example.tuosha.model.TiEsEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-25 09:38:57
 */
public interface TiEsService {
	
	TiEsEntity queryObject(Integer id);
	
	List<TiEsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TiEsEntity tiEs);
	
	int update(TiEsEntity tiEs);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);
}
