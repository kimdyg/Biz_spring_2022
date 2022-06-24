package com.callor.memo.service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.memo.model.BBsVO;
import com.callor.memo.persistance.BbsDao;

public interface BBsService  extends BbsDao{

	public String insertBbsAndFile(BBsVO bbsVO, MultipartFile file);
	public String insertBbsAndFiles(BBsVO bbsVO, MultipartHttpServletRequest files);
}
