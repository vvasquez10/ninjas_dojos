package com.daxos.ninjas_dojos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daxos.ninjas_dojos.models.Dojo;
import com.daxos.ninjas_dojos.repositories.DojoRepository;

@Service
public class DojoService {
	
	@Autowired
	private DojoRepository dojoRepository;
	
	public List<Dojo> selectAllFromDojos(){
		return dojoRepository.findAll();
	}
	
	public Dojo insertIntoDojos( Dojo newDojo ) {
		return dojoRepository.save( newDojo );
	}	

	public Dojo findDojoById(Long id){
		Optional<Dojo> optionalResult = dojoRepository.findById(id);
		if(optionalResult.isPresent()) {			
			return optionalResult.get();
		} else {
			return null;
		}
	}
}
