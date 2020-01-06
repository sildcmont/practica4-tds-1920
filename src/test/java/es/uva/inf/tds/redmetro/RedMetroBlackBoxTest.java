package es.uva.inf.tds.redmetro;

import es.uva.inf.maps.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RedMetroBlackBoxTest {
	
	private RedMetro red;
	private CoordenadasGPS coordenada1, coordenada2, coordenada3, coordenada4, coordenada5, coordenada6, coordenada7, coordenada8, coordenada9, coordenada10, coordenada11, coordenada12;
	private Estacion estacion1, estacion2, estacion3, estacion4, estacion5, estacion6;
	private Linea linea1, linea2, linea3;
	
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
		
		coordenada9 = new CoordenadasGPS("041°10'06\"N","135°08'59\"W");
		coordenada10 = new CoordenadasGPS("126°45'43\"S","066°45'00\"W");
		estacion5 = new Estacion("estacion5", coordenada9, coordenada10);
		coordenada11 = new CoordenadasGPS("007°28'35\"N","107°28'35\"E");
		coordenada12 = new CoordenadasGPS("001º01'01\"N","000º00'03\"E");
		estacion6 = new Estacion("estacion6", coordenada11, coordenada12);
		linea3 = new Linea(3, "verde", estacion5, estacion6, estacion1);
		
	}
	
	@Test
	@Tag("BlackBox")
	void testTDDaddLineaExcepcionYaEsta() {
		red = new RedMetro(linea1, linea2);
		assertThrows(IllegalArgumentException.class, () ->  red.addLinea(linea1));
	}
	
	@Test
	@Tag("BlackBox")
	void testTDDeliminaLineaExcepcionNoEsta() {
		red = new RedMetro(linea1, linea2);
		assertThrows(IllegalArgumentException.class, () ->  red.eliminaLinea(linea3));
	}
	
	@Test
	@Tag("BlackBox")
	void testTDDeliminaLineaExcepcionMinimo() {
		red = new RedMetro(linea1, linea2);
		assertThrows(IllegalArgumentException.class, () ->  red.eliminaLinea(linea2));
	}
	
	@Test
	@Tag("BlackBox")
	void testTDDretiraLineaExcepcionNoEsta() {
		red = new RedMetro(linea1, linea2);
		assertThrows(IllegalArgumentException.class, () ->  red.retiraLinea(linea3));
	}
	
	@Test
	@Tag("BlackBox")
	void testTDDretiraLineaExcepcionMinimo() {
		red = new RedMetro(linea1, linea2);
		assertThrows(IllegalArgumentException.class, () ->  red.retiraLinea(linea2));
	}
	
	@Test
	@Tag("BlackBox")
	void testTDDgetCorrespondenciaLineasExcepcionNull() {
		red = new RedMetro(linea1, linea2, linea3);
		assertThrows(IllegalArgumentException.class, () ->  red.getCorrespondenciaLineas(null, linea2));
	}
	
	@Test
	@Tag("BlackBox")
	void testTDDgetCorrespondenciaLineasExcepcionLinea1NoEsta() {
		red = new RedMetro(linea2, linea3);
		assertThrows(IllegalArgumentException.class, () ->  red.getCorrespondenciaLineas(linea1, linea2));
	}
	
	@Test
	@Tag("BlackBox")
	void testTDDgetCorrespondenciaLineasExcepcionLinea2NoEsta() {
		red = new RedMetro(linea1, linea3);
		assertThrows(IllegalArgumentException.class, () ->  red.getCorrespondenciaLineas(linea1, linea2));
	}
	
	@Test
	@Tag("BlackBox")
	void testTDDgetCorrespondenciaLineasExcepcionLineasIguales() {
		red = new RedMetro(linea1, linea2, linea3);
		assertThrows(IllegalArgumentException.class, () ->  red.getCorrespondenciaLineas(linea1, linea1));
	}
	
	@Test
	@Tag("BlackBox")
	void testTDDgetConexionNoTrasbordoExcepcionNull() {
		red = new RedMetro(linea1, linea2, linea3);
		assertThrows(IllegalArgumentException.class, () ->  red.getConexionNoTrasbordo(null, estacion2));
	}
	
	@Test
	@Tag("BlackBox")
	void testTDDgetConexionNoTrasbordoExcepcionEstacionNoPertenece1() {
		red = new RedMetro(linea1, linea2);
		assertThrows(IllegalArgumentException.class, () ->  red.getConexionNoTrasbordo(estacion1, estacion5));
	}
	
	@Test
	@Tag("BlackBox")
	void testTDDgetConexionNoTrasbordoExcepcionEstacionNoPertenece2() {
		red = new RedMetro(linea1, linea2);
		assertThrows(IllegalArgumentException.class, () ->  red.getConexionNoTrasbordo(estacion5, estacion1));
	}
	
	@Test
	@Tag("BlackBox")
	void testTDDgetConexionNoTrasbordoExcepcionEstacionesIguales() {
		red = new RedMetro(linea1, linea2, linea3);
		assertThrows(IllegalArgumentException.class, () ->  red.getConexionNoTrasbordo(estacion2, estacion2));
	}

}
