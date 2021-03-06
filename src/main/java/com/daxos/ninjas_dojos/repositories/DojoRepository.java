package com.daxos.ninjas_dojos.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daxos.ninjas_dojos.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long>{
	
	// SELECT * FROM dojos
	List<Dojo> findAll();
	
	// INSERT INTO usuarios(nombre_usuario, nombre, apellido, identificador, password)
	// VALUES( Objecto con todos los datos )
	@SuppressWarnings("unchecked")
	Dojo save( Dojo newDojo );
	
	Optional<Dojo> findById( Long id );
}
