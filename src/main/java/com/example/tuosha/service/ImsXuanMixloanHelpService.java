package com.example.tuosha.service;

import com.example.tuosha.model.ImsXuanMixloanHelpEntity;

import java.util.List;
import java.util.Map;

/**
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:30
 */
public interface ImsXuanMixloanHelpService {

    ImsXuanMixloanHelpEntity queryObject(Integer id);

    List<ImsXuanMixloanHelpEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(ImsXuanMixloanHelpEntity imsXuanMixloanHelp);

    int update(ImsXuanMixloanHelpEntity imsXuanMixloanHelp);

    int delete(Integer id);

    int deleteBatch(Integer[] ids);
}
