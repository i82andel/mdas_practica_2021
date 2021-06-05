package Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Socio extends Usuario{

	private CarnetSocio carnetSocio = null;
	private LocalDate fechaInscripcion;
	
	
	public Socio(Email email, String nombre, LocalDate fechaNacimiento, CarnetSocio carnetSocio, LocalDate fechaInscripcion) {
		
		super(email, nombre, fechaNacimiento);
		this.carnetSocio = carnetSocio;
		this.fechaInscripcion = fechaInscripcion;
		
	}
	
	public Socio(Email email, String nombre, LocalDate fechaNacimiento, LocalDate fechaInscripcion) {
		
		super(email, nombre, fechaNacimiento);
		this.fechaInscripcion = fechaInscripcion;
		
	}

	public CarnetSocio getCarnetSocio() {
		return carnetSocio;
	}


	public void setCarnetSocio(CarnetSocio carnetSocio) {
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
