package pe.com.susalud.demoafl;

import java.util.Vector;

import pe.gob.susalud.jr.transaccion.susalud.bean.In271RegafiUpdate;

public class Trama271Bean {
	private String tiOperacion;
	private String caRemitente;
	private String feTransaccion;
	private String hoTransaccion;
	private String idCorrelativo;
	private String idReceptor;
	private String idRemitente;
	private String idTransaccion;
	private String noTransaccion;
	private String tiFinalidad;
	Vector<Vector<String>> dataVector = new Vector<Vector<String>>();
	Vector<Vector<String>> dataVector2 = new Vector<Vector<String>>();
	
	private In271RegafiUpdate dato;

	public Trama271Bean() {
		
	}
	
	@Override
	public String toString() {
		return new StringBuilder("tiOperacion: ").append(tiOperacion).append(" caRemitente ").append(caRemitente).append(" feTransaccion ")
				.append(feTransaccion).append(" hoTransacion ").append(hoTransaccion).append(" idCorrelativo ").append(idCorrelativo)
				.append(" idReceptor ").append(idReceptor).append(" idRemitente ").append(idRemitente).append(" idTransaccion ").append(idTransaccion)
				.append(" noTransaccion ").append(noTransaccion).append(" tiFinalidad ").append(tiFinalidad).toString();
		
	}
	
	public String getTiOperacion() {
		return tiOperacion;
	}
	public void setTiOperacion(String tiOperacion) {
		this.tiOperacion = tiOperacion;
	}
	public String getCaRemitente() {
		return caRemitente;
	}
	public void setCaRemitente(String caRemitente) {
		this.caRemitente = caRemitente;
	}
	public String getFeTransaccion() {
		return feTransaccion;
	}
	public void setFeTransaccion(String feTransaccion) {
		this.feTransaccion = feTransaccion;
	}
	public String getHoTransaccion() {
		return hoTransaccion;
	}
	public void setHoTransaccion(String hoTransaccion) {
		this.hoTransaccion = hoTransaccion;
	}
	public String getIdCorrelativo() {
		return idCorrelativo;
	}
	public void setIdCorrelativo(String idCorrelativo) {
		this.idCorrelativo = idCorrelativo;
	}
	public String getIdReceptor() {
		return idReceptor;
	}
	public void setIdReceptor(String idReceptor) {
		this.idReceptor = idReceptor;
	}
	public String getIdRemitente() {
		return idRemitente;
	}
	public void setIdRemitente(String idRemitente) {
		this.idRemitente = idRemitente;
	}
	public String getIdTransaccion() {
		return idTransaccion;
	}
	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	public String getNoTransaccion() {
		return noTransaccion;
	}
	public void setNoTransaccion(String noTransaccion) {
		this.noTransaccion = noTransaccion;
	}
	public String getTiFinalidad() {
		return tiFinalidad;
	}
	public void setTiFinalidad(String tiFinalidad) {
		this.tiFinalidad = tiFinalidad;
	}
	public Vector<Vector<String>> getDataVector() {
		return dataVector;
	}
	public void setDataVector(Vector<Vector<String>> dataVector) {
		this.dataVector = dataVector;
	}
	public Vector<Vector<String>> getDataVector2() {
		return dataVector2;
	}
	public void setDataVector2(Vector<Vector<String>> dataVector2) {
		this.dataVector2 = dataVector2;
	};
	
	public In271RegafiUpdate getDato() {
		return dato;
	}

	public void setDato(In271RegafiUpdate dato) {
		this.dato = dato;
	}

	
	
}

