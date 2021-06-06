package Business;

import java.time.LocalDate;
import Data.*;
import Ficheros.DAOManager;
import Business.*;

public interface ComprarEntrada {

	//DAOManager gestor = new DAOManager();
	
	public static Usuario setDatosUsuario(LocalDate fechaNacimiento, String nombre, Email email, DAOManager gestor) throws Exception {
		Usuario usuarioNuevo = new Usuario(email, nombre, fechaNacimiento);
		if(existeUsuarioSistema(usuarioNuevo, gestor)) {
			
			throw new Exception();
			
		}else {
			gestor.getUsuarios().insertar(usuarioNuevo);
			return usuarioNuevo;
		}
	}
	
	public static Usuario getDatosUsuario(Email email, DAOManager gestor) throws Exception {
		Usuario usuarioEncontrado;
		usuarioEncontrado = gestor.getUsuarios().obtener(email);
		if(usuarioEncontrado == null) throw new Exception();
		return usuarioEncontrado;
	}
	
	public static boolean existeUsuarioSistema(Usuario usuario, DAOManager gestor) throws Exception {
		
		boolean encontrado = false;
		String emailString = usuario.getEmail();
		Email emailUsuarioBuscado = new Email(emailString);
		if(gestor.getUsuarios().obtener(emailUsuarioBuscado) == null) {
			
			encontrado = false;
		}else {
			
			encontrado = true;
		}
		
		return encontrado;
	}
	
	public static void comprarEntrada(LocalDate fechaEvento, Usuario usuarioComprador, Localidad localidadDeseada, DAOManager gestor) throws Exception {
		
		if(ObtenerLocalidadesDisponibles.ocuparLocalidad(localidadDeseada)) {
			
			Entrada nuevaEntrada = new Entrada(fechaEvento,usuarioComprador,localidadDeseada);
			gestor.getEntradas().insertar(nuevaEntrada);
			
		}else {
			
			throw new Exception();
		}
		
	}
}
