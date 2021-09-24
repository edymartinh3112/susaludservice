/*     */ package pe.com.susalud.jr.transaccion.afiliacion.trama.bean;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SubTrama_EB
/*     */   extends SubTrama
/*     */ {
/*     */   public SubTrama_EB()
/*     */   {
/*  15 */     this.num_CamposSubTrama = 12;
/*     */     
/*  17 */     this.campoSubTrama[0] = new Campos();
/*  18 */     this.campoSubTrama[1] = new Campos();
/*  19 */     this.campoSubTrama[2] = new Campos();
/*  20 */     this.campoSubTrama[3] = new Campos();
/*  21 */     this.campoSubTrama[4] = new Campos();
/*  22 */     this.campoSubTrama[5] = new Campos();
/*  23 */     this.campoSubTrama[6] = new Campos();
/*  24 */     this.campoSubTrama[7] = new Campos();
/*  25 */     this.campoSubTrama[8] = new Campos();
/*  26 */     this.campoSubTrama[9] = new Campos();
/*  27 */     this.campoSubTrama[10] = new Campos();
/*  28 */     this.campoSubTrama[11] = new Campos();
/*     */     
/*  30 */     this.campoSubTrama[0].orden = 1;
/*  31 */     this.campoSubTrama[0].nombre = "EB01";
/*  32 */     this.campoSubTrama[0].atributo = "Alfanumerico";
/*  33 */     this.campoSubTrama[0].ubicacionByte = 0;
/*  34 */     this.campoSubTrama[0].longitudmin = 1;
/*  35 */     this.campoSubTrama[0].longitudmax = 2;
/*  36 */     this.campoSubTrama[0].descripcion = "Id identificador";
/*  37 */     this.campoSubTrama[0].contenido = "";
/*  38 */     this.campoSubTrama[0].requerido = 1;
/*  39 */     this.campoSubTrama[0].validar = 0;
/*     */     
/*  41 */     this.campoSubTrama[1].orden = 2;
/*  42 */     this.campoSubTrama[1].nombre = "EB02";
/*  43 */     this.campoSubTrama[1].atributo = "Alfanumerico";
/*  44 */     this.campoSubTrama[1].ubicacionByte = 0;
/*  45 */     this.campoSubTrama[1].longitudmin = 3;
/*  46 */     this.campoSubTrama[1].longitudmax = 3;
/*  47 */     this.campoSubTrama[1].descripcion = "Cod Nivel Cobertura";
/*  48 */     this.campoSubTrama[1].contenido = "";
/*  49 */     this.campoSubTrama[1].requerido = 1;
/*  50 */     this.campoSubTrama[1].validar = 0;
/*     */     
/*  52 */     this.campoSubTrama[2].orden = 3;
/*  53 */     this.campoSubTrama[2].nombre = "EB03";
/*  54 */     this.campoSubTrama[2].atributo = "Alfanumerico";
/*  55 */     this.campoSubTrama[2].ubicacionByte = 0;
/*  56 */     this.campoSubTrama[2].longitudmin = 1;
/*  57 */     this.campoSubTrama[2].longitudmax = 35;
/*  58 */     this.campoSubTrama[2].descripcion = "";
/*  59 */     this.campoSubTrama[2].contenido = "";
/*  60 */     this.campoSubTrama[2].requerido = 1;
/*  61 */     this.campoSubTrama[2].validar = 0;
/*     */     
/*  63 */     this.campoSubTrama[3].orden = 4;
/*  64 */     this.campoSubTrama[3].nombre = "EB04";
/*  65 */     this.campoSubTrama[3].atributo = "Alfanumerico";
/*  66 */     this.campoSubTrama[3].ubicacionByte = 0;
/*  67 */     this.campoSubTrama[3].longitudmin = 3;
/*  68 */     this.campoSubTrama[3].longitudmax = 3;
/*  69 */     this.campoSubTrama[3].descripcion = "";
/*  70 */     this.campoSubTrama[3].contenido = "";
/*  71 */     this.campoSubTrama[3].requerido = 1;
/*  72 */     this.campoSubTrama[3].validar = 0;
/*     */     
/*  74 */     this.campoSubTrama[4].orden = 5;
/*  75 */     this.campoSubTrama[4].nombre = "EB05";
/*  76 */     this.campoSubTrama[4].atributo = "Alfanumerico";
/*  77 */     this.campoSubTrama[4].ubicacionByte = 0;
/*  78 */     this.campoSubTrama[4].longitudmin = 1;
/*  79 */     this.campoSubTrama[4].longitudmax = 50;
/*  80 */     this.campoSubTrama[4].descripcion = "";
/*  81 */     this.campoSubTrama[4].contenido = "";
/*  82 */     this.campoSubTrama[4].requerido = 1;
/*  83 */     this.campoSubTrama[4].validar = 0;
/*     */     
/*  85 */     this.campoSubTrama[5].orden = 6;
/*  86 */     this.campoSubTrama[5].nombre = "EB06";
/*  87 */     this.campoSubTrama[5].atributo = "Alfanumerico";
/*  88 */     this.campoSubTrama[5].ubicacionByte = 0;
/*  89 */     this.campoSubTrama[5].longitudmin = 1;
/*  90 */     this.campoSubTrama[5].longitudmax = 35;
/*  91 */     this.campoSubTrama[5].descripcion = "";
/*  92 */     this.campoSubTrama[5].contenido = "";
/*  93 */     this.campoSubTrama[5].requerido = 1;
/*  94 */     this.campoSubTrama[5].validar = 0;
/*     */     
/*  96 */     this.campoSubTrama[6].orden = 7;
/*  97 */     this.campoSubTrama[6].nombre = "EB07";
/*  98 */     this.campoSubTrama[6].atributo = "Alfanumerico";
/*  99 */     this.campoSubTrama[6].ubicacionByte = 0;
/* 100 */     this.campoSubTrama[6].longitudmin = 1;
/* 101 */     this.campoSubTrama[6].longitudmax = 18;
/* 102 */     this.campoSubTrama[6].descripcion = "Beneficio maximo Inicial";
/* 103 */     this.campoSubTrama[6].contenido = "";
/* 104 */     this.campoSubTrama[6].requerido = 1;
/* 105 */     this.campoSubTrama[6].validar = 0;
/*     */     
/* 107 */     this.campoSubTrama[7].orden = 8;
/* 108 */     this.campoSubTrama[7].nombre = "EB08";
/* 109 */     this.campoSubTrama[7].atributo = "Alfanumerico";
/* 110 */     this.campoSubTrama[7].ubicacionByte = 0;
/* 111 */     this.campoSubTrama[7].longitudmin = 1;
/* 112 */     this.campoSubTrama[7].longitudmax = 10;
/* 113 */     this.campoSubTrama[7].descripcion = "Monto de Cobertura";
/* 114 */     this.campoSubTrama[7].contenido = "";
/* 115 */     this.campoSubTrama[7].requerido = 1;
/* 116 */     this.campoSubTrama[7].validar = 0;
/*     */     
/* 118 */     this.campoSubTrama[8].orden = 9;
/* 119 */     this.campoSubTrama[8].nombre = "EB09";
/* 120 */     this.campoSubTrama[8].atributo = "Alfanumerico";
/* 121 */     this.campoSubTrama[8].ubicacionByte = 0;
/* 122 */     this.campoSubTrama[8].longitudmin = 2;
/* 123 */     this.campoSubTrama[8].longitudmax = 2;
/* 124 */     this.campoSubTrama[8].descripcion = "Código de tipo de Procedimiento";
/* 125 */     this.campoSubTrama[8].contenido = "";
/* 126 */     this.campoSubTrama[8].requerido = 1;
/* 127 */     this.campoSubTrama[8].validar = 0;
/*     */     
/* 129 */     this.campoSubTrama[9].orden = 10;
/* 130 */     this.campoSubTrama[9].nombre = "EB10";
/* 131 */     this.campoSubTrama[9].atributo = "Alfanumerico";
/* 132 */     this.campoSubTrama[9].ubicacionByte = 0;
/* 133 */     this.campoSubTrama[9].longitudmin = 1;
/* 134 */     this.campoSubTrama[9].longitudmax = 3;
/* 135 */     this.campoSubTrama[9].descripcion = "Cantidad de Servicio";
/* 136 */     this.campoSubTrama[9].contenido = "";
/* 137 */     this.campoSubTrama[9].requerido = 1;
/* 138 */     this.campoSubTrama[9].validar = 0;
/*     */     
/* 140 */     this.campoSubTrama[10].orden = 11;
/* 141 */     this.campoSubTrama[10].nombre = "EB11";
/* 142 */     this.campoSubTrama[10].atributo = "Alfanumerico";
/* 143 */     this.campoSubTrama[10].ubicacionByte = 0;
/* 144 */     this.campoSubTrama[10].longitudmin = 2;
/* 145 */     this.campoSubTrama[10].longitudmax = 3;
/* 146 */     this.campoSubTrama[10].descripcion = "";
/* 147 */     this.campoSubTrama[10].contenido = "";
/* 148 */     this.campoSubTrama[10].requerido = 1;
/* 149 */     this.campoSubTrama[10].validar = 0;
/*     */     
/* 151 */     this.campoSubTrama[11].orden = 12;
/* 152 */     this.campoSubTrama[11].nombre = "EB12";
/* 153 */     this.campoSubTrama[11].atributo = "Alfanumerico";
/* 154 */     this.campoSubTrama[11].ubicacionByte = 0;
/* 155 */     this.campoSubTrama[11].longitudmin = 1;
/* 156 */     this.campoSubTrama[11].longitudmax = 35;
/* 157 */     this.campoSubTrama[11].descripcion = "";
/* 158 */     this.campoSubTrama[11].contenido = "";
/* 159 */     this.campoSubTrama[11].requerido = 1;
/* 160 */     this.campoSubTrama[11].validar = 0;
/*     */   }
/*     */   
/*     */   public void generaSubTrama(String sParameter1, String sParameter2, String sParameter3, String sParameter5, String sParameter7, String sParameter8, String sParameter9, String sParameter10)
/*     */   {
/* 165 */     this.campoSubTrama[0].contenido = sParameter1;
/* 166 */     this.campoSubTrama[1].contenido = sParameter2;
/* 167 */     this.campoSubTrama[2].contenido = sParameter3;
/* 168 */     this.campoSubTrama[4].contenido = sParameter5;
/* 169 */     this.campoSubTrama[6].contenido = sParameter7;
/* 170 */     this.campoSubTrama[7].contenido = sParameter8;
/* 171 */     this.campoSubTrama[8].contenido = sParameter9;
/* 172 */     this.campoSubTrama[9].contenido = sParameter10;
/*     */   }
/*     */   
/*     */   public void generaSubTrama(String sParameter1, String sParameter3) {
/* 176 */     this.campoSubTrama[0].contenido = sParameter1;
/* 177 */     this.campoSubTrama[2].contenido = sParameter3;
/*     */   }
/*     */ }


/* Location:              D:\WorkSpace\Desarrollo Afiliacion On Linea\Fuentes\FebanAfiliacionesFH\lib\jr-afiliacion-susalud_v1.5.jar!\pe\gob\susalud\jr\transaccion\susalud\trama\SubTrama_EB.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */