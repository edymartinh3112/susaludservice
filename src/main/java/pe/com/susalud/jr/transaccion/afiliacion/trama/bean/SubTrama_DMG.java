/*     */ package pe.com.susalud.jr.transaccion.afiliacion.trama.bean;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SubTrama_DMG
/*     */   extends SubTrama
/*     */ {
/*     */   public SubTrama_DMG()
/*     */   {
/*  11 */     this.num_CamposSubTrama = 7;
/*     */     
/*  13 */     this.campoSubTrama[0] = new Campos();
/*  14 */     this.campoSubTrama[1] = new Campos();
/*  15 */     this.campoSubTrama[2] = new Campos();
/*  16 */     this.campoSubTrama[3] = new Campos();
/*  17 */     this.campoSubTrama[4] = new Campos();
/*  18 */     this.campoSubTrama[5] = new Campos();
/*  19 */     this.campoSubTrama[6] = new Campos();
/*     */     
/*  21 */     this.campoSubTrama[0].orden = 1;
/*  22 */     this.campoSubTrama[0].nombre = "DMG01";
/*  23 */     this.campoSubTrama[0].atributo = "Alfanumerico";
/*  24 */     this.campoSubTrama[0].ubicacionByte = 0;
/*  25 */     this.campoSubTrama[0].longitudmin = 2;
/*  26 */     this.campoSubTrama[0].longitudmax = 3;
/*  27 */     this.campoSubTrama[0].descripcion = "Código Indicador de Formato(CCYYMMDD)";
/*  28 */     this.campoSubTrama[0].contenido = "";
/*  29 */     this.campoSubTrama[0].requerido = 1;
/*  30 */     this.campoSubTrama[0].validar = 0;
/*     */     
/*  32 */     this.campoSubTrama[1].orden = 2;
/*  33 */     this.campoSubTrama[1].nombre = "DMG02";
/*  34 */     this.campoSubTrama[1].atributo = "Alfanumerico";
/*  35 */     this.campoSubTrama[1].ubicacionByte = 0;
/*  36 */     this.campoSubTrama[1].longitudmin = 1;
/*  37 */     this.campoSubTrama[1].longitudmax = 35;
/*  38 */     this.campoSubTrama[1].descripcion = "Fecha de nacimiento";
/*  39 */     this.campoSubTrama[1].contenido = "";
/*  40 */     this.campoSubTrama[1].requerido = 1;
/*  41 */     this.campoSubTrama[1].validar = 0;
/*     */     
/*  43 */     this.campoSubTrama[2].orden = 3;
/*  44 */     this.campoSubTrama[2].nombre = "DMG03";
/*  45 */     this.campoSubTrama[2].atributo = "Alfanumerico";
/*  46 */     this.campoSubTrama[2].ubicacionByte = 0;
/*  47 */     this.campoSubTrama[2].longitudmin = 1;
/*  48 */     this.campoSubTrama[2].longitudmax = 1;
/*  49 */     this.campoSubTrama[2].descripcion = "Indicador Genero( F Female/ M Male)";
/*  50 */     this.campoSubTrama[2].contenido = "";
/*  51 */     this.campoSubTrama[2].requerido = 1;
/*  52 */     this.campoSubTrama[2].validar = 0;
/*     */     
/*  54 */     this.campoSubTrama[3].orden = 4;
/*  55 */     this.campoSubTrama[3].nombre = "DMG04";
/*  56 */     this.campoSubTrama[3].atributo = "Alfanumerico";
/*  57 */     this.campoSubTrama[3].ubicacionByte = 0;
/*  58 */     this.campoSubTrama[3].longitudmin = 1;
/*  59 */     this.campoSubTrama[3].longitudmax = 1;
/*  60 */     this.campoSubTrama[3].descripcion = "Estado Marital( I - Single M - Married)";
/*  61 */     this.campoSubTrama[3].contenido = "";
/*  62 */     this.campoSubTrama[3].requerido = 1;
/*  63 */     this.campoSubTrama[3].validar = 0;
/*     */     
/*  65 */     this.campoSubTrama[4].orden = 5;
/*  66 */     this.campoSubTrama[4].nombre = "DMG05";
/*  67 */     this.campoSubTrama[4].atributo = "Alfanumerico";
/*  68 */     this.campoSubTrama[4].ubicacionByte = 0;
/*  69 */     this.campoSubTrama[4].longitudmin = 1;
/*  70 */     this.campoSubTrama[4].longitudmax = 20;
/*  71 */     this.campoSubTrama[4].descripcion = "";
/*  72 */     this.campoSubTrama[4].contenido = "";
/*  73 */     this.campoSubTrama[4].requerido = 1;
/*  74 */     this.campoSubTrama[4].validar = 0;
/*     */     
/*  76 */     this.campoSubTrama[5].orden = 6;
/*  77 */     this.campoSubTrama[5].nombre = "DMG06";
/*  78 */     this.campoSubTrama[5].atributo = "Alfanumerico";
/*  79 */     this.campoSubTrama[5].ubicacionByte = 0;
/*  80 */     this.campoSubTrama[5].longitudmin = 1;
/*  81 */     this.campoSubTrama[5].longitudmax = 2;
/*  82 */     this.campoSubTrama[5].descripcion = "";
/*  83 */     this.campoSubTrama[5].contenido = "";
/*  84 */     this.campoSubTrama[5].requerido = 1;
/*  85 */     this.campoSubTrama[5].validar = 0;
/*     */     
/*  87 */     this.campoSubTrama[6].orden = 7;
/*  88 */     this.campoSubTrama[6].nombre = "DMG07";
/*  89 */     this.campoSubTrama[6].atributo = "Alfanumerico";
/*  90 */     this.campoSubTrama[6].ubicacionByte = 0;
/*  91 */     this.campoSubTrama[6].longitudmin = 2;
/*  92 */     this.campoSubTrama[6].longitudmax = 3;
/*  93 */     this.campoSubTrama[6].descripcion = "";
/*  94 */     this.campoSubTrama[6].contenido = "Código del País de Origen";
/*  95 */     this.campoSubTrama[6].requerido = 1;
/*  96 */     this.campoSubTrama[6].validar = 0;
/*     */   }
/*     */   
/*     */   public void generaSubTrama(String sInFormato, String sFeNacimiento, String sGenero, String sEsMarital, String sCoPais) {
/* 100 */     this.campoSubTrama[0].contenido = sInFormato;
/* 101 */     this.campoSubTrama[1].contenido = sFeNacimiento;
/* 102 */     this.campoSubTrama[2].contenido = sGenero;
/* 103 */     this.campoSubTrama[3].contenido = sEsMarital;
/* 104 */     this.campoSubTrama[6].contenido = sCoPais;
/*     */   }
/*     */ }


/* Location:              D:\WorkSpace\Desarrollo Afiliacion On Linea\Fuentes\FebanAfiliacionesFH\lib\jr-afiliacion-susalud_v1.5.jar!\pe\gob\susalud\jr\transaccion\susalud\trama\SubTrama_DMG.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */