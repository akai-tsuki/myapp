package com.example.zzz;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@RequestMapping(name = "/", method = RequestMethod.GET)
	public String sayHello(Model model) {
		model.addAttribute("message", "Hello World!!");
		return "index";
	}

	@RequestMapping(name = "/", method = RequestMethod.POST)
	public String createHelloMessage(@RequestParam("name") String name, Model model) {
		model.addAttribute("message", "Hello World!!" + name + "さん");
		return "index";

	}

}
