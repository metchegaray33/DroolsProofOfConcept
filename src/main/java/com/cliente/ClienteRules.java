package com.cliente;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;




import com.managerservices.RuleManagerServices;
import com.model.AreaDistribucion;
import com.model.AreaEstandarDistribucion;
import com.model.CotizacionInput;
import com.model.ServicioCorreo;
import com.model.TipoProducto;
import com.util.Constantes;

/**
 * Este CLIENTE simula la aplicación externa que
 * invoca al cotizador de paquetes.
 * @author MEtchegaray
 *
 */
public class ClienteRules {
/**
 * Esta clase simula a la aplicación externa que será llamado desde el Cliente.
 * El cliente le pasa como parametro de entrada una lista de objetos
 * CotizacionInput que en resumen tiene el producto que se compro,
 * cantidad, servicio de correo y destino nacional o regional * 
 */
	 
	public static void main(String[] args) {
		
		System.out.println("Invocando al servicio desde el Cliente1");
		
		RuleManagerServices ruleManagerServices=new RuleManagerServices();
		
		//SIMULO LOS DATOS DEL CARRITO
		
		List<CotizacionInput> cotizacionList=cargarCotizacion();
		
		//
		ruleManagerServices.traerPacking(cotizacionList);
		
		  //LA LISTA DE COTIZACION
				for (Iterator<CotizacionInput> iterator = cotizacionList.iterator(); iterator.hasNext();) {
					CotizacionInput cotizacionInput=(CotizacionInput) iterator.next();
					System.out.println("Resultado--> SKU producto:" + cotizacionInput.getSku() + " - precio:" + cotizacionInput.getCotizacionOutput().getServicioCorreo().getPrecio() + " - cantidad:" + cotizacionInput.getCotizacionOutput().getCantidadServicios() + " - servicio:" + cotizacionInput.getServicioCorreo().getDescripcion() + " - standard:" + cotizacionInput.getServicioCorreo().getAreaDistribucion().getAreaEstandarDistribucion().getDescripcion());
									
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
	

}
