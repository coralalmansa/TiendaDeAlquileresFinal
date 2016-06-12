package tiendaDeAlquileres;

import java.util.regex.Pattern;

/**
 * Proyecto final - Programaci�n.
 * 
 * @author Coral Almansa Dominguez
 * @version 1.0
 */
public class Libro extends Producto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String autor;
	private int numeroPaginas;
	private GeneroEditorial genero;
	private Editorial editorial;
	
	
	/**
	 * Patr�n para un autor v�lido
	 */
	private static final Pattern patternAutor = Pattern
			.compile("(?i)^([a-z������������]){1,}(\\s([a-z������������]){1,})*$");

	
	/**
	 * Construye un nuevo libro con un id, un t�tulo, un a�o, una descripci�n, un autor, 
	 * un n�mero de p�ginas y un g�nero especificado y si es Bestseller.
	 *
	 * @param id
	 * @param titulo
	 * @param anio
	 * @param descripcion
	 * @param autor
	 * @param numeroPaginas
	 * @param genero
	 * @param editorial
	 * @throws IdNoValidoException 
	 * 				Excepci�n si el id no es v�lido.
	 * @throws NumeroPaginasNoValidoException 
	 * 				Excepci�n si el n�mero de p�ginas no es v�lido.
	 * @throws GeneroEditorialNoValidoException 
	 * 				Excepci�n si el g�nero editorial no es v�lido.
	 * @throws AutorNoValidoException 
	 * 				Excepci�n si el autor no es v�lido.
	 * @throws TituloNoValidoException 
	 * 				Excepci�n si el t�tulo del producto no es v�lido
	 * @throws AnioNoValidoException 
	 * 				Excepci�n si el a�o no es v�lido
	 * @throws DescripcionNoValidaException 
	 * 				Excepci�n si la descripci�n no es v�lida
	 * @throws EditorialNoValidaException 
	 */
	public Libro(String id, String titulo, int anio, String descripcion,
			String autor, int numeroPaginas, GeneroEditorial genero, Editorial editorial) 
					throws IdNoValidoException, NumeroPaginasNoValidoException, 
			GeneroNoValidoException, AutorNoValidoException, TituloNoValidoException, 
			AnioNoValidoException, DescripcionNoValidaException, EditorialNoValidaException {
		super(id, titulo, anio, descripcion);
		setAutor(autor);
		setNumeroPaginas(numeroPaginas);
		setGenero(genero);
		setEditorial(editorial);
		
	}

	
	/**
	 * Comprueba si el autor es v�lido o no
	 * 
	 * @param autor
	 *            Autor a validar
	 * @return true si el autor es v�lido, false si el autor no es v�lido
	 */
	public static boolean esValidoAutor(String autor) {
		return patternAutor.matcher(autor).matches();
	}
	
	

	/*** Setters and Getters ***/
	
	/**
	 * Devuelve el autor del libro.
	 * 
	 * @return	Autor del libro
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * Modifica el autor del libro
	 * 
	 * @param autor
	 * 				Autor del libro
	 * @throws AutorNoValidoException
	 * 				Excepci�n si el autor no es v�lido
	 */
	protected void setAutor(String autor) throws AutorNoValidoException{
		if(!esValidoAutor(autor))
			throw new AutorNoValidoException("El autor no es v�lido!");
		this.autor = autor;
	}

	/**
	 * Devuelve el n�mero de p�ginas.
	 * 
	 * @return N�mero de p�ginas.
	 */
	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	/**
	 * Mofidica el n�mero de p�ginas.
	 * 
	 * @param numPaginas
	 * 				N�mero de p�ginas del libro.
	 * @throws NumeroPaginasNoValidoException
	 * 				Excepci�n si el n�mero de p�ginas no es v�lido.
	 */
	protected void setNumeroPaginas(int numeroPaginas) throws NumeroPaginasNoValidoException{
		if(numeroPaginas<=2)
			throw new NumeroPaginasNoValidoException("El n�mero de p�ginas debe ser mayor de 2!");
		this.numeroPaginas = numeroPaginas;
	}

	/**
	 * Devuelve el g�nero editorial.
	 * 
	 * @return G�nero editorial
	 */
	public GeneroEditorial getGenero() {
		return genero;
	}

	/**
	 * Mofidica el g�nero editorial.
	 * 
	 * @param genero
	 * 				G�nero editorial
	 * @throws GeneroEditorialNoValidoException
	 * 				Excepci�n si el g�nero no es v�lido.
	 */
	protected void setGenero(GeneroEditorial genero) throws GeneroNoValidoException {
		if(genero == null)
			throw new GeneroNoValidoException("El g�nero no el v�lido!");	
		this.genero = genero;
	}


	/**
	 * Devuelve la editorial del libro.
	 * 
	 * @return Editorial del libro
	 */
	public Editorial getEditorial() {
		return editorial;
	}

	
	/**
	 * Modifica la editorial del libro.
	 * 
	 * @param editorial
	 * 			Editorial del libro
	 * @throws EditorialNoValidaException
	 * 			Excepci�n si la editorial no es v�lida
	 */
	protected void setEditorial(Editorial editorial) throws EditorialNoValidaException {
		if(editorial == null)
			throw new EditorialNoValidaException("La editorial no es v�lida!");	
		this.editorial = editorial;
	}


	/**
	 * Calcula el precio del libro
	 * 
	 * @param dias
	 *            N�mero de dias a alquilar
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
