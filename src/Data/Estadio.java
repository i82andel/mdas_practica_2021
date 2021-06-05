package Data;

import java.io.Serializable;
import java.util.ArrayList;

public class Estadio implements Serializable{

	String nombre;
	int idEstadio;
	int aforo;
	ArrayList<Localidad> localidadesEstadio;
	
	
	public Estadio(String nombre, int idEstadio, int aforo, ArrayList<Localidad> localidadesEstadio) {
		super();
		this.nombre = nombre;
		this.idEstadio = idEstadio;
		this.aforo = aforo;
		this.localidadesEstadio = localidadesEstadio;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getIdEstadio() {
		return idEstadio;
	}
	public void setIdEstadio(int idEstadio) {
		this.idEstadio = idEstadio;
	}
	public int getAforo() {
		return aforo;
	}
	public void setAforo(int aforo) {
		this.aforo = aforo;
	}
	public ArrayList<Localidad> getLocalidadesEstadio() {
		return localidadesEstadio;
	}
	public void setLocalidadesEstadio(ArrayList<Localidad> localidadesEstadio) {
		this.localidadesEstadio = localidadesEstadio;
	}
	
	
}
