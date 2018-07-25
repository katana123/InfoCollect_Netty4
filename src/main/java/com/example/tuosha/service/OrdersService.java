package com.example.tuosha.service;

import com.example.tuosha.model.OrdersEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-25 09:38:58
 */
public interface OrdersService {
	
	OrdersEntity queryObject(Integer id);
	
	List<OrdersEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(OrdersEntity orders);
	
	int update(OrdersEntity orders);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);
}
