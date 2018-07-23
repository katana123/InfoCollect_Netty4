package com.example.tuosha.service;

import com.example.tuosha.model.ImsXuanMixloanLoanEntity;

import java.util.List;
import java.util.Map;

/**
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:30
 */
public interface ImsXuanMixloanLoanService {

    ImsXuanMixloanLoanEntity queryObject(Integer id);

    List<ImsXuanMixloanLoanEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(ImsXuanMixloanLoanEntity imsXuanMixloanLoan);

    int update(ImsXuanMixloanLoanEntity imsXuanMixloanLoan);

    int delete(Integer id);

    int deleteBatch(Integer[] ids);
}
