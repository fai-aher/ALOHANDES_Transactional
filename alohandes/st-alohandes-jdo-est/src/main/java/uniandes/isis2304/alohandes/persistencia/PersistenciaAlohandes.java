package uniandes.isis2304.alohandes.persistencia;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;  

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import uniandes.isis2304.alohandes.negocio.*;

public class PersistenciaAlohandes {

    private static Logger log = Logger.getLogger(PersistenciaAlohandes.class.getName());

    public static final String SQL = "javax.jdo.query.SQL";

    private static PersistenciaAlohandes instance;

    private PersistenceManagerFactory pmf;

    private List<String> tablas;

    //Instancia de la clase SQLUtil.

    private SQLUtil sqlUtil;

    //Declaracion de las clases SQL para el modelo ALOHANDES.

    private SQLCliente sqlCliente;

    private SQLEmpresaAlojamiento sqlEmpresaAlojamiento;

    private SQLHabitacion sqlHabitacion;

    private SQLInmueble sqlInmueble;

    private SQLOfertaAlojamiento sqlOfertaAlojamiento;

    private SQLOperador sqlOperador;

    private SQLPersonaNatural sqlPersonaNatural;

    private SQLReserva sqlReserva;

    private SQLServicio sqlServicio;

    private SQLServiciosPorOferta sqlServiciosPorOferta;

    private SQLVivienda sqlVivienda;
    
    private SQLReservaColectiva sqlReservaColectiva;


    private PersistenciaAlohandes() {
        pmf = JDOHelper.getPersistenceManagerFactory("Alohandes");
        crearClasesSQL();

        tablas = new LinkedList<String>();
        tablas.add("ALOHANDES");
		tablas.add ("CLIENTE");
		tablas.add ("EMPRESAALOJAMIENTO");
		tablas.add ("HABITACION");
		tablas.add ("INMUEBLE");
		tablas.add ("OFERTAALOJAMIENTO");
		tablas.add ("OPERADOR");
		tablas.add ("PERSONANATURAL");
        tablas.add ("RESERVA");
        tablas.add ("SERVICIO");
        tablas.add ("SERVICIOSPOROFERTA");
        tablas.add ("VIVIENDA");
        tablas.add("RESERVACOLECTIVA");        
    }

    private PersistenciaAlohandes(JsonObject tableConfig) {
        crearClasesSQL();
        tablas = leerNombresTablas(tableConfig);

        String unidadPersistencia = tableConfig.get("unidadPersistencia").getAsString();
        log.trace("Accediendo unidad de persistencia: " + unidadPersistencia);
        pmf = JDOHelper.getPersistenceManagerFactory(unidadPersistencia);
    }

    public static PersistenciaAlohandes getInstance() {
        if (instance == null) {
            instance = new PersistenciaAlohandes();
        }
        return instance;
    }

    public static PersistenciaAlohandes getInstance(JsonObject tableConfig) {
        if (instance == null) {
            instance = new PersistenciaAlohandes(tableConfig);
        }
        return instance;
    }

    public void cerrarUnidadPersistencia() {
        pmf.close();
        instance = null;
    }

    private List<String> leerNombresTablas(JsonObject tableConfig) {
        JsonArray nombres = tableConfig.getAsJsonArray("tablas");

        List<String> resp = new LinkedList<String>();
        for (JsonElement nom : nombres) {
            resp.add(nom.getAsString());
        }

        return resp;
    }

    private void crearClasesSQL() {
        sqlUtil = new SQLUtil(this);
		sqlCliente = new SQLCliente(this);
		sqlEmpresaAlojamiento = new SQLEmpresaAlojamiento(this);
		sqlHabitacion = new SQLHabitacion(this);
		sqlInmueble = new SQLInmueble(this);
		sqlOfertaAlojamiento = new SQLOfertaAlojamiento(this);
		sqlOperador = new SQLOperador(this);
		sqlPersonaNatural = new SQLPersonaNatural(this);
        sqlReserva = new SQLReserva(this);
        sqlServicio = new SQLServicio(this);
        sqlServiciosPorOferta = new SQLServiciosPorOferta(this);
        sqlVivienda = new SQLVivienda(this);
        sqlReservaColectiva=new SQLReservaColectiva(this);
    }

    //Metodos darTabla* para cada tabla del modelo ALOHANDES.

	/**
	 * @return La cadena de caracteres con el nombre del secuenciador de Alohandes.
	 */
	public String darSeqAlohandes ()
	{
		return "ALOHANDES";
	}

    /**
	 * @return La cadena de caracteres con el nombre de la tabla Cliente
	 */
	public String darTablaCliente ()
	{
		return "CLIENTE";
	}

    /**
	 * @return La cadena de caracteres con el nombre de la tabla EmpresaAlojamiento
	 */
	public String darTablaEmpresaAlojamiento ()
	{
		return "EMPRESAALOJAMIENTO";
	}

    /**
	 * @return La cadena de caracteres con el nombre de la tabla Habitacion
	 */
	public String darTablaHabitacion ()
	{
		return "HABITACION";
	}

    /**
	 * @return La cadena de caracteres con el nombre de la tabla Inmueble
	 */
	public String darTablaInmueble ()
	{
		return "INMUEBLE";
	}

    /**
	 * @return La cadena de caracteres con el nombre de la tabla OfertaAlojamiento
	 */
	public String darTablaOfertaAlojamiento ()
	{
		return "OFERTAALOJAMIENTO";
	}

    /**
	 * @return La cadena de caracteres con el nombre de la tabla Operador
	 */
	public String darTablaOperador ()
	{
		return "OPERADOR";
	}

    /**
	 * @return La cadena de caracteres con el nombre de la tabla PersonaNatural
	 */
	public String darTablaPersonaNatural ()
	{
		return "PERSONANATURAL";
	}

    /**
	 * @return La cadena de caracteres con el nombre de la tabla Reserva
	 */
	public String darTablaReserva ()
	{
		return "RESERVA";
	}

    /**
	 * @return La cadena de caracteres con el nombre de la tabla Servicio
	 */
	public String darTablaServicio ()
	{
		return "SERVICIO";
	}

    /**
	 * @return La cadena de caracteres con el nombre de la tabla ServiciosPorOferta
	 */
	public String darTablaServiciosPorOferta ()
	{
		return "SERVICIOSPOROFERTA";
	}

    /**
	 * @return La cadena de caracteres con el nombre de la tabla Vivienda
	 */
	public String darTablaVivienda ()
	{
		return "VIVIENDA";
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla reservacolectiva
	 */
	public String darTablaReservaColectiva ()
	{
		return "RESERVACOLECTIVA";
	}

	
	
	
	
	/**
	 * Transacción para el generador de secuencia de Parranderos
	 * Adiciona entradas al log de la aplicación
	 * @return El siguiente número del secuenciador de Parranderos
	 */

    private long nextval() {
        long resp = sqlUtil.nextval(pmf.getPersistenceManager());
        log.trace("Generando secuencia: " + resp);
        return resp;
    }

    private String darDetalleException(Exception e) {
        String resp = "";
        if (e.getClass().getName().equals("javax.jdo.JDODataStoreException")) {
            JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
            return je.getNestedExceptions()[0].getMessage();
        }
        return resp;
    }


    /* ****************************************************************
     *          Métodos para manejar las entidades del modelo
     *****************************************************************/


    /* ****************************************************************
     *                   Para la clase SQLCliente
     *****************************************************************/

    /**
     * Método que actualiza, de manera transaccional, un cliente
     * Adiciona entradas al log de la aplicación
     * @param idCliente - El identificador del cliente
     * @param nombre - El nuevo nombre del cliente
     * @param vinculoUniandes - El nuevo vínculo con Uniandes del cliente
     * @return El número de tuplas modificadas
     */

    //1 
    public long actualizarCliente(long idCliente, String vinculoUniandes, String usuario, String clave) 
    {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        try 
        {
            tx.begin();
            long tuplasActualizadas = sqlCliente.actualizarCliente(pm, idCliente, vinculoUniandes, usuario, clave);
            tx.commit();

            log.trace("Actualización del cliente: " + idCliente + ": " + tuplasActualizadas + " tuplas actualizadas");

            return tuplasActualizadas;
        } 
        catch (Exception e) 
        {
            log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        } 
        finally 
        {
            if (tx.isActive()) 
            {
                tx.rollback();
            }
            pm.close();
        }
    }

    //2
    /**
     * Método que inserta, de manera transaccional, una tupla en la tabla Cliente
     * Adiciona entradas al log de la aplicación
     * @param nombre - El nombre del cliente
     * @param vinculoUniandes - El vínculo del cliente con Uniandes
     * @return El objeto Cliente adicionado. null si ocurre alguna Excepción
     */
    public Cliente adicionarCliente(String vinculoUniandes, String usuario, String clave)
    {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idCliente = nextval ();
            long tuplasInsertadas = sqlCliente.adicionarCliente(pm, idCliente, vinculoUniandes, usuario, clave);
            tx.commit();

            log.trace ("Inserción de cliente con id:  " + idCliente + ". : " + tuplasInsertadas + " tuplas insertadas");

            return new Cliente(idCliente, vinculoUniandes, usuario, clave);
        }
        catch (Exception e)
        {
            log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

    //3
    /**
     * Método que elimina, de manera transaccional, un cliente dado su identificador
     * Adiciona entradas al log de la aplicación
     * @param idCliente - El identificador del cliente
     * @return El número de tuplas eliminadas. -1 si ocurre alguna Excepción
     */
    public long eliminarClientePorId(long idCliente)
    {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasEliminadas = sqlCliente.eliminarClientePorId(pm, idCliente);
            tx.commit();

            log.trace("Eliminando cliente con id: " + idCliente + ": " + tuplasEliminadas + " tuplas eliminadas");

            return tuplasEliminadas;
        }
        catch (Exception e)
        {
            log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
    
    public long actualizarUsuarioCliente(long idCliente, String nuevoUsuario) {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasActualizadas = sqlCliente.cambiarUsuario(pm, idCliente, nuevoUsuario);
            tx.commit();

            log.trace("Actualizado el usuario del cliente con id: " + idCliente + ": " + tuplasActualizadas + " tuplas actualizadas");

            return tuplasActualizadas;
        }
        catch (Exception e)
        {
            log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
    }
   
    //4
    /**
     * Método que consulta todas las tuplas en la tabla Cliente con un identificador dado
     * @param idCliente - El identificador del cliente
     * @return El objeto Cliente, construido con base en las tuplas de la tabla CLIENTE con el identificador dado
     */
    public Cliente darClientePorId (long idCliente)
    {
        return sqlCliente.darClientePorId (pmf.getPersistenceManager(), idCliente);
    }
    //5
    /**
     * Método que consulta todas las tuplas en la tabla Cliente
     * @return La lista de objetos Cliente, construidos con base en las tuplas de la tabla CLIENTE
     */
    public List<VOCliente> darClientes ()
    {
        return sqlCliente.darClientes (pmf.getPersistenceManager());
    }
    //6
    /**
     * Método que consulta todas las tuplas en la tabla Cliente que tienen un vínculo con Uniandes dado
     * @param vinculoUniandes - El vínculo del cliente con Uniandes
     * @return La lista de objetos Cliente, construidos con base en las tuplas de la tabla CLIENTE con el vínculo con Uniandes dado
     */
    public List<Cliente> darClientesPorVinculoConUniandes(String vinculoUniandes)
    {
        return sqlCliente.darClientesPorVinculoConUniandes(pmf.getPersistenceManager(), vinculoUniandes);
    }
    //7
    /**
     * Método que consulta las reservas de un cliente dado su identificador
     * @param idCliente - El identificador del cliente
     * @return La lista de objetos Reserva, construidos con base en las tuplas de la tabla RESERVA asociadas al cliente con el identificador dado
     */
    public List<Reserva> darReservasPorCliente(long idCliente)
    {
        return sqlCliente.darReservasPorCliente(pmf.getPersistenceManager(), idCliente);
    }
    //8
    /**
     * Método que consulta las ofertas reservadas por un cliente dado su identificador
     * @param idCliente - El identificador del cliente
     * @return La lista de objetos Oferta, construidos con base en las tuplas de la tabla OFERTA reservadas por el cliente con el identificador dado
     */
    public List<OfertaAlojamiento> darOfertasReservadasPorCliente(long idCliente)
    {
        return sqlCliente.darOfertasReservadasPorCliente(pmf.getPersistenceManager(), idCliente);
    }
    //9
    /**
     * Método que consulta los clientes que han realizado reservas en un rango de fechas dado
     * @param fechaInicio - La fecha de inicio del rango de fechas
     * @param fechaFin - La fecha de fin del rango de fechas
     * @return La lista de objetos Cliente, construidos con base en las tuplas de la tabla CLIENTE que tienen reservas en el rango de fechas dado
     */
    public List<Cliente> darClientesPorRangoFechasReserva(Date fechaInicio, Date fechaFin)
    {
        return sqlCliente.darClientesPorRangoFechasReserva(pmf.getPersistenceManager(), fechaInicio, fechaFin);
    }
    //10
    /**
     * Método que consulta los clientes y el número de reservas que han realizado
     * @return La lista de pares (Cliente, número de reservas), construidos con base en las tuplas de la tabla CLIENTE y el número de reservas realizadas por cada cliente
     */
    public List<Object []> darClientesYNumeroReservas()
    {
        return sqlCliente.darClientesYNumeroReservas(pmf.getPersistenceManager());
    }
    
    // Dar cliente por usuario
    public Cliente darClientePorUsuario(String usuario)
    {
        return sqlCliente.darClientePorUsuario(pmf.getPersistenceManager(), usuario);
    }



    /* ****************************************************************
     *              Para la clase SQLEmpresaAlojamiento
     *****************************************************************/

     //1
     public EmpresaAlojamiento adicionarEmpresaAlojamiento(String tipo, int horaApertura, int horaCierre)
     {
         PersistenceManager pm = pmf.getPersistenceManager();
         Transaction tx = pm.currentTransaction();
         try
         {
             tx.begin();
             long idEmpresaAlojamiento = nextval ();
             long tuplasInsertadas = sqlEmpresaAlojamiento.adicionarEmpresaAlojamiento(pm, idEmpresaAlojamiento, tipo, horaApertura, horaCierre);
             tx.commit();
     
             log.trace("Inserción de empresa de alojamiento: "+ ": " + tuplasInsertadas + " tuplas insertadas");
     
             return new EmpresaAlojamiento(idEmpresaAlojamiento, tipo, horaApertura, horaCierre);
         }
         catch (Exception e)
         {
             log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
             return null;
         }
         finally
         {
             if (tx.isActive())
             {
                 tx.rollback();
             }
             pm.close();
         }
     }
     
     public long eliminarEmpresaAlojamiento(long id)
     {
         PersistenceManager pm = pmf.getPersistenceManager();
         Transaction tx = pm.currentTransaction();
         try
         {
             tx.begin();
             long tuplasEliminadas = sqlEmpresaAlojamiento.eliminarEmpresaAlojamiento(pm, id);
             tx.commit();
     
             log.trace("Eliminación de empresa de alojamiento: " + id + ": " + tuplasEliminadas + " tuplas eliminadas");
     
             return tuplasEliminadas;
         }
         catch (Exception e)
         {
             log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
             return -1;
         }
         finally
         {
             if (tx.isActive())
             {
                 tx.rollback();
             }
             pm.close();
         }
     }

    /**
     * Método que consulta todas las tuplas en la tabla EmpresaAlojamiento con un identificador dado
     * @param id - El identificador de la empresa
     * @return El objeto EmpresaAlojamiento, construido con base en las tuplas de la tabla EMPRESAALOJAMIENTO con el identificador dado
     */
    public EmpresaAlojamiento darEmpresaAlojamiento(long id)
    {
        return sqlEmpresaAlojamiento.darEmpresaAlojamiento(pmf.getPersistenceManager(), id);
    }

    /**
     * Método que consulta todas las tuplas en la tabla EmpresaAlojamiento
     * @return La lista de objetos EmpresaAlojamiento, construidos con base en las tuplas de la tabla EMPRESAALOJAMIENTO
     */
    public List<VOEmpresaAlojamiento> darEmpresasAlojamiento()
    {
        return sqlEmpresaAlojamiento.darEmpresasAlojamiento(pmf.getPersistenceManager());
    }

    /**
     * Método que actualiza, de manera transaccional, el tipo de una empresa de alojamiento
     * @param id - El identificador de la empresa
     * @param tipo - El nuevo tipo de la empresa (HOTEL, HOSTAL, VIVIENDAUNIVERSITARIA, VIVIENDAEXPRESS)
     * @return El número de tuplas modificadas. -1 si ocurre alguna Excepción
     */
    public long cambiarTipoEmpresa(long id, String tipo)
    {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasActualizadas = sqlEmpresaAlojamiento.cambiarTipoEmpresa(pm, id, tipo);
            tx.commit();
    
            log.trace("Actualización con id: " + id + ": " + tuplasActualizadas + " tuplas actualizadas");
    
            return tuplasActualizadas;
        }
        catch (Exception e)
        {
            log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

    /**
     * Método que actualiza, de manera transaccional, la hora de apertura de una empresa de alojamiento
     * @param id - El identificador de la empresa
     * @param horaApertura - La nueva hora de apertura de la empresa
     * @return El número de tuplas modificadas. -1 si ocurre alguna Excepción
     */
    public long cambiarHoraApertura(long id, int horaApertura)
    {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasActualizadas = sqlEmpresaAlojamiento.cambiarHoraApertura(pm, id, horaApertura);
            tx.commit();
    
            log.trace("Actualización con id: " + id + ": " + tuplasActualizadas + " tuplas actualizadas");
    
            return tuplasActualizadas;
        }
        catch (Exception e)
        {
            log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

    /**
     * Método que actualiza, de manera transaccional, la hora de cierre de una empresa de alojamiento
     * @param id - El identificador de la empresa
     * @param horaCierre - La nueva hora de cierre de la empresa
     * @return El número de tuplas modificadas. -1 si ocurre alguna Excepción
     */
    public long cambiarHoraCierre(long id, int horaCierre)
    {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasActualizadas = sqlEmpresaAlojamiento.cambiarHoraCierre(pm, id, horaCierre);
            tx.commit();
    
            log.trace("Actualización con id: " + id + ": " + tuplasActualizadas + " tuplas actualizadas");
    
            return tuplasActualizadas;
        }
        catch (Exception e)
        {
            log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}


    /* ****************************************************************
     *              Para la clase SQLHabitacion
     *****************************************************************/

     public Habitacion adicionarHabitacion(String tipo)
     {
         PersistenceManager pm = pmf.getPersistenceManager();
         Transaction tx = pm.currentTransaction();
         try
         {
             tx.begin();
             long id = nextval ();
             long tuplasInsertadas = sqlHabitacion.adicionarHabitacion(pm, id, tipo);
             tx.commit();
     
             log.trace("Inserción de habitación: " + id + ": " + tuplasInsertadas + " tuplas insertadas");
     
             return new Habitacion(id, tipo);
         }
         catch (Exception e)
         {
             log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
             return null;
         }
         finally
         {
             if (tx.isActive())
             {
                 tx.rollback();
             }
             pm.close();
         }
     }
     
     public long eliminarHabitacionPorId(long id)
     {
         PersistenceManager pm = pmf.getPersistenceManager();
         Transaction tx = pm.currentTransaction();
         try
         {
             tx.begin();
             long tuplasEliminadas = sqlHabitacion.eliminarHabitacionPorId(pm, id);
             tx.commit();
     
             log.trace("Eliminación de habitación: " + id + ": " + tuplasEliminadas + " tuplas eliminadas");
     
             return tuplasEliminadas;
         }
         catch (Exception e)
         {
             log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
             return -1;
         }
         finally
         {
             if (tx.isActive())
             {
                 tx.rollback();
             }
             pm.close();
         }
     }

    /**
     * Método que consulta todas las tuplas en la tabla Habitacion con un identificador dado
     * @param id - El identificador de la habitación
     * @return El objeto Habitacion, construido con base en las tuplas de la tabla HABITACION con el identificador dado
     */
    public Habitacion darHabitacionPorId(long id)
    {
        return sqlHabitacion.darHabitacionPorId(pmf.getPersistenceManager(), id);
    }

    /**
     * Método que consulta todas las tuplas en la tabla Habitacion
     * @return La lista de objetos Habitacion, construidos con base en las tuplas de la tabla HABITACION
     */
    public List<Habitacion> darHabitaciones()
    {
        return sqlHabitacion.darHabitaciones(pmf.getPersistenceManager());
    }

    /**
     * Método que actualiza, de manera transaccional, el tipo de una habitación
     * @param id - El identificador de la habitación
     * @param tipo - El nuevo tipo de la habitación
     * @return El número de tuplas modificadas. -1 si ocurre alguna Excepción
     */
    public long cambiarTipoHabitacion(long id, String tipo)
    {
        return sqlHabitacion.cambiarTipoHabitacion(pmf.getPersistenceManager(), id, tipo);
    }

    /* ****************************************************************
     *              Para la clase SQLInmueble
     *****************************************************************/

     public Inmueble adicionarInmueble(long operadorAsociado, String categoria, int capacidad, String ubicacion, String menaje, int tamanoEnMtSq)
     {
         PersistenceManager pm = pmf.getPersistenceManager();
         Transaction tx = pm.currentTransaction();
         try
         {
             tx.begin();
             long idInmueble = nextval ();
             long tuplasInsertadas = sqlInmueble.adicionarInmueble(pm, idInmueble, operadorAsociado, categoria, capacidad,  ubicacion,  menaje, tamanoEnMtSq);
             tx.commit();
     
             log.trace("Inserción de inmueble: " + idInmueble + ": " + tuplasInsertadas + " tuplas insertadas");
     
             return new Inmueble(idInmueble, operadorAsociado, categoria, capacidad,  ubicacion,  menaje, tamanoEnMtSq);
         }
         catch (Exception e)
         {
             log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
             return null;
         }
         finally
         {
             if (tx.isActive())
             {
                 tx.rollback();
             }
             pm.close();
         }
     }
     
     public long eliminarInmueblePorId(long id)
     {
         PersistenceManager pm = pmf.getPersistenceManager();
         Transaction tx = pm.currentTransaction();
         try
         {
             tx.begin();
             long tuplasEliminadas = sqlInmueble.eliminarInmueblePorId(pm, id);
             tx.commit();
     
             log.trace("Eliminación de inmueble: " + id + ": " + tuplasEliminadas + " tuplas eliminadas");
     
             return tuplasEliminadas;
         }
         catch (Exception e)
         {
             log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
             return -1;
         }
         finally
         {
             if (tx.isActive())
             {
                 tx.rollback();
             }
             pm.close();
         }
     }

     //Metodos para obtener y actualizar informacion, se omite la especificacion de sus parametros debido a su similitud.
     
     public Inmueble darInmueblePorId(long id)
     {
         return sqlInmueble.darInmueblePorId(pmf.getPersistenceManager(), id);
     }

     public List<Inmueble> darInmueblesPorOperadorAsociado(long idOperador)
     {
         return sqlInmueble.darInmueblesPorOperadorAsociado(pmf.getPersistenceManager(), idOperador);
     }
     
     public List<Inmueble> darInmueblesPorCategoria(String categoria)
     {
         return sqlInmueble.darInmueblesPorCategoria(pmf.getPersistenceManager(), categoria);
     }
     
     public List<Inmueble> darInmueblesPorUbicacion(String ubicacion)
     {
         return sqlInmueble.darInmueblesPorUbicacion(pmf.getPersistenceManager(), ubicacion);
     }
     
     public List<Inmueble> darInmueblesPorCapacidad(int capacidad)
     {
         return sqlInmueble.darInmueblesPorCapacidad(pmf.getPersistenceManager(), capacidad);
     }
     
     public List<Inmueble> darInmueblesPorMenaje(String menaje)
     {
         return sqlInmueble.darInmueblesPorMenaje(pmf.getPersistenceManager(), menaje);
     }
     
     public List<Inmueble> darInmueblesPorTamanoEnMtSq(double tamanoEnMtSq)
     {
         return sqlInmueble.darInmueblesPorTamanoEnMtSq(pmf.getPersistenceManager(), tamanoEnMtSq);
     }
     
     public List<VOInmueble> darInmuebles()
     {
         return sqlInmueble.darInmuebles(pmf.getPersistenceManager());
     }
     
     public long cambiarCategoriaInmueble(long id, String categoria)
     {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasActualizadas = sqlInmueble.cambiarCategoriaInmueble(pm, id, categoria);
            tx.commit();
    
            log.trace("Actualización con id: " + id + ": " + tuplasActualizadas + " tuplas actualizadas");
    
            return tuplasActualizadas;
        }
        catch (Exception e)
        {
            log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
     
     public long cambiarCapacidadInmueble(long id, int capacidad)
     {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasActualizadas = sqlInmueble.cambiarCapacidadInmueble(pm, id, capacidad);
            tx.commit();
    
            log.trace("Actualización con id:" + id + ": " + tuplasActualizadas + " tuplas actualizadas");
    
            return tuplasActualizadas;
        }
        catch (Exception e)
        {
            log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
     
     public long cambiarUbicacionInmueble(long id, String ubicacion)
     {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasActualizadas = sqlInmueble.cambiarUbicacionInmueble(pm, id, ubicacion);
            tx.commit();
    
            log.trace("Actualización con id: " + id + ": " + tuplasActualizadas + " tuplas actualizadas");
    
            return tuplasActualizadas;
        }
        catch (Exception e)
        {
            log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
     
     public long cambiarMenajeInmueble(long id, String menaje)
     {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasActualizadas = sqlInmueble.cambiarMenajeInmueble(pm, id, menaje);
            tx.commit();
    
            log.trace("Actualización con id: " + id + ": " + tuplasActualizadas + " tuplas actualizadas");
    
            return tuplasActualizadas;
        }
        catch (Exception e)
        {
            log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
     
     public long cambiarTamanoEnMtSqInmueble(long id, double tamanoEnMtSq)
     {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasActualizadas = sqlInmueble.cambiarTamanoEnMtSqInmueble(pm, id, tamanoEnMtSq);
            tx.commit();
    
            log.trace("Actualización con id: " + id + ": " + tuplasActualizadas + " tuplas actualizadas");
    
            return tuplasActualizadas;
        }
        catch (Exception e)
        {
            log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}


    /* ****************************************************************
     *              Para la clase SQLOfertaAlojamiento
     *****************************************************************/

     public OfertaAlojamiento adicionarOfertaAlojamiento(int precioBase, long inmuebleAsociado, boolean ofertaActiva, boolean ofertaDisponible, String modalidadTemporal)
     {
         PersistenceManager pm = pmf.getPersistenceManager();
         Transaction tx=pm.currentTransaction();
         try
         {
             tx.begin();
             long idOferta = nextval ();
             long tuplasInsertadas = sqlOfertaAlojamiento.adicionarOfertaAlojamiento(pm, idOferta, precioBase, inmuebleAsociado, ofertaActiva, ofertaDisponible, modalidadTemporal);
             tx.commit();
     
             log.trace ("Inserción de oferta: " + idOferta + ": " + tuplasInsertadas + " tuplas insertadas");
     
             return new OfertaAlojamiento(idOferta, precioBase, inmuebleAsociado, ofertaActiva, ofertaDisponible, modalidadTemporal);
         }
         catch (Exception e)
         {
             log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
             return null;
         }
         finally
         {
             if (tx.isActive())
             {
                 tx.rollback();
             }
             pm.close();
         }
     }
     
     public long eliminarOfertaAlojamientoPorId(long id)
     {
         PersistenceManager pm = pmf.getPersistenceManager();
         Transaction tx=pm.currentTransaction();
         try
         {
             tx.begin();
             long tuplasEliminadas = sqlOfertaAlojamiento.eliminarOfertaAlojamientoPorId(pm, id);
             tx.commit();
     
             log.trace("Eliminación de oferta: " + id + ": " + tuplasEliminadas + " tuplas eliminadas");
     
             return tuplasEliminadas;
         }
         catch (Exception e)
         {
             log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
             return -1;
         }
         finally
         {
             if (tx.isActive())
             {
                 tx.rollback();
             }
             pm.close();
         }
     }
     
     public OfertaAlojamiento darOfertaAlojamientoPorId(long id)
     {
         return sqlOfertaAlojamiento.darOfertaAlojamientoPorId(pmf.getPersistenceManager(), id);
     }
     
     public List<OfertaAlojamiento> darOfertasAlojamiento()
     {
         return sqlOfertaAlojamiento.darOfertasAlojamiento(pmf.getPersistenceManager());
     }
     
     public long cambiarPrecioBaseOferta(long id, int precioBase)
     {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasActualizadas = sqlOfertaAlojamiento.cambiarPrecioBaseOferta(pm, id, precioBase);
            tx.commit();
    
            log.trace("Actualización con id: " + id + ": " + tuplasActualizadas + " tuplas actualizadas");
    
            return tuplasActualizadas;
        }
        catch (Exception e)
        {
            log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
     
     public long cambiarEstadoOferta(long id, boolean estado)
     {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasActualizadas = sqlOfertaAlojamiento.cambiarEstadoOferta(pm, id, estado);
            tx.commit();
    
            log.trace("Actualización con id: " + id + ": " + tuplasActualizadas + " tuplas actualizadas");
    
            return tuplasActualizadas;
        }
        catch (Exception e)
        {
            log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
     
     public long cambiarDisponibilidadOferta(long id, int i)
     {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasActualizadas = sqlOfertaAlojamiento.cambiarDisponibilidadOferta(pm, id, i);
            tx.commit();
    
            log.trace("Actualización con id: " + id + ": " + tuplasActualizadas + " tuplas actualizadas");
    
            return tuplasActualizadas;
        }
        catch (Exception e)
        {
            log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

     
     public long cambiarModalidadTemporalOferta(long id, String modalidadTemporal)
     {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasActualizadas = sqlOfertaAlojamiento.cambiarModalidadTemporalOferta(pm, id, modalidadTemporal);
            tx.commit();
    
            log.trace("Actualización con id: " + id + ": " + tuplasActualizadas + " tuplas actualizadas");
    
            return tuplasActualizadas;
        }
        catch (Exception e)
        {
            log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
 
     public List<OfertaAlojamiento> darOfertasAlojamientoPorModalidadTemporal(String modalidadTemporal)
     {
         return sqlOfertaAlojamiento.darOfertasAlojamientoPorModalidadTemporal(pmf.getPersistenceManager(), modalidadTemporal);
     }
     
     public List<OfertaAlojamiento> darOfertasAlojamientoActivas()
     {
         return sqlOfertaAlojamiento.darOfertasAlojamientoActivas(pmf.getPersistenceManager());
     }
     
     public List<OfertaAlojamiento> darOfertasAlojamientoDisponibles()
     {
         return sqlOfertaAlojamiento.darOfertasAlojamientoDisponibles(pmf.getPersistenceManager());
     }



    /* ****************************************************************
     *              Para la clase SQLOperador
     *****************************************************************/

     public Operador adicionarOperador(String relacionConUniandes, String usuario, String clave)
     {
         PersistenceManager pm = pmf.getPersistenceManager();
         Transaction tx=pm.currentTransaction();
         try
         {
             tx.begin();
             long idOperador = nextval ();
             long tuplasInsertadas = sqlOperador.adicionarOperador(pm, idOperador, relacionConUniandes, usuario, clave);
             tx.commit();
     
             log.trace ("Inserción de operador: " + idOperador + ": " + tuplasInsertadas + " tuplas insertadas");
     
             return new Operador(idOperador, relacionConUniandes, usuario, clave);
         }
         catch (Exception e)
         {
             log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
             return null;
         }
         finally
         {
             if (tx.isActive())
             {
                 tx.rollback();
             }
             pm.close();
         }
     }
     
     public long eliminarOperadorPorId(long id)
     {
         PersistenceManager pm = pmf.getPersistenceManager();
         Transaction tx=pm.currentTransaction();
         try
         {
             tx.begin();
             long tuplasEliminadas = sqlOperador.eliminarOperadorPorId(pm, id);
             tx.commit();
     
             log.trace("Eliminación de operador: " + id + ": " + tuplasEliminadas + " tuplas eliminadas");
     
             return tuplasEliminadas;
         }
         catch (Exception e)
         {
             log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
             return -1;
         }
         finally
         {
             if (tx.isActive())
             {
                 tx.rollback();
             }
             pm.close();
         }
     }
     

     public Operador darOperadorPorUsuario(String usuario) {
         {
             return sqlOperador.darOperadorPorUsuario(pmf.getPersistenceManager(), usuario);
         }
     }
     
     public Operador darOperadorPorId(long id)
     {
         return sqlOperador.darOperadorPorId(pmf.getPersistenceManager(), id);
     }
     
     public List<VOOperador> darOperadores()
     {
         return sqlOperador.darOperadores(pmf.getPersistenceManager());
     }
     
     public long cambiarRelacionConUniandes(long id, String relacionConUniandes)
     {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasActualizadas = sqlOperador.cambiarRelacionConUniandes(pm, id, relacionConUniandes);
            tx.commit();
    
            log.trace("Actualización con id:: " + id + ": " + tuplasActualizadas + " tuplas actualizadas");
    
            return tuplasActualizadas;
        }
        catch (Exception e)
        {
            log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
     
     public long cambiarUsuarioOperador(long idOperador, String nuevoUsuario) {
         PersistenceManager pm = pmf.getPersistenceManager();
         Transaction tx=pm.currentTransaction();
         try
         {
             tx.begin();
             long tuplasActualizadas = sqlOperador.cambiarUsuarioOperador(pm, idOperador, nuevoUsuario);
             tx.commit();
     
             log.trace("Actualización del usuario para el Operador con id:: " + idOperador + ": " + tuplasActualizadas + " tuplas actualizadas");
     
             return tuplasActualizadas;
         }
         catch (Exception e)
         {
             log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
             return -1;
         }
         finally
         {
             if (tx.isActive())
             {
                 tx.rollback();
             }
             pm.close();
         }
     }

     public List<Operador> darOperadoresPersonaNatural()
     {
         return sqlOperador.darOperadoresPersonaNatural(pmf.getPersistenceManager());
     }
     
     public List<Operador> darOperadoresEmpresaAlojamiento()
     {
         return sqlOperador.darOperadoresEmpresaAlojamiento(pmf.getPersistenceManager());
     }



    /* ****************************************************************
     *              Para la clase SQLPersonaNatural
     *****************************************************************/

     public PersonaNatural adicionarPersonaNatural(boolean ofreceAlojamientoPorDias)
     {
         PersistenceManager pm = pmf.getPersistenceManager();
         Transaction tx=pm.currentTransaction();
         try
         {
             tx.begin();
             long idPersonaNatural = nextval ();
             long tuplasInsertadas = sqlPersonaNatural.adicionarPersonaNatural(pm, idPersonaNatural, ofreceAlojamientoPorDias);
             tx.commit();
     
             log.trace ("Inserción de persona natural: " + idPersonaNatural + ": " + tuplasInsertadas + " tuplas insertadas");
     
             return new PersonaNatural(idPersonaNatural, ofreceAlojamientoPorDias);
         }
         catch (Exception e)
         {
             log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
             return null;
         }
         finally
         {
             if (tx.isActive())
             {
                 tx.rollback();
             }
             pm.close();
         }
     }
     
     public long eliminarPersonaNaturalPorId(long id)
     {
         PersistenceManager pm = pmf.getPersistenceManager();
         Transaction tx=pm.currentTransaction();
         try
         {
             tx.begin();
             long tuplasEliminadas = sqlPersonaNatural.eliminarPersonaNaturalPorId(pm, id);
             tx.commit();
     
             log.trace("Eliminación de persona natural: " + id + ": " + tuplasEliminadas + " tuplas eliminadas");
     
             return tuplasEliminadas;
         }
         catch (Exception e)
         {
             log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
             return -1;
         }
         finally
         {
             if (tx.isActive())
             {
                 tx.rollback();
             }
             pm.close();
         }
     }
     
     public PersonaNatural darPersonaNaturalPorId(long id)
     {
         return sqlPersonaNatural.darPersonaNaturalPorId(pmf.getPersistenceManager(), id);
     }
     
     public List<PersonaNatural> darPersonasNaturales()
     {
         return sqlPersonaNatural.darPersonasNaturales(pmf.getPersistenceManager());
     }
     
     public long cambiarOfreceAlojamientoPorDias(long id, boolean ofreceAlojamientoPorDias)
     {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasActualizadas = sqlPersonaNatural.cambiarOfreceAlojamientoPorDias(pm, id, ofreceAlojamientoPorDias);
            tx.commit();
    
            log.trace("Actualización con id: " + id + ": " + tuplasActualizadas + " tuplas actualizadas");
    
            return tuplasActualizadas;
        }
        catch (Exception e)
        {
            log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
   


    /* ****************************************************************
     *              Para la clase SQLReserva
     *****************************************************************/

     public Reserva adicionarReserva(long idClienteAsociado, long idOfertaAsociada, Date fechaReserva, Date fechaInicialReserva, Date fechaFinalReserva, String promocionesActivas, Date fechaCancelacion)
     {
         PersistenceManager pm = pmf.getPersistenceManager();
         Transaction tx=pm.currentTransaction();
         try
         {
             tx.begin();
             long tuplasInsertadas = sqlReserva.adicionarReserva(pm, idClienteAsociado, idOfertaAsociada, fechaReserva, fechaInicialReserva, fechaFinalReserva, promocionesActivas,  fechaCancelacion);
             tx.commit();
     
             log.trace ("Inserción de reserva" + ": " + tuplasInsertadas + " tuplas insertadas");
     
             return new Reserva(/* parámetros */);
         }
         catch (Exception e)
         {
             log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
             return null;
         }
         finally
         {
             if (tx.isActive())
             {
                 tx.rollback();
             }
             pm.close();
         }
     }
     
     public long eliminarReserva(long idCliente, long idOferta, Date fechaReserva)
     {
         PersistenceManager pm = pmf.getPersistenceManager();
         Transaction tx=pm.currentTransaction();
         try
         {
             tx.begin();
             long tuplasEliminadas = sqlReserva.eliminarReserva(pm, idCliente, idOferta, fechaReserva);
             tx.commit();
     
             log.trace("Eliminación de reserva: " + ": " + tuplasEliminadas + " tuplas eliminadas");
     
             return tuplasEliminadas;
         }
         catch (Exception e)
         {
             log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
             return -1;
         }
         finally
         {
             if (tx.isActive())
             {
                 tx.rollback();
             }
             pm.close();
         }
     }
     
     public Reserva darReservaPorId(long idCliente, long idOferta, Date fechaReserva)
     {
         return sqlReserva.darReservaPorId(pmf.getPersistenceManager(), idCliente, idOferta, fechaReserva);
     }
     
     public List<VOReserva> darReservas()
     {
         return sqlReserva.darReservas(pmf.getPersistenceManager());
     }
     
     public long actualizarFechaCancelacion(long idCliente, long idOferta, Date fechaReserva, Date fechaCancelacion)
     {
         PersistenceManager pm = pmf.getPersistenceManager();
         Transaction tx=pm.currentTransaction();
         try
         {
             tx.begin();
             long tuplasActualizadas = sqlReserva.actualizarFechaCancelacion(pm, idCliente, idOferta, fechaReserva, fechaCancelacion);
             tx.commit();
     
             log.trace("Actualización de fecha de cancelación de reserva: " + ": " + tuplasActualizadas + " tuplas actualizadas");
     
             return tuplasActualizadas;
         }
         catch (Exception e)
         {
             log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
             return -1;
         }
         finally
         {
             if (tx.isActive())
             {
                 tx.rollback();
             }
             pm.close();
         }
     }
     
     
     public List<Reserva> darReservasPorOferta(long idOferta)
     {
         return sqlReserva.darReservasPorOferta(pmf.getPersistenceManager(), idOferta);
     }
     
     public List<Object[]> darClientesYOfertasConReserva()
     {
         return sqlReserva.darClientesYOfertasConReserva(pmf.getPersistenceManager());
     }
     
     public List<Reserva> darReservasEntreFechas(Date fechaInicio, Date fechaFin)
     {
         return sqlReserva.darReservasEntreFechas(pmf.getPersistenceManager(), fechaInicio, fechaFin);
     }



    /* ****************************************************************
     *              Para la clase SQLServicio
     *****************************************************************/

     public Servicio adicionarServicio(String nombre, String descripcion, int horaApertura, int horaCierre, int costoAdicional)
     {
         PersistenceManager pm = pmf.getPersistenceManager();
         Transaction tx=pm.currentTransaction();
         try
         {
             tx.begin();
             long idServicio = nextval ();
             long tuplasInsertadas = sqlServicio.adicionarServicio(pm, idServicio, nombre, descripcion, horaApertura, horaCierre, costoAdicional);
             tx.commit();
     
             log.trace("Inserción de servicio: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
     
             return new Servicio(idServicio, nombre, descripcion, horaApertura, horaCierre, costoAdicional);
         }
         catch (Exception e)
         {
             log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
             return null;
         }
         finally
         {
             if (tx.isActive())
             {
                 tx.rollback();
             }
             pm.close();
         }
     }
     
     public long eliminarServicioPorId(long idServicio)
     {
         PersistenceManager pm = pmf.getPersistenceManager();
         Transaction tx=pm.currentTransaction();
         try
         {
             tx.begin();
             long tuplasEliminadas = sqlServicio.eliminarServicioPorId(pm, idServicio);
             tx.commit();
     
             log.trace("Eliminación de servicio por id: " + idServicio + ": " + tuplasEliminadas + " tuplas eliminadas");
     
             return tuplasEliminadas;
         }
         catch (Exception e)
         {
             log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
             return -1;
         }
         finally
         {
             if (tx.isActive())
             {
                 tx.rollback();
             }
             pm.close();
         }
     }
     
     public Servicio darServicioPorId(long idServicio)
     {
         return (Servicio) sqlServicio.darServicioPorId(pmf.getPersistenceManager(), idServicio);
     }
     
     public List<Servicio> darServicios()
     {
         return (List<Servicio>) sqlServicio.darServicios(pmf.getPersistenceManager());
     }

     public long cambiarNombreServicio(long idServicio, String nuevoNombre)
     {
         PersistenceManager pm = pmf.getPersistenceManager();
         Transaction tx=pm.currentTransaction();
         try
         {
             tx.begin();
             long tuplasActualizadas = sqlServicio.cambiarNombreServicio(pm, idServicio, nuevoNombre);
             tx.commit();
     
             log.trace("Cambio de nombre de servicio con id: " + idServicio + ": " + tuplasActualizadas + " tuplas actualizadas");
     
             return tuplasActualizadas;
         }
         catch (Exception e)
         {
             log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
             return -1;
         }
         finally
         {
             if (tx.isActive())
             {
                 tx.rollback();
             }
             pm.close();
         }
     }

     public long cambiarDescripcionServicio(long idServicio, String nuevaDescripcion)
     {
         PersistenceManager pm = pmf.getPersistenceManager();
         Transaction tx=pm.currentTransaction();
         try
         {
             tx.begin();
             long tuplasActualizadas = sqlServicio.cambiarDescripcionServicio(pm, idServicio, nuevaDescripcion);
             tx.commit();
     
             log.trace("Cambio de descripcion de servicio con id: " + idServicio + ": " + tuplasActualizadas + " tuplas actualizadas");
     
             return tuplasActualizadas;
         }
         catch (Exception e)
         {
             log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
             return -1;
         }
         finally
         {
             if (tx.isActive())
             {
                 tx.rollback();
             }
             pm.close();
         }
     }

     public long cambiarHoraAperturaServicio(long idServicio, int nuevaHora)
     {
         PersistenceManager pm = pmf.getPersistenceManager();
         Transaction tx=pm.currentTransaction();
         try
         {
             tx.begin();
             long tuplasActualizadas = sqlServicio.cambiarHoraAperturaServicio(pm, idServicio, nuevaHora);
             tx.commit();
     
             log.trace("Actualizacion con id: " + idServicio + ": " + tuplasActualizadas + " tuplas actualizadas");
     
             return tuplasActualizadas;
         }
         catch (Exception e)
         {
             log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
             return -1;
         }
         finally
         {
             if (tx.isActive())
             {
                 tx.rollback();
             }
             pm.close();
         }
     }

     public long cambiarHoraCierreServicio(long idServicio, int nuevaHora)
     {
         PersistenceManager pm = pmf.getPersistenceManager();
         Transaction tx=pm.currentTransaction();
         try
         {
             tx.begin();
             long tuplasActualizadas = sqlServicio.cambiarHoraCierreServicio(pm, idServicio, nuevaHora);
             tx.commit();
     
             log.trace("Actualizacion con id: " + idServicio + ": " + tuplasActualizadas + " tuplas actualizadas");
     
             return tuplasActualizadas;
         }
         catch (Exception e)
         {
             log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
             return -1;
         }
         finally
         {
             if (tx.isActive())
             {
                 tx.rollback();
             }
             pm.close();
         }
     }

     public long cambiarCostoAdicionalServicio(long idServicio, int nuevoCostoAdicional)
     {
         PersistenceManager pm = pmf.getPersistenceManager();
         Transaction tx=pm.currentTransaction();
         try
         {
             tx.begin();
             long tuplasActualizadas = sqlServicio.cambiarCostoAdicionalServicio(pm, idServicio, nuevoCostoAdicional);
             tx.commit();
     
             log.trace("Actualizacion con id: " + idServicio + ": " + tuplasActualizadas + " tuplas actualizadas");
     
             return tuplasActualizadas;
         }
         catch (Exception e)
         {
             log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
             return -1;
         }
         finally
         {
             if (tx.isActive())
             {
                 tx.rollback();
             }
             pm.close();
         }
     }
     
     public List<Servicio> darServiciosPorNombre(String nombre)
     {
         return sqlServicio.darServiciosPorNombre(pmf.getPersistenceManager(), nombre);
     }
     
     public List<Servicio> darServiciosPorRangoHorario(int horaInicio, int horaFin)
     {
         return sqlServicio.darServiciosPorRangoHorario(pmf.getPersistenceManager(), horaInicio, horaFin);
     }
     
     public List<Servicio> darServiciosPorCostoAdicional(int costo)
     {
         return sqlServicio.darServiciosPorCostoAdicional(pmf.getPersistenceManager(), costo);
     }
     
     public List<Servicio> darServiciosPorOfertaAlojamiento(long idOfertaAlojamiento)
     {
         return sqlServicio.darServiciosPorOfertaAlojamiento(pmf.getPersistenceManager(), idOfertaAlojamiento);
     }


    /* ****************************************************************
     *              Para la clase SQLServiciosPorOferta
     *****************************************************************/

    public ServiciosPorOferta adicionarServicioPorOferta(long idOfertaAlojamiento, long idServicioOfrecido)
    {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasInsertadas = sqlServiciosPorOferta.adicionarServicioPorOferta(pm, idOfertaAlojamiento, idServicioOfrecido);
            tx.commit();
    
            log.trace("Inserción de servicio por oferta con idOfertaAlojamiento: " + idOfertaAlojamiento + ", idServicioOfrecido: " + idServicioOfrecido + ": " + tuplasInsertadas + " tuplas insertadas");
    
            return new ServiciosPorOferta(idOfertaAlojamiento, idServicioOfrecido);
        }
        catch (Exception e)
        {
            log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
    
    // Necesarios ambos id para eliminar
    public long eliminarServicioPorOferta(long idOfertaAlojamiento, long idServicioOfrecido)
    {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasEliminadas = sqlServiciosPorOferta.eliminarServicioPorOferta(pm, idOfertaAlojamiento, idServicioOfrecido);
            tx.commit();
    
            log.trace("Eliminación de servicio por oferta con idOfertaAlojamiento: " + idOfertaAlojamiento + ", idServicioOfrecido: " + idServicioOfrecido + ": " + tuplasEliminadas + " tuplas eliminadas");
    
            return tuplasEliminadas;
        }
        catch (Exception e)
        {
            log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
    
    public List<ServiciosPorOferta> darServiciosPorOferta()
    {
        return sqlServiciosPorOferta.darServiciosPorOferta(pmf.getPersistenceManager());
    }
    
    public List<ServiciosPorOferta> darServiciosPorIdOfertaAlojamiento(long idOfertaAlojamiento)
    {
        return sqlServiciosPorOferta.darServiciosPorIdOfertaAlojamiento(pmf.getPersistenceManager(), idOfertaAlojamiento);
    }
    
    public List<ServiciosPorOferta> darServiciosPorIdServicioOfrecido(long idServicioOfrecido)
    {
        return sqlServiciosPorOferta.darServiciosPorIdServicioOfrecido(pmf.getPersistenceManager(), idServicioOfrecido);
    }

    /* ****************************************************************
     *              Para la clase SQLVivienda
     *****************************************************************/

     public Vivienda adicionarVivienda(long idInmueble, String tipoVivienda, int numeroHabitaciones)
     {
         PersistenceManager pm = pmf.getPersistenceManager();
         Transaction tx=pm.currentTransaction();
         try
         {
             tx.begin();
             long tuplasInsertadas = sqlVivienda.adicionarVivienda(pm, idInmueble, tipoVivienda, numeroHabitaciones);
             tx.commit();
     
             log.trace("Inserción de vivienda: " + idInmueble + ": " + tuplasInsertadas + " tuplas insertadas");
     
             return new Vivienda(idInmueble, tipoVivienda, numeroHabitaciones);
         }
         catch (Exception e)
         {
             log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
             return null;
         }
         finally
         {
             if (tx.isActive())
             {
                 tx.rollback();
             }
             pm.close();
         }
     }
     
     public long eliminarViviendaPorId(long idInmueble)
     {
         PersistenceManager pm = pmf.getPersistenceManager();
         Transaction tx=pm.currentTransaction();
         try
         {
             tx.begin();
             long tuplasEliminadas = sqlVivienda.eliminarViviendaPorId(pm, idInmueble);
             tx.commit();
     
             log.trace("Eliminación de vivienda: " + idInmueble + ": " + tuplasEliminadas + " tuplas eliminadas");
     
             return tuplasEliminadas;
         }
         catch (Exception e)
         {
             log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
             return -1;
         }
         finally
         {
             if (tx.isActive())
             {
                 tx.rollback();
             }
             pm.close();
         }
     }
     
     public Vivienda darViviendaPorId(long idInmueble)
     {
         return sqlVivienda.darViviendaPorId(pmf.getPersistenceManager(), idInmueble);
     }
     
     public List<Vivienda> darViviendas()
     {
         return sqlVivienda.darViviendas(pmf.getPersistenceManager());
     }
     
     public long cambiarTipoVivienda(long idInmueble, String tipoVivienda)
     {
         PersistenceManager pm = pmf.getPersistenceManager();
         Transaction tx=pm.currentTransaction();
         try
         {
             tx.begin();
             long tuplasActualizadas = sqlVivienda.cambiarTipoVivienda(pm, idInmueble, tipoVivienda);
             tx.commit();
     
             log.trace("Cambio de tipo de vivienda: " + idInmueble + ": " + tuplasActualizadas + " tuplas actualizadas");
     
             return tuplasActualizadas;
         }
         catch (Exception e)
         {
             log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
             return -1;
         }
         finally
         {
             if (tx.isActive())
             {
                 tx.rollback();
             }
             pm.close();
         }
     }
     
     public long cambiarNumeroHabitaciones(long idInmueble, int numeroHabitaciones)
     {
         PersistenceManager pm = pmf.getPersistenceManager();
         Transaction tx=pm.currentTransaction();
         try
         {
             tx.begin();
             long tuplasActualizadas = sqlVivienda.cambiarNumeroHabitaciones(pm, idInmueble, numeroHabitaciones);
             tx.commit();
     
             log.trace("Cambio de número de habitaciones de la vivienda: " + idInmueble + ": " + tuplasActualizadas + " tuplas actualizadas");
     
             return tuplasActualizadas;
         }
         catch (Exception e)
         {
            log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

    /**
     * Metodos combinados que relacionan diferentes tablas.
     */
    /**
     * Método privado para generar la información completa de las ofertas de alojamiento y sus servicios: 
     * La información básica de la oferta, especificando también el nombre del servicio, en el formato esperado por los objetos OFERTAALOJAMIENTO
     * @param tuplas - Una lista de arreglos de objetos, con la información de la oferta y del servicio, en el siguiente orden:
     *   oferta.id, oferta.precioBase, oferta.estado, oferta.disponibilidad, oferta.modalidadTemporal, servicio.id, servicio.nombre
     * @return Una lista de arreglos de 2 objetos. El primero es un objeto OFERTAALOJAMIENTO, el segundo corresponde al nombre del servicio
     */
    private List<Object[]> armarOfertasAlojamientoConServicios(List<Object[]> tuplas) {
        List<Object[]> ofertasConServicios = new LinkedList<Object[]>();
        for (Object[] tupla : tuplas) {
            long idOferta = ((BigDecimal) tupla[0]).longValue();
            int precioBase = ((BigDecimal) tupla[1]).intValue();
            String modalidadTemporal = (String) tupla[2];
            String nombreServicio = (String) tupla[3];
            long inmuebleAsociado = (long) tupla[4];
            boolean ofertaActiva = (boolean) tupla[5];
            boolean ofertaDisponible = (boolean) tupla[6];

            Object[] ofertaConServicio = new Object[2];
            ofertaConServicio[0] = new OfertaAlojamiento(idOferta, precioBase, inmuebleAsociado, ofertaActiva, ofertaDisponible, modalidadTemporal);
            ofertaConServicio[1] = nombreServicio;

            ofertasConServicios.add(ofertaConServicio);
        }
        return ofertasConServicios;
    }

    private List<Object[]> armarReservasConClientesYOfertas(List<Object[]> tuplas) {
        List<Object[]> reservasConClientesYOfertas = new LinkedList<Object[]>();
        for (Object[] tupla : tuplas) {
            long idCliente = ((BigDecimal) tupla[0]).longValue();
            long idOferta = ((BigDecimal) tupla[1]).longValue();
            Date fechaReserva = (Date) tupla[2];
            Date fechaInicio = (Date) tupla[3];
            Date fechaFin = (Date) tupla[4];
            String promociones = (String) tupla[5];
            Date fechaCancelacion = (Date) tupla[6];
            String relacionConUniandes = (String) tupla[7];
            int precioBase = (int) tupla[8];
            long inmuebleAsociado = (long) tupla[9];
            boolean ofertaActiva = (boolean) tupla[10];
            boolean ofertaDisponible = (boolean) tupla[11];
            String modalidadTemporal = (String) tupla[12];
            String usuario = (String) tupla[13];
            String clave = (String) tupla[14];
    
    
            Object[] reservaClienteOferta = new Object[3];
            reservaClienteOferta[0] = new Reserva(idCliente, idOferta, fechaReserva, fechaInicio, fechaFin, promociones, fechaCancelacion);
            reservaClienteOferta[1] = new Cliente(idCliente, relacionConUniandes, usuario, clave);
            reservaClienteOferta[2] = new OfertaAlojamiento(idOferta, precioBase, inmuebleAsociado, ofertaActiva, ofertaDisponible, modalidadTemporal);
    
            reservasConClientesYOfertas.add(reservaClienteOferta);
        }
        return reservasConClientesYOfertas;
    }

    private List<Object[]> armarInmueblesConOperadores(List<Object[]> tuplas) {
        List<Object[]> inmueblesConOperadores = new LinkedList<Object[]>();
        for (Object[] tupla : tuplas) {
            long idInmueble = ((BigDecimal) tupla[0]).longValue();
            String ubicacion = (String) tupla[1];
            String categoria = (String) tupla[2];
            int capacidad = ((BigDecimal) tupla[3]).intValue();
            long idOperador = ((BigDecimal) tupla[4]).longValue();
            String menaje = (String) tupla[5];
            double tamano = ((BigDecimal) tupla[6]).doubleValue();
            String relacionUniandes = (String) tupla[7];
            String usuario = (String) tupla[8];
            String clave = (String) tupla[9];
    
            Object[] inmuebleOperador = new Object[2];
            inmuebleOperador[0] = new Inmueble(idInmueble, idOperador, categoria, capacidad, ubicacion, menaje, tamano);
            inmuebleOperador[1] = new Operador(idOperador, relacionUniandes, usuario, clave);
    
            inmueblesConOperadores.add(inmuebleOperador);
        }
        return inmueblesConOperadores;
    }

    private List<Object[]> armarOfertasAlojamientoConInmuebles(List<Object[]> tuplas) {
        List<Object[]> ofertasAlojamientoConInmuebles = new LinkedList<Object[]>();
        for (Object[] tupla : tuplas) {
            long idOferta = ((BigDecimal) tupla[0]).longValue();
            int precioBase = (int) tupla[1];
            long idInmueble = ((BigDecimal) tupla[2]).longValue();
            String ubicacion = (String) tupla[3];
            String categoria = (String) tupla[4];
            int capacidad = ((BigDecimal) tupla[5]).intValue();
            long idOperador = ((BigDecimal) tupla[6]).longValue();
            boolean ofertaActiva = (boolean) tupla[7];
            boolean ofertaDisponible = (boolean) tupla[8];
            String modalidadTemporal = (String) tupla[9];
            String menaje = (String) tupla[10];
            double tamano = ((BigDecimal) tupla[11]).doubleValue();
    
            Object[] ofertaInmueble = new Object[2];
            ofertaInmueble[0] = new OfertaAlojamiento(idOferta, precioBase, idInmueble, ofertaActiva, ofertaDisponible, modalidadTemporal);
            ofertaInmueble[1] = new Inmueble(idInmueble, idOperador, categoria, capacidad, ubicacion, menaje, tamano);
    
            ofertasAlojamientoConInmuebles.add(ofertaInmueble);
        }
        return ofertasAlojamientoConInmuebles;
    }


    // Fin metodos de clases SQL
    
    
    
    /* ****************************************************************
     *  Métodos especificos para Resolver Requerimientos Funcionales  *
     *****************************************************************/
    
    /* Para resolver la RFC 1: Mostrar el dinero recibido por cada proveedor de alojamiento durante el año actual y el
     * año corrido.
     * 
     * Consideracion: el dinero que recibe un operador por reserva de su alojamiento es igual
     * al numero de dias de reserva multiplicados por el precio base de su oferta de alojamiento
     * asoaciada a ese inmueble.
     */
    
    public List<Object[]> dineroRecibidoPorProveedor(int anioActual, int anioPasado) {
        log.info("Consultando el dinero recibido por proveedores de alojamiento");
        List<Object[]> resultado;
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        
        try {
            tx.begin();
            
            String sql = "SELECT op.IDOPERADOR, SUM((TRUNC(res.FECHAFINALRESERVA) - TRUNC(res.FECHAINICIALRESERVA)) * o.PRECIOBASE) AS DINERO_RECIBIDO " +
                    "FROM OPERADOR op " +
            		"JOIN INMUEBLE i ON op.IDOPERADOR = i.OPERADORASOCIADO " +
                    "JOIN OFERTAALOJAMIENTO o ON op.IDOPERADOR = i.OPERADORASOCIADO " +
                    "JOIN RESERVA res ON o.IDOFERTA = res.IDOFERTAASOCIADA " +
                    "WHERE (EXTRACT(YEAR FROM res.FECHAINICIALRESERVA) = ? OR EXTRACT(YEAR FROM res.FECHAINICIALRESERVA) = ?) " +
                    "GROUP BY op.IDOPERADOR " +
                    "ORDER BY op.IDOPERADOR ";
                       
            Query q = pm.newQuery(SQL, sql);
            q.setParameters(anioActual, anioPasado);
            resultado = (List<Object[]>) q.executeList();
            
            tx.commit();
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage(), e);
            resultado = null;
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }
        
        log.info("Consulta realizada");
        return resultado;
    }
    
 
    
    // Para resolver la RFC2: 20 consultas mas populares
    
    public void ofertasMasPopulares() {
        log.info("Consultando las 20 ofertas más populares");

        String sql = "SELECT o.IDOFERTA, o.PRECIOBASE, COUNT(res.IDOFERTAASOCIADA) " +
                     "FROM OFERTAALOJAMIENTO o " +
                     "JOIN RESERVA res ON o.IDOFERTA = res.IDOFERTAASOCIADA " +
                     "GROUP BY o.IDOFERTA, o.PRECIOBASE " +
                     "ORDER BY COUNT(o.IDOFERTA) DESC " +
                     "FETCH FIRST 20 ROWS ONLY ";

        List<?> resultado = new ArrayList<>();

        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        
        try {
            tx.begin();
            Query q = pm.newQuery(SQL, sql);
            List<?> queryResult = q.executeList();
            tx.commit();
        } catch (Exception e) {
            log.error("Error consultando las 20 ofertas más populares: " + e.getMessage());
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            if (!((PersistenceManager) tx).isClosed()) {
                ((PersistenceManager) tx).close();
            }
            pm.close();
        }

        log.info("Consulta realizada");
    }
    
    
    
    // Para el RFC3: Mostrar el índice de ocupación de cada una de las ofertas
    // de alojamiento registradas
    
    /* 
     *  el índice de ocupación se define como la proporción del número de días
     *  reservados para cada oferta durante un período específico (por ejemplo,
     *  un año) en relación con el total de días disponibles en ese período
    */
    
    public List<Object[]> indiceOcupacion(Date fechaInicio, Date fechaFin) {
        log.info("Consultando el índice de ocupación de las ofertas de alojamiento");
        List<Object[]> resultado = new ArrayList<>();

        String sql = "SELECT ofer.ID, COUNT(res.ID) AS NUMERO_RESERVAS, " +
                     "SUM(TRUNC(res.FECHAFINALRESERVA) - TRUNC(res.FECHAINICIALRESERVA)) AS DIAS_RESERVADOS, " +
                     "((SUM(TRUNC(res.FECHAFINALRESERVA) - TRUNC(res.FECHAINICIALRESERVA))) / ((TRUNC(? - ?)) * 1.0)) * 100 AS INDICE_OCUPACION " +
                     "FROM OFERTAALOJAMIENTO ofer LEFT JOIN RESERVA res " +
                     "ON ofer.ID = res.IDOFERTAASOCIADA " +
                     "AND TRUNC(res.FECHAINICIALRESERVA) >= ? AND TRUNC(res.FECHAFINALRESERVA) <= ? " +
                     "GROUP BY ofer.ID";

        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();

        try {
            tx.begin();
            Query q = pm.newQuery(SQL, sql);
            q.setParameters(fechaInicio, fechaFin, fechaInicio, fechaFin);
            List<Object[]> queryResult = (List<Object[]>) q.executeList();
            resultado.addAll(queryResult);
            tx.commit();
        } catch (Exception e) {
            log.error("Error consultando el índice de ocupación de las ofertas de alojamiento: " + e.getMessage());
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            if (!((PersistenceManager) tx).isClosed()) {
                ((PersistenceManager) tx).close();
            }
            pm.close();
        }

        return resultado;
    }
    
    
    /* Para el RFC4: Mostrar los alojamientos disponibles en un rango de fechas,
     * que cumplen con un conjunto de requerimientos de dotación o servicios.
     * 
     * Se consider que esos servicios se obtienen como parametros por medio de una
     * lista de Strings.
     * 
     * Además, se requerien 2 atributos mas: fechaInicio y fechaFin para filtrar la
     * busqueda.
     */
    
    public List<OfertaAlojamiento> alojamientosDisponiblesConServicios(Date fechaInicio, Date fechaFin, List<String> servicios) {
        log.info("Consultando alojamientos disponibles con servicios específicos");
        List<OfertaAlojamiento> resultado = new ArrayList<>();

        String baseSql = "SELECT ofer.* " +
                         "FROM OFERTAALOJAMIENTO ofer " +
                         "WHERE ofer.ID NOT IN (SELECT res.IDOFERTAASOCIADA FROM RESERVA res " +
                         "WHERE (TRUNC(res.FECHAINICIALRESERVA) BETWEEN ? AND ?) OR (TRUNC(res.FECHAFINALRESERVA) BETWEEN ? AND ?)) " +
                         "AND ofer.ID IN (SELECT spo.IDOFERTAALOJAMIENTO FROM SERVICIOSPOROFERTA spo " +
                         "INNER JOIN SERVICIO serv ON spo.IDSERVICIOOFRECIDO = serv.IDSERVICIO WHERE serv.NOMBRE IN ";

        String inClause = servicios.stream().map(s -> "?").collect(Collectors.joining(",", "(", ")"));

        String sql = baseSql + inClause + " GROUP BY spo.IDOFERTAALOJAMIENTO HAVING COUNT(spo.IDOFERTAALOJAMIENTO) = ?)";

        PersistenceManager pm = pmf.getPersistenceManager();	
        Transaction tx = pm.currentTransaction();

        try {
            tx.begin();
            Query q = pm.newQuery(SQL, sql);

            q.setParameters(fechaInicio, fechaFin, fechaInicio, fechaFin);
            for (int i = 0; i < servicios.size(); i++) {
                q.setParameters(i + 4, servicios.get(i));
            }
            q.setParameters(servicios.size() + 4, servicios.size());

            List<OfertaAlojamiento> queryResult = (List<OfertaAlojamiento>) q.executeList();
            resultado.addAll(queryResult);
            tx.commit();
        } catch (Exception e) {
            log.error("Error consultando alojamientos disponibles con servicios específicos: " + e.getMessage());
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            if (!((PersistenceManager) tx).isClosed()) {
                ((PersistenceManager) tx).close();
            }
            pm.close();
        }

        return resultado;
    }
    
    // NUEVO CRUD: PARA RESERVA COLECTIVA
    

    /* ****************************************************************
     *              Para la clase SQLReservaColectiva
     *****************************************************************/
    
    public ReservaColectiva adicionarReservaColectiva(int[] idOfertaAsociada)
    {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long idReservaColectiva = nextval ();
            long tups=0;
            for(int i=0; i<idOfertaAsociada.length;i++)
            {
            long tuplasInsertadas = sqlReservaColectiva.adicionarReservaColectiva(pm, idReservaColectiva, idOfertaAsociada[i]);
            tups++;
            }
            tx.commit();
    
            log.trace ("Inserción de reserva colectiva: " + idReservaColectiva + ": " + tups + " tuplas insertadas");
    
           return new ReservaColectiva(idReservaColectiva, idOfertaAsociada[idOfertaAsociada.length-1]);
        }
        catch (Exception e)
        {
            log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
    }
    
    public long eliminarReservaColectivaPorId(long id)
    {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasEliminadas = sqlReservaColectiva.eliminarReservaColectivaPorId(pm, id);
            tx.commit();
    
            log.trace("Eliminación de ReservaColectiva: " + id + ": " + tuplasEliminadas + " tuplas eliminadas");
    
            return tuplasEliminadas;
        }
        catch (Exception e)
        {
            log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
    }
    
    public List<ReservaColectiva> darReservaColectivaPorId(long idReservaColectiva)
    {
        return sqlReservaColectiva.darReservaColectivaPorId(pmf.getPersistenceManager(), idReservaColectiva);
    }
    
    
    public List<ReservaColectiva> darReservasColectivas()
    {
        return sqlReservaColectiva.darReservasColectivas(pmf.getPersistenceManager());
    }
    
    public long eliminarReservaPorIdOfertaAsociada(long idOferta)
    {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long tuplasEliminadas = sqlReserva.eliminarReservasPorIdOfertaAsociada(pm, idOferta);
            tx.commit();
    
            log.trace("Eliminación de reserva: " + ": " + tuplasEliminadas + " tuplas eliminadas");
    
            return tuplasEliminadas;
        }
        catch (Exception e)
        {
            log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
    }
    
    
    
    
    
    
    /* ***************************************************************************************
     *  Nuevos metodos para Satisfacer Requerimientos Funcionales Consulta para Iteracion 3  *
     ****************************************************************************************/
    
    
    /* Para el RFC7: Necesarios 3 métodos diferentes : FUNCIONA
     */
    
    public List<Object[]> analizarOperacionAlohandes(String modalidadTemporal, String tipoAlojamiento) {
        log.info("Analizando la operación de Alohandes según la modalidad temporal: " + modalidadTemporal + " y el tipo de alojamiento: " + tipoAlojamiento);
        List<Object[]> resultado = new ArrayList<>();

        List<Object[]> fechasMayorDemanda = calcularFechasMayorDemanda(modalidadTemporal, tipoAlojamiento);
        List<Object[]> fechasMayoresIngresos = calcularFechasMayoresIngresos(modalidadTemporal, tipoAlojamiento);
        List<Object[]> fechasMenorOcupacion = calcularFechasMenorOcupacion(modalidadTemporal, tipoAlojamiento);

        resultado.addAll(fechasMayorDemanda);
        resultado.addAll(fechasMayoresIngresos);
        resultado.addAll(fechasMenorOcupacion);

        log.info("Análisis realizado");
        return resultado;
    }

    
    
    //1
    
    public List<Object[]> calcularFechasMayorDemanda(String modalidadTemporal, String tipoAlojamiento) {
        log.info("Consultando las fechas de mayor demanda para alojamientos de tipo: " + tipoAlojamiento + " con modalidad temporal: " + modalidadTemporal);
        List<Object[]> resultado;
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        
        try {
            tx.begin();
            
            String sql = "SELECT res.FECHAINICIALRESERVA, COUNT(res.IDOFERTAASOCIADA) AS CANTIDAD_RESERVAS " +
                         "FROM RESERVA res " +
                         "JOIN OFERTAALOJAMIENTO oa ON res.IDOFERTAASOCIADA = oa.IDOFERTA " +
                         "JOIN INMUEBLE i ON oa.INMUEBLEASOCIADO = i.IDINMUEBLE " +
                         "WHERE i.CATEGORIA = ? AND oa.MODALIDADTEMPORAL = ? " +
                         "GROUP BY res.FECHAINICIALRESERVA " +
                         "ORDER BY CANTIDAD_RESERVAS DESC";
                       
            Query q = pm.newQuery(SQL, sql);
            q.setParameters(tipoAlojamiento, modalidadTemporal);
            resultado = (List<Object[]>) q.executeList();
            
            tx.commit();
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage(), e);
            resultado = null;
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }
        
        log.info("Consulta realizada");
        return resultado;
    }

    
    //2
    
    public List<Object[]> calcularFechasMayoresIngresos(String modalidadTemporal, String tipoAlojamiento) {
        log.info("Consultando las fechas de mayores ingresos para alojamientos de tipo: " + tipoAlojamiento + " con modalidad temporal: " + modalidadTemporal);
        List<Object[]> resultado;
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        
        try {
            tx.begin();
            
            String sql = "SELECT res.FECHAINICIALRESERVA, SUM((TRUNC(res.FECHAFINALRESERVA) - TRUNC(res.FECHAINICIALRESERVA)) * oa.PRECIOBASE) AS INGRESOS " +
                         "FROM RESERVA res " +
                         "JOIN OFERTAALOJAMIENTO oa ON res.IDOFERTAASOCIADA = oa.IDOFERTA " +
                         "JOIN INMUEBLE i ON oa.INMUEBLEASOCIADO = i.IDINMUEBLE " +
                         "WHERE i.CATEGORIA = ? AND oa.MODALIDADTEMPORAL = ? " +
                         "GROUP BY res.FECHAINICIALRESERVA " +
                         "ORDER BY INGRESOS DESC";
                       
            Query q = pm.newQuery(SQL, sql);
            q.setParameters(tipoAlojamiento, modalidadTemporal);
            resultado = (List<Object[]>) q.executeList();
            
            tx.commit();
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage(), e);
            resultado = null;
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }
        
        log.info("Consulta realizada");
        return resultado;
    }


        
        
       // 3

    public List<Object[]> calcularFechasMenorOcupacion(String modalidadTemporal, String tipoAlojamiento) {
        log.info("Consultando las fechas de menor ocupación para alojamientos de tipo: " + tipoAlojamiento + " con modalidad temporal: " + modalidadTemporal);
        List<Object[]> resultado;
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        
        try {
            tx.begin();
            
            String sql = "SELECT res.FECHAINICIALRESERVA, COUNT(res.IDOFERTAASOCIADA) AS CANTIDAD_RESERVAS " +
                         "FROM RESERVA res " +
                         "JOIN OFERTAALOJAMIENTO oa ON res.IDOFERTAASOCIADA = oa.IDOFERTA " +
                         "JOIN INMUEBLE i ON oa.INMUEBLEASOCIADO = i.IDINMUEBLE " +
                         "WHERE i.CATEGORIA = ? AND oa.MODALIDADTEMPORAL = ? " +
                         "GROUP BY res.FECHAINICIALRESERVA " +
                         "ORDER BY CANTIDAD_RESERVAS ASC";
                       
            Query q = pm.newQuery(SQL, sql);
            q.setParameters(tipoAlojamiento, modalidadTemporal);
            resultado = (List<Object[]>) q.executeList();
            
            tx.commit();
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage(), e);
            resultado = null;
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }
        
        log.info("Consulta realizada");
        return resultado;
    }

    
    
    
 // RFC8: Clientes frecuentes de un alojamiento (inmueble) dado, parametro: id del inmueble.
    
    public List<Object[]> encontrarClientesFrecuentes(long idInmueble) {
        log.info("Consultando los clientes frecuentes");
        List<Object[]> resultado;
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();

        try {
            tx.begin();

            String sql = "SELECT r.idClienteAsociado, COUNT(*) as numReservas, SUM(TRUNC(r.fechaFinalReserva) - TRUNC(r.fechaInicialReserva)) as totalNoches " +
                         "FROM Reserva r INNER JOIN OfertaAlojamiento o ON r.idOfertaAsociada = o.idOferta " +
                         "WHERE o.inmuebleAsociado = ? " +
                         "GROUP BY r.idClienteAsociado " +
                         "HAVING COUNT(*) >= 3 OR SUM(TRUNC(r.fechaFinalReserva) - TRUNC(r.fechaInicialReserva)) >= 15";

            Query q = pm.newQuery(SQL, sql);
            q.setParameters(idInmueble);
            resultado = (List<Object[]>) q.executeList();

            tx.commit();
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage(), e);
            resultado = null;
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }

        log.info("Consulta realizada");
        return resultado;
    }

    
    
    
// RFC9: Encontrar OFERTAS de alojamiento con poca demanda.
    
    
    public List<BigDecimal> encontrarOfertasPocaDemanda() {
        log.info("Consultando las ofertas de alojamiento con poca demanda");
        List<BigDecimal> resultado;
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();

        try {
            tx.begin();

            String sql = "SELECT DISTINCT o.idOferta " +
                         "FROM OfertaAlojamiento o " +
                         "WHERE o.idOferta NOT IN ( " +
                         "SELECT r.idOfertaAsociada " +
                         "FROM Reserva r " +
                         "JOIN Reserva r2 ON r.idOfertaAsociada = r2.idOfertaAsociada AND r.fechaInicialReserva != r2.fechaInicialReserva " +
                         "WHERE ABS(TRUNC(r.fechaInicialReserva) - TRUNC(r2.fechaInicialReserva)) <= 30)";

            Query q = pm.newQuery(SQL, sql);
            resultado = (List<BigDecimal>) q.executeList();

            tx.commit();
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage(), e);
            resultado = null;
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }

        log.info("Consulta realizada");
        return resultado;
    }

    
    
    /**************************************************************************
		    Metodos para el desarrollo de la ITERACION 4 del curso
    ***************************************************************************/
    
    /* 1. RFC10 - encontrarClientesPorOfertaRangoFechas */
    
    public List<Object[]> encontrarClientesPorOfertaRangoFechas(String idOfertaAsociads, java.util.Date fechaIniciall,java.util.Date fechaFinall,String orden) {
   	 PersistenceManager pm = pmf.getPersistenceManager();

   	 SimpleDateFormat f = new SimpleDateFormat("dd/MM/yy");
   	 String fechaInicial = f.format(fechaIniciall);
   	 String fechaFinal = f.format(fechaFinall);
   	 String sql ="";
   	 if (orden.equals(""))
   	 {
   		 sql = "select c.idcliente as id, c.vinculoconuniandes,c.usuario,c.clave, count(c.idcliente) as Reservas_Realizadas,i.categoria as categoria_inmueble, i.capacidad as capacidad_imueble,i.ubicacion as ubicación_imueble "
   	        		+ "from cliente c inner join reserva r on c.idcliente = r.idclienteasociado "
   	        		+ "inner join ofertaalojamiento o on r.idofertaasociada=o.idoferta "
   	        		+ "inner join inmueble i on i.idinmueble=o.inmuebleasociado "
   	        		+ "where r.idofertaasociada="+idOfertaAsociads+" and r.fechainicialreserva between to_date('"+fechaInicial+"','dd,mm,yy') and to_date('"+fechaFinal+"','dd,mm,yy') "
   	        		+ "group by c.idcliente, c.vinculoconuniandes,c.usuario,c.clave,i.categoria, i.capacidad,i.ubicacion ";
   	 }
   	 else
   	 {
   		 String[] ordenes=orden.split(",");
   		 String orderby="";
   		 for(String o:ordenes)
   		 {
   			 if(o.equals("idcliente"))
   			 {
   				 orderby+="c.idcliente,";
   			 }
   			 else if (o.equals("vinculo uniandes"))
   			 {
   				 orderby+="c.vinculoconuniandes,";
   			 }
   			 else if (o.equals("usuario"))
   			 {
   				 orderby+="c.usuario,";
   			 }
   			 else if (o.equals("clave"))
   			 {
   				 orderby+="c.clave,";
   			 }
   			 else if (o.equals("numero de reservas realizadas"))
   			 {
   				 orderby+="Reservas_Realizadas,";
   			 }
   			 else if (o.equals("categoria inmueble"))
   			 {
   				 orderby+="i.categoria,";
   			 }
   			 else if (o.equals("capacidad inmueble"))
   			 {
   				 orderby+="i.capacidad,";
   			 }
   			 else if (o.equals("ubicacion inmueble"))
   			 {
   				 orderby+="i.ubicacion,";
   			 }
   		 }
   		 String order=orderby.substring(0, orderby.length()-1);
   		 
   		 sql = "select c.idcliente as id, c.vinculoconuniandes,c.usuario,c.clave, count(c.idcliente) as Reservas_Realizadas,i.categoria as categoria_inmueble, i.capacidad as capacidad_imueble,i.ubicacion as ubicación_imueble "
	        		+ "from cliente c inner join reserva r on c.idcliente = r.idclienteasociado "
	        		+ "inner join ofertaalojamiento o on r.idofertaasociada=o.idoferta "
	        		+ "inner join inmueble i on i.idinmueble=o.inmuebleasociado "
	        		+ "where r.idofertaasociada="+idOfertaAsociads+" and r.fechainicialreserva between to_date('"+fechaInicial+"','dd,mm,yy') and to_date('"+fechaFinal+"','dd,mm,yy') "
	        		+ "group by c.idcliente, c.vinculoconuniandes,c.usuario,c.clave,i.categoria, i.capacidad,i.ubicacion "
	        		+"order by "+order;
   	 }
       

       Query q = pm.newQuery(SQL, sql);
       q.setResultClass(Object[].class);
       List<Object[]> consulta = (List<Object[]>) q.executeList();
       return consulta;
   }
   
   public List<Object[]> encontrarClientesPorOfertaRangoFechas1(String idCliente, String idOfertaAsociads, java.util.Date fechaIniciall,java.util.Date fechaFinall,String orden) {
  	 PersistenceManager pm = pmf.getPersistenceManager();

  	 SimpleDateFormat f = new SimpleDateFormat("dd/MM/yy");
  	 String fechaInicial = f.format(fechaIniciall);
  	 String fechaFinal = f.format(fechaFinall);
  	 String sql ="";
  	 
  		 sql = "select c.idcliente as id, c.vinculoconuniandes,c.usuario,c.clave, r.fechainicialreserva,r.fechafinalreserva,i.categoria as categoria_inmueble, i.capacidad as capacidad_imueble,i.ubicacion as ubicación_imueble "+
  				"from cliente c inner join reserva r on c.idcliente = r.idclienteasociado  "+
  				"inner join ofertaalojamiento o on r.idofertaasociada=o.idoferta "+
  				"inner join inmueble i on i.idinmueble=o.inmuebleasociado  "+
  				"where c.idcliente="+idCliente+" and r.idofertaasociada="+idOfertaAsociads+" and r.fechainicialreserva between to_date('"+fechaInicial+"','dd,mm,yy') and to_date('"+fechaFinal+"','dd,mm,yy')";

      Query q = pm.newQuery(SQL, sql);
      q.setResultClass(Object[].class);
      List<Object[]> consulta = (List<Object[]>) q.executeList();
      return consulta;
  }
   
   
   /* 2. RFC11: encontrarClientesPorOfertaRangoFechas */
   
   public List<Object[]> encontrarNoClientesPorOfertaRangoFechas(String idOfertaAsociads, java.util.Date fechaIniciall,java.util.Date fechaFinall,String orden) {
  	 PersistenceManager pm = pmf.getPersistenceManager();

  	 SimpleDateFormat f = new SimpleDateFormat("dd/MM/yy");
  	 String fechaInicial = f.format(fechaIniciall);
  	 String fechaFinal = f.format(fechaFinall);
  	 String sql ="";
  	 if (orden.equals(""))
  	 {
  		 sql = "select * "+
  				"from cliente c "+
  				"where c.idcliente not in "+
  				 "(select c.idcliente as id "
  	        		+ "from cliente c inner join reserva r on c.idcliente = r.idclienteasociado "
  	        		+ "inner join ofertaalojamiento o on r.idofertaasociada=o.idoferta "
  	        		+ "inner join inmueble i on i.idinmueble=o.inmuebleasociado "
  	        		+ "where r.idofertaasociada="+idOfertaAsociads+" and r.fechainicialreserva between to_date('"+fechaInicial+"','dd,mm,yy') and to_date('"+fechaFinal+"','dd,mm,yy'))"+
  	        		" fetch first 50 rows only";
  	 }
  	 else
  	 {
  		 String[] ordenes=orden.split(",");
  		 String orderby="";
  		 for(String o:ordenes)
  		 {
  			 if(o.equals("idcliente"))
  			 {
  				 orderby+="c.idcliente,";
  			 }
  			 else if (o.equals("vinculo uniandes"))
  			 {
  				 orderby+="c.vinculoconuniandes,";
  			 }
  			 else if (o.equals("usuario"))
  			 {
  				 orderby+="c.usuario,";
  			 }
  			 else if (o.equals("clave"))
  			 {
  				 orderby+="c.clave,";
  			 }
  			 else if (o.equals("numero de reservas realizadas"))
  			 {
  				 orderby+="Reservas_Realizadas,";
  			 }
  			 else if (o.equals("categoria inmueble"))
  			 {
  				 orderby+="i.categoria,";
  			 }
  			 else if (o.equals("capacidad inmueble"))
  			 {
  				 orderby+="i.capacidad,";
  			 }
  			 else if (o.equals("ubicacion inmueble"))
  			 {
  				 orderby+="i.ubicacion,";
  			 }
  		 }
  		 String order=orderby.substring(0, orderby.length()-1);
  		 
  		sql = "select * "+
  				"from cliente c "+
  				"where c.idcliente not in "+
  				 "(select c.idcliente "
  	        		+ "from cliente c inner join reserva r on c.idcliente = r.idclienteasociado "
  	        		+ "inner join ofertaalojamiento o on r.idofertaasociada=o.idoferta "
  	        		+ "inner join inmueble i on i.idinmueble=o.inmuebleasociado "
  	        		+ "where r.idofertaasociada="+idOfertaAsociads+" and r.fechainicialreserva between to_date('"+fechaInicial+"','dd,mm,yy') and to_date('"+fechaFinal+"','dd,mm,yy'))"+
  	        		" order by "+order+
  	        		" fetch first 50 rows only";
  	 }
      

      Query q = pm.newQuery(SQL, sql);
      q.setResultClass(Object[].class);
      List<Object[]> consulta = (List<Object[]>) q.executeList();
      return consulta;
  }
   
    
    
    // 3.  Obtencion de Credenciales
    
    public String verificarCredenciales(String usuario, String clave) {
        log.info("Verificando credenciales: usuario = " + usuario + "y clave =  "+ clave);
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();

        try {
            tx.begin();

            // Verificar si las credenciales corresponden a un operador
            Operador operador = sqlOperador.darOperadorPorCredenciales(pm, usuario, clave);
            if (operador != null) {
                log.info("Credenciales válidas para operador");
                return "Operador";
            }

            // Verificar si las credenciales corresponden a un cliente
            Cliente cliente = sqlCliente.darClientePorCredenciales(pm, usuario, clave);
            if (cliente != null) {
                log.info("Credenciales válidas para cliente");
                return "Cliente";
            }

            log.info("Credenciales inválidas, no existen en la base de datos.");
            return "Inexistente";

        } catch (Exception e) {
            log.error("Exception: " + e.getMessage(), e);
            return "Inexistente";
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }
    }
    
	/* 4. RFC12: CONSULTAR FUNCIONAMIENTO
	 * 
	Muestra, para cada semana del año, la oferta de alojamiento con más ocupación, la oferta de alojamiento con
	menos ocupación, los operadores más solicitados y los operadores menos solicitados. Las respuestas deben
	ser sustentadas por el detalle de las ofertas de alojamiento y operadores correspondientes. Esta operación es
	realizada el gerente general de AlohAndes.	
	*/
    
    // Primero, se define una nueva clase java para almacenar los resultados de esta consulta:
    
    // Esta nueva clase fue definida en el paquete de Persistencia.

    
    public ResultadosConsulta consultarFuncionamiento(int anio) {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        ResultadosConsulta resultados = new ResultadosConsulta();

        try {
            tx.begin();

            for (int mes = 1; mes <= 12; mes++) {
                resultados.addOfertaMaxOcupacion(encontrarOfertaMaxOcupacion(pm, mes, anio));
                resultados.addOfertaMinOcupacion(encontrarOfertaMinOcupacion(pm, mes, anio));
                resultados.addOperadoresMasSolicitados(encontrarOperadoresMasSolicitados(pm, mes, anio));
                resultados.addOperadoresMenosSolicitados(encontrarOperadoresMenosSolicitados(pm, mes, anio));
            }

            tx.commit();
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage(), e);
            resultados = null;
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }

        return resultados;
    }


    public Object[] encontrarOfertaMaxOcupacion(PersistenceManager pm, int mes, int anio) {
        String fechaInicial = "01-" + String.format("%02d", mes) + "-" + Integer.toString(anio);
        String fechaFinal = "28-" + String.format("%02d", mes) + "-" + Integer.toString(anio);

        String sql = "SELECT o.idOferta, COUNT(*) AS cantidadReservas " +
                     "FROM OfertaAlojamiento o " +
                     "JOIN Reserva r ON r.idOfertaAsociada = o.idOferta " +
                     "WHERE r.fechaInicialReserva BETWEEN TO_DATE('" + fechaInicial + "', 'DD-MM-YYYY') AND TO_DATE('" + fechaFinal + "', 'DD-MM-YYYY') " +
                     "GROUP BY o.idOferta " +
                     "ORDER BY COUNT(*) DESC " +
                     "FETCH FIRST ROW ONLY";

        Query q = pm.newQuery(SQL, sql);
        q.setResultClass(Object[].class);
        Object[] result = (Object[]) q.executeUnique();
        return result;
    }


    public Object[] encontrarOfertaMinOcupacion(PersistenceManager pm, int mes, int anio) {
        String fechaInicial = "01-" + String.format("%02d", mes) + "-" + Integer.toString(anio);
        String fechaFinal = "28-" + String.format("%02d", mes) + "-" + Integer.toString(anio);

        String sql = "SELECT * " +
                     "FROM ( " +
                     "  SELECT o.idOferta, COUNT(*) AS cantidadReservas " +
                     "  FROM OfertaAlojamiento o " +
                     "  JOIN Reserva r ON r.idOfertaAsociada = o.idOferta " +
                     "  WHERE r.fechaInicialReserva BETWEEN TO_DATE('" + fechaInicial + "', 'DD-MM-YYYY') AND TO_DATE('" + fechaFinal + "', 'DD-MM-YYYY') " +
                     "  GROUP BY o.idOferta " +
                     "  ORDER BY COUNT(*) ASC " +
                     ") " +
                     "WHERE ROWNUM = 1";

        Query q = pm.newQuery(SQL, sql);
        q.setResultClass(Object[].class);
        return (Object[]) q.executeUnique();
    }


    public List<Object[]> encontrarOperadoresMasSolicitados(PersistenceManager pm, int mes, int anio) {
    	String fechaInicial = "01-" + String.format("%02d", mes) + "-" + Integer.toString(anio);
    	String fechaFinal = "28-" + String.format("%02d", mes) + "-" + Integer.toString(anio);

        String sql = "SELECT op.idOperador, COUNT(*) AS cantidadReservas " +
                     "FROM Operador op " +
                     "JOIN Inmueble i ON op.idOperador = i.operadorAsociado " +
                     "JOIN OfertaAlojamiento ofa ON i.idInmueble = ofa.inmuebleAsociado " +
                     "JOIN Reserva r ON ofa.idOferta = r.idOfertaAsociada " +
                     "WHERE r.fechaInicialReserva BETWEEN TO_DATE('" + fechaInicial + "', 'DD-MM-YYYY') AND TO_DATE('" + fechaFinal + "', 'DD-MM-YYYY') " +
                     "GROUP BY op.idOperador " +
                     "ORDER BY COUNT(*) DESC " +
                     "FETCH FIRST 5 ROWS ONLY";

        Query q = pm.newQuery(SQL, sql);
        q.setResultClass(Object[].class);
        List<Object[]> operadores = (List<Object[]>) q.executeList();
        return operadores;
    }



    public List<Object[]> encontrarOperadoresMenosSolicitados(PersistenceManager pm, int mes, int anio) {
    	String fechaInicial = "01-" + String.format("%02d", mes) + "-" + Integer.toString(anio);
    	String fechaFinal = "28-" + String.format("%02d", mes) + "-" + Integer.toString(anio);


        String sql = "SELECT op.idOperador, COUNT(*) AS cantidadReservas " +
                     "FROM Operador op " +
                     "JOIN Inmueble i ON op.idOperador = i.operadorAsociado " +
                     "JOIN OfertaAlojamiento ofa ON i.idInmueble = ofa.inmuebleAsociado " +
                     "JOIN Reserva r ON ofa.idOferta = r.idOfertaAsociada " +
                     "WHERE r.fechaInicialReserva BETWEEN TO_DATE('" + fechaInicial + "', 'DD-MM-YYYY') AND TO_DATE('" + fechaFinal + "', 'DD-MM-YYYY') " +
                     "GROUP BY op.idOperador " +
                     "ORDER BY COUNT(*) ASC " +
                     "FETCH FIRST 5 ROWS ONLY";

        Query q = pm.newQuery(SQL, sql);
        q.setResultClass(Object[].class);
        List<Object[]> operadores = (List<Object[]>) q.executeList();
        return operadores;
    }

    
	/* 5. RFC13 - CONSULTAR LOS BUENOS CLIENTES
	 * 
		Los buenos clientes son de tres tipos: aquellos que hacen reservas en AlohAndes al menos una vez al mes,
		aquellos que siempre reservan alojamientos costosos (Entiéndase costoso, por ejemplo, como mayor a USD
		150 por noche) y aquellos que siempre reservan suites. Esta consulta retorna toda la información de dichos
		clientes, incluyendo la que justifica su calificación como buenos clientes. Esta operación es realizada
		únicamente por el gerente general de AlohAndes
		*/
    
    public List<Object[]> consultarBuenosClientes() {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();

        List<Object[]> buenosClientes = new ArrayList<>();

        try {
            tx.begin();

            // Query 1
            String sql1 = "SELECT c.*, " +
                          "(SELECT COUNT(*) FROM Reserva r WHERE c.idCliente = r.idClienteAsociado AND EXTRACT(YEAR FROM r.fechaReserva) = 2022) " +
                          "AS NumeroReservasAlAño " +
                          "FROM Cliente c " +
                          "WHERE (SELECT COUNT(DISTINCT EXTRACT(MONTH FROM r.fechaReserva)) " +
                          "FROM Reserva r WHERE c.idCliente = r.idClienteAsociado AND EXTRACT(YEAR FROM r.fechaReserva) = 2022) = 12";
            Query q1 = pm.newQuery(SQL, sql1);
            q1.setResultClass(Object[].class);
            List<Object[]> resultadoQuery1 = (List<Object[]>) q1.executeList();
            buenosClientes.addAll(resultadoQuery1);

            // Query 2
            String sql2 = "SELECT c.*, " +
                          "(SELECT COUNT(*) FROM Reserva r, OfertaAlojamiento o " +
                          "WHERE c.idCliente = r.idClienteAsociado AND r.idOfertaAsociada = o.idOferta " +
                          "AND o.precioBase >= 700000 AND EXTRACT(YEAR FROM r.fechaReserva) = 2022) " +
                          "AS Cantidad_Reservas_Costosas_AlAño " +
                          "FROM Cliente c " +
                          "WHERE (SELECT COUNT(DISTINCT EXTRACT(MONTH FROM r.fechaReserva)) " +
                          "FROM Reserva r WHERE c.idCliente = r.idClienteAsociado AND EXTRACT(YEAR FROM r.fechaReserva) = 2022) = 12";
            Query q2 = pm.newQuery(SQL, sql2);
            q2.setResultClass(Object[].class);
            List<Object[]> resultadoQuery2 = (List<Object[]>) q2.executeList();
            buenosClientes.addAll(resultadoQuery2);

            // Query 3
            String sql3 = "SELECT c.*, " +
                          "(SELECT COUNT(*) FROM Reserva r, OfertaAlojamiento o, Inmueble i " +
                          "WHERE c.idCliente = r.idClienteAsociado AND r.idOfertaAsociada = o.idOferta " +
                          "AND o.inmuebleAsociado = i.idInmueble AND i.Categoria = 'SUITE' " +
                          "AND EXTRACT(YEAR FROM r.fechaReserva) = 2022) " +
                          "AS Numero_Reservas_Suite_Al_Año " +
                          "FROM Cliente c " +
                          "WHERE (SELECT COUNT(DISTINCT EXTRACT(MONTH FROM r.fechaReserva)) " +
                          "FROM Reserva r WHERE c.idCliente = r.idClienteAsociado AND EXTRACT(YEAR FROM r.fechaReserva) = 2022) = 12";
            Query q3 = pm.newQuery(SQL, sql3);
            q3.setResultClass(Object[].class);
            List<Object[]> resultadoQuery3 = (List<Object[]>) q3.executeList();
            buenosClientes.addAll(resultadoQuery3);

            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            ex.printStackTrace();
        } finally {
            if (pm != null && !pm.isClosed()) {
                pm.close();
            }
        }

        return buenosClientes;
    }

    
    /* ***********************************************************************
     *  FIN de Métodos especificos para Resolver Requerimientos Funcionales  *
     *************************************************************************/ 
    

    //Metodo para limpiar las tabñas

    /**
     * Elimina todas las tuplas de todas las tablas de la base de datos de Alohandes
     * Crea y ejecuta las sentencias SQL para cada tabla de la base de datos - EL ORDEN ES IMPORTANTE 
     * @return Un arreglo con números que indican el número de tuplas borradas en las tablas, en el orden que fueron eliminadas
     */
    public long[] limpiarAlohandes()
    {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        try
        {
            tx.begin();
            long[] resp = sqlUtil.limpiarAlohandes(pm);
            tx.commit();
            log.info("Borrada la base de datos");
            return resp;
        }
        catch (Exception e)
        {
            log.error("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return new long[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
    }


}