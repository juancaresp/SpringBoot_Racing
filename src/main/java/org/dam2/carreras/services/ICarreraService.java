package org.dam2.carreras.services;

import java.util.List;
import java.util.Optional;

import org.dam2.carreras.modelo.Carrera;

public interface ICarreraService {

	public boolean insert (Carrera c);
	
	public boolean update (Carrera c);
	
	public boolean delete (String nombre);
	
	public List<Carrera> findAll ();
	
	public Optional<Carrera> findByNombre (String nombre);
	
}
