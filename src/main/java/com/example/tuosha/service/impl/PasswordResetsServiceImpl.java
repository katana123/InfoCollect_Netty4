package com.example.tuosha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.PasswordResetsDao;
import com.example.tuosha.model.PasswordResetsEntity;
import com.example.tuosha.service.PasswordResetsService;



@Service("passwordResetsServiceImpl")
public class PasswordResetsServiceImpl implements PasswordResetsService {
	@Autowired
	private PasswordResetsDao passwordResetsDao;
	
	@Override
	public PasswordResetsEntity queryObject(String email){
		return passwordResetsDao.queryObject(email);
	}
	
	@Override
	public List<PasswordResetsEntity> queryList(Map<String, Object> map){
		return passwordResetsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return passwordResetsDao.queryTotal(map);
	}
	
	@Override
	public void save(PasswordResetsEntity passwordResets){
		passwordResetsDao.save(passwordResets);
	}
	
	@Override
	public int update(PasswordResetsEntity passwordResets){
		return passwordResetsDao.update(passwordResets);
	}
	
	@Override
	public int delete(String email){
		return passwordResetsDao.delete(email);
	}
	
	@Override
	public int deleteBatch(String[] emails){
		return passwordResetsDao.deleteBatch(emails);
	}
	
}
