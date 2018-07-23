package com.example.tuosha.service;

import com.example.tuosha.model.ImsXuanMixloanBankCardEntity;

import java.util.List;
import java.util.Map;

/**
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:31
 */
public interface ImsXuanMixloanBankCardService {

    ImsXuanMixloanBankCardEntity queryObject(Integer id);

    List<ImsXuanMixloanBankCardEntity> queryList(Map<String, Object> map);

    List<ImsXuanMixloanBankCardEntity> queryListAll();

    List<ImsXuanMixloanBankCardEntity> queryDebitAll();

    int queryTotal(Map<String, Object> map);

    void save(ImsXuanMixloanBankCardEntity imsXuanMixloanBankCard);

    int update(ImsXuanMixloanBankCardEntity imsXuanMixloanBankCard);

    int delete(Integer id);

    int deleteBatch(Integer[] ids);


}
