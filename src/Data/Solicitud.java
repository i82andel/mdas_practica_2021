package Data;

import java.io.Serializable;

public class Solicitud implements Serializable{

	private Socio socioSolicitante;
	private String razon;
	
	public Solicitud(Socio socioSolicitante, String razon) {
		super();
		this.socioSolicitante = socioSolicitante;
		this.razon = razon;
	}

	public Socio getSocioSolicitante() {
		return socioSolicitante;
	}

	public void setSocioSolicitante(Socio socioSolicitante) {
		this.socioSolicitante = socioSolicitante;
	}

	public String getRazon() {
		return razon;
	}

	public void setRazon(String razon) {
		this.razon = razon;
	}
	
	
	
}
