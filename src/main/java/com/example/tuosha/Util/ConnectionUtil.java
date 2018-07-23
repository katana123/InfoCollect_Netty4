package com.example.tuosha.Util;

import java.sql.*;

/**
 * Created by kasim on 15-2-10.
 */
public class ConnectionUtil {

    /**
     * 获取股份INFOCLT数据库中
     * 源燃料以及能源日报本地数据数据库链接
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getEnergyAndResouceMysqlConnection()
            throws ClassNotFoundException, SQLException {
        Connection conn = null;
        String DRIVER = "com.mysql.jdbc.Driver";
        String URL = "jdbc:mysql://127.0.0.1:3306/irs1?useUnicode=true&amp;"
                + "characterEncoding=UTF-8&amp;autoReconnect=true&&zeroDateTimeBehavior=convertToNull";
        try {
            Class.forName(DRIVER).newInstance();
            String USERNAME = "root";
            String PASSWORD = "root";
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

        }
        return conn;
    }

    /**
     * 股份INFOCLTt数据库获取链接方式
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getmysqlConnection1()
            throws ClassNotFoundException, SQLException {
        Connection conn = null;
        String DRIVER = "com.mysql.jdbc.Driver";
        String URL = "jdbc:mysql://127.0.0.1:3306/irs1?useUnicode=true&amp;"
                + "characterEncoding=UTF-8&amp;autoReconnect=true&&zeroDateTimeBehavior=convertToNull";
        try {
            Class.forName(DRIVER).newInstance();
            String USERNAME = "root";
            String PASSWORD = "root";
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

        }
        return conn;
    }

    /**
     * 股份INFOCLTt数据库获取链接方式
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getmysqlConnection()
            throws ClassNotFoundException, SQLException {
        Connection conn = null;
        String DRIVER = "com.mysql.jdbc.Driver";
        String URL = "jdbc:mysql://127.0.0.1:3306/irs1?useUnicode=true&amp;"
                + "characterEncoding=UTF-8&amp;autoReconnect=true&&zeroDateTimeBehavior=convertToNull";
        try {
            Class.forName(DRIVER).newInstance();
            String USERNAME = "root";
            String PASSWORD = "root";
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
        }
        return conn;
    }

    /**
     * 源燃料数据库获取链接方式
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConnection() throws ClassNotFoundException,
            SQLException {
        Connection conn = null;
        String DRIVER = "com.mysql.jdbc.Driver";
        String URL = "jdbc:mysql://127.0.0.1:3306/irs1?useUnicode=true&amp;"
                + "characterEncoding=UTF-8&amp;autoReconnect=true&&zeroDateTimeBehavior=convertToNull";
        try {
            Class.forName(DRIVER).newInstance();
            String USERNAME = "root";
            String PASSWORD = "root";
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭数据库连接
     *
     * @param rs   ResultSet to be closed
     * @param stmt Statement or PreparedStatement to be closed
     * @param conn Connection to be closed
     */
    public static void close(ResultSet rs, PreparedStatement stmt,
                             Connection conn) {
        if (rs != null)
            try {
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        if (stmt != null)
            try {
                stmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        if (conn != null)
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
    }
}

