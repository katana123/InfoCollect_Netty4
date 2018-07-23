package com.example.tuosha.dao;

import com.example.tuosha.Util.ConnectionUtil;
import com.example.tuosha.model.ContentBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContentDao {

    public ArrayList<ContentBean> SelectContents() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<ContentBean> result = new ArrayList<ContentBean>();
        Connection conn = null;

        try {
            conn = ConnectionUtil.getmysqlConnection();
            String selectSql = "SELECT * " +
                    "FROM irs1.ims_xuan_mixloan_channel ORDER BY irs1.ims_xuan_mixloan_channel.createtime DESC limit 10";
            pst = conn.prepareStatement(selectSql);
            System.out.println("xxm test: selectSql =" + selectSql);
            rs = pst.executeQuery();
            while (rs.next()) {
                ContentBean contentBean = new ContentBean();
                System.out.println("contentBean" + rs.getString("createtime"));
                // icf.setCisdate(rs.getString("cisdate"));
                contentBean.setId(rs.getInt("id"));
                contentBean.setTitle(rs.getString("title"));
                contentBean.setReadnum(rs.getString("apply_nums"));
                contentBean.setNewstime(rs.getString("createtime"));
                contentBean.setExtInfo(rs.getString("ext_info"));
                result.add(contentBean);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            endDatabaseOptions(rs, pst, conn);
        }

        return result;
    }

    public ArrayList<ContentBean> SelectContentsByType(int type) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<ContentBean> result = new ArrayList<ContentBean>();
        Connection conn = null;

        try {
            conn = ConnectionUtil.getmysqlConnection();
            String selectSql = "SELECT * " +
                    "FROM irs1.ims_xuan_mixloan_channel WHERE irs1.ims_xuan_mixloan_channel.type=" + type + " ORDER BY irs1.ims_xuan_mixloan_channel.createtime DESC limit 10";
            pst = conn.prepareStatement(selectSql);
            System.out.println("xxm test: selectSql =" + selectSql);
            rs = pst.executeQuery();
            while (rs.next()) {
                ContentBean contentBean = new ContentBean();
                System.out.println("contentBean" + rs.getString("createtime"));
                // icf.setCisdate(rs.getString("cisdate"));
                contentBean.setId(rs.getInt("id"));
                contentBean.setTitle(rs.getString("title"));
                contentBean.setReadnum(rs.getString("apply_nums"));
                contentBean.setNewstime(rs.getString("createtime"));
                contentBean.setExtInfo(rs.getString("ext_info"));
                result.add(contentBean);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            endDatabaseOptions(rs, pst, conn);
        }

        return result;
    }

    /**
     * @param rs
     * @param pst
     * @param conn
     */
    public void endDatabaseOptions(ResultSet rs, PreparedStatement pst, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            rs = null;
        }
        if (pst != null) {
            try {
                pst.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            pst = null;
        }
        if (conn != null) {
            try {
                conn.close();

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            conn = null;
        }
    }
}
