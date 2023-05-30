package uniandes.isis2304.alohandes.negocio;
import java.sql.Date;

public class Reserva implements VOReserva {
    private long idClienteAsociado;
    private long idOfertaAsociada;
    private Date fechaReserva;
    private Date fechaInicialReserva;
    private Date fechaFinalReserva;
    private String promocionesActivas;
    private Date fechaCancelacion;

    // Constructor por defecto
    public Reserva() {
        this.idClienteAsociado = 0;
        this.idOfertaAsociada = 0;
        this.fechaReserva = null;
        this.fechaInicialReserva = null;
        this.fechaFinalReserva = null;
        this.promocionesActivas = "";
        this.fechaCancelacion = null;
    }

    // Constructor con valores
    public Reserva(long idClienteAsociado, long idOfertaAsociada, Date fechaReserva, Date fechaInicialReserva, Date fechaFinalReserva, String promocionesActivas, Date fechaCancelacion) {
        this.idClienteAsociado = idClienteAsociado;
        this.idOfertaAsociada = idOfertaAsociada;
        this.fechaReserva = fechaReserva;
        this.fechaInicialReserva = fechaInicialReserva;
        this.fechaFinalReserva = fechaFinalReserva;
        this.promocionesActivas = promocionesActivas;
        this.fechaCancelacion = fechaCancelacion;
    }

    // Getters y setters

    // Getter y setter para idClienteAsociado
    public long getIdClienteAsociado() {
        return idClienteAsociado;
    }

    public void setIdClienteAsociado(long idClienteAsociado) {
        this.idClienteAsociado = idClienteAsociado;
    }

    // Getter y setter para idOfertaAsociada
    public long getIdOfertaAsociada() {
        return idOfertaAsociada;
    }

    public void setIdOfertaAsociada(long idOfertaAsociada) {
        this.idOfertaAsociada = idOfertaAsociada;
    }

    // Getter y setter para fechaReserva
    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    // Getter y setter para fechaInicialReserva
    public Date getFechaInicialReserva() {
        return fechaInicialReserva;
    }

    public void setFechaInicialReserva(Date fechaInicialReserva) {
        this.fechaInicialReserva = fechaInicialReserva;
    }

    // Getter y setter para fechaFinalReserva
    public Date getFechaFinalReserva() {
        return fechaFinalReserva;
    }

    public void setFechaFinalReserva(Date fechaFinalReserva) {
        this.fechaFinalReserva = fechaFinalReserva;
    }

    // Getter y setter para promocionesActivas
    public String getPromocionesActivas() {
        return promocionesActivas;
    }

    public void setPromocionesActivas(String promocionesActivas) {
        this.promocionesActivas = promocionesActivas;
    }

    // Getter y setter para fechaCancelacion
    public Date getFechaCancelacion() {
        return fechaCancelacion;
    }
    
    /**
     * Setter para fechaCancelacion
     * @param fechaCancelacion - La nueva fecha de cancelación de la reserva
     */
    public void setFechaCancelacion(Date fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    @Override
    /**
     * @return Una cadena de caracteres con todos los atributos de la reserva
     */
    public String toString() {
        return "Reserva [idClienteAsociado=" + idClienteAsociado + ", idOfertaAsociada=" + idOfertaAsociada
                + ", fechaReserva=" + fechaReserva + ", fechaInicialReserva=" + fechaInicialReserva
                + ", fechaFinalReserva=" + fechaFinalReserva + ", promocionesActivas=" + promocionesActivas
                + ", fechaCancelacion=" + fechaCancelacion + "]";
    }
    
}