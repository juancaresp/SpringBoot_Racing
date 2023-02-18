package org.dam2.carreras.modelo;

import java.time.LocalDate;
import java.util.Set;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder

@Entity
public class Carrera {

	@Nonnull
	@EqualsAndHashCode.Include
	@Id
	@Column(nullable = false,length = 40)
	private String nombre;
	
	private int max;
	
	@Singular("puntoControl")
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<PuntoControl> puntosControl;
	
	private LocalDate fecha;

}
