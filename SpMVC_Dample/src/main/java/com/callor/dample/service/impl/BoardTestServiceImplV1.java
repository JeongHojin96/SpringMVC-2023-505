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
	public int insert(BoardTestDto boardDto) throws Exception {
		if( boardDto.getB_title() == "" || boardDto.getB_content() == "" || boardDto.getB_nickname() == "" || boardDto.getB_password() == "") {
			throw new Exception("NO");
		}
		return boardDao.insert(boardDto);
	}

	@Override
	public BoardTestDto findBySeq(String bseq) {
		// TODO Auto-generated method stub
		return boardDao.findBySeq(bseq);
	}

	@Override
	public int update(BoardTestDto boardDto) throws Exception {
		String getpw = boardDto.getB_password();
		long bseq = boardDto.getB_seq();
		
		if (getpw == "") {
			throw new Exception("NONE");
		} else if(!boardDao.findPW(bseq).getB_password().equals(getpw)) {
			throw new Exception("PASS_WORD");
		}
		return boardDao.update(boardDto);
		
	}

	@Override
	public int viewcountup(BoardTestDto boardDto) {
		// TODO Auto-generated method stub
		return boardDao.countup(boardDto);
	}

	@Override
	public int delete(BoardTestDto boardDto) throws Exception {
		String getpw = boardDto.getB_password();
		long bseq = boardDto.getB_seq();
		
		if (getpw == "") {
			throw new Exception("NONE");
		} else if(!boardDao.findPW(bseq).getB_password().equals(getpw)) {
			throw new Exception("PASS_WORD");
		}
		return boardDao.delete(boardDto);
	}

}
