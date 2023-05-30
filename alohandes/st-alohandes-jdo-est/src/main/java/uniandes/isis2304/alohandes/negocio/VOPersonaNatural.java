package uniandes.isis2304.alohandes.negocio;

/**
 * Interfaz para los métodos get de PersonaNatural.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author Alonso Hernandez @fai.aher
 */


public interface VOPersonaNatural {

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * @return El id del operador asociado a la persona natural
	 */
	public long getIdOperador();

	/**
	 * @return Indica si la persona natural ofrece alojamiento por días o no
	 */
	public boolean isOfreceAlojamientoPorDias();
	
	@Override
	/**
	 * @return Una cadena de caracteres con todos los atributos de la relación entre un operador y si ofrece alojamiento por días
	 */
	public String toString();
}