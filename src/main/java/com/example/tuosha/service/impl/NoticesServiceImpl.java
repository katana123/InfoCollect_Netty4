package com.example.tuosha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.NoticesDao;
import com.example.tuosha.model.NoticesEntity;
import com.example.tuosha.service.NoticesService;



@Service("noticesServiceImpl")
public class NoticesServiceImpl implements NoticesService {
	@Autowired
	private NoticesDao noticesDao;
	
	@Override
	public NoticesEntity queryObject(Integer id){
		return noticesDao.queryObject(id);
	}
	
	@Override
	public List<NoticesEntity> queryList(Map<String, Object> map){
		return noticesDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return noticesDao.queryTotal(map);
	}
	
	@Override
	public void save(NoticesEntity notices){
		noticesDao.save(notices);
	}
	
	@Override
	public int update(NoticesEntity notices){
		return noticesDao.update(notices);
	}
	
	@Override
	public int delete(Integer id){
		return noticesDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return noticesDao.deleteBatch(ids);
	}
	
}
