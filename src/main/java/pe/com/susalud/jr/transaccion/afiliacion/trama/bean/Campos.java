package pe.com.susalud.jr.transaccion.afiliacion.trama.bean;

public class Campos {
	int orden = 0;
	String nombre = "";
	String atributo = "";
	int ubicacionByte = 0;
	int longitudmin = 0;
	int longitudmax = 0;
	String descripcion = "";
	String contenido = "";
	int requerido = 1;
	int validar = 0;

	void imprimeContenido() {
		char bitIni = '.';
		char bitFin = '.';
		System.out.println("(" + this.orden + ")" + this.nombre + "(" + this.atributo + ")" + "(" + this.descripcion
				+ ")" + "[" + "[" + this.ubicacionByte + "]" + ":[" + this.longitudmin + "]" + ":[" + this.longitudmax
				+ "]" + ":[" + this.requerido + "]" + bitIni + this.contenido + bitFin);
	}

	void llenaCampo(String TramaLlegada) {
		this.contenido = TramaLlegada.substring(this.ubicacionByte, this.ubicacionByte + this.longitudmax);
	}

	/*    */
	/*    */ void completaLongitud() {
		/* 35 */ int longitudReal = 0;
		/* 36 */ char vacio = ' ';
		/*    */
		/* 38 */ if (this.contenido == null)
			longitudReal = 0;
		else {
			/* 39 */ longitudReal = this.contenido.length();
			/*    */ }
		/* 41 */ if ((this.longitudmax < longitudReal) || (this.contenido == null)) {
			/* 42 */ if (this.atributo.equals("Numerico")) {
				this.contenido = "0";
				/* 43 */ } else if (this.atributo.equals("Alfanumerico")) {
				this.contenido = "";
				/*    */ }
			/*    */ }
		/* 46 */ for (int c_ont_aux = 0; c_ont_aux < this.longitudmax - longitudReal; c_ont_aux++) {
			/* 47 */ if (this.atributo.equals("Numerico")) {
				/* 48 */ vacio = '0';
				/* 49 */ this.contenido = (vacio + this.contenido);
				/* 50 */ } else if (this.atributo.equals("Alfanumerico")) {
				/* 51 */ vacio = ' ';
				/* 52 */ this.contenido += vacio;
				/*    */ }
			/*    */ }
		/*    */ }
}
