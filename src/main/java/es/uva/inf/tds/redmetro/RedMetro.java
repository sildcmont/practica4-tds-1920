package es.uva.inf.tds.redmetro;

import java.util.ArrayList;
import java.util.function.BooleanSupplier;

/**
 * Clase que representa una Red de Metro compuesta por Líneas.
 * Una red de metro debe tener al menos 2 líneas.
 * @author silmont
 * @Invariant {@code getLineas().size >= 2}
 */

public class RedMetro {
	
	/**
	 * Crea un objeto que representa a una red de metro que contiene varias líneas.
	 * 
	 * @param lineas
	 * 
	 * @pre.condition {@code lineas != null}
	 * 
	 * @throws IllegalArgumentException cuando no se cumple la precondicion
	 */
	public RedMetro(Linea...lineas) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Crea un objeto que representa a una red de metro con varias lineas a partir de un json
	 * 
	 * @param json
	 * 
	 * @pre.condition {@code json != null}
	 * 
	 * @throws IllegalArgumentException cuando no se cumple la precondición
	 */
	public RedMetro(String json) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Consulta las lineas que contiene la red de metro.
	 * @return lista con las lineas de la red
	 */
	public ArrayList<Linea> getLineas() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Consulta una linea a partir de su número
	 * @param numLinea numero de la linea que se quiere obtener
	 * @return linea que se identifica con el numero introducido
	 * 
	 * @pre.condition {@code numLinea >= 0}
	 * 
	 * @throws IllegalArgumentException cuando no se cumple la precondicion
	 */
	public Linea getLinea(int numLinea) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Consulta una linea a partir de su color
	 * @param color color de la linea que se quiere obtener
	 * @return linea que se identifica con el color introducido
	 * 
	 * @pre.condition {@code color != null}
	 * 
	 * @throws IllegalArgumentException cuando no se cumple la precondicion
	 */
	public Linea getLinea(String color) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Consulta si la linea introducida esta activa en la red de metro
	 * @param linea linea que queremos comprobar 
	 * @return true si la linea esta activa, false si no está o si no se encuentra en la red
	 * 
	 * @pre.condition {@code linea != null}
	 * 
	 * @throws IllegalArgumentException cuando no se cumple la precondicion
	 */
	public boolean isLineaActiva(Linea linea) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Consulta si la linea introducida se encuentra en la red de metro 
	 * @param linea linea que queremos comprobar
	 * @return true si la linea se encuentra en la red, false si no se encuentra
	 * 
	 * @pre.condition {@code linea != null}
	 * 
	 * @throws IllegalArgumentException cuando no se cumple la precondicion
	 */
	public boolean contieneLinea(Linea linea) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Añade una nueva linea a la red de metro 
	 * @param linea linea que deseamos añadir 
	 * 
	 * @pre.condition {@code !red.contieneLinea(linea))
	 * @pre.condition {@code linea != null}
	 * 
	 * @throws IllegalArgumentException cuando no se cumplen las precondiciones
	 */
	public void addLinea(Linea linea) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Elimina una linea de la red de metro 
	 * @param linea linea que deseamos eliminar 
	 * 
	 * @pre.condition {@code red.contieneLinea(linea))
	 * @pre.condition {@code linea != null}
	 * @pre.condition {@code red.getNumLineas() >= 3}
	 * 
	 * @throws IllegalArgumentException cuando no se cumplen las precondiciones
	 */
	public void eliminaLinea(Linea linea) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Retira una linea de servicio en la red de metro 
	 * @param linea linea que deseamos retirar
	 * 
	 * @pre.condition {@code red.contieneLinea(linea))
	 * @pre.condition {@code linea != null}
	 * @pre.condition {@code red.getNumLineas() >= 3}
	 * 
	 * @throws IllegalArgumentException cuando no se cumplen las precondiciones
	 */
	public void retiraLinea(Linea linea) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Consulta las lineas que han sido retiradas del servicio en la red de metro 
	 * @return lista de lineas que ya no están en servicio en la red
	 */
	public ArrayList<Linea> getLineasRetiradas() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Consulta las lineas de la red que pasan por una determinada estación
	 * @param estacion estacion de la que queremos consultar que lineas pasan por ella
	 * @return lista de lineas que pasan por {@code estacion}
	 */
	public ArrayList<Linea> getLineasEstacion(Estacion estacion) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Consulta en que estacion o estaciones se produce la correspondencia entre las dos lineas
	 * introducidas. Ambas lineas deben de estar en la red. Si no hay correspondencias, se devuelve
	 * una lista vacia.
	 * @param linea1 Primera linea de la que queremos saber la correspondencia con la otra
	 * @param linea2 Segunda linea de la que queremos saber la correspondencia
	 * @return lista de estaciones en las que se produce la correspondencia 
	 * 
	 * @pre.condition {@code lista1 != null}
	 * @pre.condition {@code lista2 != null}
	 * @pre.condition {@code red.contieneLinea(linea1)}
	 * @pre.condition {@code red.contieneLinea(linea2)}
	 * 
	 * @throws IllegalArgumentException cuando no se cumplen las precondiciones
	 */
	public Estacion[] getCorrespondenciaLineas(Linea linea1, Linea linea2) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Consulta si hay conexion entre dos estaciones dadas en una misma linea (sin transbordo)
	 * @param estacion1 primera estacion que queremos consultar
	 * @param estacion2 segunda estacion que queremos consultar
	 * @return linea en la que se produce conexión, null si no hay conexion sin transbordo
	 * 
	 * @pre.condition ambas estaciones deben pertenecer a alguna de las lineas de la red
	 * @pre.condition {@code estacion1 != null}
	 * @pre.condition {@code estacion2 != null}
	 * @pre.condition {@code estacion1 != estacion2}
	 * 
	 * @throws IllegalArgumentExceptio cuando no se cumplen las precondiciones
	 */
	public Linea getConexionNoTransbordo(Estacion estacion1, Estacion estacion2) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
