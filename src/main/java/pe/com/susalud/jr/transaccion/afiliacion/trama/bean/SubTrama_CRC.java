/*    */ package pe.com.susalud.jr.transaccion.afiliacion.trama.bean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SubTrama_CRC
/*    */   extends SubTrama
/*    */ {
/*    */   public SubTrama_CRC()
/*    */   {
/* 15 */     this.num_CamposSubTrama = 3;
/*    */     
/* 17 */     this.campoSubTrama[0] = new Campos();
/* 18 */     this.campoSubTrama[1] = new Campos();
/* 19 */     this.campoSubTrama[2] = new Campos();
/*    */     
/* 21 */     this.campoSubTrama[0].orden = 1;
/* 22 */     this.campoSubTrama[0].nombre = "CRC01";
/* 23 */     this.campoSubTrama[0].atributo = "Alfanumerico";
/* 24 */     this.campoSubTrama[0].ubicacionByte = 0;
/* 25 */     this.campoSubTrama[0].longitudmin = 2;
/* 26 */     this.campoSubTrama[0].longitudmax = 2;
/* 27 */     this.campoSubTrama[0].descripcion = "Cód. Categoria";
/* 28 */     this.campoSubTrama[0].contenido = "";
/* 29 */     this.campoSubTrama[0].requerido = 1;
/* 30 */     this.campoSubTrama[0].validar = 0;
/*    */     
/* 32 */     this.campoSubTrama[1].orden = 2;
/* 33 */     this.campoSubTrama[1].nombre = "CRC02";
/* 34 */     this.campoSubTrama[1].atributo = "Alfanumerico";
/* 35 */     this.campoSubTrama[1].ubicacionByte = 0;
/* 36 */     this.campoSubTrama[1].longitudmin = 1;
/* 37 */     this.campoSubTrama[1].longitudmax = 1;
/* 38 */     this.campoSubTrama[1].descripcion = "Cod Rpta. de Condición";
/* 39 */     this.campoSubTrama[1].contenido = "";
/* 40 */     this.campoSubTrama[1].requerido = 1;
/* 41 */     this.campoSubTrama[1].validar = 0;
/*    */     
/* 43 */     this.campoSubTrama[2].orden = 3;
/* 44 */     this.campoSubTrama[2].nombre = "CRC03";
/* 45 */     this.campoSubTrama[2].atributo = "Alfanumerico";
/* 46 */     this.campoSubTrama[2].ubicacionByte = 0;
/* 47 */     this.campoSubTrama[2].longitudmin = 2;
/* 48 */     this.campoSubTrama[2].longitudmax = 3;
/* 49 */     this.campoSubTrama[2].descripcion = "Indicador Condición";
/* 50 */     this.campoSubTrama[2].contenido = "00";
/* 51 */     this.campoSubTrama[2].requerido = 1;
/* 52 */     this.campoSubTrama[2].validar = 0;
/*    */   }
/*    */   
/*    */   public void generaSubTrama(String sParameter1, String sParameter2) {
/* 56 */     this.campoSubTrama[0].contenido = sParameter1;
/* 57 */     this.campoSubTrama[1].contenido = sParameter2;
/*    */   }
/*    */ }


/* Location:              D:\WorkSpace\Desarrollo Afiliacion On Linea\Fuentes\FebanAfiliacionesFH\lib\jr-afiliacion-susalud_v1.5.jar!\pe\gob\susalud\jr\transaccion\susalud\trama\SubTrama_CRC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */