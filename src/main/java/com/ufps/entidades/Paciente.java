package com.ufps.entidades;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paciente implements Serializable {
	
	private int id;

	private String documento;

	private String nombre;

	private String apellido;

	private String email;

	private String genero;

	private Date fechanacimiento;

	private String telefono;

	private String direccion;

	private Integer peso;

	private Integer estatura;
	
	
}
