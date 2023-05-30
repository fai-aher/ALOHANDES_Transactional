package uniandes.isis2304.alohandes.persistencia;

import java.sql.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.alohandes.negocio.Cliente;
import uniandes.isis2304.alohandes.negocio.OfertaAlojamiento;
import uniandes.isis2304.alohandes.negocio.Reserva;
import uniandes.isis2304.alohandes.negocio.VOCliente;

public class SQLCliente {

    private static final String SQL = PersistenciaAlohandes.SQL;

    private PersistenciaAlohandes pp;

    public SQLCliente(PersistenciaAlohandes pp) {
        this.pp = pp;
    }

    /**
     * Cambia los valores de un cliente en la base de datos.
     * @param pm - El PersistenceManager que realiza la transacción
     * @param idCliente - El identificador del cliente
     * @param nombre - El nuevo nombre del cliente
     * @param vinculoUniandes - El nuevo vínculo con Uniandes del cliente
     * @return El número de tuplas modificadas
     */
    public long actualizarCliente (PersistenceManager pm, long idCliente, String vinculoUniandes, String usuario, String clave) 
    {
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaCliente() + " SET nombre = ?, vinculo_uniandes = ? WHERE id = ?");
        q.setParameters(vinculoUniandes, idCliente);
        return (long) q.executeUnique();
    }

    //Otros métodos necesarios para esta clase de persistencia.

    public long adicionarCliente(PersistenceManager pm, long idCliente, String vinculoConUniandes, String usuario, String clave) {
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaCliente() + "(idcliente, vinculoconuniandes, usuario, clave) values (?, ?, ?, ?)");
        q.setParameters(idCliente, vinculoConUniandes, usuario, clave);
        return (long) q.executeUnique();
    }

    public long eliminarClientePorId(PersistenceManager pm, long idCliente) {
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCliente() + " WHERE idCliente = ?");
        q.setParameters(idCliente);
        return (long) q.executeUnique();
    }

    public Cliente darClientePorId(PersistenceManager pm, long idCliente) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCliente() + " WHERE idCliente = ?");
        q.setResultClass(Cliente.class);
        q.setParameters(idCliente);
        return (Cliente) q.executeUnique();
    }

    public List<VOCliente> darClientes(PersistenceManager pm) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCliente());
        q.setResultClass(Cliente.class);
        return (List<VOCliente>) q.executeList();
    }

    public List<Cliente> darClientesPorVinculoConUniandes(PersistenceManager pm, String vinculoConUniandes) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCliente() + " WHERE vinculoconuniandes = ?");
        q.setResultClass(Cliente.class);
        q.setParameters(vinculoConUniandes);
        return (List<Cliente>) q.executeList();
        
    }
    public Cliente darClientePorUsuario(PersistenceManager pm, String usuario) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCliente() + " WHERE usuario = ?");
        q.setResultClass(Cliente.class);
        q.setParameters(usuario);
        return (Cliente) q.executeUnique();
        
    }
    
    public long cambiarRelacionConUniandes(PersistenceManager pm, long idOperador, String nuevaRelacion) {
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaOperador() + " SET relacionConUniandes = ? WHERE idCliente = ?");
        q.setParameters(nuevaRelacion, idOperador);
        return (long) q.executeUnique();
    }
    
    public long cambiarUsuario(PersistenceManager pm, long idCliente, String nuevoUsuario) {
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaOperador() + " SET usuario = ? WHERE idCliente = ?");
        q.setParameters(nuevoUsuario, idCliente);
        return (long) q.executeUnique();
    }
   
    
 // Consultar las reservas realizadas por un cliente específico
    public List<Reserva> darReservasPorCliente(PersistenceManager pm, long idCliente) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReserva() + " WHERE idclienteasociado = ?");
        q.setResultClass(Reserva.class);
        q.setParameters(idCliente);
        return (List<Reserva>) q.executeList();
    }

    // Consultar los clientes que han realizado reservas en un rango de fechas específico
    public List<Cliente> darClientesPorRangoFechasReserva(PersistenceManager pm, Date fechaInicial, Date fechaFinal) {
        String sql = "SELECT DISTINCT c.* FROM " + pp.darTablaCliente() + " c, " + pp.darTablaReserva() + " r ";
        sql += "WHERE r.fechareserva BETWEEN ? AND ? ";
        sql += "AND r.idclienteasociado = c.id";

        Query q = pm.newQuery(SQL, sql);
        q.setResultClass(Cliente.class);
        q.setParameters(fechaInicial, fechaFinal);
        return (List<Cliente>) q.executeList();
    }

    // Consultar el número de reservas realizadas por cada cliente
    public List<Object[]> darClientesYNumeroReservas(PersistenceManager pm) {
        String sql = "SELECT c.id, c.vinculoconuniandes, COUNT(r.idclienteasociado) as num_reservas ";
        sql += "FROM " + pp.darTablaCliente() + " c LEFT JOIN " + pp.darTablaReserva() + " r ";
        sql += "ON c.id = r.idclienteasociado ";
        sql += "GROUP BY c.id, c.vinculoconuniandes";

        Query q = pm.newQuery(SQL, sql);
        return q.executeList();
    }

    // Consultar las ofertas de alojamiento reservadas por un cliente específico
    public List<OfertaAlojamiento> darOfertasReservadasPorCliente(PersistenceManager pm, long idCliente) {
        String sql = "SELECT o.* FROM " + pp.darTablaOfertaAlojamiento() + " o, " + pp.darTablaReserva() + " r ";
        sql += "WHERE r.idclienteasociado = ? ";
        sql += "AND r.idofertaasociada = o.idOferta";

        Query q = pm.newQuery(SQL, sql);
        q.setResultClass(OfertaAlojamiento.class);
        q.setParameters(idCliente);
        return (List<OfertaAlojamiento>) q.executeList();
    }
    
    
    // Obtener un Cliente por sus CREDENCIALES:
    
    public Cliente darClientePorCredenciales(PersistenceManager pm, String usuario, String clave) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCliente() + " c WHERE c.usuario = ? AND c.clave = ?");
        q.setResultClass(Cliente.class);
        q.setParameters(usuario, clave);
        return (Cliente) q.executeUnique();
    }


}