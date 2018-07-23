package com.example.tuosha.service;

import com.example.tuosha.model.ImsXuanMixloanPaymentEntity;

import java.util.List;
import java.util.Map;

/**
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:30
 */
public interface ImsXuanMixloanPaymentService {

    ImsXuanMixloanPaymentEntity queryObject(Integer id);

    List<ImsXuanMixloanPaymentEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(ImsXuanMixloanPaymentEntity imsXuanMixloanPayment);

    int update(ImsXuanMixloanPaymentEntity imsXuanMixloanPayment);

    int delete(Integer id);

    int deleteBatch(Integer[] ids);
}
