/*    */ package pe.com.susalud.jr.transaccion.afiliacion.trama.bean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SubTrama_HSD
/*    */   extends SubTrama
/*    */ {
/*    */   public SubTrama_HSD()
/*    */   {
/* 15 */     this.num_CamposSubTrama = 2;
/*    */     
/* 17 */     this.campoSubTrama[0] = new Campos();
/* 18 */     this.campoSubTrama[1] = new Campos();
/*    */     
/* 20 */     this.campoSubTrama[0].orden = 1;
/* 21 */     this.campoSubTrama[0].nombre = "HSD01";
/* 22 */     this.campoSubTrama[0].atributo = "Alfanumerico";
/* 23 */     this.campoSubTrama[0].ubicacionByte = 0;
/* 24 */     this.campoSubTrama[0].longitudmin = 2;
/* 25 */     this.campoSubTrama[0].longitudmax = 2;
/* 26 */     this.campoSubTrama[0].descripcion = "Identificador Cantidad";
/* 27 */     this.campoSubTrama[0].contenido = "";
/* 28 */     this.campoSubTrama[0].requerido = 1;
/* 29 */     this.campoSubTrama[0].validar = 0;
/*    */     
/* 31 */     this.campoSubTrama[1].orden = 2;
/* 32 */     this.campoSubTrama[1].nombre = "HSD02";
/* 33 */     this.campoSubTrama[1].atributo = "Alfanumerico";
/* 34 */     this.campoSubTrama[1].ubicacionByte = 0;
/* 35 */     this.campoSubTrama[1].longitudmin = 1;
/* 36 */     this.campoSubTrama[1].longitudmax = 3;
/* 37 */     this.campoSubTrama[1].descripcion = "Cantidad";
/* 38 */     this.campoSubTrama[1].contenido = "";
/* 39 */     this.campoSubTrama[1].requerido = 1;
/* 40 */     this.campoSubTrama[1].validar = 0;
/*    */   }
/*    */   
/*    */   public void generaSubTrama(String sParameter1, String sParameter2) {
/* 44 */     this.campoSubTrama[0].contenido = sParameter1;
/* 45 */     this.campoSubTrama[1].contenido = sParameter2;
/*    */   }
/*    */ }


/* Location:              D:\WorkSpace\Desarrollo Afiliacion On Linea\Fuentes\FebanAfiliacionesFH\lib\jr-afiliacion-susalud_v1.5.jar!\pe\gob\susalud\jr\transaccion\susalud\trama\SubTrama_HSD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */