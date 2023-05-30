package uniandes.isis2304.alohandes.negocio;

/**
 * Interfaz para los métodos get de Habitacion.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author Alonso Hernandez @fai.aher
 */


public interface VOHabitacion {

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * @return El id del inmueble asociado a la habitación
	 */
	public long getIdInmueble();

	/**
	 * @return El tipo de habitación
	 */
	public String getTipoHabitacion();
	
	@Override
	/**
	 * @return Una cadena de caracteres con todos los atributos de la relación entre inmueble y tipo de habitación
	 */
	public String toString();
}