package com.example.tuosha.service.impl;

import com.example.tuosha.service.ImsXuanMixloanPosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.ImsXuanMixloanPosterDao;
import com.example.tuosha.model.ImsXuanMixloanPosterEntity;


@Service("imsXuanMixloanPosterServiceImpl")
public class ImsXuanMixloanPosterServiceImpl implements ImsXuanMixloanPosterService {
    @Autowired
    private ImsXuanMixloanPosterDao imsXuanMixloanPosterDao;

    @Override
    public ImsXuanMixloanPosterEntity queryObject(Integer id) {
        return imsXuanMixloanPosterDao.queryObject(id);
    }

    @Override
    public List<ImsXuanMixloanPosterEntity> queryList(Map<String, Object> map) {
        return imsXuanMixloanPosterDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return imsXuanMixloanPosterDao.queryTotal(map);
    }

    @Override
    public void save(ImsXuanMixloanPosterEntity imsXuanMixloanPoster) {
        imsXuanMixloanPosterDao.save(imsXuanMixloanPoster);
    }

    @Override
    public int update(ImsXuanMixloanPosterEntity imsXuanMixloanPoster) {
        return imsXuanMixloanPosterDao.update(imsXuanMixloanPoster);
    }

    @Override
    public int delete(Integer id) {
        return imsXuanMixloanPosterDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return imsXuanMixloanPosterDao.deleteBatch(ids);
    }

}
