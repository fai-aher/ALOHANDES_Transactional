package uniandes.isis2304.alohandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.alohandes.negocio.Habitacion;

public class SQLHabitacion {

    private static final String SQL = PersistenciaAlohandes.SQL;

    private PersistenciaAlohandes pp;

    public SQLHabitacion(PersistenciaAlohandes pp) {
        this.pp = pp;
    }

    public long adicionarHabitacion(PersistenceManager pm, long idInmueble, String tipoHabitacion) {
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaHabitacion()
                + "(idInmueble, tipoHabitacion) values (?, ?)");
        q.setParameters(idInmueble, tipoHabitacion);
        return (long) q.executeUnique();
    }

    public long eliminarHabitacionPorId(PersistenceManager pm, long idInmueble) {
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHabitacion() + " WHERE idInmueble = ?");
        q.setParameters(idInmueble);
        return (long) q.executeUnique();
    }

    public Habitacion darHabitacionPorId(PersistenceManager pm, long idInmueble) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHabitacion() + " WHERE idInmueble = ?");
        q.setResultClass(Habitacion.class);
        q.setParameters(idInmueble);
        return (Habitacion) q.executeUnique();
    }

    public List<Habitacion> darHabitaciones(PersistenceManager pm) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHabitacion());
        q.setResultClass(Habitacion.class);
        return (List<Habitacion>) q.executeList();
    }

    public long cambiarTipoHabitacion(PersistenceManager pm, long idInmueble, String tipoHabitacion) {
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaHabitacion()
                + " SET tipoHabitacion = ? WHERE idInmueble = ?");
        q.setParameters(tipoHabitacion, idInmueble);
        return (long) q.executeUnique();
    }

}