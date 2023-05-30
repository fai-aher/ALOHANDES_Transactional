package uniandes.isis2304.alohandes.negocio;

/**
 * Interfaz para los métodos get de Operador.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author Alonso Hernandez @fai.aher
 */

public interface VOOperador {
    /* ****************************************************************
     * 			Métodos
     *****************************************************************/
    /**
     * @return El id del operador
     */
    public long getIdOperador();

    /**
     * @return la relación con Uniandes del operador
     */
    public String getRelacionConUniandes();
    
    /**
     * @return el usuario del Operador
     */
    public String getUsuario();
    
    /**
     * @return la clave del Operador
     */
    public String getClave();

    @Override
    /**
     * @return Una cadena de caracteres con todos los atributos del operador
     */
    public String toString();
    
}