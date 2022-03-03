package com.daxos.ninjas_dojos.services;

import java.util.List;
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

}
