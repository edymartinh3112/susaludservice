/*     */ package pe.com.susalud.jr.transaccion.afiliacion.trama.bean;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SubTrama_GS
/*     */   extends SubTrama
/*     */ {
/*     */   public SubTrama_GS()
/*     */   {
/*  12 */     this.num_CamposSubTrama = 8;
/*     */     
/*  14 */     this.campoSubTrama[0] = new Campos();
/*  15 */     this.campoSubTrama[1] = new Campos();
/*  16 */     this.campoSubTrama[2] = new Campos();
/*  17 */     this.campoSubTrama[3] = new Campos();
/*  18 */     this.campoSubTrama[4] = new Campos();
/*  19 */     this.campoSubTrama[5] = new Campos();
/*  20 */     this.campoSubTrama[6] = new Campos();
/*  21 */     this.campoSubTrama[7] = new Campos();
/*     */     
/*  23 */     this.campoSubTrama[0].orden = 1;
/*  24 */     this.campoSubTrama[0].nombre = "GS01";
/*  25 */     this.campoSubTrama[0].atributo = "Alfanumerico";
/*  26 */     this.campoSubTrama[0].ubicacionByte = 0;
/*  27 */     this.campoSubTrama[0].longitudmin = 2;
/*  28 */     this.campoSubTrama[0].longitudmax = 2;
/*  29 */     this.campoSubTrama[0].descripcion = "";
/*  30 */     this.campoSubTrama[0].contenido = "HS";
/*  31 */     this.campoSubTrama[0].requerido = 1;
/*  32 */     this.campoSubTrama[0].validar = 0;
/*     */     
/*  34 */     this.campoSubTrama[1].orden = 2;
/*  35 */     this.campoSubTrama[1].nombre = "GS02";
/*  36 */     this.campoSubTrama[1].atributo = "Alfanumerico";
/*  37 */     this.campoSubTrama[1].ubicacionByte = 0;
/*  38 */     this.campoSubTrama[1].longitudmin = 2;
/*  39 */     this.campoSubTrama[1].longitudmax = 15;
/*  40 */     this.campoSubTrama[1].descripcion = "";
/*  41 */     this.campoSubTrama[1].contenido = "";
/*  42 */     this.campoSubTrama[1].requerido = 1;
/*  43 */     this.campoSubTrama[1].validar = 0;
/*     */     
/*  45 */     this.campoSubTrama[2].orden = 3;
/*  46 */     this.campoSubTrama[2].nombre = "GS03";
/*  47 */     this.campoSubTrama[2].atributo = "Alfanumerico";
/*  48 */     this.campoSubTrama[2].ubicacionByte = 0;
/*  49 */     this.campoSubTrama[2].longitudmin = 2;
/*  50 */     this.campoSubTrama[2].longitudmax = 15;
/*  51 */     this.campoSubTrama[2].descripcion = "";
/*  52 */     this.campoSubTrama[2].contenido = "";
/*  53 */     this.campoSubTrama[2].requerido = 1;
/*  54 */     this.campoSubTrama[2].validar = 0;
/*     */     
/*  56 */     this.campoSubTrama[3].orden = 4;
/*  57 */     this.campoSubTrama[3].nombre = "GS04";
/*  58 */     this.campoSubTrama[3].atributo = "Alfanumerico";
/*  59 */     this.campoSubTrama[3].ubicacionByte = 0;
/*  60 */     this.campoSubTrama[3].longitudmin = 8;
/*  61 */     this.campoSubTrama[3].longitudmax = 8;
/*  62 */     this.campoSubTrama[3].descripcion = "";
/*  63 */     this.campoSubTrama[3].contenido = "";
/*  64 */     this.campoSubTrama[3].requerido = 1;
/*  65 */     this.campoSubTrama[3].validar = 0;
/*     */     
/*  67 */     this.campoSubTrama[4].orden = 5;
/*  68 */     this.campoSubTrama[4].nombre = "GS05";
/*  69 */     this.campoSubTrama[4].atributo = "Alfanumerico";
/*  70 */     this.campoSubTrama[4].ubicacionByte = 0;
/*  71 */     this.campoSubTrama[4].longitudmin = 4;
/*  72 */     this.campoSubTrama[4].longitudmax = 8;
/*  73 */     this.campoSubTrama[4].descripcion = "";
/*  74 */     this.campoSubTrama[4].contenido = "";
/*  75 */     this.campoSubTrama[4].requerido = 1;
/*  76 */     this.campoSubTrama[4].validar = 0;
/*     */     
/*  78 */     this.campoSubTrama[5].orden = 6;
/*  79 */     this.campoSubTrama[5].nombre = "GS06";
/*  80 */     this.campoSubTrama[5].atributo = "Numerico";
/*  81 */     this.campoSubTrama[5].ubicacionByte = 0;
/*  82 */     this.campoSubTrama[5].longitudmin = 1;
/*  83 */     this.campoSubTrama[5].longitudmax = 9;
/*  84 */     this.campoSubTrama[5].descripcion = "";
/*  85 */     this.campoSubTrama[5].contenido = "";
/*  86 */     this.campoSubTrama[5].requerido = 1;
/*  87 */     this.campoSubTrama[5].validar = 0;
/*     */     
/*  89 */     this.campoSubTrama[6].orden = 7;
/*  90 */     this.campoSubTrama[6].nombre = "GS07";
/*  91 */     this.campoSubTrama[6].atributo = "Alfanumerico";
/*  92 */     this.campoSubTrama[6].ubicacionByte = 0;
/*  93 */     this.campoSubTrama[6].longitudmin = 1;
/*  94 */     this.campoSubTrama[6].longitudmax = 2;
/*  95 */     this.campoSubTrama[6].descripcion = "";
/*  96 */     this.campoSubTrama[6].contenido = "X";
/*  97 */     this.campoSubTrama[6].requerido = 1;
/*  98 */     this.campoSubTrama[6].validar = 0;
/*     */     
/* 100 */     this.campoSubTrama[7].orden = 8;
/* 101 */     this.campoSubTrama[7].nombre = "GS08";
/* 102 */     this.campoSubTrama[7].atributo = "Alfanumerico";
/* 103 */     this.campoSubTrama[7].ubicacionByte = 0;
/* 104 */     this.campoSubTrama[7].longitudmin = 1;
/* 105 */     this.campoSubTrama[7].longitudmax = 12;
/* 106 */     this.campoSubTrama[7].descripcion = "";
/* 107 */     this.campoSubTrama[7].contenido = "00501";
/* 108 */     this.campoSubTrama[7].requerido = 1;
/* 109 */     this.campoSubTrama[7].validar = 0;
/*     */   }
/*     */   
/*     */   public void generaSubTrama(String sIdRemitente, String sIdReceptor, String sFeTransaccion, String sHoTransaccion, String sNuControl) {
/* 113 */     this.campoSubTrama[1].contenido = sIdRemitente;
/* 114 */     this.campoSubTrama[2].contenido = sIdReceptor;
/* 115 */     this.campoSubTrama[3].contenido = sFeTransaccion;
/* 116 */     this.campoSubTrama[4].contenido = sHoTransaccion;
/* 117 */     this.campoSubTrama[5].contenido = sNuControl;
/*     */   }
/*     */   
/*     */   public void generaSubTrama(String sTiTx, String sIdRemitente, String sIdReceptor, String sFeTransaccion, String sHoTransaccion, String sNuControl) {
/* 121 */     this.campoSubTrama[0].contenido = sTiTx;
/* 122 */     this.campoSubTrama[1].contenido = sIdRemitente;
/* 123 */     this.campoSubTrama[2].contenido = sIdReceptor;
/* 124 */     this.campoSubTrama[3].contenido = sFeTransaccion;
/* 125 */     this.campoSubTrama[4].contenido = sHoTransaccion;
/* 126 */     this.campoSubTrama[5].contenido = sNuControl;
/*     */   }
/*     */ }


/* Location:              D:\WorkSpace\Desarrollo Afiliacion On Linea\Fuentes\FebanAfiliacionesFH\lib\jr-afiliacion-susalud_v1.5.jar!\pe\gob\susalud\jr\transaccion\susalud\trama\SubTrama_GS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */