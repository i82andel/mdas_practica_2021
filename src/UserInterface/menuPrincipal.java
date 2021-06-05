package UserInterface;

import java.util.Scanner;
import java.util.InputMismatchException;

public class menuPrincipal {

	public static void main(String[] args) {
		
		Scanner sn = new Scanner(System.in);
		
		int opcionMenuPrincipal, opcionMenuSocios = 0;
		boolean salirMenu = false;
		
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
							System.out.println("  5. Cancelar abono.");
							System.out.println("  6. Crear carnet de socio.");
							System.out.println("  7. Solicitud socio compromisario.");
							System.out.println("____________________________________________________");
							System.out.println("  8. Salir.");
							System.out.println("====================================================");
							try {
								opcionMenuSocios = sn.nextInt();
							switch(opcionMenuSocios) {
							
							case 1:
								break;
								
							case 2:
								break;
								
							case 3:
								break;
								
							case 4:
								break;
								
							case 5:
								break;
								
							case 6:
								break;
								
							case 7:
								break;
								
							case 8:
								salirMenu = true;
								
								break;
								
							default:
								System.out.println("La opcion seleccionada no existe. Debe ser entre 1 y 8.");
							
							}
						
							}catch(InputMismatchException e) {
								System.out.println("Debes introducir un numero.");
								sn.next();
						}
						}
						
						
						
						break;
						
						
						
					case 2:
						System.out.println("=================== SACAR ENTRADA ===================");
						
						
						break;
						
					case 3:
						System.out.println("=================== CONVOCAR JUNTA ===================");
						
						break;
					
					case 4:
						System.out.println("Fin del Menu");
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
