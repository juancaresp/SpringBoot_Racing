package org.dam2.carreras.clientes;

import org.springframework.web.client.RestTemplate;

public class ClienteRest {
	
	private static final String URIBASE="http://localhost:8080/corredor";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cargarDatos();
	}
	
	
	private static void cargarDatos() {
		// TODO Auto-generated method stub
		RestTemplate restTemplate=new RestTemplate();
		String uri=URIBASE+"/cargar";
		try{
			System.out.println(restTemplate.getForEntity(uri, String.class).getBody());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
