package org.dam2.carreras.modelo;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
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
public class Corredor {

	@Id
	@EqualsAndHashCode.Include
	@Column(nullable = false,length = 10)
	private String dni;
	
	@Column(length = 30)
	private String nombre;
	@Enumerated
	private Sexo sexo;
}
