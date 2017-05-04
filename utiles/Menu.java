package utiles;

/**
 * 2. Crea la clase Menu. M�telo en el paquete utiles. Implementa al menos los siguientes
 * m�todos y atributos:
 * <ul>
 * <li>a. titulo
 * <li>b. opciones
 * <li>c. numOpciones
 * <li>d. gestionar()
 * <li>e. mostrar()
 * <li>f. recogerOpcion()
 * </ul>
 * @author Alberto P�rez Cano
 * @version
 *
 */
public class Menu {
	
	private String[] opciones;
	private String titulo;
	
	public Menu(String titulo, String[] opciones){
		setTitulo(titulo);
		setOpciones(opciones);
	}
	
	private void setTitulo(String titulo){
		this.titulo = titulo;
	}
	
	private String getTitulo(){
		return this.titulo;
	}
	
	private void setOpciones(String[] opciones){
		this.opciones = opciones;
	}
	
	private String[] getOpciones(){
		return this.opciones;
	}
	
	/**
	 * Muestra un menu
	 */
	public void mostrar(){
		System.out.println(this.getTitulo());
		//System.out.println("0. Salir"); 
		for(int i = 0; i < this.getOpciones().length; i++){
			System.out.println(i+1 + ". " + getOpciones()[i]);
		}
		System.out.println((getOpciones().length+1)+ ". Salir");
	}
	
	/**
	 * Recoge la opcion
	 * @return Opcion
	 */
	public int recogerOpcion(){
		int opt;
		do{
			opt = Teclado.leerEntero("Introduzca un opcion");
		}while(opt < 1 || opt > getOpciones().length+1);
		
		return opt;
	}
	
	public int gestionar(){
		mostrar();
		return recogerOpcion();
	}

}
