package com.example.tuosha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.OrdersDao;
import com.example.tuosha.model.OrdersEntity;
import com.example.tuosha.service.OrdersService;



@Service("ordersServiceImpl")
public class OrdersServiceImpl implements OrdersService {
	@Autowired
	private OrdersDao ordersDao;
	
	@Override
	public OrdersEntity queryObject(Integer id){
		return ordersDao.queryObject(id);
	}
	
	@Override
	public List<OrdersEntity> queryList(Map<String, Object> map){
		return ordersDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return ordersDao.queryTotal(map);
	}
	
	@Override
	public void save(OrdersEntity orders){
		ordersDao.save(orders);
	}
	
	@Override
	public int update(OrdersEntity orders){
		return ordersDao.update(orders);
	}
	
	@Override
	public int delete(Integer id){
		return ordersDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return ordersDao.deleteBatch(ids);
	}
	
}
