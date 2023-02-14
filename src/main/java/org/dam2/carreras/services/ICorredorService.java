package org.dam2.carreras.services;

import java.util.List;
import java.util.Optional;

import org.dam2.carreras.modelo.Corredor;

public interface ICorredorService {

	public boolean insert (Corredor c);
	
	public boolean update (Corredor c);
	
	public boolean delete (String dni);
	
	public List<Corredor> findAll ();
	
	public Optional<Corredor> findByDni (String dni);
}
