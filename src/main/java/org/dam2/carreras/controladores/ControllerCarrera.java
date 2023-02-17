package org.dam2.carreras.controladores;

import java.util.List;

import org.dam2.carreras.modelo.Carrera;
import org.dam2.carreras.modelo.Participacion;
import org.dam2.carreras.services.ICarreraService;
import org.dam2.carreras.services.ICorredorService;
import org.dam2.carreras.services.IPuntoControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carreras")
public class ControllerCarrera {
	@Autowired ICarreraService carreraS;
	@Autowired ICorredorService corredorS;
	@Autowired IPuntoControlService puntoS;
	
	@GetMapping("/findall")
	public ResponseEntity<List<Carrera>> findAllCarreras(){
		return new ResponseEntity<List<Carrera>>(carreraS.findAll(),HttpStatus.ACCEPTED);
	}
	@GetMapping("/participaciones/{ncarrera}")
	public ResponseEntity<List<Participacion>> findParticipacionByCarrera(@PathVariable String ncarrera){
		ResponseEntity<List<Participacion>> response=new ResponseEntity<List<Participacion>>(HttpStatus.BAD_REQUEST);
		List<Participacion> carreras=carreraS.findPartByCarrera(ncarrera);
		if(carreras.size()>0){
			response=new ResponseEntity<List<Participacion>>(carreras,HttpStatus.ACCEPTED);
		}
		return response;
	}
		/*
		@PutMapping("/actualizarpart/{ncarrera}")
		public ResponseEntity<String> findParticipacionByCarrera(@RequestBody List<Carrera> ncarrera){
			ResponseEntity<String> response=new ResponseEntity<String>("FALLO,cargado Incorrectamente",HttpStatus.BAD_REQUEST);
			if(corredorS.findByDni(c.getDni()).isEmpty()) {
				corredorS.insert(c);
			}
			int dorsal=carreraS.insertarCorredor(c,ncarrera);
			if(dorsal!=-1) {
				response=new ResponseEntity<String>("Cargado Correctamente",HttpStatus.ACCEPTED);
			
			return response;
		}*/
}

