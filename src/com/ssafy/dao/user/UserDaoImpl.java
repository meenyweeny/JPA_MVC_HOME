package com.ssafy.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;

import com.ssafy.dto.user.User;
import com.ssafy.util.DBUtil;

public class UserDaoImpl implements UserDao {
	
	DBUtil util;

	public UserDaoImpl() {
		util = DBUtil.getInstance();
	}
	
	@Override
	public ArrayList<User> selectAll() {
		ArrayList<User> list = new ArrayList<>();
		
		String query = "select userId, password, name " +
						"from user";
		try {
			Connection con = util.getConnection();
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(query);
			
			while(rs.next()) {
				String userId = rs.getString(1);
				String password = rs.getString(2);
				String name = rs.getString(3);
				User user = new User(userId, password, name);
				list.add(user);
			}
			
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Optional<User> selectUserByUserId(String userId) {
		Optional<User> user = Optional.empty();
		
		String query = "select userId, password, name " + 
						"from user" +
						"where userId = ?";
		
		try {
			Connection con = util.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, userId);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			userId = rs.getString(1);
			String password = rs.getString(2);
			String name = rs.getString(3);
			user = Optional.ofNullable(new User(userId,password,name));
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public void insert(User user) {
		String query = "insert into user(userId, password, name) " +
						"values(?,?,?)";
		try {
			Connection con = util.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.executeUpdate();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(User user) {
		String query = "update user " +
						"set password = ?" +
						"name = ?" +
						"where userId = ?";
		try {
			Connection con = util.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getUserId());
			pstmt.executeUpdate();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteByUserId(String userId) {
		String query = "delete from user where userId = ?";
		try {
			Connection con = util.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.executeUpdate();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}