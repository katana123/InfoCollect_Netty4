package com.example.tuosha.service;

import com.example.tuosha.model.PasswordResetsEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-25 09:38:57
 */
public interface PasswordResetsService {
	
	PasswordResetsEntity queryObject(String email);
	
	List<PasswordResetsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(PasswordResetsEntity passwordResets);
	
	int update(PasswordResetsEntity passwordResets);
	
	int delete(String email);
	
	int deleteBatch(String[] emails);
}
