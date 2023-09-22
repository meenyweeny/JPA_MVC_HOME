package com.ssafy.service.board;

import java.util.List;

import com.ssafy.dao.board.BoardDao;
import com.ssafy.dao.board.BoardDaoImpl;
import com.ssafy.dto.board.BoardDto;

public class BoardServiceImpl implements BoardService {
	// singleton으로 생성
	
	private static BoardService boardService = new BoardServiceImpl();
	
	private BoardServiceImpl() {}
	
	public static BoardService getBoardService() {
		return boardService;
	}



	@Override
	public void registerArticle(BoardDto boardDto) {
		BoardDaoImpl.getBoardDao().registerArticle(boardDto);
	}

	@Override
	public List<BoardDto> searchListAll() {
		return BoardDaoImpl.getBoardDao().searchListAll();
	}

	@Override
	public List<BoardDto> searchListBySubject(String subject) {
		return BoardDaoImpl.getBoardDao().searchListBySubject(subject);
	}

	@Override
	public BoardDto viewArticle(int no) {
		return BoardDaoImpl.getBoardDao().viewArticle(no);
	}

	@Override
	public void modifyArticle(BoardDto boardDto) {
		BoardDaoImpl.getBoardDao().modifyArticle(boardDto);
	}

	@Override
	public void deleteArticle(int no) {
		BoardDaoImpl.getBoardDao().deleteArticle(no);
	}

}
