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

import com.example.tuosha.dao.JqCatsDao;
import com.example.tuosha.model.JqCatsEntity;
import com.example.tuosha.service.JqCatsService;



@Service("jqCatsServiceImpl")
public class JqCatsServiceImpl implements JqCatsService {
	@Autowired
	private JqCatsDao jqCatsDao;
	
	@Override
	public JqCatsEntity queryObject(Integer id){
		return jqCatsDao.queryObject(id);
	}
	
	@Override
	public List<JqCatsEntity> queryList(Map<String, Object> map){
		return jqCatsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return jqCatsDao.queryTotal(map);
	}
	
	@Override
	public void save(JqCatsEntity jqCats){
		jqCatsDao.save(jqCats);
	}
	
	@Override
	public int update(JqCatsEntity jqCats){
		return jqCatsDao.update(jqCats);
	}
	
	@Override
	public int delete(Integer id){
		return jqCatsDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return jqCatsDao.deleteBatch(ids);
	}


	public static ArrayList<JqCatsEntity> queryCats() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<JqCatsEntity> result = new ArrayList<JqCatsEntity>();
		Connection conn = null;
		try {
			conn = ConnectionUtil.getmysqlConnection();
			String selectSql = "select * from jq_cats";
			pst = conn.prepareStatement(selectSql);
			rs = pst.executeQuery();
			while (rs.next()) {
				JqCatsEntity jqc = new JqCatsEntity();
				jqc.setName(rs.getString("name"));//请求的银行名称
				jqc.setId(rs.getInt("id"));
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
