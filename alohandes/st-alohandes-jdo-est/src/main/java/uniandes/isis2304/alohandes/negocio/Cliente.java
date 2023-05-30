package uniandes.isis2304.alohandes.negocio;

public class Cliente implements VOCliente {
    private long idCliente;
    private String vinculoConUniandes;
    private String usuario;
    private String clave;

    // Constructor por defecto
    public Cliente() {
        this.idCliente = 0;
        this.vinculoConUniandes = "";
        this.usuario = "";
        this.clave = "";
    }

    // Constructor con valores
    public Cliente(long idCliente, String vinculoConUniandes, String usuario, String clave) {
        this.idCliente = idCliente;
        this.vinculoConUniandes = vinculoConUniandes;
        this.usuario = usuario;
        this.clave = clave;
    }

    // Getters y setters

    // Getter y setter para idCliente
    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    // Getter y setter para vinculoConUniandes
    public String getVinculoConUniandes() {
        return vinculoConUniandes;
    }

    public void setVinculoConUniandes(String vinculoConUniandes) {
        this.vinculoConUniandes = vinculoConUniandes;
    }

    // Getter y setter para usuario
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    // Getter y setter para clave
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Cliente [idCliente=" + idCliente + ", vinculoConUniandes=" + vinculoConUniandes + ", usuario=" + usuario + ", clave=" + clave + "]";
    }
}