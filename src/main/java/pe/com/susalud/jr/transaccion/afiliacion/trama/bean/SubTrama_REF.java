/*    */ package pe.com.susalud.jr.transaccion.afiliacion.trama.bean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SubTrama_REF
/*    */   extends SubTrama
/*    */ {
/*    */   public SubTrama_REF()
/*    */   {
/* 12 */     this.num_CamposSubTrama = 3;
/*    */     
/* 14 */     this.campoSubTrama[0] = new Campos();
/* 15 */     this.campoSubTrama[1] = new Campos();
/* 16 */     this.campoSubTrama[2] = new Campos();
/*    */     
/* 18 */     this.campoSubTrama[0].orden = 1;
/* 19 */     this.campoSubTrama[0].nombre = "REF01";
/* 20 */     this.campoSubTrama[0].atributo = "Alfanumerico";
/* 21 */     this.campoSubTrama[0].ubicacionByte = 0;
/* 22 */     this.campoSubTrama[0].longitudmin = 2;
/* 23 */     this.campoSubTrama[0].longitudmax = 3;
/* 24 */     this.campoSubTrama[0].descripcion = "Codigo de identificacion de referencia";
/* 25 */     this.campoSubTrama[0].contenido = "";
/* 26 */     this.campoSubTrama[0].requerido = 1;
/* 27 */     this.campoSubTrama[0].validar = 0;
/*    */     
/* 29 */     this.campoSubTrama[1].orden = 2;
/* 30 */     this.campoSubTrama[1].nombre = "REF02";
/* 31 */     this.campoSubTrama[1].atributo = "Alfanumerico";
/* 32 */     this.campoSubTrama[1].ubicacionByte = 0;
/* 33 */     this.campoSubTrama[1].longitudmin = 1;
/* 34 */     this.campoSubTrama[1].longitudmax = 50;
/* 35 */     this.campoSubTrama[1].descripcion = "Referencia de informacion";
/* 36 */     this.campoSubTrama[1].contenido = "";
/* 37 */     this.campoSubTrama[1].requerido = 1;
/* 38 */     this.campoSubTrama[1].validar = 0;
/*    */     
/* 40 */     this.campoSubTrama[2].orden = 3;
/* 41 */     this.campoSubTrama[2].nombre = "REF03";
/* 42 */     this.campoSubTrama[2].atributo = "Alfanumerico";
/* 43 */     this.campoSubTrama[2].ubicacionByte = 0;
/* 44 */     this.campoSubTrama[2].longitudmin = 1;
/* 45 */     this.campoSubTrama[2].longitudmax = 80;
/* 46 */     this.campoSubTrama[2].descripcion = "Descripcion";
/* 47 */     this.campoSubTrama[2].contenido = "";
/* 48 */     this.campoSubTrama[2].requerido = 1;
/* 49 */     this.campoSubTrama[2].validar = 0;
/*    */   }
/*    */   
/*    */   public void generaSubTrama(String sParam1, String sParam2) {
/* 53 */     this.campoSubTrama[0].contenido = sParam1;
/* 54 */     this.campoSubTrama[1].contenido = sParam2;
/*    */   }
/*    */   
/*    */   public void generaSubTrama(String sParam1, String sParam2, String sParam3) {
/* 58 */     this.campoSubTrama[0].contenido = sParam1;
/* 59 */     this.campoSubTrama[1].contenido = sParam2;
/* 60 */     this.campoSubTrama[2].contenido = sParam3;
/*    */   }
/*    */ }


/* Location:              D:\WorkSpace\Desarrollo Afiliacion On Linea\Fuentes\FebanAfiliacionesFH\lib\jr-afiliacion-susalud_v1.5.jar!\pe\gob\susalud\jr\transaccion\susalud\trama\SubTrama_REF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */