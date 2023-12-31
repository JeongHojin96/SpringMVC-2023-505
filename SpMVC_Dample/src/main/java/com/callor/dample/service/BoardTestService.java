package com.callor.dample.service;

import java.util.List;

import com.callor.dample.model.BoardTestDto;

public interface BoardTestService {

	public List<BoardTestDto> selectAll();

	public int insert(BoardTestDto boardDto) throws Exception;

	public BoardTestDto findBySeq(String bseq);

	public int update(BoardTestDto boardDto) throws Exception;
	
	public int delete(BoardTestDto boardDto) throws Exception;

	public int viewcountup(BoardTestDto boardDto);

}
