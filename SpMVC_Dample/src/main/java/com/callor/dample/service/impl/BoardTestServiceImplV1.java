package com.callor.dample.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.dample.model.BoardTestDto;
import com.callor.dample.persistance.BoardTestDao;
import com.callor.dample.service.BoardTestService;

@Service
public class BoardTestServiceImplV1 implements BoardTestService {

	protected final BoardTestDao boardDao;
	
	public BoardTestServiceImplV1(BoardTestDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public List<BoardTestDto> selectAll() {
		return boardDao.selectAll();
	}

	@Override
	public int insert(BoardTestDto boardDto) {
		return boardDao.insert(boardDto);
	}

	@Override
	public BoardTestDto findBySeq(String bseq) {
		// TODO Auto-generated method stub
		return boardDao.findBySeq(bseq);
	}

	@Override
	public int update(BoardTestDto boardDto) {
		// TODO Auto-generated method stub
		return boardDao.update(boardDto);
	}

}
