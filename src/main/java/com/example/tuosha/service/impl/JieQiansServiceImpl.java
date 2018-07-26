package com.example.tuosha.service.impl;

import com.example.tuosha.Util.ConnectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.JieQiansDao;
import com.example.tuosha.model.JieQiansEntity;
import com.example.tuosha.service.JieQiansService;



@Service("jieQiansServiceImpl")
public class JieQiansServiceImpl implements JieQiansService {
	@Autowired
	private JieQiansDao jieQiansDao;
	
	@Override
	public JieQiansEntity queryObject(Integer id){
		return jieQiansDao.queryObject(id);
	}
	
	@Override
	public List<JieQiansEntity> queryList(Map<String, Object> map){
		return jieQiansDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return jieQiansDao.queryTotal(map);
	}
	
	@Override
	public void save(JieQiansEntity jieQians){
		jieQiansDao.save(jieQians);
	}
	
	@Override
	public int update(JieQiansEntity jieQians){
		return jieQiansDao.update(jieQians);
	}
	
	@Override
	public int delete(Integer id){
		return jieQiansDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return jieQiansDao.deleteBatch(ids);
	}

    public static ArrayList<JieQiansEntity> getJieQianList() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<JieQiansEntity> result = new ArrayList<JieQiansEntity>();
        Connection conn = null;
        try {
            conn = ConnectionUtil.getmysqlConnection();
            String selectSql = "SELECT DISTINCT id,advantage,name,view,created_at,link,image " +
                    "FROM jie_qians ORDER BY created_at DESC limit 10";
            pst = conn.prepareStatement(selectSql);
            rs = pst.executeQuery();
            while (rs.next()) {
                JieQiansEntity jqc = new JieQiansEntity();
                jqc.setId(rs.getInt("id"));
                jqc.setName(rs.getString("name"));//请求的银行名称
                jqc.setView(rs.getInt("view"));
                jqc.setCreatedAt(rs.getDate("created_at"));
                jqc.setAdvantage(rs.getString("advantage"));
                jqc.setLink(rs.getString("link"));
                jqc.setImage(rs.getString("image"));
                result.add(jqc);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(rs, pst, conn);
        }
        return result;
        //return imsXuanMixloanBankDao.queryListAll();
    }

    public static ArrayList<JieQiansEntity> getJieQianListByType(int type) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<JieQiansEntity> result = new ArrayList<JieQiansEntity>();
        Connection conn = null;
        try {
            conn = ConnectionUtil.getmysqlConnection();
            String selectSql = "SELECT DISTINCT a.id,a.advantage,a.name,a.view,a.created_at,a.link,a.image " +
                    "from jie_qians a left join jie_qian_jq_cat b on a.id = b.jie_qian_id where b.jq_cat_id = " + type + " ORDER BY a.created_at DESC limit 10";
            pst = conn.prepareStatement(selectSql);
            rs = pst.executeQuery();
            while (rs.next()) {
                JieQiansEntity jqc = new JieQiansEntity();
                jqc.setId(rs.getInt("id"));
                jqc.setName(rs.getString("name"));//请求的银行名称
                jqc.setView(rs.getInt("view"));
                jqc.setCreatedAt(rs.getDate("created_at"));
                jqc.setAdvantage(rs.getString("advantage"));
                jqc.setLink(rs.getString("link"));
                jqc.setImage(rs.getString("image"));
                result.add(jqc);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(rs, pst, conn);
        }
        return result;
        //return imsXuanMixloanBankDao.queryListAll();
    }
}
