package com.callor.app;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		// model 객체에 변수명="데이터" 속성을 추가하여
		// jsp 에  rendering 할 데이터를 준비하기
		// model.addAttribute("변수명", "데이터")
		model.addAttribute("my_name", "홍길동" );
		
		String[] st = {"홍길동", "이몽룡", "성춘향"};
		model.addAttribute("ST", st );
		
		return "home";
	}
	
}
