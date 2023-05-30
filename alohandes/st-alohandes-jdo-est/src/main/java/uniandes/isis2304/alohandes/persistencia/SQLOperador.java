package uniandes.isis2304.alohandes.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import java.util.ArrayList;

import uniandes.isis2304.alohandes.negocio.Cliente;
import uniandes.isis2304.alohandes.negocio.Operador;
import uniandes.isis2304.alohandes.negocio.VOOperador;

public class SQLOperador {
    private static final String SQL = "javax.jdo.query.SQL";
    private PersistenciaAlohandes pp;

    public SQLOperador(PersistenciaAlohandes pp) {
        this.pp = pp;
    }

    public long adicionarOperador(PersistenceManager pm, long idOperador, String relacionConUniandes, String usuario, String clave) {
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaOperador() + "(id, relacionConUniandes, usuario, clave) values (?, ?, ?, ?)");
        q.setParameters(idOperador, relacionConUniandes, usuario, clave);
        return (long) q.executeUnique();
    }

    public long eliminarOperadorPorId(PersistenceManager pm, long idOperador) {
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOperador() + " WHERE id = ?");
        q.setParameters(idOperador);
        return (long) q.executeUnique();
    }

    public Operador darOperadorPorId(PersistenceManager pm, long idOperador) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOperador() + " WHERE id = ?");
        q.setResultClass(Operador.class);
        q.setParameters(idOperador);
        return (Operador) q.executeUnique();
    }

    public List<VOOperador> darOperadores(PersistenceManager pm) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOperador());
        q.setResultClass(Operador.class);
        return (List<VOOperador>) q.executeList();
    }

    public long cambiarRelacionConUniandes(PersistenceManager pm, long idOperador, String nuevaRelacion) {
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaOperador() + " SET relacionConUniandes = ? WHERE id = ?");
        q.setParameters(nuevaRelacion, idOperador);
        return (long) q.executeUnique();
    }
    
    public long cambiarUsuarioOperador(PersistenceManager pm, long idOperador, String nuevoUsuario) {
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaOperador() + " SET usuario = ? WHERE id = ?");
        q.setParameters(nuevoUsuario, idOperador);
        return (long) q.executeUnique();
    }

    public Operador darOperadorPorUsuario(PersistenceManager pm, String usuario) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOperador() + " WHERE usuario = ?");
        q.setResultClass(Cliente.class);
        q.setParameters(usuario);
        return (Operador) q.executeUnique();
        
    }
    
    public List<Operador> darOperadoresPersonaNatural(PersistenceManager pm) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOperador() + " o INNER JOIN " + pp.darTablaPersonaNatural() + " pn ON o.id = pn.idOperador");
        q.setResultClass(Operador.class);
        return (List<Operador>) q.executeList();
    }

    public List<Operador> darOperadoresEmpresaAlojamiento(PersistenceManager pm) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOperador() + " o INNER JOIN " + pp.darTablaEmpresaAlojamiento() + " ea ON o.id = ea.idOperador");
        q.setResultClass(Operador.class);
        return (List<Operador>) q.executeList();
    }
    
    // Metodo para encontrar un Operador por su usuario y contrasenia:
    
    public Operador darOperadorPorCredenciales(PersistenceManager pm, String usuario, String clave) {
        Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOperador() + " WHERE usuario = ? AND clave = ?");
        q.setResultClass(Operador.class);
        q.setParameters(usuario, clave);
        return (Operador) q.executeUnique();
    }

    
    
    
}