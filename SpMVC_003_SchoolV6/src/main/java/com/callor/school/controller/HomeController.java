package com.callor.school.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.school.service.StudentService;

import lombok.extern.slf4j.Slf4j;
@Controller
@Slf4j
public class HomeController {
	
	/*
	 * 생성자 주입 방식
	 * HomeController homeController
	 * 		= new HomeController(stService)
	 */
	
	private final StudentService stService;
	public HomeController(StudentService stService) {
		this.stService = stService;
	}
	
	 /*
	  * 클래스에 @slf4j Annotation 을 부착하므로서 다음 코드를 
	  * lombok 이 대신 만들어준다
	  */
	//private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		log.trace("Hello");
		log.debug("Hello");
		log.info("Hello");
		log.warn("Hello");
		log.error("Hello");
		
		return "home";
	}
	
}
