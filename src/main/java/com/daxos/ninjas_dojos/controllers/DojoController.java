package com.daxos.ninjas_dojos.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String newDojo(@Valid @ModelAttribute("dojo") Dojo dojo) {
				
		return "newDojo.jsp";	
	}	
	
	//localhost:8080/dojos/{id}
	@RequestMapping( value = "/{id}", method = RequestMethod.GET )
	public String showDojo(Model model) {
		
		//List<Expense> expenseList = expenseService.selectAllFromExpenses();
		//model.addAttribute( "expenseList", expenseList );
		
		return "showDojo.jsp";	
	}	
	
	@RequestMapping( value = "/createDojo", method = RequestMethod.POST )
	public String registrarUsuario( @Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		
		if ( result.hasErrors() ) {
			return "newDojo.jsp";
		}
		else {			
			dojoService.insertIntoDojos(dojo);	
			return "redirect:/dojos/new";
		}
	}

}
