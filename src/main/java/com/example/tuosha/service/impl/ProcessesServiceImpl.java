package com.example.tuosha.service.impl;

import com.example.tuosha.Util.ConnectionUtil;
import com.example.tuosha.model.DaikuansEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.ProcessesDao;
import com.example.tuosha.model.ProcessesEntity;
import com.example.tuosha.service.ProcessesService;



@Service("processesServiceImpl")
public class ProcessesServiceImpl implements ProcessesService {
	@Autowired
	private ProcessesDao processesDao;
	
	@Override
	public ProcessesEntity queryObject(Integer id){
		return processesDao.queryObject(id);
	}
	
	@Override
	public List<ProcessesEntity> queryList(Map<String, Object> map){
		return processesDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return processesDao.queryTotal(map);
	}
	
	@Override
	public void save(ProcessesEntity processes){
		processesDao.save(processes);
	}
	
	@Override
	public int update(ProcessesEntity processes){
		return processesDao.update(processes);
	}
	
	@Override
	public int delete(Integer id){
		return processesDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return processesDao.deleteBatch(ids);
	}

	public ArrayList<ProcessesEntity> queryListAll() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<ProcessesEntity> result = new ArrayList<ProcessesEntity>();
		Connection conn = null;
		try {
			conn = ConnectionUtil.getmysqlConnection();
			String selectSql = "select * from processes where isnull(deleted_at)";
			pst = conn.prepareStatement(selectSql);
			rs = pst.executeQuery();
			while (rs.next()) {
				ProcessesEntity icf = new ProcessesEntity();
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
