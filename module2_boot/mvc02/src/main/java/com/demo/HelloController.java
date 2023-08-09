package com.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@GetMapping(path = "hellourl")
	public ModelAndView hello() {
		ModelAndView mv=new ModelAndView();//data + logical view name
		mv.setViewName("hello");
		mv.addObject("message", "spring mvc rock!");
		return mv;
		
	}

}
