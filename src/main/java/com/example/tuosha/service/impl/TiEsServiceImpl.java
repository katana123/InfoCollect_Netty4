package com.example.tuosha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.TiEsDao;
import com.example.tuosha.model.TiEsEntity;
import com.example.tuosha.service.TiEsService;



@Service("tiEsServiceImpl")
public class TiEsServiceImpl implements TiEsService {
	@Autowired
	private TiEsDao tiEsDao;
	
	@Override
	public TiEsEntity queryObject(Integer id){
		return tiEsDao.queryObject(id);
	}
	
	@Override
	public List<TiEsEntity> queryList(Map<String, Object> map){
		return tiEsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tiEsDao.queryTotal(map);
	}
	
	@Override
	public void save(TiEsEntity tiEs){
		tiEsDao.save(tiEs);
	}
	
	@Override
	public int update(TiEsEntity tiEs){
		return tiEsDao.update(tiEs);
	}
	
	@Override
	public int delete(Integer id){
		return tiEsDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return tiEsDao.deleteBatch(ids);
	}
	
}
