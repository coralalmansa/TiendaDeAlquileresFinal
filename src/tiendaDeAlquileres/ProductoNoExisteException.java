package tiendaDeAlquileres;
/**
 * Proyecto final - Programación.
 * 
 * @author Coral Almansa Dominguez
 * @version 1.0
 */
public class ProductoNoExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductoNoExisteException(String string) {
		super(string);
	}
}
