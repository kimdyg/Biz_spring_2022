package com.callor.naver.service;

import org.springframework.stereotype.Service;

import com.callor.naver.config.QualifierConfig;
import com.callor.naver.persistance.MemberDao;

@Service(QualifierConfig.SERVICE.MEMBER_V1)
public interface MemberService extends MemberDao{

}
