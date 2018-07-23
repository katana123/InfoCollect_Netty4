package com.example.tuosha.service.impl;

import com.example.tuosha.service.ImsXuanMixloanLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.ImsXuanMixloanLoanDao;
import com.example.tuosha.model.ImsXuanMixloanLoanEntity;


@Service("imsXuanMixloanLoanServiceImpl")
public class ImsXuanMixloanLoanServiceImpl implements ImsXuanMixloanLoanService {
    @Autowired
    private ImsXuanMixloanLoanDao imsXuanMixloanLoanDao;

    @Override
    public ImsXuanMixloanLoanEntity queryObject(Integer id) {
        return imsXuanMixloanLoanDao.queryObject(id);
    }

    @Override
    public List<ImsXuanMixloanLoanEntity> queryList(Map<String, Object> map) {
        return imsXuanMixloanLoanDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return imsXuanMixloanLoanDao.queryTotal(map);
    }

    @Override
    public void save(ImsXuanMixloanLoanEntity imsXuanMixloanLoan) {
        imsXuanMixloanLoanDao.save(imsXuanMixloanLoan);
    }

    @Override
    public int update(ImsXuanMixloanLoanEntity imsXuanMixloanLoan) {
        return imsXuanMixloanLoanDao.update(imsXuanMixloanLoan);
    }

    @Override
    public int delete(Integer id) {
        return imsXuanMixloanLoanDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return imsXuanMixloanLoanDao.deleteBatch(ids);
    }

}
