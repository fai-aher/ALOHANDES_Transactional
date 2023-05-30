package uniandes.isis2304.alohandes.negocio;

/**
 * Interfaz para los métodos get de EmpresaAlojamiento.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author Alonso Hernandez @fai.aher
 */


public interface VOEmpresaAlojamiento {

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * @return El id del operador que ofrece alojamiento
	 */
	public long getIdOperador();

	/**
	 * @return El tipo de empresa de alojamiento
	 */
	public String getTipoEmpresa();

	/**
	 * @return La hora de apertura del alojamiento
	 */
	public int getHoraApertura();

	/**
	 * @return La hora de cierre del alojamiento
	 */
	public int getHoraCierre();

	@Override
	/**
	 * @return Una cadena de caracteres con todos los atributos de la empresa de alojamiento
	 */
	public String toString();

}