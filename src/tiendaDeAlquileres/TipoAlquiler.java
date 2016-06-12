package tiendaDeAlquileres;
/**
 * Proyecto final - Programación.
 * 
 * @author Coral Almansa Dominguez
 * @version 1.0
 */
public enum TipoAlquiler {
	
	NORMAL(2.75f), 
	NOVEDAD(3.75f);
	
	
	private float precio;
	
	/**
	 * Construye un nuevo tipo de alquiler con un precio especificado
	 * 
	 * @param precio
	 *            Precio del nuevo tipo de alquiler
	 */
	private TipoAlquiler(float precio) {
		this.precio = precio;
	}
	
	/**
	 * Devuelve el precio del tipo de alquiler
	 * 
	 * @return Precio del tipo de alquiler
	 */
	public float getPrecio() {
		return precio;
	}
	
}