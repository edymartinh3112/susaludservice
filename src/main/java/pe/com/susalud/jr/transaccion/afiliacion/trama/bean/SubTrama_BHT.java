/*    */ package  pe.com.susalud.jr.transaccion.afiliacion.trama.bean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SubTrama_BHT
/*    */   extends SubTrama
/*    */ {
/*    */   public SubTrama_BHT()
/*    */   {
/* 12 */     this.num_CamposSubTrama = 2;
/*    */     
/* 14 */     this.campoSubTrama[0] = new Campos();
/* 15 */     this.campoSubTrama[1] = new Campos();
/*    */     
/* 17 */     this.campoSubTrama[0].orden = 1;
/* 18 */     this.campoSubTrama[0].nombre = "BHT01";
/* 19 */     this.campoSubTrama[0].atributo = "Numerico";
/* 20 */     this.campoSubTrama[0].ubicacionByte = 0;
/* 21 */     this.campoSubTrama[0].longitudmin = 4;
/* 22 */     this.campoSubTrama[0].longitudmax = 4;
/* 23 */     this.campoSubTrama[0].descripcion = "";
/* 24 */     this.campoSubTrama[0].contenido = "0022";
/* 25 */     this.campoSubTrama[0].requerido = 1;
/* 26 */     this.campoSubTrama[0].validar = 0;
/*    */     
/* 28 */     this.campoSubTrama[1].orden = 2;
/* 29 */     this.campoSubTrama[1].nombre = "BHT02";
/* 30 */     this.campoSubTrama[1].atributo = "Numerico";
/* 31 */     this.campoSubTrama[1].ubicacionByte = 0;
/* 32 */     this.campoSubTrama[1].longitudmin = 2;
/* 33 */     this.campoSubTrama[1].longitudmax = 2;
/* 34 */     this.campoSubTrama[1].descripcion = "";
/* 35 */     this.campoSubTrama[1].contenido = "13";
/* 36 */     this.campoSubTrama[1].requerido = 1;
/* 37 */     this.campoSubTrama[1].validar = 0;
/*    */   }
/*    */   
/*    */   public void generaSubTrama(String sCoJerarquico, String sTiFinalidad) {
/* 41 */     this.campoSubTrama[0].contenido = sCoJerarquico;
/* 42 */     this.campoSubTrama[1].contenido = sTiFinalidad;
/*    */   }
/*    */ }


/* Location:              D:\WorkSpace\Desarrollo Afiliacion On Linea\Fuentes\FebanAfiliacionesFH\lib\jr-afiliacion-susalud_v1.5.jar!\pe\gob\susalud\jr\transaccion\susalud\trama\SubTrama_BHT.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */