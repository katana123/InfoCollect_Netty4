package com.example.tuosha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.BankCardsDao;
import com.example.tuosha.model.BankCardsEntity;
import com.example.tuosha.service.BankCardsService;



@Service("bankCardsServiceImpl")
public class BankCardsServiceImpl implements BankCardsService {
	@Autowired
	private BankCardsDao bankCardsDao;
	
	@Override
	public BankCardsEntity queryObject(Integer id){
		return bankCardsDao.queryObject(id);
	}
	
	@Override
	public List<BankCardsEntity> queryList(Map<String, Object> map){
		return bankCardsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return bankCardsDao.queryTotal(map);
	}
	
	@Override
	public void save(BankCardsEntity bankCards){
		bankCardsDao.save(bankCards);
	}
	
	@Override
	public int update(BankCardsEntity bankCards){
		return bankCardsDao.update(bankCards);
	}
	
	@Override
	public int delete(Integer id){
		return bankCardsDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return bankCardsDao.deleteBatch(ids);
	}
	
}
