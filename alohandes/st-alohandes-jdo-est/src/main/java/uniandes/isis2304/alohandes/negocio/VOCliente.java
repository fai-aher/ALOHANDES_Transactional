package uniandes.isis2304.alohandes.negocio;

/**
 * Interfaz para los métodos get de Cliente.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author Alonso Hernandez @fai.aher
 */

public interface VOCliente {
    /* ****************************************************************
     * 			Métodos
     *****************************************************************/
    /**
     * @return El id del cliente
     */
    public long getIdCliente();

    /**
     * @return El vínculo del cliente con Uniandes
     */
    public String getVinculoConUniandes();
    
    /**
     * @return El usuario del cliente
     */
    public String getUsuario();
    
    /**
     * @return La clave del cliente
     */
    public String getClave();

    @Override
    /**
     * @return Una cadena de caracteres con todos los atributos del cliente
     */
    public String toString();
}
