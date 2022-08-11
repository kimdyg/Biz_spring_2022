package com.callor.todo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.todo.model.UserVO;
import com.callor.todo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/join",method=RequestMethod.GET)
	public String join() {
		return "users/join";
	}
	@RequestMapping(value = "/join",method=RequestMethod.POST)
	public String join(UserVO userVO) {
		
		log.debug("회원가입 정보 {}", userVO);
		userService.insert(userVO);
		return "redirect:/login";
	}
	@PreAuthorize("hasAnyRole(['ROLE_ADMIN','ROLE_USER'])")
	@RequestMapping(value = "/mypage",method=RequestMethod.GET)
	public String mypage(Principal principal ) {
		String username = principal.getName();
		return "users/mypage";
		
	}
	@RequestMapping(value = "/mypage2",method=RequestMethod.GET)
	public String mypage(@AuthenticationPrincipal UserVO userVO) {
		
		return "users/mypage";
	}

}
