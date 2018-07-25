package com.example.tuosha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.SettingsDao;
import com.example.tuosha.model.SettingsEntity;
import com.example.tuosha.service.SettingsService;



@Service("settingsServiceImpl")
public class SettingsServiceImpl implements SettingsService {
	@Autowired
	private SettingsDao settingsDao;
	
	@Override
	public SettingsEntity queryObject(Integer id){
		return settingsDao.queryObject(id);
	}
	
	@Override
	public List<SettingsEntity> queryList(Map<String, Object> map){
		return settingsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return settingsDao.queryTotal(map);
	}
	
	@Override
	public void save(SettingsEntity settings){
		settingsDao.save(settings);
	}
	
	@Override
	public int update(SettingsEntity settings){
		return settingsDao.update(settings);
	}
	
	@Override
	public int delete(Integer id){
		return settingsDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return settingsDao.deleteBatch(ids);
	}
	
}
