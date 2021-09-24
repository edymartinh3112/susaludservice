/*     */ package  pe.com.susalud.jr.transaccion.afiliacion.trama.bean;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SubTrama_EB13
/*     */   extends SubTrama
/*     */ {
/*     */   public SubTrama_EB13()
/*     */   {
/*  15 */     this.num_CamposSubTrama = 8;
/*     */     
/*  17 */     this.campoSubTrama[0] = new Campos();
/*  18 */     this.campoSubTrama[1] = new Campos();
/*  19 */     this.campoSubTrama[2] = new Campos();
/*  20 */     this.campoSubTrama[3] = new Campos();
/*  21 */     this.campoSubTrama[4] = new Campos();
/*  22 */     this.campoSubTrama[5] = new Campos();
/*  23 */     this.campoSubTrama[6] = new Campos();
/*  24 */     this.campoSubTrama[7] = new Campos();
/*     */     
/*  26 */     this.campoSubTrama[0].orden = 1;
/*  27 */     this.campoSubTrama[0].nombre = "EB1301";
/*  28 */     this.campoSubTrama[0].atributo = "Numerico";
/*  29 */     this.campoSubTrama[0].ubicacionByte = 0;
/*  30 */     this.campoSubTrama[0].longitudmin = 2;
/*  31 */     this.campoSubTrama[0].longitudmax = 2;
/*  32 */     this.campoSubTrama[0].descripcion = "Cód. Calificador de Producto/Servicio";
/*  33 */     this.campoSubTrama[0].contenido = "";
/*  34 */     this.campoSubTrama[0].requerido = 1;
/*  35 */     this.campoSubTrama[0].validar = 0;
/*     */     
/*  37 */     this.campoSubTrama[1].orden = 2;
/*  38 */     this.campoSubTrama[1].nombre = "EB1302";
/*  39 */     this.campoSubTrama[1].atributo = "Alfanumerico";
/*  40 */     this.campoSubTrama[1].ubicacionByte = 0;
/*  41 */     this.campoSubTrama[1].longitudmin = 1;
/*  42 */     this.campoSubTrama[1].longitudmax = 3;
/*  43 */     this.campoSubTrama[1].descripcion = "ID de Producto/Servicio";
/*  44 */     this.campoSubTrama[1].contenido = "";
/*  45 */     this.campoSubTrama[1].requerido = 1;
/*  46 */     this.campoSubTrama[1].validar = 0;
/*     */     
/*  48 */     this.campoSubTrama[2].orden = 3;
/*  49 */     this.campoSubTrama[2].nombre = "EB1303";
/*  50 */     this.campoSubTrama[2].atributo = "Alfanumerico";
/*  51 */     this.campoSubTrama[2].ubicacionByte = 0;
/*  52 */     this.campoSubTrama[2].longitudmin = 1;
/*  53 */     this.campoSubTrama[2].longitudmax = 35;
/*  54 */     this.campoSubTrama[2].descripcion = "";
/*  55 */     this.campoSubTrama[2].contenido = "";
/*  56 */     this.campoSubTrama[2].requerido = 1;
/*  57 */     this.campoSubTrama[2].validar = 0;
/*     */     
/*  59 */     this.campoSubTrama[3].orden = 4;
/*  60 */     this.campoSubTrama[3].nombre = "EB1304";
/*  61 */     this.campoSubTrama[3].atributo = "Alfanumerico";
/*  62 */     this.campoSubTrama[3].ubicacionByte = 0;
/*  63 */     this.campoSubTrama[3].longitudmin = 2;
/*  64 */     this.campoSubTrama[3].longitudmax = 2;
/*  65 */     this.campoSubTrama[3].descripcion = "";
/*  66 */     this.campoSubTrama[3].contenido = "";
/*  67 */     this.campoSubTrama[3].requerido = 1;
/*  68 */     this.campoSubTrama[3].validar = 0;
/*     */     
/*  70 */     this.campoSubTrama[4].orden = 5;
/*  71 */     this.campoSubTrama[4].nombre = "EB1305";
/*  72 */     this.campoSubTrama[4].atributo = "Alfanumerico";
/*  73 */     this.campoSubTrama[4].ubicacionByte = 0;
/*  74 */     this.campoSubTrama[4].longitudmin = 2;
/*  75 */     this.campoSubTrama[4].longitudmax = 2;
/*  76 */     this.campoSubTrama[4].descripcion = "";
/*  77 */     this.campoSubTrama[4].contenido = "";
/*  78 */     this.campoSubTrama[4].requerido = 1;
/*  79 */     this.campoSubTrama[4].validar = 0;
/*     */     
/*  81 */     this.campoSubTrama[5].orden = 6;
/*  82 */     this.campoSubTrama[5].nombre = "EB1306";
/*  83 */     this.campoSubTrama[5].atributo = "Alfanumerico";
/*  84 */     this.campoSubTrama[5].ubicacionByte = 0;
/*  85 */     this.campoSubTrama[5].longitudmin = 2;
/*  86 */     this.campoSubTrama[5].longitudmax = 2;
/*  87 */     this.campoSubTrama[5].descripcion = "";
/*  88 */     this.campoSubTrama[5].contenido = "";
/*  89 */     this.campoSubTrama[5].requerido = 1;
/*  90 */     this.campoSubTrama[5].validar = 0;
/*     */     
/*  92 */     this.campoSubTrama[6].orden = 7;
/*  93 */     this.campoSubTrama[6].nombre = "EB1307";
/*  94 */     this.campoSubTrama[6].atributo = "Alfanumerico";
/*  95 */     this.campoSubTrama[6].ubicacionByte = 0;
/*  96 */     this.campoSubTrama[6].longitudmin = 1;
/*  97 */     this.campoSubTrama[6].longitudmax = 80;
/*  98 */     this.campoSubTrama[6].descripcion = "";
/*  99 */     this.campoSubTrama[6].contenido = "";
/* 100 */     this.campoSubTrama[6].requerido = 1;
/* 101 */     this.campoSubTrama[6].validar = 0;
/*     */     
/* 103 */     this.campoSubTrama[7].orden = 8;
/* 104 */     this.campoSubTrama[7].nombre = "EB1308";
/* 105 */     this.campoSubTrama[7].atributo = "Alfanumerico";
/* 106 */     this.campoSubTrama[7].ubicacionByte = 0;
/* 107 */     this.campoSubTrama[7].longitudmin = 1;
/* 108 */     this.campoSubTrama[7].longitudmax = 20;
/* 109 */     this.campoSubTrama[7].descripcion = "";
/* 110 */     this.campoSubTrama[7].contenido = "";
/* 111 */     this.campoSubTrama[7].requerido = 1;
/* 112 */     this.campoSubTrama[7].validar = 0;
/*     */   }
/*     */   
/*     */   public void generaSubTrama(String sICalificadorServicio, String sIdProductoServicio, String sDescripcionProducto) {
/* 116 */     this.campoSubTrama[0].contenido = sICalificadorServicio;
/* 117 */     this.campoSubTrama[1].contenido = sIdProductoServicio;
/* 118 */     this.campoSubTrama[4].contenido = sDescripcionProducto;
/*     */   }
/*     */ }


/* Location:              D:\WorkSpace\Desarrollo Afiliacion On Linea\Fuentes\FebanAfiliacionesFH\lib\jr-afiliacion-susalud_v1.5.jar!\pe\gob\susalud\jr\transaccion\susalud\trama\SubTrama_EB13.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */