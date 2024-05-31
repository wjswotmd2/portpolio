package com.portfolio.www.auth.controller;

import java.util.Calendar;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.portfolio.www.auth.service.JoinService;

@Controller
public class JoinController {
	
	@Autowired
	private JoinService joinService;
	
	@RequestMapping("/auth/joinPage.do")
	public ModelAndView joinPage(@RequestParam HashMap<String, String> params) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("key", Calendar.getInstance().getTimeInMillis());
		mv.setViewName("auth/join");
		
		return mv;
	}
	
	@RequestMapping("/auth/join.do")
	public ModelAndView join(@RequestParam HashMap<String, String> params) {
		
		int result = joinService.join(params);
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", result);
		
		String msg;
		if (result == 1) {
			msg = "회원가입이 되었습니다";
		}else {
			msg = "중복 아이디 입니다. 회원가입 실패하였습니다";
		}
		
		mv.addObject("msg", msg);
		mv.setViewName("auth/login");
		return mv;
	}
	
	@RequestMapping("/auth/emailAuth.do")	//회원 인증메일 링크
	public ModelAndView emailAuth(@RequestParam("uri") String uri) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("auth/login");	//login.jsp로 연결
//		joinService.emailAuth(uri);	//uri로 검색하여 auth_uri 맞는지와 auth_yn=n인지 확인
		
		boolean result = joinService.emailAuth(uri);	//uri로 검색하여 auth_uri 맞는지와 auth_yn=n인지 확인
		mv.addObject("result", result);
		String msg = result ? "인증 성공하였습니다." : "인증 만료되었습니다.";
		mv.addObject("msg", msg); 
		return mv;
	}

}
