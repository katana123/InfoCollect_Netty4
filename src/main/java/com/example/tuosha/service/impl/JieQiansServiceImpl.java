package com.example.tuosha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.JieQiansDao;
import com.example.tuosha.model.JieQiansEntity;
import com.example.tuosha.service.JieQiansService;



@Service("jieQiansServiceImpl")
public class JieQiansServiceImpl implements JieQiansService {
	@Autowired
	private JieQiansDao jieQiansDao;
	
	@Override
	public JieQiansEntity queryObject(Integer id){
		return jieQiansDao.queryObject(id);
	}
	
	@Override
	public List<JieQiansEntity> queryList(Map<String, Object> map){
		return jieQiansDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return jieQiansDao.queryTotal(map);
	}
	
	@Override
	public void save(JieQiansEntity jieQians){
		jieQiansDao.save(jieQians);
	}
	
	@Override
	public int update(JieQiansEntity jieQians){
		return jieQiansDao.update(jieQians);
	}
	
	@Override
	public int delete(Integer id){
		return jieQiansDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return jieQiansDao.deleteBatch(ids);
	}
	
}
