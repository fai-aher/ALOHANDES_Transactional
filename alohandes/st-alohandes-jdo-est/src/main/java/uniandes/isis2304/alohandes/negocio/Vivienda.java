package uniandes.isis2304.alohandes.negocio;

public class Vivienda implements VOVivienda {

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El id del inmueble asociado a la vivienda
	 */
	private long idInmueble;
	
	/**
	 * El tipo de vivienda
	 */
	private String tipoVivienda;
	
	/**
	 * El número de habitaciones de la vivienda
	 */
	private int numeroHabitaciones;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	/**
	 * Constructor por defecto
	 */
	public Vivienda() {
		this.idInmueble = 0;
		this.tipoVivienda = "";
		this.numeroHabitaciones = 0;
	}

	/**
	 * Constructor con valores
	 * @param idInmueble - El id del inmueble asociado a la vivienda
	 * @param tipoVivienda - El tipo de vivienda
	 * @param numeroHabitaciones - El número de habitaciones de la vivienda
	 */
	public Vivienda(long idInmueble, String tipoVivienda, int numeroHabitaciones) {
		this.idInmueble = idInmueble;
		this.tipoVivienda = tipoVivienda;
		this.numeroHabitaciones = numeroHabitaciones;
	}

	/**
	 * @return El id del inmueble asociado a la vivienda
	 */
	public long getIdInmueble() {
		return idInmueble;
	}

	/**
	 * @param idInmueble - El nuevo id del inmueble asociado a la vivienda
	 */
	public void setIdInmueble(long idInmueble) {
		this.idInmueble = idInmueble;
	}

	/**
	 * @return El tipo de vivienda
	 */
	public String getTipoVivienda() {
		return tipoVivienda;
	}

	/**
	 * @param tipoVivienda - El nuevo tipo de vivienda
	 */
	public void setTipoVivienda(String tipoVivienda) {
		this.tipoVivienda = tipoVivienda;
	}

	/**
	 * @return El número de habitaciones de la vivienda
	 */
	public int getNumeroHabitaciones() {
		return numeroHabitaciones;
	}

	/**
	 * @param numeroHabitaciones - El nuevo número de habitaciones de la vivienda
	 */
	public void setNumeroHabitaciones(int numeroHabitaciones) {
		this.numeroHabitaciones = numeroHabitaciones;
	}

	@Override
	/**
	 * @return Una cadena de caracteres con todos los atributos de la relación entre inmueble y tipo de vivienda
	 */
	public String toString() {
		return "Vivienda [idInmueble=" + idInmueble + ", tipoVivienda=" + tipoVivienda + ", numeroHabitaciones="
				+ numeroHabitaciones + "]";
	}
}