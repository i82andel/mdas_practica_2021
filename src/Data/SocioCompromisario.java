package Data;

import java.time.LocalDate;

public class SocioCompromisario extends Socio{

	boolean solicitudAceptada;
	
	public SocioCompromisario(Email email, String nombre, LocalDate fechaNacimiento, LocalDate fechaInscripcion) {
		super(email, nombre, fechaNacimiento, fechaInscripcion);
		this.solicitudAceptada = false;
		
	}

	public boolean isSolicitudAceptada() {
		return solicitudAceptada;
	}

	public void setSolicitudAceptada(boolean solicitudAceptada) {
		this.solicitudAceptada = solicitudAceptada;
	}

	
}
