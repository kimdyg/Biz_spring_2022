package com.callor.memo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.memo.service.MemoService;
import com.callor.memo.vo.MemoVO;

public class MemoController {

	@Autowired
	public MemoService memoService;
	
	@RequestMapping(value = "/view_m",method=RequestMethod.GET)
	public String m_list(@ModelAttribute("memoVO") MemoVO memoVO, Model model) {
		model.addAttribute("memoVO",memoVO);
		return null;
	}
	@RequestMapping(value = "/view_m",method=RequestMethod.POST)
	public String m_list() {
		return null;
	}
}
