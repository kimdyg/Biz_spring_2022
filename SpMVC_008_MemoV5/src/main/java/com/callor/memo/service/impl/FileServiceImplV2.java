package com.callor.memo.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.memo.config.QualifierConfig;
import com.callor.memo.model.FilesVO;
import com.callor.memo.service.FileUpService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(QualifierConfig.SERVICE.FILE_V2)
public class FileServiceImplV2 implements FileUpService{
	
	private final String upLoadFolder;
	public FileServiceImplV2(String upLoadFolder) {
		this.upLoadFolder = upLoadFolder;
	}

	@Override
	public String fileUp(MultipartFile file) throws Exception {

		if(file == null) {
			return null;
		}
		File dir = new File(upLoadFolder);
		if( !dir.exists()) {
			dir.mkdirs();
		}
		
		String fileName = file.getOriginalFilename();
		String strUUID = UUID.randomUUID().toString();
		
		fileName = String.format("%s-%s", strUUID, fileName);
		log.debug("파일 이름 {} :",fileName);
		
		File upLoadFile = new File(upLoadFolder, fileName);
		file.transferTo(upLoadFile);
		return fileName;
		
	}

	@Override
	public List<FilesVO> filesUp(MultipartHttpServletRequest files) throws Exception {


		List<MultipartFile> fileList = files.getFiles("mFile");
		
		List<FilesVO> retFiles = new ArrayList<>();
		for(MultipartFile file : fileList) {
			
			String originName = file.getOriginalFilename();
			String uuName = this.fileUp(file);
			
			FilesVO fileVO = FilesVO.builder()
					.i_originalName(originName)
					.i_imageName(uuName)
					.build();
			
			retFiles.add(fileVO);
			
		}
		
		return retFiles;
	}

	@Override
	public boolean fileDelete(String filename) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
