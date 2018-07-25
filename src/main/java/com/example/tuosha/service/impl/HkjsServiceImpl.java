package com.example.tuosha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.HkjsDao;
import com.example.tuosha.model.HkjsEntity;
import com.example.tuosha.service.HkjsService;



@Service("hkjsServiceImpl")
public class HkjsServiceImpl implements HkjsService {
	@Autowired
	private HkjsDao hkjsDao;
	
	@Override
	public HkjsEntity queryObject(Integer id){
		return hkjsDao.queryObject(id);
	}
	
	@Override
	public List<HkjsEntity> queryList(Map<String, Object> map){
		return hkjsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return hkjsDao.queryTotal(map);
	}
	
	@Override
	public void save(HkjsEntity hkjs){
		hkjsDao.save(hkjs);
	}
	
	@Override
	public int update(HkjsEntity hkjs){
		return hkjsDao.update(hkjs);
	}
	
	@Override
	public int delete(Integer id){
		return hkjsDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return hkjsDao.deleteBatch(ids);
	}
	
}
