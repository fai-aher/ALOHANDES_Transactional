package uniandes.isis2304.alohandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.alohandes.negocio.OfertaAlojamiento;

public class SQLOfertaAlojamiento {
    private static final String SQL = PersistenciaAlohandes.SQL;

    private PersistenciaAlohandes pp;

    public SQLOfertaAlojamiento(PersistenciaAlohandes pp) {
        this.pp = pp;
    }

    public long adicionarOfertaAlojamiento(PersistenceManager pm, long idOferta, long precioBase, long inmuebleAsociado, boolean ofertaActiva, boolean ofertaDisponible, String modalidadTemporal) {
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaOfertaAlojamiento() + "(id, precioBase, inmuebleAsociado, ofertaActiva, ofertaDisponible, modalidadTemporal) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(idOferta, precioBase, inmuebleAsociado, ofertaActiva, ofertaDisponible, modalidadTemporal);
        return (long) q.executeUnique();
    }

    public long eliminarOfertaAlojamientoPorId(PersistenceManager pm, long idOferta) {
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOfertaAlojamiento() + " WHERE id = ?");
        q.setParameters(idOferta);
        return (long) q.executeUnique();
    }

    public OfertaAlojamiento darOfertaAlojamientoPorId(PersistenceManager pm, long idOferta) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOfertaAlojamiento() + " WHERE id = ?");
        q.setResultClass(OfertaAlojamiento.class);
        q.setParameters(idOferta);
        return (OfertaAlojamiento) q.executeUnique();
    }

    public List<OfertaAlojamiento> darOfertasAlojamiento(PersistenceManager pm) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOfertaAlojamiento());
        q.setResultClass(OfertaAlojamiento.class);
        return (List<OfertaAlojamiento>) q.executeList();
    }

    public long cambiarPrecioBaseOferta(PersistenceManager pm, long idOferta, long nuevoPrecioBase) {
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaOfertaAlojamiento() + " SET precioBase = ? WHERE id = ?");
        q.setParameters(nuevoPrecioBase, idOferta);
        return (long) q.executeUnique();
    }

    public long cambiarEstadoOferta(PersistenceManager pm, long idOferta, boolean ofertaActiva) {
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaOfertaAlojamiento() + " SET ofertaActiva = ? WHERE id = ?");
        q.setParameters(ofertaActiva, idOferta);
        return (long) q.executeUnique();
    }

    public long cambiarDisponibilidadOferta(PersistenceManager pm, long idOferta, int i) {
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaOfertaAlojamiento() + " SET ofertaDisponible = ? WHERE idoferta = ?");
        q.setParameters(i, idOferta);
        return (long) q.executeUnique();
    }

    public long cambiarModalidadTemporalOferta(PersistenceManager pm, long idOferta, String nuevaModalidadTemporal) {
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaOfertaAlojamiento() + " SET modalidadTemporal = ? WHERE id = ?");
        q.setParameters(nuevaModalidadTemporal, idOferta);
        return (long) q.executeUnique();
    }

    public List<OfertaAlojamiento> darOfertasAlojamientoPorModalidadTemporal(PersistenceManager pm, String modalidadTemporal) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOfertaAlojamiento() + " WHERE modalidadTemporal = ?");
        q.setResultClass(OfertaAlojamiento.class);
        q.setParameters(modalidadTemporal);
        return (List<OfertaAlojamiento>) q.executeList();
    }

    public List<OfertaAlojamiento> darOfertasAlojamientoActivas(PersistenceManager pm) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOfertaAlojamiento() + " WHERE ofertaActiva = ?");
        q.setResultClass(OfertaAlojamiento.class);
        q.setParameters(true);
        return (List<OfertaAlojamiento>) q.executeList();
    }

    public List<OfertaAlojamiento> darOfertasAlojamientoDisponibles(PersistenceManager pm) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOfertaAlojamiento() + " WHERE ofertaDisponible = ?");
        q.setResultClass(OfertaAlojamiento.class);
        q.setParameters(true);
        return (List<OfertaAlojamiento>) q.executeList();
    }
}
