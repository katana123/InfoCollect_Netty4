package com.example.tuosha.service;

import com.example.tuosha.model.ImsXuanMixloanCreditcardEntity;

import java.util.List;
import java.util.Map;

/**
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:31
 */
public interface ImsXuanMixloanCreditcardService {

    ImsXuanMixloanCreditcardEntity queryObject(Integer id);

    List<ImsXuanMixloanCreditcardEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(ImsXuanMixloanCreditcardEntity imsXuanMixloanCreditcard);

    int update(ImsXuanMixloanCreditcardEntity imsXuanMixloanCreditcard);

    int delete(Integer id);

    int deleteBatch(Integer[] ids);
}
