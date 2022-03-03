package com.daxos.ninjas_dojos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daxos.ninjas_dojos.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	
	// SELECT * FROM usuarios
	List<Ninja> findAll();
	
	// INSERT INTO usuarios(nombre_usuario, nombre, apellido, identificador, password)
	// VALUES( Objecto con todos los datos )
	@SuppressWarnings("unchecked")
	Ninja save( Ninja newNinja );
}
