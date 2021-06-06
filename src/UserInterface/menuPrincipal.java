package UserInterface;

import java.util.Scanner;

import Business.ComprarEntrada;
import Business.GestionarAbonos;
import Business.ObtenerLocalidadesDisponibles;
import Business.SistemasSocios;
import Data.Email;
import Data.Estadio;
import Data.Localidad;
import Data.Socio;
import Data.SocioAbonado;
import Data.Usuario;
import Ficheros.DAOManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class menuPrincipal {

	public static void main(String[] args) throws Exception {
		
		Scanner sn = new Scanner(System.in);
		SistemasSocios sistemaSocio = new SistemasSocios();
		
		Usuario usuario = null;
		Socio socio = null;
		SocioAbonado socioAbonado = null;
		Estadio estadio = null;
		Localidad localidad = null;
		Email emailAux = null;
		
		String emailString, nombreAux, fechaNacimientoString, razonAux, fechaEventoString;
		
		ArrayList<Localidad> localidadesDisponibles = null;
		
		LocalDate fechaNacimientoAux, fechaEventoAux;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		int opcionMenuPrincipal, opcionMenuSocios = 0, localidadAux, IDestadioAux;
		
		boolean salirMenu = false;
		
		DAOManager manager = DAOManager.getInstance();
		manager.getUsuarios().cargarFichero();
		manager.getSocios().cargarFichero();
		//manager.getAbonados().cargarFichero();
		//manager.getCompromisarios().cargarFichero();
		//manager.getEntradas().cargarFichero();
		//manager.getEstadios().cargarFichero();
		//manager.getJuntas().cargarFichero();
		//manager.getSolicitudes().cargarFichero();
		
		
		ArrayList <Usuario> usuarios = (ArrayList<Usuario>) manager.getUsuarios().obtenerTodos();
		for(int i = 0; i< usuarios.size(); i++) {
			System.out.println(usuarios.get(i).getEmail());
		}
		
		ArrayList <Socio> socios = (ArrayList<Socio>) manager.getSocios().obtenerTodos();
		for(int i = 0; i< socios.size(); i++) {
			System.out.println(socios.get(i).getEmail());
		}
		
		while(true) {
			
			salirMenu = false;
			
			
			System.out.println("====================== M E N U ======================");
			System.out.println("Introduce el numero de la opcion que desee realizar: ");
			System.out.println("  1. Gestión de socios.");
			System.out.println("  2. Sacar entradas.");
			System.out.println("  3. Convocar Junta (Solo socios compromisarios).");
			System.out.println("____________________________________________________");
			System.out.println("  4. Salir.");
			System.out.println("====================================================");
			
			try {
				opcionMenuPrincipal = sn.nextInt();
				
				switch(opcionMenuPrincipal) {
				
					case 1:
						
						while(!salirMenu) {
							
							System.out.println("================= GESTIÓN DE SOCIOS =================");
							System.out.println("Introduce el numero de la opcion que desee realizar: ");
							System.out.println("  1. Crear socio.");
							System.out.println("  2. Cancelar socio.");
							System.out.println("  3. Obtener información de socio.");
							System.out.println("  4. Renovar abono.");
							System.out.println("  5. Crear carnet de socio.");
							System.out.println("  6. Solicitud socio compromisario.");
							System.out.println("____________________________________________________");
							System.out.println("  7. Salir.");
							System.out.println("====================================================");
							try {
								opcionMenuSocios = sn.nextInt();
							switch(opcionMenuSocios) {
							
							case 1:
								System.out.println("==================== CREAR SOCIO ====================");
								
								
								sn.nextLine();
								System.out.println("Introduce nombre: ");
								nombreAux = sn.nextLine();
								
								System.out.println("Introduce email: ");
								emailString = sn.nextLine();
								
								System.out.println("Introduce fecha de nacimiento (dd-MM-yyyy): ");
								fechaNacimientoString = sn.nextLine();
								
								
								fechaNacimientoAux = LocalDate.parse(fechaNacimientoString, formatter);
								
								emailAux = new Email(emailString);
								
								usuario = ComprarEntrada.setDatosUsuario(fechaNacimientoAux, nombreAux, emailAux);
								
								
								
								sistemaSocio.asociarseClub(usuario);
								
								
								break;
								
							case 2:
								System.out.println("================== CANCELAR SOCIO ===================");
								
								sn.nextLine();
								System.out.println("Introduce email del socio que desea cancelar: ");
								emailString = sn.nextLine();
								emailAux = new Email(emailString);
								
								socio = sistemaSocio.getSocioInfo(emailAux);
								sistemaSocio.cancelarAsocio(socio);
								
								break;
								
							case 3:
								System.out.println("================ OBTENER INFORMACION ================");
								sn.nextLine();
								System.out.println("Introduce email del socio que desea obtener informacion: ");
								emailString = sn.nextLine();
								emailAux = new Email(emailString);
								
								socio = sistemaSocio.getSocioInfo(emailAux);
								
								System.out.println("Nombre: " + socio.getNombre());
								System.out.println("Email: " + socio.getEmail());
								System.out.println("Fecha de nacimiento: " + socio.getFechaNacimiento());
								System.out.println("Edad: " + socio.getEdad() + " años");
								System.out.println("Fecha de inscripción: " + socio.getFechaInscripcion());
								System.out.println("Antigüedad " + socio.getAntiguedadSocio() + " años");
								
								
								break;
								
							case 4:
								System.out.println("=================== RENOVAR ABONO ===================");
								sn.nextLine();
								System.out.println("Introduce email del socio que desea renovar el abono: ");
								emailString = sn.nextLine();
								emailAux = new Email(emailString);
								
								socio = sistemaSocio.getSocioInfo(emailAux);
								
								if(GestionarAbonos.comprobarSocioEstaAbonado(socio)) {
									socioAbonado = sistemaSocio.getSocioAbonadoInfo(emailAux);
									socioAbonado.getAbono().renovarAbono();
									
								}
								
								else {
									System.out.println("El socio introducido no es abonado.");
								}
								
								break;
								
								
							case 5:
								System.out.println("==================== CREAR CARNET ===================");
								sn.nextLine();
								System.out.println("Introduce email del socio que desea crear carnet: ");
								emailString = sn.nextLine();
								emailAux = new Email(emailString);
								
								socio = sistemaSocio.getSocioInfo(emailAux);
								sistemaSocio.crearCarnet(socio);
								
								break;
								
							case 6:
								System.out.println("=========== SOLICITUD SOCIO COMPROMISARIO ===========");
								sn.nextLine();
								System.out.println("Introduce email del socio que desea realizar la solicitud: ");
								emailString = sn.nextLine();
								emailAux = new Email(emailString);
								
								socio = sistemaSocio.getSocioInfo(emailAux);
								
								System.out.println("Introduce razón: ");
								razonAux = sn.nextLine();
								
								sistemaSocio.añadirSolicitud(socio, razonAux);
								
								
								
								break;
								
							case 7:
								salirMenu = true;
								
								break;
								
							default:
								System.out.println("La opcion seleccionada no existe. Debe ser entre 1 y 7.");
							
							}
						
							}catch(InputMismatchException e) {
								System.out.println("Debes introducir un numero.");
								sn.next();
						}
						}
						
						
						
						break;
						
						
						
					case 2:
						System.out.println("=================== SACAR ENTRADA ===================");
						
						System.out.println("Introduce nombre: ");
						nombreAux = sn.nextLine();
						System.out.println("Introduce email: ");
						emailString = sn.nextLine();
						
						System.out.println("Introduce fecha de nacimiento (dd-MM-yyyy): ");
						fechaNacimientoString = sn.nextLine();
						
						fechaNacimientoAux = LocalDate.parse(fechaNacimientoString, formatter);
						
						emailAux = new Email(emailString);
						
						usuario = ComprarEntrada.setDatosUsuario(fechaNacimientoAux, nombreAux, emailAux);
						
						System.out.println("Introduce fecha de evento (dd-MM-yyyy): ");
						fechaEventoString = sn.nextLine();
						
						fechaEventoAux = LocalDate.parse(fechaEventoString, formatter);
						
						
						System.out.println("Introduce el id del estadio: ");
						IDestadioAux = sn.nextInt();
						
						estadio = manager.getEstadios().obtener(IDestadioAux);
						
						System.out.println("Introduce numero de localidad: ");
						localidadAux = sn.nextInt();
						
						localidadesDisponibles = ObtenerLocalidadesDisponibles.getLocalidadesDisponibles(estadio);
						
						localidad = new Localidad(0, "", 0, true);
						
						for(int i = 0; i< localidadesDisponibles.size(); i++) {
							if(localidadesDisponibles.get(i).getNumero() == localidadAux) {
								ObtenerLocalidadesDisponibles.ocuparLocalidad(localidadesDisponibles.get(i));
								localidad = localidadesDisponibles.get(i);
							}
						}
						
						ComprarEntrada.comprarEntrada(fechaEventoAux, usuario, localidad);
						
						
						break;
						
					case 3:
						System.out.println("=================== CONVOCAR JUNTA ===================");
						
						break;
					
					case 4:
						System.out.println("Fin del Menu");

						manager.guardarFicheros();
						
						System.exit(0);
						break;
						
						
					default:
						System.out.println("La opcion seleccionada no existe. Debe ser entre 1 y 4.");
				}
				
			}catch(InputMismatchException e) {
				System.out.println("Debes introducir un numero.");
				sn.next();
			}
		}
	}
}
