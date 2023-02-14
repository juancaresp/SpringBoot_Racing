package org.dam2.carreras.controladores;

import java.time.LocalDate;

import org.dam2.carreras.modelo.Carrera;
import org.dam2.carreras.modelo.Corredor;
import org.dam2.carreras.modelo.Participacion;
import org.dam2.carreras.modelo.PuntoControl;
import org.dam2.carreras.modelo.Sexo;
import org.dam2.carreras.repository.CorredorRepository;
import org.dam2.carreras.repository.ParticipacionRepository;
import org.dam2.carreras.repository.PuntoControlRepository;
import org.dam2.carreras.services.ICarreraService;
import org.dam2.carreras.services.ICorredorService;
import org.dam2.carreras.services.IPuntoControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/corredor")
public class ControladorCorredor {
	
	@Autowired ICarreraService carreraS;
	@Autowired ICorredorService corredorS;
	@Autowired IPuntoControlService puntoS;
	
	@GetMapping("/cargar")
	public ResponseEntity<String> cargarDatos(){
		String resultado="Datos NO cargados";
		HttpStatus status=HttpStatus.BAD_REQUEST;
		ResponseEntity<String> response;
		
		Carrera ca1,ca2;
		Corredor c1,c2;
		PuntoControl p1,p2;
		Participacion p;
		
		c1=Corredor.builder()
				.dni("001")
				.nombre("Juanito")
				.sexo(Sexo.HOMBRE)
				.build();
		
		c2=Corredor.builder()
				.dni("002")
				.nombre("Lucia")
				.sexo(Sexo.MUJER)
				.build();
		corredorS.insert(c1);
		corredorS.insert(c2);
		
		p1=PuntoControl.builder()
				.id("001")
				.puntoKm(10)
				.juez("Pepe")
				.primerCorredor(c1)
				.tiempo(20000)
				.build();
		
		p2=PuntoControl.builder()
				.id("002")
				.puntoKm(20)
				.juez("Juez2")
				.primerCorredor(c1)
				.tiempo(40000)
				.build();
		
		puntoS.insert(p1);
		puntoS.insert(p2);
		
		ca1=Carrera.builder()
				.nombre("Santos")
				.max(10)
				.puntoControl(p1)
				.puntoControl(p2)
				.fecha(LocalDate.now().minusMonths(7))
				.build();
		
		
		
		p1=PuntoControl.builder()
				.id("003")
				.puntoKm(5)
				.juez("juez1")
				.primerCorredor(c2)
				.tiempo(10000)
				.build();
		
		p2=PuntoControl.builder()
				.id("004")
				.puntoKm(10)
				.juez("Juez2")
				.primerCorredor(c2)
				.tiempo(200000)
				.build();
		
		puntoS.insert(p1);
		puntoS.insert(p2);
		
		ca2=Carrera.builder()
				.nombre("Segunda Carrera Anual")
				.max(500)
				.puntoControl(p1)
				.puntoControl(p2)
				.fecha(LocalDate.now().minusMonths(2))
				.build();
		
		
		if(carreraS.insert(ca2)&&carreraS.insert(ca1)) {
			status=HttpStatus.OK;
			resultado="Todo Cargado";
		}
		
		response=new ResponseEntity<String>(resultado,status);
		return response;
	}
	
	@PostMapping("/inscribir/{ncarrera}")
	public ResponseEntity<Corredor> inscribir(@PathVariable String ncarrera){
		
		return null;
	}
}
