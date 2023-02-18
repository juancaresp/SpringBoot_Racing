package org.dam2.carreras.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dam2.carreras.modelo.Carrera;
import org.dam2.carreras.modelo.Corredor;
import org.dam2.carreras.modelo.Participacion;
import org.dam2.carreras.services.ICarreraService;
import org.dam2.carreras.services.ICorredorService;
import org.dam2.carreras.services.IPuntoControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/findallid")
	public ResponseEntity<List<String>> findAllIdCarreras(){
		List<String> carreras=carreraS.findAll().stream().map(ca->ca.getNombre()).collect(Collectors.toList());
		
		return new ResponseEntity<List<String>>(carreras,HttpStatus.ACCEPTED);
	}
	@PostMapping("/findalliddisp")
	public ResponseEntity<List<String>> findAllIddisp(@RequestBody Corredor corredor){
		List<Carrera> carreras=carreraS.findAll();
		List<String> strings=new ArrayList<>();
		List<Participacion> part;
		Carrera ca;
		boolean exito;
		
		for(int i=0;i<carreras.size();i++) {
			exito=true;
			ca=carreras.get(i);
			part=carreraS.findPartByCarrera(ca.getNombre());
			if(part.size()!=0) {
				if(part.size()<ca.getMax()) {
					if(part.get(i).getCorredor().equals(corredor)) {
						exito=false;
					}
				}else {
					exito=false;
				}
			}
			if(exito) {
				strings.add(ca.getNombre());
			}
		}
		
		
		return new ResponseEntity<List<String>>(strings,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/findbyid/{ncarrera}")
	public ResponseEntity<Carrera> findbyId(@PathVariable String ncarrera){
		return new ResponseEntity<Carrera>(carreraS.findByNombre(ncarrera).orElse(new Carrera()),HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/participaciones/{ncarrera}")
	public ResponseEntity<List<Participacion>> findParticipacionByCarrera(@PathVariable String ncarrera){
		ResponseEntity<List<Participacion>> response=new ResponseEntity<List<Participacion>>(HttpStatus.BAD_REQUEST);
		List<Participacion> carreras=carreraS.findPartByCarrera(ncarrera);
		if(carreras.size()>0) {
			response=new ResponseEntity<List<Participacion>>(carreras,HttpStatus.ACCEPTED);
		}
		return response;
	}
		
	@PutMapping("/actualizarpart")
	public ResponseEntity<String> findParticipacionByCarrera(@RequestBody List<Participacion> carreras){
		
		ResponseEntity<String> response=new ResponseEntity<String>("FALLO, actualizado Incorrectamente",HttpStatus.BAD_REQUEST);
	
		if(carreraS.actualizarParticipaciones(carreras)) {
			response=new ResponseEntity<String>("Actualizado Correctamente",HttpStatus.OK);
		}
		
		return response;
	}
}

