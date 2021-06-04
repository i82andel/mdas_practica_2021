package Business;

import java.time.LocalDate;
import Data.*;

public interface ComprarEntrada {

	public static Usuario setDatosUsuario(LocalDate fechaNacimiento, String nombre, Email email) {
		Usuario usuarioNuevo = new Usuario(email, nombre, fechaNacimiento);
		//Guardar datos en el sistema + ficheros de datos
		return nuevoUsuario;
	}
	
	public static Usuario getDatosUsuario(Email email) {
		Usuario usurioEncontrado;
		//usuarioEncontrado <- buscar en el sistema o la base de datos;
		return usuarioEncontrado;
	}
	
	public static void comprarEntrada(LocalDate fechaEnvento, Usuario usuarioComprador, Localidad localidadDeseada) {
		
		//comprobar localidad no ocupada
		localidadDeseada.setOcupada(true);
		Entrada nuevaEntrada = new Entrada(fechaEvento,usuarioComparador,localidadDeseada);
		//Guardar entrada en sistema + fichero
		
	}
}
