package UserInterface;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import Business.ComprarEntrada;
import Business.SistemasSocios;
import Data.Abono;
import Data.CarnetSocio;
import Data.Email;
import Data.Entrada;
import Data.Estadio;
import Data.Junta;
import Data.Localidad;
import Data.SocioAbonado;
import Data.SocioCompromisario;
import Data.Solicitud;
import Data.Usuario;
import Ficheros.DAOManager;

public class MenuSecundario {

	public static void main(String[] args) throws Exception {
		
		Scanner sn = new Scanner(System.in);
		SistemasSocios sistemaSocio = new SistemasSocios();
		String emailString, nombre, fechaNacimientoString, razon, fechaEventoString;
		
		DAOManager gestor = new DAOManager();
		
		System.out.println("Introduce nombre: ");
		nombre = sn.nextLine();
		System.out.println("Introduce email: ");
		emailString = sn.nextLine();
		
		System.out.println("Introduce fecha de nacimiento (dd-MM-yyyy): ");
		fechaNacimientoString = sn.nextLine();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoString, formatter);
		
		Email email = new Email(emailString);
		
		Usuario usuario = ComprarEntrada.setDatosUsuario(fechaNacimiento, nombre, email);
		

		
		sistemaSocio.asociarseClub(usuario);
		
		
		
		gestor.getSocios().guardarFichero();
		Localidad localidad = new Localidad(1, "zona", 1, false);
		Localidad localidad2 = new Localidad(1, "zona", 2, false);
		ArrayList<Localidad> localidades = new ArrayList<Localidad>();
		localidades.add(localidad2);
		localidades.add(localidad);
		Entrada entrada = new Entrada(LocalDate.now(), usuario, localidad);
		
		//gestor.getEntradas().insertar(entrada);
		//gestor.getEntradas().guardarFichero();
		
		Estadio estadio = new Estadio("nombre",1, 10, localidades);
		//gestor.getEstadios().insertar(estadio);
		//gestor.getEstadios().guardarFichero();
		
		CarnetSocio carnetSocio = new CarnetSocio("COMPLETO");
		SocioCompromisario sociocompromisario = new SocioCompromisario(email, "nombre", LocalDate.now(),carnetSocio , LocalDate.now());
		
		ArrayList<String> temas = new ArrayList<String>();
		temas.add("tema1");
		Junta junta = new Junta(sociocompromisario, temas, LocalDate.now(), LocalTime.now());
		//gestor.getJuntas().insertar(junta);
		//gestor.getJuntas().guardarFichero();
		
		Abono abono = new Abono(localidad, "futobl");
		SocioAbonado socioAbonado = new SocioAbonado(email, "nombre", LocalDate.now(), carnetSocio, LocalDate.now(), abono);
		//gestor.getAbonados().insertar(socioAbonado);
		//gestor.getAbonados().guardarFichero();
		
		SocioCompromisario socio = new SocioCompromisario(email, "12-12-2020", fechaNacimiento, carnetSocio, LocalDate.now());
		//gestor.getCompromisarios().insertar(sociocompromisario);
		//gestor.getCompromisarios().guardarFichero();
		
		Solicitud solicitud = new Solicitud(socio, "12-12-2000");
		gestor.getSolicitudes().insertar(solicitud);
		gestor.getSolicitudes().guardarFichero();
	}
}
