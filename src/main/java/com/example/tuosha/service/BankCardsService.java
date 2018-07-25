package com.example.tuosha.service;

import com.example.tuosha.model.BankCardsEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-25 09:38:58
 */
public interface BankCardsService {
	
	BankCardsEntity queryObject(Integer id);
	
	List<BankCardsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BankCardsEntity bankCards);
	
	int update(BankCardsEntity bankCards);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);
}
