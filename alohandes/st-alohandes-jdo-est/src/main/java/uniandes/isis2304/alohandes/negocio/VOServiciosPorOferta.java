package uniandes.isis2304.alohandes.negocio;

public interface VOServiciosPorOferta {

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * @return El id de la oferta de alojamiento asociada
	 */
	public long getIdOfertaAlojamiento();

	/**
	 * @return El id del servicio ofrecido en la oferta
	 */
	public long getIdServicioOfrecido();
	
	@Override
	/**
	 * @return Una cadena de caracteres con todos los atributos de la relación entre oferta de alojamiento y servicio ofrecido
	 */
	public String toString();
}
