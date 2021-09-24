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
/*    */ public class SubTrama_SV2
/*    */   extends SubTrama
/*    */ {
/*    */   public SubTrama_SV2()
/*    */   {
/* 16 */     this.num_CamposSubTrama = 2;
/*    */     
/* 18 */     this.campoSubTrama[0] = new Campos();
/* 19 */     this.campoSubTrama[1] = new Campos();
/*    */     
/* 21 */     this.campoSubTrama[0].orden = 1;
/* 22 */     this.campoSubTrama[0].nombre = "SV201";
/* 23 */     this.campoSubTrama[0].atributo = "Alfanumerico";
/* 24 */     this.campoSubTrama[0].ubicacionByte = 0;
/* 25 */     this.campoSubTrama[0].longitudmin = 1;
/* 26 */     this.campoSubTrama[0].longitudmax = 18;
/* 27 */     this.campoSubTrama[0].descripcion = "Monto Monetario";
/* 28 */     this.campoSubTrama[0].contenido = "";
/* 29 */     this.campoSubTrama[0].requerido = 1;
/* 30 */     this.campoSubTrama[0].validar = 0;
/*    */   }
/*    */   
/*    */   public void generaSubTrama(String sParameter)
/*    */   {
/* 35 */     this.campoSubTrama[0].contenido = sParameter;
/*    */   }
/*    */ }


/* Location:              D:\WorkSpace\Desarrollo Afiliacion On Linea\Fuentes\FebanAfiliacionesFH\lib\jr-afiliacion-susalud_v1.5.jar!\pe\gob\susalud\jr\transaccion\susalud\trama\SubTrama_SV2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */