/*    */ package pe.com.susalud.jr.transaccion.afiliacion.trama.bean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SubTrama_SV1
/*    */   extends SubTrama
/*    */ {
/*    */   public SubTrama_SV1()
/*    */   {
/* 16 */     this.num_CamposSubTrama = 2;
/*    */     
/* 18 */     this.campoSubTrama[0] = new Campos();
/* 19 */     this.campoSubTrama[1] = new Campos();
/*    */     
/* 21 */     this.campoSubTrama[0].orden = 1;
/* 22 */     this.campoSubTrama[0].nombre = "SV101";
/* 23 */     this.campoSubTrama[0].atributo = "Alfanumerico";
/* 24 */     this.campoSubTrama[0].ubicacionByte = 0;
/* 25 */     this.campoSubTrama[0].longitudmin = 2;
/* 26 */     this.campoSubTrama[0].longitudmax = 2;
/* 27 */     this.campoSubTrama[0].descripcion = "ID Calificador";
/* 28 */     this.campoSubTrama[0].contenido = "";
/* 29 */     this.campoSubTrama[0].requerido = 1;
/* 30 */     this.campoSubTrama[0].validar = 0;
/*    */     
/* 32 */     this.campoSubTrama[1].orden = 2;
/* 33 */     this.campoSubTrama[1].nombre = "SV102";
/* 34 */     this.campoSubTrama[1].atributo = "Alfanumerico";
/* 35 */     this.campoSubTrama[1].ubicacionByte = 0;
/* 36 */     this.campoSubTrama[1].longitudmin = 1;
/* 37 */     this.campoSubTrama[1].longitudmax = 2;
/* 38 */     this.campoSubTrama[1].descripcion = "ID";
/* 39 */     this.campoSubTrama[1].contenido = "";
/* 40 */     this.campoSubTrama[1].requerido = 1;
/* 41 */     this.campoSubTrama[1].validar = 0;
/*    */   }
/*    */   
/*    */   public void generaSubTrama(String sParameter1, String sParameter2) {
/* 45 */     this.campoSubTrama[0].contenido = sParameter1;
/* 46 */     this.campoSubTrama[1].contenido = sParameter2;
/*    */   }
/*    */ }


/* Location:              D:\WorkSpace\Desarrollo Afiliacion On Linea\Fuentes\FebanAfiliacionesFH\lib\jr-afiliacion-susalud_v1.5.jar!\pe\gob\susalud\jr\transaccion\susalud\trama\SubTrama_SV1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */