package pe.com.susalud.jr.transaccion.afiliacion.trama.bean;

public class SubTrama {
	int num_CamposSubTrama = 50;
	/* 12 */ int longitud_SubTrama = 1000;
	/* 13 */ String contenidoSubTrama = "";
	/* 14 */ String codigoErrorSubtrama = "0000";
	/* 15 */ Campos[] campoSubTrama = new Campos[120];

	/*    */
	/*    */ public void recibeContenidoSubTrama(String SubTramaEntradaTotal)
	/*    */ {
		/* 19 */ this.contenidoSubTrama = SubTramaEntradaTotal;
		/*    */ }

	/*    */
	/*    */ public void procesaSubTrama() {
		/* 23 */ fijaLongitud();
		/* 24 */ if (this.longitud_SubTrama <= this.contenidoSubTrama.length())
		/*    */ {
			/*    */
			/*    */
			/* 28 */ for (int i = 0; i < this.num_CamposSubTrama; i++)
			/*    */ {
				/* 30 */ if (i == 0) {
					/* 31 */ this.campoSubTrama[i].ubicacionByte = 0;
					/* 32 */ this.campoSubTrama[i].orden = 1;
					/*    */ } else {
					/* 34 */ this.campoSubTrama[i].ubicacionByte = (this.campoSubTrama[(i - 1)].ubicacionByte
							+ this.campoSubTrama[(i - 1)].longitudmax);
					/* 35 */ this.campoSubTrama[i].orden = (i + 1);
					/*    */ }
				/* 37 */ this.longitud_SubTrama = (this.campoSubTrama[i].ubicacionByte
						+ this.campoSubTrama[i].longitudmax);
				/* 38 */ this.campoSubTrama[i].llenaCampo(this.contenidoSubTrama);
				/*    */ }
			/*    */ } else {
			/* 41 */ this.codigoErrorSubtrama = "5100";
			/*    */ }
		/*    */ }

	/*    */
	/*    */ public String returnComoString(String sPrefijo, String sCampo, String sSegmento)
	/*    */ {
		/* 47 */ String cadena = sPrefijo;
		/* 48 */ for (int i1 = 0; i1 < this.num_CamposSubTrama - 1; i1++) {
			/* 49 */ cadena = cadena + this.campoSubTrama[i1].contenido + sCampo;
			/*    */ }
		/* 51 */ cadena = cadena + this.campoSubTrama[(this.num_CamposSubTrama - 1)].contenido + sSegmento;
		/* 52 */ return cadena;
		/*    */ }

	/*    */
	/*    */ public void imprimecampos() {
		/* 56 */ int ini_ = 0;
		/* 57 */ int fin_ = this.num_CamposSubTrama;
		/* 58 */ for (int c_ont_aux = ini_; c_ont_aux < fin_; c_ont_aux++) {
			/* 59 */ this.campoSubTrama[c_ont_aux].imprimeContenido();
			/*    */ }
		/*    */ }

	/*    */
	/*    */ public void completaLongitud() {
		/* 64 */ int ini_ = 0;
		/* 65 */ int fin_ = this.num_CamposSubTrama;
		/* 66 */ for (int c_ont_aux = ini_; c_ont_aux < fin_; c_ont_aux++) {
			/* 67 */ this.campoSubTrama[c_ont_aux].completaLongitud();
			/*    */ }
		/*    */ }

	/*    */
	/*    */ public void fijaLongitud() {
		/* 72 */ this.longitud_SubTrama = 0;
		/* 73 */ for (int i = 0; i < this.num_CamposSubTrama; i++) {
			/* 74 */ this.longitud_SubTrama += this.campoSubTrama[i].longitudmax;
			/*    */ }
		/*    */ }

	/*    */
	/*    */ public String getCampoSubTrama(int pos) {
		/* 79 */ return this.campoSubTrama[pos].contenido.trim();
		/*    */ }

	/*    */
	/*    */ public void setCodigoErrorSubtrama(String error) {
		/* 83 */ this.codigoErrorSubtrama = error;
		/*    */ }

	/*    */
	/*    */ public String getCodigoErrorSubtrama() {
		/* 87 */ return this.codigoErrorSubtrama;
		/*    */ }
}
