package com.example.tuosha.service;

import com.example.tuosha.model.TbRolesEntity;

import java.util.List;
import java.util.Map;

/**
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:31
 */
public interface TbRolesService {

    TbRolesEntity queryObject(Long roleId);

    List<TbRolesEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(TbRolesEntity tbRoles);

    int update(TbRolesEntity tbRoles);

    int delete(Long roleId);

    int deleteBatch(Long[] roleIds);
}
