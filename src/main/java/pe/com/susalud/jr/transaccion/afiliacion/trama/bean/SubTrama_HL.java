/*    */ package pe.com.susalud.jr.transaccion.afiliacion.trama.bean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SubTrama_HL
/*    */   extends SubTrama
/*    */ {
/*    */   public SubTrama_HL()
/*    */   {
/* 12 */     this.num_CamposSubTrama = 4;
/*    */     
/* 14 */     this.campoSubTrama[0] = new Campos();
/* 15 */     this.campoSubTrama[1] = new Campos();
/* 16 */     this.campoSubTrama[2] = new Campos();
/* 17 */     this.campoSubTrama[3] = new Campos();
/*    */     
/* 19 */     this.campoSubTrama[0].orden = 1;
/* 20 */     this.campoSubTrama[0].nombre = "HL01";
/* 21 */     this.campoSubTrama[0].atributo = "Alfanumerico";
/* 22 */     this.campoSubTrama[0].ubicacionByte = 0;
/* 23 */     this.campoSubTrama[0].longitudmin = 1;
/* 24 */     this.campoSubTrama[0].longitudmax = 12;
/* 25 */     this.campoSubTrama[0].descripcion = "";
/* 26 */     this.campoSubTrama[0].contenido = "1";
/* 27 */     this.campoSubTrama[0].requerido = 1;
/* 28 */     this.campoSubTrama[0].validar = 0;
/*    */     
/* 30 */     this.campoSubTrama[1].orden = 2;
/* 31 */     this.campoSubTrama[1].nombre = "HL02";
/* 32 */     this.campoSubTrama[1].atributo = "Alfanumerico";
/* 33 */     this.campoSubTrama[1].ubicacionByte = 0;
/* 34 */     this.campoSubTrama[1].longitudmin = 1;
/* 35 */     this.campoSubTrama[1].longitudmax = 12;
/* 36 */     this.campoSubTrama[1].descripcion = "";
/* 37 */     this.campoSubTrama[1].contenido = "";
/* 38 */     this.campoSubTrama[1].requerido = 1;
/* 39 */     this.campoSubTrama[1].validar = 0;
/*    */     
/* 41 */     this.campoSubTrama[2].orden = 3;
/* 42 */     this.campoSubTrama[2].nombre = "HL03";
/* 43 */     this.campoSubTrama[2].atributo = "Numerico";
/* 44 */     this.campoSubTrama[2].ubicacionByte = 0;
/* 45 */     this.campoSubTrama[2].longitudmin = 1;
/* 46 */     this.campoSubTrama[2].longitudmax = 2;
/* 47 */     this.campoSubTrama[2].descripcion = "";
/* 48 */     this.campoSubTrama[2].contenido = "20";
/* 49 */     this.campoSubTrama[2].requerido = 1;
/* 50 */     this.campoSubTrama[2].validar = 0;
/*    */     
/* 52 */     this.campoSubTrama[3].orden = 4;
/* 53 */     this.campoSubTrama[3].nombre = "HL04";
/* 54 */     this.campoSubTrama[3].atributo = "Numerico";
/* 55 */     this.campoSubTrama[3].ubicacionByte = 0;
/* 56 */     this.campoSubTrama[3].longitudmin = 1;
/* 57 */     this.campoSubTrama[3].longitudmax = 1;
/* 58 */     this.campoSubTrama[3].descripcion = "";
/* 59 */     this.campoSubTrama[3].contenido = "1";
/* 60 */     this.campoSubTrama[3].requerido = 1;
/* 61 */     this.campoSubTrama[3].validar = 0;
/*    */   }
/*    */   
/*    */   public void generaSubTrama(String sNuJerarquico, String sCoJerarquico, String sCoIndicador) {
/* 65 */     this.campoSubTrama[0].contenido = sNuJerarquico;
/* 66 */     this.campoSubTrama[2].contenido = sCoJerarquico;
/* 67 */     this.campoSubTrama[3].contenido = sCoIndicador;
/*    */   }
/*    */   
/*    */   public void generaSubTrama(String sNuJerarquico, String sNuPadreJerarquico, String sCoJerarquico, String sCoIndicaSegmentos) {
/* 71 */     this.campoSubTrama[0].contenido = sNuJerarquico;
/* 72 */     this.campoSubTrama[1].contenido = sNuPadreJerarquico;
/* 73 */     this.campoSubTrama[2].contenido = sCoJerarquico;
/* 74 */     this.campoSubTrama[3].contenido = sCoIndicaSegmentos;
/*    */   }
/*    */ }


/* Location:              D:\WorkSpace\Desarrollo Afiliacion On Linea\Fuentes\FebanAfiliacionesFH\lib\jr-afiliacion-susalud_v1.5.jar!\pe\gob\susalud\jr\transaccion\susalud\trama\SubTrama_HL.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */