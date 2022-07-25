package com.callor.score.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.score.model.StudentVO;
import com.callor.score.service.StudentService;

/*
 * Cors 오류가 발생하지 않도록 서버에서 설정하기
 * React 의 fecth 요청에 대하여 CORS 문제를 건너 뛰도록 설정하기
 */
@CrossOrigin({"http://localhost:3000","http://127.0.0.1"})
@Controller
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	private StudentService stService;
	
	@RequestMapping(value = {"/",""}, method=RequestMethod.GET)
	public String home(Model model) {
		List<StudentVO> stList =stService.selectAll();
		model.addAttribute("STLIST",stList);
		
		return "student/list";
	}
	
	@RequestMapping(value = "/detail",method=RequestMethod.GET)
	public String detail(String st_num) {
		return "student/detail";
	}

	@ResponseBody
	@RequestMapping(value = "/json", method=RequestMethod.GET)
	public List<StudentVO> home() {
		List<StudentVO> stList =stService.selectAll();
				
		return stList;
	}
	@ResponseBody
	@RequestMapping(value = "/{st_num}/delete")
	public String delete(@PathVariable("st_num") String st_num) {
		int ret = stService.delete(st_num);
		if(ret > 0) {
			return "OK";
		} else {
			return "FAIL";
		}
		
	}
}
