package com.example.tuosha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.PostsDao;
import com.example.tuosha.model.PostsEntity;
import com.example.tuosha.service.PostsService;



@Service("postsServiceImpl")
public class PostsServiceImpl implements PostsService {
	@Autowired
	private PostsDao postsDao;
	
	@Override
	public PostsEntity queryObject(Integer id){
		return postsDao.queryObject(id);
	}
	
	@Override
	public List<PostsEntity> queryList(Map<String, Object> map){
		return postsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return postsDao.queryTotal(map);
	}
	
	@Override
	public void save(PostsEntity posts){
		postsDao.save(posts);
	}
	
	@Override
	public int update(PostsEntity posts){
		return postsDao.update(posts);
	}
	
	@Override
	public int delete(Integer id){
		return postsDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return postsDao.deleteBatch(ids);
	}
	
}
