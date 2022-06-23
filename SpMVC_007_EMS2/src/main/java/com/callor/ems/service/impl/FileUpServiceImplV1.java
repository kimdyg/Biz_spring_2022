package com.callor.ems.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.ems.service.FileUpService;
import com.callor.ems.service.QualifyConfig;

@Service(QualifyConfig.SERVICE.MAIL_V3)
public class FileUpServiceImplV1  implements FileUpService{

	@Autowired
	private String upPath;
	private ResourceLoader resourceLoader;
	
	public FileUpServiceImplV1(String upPath, ResourceLoader resourceLoader) {
		this.upPath = upPath;
		this.resourceLoader = resourceLoader;
	}

	@Override
	public String fileUp(MultipartFile file) throws Exception  {
		
		if(file == null) {
			return null;
		}

		String upLoadPath = resourceLoader
								.getResource("/resources/upload")
								.getURI()
								.getPath();
		
		String fileName = file.getOriginalFilename();
		
		File dir = new File(upLoadPath);
		
		if(!dir.exists()) {
			dir.mkdirs();
		}
		File upLoadFile = new File(upLoadPath, fileName);
		file.transferTo(upLoadFile);
		return fileName;
		
	}


	@Override
	public List<String> filesUp(MultipartHttpServletRequest mFile) {
		// TODO Auto-generated method stub
		return null;
	}

}
