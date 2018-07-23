package com.example.tuosha.service.impl;

import com.example.tuosha.service.ImsXuanMixloanCreditcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.ImsXuanMixloanCreditcardDao;
import com.example.tuosha.model.ImsXuanMixloanCreditcardEntity;


@Service("imsXuanMixloanCreditcardServiceImpl")
public class ImsXuanMixloanCreditcardServiceImpl implements ImsXuanMixloanCreditcardService {
    @Autowired
    private ImsXuanMixloanCreditcardDao imsXuanMixloanCreditcardDao;

    @Override
    public ImsXuanMixloanCreditcardEntity queryObject(Integer id) {
        return imsXuanMixloanCreditcardDao.queryObject(id);
    }

    @Override
    public List<ImsXuanMixloanCreditcardEntity> queryList(Map<String, Object> map) {
        return imsXuanMixloanCreditcardDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return imsXuanMixloanCreditcardDao.queryTotal(map);
    }

    @Override
    public void save(ImsXuanMixloanCreditcardEntity imsXuanMixloanCreditcard) {
        imsXuanMixloanCreditcardDao.save(imsXuanMixloanCreditcard);
    }

    @Override
    public int update(ImsXuanMixloanCreditcardEntity imsXuanMixloanCreditcard) {
        return imsXuanMixloanCreditcardDao.update(imsXuanMixloanCreditcard);
    }

    @Override
    public int delete(Integer id) {
        return imsXuanMixloanCreditcardDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return imsXuanMixloanCreditcardDao.deleteBatch(ids);
    }

}
