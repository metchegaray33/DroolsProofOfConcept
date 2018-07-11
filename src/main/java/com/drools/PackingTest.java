package com.drools;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;



import com.model.*;
import com.util.Constantes;

public class PackingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		   try {
	            // load up the knowledge base
		        KieServices ks = KieServices.Factory.get();
	    	    KieContainer kContainer = ks.getKieClasspathContainer();
	        	KieSession kSession = kContainer.newKieSession("ksession-rules");

	        	
	        	/***
	        	 * CARGAR LOS DATOS QUE USAN LAS REGLAS
	        	 */
	        	List<Contenedor> contenedoresList=cargarContenedores();
	        	List<Producto> productosList=cargarProductos();
	        	List<ServicioCorreo> servicioList=cargarServicios();
	    		List<CotizacionInput> cotizacionList=cargarCotizacion();
	    		
	         
	    		/**
	    		 * INSERTAR EN EL WORKING MEMORY
	    		 */	        	
	    	
	    		 //LA LISTA DE CONTENEDORES
	        	for (Iterator<Contenedor> iterator = contenedoresList.iterator(); iterator.hasNext();) {
	        		Contenedor contenedor=(Contenedor) iterator.next();
	        		kSession.insert(contenedor);					
				}
	        	
       	     
	    		 //LA LISTA DE PRODCUTOS
	        	for (Iterator<Producto> iterator = productosList.iterator(); iterator.hasNext();) {
	        		Producto producto=(Producto) iterator.next();
	        		kSession.insert(producto);					
				}

	        	
	    		 //LA LISTA DE SERVICIOS
	        	for (Iterator<ServicioCorreo> iterator = servicioList.iterator(); iterator.hasNext();) {
	        		ServicioCorreo servicio=(ServicioCorreo) iterator.next();
	        		kSession.insert(servicio);					
				}
	        	
	        	
	        	 //LA LISTA DE COTIZACION
	        	for (Iterator<CotizacionInput> iterator = cotizacionList.iterator(); iterator.hasNext();) {
	        		CotizacionInput cotizacionInput=(CotizacionInput) iterator.next();
	        		kSession.insert(cotizacionInput);					
				}       	
	            
	        	/**
	        	 * LANZO LAS REGLAS
	        	 */
	        	
	            kSession.fireAllRules();
	            
	          
	            /**
	        	 * OUTPUT DE LAS REGLAS
	        	 */
	            
	            System.out.println("EL OUTPUT DE LAS REGLAS");
	            
	            
	            //LA LISTA DE COTIZACION
	        	for (Iterator<CotizacionInput> iterator = cotizacionList.iterator(); iterator.hasNext();) {
	        		CotizacionInput cotizacionInput=(CotizacionInput) iterator.next();
	        		System.out.println("producto:" + cotizacionInput.getSku() + " precio:" + cotizacionInput.getCotizacionOutput().getServicioCorreo().getPrecio() + "-cantidad:" + cotizacionInput.getCotizacionOutput().getCantidadServicios());
	        						
				}	        
	            
	        } catch (Throwable t) {
	            t.printStackTrace();
	        }
	}

	private static List<CotizacionInput> cargarCotizacion() {
				
		/**
    	 * CotizacionInput - Carrito
    	 * 
    	 * Producto:•	Aves Argentinas x4
		   Servicio Seleccionado: Encomienda Correo Clásica
		   Destino: Av. Fair 1101, Monte Grande, Buenos Aires -NACIONAL
    	 */
		
		List<CotizacionInput> list=new ArrayList<CotizacionInput>();
    	
		CotizacionInput  cotizacionInput=new CotizacionInput();	    
    	crearCotizacionInput(cotizacionInput);
    	list.add(cotizacionInput);    	
    	
    	
    	CotizacionInput  cotizacionInputLibro=new CotizacionInput();	    
    	crearCotizacionInputLibro(cotizacionInputLibro);
    	list.add(cotizacionInputLibro);    	
    	
    	CotizacionInput  cotizacionInputRetrato=new CotizacionInput();	    
    	crearCotizacionInputRetrato(cotizacionInputRetrato);
    	list.add(cotizacionInputRetrato);    	
    	
		return list;
	}

	private static void crearCotizacionInputRetrato(CotizacionInput cotizacionInput) {
		// TODO Auto-generated method stub
		
		/**
		 * COTIZACION INPUT - LO QUE ESTÁ EN EL CARRITO
		 */
		/**
		 * PRODUCTOS
		 */
      
		cotizacionInput.setSku(Constantes.SKU5);
		cotizacionInput.setTipoProducto(new TipoProducto(Constantes.ID_TIPO_PRODUCTO_OTROS,Constantes.DESCRIPCION_TIPO_PRODUCTO_OTROS));
		cotizacionInput.setAlto(30);;
		cotizacionInput.setEspesor(1);
		cotizacionInput.setLargo(20);
		cotizacionInput.setPesoMaxProducto(1);
		cotizacionInput.setCantidadComprada(2);	      
		
		/**
		 * SERVICIO CORREO
		 */
		ServicioCorreo  servicioCorreo=new ServicioCorreo();
		servicioCorreo.setIdServicio(Constantes.ID_TIPO_SERVICIO_PRIORITARIO);
		servicioCorreo.setDescripcion(Constantes.DESCRIPCION_TIPO_SERVICIO_CORREOPRIORITARIO);       	     
		cotizacionInput.setServicioCorreo(servicioCorreo);;
    	     
		/**
		 * AREA DISTRIBUCION
		 */
		AreaDistribucion areaDistribucion=new AreaDistribucion();
		areaDistribucion.setAreaEstandarDistribucion(AreaEstandarDistribucion.REGIONAL);       	
		servicioCorreo.setAreaDistribucion(areaDistribucion);
		
		
	}

	private static void crearCotizacionInputLibro(CotizacionInput cotizacionInput) {
		// TODO Auto-generated method stub
		
		/**
		 * COTIZACION INPUT - LO QUE ESTÁ EN EL CARRITO
		 */
		/**
		 * PRODUCTOS
		 */
      
		cotizacionInput.setSku(Constantes.SKU4);
		cotizacionInput.setTipoProducto(new TipoProducto(Constantes.ID_TIPO_PRODUCTO_OTROS,Constantes.DESCRIPCION_TIPO_PRODUCTO_OTROS));
		cotizacionInput.setAlto(25);;
		cotizacionInput.setEspesor(2.5);
		cotizacionInput.setLargo(15);
		cotizacionInput.setPesoMaxProducto(8);
		cotizacionInput.setCantidadComprada(2);	      
		
		/**
		 * SERVICIO CORREO
		 */
		ServicioCorreo  servicioCorreo=new ServicioCorreo();
		servicioCorreo.setIdServicio(Constantes.ID_TIPO_SERVICIO_PRIORITARIO);
		servicioCorreo.setDescripcion(Constantes.DESCRIPCION_TIPO_SERVICIO_CORREOPRIORITARIO);       	     
		cotizacionInput.setServicioCorreo(servicioCorreo);;
    	     
		/**
		 * AREA DISTRIBUCION
		 */
		AreaDistribucion areaDistribucion=new AreaDistribucion();
		areaDistribucion.setAreaEstandarDistribucion(AreaEstandarDistribucion.REGIONAL);       	
		servicioCorreo.setAreaDistribucion(areaDistribucion);
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
	

	private static void crearCotizacionInput(CotizacionInput cotizacionInput) {
		/**
		 * COTIZACION INPUT - LO QUE ESTÁ EN EL CARRITO
		 */
		/**
		 * PRODUCTOS
		 */
      
		cotizacionInput.setSku(Constantes.SKU1);
		cotizacionInput.setTipoProducto(new TipoProducto(Constantes.ID_TIPO_PRODUCTO_FILATELIA,Constantes.DESCRIPCION_TIPO_PRODUCTO_FILATELIA));
		cotizacionInput.setAlto(50);;
		cotizacionInput.setEspesor(2);
		cotizacionInput.setLargo(3);
		cotizacionInput.setPesoMaxProducto(4);
		cotizacionInput.setCantidadComprada(4);	      
		
		/**
		 * SERVICIO CORREO
		 *//*
		ServicioCorreo  servicioCorreo=new ServicioCorreo();
		servicioCorreo.setIdServicio(Constantes.ID_TIPO_SERVICIO_CORREOCLASICO);
		servicioCorreo.setDescripcion(Constantes.DESCRIPCION_TIPO_SERVICIO_CORREOCLASICO);       	     
		cotizacionInput.setServicioCorreo(servicioCorreo);;
    	     
		*//**
		 * AREA DISTRIBUCION
		 *//*
		AreaDistribucion areaDistribucion=new AreaDistribucion();
		areaDistribucion.setAreaEstandarDistribucion(AreaEstandarDistribucion.NACIONAL);       	
		servicioCorreo.setAreaDistribucion(areaDistribucion);*/
		
		/**
		 * SERVICIO CORREO
		 */
		ServicioCorreo  servicioCorreo=new ServicioCorreo();
		servicioCorreo.setIdServicio(Constantes.ID_TIPO_SERVICIO_PRIORITARIO);
		servicioCorreo.setDescripcion(Constantes.DESCRIPCION_TIPO_SERVICIO_CORREOPRIORITARIO);       	     
		cotizacionInput.setServicioCorreo(servicioCorreo);;
    	     
		/**
		 * AREA DISTRIBUCION
		 */
		AreaDistribucion areaDistribucion=new AreaDistribucion();
		areaDistribucion.setAreaEstandarDistribucion(AreaEstandarDistribucion.REGIONAL);       	
		servicioCorreo.setAreaDistribucion(areaDistribucion);
		
		
		
	}
	

}
