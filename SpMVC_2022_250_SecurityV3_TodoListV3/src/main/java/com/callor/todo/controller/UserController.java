package com.callor.todo.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.todo.model.AuthorityVO;
import com.callor.todo.model.UserVO;
import com.callor.todo.persistance.UserDao;
import com.callor.todo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String login(String error, Model model) {
		model.addAttribute("error",error);
		return "user/login";
		
	}
	@RequestMapping(value = "/join", method=RequestMethod.GET)
	public String join() {
		return null;
	}
	
	@RequestMapping(value = "/join", method=RequestMethod.POST)
	public String join(@ModelAttribute UserVO userVO) {
		userService.insert(userVO);
		log.debug(userVO.toString());
		log.debug("회원가입 데이터 : " + userVO);
		log.debug("회원가입 데이터 : {}", userVO);
		return null;
		
	}
	
	@PreAuthorize("hasAnyRole(['ROLE_USER','ROLE_ADMIN'])")
	@RequestMapping(value = "/mypage", method=RequestMethod.GET)
	public String mypage(Principal principal) {
		
		String username = principal.getName();
		
		return "user/mypage";
	}
}
