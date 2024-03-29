package com.callor.score.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.score.model.StudentVO;
import com.callor.score.persistance.StudentDao;
import com.callor.score.service.StudentService;

@Service
public class StudentServiceImplV1 implements StudentService{

	@Autowired
	private StudentDao stDao;
	
	@Override
	public List<StudentVO> selectAll() {
		
		return stDao.selectAll();
	}

	@Override
	public StudentVO findById(String id) {
		// TODO Auto-generated method stub
		return stDao.findById(id);
	}

	@Override
	public int insert(StudentVO vo) {
		// TODO Auto-generated method stub
		return stDao.insert(vo);
	}

	@Override
	public int update(StudentVO vo) {
		// TODO Auto-generated method stub
		return stDao.update(vo);
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return stDao.delete(id);
	}

}
