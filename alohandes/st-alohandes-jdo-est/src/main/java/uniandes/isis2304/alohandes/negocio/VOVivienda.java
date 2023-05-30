package uniandes.isis2304.alohandes.negocio;

/**
 * Interfaz para los métodos get de Vivienda.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author Alonso Hernandez @fai.aher
 */


public interface VOVivienda {

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * @return El id del inmueble asociado a la vivienda
	 */
	public long getIdInmueble();

	/**
	 * @return El tipo de vivienda
	 */
	public String getTipoVivienda();

	/**
	 * @return El número de habitaciones de la vivienda
	 */
	public int getNumeroHabitaciones();
	
	@Override
	/**
	 * @return Una cadena de caracteres con todos los atributos de la relación entre inmueble y tipo de vivienda
	 */
	public String toString();
}