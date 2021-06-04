package Data;

import java.time.LocalDate;
import java.time.Period;

public class Socio extends Usuario {

	String carnetSocio;
	LocalDate fechaInscripcion;
	
	
	public Socio(Email email, String nombre, LocalDate fechaNacimiento, String carnetSocio, LocalDate fechaInscripcion) {
		
		super(email, nombre, fechaNacimiento);
		this.carnetSocio = carnetSocio;
		this.fechaInscripcion = fechaInscripcion;
		
	}
	
	public Socio(Email email, String nombre, LocalDate fechaNacimiento, LocalDate fechaInscripcion) {
		
		super(email, nombre, fechaNacimiento);
		this.fechaInscripcion = fechaInscripcion;
		
	}

	public String getCarnetSocio() {
		return carnetSocio;
	}


	public void setCarnetSocio(String carnetSocio) {
		this.carnetSocio = carnetSocio;
	}


	public LocalDate getFechaInscripcion() {
		return fechaInscripcion;
	}


	public void setFechaInscripcion(LocalDate fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}


	public int getAntiguedadSocio() {
		
		Period period = Period.between(fechaInscripcion ,LocalDate.now());
		return period.getYears();
	}
	
	
}
