package com.example.tuosha.service;

import com.example.tuosha.model.ProductsEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-25 09:38:57
 */
public interface ProductsService {
	
	ProductsEntity queryObject(Integer id);
	
	List<ProductsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ProductsEntity products);
	
	int update(ProductsEntity products);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);
}
