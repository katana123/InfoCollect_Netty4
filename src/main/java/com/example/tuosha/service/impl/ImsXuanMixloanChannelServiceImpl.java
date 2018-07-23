package com.example.tuosha.service.impl;

import com.example.tuosha.service.ImsXuanMixloanChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.ImsXuanMixloanChannelDao;
import com.example.tuosha.model.ImsXuanMixloanChannelEntity;


@Service("imsXuanMixloanChannelServiceImpl")
public class ImsXuanMixloanChannelServiceImpl implements ImsXuanMixloanChannelService {
    @Autowired
    private ImsXuanMixloanChannelDao imsXuanMixloanChannelDao;

    @Override
    public ImsXuanMixloanChannelEntity queryObject(Integer id) {
        return imsXuanMixloanChannelDao.queryObject(id);
    }

    @Override
    public List<ImsXuanMixloanChannelEntity> queryList(Map<String, Object> map) {
        return imsXuanMixloanChannelDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return imsXuanMixloanChannelDao.queryTotal(map);
    }

    @Override
    public void save(ImsXuanMixloanChannelEntity imsXuanMixloanChannel) {
        imsXuanMixloanChannelDao.save(imsXuanMixloanChannel);
    }

    @Override
    public int update(ImsXuanMixloanChannelEntity imsXuanMixloanChannel) {
        return imsXuanMixloanChannelDao.update(imsXuanMixloanChannel);
    }

    @Override
    public int delete(Integer id) {
        return imsXuanMixloanChannelDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return imsXuanMixloanChannelDao.deleteBatch(ids);
    }

}
