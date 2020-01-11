package es.uva.inf.tds.redmetro;

import java.util.ArrayList;
import com.google.gson.*;
import es.uva.inf.maps.CoordenadasGPS;

/**
 * Clase que representa una Red de Metro compuesta por Líneas.
 * Una red de metro debe tener al menos 2 líneas.
 * @author silmont
 * @Invariant {@code getLineas().size >= 2}
 */

public class RedMetro {
	
	private ArrayList<Linea> lineasGeneral;
	private ArrayList<Linea> lineasRetiradas;
	private ArrayList<Linea> lineasEliminadas;
	
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
		if(lineas == null) throw new IllegalArgumentException();
		
		lineasGeneral = new ArrayList<>();
		lineasRetiradas = new ArrayList<>();
		lineasEliminadas = new ArrayList<>();
		
		for(int i=0; i<lineas.length; i++) {
			if(lineas[i] == null) throw new IllegalArgumentException();
			lineasGeneral.add(lineas[i]);
		}
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
		if(json == null) throw new IllegalArgumentException();
		Gson gson = new Gson();
		Linea[] lineas = gson.fromJson(json, Linea[].class);
		
		lineasGeneral = new ArrayList<>();
		lineasRetiradas = new ArrayList<>();
		lineasEliminadas = new ArrayList<>();
		
		for(Linea l : lineas) {
			lineasGeneral.add(l);
		}
	}

	/**
	 * Consulta las lineas que contiene la red de metro.
	 * @return lista con las lineas de la red
	 */
	public ArrayList<Linea> getLineas() {

		return lineasGeneral;
	}

	/**
	 * Consulta una linea a partir de su número
	 * @param numLinea numero de la linea que se quiere obtener
	 * @return linea que se identifica con el numero introducido, null si no hay una linea con ese numero
	 * 
	 * @pre.condition {@code numLinea >= 0}
	 * 
	 * @throws IllegalArgumentException cuando no se cumple la precondicion
	 */
	public Linea getLinea(int numLinea) {
		if(numLinea<0) throw new IllegalArgumentException();
		if(numLinea>lineasGeneral.size()) return null;
		
		return lineasGeneral.get(numLinea);
	}

	/**
	 * Consulta una linea a partir de su color
	 * @param color color de la linea que se quiere obtener
	 * @return linea que se identifica con el color introducido, null si no hay una linea con ese color
	 * 
	 * @pre.condition {@code color != null}
	 * 
	 * @throws IllegalArgumentException cuando no se cumple la precondicion
	 */
	public Linea getLinea(String color) {
		if(color == null) throw new IllegalArgumentException();
		for(int i=0; i<lineasGeneral.size(); i++) {
			if(lineasGeneral.get(i).getColor()==color) return lineasGeneral.get(i);
		}
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
		boolean bandera = true;
		if(lineasRetiradas.contains(linea) || lineasEliminadas.contains(linea)) bandera = false;
		
		return bandera;
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
		
		return lineasGeneral.contains(linea);
	}

	/**
	 * Añade una nueva linea a la red de metro 
	 * @param linea linea que deseamos añadir 
	 * 
	 * @pre.condition {@code !red.contieneLinea(linea))
	 * @pre.condition {@code linea != null}
	 * @pre.condition {@code linea.getNumero() == lineasGeneral.size()+1}
	 * 
	 * @throws IllegalArgumentException cuando no se cumplen las precondiciones
	 */
	public void addLinea(Linea linea) {
		if(linea == null) throw new IllegalArgumentException();
		if(contieneLinea(linea)) throw new IllegalArgumentException();
		if(linea.getNumero() != lineasGeneral.size()+1) throw new IllegalArgumentException();
		
		lineasGeneral.add(linea);
		
	}

	/**
	 * Elimina una linea de la red de metro 
	 * @param linea linea que deseamos eliminar 
	 * 
	 * @pre.condition {@code red.contieneLinea(linea))
	 * @pre.condition {@code linea != null}
	 * @pre.condition la red debe tener al menos 3 lineas 
	 * 
	 * @throws IllegalArgumentException cuando no se cumplen las precondiciones
	 */
	public void eliminaLinea(Linea linea) {
		if(linea == null) throw new IllegalArgumentException();
		if(!contieneLinea(linea)) throw new IllegalArgumentException();
		if(lineasGeneral.size()<3) throw new IllegalArgumentException();
		
		lineasEliminadas.add(linea);
		
	}

	/**
	 * Retira una linea de servicio en la red de metro 
	 * @param linea linea que deseamos retirar
	 * 
	 * @pre.condition {@code red.contieneLinea(linea))
	 * @pre.condition {@code linea != null}
	 * @pre.condition la red debe tener al menos 3 lineas
	 * 
	 * 
	 * @throws IllegalArgumentException cuando no se cumplen las precondiciones
	 */
	public void retiraLinea(Linea linea) {
		if(linea == null) throw new IllegalArgumentException();
		if(!contieneLinea(linea)) throw new IllegalArgumentException();
		if(lineasGeneral.size()<3) throw new IllegalArgumentException();
		
		lineasRetiradas.add(linea);
		
	}

	/**
	 * Consulta las lineas que han sido retiradas del servicio en la red de metro 
	 * @return lista de lineas que ya no están en servicio en la red
	 */
	public ArrayList<Linea> getLineasRetiradas() {

		return lineasRetiradas;
	}

	/**
	 * Consulta las lineas de la red que pasan por una determinada estación
	 * Si ninguna linea de esa red pasa por la estacion introducida, devuelve una lista vacia
	 * 
	 * @param estacion estacion de la que queremos consultar que lineas pasan por ella
	 * @return lista de lineas que pasan por {@code estacion}
	 * 
	 * @pre.condition {@code estacion != null}
	 * 
	 * @throw IllegalArgumentException cuando no se cumplen la precondicion
	 */
	public ArrayList<Linea> getLineasEstacion(Estacion estacion) {
		if(estacion == null) throw new IllegalArgumentException();
		ArrayList<Linea> lineasEstacion = new ArrayList<>();
		
		for(Linea l : lineasGeneral) {
			if(isLineaActiva(l) && l.contieneEstacion(estacion)) lineasEstacion.add(l);
		}
		
		return lineasEstacion;
	}

	/**
	 * Consulta en que estacion o estaciones se produce la correspondencia entre las dos lineas
	 * introducidas. Ambas lineas deben de estar en la red. Si no hay correspondencias, se devuelve
	 * una lista vacia.
	 * @param linea1 Primera linea de la que queremos saber la correspondencia con la otra
	 * @param linea2 Segunda linea de la que queremos saber la correspondencia
	 * @return lista de estaciones en las que se produce la correspondencia 
	 * 
	 * @pre.condition {@code linea1 != null}
	 * @pre.condition {@code linea2 != null}
	 * @pre.condition {@code linea1 != linea2}
	 * @pre.condition {@code red.contieneLinea(linea1)}
	 * @pre.condition {@code red.contieneLinea(linea2)}
	 * 
	 * @throws IllegalArgumentException cuando no se cumplen las precondiciones
	 */
	public Estacion[] getCorrespondenciaLineas(Linea linea1, Linea linea2) {
		if(linea1 == null) throw new IllegalArgumentException();
		if(linea2 == null) throw new IllegalArgumentException();
		if(!contieneLinea(linea1)) throw new IllegalArgumentException();
		if(!contieneLinea(linea2)) throw new IllegalArgumentException();
		if(linea1.getNumero() == linea2.getNumero()) throw new IllegalArgumentException();
		
		ArrayList<Estacion> estacionesCorrespondencia = new ArrayList<>();
		
		
		for(Estacion e1 : linea1.getEstaciones(true)) {
			for(Estacion e2 : linea2.getEstaciones(true)) {
				if(e1.getNombre() == e2.getNombre()) estacionesCorrespondencia.add(e1);
			}
		}
		Estacion[] estacionesCorrespond = (Estacion[]) estacionesCorrespondencia.toArray();
		return estacionesCorrespond;
	}

	/**
	 * Consulta si hay conexion entre dos estaciones dadas en una misma linea (sin trasbordo)
	 * @param estacion1 primera estacion que queremos consultar
	 * @param estacion2 segunda estacion que queremos consultar
	 * @return linea en la que se produce conexión, null si no hay conexion sin transbordo
	 * 
	 * @pre.condition ambas estaciones deben pertenecer a alguna de las lineas de la red
	 * @pre.condition {@code estacion1 != null}
	 * @pre.condition {@code estacion2 != null}
	 * @pre.condition {@code estacion1 != estacion2}
	 * 
	 * @throws IllegalArgumentException cuando no se cumplen las precondiciones
	 */
	public Linea getConexionNoTrasbordo(Estacion estacion1, Estacion estacion2) {
		if(estacion1 == null) throw new IllegalArgumentException();
		if(estacion2 == null) throw new IllegalArgumentException();
		if(estacion1.getNombre() == estacion2.getNombre()) throw new IllegalArgumentException();
		boolean contiene1 = false;
		boolean contiene2 = false;
		Linea lineaCorrespondencia = null;
		for(Linea l : lineasGeneral) {
			if (l.contieneEstacion(estacion1)) contiene1 = true;
			if (l.contieneEstacion(estacion2)) contiene2 = true;
			if(l.contieneEstacion(estacion1) && l.contieneEstacion(estacion2)) lineaCorrespondencia = l;
			
		}
		if(contiene1==false || contiene2 == false) throw new IllegalArgumentException();
		
		
		return lineaCorrespondencia;
	}

	/**
	 * Consulta si hay conexion entre dos estaciones dadas con la posibilidad de trasbordo.
	 * 
	 * @param estacion1
	 * @param estacion2
	 * @return lista de lineas que forman parte del trayecto en orden (la primera contiene {@code estacion1}, y la ultima {@code estacion2})
	 * 
	 * @pre.condition ambas estaciones deben pertenecer a alguna de las lineas de la red
	 * @pre.condition {@code estacion1 != null}
	 * @pre.condition {@code estacion2 != null}
	 * @pre.condition {@code estacion1 != estacion2}
	 * 
	 * @throws IllegalArgumentExceptio cuando no se cumplen las precondiciones
	 * 
	 */
	public ArrayList<Linea> getConexionTrasbordo(Estacion estacion1, Estacion estacion2) {
		if(estacion1 == null) throw new IllegalArgumentException();
		if(estacion2 == null) throw new IllegalArgumentException();
		if(estacion1.getNombre() == estacion2.getNombre()) throw new IllegalArgumentException();
		boolean contiene1 = false;
		boolean contiene2 = false;
		for(Linea l : lineasGeneral) {
			if (l.contieneEstacion(estacion1)) contiene1 = true;
			if (l.contieneEstacion(estacion2)) contiene2 = true;
		}
		if(contiene1==false || contiene2 == false) throw new IllegalArgumentException();
		
		ArrayList<Linea> listaTrasbordo = new ArrayList<>();
		
		for(Linea l1 : lineasGeneral) {
			for(Linea l2 : lineasGeneral) {
				if(l1.contieneEstacion(estacion1) && l2.contieneEstacion(estacion2) && getCorrespondenciaLineas(l1,l2).length>0) {
					listaTrasbordo.add(l1);
					listaTrasbordo.add(l2);
				}
			}
		}
		
		
		return listaTrasbordo;
	}

	/**
	 * Consulta si hay una estacion cercana a la coordenada GPS dada
	 * @param coordenada CoordenadaGPS de la que queremos comprobar la cercania de estaciones
	 * @param i distancia maxima para establecer la cercania
	 * @return lista de estaciones que se encuentran cerca
	 * 
	 * @pre.condition {@code i>=0}
	 * @pre.condition {@code coordenada != null}
	 * 
	 * @throws IllegalArgumentException cuando no se cumplen las precondiciones
	 */
	public ArrayList<Estacion> getEstacionCercana(CoordenadasGPS coordenada, int i) {
		if(i<0) throw new IllegalArgumentException();
		if(coordenada == null) throw new IllegalArgumentException();
		
		ArrayList<Estacion> estacionesCercanas = new ArrayList<Estacion>();
		for(Linea l : lineasGeneral) {
			for(Estacion e : l.getEstaciones(true)) {
				for(CoordenadasGPS c : e.getCoordenadasGPS()) {
					if(c.getDistanciaA(coordenada)<=i) estacionesCercanas.add(e);
				}
				
			}
		}
		return estacionesCercanas;
	}

	/**
	 * Obtiene toda la información de una red de metro en formato JSON
	 * @return json que representa la red de metro
	 */
	public String getJSON() {
		return new Gson().toJson(this);
	}

	
	
	
}
