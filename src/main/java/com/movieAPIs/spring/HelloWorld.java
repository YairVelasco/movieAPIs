package com.movieAPIs.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorld {
	
	
	@RequestMapping("/SayHello")
	public ModelAndView showMessage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("HelloWorld");
		return mv;
	}
}
