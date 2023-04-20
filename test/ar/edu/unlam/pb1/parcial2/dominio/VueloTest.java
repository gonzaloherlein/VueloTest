package ar.edu.unlam.pb1.parcial2.dominio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class VueloTest {
	
//	 queSpuedaBuscaarUnAeropuertoPorCodigo
//	    queSpuedaBuscaarUnAeropuertoPorNombre
//	    queSepuedaCambiarLaDireccionDeUnAeropuerto
//	    
//	    
//	    QueSepUedaCrearUnaRuta
//	    QueepuedaCambiarEltvDeUnaruta
//	    
//	    
//	    queSepuedaBuscartodasLasRutasDeUnAeropuertoOrigen
//	    
//	    
//	    queNoSePuedaCrearUnVueloConLaMismRutayQueSeSuperpongaEnELHorario

	@Test
	public void queSePuedaAgregarPasajero() {
		
		Vuelo vuelo=new Vuelo("lafe","san justo");
		Pasajero pasajero1 = new Pasajero();
		assertTrue(vuelo.agregarPasajero(pasajero1));
		
	}
	
	@Test
	public void verificarDisponibilidadAsientoYAsignarAsiento() {
		Vuelo vuelo = new Vuelo("as","as");
		Pasajero pasajero = new Pasajero();
		
		assertTrue(vuelo.asignarAsiento(pasajero, 2, 4));
		assertFalse(vuelo.verificarDisponibilidadAsiento(2, 4));
	}
	
	@Test
	public void queSePuedaBuscarPasajero() {
		Vuelo vuelo = new Vuelo("as","aws");
		Pasajero pasajero = new Pasajero(12456789);
		Pasajero pasajero2 = new Pasajero(32145687);
		
		vuelo.agregarPasajero(pasajero);
		vuelo.agregarPasajero(pasajero2);
		
		Pasajero pasajeroBuscado = vuelo.buscarPasajero(12456789);
		assertEquals(pasajero, pasajeroBuscado);
	}
	
	@Test
	public void queSeOrdeneListaDePasajerosPorDNI() {
		Vuelo vuelo = new Vuelo("as","as");
		ArrayList<Pasajero> pasajeros=new ArrayList();
		Pasajero pasajero = new Pasajero(2);
		Pasajero pasajero2 = new Pasajero(1);
		Pasajero pasajero3 = new Pasajero(3);
		pasajeros.add(pasajero);
		pasajeros.add(pasajero2);
		pasajeros.add(pasajero3);
		
		Collections.sort(pasajeros);
		
		assertEquals(pasajero.getDni(), pasajeros.get(0).getDni()); 
		
		
		
		
	}
	
	
}
