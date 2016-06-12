package tiendaDeAlquileres;

import java.util.regex.Pattern;

/**
 * Proyecto final - Programaci�n.
 * 
 * @author Coral Almansa Dominguez
 * @version 1.0
 */
public class Pelicula extends Producto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String director;
	private int duracion;
	private GeneroCinematografico genero;
	

	/**
	 * Patr�n para un director v�lido
	 */
	private static final Pattern patternDirector = Pattern
			.compile("(?i)^([a-z������������]){1,}(\\s([a-z������������]){1,})*$");
	

	/**
	 * Construye una pel�cula con un id, un t�tulo, un a�o, una descripci�n, un director, una duraci�n
	 *  y un g�nero especificado y si tiene oscar.
	 *  
	 * @param id
	 * @param titulo
	 * @param anio
	 * @param descripcion
	 * @param director
	 * @param duracion
	 * @param genero
	 * @throws IdNoValidoException 
	 * 					Excepci�n si el id no es v�lido
	 * @throws DuracionPeliculaNoValidaException 
	 * 					Excepci�n si la duraci�n de la pel�cula no es v�lida
	 * @throws GeneroCinematograficoNoValidoException 
	 * 					Excepci�n si el g�nero cinematogr�fico no es v�lido
	 * @throws DirectorNoValidoException 
	 * 					Excepci�n si el director no es v�lido
	 * @throws TituloNoValidoException 
	 * 					Excepci�n si el t�tulo del producto no es v�lido
	 * @throws AnioNoValidoException 
	 * 					Excepci�n si el a�o no es v�lido
	 * @throws DescripcionNoValidaException 
	 * 					Excepci�n si la descripci�n no es v�lida
	 */
	public Pelicula(String id, String titulo, int anio, String descripcion,
			String director, int duracion, GeneroCinematografico genero) 
					throws IdNoValidoException, DuracionPeliculaNoValidaException, 
			GeneroNoValidoException, DirectorNoValidoException, TituloNoValidoException, 
			AnioNoValidoException, DescripcionNoValidaException {
		super(id, titulo, anio, descripcion);
		setDirector(director);
		setDuracion(duracion);
		setGenero(genero);
		
	}

	/**
	 * Comprueba si el director de la pel�cula es v�lido
	 * 
	 * @param director
	 *            Director a validar
	 * @return true si el director es v�lido, false si el director no es v�lido
	 */
	public static boolean esValidoDirector(String director) {
		return patternDirector.matcher(director).matches();
	}
	
	

	/*** Setters and Getters ***/
	

	/**
	 * Devuelve el director de la pel�cula.
	 * 
	 * @return Director
	 */
	public String getDirector() {
		return director;
	}


	/**
	 * Modifica el director de la pel�cula.
	 * 
	 * @param director
	 * 				Director de la pel�cula
	 * @throws DirectorNoValidoException
	 * 				Excepci�n si el director no es v�lido
	 */
	protected void setDirector(String director) throws DirectorNoValidoException{
		if(!esValidoDirector(director))
			throw new DirectorNoValidoException("El director no es v�lido!");
		this.director = director;
	}

	/**
	 * Devuelve la duraci�n de la pel�cula.
	 * 
	 * @return Duraci�n de la pel�cula
	 */
	public int getDuracion() {
		return duracion;
	}

	/**
	 * Modifica la duraci�n de la pel�cula.
	 * 
	 * @param duracion
	 * 					Duraci�n de la pel�cula
	 * @throws DuracionPeliculaNoValidaException
	 * 					Excepci�n si la duraci�n no es v�lida
	 */
	protected void setDuracion(int duracion) throws DuracionPeliculaNoValidaException{
		if(duracion <= 0)
			throw new DuracionPeliculaNoValidaException("La duraci�n debe ser mayor de 0!");
		this.duracion = duracion;
	}

	/**
	 * Devuelve el g�nero cinematogr�fico.
	 * 
	 * @return G�nero cinematogr�fico
	 */
	public GeneroCinematografico getGenero() {
		return genero;
	}

	/**
	 * Modifica el g�nero cinematogr�fico
	 * 
	 * @param genero
	 * 				G�nero cinematogr�fico
	 * @throws GeneroCinematograficoNoValidoException
	 * 				Excepci�n si el g�nero no es v�lido
	 */
	protected void setGenero(GeneroCinematografico genero) throws GeneroNoValidoException{
		if(genero == null)
			throw new GeneroNoValidoException("El g�nero cinematogr�fico no es v�lido!");
		this.genero = genero;
	}



	/**
	 * Calcula el precio de la pel�cula
	 * 
	 * @param dias
	 *            N�mero de d�as a alquilar
	 * @param tipo
	 *            Tipo de alquiler
	 * @return Precio del producto
	 */
	@Override
	public float getPrecio(int dias, TipoAlquiler tipo) {
		float total;
		if (tipo == TipoAlquiler.NORMAL) {
			total = tipo.getPrecio();
			if (dias > 2)
				total += tipo.getPrecio() * 0.2 * (dias - 2);
			return total;
		} else if (tipo == TipoAlquiler.NOVEDAD) {
			total = tipo.getPrecio();
			if (dias > 2)
				total += tipo.getPrecio() * 0.2 * (dias - 2);
			return total;
		}
		return 0;
	}

}
