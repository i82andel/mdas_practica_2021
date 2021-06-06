package Business;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import Data.*;
import Ficheros.DAOManager;

public class SistemasSocios {

	//DAOManager gestor = new DAOManager();
	
	public void asociarseClub(Usuario usuarioInscrito, DAOManager gestor) throws Exception {
		
		Socio nuevoSocio = setDatosSocio(usuarioInscrito);
		if(!existeSocioSistema(nuevoSocio, gestor)) {
			
			gestor.getSocios().insertar(nuevoSocio);
			
		}else {
			
			throw new Exception();
		}
		
	}
	
	public Socio setDatosSocio(Usuario usuario) {
		

		Email emailSocio = new Email(usuario.getEmail());
		String nombreSocio = usuario.getNombre();
		LocalDate fechaNacimiento  = usuario.getFechaNacimiento();
		LocalDate fechaInscripcion = LocalDate.now();
		
		Socio nuevoSocioAbonado = new Socio(emailSocio,  nombreSocio,  fechaNacimiento, fechaInscripcion);
		return nuevoSocioAbonado;
		
	}
	
	public boolean existeSocioSistema(Socio socio, DAOManager gestor) {
		
		boolean encontrado = false;
		String emailString = socio.getEmail();
		Email emailSocioBuscado = new Email(emailString);
		if(gestor.getSocios().obtener(emailSocioBuscado) == null) {
			
			encontrado = false;
		}else {
			
			encontrado = true;
		}
		
		return encontrado;
	}
	
	public void cancelarAsocio(Socio socioDeBaja, DAOManager gestor) {
		
		gestor.getSocios().eliminar(socioDeBaja);
		
	}
	
	public Socio getSocioInfo(Email emailSocio, DAOManager gestor) throws Exception {
		
		Socio socioEncontrado = gestor.getSocios().obtener(emailSocio);
		if(socioEncontrado == null) {
			
			//throw new Exception();
			System.out.println("No encontrado");
			
		}
		return socioEncontrado;
	}

	public SocioAbonado getSocioAbonadoInfo(Email emailSocio, DAOManager gestor) throws Exception {
		
		SocioAbonado socioEncontrado = gestor.getAbonados().obtener(emailSocio);
		if(socioEncontrado == null) {
			
			throw new Exception();
			
		}
		return socioEncontrado;
	}
	
	public void convocarJunta(SocioCompromisario socioConvocante, ArrayList<String> temasTratarJunta, 
			LocalDate fechaJunta, LocalTime horaJunta, DAOManager gestor) {
		
		Junta nuevaJunta = new Junta(socioConvocante, temasTratarJunta, fechaJunta, horaJunta);
		gestor.getJuntas().insertar(nuevaJunta);
		
		
	}
	
	public void crearCarnet(Socio socio, DAOManager gestor) {
		
		String tipoCarnet = valorarTipoCarnet(socio, gestor);
		CarnetSocio nuevoCarnet = new CarnetSocio(tipoCarnet);
		socio.setCarnetSocio(nuevoCarnet);
		
	}
	
	public String valorarTipoCarnet(Socio socio, DAOManager gestor) {
		
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
	
	public boolean validarAntiguedad(Socio socio, DAOManager gestor) {
		
		int antiguedadRequerida = 25;
		int antiguedadSocio = socio.getAntiguedadSocio();
		boolean valido = false;
		
		if(antiguedadSocio >= antiguedadRequerida) valido = true;
		else valido = false;
		return valido;
		
	}
	
	public void añadirSolicitud(Socio socioSolicitante, String razon, DAOManager gestor) {
		
		Solicitud nuevaSolicitud = new Solicitud( socioSolicitante,  razon);
		gestor.getSolicitudes().insertar(nuevaSolicitud);
		
	}
	
	
}
