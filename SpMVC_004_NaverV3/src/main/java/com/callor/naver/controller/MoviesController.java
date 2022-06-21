package com.callor.naver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/movies")
public class MoviesController {

	@RequestMapping(value = {"/",""})
	public String list() {
		return "movies/list";
	}
}
