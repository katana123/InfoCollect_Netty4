package com.example.tuosha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.XykBannersDao;
import com.example.tuosha.model.XykBannersEntity;
import com.example.tuosha.service.XykBannersService;



@Service("xykBannersServiceImpl")
public class XykBannersServiceImpl implements XykBannersService {
	@Autowired
	private XykBannersDao xykBannersDao;
	
	@Override
	public XykBannersEntity queryObject(Integer id){
		return xykBannersDao.queryObject(id);
	}
	
	@Override
	public List<XykBannersEntity> queryList(Map<String, Object> map){
		return xykBannersDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return xykBannersDao.queryTotal(map);
	}
	
	@Override
	public void save(XykBannersEntity xykBanners){
		xykBannersDao.save(xykBanners);
	}
	
	@Override
	public int update(XykBannersEntity xykBanners){
		return xykBannersDao.update(xykBanners);
	}
	
	@Override
	public int delete(Integer id){
		return xykBannersDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return xykBannersDao.deleteBatch(ids);
	}
	
}
