package com.portfolio.www.auth.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.portfolio.www.auth.dto.MemberDto;
import com.portfolio.www.auth.mybatis.MemberRepository;

import at.favre.lib.crypto.bcrypt.BCrypt;

@Service
public class LoginService {
	
	@Autowired
	private MemberRepository memberRepository;

	public MemberDto login(HashMap<String, String> params) throws EmptyResultDataAccessException {
		//사용자 찾기
		MemberDto memberDto = memberRepository.getMember(params.get("memberId"));
		String passwd = params.get("passwd"); 
		 //사용자가 입력한 비밀번호
		String dbpasswd = memberDto.getPasswd(); 
		
		BCrypt.Result result = BCrypt.verifyer().verify(passwd.toCharArray(), dbpasswd);

		return result.verified ? memberDto : null ;
	}
	
}
