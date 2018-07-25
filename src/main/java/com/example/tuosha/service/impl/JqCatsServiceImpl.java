package com.example.tuosha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.JqCatsDao;
import com.example.tuosha.model.JqCatsEntity;
import com.example.tuosha.service.JqCatsService;



@Service("jqCatsServiceImpl")
public class JqCatsServiceImpl implements JqCatsService {
	@Autowired
	private JqCatsDao jqCatsDao;
	
	@Override
	public JqCatsEntity queryObject(Integer id){
		return jqCatsDao.queryObject(id);
	}
	
	@Override
	public List<JqCatsEntity> queryList(Map<String, Object> map){
		return jqCatsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return jqCatsDao.queryTotal(map);
	}
	
	@Override
	public void save(JqCatsEntity jqCats){
		jqCatsDao.save(jqCats);
	}
	
	@Override
	public int update(JqCatsEntity jqCats){
		return jqCatsDao.update(jqCats);
	}
	
	@Override
	public int delete(Integer id){
		return jqCatsDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return jqCatsDao.deleteBatch(ids);
	}
	
}
