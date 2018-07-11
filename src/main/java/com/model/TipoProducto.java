package com.model;

public class TipoProducto {

	int idTipoProducto;
	String descripcion;
	

	public int getIdTipoProducto() {
		return idTipoProducto;
	}
	public void setIdTipoProducto(int idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public TipoProducto(int idTipoProducto,String descripcion){
		this.idTipoProducto = idTipoProducto;
		this.descripcion = descripcion;
	}
	
}
