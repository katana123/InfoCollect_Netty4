package com.example.tuosha.service;

import com.example.tuosha.model.TbMenusEntity;

import java.util.List;
import java.util.Map;

/**
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:31
 */
public interface TbMenusService {

    TbMenusEntity queryObject(Long menuId);

    List<TbMenusEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(TbMenusEntity tbMenus);

    int update(TbMenusEntity tbMenus);

    int delete(Long menuId);

    int deleteBatch(Long[] menuIds);
}
