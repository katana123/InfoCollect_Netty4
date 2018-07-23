package com.example.tuosha.service.impl;

import com.example.tuosha.Util.ConnectionUtil;
import com.example.tuosha.model.ImsXuanMixloanBankEntity;
import com.example.tuosha.service.TbUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.TbUsersDao;
import com.example.tuosha.model.TbUsersEntity;


@Service("tbUsersServiceImpl")
public class TbUsersServiceImpl implements TbUsersService {
    @Autowired
    private TbUsersDao tbUsersDao;

    @Override
    public TbUsersEntity queryObject(Long uid) {
        return tbUsersDao.queryObject(uid);
    }

    @Override
    public List<TbUsersEntity> queryList(Map<String, Object> map) {
        return tbUsersDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return tbUsersDao.queryTotal(map);
    }

    @Override
    public void save(TbUsersEntity tbUsers) {
        tbUsersDao.save(tbUsers);
    }

    @Override
    public int update(TbUsersEntity tbUsers) {
        return tbUsersDao.update(tbUsers);
    }

    @Override
    public int delete(Long uid) {
        return tbUsersDao.delete(uid);
    }

    @Override
    public int deleteBatch(Long[] uids) {
        return tbUsersDao.deleteBatch(uids);
    }


    public TbUsersEntity queryImei(String imei) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        TbUsersEntity result = new TbUsersEntity();
        Connection conn = null;
        try {
            conn = ConnectionUtil.getmysqlConnection();
            String selectSql = "select * from tb_users where imei=" + imei;
            pst = conn.prepareStatement(selectSql);
            rs = pst.executeQuery();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(rs, pst, conn);
        }
        return result;
    }

    public TbUsersEntity queryuser(String nickname, String password) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        TbUsersEntity result = new TbUsersEntity();
        Connection conn = null;
        try {
            conn = ConnectionUtil.getmysqlConnection();
            String selectSql = "select * from tb_users where nickname='" + nickname + "' and password='" + password + "'";
            System.out.println(selectSql);
            pst = conn.prepareStatement(selectSql);
            rs = pst.executeQuery();
            while (rs.next()) {
                TbUsersEntity user = new TbUsersEntity();
                user.setPassword(rs.getString("password"));
                user.setNickname(rs.getString("nickname"));
                user.setStatus(rs.getString("status"));
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(rs, pst, conn);
        }
        return result;
    }

    public TbUsersEntity queryname(String username) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        TbUsersEntity result = new TbUsersEntity();
        Connection conn = null;
        try {
            conn = ConnectionUtil.getmysqlConnection();
            String selectSql = "select * from tb_users where nickname='" + username + "'";
            pst = conn.prepareStatement(selectSql);
            rs = pst.executeQuery();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(rs, pst, conn);
        }

        return result;
    }

    public int insertuser(TbUsersEntity tbuser) {

        PreparedStatement pst = null;
        boolean rs = true;
        ResultSet rss = null;
        TbUsersEntity result = new TbUsersEntity();
        Connection conn = null;
        try {
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            conn = ConnectionUtil.getmysqlConnection();
            String selectSql = "insert into tb_users(nickname,password,phone,status,create_time,sex) values ('" +
                    tbuser.getNickname() + "','" +
                    tbuser.getPassword() + "','" +
                    tbuser.getPhone() + "','0','" + sdf.format(d) + "','0') ";
            pst = conn.prepareStatement(selectSql);
            rs = pst.execute();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(rss, pst, conn);
        }
        int yy = 0;
        if (rs) {
            yy = 1;
        } else {
            yy = 2;
        }
        return yy;
    }
}
