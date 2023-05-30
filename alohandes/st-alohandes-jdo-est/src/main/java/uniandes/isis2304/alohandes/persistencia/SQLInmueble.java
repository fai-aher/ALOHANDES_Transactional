package uniandes.isis2304.alohandes.persistencia;

import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.alohandes.negocio.Inmueble;
import uniandes.isis2304.alohandes.negocio.VOInmueble;

public class SQLInmueble {

    private static final String SQL = PersistenciaAlohandes.SQL;
    private PersistenciaAlohandes pp;

    public SQLInmueble(PersistenciaAlohandes pp) {
        this.pp = pp;
    }

    public long adicionarInmueble(PersistenceManager pm, long idInmueble, long operadorAsociado, String categoria, int capacidad, String ubicacion, String menaje, int tamanoEnMtSq) {
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaInmueble() + "(idInmueble, operadorAsociado, categoria, capacidad, ubicacion, menaje, tamanoEnMtSq) values (?, ?, ?, ?, ?, ?, ?)");
        q.setParameters(idInmueble, operadorAsociado, categoria, capacidad, ubicacion, menaje, tamanoEnMtSq);
        return (long) q.executeUnique();
    }

    public long eliminarInmueblePorId(PersistenceManager pm, long idInmueble) {
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaInmueble() + " WHERE idInmueble = ?");
        q.setParameters(idInmueble);
        return (long) q.executeUnique();
    }

    public Inmueble darInmueblePorId(PersistenceManager pm, long idInmueble) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaInmueble() + " WHERE idInmueble = ?");
        q.setResultClass(Inmueble.class);
        q.setParameters(idInmueble);
        return (Inmueble) q.executeUnique();
    }

    public List<Inmueble> darInmueblesPorOperadorAsociado(PersistenceManager pm, long operadorAsociado) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaInmueble() + " WHERE operadorAsociado = ?");
        q.setResultClass(Inmueble.class);
        q.setParameters(operadorAsociado);
        return (List<Inmueble>) q.executeList();
    }

    public List<Inmueble> darInmueblesPorCategoria(PersistenceManager pm, String categoria) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaInmueble() + " WHERE categoria = ?");
        q.setResultClass(Inmueble.class);
        q.setParameters(categoria);
        return (List<Inmueble>) q.executeList();
    }

    public List<Inmueble> darInmueblesPorUbicacion(PersistenceManager pm, String ubicacion) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaInmueble() + " WHERE ubicacion = ?");
        q.setResultClass(Inmueble.class);
        q.setParameters(ubicacion);
        return (List<Inmueble>) q.executeList();
    }

    public List<Inmueble> darInmueblesPorCapacidad(PersistenceManager pm, int capacidad) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaInmueble() + " WHERE capacidad = ?");
        q.setResultClass(Inmueble.class);
        q.setParameters(capacidad);
        return (List<Inmueble>) q.executeList();
    }

    public List<Inmueble> darInmueblesPorMenaje(PersistenceManager pm, String menaje) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaInmueble() + " WHERE menaje = ?");
        q.setResultClass(Inmueble.class);
        q.setParameters(menaje);
        return (List<Inmueble>) q.executeList();
    }

    public List<Inmueble> darInmueblesPorTamanoEnMtSq(PersistenceManager pm, double tamanoEnMtSq) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaInmueble() + " WHERE tamanoEnMtSq = ?");
        q.setResultClass(Inmueble.class);
        q.setParameters(tamanoEnMtSq);
        return (List<Inmueble>) q.executeList();
    }

    public List<VOInmueble> darInmuebles(PersistenceManager pm) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaInmueble());
        q.setResultClass(Inmueble.class);
        return (List<VOInmueble>) q.executeList();
    }

    public long cambiarCategoriaInmueble(PersistenceManager pm, long idInmueble, String nuevaCategoria) {
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaInmueble() + " SET categoria = ? WHERE idInmueble = ?");
        q.setParameters(nuevaCategoria, idInmueble);
        return (long) q.executeUnique();
    }

    public long cambiarCapacidadInmueble(PersistenceManager pm, long idInmueble, int nuevaCapacidad) {
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaInmueble() + " SET capacidad = ? WHERE idInmueble = ?");
        q.setParameters(nuevaCapacidad, idInmueble);
        return (long) q.executeUnique();
    }

    public long cambiarUbicacionInmueble(PersistenceManager pm, long idInmueble, String nuevaUbicacion) {
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaInmueble() + " SET ubicacion = ? WHERE idInmueble = ?");
        q.setParameters(nuevaUbicacion, idInmueble);
        return (long) q.executeUnique();
    }

    public long cambiarMenajeInmueble(PersistenceManager pm, long idInmueble, String nuevoMenaje) {
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaInmueble() + " SET menaje = ? WHERE idInmueble = ?");
        q.setParameters(nuevoMenaje, idInmueble);
        return (long) q.executeUnique();
    }

    public long cambiarTamanoEnMtSqInmueble(PersistenceManager pm, long idInmueble, double nuevoTamanoEnMtSq) {
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaInmueble() + " SET tamanoEnMtSq = ? WHERE idInmueble = ?");
        q.setParameters(nuevoTamanoEnMtSq, idInmueble);
        return (long) q.executeUnique();
    }
}