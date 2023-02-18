package org.dam2.carreras.clientes;


import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.dam2.carreras.modelo.Carrera;
import org.dam2.carreras.modelo.Corredor;
import org.dam2.carreras.modelo.Participacion;
import org.dam2.carreras.modelo.Sexo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;


public class ClienteRest {
	
	private static final String URIBASE="http://localhost:8080";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cargarDatos();
		insertarCorredorCarrera();
		insertarTiempos();
		consultarCoPrimeraCarr();
	}
	
	
	private static void consultarCoPrimeraCarr() {
		RestTemplate restTemplate=new RestTemplate();
		String uri=URIBASE+"/corredor/findCoPrimeraCarr";
		String[] corredores;
		try {
			corredores=restTemplate.getForObject(uri, String[].class);
			for(int i=0;i<corredores.length;i++) {
				System.out.println(corredores[i]);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}


	private static void insertarTiempos() {
		// TODO Auto-generated method stub
		RestTemplate restTemplate=new RestTemplate();
		String uriCons=URIBASE+"/carreras/participaciones/{ncarrera}";
		String uri=URIBASE+"/carreras/actualizarpart";
		String nCa="";
		
		nCa = pedirCarrera();
		
		List<Participacion> participaciones=Stream.of(restTemplate.getForObject(uriCons, Participacion[].class,nCa)).toList();
		participaciones.forEach(p->p.setTiempo(20));//En el set tiempo pediriamos el tiempo
		try {
			restTemplate.put(uri,participaciones, String.class);
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}


	private static void insertarCorredorCarrera() {
		// TODO Auto-generated method stub
		RestTemplate restTemplate=new RestTemplate();
		String uri=URIBASE+"/app/inscribir/{ncarrera}";
		ResponseEntity<Integer> response;
		String nCa="";
		boolean exito;
		
		Corredor c=Corredor.builder()
				.dni("003")
				.nombre("El Tercero")
				.sexo(Sexo.HOMBRE)
				.build();
		List<Participacion> part;
		
		String[] carr=restTemplate.postForObject(URIBASE+"/carreras/findalliddisp",c,String[].class);
		List<String> carreras= Arrays.stream(carr).toList();
		
		do {
			carreras.forEach(car-> System.out.println(car));
			nCa="Santos";
		}while(!carreras.contains(nCa));
		
		try {
			response=restTemplate.postForEntity(uri, c, Integer.class, nCa);
			System.out.println("El dorsal es: "+response.getBody());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}


	private static String pedirCarrera() {
		RestTemplate restTemplate=new RestTemplate();
		String nCa;
		String[] carr=restTemplate.getForObject(URIBASE+"/carreras/findallid",String[].class);
		List<String> carreras= Arrays.stream(carr).toList();
		
		do {
			carreras.forEach(car-> System.out.println(car));
			nCa="Santos";
		}while(!carreras.contains(nCa));
		return nCa;
	}


	private static void cargarDatos() {
		// TODO Auto-generated method stub
		RestTemplate restTemplate=new RestTemplate();
		String uri=URIBASE+"/app/cargar";
		try{
			System.out.println(restTemplate.getForEntity(uri, String.class).getBody());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
