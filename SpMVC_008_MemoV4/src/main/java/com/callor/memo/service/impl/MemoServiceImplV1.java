package com.callor.memo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.memo.config.QualifierConfig;
import com.callor.memo.model.MemoVO;
import com.callor.memo.model.FilesVO;
import com.callor.memo.persistance.MemoDao;
import com.callor.memo.persistance.FileDao;
import com.callor.memo.service.MemoService;
import com.callor.memo.service.FileUpService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(QualifierConfig.SERVICE.MEMO_V1)
public class MemoServiceImplV1 implements MemoService{

	protected final MemoDao memoDao;
	protected final FileUpService fileService;
	protected final FileDao fileDao;
	
	public MemoServiceImplV1(MemoDao memoDao, @Qualifier(QualifierConfig.SERVICE.FILE_V2) FileUpService fileService, FileDao fileDao) {
		super();
		this.memoDao = memoDao;
		this.fileService = fileService;
		this.fileDao = fileDao;
	}

	@Override
	public String insertMemoAndFile(MemoVO memoVO, MultipartFile file) {

		int ret = memoDao.insert(memoVO);
		
		if(ret > 0) {
			try {
				String fileName = fileService.fileUp(file);
				
				FilesVO imageVO = FilesVO.builder()
						.i_originalName(file.getOriginalFilename())
						.i_imageName(fileName)
						.i_bseq(memoVO.getB_seq())
						.build();
				
				fileDao.insert(imageVO);
				log.debug(imageVO.toString());
				return imageVO.getI_imageName();
				
			} catch (Exception e) {
				e.printStackTrace();
				// TODO Auto-generated catch block
				return "FILE UP FAIL";
			}
			
					
			
		}
		
		return null;
		
	}

	@Override
	public String insertMemoAndFiles(MemoVO memoVO, MultipartHttpServletRequest files) {

		int ret = memoDao.insert(memoVO);
		try {
			List<FilesVO> fileNames = fileService.filesUp(files);
			for(FilesVO file : fileNames) {
				file.setI_bseq(memoVO.getB_seq());
			}
			ret = fileDao.insertFiles(fileNames);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}


	@Override
	public void create_bbs_table() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MemoVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemoVO findById(Long id) {
		// TODO Auto-generated method stub 아자아자 화이팅~~~!!!
		return memoDao.findById(id);
	}

	@Override
	public int insert(MemoVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(MemoVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
