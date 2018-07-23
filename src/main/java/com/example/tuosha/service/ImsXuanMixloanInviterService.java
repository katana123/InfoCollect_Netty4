package com.example.tuosha.service;

import com.example.tuosha.model.ImsXuanMixloanInviterEntity;

import java.util.List;
import java.util.Map;

/**
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:30
 */
public interface ImsXuanMixloanInviterService {

    ImsXuanMixloanInviterEntity queryObject(Integer id);

    List<ImsXuanMixloanInviterEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(ImsXuanMixloanInviterEntity imsXuanMixloanInviter);

    int update(ImsXuanMixloanInviterEntity imsXuanMixloanInviter);

    int delete(Integer id);

    int deleteBatch(Integer[] ids);
}
