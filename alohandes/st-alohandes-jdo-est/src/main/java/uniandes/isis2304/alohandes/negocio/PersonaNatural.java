package uniandes.isis2304.alohandes.negocio;

public class PersonaNatural implements VOPersonaNatural {

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El id del operador asociado a la persona natural
	 */
	private long idOperador;
	
	/**
	 * Indica si la persona natural ofrece alojamiento por días o no
	 */
	private boolean ofreceAlojamientoPorDias;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	/**
	 * Constructor por defecto
	 */
	public PersonaNatural() {
		this.idOperador = 0;
		this.ofreceAlojamientoPorDias = false;
	}

	/**
	 * Constructor con valores
	 * @param idOperador - El id del operador asociado a la persona natural
	 * @param ofreceAlojamientoPorDias - Indica si la persona natural ofrece alojamiento por días o no
	 */
	public PersonaNatural(long idOperador, boolean ofreceAlojamientoPorDias) {
		this.idOperador = idOperador;
		this.ofreceAlojamientoPorDias = ofreceAlojamientoPorDias;
	}

	/**
	 * @return El id del operador asociado a la persona natural
	 */
	public long getIdOperador() {
		return idOperador;
	}

	/**
	 * @param idOperador - El nuevo id del operador asociado a la persona natural
	 */
	public void setIdOperador(long idOperador) {
		this.idOperador = idOperador;
	}

	/**
	 * @return Indica si la persona natural ofrece alojamiento por días o no
	 */
	public boolean isOfreceAlojamientoPorDias() {
		return ofreceAlojamientoPorDias;
	}

	/**
	 * @param ofreceAlojamientoPorDias - Indica si la persona natural ofrece alojamiento por días o no
	 */
	public void setOfreceAlojamientoPorDias(boolean ofreceAlojamientoPorDias) {
		this.ofreceAlojamientoPorDias = ofreceAlojamientoPorDias;
	}

	@Override
	/**
	 * @return Una cadena de caracteres con todos los atributos de la relación entre un operador y si ofrece alojamiento por días
	 */
	public String toString() {
		return "PersonaNatural [idOperador=" + idOperador + ", ofreceAlojamientoPorDias=" + ofreceAlojamientoPorDias + "]";
	}
}