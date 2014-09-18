package pl.kacper.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.kacper.spring.repository.PersonRepository;

@Controller
public class HelloWorldController {

	@Autowired
	private PersonRepository personRepository;
	
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
	
	@RequestMapping(value = "/persons")
	public String getPersons(Model model) {
		model.addAttribute("persons", personRepository.listPersons());
		return "persons";
	}
	
	@RequestMapping(value = "/person/{id}")
	public String getPersons(@PathVariable Integer id, Model model) {
		model.addAttribute("person", personRepository.getPersonById(id));
		return "person";
	}
}
