package com.example.tuosha.dao;

import com.example.tuosha.model.ImsXuanMixloanBankEntity;
import com.example.tuosha.base.dao.BaseDao;

import java.util.ArrayList;

/**
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:31
 */
public interface ImsXuanMixloanBankDao extends BaseDao<ImsXuanMixloanBankEntity> {
    ArrayList<ImsXuanMixloanBankEntity> queryListAll();
}
