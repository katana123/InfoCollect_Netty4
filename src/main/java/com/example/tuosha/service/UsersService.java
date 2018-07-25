package com.example.tuosha.service;

import com.example.tuosha.model.UsersEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-25 09:38:57
 */
public interface UsersService {
	
	UsersEntity queryObject(Integer id);
	
	List<UsersEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(UsersEntity users);
	
	int update(UsersEntity users);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);
}
