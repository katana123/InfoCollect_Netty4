package com.example.tuosha.service.impl;

import com.example.tuosha.Util.ConnectionUtil;
import com.example.tuosha.model.TbUsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.UsersDao;
import com.example.tuosha.model.UsersEntity;
import com.example.tuosha.service.UsersService;



@Service("usersServiceImpl")
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersDao usersDao;
	
	@Override
	public UsersEntity queryObject(Integer id){
		return usersDao.queryObject(id);
	}
	
	@Override
	public List<UsersEntity> queryList(Map<String, Object> map){
		return usersDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return usersDao.queryTotal(map);
	}
	
	@Override
	public void save(UsersEntity users){
		usersDao.save(users);
	}
	
	@Override
	public int update(UsersEntity users){
		return usersDao.update(users);
	}
	
	@Override
	public int delete(Integer id){
		return usersDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return usersDao.deleteBatch(ids);
	}


	public UsersEntity queryuser(String mobile, String password){

		PreparedStatement pst = null;
		ResultSet rs = null;
		UsersEntity result = new UsersEntity();
		Connection conn = null;
		try {
			conn = ConnectionUtil.getmysqlConnection();
			String selectSql = "select * from users where mobile='"+mobile+"' and password='"+password+"'";
			System.out.println(selectSql);
			pst = conn.prepareStatement(selectSql);
			rs = pst.executeQuery();
			while(rs.next()){
				result.setMobile(rs.getString("mobile"));
				result.setStatus(rs.getString("status"));
				result.setMember(rs.getInt("member"));
				result.setNickname(rs.getString("nickname"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, pst, conn);
		}
		return result;
	}

	public UsersEntity queryname(String username){

		PreparedStatement pst = null;
		ResultSet rs = null;
		UsersEntity result = new UsersEntity();
		Connection conn = null;
		try {
			conn = ConnectionUtil.getmysqlConnection();
			String selectSql = "select * from users where nickname='"+username+"'";
			pst = conn.prepareStatement(selectSql);
			rs = pst.executeQuery();
			while(rs.next()){
				result.setMobile(rs.getString("mobile"));
				result.setStatus(rs.getString("status"));
				result.setNickname(rs.getString("nickname"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, pst, conn);
		}

		return result;
	}
	public int insertuser(UsersEntity tbuser){

		PreparedStatement pst = null;
		int rs = 0;
		ResultSet rss = null;
		UsersEntity result = new UsersEntity();
		Connection conn = null;
		try {
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			conn = ConnectionUtil.getmysqlConnection();
			String selectSql = "insert into users(nickname,password,phone,status,member,created_at) values ('"+
					tbuser.getNickname()+"','"+
					tbuser.getPassword()+"','"+
					tbuser.getMobile()+"','正常','0','"+sdf.format(d)+"') ";
			pst = conn.prepareStatement(selectSql);
			rs = pst.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rss, pst, conn);
		}

		return rs;
	}
}
