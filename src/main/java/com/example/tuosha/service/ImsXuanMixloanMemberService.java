package com.example.tuosha.service;

import com.example.tuosha.model.ImsXuanMixloanMemberEntity;

import java.util.List;
import java.util.Map;

/**
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:30
 */
public interface ImsXuanMixloanMemberService {

    ImsXuanMixloanMemberEntity queryObject(Integer id);

    ImsXuanMixloanMemberEntity queryPhone(String phone);

    List<ImsXuanMixloanMemberEntity> queryList(Map<String, Object> map);

    int permitStatus(String phone);

    int queryTotal(Map<String, Object> map);

    void save(ImsXuanMixloanMemberEntity imsXuanMixloanMember);

    int update(ImsXuanMixloanMemberEntity imsXuanMixloanMember);

    int delete(Integer id);

    int deleteBatch(Integer[] ids);
}
