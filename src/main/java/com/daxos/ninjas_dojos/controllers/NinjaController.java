package com.daxos.ninjas_dojos.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.daxos.ninjas_dojos.models.Dojo;
import com.daxos.ninjas_dojos.models.Ninja;
import com.daxos.ninjas_dojos.services.DojoService;
import com.daxos.ninjas_dojos.services.NinjaService;

@Controller
@RequestMapping( "/ninjas" )
public class NinjaController {
	
	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;
	
	
	//localhost:8080/ninjas/new
	@RequestMapping( value = "/new", method = RequestMethod.GET )
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		
		List<Dojo> allDojos =  dojoService.selectAllFromDojos();
		System.out.println(allDojos);
		model.addAttribute("allDojos", allDojos);		
				
		return "newNinja.jsp";	
	}		

	@RequestMapping( value = "/createNinja", method = RequestMethod.POST )
	public String registrarDojo( @Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		
		
		
		if ( result.hasErrors() ) {
			return "newNinja.jsp";
		}
		else {			
			
			ninjaService.insertIntoNinjas(ninja);			
			return "redirect:/ninjas/new";
		}
	}
}
