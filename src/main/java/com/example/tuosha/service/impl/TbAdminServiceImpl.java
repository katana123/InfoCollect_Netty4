package com.example.tuosha.service.impl;

import com.example.tuosha.service.TbAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.TbAdminDao;
import com.example.tuosha.model.TbAdminEntity;


@Service("tbAdminServiceImpl")
public class TbAdminServiceImpl implements TbAdminService {
    @Autowired
    private TbAdminDao tbAdminDao;

    @Override
    public TbAdminEntity queryObject(Long id) {
        return tbAdminDao.queryObject(id);
    }

    @Override
    public List<TbAdminEntity> queryList(Map<String, Object> map) {
        return tbAdminDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return tbAdminDao.queryTotal(map);
    }

    @Override
    public void save(TbAdminEntity tbAdmin) {
        tbAdminDao.save(tbAdmin);
    }

    @Override
    public int update(TbAdminEntity tbAdmin) {
        return tbAdminDao.update(tbAdmin);
    }

    @Override
    public int delete(Long id) {
        return tbAdminDao.delete(id);
    }

    @Override
    public int deleteBatch(Long[] ids) {
        return tbAdminDao.deleteBatch(ids);
    }

}
