package uniandes.isis2304.alohandes.negocio;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

import uniandes.isis2304.alohandes.persistencia.PersistenciaAlohandes;
import uniandes.isis2304.alohandes.persistencia.ResultadosConsulta;

/*
* Clase principal del negocio
* Sarisface todos los requerimientos funcionales del negocio
* 
* @author Alonso Hernandez, Cristian Acuna: @fai-aher, @cracsi
*/
public class Alohandes {
	
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(Alohandes.class.getName());
	
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia
	 */
	private PersistenciaAlohandes pp;
	
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * El constructor por defecto
	 */
	public Alohandes ()
	{
		pp = PersistenciaAlohandes.getInstance ();
	}
	
	
	/**
	 * El constructor que recibe los nombres de las tablas en tableConfig
	 * @param tableConfig - Objeto Json con los nombres de las tablas y de la unidad de persistencia
	 */
	public Alohandes (JsonObject tableConfig)
	{
		pp = PersistenciaAlohandes.getInstance (tableConfig);
	}
	
	
	/**
	 * Cierra la conexión con la base de datos (Unidad de persistencia)
	 */
	public void cerrarUnidadPersistencia ()
	{
		pp.cerrarUnidadPersistencia ();
	}
	
	
	
		/* ****************************************************************
		 * 			Métodos Propios por entidad del proyecto
		 *****************************************************************/
	
	
	
	/* ****************************************************************
	 * 				Métodos para manejar los CLIENTES
	 *****************************************************************/
	
	
    public long actualizarCliente(long idCliente, String vinculoUniandes, String usuario, String clave) {
        log.info("Actualizando Cliente con id: " + idCliente);
        long cliente = pp.actualizarCliente(idCliente, vinculoUniandes, usuario, clave);
        log.info("Actualizando Cliente: " + cliente);
        return cliente;
    }
    
    public long actualizarUsuarioCiente(long idCliente, String usuario) {
        log.info("Actualizando Cliente con id: " + idCliente);
        long cliente = pp.actualizarUsuarioCliente(idCliente, usuario);
        log.info("Actualizando usuario del Cliente: " + cliente);
        return cliente;
    }
    
	// En una adición, el id se le asigna en la clase de PersistenciaAlohandes.
    public Cliente adicionarCliente(String vinculoUniandes, String usuario, String clave) {
        log.info("Adicionando Cliente...");
        Cliente cliente = pp.adicionarCliente(vinculoUniandes, usuario, clave);
        log.info("Adicionando Cliente: " + cliente);
        return cliente;
    }

    public long eliminarClientePorId(long idCliente) {
        log.info("Eliminando Cliente por id: " + idCliente);
        long resp = pp.eliminarClientePorId(idCliente);
        log.info("Eliminando Cliente por id: " + resp + " tuplas eliminadas");
        return resp;
    }

    public Cliente darClientePorId(long idCliente) {
        log.info("Consultando Cliente por id: " + idCliente);
        Cliente cliente = pp.darClientePorId(idCliente);
        log.info("Consultando Cliente por id: " + cliente);
        return cliente;
    }

    public List<VOCliente> darClientes() {
        log.info("Consultando Clientes");
        List<VOCliente> clientes = pp.darClientes();
        log.info("Consultando Clientes: " + clientes.size() + " existentes");
        return clientes;
    }
    
    public List<Cliente> darClientesPorVinculoConUniandes(String vinculoUniandes) {
        log.info("Consultando Clientes con vínculo con Uniandes: " + vinculoUniandes);
        List<Cliente> clientes = pp.darClientesPorVinculoConUniandes(vinculoUniandes);
        log.info("Consultando Clientes con vínculo con Uniandes: " + clientes.size() + " existentes");
        return clientes;
    }

    public List<Reserva> darReservasPorCliente(long idCliente) {
        log.info("Consultando Reservas del Cliente: " + idCliente);
        List<Reserva> reservas = pp.darReservasPorCliente(idCliente);
        log.info("Consultando Reservas del Cliente: " + reservas.size() + " existentes");
        return reservas;
    }

    public List<OfertaAlojamiento> darOfertasReservadasPorCliente(long idCliente) {
        log.info("Consultando Ofertas reservadas por el Cliente: " + idCliente);
        List<OfertaAlojamiento> ofertas = pp.darOfertasReservadasPorCliente(idCliente);
        log.info("Consultando Ofertas reservadas por el Cliente: " + ofertas.size() + " existentes");
        return ofertas;
    }

    public List<Cliente> darClientesPorRangoFechasReserva(Date fechaInicio, Date fechaFin) {
        log.info("Consultando Clientes con reservas entre " + fechaInicio + " y " + fechaFin);
        List<Cliente> clientes = pp.darClientesPorRangoFechasReserva(fechaInicio, fechaFin);
        log.info("Consultando Clientes con reservas entre las fechas: " + clientes.size() + " existentes");
        return clientes;
    }

    public List<Object[]> darClientesYNumeroReservas() {
        log.info("Consultando Clientes y número de reservas");
        List<Object[]> clientesYReservas = pp.darClientesYNumeroReservas();
        log.info("Consultando Clientes y número de reservas: " + clientesYReservas.size() + " existentes");
        return clientesYReservas;
    }

    public Cliente darClientePorUsuario(String usuario) {
        log.info("Consultando el Cliente que pertenece al usuario dado");
        Cliente cliente = pp.darClientePorUsuario(usuario);
        log.info("Consultando Cliente por usuario: " + cliente + " existentes");
        return cliente;
    }
    
 
    
    /* ****************************************************************
     *          Métodos para manejar las EMPRESAS DE ALOJAMIENTO
     *****************************************************************/

    public EmpresaAlojamiento adicionarEmpresaAlojamiento(String tipo, int horaApertura, int horaCierre) {
        log.info("Adicionando Empresa de Alojamiento: " );
        EmpresaAlojamiento empresaAlojamiento = pp.adicionarEmpresaAlojamiento(tipo, horaApertura, horaCierre);
        log.info("Adicionando Empresa de Alojamiento: " + empresaAlojamiento);
        return empresaAlojamiento;
    }

    public long eliminarEmpresaAlojamiento(long idEmpresaAlojamiento) {
        log.info("Eliminando Empresa de Alojamiento por id: " + idEmpresaAlojamiento);
        long resp = pp.eliminarEmpresaAlojamiento(idEmpresaAlojamiento);
        log.info("Eliminando Empresa de Alojamiento por id: " + resp + " tuplas eliminadas");
        return resp;
    }

    public EmpresaAlojamiento darEmpresaAlojamiento(long idEmpresaAlojamiento) {
        log.info("Consultando Empresa de Alojamiento por id: " + idEmpresaAlojamiento);
        EmpresaAlojamiento empresaAlojamiento = pp.darEmpresaAlojamiento(idEmpresaAlojamiento);
        log.info("Consultando Empresa de Alojamiento por id: " + empresaAlojamiento);
        return empresaAlojamiento;
    }

    public List<VOEmpresaAlojamiento> darEmpresasAlojamiento() {
        log.info("Consultando Empresas de Alojamiento");
        List<VOEmpresaAlojamiento> empresasAlojamiento = pp.darEmpresasAlojamiento();
        log.info("Consultando Empresas de Alojamiento: " + empresasAlojamiento.size() + " existentes");
        return empresasAlojamiento;
    }

    public long cambiarTipoEmpresa(long idEmpresaAlojamiento, String tipo) {
        log.info("Cambiando el tipo de la Empresa de Alojamiento con id: " + idEmpresaAlojamiento + " al tipo: " + tipo);
        long resp = pp.cambiarTipoEmpresa(idEmpresaAlojamiento, tipo);
        log.info("Cambiando el tipo de la Empresa de Alojamiento con id: " + idEmpresaAlojamiento + " al tipo: " + tipo + ". " + resp + " tuplas actualizadas");
        return resp;
    }

    public long cambiarHoraApertura(long idEmpresaAlojamiento, int horaApertura) {
        log.info("Cambiando la hora de apertura de la Empresa de Alojamiento con id: " + idEmpresaAlojamiento + " a la hora: " + horaApertura);
        long resp = pp.cambiarHoraApertura(idEmpresaAlojamiento, horaApertura);
        log.info("Cambiando la hora de apertura de la Empresa de Alojamiento con id: " + idEmpresaAlojamiento + " a la hora: " + horaApertura + ". " + resp + " tuplas actualizadas");
        return resp;
    }
    
    public long cambiarHoraCierre(long idEmpresaAlojamiento, int horaCierre) {
        log.info("Cambiando la hora de cierre de la Empresa de Alojamiento con id: " + idEmpresaAlojamiento + " a la hora: " + horaCierre);
        long resp = pp.cambiarHoraCierre(idEmpresaAlojamiento, horaCierre);
        log.info("Cambiando la hora de cierre de la Empresa de Alojamiento con id: " + idEmpresaAlojamiento + " a la hora: " + horaCierre + ". " + resp + " tuplas actualizadas");
        return resp;
    }


    /* ****************************************************************
     *          Métodos para manejar las HABITACIONES
     *****************************************************************/
    
    public Habitacion adicionarHabitacion(String tipo) {
        log.info("Adicionando Habitación de tipo: " + tipo);
        Habitacion habitacion = pp.adicionarHabitacion(tipo);
        log.info("Adicionando Habitación: " + habitacion);
        return habitacion;
    }

    public long eliminarHabitacionPorId(long idHabitacion) {
        log.info("Eliminando Habitación por id: " + idHabitacion);
        long resp = pp.eliminarHabitacionPorId(idHabitacion);
        log.info("Eliminando Habitación por id: " + resp + " tuplas eliminadas");
        return resp;
    }

    public Habitacion darHabitacionPorId(long idHabitacion) {
        log.info("Consultando Habitación por id: " + idHabitacion);
        Habitacion habitacion = pp.darHabitacionPorId(idHabitacion);
        log.info("Consultando Habitación por id: " + habitacion);
        return habitacion;
    }

    public List<Habitacion> darHabitaciones() {
        log.info("Consultando Habitaciones");
        List<Habitacion> habitaciones = pp.darHabitaciones();
        log.info("Consultando Habitaciones: " + habitaciones.size() + " existentes");
        return habitaciones;
    }

    public long cambiarTipoHabitacion(long idHabitacion, String tipoHabitacion) {
        log.info("Cambiando tipo de Habitación con id: " + idHabitacion + " al tipo: " + tipoHabitacion);
        long resp = pp.cambiarTipoHabitacion(idHabitacion, tipoHabitacion);
        log.info("Cambiando tipo de Habitación con id: " + idHabitacion + " al tipo: " + tipoHabitacion + ". " + resp + " tuplas actualizadas");
        return resp;
    }
    
    
    /* ****************************************************************
     *          Métodos para manejar los INMUEBLES
     *****************************************************************/
   
    public Inmueble adicionarInmueble(long idOperador, String categoria, int capacidad, String ubicacion, String menaje, int tamanoEnMtSq) {
        log.info("Adicionando Inmueble del operador con id: " + idOperador);
        Inmueble inmueble = pp.adicionarInmueble( idOperador, categoria, capacidad, ubicacion, menaje, tamanoEnMtSq);
        log.info("Adicionando Inmueble: " + inmueble);
        return inmueble;
    }

    public long eliminarInmueblePorId(long idInmueble) {
        log.info("Eliminando Inmueble por id: " + idInmueble);
        long resp = pp.eliminarInmueblePorId(idInmueble);
        log.info("Eliminando Inmueble por id: " + resp + " tuplas eliminadas");
        return resp;
    }

    public Inmueble darInmueblePorId(long idInmueble) {
        log.info("Consultando Inmueble por id: " + idInmueble);
        Inmueble inmueble = pp.darInmueblePorId(idInmueble);
        log.info("Consultando Inmueble por id: " + inmueble);
        return inmueble;
    }

    public List<Inmueble> darInmueblesPorOperadorAsociado(long idOperador) {
        log.info("Consultando Inmuebles por Operador Asociado: " + idOperador);
        List<Inmueble> inmuebles = pp.darInmueblesPorOperadorAsociado(idOperador);
        log.info("Consultando Inmuebles por Operador Asociado: " + inmuebles.size() + " existentes");
        return inmuebles;
    }

    public List<Inmueble> darInmueblesPorCategoria(String categoria) {
        log.info("Consultando Inmuebles por categoria: " + categoria);
        List<Inmueble> inmuebles = pp.darInmueblesPorCategoria(categoria);
        log.info("Consultando Inmuebles por categoria: " + inmuebles.size() + " existentes");
        return inmuebles;
    }

    public List<Inmueble> darInmueblesPorUbicacion(String ubicacion) {
        log.info("Consultando Inmuebles por ubicación: " + ubicacion);
        List<Inmueble> inmuebles = pp.darInmueblesPorUbicacion(ubicacion);
        log.info("Consultando Inmuebles por ubicación: " + inmuebles.size() + " existentes");
        return inmuebles;
    }

    public List<Inmueble> darInmueblesPorCapacidad(int capacidad) {
        log.info("Consultando Inmuebles por capacidad: " + capacidad);
        List<Inmueble> inmuebles = pp.darInmueblesPorCapacidad(capacidad);
        log.info("Consultando Inmuebles por capacidad: " + inmuebles.size() + " existentes");
        return inmuebles;
    }
    
    
    public List<Inmueble> darInmueblesPorMenaje(String menaje) {
        log.info("Consultando Inmuebles por menaje: " + menaje);
        List<Inmueble> inmuebles = pp.darInmueblesPorMenaje(menaje);
        log.info("Consultando Inmuebles por menaje: " + inmuebles.size() + " existentes");
        return inmuebles;
    }

    public List<Inmueble> darInmueblesPorTamanoEnMtSq(int tamanoEnMtSq) {
        log.info("Consultando Inmuebles por tamaño en metros cuadrados: " + tamanoEnMtSq);
        List<Inmueble> inmuebles = pp.darInmueblesPorTamanoEnMtSq(tamanoEnMtSq);
        log.info("Consultando Inmuebles por tamaño en metros cuadrados: " + inmuebles.size() + " existentes");
        return inmuebles;
    }

    public List<VOInmueble> darInmuebles() {
        log.info("Consultando Inmuebles");
        List<VOInmueble> inmuebles = pp.darInmuebles();
        log.info("Consultando Inmuebles: " + inmuebles.size() + " existentes");
        return inmuebles;
    }

    public long cambiarCategoriaInmueble(long idInmueble, String nuevaCategoria) {
        log.info("Cambiando la categoria del Inmueble: " + idInmueble + " a: " + nuevaCategoria);
        long resp = pp.cambiarCategoriaInmueble(idInmueble, nuevaCategoria);
        log.info("Cambiando la categoria del Inmueble: " + resp + " tuplas modificadas");
        return resp;
    }

    public long cambiarCapacidadInmueble(long idInmueble, int nuevaCapacidad) {
        log.info("Cambiando la capacidad del Inmueble: " + idInmueble + " a: " + nuevaCapacidad);
        long resp = pp.cambiarCapacidadInmueble(idInmueble, nuevaCapacidad);
        log.info("Cambiando la capacidad del Inmueble: " + resp + " tuplas modificadas");
        return resp;
    }

    public long cambiarUbicacionInmueble(long idInmueble, String nuevaUbicacion) {
        log.info("Cambiando la ubicación del Inmueble: " + idInmueble + " a: " + nuevaUbicacion);
        long resp = pp.cambiarUbicacionInmueble(idInmueble, nuevaUbicacion);
        log.info("Cambiando la ubicación del Inmueble: " + resp + " tuplas modificadas");
        return resp;
    }

    public long cambiarMenajeInmueble(long idInmueble, String nuevoMenaje) {
        log.info("Cambiando el menaje del Inmueble: " + idInmueble + " a: " + nuevoMenaje);
        long resp = pp.cambiarMenajeInmueble(idInmueble, nuevoMenaje);
        log.info("Cambiando el menaje del Inmueble: " + resp + " tuplas modificadas");
        return resp;
    }
    
    public long cambiarTamanoEnMtSqInmueble(long idInmueble, int nuevoTamanoEnMtSq) {
        log.info("Cambiando el tamaño en metros cuadrados del Inmueble: " + idInmueble + " a: " + nuevoTamanoEnMtSq);
        long resp = pp.cambiarTamanoEnMtSqInmueble(idInmueble, nuevoTamanoEnMtSq);
        log.info("Cambiando el tamaño en metros cuadrados del Inmueble: " + resp + " tuplas modificadas");
        return resp;
    }
   
	
   
    /* ****************************************************************
     *       Métodos para manejar las Ofertas de Alojamiento
     *****************************************************************/
	
    
    public OfertaAlojamiento adicionarOfertaAlojamiento(int precioBase, long inmuebleAsociado, boolean ofertaActiva, boolean ofertaDisponible, String modalidadTemporal) {
        log.info("Adicionando Oferta de alojamiento con precio base: " + precioBase);
        OfertaAlojamiento ofertaAlojamiento = pp.adicionarOfertaAlojamiento(precioBase, inmuebleAsociado, ofertaActiva, ofertaDisponible, modalidadTemporal);
        log.info("Adicionando Oferta de alojamiento: " + ofertaAlojamiento);
        return ofertaAlojamiento;
    }

    public long eliminarOfertaAlojamientoPorId(long idOferta) {
        log.info("Eliminando Oferta de alojamiento con id: " + idOferta);
        long resp = pp.eliminarOfertaAlojamientoPorId(idOferta);
        log.info("Eliminando Oferta de alojamiento: " + resp + " tuplas eliminadas");
        return resp;
    }

    public OfertaAlojamiento darOfertaAlojamientoPorId(long idOferta) {
        log.info("Buscando Oferta de alojamiento con id: " + idOferta);
        OfertaAlojamiento ofertaAlojamiento = pp.darOfertaAlojamientoPorId(idOferta);
        log.info("Buscando Oferta de alojamiento: " + ofertaAlojamiento);
        return ofertaAlojamiento;
    }

    public List<OfertaAlojamiento> darOfertasAlojamiento() {
        log.info("Consultando todas las Ofertas de alojamiento");
        List<OfertaAlojamiento> ofertasAlojamiento = pp.darOfertasAlojamiento();
        log.info("Consultando todas las Ofertas de alojamiento: " + ofertasAlojamiento.size() + " existentes");
        return ofertasAlojamiento;
    }

    public long cambiarPrecioBaseOferta(long idOferta, int nuevoPrecioBase) {
        log.info("Cambiando precio base de la Oferta de alojamiento con id: " + idOferta + " a: " + nuevoPrecioBase);
        long resp = pp.cambiarPrecioBaseOferta(idOferta, nuevoPrecioBase);
        log.info("Cambiando precio base de la Oferta de alojamiento: " + resp + " tuplas modificadas");
        return resp;
    }

    public long cambiarEstadoOferta(long idOferta, boolean nuevoEstado) {
        log.info("Cambiando estado de la Oferta de alojamiento con id: " + idOferta + " a: " + nuevoEstado);
        long resp = pp.cambiarEstadoOferta(idOferta, nuevoEstado);
        log.info("Cambiando estado de la Oferta de alojamiento: " + resp + " tuplas modificadas");
        return resp;
    }

    public long cambiarDisponibilidadOferta(long idOferta, int i) {
        log.info("Cambiando disponibilidad de la Oferta de alojamiento con id: " + idOferta + " a: " + i);
        long resp = pp.cambiarDisponibilidadOferta(idOferta, i);
        log.info("Cambiando disponibilidad de la oferta: " + resp + " tuplas modificadas.");
        return resp;
    }
    
    public long cambiarModalidadTemporalOferta(long idOferta, String nuevaModalidadTemporal) {
        log.info("Cambiando modalidad temporal de la Oferta de alojamiento con id: " + idOferta + " a: " + nuevaModalidadTemporal);
        long resp = pp.cambiarModalidadTemporalOferta(idOferta, nuevaModalidadTemporal);
        log.info("Cambiando modalidad temporal de la Oferta de alojamiento: " + resp + " tuplas modificadas");
        return resp;
    }

    public List<OfertaAlojamiento> darOfertasAlojamientoPorModalidadTemporal(String modalidadTemporal) {
        log.info("Consultando Ofertas de alojamiento por modalidad temporal: " + modalidadTemporal);
        List<OfertaAlojamiento> ofertasAlojamiento = pp.darOfertasAlojamientoPorModalidadTemporal(modalidadTemporal);
        log.info("Consultando Ofertas de alojamiento por modalidad temporal: " + ofertasAlojamiento.size() + " existentes");
        return ofertasAlojamiento;
    }

    public List<OfertaAlojamiento> darOfertasAlojamientoActivas() {
        log.info("Consultando Ofertas de alojamiento activas");
        List<OfertaAlojamiento> ofertasAlojamiento = pp.darOfertasAlojamientoActivas();
        log.info("Consultando Ofertas de alojamiento activas: " + ofertasAlojamiento.size() + " existentes");
        return ofertasAlojamiento;
    }

    public List<OfertaAlojamiento> darOfertasAlojamientoDisponibles() {
        log.info("Consultando Ofertas de alojamiento disponibles");
        List<OfertaAlojamiento> ofertasAlojamiento = pp.darOfertasAlojamientoDisponibles();
        log.info("Consultando Ofertas de alojamiento disponibles: " + ofertasAlojamiento.size() + " existentes");
        return ofertasAlojamiento;
    }
    
    
    
    /* ****************************************************************
     *       		Métodos para manejar los Operadores				  *
     *****************************************************************/
    
    public Operador adicionarOperador(String relacionConUniandes, String usuario, String clave) {
        log.info("Adicionando Operador con relación con Uniandes: " + relacionConUniandes + " y usuario: " + usuario);
        Operador operador = pp.adicionarOperador(relacionConUniandes, usuario, clave);
        log.info("Adicionando Operador: " + operador);
        return operador;
    }

    public long eliminarOperadorPorId(long idOperador) {
        log.info("Eliminando Operador por id: " + idOperador);
        long resp = pp.eliminarOperadorPorId(idOperador);
        log.info("Eliminando Operador por id: " + resp + " tuplas eliminadas");
        return resp;
    }

    public Operador darOperadorPorId(long idOperador) {
        log.info("Consultando Operador por id: " + idOperador);
        Operador operador = pp.darOperadorPorId(idOperador);
        log.info("Consultando Operador por id: " + operador);
        return operador;
    }

    public List<VOOperador> darOperadores() {
        log.info("Consultando Operadores");
        List<VOOperador> operadores = pp.darOperadores();
        log.info("Consultando Operadores: " + operadores.size() + " existentes");
        return operadores;
    }
    
    public Operador darOperadorPorUsuario(String usuario) {
        log.info("Consultando Operador por usuario unico.");
        Operador operador = pp.darOperadorPorUsuario(usuario);
        log.info("Consultando Operador que concuerda con el usuario dado: " + operador + " , existe!");
        return operador;
    }

    public long cambiarRelacionConUniandes(long idOperador, String nuevaRelacionConUniandes) {
        log.info("Cambiando relación con Uniandes del Operador con id: " + idOperador + " a: " + nuevaRelacionConUniandes);
        long resp = pp.cambiarRelacionConUniandes(idOperador, nuevaRelacionConUniandes);
        log.info("Cambiando relación con Uniandes del Operador: " + resp + " tuplas modificadas");
        return resp;
    }
    
    public long cambiarUsuarioOperador(long idOperador, String nuevoUsuario) {
        log.info("Cambiando el nombre de Usuario del Operador con id: " + idOperador + " a: " + nuevoUsuario);
        long resp = pp.cambiarUsuarioOperador(idOperador, nuevoUsuario);
        log.info("Cambiando el nombre de Usuario del Operador: " + resp + " tuplas modificadas");
        return resp;
    }

    public List<Operador> darOperadoresPersonaNatural() {
        log.info("Consultando Operadores de tipo Persona Natural");
        List<Operador> operadores = pp.darOperadoresPersonaNatural();
        log.info("Consultando Operadores de tipo Persona Natural: " + operadores.size() + " existentes");
        return operadores;
    }

    public List<Operador> darOperadoresEmpresaAlojamiento() {
        log.info("Consultando Operadores de tipo Empresa de Alojamiento");
        List<Operador> operadores = pp.darOperadoresEmpresaAlojamiento();
        log.info("Consultando Operadores de tipo Empresa de Alojamiento: " + operadores.size() + " existentes");
        return operadores;
    }
    
    
    /* ****************************************************************
     *        Métodos para manejar las Personas Naturales			  *
     *****************************************************************/
   
    public PersonaNatural adicionarPersonaNatural(boolean ofreceAlojamientoPorDias) {
        log.info("Adicionando Persona Natural con ofreceAlojamientoPorDias: " + ofreceAlojamientoPorDias);
        PersonaNatural personaNatural = pp.adicionarPersonaNatural(ofreceAlojamientoPorDias);
        log.info("Adicionando Persona Natural: " + personaNatural);
        return personaNatural;
    }

    public long eliminarPersonaNaturalPorId(long idOperador) {
        log.info("Eliminando Persona Natural por idOperador: " + idOperador);
        long resp = pp.eliminarPersonaNaturalPorId(idOperador);
        log.info("Eliminando Persona Natural por idOperador: " + resp + " tuplas eliminadas");
        return resp;
    }

    public PersonaNatural darPersonaNaturalPorId(long idOperador) {
        log.info("Consultando Persona Natural por idOperador: " + idOperador);
        PersonaNatural personaNatural = pp.darPersonaNaturalPorId(idOperador);
        log.info("Consultando Persona Natural por idOperador: " + personaNatural);
        return personaNatural;
    }

    public List<PersonaNatural> darPersonasNaturales() {
        log.info("Consultando Personas Naturales");
        List<PersonaNatural> personasNaturales = pp.darPersonasNaturales();
        log.info("Consultando Personas Naturales: " + personasNaturales.size() + " existentes");
        return personasNaturales;
    }

    public long cambiarOfreceAlojamientoPorDias(long idOperador, boolean nuevoOfreceAlojamientoPorDias) {
        log.info("Cambiando ofreceAlojamientoPorDias del Persona Natural con idOperador: " + idOperador + " a: " + nuevoOfreceAlojamientoPorDias);
        long resp = pp.cambiarOfreceAlojamientoPorDias(idOperador, nuevoOfreceAlojamientoPorDias);
        log.info("Cambiando ofreceAlojamientoPorDias del Persona Natural: " + resp + " tuplas modificadas");
        return resp;
    }
    
    
    
    /* ****************************************************************
     *        		Métodos para manejar las Reservas		          *
     *****************************************************************/
    
    public Reserva adicionarReserva(long idClienteAsociado, long idOfertaAsociada, Date fechaReserva, Date fechaInicialReserva, Date fechaFinalReserva, String promocionesActivas, Date fechaCancelacion) {
        log.info("Adicionando Reserva con idClienteAsociado: " + idClienteAsociado + " e idOfertaAsociada: " + idOfertaAsociada);
        Reserva reserva = pp.adicionarReserva(idClienteAsociado, idOfertaAsociada, fechaReserva, fechaInicialReserva, fechaFinalReserva, promocionesActivas, fechaCancelacion);
        log.info("Adicionando Reserva: " + reserva);
        return reserva;
    }

    public Reserva darReservaPorId(long idClienteAsociado, long idOfertaAsociada, Date fechaReserva) {
        log.info("Consultando Reserva por idClienteAsociado: " + idClienteAsociado + " e idOfertaAsociada: " + idOfertaAsociada + " y fecha de reserva: " + fechaReserva);
        Reserva reserva = pp.darReservaPorId(idClienteAsociado, idOfertaAsociada, fechaReserva);
        log.info("Consultando Reserva: " + reserva);
        return reserva;
    }

    public List<ReservaColectiva> darReservaColectivaPorId(long idReservaColectiva) {
        log.info("Consultando Reservas Colectivas por idReservaColectiva: " + idReservaColectiva);
        List<ReservaColectiva> reservaColectiva = pp.darReservaColectivaPorId(idReservaColectiva);
        log.info("Consultando Reservas Colectivas por id: " + reservaColectiva.size()+ " reservas asociadas al idReservaColectiva");
        return reservaColectiva;
    }
    
    public List<VOReserva> darReservas() {
        log.info("Consultando Reservas");
        List<VOReserva> reservas = pp.darReservas();
        log.info("Consultando Reservas: " + reservas.size() + " existentes");
        return reservas;
    }

    public long actualizarFechaCancelacion(long idClienteAsociado, long idOfertaAsociada, Date fechaReserva, Date nuevaFechaCancelacion) {
        log.info("Actualizando fecha de cancelación de la reserva con idClienteAsociado: " + idClienteAsociado + " e idOfertaAsociada: " + idOfertaAsociada + " y fecha de reserva: " + fechaReserva + " a: " + nuevaFechaCancelacion);
        long resp = pp.actualizarFechaCancelacion(idClienteAsociado, idOfertaAsociada, fechaReserva, nuevaFechaCancelacion);
        log.info("Actualizando fecha de cancelación de la reserva: " + resp + " tuplas modificadas");
        return resp;
    }
    
    public List<Reserva> darReservasPorOferta(long idOferta) {
        log.info("Consultando Reservas por oferta con id: " + idOferta);
        List<Reserva> reservas = pp.darReservasPorOferta(idOferta);
        log.info("Consultando Reservas por oferta: " + reservas.size() + " existentes");
        return reservas;
    }

    public List<Object[]> darClientesYOfertasConReserva() {
        log.info("Consultando Clientes y OfertasAlojamiento con reserva");
        List<Object[]> resultados = pp.darClientesYOfertasConReserva();
        log.info("Consultando Clientes y OfertasAlojamiento con reserva: " + resultados.size() + " existentes");
        return resultados;
    }

    public List<Reserva> darReservasEntreFechas(Date fechaInicial, Date fechaFinal) {
        log.info("Consultando Reservas entre fechas: " + fechaInicial + " y " + fechaFinal);
        List<Reserva> reservas = pp.darReservasEntreFechas(fechaInicial, fechaFinal);
        log.info("Consultando Reservas entre fechas: " + reservas.size() + " existentes");
        return reservas;
    }  
    
    public ReservaColectiva adicionarReservaColectiva(int[] idOfertaAsociada) {
        log.info("Adicionando Oferta Colectiva con : idOfertaAsociada" + idOfertaAsociada);
        ReservaColectiva reservaColectiva = pp.adicionarReservaColectiva(idOfertaAsociada);
        log.info("Adicionando reservaColectiva: " + reservaColectiva);
        return reservaColectiva;
    }
    
    public long eliminarReservasPorIdOfertaAsociada(long idOfertaAsociada) {
        //log.info("Consultando Reserva por idClienteAsociado: " + idClienteAsociado + " e idOfertaAsociada: " + idOfertaAsociada + " y fecha de reserva: " + fechaReserva);
        long reserva = pp.eliminarReservaPorIdOfertaAsociada(idOfertaAsociada);
        //log.info("Consultando Reserva: " + reserva);
        return reserva;
    }
    
    public long eliminarReservaColectivaPorId(long idReservaColectiva) {
        log.info("Eliminando ReservaColectiva por id: " + idReservaColectiva);
        long resp = pp.eliminarReservaColectivaPorId(idReservaColectiva);
        log.info("Eliminando Reserva Colectiva por id: " + resp + " tuplas eliminadas");
        return resp;
    }
    
    
    /* ****************************************************************
     *        		Métodos para manejar los Servicios		          *
     *****************************************************************/
    
    public long adicionarServicio(String nombre, String descripcion, int horaApertura, int horaCierre, int costoAdicional) {
        log.info("Adicionando Servicio: " + nombre);
        Servicio servicio = pp.adicionarServicio(nombre, descripcion, horaApertura, horaCierre, costoAdicional);
        log.info("Servicio adicionado: " + servicio.getIdServicio());
        return servicio.getIdServicio();
    }

    public long eliminarServicioPorId(long idServicio) {
        log.info("Eliminando Servicio por id: " + idServicio);
        long resp = pp.eliminarServicioPorId(idServicio);
        log.info("Servicio eliminado: " + resp + " tuplas eliminadas");
        return resp;
    }

    public Servicio darServicioPorId(long idServicio) {
        log.info("Dando Servicio por id: " + idServicio);
        Servicio servicio = pp.darServicioPorId(idServicio);
        log.info("Dando Servicio: " + servicio);
        return servicio;
    }

    public List<Servicio> darServicios() {
        log.info("Consultando Servicios");
        List<Servicio> servicios = pp.darServicios();
        log.info("Consultando Servicios: " + servicios.size() + " existentes");
        return servicios;
    }

    public long cambiarNombreServicio(long idServicio, String nombre) {
        log.info("Cambiando nombre del Servicio por id: " + idServicio);
        long cambios = pp.cambiarNombreServicio(idServicio, nombre);
        log.info("Servicio actualizado: " + cambios + " tuplas actualizadas");
        return cambios;
    }

    public long cambiarDescripcionServicio(long idServicio, String descripcion) {
        log.info("Cambiando descripción del Servicio por id: " + idServicio);
        long cambios = pp.cambiarDescripcionServicio(idServicio, descripcion);
        log.info("Servicio actualizado: " + cambios + " tuplas actualizadas");
        return cambios;
    }

    public long cambiarHoraAperturaServicio(long idServicio, int horaApertura) {
        log.info("Cambiando hora de apertura del Servicio por id: " + idServicio);
        long cambios = pp.cambiarHoraAperturaServicio(idServicio, horaApertura);
        log.info("Servicio actualizado: " + cambios + " tuplas actualizadas");
        return cambios;
    }

    public long cambiarHoraCierreServicio(long idServicio, int horaCierre) {
        log.info("Cambiando hora de cierre del Servicio por id: " + idServicio);
        long cambios = pp.cambiarHoraCierreServicio(idServicio, horaCierre);
        log.info("Servicio actualizado: " + cambios + " tuplas actualizadas");
        return cambios;
    }

    public long cambiarCostoAdicionalServicio(long idServicio, int costoAdicional) {
        log.info("Cambiando costo adicional del Servicio por id: " + idServicio);
        long cambios = pp.cambiarCostoAdicionalServicio(idServicio, costoAdicional);
        log.info("Servicio actualizado: " + cambios + " tuplas actualizadas");
        return cambios;
    }
    
    public List<Servicio> darServiciosPorNombre(String nombre) {
        log.info("Consultando Servicios por nombre: " + nombre);
        List<Servicio> servicios = pp.darServiciosPorNombre(nombre);
        log.info("Consultando Servicios por nombre: " + servicios.size() + " encontrados");
        return servicios;
    }

    public List<Servicio> darServiciosPorRangoHorario(int horaInicio, int horaFin) {
        log.info("Consultando Servicios por rango horario");
        List<Servicio> servicios = pp.darServiciosPorRangoHorario(horaInicio, horaFin);
        log.info("Consultando Servicios por rango horario: " + servicios.size() + " encontrados");
        return servicios;
    }

    public List<Servicio> darServiciosPorCostoAdicional(int costoAdicional) {
        log.info("Consultando Servicios por costo adicional igual a " + costoAdicional);
        List<Servicio> servicios = pp.darServiciosPorCostoAdicional(costoAdicional);
        log.info("Consultando Servicios por costo adicional: " + servicios.size() + " encontrados");
        return servicios;
    }

    public List<Servicio> darServiciosPorOfertaAlojamiento(long idOfertaAlojamiento) {
        log.info("Consultando Servicios por Oferta de Alojamiento con id: " + idOfertaAlojamiento);
        List<Servicio> servicios = pp.darServiciosPorOfertaAlojamiento(idOfertaAlojamiento);
        log.info("Consultando Servicios por Oferta de Alojamiento: " + servicios.size() + " encontrados");
        return servicios;
    }
    
    
    
    /* ****************************************************************
     *        Métodos para manejar los Servicios Por Oferta	          *
     *****************************************************************/
    
    public long adicionarServicioPorOferta(long idOfertaAlojamiento, long idServicioOfrecido) {
        log.info("Adicionando servicio por oferta: " + idServicioOfrecido + " a la oferta de alojamiento con id: " + idOfertaAlojamiento);
        ServiciosPorOferta servicioPorOferta = pp.adicionarServicioPorOferta(idOfertaAlojamiento, idServicioOfrecido);
        long adicionado = servicioPorOferta.getIdServicioOfrecido();
        log.info("Servicio por oferta adicionado, el id del servicio asociado es : " + adicionado);
        return adicionado;
    }

    public long eliminarServicioPorOferta(long idOfertaAlojamiento, long idServicioOfrecido) {
        log.info("Eliminando servicio por oferta: " + idServicioOfrecido + " de la oferta de alojamiento con id: " + idOfertaAlojamiento);
        long eliminado = pp.eliminarServicioPorOferta(idOfertaAlojamiento, idServicioOfrecido);
        log.info("Servicio por oferta eliminado: " + eliminado);
        return eliminado;
    }

    public List<ServiciosPorOferta> darServiciosPorOferta() {
        log.info("Consultando todos los servicios por oferta");
        List<ServiciosPorOferta> serviciosPorOferta = pp.darServiciosPorOferta();
        log.info("Consultando servicios por oferta: " + serviciosPorOferta.size() + " encontrados");
        return serviciosPorOferta;
    }

    public List<ServiciosPorOferta> darServiciosPorIdOfertaAlojamiento(long idOfertaAlojamiento) {
        log.info("Consultando servicios por oferta de alojamiento con id: " + idOfertaAlojamiento);
        List<ServiciosPorOferta> serviciosPorOferta = pp.darServiciosPorIdOfertaAlojamiento(idOfertaAlojamiento);
        log.info("Consultando servicios por oferta de alojamiento: " + serviciosPorOferta.size() + " encontrados");
        return serviciosPorOferta;
    }

    public List<ServiciosPorOferta> darServiciosPorIdServicioOfrecido(long idServicioOfrecido) {
        log.info("Consultando servicios por id de servicio ofrecido: " + idServicioOfrecido);
        List<ServiciosPorOferta> serviciosPorOferta = pp.darServiciosPorIdServicioOfrecido(idServicioOfrecido);
        log.info("Consultando servicios por id de servicio ofrecido: " + serviciosPorOferta.size() + " encontrados");
        return serviciosPorOferta;
    }
    
    
    
    /* ****************************************************************
     *       		 Métodos para manejar las Viviendas               *
     *****************************************************************/
    
    
    public long adicionarVivienda(long idInmueble, String tipoVivienda, int numeroHabitaciones) {
        log.info("Adicionando Vivienda con id: " + idInmueble);
        Vivienda vivienda = pp.adicionarVivienda(idInmueble, tipoVivienda, numeroHabitaciones);
        long adicionado = vivienda.getIdInmueble();
        log.info("Vivienda adicionada con id: " + adicionado);
        return adicionado;
    }

    public long eliminarViviendaPorId(long idInmueble) {
        log.info("Eliminando Vivienda con id: " + idInmueble);
        long eliminado = pp.eliminarViviendaPorId(idInmueble);
        log.info("Vivienda eliminada: " + eliminado);
        return eliminado;
    }

    public Vivienda darViviendaPorId(long idInmueble) {
        log.info("Consultando Vivienda con id: " + idInmueble);
        Vivienda vivienda = pp.darViviendaPorId(idInmueble);
        log.info("Vivienda consultada: " + vivienda);
        return vivienda;
    }

    public List<Vivienda> darViviendas() {
        log.info("Consultando todas las Viviendas");
        List<Vivienda> viviendas = pp.darViviendas();
        log.info("Consultando Viviendas: " + viviendas.size() + " encontradas");
        return viviendas;
    }

    public long cambiarTipoVivienda(long idInmueble, String tipoVivienda) {
        log.info("Cambiando tipo de Vivienda con id: " + idInmueble + " a: " + tipoVivienda);
        long cambiado = pp.cambiarTipoVivienda(idInmueble, tipoVivienda);
        log.info("Tipo de Vivienda cambiado: " + cambiado);
        return cambiado;
    }

    public long cambiarNumeroHabitaciones(long idInmueble, int numeroHabitaciones) {
        log.info("Cambiando número de habitaciones de la Vivienda con id: " + idInmueble + " a: " + numeroHabitaciones);
        long cambiado = pp.cambiarNumeroHabitaciones(idInmueble, numeroHabitaciones);
        log.info("Número de habitaciones cambiado: " + cambiado);
        return cambiado;
    }
    
    
    
    
	
	
    /* ****************************************************************
     *  Métodos especificos para Resolver Requerimientos Funcionales  *
     *****************************************************************/
    
    // RF4 y RF5: Creación y borrado de reservas
    
    public Reserva crearReserva(long idClienteAsociado, long idOfertaAsociada, Date fechaReserva, Date fechaInicialReserva, Date fechaFinalReserva, String promocionesActivas, Date fechaCancelacion) {
        log.info("Creando reserva para el cliente con id: " + idClienteAsociado + ", oferta con id: "
        		+ idOfertaAsociada + ", fecha de reserva: " + fechaReserva + ", fecha inicial de la reserva: "
        		+ fechaInicialReserva + ", fecha final de reserva: " + fechaFinalReserva +
        		", con las siguiente promociones activas: " + promocionesActivas + " y con fecha de cancelacion: " + fechaCancelacion + " .");
        
        Reserva reservaCreada = pp.adicionarReserva(idClienteAsociado, idOfertaAsociada, fechaReserva, fechaInicialReserva, fechaFinalReserva, promocionesActivas, fechaCancelacion);
        long [] idsReservaCreada = new long [2];
        idsReservaCreada[0] = reservaCreada.getIdClienteAsociado();
        idsReservaCreada[1] = reservaCreada.getIdOfertaAsociada();
        log.info("Reserva creada con id de Cliente: " + idsReservaCreada[0] + " y con id de Oferta de Alojamiento: " + idsReservaCreada[1]);
        log.info("Esta oferta cuenta con la siguiente informacion: \n" + "Fecha de Reserva: " + fechaReserva + "\n"
        		+ "Fecha Inicial de la Reserva: " + fechaInicialReserva + "\n"
        		+ "Fecha Final de la Reserva: " + fechaFinalReserva + "\n"
        		+ "Promociones Activas: " + promocionesActivas + "\n"
        		+ "Fecha de Cancelacion (Si no hay, sigue activa) " + fechaCancelacion +".\n");
        return reservaCreada;
    }

    public long eliminarReserva(long idCliente, long idOferta, Date fechaReserva) {
        log.info("Eliminando reserva con id de Cliente: " + idCliente + ", id de OfertaAlojamiento: " + idOferta + " y fecha de reserva: " + fechaReserva);
        long reservaEliminada = pp.eliminarReserva(idCliente, idOferta, fechaReserva);
        log.info("Reserva eliminada: " + reservaEliminada);
        return reservaEliminada;
    } 
    
    // RF6: Retirar oferta de alojamiento
    
    public long retirarOfertaAlojamiento(long idOferta) {
        log.info("Retirando oferta de alojamiento con id: " + idOferta);
        List<Reserva> reservasPorOferta = pp.darReservasPorOferta(idOferta);
        if (reservasPorOferta.isEmpty()) {
            long ofertaEliminada = pp.eliminarOfertaAlojamientoPorId(idOferta);
            log.info("Oferta de alojamiento retirada, esa oferta tenia el id: " + ofertaEliminada);
            return ofertaEliminada;
        } else {
            log.info("No se puede retirar la oferta de alojamiento, existen reservas asociadas.");
            return 0;
        }
    }
    
    // Requerimientos de Consulta
    
    // RFC1: Mostrar el dinero recibido por cada proveedor de alojamiento durante el año actual y el
    // año corrido
    
    // El año corrido es tomado como el año inmediatamente anterior.
    
    public List<Object[]> dineroRecibidoPorProveedor(int anioActual, int anioPasado) {
        log.info("Consultando el dinero recibido por cada proveedor de alojamiento");
        List<Object[]> resultado = pp.dineroRecibidoPorProveedor(anioActual, anioPasado);
        log.info("Consulta realizada");
        return resultado;
    }
    
    /* RFC2: 20 ofertas más populares
    
    public List<Object> ofertasMasPopulares() {
        log.info("Consultando las 20 ofertas más populares");
        List<Object> resultado = pp.ofertasMasPopulares();
        log.info("Consulta realizada");
        return resultado;
    } */
    
    // RFC3: Mostrar el índice de ocupación de cada una de las ofertas de alojamiento registradas
    
    public List<Object[]> indiceOcupacion(Date fechaInicio, Date fechaFin) {
        log.info("Consultando el índice de ocupación de las ofertas de alojamiento");
        List<Object[]> resultado = pp.indiceOcupacion(fechaInicio, fechaFin);
        log.info("Consulta realizada");
        return resultado;
    }
    
    // RFC4: Mostrar los alojamientos disponibles en un rango de fechas, que cumplen con un conjunto
    // de requerimientos de dotación o servicios. por ejemplo, cocineta, tv cable, internet, sala.

    
    public List<OfertaAlojamiento> alojamientosDisponiblesConServicios(Date fechaInicio, Date fechaFin, List<String> servicios) {
        log.info("Consultando alojamientos disponibles con servicios específicos");
        List<OfertaAlojamiento> resultado = pp.alojamientosDisponiblesConServicios(fechaInicio, fechaFin, servicios);
        log.info("Consulta realizada");
        return resultado;
    }
	
    
    
    
    
    /* ***************************************************************************************
     *  Nuevos metodos para Satisfacer Requerimientos Funcionales Consulta para Iteracion 3  *
     ****************************************************************************************/
    
    //RFC7
   
    
    public List<Object[]> analizarOperacionAlohandes(String modalidadTemporal, String tipoAlojamiento) {
        log.info("Analizando la operación de Alohandes según la modalidad temporal: " + modalidadTemporal + " y el tipo de alojamiento: " + tipoAlojamiento);
        List<Object[]> resultado = pp.analizarOperacionAlohandes(modalidadTemporal, tipoAlojamiento);
        log.info("Análisis realizado");
        return resultado;
    }

    
    //RFC8
    public List<Object[]> encontrarClientesFrecuentes(long idInmueble) {
        log.info("Consultando los clientes frecuentes para el inmueble con id " + idInmueble);
        List<Object[]> resultado = pp.encontrarClientesFrecuentes(idInmueble);
        log.info("Consulta realizada");
        return resultado;
    }

    
    
    //RFC9
    public List<BigDecimal> encontrarOfertasPocaDemanda() {
        log.info("Consultando las ofertas de alojamiento con poca demanda");
        List<BigDecimal> resultado = pp.encontrarOfertasPocaDemanda();
        log.info("Consulta realizada");
        return resultado;
    }
    
    
    
    /**************************************************************************
     			Metodos para el desarrollo de la ITERACION 4 del curso
     ***************************************************************************/

	// 1.  Obtencion de Credenciales
    
    public String verificarCredenciales(String usuario, String clave) {
        log.info("Verificando credenciales: usuario: " + usuario + ", clave: " + clave);
        return pp.verificarCredenciales(usuario, clave);
    }

	/* 2. RFC12: CONSULTAR FUNCIONAMIENTO
	 * 
	Muestra, para cada semana del año, la oferta de alojamiento con más ocupación, la oferta de alojamiento con
	menos ocupación, los operadores más solicitados y los operadores menos solicitados. Las respuestas deben
	ser sustentadas por el detalle de las ofertas de alojamiento y operadores correspondientes. Esta operación es
	realizada el gerente general de AlohAndes.	
	*/
    
    public ResultadosConsulta procesarResultadosConsulta(int anio) {
        return pp.consultarFuncionamiento(anio);
    }
    
    
	/* 3. RFC13 - CONSULTAR LOS BUENOS CLIENTES
	 * 
		Los buenos clientes son de tres tipos: aquellos que hacen reservas en AlohAndes al menos una vez al mes,
		aquellos que siempre reservan alojamientos costosos (Entiéndase costoso, por ejemplo, como mayor a USD
		150 por noche) y aquellos que siempre reservan suites. Esta consulta retorna toda la información de dichos
		clientes, incluyendo la que justifica su calificación como buenos clientes. Esta operación es realizada
		únicamente por el gerente general de AlohAndes
		*/
    
    public List<Object[]> consultarBuenosClientes() {
        return pp.consultarBuenosClientes();
    }
    
    
    
    /* ****************************************************************
						INICIO
	 *****************************************************************/
  
    
    public List<Object[]> encontrarClientesPorOfertaRangoFechas(String idOfertaAsociads, java.util.Date fechaInicial,java.util.Date fechaFinal,String orden) {
    	log.info("Buscando usuarios de oferta con id: " + idOfertaAsociads );
       List<Object[]> resultado = pp.encontrarClientesPorOfertaRangoFechas(idOfertaAsociads, fechaInicial,fechaFinal,orden);
       
       return resultado;
   }
    
    public List<Object[]> encontrarClientesPorOfertaRangoFechas1(String idCliente,String idOfertaAsociads, java.util.Date fechaInicial,java.util.Date fechaFinal,String orden) {
    	log.info("Buscando usuarios de oferta con id: " + idOfertaAsociads );
       List<Object[]> resultado = pp.encontrarClientesPorOfertaRangoFechas1(idCliente,idOfertaAsociads, fechaInicial,fechaFinal,orden);
       
       return resultado;
   }
    
    public List<Object[]> encontrarNoClientesPorOfertaRangoFechas(String idOfertaAsociads, java.util.Date fechaInicial,java.util.Date fechaFinal,String orden) {
    	log.info("Buscando usuarios de oferta con id: " + idOfertaAsociads );
       List<Object[]> resultado = pp.encontrarNoClientesPorOfertaRangoFechas(idOfertaAsociads, fechaInicial,fechaFinal,orden);
       
       return resultado;
   }
    
    
    
    
    /* ****************************************************************
	 * 					FUIN*
	 *****************************************************************/

    

    
    
    
    
	
	/* ****************************************************************
	 * 					Métodos para administración					  *
	 *****************************************************************/

	/**
	 * Elimina todas las tuplas de todas las tablas de la base de datos de Parranderos
	 * @return Un arreglo con 7 números que indican el número de tuplas borradas en las tablas GUSTAN, SIRVEN, VISITAN, BEBIDA,
	 * TIPOBEBIDA, BEBEDOR y BAR, respectivamente
	 */
	public long [] limpiarAlohandes ()
	{
        log.info ("Limpiando la BD de Alohandes");
        long [] borrrados = pp.limpiarAlohandes();	
        log.info ("Limpiando la BD de Alohandes: Listo!");
        return borrrados;
	}
	
	
	
	
	

}
