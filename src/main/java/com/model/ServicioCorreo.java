package com.model;

public class ServicioCorreo {

	int idServicio;
	String descripcion;
	int rangoPesoDesde;
	int rangoPesoHasta;
	int pesoMaximo;
	double precio;
		
	AreaDistribucion  areaDistribucion;

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getRangoPesoDesde() {
		return rangoPesoDesde;
	}

	public void setRangoPesoDesde(int rangoPesoDesde) {
		this.rangoPesoDesde = rangoPesoDesde;
	}

	public int getRangoPesoHasta() {
		return rangoPesoHasta;
	}

	public void setRangoPesoHasta(int rangoPesoHasta) {
		this.rangoPesoHasta = rangoPesoHasta;
	}

	public int getPesoMaximo() {
		return pesoMaximo;
	}

	public void setPesoMaximo(int pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public AreaDistribucion getAreaDistribucion() {
		return areaDistribucion;
	}

	public void setAreaDistribucion(AreaDistribucion areaDistribucion) {
		this.areaDistribucion = areaDistribucion;
	}
}
