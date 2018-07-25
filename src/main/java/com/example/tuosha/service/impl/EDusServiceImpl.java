package com.example.tuosha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.EDusDao;
import com.example.tuosha.model.EDusEntity;
import com.example.tuosha.service.EDusService;



@Service("eDusServiceImpl")
public class EDusServiceImpl implements EDusService {
	@Autowired
	private EDusDao eDusDao;
	
	@Override
	public EDusEntity queryObject(Integer id){
		return eDusDao.queryObject(id);
	}
	
	@Override
	public List<EDusEntity> queryList(Map<String, Object> map){
		return eDusDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return eDusDao.queryTotal(map);
	}
	
	@Override
	public void save(EDusEntity eDus){
		eDusDao.save(eDus);
	}
	
	@Override
	public int update(EDusEntity eDus){
		return eDusDao.update(eDus);
	}
	
	@Override
	public int delete(Integer id){
		return eDusDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return eDusDao.deleteBatch(ids);
	}
	
}
