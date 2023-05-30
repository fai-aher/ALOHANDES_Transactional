package uniandes.isis2304.alohandes.negocio;

public class ReservaColectiva implements VOReservaColectiva {
	 	private long idReservaColectiva;
	    private long idOfertaAsociada;
	    // Constructor por defecto
	    public ReservaColectiva() {
	        this.idReservaColectiva = 0;
	    }

	    // Constructor con valores
	    public ReservaColectiva(long idReservaColectiva, long idOfertaAsociada) {
	    	this.idReservaColectiva = idReservaColectiva;
	    }

	    // Getters y setters

	    // Getter y setter para idReservaColectiva
	    public long getIdReservaColectiva() {
	        return idReservaColectiva;
	    }

	    public void setIdReservaColectiva(long idReservaColectiva) {
	        this.idReservaColectiva = idReservaColectiva;
	    }

	    // Getter y setter para ReservaAsociada
	    public long getIdOfertaAsociada() {
	        return idOfertaAsociada;
	    }

	    public void setIdOfertaAsociada(long idOfertaAsociada) {
	        this.idOfertaAsociada = idOfertaAsociada;
	    }

	    @Override
	    public String toString() {
	        return "ReservaColectiva [idReservaColectiva=" + idReservaColectiva + ", idOfertaAsociada=" + idOfertaAsociada + "]";
	    }
}
