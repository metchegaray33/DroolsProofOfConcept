package com.model;


public class Producto {

	TipoProducto tipoProducto;
	FuenteAprovisionamiento  fuenteAprovisionamiento;
	Proveedor proveedor;
	String sku;
	String descripcion;
	boolean agrupa;
	int maxProdSoportado;
	
	
	
	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	public FuenteAprovisionamiento getFuenteAprovisionamiento() {
		return fuenteAprovisionamiento;
	}
	public void setFuenteAprovisionamiento(
			FuenteAprovisionamiento fuenteAprovisionamiento) {
		this.fuenteAprovisionamiento = fuenteAprovisionamiento;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isAgrupa() {
		return agrupa;
	}
	public void setAgrupa(boolean agrupa) {
		this.agrupa = agrupa;
	}
	public int getMaxProdSoportado() {
		return maxProdSoportado;
	}
	public void setMaxProdSoportado(int maxProdSoportado) {
		this.maxProdSoportado = maxProdSoportado;
	}
	

	
}
