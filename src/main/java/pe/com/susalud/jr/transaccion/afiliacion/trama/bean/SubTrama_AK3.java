/*    */ package pe.com.susalud.jr.transaccion.afiliacion.trama.bean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SubTrama_AK3
/*    */   extends SubTrama
/*    */ {
/*    */   public SubTrama_AK3()
/*    */   {
/* 13 */     this.num_CamposSubTrama = 4;
/*    */     
/* 15 */     this.campoSubTrama[0] = new Campos();
/* 16 */     this.campoSubTrama[1] = new Campos();
/* 17 */     this.campoSubTrama[2] = new Campos();
/* 18 */     this.campoSubTrama[3] = new Campos();
/*    */     
/* 20 */     this.campoSubTrama[0].orden = 1;
/* 21 */     this.campoSubTrama[0].nombre = "AK301";
/* 22 */     this.campoSubTrama[0].atributo = "Alfanumerico";
/* 23 */     this.campoSubTrama[0].ubicacionByte = 0;
/* 24 */     this.campoSubTrama[0].longitudmin = 2;
/* 25 */     this.campoSubTrama[0].longitudmax = 3;
/* 26 */     this.campoSubTrama[0].descripcion = "IDcode";
/* 27 */     this.campoSubTrama[0].contenido = "";
/* 28 */     this.campoSubTrama[0].requerido = 1;
/* 29 */     this.campoSubTrama[0].validar = 0;
/*    */     
/* 31 */     this.campoSubTrama[1].orden = 2;
/* 32 */     this.campoSubTrama[1].nombre = "AK302";
/* 33 */     this.campoSubTrama[1].atributo = "Alfanumerico";
/* 34 */     this.campoSubTrama[1].ubicacionByte = 0;
/* 35 */     this.campoSubTrama[1].longitudmin = 1;
/* 36 */     this.campoSubTrama[1].longitudmax = 10;
/* 37 */     this.campoSubTrama[1].descripcion = "segPosTx";
/* 38 */     this.campoSubTrama[1].contenido = "";
/* 39 */     this.campoSubTrama[1].requerido = 1;
/* 40 */     this.campoSubTrama[1].validar = 0;
/*    */     
/* 42 */     this.campoSubTrama[2].orden = 3;
/* 43 */     this.campoSubTrama[2].nombre = "AK303";
/* 44 */     this.campoSubTrama[2].atributo = "Alfanumerico";
/* 45 */     this.campoSubTrama[2].ubicacionByte = 0;
/* 46 */     this.campoSubTrama[2].longitudmin = 1;
/* 47 */     this.campoSubTrama[2].longitudmax = 4;
/* 48 */     this.campoSubTrama[2].descripcion = "loopIdCode";
/* 49 */     this.campoSubTrama[2].contenido = "";
/* 50 */     this.campoSubTrama[2].requerido = 1;
/* 51 */     this.campoSubTrama[2].validar = 0;
/*    */     
/* 53 */     this.campoSubTrama[3].orden = 4;
/* 54 */     this.campoSubTrama[3].nombre = "AK303";
/* 55 */     this.campoSubTrama[3].atributo = "Alfanumerico";
/* 56 */     this.campoSubTrama[3].ubicacionByte = 0;
/* 57 */     this.campoSubTrama[3].longitudmin = 1;
/* 58 */     this.campoSubTrama[3].longitudmax = 3;
/* 59 */     this.campoSubTrama[3].descripcion = "segSintxisErrorCode";
/* 60 */     this.campoSubTrama[3].contenido = "";
/* 61 */     this.campoSubTrama[3].requerido = 1;
/* 62 */     this.campoSubTrama[3].validar = 0;
/*    */   }
/*    */   
/*    */   public void generaSubTrama(String sParameter1, String sParameter2) {
/* 66 */     this.campoSubTrama[0].contenido = sParameter1;
/* 67 */     this.campoSubTrama[1].contenido = sParameter2;
/*    */   }
/*    */ }


/* Location:              D:\WorkSpace\Desarrollo Afiliacion On Linea\Fuentes\FebanAfiliacionesFH\lib\jr-afiliacion-susalud_v1.5.jar!\pe\gob\susalud\jr\transaccion\susalud\trama\SubTrama_AK3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */