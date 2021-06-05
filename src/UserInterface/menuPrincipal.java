package UserInterface;

import java.util.Scanner;
import java.util.InputMismatchException;

public class menuPrincipal {

	public static void main(String[] args) {
		
		Scanner sn = new Scanner(System.in);
		
		int opcion;
		
		while(true) {
			System.out.println("====================== M E N U ======================");
			System.out.println("Introduce el numero de la opcion que desee realizar: ");
			System.out.println("  1. Crear nuevo socio.");
			System.out.println("  2. Cancelar asocio.");
			System.out.println("  3. Obtener informacion de un socio.");
			System.out.println("  4. Convocar una junta.");
			System.out.println("  5. Crear carnet socio.");
			System.out.println("  6. Convertir Socio compromisario.");
			System.out.println("____________________________________________________");
			System.out.println("  7. EXIT");
			System.out.println("====================================================");
			
			try {
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
						System.out.println("Fin del Menu");
						System.exit(0);
						break;
						
					default:
						System.out.println("La opcion seleccionada no existe. Debe ser entre 1 y 7.");
				}
			}catch(InputMismatchException e) {
				System.out.println("Debes introducir un numero.");
				sn.next();
			}
		}
	}
}
