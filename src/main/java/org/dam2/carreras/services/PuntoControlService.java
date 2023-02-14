package org.dam2.carreras.services;

import java.util.List;
import java.util.Optional;

import org.dam2.carreras.modelo.PuntoControl;
import org.dam2.carreras.repository.CarreraRepository;
import org.dam2.carreras.repository.CorredorRepository;
import org.dam2.carreras.repository.ParticipacionRepository;
import org.dam2.carreras.repository.PuntoControlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PuntoControlService implements IPuntoControlService {

	@Autowired CarreraRepository carreraR;
	@Autowired CorredorRepository corredorR;
	@Autowired ParticipacionRepository participacionR;
	@Autowired PuntoControlRepository puntoR;
	
	@Override
	public boolean insert(PuntoControl punto) {
		boolean exito=true;
		if(puntoR.existsById(punto.getId())) {
			exito=false;
		}else {
			puntoR.save(punto);
		}
		
		return exito;
	}

	@Override
	public boolean update(PuntoControl punto) {
		boolean exito=true;
		if(!puntoR.existsById(punto.getId())) {
			exito=false;
		}else {
			puntoR.save(punto);
		}
		
		return exito;
	}

	@Override
	public boolean delete(String nombre) {
		boolean exito=true;
		if(puntoR.existsById(nombre)) {
			puntoR.deleteById(nombre);
		}else {
			exito=false;
		}
		return exito;
	}

	@Override
	public List<PuntoControl> findAll() {
		// TODO Auto-generated method stub
		return (List<PuntoControl>) puntoR.findAll();
	}

	@Override
	public Optional<PuntoControl> findById(String id) {
		// TODO Auto-generated method stub
		return puntoR.findById(id);
	}

}
