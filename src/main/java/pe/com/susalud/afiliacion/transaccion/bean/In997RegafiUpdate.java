package pe.com.susalud.afiliacion.transaccion.bean;

import java.util.ArrayList;
import java.util.List;

public class In997RegafiUpdate {
	private String noTransaccion;
	/*     */ private String idRemitente;
	/*     */ private String idReceptor;
	/*     */ private String feTransaccion;
	/*     */ private String hoTransaccion;
	/*     */ private String idCorrelativo;
	/*     */ private String idTransaccion;
	/*     */ private String excProceso;
	/* 22 */ private boolean flag = true;
	/*     */
	/*     */ private ArrayList<In997RegafiUpdateExcepcion> in997RegafiUpdateExcepcion;
	/*     */ private String nuControl;
	/*     */ private String nuControlST;

	/*     */
	/*     */ public In997RegafiUpdate()
	/*     */ {
		/* 30 */ this.in997RegafiUpdateExcepcion = new ArrayList();
		/*     */ }

	/*     */
	/*     */
	/*     */ public String getNoTransaccion()
	/*     */ {
		/* 36 */ return this.noTransaccion;
		/*     */ }

	/*     */
	/*     */ public void setNoTransaccion(String noTransaccion) {
		/* 40 */ if (this.flag) {
			/* 41 */ if (noTransaccion != null)
				this.noTransaccion = noTransaccion.trim();
			else
				this.noTransaccion = "";
			/*     */ }
		/* 43 */ else if (noTransaccion != null)
			this.noTransaccion = noTransaccion;
		else
			this.noTransaccion = "";
		/*     */ }

	/*     */
	/*     */ public String getIdRemitente()
	/*     */ {
		/* 48 */ return this.idRemitente;
		/*     */ }

	/*     */
	/*     */ public void setIdRemitente(String idRemitente) {
		/* 52 */ if (this.flag) {
			/* 53 */ if (idRemitente != null)
				this.idRemitente = idRemitente.trim();
			else
				this.idRemitente = "";
			/*     */ }
		/* 55 */ else if (idRemitente != null)
			this.idRemitente = idRemitente;
		else
			this.idRemitente = "";
		/*     */ }

	/*     */
	/*     */ public String getIdReceptor()
	/*     */ {
		/* 60 */ return this.idReceptor;
		/*     */ }

	/*     */
	/*     */ public void setIdReceptor(String idReceptor) {
		/* 64 */ if (this.flag) {
			/* 65 */ if (idReceptor != null)
				this.idReceptor = idReceptor.trim();
			else
				this.idReceptor = "";
			/*     */ }
		/* 67 */ else if (idReceptor != null)
			this.idReceptor = idReceptor;
		else
			this.idReceptor = "";
		/*     */ }

	/*     */
	/*     */ public String getFeTransaccion()
	/*     */ {
		/* 72 */ return this.feTransaccion;
		/*     */ }

	/*     */
	/*     */ public void setFeTransaccion(String feTransaccion) {
		/* 76 */ if (this.flag) {
			/* 77 */ if (feTransaccion != null)
				this.feTransaccion = feTransaccion.trim();
			else
				this.feTransaccion = "";
			/*     */ }
		/* 79 */ else if (feTransaccion != null)
			this.feTransaccion = feTransaccion;
		else
			this.feTransaccion = "";
		/*     */ }

	/*     */
	/*     */ public String getHoTransaccion()
	/*     */ {
		/* 84 */ return this.hoTransaccion;
		/*     */ }

	/*     */
	/*     */ public void setHoTransaccion(String hoTransaccion) {
		/* 88 */ if (this.flag) {
			/* 89 */ if (hoTransaccion != null)
				this.hoTransaccion = hoTransaccion.trim();
			else
				this.hoTransaccion = "";
			/*     */ }
		/* 91 */ else if (hoTransaccion != null)
			this.hoTransaccion = hoTransaccion;
		else
			this.hoTransaccion = "";
		/*     */ }

	/*     */
	/*     */ public String getIdCorrelativo()
	/*     */ {
		/* 96 */ return this.idCorrelativo;
		/*     */ }

	/*     */
	/*     */ public void setIdCorrelativo(String idCorrelativo) {
		/* 100 */ if (this.flag) {
			/* 101 */ if (idCorrelativo != null)
				this.idCorrelativo = idCorrelativo.trim();
			else
				this.idCorrelativo = "";
			/*     */ }
		/* 103 */ else if (idCorrelativo != null)
			this.idCorrelativo = idCorrelativo;
		else
			this.idCorrelativo = "";
		/*     */ }

	/*     */
	/*     */ public String getIdTransaccion()
	/*     */ {
		/* 108 */ return this.idTransaccion;
		/*     */ }

	/*     */
	/*     */ public void setIdTransaccion(String idTransaccion) {
		/* 112 */ if (this.flag) {
			/* 113 */ if (idTransaccion != null)
				this.idTransaccion = idTransaccion.trim();
			else
				this.idTransaccion = "";
			/*     */ }
		/* 115 */ else if (idTransaccion != null)
			this.idTransaccion = idTransaccion;
		else {
			this.idTransaccion = "";
			/*     */ }
		/*     */ }

	/*     */
	/*     */ public String getExcProceso()
	/*     */ {
		/* 121 */ return this.excProceso;
		/*     */ }

	/*     */
	/*     */ public void setExcProceso(String excProceso) {
		/* 125 */ if (this.flag) {
			/* 126 */ if (excProceso != null)
				this.excProceso = excProceso.trim();
			else
				this.excProceso = "";
			/*     */ }
		/* 128 */ else if (excProceso != null)
			this.excProceso = excProceso;
		else
			this.excProceso = "";
		/*     */ }

	/*     */
	/*     */ public String getNuControl()
	/*     */ {
		/* 133 */ return this.nuControl;
		/*     */ }

	/*     */
	/*     */ public void setNuControl(String nuControl) {
		/* 137 */ this.nuControl = nuControl;
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */ public void addDetalle(In997RegafiUpdateExcepcion detalleExcepcion)
	/*     */ {
		/* 144 */ this.in997RegafiUpdateExcepcion.add(detalleExcepcion);
		/*     */ }

	/*     */
	/*     */ public List<In997RegafiUpdateExcepcion> getDetallesExcepcion() {
		/* 148 */ return this.in997RegafiUpdateExcepcion;
		/*     */ }

	/*     */
	/*     */ public ArrayList<In997RegafiUpdateExcepcion> getIn271RegafiUpdateExcepcion() {
		/* 152 */ return this.in997RegafiUpdateExcepcion;
		/*     */ }

	/*     */
	/*     */ public void setIn271RegafiUpdateExcepcion(
			ArrayList<In997RegafiUpdateExcepcion> in997RegafiUpdateExcepcion) {
		/* 156 */ this.in997RegafiUpdateExcepcion = in997RegafiUpdateExcepcion;
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ public String getNuControlST()
	/*     */ {
		/* 168 */ return this.nuControlST;
		/*     */ }

	/*     */
	/*     */ public void setNuControlST(String nuControlST) {
		/* 172 */ this.nuControlST = nuControlST;
		/*     */ }

	/*     */
	/*     */ public boolean isFlag() {
		/* 176 */ return this.flag;
		/*     */ }

	/*     */
	/*     */ public void setFlag(boolean flag) {
		/* 180 */ this.flag = flag;
		/*     */ }
}
