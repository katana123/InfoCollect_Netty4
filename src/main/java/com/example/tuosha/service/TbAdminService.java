package com.example.tuosha.service;

import com.example.tuosha.model.TbAdminEntity;

import java.util.List;
import java.util.Map;

/**
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:31
 */
public interface TbAdminService {

    TbAdminEntity queryObject(Long id);

    List<TbAdminEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(TbAdminEntity tbAdmin);

    int update(TbAdminEntity tbAdmin);

    int delete(Long id);

    int deleteBatch(Long[] ids);
}
