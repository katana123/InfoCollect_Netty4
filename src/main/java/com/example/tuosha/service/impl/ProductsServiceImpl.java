package com.example.tuosha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.ProductsDao;
import com.example.tuosha.model.ProductsEntity;
import com.example.tuosha.service.ProductsService;



@Service("productsServiceImpl")
public class ProductsServiceImpl implements ProductsService {
	@Autowired
	private ProductsDao productsDao;
	
	@Override
	public ProductsEntity queryObject(Integer id){
		return productsDao.queryObject(id);
	}
	
	@Override
	public List<ProductsEntity> queryList(Map<String, Object> map){
		return productsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return productsDao.queryTotal(map);
	}
	
	@Override
	public void save(ProductsEntity products){
		productsDao.save(products);
	}
	
	@Override
	public int update(ProductsEntity products){
		return productsDao.update(products);
	}
	
	@Override
	public int delete(Integer id){
		return productsDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return productsDao.deleteBatch(ids);
	}
	
}
