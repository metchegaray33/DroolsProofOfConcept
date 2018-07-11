package com.drools;

import java.util.Iterator;
import java.util.List;

import org.drools.*;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.*;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.model.Contenedor;
import com.model.CotizacionInput;
import com.model.Producto;
import com.model.ServicioCorreo;


/**
 * Esta clase simula el servicio que será expuesto por el motor de reglas.
 * Y recibe como parametros de entrada los datos a cotizar y luego
 * trae todos los demas valores que requiere el motor para comparar y aplicar las reglas.
 * @author MEtchegaray
 *
 */
public class RulesWebServicesInterfaceImpl{

	/**
	 * Este método recibe todos los datos que necesitan la regla y devuelve el resultado de la regla
	 * @param contenedoresList lista de contenedores
	 * @param productosList lista de productos
	 * @param servicioList lista de servicios
	 * @param cotizacionList informacion de lo que hay que cotizar
	 * @return información de lo que hay que cotizar mas el resultado de la regla.
	 */
	public List<CotizacionInput> ejecutarReglasPackingNew(List<Contenedor> contenedoresList,List<Producto> productosList,List<ServicioCorreo> servicioList,List<CotizacionInput> cotizacionList,String ruleAEjecutar){
		
		System.out.println("INGRESANDO A ejecutarReglasPacking para disparar las relgas");
		
		
		 try {
			
			 KnowledgeBase kbase = createKnowledgeBase(ruleAEjecutar);			 
			StatefulKnowledgeSession kSession = createKnowledgeSession(kbase);	
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
			 * 		Esto es necesario en StatefulKnowledgeSession
			 */
			
			kSession.dispose();
  		
  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("-------------->SE HA PRODUCIDO UN ERROR");
			e.printStackTrace();
		}
		
		return cotizacionList;
	}

	 /**
		     * Creates a Drools KnowledgeBase and adds the given rules file into it
	     */
		    private  KnowledgeBase createKnowledgeBase( final String rulesFile ) { KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
	        	kbuilder.add( ResourceFactory.newClassPathResource( rulesFile ), ResourceType.DRL );	        
	        	KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
	        	kbase.addKnowledgePackages( kbuilder.getKnowledgePackages() );
	        	return kbase;
		    }
	 
		    /**
		     * Creates a Drools Stateful Knowledge Session
		     */
		    private  StatefulKnowledgeSession createKnowledgeSession( final KnowledgeBase kbase ) {
		    	final StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();		    			    
		        return ksession;
		    }
	       
	
}
