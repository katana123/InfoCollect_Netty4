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

import com.example.tuosha.dao.TiEsDao;
import com.example.tuosha.model.TiEsEntity;
import com.example.tuosha.service.TiEsService;



@Service("tiEsServiceImpl")
public class TiEsServiceImpl implements TiEsService {
	@Autowired
	private TiEsDao tiEsDao;
	
	@Override
	public TiEsEntity queryObject(Integer id){
		return tiEsDao.queryObject(id);
	}
	
	@Override
	public List<TiEsEntity> queryList(Map<String, Object> map){
		return tiEsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tiEsDao.queryTotal(map);
	}
	
	@Override
	public void save(TiEsEntity tiEs){
		tiEsDao.save(tiEs);
	}
	
	@Override
	public int update(TiEsEntity tiEs){
		return tiEsDao.update(tiEs);
	}
	
	@Override
	public int delete(Integer id){
		return tiEsDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return tiEsDao.deleteBatch(ids);
	}

	public ArrayList<TiEsEntity> queryListAll() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<TiEsEntity> result = new ArrayList<TiEsEntity>();
		Connection conn = null;
		try {
			conn = ConnectionUtil.getmysqlConnection();
			String selectSql = "select * from ti_es";
			pst = conn.prepareStatement(selectSql);
			rs = pst.executeQuery();
			while (rs.next()) {
				TiEsEntity icf = new TiEsEntity();
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
