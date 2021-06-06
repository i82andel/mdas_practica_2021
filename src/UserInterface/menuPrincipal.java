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
		String emailString, nombre, fechaNacimientoString, razon, fechaEventoString;
		
		int opcionMenuPrincipal, opcionMenuSocios = 0, localidad, estadio;
		boolean salirMenu = false;
		
		DAOManager manager = DAOManager.getInstance();
		manager.getUsuarios().cargarFichero();
		manager.getSocios().cargarFichero();
		manager.getAbonados().cargarFichero();
		manager.getCompromisarios().cargarFichero();
		manager.getEntradas().cargarFichero();
		manager.getEstadios().cargarFichero();
		manager.getJuntas().cargarFichero();
		manager.getSolicitudes().cargarFichero();
		
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
								nombre = sn.nextLine();
								System.out.println("Introduce email: ");
								emailString = sn.nextLine();
								
								System.out.println("Introduce fecha de nacimiento (dd-MM-yyyy): ");
								fechaNacimientoString = sn.nextLine();
								
								DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
								LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoString, formatter);
								
								Email email = new Email(emailString);
								
								Usuario usuario = ComprarEntrada.setDatosUsuario(fechaNacimiento, nombre, email, manager);
								
								
								sistemaSocio.asociarseClub(usuario, manager);
								
								
								break;
								
							case 2:
								System.out.println("================== CANCELAR SOCIO ===================");
								
								sn.nextLine();
								System.out.println("Introduce email del socio que desea cancelar: ");
								emailString = sn.nextLine();
								email = new Email(emailString);
								
								Socio socio = sistemaSocio.getSocioInfo(email, manager);
								sistemaSocio.cancelarAsocio(socio, manager);
								
								break;
								
							case 3:
								System.out.println("================ OBTENER INFORMACION ================");
								sn.nextLine();
								System.out.println("Introduce email del socio que desea obtener informacion: ");
								emailString = sn.nextLine();
								email = new Email(emailString);
								
								Socio socioInfo = sistemaSocio.getSocioInfo(email, manager);
								
								System.out.println("Nombre: " + socioInfo.getNombre());
								System.out.println("Email: " + socioInfo.getEmail());
								System.out.println("Fecha de nacimiento: " + socioInfo.getFechaNacimiento());
								System.out.println("Edad: " + socioInfo.getEdad() + " años");
								System.out.println("Fecha de inscripción: " + socioInfo.getFechaInscripcion());
								System.out.println("Antigüedad " + socioInfo.getAntiguedadSocio() + " años");
								
								
								break;
								
							case 4:
								System.out.println("=================== RENOVAR ABONO ===================");
								sn.nextLine();
								System.out.println("Introduce email del socio que desea renovar el abono: ");
								emailString = sn.nextLine();
								email = new Email(emailString);
								
								socioInfo = sistemaSocio.getSocioInfo(email, manager);
								
								if(GestionarAbonos.comprobarSocioNoAbonado(socioInfo)) {
									SocioAbonado socioAbonado = sistemaSocio.getSocioAbonadoInfo(email, manager);
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
								email = new Email(emailString);
								
								Socio socioCarnet = sistemaSocio.getSocioInfo(email, manager);
								sistemaSocio.crearCarnet(socioCarnet, manager);
								
								break;
								
							case 6:
								System.out.println("=========== SOLICITUD SOCIO COMPROMISARIO ===========");
								sn.nextLine();
								System.out.println("Introduce email del socio que desea realizar la solicitud: ");
								emailString = sn.nextLine();
								email = new Email(emailString);
								
								socioInfo = sistemaSocio.getSocioInfo(email, manager);
								
								System.out.println("Introduce razón: ");
								razon = sn.nextLine();
								
								sistemaSocio.añadirSolicitud(socioInfo, razon, manager);
								
								
								
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
						nombre = sn.nextLine();
						System.out.println("Introduce email: ");
						emailString = sn.nextLine();
						
						System.out.println("Introduce fecha de nacimiento (dd-MM-yyyy): ");
						fechaNacimientoString = sn.nextLine();
						
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
						LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoString, formatter);
						
						Email email = new Email(emailString);
						
						Usuario usuario = ComprarEntrada.setDatosUsuario(fechaNacimiento, nombre, email, manager);
						
						System.out.println("Introduce fecha de evento (dd-MM-yyyy): ");
						fechaEventoString = sn.nextLine();
						
						LocalDate fechaEvento = LocalDate.parse(fechaEventoString, formatter);
						
						
						
						System.out.println("Introduce el id del estadio: ");
						estadio = sn.nextInt();
						
						Estadio estadios = manager.getEstadios().obtener(estadio);
						
						System.out.println("Introduce numero de localidad: ");
						localidad = sn.nextInt();
						
						ArrayList<Localidad> localidades = ObtenerLocalidadesDisponibles.getLocalidadesDisponibles(estadios);
						
						Localidad localidadDeseada = new Localidad(0, "", 0, true);
						
						for(int i = 0; i< localidades.size(); i++) {
							if(localidades.get(i).getNumero() == localidad) {
								ObtenerLocalidadesDisponibles.ocuparLocalidad(localidades.get(i));
								localidadDeseada = localidades.get(i);
							}
						}
						
						ComprarEntrada.comprarEntrada(fechaEvento, usuario, localidadDeseada, manager);
						
						
						break;
						
					case 3:
						System.out.println("=================== CONVOCAR JUNTA ===================");
						
						break;
					
					case 4:
						System.out.println("Fin del Menu");

						manager.getUsuarios().guardarFichero();
						manager.getSocios().guardarFichero();
						manager.getAbonados().guardarFichero();
						manager.getCompromisarios().guardarFichero();
						manager.getEntradas().guardarFichero();
						manager.getJuntas().guardarFichero();
						manager.getSolicitudes().guardarFichero();
						manager.getEstadios().guardarFichero();
						
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
