package com.example.tuosha.service;

import com.example.tuosha.model.ImsXuanMixloanProductEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:30
 */
public interface ImsXuanMixloanProductService {

    ImsXuanMixloanProductEntity queryObject(Integer id);

    List<ImsXuanMixloanProductEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(ImsXuanMixloanProductEntity imsXuanMixloanProduct);

    int update(ImsXuanMixloanProductEntity imsXuanMixloanProduct);

    int delete(Integer id);

    int deleteBatch(Integer[] ids);

    ArrayList<ImsXuanMixloanProductEntity> queryProductDebitAll();

    ArrayList<ImsXuanMixloanProductEntity> queryProductBankAll();
}
