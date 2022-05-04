package com.callor.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.school.service.StudentService;

/*
 * Controller level 에 @ReauestMapping 을 설정하면
 * Controller 의 mapping 과 method의 mapping 서로 연결되어
 * RequestMapping 을 구성한다
 * localhost:8080/school/student : StudentController 의 mapping 이 연동
 * localhost:8080/school/student/list : StudentController#list() 의 mapping 이 연결
 */
@RequestMapping(value = "/student")
@Controller
public class StudentController {
	
	/*
	 * Dependency inject 중
	 * 생성자 injection
	 */
	private final StudentService stService;
	public StudentController(StudentService stService) {
		this.stService = stService;
	}
/*
 * return type 이 String type 인 method 의 경우
 * null 값은 return 하면 Request Path 와 같은 jsp 파일을 찾아서
 * rendering 을 수행한다.
 * 단, @ResponseBody 설정이 없어야 한다.
 * localhost:8080/school/student/list
 * 
 */
	@RequestMapping(value = "/list_view", method = RequestMethod.GET)
	public String list() {
		// RequestMapping 이 /student/list 이기 때문에
		// return 을 실행하면
		// return "student/list" 를 수행한 것과 동일한 효과가 있음
		return null;
	}

	@RequestMapping(value = "/list_view2", method = RequestMethod.GET)
	public String list_view2() {
		return null;

	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {
		return "/student/insert";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update() {
		return null;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete() {
		return null;
	}
}
