package Data;

import java.time.LocalDate;

public class SocioAbonado extends Socio {

	Abono abono;

	
	public SocioAbonado(Email email, String nombre, LocalDate fechaNacimiento, CarnetSocio carnetSocio,
			LocalDate fechaInscripcion, Abono abono) {
		super(email, nombre, fechaNacimiento, carnetSocio, fechaInscripcion);
		this.abono = abono;
	}

	public Abono getAbono() {
		return abono;
	}

	public void setAbono(Abono abono) {
		this.abono = abono;
	}
	
	
	
}
