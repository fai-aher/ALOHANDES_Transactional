package uniandes.isis2304.alohandes.persistencia;

import java.sql.Date;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.alohandes.negocio.*;

public class SQLReserva {
    private static final String SQL = PersistenciaAlohandes.SQL;
    private PersistenciaAlohandes pp;

    public SQLReserva(PersistenciaAlohandes pp) {
        this.pp = pp;
    }

    public long adicionarReserva(PersistenceManager pm, long idClienteAsociado, long idOfertaAsociada, Date fechaReserva, Date fechaInicialReserva, Date fechaFinalReserva, String promocionesActivas, Date fechaCancelacion) {
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaReserva() + "(idclienteasociado, idofertaasociada, fechareserva, fechainicialreserva, fechafinalreserva, promocionesactivas, fechacancelacion) values (?, ?, ?, ?, ?, ?, ?)");
        q.setParameters(idClienteAsociado, idOfertaAsociada, fechaReserva, fechaInicialReserva, fechaFinalReserva, promocionesActivas, fechaCancelacion);
        return (long) q.executeUnique();
    }

    public long eliminarReserva(PersistenceManager pm, long idClienteAsociado, long idOfertaAsociada, Date fechaReserva) {
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReserva() + " WHERE idclienteasociado = ? AND idofertaasociada = ? AND fechareserva = ?");
        q.setParameters(idClienteAsociado, idOfertaAsociada, fechaReserva);
        return (long) q.executeUnique();
    }

    public long eliminarReservasPorIdOfertaAsociada(PersistenceManager pm,long idOfertaAsociada) {
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReserva() + " WHERE  idofertaasociada = ? ");
        q.setParameters( idOfertaAsociada);
        return (long) q.executeUnique();
    }
    
    
    public Reserva darReservaPorId(PersistenceManager pm, long idClienteAsociado, long idOfertaAsociada, Date fechaReserva) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReserva() + " WHERE idclienteasociado = ? AND idofertaasociada = ? AND fechareserva = ?");
        q.setResultClass(Reserva.class);
        q.setParameters(idClienteAsociado, idOfertaAsociada, fechaReserva);
        return (Reserva) q.executeUnique();
    }

    public List<VOReserva> darReservas(PersistenceManager pm) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReserva());
        q.setResultClass(Reserva.class);
        return (List<VOReserva>) q.executeList();
    }

    public long actualizarFechaCancelacion(PersistenceManager pm, long idClienteAsociado, long idOfertaAsociada, Date fechaReserva, Date fechaCancelacion) {
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaReserva() + " SET fechacancelacion = ? WHERE idclienteasociado = ? AND idofertaasociada = ? AND fechareserva = ?");
        q.setParameters(fechaCancelacion, idClienteAsociado, idOfertaAsociada, fechaReserva);
        return (long) q.executeUnique();
    }

    public List<Reserva> darReservasPorCliente(PersistenceManager pm, long idCliente) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReserva() + " WHERE idclienteasociado = ?");
        q.setResultClass(Reserva.class);
        q.setParameters(idCliente);
        return (List<Reserva>) q.executeList();
    }

    public List<Reserva> darReservasPorOferta(PersistenceManager pm, long idOferta) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReserva() + " WHERE idofertaasociada = ?");
        q.setResultClass(Reserva.class);
        q.setParameters(idOferta);
        return (List<Reserva>) q.executeList();
    }

    public List<Object[]> darClientesYOfertasConReserva(PersistenceManager pm) {
        String sql = "SELECT c.id, c.vinculoconuniandes, o.id, o.preciobase, o.inmuebleasociado, o.modalidadtemporal";
        sql += " FROM ";
        sql += pp.darTablaCliente() + " c, ";
        sql += pp.darTablaOfertaAlojamiento() + " o, ";
        sql += pp.darTablaReserva() + " r ";
        sql += " WHERE ";
        sql += "c.id = r.idclienteasociado";
        sql += " AND o.id = r.idofertaasociada";
        Query q = pm.newQuery(SQL, sql);
        return q.executeList();
    }

    public List<Reserva> darReservasEntreFechas(PersistenceManager pm, Date fechaInicio, Date fechaFin) {
        String sql = "SELECT * FROM " + pp.darTablaReserva();
        sql += " WHERE fechainicialreserva >= ? AND fechafinalreserva <= ?";
        Query q = pm.newQuery(SQL, sql);
        q.setParameters(fechaInicio, fechaFin);
        return q.executeList();
    }
}