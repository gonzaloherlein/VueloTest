package ar.edu.unlam.pb1.parcial2.dominio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Vuelo {

	private final int CANTIDAD_DE_FILAS = 32;
	private final int CANTIDAD_DE_ASIENTOS_POR_FILA = 6;

	private String origen;
	private String destino;
	private ArrayList<Pasajero> pasajeros;
	private Pasajero[][] asientos;


	public Vuelo(String origen, String destino) {
		this.origen = origen;
		this.destino = destino;
		this.pasajeros = new ArrayList();
		this.asientos = new Pasajero[CANTIDAD_DE_FILAS][CANTIDAD_DE_ASIENTOS_POR_FILA];
	}

	public boolean agregarPasajero(Pasajero pasajero) {
		
		return pasajeros.add(pasajero);
		/*
		 * Incorpora un nuevo pasajero a la lista de pasajeros del avi�n. Devuelve true si se pudo agregar o false si la capacidad del vuelo se encuentra completa.
		 */
		
	}

	public boolean verificarDisponibilidadAsiento(int fila, int columna) {
		for (int i = 0; i < this.CANTIDAD_DE_FILAS; i++) {
			for (int j = 0; j < this.CANTIDAD_DE_ASIENTOS_POR_FILA; j++) {
				if(asientos[fila][columna]==null) {
					return true;
				}
			}
			
		}
		
		/*
		 * Verifica si el asiento indicado se encuentra disponible.
		 */
		return false;
	}

	public Pasajero buscarPasajero(int dni) {
		
		/*
		 * Busca un pasajero en la lista de pasajeros a partir del DNI. Si no lo encuentra devuelve null.
		 */
		for (Pasajero pasajero : pasajeros) {
			if(pasajero.getDni()==dni) {
				return pasajero;
			}
			
		}
		
		return null;
		
	}

	public boolean asignarAsiento(Pasajero pasajero, int fila, int columna) {
		
		/*
		 * Asigna el asiento al pasajero recibido por par�metro. Devuelve true si lo pudo asignar o false en caso que el asiento no se encuentre disponible.
		 */
		
		if(pasajeros!=null) {
			for(int i=0;i<this.CANTIDAD_DE_FILAS;i++) {
				for (int j = 0; j < this.CANTIDAD_DE_ASIENTOS_POR_FILA; j++) {
					if(asientos[fila][columna]==null) {
						asientos[fila][columna]=pasajero;
						return true;
					}
				}
			}
		}
		return false;
		
	}
	
	public void ordenarListaDePasajerosPorDNI() {
		
		/*
		 * Ordena la lista de pasajeros por DNI.
		 */
	    Collections.sort(pasajeros);
	}
	
	public ArrayList<Pasajero> getPasajeros() {
		return pasajeros;
		/*
		 * Devuelve la lista de pasajeros
		 */
	}

	@Override
	public String toString() {
		return "Vuelo [CANTIDAD_DE_FILAS=" + CANTIDAD_DE_FILAS + ", CANTIDAD_DE_ASIENTOS_POR_FILA="
				+ CANTIDAD_DE_ASIENTOS_POR_FILA + ", origen=" + origen + ", destino=" + destino + ", pasajeros="
				+ pasajeros + ", asientos=" + Arrays.toString(asientos) + "]";
	}
	
	
}
