package uniandes.isis2304.alohandes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

/* Esta clase  se encarga de manejar la secuencia para la generación de IDs y de limpiar todas las tablas en la base de datos. */

public class SQLUtil {

    private static final String SQL = PersistenciaAlohandes.SQL;

    private PersistenciaAlohandes pp;

    public SQLUtil(PersistenciaAlohandes pp) {
        this.pp = pp;
    }

    public long nextval(PersistenceManager pm) {
        Query q = pm.newQuery(SQL, "SELECT " + pp.darSeqAlohandes() + "SEQ" + ".nextval FROM DUAL");
        q.setResultClass(Long.class);
        long resp = (long) q.executeUnique();
        return resp;
    }

    public long[] limpiarAlohandes(PersistenceManager pm) {
        // Reemplaza los nombres de las tablas con los nombres de las tablas en tu modelo
        Query qServiciosPorOferta = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServiciosPorOferta());
        Query qReserva = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReserva());
        Query qOfertaAlojamiento = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOfertaAlojamiento());
        Query qServicio = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio());
        Query qHabitacion = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHabitacion());
        Query qVivienda = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaVivienda());
        Query qInmueble = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaInmueble());
        Query qEmpresaAlojamiento = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaEmpresaAlojamiento());
        Query qPersonaNatural = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPersonaNatural());
        Query qOperador = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOperador());
        Query qCliente = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCliente());

        long serviciosPorOfertaEliminados = (long) qServiciosPorOferta.executeUnique();
        long reservasEliminadas = (long) qReserva.executeUnique();
        long ofertasAlojamientoEliminadas = (long) qOfertaAlojamiento.executeUnique();
        long serviciosEliminados = (long) qServicio.executeUnique();
        long habitacionesEliminadas = (long) qHabitacion.executeUnique();
        long viviendasEliminadas = (long) qVivienda.executeUnique();
        long inmueblesEliminados = (long) qInmueble.executeUnique();
        long empresasAlojamientoEliminadas = (long) qEmpresaAlojamiento.executeUnique();
        long personasNaturalesEliminadas = (long) qPersonaNatural.executeUnique();
        long operadoresEliminados = (long) qOperador.executeUnique();
        long clientesEliminados = (long) qCliente.executeUnique();

        return new long[] {serviciosPorOfertaEliminados, reservasEliminadas, ofertasAlojamientoEliminadas, serviciosEliminados,
                habitacionesEliminadas, viviendasEliminadas, inmueblesEliminados, empresasAlojamientoEliminadas,
                personasNaturalesEliminadas, operadoresEliminados, clientesEliminados};
            }
            
}