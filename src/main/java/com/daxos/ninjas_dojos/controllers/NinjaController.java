package com.daxos.ninjas_dojos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping( "/ninjas" )
public class NinjaController {
	
	//localhost:8080/ninjas/new
	@RequestMapping( value = "/new", method = RequestMethod.GET )
	public String newNinja(Model model) {
				
		return "newNinja.jsp";	
	}		

}
