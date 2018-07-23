package com.example.tuosha.service.impl;

import com.example.tuosha.service.TbRolesMenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.TbRolesMenusDao;
import com.example.tuosha.model.TbRolesMenusEntity;


@Service("tbRolesMenusServiceImpl")
public class TbRolesMenusServiceImpl implements TbRolesMenusService {
    @Autowired
    private TbRolesMenusDao tbRolesMenusDao;

    @Override
    public TbRolesMenusEntity queryObject(Long menuId) {
        return tbRolesMenusDao.queryObject(menuId);
    }

    @Override
    public List<TbRolesMenusEntity> queryList(Map<String, Object> map) {
        return tbRolesMenusDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return tbRolesMenusDao.queryTotal(map);
    }

    @Override
    public void save(TbRolesMenusEntity tbRolesMenus) {
        tbRolesMenusDao.save(tbRolesMenus);
    }

    @Override
    public int update(TbRolesMenusEntity tbRolesMenus) {
        return tbRolesMenusDao.update(tbRolesMenus);
    }

    @Override
    public int delete(Long menuId) {
        return tbRolesMenusDao.delete(menuId);
    }

    @Override
    public int deleteBatch(Long[] menuIds) {
        return tbRolesMenusDao.deleteBatch(menuIds);
    }

}
