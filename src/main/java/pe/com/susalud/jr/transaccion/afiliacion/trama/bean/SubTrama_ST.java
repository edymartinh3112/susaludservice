/*    */ package pe.com.susalud.jr.transaccion.afiliacion.trama.bean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SubTrama_ST
/*    */   extends SubTrama
/*    */ {
/*    */   public SubTrama_ST()
/*    */   {
/* 12 */     this.num_CamposSubTrama = 3;
/*    */     
/* 14 */     this.campoSubTrama[0] = new Campos();
/* 15 */     this.campoSubTrama[1] = new Campos();
/* 16 */     this.campoSubTrama[2] = new Campos();
/*    */     
/* 18 */     this.campoSubTrama[0].orden = 1;
/* 19 */     this.campoSubTrama[0].nombre = "ST01";
/* 20 */     this.campoSubTrama[0].atributo = "Numerico";
/* 21 */     this.campoSubTrama[0].ubicacionByte = 0;
/* 22 */     this.campoSubTrama[0].longitudmin = 3;
/* 23 */     this.campoSubTrama[0].longitudmax = 3;
/* 24 */     this.campoSubTrama[0].descripcion = "";
/* 25 */     this.campoSubTrama[0].contenido = "00";
/* 26 */     this.campoSubTrama[0].requerido = 1;
/* 27 */     this.campoSubTrama[0].validar = 0;
/*    */     
/* 29 */     this.campoSubTrama[1].orden = 2;
/* 30 */     this.campoSubTrama[1].nombre = "ST02";
/* 31 */     this.campoSubTrama[1].atributo = "Alfanumerico";
/* 32 */     this.campoSubTrama[1].ubicacionByte = 0;
/* 33 */     this.campoSubTrama[1].longitudmin = 4;
/* 34 */     this.campoSubTrama[1].longitudmax = 9;
/* 35 */     this.campoSubTrama[1].descripcion = "";
/* 36 */     this.campoSubTrama[1].contenido = "";
/* 37 */     this.campoSubTrama[1].requerido = 1;
/* 38 */     this.campoSubTrama[1].validar = 0;
/*    */     
/* 40 */     this.campoSubTrama[2].orden = 3;
/* 41 */     this.campoSubTrama[2].nombre = "ST03";
/* 42 */     this.campoSubTrama[2].atributo = "Alfanumerico";
/* 43 */     this.campoSubTrama[2].ubicacionByte = 0;
/* 44 */     this.campoSubTrama[2].longitudmin = 1;
/* 45 */     this.campoSubTrama[2].longitudmax = 35;
/* 46 */     this.campoSubTrama[2].descripcion = "";
/* 47 */     this.campoSubTrama[2].contenido = "";
/* 48 */     this.campoSubTrama[2].requerido = 1;
/* 49 */     this.campoSubTrama[2].validar = 0;
/*    */   }
/*    */   
/*    */   public void generaSubTrama(String sNuControl) {
/* 53 */     this.campoSubTrama[1].contenido = sNuControl;
/*    */   }
/*    */   
/*    */   public void generaSubTrama(String sIdTransaccion, String sNuControl, String sCantArray) {
/* 57 */     this.campoSubTrama[0].contenido = sIdTransaccion;
/* 58 */     this.campoSubTrama[1].contenido = sNuControl;
/* 59 */     this.campoSubTrama[2].contenido = sCantArray;
/*    */   }
/*    */ }


/* Location:              D:\WorkSpace\Desarrollo Afiliacion On Linea\Fuentes\FebanAfiliacionesFH\lib\jr-afiliacion-susalud_v1.5.jar!\pe\gob\susalud\jr\transaccion\susalud\trama\SubTrama_ST.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */