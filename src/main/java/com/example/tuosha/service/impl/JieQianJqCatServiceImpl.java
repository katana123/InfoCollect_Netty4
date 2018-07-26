package com.example.tuosha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.JieQianJqCatDao;
import com.example.tuosha.model.JieQianJqCatEntity;
import com.example.tuosha.service.JieQianJqCatService;



@Service("jieQianJqCatServiceImpl")
public class JieQianJqCatServiceImpl implements JieQianJqCatService {
	@Autowired
	private JieQianJqCatDao jieQianJqCatDao;


    @Override
	public JieQianJqCatEntity queryObject(Integer id){
		return jieQianJqCatDao.queryObject(id);
	}
	
	@Override
	public List<JieQianJqCatEntity> queryList(Map<String, Object> map){
		return jieQianJqCatDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return jieQianJqCatDao.queryTotal(map);
	}
	
	@Override
	public void save(JieQianJqCatEntity jieQianJqCat){
		jieQianJqCatDao.save(jieQianJqCat);
	}
	
	@Override
	public int update(JieQianJqCatEntity jieQianJqCat){
		return jieQianJqCatDao.update(jieQianJqCat);
	}
	
	@Override
	public int delete(Integer id){
		return jieQianJqCatDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return jieQianJqCatDao.deleteBatch(ids);
	}

}
