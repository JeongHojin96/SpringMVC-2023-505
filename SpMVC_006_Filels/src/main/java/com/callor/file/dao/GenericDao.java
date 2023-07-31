package com.callor.file.dao;

import java.util.List;

import com.callor.file.model.BBsDto;


/*
 * 제네릭 타입 인터페이스
 * 이 인터페이스는 다른 Dao 를 만들때
 */
public interface GenericDao<DTO, PK> {

	public List<DTO> seletAll();
	public DTO findById(PK id);
	
	public int insert(DTO dto);
	public int update(DTO dto);
	
	public int delete(PK id);
	
}
