package com.example.tuosha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.CategoriesDao;
import com.example.tuosha.model.CategoriesEntity;
import com.example.tuosha.service.CategoriesService;



@Service("categoriesServiceImpl")
public class CategoriesServiceImpl implements CategoriesService {
	@Autowired
	private CategoriesDao categoriesDao;
	
	@Override
	public CategoriesEntity queryObject(Integer id){
		return categoriesDao.queryObject(id);
	}
	
	@Override
	public List<CategoriesEntity> queryList(Map<String, Object> map){
		return categoriesDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return categoriesDao.queryTotal(map);
	}
	
	@Override
	public void save(CategoriesEntity categories){
		categoriesDao.save(categories);
	}
	
	@Override
	public int update(CategoriesEntity categories){
		return categoriesDao.update(categories);
	}
	
	@Override
	public int delete(Integer id){
		return categoriesDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return categoriesDao.deleteBatch(ids);
	}
}
