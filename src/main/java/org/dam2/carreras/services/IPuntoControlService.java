package org.dam2.carreras.services;

import java.util.List;
import java.util.Optional;

import org.dam2.carreras.modelo.PuntoControl;

public interface IPuntoControlService {

	public boolean insert (PuntoControl punto);
	
	public boolean update (PuntoControl punto);
	
	public boolean delete (String nombre);
	
	public List<PuntoControl> findAll ();
	
	public Optional<PuntoControl> findById (String id);
}
