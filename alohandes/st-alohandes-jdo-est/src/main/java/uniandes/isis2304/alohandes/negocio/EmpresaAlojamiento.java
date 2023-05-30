package uniandes.isis2304.alohandes.negocio;

public class EmpresaAlojamiento implements VOEmpresaAlojamiento {

	/**
	 * Id del operador que ofrece alojamiento
	 */
	private long idOperador;

	/**
	 * Tipo de empresa de alojamiento
	 */
	private String tipoEmpresa;

	/**
	 * Hora de apertura del alojamiento
	 */
	private int horaApertura;

	/**
	 * Hora de cierre del alojamiento
	 */
	private int horaCierre;

	/**
	 * Constructor por defecto
	 */
	public EmpresaAlojamiento() {
		this.idOperador = 0;
		this.tipoEmpresa = "";
		this.horaApertura = 0;
		this.horaCierre = 0;
	}

	/**
	 * Constructor con valores
	 * @param idOperador - El id del operador que ofrece alojamiento
	 * @param tipoEmpresa - El tipo de empresa de alojamiento
	 * @param horaApertura - La hora de apertura del alojamiento
	 * @param horaCierre - La hora de cierre del alojamiento
	 */
	public EmpresaAlojamiento(long idOperador, String tipoEmpresa, int horaApertura, int horaCierre) {
		this.idOperador = idOperador;
		this.tipoEmpresa = tipoEmpresa;
		this.horaApertura = horaApertura;
		this.horaCierre = horaCierre;
	}

	/**
	 * @return El id del operador que ofrece alojamiento
	 */
	public long getIdOperador() {
		return idOperador;
	}

	/**
	 * @param idOperador - El nuevo id del operador que ofrece alojamiento
	 */
	public void setIdOperador(long idOperador) {
		this.idOperador = idOperador;
	}

	/**
	 * @return El tipo de empresa de alojamiento
	 */
	public String getTipoEmpresa() {
		return tipoEmpresa;
	}

	/**
	 * @param tipoEmpresa - El nuevo tipo de empresa de alojamiento
	 */
	public void setTipoEmpresa(String tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

	/**
	 * @return La hora de apertura del alojamiento
	 */
	public int getHoraApertura() {
		return horaApertura;
	}
	
	
	/**
	 * @param horaApertura - La nueva hora de apertura del alojamiento
	 */
	public void setHoraApertura(int horaApertura) {
		this.horaApertura = horaApertura;
	}

	/**
	 * @return La hora de cierre del alojamiento
	 */
	public int getHoraCierre() {
		return horaCierre;
	}

	/**
	 * @param horaCierre - La nueva hora de cierre del alojamiento
	 */
	public void setHoraCierre(int horaCierre) {
		this.horaCierre = horaCierre;
	}

	@Override
	/**
	 * @return Una cadena de caracteres con todos los atributos de la empresa de alojamiento
	 */
	public String toString() {
		return "EmpresaAlojamiento [idOperador=" + idOperador + ", tipoEmpresa=" + tipoEmpresa + ", horaApertura="
				+ horaApertura + ", horaCierre=" + horaCierre + "]";
	}
}