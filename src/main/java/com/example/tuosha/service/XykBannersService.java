package com.example.tuosha.service;

import com.example.tuosha.model.XykBannersEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-25 09:38:57
 */
public interface XykBannersService {
	
	XykBannersEntity queryObject(Integer id);
	
	List<XykBannersEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(XykBannersEntity xykBanners);
	
	int update(XykBannersEntity xykBanners);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);
}
