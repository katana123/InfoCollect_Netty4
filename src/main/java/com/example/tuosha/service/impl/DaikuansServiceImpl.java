package com.example.tuosha.service.impl;

import com.example.tuosha.Util.ConnectionUtil;
import com.example.tuosha.model.XinYongKasEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.DaikuansDao;
import com.example.tuosha.model.DaikuansEntity;
import com.example.tuosha.service.DaikuansService;



@Service("daikuansServiceImpl")
public class DaikuansServiceImpl implements DaikuansService {
	@Autowired
	private DaikuansDao daikuansDao;
	
	@Override
	public DaikuansEntity queryObject(Integer id){
		return daikuansDao.queryObject(id);
	}
	
	@Override
	public List<DaikuansEntity> queryList(Map<String, Object> map){
		return daikuansDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return daikuansDao.queryTotal(map);
	}
	
	@Override
	public void save(DaikuansEntity daikuans){
		daikuansDao.save(daikuans);
	}
	
	@Override
	public int update(DaikuansEntity daikuans){
		return daikuansDao.update(daikuans);
	}
	
	@Override
	public int delete(Integer id){
		return daikuansDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return daikuansDao.deleteBatch(ids);
	}


	public ArrayList<DaikuansEntity> queryListAll() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<DaikuansEntity> result = new ArrayList<DaikuansEntity>();
		Connection conn = null;
		try {
			conn = ConnectionUtil.getmysqlConnection();
			String selectSql = "select * from xin_yong_kas";
			pst = conn.prepareStatement(selectSql);
			rs = pst.executeQuery();
			while (rs.next()) {
				DaikuansEntity icf = new DaikuansEntity();
				icf.setName(rs.getString("name"));//请求的银行名称
				icf.setId(rs.getInt("id"));

				icf.setImage(rs.getString("image"));
				icf.setLink(rs.getString("link"));

				result.add(icf);
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
