package utiles;

import java.util.ArrayList;

/**
 * 
 * <p>
 * 3. Entrega la clase Lista que:
 * </p>
 * <ul>
 * <li>a. Añada al final de la lista
 * <li>b. Inserte un elemento en una determinada posición
 * <li>c. Modifique un elemento reemplazándolo por otro
 * <li>d. Conozca el tamaño de la lista
 * <li>e. Elimine elementos de la lista
 * <li>f. Busque elementos en la lista
 * <li>g. Copie la lista
 * </ul>
 * <p>
 * Utilízala en un ejemplo TestLista (por ejemplo, la alineación de un equipo
 * de fútbol, con titulares y reservas) y entrégalo correctamente identificado
 * y documentado, incluyendo JavaDoc.
 * </p>
 * <p>
 * Deberás implementar un menú con las opciones posibles para que el usuario
 * lo utilice fácilmente.
 * </p>
 * 
 * @author Alberto Perez Cano
 * @version 1.0
 */
public class Lista<E>{

	// Atributos
	private ArrayList<E> lista;

	// Constructor
	public Lista(ArrayList<E> arrayList) {
		super();
		if (arrayList == null)
			arrayList = new ArrayList<E>();
		setLista(arrayList);
	}
	
	
	public Lista() {
		lista = new ArrayList<E>();
	}

	// Getters & Setters

	/**
	 * @return the lista
	 */
	private ArrayList<E> getLista() {
		return lista;
	}

	/**
	 * @param lista
	 *            the lista to set
	 */
	private void setLista(ArrayList<E> lista) {
		this.lista = lista;
	}

	// Metodos

	/**
	 * Muestra la lista
	 */
	void mostrar() {
		System.out.println(getLista());
	}

	/**
	 * A�ade un elemento al final de la lista
	 * 
	 * @param o
	 *            Elemento que se a�ade a la lista
	 */
	void add(E o) {
		getLista().add(o);
	}

	/**
	 * Inserta un elemento en una posicion determinada
	 * 
	 * @param pos
	 *            Posicion en la que se va a insertar el elemento
	 * @param o
	 *            Elemento que se a�ade a la lista
	 * @return    false si no se añadio el elemento
	 */
	boolean add(int pos, E o) {
		if (pos < 0 || pos > getLista().size())
			return false;

		getLista().add(pos, o);
		return true;
	}

	/**
	 * Modifica un elemento de la lista por otro especificado
	 * 
	 * @param pos
	 *            Posicion del elemento que se va a modificar
	 * @param o
	 *            Nuevo elemento
	 * @return    false si no ha podido modificar
	 */
	boolean modificarElemento(int pos, E o) {
		if (pos < 0 || pos >= getLista().size())
			return false;
					
		getLista().set(pos, o);
		return true;
	}

	/**
	 * Devuelve el numero de elemetos de la lista
	 * 
	 * @return Numero de elementos de la lista
	 */
	int longitudLista() {
		return getLista().size();
	}
	
	/**
	 * Elimina un elemento de la lista
	 * @param pos
	 * 				Posicion del elemento a eliminar
	 * @return
	 * 			false si no se ha podido eliminar
	 */
	boolean remove(int pos) {
		if(pos < 0 || pos >= getLista().size())
			return false;
		
		getLista().remove(pos);
		return true;
	}
	
	/**
	 * Busca el objeto especificado y devuelve su posicion
	 * @param o
	 * 			Objeto a buscar
	 * @return
	 * 			-1 si no encuentra el objeto
	 */
	int buscar(E o) {
		return getLista().indexOf(o);
	}
	
	/**
	 * Copia un ArrayList
	 * @return
	 * 				Copia del ArrayList
	 */
	Object copiarLista() {
		return getLista().clone();
	}
}
