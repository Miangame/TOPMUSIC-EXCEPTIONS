package topMusicConExcepciones;
/**
 * 
 *TopMusic. Implementa un programa que gestione una lista de las canciones más
 *escuchadas. El usuario podrá:
 *<ul>
 *<li>a. Añadir una canción (en una posición) al TopMusic.</li>
 *<li>b. Sacar un elemento del TopMusic.</li>
 *<li>c. Subir un puesto en el TopMusic.</li>
 *<li>d. Bajar un puesto en el TopMusic.</li>
 *<li>e. Mostrar la lista TopMusic.</li>
 *<li>f. Mostrar la canción más escuchada.</li>
 *Sobre la canción se almacenará el título, artista o grupo y año de grabación.
 *
 *---------------------------
 *
 *Top Music. Realiza el ejercicio del listado Estructuras III. Entrega el código, la url del github y un pdf con pantallazos de los métodos donde:
 *-Creas la canción.
 *-Evitas el subir del top 1 (la primera canción no puede subir más)
 *-Obtienes el top de la canción.
 *-Muestras los 10 mejores.
 *
 *---------------------------
 *Top Music. Mejoremos la versión anterior, pero como conocemos QUÉ ES una excepción, vamos a utilizarla.
 *Los errores los controlaremos mediante las siguientes excepciones:
 *
 *-FechaNoValidaException
 *-CancionNoValidaException.
 *-AutorNoValidoException
 *-PosicionNoValidaException
 *
 *Y recuerda:
 *-En caso de error, el usuario ha de saber CON EXACTITUD cuál ha sido el problema.
 *	-Error al insertar la canción: título no es válido.
 *	-Error al insertar la canción: autor no es válido
 *	-Error al borrar la canción: posición no válida
 *	-Error al bajar la canción: posición no válida.
 *	-Error al subir la canción: la canción está la primera.
 *-El método Cancion.getInstance() ya no es necesario.
 *-Sigue usando expresiones regulares
 *
 *Utiliza pruebas unitarias para el control de errores.
 *El título de la canción: Me too, Don´t let me down, 19 días y 500 noches, Come...
 *-El autor/grupo: The B-52's, Jain...
 *-El año: Nunca posterior al año actual 
 * 
 * @author Javier Ponferrada Lopez
 * @version 2.0
 * */
import utiles.Menu;
import utiles.Teclado;

public class TestTopMusic {
	private static TopMusic topMusic = new TopMusic();
	public static void main(String[] args) {
		Menu menu = new Menu("----ELIGE----",new String[]{"Añadir canción","Borrar canción","Subir posición","Bajar posición","TOP","Mostrar lista","TOP10","Salir"});
		int opcion;
		do{
			opcion = menu.gestionar();
			gestionarMenu(opcion);	
		}while(opcion!=menu.getSALIR());	
		
	}

	private static void gestionarMenu(int opcion) {
		switch (opcion) {
		case 1://Add cancion en una posicion indicada
			annadirCacion();
			break;
		case 2://Remove cancion de la lista
			borrarCancion();
			break;	
		
		case 3://Upload cancion en la lista
			subirPosicion();
			break;
		
		case 4://GoDown
			bajarPosicion();
			break;
		
		case 5://Top
			mostrarTop();
			break;
		
		case 6://Mostrar Lista
			System.out.println(topMusic.toString());
			break;
		
		case 7:
			System.out.println(topMusic.top10());
			break;
			
		case 8:
			System.out.println("Hasta pronto.");
			break;
		}
		
		
	}
	
	/**
	 * MOSTRAR TOP
	 * */
	private static void mostrarTop() {
		if(topMusic.top()!=null)
			System.out.println("TOP: "+topMusic.top());
		else
			System.out.println("La lista de top esta vacia.");
	}
	
	/**
	 * BAJAR LA POSICION DE UNA CANCION
	 * */
	private static void bajarPosicion() {
		System.out.println(topMusic.toString());
		try {
			topMusic.goDown(pedirPosicionModificacion());
		} catch (PosicionNoValidaException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * SUBIR LA POSICION DE LA CANCION
	 * */
	private static void subirPosicion() {
		System.out.println(topMusic.toString());
		try {
			topMusic.upload(pedirPosicionModificacion());
		} catch (PosicionNoValidaException e) {
			System.out.println(e.getMessage());
		}		
	}
	
	/**
	 * BORRAR LA CANCION
	 * */
	private static void borrarCancion() {
		System.out.println(topMusic.toString());
		try {
			topMusic.remove(pedirPosicionModificacion());
		} catch (PosicionNoValidaException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	/**
	 * ANNADIR UNA CANCION
	 * */
	private static void annadirCacion() {
		System.out.println(topMusic.toString());
		try {
			topMusic.add(Teclado.leerEntero("Posicion("+1+" y "+(topMusic.size()+1)+"): "),Teclado.leerCadena("Titulo cancion: "),Teclado.leerCadena("Artista: "),Teclado.leerEntero("Anio de grabacion(>1950): "));
		} catch (TituloNoValido e) {
			System.out.println(e.getMessage());
		} catch (AutorNoValidoException e) {
			System.out.println(e.getMessage());
		} catch (FechaNoValidaException e) {
			System.out.println(e.getMessage());
		} catch (PosicionNoValidaException e) {
			System.out.println(e.getMessage());
		}catch (CancionNoValidaException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	private static int pedirPosicionModificacion(){
		return Teclado.leerEntero("Posicion("+1+" y "+(topMusic.size())+"): ");
	}
//	/**
//	 * pedir la posicion al usuario
//	 * @return la posicion de un elemento de la lista sobre la que se desea interactuar
//	 * */
//	private static int pedirPosicion(){
//		int posicion;
//			if(topMusic.isEmpty())
//				return 0;
//			do {
//				posicion = Teclado.leerEntero("Entre " + 1 + " y " + (topMusic.size()) + ":");
//
//			} while (posicion <= 0 || posicion > topMusic.size());
//			return posicion;
//
//	}
}

