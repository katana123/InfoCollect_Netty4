package com.example.tuosha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.DaikuansDao;
import com.example.tuosha.model.DaikuansEntity;
import com.example.tuosha.service.DaikuansService;



@Service("daikuansServiceImpl")
public class DaikuansServiceImpl implements DaikuansService {
	@Autowired
	private DaikuansDao daikuansDao;
	
	@Override
	public DaikuansEntity queryObject(Integer id){
		return daikuansDao.queryObject(id);
	}
	
	@Override
	public List<DaikuansEntity> queryList(Map<String, Object> map){
		return daikuansDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return daikuansDao.queryTotal(map);
	}
	
	@Override
	public void save(DaikuansEntity daikuans){
		daikuansDao.save(daikuans);
	}
	
	@Override
	public int update(DaikuansEntity daikuans){
		return daikuansDao.update(daikuans);
	}
	
	@Override
	public int delete(Integer id){
		return daikuansDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return daikuansDao.deleteBatch(ids);
	}
	
}
