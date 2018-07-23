package com.example.tuosha.service;

import com.example.tuosha.model.ImsXuanMixloanBankEntity;

import java.util.List;
import java.util.Map;

/**
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:31
 */
public interface ImsXuanMixloanBankService {

    ImsXuanMixloanBankEntity queryObject(Integer id);

    List<ImsXuanMixloanBankEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(ImsXuanMixloanBankEntity imsXuanMixloanBank);

    int update(ImsXuanMixloanBankEntity imsXuanMixloanBank);

    int delete(Integer id);

    int deleteBatch(Integer[] ids);
}
