package uniandes.isis2304.alohandes.negocio;

/**
 * Interfaz para los métodos get de OfertaAlojamiento.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author Alonso Hernandez @fai.aher
 */


public interface VOOfertaAlojamiento {
    /* ****************************************************************
     * 			Métodos
     *****************************************************************/
    /**
     * @return El id de la oferta de alojamiento
     */
    public long getIdOferta();

    /**
     * @return El precio base de la oferta de alojamiento
     */
    public int getPrecioBase();

    /**
     * @return El id del inmueble asociado a la oferta de alojamiento
     */
    public long getInmuebleAsociado();

    /**
     * @return Si la oferta de alojamiento está activa o no
     */
    public boolean isOfertaActiva();

    /**
     * @return Si la oferta de alojamiento está disponible o no
     */
    public boolean isOfertaDisponible();

    /**
     * @return La modalidad temporal de la oferta de alojamiento
     */
    public String getModalidadTemporal();

    @Override
    /**
     * @return Una cadena de caracteres con todos los atributos de la oferta de alojamiento
     */
    public String toString();
}