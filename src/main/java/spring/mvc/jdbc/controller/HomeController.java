package spring.mvc.jdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public String home(){
		System.out.println("Sat Saheb, Saheb mehar Krenge");
		System.out.println("Application | Home");
		return "home";
	}

}
