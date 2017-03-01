package topMusicConExcepciones;

import java.util.ArrayList;


/**
 * @author Javier Ponferrada Lopez
 * @version 2.0
 * */
public class TopMusic {
	/**
	 * Emboltorio de la lista de canciones
	 * */
	private ArrayList<Cancion> topMusic = new ArrayList<Cancion>();
	
	/**
	 * Anadir una canción (en una posición) al TopMusic.
	 * @param posicion, donde alojar la cancion (al usuario se muestra la posicion empezando en 1)
	 * @param titulo, de la cancion a anadir a la lista
	 * @param autor, de la cancion a anadir a la lista
	 * @param annioGrabacion, de la cancion a anadir a la lista
	 * @throws PosicionNoValidaException
	 * @throws CancionNoValidaException 
	 * @throws FechaNoValidaException 
	 * @throws AutorNoValidoException 
	 * @throws TituloNoValido 
	 * */
	void add(int posicion,String titulo, String artista,int anioGrabacion) throws CancionNoValidaException,TituloNoValido, AutorNoValidoException, FechaNoValidaException, PosicionNoValidaException{
		if(posicion-1<0 || posicion-1>getTopMusic().size())
			throw new PosicionNoValidaException("Posición no válida.");
		else
			getTopMusic().add(posicion-1,new Cancion(titulo,artista,anioGrabacion));
		
	}
	
	/**
	 * Sacar un elemento del TopMusic
	 * @param posicion, de la cancion que se debe borrar
	 * @throws PosicionNoValidaException 
	 * */
	void remove(int posicion) throws PosicionNoValidaException{
		if(!getTopMusic().isEmpty()){
			if(posicion-1<0 || posicion-1>getTopMusic().size())
				throw new PosicionNoValidaException("Error al borrar la canción: posición no válida");
			else
				getTopMusic().remove(posicion-1);
		}
		
	}
	
	/**
	 * Subir un puesto en el TopMusic
	 * @param cancion, posicion de la cancion que deseas subir de puesto
	 * @throws PosicionNoValidaException 
	 * */
	void upload(int cancion) throws PosicionNoValidaException {
		cancion = cancion - 1;
		if (!getTopMusic().isEmpty()) {
				if (cancion > 0 && cancion<size()) {
					getTopMusic().add(cancion - 1, getTopMusic().get(cancion));
					getTopMusic().remove(cancion+1);
				}else
					throw new PosicionNoValidaException("Error al subir la canción: la canción está la primera.");
		}
	}    
	
	/**
	 * Bajar un puesto en el TopMusic.
	 * @param cancion, posicion de la cancion que se desea que baje de puesto en el top
	 * @throws PosicionNoValidaException 
	 * */
	void goDown(int posicion) throws PosicionNoValidaException{
		posicion = posicion-1;
		if (!getTopMusic().isEmpty()) {
				if (posicion > 0 && posicion < getTopMusic().size() - 1) {
					getTopMusic().add(posicion + 2, getTopMusic().get(posicion));
					getTopMusic().remove(posicion);
				}
				else
					throw new PosicionNoValidaException("Error al bajar la canción: posición no válida.");
		}
	}
	
	/**
	 * Hallar el top de la lista
	 * @return la cancion que se encuentra en la primera posicion del topMusic
	 * */
	Cancion top(){
		if(!getTopMusic().isEmpty())
			return getTopMusic().get(0);
		return null;
	}
	
	/**
	 * Mostrar el top 10 de la lista
	 * @return top10 de la lista
	 * */
	String top10(){//
		StringBuilder cadena=new StringBuilder("------TOPMUSIC-------\n");
		if(!topMusic.isEmpty()){
			if(topMusic.size()>=10){
				for (int i=0;i<topMusic.size();i++) {
					cadena.append((i+1)+"-"+getTopMusic().get(i)+"\n");
				}
				return cadena.toString();
			}else{
				return "No existen 10 canciones en la lista.";
			}
			
		}
		return "La lista esta vacia.";
	}
	
	
	/**
	 * Mostrar la lista
	 * @return toString de la lista
	 * */
	public String toString(){//
		String cadena="------TOPMUSIC-------\n";
		if(!topMusic.isEmpty()){
			for (Cancion cancion : topMusic) {
				cadena +=(getTopMusic().indexOf(cancion)+1)+"-"+cancion+"\n";
			}
			return cadena;
		}
		return "La lista esta vacia.";
	}
	
	/**
	 * @return el emboltorio de la lista
	 * */
	private ArrayList<Cancion> getTopMusic() {
		return topMusic;
	}
	
	/**
	 * @return tamanio de la lista
	 * */
	int size(){
		return getTopMusic().size();
	}
	
	/**
	 * @return si esta vacia o no la lista
	 * */
	boolean isEmpty(){
		return getTopMusic().isEmpty();
	}
		

}
