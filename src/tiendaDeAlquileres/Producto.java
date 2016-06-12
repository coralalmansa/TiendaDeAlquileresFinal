package tiendaDeAlquileres;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Proyecto final - Programaci�n.
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
	 * Patr�n para un id v�lido.
	 */
	protected static final Pattern patternId = Pattern.compile("^\\d{3}$");
	
	
	/**
	 * Patr�n para un t�tulo v�lido.
	 */
	private static final Pattern patternTitulo = Pattern
			.compile("(?i)^([a-z������������]){1,}(\\s([a-z������������]){1,})*$");
	
	
	/**
	 * Patr�n para una descripcion v�lida.
	 */
	private static final Pattern patternDescripcion = Pattern
			.compile("(?i)^([a-z������������]){1,}(\\s([a-z������������]){1,})*$");
	
	
	/**
	 * Formato de fecha (dd/MM/yyyy)
	 */
	private static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date fechaAlquiler;
	private Date fechaDevolucion;
	
	/**
	 * Construye un nuevo producto con un id, un t�tulo, un a�o y una descripci�n 
	 * especificados.
	 * 
	 * @param id
	 * @param titulo
	 * @param anio
	 * @param descripcion
	 * @throws IdNoValidoException 
	 * 				Excepci�n si el id no es v�lido
	 * @throws TituloNoValidoException 
	 * 				Excepci�n si el t�tulo del producto no es v�lido
	 * @throws AnioNoValidoException 
	 * 				Excepci�n si el a�o no es v�lido
	 * @throws DescripcionNoValidaException 
	 * 				Excepci�n si la descripci�n no es v�lida
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
	 * Comprueba que el identificador sea v�lido.
	 * @param id
	 * 			Id a validar.
	 * @return tue si es v�lido, false si no es v�lido.
	 * 	
	 */
	public static boolean esValidoId(String id){
		return patternId.matcher(id).matches();
	}
	
	
	/**
	 * Comprueba si el t�tulo es v�lido.
	 * 
	 * @param titulo
	 * 				T�tulo del producto
	 * @return	true si el t�tulo es v�lido, false si el t�tulo no es v�lido
	 */
	public static boolean esValidoTitulo(String titulo){
		return patternTitulo.matcher(titulo).matches();
	}
	
	/**
	 * Comprueba si la descripci�n es v�lida.
	 * 
	 * @param descripcion
	 * 				Descripci�n del producto
	 * @return	true si la descripci�n es v�lida, false si la descripci�n no es v�lida
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
			throw new IdNoValidoException("El id no es v�lido!");
		this.id = id;
	}

	/**
	 * Devuelve el t�tulo del producto.
	 * 
	 * @return T�tulo del producto
	 */
	public String getTitulo() {
		return titulo;
	}

	
	/**
	 * Modifica el t�tulo del producto.
	 * 
	 * @param titulo
	 * 				T�tulo del producto
	 * @throws TituloNoValidoException
	 * 				Excepci�n si el t�tulo no es v�lido
	 */
	protected void setTitulo(String titulo) throws TituloNoValidoException{
		if(!esValidoTitulo(titulo))
			throw new TituloNoValidoException("El t�tulo no es v�lido!");
		this.titulo = titulo;
	}

	/**
	 * Devuelve el a�o del producto.
	 * 
	 * @return A�o del producto
	 */
	public int getAnio() {
		return anio;
	}
	
	/**
	 * Modifica el a�o del producto.
	 * 
	 * @param anio
	 * 				A�o del producto
	 * @throws AnioNoValidoException
	 * 				Excepci�n si el a�o no es v�lido
	 */
	protected void setAnio(int anio) throws AnioNoValidoException {
		if(anio  < 1900 || anio > fecha.get(Calendar.YEAR))
			throw new AnioNoValidoException("El a�o no es v�lido!");
		this.anio = anio;
	}

	/**
	 * Devuelve la descripci�n del producto.
	 * 
	 * @return	Descripci�n del producto
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Modifica la descripci�n del producto.
	 * 
	 * @param descripcion
	 * 					Descripci�n del producto
	 * @throws DescripcionNoValidaException
	 * 					Excepci�n si la descripci�n no es v�lida
	 */
	protected void setDescripcion(String descripcion) throws DescripcionNoValidaException{
		if(!esValidaDescripcion(descripcion))
			throw new DescripcionNoValidaException("La descripci�n no es v�lida!");
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
	 * Devuelve la fecha de devoluci�n del producto.
	 * 
	 * @return Fecha de devoluci�n
	 */
	public String getFechaDevolucion() {
		return formato.format(fechaDevolucion);
	}

	/**
	 * Modifica la fecha de devoluci�n.
	 * 
	 * @param fechaDevolucion
	 * 				Nueva fecha de devoluci�n del producto
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
	 * 				Excepci�n si el tipo de producto no es v�lido
	 */
	protected void setTipo(TipoProducto tipo) throws TipoProductoNoValidoException{
		if(tipo == null)
			throw new TipoProductoNoValidoException("El tipo de producto no es v�lido!");
		this.tipo = tipo;
	}
	
	/**
	 * Calcula el precio del alquiler del producto.
	 * 
	 * @param dias
	 * 				N�mero de d�as a alquilar
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
