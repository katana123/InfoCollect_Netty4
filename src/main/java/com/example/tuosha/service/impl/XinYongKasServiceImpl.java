package com.example.tuosha.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.tuosha.Util.ConnectionUtil;
import com.example.tuosha.model.ImsXuanMixloanBankCardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.XinYongKasDao;
import com.example.tuosha.model.XinYongKasEntity;
import com.example.tuosha.service.XinYongKasService;



@Service("xinYongKasServiceImpl")
public class XinYongKasServiceImpl implements XinYongKasService {
	@Autowired
	private XinYongKasDao xinYongKasDao;
	
	@Override
	public XinYongKasEntity queryObject(Integer id){
		return xinYongKasDao.queryObject(id);
	}
	
	@Override
	public List<XinYongKasEntity> queryList(Map<String, Object> map){
		return xinYongKasDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return xinYongKasDao.queryTotal(map);
	}
	
	@Override
	public void save(XinYongKasEntity xinYongKas){
		xinYongKasDao.save(xinYongKas);
	}
	
	@Override
	public int update(XinYongKasEntity xinYongKas){
		return xinYongKasDao.update(xinYongKas);
	}
	
	@Override
	public int delete(Integer id){
		return xinYongKasDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return xinYongKasDao.deleteBatch(ids);
	}


	public ArrayList<XinYongKasEntity> queryListAll() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<XinYongKasEntity> result = new ArrayList<XinYongKasEntity>();
		Connection conn = null;
		try {
			conn = ConnectionUtil.getmysqlConnection();
			String selectSql = "select * from xin_yong_kas";
			pst = conn.prepareStatement(selectSql);
			rs = pst.executeQuery();
			while (rs.next()) {
				XinYongKasEntity icf = new XinYongKasEntity();
				icf.setName(rs.getString("name"));//请求的银行名称
				icf.setId(rs.getInt("id"));
				icf.setViews(rs.getInt("Views"));
				icf.setPass(rs.getDouble("Pass"));
				icf.setAdvantage(rs.getString("advantage"));
				icf.setImage(rs.getString("image"));
				icf.setLink(rs.getString("link"));
				icf.setLiucheng(rs.getString("liucheng"));
				icf.setTiaojian(rs.getString("tiaojian"));
				icf.setCailiao(rs.getString("cailiao"));
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
