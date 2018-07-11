package com.model;


public class CotizacionInput {

	
	String sku;		
	int cantidadComprada;
	TipoProducto tipoProducto;
	double largo;
	double alto;
	double espesor;
	int pesoMaxProducto;	
	
	ServicioCorreo servicioCorreo;	
	
	CotizacionOutput cotizacionOutput;
	
	
	
	public ServicioCorreo getServicioCorreo() {
		return servicioCorreo;
	}
	public void setServicioCorreo(ServicioCorreo servicioCorreo) {
		this.servicioCorreo = servicioCorreo;
	}
	
	public CotizacionOutput getCotizacionOutput() {
		return cotizacionOutput;
	}
	public void setCotizacionOutput(CotizacionOutput cotizacionOutput) {
		this.cotizacionOutput = cotizacionOutput;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}


	public int getCantidadComprada() {
		return cantidadComprada;
	}
	public void setCantidadComprada(int cantidadComprada) {
		this.cantidadComprada = cantidadComprada;
	}

	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	
	/**
	 * Este método busca los datos del registro del contenedor correspondiente
	 * y crea una instancia con estos datos.
	 * @param sku
	 * @param cantidadComprada
	 */
	public void guadarContenedorFilatelia(String sku, int cantidadComprada){
		
		//primero buscar los datos y popular la clase contenedor filatelia
		
		ContenedorFilatelia contenedorFilatelia=new ContenedorFilatelia();
		contenedorFilatelia.setSku("001ab");
		contenedorFilatelia.setAlto(0.5);
		contenedorFilatelia.setEspesor(0.2);
		contenedorFilatelia.setLargo(1);
		contenedorFilatelia.setPesoMaxContenedor(2);
		contenedorFilatelia.setRangoCantidadDesde(1);
		contenedorFilatelia.setRangoCantidadHasta(10);;
		
		//this.setContenedorFilatelia(contenedorFilatelia);
//		
	}
	public double getLargo() {
		return largo;
	}
	public void setLargo(double largo) {
		this.largo = largo;
	}
	public double getAlto() {
		return alto;
	}
	public void setAlto(double alto) {
		this.alto = alto;
	}
	public double getEspesor() {
		return espesor;
	}
	public void setEspesor(double espesor) {
		this.espesor = espesor;
	}
	public int getPesoMaxProducto() {
		return pesoMaxProducto;
	}
	public void setPesoMaxProducto(int pesoMaxProducto) {
		this.pesoMaxProducto = pesoMaxProducto;
	}
	
}
