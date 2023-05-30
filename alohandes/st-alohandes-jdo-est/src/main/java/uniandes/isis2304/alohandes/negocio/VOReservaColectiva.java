package uniandes.isis2304.alohandes.negocio;

public interface VOReservaColectiva {
	  /* ****************************************************************
     * 			Métodos
     *****************************************************************/
    /**
     * @return El id de ReservaColectiva
     */
    public long getIdReservaColectiva();

    /**
     * @return El id de ReservaAsociada
     */
    public long getIdOfertaAsociada();
    
    @Override
    /**
     * @return Una cadena de caracteres con todos los atributos del cliente
     */
    public String toString();
}
