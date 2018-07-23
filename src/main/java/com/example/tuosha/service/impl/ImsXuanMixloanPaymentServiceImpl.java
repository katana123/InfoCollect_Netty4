package com.example.tuosha.service.impl;

import com.example.tuosha.service.ImsXuanMixloanPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.ImsXuanMixloanPaymentDao;
import com.example.tuosha.model.ImsXuanMixloanPaymentEntity;


@Service("imsXuanMixloanPaymentServiceImpl")
public class ImsXuanMixloanPaymentServiceImpl implements ImsXuanMixloanPaymentService {
    @Autowired
    private ImsXuanMixloanPaymentDao imsXuanMixloanPaymentDao;

    @Override
    public ImsXuanMixloanPaymentEntity queryObject(Integer id) {
        return imsXuanMixloanPaymentDao.queryObject(id);
    }

    @Override
    public List<ImsXuanMixloanPaymentEntity> queryList(Map<String, Object> map) {
        return imsXuanMixloanPaymentDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return imsXuanMixloanPaymentDao.queryTotal(map);
    }

    @Override
    public void save(ImsXuanMixloanPaymentEntity imsXuanMixloanPayment) {
        imsXuanMixloanPaymentDao.save(imsXuanMixloanPayment);
    }

    @Override
    public int update(ImsXuanMixloanPaymentEntity imsXuanMixloanPayment) {
        return imsXuanMixloanPaymentDao.update(imsXuanMixloanPayment);
    }

    @Override
    public int delete(Integer id) {
        return imsXuanMixloanPaymentDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return imsXuanMixloanPaymentDao.deleteBatch(ids);
    }

}
