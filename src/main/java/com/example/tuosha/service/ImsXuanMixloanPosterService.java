package com.example.tuosha.service;

import com.example.tuosha.model.ImsXuanMixloanPosterEntity;

import java.util.List;
import java.util.Map;

/**
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:30
 */
public interface ImsXuanMixloanPosterService {

    ImsXuanMixloanPosterEntity queryObject(Integer id);

    List<ImsXuanMixloanPosterEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(ImsXuanMixloanPosterEntity imsXuanMixloanPoster);

    int update(ImsXuanMixloanPosterEntity imsXuanMixloanPoster);

    int delete(Integer id);

    int deleteBatch(Integer[] ids);
}
