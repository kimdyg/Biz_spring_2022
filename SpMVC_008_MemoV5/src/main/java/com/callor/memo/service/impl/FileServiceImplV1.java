package com.callor.memo.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.memo.config.QualifierConfig;
import com.callor.memo.model.FilesVO;
import com.callor.memo.service.FileUpService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(QualifierConfig.SERVICE.FILE_V1)
public class FileServiceImplV1 implements FileUpService{
	

	private final ResourceLoader resLoader;
	public FileServiceImplV1(ResourceLoader resLoader) {
		this.resLoader= resLoader;
}
	
	public String fileUp(MultipartFile file) throws Exception {
	if(file ==null) {
		return null;
	}
	String upLoadPath = resLoader.getResource("/static/upload")
							.getURI()
							.getPath();
	log.debug("업로드폴더 {}", upLoadPath);
	
	String fileName = file.getOriginalFilename();
	
	File dir = new File(upLoadPath);
	if( !dir.exists()) {
		dir.mkdirs();
	}
	File upLoadFile = new File(upLoadPath, fileName);
	file.transferTo(upLoadFile);
		return fileName;
	}

	@Override
	public List<FilesVO> filesUp(MultipartHttpServletRequest files) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean fileDelete(String filename) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
