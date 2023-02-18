package org.dam2.carreras.controladores;


import java.util.ArrayList;
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

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/corredor")
public class ControladorCorredor {
	
	@Autowired ICarreraService carreraS;
	@Autowired ICorredorService corredorS;
	@Autowired IPuntoControlService puntoS;
	
	@GetMapping("/findCoPrimeraCarr")
	public ResponseEntity<List<String>> findAllCarreras(){
		ResponseEntity<List<String>> response=new ResponseEntity<List<String>>(HttpStatus.BAD_REQUEST);
		
		List<String> result=new ArrayList<>();
		
		String ca=carreraS.findAll().stream().sorted((c1,c2)->c1.getFecha().compareTo(c2.getFecha())).findFirst().get().getNombre();
		List<Participacion> part=carreraS.findPartByCarrera(ca);
		if(part.size()>0) {
			for(int i=0;i<part.size();i++) {
				Participacion pa=part.get(i);
				result.add("Nombre: "+pa.getCorredor().getNombre()+" DNI: "+pa.getCorredor().getDni()+" Tiempo: "+pa.getTiempo());
			}
			response=new ResponseEntity<List<String>>(result,HttpStatus.OK);
		}
		return response;
		
	}
	
	
}
