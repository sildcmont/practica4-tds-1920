package es.uva.inf.tds.redmetro;

import java.util.ArrayList;

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

}
