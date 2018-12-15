package com.mphasis.mySpring5BootApp.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mphasis.mySpring5BootApp.utils.MyUtils;

@Controller
public class HelloController {
	
//	@Value("${app.name}")
//	private String appName;
	
//	@Autowired
//	private MessageSource messageSource;
	
	@RequestMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("name",
				MyUtils.getMessage("text",
						"http://below18.example.com",
						"http://above18.example.com"));
	return "hello";
	}
	
	
	@RequestMapping("/hello/{id}")
	//public String helloId(Model model,@PathVariable("id") int id, @RequestParam("name") String name) {
	public String helloId(Model model,@PathVariable int id, Optional<String> name) {
		model.addAttribute("id",id);
		model.addAttribute("name",name.orElse("No Name"));
		
		
	return "hello-id";
	}

//	@RequestMapping("/hello")
//	public ModelAndView hello() {
//		ModelAndView nav = new ModelAndView("hello"); //the logical view  name
//		nav.addObject("name","Dibas Behera");		
//		return nav;
//	}
	
}
