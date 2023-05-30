package uniandes.isis2304.alohandes.negocio;

/**
 * Interfaz para los métodos get de Inmueble.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author Alonso Hernandez @fai.aher
 */


public interface VOInmueble {
    /* ****************************************************************
     * 			Métodos
     *****************************************************************/
    /**
     * @return El id del inmueble
     */
    public long getIdInmueble();
    
    /**
     * @return El id del operador asociado
     */
    public long getOperadorAsociado();

    /**
     * @return La categoría del inmueble
     */
    public String getCategoria();

    /**
     * @return La capacidad del inmueble
     */
    public int getCapacidad();

    /**
     * @return La ubicación del inmueble
     */
    public String getUbicacion();

    /**
     * @return El menaje del inmueble
     */
    public String getMenaje();

    /**
     * @return El tamaño del inmueble en metros cuadrados
     */
    public double getTamanoEnMtSq();

    @Override
    /**
     * @return Una cadena de caracteres con todos los atributos del inmueble
     */
    public String toString();
}