package pkt;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		
		//Declaracion de Arraylist
			ArrayList<Productos> lista = new ArrayList<Productos>();
			Scanner entrada = new Scanner(System.in);
			int opcion = 0;
			
			//Menu de opciones
			do {			
				System.out.println("¿Que desea hacer? \n\t1 = Listar Productos \n\t2 = Añadir \n\t3 = Eliminar "
						+ "\n\t0 = Salir");
				try {
					opcion = Integer.parseInt(entrada.nextLine());
					
					switch(opcion) {
						case 1 -> listarProductos(lista);
//						case 2 -> añadir(lista);
//						case 3 -> eliminar(lista);
						case 0 -> System.out.println("Ha seleccionado salir");
						default -> System.out.println("Opción no válida");						
					}
				}catch(NumberFormatException exc) {
					System.out.println("Dato no numérico");
					opcion = 99;
				}
			}while(opcion != 0);
			System.out.println("Hasta luego!!!");
			
	}
	
	public static void listarProductos (ArrayList<Productos> lista) {	
		
		System.out.println("Cesta con: " + lista.size() + " producto/s");
		for (Productos product : lista) {
			System.out.println(product);
		}	
		
	}

}
