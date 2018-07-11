package com.model;

public class Contenedor {

	 String sku;
	 double largo;
	 double alto;
	 double espesor;
	 double pesoMaxContenedor;
	 double coeficiente;
	
	/**
	 * Hace el calculo correspondiente y devuelve el peso volumetrico
	 * @param largo
	 * @param alto
	 * @param espesor
	 * @param coeficiente
	 * @return
	 */
	public  double calcularPesoVolumetrico(double largo, double alto, double espesor, double coeficiente){
		
		//PV = (1*0.5*0.2)/ Coeficiente
		double pesoVolumentrico=(largo*alto*espesor)/coeficiente;		
		return pesoVolumentrico;
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
	public double getPesoMaxContenedor() {
		return pesoMaxContenedor;
	}
	public void setPesoMaxContenedor(double pesoMaxContenedor) {
		this.pesoMaxContenedor = pesoMaxContenedor;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public double getCoeficiente() {
		return coeficiente;
	}
	public void setCoeficiente(double coeficiente) {
		this.coeficiente = coeficiente;
	}
		
}
