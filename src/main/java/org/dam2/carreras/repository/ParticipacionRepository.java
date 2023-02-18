package org.dam2.carreras.repository;

import java.util.List;

import org.dam2.carreras.modelo.Carrera;
import org.dam2.carreras.modelo.Participacion;
import org.springframework.data.repository.CrudRepository;

public interface ParticipacionRepository extends CrudRepository<Participacion, String> {

	public List<Participacion> findByCarreraNombre(String c);
}
