package com.example.tuosha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.ProcessesDao;
import com.example.tuosha.model.ProcessesEntity;
import com.example.tuosha.service.ProcessesService;



@Service("processesServiceImpl")
public class ProcessesServiceImpl implements ProcessesService {
	@Autowired
	private ProcessesDao processesDao;
	
	@Override
	public ProcessesEntity queryObject(Integer id){
		return processesDao.queryObject(id);
	}
	
	@Override
	public List<ProcessesEntity> queryList(Map<String, Object> map){
		return processesDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return processesDao.queryTotal(map);
	}
	
	@Override
	public void save(ProcessesEntity processes){
		processesDao.save(processes);
	}
	
	@Override
	public int update(ProcessesEntity processes){
		return processesDao.update(processes);
	}
	
	@Override
	public int delete(Integer id){
		return processesDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return processesDao.deleteBatch(ids);
	}
	
}
