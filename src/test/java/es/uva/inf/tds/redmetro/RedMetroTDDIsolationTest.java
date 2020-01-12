package es.uva.inf.tds.redmetro;

import es.uva.inf.maps.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Clase de test TDD que prueba la clase RedMetro
 * @author silmont
 *
 */
public class RedMetroTDDIsolationTest {
	
	private RedMetro red;
	private CoordenadasGPS coordenada1, coordenada2, coordenada3, coordenada4, coordenada5, coordenada6, coordenada7, coordenada8, coordenada9, coordenada10, coordenada11, coordenada12;
	private Estacion estacion1, estacion2, estacion3, estacion4, estacion5, estacion6;
	private Linea linea1, linea2, linea3;
	
	@Mock
	private CoordenadasGPS coordenada1Mock, coordenada2Mock, coordenada3Mock, coordenada4Mock, coordenada5Mock, coordenada6Mock, coordenada7Mock, coordenada8Mock, coordenada9Mock, coordenada10Mock, coordenada11Mock, coordenada12Mock;
	private Estacion estacion1Mock, estacion2Mock, estacion3Mock, estacion4Mock, estacion5Mock, estacion6Mock;
	private Linea linea1Mock, linea2Mock, linea3Mock;

	
	@BeforeEach
	void setUp() {
		coordenada1Mock = mock(CoordenadasGPS.class);
		when(coordenada1Mock.getLatitudGMS()).thenReturn("041°38'06\"N");
		when(coordenada1Mock.getLongitudGMS()).thenReturn("135°05'59\"E");
		coordenada2Mock = mock(CoordenadasGPS.class);
		when(coordenada2Mock.getLatitudGMS()).thenReturn("056°45'43\"S");
		when(coordenada2Mock.getLongitudGMS()).thenReturn("059°45'00\"W");
		
		estacion1Mock = mock(Estacion.class);
		when(estacion1Mock.getNombre()).thenReturn("estacion1");
		CoordenadasGPS[] estacion1coord = {coordenada1Mock, coordenada2Mock};
		when(estacion1Mock.getCoordenadasGPS()).thenReturn(estacion1coord);
		
		
		coordenada3 = new CoordenadasGPS("007°28'35\"N","007°28'35\"E");
		coordenada4 = new CoordenadasGPS("000º00'00\"N","000º00'00\"E");
		estacion2 = new Estacion("estacion2", coordenada3, coordenada4);
		
		coordenada3Mock = mock(CoordenadasGPS.class);
		when(coordenada3Mock.getLatitudGMS()).thenReturn("007°28'35\"N");
		when(coordenada3Mock.getLongitudGMS()).thenReturn("007°28'35\"E");
		coordenada4Mock = mock(CoordenadasGPS.class);
		when(coordenada4Mock.getLatitudGMS()).thenReturn("000º00'00\"N");
		when(coordenada4Mock.getLongitudGMS()).thenReturn("000º00'00\"E");
		
		estacion2Mock = mock(Estacion.class);
		when(estacion2Mock.getNombre()).thenReturn("estacion2");
		CoordenadasGPS[] estacion2coord = {coordenada3Mock, coordenada4Mock};
		when(estacion2Mock.getCoordenadasGPS()).thenReturn(estacion2coord);
		
		linea1Mock = mock(Linea.class);
		when(linea1Mock.getNumero()).thenReturn(1);
		when(linea1Mock.getColor()).thenReturn("rojo");
		Estacion[] estacionesLinea1 = {estacion1Mock, estacion2Mock};
		when(linea1Mock.getEstaciones(true)).thenReturn(estacionesLinea1);
		
		
		coordenada5Mock = mock(CoordenadasGPS.class);
		when(coordenada5Mock.getLatitudGMS()).thenReturn("041°38'06\"S");
		when(coordenada5Mock.getLongitudGMS()).thenReturn("135°05'59\"W");
		coordenada6Mock = mock(CoordenadasGPS.class);
		when(coordenada6Mock.getLatitudGMS()).thenReturn("034°30'06\"N");
		when(coordenada6Mock.getLongitudGMS()).thenReturn("100°05'59\"E");
		
		estacion3Mock = mock(Estacion.class);
		when(estacion3Mock.getNombre()).thenReturn("estacion3");
		CoordenadasGPS[] estacion3coord = {coordenada5Mock, coordenada6Mock};
		when(estacion3Mock.getCoordenadasGPS()).thenReturn(estacion3coord);
		
		
		coordenada7Mock = mock(CoordenadasGPS.class);
		when(coordenada7Mock.getLatitudGMS()).thenReturn("175°38'06\"S");
		when(coordenada7Mock.getLongitudGMS()).thenReturn("60°05'59\"E");
		coordenada8Mock = mock(CoordenadasGPS.class);
		when(coordenada8Mock.getLatitudGMS()).thenReturn("141°38'06\"N");
		when(coordenada8Mock.getLongitudGMS()).thenReturn("35°05'59\"W");
		
		estacion4Mock = mock(Estacion.class);
		when(estacion4Mock.getNombre()).thenReturn("estacion4");
		CoordenadasGPS[] estacion4coord = {coordenada7Mock, coordenada8Mock};
		when(estacion4Mock.getCoordenadasGPS()).thenReturn(estacion4coord);
		
		
		linea2Mock = mock(Linea.class);
		when(linea2Mock.getNumero()).thenReturn(2);
		when(linea2Mock.getColor()).thenReturn("azul");
		Estacion[] estacionesLinea2 = {estacion3Mock, estacion4Mock};
		when(linea2Mock.getEstaciones(true)).thenReturn(estacionesLinea2);
		
		coordenada9Mock = mock(CoordenadasGPS.class);
		when(coordenada9Mock.getLatitudGMS()).thenReturn("041°10'06\"N");
		when(coordenada9Mock.getLongitudGMS()).thenReturn("135°08'59\"W");
		coordenada10Mock = mock(CoordenadasGPS.class);
		when(coordenada10Mock.getLatitudGMS()).thenReturn("126°45'43\"S");
		when(coordenada10Mock.getLongitudGMS()).thenReturn("066°45'00\"W");
		
		estacion5Mock = mock(Estacion.class);
		when(estacion5Mock.getNombre()).thenReturn("estacion5");
		CoordenadasGPS[] estacion5coord = {coordenada9Mock, coordenada10Mock};
		when(estacion5Mock.getCoordenadasGPS()).thenReturn(estacion5coord);
		
		
		coordenada11Mock = mock(CoordenadasGPS.class);
		when(coordenada11Mock.getLatitudGMS()).thenReturn("007°28'35\"N");
		when(coordenada11Mock.getLongitudGMS()).thenReturn("107°28'35\"E");
		coordenada12Mock = mock(CoordenadasGPS.class);
		when(coordenada12Mock.getLatitudGMS()).thenReturn("001º01'01\"N");
		when(coordenada12Mock.getLongitudGMS()).thenReturn("000º00'03\"E");
		
		estacion6Mock = mock(Estacion.class);
		when(estacion6Mock.getNombre()).thenReturn("estacion6");
		CoordenadasGPS[] estacion6coord = {coordenada11Mock, coordenada12Mock};
		when(estacion6Mock.getCoordenadasGPS()).thenReturn(estacion6coord);
		
		
		linea3Mock = mock(Linea.class);
		when(linea3Mock.getNumero()).thenReturn(3);
		when(linea3Mock.getColor()).thenReturn("verde");
		Estacion[] estacionesLinea3 = {estacion5Mock, estacion6Mock, estacion1Mock};
		when(linea3Mock.getEstaciones(true)).thenReturn(estacionesLinea3);
		
	}
	
	
	
	@Test
	@Tag ("TDD")
	@Tag("Isolation")
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
	@Tag("Isolation")
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
	@Tag("Isolation")
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
	@Tag("Isolation")
	void testTDDConstructorJSONNull() {
		String json = null;
		assertThrows(IllegalArgumentException.class, () ->  red = new RedMetro(json));
		
	}
	
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	void testTDDgetLineaNum() {
		red = new RedMetro(linea1,linea2);
		assertEquals(linea1, red.getLinea(1));
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	void testTDDgetLineaNumNegativo() {
		red = new RedMetro(linea1,linea2);
		assertThrows(IllegalArgumentException.class, () ->  red.getLinea(-5));
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	void testTDDgetLineaColor() {
		red = new RedMetro(linea1,linea2);
		assertEquals(linea1, red.getLinea("rojo"));
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	void testTDDgetLineaColorNull() {
		red = new RedMetro(linea1,linea2);
		assertThrows(IllegalArgumentException.class, () ->  red.getLinea(null));
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	void testTDDisLineaActiva() {
		red = new RedMetro(linea1,linea2);
		assertTrue(red.isLineaActiva(linea1));
	}
	

	@Test
	@Tag("TDD")
	@Tag("Isolation")
	void testTDDisLineaActivaNull() {
		red = new RedMetro(linea1,linea2);
		assertThrows(IllegalArgumentException.class, () ->  red.isLineaActiva(null));
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	void testTDDcontieneLinea() {
		red = new RedMetro(linea1,linea2);
		assertTrue(red.contieneLinea(linea1));
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	void testTDDcontieneLineaNull() {
		red = new RedMetro(linea1,linea2);
		assertThrows(IllegalArgumentException.class, () ->  red.contieneLinea(null));
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	void testTDDaddLinea(){
		red = new RedMetro(linea1, linea2);
		red.addLinea(linea3);
		Linea[] esperado = {linea1, linea2, linea3};
		assertArrayEquals(esperado, red.getLineas().toArray());
		
	}

	@Test
	@Tag("TDD")
	@Tag("Isolation")
	void testTDDaddLineaExcepcion() {
		red = new RedMetro(linea1, linea2);
		assertThrows(IllegalArgumentException.class, () ->  red.addLinea(null));
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	void testTDDeliminaLinea(){
		red = new RedMetro(linea1, linea2, linea3);
		red.eliminaLinea(linea3);
		Linea[] esperado = {linea1, linea2};
		assertArrayEquals(esperado, red.getLineas().toArray());
		
	}

	@Test
	@Tag("TDD")
	@Tag("Isolation")
	void testTDDeliminaLineaExcepcion() {
		red = new RedMetro(linea1, linea2, linea3);
		assertThrows(IllegalArgumentException.class, () ->  red.eliminaLinea(null));
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	void testTDDretiraLinea(){
		red = new RedMetro(linea1, linea2, linea3);
		red.retiraLinea(linea3);
		Linea[] esperado = {linea1, linea2};
		assertArrayEquals(esperado, red.getLineas().toArray());
		
	}

	@Test
	@Tag("TDD")
	@Tag("Isolation")
	void testTDDretiraLineaExcepcion() {
		red = new RedMetro(linea1, linea2, linea3);
		assertThrows(IllegalArgumentException.class, () ->  red.retiraLinea(null));
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	void testTDDgetLineasRetiradas(){
		red = new RedMetro(linea1, linea2, linea3);
		red.retiraLinea(linea3);
		Linea[] esperado = {linea3};
		assertArrayEquals(esperado, red.getLineasRetiradas().toArray());
		
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	void testTDDgetLineasEstacion(){
		red = new RedMetro(linea1, linea2, linea3);
		Linea[] esperado = {linea3};
		assertArrayEquals(esperado, red.getLineasEstacion(estacion5).toArray());
		
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	void testTDDgetLineasEstacionExcepcion() {
		red = new RedMetro(linea1, linea2, linea3);
		assertThrows(IllegalArgumentException.class, () ->  red.getLineasEstacion(null));
	}

	@Test
	@Tag("TDD")
	@Tag("Isolation")
	void testTDDgetCorrespondenciaLineas() {
		red = new RedMetro(linea1, linea2, linea3);
		Estacion[] esperado = {estacion1};
		assertArrayEquals(esperado, red.getCorrespondenciaLineas(linea1, linea3));
		
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	void testTDDgetCorrespondenciaLineasExcepcion() {
		red = new RedMetro(linea1, linea2, linea3);
		assertThrows(IllegalArgumentException.class, () ->  red.getCorrespondenciaLineas(linea1, null));
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	void testTDDgetConexionNoTrasbordo() {
		red = new RedMetro(linea1, linea2, linea3);
		Linea[] esperado = {linea1};
		Linea[] obtenido = {red.getConexionNoTrasbordo(estacion1, estacion2)};
		assertArrayEquals(esperado, obtenido);
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	void testTDDgetConexionNoTrasbordoExcepcion() {
		red = new RedMetro(linea1, linea2, linea3);
		assertThrows(IllegalArgumentException.class, () ->  red.getConexionNoTrasbordo(estacion1, null));
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	void testTDDgetConexionTrasbordo() {
		red = new RedMetro(linea1, linea2, linea3);
		Linea[] esperado = {linea1, linea2};
		assertArrayEquals(esperado, red.getConexionTrasbordo(estacion1, estacion3).toArray());
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	void testTDDgetConexionTrasbordoExcepcion() {
		red = new RedMetro(linea1, linea2, linea3);
		assertThrows(IllegalArgumentException.class, () ->  red.getConexionTrasbordo(estacion1, null));
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	void testTDDgetEstacionCercana() {
		red = new RedMetro(linea1, linea2, linea3);
		Estacion[] esperado = {estacion1};
		assertArrayEquals(esperado, red.getEstacionCercana(coordenada1, 100).toArray());
		}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	void testTDDgetEstacionCercanaExcepcion() {
		red = new RedMetro(linea1, linea2, linea3);
		assertThrows(IllegalArgumentException.class, () ->  red.getEstacionCercana(null, 100));
	}
	
	@Test
	@Tag("TDD")
	@Tag("Isolation")
	void testTDDgetJSON() {
		red = new RedMetro(linea1, linea2, linea3);
		String jsonEsperado = "";
		assertEquals(jsonEsperado, red.getJSON());
	}
	
}
