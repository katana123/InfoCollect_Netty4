package com.example.tuosha.dao;

import com.example.tuosha.Util.ConnectionUtil;
import com.example.tuosha.model.KouziBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class KouziDao {
    public ArrayList<KouziBean> SelectKz() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<KouziBean> result = new ArrayList<KouziBean>();
        Connection conn = null;

        try {
            conn = ConnectionUtil.getmysqlConnection();
            String selectSql = "SELECT DISTINCT ext_info,name,apply_nums,createtime " +
                    "FROM irs1.ims_xuan_mixloan_loan ORDER BY irs1.ims_xuan_mixloan_loan.createtime DESC limit 10";
            pst = conn.prepareStatement(selectSql);
            System.out.println("xxm test: selectSql =" + selectSql);
            rs = pst.executeQuery();
            while (rs.next()) {
                KouziBean kouziList = new KouziBean();
                System.out.println("kouziList" + rs.getString("createtime"));
                // icf.setCisdate(rs.getString("cisdate"));
                kouziList.setTitle(rs.getString("name"));
                kouziList.setClicknum(rs.getString("apply_nums"));
                kouziList.setExtInfo(rs.getString("ext_info"));
//                kouziList.setKouzi_url(rs.getString("ext_info"));
                kouziList.setKouzitime(rs.getString("createtime"));
                result.add(kouziList);
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

    public ArrayList<KouziBean> SelectKzByType(int type) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<KouziBean> result = new ArrayList<KouziBean>();
        Connection conn = null;

        try {
            conn = ConnectionUtil.getmysqlConnection();
            String selectSql = "SELECT DISTINCT ext_info,name,apply_nums,createtime " +
                    "FROM irs1.ims_xuan_mixloan_loan WHERE find_in_set(" + type + ",irs1.ims_xuan_mixloan_loan.`type`) ORDER BY irs1.ims_xuan_mixloan_loan.createtime DESC limit 10";
            pst = conn.prepareStatement(selectSql);
            System.out.println("xxm test: selectSql =" + selectSql);
            rs = pst.executeQuery();
            while (rs.next()) {
                KouziBean kouziList = new KouziBean();
                System.out.println("kouziList" + rs.getString("createtime"));
                // icf.setCisdate(rs.getString("cisdate"));
                kouziList.setTitle(rs.getString("name"));
                kouziList.setClicknum(rs.getString("apply_nums"));
                kouziList.setExtInfo(rs.getString("ext_info"));
                kouziList.setKouzitime(rs.getString("createtime"));
                result.add(kouziList);
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
