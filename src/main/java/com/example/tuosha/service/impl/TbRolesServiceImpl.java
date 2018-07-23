package com.example.tuosha.service.impl;

import com.example.tuosha.service.TbRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.TbRolesDao;
import com.example.tuosha.model.TbRolesEntity;


@Service("tbRolesServiceImpl")
public class TbRolesServiceImpl implements TbRolesService {
    @Autowired
    private TbRolesDao tbRolesDao;

    @Override
    public TbRolesEntity queryObject(Long roleId) {
        return tbRolesDao.queryObject(roleId);
    }

    @Override
    public List<TbRolesEntity> queryList(Map<String, Object> map) {
        return tbRolesDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return tbRolesDao.queryTotal(map);
    }

    @Override
    public void save(TbRolesEntity tbRoles) {
        tbRolesDao.save(tbRoles);
    }

    @Override
    public int update(TbRolesEntity tbRoles) {
        return tbRolesDao.update(tbRoles);
    }

    @Override
    public int delete(Long roleId) {
        return tbRolesDao.delete(roleId);
    }

    @Override
    public int deleteBatch(Long[] roleIds) {
        return tbRolesDao.deleteBatch(roleIds);
    }

}
