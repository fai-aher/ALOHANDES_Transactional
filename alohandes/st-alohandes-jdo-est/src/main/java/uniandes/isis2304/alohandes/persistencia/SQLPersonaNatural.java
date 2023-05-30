package uniandes.isis2304.alohandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.alohandes.negocio.PersonaNatural;

public class SQLPersonaNatural {

    private static final String SQL = PersistenciaAlohandes.SQL;

    private PersistenciaAlohandes pp;

    public SQLPersonaNatural(PersistenciaAlohandes pp) {
        this.pp = pp;
    }

    public long adicionarPersonaNatural(PersistenceManager pm, long idOperador, boolean ofreceAlojamientoPorDias) {
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaPersonaNatural()
                + "(idOperador, ofreceAlojamientoPorDias) values (?, ?)");
        q.setParameters(idOperador, ofreceAlojamientoPorDias);
        return (long) q.executeUnique();
    }

    public long eliminarPersonaNaturalPorId(PersistenceManager pm, long idOperador) {
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPersonaNatural() + " WHERE idOperador = ?");
        q.setParameters(idOperador);
        return (long) q.executeUnique();
    }

    public PersonaNatural darPersonaNaturalPorId(PersistenceManager pm, long idOperador) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPersonaNatural() + " WHERE idOperador = ?");
        q.setResultClass(PersonaNatural.class);
        q.setParameters(idOperador);
        return (PersonaNatural) q.executeUnique();
    }

    public List<PersonaNatural> darPersonasNaturales(PersistenceManager pm) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPersonaNatural());
        q.setResultClass(PersonaNatural.class);
        return (List<PersonaNatural>) q.executeList();
    }

    public long cambiarOfreceAlojamientoPorDias(PersistenceManager pm, long idOperador, boolean ofreceAlojamientoPorDias) {
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaPersonaNatural()
                + " SET ofreceAlojamientoPorDias = ? WHERE idOperador = ?");
        q.setParameters(ofreceAlojamientoPorDias, idOperador);
        return (long) q.executeUnique();
    }

}