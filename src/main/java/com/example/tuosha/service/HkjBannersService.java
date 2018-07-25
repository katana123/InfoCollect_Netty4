package com.example.tuosha.service;

import com.example.tuosha.model.HkjBannersEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-25 09:38:58
 */
public interface HkjBannersService {
	
	HkjBannersEntity queryObject(Integer id);
	
	List<HkjBannersEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(HkjBannersEntity hkjBanners);
	
	int update(HkjBannersEntity hkjBanners);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);
}
