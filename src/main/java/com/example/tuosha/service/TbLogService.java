package com.example.tuosha.service;

import com.example.tuosha.Util.ResultUtil;
import com.example.tuosha.model.TbLogEntity;
import com.example.tuosha.model.UserSearch;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:31
 */
public interface TbLogService {

    TbLogEntity queryObject(Long id);

    List<TbLogEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(TbLogEntity tbLog);

    int update(TbLogEntity tbLog);

    int delete(Long id);

    int deleteBatch(Long[] ids);

    //添加日志
    void insLog(TbLogEntity log);

    //获取日志列表
    ResultUtil selLogList(Integer page, Integer limit, UserSearch search);

    //删除指定日期以前的日志
    int delLogsByDate(Date date);
}
