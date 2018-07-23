package com.example.tuosha.service.impl;

import com.example.tuosha.service.ImsXuanMixloanHelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.ImsXuanMixloanHelpDao;
import com.example.tuosha.model.ImsXuanMixloanHelpEntity;


@Service("imsXuanMixloanHelpServiceImpl")
public class ImsXuanMixloanHelpServiceImpl implements ImsXuanMixloanHelpService {
    @Autowired
    private ImsXuanMixloanHelpDao imsXuanMixloanHelpDao;

    @Override
    public ImsXuanMixloanHelpEntity queryObject(Integer id) {
        return imsXuanMixloanHelpDao.queryObject(id);
    }

    @Override
    public List<ImsXuanMixloanHelpEntity> queryList(Map<String, Object> map) {
        return imsXuanMixloanHelpDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return imsXuanMixloanHelpDao.queryTotal(map);
    }

    @Override
    public void save(ImsXuanMixloanHelpEntity imsXuanMixloanHelp) {
        imsXuanMixloanHelpDao.save(imsXuanMixloanHelp);
    }

    @Override
    public int update(ImsXuanMixloanHelpEntity imsXuanMixloanHelp) {
        return imsXuanMixloanHelpDao.update(imsXuanMixloanHelp);
    }

    @Override
    public int delete(Integer id) {
        return imsXuanMixloanHelpDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return imsXuanMixloanHelpDao.deleteBatch(ids);
    }

}
