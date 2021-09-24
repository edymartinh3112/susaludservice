package pe.com.susalud.afiliacion.entidad.bean;

import java.util.ArrayList;

public class AfiliacionData {
	private String c_c_afiliado;
	private String c_t_afiliado;
	private String n_dni;
	private int n_flg_tipo_afiliacion;
	private String c_c_motivo_afiliacion;
	private String c_t_motivo_afiliacion;

	private String c_c_envio_susalud;
	private String d_dt_envio;
	private int c_tipo;
	private String c_c_usuario;
	private String c_tipo_envio;
	private int n_i_cantidad;
	private ArrayList<AfiliacionDataDet> lstAfiliacionDet;

	/**
	 * @return the c_c_afiliado
	 */
	public String getC_c_afiliado() {
		return c_c_afiliado;
	}

	/**
	 * @param c_c_afiliado the c_c_afiliado to set
	 */
	public void setC_c_afiliado(String c_c_afiliado) {
		this.c_c_afiliado = c_c_afiliado;
	}

	/**
	 * @return the c_t_afiliado
	 */
	public String getC_t_afiliado() {
		return c_t_afiliado;
	}

	/**
	 * @param c_t_afiliado the c_t_afiliado to set
	 */
	public void setC_t_afiliado(String c_t_afiliado) {
		this.c_t_afiliado = c_t_afiliado;
	}

	/**
	 * @return the n_dni
	 */
	public String getN_dni() {
		return n_dni;
	}

	/**
	 * @param n_dni the n_dni to set
	 */
	public void setN_dni(String n_dni) {
		this.n_dni = n_dni;
	}

	/**
	 * @return the n_flg_tipo_afiliacion
	 */
	public int getN_flg_tipo_afiliacion() {
		return n_flg_tipo_afiliacion;
	}

	/**
	 * @param n_flg_tipo_afiliacion the n_flg_tipo_afiliacion to set
	 */
	public void setN_flg_tipo_afiliacion(int n_flg_tipo_afiliacion) {
		this.n_flg_tipo_afiliacion = n_flg_tipo_afiliacion;
	}

	/**
	 * @return the c_c_motivo_afiliacion
	 */
	public String getC_c_motivo_afiliacion() {
		return c_c_motivo_afiliacion;
	}

	/**
	 * @param c_c_motivo_afiliacion the c_c_motivo_afiliacion to set
	 */
	public void setC_c_motivo_afiliacion(String c_c_motivo_afiliacion) {
		this.c_c_motivo_afiliacion = c_c_motivo_afiliacion;
	}

	/**
	 * @return the c_t_motivo_afiliacion
	 */
	public String getC_t_motivo_afiliacion() {
		return c_t_motivo_afiliacion;
	}

	/**
	 * @param c_t_motivo_afiliacion the c_t_motivo_afiliacion to set
	 */
	public void setC_t_motivo_afiliacion(String c_t_motivo_afiliacion) {
		this.c_t_motivo_afiliacion = c_t_motivo_afiliacion;
	}

	/**
	 * @return the c_c_envio_susalud
	 */
	public String getC_c_envio_susalud() {
		return c_c_envio_susalud;
	}

	/**
	 * @param c_c_envio_susalud the c_c_envio_susalud to set
	 */
	public void setC_c_envio_susalud(String c_c_envio_susalud) {
		this.c_c_envio_susalud = c_c_envio_susalud;
	}

	/**
	 * @return the d_dt_envio
	 */
	public String getD_dt_envio() {
		return d_dt_envio;
	}

	/**
	 * @param d_dt_envio the d_dt_envio to set
	 */
	public void setD_dt_envio(String d_dt_envio) {
		this.d_dt_envio = d_dt_envio;
	}

	/**
	 * @return the c_tipo
	 */
	public int getC_tipo() {
		return c_tipo;
	}

	/**
	 * @param c_tipo the c_tipo to set
	 */
	public void setC_tipo(int c_tipo) {
		this.c_tipo = c_tipo;
	}

	/**
	 * @return the c_c_usuario
	 */
	public String getC_c_usuario() {
		return c_c_usuario;
	}

	/**
	 * @param c_c_usuario the c_c_usuario to set
	 */
	public void setC_c_usuario(String c_c_usuario) {
		this.c_c_usuario = c_c_usuario;
	}

	/**
	 * @return the c_tipo_envio
	 */
	public String getC_tipo_envio() {
		return c_tipo_envio;
	}

	/**
	 * @param c_tipo_envio the c_tipo_envio to set
	 */
	public void setC_tipo_envio(String c_tipo_envio) {
		this.c_tipo_envio = c_tipo_envio;
	}

	/**
	 * @return the n_i_cantidad
	 */
	public int getN_i_cantidad() {
		return n_i_cantidad;
	}

	/**
	 * @param n_i_cantidad the n_i_cantidad to set
	 */
	public void setN_i_cantidad(int n_i_cantidad) {
		this.n_i_cantidad = n_i_cantidad;
	}

	/**
	 * @return the lstAfiliacionDet
	 */
	public ArrayList<AfiliacionDataDet> getLstAfiliacionDet() {
		return lstAfiliacionDet;
	}

	/**
	 * @param lstAfiliacionDet the lstAfiliacionDet to set
	 */
	public void setLstAfiliacionDet(ArrayList<AfiliacionDataDet> lstAfiliacionDet) {
		this.lstAfiliacionDet = lstAfiliacionDet;
	}
}
