package Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Currency;

public class Abono implements Serializable{

	private Localidad localidad;
	private LocalDate fechaCaducidad;
	private Socio socioPropietario;
	private String deporte;
	
	
	public Abono(Localidad localidad, LocalDate fechaCaducidad, String deporte) {
		this.localidad = localidad;
		this.fechaCaducidad = fechaCaducidad;
		this.deporte = deporte;
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
	
	public float getPrecio() {
		float precio = (float) 30.00;
		return precio;
	}
}

