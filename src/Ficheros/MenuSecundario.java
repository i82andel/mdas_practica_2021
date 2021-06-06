package Ficheros;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Business.ComprarEntrada;
import Business.SistemasSocios;
import Data.Email;
import Data.Usuario;

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
		
		gestor.getUsuarios().insertar(usuario);
		
		gestor.getUsuarios().guardarFichero();
	}
}
