package com.example.tuosha.service.impl;

import com.example.tuosha.model.ImsXuanMixloanMemberEntity;
import com.example.tuosha.model.ImsXuanMixloanProductEntity;

import java.util.ArrayList;

public class SWImpl {
    private ImsXuanMixloanMemberServiceImpl memberServiceImpl = new ImsXuanMixloanMemberServiceImpl();
    private ImsXuanMixloanProductServiceImpl productServiceImpl = new ImsXuanMixloanProductServiceImpl();

    /**
     * 获取移动终端权限
     *
     * @param imei
     * @return 0为未注册
     * 1为已注册未授权
     * 2为已注册已授权
     * @throws Exception
     */
    public int getPermissionResult(String phone) throws Exception {
        return this.memberServiceImpl.permitStatus(phone);
    }

    /**
     * 获取移动终端登陆结果
     *
     * @param userID
     * @param userPwd
     * @param imei
     * @return 0为登陆用户名不存在
     * 1为登陆成功
     * 2为登陆密码错误
     * 3为登陆用户名与imei不匹配
     * @throws Exception
     */
    public int getLoginResult(String userID, String userPwd, String phone) throws Exception {
        return this.memberServiceImpl.iflogin(userID, userPwd, phone);
    }

    /**
     * 判断用户名是否存在
     *
     * @param userInfo
     * @return 0x01 表示用户名可用
     * 0x02 表示用户名不可用
     * @throws Exception
     */
    public int getRegistInfo(String cusername) throws Exception {
        return this.memberServiceImpl.getUserInfo(cusername);
    }

    /**
     * 判断用户名是否存在
     *
     * @param userInfo
     * @return 0x01 表示用户名可用
     * 0x02 表示用户名不可用
     * @throws Exception
     */
    public ImsXuanMixloanMemberEntity findUserInfo(ImsXuanMixloanMemberEntity userinfo) throws Exception {
        return this.memberServiceImpl.findUserInfo(userinfo);
    }

    /**
     * @param userInfo
     * @return 0x01表示插入成功
     * 0x02表示插入失败
     * @throws Exception
     */
    public int insertUserInfo(ImsXuanMixloanMemberEntity userInfo) throws Exception {
        return this.memberServiceImpl.insertUserInfo(userInfo);
    }

    /**
     * @param cusername,cpwd
     * @return 用户权限
     * @throws Exception
     */
    public int getStatus(String cusername, String cpwd) throws Exception {
        return this.memberServiceImpl.getPrisByCuid(cusername, cpwd);
    }

    public ArrayList<ImsXuanMixloanProductEntity> getproductArrayList() throws Exception {
        return this.productServiceImpl.getproductArrayList();
    }
}
