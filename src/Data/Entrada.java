package Data;

import java.io.Serializable;
import java.time.LocalDate;

public class Entrada implements Serializable{

	LocalDate fechaEvento;
	Usuario datosPropietarioEntrada;
	Localidad localidadAsignada;
	
	
	public Entrada(LocalDate fechaEvento, Usuario datosPropietarioEntrada, Localidad localidadAsignada) {
		comprobarLocalidad(localidadAsignada);
		this.fechaEvento = fechaEvento;
		this.datosPropietarioEntrada = datosPropietarioEntrada;
		this.localidadAsignada = localidadAsignada;
	}

	public LocalDate getFechaEvento() {
		return fechaEvento;
	}

	public void setFechaEvento(LocalDate fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public Usuario getDatosPropietarioEntrada() {
		return datosPropietarioEntrada;
	}

	public void setDatosPropietarioEntrada(Usuario datosPropietarioEntrada) {
		this.datosPropietarioEntrada = datosPropietarioEntrada;
	}

	public Localidad getLocalidadAsignada() {
		return localidadAsignada;
	}

	public void setLocalidadAsignada(Localidad localidadAsignada) {
		this.localidadAsignada = localidadAsignada;
	}
	
	public boolean comprobarLocalidad(Localidad localidadaComprobar) {
		boolean localidadReservada = false;
		if(localidadaComprobar.isOcupada()) {
			localidadReservada = true;
		}
		return localidadReservada;
	}
	
	
	
	
}
