package tiendaDeAlquileres;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/**
 * Proyecto final - Programación.
 * 
 * @author Coral Almansa Dominguez
 * @version 1.0
 */
public class Alquiler {

	/**
	 * Fecha actual.
	 */
	private static Calendar fecha = Calendar.getInstance();
	
	/**
	 * Formato de la fecha: dd/mm/yyyy
	 */
	private static SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
	
	/**
	 * Producto a alquilar.
	 */
	private Producto producto;
	
	/**
	 * Fecha alquiler.
	 */
	private Date fechaAlquiler;
	
	/**
	 * Fecha devolución
	 */
	private Date fechaDevolucion;
	
	/**
	 * Construye un nuevo alquiler del producto esècificado.
	 * 
	 * @param producto
	 * 				Nuevo producto a alquilar
	 */
	public Alquiler(Producto producto){
		setProducto(producto);
		setFechaAlquiler(fecha.getTime());
	}

	/**
	 * Devuelve el producto a alquilar.
	 * 
	 * @return	Producto a alquilar
	 */
	protected Producto getProducto() {
		return producto;
	}

	/**
	 * Modifica el producto a alquilar.
	 * 
	 * @param producto
	 * 				Nuevo producto a alquilar
	 */
	protected void setProducto(Producto producto) {
		this.producto = producto;
	}

	/**
	 * Devuelve la fecha de alquiler.
	 * 
	 * @return Fecha de alquiler
	 */
	public String getFechaAlquiler() {
		return formatoFecha.format(fechaAlquiler);
	}

	/**
	 * Modifica al fecha de alquiler del producto.
	 * 
	 * @param fechaAlquiler
	 * 				Nueva fecha de alquiler
	 */
	protected void setFechaAlquiler(Date fechaAlquiler) {
		this.fechaAlquiler = fechaAlquiler;
	}

	/**
	 * Devuelve la fecha de devolución.
	 * 
	 * @return	Fecha de devolución
	 */
	protected String getFechaDevolucion() {
		return formatoFecha.format(fechaDevolucion);
	}

	/**
	 * Modifica la fecha de devolución del producto.
	 * 
	 * @param fechaDevolucion
	 * 				Nueva fecha de devolución
	 */
	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	
	/**
	 * Alquila un producto.
	 * 
	 * @throws ProductoNoDisponibleException
	 * 				Excepción si el producto no está disponible
	 */
	public void alquilar() throws ProductoNoDisponibleException{
		if(!producto.isDisponible())
			throw new ProductoNoDisponibleException("El producto no está disponible!");
		producto.setDisponible(false);
	}
	
	/**
	 * Hace la devolución de un producto.
	 * 
	 * @throws ProductoDisponibleException
	 * 				Excepción si el producto está disponible
	 */
	public void devolver() throws ProductoDisponibleException{
		if(producto.isDisponible())
			throw new ProductoDisponibleException("El producto si está disponible!");
		producto.setDisponible(true);
	}
	
	/**
	 * Crea la factura del alquiler de los productos.
	 * 
	 * @param alquileres
	 * 				Lista de los productos alquilados.
	 * @param dias
	 * 				Número de días de alquiler
	 * @param tipo
	 * 				Tipo de alquiler
	 * @return	Factura del alquiler
	 */
	public static String crearFactura(ArrayList<Alquiler> alquileres,
			int dias, TipoAlquiler tipo){
		String factura;
		float total = 0f;
		factura = "FACTURA del Alquiler:";
		
		for(Alquiler alquiler: alquileres){
			factura += "\r\n\r\nID: " + alquiler.getProducto().getId() + 
				"\r\nTítulo: " + alquiler.getProducto().getTitulo() +
				" ( " + alquiler.getProducto().getPrecio(dias, tipo) + " euros).\r\n";
			factura += "Fecha alquiler: " + alquiler.getFechaAlquiler();
			factura += "\r\nFecha devolución: " + alquiler.getFechaDevolucion();
			total += alquiler.getProducto().getPrecio(dias, tipo);
		}
		factura += "\r\n\r\nPRECIO: " + total + " euros.\r\n";
		return factura;
	}
	
	
}
