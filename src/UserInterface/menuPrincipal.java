package UserInterface;

import java.util.Scanner;
import java.util.InputMismatchException;
public class menuPrincipal {

	public static void main(String[] args) {
		
		Scanner sn = new Scanner(System.in);
		
		boolean salir = false;
		int opcion;
		
		while(!salir) {
			
			System.out.println("1. Crear nuevo socio.");
			System.out.println("2. Cancelar asocio.");
			System.out.println("3. Obtener informacion de un socio.");
			System.out.println("4. Convocar una junta.");
			System.out.println("5. Crear carnet socio.");
			System.out.println("6. Convertir Socio compromisario.");
			System.out.println("7. Salir");
			
			try {
			
		
			
				System.out.println("Introduce el numero de la opcion que desee realizar: ");
				opcion = sn.nextInt();
				
				switch(opcion) {
					case 1:
						System.out.println("Usted ha elegido la opcion 1:");
						break;
						
					case 2:
						System.out.println("Usted ha elegido la opcion 2:");
						break;
						
					case 3:
						System.out.println("Usted ha elegido la opcion 3:");
						break;
						
					case 4:
						System.out.println("Usted ha elegido la opcion 4:");
						break;
						
					case 5:
						System.out.println("Usted ha elegido la opcion 5:");
						break;
						
					case 6:
						System.out.println("Usted ha elegido la opcion 6:");
						break;
						
					case 7:
						salir = true;
						break;
				}
			}catch(InputMismatchException e) {
				System.out.println("Debes introducir un numero.");
				sn.next();
			}
			
		}
		
		System.out.println("Fin del menu.");

	}

}
