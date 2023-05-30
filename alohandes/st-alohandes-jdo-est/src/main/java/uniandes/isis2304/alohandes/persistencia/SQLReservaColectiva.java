package uniandes.isis2304.alohandes.persistencia;

import java.sql.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.alohandes.negocio.OfertaAlojamiento;
import uniandes.isis2304.alohandes.negocio.ReservaColectiva;
import uniandes.isis2304.alohandes.negocio.VOReservaColectiva;


public class SQLReservaColectiva {

	private static final String SQL = PersistenciaAlohandes.SQL;

    private PersistenciaAlohandes pp;

    public SQLReservaColectiva(PersistenciaAlohandes pp) {
        this.pp = pp;
    }

  
    //Otros métodos necesarios para esta clase de persistencia.

    public long adicionarReservaColectiva(PersistenceManager pm, long idReservaColectiva, long idOfertaAsociada) {
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaReservaColectiva() + "(idReservaColectiva, idOfertaAsociada) values ( ?, ?)");
        q.setParameters(idReservaColectiva, idOfertaAsociada);
        return (long) q.executeUnique();
    }

    public long eliminarReservaColectivaPorId(PersistenceManager pm, long idReservaColectiva) {
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReservaColectiva() + " WHERE idReservaColectiva = ?");
        q.setParameters(idReservaColectiva);
        return (long) q.executeUnique();
    }

    public List<ReservaColectiva> darReservaColectivaPorId(PersistenceManager pm, long idReservaColectiva) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReservaColectiva() + " WHERE idReservaColectiva = ?");
        q.setResultClass(ReservaColectiva.class);
        q.setParameters(idReservaColectiva);
        return (List<ReservaColectiva>) q.executeList();
    }
    
    


    public List<ReservaColectiva> darReservasColectivas(PersistenceManager pm) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaReservaColectiva());
        q.setResultClass(ReservaColectiva.class);
        return (List<ReservaColectiva>) q.executeList();
    }
}
