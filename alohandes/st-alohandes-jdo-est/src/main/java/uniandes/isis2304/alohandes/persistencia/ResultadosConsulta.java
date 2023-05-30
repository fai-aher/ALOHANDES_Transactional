package uniandes.isis2304.alohandes.persistencia;

import java.util.ArrayList;
import java.util.List;

public class ResultadosConsulta {
    private List<Object[]> ofertasMaxOcupacion;
    private List<Object[]> ofertasMinOcupacion;
    private List<List<Object[]>> operadoresMasSolicitados;
    private List<List<Object[]>> operadoresMenosSolicitados;

    public ResultadosConsulta() {
        ofertasMaxOcupacion = new ArrayList<>();
        ofertasMinOcupacion = new ArrayList<>();
        operadoresMasSolicitados = new ArrayList<>();
        operadoresMenosSolicitados = new ArrayList<>();
    }

    public void addOfertaMaxOcupacion(Object[] oferta) {
        if (ofertasMaxOcupacion == null) {
            ofertasMaxOcupacion = new ArrayList<>();
        }
        ofertasMaxOcupacion.add(oferta);
    }


    public void addOfertaMinOcupacion(Object[] oferta) {
        ofertasMinOcupacion.add(oferta);
    }

    public void addOperadoresMasSolicitados(List<Object[]> operadores) {
        operadoresMasSolicitados.add(operadores);
    }

    public void addOperadoresMenosSolicitados(List<Object[]> operadores) {
        operadoresMenosSolicitados.add(operadores);
    }

    // Getters y setters

    public List<Object[]> getOfertasMaxOcupacion() {
        return ofertasMaxOcupacion;
    }

    public void setOfertasMaxOcupacion(List<Object[]> ofertasMaxOcupacion) {
        this.ofertasMaxOcupacion = ofertasMaxOcupacion;
    }

    public List<Object[]> getOfertasMinOcupacion() {
        return ofertasMinOcupacion;
    }

    public void setOfertasMinOcupacion(List<Object[]> ofertasMinOcupacion) {
        this.ofertasMinOcupacion = ofertasMinOcupacion;
    }

    public List<List<Object[]>> getOperadoresMasSolicitados() {
        return operadoresMasSolicitados;
    }

    public void setOperadoresMasSolicitados(List<List<Object[]>> operadoresMasSolicitados) {
        this.operadoresMasSolicitados = operadoresMasSolicitados;
    }

    public List<List<Object[]>> getOperadoresMenosSolicitados() {
        return operadoresMenosSolicitados;
    }

    public void setOperadoresMenosSolicitados(List<List<Object[]>> operadoresMenosSolicitados) {
        this.operadoresMenosSolicitados = operadoresMenosSolicitados;
    }
}
