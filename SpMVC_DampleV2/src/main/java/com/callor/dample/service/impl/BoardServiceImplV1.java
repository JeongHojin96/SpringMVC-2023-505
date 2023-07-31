package com.callor.dample.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.dample.model.BoardDto;
import com.callor.dample.persistance.BoardDao;
import com.callor.dample.service.BoardService;

@Service
public class BoardServiceImplV1 implements BoardService {

	protected final BoardDao boardDao;
	
	public BoardServiceImplV1(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public List<BoardDto> selectAll() {
		return boardDao.selectAll();
	}

	@Override
	public int insert(BoardDto boardDto) throws Exception {
		if( boardDto.getB_title().isBlank() || boardDto.getB_content().isBlank() || boardDto.getB_nickname().isBlank()  || boardDto.getB_password().isBlank()) {
			throw new Exception("NO");
		}
		return boardDao.insert(boardDto);
	}

	@Override
	public BoardDto findBySeq(String bseq) {
		// TODO Auto-generated method stub
		return boardDao.findBySeq(bseq);
	}

	@Override
	public int update(BoardDto boardDto) throws Exception {
		String getpw = boardDto.getB_password();
		long bseq = boardDto.getB_seq();
		if( boardDto.getB_title().isBlank() || boardDto.getB_content().isBlank() || boardDto.getB_nickname().isBlank()  || boardDto.getB_password().isBlank()) {
			throw new Exception("NO");
		}
		if (getpw == "") {
			throw new Exception("NONE");
		} else if(!boardDao.findPW(bseq).getB_password().equals(getpw)) {
			throw new Exception("PASS_WORD");
		}
		return boardDao.update(boardDto);
		
	}

	@Override
	public int viewcountup(BoardDto boardDto) {
		// TODO Auto-generated method stub
		return boardDao.countup(boardDto);
	}

	@Override
	public int delete(BoardDto boardDto) throws Exception {
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
