package com.model;

public class CotizacionOutput {

	
	Producto producto;
	ServicioCorreo  servicioCorreo;
	Contenedor contenedor;
	double pesoVolumetrico;
	int cantidadServicios;
	
	public CotizacionOutput(Producto producto,Contenedor contenedor,ServicioCorreo servicioCorreo, double pesoVolumetrico, int cantidadServicios){		
		
		this.producto=producto;
		this.contenedor=contenedor;
		this.servicioCorreo=servicioCorreo;
		this.pesoVolumetrico=pesoVolumetrico;
		this.cantidadServicios=cantidadServicios;
				
	}
	

	
	public double getPesoVolumetrico() {
		return pesoVolumetrico;
	}
	public void setPesoVolumetrico(double pesoVolumetrico) {
		this.pesoVolumetrico = pesoVolumetrico;
	}
	
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public ServicioCorreo getServicioCorreo() {
		return servicioCorreo;
	}
	public void setServicioCorreo(ServicioCorreo servicioCorreo) {
		this.servicioCorreo = servicioCorreo;
	}
	public Contenedor getContenedor() {
		return contenedor;
	}
	public void setContenedor(Contenedor contenedor) {
		this.contenedor = contenedor;
	}



	public int getCantidadServicios() {
		return cantidadServicios;
	}



	public void setCantidadServicios(int cantidadServicios) {
		this.cantidadServicios = cantidadServicios;
	}





}
