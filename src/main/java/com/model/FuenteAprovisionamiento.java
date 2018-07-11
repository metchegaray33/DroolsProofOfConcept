package com.model;

public class FuenteAprovisionamiento {

	int idFuente;
	String descripcion;
	
	public FuenteAprovisionamiento(int id, String descripcion){
		this.idFuente=id;
		this.descripcion=descripcion;
	}
	public int getIdFuente() {
		return idFuente;
	}
	public void setIdFuente(int idFuente) {
		this.idFuente = idFuente;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
