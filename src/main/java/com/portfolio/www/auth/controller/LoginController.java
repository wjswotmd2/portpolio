package com.portfolio.www.auth.controller;

import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.portfolio.www.auth.dto.MemberDto;
import com.portfolio.www.auth.service.LoginService;
import com.portfolio.www.message.MessageEnum;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/auth/loginPage.do")
	public ModelAndView loginPage(@RequestParam HashMap<String, String> params) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("key", Calendar.getInstance().getTimeInMillis());
		mv.setViewName("auth/login");
		
		return mv;
	}
	
	@RequestMapping("/auth/recoverPassPage.do")
	public ModelAndView recoverPassPage(@RequestParam HashMap<String, String> params) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("key", Calendar.getInstance().getTimeInMillis());
		mv.setViewName("auth/recover-pass");
		
		return mv;
	}
	
	@RequestMapping("/auth/login.do")
	public ModelAndView login(
			HttpServletRequest request,
			@RequestParam HashMap<String, String> params) {
		ModelAndView mv = new ModelAndView();
		MemberDto memberDto = null;
		
		try {
			memberDto = loginService.login(params);	//사용자 확인
			if(!ObjectUtils.isEmpty(memberDto)) {	//로그인을 했으면 null값이 아닐테니
				//세션 처리
				//세션을 불러와서
				HttpSession session = request.getSession();
				//memberId넣어줌
				session.setAttribute("memberId", memberDto.getMemberId());
				mv.setViewName("forum/notice/list");
			}else {	//비밀번호가 다른경우
				mv.setViewName("login");
				mv.addObject("code", "9001");
				mv.addObject("msg", "비밀번호가 틀렸습니다");
			}
		} catch (EmptyResultDataAccessException e) { //사용자가 없는경우
			mv.setViewName("login");
			mv.addObject("code", "9000");
			mv.addObject("msg", "가입된 사용자가 없습니다");
		}
		return mv;
	}
	

}
