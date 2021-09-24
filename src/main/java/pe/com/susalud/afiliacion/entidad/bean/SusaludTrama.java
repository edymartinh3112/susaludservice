package pe.com.susalud.afiliacion.entidad.bean;

public class SusaludTrama {
	private int idsusaludtrama;
	private String idafiliado;
	private String fenvio;
	private String ttenvio;
	private String idconfirmacion;
	private String iderror;
	private int nvector;
	private String xerror;
	private String xtramaenvio;
	private String xtramaretorno;

	@Override
	public String toString() {
		return "SusaludTrama{" + "idsusaludtrama=" + idsusaludtrama + ", idafiliado=" + idafiliado + ", fenvio="
				+ fenvio + ", ttenvio=" + ttenvio + ", idconfirmacion=" + idconfirmacion + ", iderror=" + iderror
				+ ", nvector=" + nvector + ", xerror=" + xerror + ", xtramaenvio=" + xtramaenvio + ", xtramaretorno="
				+ xtramaretorno + '}';
	}

	/**
	 * @return the idsusaludtrama
	 */
	public int getIdsusaludtrama() {
		return idsusaludtrama;
	}

	/**
	 * @param idsusaludtrama the idsusaludtrama to set
	 */
	public void setIdsusaludtrama(int idsusaludtrama) {
		this.idsusaludtrama = idsusaludtrama;
	}

	/**
	 * @return the idafiliado
	 */
	public String getIdafiliado() {
		return idafiliado;
	}

	/**
	 * @param idafiliado the idafiliado to set
	 */
	public void setIdafiliado(String idafiliado) {
		this.idafiliado = idafiliado;
	}

	/**
	 * @return the fenvio
	 */
	public String getFenvio() {
		return fenvio;
	}

	/**
	 * @param fenvio the fenvio to set
	 */
	public void setFenvio(String fenvio) {
		this.fenvio = fenvio;
	}

	/**
	 * @return the ttenvio
	 */
	public String getTtenvio() {
		return ttenvio;
	}

	/**
	 * @param ttenvio the ttenvio to set
	 */
	public void setTtenvio(String ttenvio) {
		this.ttenvio = ttenvio;
	}

	/**
	 * @return the idconfirmacion
	 */
	public String getIdconfirmacion() {
		return idconfirmacion;
	}

	/**
	 * @param idconfirmacion the idconfirmacion to set
	 */
	public void setIdconfirmacion(String idconfirmacion) {
		this.idconfirmacion = idconfirmacion;
	}

	/**
	 * @return the xerror
	 */
	public String getXerror() {
		return xerror;
	}

	/**
	 * @param xerror the xerror to set
	 */
	public void setXerror(String xerror) {
		this.xerror = xerror;
	}

	/**
	 * @return the xtramaenvio
	 */
	public String getXtramaenvio() {
		return xtramaenvio;
	}

	/**
	 * @param xtramaenvio the xtramaenvio to set
	 */
	public void setXtramaenvio(String xtramaenvio) {
		this.xtramaenvio = xtramaenvio;
	}

	/**
	 * @return the xtramaretorno
	 */
	public String getXtramaretorno() {
		return xtramaretorno;
	}

	/**
	 * @param xtramaretorno the xtramaretorno to set
	 */
	public void setXtramaretorno(String xtramaretorno) {
		this.xtramaretorno = xtramaretorno;
	}

	/**
	 * @return the iderror
	 */
	public String getIderror() {
		return iderror;
	}

	/**
	 * @param iderror the iderror to set
	 */
	public void setIderror(String iderror) {
		this.iderror = iderror;
	}

	/**
	 * @return the nvector
	 */
	public int getNvector() {
		return nvector;
	}

	/**
	 * @param nvector the nvector to set
	 */
	public void setNvector(int nvector) {
		this.nvector = nvector;
	}
}
