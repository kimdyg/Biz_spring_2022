package com.callor.todo.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.todo.model.MemoDTO;
import com.callor.todo.service.MemoService;

@Controller
@RequestMapping(value = "/memo")
public class TodoController {

	private final MemoService memoService;
	public TodoController(MemoService memoService) {
		this.memoService = memoService;
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model,HttpSession httpSession) {
		
		String username = (String) httpSession.getAttribute("USERNAME");
		if(username != null) {
			List<MemoDTO> memos = memoService.findByAuthor(username);
			model.addAttribute("MEMOS", memos);
		}
		return "/memo/home";
	}
	
}
