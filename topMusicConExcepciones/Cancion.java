package topMusicConExcepciones;

import java.util.Calendar;
import java.util.regex.Pattern;

/**
 * @author Javier Ponferrada Lopez
 * @version 2.0
 * */
public class Cancion {
	/**
	 * Fecha del sistema
	 * */
	private static final Calendar FECHA = Calendar.getInstance();
	/**
	 * Fecha del sistema
	 * */
	private static final int ANIO = FECHA.get(Calendar.YEAR);
	/**
	 * Patron para validar el titulo de la cancion y el autor.
	 * */
	 private static final Pattern PATTENRN = Pattern.compile("([\\w'´,áéóúüñ!]+\\s?){2,}");
	
	/**
	 * titulo de la cancion
	 * */
	private String titulo;
	/**
	 * Nombre del grupo o artista de la cancion
	 * */
	private String artistaOGrupo;
	/**
	 * anio de grabacion
	 * */
	private int anioGrabacion;
	
	/**
	 * Constructor de la clase 
	 * @param titulo, que se le asigna a la cancion 
	 * @param artistaOGrupo, que se le asigna a la cancion 
	 * @param anioGrabacion, que se le asigna a la cancion 
	 * @throws CancionNoValidaException 
	 * @throws AutorNoValidoException 
	 * @throws FechaNoValidaException 
	 * */
	Cancion(String titulo, String artistaOGrupo, int anioGrabacion) throws CancionNoValidaException,TituloNoValido, AutorNoValidoException, FechaNoValidaException {
		if(!PATTENRN.matcher(titulo).matches() && !PATTENRN.matcher(artistaOGrupo).matches() && !(anioGrabacion > 1950 && anioGrabacion <= ANIO)){
			throw new CancionNoValidaException("La canción no es válida.");
		}else{
			if(PATTENRN.matcher(titulo).matches())
				setTitulo(titulo);
			else
				throw new TituloNoValido("Error al insertar la canción: título no es válido.");
			
			if(PATTENRN.matcher(artistaOGrupo).matches())
				setArtistaOGrupo(artistaOGrupo);
			else
				throw new AutorNoValidoException("Error al insertar la canción: autor no es válido");
			
			if(anioGrabacion > 1950 && anioGrabacion <= ANIO)
				setAnioGrabacion(anioGrabacion);
			else
				throw new FechaNoValidaException("La Fecha no es válida.");
		}
		
		
	}
	
	/**
	 * @return titulo de la cancion
	 * */
	String getTitulo() {
		return titulo;
	}
	
	/**
	 * @param titulo, de la cancion a asignar a la misma
	 * */
	private void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	/**
	 * @return artista o grupo de la cancion
	 * */
	String getArtistaOGrupo() {
		return artistaOGrupo;
	}
	
	/**
	 * @param artistaOGrupo, de la cancion a asignar a la misma
	 * */
	private void setArtistaOGrupo(String artistaOGrupo) {
		this.artistaOGrupo = artistaOGrupo;
	}
	
	/**
	 * @return anio de grabacion de la cancion
	 * */
	int getAnioGrabacion() {
		return anioGrabacion;
	}
	
	/**
	 * @param anioGrabacion, de la cancion a asignar a la misma
	 * */
	private void setAnioGrabacion(int anioGrabacion2) {
		this.anioGrabacion = anioGrabacion2;
	}
	
	/**
	 * @return toString de la cancion
	 * */
	public String toString() {
		return "["+titulo + "," + artistaOGrupo + "," + anioGrabacion
				+ "]";
	}
	
}
