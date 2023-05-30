package uniandes.isis2304.alohandes.negocio;

public class Inmueble implements VOInmueble {
    private long idInmueble;
    private long operadorAsociado;
    private String categoria;
    private int capacidad;
    private String ubicacion;
    private String menaje;
    private double tamanoEnMtSq;

    // Constructor por defecto
    public Inmueble() {
        this.idInmueble = 0;
        this.operadorAsociado = 0;
        this.categoria = "";
        this.capacidad = 0;
        this.ubicacion = "";
        this.menaje = "";
        this.tamanoEnMtSq = 0;
    }

    // Constructor con valores
    public Inmueble(long idInmueble, long operadorAsociado, String categoria, int capacidad, String ubicacion, String menaje, double tamanoEnMtSq) {
        this.idInmueble = idInmueble;
        this.operadorAsociado = operadorAsociado;
        this.categoria = categoria;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
        this.menaje = menaje;
        this.tamanoEnMtSq = tamanoEnMtSq;
    }

    // Getters y setters
    
    // Getter y setter para idInmueble
    public long getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(long idInmueble) {
        this.idInmueble = idInmueble;
    }
    
    //Getter y setter para operadorAsociado
    
    public long getOperadorAsociado() {
        return operadorAsociado;
    }

    public void setOperadorAsociado(long operadorAsociado) {
        this.operadorAsociado= operadorAsociado;
    }

    // Getter y setter para categoria
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // Getter y setter para capacidad
    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    // Getter y setter para ubicacion
    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    // Getter y setter para menaje
    public String getMenaje() {
        return menaje;
    }

    public void setMenaje(String menaje) {
        this.menaje = menaje;
    }

    // Getter y setter para tamanoEnMtSq
    public double getTamanoEnMtSq() {
        return tamanoEnMtSq;
    }

    public void setTamanoEnMtSq(double tamanoEnMtSq) {
        this.tamanoEnMtSq = tamanoEnMtSq;
    }
    

    //toString method
    
    @Override
    public String toString() {
        return "Inmueble [idInmueble=" + idInmueble + ", operadorAsociado=" + operadorAsociado + ", categoria=" + categoria + ", capacidad=" + capacidad
                + ", ubicacion=" + ubicacion + ", menaje=" + menaje + ", tamanoEnMtSq=" + tamanoEnMtSq + "]";
    }
}