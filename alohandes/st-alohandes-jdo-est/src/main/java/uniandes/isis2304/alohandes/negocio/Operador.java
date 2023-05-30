package uniandes.isis2304.alohandes.negocio;

public class Operador implements VOOperador {
	
    private long idOperador;
    private String relacionConUniandes;
    private String usuario;
    private String clave;

    // Constructor por defecto
    public Operador() {
        this.idOperador = 0;
        this.relacionConUniandes = "";
        this.usuario = "";
        this.clave = "";
    }

    // Constructor con valores
    public Operador(long idOperador, String relacionConUniandes, String usuario, String clave) {
        this.idOperador = idOperador;
        this.relacionConUniandes = relacionConUniandes;
        this.usuario = usuario;
        this.clave = clave;
    }

    // Getter y setter para idOperador
    public long getIdOperador() {
        return idOperador;
    }

    public void setIdOperador(long idOperador) {
        this.idOperador = idOperador;
    }

    // Getter y setter para relacionConUniandes
    public String getRelacionConUniandes() {
        return relacionConUniandes;
    }

    public void setRelacionConUniandes(String relacionConUniandes) {
        this.relacionConUniandes = relacionConUniandes;
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
        return "Operador [idOperador=" + idOperador + ", relacionConUniandes=" + relacionConUniandes + "]";
    }
}

