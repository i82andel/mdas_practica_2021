package Data;

import java.time.LocalDate;
import java.time.Period;

public class Usuario {

	Email email;
	String nombre;
	LocalDate fechaNacimiento;
		
	
	public Usuario(Email email, String nombre, LocalDate fechaNacimiento) {
		super();
		this.email = email;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getEmail() {
		return email.getEmail();	
	}
	
	public void setEmail(Email email) {
		this.email = email;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public int getEdad() {
		LocalDate fechaActual = LocalDate.now();
		Period period = Period.between(fechaNacimiento , fechaActual);
		int añosEntreFechas = period.getYears();
		return añosEntreFechas;
	}
	
}
