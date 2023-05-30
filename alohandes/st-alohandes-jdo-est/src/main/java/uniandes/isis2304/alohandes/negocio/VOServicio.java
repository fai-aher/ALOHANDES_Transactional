package uniandes.isis2304.alohandes.negocio;

/**
 * Interfaz para los métodos get de Servicio.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author Alonso Hernandez @fai.aher
 */


public interface VOServicio {
    /* ****************************************************************
     * 			Métodos
     *****************************************************************/

    /**
     * @return El id del servicio
     */
    public long getIdServicio();

    /**
     * @return El nombre del servicio
     */
    public String getNombre();

    /**
     * @return La descripción del servicio
     */
    public String getDescripcion();

    /**
     * @return La hora de apertura del servicio
     */
    public int getHoraApertura();

    /**
     * @return La hora de cierre del servicio
     */
    public int getHoraCierre();

    /**
     * @return El costo adicional del servicio
     */
    public int getCostoAdicional();

    @Override
    /**
     * @return Una cadena de caracteres con todos los atributos del servicio
     */
    public String toString();
}