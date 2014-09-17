package pl.kacper.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	@RequestMapping("/hello")
	public String hello(@RequestParam(value="name", required=false, defaultValue="Edgar") String name, Model model) {
		model.addAttribute("name", name);
		System.out.println(name);
		return "helloworld";
	}
	
	@RequestMapping(value = "/msg/{msg}")
	public String displayMessage(@PathVariable String msg, Model model) {
		model.addAttribute("name", msg);
		return "helloworld";
	}
}
