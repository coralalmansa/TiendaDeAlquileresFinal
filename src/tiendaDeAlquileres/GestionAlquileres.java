package tiendaDeAlquileres;

import java.io.File;
/**
 * Proyecto final - Programación.
 * 
 * @author Coral Almansa Dominguez
 * @version 1.0
 */
public class GestionAlquileres {

	/**
	 * Tienda de alquileres
	 */
	private static TiendaDeAlquiler tiendaDeAlquiler = new TiendaDeAlquiler();
	
	/**
	 * Fichero
	 */
	private static File file;
	
	/**
	 * Estado de la tienda
	 */
	private static boolean modificado;

	/**
	 * Devuelve la tienda.
	 * 
	 * @return	tienda de alquiler
	 */
	public static TiendaDeAlquiler getTiendaDeAlquiler() {
		return tiendaDeAlquiler;
	}

	/**
	 * Modifica la tienda.
	 * 
	 * @param tiendaDeAlquiler
	 * 			Nueva tienda de alquiler
	 */
	public static void setTiendaDeAlquiler(TiendaDeAlquiler tiendaDeAlquiler) {
		GestionAlquileres.tiendaDeAlquiler = tiendaDeAlquiler;
	}

	/**
	 * Devuelve el fichero.
	 * 
	 * @return Fichero
	 */
	public static File getFile() {
		return file;
	}

	/**
	 * Modifica el fichero.
	 * 
	 * @param file
	 * 			Nuevo fichero
	 */
	public static void setFile(File file) {
		GestionAlquileres.file = file;
	}

	/**
	 * Devuelve el estado de la tienda.
	 * 
	 * @return	Estado de la tienda
	 */
	public static boolean isModificado() {
		return modificado;
	}

	/**
	 * Modifica el estado de la tienda.
	 * 
	 * @param modificado
	 * 			Nuevo estado de la tienda
	 */
	public static void setModificado(boolean modificado) {
		GestionAlquileres.modificado = modificado;
	}
		
}
