package com.example.tuosha.service.impl;

import com.example.tuosha.service.ImsXuanMixloanChannelSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.ImsXuanMixloanChannelSubjectDao;
import com.example.tuosha.model.ImsXuanMixloanChannelSubjectEntity;


@Service("imsXuanMixloanChannelSubjectServiceImpl")
public class ImsXuanMixloanChannelSubjectServiceImpl implements ImsXuanMixloanChannelSubjectService {
    @Autowired
    private ImsXuanMixloanChannelSubjectDao imsXuanMixloanChannelSubjectDao;

    @Override
    public ImsXuanMixloanChannelSubjectEntity queryObject(Integer id) {
        return imsXuanMixloanChannelSubjectDao.queryObject(id);
    }

    @Override
    public List<ImsXuanMixloanChannelSubjectEntity> queryList(Map<String, Object> map) {
        return imsXuanMixloanChannelSubjectDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return imsXuanMixloanChannelSubjectDao.queryTotal(map);
    }

    @Override
    public void save(ImsXuanMixloanChannelSubjectEntity imsXuanMixloanChannelSubject) {
        imsXuanMixloanChannelSubjectDao.save(imsXuanMixloanChannelSubject);
    }

    @Override
    public int update(ImsXuanMixloanChannelSubjectEntity imsXuanMixloanChannelSubject) {
        return imsXuanMixloanChannelSubjectDao.update(imsXuanMixloanChannelSubject);
    }

    @Override
    public int delete(Integer id) {
        return imsXuanMixloanChannelSubjectDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return imsXuanMixloanChannelSubjectDao.deleteBatch(ids);
    }

}
