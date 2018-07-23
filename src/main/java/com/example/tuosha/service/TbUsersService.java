package com.example.tuosha.service;

import com.example.tuosha.model.TbUsersEntity;

import java.util.List;
import java.util.Map;

/**
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:31
 */
public interface TbUsersService {

    TbUsersEntity queryObject(Long uid);

    List<TbUsersEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(TbUsersEntity tbUsers);

    int update(TbUsersEntity tbUsers);

    int delete(Long uid);

    int deleteBatch(Long[] uids);
}
