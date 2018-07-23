package com.example.tuosha.dao;

import com.example.tuosha.model.ImsXuanMixloanMemberEntity;
import com.example.tuosha.base.dao.BaseDao;

/**
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2018-07-10 12:09:30
 */
public interface ImsXuanMixloanMemberDao extends BaseDao<ImsXuanMixloanMemberEntity> {
    ImsXuanMixloanMemberEntity queryPhone(String phone);

    int permitStatus(String phone);

    int iflogin(String uid, String pass, String phone);

    int getUserInfo(String cusername);

    ImsXuanMixloanMemberEntity findUserInfo(ImsXuanMixloanMemberEntity userinfo);

    int insertUserInfo(ImsXuanMixloanMemberEntity userInfo);

    int getPrisByCuid(String nickname, String pass);
}
