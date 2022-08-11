package com.callor.todo.service;

import java.util.List;

import com.callor.todo.model.MemoDTO;

public interface MemoService {


	public List<MemoDTO> selectAll();
	public MemoDTO findById(Long seq);
	public List<MemoDTO> findByAuthor(String username);
	
}
