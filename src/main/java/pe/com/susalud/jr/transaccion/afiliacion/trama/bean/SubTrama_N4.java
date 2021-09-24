/*     */ package pe.com.susalud.jr.transaccion.afiliacion.trama.bean;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SubTrama_N4
/*     */   extends SubTrama
/*     */ {
/*     */   public SubTrama_N4()
/*     */   {
/*  15 */     this.num_CamposSubTrama = 7;
/*     */     
/*  17 */     this.campoSubTrama[0] = new Campos();
/*  18 */     this.campoSubTrama[1] = new Campos();
/*  19 */     this.campoSubTrama[2] = new Campos();
/*  20 */     this.campoSubTrama[3] = new Campos();
/*  21 */     this.campoSubTrama[4] = new Campos();
/*  22 */     this.campoSubTrama[5] = new Campos();
/*  23 */     this.campoSubTrama[6] = new Campos();
/*     */     
/*  25 */     this.campoSubTrama[0].orden = 1;
/*  26 */     this.campoSubTrama[0].nombre = "N401";
/*  27 */     this.campoSubTrama[0].atributo = "Alfanumerico";
/*  28 */     this.campoSubTrama[0].ubicacionByte = 0;
/*  29 */     this.campoSubTrama[0].longitudmin = 2;
/*  30 */     this.campoSubTrama[0].longitudmax = 30;
/*  31 */     this.campoSubTrama[0].descripcion = "";
/*  32 */     this.campoSubTrama[0].contenido = "";
/*  33 */     this.campoSubTrama[0].requerido = 1;
/*  34 */     this.campoSubTrama[0].validar = 0;
/*     */     
/*  36 */     this.campoSubTrama[1].orden = 2;
/*  37 */     this.campoSubTrama[1].nombre = "N402";
/*  38 */     this.campoSubTrama[1].atributo = "Alfanumerico";
/*  39 */     this.campoSubTrama[1].ubicacionByte = 0;
/*  40 */     this.campoSubTrama[1].longitudmin = 2;
/*  41 */     this.campoSubTrama[1].longitudmax = 2;
/*  42 */     this.campoSubTrama[1].descripcion = "";
/*  43 */     this.campoSubTrama[1].contenido = "";
/*  44 */     this.campoSubTrama[1].requerido = 1;
/*  45 */     this.campoSubTrama[1].validar = 0;
/*     */     
/*  47 */     this.campoSubTrama[2].orden = 3;
/*  48 */     this.campoSubTrama[2].nombre = "N403";
/*  49 */     this.campoSubTrama[2].atributo = "Alfanumerico";
/*  50 */     this.campoSubTrama[2].ubicacionByte = 0;
/*  51 */     this.campoSubTrama[2].longitudmin = 3;
/*  52 */     this.campoSubTrama[2].longitudmax = 15;
/*  53 */     this.campoSubTrama[2].descripcion = "Cod. Postal";
/*  54 */     this.campoSubTrama[2].contenido = "";
/*  55 */     this.campoSubTrama[2].requerido = 1;
/*  56 */     this.campoSubTrama[2].validar = 0;
/*     */     
/*  58 */     this.campoSubTrama[3].orden = 4;
/*  59 */     this.campoSubTrama[3].nombre = "N404";
/*  60 */     this.campoSubTrama[3].atributo = "Alfanumerico";
/*  61 */     this.campoSubTrama[3].ubicacionByte = 0;
/*  62 */     this.campoSubTrama[3].longitudmin = 2;
/*  63 */     this.campoSubTrama[3].longitudmax = 3;
/*  64 */     this.campoSubTrama[3].descripcion = "Cod. País";
/*  65 */     this.campoSubTrama[3].contenido = "";
/*  66 */     this.campoSubTrama[3].requerido = 1;
/*  67 */     this.campoSubTrama[3].validar = 0;
/*     */     
/*  69 */     this.campoSubTrama[4].orden = 5;
/*  70 */     this.campoSubTrama[4].nombre = "N405";
/*  71 */     this.campoSubTrama[4].atributo = "Alfanumerico";
/*  72 */     this.campoSubTrama[4].ubicacionByte = 0;
/*  73 */     this.campoSubTrama[4].longitudmin = 1;
/*  74 */     this.campoSubTrama[4].longitudmax = 2;
/*  75 */     this.campoSubTrama[4].descripcion = "Iden. Ubigeo";
/*  76 */     this.campoSubTrama[4].contenido = "";
/*  77 */     this.campoSubTrama[4].requerido = 1;
/*  78 */     this.campoSubTrama[4].validar = 0;
/*     */     
/*  80 */     this.campoSubTrama[5].orden = 6;
/*  81 */     this.campoSubTrama[5].nombre = "N406";
/*  82 */     this.campoSubTrama[5].atributo = "Alfanumerico";
/*  83 */     this.campoSubTrama[5].ubicacionByte = 0;
/*  84 */     this.campoSubTrama[5].longitudmin = 1;
/*  85 */     this.campoSubTrama[5].longitudmax = 20;
/*  86 */     this.campoSubTrama[5].descripcion = "Ubigeo";
/*  87 */     this.campoSubTrama[5].contenido = "";
/*  88 */     this.campoSubTrama[5].requerido = 1;
/*  89 */     this.campoSubTrama[5].validar = 0;
/*     */     
/*  91 */     this.campoSubTrama[6].orden = 7;
/*  92 */     this.campoSubTrama[6].nombre = "N407";
/*  93 */     this.campoSubTrama[6].atributo = "Alfanumerico";
/*  94 */     this.campoSubTrama[6].ubicacionByte = 0;
/*  95 */     this.campoSubTrama[6].longitudmin = 1;
/*  96 */     this.campoSubTrama[6].longitudmax = 3;
/*  97 */     this.campoSubTrama[6].descripcion = "Cod. Sub. País";
/*  98 */     this.campoSubTrama[6].contenido = "";
/*  99 */     this.campoSubTrama[6].requerido = 1;
/* 100 */     this.campoSubTrama[6].validar = 0;
/*     */   }
/*     */   
/*     */   public void generaSubTrama(String sParameter1, String sParameter5, String sParameter6) {
/* 104 */     this.campoSubTrama[0].contenido = sParameter1;
/* 105 */     this.campoSubTrama[4].contenido = sParameter5;
/* 106 */     this.campoSubTrama[5].contenido = sParameter6;
/*     */   }
/*     */ }


/* Location:              D:\WorkSpace\Desarrollo Afiliacion On Linea\Fuentes\FebanAfiliacionesFH\lib\jr-afiliacion-susalud_v1.5.jar!\pe\gob\susalud\jr\transaccion\susalud\trama\SubTrama_N4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */