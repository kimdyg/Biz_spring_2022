package com.callor.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

/*
 *  Spring 아 HomeController 클래스를 객체로 생성하여
 *  container에 보관해 줘
 */
@Slf4j
@Controller
public class HomeController {
	
	/*
	 * http://localhost:8080/hello/ GET 로 요청이 들어오면
	 *	/WEB-INF/views/home.jsp 파일을 rendering 하여
	 *	html 코드로 변환한 후 응답하라 1998
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		// Model model 객체
		// jsp 파일을 rendering 할때 사용할 데이터를 보내기 위한 장바구니
		// "NATION 이라는 이름의 변수에 '대한민국' 문자열을 담아서
		// JSP 에게 보내겠다" 라는 의미
		model.addAttribute("NATION","대한민국");
		
		return "home";
	}
	/*
	 * form 을 통해 입력한 데이터를 보내면
	 * method 의 매개변수를 통하여 데이터를 수신한다
	 * 
	 * form에 두개의 input box 가 있고
	 * 각각 name 속성이 nation, age 로 설정되어있다
	 * gakgak name 속성이 변수로 변환되어 Controller 의 method 로
	 * 전달된다
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(String nation, String age) {
		
		log.debug("국가명 {}", nation);
		log.debug("나이 {}", age);
		return "home";
	}
	
}
