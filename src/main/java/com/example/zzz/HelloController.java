package com.example.zzz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@Autowired
	private StringRedisTemplate template;

	@RequestMapping(name = "/", method = RequestMethod.GET)
	public String sayHello(Model model) {
		model.addAttribute("message", "Hello World!!");

		String before = template.opsForValue().get("name");
		if (null == before) {
			before = "null";
		}
		model.addAttribute("before", before);

		return "index";
	}

	@RequestMapping(name = "/", method = RequestMethod.POST)
	public String createHelloMessage(@RequestParam("name") String name, Model model) {
		model.addAttribute("message", "Hello World!! " + name + "さん");
		String before = template.opsForValue().get("name");

		if (null == before) {
			before = "null";
		}

		model.addAttribute("before", before);
		template.opsForValue().set("name", name);

		return "index";

	}

}
