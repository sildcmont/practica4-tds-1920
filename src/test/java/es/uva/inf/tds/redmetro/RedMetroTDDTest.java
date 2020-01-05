package es.uva.inf.tds.redmetro;

import es.uva.inf.maps.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Clase de test TDD que prueba la clase RedMetro
 * @author silmont
 *
 */
public class RedMetroTDDTest {
	
	@Test
	@Tag ("TDD")
	void testTDDConstructorRedMetro() {
		CoordenadasGPS coordenada1 = new CoordenadasGPS("041°38'06\"N","135°05'59\"E");
		CoordenadasGPS coordenada2 = new CoordenadasGPS("056°45'43\"S","059°45'00\"W");
		Estacion estacion1 = new Estacion("estacion1", coordenada1, coordenada2);
		CoordenadasGPS coordenada3 = new CoordenadasGPS("007°28'35\"N","007°28'35\"E");
		CoordenadasGPS coordenada4 = new CoordenadasGPS("000º00'00\"N","000º00'00\"E");
		Estacion estacion2 = new Estacion("estacion2", coordenada3, coordenada4);
		Linea linea1 = new Linea(1, "rojo", estacion1, estacion2);
		
		CoordenadasGPS coordenada5 = new CoordenadasGPS("041°38'06\"S","135°05'59\"W");
		CoordenadasGPS coordenada6 = new CoordenadasGPS("034°30'06\"N","100°05'59\"E");
		Estacion estacion3 = new Estacion("estacion3", coordenada5, coordenada6);
		CoordenadasGPS coordenada7 = new CoordenadasGPS("175°38'06\"S","60°05'59\"E");
		CoordenadasGPS coordenada8 = new CoordenadasGPS("141°38'06\"N","35°05'59\"W");
		Estacion estacion4 = new Estacion("estacion4", coordenada7, coordenada8);
		Linea linea2 = new Linea(2, "azul", estacion3, estacion4);
		
		RedMetro red = new RedMetro(linea1, linea2);
		Linea[] esperado = {linea1, linea2};
		assertArrayEquals(esperado, red.getLineas().toArray());
		
	}
	
	@Test
	@Tag("TDD")
	void testTDDConstructorRedMetroNull() {
		
	}
	
	

}
