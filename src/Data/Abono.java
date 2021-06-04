package Data;

import java.time.LocalDate;

public class Abono {

	Localidad localidad;
	LocalDate fechaCaducidad;
	String tipoAbono;
	
	
	public Abono(Localidad localidad, LocalDate fechaCaducidad, String tipoAbono) {
		this.localidad = localidad;
		this.fechaCaducidad = fechaCaducidad;
		this.tipoAbono = tipoAbono;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	
	
}

