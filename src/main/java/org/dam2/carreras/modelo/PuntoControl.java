package org.dam2.carreras.modelo;


import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder

@Entity
public class PuntoControl {

	@Id
	@EqualsAndHashCode.Include
	@Column(nullable = false,length = 10)
	private String id;
	
	private int puntoKm;
	
	@Column(length = 30)
	private String juez;
	
	@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	private Corredor primerCorredor;
	
	private int tiempo;

}
