/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Curso: isis2304 - Sistemas Transaccionales
 * Proyecto: Parranderos Uniandes
 * @version 1.0
 * @author Germán Bravo
 * Julio de 2018
 * 
 * Revisado por: Claudia Jiménez, Christian Ariza
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */


package uniandes.isis2304.alohandes.interfazApp;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import oracle.sql.DATE;

import java.sql.Date;
import java.text.SimpleDateFormat;

import uniandes.isis2304.alohandes.negocio.*;
import uniandes.isis2304.alohandes.persistencia.ResultadosConsulta;

/**
 * Clase principal de la interfaz
 * 
 * Hecho por Alonso Hernandez Tavera (f.hernandezt, @fai-aher en GitHub) y Cristian Acuna
 * 
 * @author Germán Bravo
 */
@SuppressWarnings("serial")

public class InterfazAlohandesApp extends JFrame implements ActionListener
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(InterfazAlohandesApp.class.getName());
	
	/**o) 
	 * Ruta al archivo de configuración de la interfaz
	 */
	private static final String CONFIG_INTERFAZ_GERENTE = "./src/main/resources/config/interfaceConfigApp.json"; 
	
	/* Se define la configuracion de la interfaz que se muestra
	 * en el caso de un operador de la plataforma ALOHANDES.
	 */
	private static final String CONFIG_INTERFAZ_OPERADOR = "./src/main/resources/config/operadorInterfaceConfig.json"; 
	
	/* Se define la configuracion de la interfaz que se muestra
	 * en el caso de un cliente de la plataforma ALOHANDES.
	 */
	private static final String CONFIG_INTERFAZ_CLIENTE = "./src/main/resources/config/clienteInterfaceConfig.json"; 

	
	/**
	 * Ruta al archivo de configuración de los nombres de tablas de la base de datos
	 */
	private static final String CONFIG_TABLAS = "./src/main/resources/config/TablasBD_A.json"; 
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
    /**
     * Objeto JSON con los nombres de las tablas de la base de datos que se quieren utilizar
     */
    private JsonObject tableConfig;
    
    /**
     * Asociación a la clase principal del negocio.
     */
    private Alohandes alohandes;
    
    
    
    /* ****************************************************************
	 * 			Atributos de interfaz
	 *****************************************************************/
    /**
     * Objeto JSON con la configuración de interfaz de la app.
     */
    private JsonObject guiConfig;
    
    /**
     * Panel de despliegue de interacción para los requerimientos
     */
    private PanelDatos panelDatos;
    
    /**
     * Menú de la aplicación
     */
    private JMenuBar menuBar;
    
    private static final String ADMINISTRADOR =  "ADMINISTRADOR";
 
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
    /**
     * Construye la ventana principal de la aplicación. <br>
     * <b>post:</b> Todos los componentes de la interfaz fueron inicializados.
     */
    public InterfazAlohandesApp( )
    {
        tableConfig = openConfig ("Tablas BD", CONFIG_TABLAS);
        alohandes = new Alohandes (tableConfig);
        
        // Mostrar el formulario de inicio de sesión
        iniciarInterfazLoginForm();
        
    }
    
    
    // Iniciar Interfaz del GERENTE
    
    private void initializeAdminInterface() {
    	
    	this.setVisible(true);
    	
    	// Carga la configuración de la interfaz desde un archivo JSON
        guiConfig = openConfig ("Interfaz", CONFIG_INTERFAZ_GERENTE);
    	
        // Configura la apariencia del frame que contiene la interfaz gráfica
        configurarFrame();
    	
        if (guiConfig != null) 	   
        {
     	   crearMenu( guiConfig.getAsJsonArray("menuBar") );
        }
        
    	String path = guiConfig.get("bannerPath").getAsString();
        panelDatos = new PanelDatos ( );

        // Carga de la imagen del banner
        ImageIcon bannerIcon = new ImageIcon(path);
		int anchoImagen = guiConfig.get("bannerWidth").getAsInt();
		int altoImagen = guiConfig.get("bannerHeight").getAsInt();
		
        Image bannerImage = bannerIcon.getImage().getScaledInstance(anchoImagen, altoImagen, Image.SCALE_SMOOTH);

        setLayout (new BorderLayout());
        add (new JLabel (new ImageIcon (bannerImage)), BorderLayout.NORTH );          
        add( panelDatos, BorderLayout.CENTER );   
    	
    }
    
    // Iniciar Interfaz del OPERADOR
    
    private void initializeOperatorInterface() {
    	
    	this.setVisible(true);
    	
    	// Carga la configuración de la interfaz desde un archivo JSON
        guiConfig = openConfig ("Interfaz", CONFIG_INTERFAZ_OPERADOR);
        
        // Configura la apariencia del frame que contiene la interfaz gráfica
        configurarFrame();
        
        if (guiConfig != null) 	   
        {
     	   crearMenu( guiConfig.getAsJsonArray("menuBar") );
        }
        
    	String path = guiConfig.get("bannerPath").getAsString();
        panelDatos = new PanelDatos ( );
        
        // Carga de la imagen del banner
        ImageIcon bannerIcon = new ImageIcon(path);
		int anchoImagen = guiConfig.get("bannerWidth").getAsInt();
		int altoImagen = guiConfig.get("bannerHeight").getAsInt();
		
        Image bannerImage = bannerIcon.getImage().getScaledInstance(anchoImagen, altoImagen, Image.SCALE_SMOOTH);

        setLayout (new BorderLayout());
        add (new JLabel (new ImageIcon (bannerImage)), BorderLayout.NORTH );          
        add( panelDatos, BorderLayout.CENTER );       
    	
    }
    
    
 // Iniciar Interfaz del CLIENTE
    
    private void initializeClientInterface() {
    	
    	this.setVisible(true);
    	
    	// Carga la configuración de la interfaz desde un archivo JSON
        guiConfig = openConfig ("Interfaz", CONFIG_INTERFAZ_CLIENTE);
        
        // Configura la apariencia del frame que contiene la interfaz gráfica
        configurarFrame();
        
        if (guiConfig != null) 	   
        {
     	   crearMenu( guiConfig.getAsJsonArray("menuBar") );
        }
        
    	String path = guiConfig.get("bannerPath").getAsString();
        panelDatos = new PanelDatos ( );

        // Carga de la imagen del banner
        ImageIcon bannerIcon = new ImageIcon(path);
		int anchoImagen = guiConfig.get("bannerWidth").getAsInt();
		int altoImagen = guiConfig.get("bannerHeight").getAsInt();
		
        Image bannerImage = bannerIcon.getImage().getScaledInstance(anchoImagen, altoImagen, Image.SCALE_SMOOTH);

        setLayout (new BorderLayout());
        add (new JLabel (new ImageIcon (bannerImage)), BorderLayout.NORTH );          
        add( panelDatos, BorderLayout.CENTER );       
    	
    }
    

    
    
    /* ****************************************************************
	 * 			Métodos de configuración de la interfaz
	 *****************************************************************/
    
    private JsonObject openConfig (String tipo, String archConfig)
    {
    	JsonObject config = null;
		try 
		{
			Gson gson = new Gson( );
			FileReader file = new FileReader (archConfig);
			JsonReader reader = new JsonReader ( file );
			config = gson.fromJson(reader, JsonObject.class);
			log.info ("Se encontró un archivo de configuración válido: " + tipo);
		} 
		catch (Exception e)
		{
			e.printStackTrace ();
			log.info ("NO se encontró un archivo de configuración válido");			
			JOptionPane.showMessageDialog(null, "No se encontró un archivo de configuración de interfaz válido: " + tipo, "Alohandes App", JOptionPane.ERROR_MESSAGE);
		}	
        return config;
    }
    
    /**
     * Metodo para configurar el frame que usa la aplicacion
     */
    private void configurarFrame(  )
    {
    	int alto = 0;
    	int ancho = 0;
    	String titulo = "";	
    	
    	if ( guiConfig == null )
    	{
    		log.info ( "Configuración por defecto" );			
			titulo = "Alohandes APP";
    	}
    	else
    	{
			log.info ( "Se aplica configuración indicada en el archivo de configuración" );
    		titulo = guiConfig.get("title").getAsString();
			alto= guiConfig.get("frameH").getAsInt();
			ancho = guiConfig.get("frameW").getAsInt();
    	}
    	
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLocationRelativeTo(rootPane);
        setLocation(420,40);
        setResizable( true );
        setBackground( Color.WHITE );

        setTitle( titulo );
		setSize ( ancho, alto);        
    }
    
    /**
     * Método para crear el menú de la aplicación con base em el objeto JSON leído
     * Genera una barra de menú y los menús con sus respectivas opciones
     * @param jsonMenu - Arreglo Json con los menùs deseados
     */
    private void crearMenu( JsonArray jsonMenu )
    {    	
    	// Creación de la barra de menús
        menuBar = new JMenuBar();       
        for (JsonElement men : jsonMenu)
        {
        	// Creación de cada uno de los menús
        	JsonObject jom = men.getAsJsonObject(); 

        	String menuTitle = jom.get("menuTitle").getAsString();        	
        	JsonArray opciones = jom.getAsJsonArray("options");
        	
        	JMenu menu = new JMenu( menuTitle);
        	
        	for (JsonElement op : opciones)
        	{       	
        		// Creación de cada una de las opciones del menú
        		JsonObject jo = op.getAsJsonObject(); 
        		String lb =   jo.get("label").getAsString();
        		String event = jo.get("event").getAsString();
        		
        		JMenuItem mItem = new JMenuItem( lb );
        		mItem.addActionListener( this );
        		mItem.setActionCommand(event);
        		
        		menu.add(mItem);
        	}       
        	menuBar.add( menu );
        }        
        setJMenuBar ( menuBar );	
    }
    
	/* ****************************************************************
   	 * 			CRUD de Operador
   	 *****************************************************************/
   	
   	public void adicionarOperador( )
       {
       	try 
       	{
       	    String relacionConUniandes = JOptionPane.showInputDialog (this, "Cual es la relacion con Uniandes?", "relacionConUniandes", JOptionPane.QUESTION_MESSAGE);
       	    String usuario = JOptionPane.showInputDialog (this, "Cual es el usuario del Operador?", "usuario", JOptionPane.QUESTION_MESSAGE);
       		String clave = JOptionPane.showInputDialog (this, "Cual es la clave del Operador?", "clave", JOptionPane.QUESTION_MESSAGE);
       		
       		if (relacionConUniandes != null && usuario != null && clave != null)
       		
       		{
           		VOOperador c = alohandes.adicionarOperador(relacionConUniandes, usuario, clave);
           		if (c == null)
           		{
           			throw new Exception ("No se pudo crear un operador ");
           		}
           		String resultado = "En adicionarOperador\n\n";
           		resultado += "Operador adicionado exitosamente: " + c;
       			resultado += "\n Operacion terminada";
       			panelDatos.actualizarInterfaz(resultado);
       		}
       		else
       		{
       			panelDatos.actualizarInterfaz("Operacion cancelada.");
       		}
   		} 
       	catch (Exception e) 
       	{
   			e.printStackTrace();
   			String resultado = generarMensajeError(e);
   			panelDatos.actualizarInterfaz(resultado);
   		}
       	
       }
   	
   	public void listarOperador( )
       {
       	try 
       	{
   			List <VOOperador> lista = alohandes.darOperadores();

   			String resultado = "En listarOperador";
   			resultado +=  "\n" + listarOperador(lista);
   			panelDatos.actualizarInterfaz(resultado);
   			resultado += "\n Operación terminada";
   		} 
       	catch (Exception e) 
       	{
   			e.printStackTrace();
   			String resultado = generarMensajeError(e);
   			panelDatos.actualizarInterfaz(resultado);
   		}
       }


       public void eliminarOperadorPorId( )
       {
       	try 
       	{
       		String idOperador = JOptionPane.showInputDialog (this, "Cual es la id del Operador a buscar?", "ELiminar un Operador por Id", JOptionPane.QUESTION_MESSAGE);
       		if (idOperador != null)
       		{
       			long id = Long.valueOf (idOperador);
       			long OperadoresEliminados = alohandes.eliminarOperadorPorId(id);

       			String resultado = "En eliminar Operadores\n\n";
       			resultado += OperadoresEliminados + " Operador eliminado\n";
       			resultado += "\n Operacion terminada.";
       			panelDatos.actualizarInterfaz(resultado);
       		}
       		else
       		{
       			panelDatos.actualizarInterfaz("Operacion cancelada.");
       		}
   		} 
       	catch (Exception e) 
       	{
   			e.printStackTrace();
   			String resultado = generarMensajeError(e);
   			panelDatos.actualizarInterfaz(resultado);
   		}
   }
       
       public void buscarOperadorPorId( )
       {
       	try 
       	{
       		String idOperador = JOptionPane.showInputDialog (this, "Cual es la id del Operador a buscar?", "Buscar Operador dada una Id", JOptionPane.QUESTION_MESSAGE);
       		if (idOperador!= null)
       		{
       			long id = Long.valueOf (idOperador);
       			VOOperador operador = alohandes.darOperadorPorId(id);

       			String resultado = "En Buscar Operador:\n\n";
       			resultado += operador;
       			resultado += "\n Operacion terminada.";
       			panelDatos.actualizarInterfaz(resultado);
       		}
       		else
       		{
       			panelDatos.actualizarInterfaz("Operacion cancelada.");
       		}
   		} 
       	catch (Exception e) 
       	{
   			e.printStackTrace();
   			String resultado = generarMensajeError(e);
   			panelDatos.actualizarInterfaz(resultado);
   		}
       }
    
       /* ****************************************************************
     	 * 			CRUD de Cliente
     	 *****************************************************************/

         public void adicionarCliente( )
         
       
         {
         	try 
         	{
         	
         		String vinculoConUniandes = JOptionPane.showInputDialog (this, "cual es el vinculo con Uniandes?", "vinculoUniandes", JOptionPane.QUESTION_MESSAGE);
         		String usuario = JOptionPane.showInputDialog (this, "cual sera el nombre de usuario del cliente?", "usuario", JOptionPane.QUESTION_MESSAGE);
         		String clave = JOptionPane.showInputDialog (this, "cual sera su clave?", "nombre", JOptionPane.QUESTION_MESSAGE);

         		if  (vinculoConUniandes != null && usuario != null && clave != null)
         		{
             		VOCliente c = alohandes.adicionarCliente(vinculoConUniandes, usuario, clave);
             		if (c == null)
             		{
             			throw new Exception ("No se pudo crear un Cliente");
             		}
             		String resultado = "En adicionarCliente: \n\n";
             		resultado += "Cliente adicionado exitosamente: " + c;
         			resultado += "\n Operacion terminada. ";
         			panelDatos.actualizarInterfaz(resultado);
         		}
         		else
         		{
         			panelDatos.actualizarInterfaz("Operacion cancelada.");
         		}
     		} 
         	catch (Exception e) 
         	{
     			e.printStackTrace();
     			String resultado = generarMensajeError(e);
     			panelDatos.actualizarInterfaz(resultado);
     		}
         }

         public void listarCliente( )
         {
         	try 
         	{
     			List <VOCliente> lista = alohandes.darClientes();

     			String resultado = "En el metodo listar Clientes: ";
     			resultado +=  "\n" + listarCliente(lista);
     			panelDatos.actualizarInterfaz(resultado);
     			resultado += "\n Operacion terminada.";
     		} 
         	catch (Exception e) 
         	{
     			e.printStackTrace();
     			String resultado = generarMensajeError(e);
     			panelDatos.actualizarInterfaz(resultado);
     		}
         }

         public void eliminarClientePorId( )
         {
         	try 
         	{
         		String idCliente = JOptionPane.showInputDialog (this, "Cual es el id del cliente?", "Borrar Cliente dado un Id", JOptionPane.QUESTION_MESSAGE);
         		if (idCliente != null)
         		{
         			long id = Long.valueOf (idCliente);
         			long ClientesEliminadas = alohandes.eliminarClientePorId(id);

         			String resultado = "En eliminar Clientes: \n\n";
         			resultado += ClientesEliminadas + " Clientes eliminados: \n";
         			resultado += "\n Operacion terminada.";
         			panelDatos.actualizarInterfaz(resultado);
         		}
         		else
         		{
         			panelDatos.actualizarInterfaz("Operacion cancelada. ");
         		}
     		} 
         	catch (Exception e) 
         	{
     			e.printStackTrace();
     			String resultado = generarMensajeError(e);
     			panelDatos.actualizarInterfaz(resultado);
     		}
         }

         public void buscarClientePorId( )
         {
         	try 
         	{
         		String idCliente = JOptionPane.showInputDialog (this, "Cual es el id del cliente?", "Buscar Cliente por Id", JOptionPane.QUESTION_MESSAGE);
         		if (idCliente!= null)
         		{
         			long id = Long.valueOf (idCliente);
         			VOCliente Cliente = alohandes.darClientePorId(id);

         			String resultado = "Resultado Buscar Cliente: \n\n";
         			resultado += Cliente;
         			resultado += "\n Operacion terminada. ";
         			panelDatos.actualizarInterfaz(resultado);
         		}
         		else
         		{
         			panelDatos.actualizarInterfaz("Operacion cancelada.");
         		}
     		} 
         	catch (Exception e) 
         	{
     			e.printStackTrace();
     			String resultado = generarMensajeError(e);
     			panelDatos.actualizarInterfaz(resultado);
     		}
         }
	
	/* ****************************************************************
	 * 			CRUD de Inmueble
	 *****************************************************************/ 

    public void adicionarInmueble( )
    {
    	try 
    	{
    		long operadorAsociado = Long.parseLong(JOptionPane.showInputDialog  (this, "cual es el id del Operador Asociado?", "idOperador", JOptionPane.QUESTION_MESSAGE));
    		String categoria = JOptionPane.showInputDialog (this, "Cual es su categoria?", "categoria", JOptionPane.QUESTION_MESSAGE);
    		int capacidad = Integer.parseInt(JOptionPane.showInputDialog (this, "Cual es la capacidad?", "capacidad", JOptionPane.QUESTION_MESSAGE));
    		String ubicacion = JOptionPane.showInputDialog (this, "cual es su ubicacion?", "ubicacion", JOptionPane.QUESTION_MESSAGE);
    		String menaje = JOptionPane.showInputDialog (this, "cual es el menaje incluido?", "menaje", JOptionPane.QUESTION_MESSAGE);
    		int tamanio = Integer.parseInt(JOptionPane.showInputDialog (this, "cual es su tamanio en Metros Cuadrados?", "tamanio en mt sq", JOptionPane.QUESTION_MESSAGE));
    		
    		if (operadorAsociado > 0 && categoria != null && capacidad > 0 && ubicacion != null && menaje != null && tamanio > 0)
    		{
        		VOInmueble c = alohandes.adicionarInmueble(operadorAsociado, categoria, capacidad, ubicacion, menaje, tamanio);
        		if (c == null)
        		{
        			throw new Exception ("No se pudo crear un inmueble");
        		}
        		String resultado = "En adicionar Inmueble\n\n";
        		resultado += "Inmueble adicionado exitosamente: " + c;
    			resultado += "\n Operación terminada";
    			panelDatos.actualizarInterfaz(resultado);
    		}
    		else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }
	

    public void listarInmueble( )
    {
    	try 
    	{
			List <VOInmueble> lista = alohandes.darInmuebles();

			String resultado = "En listar Inmuebles";
			resultado +=  "\n" + listarInmueble(lista);
			panelDatos.actualizarInterfaz(resultado);
			resultado += "\n Operación terminada";
		} 
    	catch (Exception e) 
    	{
			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }


    public void eliminarInmueblePorId( )
    {
    	try 
    	{
    		String idInmueble = JOptionPane.showInputDialog (this, "cual es el id del inmueble?", "Borrar Inmueble por Id", JOptionPane.QUESTION_MESSAGE);
    		if (idInmueble != null)
    		{
    			long id = Long.valueOf (idInmueble);
    			long alojamientosEliminados = alohandes.eliminarInmueblePorId(id);

    			String resultado = "Resultado eliminar Inmueble: \n\n";
    			resultado += alojamientosEliminados + " Inmuebles eliminados \n";
    			resultado += "\n Operación terminada. ";
    			panelDatos.actualizarInterfaz(resultado);
    		}
    		else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada.");
    		}
		} 
    	catch (Exception e) 
    	{
			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }


    public void buscarInmueblePorId( )
    {
    	try 
    	{
    		String idInmueble = JOptionPane.showInputDialog (this, "cual es el id del Inmueble?", "Buscar Inmueble por Id", JOptionPane.QUESTION_MESSAGE);
    		if (idInmueble != null)
    		{
    			long id = Long.valueOf (idInmueble);
    			VOInmueble inmueble = alohandes.darInmueblePorId(id);

    			String resultado = "Resultado de buscar inmueble por id: \n\n";
    			resultado += inmueble;
    			resultado += "\n Operación terminada";
    			panelDatos.actualizarInterfaz(resultado);
    		}
    		else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada.");
    		}
		} 
    	catch (Exception e) 
    	{
			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }
    
	/* ****************************************************************
	 * 			CRUD de RESERVA
	 * 
	 *     private long idClienteAsociado;
    private long idOfertaAsociada;
    private Date fechaReserva;
    private Date fechaInicialReserva;
    private Date fechaFinalReserva;
    private String promocionesActivas;
    private Date fechaCancelacion;
	 *****************************************************************/ 
    
    
    
    
    

    public void adicionarReserva( )
    {
    	try 
    	{
    		long idClienteAsociado = Long.parseLong(JOptionPane.showInputDialog  (this, "cual es el id del Cliente Asociado?", "idClienteAsociado", JOptionPane.QUESTION_MESSAGE));
    		
    		long idOfertaAsociada = Long.parseLong(JOptionPane.showInputDialog  (this, "cual es el id de la Oferta Asociada?", "idOfertaAsociada", JOptionPane.QUESTION_MESSAGE));
    		
    		String f1= (JOptionPane.showInputDialog (this, "Cual es la fecha en la que se hizo la Reserva? (en formato yyyy-mm-dd)", "fechaReserva", JOptionPane.QUESTION_MESSAGE));
    		Date fechaReserva = Date.valueOf(f1);
    		
    		String f2 = (JOptionPane.showInputDialog (this, "cual es la fecha inicial de la reserva? (en formato yyyy-mm-dd)", "fechaInicialReserva", JOptionPane.QUESTION_MESSAGE));
    		Date fechaInicialReserva = Date.valueOf(f2);
    		
    		String f3 = (JOptionPane.showInputDialog (this, "cual es la fecha final de la reserva? (en formato yyyy-mm-dd)", "fechaFinalReserva", JOptionPane.QUESTION_MESSAGE));
    		Date fechaFinalReserva = Date.valueOf(f3);
    		
    		String promocionesActivas = JOptionPane.showInputDialog (this, "Escribe las promociones activas separadas por comas", "promocionesActivas", JOptionPane.QUESTION_MESSAGE);
    		
    		Date fechaCancelacion = null;
    		String f4 = (JOptionPane.showInputDialog (this, "Si se canceló la Reserva, escriba la fecha en formato yyyy-mm-dd), si no, dejalo vacio.", "fechaCancelacion", JOptionPane.QUESTION_MESSAGE));
    		System.out.println("f4 es igual a : " + f4);
    		
    		try
    		{
    			fechaCancelacion = Date.valueOf(f4);
    		}
    		catch (Exception e)
    		{
    			fechaCancelacion = null;
    		};

    			
    		
    		if (idClienteAsociado > 0 && idOfertaAsociada > 0 && fechaReserva != null && fechaInicialReserva != null && fechaFinalReserva != null && promocionesActivas != null)
    		{
        		VOReserva c = alohandes.adicionarReserva(idClienteAsociado, idOfertaAsociada, fechaReserva, fechaInicialReserva, fechaFinalReserva, promocionesActivas, fechaCancelacion);
        		if (c == null)
        		{
        			throw new Exception ("No se pudo Registrar la Reserva");
        		}
        		String resultado = "En adicionar Reserva\n\n";
        		resultado += "Reserva adicionada exitosamente: " + c;
    			resultado += "\n Operación terminada";
    			panelDatos.actualizarInterfaz(resultado);
    		}
    		else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }
	

    public void listarReserva( )
    {
    	try 
    	{
			List <VOReserva> lista = alohandes.darReservas();

			String resultado = "En listar Inmuebles";
			resultado +=  "\n" + listarReservas(lista);
			panelDatos.actualizarInterfaz(resultado);
			resultado += "\n Operación terminada";
		} 
    	catch (Exception e) 
    	{
			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }


    public void eliminarReservaPorId( )
    {
    	try 
    	{
    		long idCliente = Long.parseLong(JOptionPane.showInputDialog (this, "cual es el id del ciente de la reserva?", "Borrar Reserva por Id", JOptionPane.QUESTION_MESSAGE));
    		long idOferta= Long.parseLong(JOptionPane.showInputDialog (this, "cual es el id de la oferta de la reserva?", "Borrar Reserva por Id", JOptionPane.QUESTION_MESSAGE));
    		String fecha = (JOptionPane.showInputDialog (this, "cual es el la fecha de la reserva? (formato yyyy-mm-dd)", "Borrar Reserva por Id", JOptionPane.QUESTION_MESSAGE));
    		Date fechaReserva = Date.valueOf(fecha);
    		
    		if (idCliente > 0 && idOferta > 0 && fechaReserva != null)
    		{
    			long reservasEliminadas = alohandes.eliminarReserva(idCliente, idOferta, fechaReserva);

    			String resultado = "Resultado eliminar Inmueble: \n\n";
    			resultado += reservasEliminadas + " Inmuebles eliminados \n";
    			resultado += "\n Operación terminada. ";
    			panelDatos.actualizarInterfaz(resultado);
    		}
    		else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada.");
    		}
		} 
    	catch (Exception e) 
    	{
			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }


    public void buscarReservaPorId( )
    {
    	try 
    	{
    		long idCliente = Long.parseLong(JOptionPane.showInputDialog (this, "cual es el id del ciente de la reserva?", "Borrar Reserva por Id", JOptionPane.QUESTION_MESSAGE));
    		long idOferta= Long.parseLong(JOptionPane.showInputDialog (this, "cual es el id de la oferta de la reserva?", "Borrar Reserva por Id", JOptionPane.QUESTION_MESSAGE));
    		String fecha = (JOptionPane.showInputDialog (this, "cual es el la fecha de la reserva? (formato yyyy-mm-dd)", "Borrar Reserva por Id", JOptionPane.QUESTION_MESSAGE));
    		Date fechaReserva = Date.valueOf(fecha);
    		
    		if (idCliente > 0 && idOferta > 0 && fechaReserva != null)
    		{
    			VOReserva reserva = alohandes.darReservaPorId(idCliente, idOferta, fechaReserva);

    			String resultado = "Resultado de buscar Reserva por id: \n\n";
    			resultado += reserva;
    			resultado += "\n Operación terminada";
    			panelDatos.actualizarInterfaz(resultado);
    		}
    		else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada.");
    		}
		} 
    	catch (Exception e) 
    	{
			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }
    
    
   
    
    
    
    
    
    
    
    
      
       /* ****************************************************************
       * 			Métodos Requerimientos
       *****************************************************************/
        		
            
                
                
                /* ****************************************************************
            	 * 			Métodos administrativos
            	 *****************************************************************/
            	/**
            	 * Muestra el log de Alohandes
            	 */
            	public void mostrarLogAlohandes ()
            	{
            		mostrarArchivo ("alohandes.log");
            	}
            	
            	/**
            	 * Muestra el log de datanucleus
            	 */
            	public void mostrarLogDatanuecleus ()
            	{
            		mostrarArchivo ("datanucleus.log");
            	}
            	
            	/**
            	 * Limpia el contenido del log de alohandes
            	 * Muestra en el panel de datos la traza de la ejecución
            	 */
            	public void limpiarLogAlohandes ()
            	{
            		// Ejecución de la operación y recolección de los resultados
            		boolean resp = limpiarArchivo ("alohandes.log");

            		// Generación de la cadena de caracteres con la traza de la ejecución de la demo
            		String resultado = "\n\n************ Limpiando el log de alohandes ************ \n";
            		resultado += "Archivo " + (resp ? "limpiado exitosamente" : "NO PUDO ser limpiado !!");
            		resultado += "\nLimpieza terminada";

            		panelDatos.actualizarInterfaz(resultado);
            	}
            	
            	/**
            	 * Limpia el contenido del log de datanucleus
            	 * Muestra en el panel de datos la traza de la ejecución
            	 */
            	public void limpiarLogDatanucleus ()
            	{
            		// Ejecución de la operación y recolección de los resultados
            		boolean resp = limpiarArchivo ("datanucleus.log");

            		// Generación de la cadena de caracteres con la traza de la ejecución de la demo
            		String resultado = "\n\n************ Limpiando el log de datanucleus ************ \n";
            		resultado += "Archivo " + (resp ? "limpiado exitosamente" : "NO PUDO ser limpiado !!");
            		resultado += "\nLimpieza terminada";

            		panelDatos.actualizarInterfaz(resultado);
            	}
            	
            	/**
            	 * Limpia todas las tuplas de todas las tablas de la base de datos de alohandes
            	 * Muestra en el panel de datos el número de tuplas eliminadas de cada tabla
            	 */
            	public void limpiarBD ()
            	{
            		try 
            		{
                		// Ejecución de la demo y recolección de los resultados
            			long eliminados [] = alohandes.limpiarAlohandes();
            			
            			// Generación de la cadena de caracteres con la traza de la ejecución de la demo
            			String resultado = "\n\n************* Limpiando la base de datos ************* \n";
            			resultado += eliminados [0] + " OPERADORES eliminados\n";
            			resultado += eliminados [1] + " ClienteS eliminadas\n";
            			resultado += eliminados [2] + " ALOJAMIENTOS eliminados\n";

            			resultado += "\nLimpieza terminada";
               
            			panelDatos.actualizarInterfaz(resultado);
            		} 
            		catch (Exception e) 
            		{
            			e.printStackTrace();
            			String resultado = generarMensajeError(e);
            			panelDatos.actualizarInterfaz(resultado);
            		}
            	}
            	
            	/**
            	 * Muestra la presentación general del proyecto
            	 */
            	public void mostrarPresentacionGeneral ()
            	{
            		mostrarArchivo ("data/00-ST-ParranderosJDO.pdf");
            	}
            	
            	/**
            	 * Muestra el modelo conceptual de Alohandes
            	 */
            	public void mostrarModeloConceptual ()
            	{
            		mostrarArchivo ("data/Modelo Conceptual Alohandes.pdf");
            	}
            	
            	/**
            	 * Muestra el esquema de la base de datos de Alohandes
            	 */
            	public void mostrarEsquemaBD ()
            	{
            		mostrarArchivo ("data/Esquema BD Alohandes.pdf");
            	}
            	
            	/**
            	 * Muestra el script de creación de la base de datos
            	 */
            	public void mostrarScriptBD ()
            	{
            		mostrarArchivo ("data/EsquemaAlohandes.sql");
            	}
            	
            	/**
            	 * Muestra la arquitectura de referencia para Alohandes
            	 */
            	public void mostrarArqRef ()
            	{
            		mostrarArchivo ("data/ArquitecturaReferencia.pdf");
            	}
            	
            	/**
            	 * Muestra la documentación Javadoc del proyectp
            	 */
            	public void mostrarJavadoc ()
            	{
            		mostrarArchivo ("doc/index.html");
            	}
            	
            	/**
                 * Muestra la información acerca del desarrollo de esta apicación
                 */
                public void acercaDe ()
                {
            		String resultado = "\n\n ************************************\n\n";
            		resultado += " * Universidad	de	los	Andes	(Bogotá	- Colombia)\n";
            		resultado += " * Departamento	de	Ingeniería	de	Sistemas	y	Computación\n";
            		resultado += " * Trabajo hecho por Alonso Hernandez y Cristian Acuna. ";

            		panelDatos.actualizarInterfaz(resultado);		
                }    
                
                
                
                
                
        /* *********************************************************************
        *Métodos privados para la presentación de resultados y otras operaciones
        ************************************************************************/
		/**
	     * Genera una cadena de caracteres con la lista de los operadores recibidos: una línea por cada operador.
	     * @param lista - La lista con los operadores.
	     * @return La cadena con una líea para cada operador
	     */
		private String listarOperador(List<VOOperador> lista) {
			
			String resp = "Los operadores existentes son:\n";
	    	int i = 1;
	        for (VOOperador tb : lista)
	        {
	        	resp += i++ + ". " + tb.toString() + "\n";
	        }
	        return resp;
		}
		/**
	     * Genera una cadena de caracteres con la lista de las Clientes recibidos: una línea por cada habitación de residencia.
	     * @param lista - La lista con las habitaciones de residencia.
	     * @return La cadena con una líea para cada habitación de residencia recibida
	     */
		private String listarCliente(List<VOCliente> lista) {
    		
			String resp = "Las Clientes existentes son:\n";
	    	int i = 1;
	        for (VOCliente tb : lista)
	        {
	        	resp += i++ + ". " + tb.toString() + "\n";
	        }
	        return resp;
    	}
		/**
	     * Genera una cadena de caracteres con la lista de los alojamientos recibidos: una línea por cada alojamiento.
	     * @param lista - La lista con las reservas
	     * @return La cadena con una líea para cada alojamiento recibido
	     */ 

		private String listarInmueble(List<VOInmueble> lista) {
		
			String resp = "Los alojamientos existentes son:\n";
		    int i = 1;
		       for (VOInmueble tb : lista)
		       {
		        resp += i++ + ". " + tb.toString() + "\n";
		       }
		       return resp;
		}
		
		private String listarReservas(List<VOReserva> lista) {
			
			String resp = "Los alojamientos existentes son:\n";
		    int i = 1;
		       for (VOReserva tb : lista)
		       {
		        resp += i++ + ". " + tb.toString() + "\n";
		       }
		       return resp;
		}
	

		/**
	     * Genera una cadena de caracteres con la descripción de la excepcion e, haciendo énfasis en las excepcionsde JDO
	     * @param e - La excepción recibida
	     * @return La descripción de la excepción, cuando es javax.jdo.JDODataStoreException, "" de lo contrario
	     */
		private String darDetalleException(Exception e) 
		{
			String resp = "";
			if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
			{
				JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
				return je.getNestedExceptions() [0].getMessage();
			}
			return resp;
		}

		/**
		 * Genera una cadena para indicar al usuario que hubo un error en la aplicación
		 * @param e - La excepción generada
		 * @return La cadena con la información de la excepción y detalles adicionales
		 */
		private String generarMensajeError(Exception e) 
		{
			String resultado = "************ Error en la ejecución\n";
			resultado += e.getLocalizedMessage() + ", " + darDetalleException(e);
			resultado += "\n\nRevise datanucleus.log y alohandes.log para más detalles";
			return resultado;
		}

		/**
		 * Limpia el contenido de un archivo dado su nombre
		 * @param nombreArchivo - El nombre del archivo que se quiere borrar
		 * @return true si se pudo limpiar
		 */
		private boolean limpiarArchivo(String nombreArchivo) 
		{
			BufferedWriter bw;
			try 
			{
				bw = new BufferedWriter(new FileWriter(new File (nombreArchivo)));
				bw.write ("");
				bw.close ();
				return true;
			} 
			catch (IOException e) 
			{
//				e.printStackTrace();
				return false;
			}
		}

		/**
		 * Abre el archivo dado como parámetro con la aplicación por defecto del sistema
		 * @param nombreArchivo - El nombre del archivo que se quiere mostrar
		 */
		private void mostrarArchivo (String nombreArchivo)
		{
			try
			{
				Desktop.getDesktop().open(new File(nombreArchivo));
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		/* ********************************************************
		 * 			Requerimientos Funcionales de modificación iteraación 3
		 **********************************************************/
		
		public void registrarReservaColectiva( )
	    {
	        	try 
	        	{
	        		
	        		String idClientesAsociados= (JOptionPane.showInputDialog (this, "Ingrese el id del cliente asociado por cada reserva que desee hacer debe ingresar un valor y separarlos con comas(,)", "idClientesAsociados", JOptionPane.QUESTION_MESSAGE));
	        		String[] idClientesAsociadosLista=idClientesAsociados.split(",");
	        		//System.out.println("idClientesAsociadosLista es igual a : " + idClientesAsociadosLista[0]+idClientesAsociadosLista[1]+idClientesAsociadosLista[2]);
	        		
	        		String idOfertasAsociadas= (JOptionPane.showInputDialog (this, "Ingrese el id de las Ofertas que desee realizar, por cada Ofertas debe debe ingresar un valor y separarlos con comas(,)", "idOfertasAsociadas", JOptionPane.QUESTION_MESSAGE));
	        		String[] idOfertasAsociadasLista=idOfertasAsociadas.split(",");
	        		
	        		String f1s= (JOptionPane.showInputDialog (this, "Ingrese las fechas en las que se realizan las reservas, por cada reserva debe debe ingresar un valor y separarlos con comas(,) y en formato (yyyy-mm-dd)", "fechasReservas", JOptionPane.QUESTION_MESSAGE));
	        		String[] f1sLista=f1s.split(",");
	        		//String f1= (JOptionPane.showInputDialog (this, "Cual es la fecha en la que se hizo la Reserva? (en formato yyyy-mm-dd)", "fechaReserva", JOptionPane.QUESTION_MESSAGE));
	        		//Date fechaReserva = Date.valueOf(f1);
	        		
	        		String f2s= (JOptionPane.showInputDialog (this, "Ingrese las fechas iniciales de las reservas, por cada reserva debe debe ingresar un valor y separarlos con comas(,) y en formato (yyyy-mm-dd)", "fechasInicialesReservas", JOptionPane.QUESTION_MESSAGE));
	        		String[] f2sLista=f2s.split(",");
	        		//String f2 = (JOptionPane.showInputDialog (this, "cual es la fecha inicial de la reserva? (en formato yyyy-mm-dd)", "fechaInicialReserva", JOptionPane.QUESTION_MESSAGE));
	        		// Date fechaInicialReserva = Date.valueOf(f2);
	        		
	        		String f3s= (JOptionPane.showInputDialog (this, "Ingrese las fechas finales de las reservas, por cada reserva debe debe ingresar un valor y separarlos con comas(,) y en formato (yyyy-mm-dd)", "fechasFinalesReservas", JOptionPane.QUESTION_MESSAGE));
	        		String[] f3sLista=f3s.split(",");
	        		//String f3 = (JOptionPane.showInputDialog (this, "cual es la fecha final de la reserva? (en formato yyyy-mm-dd)", "fechaFinalReserva", JOptionPane.QUESTION_MESSAGE));
	        		//Date fechaFinalReserva = Date.valueOf(f3);
	        		
	        		String promocionessActivas = JOptionPane.showInputDialog (this, "Escribe las promociones activas por cada reserva debe debe ingresar un valor y separarlos con comas(,)", "promocionesActivas", JOptionPane.QUESTION_MESSAGE);
	        		String[] promocionessActivasLista=promocionessActivas.split(",");
	        		
	        		//String f4s = (JOptionPane.showInputDialog (this, "Si se canceló la Reserva, escriba las fechas de cancelación (en formato yyyy-mm-dd) para cada reserva, si no, dejalo vacio y separe los valores con comas así sean vacíos.", "fechasCancelaciones", JOptionPane.QUESTION_MESSAGE));
	        		//String[] f4sLista=f4s.split(",");
	        		//System.out.println("idClientesAsociadosLista es igual a : " + idClientesAsociadosLista[0]+idClientesAsociadosLista[1]+idClientesAsociadosLista[2]);
	        		
	        		int nReservas=idClientesAsociadosLista.length;
	        		int[] idClientesAsociadosN=new int [nReservas];
	        		int[]  idOfertasAsociadasN=new int [nReservas];
	        		Date[]  f1sN=new Date [nReservas];
	        		Date[]  f2sN=new Date [nReservas];
	        		Date[]  f3sN=new Date [nReservas];
	        		//int[]  promocionessActivasN=new int [nReservas];
	        		Date[]  f4sN=new Date [nReservas];
	        		
	        		for(int i=0;i<nReservas;i++)
	    			{
	        			idClientesAsociadosN[i]=Integer.parseInt(idClientesAsociadosLista[i]);
	        			idOfertasAsociadasN[i]=Integer.parseInt(idOfertasAsociadasLista[i]);
	        			f1sN[i]=Date.valueOf(f1sLista[i]);
	        			f2sN[i]=Date.valueOf(f2sLista[i]);
	        			f3sN[i]=Date.valueOf(f3sLista[i]);
	        			//promocionessActivasN[i]=Integer.parseInt(promocionessActivasLista[i]);
	        			f4sN[i]=null;	
	    			}
	        		
	        		if ( idOfertasAsociadasLista.length==nReservas && f1sLista.length==nReservas && f2sLista.length==nReservas && f3sLista.length==nReservas && promocionessActivasLista.length==nReservas)
	        		{
	        			for(int i=0;i<nReservas;i++)
	        			{
	        				//System.out.println("1"+idReservasAsociadasLista[i]+ "2"+f1sLista[i] +"3"+f2sLista[i]+"4"+f3sLista[i]+"5"+promocionessActivasLista[i]+"6"+f4sLista[i]);
	        				
	        				if (idClientesAsociadosN[i] > 0 && idOfertasAsociadasN[i] > 0 && f1sN[i] != null && f2sN[i] != null && f3sN[i] != null && promocionessActivasLista[i] != null)
	                		{
	                    		
	        					VOReserva c = alohandes.adicionarReserva(idClientesAsociadosN[i], idOfertasAsociadasN[i], f1sN[i], f2sN[i], f3sN[i], promocionessActivasLista[i], null);
	                    		
	                    		
	                    		if (c == null)
	                    		{
	                    			throw new Exception ("No se pudo Registrar la Reserva");
	                    		}
	                    		String resultado = "En adicionar Reserva\n\n";
	                    		resultado += "Reserva adicionada exitosamente: " + c;
	                			resultado += "\n Operación terminada";
	                			panelDatos.actualizarInterfaz(resultado);
	                		}
	                		else
	                		{
	                			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
	                			
	                		}
	        			}
	        			System.out.println(idOfertasAsociadasN[0]+"FFFFFFFFFFFFFFFF");
	        			VOReservaColectiva b=alohandes.adicionarReservaColectiva(idOfertasAsociadasN);
	        			if (b == null)
	            		{
	            			throw new Exception ("No se pudo Registrar la Reserva Colectiva");
	            		}
	        			String resultado = "En adicionar Reserva colectiva\n\n";
	            		resultado += "Reserva adicionada exitosamente: " + b;
	        			resultado += "\n Operación terminada";
	        			panelDatos.actualizarInterfaz(resultado);
	        		}
	        		else
	        		{
	        			panelDatos.actualizarInterfaz("Datos ingresados incorrectamente");
	        		}
	        		
	        		
	    
	    		} 
	        	catch (Exception e) 
	        	{
	    			e.printStackTrace();
	    			String resultado = generarMensajeError(e);
	    			panelDatos.actualizarInterfaz(resultado);
	    		}
	    }
		
		
		
		public void cancelarReservaColectiva( )
	    {
	        	try 
	        	{
	        		
	        		long idReserva = Long.parseLong(JOptionPane.showInputDialog (this, "cual es el id de la reserva colectiva que desea cancelar?", "Borrar Reserva Colectiva por Id", JOptionPane.QUESTION_MESSAGE));
	        		
	        		
	        		List<ReservaColectiva> a=alohandes.darReservaColectivaPorId(idReserva);
	        		
	        		for(ReservaColectiva aa:a)
	        		{
	        		System.out.println(aa.getIdOfertaAsociada());
	        		System.out.println(aa.getIdReservaColectiva());
	        		long idOferta=aa.getIdOfertaAsociada();
	        		long reservasEliminadas = alohandes.eliminarReservasPorIdOfertaAsociada(idOferta);
	        		panelDatos.actualizarInterfaz("Reserva "+ aa +"eliminada");
	        		}
	        		alohandes.eliminarReservaColectivaPorId(idReserva);
	        		panelDatos.actualizarInterfaz("Reserva Colectiva"+ idReserva +"eliminada");
	    		} 
	        	catch (Exception e) 
	        	{
	    			e.printStackTrace();
	    			String resultado = generarMensajeError(e);
	    			panelDatos.actualizarInterfaz(resultado);
	    		}
	    }
		
		public void deshabilitarOferta()
	    {
	    	long idOferta = Long.parseLong(JOptionPane.showInputDialog (this, "cual es el id de la oferta que desea deshabilitar?", "rehabilitar oferta por Id", JOptionPane.QUESTION_MESSAGE));
	    	alohandes.cambiarDisponibilidadOferta(idOferta, 0);
	    	String respuesta="Oferta con código "+ idOferta +" deshabilitada\n";
	    	
	    	alohandes.eliminarReservasPorIdOfertaAsociada(idOferta);
			respuesta+="Se eliminaron las reservas de la oferta deshabilitada con id "+idOferta;
			/*
	    	List<Reserva> reservas=alohandes.darReservasPorOferta(idOferta);
	    	if(reservas.size() ==0)
	    	{
	    		respuesta += "La oferta con id "+ idOferta +" no tenía reservas asociadas\n";
	    		
	    	}
	    	else
	    	{
	    		List<OfertaAlojamiento> ofertasDisponibles=alohandes.darOfertasAlojamientoDisponibles();
	    		int reservasAsignadas=0;
	    		int iter=0;
	    		
	    		while (iter<reservas.size()||iter<ofertasDisponibles.size())
	    		{
	    			OfertaAlojamiento oferta=ofertasDisponibles.get(iter);
	    			Reserva res=reservas.get(iter);
	    			panelDatos.actualizarInterfaz(res.toString());
	    			alohandes.adicionarReserva(res.getIdClienteAsociado(), oferta.getIdOferta(), Date.valueOf("15/4/22"), res.getFechaInicialReserva(), Date.valueOf("5/9/20"), res.getPromocionesActivas(), res.getFechaCancelacion());
	    			respuesta+="se reubico la reserva con id " +res.getIdClienteAsociado()+ " a la oferta con id "+ oferta.getIdOferta()+"\n";
	    			iter++;
	    		}
	    		if(reservas.size()>ofertasDisponibles.size())
	    		{
	    			int noUbi=reservas.size()-ofertasDisponibles.size();
	    			respuesta+="no se pudieron reubicar " + noUbi+" reservas";
	    		}
	    		
	    		
	    	}*/
	    	panelDatos.actualizarInterfaz(respuesta);
	    }
		
		public void rehabilitarOferta()
	    {
	    	long idOferta = Long.parseLong(JOptionPane.showInputDialog (this, "cual es el id de la oferta que desea rehabilitar?", "rehabilitar oferta por Id", JOptionPane.QUESTION_MESSAGE));
	    	alohandes.cambiarDisponibilidadOferta(idOferta, 1);
	    	panelDatos.actualizarInterfaz("Oferta con código "+ idOferta +" rehabilitada");
	    }
		
		
		/* ********************************************************
		 * 			Requerimientos Funcionales de Consulta
		 **********************************************************/
		
	    // RFC1: Mostrar el dinero recibido por cada proveedor de alojamiento durante el año actual y el
	    // año corrido
	    
	    // El anio corrido es tomado como el año inmediatamente anterior.
	   
		
		public void dineroRecibidoPorProveedor(){


			JTextField actual = new JTextField("2023");
			JTextField pasado = new JTextField("2022");
			String message = "Por favor ingresa el anio actual y el anio pasado en valores enteros.";
			
			int dineroRecibido = JOptionPane.showOptionDialog(this, new Object[] {message, actual, pasado}, "Anios de busqueda", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null); 
			if (dineroRecibido == JOptionPane.OK_OPTION){
					int anioactual = Integer.parseInt(actual.getText());
					int aniopasado = Integer.parseInt(pasado.getText());
					
					List<Object[]> respuesta = alohandes.dineroRecibidoPorProveedor(anioactual, aniopasado);
					String mensaje = "Proveedor		Dinero Recibido";
					System.out.println(respuesta);
					for (Object[] tupla : respuesta){ 
							mensaje += "\n" + tupla[0] + "		$ " + tupla[1];
					}

					panelDatos.actualizarInterfaz(mensaje);
					}
			
					else{
						panelDatos.actualizarInterfaz("Operación cancelada.");
					}
				}
			
		
		/**
		 *  Requerimiento funcional  C2, muestra las 20 ofertas más populares
		 *  
		
		public void ofertasMasPopulares(){

			List<Object> respuesta = alohandes.ofertasMasPopulares();
					String mensaje = "id_OfertaAlojamiento";
					for (Object elemento : respuesta){
						mensaje += "\n" + elemento;
					}
					panelDatos.actualizarInterfaz(mensaje);
			} */
	
		
		
		
		
		
	    /* ***************************************************************************************
	     *  Nuevos metodos para Satisfacer Requerimientos Funcionales Consulta para Iteracion 3  *
	     ****************************************************************************************/
		
		// RFC7
		
		public void analizarOperacionAlohandes(){
		    // Crear los JComboBox para seleccionar la modalidad temporal y el tipo de alojamiento
		    JComboBox<String> modalidadTemporalOptions = new JComboBox<>(new String[]{"Mes", "Semana", "Semestre", "Bimestre"});
		    JComboBox<String> tipoAlojamientoOptions = new JComboBox<>(new String[]{"Premium", "Básico", "Económico", "Ejecutivo", "Doble"});
		    
		    // Crear el mensaje a mostrar
		    String message = "Por favor selecciona una modalidad temporal y un tipo de alojamiento:";
		    
		    // Crear el dialogo para seleccionar la modalidad temporal y el tipo de alojamiento
		    int option = JOptionPane.showOptionDialog(this, new Object[] {message, modalidadTemporalOptions, tipoAlojamientoOptions}, "Análisis de la Operación de Alohandes", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

		    // Si se seleccionó una opción, proceder con la consulta
		    if(option == JOptionPane.OK_OPTION){
		        List<Object[]> respuesta = alohandes.analizarOperacionAlohandes((String) modalidadTemporalOptions.getSelectedItem(), (String) tipoAlojamientoOptions.getSelectedItem());

		        String mensajeMayorDemanda = "Fechas de Mayor Demanda:\nFecha\t\t\tCantidad";
		        String mensajeMayoresIngresos = "\n\nFechas de Mayores Ingresos:\nFecha\t\t\tIngresos";
		        String mensajeMenorOcupacion = "\n\nFechas de Menor Ocupación:\nFecha\t\t\tCantidad";

		        // Aquí asumimos que cada tercio de la lista corresponde a cada uno de los tipos de fechas
		        int tercio = respuesta.size() / 3;

		        // Procesar la respuesta
		        for(int i = 0; i < respuesta.size(); i++) {
		            if(i < tercio) {
		                mensajeMayorDemanda += "\n" + respuesta.get(i)[0].toString() + "\t\t" + respuesta.get(i)[1].toString();
		            } else if(i < tercio * 2) {
		                mensajeMayoresIngresos += "\n" + respuesta.get(i)[0].toString() + "\t\t" + respuesta.get(i)[1].toString();
		            } else {
		                mensajeMenorOcupacion += "\n" + respuesta.get(i)[0].toString() + "\t\t" + respuesta.get(i)[1].toString();
		            }
		        }

		        // Mostrar el resultado
		        panelDatos.actualizarInterfaz(mensajeMayorDemanda + mensajeMayoresIngresos + mensajeMenorOcupacion);
		    }
		    else{
		        panelDatos.actualizarInterfaz("Operación cancelada.");
		    }
		}



	    
		//RFC8
		
		public void encontrarClientesFrecuentes() {
		    JTextField idInmuebleField = new JTextField("");
		    String message = "Por favor ingresa el ID del inmueble.";

		    int option = JOptionPane.showOptionDialog(this, new Object[] {message, idInmuebleField}, "Encontrar clientes frecuentes", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

		    if (option == JOptionPane.OK_OPTION) {
		        long idInmueble = Long.parseLong(idInmuebleField.getText());

		        List<Object[]> respuesta = alohandes.encontrarClientesFrecuentes(idInmueble);
		        String mensaje = "Cliente\tFrecuencia";
		        
		        for (Object[] tupla : respuesta) {
		            mensaje += "\n" + tupla[0] + "\t" + tupla[1];
		        }

		        panelDatos.actualizarInterfaz(mensaje);
		    } else {
		        panelDatos.actualizarInterfaz("Operación cancelada.");
		    }
		}

		// RFC9
		
		public void encontrarOfertasPocaDemanda() {
		    int option = JOptionPane.showOptionDialog(this, "¿Deseas encontrar las ofertas de alojamiento con poca demanda?", "Encontrar ofertas con poca demanda", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

		    if (option == JOptionPane.OK_OPTION) {
		        List<BigDecimal> respuesta = alohandes.encontrarOfertasPocaDemanda();
		        String mensaje = "ID Oferta";

		        for (BigDecimal idOferta : respuesta) {
		            mensaje += "\n" + idOferta.longValue();
		        }

		        panelDatos.actualizarInterfaz(mensaje);
		    } else {
		        panelDatos.actualizarInterfaz("Operación cancelada.");
		    }
		}

		
		
	    /**************************************************************************
	    		Metodos para el desarrollo de la ITERACION 4 del curso
		***************************************************************************/
		
		// 1.  Obtencion de Credenciales
		
		public void iniciarInterfazLoginForm() {
		    LoginForm loginForm = new LoginForm();
		    loginForm.setVisible(true);
		    loginForm.getBotonIngresar().addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		            String usuario = loginForm.getUsuarioTextField().getText();
		            String clave = new String(loginForm.getClavePasswordField().getPassword());
		            
		            if (usuario.equals("gerente") && clave.equals("alohandes")) {
		            	String mensajeBienvenidoGerente = "Bienvenido, Gerente de ALOHANDES";
		            	JOptionPane.showMessageDialog(null, mensajeBienvenidoGerente, "Bienvenido", JOptionPane.INFORMATION_MESSAGE);       	
		                // Carga la configuración de la interfaz desde un archivo JSON
		            	loginForm.dispose();
		            	initializeAdminInterface();
		            }
		            
		            else {
		                 
			            String resultado = alohandes.verificarCredenciales(usuario, clave);
	
			            if (resultado.equals("Operador")) {
			            	String mensajeBienvenidoOperador = "Bienvenido, Operador de ALOHANDES";
			            	JOptionPane.showMessageDialog(null, mensajeBienvenidoOperador, "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
			                
			            	// Abrir interfaz para operador          
			            	loginForm.dispose();
			            	initializeOperatorInterface();
			            	
			            } else if (resultado.equals("Cliente")) {
			            	String mensajeBienvenidoCliente = "Bienvenido, Cliente de ALOHANDES";
			            	JOptionPane.showMessageDialog(null, mensajeBienvenidoCliente, "Bienvenido", JOptionPane.INFORMATION_MESSAGE);       	
			            	
			                // Abrir interfaz para cliente
			            	loginForm.dispose();
			            	initializeClientInterface();
			            	
			            	
			            } else {
			            	String mensajeError = "Credenciales inválidas.";
			            	JOptionPane.showMessageDialog(null, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
			            }
		           }
		        }
		    });
		    
		}
		
		
		/* INICO*/
		
		
		
		public void consultarConsumo( )
	    {
	        	try 
	        	{
	        		
	        		String idOfertaAsociads= (JOptionPane.showInputDialog (this, "Seleccione la oferta a consultar", "idOfertaAsociada", JOptionPane.QUESTION_MESSAGE));
	        		
	        		String fechaIniciall= (JOptionPane.showInputDialog (this, "Ingrese la fecha inicial de su consulta (en formato dd/mm/aa)", "fecha Inicial", JOptionPane.QUESTION_MESSAGE));
	        		
	        		String fechaFinall= (JOptionPane.showInputDialog (this, "Ingrese la fecha final de su consulta (en formato dd/mm/aa)", "fecha Final", JOptionPane.QUESTION_MESSAGE));
	        		
	        		String ordenamiento= (JOptionPane.showInputDialog (this, "Ingrese los criterios por los cuales desea organizar sus resultados, puede elegir entre: idcliente,vinculo uniandes,usuario,clave,numero de reservas realizadas,categoria inmueble,capacidad inmueble,ubicacion inmueble. Puede elegir varios o ningún criterio, escríbalos como se ven en las opciones y separados únicamente por una coma", "criterios organización", JOptionPane.QUESTION_MESSAGE));
	        		
	        		java.util.Date fechaInicial=new SimpleDateFormat("dd/MM/yy").parse(fechaIniciall);  
	        		java.util.Date fechaFinal=new SimpleDateFormat("dd/MM/yy").parse(fechaFinall);  
	        		
	        		List<Object[]> consulta=alohandes.encontrarClientesPorOfertaRangoFechas(idOfertaAsociads, fechaInicial, fechaFinal, ordenamiento);
	        		
	        		String respuesta="Id Cliente\t\tVinculo Uniandes\t\tUsuario\t\tClave\t\tNúmero de reservas realizadas "+"\t\t"+"Categoria de inueble\t\tCapacidad Inmueble\t\tUbicación Inmueble\n";
	        		
	        		for (Object[] c:consulta)
	        		{
	        			for(Object cc:c)
	        			{
	        				respuesta+=cc.toString();
	        				respuesta+="\t\t\t";
	        				
	        			}
	        			respuesta+="\n";
	        			
	        		}
	        		panelDatos.actualizarInterfaz(respuesta);
	    
	    		} 
	        	catch (Exception e) 
	        	{
	    			e.printStackTrace();
	    			String resultado = generarMensajeError(e);
	    			panelDatos.actualizarInterfaz(resultado);
	    		}
	    }
		
		public void consultarConsumo1( )
	    {
	        	try 
	        	{
	        		String idCliente= (JOptionPane.showInputDialog (this, "ingrese su id de cliente", "idCliente", JOptionPane.QUESTION_MESSAGE));
	        		
	        		String idOfertaAsociads= (JOptionPane.showInputDialog (this, "Seleccione la oferta a consultar", "idOfertaAsociada", JOptionPane.QUESTION_MESSAGE));
	        		
	        		String fechaIniciall= (JOptionPane.showInputDialog (this, "Ingrese la fecha inicial de su consulta (en formato dd/mm/aa)", "fecha Inicial", JOptionPane.QUESTION_MESSAGE));
	        		
	        		String fechaFinall= (JOptionPane.showInputDialog (this, "Ingrese la fecha final de su consulta (en formato dd/mm/aa)", "fecha Final", JOptionPane.QUESTION_MESSAGE));
	        		
	        		String ordenamiento= "";
	        		java.util.Date fechaInicial=new SimpleDateFormat("dd/MM/yy").parse(fechaIniciall);  
	        		java.util.Date fechaFinal=new SimpleDateFormat("dd/MM/yy").parse(fechaFinall);  
	        		
	        		List<Object[]> consulta=alohandes.encontrarClientesPorOfertaRangoFechas1(idCliente,idOfertaAsociads, fechaInicial, fechaFinal, ordenamiento);
	        		
	        		String respuesta="Id Cliente\t\tVinculo Uniandes\t\tUsuario\t\tClave\t\tNúmero de reservas realizadas "+"\t\t"+"Categoria de inueble\t\tCapacidad Inmueble\t\tUbicación Inmueble\n";
	        		
	        		for (Object[] c:consulta)
	        		{
	        			for(Object cc:c)
	        			{
	        				respuesta+=cc.toString();
	        				respuesta+="\t\t";
	        				
	        			}
	        			respuesta+="\n";
	        			
	        		}
	        		panelDatos.actualizarInterfaz(respuesta);
	    
	    		} 
	        	catch (Exception e) 
	        	{
	    			e.printStackTrace();
	    			String resultado = generarMensajeError(e);
	    			panelDatos.actualizarInterfaz(resultado);
	    		}
	    }
		
		public void consultarNoConsumo( )
	    {
	        	try 
	        	{
	        		
	        		String idOfertaAsociads= (JOptionPane.showInputDialog (this, "Seleccione la oferta a consultar", "idOfertaAsociada", JOptionPane.QUESTION_MESSAGE));
	        		
	        		String fechaIniciall= (JOptionPane.showInputDialog (this, "Ingrese la fecha inicial de su consulta (en formato dd/mm/aa)", "fecha Inicial", JOptionPane.QUESTION_MESSAGE));
	        		
	        		String fechaFinall= (JOptionPane.showInputDialog (this, "Ingrese la fecha final de su consulta (en formato dd/mm/aa)", "fecha Final", JOptionPane.QUESTION_MESSAGE));
	        		
	        		String ordenamiento= (JOptionPane.showInputDialog (this, "Ingrese los criterios por los cuales desea organizar sus resultados, puede elegir entre: idcliente,vinculo uniandes,usuario,clave,numero de reservas realizadas,categoria inmueble,capacidad inmueble,ubicacion inmueble. Puede elegir varios o ningún criterio, escríbalos como se ven en las opciones y separados únicamente por una coma", "criterios organización", JOptionPane.QUESTION_MESSAGE));
	        		
	        		java.util.Date fechaInicial=new SimpleDateFormat("dd/MM/yy").parse(fechaIniciall);  
	        		java.util.Date fechaFinal=new SimpleDateFormat("dd/MM/yy").parse(fechaFinall);  
	        		
	        		List<Object[]> consulta=alohandes.encontrarNoClientesPorOfertaRangoFechas(idOfertaAsociads, fechaInicial, fechaFinal, ordenamiento);
	        		
	        		String respuesta="Id Cliente\t\tVinculo Uniandes\t\tUsuario\t\tClave\n";
	        		
	        		for (Object[] c:consulta)
	        		{
	        			for(Object cc:c)
	        			{
	        				respuesta+=cc.toString();
	        				respuesta+="\t\t\t";
	        				
	        			}
	        			respuesta+="\n";
	        			
	        		}
	        		panelDatos.actualizarInterfaz(respuesta);
	    
	    		} 
	        	catch (Exception e) 
	        	{
	    			e.printStackTrace();
	    			String resultado = generarMensajeError(e);
	    			panelDatos.actualizarInterfaz(resultado);
	    		}
	    }
		
		
		
		
		
		
		/* FIN*/
		
		
		
		
		/* 2. RFC12: CONSULTAR FUNCIONAMIENTO
		 * 
		Muestra, para cada semana del año, la oferta de alojamiento con más ocupación, la oferta de alojamiento con
		menos ocupación, los operadores más solicitados y los operadores menos solicitados. Las respuestas deben
		ser sustentadas por el detalle de las ofertas de alojamiento y operadores correspondientes. Esta operación es
		realizada el gerente general de AlohAndes.	
		*/
		
		
		public void consultarFuncionamiento() {
		    JTextField anioField = new JTextField("");
		    String message = "Por favor ingresa el año para consultar el funcionamiento.";

		    int option = JOptionPane.showOptionDialog(this, new Object[]{message, anioField}, "Consultar Funcionamiento", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

		    if (option == JOptionPane.OK_OPTION) {
		        int anio = Integer.parseInt(anioField.getText());

		        ResultadosConsulta resultados = alohandes.procesarResultadosConsulta(anio);

		        StringBuilder mensaje = new StringBuilder();
		        for (int mes = 1; mes <= 12; mes++) {
		            mensaje.append("Mes ").append(mes).append(":\n");

		            // Obtener datos de oferta con mayor ocupación
		            Object[] ofertaMaxOcupacion = resultados.getOfertasMaxOcupacion().get(mes - 1);
		            mensaje.append("Oferta con mayor ocupación: ");
		            if (ofertaMaxOcupacion != null) {
		                mensaje.append("ID: ").append(ofertaMaxOcupacion[0]).append(", Cantidad de reservas: ").append(ofertaMaxOcupacion[1]);
		            }
		            mensaje.append("\n");

		            // Obtener datos de oferta con menor ocupación
		            Object[] ofertaMinOcupacion = resultados.getOfertasMinOcupacion().get(mes - 1);
		            mensaje.append("Oferta con menor ocupación: ");
		            if (ofertaMinOcupacion != null) {
		                mensaje.append("ID: ").append(ofertaMinOcupacion[0]).append(", Cantidad de reservas: ").append(ofertaMinOcupacion[1]);
		            }
		            mensaje.append("\n");

		            // Obtener datos de operadores más solicitados
		            List<Object[]> operadoresMasSolicitados = resultados.getOperadoresMasSolicitados().get(mes - 1);
		            mensaje.append("Operadores más solicitados: ");
		            if (operadoresMasSolicitados != null) {
		                for (Object[] operador : operadoresMasSolicitados) {
		                    if (operador != null) {
		                        mensaje.append("ID: ").append(operador[0]).append(", Cantidad de reservas: ").append(operador[1]).append("; ");
		                    }
		                }
		            }
		            mensaje.append("\n");

		            // Obtener datos de operadores menos solicitados
		            List<Object[]> operadoresMenosSolicitados = resultados.getOperadoresMenosSolicitados().get(mes - 1);
		            mensaje.append("Operadores menos solicitados: ");
		            if (operadoresMenosSolicitados != null) {
		                for (Object[] operador : operadoresMenosSolicitados) {
		                    if (operador != null) {
		                        mensaje.append("ID: ").append(operador[0]).append(", Cantidad de reservas: ").append(operador[1]).append("; ");
		                    }
		                }
		            }
		            mensaje.append("\n\n");
		        }

		        panelDatos.actualizarInterfaz(mensaje.toString());
		    } else {
		        panelDatos.actualizarInterfaz("Operación cancelada.");
		    }
		}


		
		/* 3. RFC13 - CONSULTAR LOS BUENOS CLIENTES
		 * 
			Los buenos clientes son de tres tipos: aquellos que hacen reservas en AlohAndes al menos una vez al mes,
			aquellos que siempre reservan alojamientos costosos (Entiéndase costoso, por ejemplo, como mayor a USD
			150 por noche) y aquellos que siempre reservan suites. Esta consulta retorna toda la información de dichos
			clientes, incluyendo la que justifica su calificación como buenos clientes. Esta operación es realizada
			únicamente por el gerente general de AlohAndes
			*/
		
		
		public void mostrarBuenosClientes() {
		    int option = JOptionPane.showOptionDialog(this, "¿Deseas buscar los Buenos Clientes?", "Buscar Buenos Clientes", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

		    if (option == JOptionPane.OK_OPTION) {
		        List<Object[]> buenosClientes = alohandes.consultarBuenosClientes();

		        if (!buenosClientes.isEmpty()) {
		            StringBuilder mensaje = new StringBuilder("Estos son los Mejores Clientes de ALOHANDES para el año 2022:\n\n");

		            for (Object[] clienteData : buenosClientes) {
		                // Extraer datos del cliente
		                BigDecimal idCliente = (BigDecimal) clienteData[0];
		                String usuario = (String) clienteData[1];
		                String vinculoConUniandes = (String) clienteData[2];
		                // Extraer la justificación correspondiente
		                Object justificacion = clienteData[4];

		                mensaje.append("ID Cliente: ").append(idCliente).append("\n");
		                mensaje.append("Nombre de Usuario: ").append(usuario).append("\n");
		                mensaje.append("Vínculo con Uniandes: ").append(vinculoConUniandes).append("\n");
		                mensaje.append("Justificación: Esta es la cantidad de veces que el cliente reservó\nal año una vez por mes, o que reservó siempre Ofertas Costosas\no que reservó siempre Inmuebles de tipo SUITE:  ").append(justificacion).append("\n");
		                mensaje.append("--------------------------------------\n");
		            }

		            panelDatos.actualizarInterfaz(mensaje.toString());
		        } else {
		            panelDatos.actualizarInterfaz("No se encontraron Buenos Clientes.");
		        }
		    } else {
		        panelDatos.actualizarInterfaz("Operación cancelada.");
		    }
		}

		
		
		
		
		
		
		
		/************************************
		 		Funciones adicionales
		 ************************************/
		
		
	    @Override
		public void actionPerformed(ActionEvent pEvento)
		{
			String evento = pEvento.getActionCommand( );		
	        try 
	        {
				Method req = InterfazAlohandesApp.class.getMethod ( evento );			
				req.invoke ( this );
			} 
	        catch (Exception e) 
	        {
				e.printStackTrace();
			} 
		}
	    
	    
	    
		
		/* ****************************************************************
		 * 			Programa principal
		 *****************************************************************/
	    /**
	     * Este método ejecuta la aplicación, creando una nueva interfaz
	     * @param args Arreglo de argumentos que se recibe por línea de comandos
	     */
	    public static void main( String[] args )
	    {
	        try
	        {
	        		BasicConfigurator.configure();
	            // Unifica la interfaz para Mac y para Windows.
	            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
	            InterfazAlohandesApp interfaz = new InterfazAlohandesApp( );
	        }
	        catch( Exception e )
	        {
	            e.printStackTrace( );
	        }
	    }
}