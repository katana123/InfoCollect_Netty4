package com.example.tuosha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.HkjBannersDao;
import com.example.tuosha.model.HkjBannersEntity;
import com.example.tuosha.service.HkjBannersService;



@Service("hkjBannersServiceImpl")
public class HkjBannersServiceImpl implements HkjBannersService {
	@Autowired
	private HkjBannersDao hkjBannersDao;
	
	@Override
	public HkjBannersEntity queryObject(Integer id){
		return hkjBannersDao.queryObject(id);
	}
	
	@Override
	public List<HkjBannersEntity> queryList(Map<String, Object> map){
		return hkjBannersDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return hkjBannersDao.queryTotal(map);
	}
	
	@Override
	public void save(HkjBannersEntity hkjBanners){
		hkjBannersDao.save(hkjBanners);
	}
	
	@Override
	public int update(HkjBannersEntity hkjBanners){
		return hkjBannersDao.update(hkjBanners);
	}
	
	@Override
	public int delete(Integer id){
		return hkjBannersDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return hkjBannersDao.deleteBatch(ids);
	}
	
}
