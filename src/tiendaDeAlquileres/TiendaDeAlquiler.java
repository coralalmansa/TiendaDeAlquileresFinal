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
	 * A�ade un objeto de tipo Libro a la tienda.
	 * 
	 * @param id
	 * 			Id del libro
	 * @param titulo
	 * 			T�tulo del libro
	 * @param anio
	 * 			A�o de lanzamiento del libro
	 * @param descripcion
	 * 			Descripci�n del libro
	 * @param autor
	 * 			Autor del libro
	 * @param numeroPaginas
	 * 			N�mero de p�ginas del libro
	 * @param genero
	 * 			G�nero editorial
	 * @return	true si el libro se ha a�adido, false si no se ha a�adido
	 * @throws IdNoValidoException
	 * 			Excepci�n si el id no es v�lido
	 * @throws NumeroPaginasNoValidoException
	 * 			Excepci�n si el n�mero de p�ginas no es v�lido
	 * @throws GeneroNoValidoException
	 * 			Excepci�n si el g�nero no es v�lido
	 * @throws AutorNoValidoException
	 * 			Excepci�n si el autor no es v�lido
	 * @throws TituloNoValidoException
	 * 			Excepci�n si el t�tulo no es v�lido
	 * @throws AnioNoValidoException
	 * 			Excepci�n si el a�o no es v�lido
	 * @throws DescripcionNoValidaException
	 * 			Excepci�n si la descripci�n no es v�lida
	 * @throws ProductoYaExisteException
	 * 			Excepci�n si el producto ya existe
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
	 * A�ade un objeto Pel�cula a la tienda.
	 * 
	 * @param id
	 * 			Id de la pel�cula
	 * @param titulo
	 * 			T�tulo de la pel�cula
	 * @param anio
	 * 			A�o de estreno de la pel�cula
	 * @param descripcion
	 * 			Descripci�n de la pel�cula
	 * @param director
	 * 			Director de la pel�cula
	 * @param duracion
	 * 			Duraci�n de la pel�cula
	 * @param genero
	 * 			G�nero cinematogr�fico
	 * 
	 * @return true si la pel�cula se ha a�adido, false si no se ha a�adido
	 * 
	 * @throws IdNoValidoException
	 * 			Excepci�n si el id no es v�lido
	 * @throws DuracionPeliculaNoValidaException
	 * 			Excepci�n si la duraci�n de la pel�cula no es v�lida
	 * @throws GeneroNoValidoException
	 * 			Excepci�n si el g�nero no es v�lido
	 * @throws DirectorNoValidoException
	 * 			Excepci�n si el director no es v�lido
	 * @throws TituloNoValidoException
	 * 			Excepci�n si el t�tulo no es v�lido
	 * @throws AnioNoValidoException
	 * 			Excepci�n si el a�o no es v�lido
	 * @throws DescripcionNoValidaException
	 * 			Excepci�n si la descripci�n no es v�lida
	 * @throws ProductoYaExisteException
	 * 			Excepci�n si el producto ya existe
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
	 * A�ade un objeto de tipo M�sica a la tienda.
	 * 
	 * @param id
	 * 			Id de la m�sica
	 * @param titulo
	 * 			T�tulo de la m�sica
	 * @param anio
	 * 			A�o en el que se compuso la m�sica
	 * @param descripcion
	 * 			Descripci�n de la m�sica
	 * @param interprete
	 * 			Int�rprete de la m�sica
	 * @param numeroCanciones
	 * 			N�mero de canciones
	 * @param genero
	 * 			G�nero musical
	 * @return	true si la m�sica se ha a�adido, false si no se ha a�adido
	 * 
	 * @throws IdNoValidoException
	 * 			Excepci�n si el id no es v�lido
	 * @throws NumeroCancionesNoValidoException
	 * 			Excepci�n si el n�mero de canciones no es v�lido
	 * @throws GeneroNoValidoException
	 * 			Excepci�n si el g�nero musical no es v�lido
	 * @throws InterpreteNoValidoException
	 * 			Excepci�n si el int�rprete no es v�lido
	 * @throws TituloNoValidoException
	 * 			Excepci�n si el t�tulo no es v�lido
	 * @throws AnioNoValidoException
	 * 			Excepci�n si el a�o no es v�lido
	 * @throws DescripcionNoValidaException
	 * 			Excepci�n si la descripci�n no es v�lida
	 * @throws ProductoYaExisteException
	 * 			Excepci�n si el producto ya existe
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
	 * 			Excepci�n si el producto no existe
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
	 * 			Excepci�n si el producto no existe
	 */
	public Producto get(String id) throws ProductoNoExisteException{
		for(Producto producto : tiendaDeAlquiler){
			if(producto.getId().equals(id))
				return producto;
		}
		throw new ProductoNoExisteException("El producto no existe!");	
	}
	
	/**
	 * Devuelve el n�mero de productos de la tienda
	 * 
	 * @return	N�mero de productos
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
	 * Devuelve el producto con el t�tulo indicado.
	 * 
	 * @param titulo
	 * 			T�tulo que se va a buscar
	 * @return	Producto de la tienda
	 * @throws ProductoNoExisteException
	 * 			Excepci�n si el producto no existe
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
	 * 			�ndice a buscar
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
	 * Crea una lista de productos de un determinado g�nero.
	 * 
	 * @param genero
	 * 			G�nero a buscar
	 * @param tipoProducto 
	 * @return	Lista de productos de un determinado g�nero
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
