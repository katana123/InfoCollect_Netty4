package com.example.tuosha.service;

import com.example.tuosha.model.TbRolesMenusEntity;

import java.util.List;
import java.util.Map;

/**
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:31
 */
public interface TbRolesMenusService {

    TbRolesMenusEntity queryObject(Long menuId);

    List<TbRolesMenusEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(TbRolesMenusEntity tbRolesMenus);

    int update(TbRolesMenusEntity tbRolesMenus);

    int delete(Long menuId);

    int deleteBatch(Long[] menuIds);
}
