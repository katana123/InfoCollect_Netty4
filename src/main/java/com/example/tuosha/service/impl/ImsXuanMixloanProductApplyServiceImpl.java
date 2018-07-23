package com.example.tuosha.service.impl;

import com.example.tuosha.service.ImsXuanMixloanProductApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.ImsXuanMixloanProductApplyDao;
import com.example.tuosha.model.ImsXuanMixloanProductApplyEntity;


@Service("imsXuanMixloanProductApplyServiceImpl")
public class ImsXuanMixloanProductApplyServiceImpl implements ImsXuanMixloanProductApplyService {
    @Autowired
    private ImsXuanMixloanProductApplyDao imsXuanMixloanProductApplyDao;

    @Override
    public ImsXuanMixloanProductApplyEntity queryObject(Integer id) {
        return imsXuanMixloanProductApplyDao.queryObject(id);
    }

    @Override
    public List<ImsXuanMixloanProductApplyEntity> queryList(Map<String, Object> map) {
        return imsXuanMixloanProductApplyDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return imsXuanMixloanProductApplyDao.queryTotal(map);
    }

    @Override
    public void save(ImsXuanMixloanProductApplyEntity imsXuanMixloanProductApply) {
        imsXuanMixloanProductApplyDao.save(imsXuanMixloanProductApply);
    }

    @Override
    public int update(ImsXuanMixloanProductApplyEntity imsXuanMixloanProductApply) {
        return imsXuanMixloanProductApplyDao.update(imsXuanMixloanProductApply);
    }

    @Override
    public int delete(Integer id) {
        return imsXuanMixloanProductApplyDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return imsXuanMixloanProductApplyDao.deleteBatch(ids);
    }

}
