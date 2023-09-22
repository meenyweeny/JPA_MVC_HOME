package com.ssafy.service.board;

import java.util.List;

import com.ssafy.dto.board.BoardDto;

public interface BoardService {

	void registerArticle(BoardDto boardDto);

	List<BoardDto> searchListAll();

	List<BoardDto> searchListBySubject(String subject);

	BoardDto viewArticle(int no);

	void modifyArticle(BoardDto boardDto);

	void deleteArticle(int no);

}
