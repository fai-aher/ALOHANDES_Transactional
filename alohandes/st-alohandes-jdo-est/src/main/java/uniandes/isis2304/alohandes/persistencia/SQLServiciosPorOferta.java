package uniandes.isis2304.alohandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.alohandes.negocio.ServiciosPorOferta;

public class SQLServiciosPorOferta
{
    private static final String SQL = PersistenciaAlohandes.SQL;

    private PersistenciaAlohandes pp;

    public SQLServiciosPorOferta(PersistenciaAlohandes pp)
    {
        this.pp = pp;
    }

    public long adicionarServicioPorOferta(PersistenceManager pm, long idOfertaAlojamiento, long idServicioOfrecido)
    {
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaServiciosPorOferta() + "(idofertaalojamiento, idservicioofrecido) values (?, ?)");
        q.setParameters(idOfertaAlojamiento, idServicioOfrecido);
        return (long) q.executeUnique();
    }

    public long eliminarServicioPorOferta(PersistenceManager pm, long idOfertaAlojamiento, long idServicioOfrecido)
    {
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServiciosPorOferta() + " WHERE idofertaalojamiento = ? AND idservicioofrecido = ?");
        q.setParameters(idOfertaAlojamiento, idServicioOfrecido);
        return (long) q.executeUnique();
    }

    public List<ServiciosPorOferta> darServiciosPorOferta(PersistenceManager pm)
    {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServiciosPorOferta());
        q.setResultClass(ServiciosPorOferta.class);
        return (List<ServiciosPorOferta>) q.executeList();
    }

    public List<ServiciosPorOferta> darServiciosPorIdOfertaAlojamiento(PersistenceManager pm, long idOfertaAlojamiento)
    {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServiciosPorOferta() + " WHERE idofertaalojamiento = ?");
        q.setResultClass(ServiciosPorOferta.class);
        q.setParameters(idOfertaAlojamiento);
        return (List<ServiciosPorOferta>) q.executeList();
    }

    public List<ServiciosPorOferta> darServiciosPorIdServicioOfrecido(PersistenceManager pm, long idServicioOfrecido)
    {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServiciosPorOferta() + " WHERE idservicioofrecido = ?");
        q.setResultClass(ServiciosPorOferta.class);
        q.setParameters(idServicioOfrecido);
        return (List<ServiciosPorOferta>) q.executeList();
    }
}