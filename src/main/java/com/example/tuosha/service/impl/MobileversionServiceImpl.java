package com.example.tuosha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.MobileversionDao;
import com.example.tuosha.model.MobileversionEntity;
import com.example.tuosha.service.MobileversionService;



@Service("mobileversionServiceImpl")
public class MobileversionServiceImpl implements MobileversionService {
	@Autowired
	private MobileversionDao mobileversionDao;
	
	@Override
	public MobileversionEntity queryObject(Integer id){
		return mobileversionDao.queryObject(id);
	}
	
	@Override
	public List<MobileversionEntity> queryList(Map<String, Object> map){
		return mobileversionDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return mobileversionDao.queryTotal(map);
	}
	
	@Override
	public void save(MobileversionEntity mobileversion){
		mobileversionDao.save(mobileversion);
	}
	
	@Override
	public int update(MobileversionEntity mobileversion){
		return mobileversionDao.update(mobileversion);
	}
	
	@Override
	public int delete(Integer id){
		return mobileversionDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return mobileversionDao.deleteBatch(ids);
	}
	
}
