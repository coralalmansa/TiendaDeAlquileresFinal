package tiendaDeAlquileres;

import java.util.regex.Pattern;

/**
 * Proyecto final - Programaci�n.
 * 
 * @author Coral Almansa Dominguez
 * @version 1.0
 */
public class Musica extends Producto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String interprete;
	private int numeroCanciones;
	private GeneroMusical genero;
	
	
	/**
	 * Patr�n para un int�rprete v�lido
	 */
	private static final Pattern patternInterprete = Pattern
			.compile("(?i)^([a-z������������]){1,}(\\s([a-z������������]){1,})*$");

	
	/**
	 * Construye un nuevo objeto de tipo Musica con un id, un t�tulo, un a�o, una descripci�n, 
	 * un int�rprete, un n�mero de canciones y un g�nero especificado y si tiene Grammys.
	 * 
	 * @param id
	 * @param titulo
	 * @param anio
	 * @param descripcion
	 * @param interprete
	 * @param numeroCanciones
	 * @param genero
	 * @throws IdNoValidoException 
	 * 				Excepci�n si el id no es v�lido
	 * @throws NumeroCancionesNoValidoException 
	 * 				Excepci�n si el n�mero de canciones no es v�lido
	 * @throws GeneroNoValidoException 
	 * 				Excepci�n si el g�nero musical no es v�lido
	 * @throws InterpreteNoValidoException 
	 * 				Excepci�n si el int�rprete no es v�lido
	 * @throws TituloNoValidoException 
	 * 				Excepci�n si el t�tulo del producto no es v�lido
	 * @throws AnioNoValidoException 
	 * 				Excepci�n si el a�o no es v�lido
	 * @throws DescripcionNoValidaException 
	 * 				Excepci�n si la descripci�n no es v�lida
	 */
	public Musica(String id, String titulo, int anio, String descripcion,
			String interprete, int numeroCanciones, GeneroMusical genero) 
					throws IdNoValidoException, NumeroCancionesNoValidoException, 
			GeneroNoValidoException, InterpreteNoValidoException, TituloNoValidoException, 
			AnioNoValidoException, DescripcionNoValidaException {
		super(id, titulo, anio, descripcion);
		setInterprete(interprete);
		setNumeroCanciones(numeroCanciones);
		setGenero(genero);
		
	}

	
	/**
	 * Comprueba si el int�rprete es v�lido o no
	 * 
	 * @param interprete
	 *            Int�rprete a validar
	 * @return true si el int�rprete es v�lido, false si el int�rprete no es v�lido
	 */
	public static boolean esValidoInterprete(String interprete) {
		return patternInterprete.matcher(interprete).matches();
	}
	

	
	
	/*** Setters and Getters ***/
	
	/**
	 * Devuelve el int�rprete de la m�sica.
	 * 
	 * @return Int�rprete
	 */
	public String getInterprete() {
		return interprete;
	}

	/**
	 * Modifica el int�rprete de la m�sica.
	 * 
	 * @param interprete
	 * 				Int�rprete de la m�sica
	 * @throws InterpreteNoValidoException
	 * 				Excepci�n si el int�rprete no es v�lido
	 */
	protected void setInterprete(String interprete) throws InterpreteNoValidoException{
		if(!esValidoInterprete(interprete))
			throw new InterpreteNoValidoException("El int�rprete no es v�lido!");
		this.interprete = interprete;
	}

	/**
	 * Devuelve el n�mero de canciones.
	 * 
	 * @return N�mero de canciones
	 */
	public int getNumeroCanciones() {
		return numeroCanciones;
	}

	/**
	 * Modifica el n�mero de canciones.
	 * 
	 * @param numeroCanciones
	 * 				N�mero de canciones
	 * @throws NumeroCancionesNoValidoException
	 * 				Excepci�n si el n�mero de canciones no es v�lido
	 */
	protected void setNumeroCanciones(int numeroCanciones) throws NumeroCancionesNoValidoException{
		if(numeroCanciones <=0)
			throw new NumeroCancionesNoValidoException ("El n�mero de canciones debe ser mayor de 0!");
		this.numeroCanciones = numeroCanciones;
	}

	/**
	 * Devuelve el g�nero musical.
	 * 
	 * @return G�nero musical
	 */
	public GeneroMusical getGenero() {
		return genero;
	}

	/**
	 * Modifica el g�nero musical.
	 * 
	 * @param genero
	 * 				G�nero musical
	 * @throws GeneroNoValidoException
	 * 				Excepci�n si el g�nero musical no es v�lido
	 */
	protected void setGenero(GeneroMusical genero) throws GeneroNoValidoException{
		if(genero == null)
			throw new GeneroNoValidoException("El g�nero no es v�lido!");
		this.genero = genero;
	}


	


	/**
	 * Calcula el precio de la m�sica.
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
