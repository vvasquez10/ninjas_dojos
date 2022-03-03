package com.daxos.ninjas_dojos.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.daxos.ninjas_dojos.models.Ninja;
import com.daxos.ninjas_dojos.repositories.NinjaRepository;

@Service
public class NinjaService {

	@Autowired
	private NinjaRepository ninjaRepository;
	
	public List<Ninja> selectAllFromUNinjas(){
		return ninjaRepository.findAll();
	}
	
	public Ninja insertIntoNinjas( Ninja newNinja ) {
		return ninjaRepository.save( newNinja );
	}	

}
