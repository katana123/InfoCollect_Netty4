package com.example.tuosha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.ToolsDao;
import com.example.tuosha.model.ToolsEntity;
import com.example.tuosha.service.ToolsService;



@Service("toolsServiceImpl")
public class ToolsServiceImpl implements ToolsService {
	@Autowired
	private ToolsDao toolsDao;
	
	@Override
	public ToolsEntity queryObject(Integer id){
		return toolsDao.queryObject(id);
	}
	
	@Override
	public List<ToolsEntity> queryList(Map<String, Object> map){
		return toolsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return toolsDao.queryTotal(map);
	}
	
	@Override
	public void save(ToolsEntity tools){
		toolsDao.save(tools);
	}
	
	@Override
	public int update(ToolsEntity tools){
		return toolsDao.update(tools);
	}
	
	@Override
	public int delete(Integer id){
		return toolsDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return toolsDao.deleteBatch(ids);
	}
	
}
