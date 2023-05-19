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

	public static void main(String[] args) {

		// Declaracion de Arraylist
		ArrayList<Productos> lista = new ArrayList<Productos>();
		Scanner entrada = new Scanner(System.in);
		int opcion = 0;

		// Menu de opciones
		do {
			System.out.println(
					"¿Que desea hacer? \n\t1 = Listar Productos \n\t2 = Añadir \n\t3 = Eliminar " + "\n\t0 = Salir");
			try {
				opcion = Integer.parseInt(entrada.nextLine());

				switch (opcion) {
				case 1 -> listarProductos(lista);
//						case 2 -> añadir(lista);
//						case 3 -> eliminar(lista);
				case 0 -> System.out.println("Ha seleccionado salir");
				default -> System.out.println("Opción no válida");
				}
			} catch (NumberFormatException exc) {
				System.out.println("Dato no numérico");
				opcion = 99;
			}
		} while (opcion != 0);
		System.out.println("Hasta luego!!!");

	}

	public static void listarProductos(ArrayList<Productos> lista) {

		System.out.println("Cesta con: " + lista.size() + " producto/s");
		for (Productos product : lista) {
			System.out.println(product);
		}

	}

	public static void añadir(ArrayList<Productos> lista) {
		Scanner sc = new Scanner(System.in);

		String nombre = "", desc = "", entTeclado = "";
		Categorias cate = null;
		Float cant = 0f;
		Double precio = 0.0;
		boolean sinErrores = true, salir = false;

		do {
			sinErrores = true;
			System.out.println("Introduzca el nombre del producto (o 'salir' para parar)");
			nombre = sc.nextLine().toLowerCase().trim();
			if (nombre.equalsIgnoreCase("salir")) {
				System.out.println("Adios");
				sinErrores = false;
				salir = true;
			} else if (!Validar.validarString(nombre, 20)) {
				System.out.println("(El nombre no puede ser nulo ni puede tener mas de 20 caracteres) \n");
				sinErrores = false;
			}
		} while (!sinErrores && !salir);

		if (!salir) {
			do {
				System.out.println("Introduzca una descripcion (o 'salir' para parar)");
				desc = sc.nextLine();
				if (desc.equalsIgnoreCase("salir")) {
					System.out.println("Adios");
					sinErrores = false;
					salir = true;
				} else if (!Validar.validarString(desc, 100)) {
					System.out.println("(La descripcion no puede ser nula ni puede tener mas de 100 caracteres) \n");
					sinErrores = false;
				}

			} while (!sinErrores && !salir);
		}

		if (!salir) {
			do {
				for (int i = 0; i < Categorias.values().length; i++) {
					System.out.println((i + 1) + "-) " + Categorias.values()[i] + "\n");
				}
				System.out.println("Introduzca la categoria del producto: ");
				entTeclado = sc.nextLine().toUpperCase().replace("Í", "I");
				if (Validar.chkCategorias(entTeclado) != null) {
					cate = Validar.chkCategorias(entTeclado);
					sinErrores = true;
				} else if (!entTeclado.equalsIgnoreCase("salir")) {
					salir = true;
					sinErrores = false;
				} else {
					System.out.println("Categoria Incorrecta");
					sinErrores = false;
				}

			} while (!sinErrores && !salir);
		}

		// Control de las unidades
		if (!salir) {
			do {
				System.out.println("Cuantas unidades desea? Introduzca salir para parar");
				try {
					entTeclado = sc.nextLine().replace(',', '.');
					cant = Math.abs(Float.parseFloat(entTeclado));
					sinErrores = true;
					if (cant == 0) {
						System.out.println("Tiene que ser mayor que 0");
						sinErrores = false;
					}
				} catch (NumberFormatException e) {
					if (entTeclado.equalsIgnoreCase("salir")) {
						salir = true;
					} else {
						System.out.println("Introduzca un numero, no se admiten letras.");
						sinErrores = false;
					}
				}

			} while (!sinErrores && !salir);
		}

		if (!salir) {
			do {
				System.out.println("Que precio tiene el producto? Introduzca salir para parar");
				try {
					entTeclado = sc.nextLine().replace(',', '.');
					precio = Math.abs(Double.parseDouble(entTeclado));
					sinErrores = true;
					if (precio == 0) {
						System.out.println("Tiene que ser mayor que 0");
						sinErrores = false;
					}
				} catch (NumberFormatException e) {
					if (entTeclado.equalsIgnoreCase("salir")) {
						salir = true;
					} else {
						System.out.println("Introduzca un numero, no se admiten letras.");
						sinErrores = false;
					}
				}

			} while (!sinErrores && !salir);
		}

		if (sinErrores == true) {
			lista.add(new Productos(nombre, desc, cate, cant, precio));
		}
	}

	public static void eliminar(ArrayList<Productos> lista) {
		Scanner sc = new Scanner(System.in);
		listarProductos(lista);

		System.out.println("Introduzca el id del producto a elimiar");
		int id = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId() == id) {
				lista.remove(i);
				System.out.println("Producto eliminado correctamente.");
			}
		}
	}
}