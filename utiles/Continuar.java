package utiles;

public class Continuar {
	/**
	* Permite al usuario decidir si quiere repetir el proceso
	* 
	* @param msg Mensaje para mostrar al usuario sobre lo que tiene que decidir
	* @return true, false Devuelve true o false dependiendo de la decision del usuario
	*/
	public static boolean continuar(String msg){
		char respuesta;
		
		do{
			respuesta = Teclado.leerCaracter(msg + "(S/N)");
		}while(respuesta != 's' && respuesta != 'S' && respuesta != 'n' && respuesta != 'N');
		
		
		if(respuesta == 'S' || respuesta == 's'){
			return true;
		}
		
		return false;
	}
}
