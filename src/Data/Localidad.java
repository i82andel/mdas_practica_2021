package Data;

import java.io.Serializable;

public class Localidad implements Serializable{

	int numero;
	String zona;
	int idEstadio;
	boolean ocupada;
	
	public Localidad(int numero, String zona, int idEstadio, boolean ocupada) {
		this.numero = numero;
		this.zona = zona;
		this.idEstadio = idEstadio;
		this.ocupada = ocupada;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public int getIdEstadio() {
		return idEstadio;
	}

	public void setIdEstadio(int idEstadio) {
		this.idEstadio = idEstadio;
	}

	public boolean isOcupada() {
		return ocupada;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}
	
	
	
}
