package uniandes.isis2304.alohandes.negocio;

import java.sql.Date;

/**
 * Interfaz para los métodos get de Reserva.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author Alonso Hernandez @fai.aher
 */

public interface VOReserva {
    /* ****************************************************************
     * 			Métodos
     *****************************************************************/
    /**
     * @return El id del cliente asociado a la reserva
     */
    public long getIdClienteAsociado();

    /**
     * @return El id de la oferta asociada a la reserva
     */
    public long getIdOfertaAsociada();

    /**
     * @return La fecha de la reserva
     */
    public Date getFechaReserva();

    /**
     * @return La fecha inicial de la reserva
     */
    public Date getFechaInicialReserva();

    /**
     * @return La fecha final de la reserva
     */
    public Date getFechaFinalReserva();

    /**
     * @return Las promociones activas para la reserva
     */
    public String getPromocionesActivas();

    /**
     * @return La fecha de cancelación de la reserva
     */
    public Date getFechaCancelacion();

    @Override
    /**
     * @return Una cadena de caracteres con todos los atributos de la reserva
     */
    public String toString();
}