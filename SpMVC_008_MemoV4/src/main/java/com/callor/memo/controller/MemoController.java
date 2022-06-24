package com.callor.memo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.MemoVO;
import com.callor.memo.persistance.FileDao;
import com.callor.memo.service.MemoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequestMapping(value = "/memo")
public class MemoController {
	
	
	@Autowired
	private MemoService memoService;
	
	@Autowired
	private FileDao fileDao;
	
	@RequestMapping(value = "/write", method=RequestMethod.GET)
	public String write(@ModelAttribute("memoVO") MemoVO memoVO, Model model) {
		model.addAttribute("memoVO",memoVO);
		return "memo/input";
	}

	// 0616여기에 MultipartFile file
	@RequestMapping(value = "/write",method=RequestMethod.POST)
	public String write(@ModelAttribute("memoVO") MemoVO memoVO,@RequestParam("up_file") MultipartFile file, Model model) {
		
		log.debug("받은데이터 {}",memoVO.toString());
		log.debug("받은파일 {}",file.getOriginalFilename());
		
		String imageFile = memoService.insertMemoAndFile(memoVO,file);
		model.addAttribute("IMAGE",imageFile);
		
		return "redirect:/";
		
	}
	@RequestMapping(value = "/detail",method=RequestMethod.GET)
	public String detail(String seq,Model model) {
		try {
			long b_seq = Long.valueOf(seq);
			MemoVO memoVO = memoService.findById(b_seq);
			memoVO.setImages(fileDao.findByBBsSeq(b_seq));
			model.addAttribute("MEMO",memoVO);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	@ModelAttribute("memoVO")
	private MemoVO memoVO() {
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		
		MemoVO memoVO = MemoVO.builder()
					.b_date(dayFormat.format(date))
					.b_time(timeFormat.format(date))
					.b_writer("callor")
					.build();
		log.debug(memoVO.toString());
		return memoVO;
	}
}
