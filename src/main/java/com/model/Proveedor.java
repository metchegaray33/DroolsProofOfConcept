package com.model;

public class Proveedor {
	int idProveedor;
	String descripcion;
	
	public Proveedor(int id,String descripcion){
		this.idProveedor=id;
		this.descripcion=descripcion;
	}
	public int getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
