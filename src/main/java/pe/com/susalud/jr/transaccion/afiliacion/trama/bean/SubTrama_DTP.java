/*    */ package pe.com.susalud.jr.transaccion.afiliacion.trama.bean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SubTrama_DTP
/*    */   extends SubTrama
/*    */ {
/*    */   public SubTrama_DTP()
/*    */   {
/* 15 */     this.num_CamposSubTrama = 3;
/*    */     
/* 17 */     this.campoSubTrama[0] = new Campos();
/* 18 */     this.campoSubTrama[1] = new Campos();
/* 19 */     this.campoSubTrama[2] = new Campos();
/*    */     
/* 21 */     this.campoSubTrama[0].orden = 1;
/* 22 */     this.campoSubTrama[0].nombre = "DTP01";
/* 23 */     this.campoSubTrama[0].atributo = "Alfanumerico";
/* 24 */     this.campoSubTrama[0].ubicacionByte = 0;
/* 25 */     this.campoSubTrama[0].longitudmin = 3;
/* 26 */     this.campoSubTrama[0].longitudmax = 3;
/* 27 */     this.campoSubTrama[0].descripcion = "Código Identificador Fecha u Hora";
/* 28 */     this.campoSubTrama[0].contenido = "";
/* 29 */     this.campoSubTrama[0].requerido = 1;
/* 30 */     this.campoSubTrama[0].validar = 0;
/*    */     
/* 32 */     this.campoSubTrama[1].orden = 2;
/* 33 */     this.campoSubTrama[1].nombre = "DTP02";
/* 34 */     this.campoSubTrama[1].atributo = "Alfanumerico";
/* 35 */     this.campoSubTrama[1].ubicacionByte = 0;
/* 36 */     this.campoSubTrama[1].longitudmin = 2;
/* 37 */     this.campoSubTrama[1].longitudmax = 3;
/* 38 */     this.campoSubTrama[1].descripcion = "Código identificador de Formato";
/* 39 */     this.campoSubTrama[1].contenido = "";
/* 40 */     this.campoSubTrama[1].requerido = 1;
/* 41 */     this.campoSubTrama[1].validar = 0;
/*    */     
/* 43 */     this.campoSubTrama[2].orden = 3;
/* 44 */     this.campoSubTrama[2].nombre = "DTP03";
/* 45 */     this.campoSubTrama[2].atributo = "Alfanumerico";
/* 46 */     this.campoSubTrama[2].ubicacionByte = 0;
/* 47 */     this.campoSubTrama[2].longitudmin = 1;
/* 48 */     this.campoSubTrama[2].longitudmax = 35;
/* 49 */     this.campoSubTrama[2].descripcion = "Fecha";
/* 50 */     this.campoSubTrama[2].contenido = "";
/* 51 */     this.campoSubTrama[2].requerido = 1;
/* 52 */     this.campoSubTrama[2].validar = 0;
/*    */   }
/*    */   
/*    */   public void generaSubTrama(String sIdentificadorFecha, String sFormatofecha, String sParameterFecha) {
/* 56 */     this.campoSubTrama[0].contenido = sIdentificadorFecha;
/* 57 */     this.campoSubTrama[1].contenido = sFormatofecha;
/* 58 */     this.campoSubTrama[2].contenido = sParameterFecha;
/*    */   }
/*    */ }


/* Location:              D:\WorkSpace\Desarrollo Afiliacion On Linea\Fuentes\FebanAfiliacionesFH\lib\jr-afiliacion-susalud_v1.5.jar!\pe\gob\susalud\jr\transaccion\susalud\trama\SubTrama_DTP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */