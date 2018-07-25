package com.example.tuosha.service;

import com.example.tuosha.model.XinYongKasEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-25 09:38:57
 */
public interface XinYongKasService {
	
	XinYongKasEntity queryObject(Integer id);
	
	List<XinYongKasEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(XinYongKasEntity xinYongKas);
	
	int update(XinYongKasEntity xinYongKas);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);
}
