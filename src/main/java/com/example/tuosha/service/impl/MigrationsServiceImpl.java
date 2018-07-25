package com.example.tuosha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.MigrationsDao;
import com.example.tuosha.model.MigrationsEntity;
import com.example.tuosha.service.MigrationsService;



@Service("migrationsServiceImpl")
public class MigrationsServiceImpl implements MigrationsService {
	@Autowired
	private MigrationsDao migrationsDao;
	
	@Override
	public MigrationsEntity queryObject(Integer id){
		return migrationsDao.queryObject(id);
	}
	
	@Override
	public List<MigrationsEntity> queryList(Map<String, Object> map){
		return migrationsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return migrationsDao.queryTotal(map);
	}
	
	@Override
	public void save(MigrationsEntity migrations){
		migrationsDao.save(migrations);
	}
	
	@Override
	public int update(MigrationsEntity migrations){
		return migrationsDao.update(migrations);
	}
	
	@Override
	public int delete(Integer id){
		return migrationsDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return migrationsDao.deleteBatch(ids);
	}
	
}
