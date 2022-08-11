package com.callor.todo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.todo.model.MemoDTO;
import com.callor.todo.persistance.MemoDao;
import com.callor.todo.service.MemoService;

@Service
public class MemoServiceImplV1 implements MemoService{

	@Autowired
	private MemoDao memoDao;
	
	@Autowired
	public void create_table() {
		memoDao.create_memo_table();
	}
	
	@Override
	public List<MemoDTO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemoDTO findById(Long seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemoDTO> findByAuthor(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
