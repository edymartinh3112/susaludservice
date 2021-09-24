/*     */ package pe.com.susalud.jr.transaccion.afiliacion.trama.bean;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SubTrama_NM1
/*     */   extends SubTrama
/*     */ {
/*     */   public SubTrama_NM1()
/*     */   {
/*  12 */     this.num_CamposSubTrama = 12;
/*     */     
/*  14 */     this.campoSubTrama[0] = new Campos();
/*  15 */     this.campoSubTrama[1] = new Campos();
/*  16 */     this.campoSubTrama[2] = new Campos();
/*  17 */     this.campoSubTrama[3] = new Campos();
/*  18 */     this.campoSubTrama[4] = new Campos();
/*  19 */     this.campoSubTrama[5] = new Campos();
/*  20 */     this.campoSubTrama[6] = new Campos();
/*  21 */     this.campoSubTrama[7] = new Campos();
/*  22 */     this.campoSubTrama[8] = new Campos();
/*  23 */     this.campoSubTrama[9] = new Campos();
/*  24 */     this.campoSubTrama[10] = new Campos();
/*  25 */     this.campoSubTrama[11] = new Campos();
/*     */     
/*  27 */     this.campoSubTrama[0].orden = 1;
/*  28 */     this.campoSubTrama[0].nombre = "NM101";
/*  29 */     this.campoSubTrama[0].atributo = "Alfanumerico";
/*  30 */     this.campoSubTrama[0].ubicacionByte = 0;
/*  31 */     this.campoSubTrama[0].longitudmin = 2;
/*  32 */     this.campoSubTrama[0].longitudmax = 3;
/*  33 */     this.campoSubTrama[0].descripcion = "Codigo identificador";
/*  34 */     this.campoSubTrama[0].contenido = "";
/*  35 */     this.campoSubTrama[0].requerido = 1;
/*  36 */     this.campoSubTrama[0].validar = 0;
/*     */     
/*  38 */     this.campoSubTrama[1].orden = 2;
/*  39 */     this.campoSubTrama[1].nombre = "NM102";
/*  40 */     this.campoSubTrama[1].atributo = "Alfanumerico";
/*  41 */     this.campoSubTrama[1].ubicacionByte = 0;
/*  42 */     this.campoSubTrama[1].longitudmin = 1;
/*  43 */     this.campoSubTrama[1].longitudmax = 1;
/*  44 */     this.campoSubTrama[1].descripcion = "Tipo calificador";
/*  45 */     this.campoSubTrama[1].contenido = "";
/*  46 */     this.campoSubTrama[1].requerido = 1;
/*  47 */     this.campoSubTrama[1].validar = 0;
/*     */     
/*  49 */     this.campoSubTrama[2].orden = 3;
/*  50 */     this.campoSubTrama[2].nombre = "NM103";
/*  51 */     this.campoSubTrama[2].atributo = "Alfanumerico";
/*  52 */     this.campoSubTrama[2].ubicacionByte = 0;
/*  53 */     this.campoSubTrama[2].longitudmin = 1;
/*  54 */     this.campoSubTrama[2].longitudmax = 60;
/*  55 */     this.campoSubTrama[2].descripcion = "Apellido pat/Nombre Org.";
/*  56 */     this.campoSubTrama[2].contenido = "";
/*  57 */     this.campoSubTrama[2].requerido = 1;
/*  58 */     this.campoSubTrama[2].validar = 0;
/*     */     
/*  60 */     this.campoSubTrama[3].orden = 4;
/*  61 */     this.campoSubTrama[3].nombre = "NM104";
/*  62 */     this.campoSubTrama[3].atributo = "Alfanumerico";
/*  63 */     this.campoSubTrama[3].ubicacionByte = 0;
/*  64 */     this.campoSubTrama[3].longitudmin = 1;
/*  65 */     this.campoSubTrama[3].longitudmax = 35;
/*  66 */     this.campoSubTrama[3].descripcion = "Nombres";
/*  67 */     this.campoSubTrama[3].contenido = "";
/*  68 */     this.campoSubTrama[3].requerido = 1;
/*  69 */     this.campoSubTrama[3].validar = 0;
/*     */     
/*  71 */     this.campoSubTrama[4].orden = 5;
/*  72 */     this.campoSubTrama[4].nombre = "NM105";
/*  73 */     this.campoSubTrama[4].atributo = "Alfanumerico";
/*  74 */     this.campoSubTrama[4].ubicacionByte = 0;
/*  75 */     this.campoSubTrama[4].longitudmin = 1;
/*  76 */     this.campoSubTrama[4].longitudmax = 25;
/*  77 */     this.campoSubTrama[4].descripcion = "Segundo nombre";
/*  78 */     this.campoSubTrama[4].contenido = "";
/*  79 */     this.campoSubTrama[4].requerido = 0;
/*  80 */     this.campoSubTrama[4].validar = 0;
/*     */     
/*  82 */     this.campoSubTrama[5].orden = 6;
/*  83 */     this.campoSubTrama[5].nombre = "NM106";
/*  84 */     this.campoSubTrama[5].atributo = "Alfanumerico";
/*  85 */     this.campoSubTrama[5].ubicacionByte = 0;
/*  86 */     this.campoSubTrama[5].longitudmin = 1;
/*  87 */     this.campoSubTrama[5].longitudmax = 10;
/*  88 */     this.campoSubTrama[5].descripcion = "Prefijo de nombre";
/*  89 */     this.campoSubTrama[5].contenido = "";
/*  90 */     this.campoSubTrama[5].requerido = 0;
/*  91 */     this.campoSubTrama[5].validar = 0;
/*     */     
/*  93 */     this.campoSubTrama[6].orden = 7;
/*  94 */     this.campoSubTrama[6].nombre = "NM107";
/*  95 */     this.campoSubTrama[6].atributo = "Alfanumerico";
/*  96 */     this.campoSubTrama[6].ubicacionByte = 0;
/*  97 */     this.campoSubTrama[6].longitudmin = 1;
/*  98 */     this.campoSubTrama[6].longitudmax = 10;
/*  99 */     this.campoSubTrama[6].descripcion = "Sufijo de nombre";
/* 100 */     this.campoSubTrama[6].contenido = "";
/* 101 */     this.campoSubTrama[6].requerido = 0;
/* 102 */     this.campoSubTrama[6].validar = 0;
/*     */     
/* 104 */     this.campoSubTrama[7].orden = 8;
/* 105 */     this.campoSubTrama[7].nombre = "NM108";
/* 106 */     this.campoSubTrama[7].atributo = "Alfanumerico";
/* 107 */     this.campoSubTrama[7].ubicacionByte = 0;
/* 108 */     this.campoSubTrama[7].longitudmin = 1;
/* 109 */     this.campoSubTrama[7].longitudmax = 2;
/* 110 */     this.campoSubTrama[7].descripcion = "Codigo Calificador";
/* 111 */     this.campoSubTrama[7].contenido = "";
/* 112 */     this.campoSubTrama[7].requerido = 0;
/* 113 */     this.campoSubTrama[7].validar = 0;
/*     */     
/* 115 */     this.campoSubTrama[8].orden = 9;
/* 116 */     this.campoSubTrama[8].nombre = "NM109";
/* 117 */     this.campoSubTrama[8].atributo = "Alfanumerico";
/* 118 */     this.campoSubTrama[8].ubicacionByte = 0;
/* 119 */     this.campoSubTrama[8].longitudmin = 2;
/* 120 */     this.campoSubTrama[8].longitudmax = 20;
/* 121 */     this.campoSubTrama[8].descripcion = "Codigo de Identificación";
/* 122 */     this.campoSubTrama[8].contenido = "";
/* 123 */     this.campoSubTrama[8].requerido = 0;
/* 124 */     this.campoSubTrama[8].validar = 0;
/*     */     
/* 126 */     this.campoSubTrama[9].orden = 10;
/* 127 */     this.campoSubTrama[9].nombre = "NM110";
/* 128 */     this.campoSubTrama[9].atributo = "Alfanumerico";
/* 129 */     this.campoSubTrama[9].ubicacionByte = 0;
/* 130 */     this.campoSubTrama[9].longitudmin = 2;
/* 131 */     this.campoSubTrama[9].longitudmax = 2;
/* 132 */     this.campoSubTrama[9].descripcion = "Codigo de referencia con Entidad";
/* 133 */     this.campoSubTrama[9].contenido = "";
/* 134 */     this.campoSubTrama[9].requerido = 0;
/* 135 */     this.campoSubTrama[9].validar = 0;
/*     */     
/* 137 */     this.campoSubTrama[10].orden = 11;
/* 138 */     this.campoSubTrama[10].nombre = "NM111";
/* 139 */     this.campoSubTrama[10].atributo = "Alfanumerico";
/* 140 */     this.campoSubTrama[10].ubicacionByte = 0;
/* 141 */     this.campoSubTrama[10].longitudmin = 2;
/* 142 */     this.campoSubTrama[10].longitudmax = 3;
/* 143 */     this.campoSubTrama[10].descripcion = "Codigo de identificacion de Entidad";
/* 144 */     this.campoSubTrama[10].contenido = "";
/* 145 */     this.campoSubTrama[10].requerido = 0;
/* 146 */     this.campoSubTrama[10].validar = 0;
/*     */     
/* 148 */     this.campoSubTrama[11].orden = 12;
/* 149 */     this.campoSubTrama[11].nombre = "NM112";
/* 150 */     this.campoSubTrama[11].atributo = "Alfanumerico";
/* 151 */     this.campoSubTrama[11].ubicacionByte = 0;
/* 152 */     this.campoSubTrama[11].longitudmin = 1;
/* 153 */     this.campoSubTrama[11].longitudmax = 60;
/* 154 */     this.campoSubTrama[11].descripcion = "Apellido materno";
/* 155 */     this.campoSubTrama[11].contenido = "";
/* 156 */     this.campoSubTrama[11].requerido = 0;
/* 157 */     this.campoSubTrama[11].validar = 0;
/*     */   }
/*     */   
/*     */   public void generaSubTrama(String sCoIdentificador, String sTiCalificador, String sCoCalificador, String sCoIdentificacion) {
/* 161 */     this.campoSubTrama[0].contenido = sCoIdentificador;
/* 162 */     this.campoSubTrama[1].contenido = sTiCalificador;
/* 163 */     this.campoSubTrama[7].contenido = sCoCalificador;
/* 164 */     this.campoSubTrama[8].contenido = sCoIdentificacion;
/*     */   }
/*     */   
/*     */   public void generaSubTrama(String sParamter1, String sParamte5) {
/* 168 */     this.campoSubTrama[0].contenido = sParamter1;
/* 169 */     this.campoSubTrama[4].contenido = sParamte5;
/*     */   }
/*     */   
/*     */   public void generaSubTrama(String sCoIdentificador, String sTiCalificador, String sApPaterno, String sNombres1, String sNombres2, String sNombres3, String sNombres4, String CoIdentificacion, String coAfiliado, String sApMaterno) {
/* 173 */     this.campoSubTrama[0].contenido = sCoIdentificador;
/* 174 */     this.campoSubTrama[1].contenido = sTiCalificador;
/* 175 */     this.campoSubTrama[2].contenido = sApPaterno;
/* 176 */     this.campoSubTrama[3].contenido = sNombres1;
/* 177 */     this.campoSubTrama[4].contenido = sNombres2;
/* 178 */     this.campoSubTrama[5].contenido = sNombres3;
/* 179 */     this.campoSubTrama[6].contenido = sNombres4;
/* 180 */     this.campoSubTrama[7].contenido = CoIdentificacion;
/* 181 */     this.campoSubTrama[8].contenido = coAfiliado;
/* 182 */     this.campoSubTrama[11].contenido = sApMaterno;
/*     */   }
/*     */ }


/* Location:              D:\WorkSpace\Desarrollo Afiliacion On Linea\Fuentes\FebanAfiliacionesFH\lib\jr-afiliacion-susalud_v1.5.jar!\pe\gob\susalud\jr\transaccion\susalud\trama\SubTrama_NM1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */