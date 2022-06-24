package com.callor.memo.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.memo.model.StudentVO;
import com.callor.memo.service.StudentService;

import lombok.extern.slf4j.Slf4j;
@Controller
@Slf4j
public class HomeController {
	private final StudentService stService;
	public HomeController(StudentService stService) {
		this.stService = stService;
	}
	//private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		List<StudentVO> stList = stService.selectAll();
		model.addAttribute("ST_LIST", stList);
		
		return "home";
	}
	
}
