package org.dam2.carreras.services;

import java.util.List;
import java.util.Optional;

import org.dam2.carreras.modelo.Corredor;
import org.dam2.carreras.repository.CarreraRepository;
import org.dam2.carreras.repository.CorredorRepository;
import org.dam2.carreras.repository.ParticipacionRepository;
import org.dam2.carreras.repository.PuntoControlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorredorService implements ICorredorService {

	@Autowired CarreraRepository carreraR;
	@Autowired CorredorRepository corredorR;
	@Autowired ParticipacionRepository participacionR;
	@Autowired PuntoControlRepository puntoR;
	
	@Override
	public boolean insert(Corredor c) {
		boolean exito=true;
		if(corredorR.existsById(c.getDni())) {
			exito=false;
		}else {
			corredorR.save(c);
		}
		
		return exito;
	}

	@Override
	public boolean update(Corredor c) {
		boolean exito=true;
		if(!corredorR.existsById(c.getDni())) {
			exito=false;
		}else {
			corredorR.save(c);
		}
		
		return exito;
	}

	@Override
	public boolean delete(String dni) {
		boolean exito=true;
		if(corredorR.existsById(dni)) {
			corredorR.deleteById(dni);
		}else {
			exito=false;
		}
		return exito;
	}

	@Override
	public List<Corredor> findAll() {
		// TODO Auto-generated method stub
		return (List<Corredor>) corredorR.findAll();
	}

	@Override
	public Optional<Corredor> findByDni(String dni) {
		// TODO Auto-generated method stub
		return corredorR.findById(dni);
	}

}
