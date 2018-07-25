package com.example.tuosha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.AlipayDao;
import com.example.tuosha.model.AlipayEntity;
import com.example.tuosha.service.AlipayService;



@Service("alipayServiceImpl")
public class AlipayServiceImpl implements AlipayService {
	@Autowired
	private AlipayDao alipayDao;
	
	@Override
	public AlipayEntity queryObject(Integer id){
		return alipayDao.queryObject(id);
	}
	
	@Override
	public List<AlipayEntity> queryList(Map<String, Object> map){
		return alipayDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return alipayDao.queryTotal(map);
	}
	
	@Override
	public void save(AlipayEntity alipay){
		alipayDao.save(alipay);
	}
	
	@Override
	public int update(AlipayEntity alipay){
		return alipayDao.update(alipay);
	}
	
	@Override
	public int delete(Integer id){
		return alipayDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return alipayDao.deleteBatch(ids);
	}
	
}
