package com.callor.dample.service;

import java.util.List;

import com.callor.dample.model.BoardTestDto;

public interface BoardTestService {

	public List<BoardTestDto> selectAll();

	public int insert(BoardTestDto boardDto);

	public BoardTestDto findBySeq(String bseq);

	public int update(BoardTestDto boardDto);

}
