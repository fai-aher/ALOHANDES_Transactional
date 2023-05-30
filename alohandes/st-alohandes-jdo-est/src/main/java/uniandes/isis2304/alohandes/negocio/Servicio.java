package uniandes.isis2304.alohandes.negocio;

public class Servicio implements VOServicio {
    private long idServicio;
    private String nombre;
    private String descripcion;
    private int horaApertura;
    private int horaCierre;
    private int costoAdicional;

    // Constructor por defecto
    public Servicio() {
        this.idServicio = 0;
        this.nombre = "";
        this.descripcion = "";
        this.horaApertura = 0;
        this.horaCierre = 0;
        this.costoAdicional = 0;
    }

    // Constructor con valores
    public Servicio(long idServicio, String nombre, String descripcion, int horaApertura, int horaCierre, int costoAdicional) {
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.costoAdicional = costoAdicional;
    }

    // Getters y setters
    
    // Getter y setter para nombre

    public long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(long idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y setter para descripcion
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Getter y setter para horaApertura
    public int getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(int horaApertura) {
        this.horaApertura = horaApertura;
    }

    // Getter y setter para horaCierre
    public int getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(int horaCierre) {
        this.horaCierre = horaCierre;
    }

    // Getter y setter para costoAdicional
    public int getCostoAdicional() {
        return costoAdicional;
    }

    public void setCostoAdicional(int costoAdicional) {
        this.costoAdicional = costoAdicional;
    }
    
    
    @Override
    public String toString() {
        return "Servicio [id=" + idServicio +", nombre=" + nombre + ", descripcion=" + descripcion
                + ", horaApertura=" + horaApertura + ", horaCierre=" + horaCierre + ", costoAdicional=" + costoAdicional + "]";
    }
}