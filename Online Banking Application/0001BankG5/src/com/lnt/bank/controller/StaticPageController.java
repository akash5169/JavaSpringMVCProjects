package com.lnt.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lnt.bank.model.Login;

@Controller
public class StaticPageController {
	
	@RequestMapping(value = "/digital")
	public String showDigital(Model model) {
		
		return "digital";
	}
	

	@RequestMapping(value = "/contact")
	public String showContact(Model model) {
		
		return "contact";
	}
	

	@RequestMapping(value = "/map")
	public String showMap(Model model) {
		
		return "map";
	}
	

	@RequestMapping(value = "/about")
	public String showAbout(Model model) {
		
		return "about";
	}

}
