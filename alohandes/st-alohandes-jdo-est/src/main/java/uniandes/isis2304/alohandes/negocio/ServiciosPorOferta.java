package uniandes.isis2304.alohandes.negocio;

public class ServiciosPorOferta implements VOServiciosPorOferta {
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El id de la oferta de alojamiento asociada
	 */
	private long idOfertaAlojamiento;
	
	/**
	 * El id del servicio ofrecido en la oferta
	 */
	private long idServicioOfrecido;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	
	/**
	 * Constructor por defecto
	 */
	public ServiciosPorOferta() {
		this.idOfertaAlojamiento = 0;
		this.idServicioOfrecido = 0;
	}

	/**
	 * Constructor con valores
	 * @param idOfertaAlojamiento - El id de la oferta de alojamiento asociada
	 * @param idServicioOfrecido - El id del servicio ofrecido en la oferta
	 */
	public ServiciosPorOferta(long idOfertaAlojamiento, long idServicioOfrecido) {
		this.idOfertaAlojamiento = idOfertaAlojamiento;
		this.idServicioOfrecido = idServicioOfrecido;
	}

	/**
	 * @return El id de la oferta de alojamiento asociada
	 */
	public long getIdOfertaAlojamiento() {
		return idOfertaAlojamiento;
	}

	/**
	 * @param idOfertaAlojamiento - El nuevo id de la oferta de alojamiento asociada
	 */
	public void setIdOfertaAlojamiento(long idOfertaAlojamiento) {
		this.idOfertaAlojamiento = idOfertaAlojamiento;
	}

	/**
	 * @return El id del servicio ofrecido en la oferta
	 */
	public long getIdServicioOfrecido() {
		return idServicioOfrecido;
	}

	/**
	 * @param idServicioOfrecido - El nuevo id del servicio ofrecido en la oferta
	 */
	public void setIdServicioOfrecido(long idServicioOfrecido) {
		this.idServicioOfrecido = idServicioOfrecido;
	}

	@Override
	/**
	 * @return Una cadena de caracteres con todos los atributos de la relación entre oferta de alojamiento y servicio ofrecido
	 */
	public String toString() {
		return "ServiciosPorOferta [idOfertaAlojamiento=" + idOfertaAlojamiento + ", idServicioOfrecido=" + idServicioOfrecido + "]";
	}
}