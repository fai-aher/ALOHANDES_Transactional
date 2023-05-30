package uniandes.isis2304.alohandes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.alohandes.negocio.EmpresaAlojamiento;
import uniandes.isis2304.alohandes.negocio.VOEmpresaAlojamiento;

public class SQLEmpresaAlojamiento {

    private static final String SQL = PersistenciaAlohandes.SQL;
    private PersistenciaAlohandes pp;

    public SQLEmpresaAlojamiento(PersistenciaAlohandes pp) {
        this.pp = pp;
    }

    public long adicionarEmpresaAlojamiento(PersistenceManager pm, long idOperador, String tipoEmpresa, int horaApertura, int horaCierre) {
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaEmpresaAlojamiento() + "(idoperador, tipoempresa, horaapertura, horacierre) values (?, ?, ?, ?)");
        q.setParameters(idOperador, tipoEmpresa, horaApertura, horaCierre);
        return (long) q.executeUnique();
    }

    public long eliminarEmpresaAlojamiento(PersistenceManager pm, long idOperador) {
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaEmpresaAlojamiento() + " WHERE idoperador = ?");
        q.setParameters(idOperador);
        return (long) q.executeUnique();
    }

    public EmpresaAlojamiento darEmpresaAlojamiento(PersistenceManager pm, long idOperador) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaEmpresaAlojamiento() + " WHERE idoperador = ?");
        q.setResultClass(EmpresaAlojamiento.class);
        q.setParameters(idOperador);
        return (EmpresaAlojamiento) q.executeUnique();
    }

    public List<VOEmpresaAlojamiento> darEmpresasAlojamiento(PersistenceManager pm) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaEmpresaAlojamiento());
        q.setResultClass(EmpresaAlojamiento.class);
        return (List<VOEmpresaAlojamiento>) q.executeList();
    }

    public long cambiarTipoEmpresa(PersistenceManager pm, long idOperador, String tipoEmpresa) {
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaEmpresaAlojamiento() + " SET tipoempresa = ? WHERE idoperador = ?");
        q.setParameters(tipoEmpresa, idOperador);
        return (long) q.executeUnique();
    }

    public long cambiarHoraApertura(PersistenceManager pm, long idOperador, int horaApertura) {
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaEmpresaAlojamiento() + " SET horaapertura = ? WHERE idoperador = ?");
        q.setParameters(horaApertura, idOperador);
        return (long) q.executeUnique();
    }

    public long cambiarHoraCierre(PersistenceManager pm, long idOperador, int horaCierre) {
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaEmpresaAlojamiento() + " SET horacierre = ? WHERE idoperador = ?");
        q.setParameters(horaCierre, idOperador);
        return (long) q.executeUnique();
    }
}