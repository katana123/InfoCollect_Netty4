package com.example.tuosha.service.impl;

import com.example.tuosha.service.TbLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.example.tuosha.Util.MyUtil;
import com.example.tuosha.Util.ResultUtil;
import com.example.tuosha.model.TbLogExample;
import com.example.tuosha.model.UserSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.TbLogDao;
import com.example.tuosha.model.TbLogEntity;


@Service("tbLogServiceImpl")
public class TbLogServiceImpl implements TbLogService {
    @Autowired
    private TbLogDao tbLogDao;

    @Override
    public TbLogEntity queryObject(Long id) {
        return tbLogDao.queryObject(id);
    }

    @Override
    public List<TbLogEntity> queryList(Map<String, Object> map) {
        return tbLogDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return tbLogDao.queryTotal(map);
    }

    @Override
    public void save(TbLogEntity tbLog) {
        tbLogDao.save(tbLog);
    }

    @Override
    public int update(TbLogEntity tbLog) {
        return tbLogDao.update(tbLog);
    }

    @Override
    public int delete(Long id) {
        return tbLogDao.delete(id);
    }

    @Override
    public int deleteBatch(Long[] ids) {
        return tbLogDao.deleteBatch(ids);
    }


    public void insLog(TbLogEntity tbLog) {
        tbLogDao.save(tbLog);
    }


    @Override
    public ResultUtil selLogList(Integer page, Integer limit, UserSearch search) {
        PageHelper.startPage(page, limit);
        TbLogExample example = new TbLogExample();
        //设置按创建时间降序排序
        example.setOrderByClause("create_time DESC");
        TbLogExample.Criteria criteria = example.createCriteria();

        if (search.getOperation() != null && !"".equals(search.getOperation())) {
            criteria.andOperationLike("%" + search.getOperation() + "%");
        }

        if (search.getCreateTimeStart() != null && !"".equals(search.getCreateTimeStart())) {
            criteria.andCreateTimeGreaterThanOrEqualTo(MyUtil.getDateByString(search.getCreateTimeStart()));
        }
        if (search.getCreateTimeEnd() != null && !"".equals(search.getCreateTimeEnd())) {
            criteria.andCreateTimeLessThanOrEqualTo(MyUtil.getDateByString(search.getCreateTimeEnd()));
        }

        List<TbLogEntity> logs = tbLogDao.selectByExample(example);
        PageInfo<TbLogEntity> pageInfo = new PageInfo<TbLogEntity>(logs);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public int delLogsByDate(Date date) {
        TbLogExample example = new TbLogExample();
        TbLogExample.Criteria criteria = example.createCriteria();
        criteria.andCreateTimeLessThanOrEqualTo(date);
        int count = tbLogDao.deleteByExample(example);
        return count;
    }

}
