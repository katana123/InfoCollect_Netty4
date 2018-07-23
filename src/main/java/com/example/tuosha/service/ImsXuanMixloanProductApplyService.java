package com.example.tuosha.service;

import com.example.tuosha.model.ImsXuanMixloanProductApplyEntity;

import java.util.List;
import java.util.Map;

/**
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:30
 */
public interface ImsXuanMixloanProductApplyService {

    ImsXuanMixloanProductApplyEntity queryObject(Integer id);

    List<ImsXuanMixloanProductApplyEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(ImsXuanMixloanProductApplyEntity imsXuanMixloanProductApply);

    int update(ImsXuanMixloanProductApplyEntity imsXuanMixloanProductApply);

    int delete(Integer id);

    int deleteBatch(Integer[] ids);
}
