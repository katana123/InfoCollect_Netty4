package com.example.tuosha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.UsersDao;
import com.example.tuosha.model.UsersEntity;
import com.example.tuosha.service.UsersService;



@Service("usersServiceImpl")
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersDao usersDao;
	
	@Override
	public UsersEntity queryObject(Integer id){
		return usersDao.queryObject(id);
	}
	
	@Override
	public List<UsersEntity> queryList(Map<String, Object> map){
		return usersDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return usersDao.queryTotal(map);
	}
	
	@Override
	public void save(UsersEntity users){
		usersDao.save(users);
	}
	
	@Override
	public int update(UsersEntity users){
		return usersDao.update(users);
	}
	
	@Override
	public int delete(Integer id){
		return usersDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return usersDao.deleteBatch(ids);
	}
	
}
