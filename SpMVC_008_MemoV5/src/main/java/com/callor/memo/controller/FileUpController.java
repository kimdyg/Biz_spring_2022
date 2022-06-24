package com.callor.memo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.memo.model.MemoVO;
import com.callor.memo.service.MemoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/file")
public class FileUpController {

	private final MemoService memoService;
	public FileUpController(MemoService memoService) {
		this.memoService = memoService;
	}
	
	@RequestMapping(value = "/fileups", method=RequestMethod.GET)
	public String upFiles(@ModelAttribute("memoVO") MemoVO memoVO, Model model) {
		
		return null;
	}
	@RequestMapping(value = "/fileups", method=RequestMethod.POST)
	public String upFiles(@ModelAttribute("memoVO") MemoVO memoVO, MultipartHttpServletRequest mFiles, Model model) {
		
		memoService.insertMemoAndFiles(memoVO, mFiles);
		
		return null;
	}
	@ModelAttribute("memoVO")
	private MemoVO memoVO() {
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		
		MemoVO memoVO = MemoVO.builder()
					.m_date(dayFormat.format(date))
					.m_time(timeFormat.format(date))
					.m_author("")
					.build();
		log.debug(memoVO.toString());
		return memoVO;
	}
	
}
