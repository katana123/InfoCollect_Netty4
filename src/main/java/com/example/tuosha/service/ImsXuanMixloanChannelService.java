package com.example.tuosha.service;

import com.example.tuosha.model.ImsXuanMixloanChannelEntity;

import java.util.List;
import java.util.Map;

/**
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:31
 */
public interface ImsXuanMixloanChannelService {

    ImsXuanMixloanChannelEntity queryObject(Integer id);

    List<ImsXuanMixloanChannelEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(ImsXuanMixloanChannelEntity imsXuanMixloanChannel);

    int update(ImsXuanMixloanChannelEntity imsXuanMixloanChannel);

    int delete(Integer id);

    int deleteBatch(Integer[] ids);
}
