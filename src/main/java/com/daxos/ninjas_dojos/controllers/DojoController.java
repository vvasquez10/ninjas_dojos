package com.daxos.ninjas_dojos.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.daxos.ninjas_dojos.models.Dojo;
import com.daxos.ninjas_dojos.services.DojoService;

@Controller
@RequestMapping( "/dojos" )
public class DojoController {

	@Autowired
	private DojoService dojoService;
	
	//localhost:8080/dojos/new
	@RequestMapping( value = "/new", method = RequestMethod.GET )
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
				
		return "newDojo.jsp";	
	}	
	
	//localhost:8080/dojos/{id}
	@RequestMapping( value = "/{dojo_id}", method = RequestMethod.GET )
	public String showDojo(Model model, @PathVariable("dojo_id") Long dojo_id) {
		
		//Finds the dojo to show
		model.addAttribute( "foundedDojo", dojoService.findDojoById(dojo_id));
		
		return "showDojo.jsp";	
	}	
	
	@RequestMapping( value = "/createDojo", method = RequestMethod.POST )
	public String registrarDojo( @Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		
		if ( result.hasErrors() ) {
			return "newDojo.jsp";
		}
		else {			
			dojoService.insertIntoDojos(dojo);			
			System.out.println("Hecho");
			return "redirect:/dojos/new";
		}
	}

}
