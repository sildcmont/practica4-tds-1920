package es.uva.inf.tds.redmetro;


import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import es.uva.inf.maps.CoordenadasGPS;

/**
 * 
 * @author silmont
 *
 */
public class RedMetroSequenceIsolationTest {
	
private RedMetro red;
	
	
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
		when(linea1Mock.contieneEstacion(estacion1Mock)).thenReturn(true);
		when(linea1Mock.contieneEstacion(estacion2Mock)).thenReturn(true);
		when(linea1Mock.contieneEstacion(estacion3Mock)).thenReturn(false);
		when(linea1Mock.contieneEstacion(estacion4Mock)).thenReturn(false);
		when(linea1Mock.contieneEstacion(estacion5Mock)).thenReturn(false);
		when(linea1Mock.contieneEstacion(estacion6Mock)).thenReturn(false);
		when(linea1Mock.hayCorrespondencia(linea3Mock)).thenReturn(true);
		when(linea1Mock.hayCorrespondencia(linea2Mock)).thenReturn(false);
		when(linea1Mock.hayCorrespondencia(linea1Mock)).thenReturn(false);
		
		
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
		when(linea2Mock.getEstaciones(true)).thenReturn(estacionesLinea1);
		when(linea2Mock.contieneEstacion(estacion1Mock)).thenReturn(false);
		when(linea2Mock.contieneEstacion(estacion2Mock)).thenReturn(false);
		when(linea2Mock.contieneEstacion(estacion3Mock)).thenReturn(true);
		when(linea2Mock.contieneEstacion(estacion4Mock)).thenReturn(true);
		when(linea2Mock.contieneEstacion(estacion5Mock)).thenReturn(false);
		when(linea2Mock.contieneEstacion(estacion6Mock)).thenReturn(false);
		when(linea2Mock.hayCorrespondencia(linea3Mock)).thenReturn(false);
		when(linea2Mock.hayCorrespondencia(linea2Mock)).thenReturn(false);
		when(linea2Mock.hayCorrespondencia(linea1Mock)).thenReturn(false);
		
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
		Estacion[] estacionesLinea3 = {estacion1Mock, estacion5Mock, estacion6Mock};
		when(linea3Mock.getEstaciones(true)).thenReturn(estacionesLinea3);
		when(linea3Mock.contieneEstacion(estacion1Mock)).thenReturn(true);
		when(linea3Mock.contieneEstacion(estacion2Mock)).thenReturn(false);
		when(linea3Mock.contieneEstacion(estacion3Mock)).thenReturn(false);
		when(linea3Mock.contieneEstacion(estacion4Mock)).thenReturn(false);
		when(linea3Mock.contieneEstacion(estacion5Mock)).thenReturn(true);
		when(linea3Mock.contieneEstacion(estacion6Mock)).thenReturn(true);
		when(linea3Mock.hayCorrespondencia(linea3Mock)).thenReturn(false);
		when(linea3Mock.hayCorrespondencia(linea2Mock)).thenReturn(false);
		when(linea3Mock.hayCorrespondencia(linea1Mock)).thenReturn(true);
		
	}
	
	@Test
	@Tag("Sequence")
	void testSecuencia() {
		red = new RedMetro(linea1Mock,linea2Mock);
		red.addLinea(linea3Mock);
		Linea[] esperado = {linea1Mock,linea2Mock,linea3Mock};
		assertArrayEquals(esperado, red.getLineas().toArray());
		red.retiraLinea(linea3Mock);
		Linea[] esperado2 = {linea3Mock};
		assertArrayEquals(esperado2, red.getLineasRetiradas().toArray());
		
		
		
	}

}
