package com.callor.memo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.memo.model.FilesVO;

public interface FileUpService {

	// 한개의 파일 업로드
	public String fileUp(MultipartFile file) throws Exception;
	//여러개 파일 업로드
	public List<FilesVO> filesUp(MultipartHttpServletRequest files) throws Exception;
	// 업로드한 파일 삭제
	public boolean fileDelete(String filename) throws Exception;
}
