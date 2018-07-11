package com.model;

import java.util.List;

public class CotizacionOutputResult {

	double precioTotal;
	List<CotizacionOutputResult> CotizacionOutputResultList;
	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	public List<CotizacionOutputResult> getCotizacionOutputResultList() {
		return CotizacionOutputResultList;
	}
	public void setCotizacionOutputResultList(
			List<CotizacionOutputResult> cotizacionOutputResultList) {
		CotizacionOutputResultList = cotizacionOutputResultList;
	}
}
