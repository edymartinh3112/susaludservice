/*    */ package pe.com.susalud.jr.transaccion.afiliacion.trama.bean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SubTrama_N3
/*    */   extends SubTrama
/*    */ {
/*    */   public SubTrama_N3()
/*    */   {
/* 14 */     this.num_CamposSubTrama = 2;
/*    */     
/* 16 */     this.campoSubTrama[0] = new Campos();
/* 17 */     this.campoSubTrama[1] = new Campos();
/*    */     
/* 19 */     this.campoSubTrama[0].orden = 1;
/* 20 */     this.campoSubTrama[0].nombre = "N301";
/* 21 */     this.campoSubTrama[0].atributo = "Alfanumerico";
/* 22 */     this.campoSubTrama[0].ubicacionByte = 0;
/* 23 */     this.campoSubTrama[0].longitudmin = 1;
/* 24 */     this.campoSubTrama[0].longitudmax = 55;
/* 25 */     this.campoSubTrama[0].descripcion = "Direccion01";
/* 26 */     this.campoSubTrama[0].contenido = "";
/* 27 */     this.campoSubTrama[0].requerido = 1;
/* 28 */     this.campoSubTrama[0].validar = 0;
/*    */     
/* 30 */     this.campoSubTrama[1].orden = 2;
/* 31 */     this.campoSubTrama[1].nombre = "N302";
/* 32 */     this.campoSubTrama[1].atributo = "Alfanumerico";
/* 33 */     this.campoSubTrama[1].ubicacionByte = 0;
/* 34 */     this.campoSubTrama[1].longitudmin = 1;
/* 35 */     this.campoSubTrama[1].longitudmax = 55;
/* 36 */     this.campoSubTrama[1].descripcion = "Direccion02";
/* 37 */     this.campoSubTrama[1].contenido = "";
/* 38 */     this.campoSubTrama[1].requerido = 1;
/* 39 */     this.campoSubTrama[1].validar = 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public void generaSubTrama(String sParameter1, String sParameter2)
/*    */   {
/* 45 */     this.campoSubTrama[0].contenido = sParameter1;
/* 46 */     this.campoSubTrama[1].contenido = sParameter2;
/*    */   }
/*    */ }


/* Location:              D:\WorkSpace\Desarrollo Afiliacion On Linea\Fuentes\FebanAfiliacionesFH\lib\jr-afiliacion-susalud_v1.5.jar!\pe\gob\susalud\jr\transaccion\susalud\trama\SubTrama_N3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */