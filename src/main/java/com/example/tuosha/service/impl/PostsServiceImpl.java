package com.example.tuosha.service.impl;

import com.example.tuosha.Util.ConnectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.tuosha.dao.PostsDao;
import com.example.tuosha.model.PostsEntity;
import com.example.tuosha.service.PostsService;



@Service("postsServiceImpl")
public class PostsServiceImpl implements PostsService {
	@Autowired
	private PostsDao postsDao;

	@Override
	public PostsEntity queryObject(Integer id){
		return postsDao.queryObject(id);
	}
	
	@Override
	public List<PostsEntity> queryList(Map<String, Object> map){
		return postsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return postsDao.queryTotal(map);
	}
	
	@Override
	public void save(PostsEntity posts){
		postsDao.save(posts);
	}
	
	@Override
	public int update(PostsEntity posts){
		return postsDao.update(posts);
	}
	
	@Override
	public int delete(Integer id){
		return postsDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
		return postsDao.deleteBatch(ids);
	}

	public static ArrayList<PostsEntity> getPostsList() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<PostsEntity> result = new ArrayList<PostsEntity>();
		Connection conn = null;
		try {
			conn = ConnectionUtil.getmysqlConnection();
			String selectSql = "SELECT DISTINCT id,intro,name,views,created_at,image " +
					"from posts where deleted_at is null ORDER BY created_at DESC limit 10";
			pst = conn.prepareStatement(selectSql);
			rs = pst.executeQuery();
			while (rs.next()) {
				PostsEntity pte = new PostsEntity();
				pte.setId(rs.getInt("id"));
				pte.setName(rs.getString("name"));//请求的银行名称
				pte.setIntro(rs.getString("intro"));
				pte.setCreatedAt(rs.getDate("created_at"));
				pte.setViews(rs.getInt("views"));
				pte.setImage(rs.getString("image"));
				result.add(pte);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			endDatabaseOptions(rs, pst, conn);
		}
		return result;
	}

	public static ArrayList<PostsEntity> getPostsListByType(int type) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<PostsEntity> result = new ArrayList<PostsEntity>();
		Connection conn = null;

		try {
			conn = ConnectionUtil.getmysqlConnection();
			String selectSql = "SELECT DISTINCT id,intro,name,views,created_at,image " +
					"from posts where deleted_at is null and category_id = " + type + " ORDER BY created_at DESC limit 10";
			pst = conn.prepareStatement(selectSql);
			System.out.println("xxm test: selectSql =" + selectSql);
			rs = pst.executeQuery();
			while (rs.next()) {
				PostsEntity pte = new PostsEntity();
				pte.setId(rs.getInt("id"));
				pte.setName(rs.getString("name"));//请求的银行名称
				pte.setIntro(rs.getString("intro"));
				pte.setCreatedAt(rs.getDate("created_at"));
				pte.setViews(rs.getInt("views"));
				pte.setImage(rs.getString("image"));
				result.add(pte);
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
	public static void endDatabaseOptions(ResultSet rs, PreparedStatement pst, Connection conn) {
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
