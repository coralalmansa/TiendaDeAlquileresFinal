package tiendaDeAlquileres;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Proyecto final - Programación.
 * 
 * @author Coral Almansa Dominguez
 * @version 1.0
 */
public abstract class Producto implements Serializable, Comparable<Producto>, Calculable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Fecha actual
	 */
	private Calendar fecha = Calendar.getInstance();
	
	private String id;
	private String titulo;
	private int anio;
	private String descripcion;
	private boolean disponible;
	private TipoProducto tipo;
	
	/**
	 * Patrón para un id válido.
	 */
	protected static final Pattern patternId = Pattern.compile("^\\d{3}$");
	
	
	/**
	 * Patrón para un título válido.
	 */
	private static final Pattern patternTitulo = Pattern
			.compile("(?i)^([a-záéíóúÁÉÍÓÚñÑ]){1,}(\\s([a-záéíóúÁÉÍÓÚñÑ]){1,})*$");
	
	
	/**
	 * Patrón para una descripcion válida.
	 */
	private static final Pattern patternDescripcion = Pattern
			.compile("(?i)^([a-záéíóúÁÉÍÓÚñÑ]){1,}(\\s([a-záéíóúÁÉÍÓÚñÑ]){1,})*$");
	
	
	/**
	 * Formato de fecha (dd/MM/yyyy)
	 */
	private static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date fechaAlquiler;
	private Date fechaDevolucion;
	
	/**
	 * Construye un nuevo producto con un id, un título, un año y una descripción 
	 * especificados.
	 * 
	 * @param id
	 * @param titulo
	 * @param anio
	 * @param descripcion
	 * @throws IdNoValidoException 
	 * 				Excepción si el id no es válido
	 * @throws TituloNoValidoException 
	 * 				Excepción si el título del producto no es válido
	 * @throws AnioNoValidoException 
	 * 				Excepción si el año no es válido
	 * @throws DescripcionNoValidaException 
	 * 				Excepción si la descripción no es válida
	 */
	public Producto(String id, String titulo, int anio,
			String descripcion) throws IdNoValidoException, TituloNoValidoException, 
			AnioNoValidoException, DescripcionNoValidaException {
	
		setId(id);
		setTitulo(titulo);
		setAnio(anio);
		setDescripcion(descripcion);
		setDisponible(true);	
	}

	

	/**
	 * Comprueba que el identificador sea válido.
	 * @param id
	 * 			Id a validar.
	 * @return tue si es válido, false si no es válido.
	 * 	
	 */
	public static boolean esValidoId(String id){
		return patternId.matcher(id).matches();
	}
	
	
	/**
	 * Comprueba si el título es válido.
	 * 
	 * @param titulo
	 * 				Título del producto
	 * @return	true si el título es válido, false si el título no es válido
	 */
	public static boolean esValidoTitulo(String titulo){
		return patternTitulo.matcher(titulo).matches();
	}
	
	/**
	 * Comprueba si la descripción es válida.
	 * 
	 * @param descripcion
	 * 				Descripción del producto
	 * @return	true si la descripción es válida, false si la descripción no es válida
	 */
	public static boolean esValidaDescripcion(String descripcion){
		return patternDescripcion.matcher(descripcion).matches();
		
	}
	
	
	
	/*** Setters and Getters ***/
	
	/**
	 * Devuelve el id del producto.
	 * 
	 * @return id del producto
	 */
	public String getId() {
		return id;
	}

	/**
	 * Modifica el id del producto.
	 * 
	 * @param id
	 * 				Nuevo id del producto
	 * @throws IdNoValidoException
	 */
	protected void setId(String id) throws IdNoValidoException {
		if(!esValidoId(id))
			throw new IdNoValidoException("El id no es válido!");
		this.id = id;
	}

	/**
	 * Devuelve el título del producto.
	 * 
	 * @return Título del producto
	 */
	public String getTitulo() {
		return titulo;
	}

	
	/**
	 * Modifica el título del producto.
	 * 
	 * @param titulo
	 * 				Título del producto
	 * @throws TituloNoValidoException
	 * 				Excepción si el título no es válido
	 */
	protected void setTitulo(String titulo) throws TituloNoValidoException{
		if(!esValidoTitulo(titulo))
			throw new TituloNoValidoException("El título no es válido!");
		this.titulo = titulo;
	}

	/**
	 * Devuelve el año del producto.
	 * 
	 * @return Año del producto
	 */
	public int getAnio() {
		return anio;
	}
	
	/**
	 * Modifica el año del producto.
	 * 
	 * @param anio
	 * 				Año del producto
	 * @throws AnioNoValidoException
	 * 				Excepción si el año no es válido
	 */
	protected void setAnio(int anio) throws AnioNoValidoException {
		if(anio  < 1900 || anio > fecha.get(Calendar.YEAR))
			throw new AnioNoValidoException("El año no es válido!");
		this.anio = anio;
	}

	/**
	 * Devuelve la descripción del producto.
	 * 
	 * @return	Descripción del producto
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Modifica la descripción del producto.
	 * 
	 * @param descripcion
	 * 					Descripción del producto
	 * @throws DescripcionNoValidaException
	 * 					Excepción si la descripción no es válida
	 */
	protected void setDescripcion(String descripcion) throws DescripcionNoValidaException{
		if(!esValidaDescripcion(descripcion))
			throw new DescripcionNoValidaException("La descripción no es válida!");
		this.descripcion = descripcion;
	}


	/**
	 * Devuelve la fecha de alquiler del producto.
	 * 
	 * @return Fecha de alquiler
	 */
	public String getFechaAlquiler() {
		return formato.format(fechaAlquiler);
	}


	/**
	 * Modifica la fecha de alquiler.
	 * 
	 * @param fechaAlquiler
	 * 				Nueva fecha de alquiler del producto
	 */
	public void setFechaAlquiler(Date fechaAlquiler) {
		this.fechaAlquiler = fechaAlquiler;
	}

	/**
	 * Devuelve la fecha de devolución del producto.
	 * 
	 * @return Fecha de devolución
	 */
	public String getFechaDevolucion() {
		return formato.format(fechaDevolucion);
	}

	/**
	 * Modifica la fecha de devolución.
	 * 
	 * @param fechaDevolucion
	 * 				Nueva fecha de devolución del producto
	 */
	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}


	/**
	 * Devuelve el estado del producto
	 * 
	 * @return Estado del producto
	 */
	public boolean isDisponible() {
		return disponible;
	}

	/**
	 * Modifica el estado del producto
	 * 
	 * @param disponible
	 *            Representa el nuevo estado del producto
	 */
	void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}


	/**
	 * Devuelve el tipo de producto.
	 * 
	 * @return Tipo de producto
	 */
	public TipoProducto getTipo() {
		return tipo;
	}

	/**
	 * Modifica el tipo de producto.
	 * 
	 * @param tipo
	 * 				Tipo de producto
	 * @throws TipoProductoNoValidoException
	 * 				Excepción si el tipo de producto no es válido
	 */
	protected void setTipo(TipoProducto tipo) throws TipoProductoNoValidoException{
		if(tipo == null)
			throw new TipoProductoNoValidoException("El tipo de producto no es válido!");
		this.tipo = tipo;
	}
	
	/**
	 * Calcula el precio del alquiler del producto.
	 * 
	 * @param dias
	 * 				Número de días a alquilar
	 * @param tipo
	 * 				Tipo de alquiler
	 * @return	Precio del producto
	 */
	@Override
	public abstract float getPrecio(int dias, TipoAlquiler tipo);


	@Override
	public int compareTo(Producto p) {
		int estado = Integer.compare(this.anio, p.anio);
		if (estado != 0) 
			return estado;
		estado = this.titulo.compareToIgnoreCase(p.titulo);
		return estado;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
