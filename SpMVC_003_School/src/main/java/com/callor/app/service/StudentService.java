package com.callor.app.service;

import java.util.List;

import com.callor.app.domain.StudentVO;

public interface StudentService {

	public int insert(StudentVO studentVO); // 데이터추가

	public List<StudentVO> selectAll(); // 전체리스트 가져오기

	public StudentVO findById(String stNum); // 1개의 데이터 가져오기
}
