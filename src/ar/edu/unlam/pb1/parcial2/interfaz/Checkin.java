package ar.edu.unlam.pb1.parcial2.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb1.parcial2.dominio.Pasajero;
import ar.edu.unlam.pb1.parcial2.dominio.Vuelo;

public class Checkin {

	public static void main(String[] args) {
		
		System.out.println("Bienvenido ");
		int CantidadPasajero = 189;
		Vuelo vuelo = new Vuelo();

		int opcion = 0;
		do {
			opcion = seleccionarOpcion();
			switch (opcion) {
			case 1: 
				registrarPasajero(vuelo);
				break;
			case 2: 
				elegirAsiento(vuelo);
				break;
			case 3:
				listarPasajeros(vuelo);
				break;
			default:
				System.out.println("Opcion Invalida");
				break;
			}

		} while (opcion != 9);
	}
	
	private static int seleccionarOpcion() {
		Scanner teclado = new Scanner(System.in);
		int opcionSeleccionada=0;
		
		System.out.println("************************");
		System.out.println("Menu de opciones\n");
		System.out.println("1 - Registrar pasajero");
		System.out.println("2 - Elegir Asiento");
		System.out.println("3 - Listar pasajeros");
		System.out.println("9 - Salir");
		System.out.println("************************");
		System.out.println("Ingrese una opcion");
		
		opcionSeleccionada = teclado.nextInt();
		
		return opcionSeleccionada;
	}
	
	public static void registrarPasajero(Vuelo actual) {
		
		/*
		 * Interfaz de usuario encargada de cargar un pasajero al vuelo. Debe ingresar los datos necesarios e informar por pantalla el resultado de la operaci�n.
		 */
		
		Scanner teclado = new Scanner(System.in);
		String nombre, apellido;
		int dni;
		
		System.out.println("Ingrese el dni del pasajero: ");
		dni = teclado.nextInt();
		
		System.out.println("Ingrese el nombre del pasajero: ");
		nombre = teclado.next();
		
		System.out.println("Ingrese el apellido del pasajero: ");
		apellido = teclado.next();
		
		Pasajero pasajero = new Pasajero(dni,nombre,apellido);
		
		if(actual.agregarPasajero(pasajero)) {
			System.out.println("Se ha registrado correctamente");
		}else {
			System.out.println("Vuelva a intentarlo");
		}
	}
	
	private static void elegirAsiento(Vuelo actual) {
		
		/*
		 * Interfaz de usuario encargada de gestionar la asignaci�n de asientos en el vuelo. Debe permitir el ingreso de los datos y mostrar por pantalla el resultado de la operaci�n.
		 */
		
		Scanner teclado = new Scanner(System.in);
		int dni, fila, columna;
		Pasajero pasajeroASentar;
		
		System.out.println("Ingrese el dni del pasajero: ");
		dni = teclado.nextInt();
		
		pasajeroASentar = actual.buscarPasajero(dni);
		
		System.out.println("Asigne la fila del asiento: ");
		fila = teclado.nextInt();
		
		System.out.println("Asigne la columna del asiento: ");
		columna = teclado.nextInt();
		
		if(actual.asignarAsiento(pasajeroASentar, fila, columna)) {
			System.out.println("Ha elegido asiento correctamente");
		}else {
			System.out.println("No se ha podido elegir asiento correctamente");
		}
		
		
	}

	private static void listarPasajeros(Vuelo actual) {
		
		/*
		 * Se debe mostrar la lista de pasajeros registrados para este vuelo ordenados por DNI
		 */
		actual.getPasajeros().toString();
		
	}
}
