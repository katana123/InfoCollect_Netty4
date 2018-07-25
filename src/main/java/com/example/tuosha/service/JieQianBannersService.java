package com.example.tuosha.service;

import com.example.tuosha.model.JieQianBannersEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-25 09:38:57
 */
public interface JieQianBannersService {
	
	JieQianBannersEntity queryObject(Integer id);
	
	List<JieQianBannersEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(JieQianBannersEntity jieQianBanners);
	
	int update(JieQianBannersEntity jieQianBanners);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);
}
