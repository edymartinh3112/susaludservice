/*     */ package pe.com.susalud.jr.transaccion.afiliacion.trama.bean;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SubTrama_REF4
/*     */   extends SubTrama
/*     */ {
/*     */   public SubTrama_REF4()
/*     */   {
/*  12 */     this.num_CamposSubTrama = 6;
/*     */     
/*  14 */     this.campoSubTrama[0] = new Campos();
/*  15 */     this.campoSubTrama[1] = new Campos();
/*  16 */     this.campoSubTrama[2] = new Campos();
/*  17 */     this.campoSubTrama[3] = new Campos();
/*  18 */     this.campoSubTrama[4] = new Campos();
/*  19 */     this.campoSubTrama[5] = new Campos();
/*     */     
/*  21 */     this.campoSubTrama[0].orden = 41;
/*  22 */     this.campoSubTrama[0].nombre = "REF0401";
/*  23 */     this.campoSubTrama[0].atributo = "Alfanumerico";
/*  24 */     this.campoSubTrama[0].ubicacionByte = 0;
/*  25 */     this.campoSubTrama[0].longitudmin = 2;
/*  26 */     this.campoSubTrama[0].longitudmax = 3;
/*  27 */     this.campoSubTrama[0].descripcion = "Calificador de identificacion referencial";
/*  28 */     this.campoSubTrama[0].contenido = "";
/*  29 */     this.campoSubTrama[0].requerido = 1;
/*  30 */     this.campoSubTrama[0].validar = 0;
/*     */     
/*  32 */     this.campoSubTrama[1].orden = 42;
/*  33 */     this.campoSubTrama[1].nombre = "REF0402";
/*  34 */     this.campoSubTrama[1].atributo = "Alfanumerico";
/*  35 */     this.campoSubTrama[1].ubicacionByte = 0;
/*  36 */     this.campoSubTrama[1].longitudmin = 1;
/*  37 */     this.campoSubTrama[1].longitudmax = 20;
/*  38 */     this.campoSubTrama[1].descripcion = "Información de referencia";
/*  39 */     this.campoSubTrama[1].contenido = "";
/*  40 */     this.campoSubTrama[1].requerido = 1;
/*  41 */     this.campoSubTrama[1].validar = 0;
/*     */     
/*  43 */     this.campoSubTrama[2].orden = 43;
/*  44 */     this.campoSubTrama[2].nombre = "REF0403";
/*  45 */     this.campoSubTrama[2].atributo = "Alfanumerico";
/*  46 */     this.campoSubTrama[2].ubicacionByte = 0;
/*  47 */     this.campoSubTrama[2].longitudmin = 2;
/*  48 */     this.campoSubTrama[2].longitudmax = 3;
/*  49 */     this.campoSubTrama[2].descripcion = "Calificador de identificacion referencial";
/*  50 */     this.campoSubTrama[2].contenido = "";
/*  51 */     this.campoSubTrama[2].requerido = 1;
/*  52 */     this.campoSubTrama[2].validar = 0;
/*     */     
/*  54 */     this.campoSubTrama[3].orden = 44;
/*  55 */     this.campoSubTrama[3].nombre = "REF0404";
/*  56 */     this.campoSubTrama[3].atributo = "Alfanumerico";
/*  57 */     this.campoSubTrama[3].ubicacionByte = 0;
/*  58 */     this.campoSubTrama[3].longitudmin = 1;
/*  59 */     this.campoSubTrama[3].longitudmax = 20;
/*  60 */     this.campoSubTrama[3].descripcion = "Información de referencia";
/*  61 */     this.campoSubTrama[3].contenido = "";
/*  62 */     this.campoSubTrama[3].requerido = 1;
/*  63 */     this.campoSubTrama[3].validar = 0;
/*     */     
/*  65 */     this.campoSubTrama[4].orden = 45;
/*  66 */     this.campoSubTrama[4].nombre = "REF0405";
/*  67 */     this.campoSubTrama[4].atributo = "Alfanumerico";
/*  68 */     this.campoSubTrama[4].ubicacionByte = 0;
/*  69 */     this.campoSubTrama[4].longitudmin = 2;
/*  70 */     this.campoSubTrama[4].longitudmax = 3;
/*  71 */     this.campoSubTrama[4].descripcion = "Calificador de identificacion referencial";
/*  72 */     this.campoSubTrama[4].contenido = "";
/*  73 */     this.campoSubTrama[4].requerido = 1;
/*  74 */     this.campoSubTrama[4].validar = 0;
/*     */     
/*  76 */     this.campoSubTrama[5].orden = 46;
/*  77 */     this.campoSubTrama[5].nombre = "REF0406";
/*  78 */     this.campoSubTrama[5].atributo = "Alfanumerico";
/*  79 */     this.campoSubTrama[5].ubicacionByte = 0;
/*  80 */     this.campoSubTrama[5].longitudmin = 1;
/*  81 */     this.campoSubTrama[5].longitudmax = 20;
/*  82 */     this.campoSubTrama[5].descripcion = "Información de referencia";
/*  83 */     this.campoSubTrama[5].contenido = "";
/*  84 */     this.campoSubTrama[5].requerido = 1;
/*  85 */     this.campoSubTrama[5].validar = 0;
/*     */   }
/*     */   
/*     */   public void generaSubTrama(String sParam1, String sParam2) {
/*  89 */     this.campoSubTrama[0].contenido = sParam1;
/*  90 */     this.campoSubTrama[1].contenido = sParam2;
/*     */   }
/*     */   
/*     */   public void generaSubTrama(String sParam1, String sParam2, String sParam4) {
/*  94 */     this.campoSubTrama[0].contenido = sParam1;
/*  95 */     this.campoSubTrama[1].contenido = sParam2;
/*  96 */     this.campoSubTrama[3].contenido = sParam4;
/*     */   }
/*     */   
/*     */   public void generaSubTrama(String sParam1, String sParam2, String sParam3, String sParam4, String sParam5, String sParam6) {
/* 100 */     this.campoSubTrama[0].contenido = sParam1;
/* 101 */     this.campoSubTrama[1].contenido = sParam2;
/* 102 */     this.campoSubTrama[2].contenido = sParam3;
/* 103 */     this.campoSubTrama[3].contenido = sParam4;
/* 104 */     this.campoSubTrama[4].contenido = sParam5;
/* 105 */     this.campoSubTrama[5].contenido = sParam6;
/*     */   }
/*     */ }


/* Location:              D:\WorkSpace\Desarrollo Afiliacion On Linea\Fuentes\FebanAfiliacionesFH\lib\jr-afiliacion-susalud_v1.5.jar!\pe\gob\susalud\jr\transaccion\susalud\trama\SubTrama_REF4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */