package com.example.tuosha.service;

import com.example.tuosha.model.AlipayEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-25 09:38:58
 */
public interface AlipayService {
	
	AlipayEntity queryObject(Integer id);
	
	List<AlipayEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AlipayEntity alipay);
	
	int update(AlipayEntity alipay);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);
}
