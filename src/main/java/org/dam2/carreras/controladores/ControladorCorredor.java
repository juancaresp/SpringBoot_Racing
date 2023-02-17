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
	
	
	
	
}
