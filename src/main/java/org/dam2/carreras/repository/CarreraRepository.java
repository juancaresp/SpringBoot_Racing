package org.dam2.carreras.repository;

import org.dam2.carreras.modelo.Carrera;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepository extends CrudRepository<Carrera, String> {
	
}
