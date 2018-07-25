package com.example.tuosha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.XinYongKasDao;
import com.example.tuosha.model.XinYongKasEntity;
import com.example.tuosha.service.XinYongKasService;



@Service("xinYongKasServiceImpl")
public class XinYongKasServiceImpl implements XinYongKasService {
	@Autowired
	private XinYongKasDao xinYongKasDao;
	
	@Override
	public XinYongKasEntity queryObject(Integer id){
		return xinYongKasDao.queryObject(id);
	}
	
	@Override
	public List<XinYongKasEntity> queryList(Map<String, Object> map){
		return xinYongKasDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return xinYongKasDao.queryTotal(map);
	}
	
	@Override
	public void save(XinYongKasEntity xinYongKas){
		xinYongKasDao.save(xinYongKas);
	}
	
	@Override
	public int update(XinYongKasEntity xinYongKas){
		return xinYongKasDao.update(xinYongKas);
	}
	
	@Override
	public int delete(Integer id){
		return xinYongKasDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return xinYongKasDao.deleteBatch(ids);
	}
	
}
