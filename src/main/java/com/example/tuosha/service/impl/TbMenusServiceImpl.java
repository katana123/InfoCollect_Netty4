package com.example.tuosha.service.impl;

import com.example.tuosha.service.TbMenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.TbMenusDao;
import com.example.tuosha.model.TbMenusEntity;


@Service("tbMenusServiceImpl")
public class TbMenusServiceImpl implements TbMenusService {
    @Autowired
    private TbMenusDao tbMenusDao;

    @Override
    public TbMenusEntity queryObject(Long menuId) {
        return tbMenusDao.queryObject(menuId);
    }

    @Override
    public List<TbMenusEntity> queryList(Map<String, Object> map) {
        return tbMenusDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return tbMenusDao.queryTotal(map);
    }

    @Override
    public void save(TbMenusEntity tbMenus) {
        tbMenusDao.save(tbMenus);
    }

    @Override
    public int update(TbMenusEntity tbMenus) {
        return tbMenusDao.update(tbMenus);
    }

    @Override
    public int delete(Long menuId) {
        return tbMenusDao.delete(menuId);
    }

    @Override
    public int deleteBatch(Long[] menuIds) {
        return tbMenusDao.deleteBatch(menuIds);
    }

}
