package com.example.tuosha.service;

import com.example.tuosha.model.MoneyRecordsEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-25 09:38:57
 */
public interface MoneyRecordsService {
	
	MoneyRecordsEntity queryObject(Integer id);
	
	List<MoneyRecordsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(MoneyRecordsEntity moneyRecords);
	
	int update(MoneyRecordsEntity moneyRecords);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);
}
