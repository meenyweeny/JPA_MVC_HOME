package com.ssafy.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.BoardDto;
import com.ssafy.util.DBUtil;

public class BoardDaoImpl implements BoardDao {

	private static BoardDao boardDao = new BoardDaoImpl();
	
	private BoardDaoImpl() {}
	
	public static BoardDao getBoardDao() {
		return boardDao;
	}
	
	@Override
	public void registerArticle(BoardDto boardDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		//dto를 table에 insert
		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuilder sql = new StringBuilder("insert into board (user_id, subject, content) \n");
			sql.append("value (?,?,?)");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, boardDto.getUserId());
			pstmt.setString(2, boardDto.getSubject());
			pstmt.setString(3, boardDto.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<BoardDto> searchListAll() {
		List<BoardDto> list = new ArrayList<BoardDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuilder sql = new StringBuilder("select article_no, user_id, subject, content, register_time \n");
			sql.append("from board \n");
			sql.append("order by article_no desc limit 0, 20");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setArticleNo(rs.getInt("article_no"));
				boardDto.setUserId(rs.getString("user_id"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setRegisterTime(rs.getString("register_time"));

				list.add(boardDto);
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(rs, pstmt, conn);
		}
		
		return list;
	}

	@Override
	public List<BoardDto> searchListBySubject(String subject) {
		List<BoardDto> list = new ArrayList<BoardDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuilder sql = new StringBuilder("select article_no, user_id, subject, content, resister_time \n");
			sql.append("from board \n");
			sql.append("where suject = ?");
			sql.append("order by article_no desc limit 0, 20");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, subject);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setArticleNo(rs.getInt("article_no"));
				boardDto.setUserId(rs.getString("user_id"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setRegisterTime(rs.getString("resister_time"));

				list.add(boardDto);
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(rs, pstmt, conn);
		}
		
		return list;
	}

	@Override
	public BoardDto viewArticle(int no) {
		
		
		return null;
	}

	@Override
	public void modifyArticle(BoardDto boardDto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteArticle(int no) {
		// TODO Auto-generated method stub

	}

}
