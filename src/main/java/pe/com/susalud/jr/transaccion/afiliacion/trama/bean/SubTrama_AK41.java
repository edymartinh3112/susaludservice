/*    */ package  pe.com.susalud.jr.transaccion.afiliacion.trama.bean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SubTrama_AK41
/*    */   extends SubTrama
/*    */ {
/*    */   public SubTrama_AK41()
/*    */   {
/* 13 */     this.num_CamposSubTrama = 3;
/*    */     
/* 15 */     this.campoSubTrama[0] = new Campos();
/* 16 */     this.campoSubTrama[1] = new Campos();
/* 17 */     this.campoSubTrama[2] = new Campos();
/*    */     
/* 19 */     this.campoSubTrama[0].orden = 1;
/* 20 */     this.campoSubTrama[0].nombre = "AK401";
/* 21 */     this.campoSubTrama[0].atributo = "Alfanumerico";
/* 22 */     this.campoSubTrama[0].ubicacionByte = 0;
/* 23 */     this.campoSubTrama[0].longitudmin = 1;
/* 24 */     this.campoSubTrama[0].longitudmax = 2;
/* 25 */     this.campoSubTrama[0].descripcion = "elPosSeg";
/* 26 */     this.campoSubTrama[0].contenido = "";
/* 27 */     this.campoSubTrama[0].requerido = 1;
/* 28 */     this.campoSubTrama[0].validar = 0;
/*    */     
/* 30 */     this.campoSubTrama[1].orden = 2;
/* 31 */     this.campoSubTrama[1].nombre = "AK402";
/* 32 */     this.campoSubTrama[1].atributo = "Alfanumerico";
/* 33 */     this.campoSubTrama[1].ubicacionByte = 0;
/* 34 */     this.campoSubTrama[1].longitudmin = 1;
/* 35 */     this.campoSubTrama[1].longitudmax = 2;
/* 36 */     this.campoSubTrama[1].descripcion = "elPosSeg";
/* 37 */     this.campoSubTrama[1].contenido = "";
/* 38 */     this.campoSubTrama[1].requerido = 1;
/* 39 */     this.campoSubTrama[1].validar = 0;
/*    */     
/* 41 */     this.campoSubTrama[2].orden = 3;
/* 42 */     this.campoSubTrama[2].nombre = "AK403";
/* 43 */     this.campoSubTrama[2].atributo = "Alfanumerico";
/* 44 */     this.campoSubTrama[2].ubicacionByte = 0;
/* 45 */     this.campoSubTrama[2].longitudmin = 1;
/* 46 */     this.campoSubTrama[2].longitudmax = 2;
/* 47 */     this.campoSubTrama[2].descripcion = "elPosSeg";
/* 48 */     this.campoSubTrama[2].contenido = "";
/* 49 */     this.campoSubTrama[2].requerido = 1;
/* 50 */     this.campoSubTrama[2].validar = 0;
/*    */   }
/*    */   
/*    */   public void generaSubTrama(String sParameter1) {
/* 54 */     this.campoSubTrama[0].contenido = sParameter1;
/*    */   }
/*    */ }


/* Location:              D:\WorkSpace\Desarrollo Afiliacion On Linea\Fuentes\FebanAfiliacionesFH\lib\jr-afiliacion-susalud_v1.5.jar!\pe\gob\susalud\jr\transaccion\susalud\trama\SubTrama_AK41.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */