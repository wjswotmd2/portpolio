package com.portfolio.www.auth.mybatis;

import org.springframework.stereotype.Repository;

import com.portfolio.www.auth.dto.MemberAuthDto;

@Repository
public interface MemberAuthRepository {
	//회원인증 정보추가
	public int addAuthInfo(MemberAuthDto memberAuthDto);
	
	//회원인증 uri가져오기
	public MemberAuthDto getAuthUri(String uri);
	
	//인증완료 후 auth_yn = 'Y'로 변경
	public int updateAuthInfo(MemberAuthDto memberAuthDto);
	
}
