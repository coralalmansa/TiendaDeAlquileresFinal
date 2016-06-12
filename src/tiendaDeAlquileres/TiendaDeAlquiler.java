package tiendaDeAlquileres;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class TiendaDeAlquiler implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * ArrayList de los productos de a tienda.
	 */
	private ArrayList<Producto> tiendaDeAlquiler = new ArrayList<Producto>();
	

	/**
	 * Añade un objeto de tipo Libro a la tienda.
	 * 
	 * @param id
	 * 			Id del libro
	 * @param titulo
	 * 			Título del libro
	 * @param anio
	 * 			Año de lanzamiento del libro
	 * @param descripcion
	 * 			Descripción del libro
	 * @param autor
	 * 			Autor del libro
	 * @param numeroPaginas
	 * 			Número de páginas del libro
	 * @param genero
	 * 			Género editorial
	 * @return	true si el libro se ha añadido, false si no se ha añadido
	 * @throws IdNoValidoException
	 * 			Excepción si el id no es válido
	 * @throws NumeroPaginasNoValidoException
	 * 			Excepción si el número de páginas no es válido
	 * @throws GeneroNoValidoException
	 * 			Excepción si el género no es válido
	 * @throws AutorNoValidoException
	 * 			Excepción si el autor no es válido
	 * @throws TituloNoValidoException
	 * 			Excepción si el título no es válido
	 * @throws AnioNoValidoException
	 * 			Excepción si el año no es válido
	 * @throws DescripcionNoValidaException
	 * 			Excepción si la descripción no es válida
	 * @throws ProductoYaExisteException
	 * 			Excepción si el producto ya existe
	 * @throws EditorialNoValidaException 
	 */
	public boolean aniadir(String id, String titulo, int anio, String descripcion,
			String autor, int numeroPaginas, GeneroEditorial genero, Editorial editorial) 
					throws IdNoValidoException, NumeroPaginasNoValidoException, 
			GeneroNoValidoException, AutorNoValidoException, TituloNoValidoException, 
			AnioNoValidoException, DescripcionNoValidaException, ProductoYaExisteException, EditorialNoValidaException  {
		
		Producto producto = new Libro(id, titulo, anio, descripcion, autor, numeroPaginas, genero, editorial);
		if(tiendaDeAlquiler.contains(producto))
			throw new ProductoYaExisteException("El producto ya existe!");
		return tiendaDeAlquiler.add(producto);	
	}

	/**
	 * Añade un objeto Película a la tienda.
	 * 
	 * @param id
	 * 			Id de la película
	 * @param titulo
	 * 			Título de la película
	 * @param anio
	 * 			Año de estreno de la película
	 * @param descripcion
	 * 			Descripción de la película
	 * @param director
	 * 			Director de la película
	 * @param duracion
	 * 			Duración de la película
	 * @param genero
	 * 			Género cinematográfico
	 * 
	 * @return true si la película se ha añadido, false si no se ha añadido
	 * 
	 * @throws IdNoValidoException
	 * 			Excepción si el id no es válido
	 * @throws DuracionPeliculaNoValidaException
	 * 			Excepción si la duración de la película no es válida
	 * @throws GeneroNoValidoException
	 * 			Excepción si el género no es válido
	 * @throws DirectorNoValidoException
	 * 			Excepción si el director no es válido
	 * @throws TituloNoValidoException
	 * 			Excepción si el título no es válido
	 * @throws AnioNoValidoException
	 * 			Excepción si el año no es válido
	 * @throws DescripcionNoValidaException
	 * 			Excepción si la descripción no es válida
	 * @throws ProductoYaExisteException
	 * 			Excepción si el producto ya existe
	 */
	public boolean aniadir(String id, String titulo, int anio, String descripcion,
			String director, int duracion, GeneroCinematografico genero) 
					throws IdNoValidoException, DuracionPeliculaNoValidaException, 
			GeneroNoValidoException, DirectorNoValidoException, TituloNoValidoException, 
			AnioNoValidoException, DescripcionNoValidaException, ProductoYaExisteException{
		Producto producto = new Pelicula(id, titulo, anio, descripcion, director, duracion, genero);
		if(tiendaDeAlquiler.contains(producto))
			throw new ProductoYaExisteException("El producto ya existe!");
		return tiendaDeAlquiler.add(producto);
	
	}
	
	/**
	 * Añade un objeto de tipo Música a la tienda.
	 * 
	 * @param id
	 * 			Id de la música
	 * @param titulo
	 * 			Título de la música
	 * @param anio
	 * 			Año en el que se compuso la música
	 * @param descripcion
	 * 			Descripción de la música
	 * @param interprete
	 * 			Intérprete de la música
	 * @param numeroCanciones
	 * 			Número de canciones
	 * @param genero
	 * 			Género musical
	 * @return	true si la música se ha añadido, false si no se ha añadido
	 * 
	 * @throws IdNoValidoException
	 * 			Excepción si el id no es válido
	 * @throws NumeroCancionesNoValidoException
	 * 			Excepción si el número de canciones no es válido
	 * @throws GeneroNoValidoException
	 * 			Excepción si el género musical no es válido
	 * @throws InterpreteNoValidoException
	 * 			Excepción si el intérprete no es válido
	 * @throws TituloNoValidoException
	 * 			Excepción si el título no es válido
	 * @throws AnioNoValidoException
	 * 			Excepción si el año no es válido
	 * @throws DescripcionNoValidaException
	 * 			Excepción si la descripción no es válida
	 * @throws ProductoYaExisteException
	 * 			Excepción si el producto ya existe
	 */
	public boolean aniadir(String id, String titulo, int anio, String descripcion,
			String interprete, int numeroCanciones, GeneroMusical genero) 
					throws IdNoValidoException, NumeroCancionesNoValidoException, 
			GeneroNoValidoException, InterpreteNoValidoException, TituloNoValidoException, 
			AnioNoValidoException, DescripcionNoValidaException, ProductoYaExisteException{
		Producto producto = new Musica(id, titulo, anio, descripcion, interprete, numeroCanciones, genero);
		if(tiendaDeAlquiler.contains(producto))
			throw new ProductoYaExisteException("El producto ya existe!");
		return tiendaDeAlquiler.add(producto);
	}
	
	/**
	 * Elimina un producto de la tienda.
	 * 
	 * @param id
	 * 			Id del producto que se va a eliminar
	 * @return	true si el producto se ha eliminado, false si el producto no se encuentra 
	 * 			en la tienda
	 * @throws ProductoNoExisteException
	 * 			Excepción si el producto no existe
	 */
	public boolean eliminar(String id) throws ProductoNoExisteException {
		Producto producto = get(id);
		if(!tiendaDeAlquiler.contains(producto))
			throw new ProductoNoExisteException("El producto no existe!");
		return tiendaDeAlquiler.remove(producto);
	}
	
	/**
	 * Devuelve el producto con el id indicado.
	 * 
	 * @param id
	 * 			Id a buscar
	 * @return Producto de la tienda
	 * @throws ProductoNoExisteException
	 * 			Excepción si el producto no existe
	 */
	public Producto get(String id) throws ProductoNoExisteException{
		for(Producto producto : tiendaDeAlquiler){
			if(producto.getId().equals(id))
				return producto;
		}
		throw new ProductoNoExisteException("El producto no existe!");	
	}
	
	/**
	 * Devuelve el número de productos de la tienda
	 * 
	 * @return	Número de productos
	 */
	public int size(){
		return tiendaDeAlquiler.size();
	}
	
	/**
	 * Ordena los productos de la tienda.
	 */
	public void ordenar(){
		Collections.sort(tiendaDeAlquiler);
	}
	
	/**
	 * Devuelve el producto con el título indicado.
	 * 
	 * @param titulo
	 * 			Título que se va a buscar
	 * @return	Producto de la tienda
	 * @throws ProductoNoExisteException
	 * 			Excepción si el producto no existe
	 */
	public Producto getProducto(String titulo) throws ProductoNoExisteException{
		for (Producto producto : tiendaDeAlquiler){
			if(producto.getTitulo().equals(titulo))
				return producto;	
		}
		throw new ProductoNoExisteException("El producto no existe!");
	}
	
	/**
	 * Devuelve el producto
	 * @param indice
	 * 			Índice a buscar
	 * @return	Producto de la tienda. null si el producto no existe
	 */
	public Producto get(int indice){
		if(tiendaDeAlquiler.isEmpty())
			return null;
		if(indice < 0 || indice > tiendaDeAlquiler.size()-1)
			return null;
		return tiendaDeAlquiler.get(indice);
	}
	
	
	/**
	 * Crea una lista de productos de un determinado género.
	 * 
	 * @param genero
	 * 			Género a buscar
	 * @param tipoProducto 
	 * @return	Lista de productos de un determinado género
	 */
	public ArrayList<Producto> getGenero(GeneroMusical genero, TipoProducto tipoProducto){
		
		ArrayList<Producto> arrayMusicaGenero = new ArrayList<Producto>();
		for (Producto producto : tiendaDeAlquiler){
			if(producto instanceof Musica){
				Musica musica = (Musica) producto;
				if (musica.getGenero() == genero)
					arrayMusicaGenero.add(musica);		
				}
			}
		return arrayMusicaGenero;	
	}
	
	public ArrayList<Producto> getGenero(GeneroCinematografico genero, TipoProducto tipoProducto){
		
		ArrayList<Producto> arrayPeliculaGenero = new ArrayList<Producto>();
		for (Producto producto : tiendaDeAlquiler){
			if(producto instanceof Musica){
				Pelicula pelicula = (Pelicula) producto;
				if (pelicula.getGenero() == genero)
					arrayPeliculaGenero.add(pelicula);		
				}
			}
		return arrayPeliculaGenero;	
	}
	
	public ArrayList<Producto> getGenero(GeneroEditorial genero, TipoProducto tipoProducto){
		
		ArrayList<Producto> arrayLibroGenero = new ArrayList<Producto>();
		for (Producto producto : tiendaDeAlquiler){
			if(producto instanceof Musica){
				Libro libro = (Libro) producto;
				if (libro.getGenero() == genero)
					arrayLibroGenero.add(libro);		
				}
			}
		return arrayLibroGenero;	
	}
	
		
}
