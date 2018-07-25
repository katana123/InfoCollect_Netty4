package com.example.tuosha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.MoneyRecordsDao;
import com.example.tuosha.model.MoneyRecordsEntity;
import com.example.tuosha.service.MoneyRecordsService;



@Service("moneyRecordsServiceImpl")
public class MoneyRecordsServiceImpl implements MoneyRecordsService {
	@Autowired
	private MoneyRecordsDao moneyRecordsDao;
	
	@Override
	public MoneyRecordsEntity queryObject(Integer id){
		return moneyRecordsDao.queryObject(id);
	}
	
	@Override
	public List<MoneyRecordsEntity> queryList(Map<String, Object> map){
		return moneyRecordsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return moneyRecordsDao.queryTotal(map);
	}
	
	@Override
	public void save(MoneyRecordsEntity moneyRecords){
		moneyRecordsDao.save(moneyRecords);
	}
	
	@Override
	public int update(MoneyRecordsEntity moneyRecords){
		return moneyRecordsDao.update(moneyRecords);
	}
	
	@Override
	public int delete(Integer id){
		return moneyRecordsDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return moneyRecordsDao.deleteBatch(ids);
	}
	
}
