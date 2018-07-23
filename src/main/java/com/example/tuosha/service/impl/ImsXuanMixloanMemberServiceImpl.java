package com.example.tuosha.service.impl;

import com.example.tuosha.service.ImsXuanMixloanMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.ImsXuanMixloanMemberDao;
import com.example.tuosha.model.ImsXuanMixloanMemberEntity;


@Service("imsXuanMixloanMemberServiceImpl")
public class ImsXuanMixloanMemberServiceImpl implements ImsXuanMixloanMemberService {
    @Autowired
    private ImsXuanMixloanMemberDao imsXuanMixloanMemberDao;

    @Override
    public ImsXuanMixloanMemberEntity queryObject(Integer id) {
        return imsXuanMixloanMemberDao.queryObject(id);
    }

    @Override
    public ImsXuanMixloanMemberEntity queryPhone(String phone) {
        return imsXuanMixloanMemberDao.queryObject(phone);
    }

    @Override
    public int permitStatus(String phone) {
        return imsXuanMixloanMemberDao.permitStatus(phone);
    }

    //@Override
    public int iflogin(String uid, String pass, String phone) {
        return imsXuanMixloanMemberDao.iflogin(uid, pass, phone);
    }

    //@Override
    public int getUserInfo(String nickname) {
        return imsXuanMixloanMemberDao.getUserInfo(nickname);
    }

    //@Override
    public ImsXuanMixloanMemberEntity findUserInfo(ImsXuanMixloanMemberEntity userinfo) {
        return imsXuanMixloanMemberDao.findUserInfo(userinfo);
    }

    public int insertUserInfo(ImsXuanMixloanMemberEntity userinfo) {
        return imsXuanMixloanMemberDao.insertUserInfo(userinfo);
    }

    public int getPrisByCuid(String uid, String pass) {
        return imsXuanMixloanMemberDao.getPrisByCuid(uid, pass);
    }

    @Override
    public List<ImsXuanMixloanMemberEntity> queryList(Map<String, Object> map) {
        return imsXuanMixloanMemberDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return imsXuanMixloanMemberDao.queryTotal(map);
    }

    @Override
    public void save(ImsXuanMixloanMemberEntity imsXuanMixloanMember) {
        imsXuanMixloanMemberDao.save(imsXuanMixloanMember);
    }

    @Override
    public int update(ImsXuanMixloanMemberEntity imsXuanMixloanMember) {
        return imsXuanMixloanMemberDao.update(imsXuanMixloanMember);
    }

    @Override
    public int delete(Integer id) {
        return imsXuanMixloanMemberDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return imsXuanMixloanMemberDao.deleteBatch(ids);
    }

}
