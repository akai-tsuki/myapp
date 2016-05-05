package com.example.zzz;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/")
	public String sayHello(Model model) {
		model.addAttribute("message", "Hello world!!");
		return "index";
	}
}
