package com.example.tuosha.service;

import com.example.tuosha.model.ImsXuanMixloanChannelSubjectEntity;

import java.util.List;
import java.util.Map;

/**
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:31
 */
public interface ImsXuanMixloanChannelSubjectService {

    ImsXuanMixloanChannelSubjectEntity queryObject(Integer id);

    List<ImsXuanMixloanChannelSubjectEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(ImsXuanMixloanChannelSubjectEntity imsXuanMixloanChannelSubject);

    int update(ImsXuanMixloanChannelSubjectEntity imsXuanMixloanChannelSubject);

    int delete(Integer id);

    int deleteBatch(Integer[] ids);
}
