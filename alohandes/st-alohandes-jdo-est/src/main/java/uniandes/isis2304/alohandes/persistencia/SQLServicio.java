package uniandes.isis2304.alohandes.persistencia;

import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.alohandes.negocio.Servicio;

public class SQLServicio {

    private static final String SQL = PersistenciaAlohandes.SQL;
    private PersistenciaAlohandes pp;

    public SQLServicio(PersistenciaAlohandes pp) {
        this.pp = pp;
    }

    public long adicionarServicio(PersistenceManager pm, long idServicio, String nombre, String descripcion, int horaApertura, int horaCierre, long costoAdicional) {
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaServicio() + "(id, nombre, descripcion, horaApertura, horaCierre, costoAdicional) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(idServicio, nombre, descripcion, horaApertura, horaCierre, costoAdicional);
        return (long) q.executeUnique();
    }

    public long eliminarServicioPorId(PersistenceManager pm, long idServicio) {
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio() + " WHERE id = ?");
        q.setParameters(idServicio);
        return (long) q.executeUnique();
    }

    public Servicio darServicioPorId(PersistenceManager pm, long idServicio) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio() + " WHERE id = ?");
        q.setResultClass(Servicio.class);
        q.setParameters(idServicio);
        return (Servicio) q.executeUnique();
    }

    public List<Servicio> darServicios(PersistenceManager pm) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio());
        q.setResultClass(Servicio.class);
        return (List<Servicio>) q.executeList();
    }

    public long cambiarNombreServicio(PersistenceManager pm, long idServicio, String nuevoNombre) {
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaServicio() + " SET nombre = ? WHERE id = ?");
        q.setParameters(nuevoNombre, idServicio);
        return (long) q.executeUnique();
    }

    public long cambiarDescripcionServicio(PersistenceManager pm, long idServicio, String nuevaDescripcion) {
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaServicio() + " SET descripcion = ? WHERE id = ?");
        q.setParameters(nuevaDescripcion, idServicio);
        return (long) q.executeUnique();
    }

    public long cambiarHoraAperturaServicio(PersistenceManager pm, long idServicio, int nuevaHoraApertura) {
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaServicio() + " SET horaApertura = ? WHERE id = ?");
        q.setParameters(nuevaHoraApertura, idServicio);
        return (long) q.executeUnique();
    }

    public long cambiarHoraCierreServicio(PersistenceManager pm, long idServicio, int nuevaHoraCierre) {
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaServicio() + " SET horaCierre = ? WHERE id = ?");
        q.setParameters(nuevaHoraCierre, idServicio);
        return (long) q.executeUnique();
    }

	public long cambiarCostoAdicionalServicio(PersistenceManager pm, long idServicio, long nuevoCostoAdicional) {
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaServicio() + " SET costoAdicional = ? WHERE id = ?");
        q.setParameters(nuevoCostoAdicional, idServicio);
        return (long) q.executeUnique();
    }

    public List<Servicio> darServiciosPorNombre(PersistenceManager pm, String nombre) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio() + " WHERE nombre = ?");
        q.setResultClass(Servicio.class);
        q.setParameters(nombre);
        return (List<Servicio>) q.executeList();
    }

    public List<Servicio> darServiciosPorRangoHorario(PersistenceManager pm, int horaApertura, int horaCierre) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio() + " WHERE horaApertura >= ? AND horaCierre <= ?");
        q.setResultClass(Servicio.class);
        q.setParameters(horaApertura, horaCierre);
        return (List<Servicio>) q.executeList();
    }

    public List<Servicio> darServiciosPorCostoAdicional(PersistenceManager pm, long costoAdicional) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio() + " WHERE costoAdicional = ?");
        q.setResultClass(Servicio.class);
        q.setParameters(costoAdicional);
        return (List<Servicio>) q.executeList();
    }

	public List<Servicio> darServiciosPorOfertaAlojamiento(PersistenceManager pm, long idOfertaAlojamiento) {
        String sql = "SELECT s.*";
        sql += " FROM ";
        sql += pp.darTablaServicio() + " s, ";
        sql += pp.darTablaServiciosPorOferta() + " spo ";
        sql += " WHERE ";
        sql += "spo.idOfertaAlojamiento = ?";
        sql += " AND spo.idServicioOfrecido = s.id";
        Query q = pm.newQuery(SQL, sql);
        q.setResultClass(Servicio.class);
        q.setParameters(idOfertaAlojamiento);
        return (List<Servicio>) q.executeList();
    }

}