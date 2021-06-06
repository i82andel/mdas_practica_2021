package Business;

import java.time.LocalDate;

import Data.*;
import Ficheros.DAOManager;

public interface GestionarAbonos {
	
	DAOManager gestor = new DAOManager();

	public static boolean comprobarSocioNoAbonado(Socio socio) throws Exception {
		
		boolean encontrado = false;
		String emailString = socio.getEmail();
		Email emailSocioEmail = new Email(emailString);
		SocioAbonado socioAbonadoEncontrado = gestor.getAbonados().obtener(emailSocioEmail);
		if(socioAbonadoEncontrado != null) {
			encontrado = true;	
		}
		return encontrado;
		
	}
	
	
	public static Abono factoriaAbono(Localidad localidadDeseada, String tipoAbono, String deporte) {

		if (tipoAbono.equals("COMPLETO")) {
			return new AbonoCompleto(localidadDeseada, deporte);
		}
		else {
			 return new AbonoLiga(localidadDeseada,deporte);
		}
		
	}
	
	public static SocioAbonado setDatosSocioAbonado(Socio socioBasico, Abono abono) throws Exception {
		
		Email emailSocioComprador = new Email(socioBasico.getEmail());
		String nombreSocioComprador = socioBasico.getNombre();
		CarnetSocio carnetSocioComprador = socioBasico.getCarnetSocio();
		LocalDate fechaNacimientoSocioComprador  = socioBasico.getFechaNacimiento();
		LocalDate fechaInscripcionSocioComprador = socioBasico.getFechaInscripcion();
		
		SocioAbonado nuevoSocioAbonado = new SocioAbonado(emailSocioComprador,  nombreSocioComprador,  fechaNacimientoSocioComprador, carnetSocioComprador, fechaInscripcionSocioComprador, abono);
		
		return nuevoSocioAbonado;
	}
	
	
	public static void comprarAbono(Localidad localidadDeseada, Socio socioComprador, String tipoAbono, String deporte) throws Exception {
		
		if(!comprobarSocioNoAbonado(socioComprador)){
			
			Abono nuevoAbono = factoriaAbono(localidadDeseada, tipoAbono, deporte);
			SocioAbonado nuevoSocioAbonado = setDatosSocioAbonado(socioComprador, nuevoAbono);
			
			gestor.getAbonados().insertar(nuevoSocioAbonado);
			
		}else {
			
			throw new Exception();
			
		}

	}
	
	
	
}
