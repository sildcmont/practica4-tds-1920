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
	
	private RedMetro red;
	private CoordenadasGPS coordenada1, coordenada2, coordenada3, coordenada4, coordenada5, coordenada6, coordenada7, coordenada8;
	private Estacion estacion1, estacion2, estacion3, estacion4;
	private Linea linea1, linea2;
	
	@BeforeEach
	void setUp() {
		coordenada1 = new CoordenadasGPS("041°38'06\"N","135°05'59\"E");
		coordenada2 = new CoordenadasGPS("056°45'43\"S","059°45'00\"W");
		estacion1 = new Estacion("estacion1", coordenada1, coordenada2);
		
		coordenada3 = new CoordenadasGPS("007°28'35\"N","007°28'35\"E");
		coordenada4 = new CoordenadasGPS("000º00'00\"N","000º00'00\"E");
		estacion2 = new Estacion("estacion2", coordenada3, coordenada4);
		
		linea1 = new Linea(1, "rojo", estacion1, estacion2);
		
		coordenada5 = new CoordenadasGPS("041°38'06\"S","135°05'59\"W");
		coordenada6 = new CoordenadasGPS("034°30'06\"N","100°05'59\"E");
		estacion3 = new Estacion("estacion3", coordenada5, coordenada6);
		
		coordenada7 = new CoordenadasGPS("175°38'06\"S","60°05'59\"E");
		coordenada8 = new CoordenadasGPS("141°38'06\"N","35°05'59\"W");
		estacion4 = new Estacion("estacion4", coordenada7, coordenada8);
		
		linea2 = new Linea(2, "azul", estacion3, estacion4);
		
	}
	
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
		CoordenadasGPS coordenada1 = new CoordenadasGPS("041°38'06\"N","135°05'59\"E");
		CoordenadasGPS coordenada2 = new CoordenadasGPS("056°45'43\"S","059°45'00\"W");
		Estacion estacion1 = new Estacion("estacion1", coordenada1, coordenada2);
		CoordenadasGPS coordenada3 = new CoordenadasGPS("007°28'35\"N","007°28'35\"E");
		CoordenadasGPS coordenada4 = new CoordenadasGPS("000º00'00\"N","000º00'00\"E");
		Estacion estacion2 = new Estacion("estacion2", coordenada3, coordenada4);
		Linea linea1 = new Linea(1, "rojo", estacion1, estacion2);

		assertThrows(IllegalArgumentException.class, () ->  red = new RedMetro(linea1, null));
		
	}
	
	@Test
	@Tag("TDD")
	void testTDDConstructorJSON() {
		String json = "\"[{\\\"dorsal\\\":6,\" + \"\\\"name\\\":\\\"Iniesta\\\",\"\n" + 
				"                + \"\\\"demarcation\\\":[\\\"Right winger\\\",\\\"Midfielder\\\"],\"\n" + 
				"                + \"\\\"team\\\":\\\"FC Barcelona\\\"}]\";";
		RedMetro red = new RedMetro(json);
		Linea[] esperado = {linea1, linea2};
		assertArrayEquals(esperado, red.getLineas().toArray());
		
	}
	
	@Test
	@Tag("TDD")
	void testTDDConstructorJSONNull() {
		String json = null;
		assertThrows(IllegalArgumentException.class, () ->  red = new RedMetro(json));
		
	}
	
	
	@Test
	@Tag("TDD")
	void testTDDgetLineaNum() {
		red = new RedMetro(linea1,linea2);
		assertEquals(linea1, red.getLinea(1));
	}
	
	@Test
	@Tag("TDD")
	void testTDDgetLineaNumNegativo() {
		red = new RedMetro(linea1,linea2);
		assertThrows(IllegalArgumentException.class, () ->  red.getLinea(-5));
	}
	
	@Test
	@Tag("TDD")
	void testTDDgetLineaColor() {
		red = new RedMetro(linea1,linea2);
		assertEquals(linea1, red.getLinea("rojo"));
	}
	
	@Test
	@Tag("TDD")
	void testTDDgetLineaColorNull() {
		red = new RedMetro(linea1,linea2);
		assertThrows(IllegalArgumentException.class, () ->  red.getLinea(null));
	}
	
	@Test
	@Tag("TDD")
	void testTDDisLineaActiva() {
		red = new RedMetro(linea1,linea2);
		assertTrue(red.isLineaActiva(linea1));
	}
	

	@Test
	@Tag("TDD")
	void testTDDisLineaActivaNull() {
		red = new RedMetro(linea1,linea2);
		assertThrows(IllegalArgumentException.class, () ->  red.isLineaActiva(null));
	}
	
	@Test
	@Tag("TDD")
	void testTDDcontieneLinea() {
		red = new RedMetro(linea1,linea2);
		assertTrue(red.contieneLinea(linea1));
	}
	
	@Test
	@Tag("TDD")
	void testTDDcontieneLineaNull() {
		red = new RedMetro(linea1,linea2);
		assertThrows(IllegalArgumentException.class, () ->  red.contieneLinea(null));
	}

}
