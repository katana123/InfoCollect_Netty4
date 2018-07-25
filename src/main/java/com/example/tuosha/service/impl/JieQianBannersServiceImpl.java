package com.example.tuosha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.JieQianBannersDao;
import com.example.tuosha.model.JieQianBannersEntity;
import com.example.tuosha.service.JieQianBannersService;



@Service("jieQianBannersServiceImpl")
public class JieQianBannersServiceImpl implements JieQianBannersService {
	@Autowired
	private JieQianBannersDao jieQianBannersDao;
	
	@Override
	public JieQianBannersEntity queryObject(Integer id){
		return jieQianBannersDao.queryObject(id);
	}
	
	@Override
	public List<JieQianBannersEntity> queryList(Map<String, Object> map){
		return jieQianBannersDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return jieQianBannersDao.queryTotal(map);
	}
	
	@Override
	public void save(JieQianBannersEntity jieQianBanners){
		jieQianBannersDao.save(jieQianBanners);
	}
	
	@Override
	public int update(JieQianBannersEntity jieQianBanners){
		return jieQianBannersDao.update(jieQianBanners);
	}
	
	@Override
	public int delete(Integer id){
		return jieQianBannersDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return jieQianBannersDao.deleteBatch(ids);
	}
	
}
