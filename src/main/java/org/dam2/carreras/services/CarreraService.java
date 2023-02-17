package org.dam2.carreras.services;

import java.util.List;
import java.util.Optional;

import org.dam2.carreras.modelo.Carrera;
import org.dam2.carreras.modelo.Corredor;
import org.dam2.carreras.modelo.Participacion;
import org.dam2.carreras.repository.CarreraRepository;
import org.dam2.carreras.repository.CorredorRepository;
import org.dam2.carreras.repository.ParticipacionRepository;
import org.dam2.carreras.repository.PuntoControlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarreraService implements ICarreraService {

	@Autowired CarreraRepository carreraR;
	@Autowired CorredorRepository corredorR;
	@Autowired ParticipacionRepository participacionR;
	@Autowired PuntoControlRepository puntoR;
	
	@Override
	public boolean insert(Carrera c) {
		boolean exito=true;
		if(carreraR.existsById(c.getNombre())) {
			exito=false;
		}else {
			carreraR.save(c);
		}
		
		return exito;
	}
	
	@Override
	public boolean update(Carrera c) {
		boolean exito=true;
		if(!carreraR.existsById(c.getNombre())) {
			exito=false;
		}else {
			carreraR.save(c);
		}
		
		return exito;
	}

	@Override
	public boolean delete(String nombre) {
		boolean exito=true;
		if(carreraR.existsById(nombre)) {
			carreraR.deleteById(nombre);
		}else {
			exito=false;
		}
		return exito;
	}

	@Override
	public List<Carrera> findAll() {
		// TODO Auto-generated method stub
		return (List<Carrera>) carreraR.findAll();
	}

	@Override
	public Optional<Carrera> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return carreraR.findById(nombre);
	}

	@Override
	public int insertarCorredor(Corredor c,String nCarrera) {
		int dor=-1;
		Optional<Carrera> ca=carreraR.findById(nCarrera);
		if(ca.isPresent()) {
			dor=participacionR.findByCarrera(ca.get()).size();
			if(dor<ca.get().getMax()) {
				dor++;
				Participacion pa=Participacion.builder()
									.carrera(ca.get())
									.corredor(c)
									.tiempo(-1)
									.dorsal(dor)
									.build();
				participacionR.save(pa);
			}else {
				dor=-1;
			}
		}
		return dor;
	}

	@Override
	public List<Participacion> findPartByCarrera(String ncarrera) {
		// TODO Auto-generated method stub
		return findPartByCarrera(ncarrera);
	}

}
