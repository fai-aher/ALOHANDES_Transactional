package uniandes.isis2304.alohandes.negocio;

public class Habitacion implements VOHabitacion {

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El id del inmueble asociado a la habitación
	 */
	private long idInmueble;
	
	/**
	 * El tipo de habitación
	 */
	private String tipoHabitacion;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	/**
	 * Constructor por defecto
	 */
	public Habitacion() {
		this.idInmueble = 0;
		this.tipoHabitacion = "";
	}

	/**
	 * Constructor con valores
	 * @param idInmueble - El id del inmueble asociado a la habitación
	 * @param tipoHabitacion - El tipo de habitación
	 */
	public Habitacion(long idInmueble, String tipoHabitacion) {
		this.idInmueble = idInmueble;
		this.tipoHabitacion = tipoHabitacion;
	}

	/**
	 * @return El id del inmueble asociado a la habitación
	 */
	public long getIdInmueble() {
		return idInmueble;
	}

	/**
	 * @param idInmueble - El nuevo id del inmueble asociado a la habitación
	 */
	public void setIdInmueble(long idInmueble) {
		this.idInmueble = idInmueble;
	}

	/**
	 * @return El tipo de habitación
	 */
	public String getTipoHabitacion() {
		return tipoHabitacion;
	}

	/**
	 * @param tipoHabitacion - El nuevo tipo de habitación
	 */
	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	@Override
	/**
	 * @return Una cadena de caracteres con todos los atributos de la relación entre inmueble y tipo de habitación
	 */
	public String toString() {
		return "Habitacion [idInmueble=" + idInmueble + ", tipoHabitacion=" + tipoHabitacion + "]";
	}
}