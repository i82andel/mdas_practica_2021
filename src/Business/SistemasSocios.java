package Business;

import java.time.LocalDate;

import Data.Socio;
import Data.Usuario;

public class SistemasSocios {

	public void asociarseClub(Usuario usuarioInscrito) {
		
		LocalDate fechaActualdeInscripcion = LocalDate.now();
		Socio nuevoSocio = new Socio(fechaActualdeInscripcion);
		
		
		
		
	}
	
	
	
}
