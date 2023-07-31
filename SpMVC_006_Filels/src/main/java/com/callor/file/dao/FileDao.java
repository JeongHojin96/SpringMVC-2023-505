package com.callor.file.dao;

import java.util.List;

import com.callor.file.model.BBsDto;
import com.callor.file.model.FileDto;

public interface FileDao {

	public List<FileDto> seletAll();
	public FileDto findById(Long id);
	
	public List<FileDto> findByBSeq(long seq);
	
	public int insert(FileDto fileDto);
	public int update(FileDto fileDto);
	
	public int delete(Long id);
	
	public void create_file_table(String dumy);
	
}
