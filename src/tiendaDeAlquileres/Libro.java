package tiendaDeAlquileres;

import java.util.regex.Pattern;

/**
 * Proyecto final - Programación.
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
	 * Patrón para un autor válido
	 */
	private static final Pattern patternAutor = Pattern
			.compile("(?i)^([a-záéíóúÁÉÍÓÚñÑ]){1,}(\\s([a-záéíóúÁÉÍÓÚñÑ]){1,})*$");

	
	/**
	 * Construye un nuevo libro con un id, un título, un año, una descripción, un autor, 
	 * un número de páginas y un género especificado y si es Bestseller.
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
	 * 				Excepción si el id no es válido.
	 * @throws NumeroPaginasNoValidoException 
	 * 				Excepción si el número de páginas no es válido.
	 * @throws GeneroEditorialNoValidoException 
	 * 				Excepción si el género editorial no es válido.
	 * @throws AutorNoValidoException 
	 * 				Excepción si el autor no es válido.
	 * @throws TituloNoValidoException 
	 * 				Excepción si el título del producto no es válido
	 * @throws AnioNoValidoException 
	 * 				Excepción si el año no es válido
	 * @throws DescripcionNoValidaException 
	 * 				Excepción si la descripción no es válida
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
	 * Comprueba si el autor es válido o no
	 * 
	 * @param autor
	 *            Autor a validar
	 * @return true si el autor es válido, false si el autor no es válido
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
	 * 				Excepción si el autor no es válido
	 */
	protected void setAutor(String autor) throws AutorNoValidoException{
		if(!esValidoAutor(autor))
			throw new AutorNoValidoException("El autor no es válido!");
		this.autor = autor;
	}

	/**
	 * Devuelve el número de páginas.
	 * 
	 * @return Número de páginas.
	 */
	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	/**
	 * Mofidica el número de páginas.
	 * 
	 * @param numPaginas
	 * 				Número de páginas del libro.
	 * @throws NumeroPaginasNoValidoException
	 * 				Excepción si el número de páginas no es válido.
	 */
	protected void setNumeroPaginas(int numeroPaginas) throws NumeroPaginasNoValidoException{
		if(numeroPaginas<=2)
			throw new NumeroPaginasNoValidoException("El número de páginas debe ser mayor de 2!");
		this.numeroPaginas = numeroPaginas;
	}

	/**
	 * Devuelve el género editorial.
	 * 
	 * @return Género editorial
	 */
	public GeneroEditorial getGenero() {
		return genero;
	}

	/**
	 * Mofidica el género editorial.
	 * 
	 * @param genero
	 * 				Género editorial
	 * @throws GeneroEditorialNoValidoException
	 * 				Excepción si el género no es válido.
	 */
	protected void setGenero(GeneroEditorial genero) throws GeneroNoValidoException {
		if(genero == null)
			throw new GeneroNoValidoException("El género no el válido!");	
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
	 * 			Excepción si la editorial no es válida
	 */
	protected void setEditorial(Editorial editorial) throws EditorialNoValidaException {
		if(editorial == null)
			throw new EditorialNoValidaException("La editorial no es válida!");	
		this.editorial = editorial;
	}


	/**
	 * Calcula el precio del libro
	 * 
	 * @param dias
	 *            Número de dias a alquilar
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
