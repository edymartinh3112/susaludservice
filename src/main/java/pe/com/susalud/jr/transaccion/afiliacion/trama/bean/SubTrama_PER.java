/*     */ package pe.com.susalud.jr.transaccion.afiliacion.trama.bean;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SubTrama_PER
/*     */   extends SubTrama
/*     */ {
/*     */   public SubTrama_PER()
/*     */   {
/*  13 */     this.num_CamposSubTrama = 6;
/*     */     
/*  15 */     this.campoSubTrama[0] = new Campos();
/*  16 */     this.campoSubTrama[1] = new Campos();
/*  17 */     this.campoSubTrama[2] = new Campos();
/*  18 */     this.campoSubTrama[3] = new Campos();
/*  19 */     this.campoSubTrama[4] = new Campos();
/*  20 */     this.campoSubTrama[5] = new Campos();
/*     */     
/*  22 */     this.campoSubTrama[0].orden = 1;
/*  23 */     this.campoSubTrama[0].nombre = "PER01";
/*  24 */     this.campoSubTrama[0].atributo = "Alfanumerico";
/*  25 */     this.campoSubTrama[0].ubicacionByte = 0;
/*  26 */     this.campoSubTrama[0].longitudmin = 2;
/*  27 */     this.campoSubTrama[0].longitudmax = 2;
/*  28 */     this.campoSubTrama[0].descripcion = "CodigoIdResponsabilidad";
/*  29 */     this.campoSubTrama[0].contenido = "";
/*  30 */     this.campoSubTrama[0].requerido = 1;
/*  31 */     this.campoSubTrama[0].validar = 0;
/*     */     
/*  33 */     this.campoSubTrama[1].orden = 2;
/*  34 */     this.campoSubTrama[1].nombre = "PER02";
/*  35 */     this.campoSubTrama[1].atributo = "Alfanumerico";
/*  36 */     this.campoSubTrama[1].ubicacionByte = 0;
/*  37 */     this.campoSubTrama[1].longitudmin = 1;
/*  38 */     this.campoSubTrama[1].longitudmax = 60;
/*  39 */     this.campoSubTrama[1].descripcion = "Nombre";
/*  40 */     this.campoSubTrama[1].contenido = "";
/*  41 */     this.campoSubTrama[1].requerido = 1;
/*  42 */     this.campoSubTrama[1].validar = 0;
/*     */     
/*  44 */     this.campoSubTrama[2].orden = 3;
/*  45 */     this.campoSubTrama[2].nombre = "PER03";
/*  46 */     this.campoSubTrama[2].atributo = "Alfanumerico";
/*  47 */     this.campoSubTrama[2].ubicacionByte = 0;
/*  48 */     this.campoSubTrama[2].longitudmin = 2;
/*  49 */     this.campoSubTrama[2].longitudmax = 2;
/*  50 */     this.campoSubTrama[2].descripcion = "CaFormaComunicacionEmail";
/*  51 */     this.campoSubTrama[2].contenido = "";
/*  52 */     this.campoSubTrama[2].requerido = 1;
/*  53 */     this.campoSubTrama[2].validar = 0;
/*     */     
/*  55 */     this.campoSubTrama[3].orden = 4;
/*  56 */     this.campoSubTrama[3].nombre = "PER04";
/*  57 */     this.campoSubTrama[3].atributo = "Alfanumerico";
/*  58 */     this.campoSubTrama[3].ubicacionByte = 0;
/*  59 */     this.campoSubTrama[3].longitudmin = 1;
/*  60 */     this.campoSubTrama[3].longitudmax = 80;
/*  61 */     this.campoSubTrama[3].descripcion = "EmailAfiliado";
/*  62 */     this.campoSubTrama[3].contenido = "";
/*  63 */     this.campoSubTrama[3].requerido = 1;
/*  64 */     this.campoSubTrama[3].validar = 0;
/*     */     
/*  66 */     this.campoSubTrama[4].orden = 5;
/*  67 */     this.campoSubTrama[4].nombre = "PER05";
/*  68 */     this.campoSubTrama[4].atributo = "Alfanumerico";
/*  69 */     this.campoSubTrama[4].ubicacionByte = 0;
/*  70 */     this.campoSubTrama[4].longitudmin = 2;
/*  71 */     this.campoSubTrama[4].longitudmax = 2;
/*  72 */     this.campoSubTrama[4].descripcion = "CaFormaComunicacionTelefono";
/*  73 */     this.campoSubTrama[4].contenido = "";
/*  74 */     this.campoSubTrama[4].requerido = 1;
/*  75 */     this.campoSubTrama[4].validar = 0;
/*     */     
/*  77 */     this.campoSubTrama[5].orden = 6;
/*  78 */     this.campoSubTrama[5].nombre = "PER06";
/*  79 */     this.campoSubTrama[5].atributo = "Alfanumerico";
/*  80 */     this.campoSubTrama[5].ubicacionByte = 0;
/*  81 */     this.campoSubTrama[5].longitudmin = 1;
/*  82 */     this.campoSubTrama[5].longitudmax = 20;
/*  83 */     this.campoSubTrama[5].descripcion = "TelefonoAfiliado";
/*  84 */     this.campoSubTrama[5].contenido = "";
/*  85 */     this.campoSubTrama[5].requerido = 1;
/*  86 */     this.campoSubTrama[5].validar = 0;
/*     */   }
/*     */   
/*     */   public void generaSubTrama(String sParameter1, String sParameter2) {
/*  90 */     this.campoSubTrama[0].contenido = sParameter1;
/*  91 */     this.campoSubTrama[1].contenido = sParameter2;
/*     */   }
/*     */   
/*     */ 
/*     */   public void generaSubTrama(String sParameter1, String sParameter2, String sParameter3, String sParameter4, String sParameter5)
/*     */   {
/*  97 */     this.campoSubTrama[0].contenido = sParameter1;
/*  98 */     this.campoSubTrama[2].contenido = sParameter2;
/*  99 */     this.campoSubTrama[3].contenido = sParameter3;
/* 100 */     this.campoSubTrama[4].contenido = sParameter4;
/* 101 */     this.campoSubTrama[5].contenido = sParameter5;
/*     */   }
/*     */ }


/* Location:              D:\WorkSpace\Desarrollo Afiliacion On Linea\Fuentes\FebanAfiliacionesFH\lib\jr-afiliacion-susalud_v1.5.jar!\pe\gob\susalud\jr\transaccion\susalud\trama\SubTrama_PER.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */