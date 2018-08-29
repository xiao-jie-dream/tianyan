package com.colourfulchina.tianyan.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class StudentViewController {

	@GetMapping("/demo")
	public String indexView(ModelMap modelMap){
		modelMap.addAttribute("name","测试数据");
		return "/index";
	}
}
