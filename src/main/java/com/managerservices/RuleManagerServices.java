package com.managerservices;

import java.util.ArrayList;
import java.util.List;

import com.drools.RulesWebServicesInterfaceImpl;
import com.model.AreaDistribucion;
import com.model.AreaEstandarDistribucion;
import com.model.Contenedor;
import com.model.ContenedorFilatelia;
import com.model.ContenedorOtros;
import com.model.CotizacionInput;
import com.model.FuenteAprovisionamiento;
import com.model.Producto;
import com.model.Proveedor;
import com.model.ServicioCorreo;
import com.model.TipoProducto;
import com.util.Constantes;

/**
 * Esta clase simula el servicio que será llamado desde el Cliente
 * el cliente le pasa como parametro de entrada una lista de objetos
 * CotizacionInput que en resumen tiene el producto que se compro,
 * cantidad, servicio de correo y destino nacional o regional * 
 * @author MEtchegaray
 *
 */
public class RuleManagerServices {

	/**
	 * Este método se encarga traer los datos que necesita el motor de reglas para evaluar
	 * Son los datos de contenedores, productos y servicios.
	 * Ahora son cargados los datos a mano pero se puede tomar desde una BD
	 * 
	 * @param cotizacionList una lista de elementos CotizacionInput
	 * @return  List<CotizacionInput>  a la lista de entrada se le agrega un objeto CotizacionOuput que tiene una sintesis
	 * del servicio que le correponde y su precio
	 */
	public  List<CotizacionInput>  traerPacking(List<CotizacionInput> cotizacionList){
		
		System.out.println("Ingresando al Servicio traerPacking");
		
		RulesWebServicesInterfaceImpl rulesWebServicesInterface=new RulesWebServicesInterfaceImpl();
		
		/***
    	 * TRAER LOS DATOS QUE USAN LAS REGLAS
    	 */
    	List<Contenedor> contenedoresList=cargarContenedores();
    	List<Producto> productosList=cargarProductos();
    	List<ServicioCorreo> servicioList=cargarServicios();	
    	
    //	return rulesWebServicesInterface.ejecutarReglasPacking(contenedoresList, productosList, servicioList, cotizacionList);
    	return rulesWebServicesInterface.ejecutarReglasPackingNew(contenedoresList, productosList, servicioList, cotizacionList,"rules/packing.drl");
		
	}
	
	private static List<ServicioCorreo> cargarServicios() {
		
		List<ServicioCorreo> list=new ArrayList<ServicioCorreo>();
		
		   /**
         * Popular SERVICIO CORREO 1
         */
    	
    	ServicioCorreo  servicioCorreo1=new ServicioCorreo();  
    	crearServicioCorreo1(servicioCorreo1);	    		
    	list.add(servicioCorreo1);
   
    	 /**
         * Popular SERVICIO CORREO 2
         */
    	
    	ServicioCorreo  servicioCorreo2=new ServicioCorreo();  
    	crearServicioCorreo2(servicioCorreo2);	    
    	list.add(servicioCorreo2);
    	
		return list;
	}
	
	
	
	
		
	
	/**
	 * CREAR CONTENEDOR FILATELIA
	 * 
	 */
	
	private static List<Contenedor> cargarContenedores() {
		List<Contenedor> list=new ArrayList<Contenedor>();
		
    	/**
		 * Armo el primer contenedor
		 */
		Contenedor  contenedorFilatelia=new ContenedorFilatelia();		
		crearContenedor1Filatelia((ContenedorFilatelia)contenedorFilatelia);
		list.add(contenedorFilatelia);
		
		/**
		 * Armo el segundo contenedor
		 */
		Contenedor  contenedorFilatelia2=new ContenedorFilatelia();		
		crearContenedorFilatelia2((ContenedorFilatelia)contenedorFilatelia2);
		list.add(contenedorFilatelia2);
		
		/**
    	 * 	CREAR CONTENEDOR NO FILATELIA SKU 4
    	 */
		Contenedor contenedorOtros=new ContenedorOtros();
		crearContenedorNofilatelia((ContenedorOtros)contenedorOtros);		
		list.add(contenedorOtros);
		
		/**
    	 * 	CREAR CONTENEDOR NO FILATELIA SKU5
    	 */
		Contenedor contenedorOtros2=new ContenedorOtros();
		crearContenedorNofilatelia2((ContenedorOtros)contenedorOtros2);		
		list.add(contenedorOtros2);
		
		return list;
	}

	private static void crearContenedorNofilatelia(
			ContenedorOtros contenedorOtros) {
		contenedorOtros.setSku(Constantes.SKU4);		
		contenedorOtros.setAlto(25);
		contenedorOtros.setEspesor(2.5);
		contenedorOtros.setLargo(15);
		contenedorOtros.setPesoMaxContenedor(2);
		contenedorOtros.setMaxProdSoportado(8);
		contenedorOtros.setCoeficiente(5000);
	}

	private static void crearContenedorNofilatelia2(
			ContenedorOtros contenedorOtros) {
		contenedorOtros.setSku(Constantes.SKU5);		
		contenedorOtros.setAlto(30);
		contenedorOtros.setEspesor(1);
		contenedorOtros.setLargo(20);
		contenedorOtros.setPesoMaxContenedor(1);
		contenedorOtros.setMaxProdSoportado(1);
		contenedorOtros.setCoeficiente(5000);
	}
	
	private static void crearContenedorFilatelia2(
			ContenedorFilatelia contenedorFilatelia2) {
		contenedorFilatelia2.setSku(Constantes.SKU1);		
		contenedorFilatelia2.setAlto(1);
		contenedorFilatelia2.setEspesor(0.5);
		contenedorFilatelia2.setLargo(4);
		contenedorFilatelia2.setPesoMaxContenedor(4);
		contenedorFilatelia2.setRangoCantidadDesde(11);
		contenedorFilatelia2.setRangoCantidadHasta(15);
		contenedorFilatelia2.setCoeficiente(5000);
	}

	private static void crearContenedor1Filatelia(
			ContenedorFilatelia contenedorFilatelia) {
		contenedorFilatelia.setSku(Constantes.SKU1);		
		contenedorFilatelia.setAlto(0.5);
		contenedorFilatelia.setEspesor(0.2);
		contenedorFilatelia.setLargo(1);
		contenedorFilatelia.setPesoMaxContenedor(2);
		contenedorFilatelia.setRangoCantidadDesde(1);
		contenedorFilatelia.setRangoCantidadHasta(10);
		contenedorFilatelia.setCoeficiente(5000);
	}


	private static List<Producto> cargarProductos() {
		
		List<Producto> list=new ArrayList<Producto>();
		
    	/**
    	 * Crear producto filatelia
    	 */
    	Producto productoFilatelia =new Producto();
    	crearProductoFilatelia(productoFilatelia);
    	list.add(productoFilatelia);
    	
    	/**
    	 * Crear producto NO filatelia 1
    	 */
    	Producto productoNoFilatelia1 =new Producto();
    	crearProductoNoFilatelia1(productoNoFilatelia1);
    	list.add(productoNoFilatelia1);
    	
    	/**
    	 * Crear producto NO filatelia 2
    	 */
    	Producto productoNoFilatelia2 =new Producto();
    	crearProductoNoFilatelia2(productoNoFilatelia2);
    	list.add(productoNoFilatelia2);
    	
		return list;
	}
	
	/**
	 * CREO UN SERVICIO DE CORREO
	 * @param servicioCorreo1
	 */
	private static void crearServicioCorreo1(ServicioCorreo servicioCorreo1) {
		servicioCorreo1.setIdServicio(Constantes.ID_TIPO_SERVICIO_CORREOCLASICO);
		servicioCorreo1.setDescripcion(Constantes.DESCRIPCION_TIPO_SERVICIO_CORREOCLASICO);  
		
		servicioCorreo1.setPesoMaximo(5);
		servicioCorreo1.setPrecio(30);
		servicioCorreo1.setRangoPesoDesde(1);
		servicioCorreo1.setRangoPesoHasta(5);
		
		/**
		 * AREA DISTRIBUCION
		 */
		AreaDistribucion areaDistribucion=new AreaDistribucion();
		areaDistribucion.setAreaEstandarDistribucion(AreaEstandarDistribucion.NACIONAL);       	
		servicioCorreo1.setAreaDistribucion(areaDistribucion);
	}
	
	/**
	 * CREO UN SERVICIO DE CORREO
	 * @param servicioCorreo1
	 */
	private static void crearServicioCorreo2(ServicioCorreo servicioCorreo1) {
		servicioCorreo1.setIdServicio(Constantes.ID_TIPO_SERVICIO_PRIORITARIO);
		servicioCorreo1.setDescripcion(Constantes.DESCRIPCION_TIPO_SERVICIO_CORREOPRIORITARIO);  
		
		servicioCorreo1.setPesoMaximo(5);
		servicioCorreo1.setPrecio(30);
		servicioCorreo1.setRangoPesoDesde(1);
		servicioCorreo1.setRangoPesoHasta(5);
		
		/**
		 * AREA DISTRIBUCION
		 */
		AreaDistribucion areaDistribucion=new AreaDistribucion();
		areaDistribucion.setAreaEstandarDistribucion(AreaEstandarDistribucion.REGIONAL);       	
		servicioCorreo1.setAreaDistribucion(areaDistribucion);
	}

	private static void crearProductoFilatelia(Producto producto) {		
		producto.setAgrupa(Constantes.SI_AGRUPA);
		producto.setDescripcion(Constantes.SKU1_DESCRIPCION1);
		producto.setFuenteAprovisionamiento(new FuenteAprovisionamiento(1,"MONTEGRANDE"));
		producto.setMaxProdSoportado(10);
		producto.setProveedor(new Proveedor(1,"CORREO"));
		producto.setSku(Constantes.SKU1);
		producto.setTipoProducto(new TipoProducto(Constantes.ID_TIPO_PRODUCTO_FILATELIA,Constantes.DESCRIPCION_TIPO_PRODUCTO_FILATELIA));
		
		
		
	}

	/**
	 * Crea ejemplo de producto del tipo OTROS
	 * @param producto
	 */
	private static void crearProductoNoFilatelia1(Producto producto) {		
		producto.setAgrupa(Constantes.SI_AGRUPA);
		producto.setDescripcion(Constantes.SKU4_DESCRIPCION1);
		producto.setFuenteAprovisionamiento(new FuenteAprovisionamiento(2,"FRAVEGA"));
		producto.setMaxProdSoportado(8);
		producto.setProveedor(new Proveedor(2,"FRAVEGA"));
		producto.setSku(Constantes.SKU4);
		producto.setTipoProducto(new TipoProducto(Constantes.ID_TIPO_PRODUCTO_OTROS,Constantes.DESCRIPCION_TIPO_PRODUCTO_OTROS));
		
		/**
		 * Le cargo los contenedores asignados
		 */
		
		
	}

	/**
	 * Crea ejemplo de producto del tipo OTROS
	 * @param producto
	 */
	private static void crearProductoNoFilatelia2(Producto producto) {		
		producto.setAgrupa(Constantes.NO_AGRUPA);
		producto.setDescripcion(Constantes.SKU5_DESCRIPCION1);
		producto.setFuenteAprovisionamiento(new FuenteAprovisionamiento(3,"SAMPLES"));
		producto.setMaxProdSoportado(1);
		producto.setProveedor(new Proveedor(3,"SAMPLES"));
		producto.setSku(Constantes.SKU5);
		producto.setTipoProducto(new TipoProducto(Constantes.ID_TIPO_PRODUCTO_OTROS,Constantes.DESCRIPCION_TIPO_PRODUCTO_OTROS));

		
	}
	

		

}
