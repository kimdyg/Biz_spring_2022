package com.callor.school.service.impl;

import org.springframework.stereotype.Service;

import com.callor.school.model.UserVO;
import com.callor.school.service.UserService;

import lombok.extern.slf4j.Slf4j;

/*
 * UserServiceImplV1 클래스를 Component(bean) 로 등록하기
 */
@Slf4j
@Service
public class UserServiceImplV1 implements UserService{

	@Override
	public UserVO login(UserVO userVO) {

		log.debug(userVO.toString());
		
		String username = userVO.getUsername();
		String password = userVO.getPassword();
		
		if(username.equalsIgnoreCase("kimdyg") && password.equals("12341234")) {
			
			userVO.setName("김대영");
			userVO.setRole("ADMIN");
			userVO.setEmail("rlaeldud9502@naver.com");
			
		} else {
			userVO = null;
		}
		
		return userVO;
	}

	@Override
	public UserVO join(UserVO userVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
