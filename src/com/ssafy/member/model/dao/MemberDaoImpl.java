package com.ssafy.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.member.model.MemberDto;
import com.ssafy.util.DBUtil;

public class MemberDaoImpl implements MemberDao {
 	private static MemberDao memberdao = new MemberDaoImpl();
 
 	private MemberDaoImpl() {}
	
 	public static MemberDao getMemberdao() {
		return memberdao;
	}
 	
	@Override
	public void registerMember(MemberDto memberDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuilder sql = new StringBuilder("insert into members (user_id, user_name, user_pass, joindate) \n");
			sql.append("value (?,?,?,?)");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, memberDto.getUserId());
			pstmt.setString(2, memberDto.getUserName());
			pstmt.setString(3, memberDto.getUserPass());
			pstmt.setString(4, memberDto.getJoinDate());
			pstmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(pstmt, conn);
		}
		
	}

	@Override
	public MemberDto login(String userId, String userPass) {
		MemberDto memberDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuilder sql = new StringBuilder("select * from members \n");
			sql.append("where user_id=? and user_pass=?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userId);
			pstmt.setString(2, userPass);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberDto = new MemberDto();
				memberDto.setUserId(rs.getString("user_Id"));
				memberDto.setUserName(rs.getString("user_name"));
				memberDto.setUserPass(rs.getString("user_pass"));
				memberDto.setJoinDate(rs.getString("joindate"));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(rs, pstmt, conn);
		}
		return memberDto;
	}

	@Override
	public void modifyMember(MemberDto memberDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuilder sql = new StringBuilder("update members set user_pass=? where user_id=?\n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, memberDto.getUserPass());
			pstmt.setString(2, memberDto.getUserId());
			if (pstmt.executeUpdate()>0) System.out.println("변경 성공");
			else System.out.println("대상 없음");
		} catch (SQLException e){
			e.printStackTrace();
			System.out.println("변경 실패");
		} finally {
			DBUtil.getInstance().close(pstmt, conn);
		}

	}

	@Override
	public void deleteMember(String userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuilder sql = new StringBuilder("delete from members where user_id=?\n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userId);
			if (pstmt.executeUpdate()>0) System.out.println("삭제 성공");
			else System.out.println("대상 없음");
		} catch (SQLException e){
			System.out.println("삭제 실패");
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(pstmt, conn);
		}

	}
}
