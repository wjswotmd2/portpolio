package com.portfolio.www.index.controller;

import java.util.Calendar;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	

	@RequestMapping("/index.do")
	public ModelAndView index(@RequestParam HashMap<String, String> params) {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/auth/contactPage.do")
	public ModelAndView contactPage(@RequestParam HashMap<String, String> params) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("key", Calendar.getInstance().getTimeInMillis());
		mv.setViewName("auth/contact");
		
		return mv;
	}

}
