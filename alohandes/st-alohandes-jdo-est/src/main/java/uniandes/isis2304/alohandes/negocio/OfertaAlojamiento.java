package uniandes.isis2304.alohandes.negocio;

public class OfertaAlojamiento implements VOOfertaAlojamiento {
    private long idOferta;
    private int precioBase;
    private long inmuebleAsociado;
    private boolean ofertaActiva;
    private boolean ofertaDisponible;
    private String modalidadTemporal;

    // Constructor por defecto
    public OfertaAlojamiento() {
        this.idOferta = 0;
        this.precioBase = 0;
        this.inmuebleAsociado = 0;
        this.ofertaActiva = false;
        this.ofertaDisponible = false;
        this.modalidadTemporal = "";
    }

    // Constructor con valores
    public OfertaAlojamiento(long idOferta, int precioBase, long inmuebleAsociado, boolean ofertaActiva, boolean ofertaDisponible, String modalidadTemporal) {
        this.idOferta = idOferta;
        this.precioBase = precioBase;
        this.inmuebleAsociado = inmuebleAsociado;
        this.ofertaActiva = ofertaActiva;
        this.ofertaDisponible = ofertaDisponible;
        this.modalidadTemporal = modalidadTemporal;
    }

    // Getters y setters

    // Getter y setter para idOferta
    public long getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(long idOferta) {
        this.idOferta = idOferta;
    }

    // Getter y setter para precioBase
    public int getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(int precioBase) {
        this.precioBase = precioBase;
    }

    // Getter y setter para inmuebleAsociado
    public long getInmuebleAsociado() {
        return inmuebleAsociado;
    }

    public void setInmuebleAsociado(long inmuebleAsociado) {
        this.inmuebleAsociado = inmuebleAsociado;
    }

    // Getter y setter para ofertaActiva
    public boolean isOfertaActiva() {
        return ofertaActiva;
    }

    public void setOfertaActiva(boolean ofertaActiva) {
        this.ofertaActiva = ofertaActiva;
    }

    // Getter y setter para ofertaDisponible
    public boolean isOfertaDisponible() {
        return ofertaDisponible;
    }

    public void setOfertaDisponible(boolean ofertaDisponible) {
        this.ofertaDisponible = ofertaDisponible;
    }

    // Getter y setter para modalidadTemporal
    public String getModalidadTemporal() {
        return modalidadTemporal;
    }

    public void setModalidadTemporal(String modalidadTemporal) {
        this.modalidadTemporal = modalidadTemporal;
    }

    @Override
    public String toString() {
        return "OfertaAlojamiento [idOferta=" + idOferta + ", precioBase=" + precioBase + ", inmuebleAsociado=" + inmuebleAsociado
                + ", ofertaActiva=" + ofertaActiva + ", ofertaDisponible=" + ofertaDisponible + ", modalidadTemporal=" + modalidadTemporal + "]";
    }
}