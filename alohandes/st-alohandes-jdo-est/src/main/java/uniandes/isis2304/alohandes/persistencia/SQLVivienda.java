package uniandes.isis2304.alohandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.alohandes.negocio.Vivienda;

public class SQLVivienda {

    private static final String SQL = PersistenciaAlohandes.SQL;

    private PersistenciaAlohandes pp;

    public SQLVivienda(PersistenciaAlohandes pp) {
        this.pp = pp;
    }

    public long adicionarVivienda(PersistenceManager pm, long idInmueble, String tipoVivienda, int numeroHabitaciones) {
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaVivienda()
                + "(idInmueble, tipoVivienda, numeroHabitaciones) values (?, ?, ?)");
        q.setParameters(idInmueble, tipoVivienda, numeroHabitaciones);
        return (long) q.executeUnique();
    }

    public long eliminarViviendaPorId(PersistenceManager pm, long idInmueble) {
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaVivienda() + " WHERE idInmueble = ?");
        q.setParameters(idInmueble);
        return (long) q.executeUnique();
    }

    public Vivienda darViviendaPorId(PersistenceManager pm, long idInmueble) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaVivienda() + " WHERE idInmueble = ?");
        q.setResultClass(Vivienda.class);
        q.setParameters(idInmueble);
        return (Vivienda) q.executeUnique();
    }

    public List<Vivienda> darViviendas(PersistenceManager pm) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaVivienda());
        q.setResultClass(Vivienda.class);
        return (List<Vivienda>) q.executeList();
    }

    public long cambiarTipoVivienda(PersistenceManager pm, long idInmueble, String tipoVivienda) {
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaVivienda()
                + " SET tipoVivienda = ? WHERE idInmueble = ?");
        q.setParameters(tipoVivienda, idInmueble);
        return (long) q.executeUnique();
    }

    public long cambiarNumeroHabitaciones(PersistenceManager pm, long idInmueble, int numeroHabitaciones) {
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaVivienda()
                + " SET numeroHabitaciones = ? WHERE idInmueble = ?");
        q.setParameters(numeroHabitaciones, idInmueble);
        return (long) q.executeUnique();
    }

}