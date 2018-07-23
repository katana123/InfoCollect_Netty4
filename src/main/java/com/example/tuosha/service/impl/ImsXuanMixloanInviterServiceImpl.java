package com.example.tuosha.service.impl;

import com.example.tuosha.service.ImsXuanMixloanInviterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.ImsXuanMixloanInviterDao;
import com.example.tuosha.model.ImsXuanMixloanInviterEntity;


@Service("imsXuanMixloanInviterServiceImpl")
public class ImsXuanMixloanInviterServiceImpl implements ImsXuanMixloanInviterService {
    @Autowired
    private ImsXuanMixloanInviterDao imsXuanMixloanInviterDao;

    @Override
    public ImsXuanMixloanInviterEntity queryObject(Integer id) {
        return imsXuanMixloanInviterDao.queryObject(id);
    }

    @Override
    public List<ImsXuanMixloanInviterEntity> queryList(Map<String, Object> map) {
        return imsXuanMixloanInviterDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return imsXuanMixloanInviterDao.queryTotal(map);
    }

    @Override
    public void save(ImsXuanMixloanInviterEntity imsXuanMixloanInviter) {
        imsXuanMixloanInviterDao.save(imsXuanMixloanInviter);
    }

    @Override
    public int update(ImsXuanMixloanInviterEntity imsXuanMixloanInviter) {
        return imsXuanMixloanInviterDao.update(imsXuanMixloanInviter);
    }

    @Override
    public int delete(Integer id) {
        return imsXuanMixloanInviterDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return imsXuanMixloanInviterDao.deleteBatch(ids);
    }

}
