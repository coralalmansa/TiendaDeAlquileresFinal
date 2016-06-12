package tiendaDeAlquileres;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * @author Coral Almansa Dom�nguez
 * @version 1.0
 *
 */

public class Fichero {


	/**
	 * M�todo para abrir una tienda existente
	 * 
	 * @param file
	 *            Representa el fichero a abrir
	 * @return Tienda existente
	 * @throws ClassNotFoundException 
	 * @throws IOException
	 */
	public static TiendaDeAlquiler abrir(File file) throws ClassNotFoundException,
			IOException {
		file = comprobarExtension(file);
		try (ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(file)))) {
			return (TiendaDeAlquiler) in.readObject();
		}
	}
	
	/**
	 * M�todo para guardar una tienda
	 * 
	 * @param file
	 *            Representa el fichero a guardar
	 * @param tienda
	 *            Representa la tienda a guardar
	 * @throws IOException
	 */
	public static void guardar(File file, TiendaDeAlquiler tiendaDeAlquiler) throws IOException {
		file = comprobarExtension(file);
		try (ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(file, false)))) {
			out.writeObject(tiendaDeAlquiler);
		}
	}
	
	/**
	 * Comprueba si el fichero existe
	 * 
	 * @param file
	 *            Representa el fichero a comprobar
	 * @return true si el fichero existe, false en otro caso
	 */
	public static boolean isExists(File file) {
		file = comprobarExtension(file);
		return file.exists();
	}
	
	/**
	 * Comprueba si la extensi�n del fichero es v�lida o no
	 * 
	 * @param file
	 *            Representa el fichero a comprobar
	 * @return Fichero con la extensi�n v�lida
	 */
	public static File comprobarExtension(File file) {
		String path = file.getPath();
        if (!path.endsWith(".obj"))
            return new File(path + ".obj");
        return file;
	}
}
