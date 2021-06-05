package Business;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import Data.*;

public class SistemasSocios {

	public void asociarseClub(Usuario usuarioInscrito) {
		
		//comprobar que no exista.
		LocalDate fechaActualdeInscripcion = LocalDate.now();
		Socio nuevoSocio = new Socio(fechaActualdeInscripcion);
		//meter socio en el array
	}
	
	public void cancelarAsocio(Socio socioDeBaja) {
		
		//borrar del array de socios
		//
		
	}
	
	public Socio getSocioInfo(Email emailSocio) {
		
		//buscar por email en 
		return socioEncontrado;
	}
	
	public boolean validarDatos(Usuario usuarioNuevo){
		
		//buscar si el usuario existe 
		
	}
	
	public void convocarJunta(SocioCompromisario socioConvocante, ArrayList<String> temasTratarJunta, 
			LocalDate fechaJunta, LocalTime horaJunta) {
		
		Junta nuevaJunta = new Junta(socioConvocante, temasTratarJunta, fechaJunta, horaJunta);
		//guardar nueva junta en el array
		
		
	}
	
	public void crearCarnet(Socio socio) {
		
		String tipoCarnet = valorarTipoCarnet(socio);
		CarnetSocio nuevoCarnet = new CarnetSocio(tipoCarnet);
		socio.setCarnetSocio(nuevoCarnet);
		
	}
	
	public String valorarTipoCarnet(Socio socio) {
		
		int edadSocio = socio.getEdad();
		int antiguedadSocio = socio.getAntiguedadSocio();

		if(antiguedadSocio >= 25){
			
			return "plata";
			
		}else if(edadSocio < 18) {
			
			return "infantil";
			
		}else if(edadSocio >= 18 && edadSocio < 65) {
			
			return "adulto";
			
		}else{
			
			return "oro";
			
		}
		
	}
	
	public void añadirSolicitud(Socio socio, String razon) {
		
		
	}
	
	public boolean validarAntiguedad(Socio socio) {
		
		int antiguedadRequerida = 25;
		int antiguedadSocio = socio.getAntiguedadSocio();
		boolean valido = false;
		
		if(antiguedadSocio >= antiguedadRequerida) valido = true;
		else valido = false;
		return valido;
		
	}
	
	
	
	
}
