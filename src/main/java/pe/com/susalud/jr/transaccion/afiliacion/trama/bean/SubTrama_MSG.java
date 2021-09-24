/*    */ package pe.com.susalud.jr.transaccion.afiliacion.trama.bean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SubTrama_MSG
/*    */   extends SubTrama
/*    */ {
/*    */   public SubTrama_MSG()
/*    */   {
/* 11 */     this.num_CamposSubTrama = 3;
/*    */     
/* 13 */     this.campoSubTrama[0] = new Campos();
/* 14 */     this.campoSubTrama[1] = new Campos();
/* 15 */     this.campoSubTrama[2] = new Campos();
/*    */     
/* 17 */     this.campoSubTrama[0].orden = 1;
/* 18 */     this.campoSubTrama[0].nombre = "MSG01";
/* 19 */     this.campoSubTrama[0].atributo = "Alfanumerico";
/* 20 */     this.campoSubTrama[0].ubicacionByte = 0;
/* 21 */     this.campoSubTrama[0].longitudmin = 1;
/* 22 */     this.campoSubTrama[0].longitudmax = 264;
/* 23 */     this.campoSubTrama[0].descripcion = "Texto Libre para Mensajes";
/* 24 */     this.campoSubTrama[0].contenido = "";
/* 25 */     this.campoSubTrama[0].requerido = 1;
/* 26 */     this.campoSubTrama[0].validar = 0;
/*    */     
/* 28 */     this.campoSubTrama[1].orden = 2;
/* 29 */     this.campoSubTrama[1].nombre = "MSG02";
/* 30 */     this.campoSubTrama[1].atributo = "Alfanumerico";
/* 31 */     this.campoSubTrama[1].ubicacionByte = 0;
/* 32 */     this.campoSubTrama[1].longitudmin = 2;
/* 33 */     this.campoSubTrama[1].longitudmax = 2;
/* 34 */     this.campoSubTrama[1].descripcion = "Código de control de impresión";
/* 35 */     this.campoSubTrama[1].contenido = "";
/* 36 */     this.campoSubTrama[1].requerido = 1;
/* 37 */     this.campoSubTrama[1].validar = 0;
/*    */     
/* 39 */     this.campoSubTrama[2].orden = 3;
/* 40 */     this.campoSubTrama[2].nombre = "MSG03";
/* 41 */     this.campoSubTrama[2].atributo = "Alfanumerico";
/* 42 */     this.campoSubTrama[2].ubicacionByte = 0;
/* 43 */     this.campoSubTrama[2].longitudmin = 1;
/* 44 */     this.campoSubTrama[2].longitudmax = 9;
/* 45 */     this.campoSubTrama[2].descripcion = "Número";
/* 46 */     this.campoSubTrama[2].contenido = "";
/* 47 */     this.campoSubTrama[2].requerido = 1;
/* 48 */     this.campoSubTrama[2].validar = 0;
/*    */   }
/*    */   
/*    */   public void generaSubTrama(String sTextoMsg) {
/* 52 */     this.campoSubTrama[0].contenido = sTextoMsg;
/*    */   }
/*    */   
/*    */   public void generaSubTrama(String priParametro, String segParametro, String terParametro) {
/* 56 */     this.campoSubTrama[0].contenido = priParametro;
/* 57 */     this.campoSubTrama[1].contenido = segParametro;
/* 58 */     this.campoSubTrama[2].contenido = terParametro;
/*    */   }
/*    */ }


/* Location:              D:\WorkSpace\Desarrollo Afiliacion On Linea\Fuentes\FebanAfiliacionesFH\lib\jr-afiliacion-susalud_v1.5.jar!\pe\gob\susalud\jr\transaccion\susalud\trama\SubTrama_MSG.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */