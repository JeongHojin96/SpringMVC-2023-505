package com.callor.dample.service;

import java.util.List;

import com.callor.dample.model.BoardDto;

public interface BoardService {

	public List<BoardDto> selectAll();

	public int insert(BoardDto boardDto) throws Exception;

	public BoardDto findBySeq(String bseq);

	public int update(BoardDto boardDto) throws Exception;
	
	public int delete(BoardDto boardDto) throws Exception;

	public int viewcountup(BoardDto boardDto);

}
