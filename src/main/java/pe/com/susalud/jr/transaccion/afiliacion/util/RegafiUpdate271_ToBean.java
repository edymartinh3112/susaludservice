/*     */ package pe.com.susalud.jr.transaccion.afiliacion.util;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;

		import pe.com.susalud.jr.transaccion.afiliacion.bean.In271RegafiUpdate;
		import pe.com.susalud.jr.transaccion.afiliacion.bean.In271RegafiUpdateAfiliacion;
		import pe.com.susalud.jr.transaccion.afiliacion.bean.In271RegafiUpdateAfiliado;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.bean.In271RegafiUpdate;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.bean.In271RegafiUpdateAfiliacion;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.bean.In271RegafiUpdateAfiliado;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RegafiUpdate271_ToBean
/*     */ {
/*  17 */   private static Boolean flagISA = Boolean.valueOf(true);
/*  18 */   private static Boolean flaGS = Boolean.valueOf(true);
/*  19 */   private static Boolean flagST = Boolean.valueOf(true);
/*  20 */   private static Boolean flagBHT = Boolean.valueOf(true);
/*  21 */   private static Boolean flagNM1 = Boolean.valueOf(true);
/*  22 */   private static Boolean flagREF = Boolean.valueOf(true);
/*  23 */   private static Boolean flagN2 = Boolean.valueOf(true);
/*  24 */   private static Boolean flagN4 = Boolean.valueOf(true);
/*  25 */   private static Boolean flagDTP = Boolean.valueOf(true);
/*  26 */   private static Boolean flagEB = Boolean.valueOf(true);
/*  27 */   private static Boolean flagDMG = Boolean.valueOf(true);
/*  28 */   private static Boolean flagPRV = Boolean.valueOf(true);
/*     */   
/*  30 */   private static Integer tagREF = Integer.valueOf(1);
/*  31 */   private static Integer tagNM1 = Integer.valueOf(1);
/*  32 */   private static Integer tagDMG = Integer.valueOf(1);
/*  33 */   private static Integer tagN2 = Integer.valueOf(1);
/*  34 */   private static Integer tagPRV = Integer.valueOf(1);
/*  35 */   private static Integer tagDTP = Integer.valueOf(1);
/*  36 */   private static Integer tagEB = Integer.valueOf(1);
/*  37 */   private static String tagHL = null;
/*  38 */   private static Integer con01 = Integer.valueOf(0); private static Integer con02 = Integer.valueOf(0);
/*     */   
/*     */   public static In271RegafiUpdate traducirEstructura271(String cadena) {
/*  41 */     flagISA = Boolean.valueOf(true);
/*  42 */     flaGS = Boolean.valueOf(true);
/*  43 */     flagST = Boolean.valueOf(true);
/*  44 */     flagBHT = Boolean.valueOf(true);
/*  45 */     flagNM1 = Boolean.valueOf(true);
/*  46 */     flagREF = Boolean.valueOf(true);
/*  47 */     flagN2 = Boolean.valueOf(true);
/*  48 */     flagN4 = Boolean.valueOf(true);
/*  49 */     flagDTP = Boolean.valueOf(true);
/*  50 */     flagEB = Boolean.valueOf(true);
/*  51 */     flagDMG = Boolean.valueOf(true);
/*  52 */     flagPRV = Boolean.valueOf(true);
/*     */     
/*  54 */     tagREF = Integer.valueOf(1);
/*  55 */     tagNM1 = Integer.valueOf(1);
/*  56 */     tagDMG = Integer.valueOf(1);
/*  57 */     tagN2 = Integer.valueOf(1);
/*  58 */     tagPRV = Integer.valueOf(1);
/*  59 */     tagDTP = Integer.valueOf(1);
/*  60 */     tagEB = Integer.valueOf(1);
/*  61 */     tagHL = null;
/*  62 */     con01 = Integer.valueOf(0);
/*  63 */     con02 = Integer.valueOf(0);
/*     */     
/*     */ 
/*  66 */     String[] canDetalle = cantidaSegmentosTx(cadena);
/*     */     
/*     */ 
/*     */ 
/*  70 */     int can01 = Integer.parseInt(canDetalle[0].trim());
/*  71 */     int can02 = Integer.parseInt(canDetalle[1].trim());
/*     */     
/*  73 */     In271RegafiUpdate in271RegafiUpdate = new In271RegafiUpdate();
/*  74 */     String[] arrayCadena = cadena.split("\\~");
/*     */     
/*  76 */     for (String s2 : arrayCadena)
/*     */     {
/*  78 */       String dataCadena = s2;
/*  79 */       String[] s1 = dataCadena.split("\\*");
/*     */       
/*  81 */       if (s1[0].trim().equals("ISA")) {
/*  82 */         if (flagISA.booleanValue()) {
/*  83 */           cargarCamposISA(s1, in271RegafiUpdate);
/*     */         }
/*  85 */       } else if (s1[0].trim().equals("GS")) {
/*  86 */         if (flaGS.booleanValue()) {
/*  87 */           cargarCamposGS(s1, in271RegafiUpdate);
/*     */         }
/*  89 */       } else if (s1[0].trim().equals("ST")) {
/*  90 */         if (flagST.booleanValue()) {
/*  91 */           cargarCamposST(s1, in271RegafiUpdate);
/*     */         }
/*  93 */       } else if (s1[0].trim().equals("BHT")) {
/*  94 */         if (flagBHT.booleanValue()) {
/*  95 */           cargarCamposBHT(s1, in271RegafiUpdate);
/*     */         }
/*  97 */       } else if (s1[0].trim().equals("HL")) {
/*  98 */         cargarCamposNM1(s1, in271RegafiUpdate);
/*  99 */       } else if (s1[0].trim().equals("NM1")) {
/* 100 */         if (flagNM1.booleanValue()) {
/* 101 */           cargarCamposNM1(s1, in271RegafiUpdate);
/*     */         }
/* 103 */       } else if (s1[0].trim().equals("REF")) {
/* 104 */         if (flagREF.booleanValue()) {
/* 105 */           cargarCamposREF(s1, in271RegafiUpdate, can02);
/*     */         }
/* 107 */       } else if (s1[0].trim().equals("N2")) {
/* 108 */         if (flagN2.booleanValue()) {
/* 109 */           cargarCamposN2(s1, in271RegafiUpdate);
/*     */         }
/* 111 */       } else if (s1[0].trim().equals("N4")) {
/* 112 */         if (flagN4.booleanValue()) {
/* 113 */           cargarCamposN4(s1, in271RegafiUpdate);
/*     */         }
/* 115 */       } else if (s1[0].trim().equals("DMG")) {
/* 116 */         if (flagDMG.booleanValue()) {
/* 117 */           cargarCamposDMG(s1, in271RegafiUpdate, can01);
/*     */         }
/* 119 */       } else if (s1[0].trim().equals("PRV")) {
/* 120 */         if (flagPRV.booleanValue()) {
/* 121 */           cargarCamposPRV(s1, in271RegafiUpdate);
/*     */         }
/* 123 */       } else if (s1[0].trim().equals("DTP")) {
/* 124 */         if (flagDTP.booleanValue()) {
/* 125 */           cargarCamposDTP(s1, in271RegafiUpdate);
/*     */ 
/*     */         }
/*     */         
/*     */ 
/*     */       }
/* 131 */       else if ((s1[0].trim().equals("EB")) && 
/* 132 */         (flagEB.booleanValue())) {
/* 133 */         cargarCamposEB(s1, in271RegafiUpdate, can01, can02);
/*     */       }
/*     */     }
/*     */     
/* 137 */     return in271RegafiUpdate;
/*     */   }
/*     */   
/*     */   private static In271RegafiUpdate cargarCamposISA(String[] s1, In271RegafiUpdate arrayCadena) {
/* 141 */     arrayCadena.setNoTransaccion("271_REGAFI_UPDATE");
/* 142 */     if (!"".equals(s1[6].trim())) arrayCadena.setIdRemitente(s1[6]);
/* 143 */     if (!"".equals(s1[8].trim())) arrayCadena.setIdReceptor(s1[8]);
/* 144 */     if (!"".equals(s1[13].trim())) { arrayCadena.setIdCorrelativo(s1[13]);
/*     */     }
/*     */     
/*     */ 
/* 148 */     flagISA = Boolean.valueOf(false);
/* 149 */     return arrayCadena;
/*     */   }
/*     */   
/*     */   private static In271RegafiUpdate cargarCamposGS(String[] s1, In271RegafiUpdate arrayCadena) {
/* 153 */     if (!"".equals(s1[4].trim())) arrayCadena.setFeTransaccion(s1[4]);
/* 154 */     if (!"".equals(s1[5].trim())) { arrayCadena.setHoTransaccion(s1[5]);
/*     */     }
/*     */     
/* 157 */     flaGS = Boolean.valueOf(false);
/* 158 */     return arrayCadena;
/*     */   }
/*     */   
/*     */   private static In271RegafiUpdate cargarCamposST(String[] s1, In271RegafiUpdate arrayCadena) {
/* 162 */     if (!"".equals(s1[1].trim())) { arrayCadena.setIdTransaccion(s1[1]);
/*     */     }
/* 164 */     flagST = Boolean.valueOf(false);
/* 165 */     return arrayCadena;
/*     */   }
/*     */   
/*     */   private static In271RegafiUpdate cargarCamposBHT(String[] s1, In271RegafiUpdate arrayCadena) {
/* 169 */     if (!"".equals(s1[2].trim())) { arrayCadena.setTiFinalidad(s1[2]);
/*     */     }
/* 171 */     flagBHT = Boolean.valueOf(false);
/* 172 */     return arrayCadena;
/*     */   }
/*     */   
/*     */   private static In271RegafiUpdate cargarCamposNM1(String[] s1, In271RegafiUpdate arrayCadena)
/*     */   {
/* 177 */     if (s1[0].trim().equals("HL")) {
/* 178 */       tagHL = s1[1].trim();
/*     */     }
/*     */     
/* 181 */     if (("1".equals(tagHL)) && (s1[0].trim().equals("NM1"))) {
/* 182 */       if (!"".equals(s1[2].trim())) arrayCadena.setCaRemitente(s1[2]);
/* 183 */       if (!"".equals(s1[9].trim())) { arrayCadena.setIdRemitente(s1[9]);
/*     */       }
/*     */       
/* 186 */       tagNM1 = Integer.valueOf(tagNM1.intValue() + 1);
/*     */     }
/* 188 */     else if (("2".equals(tagHL)) && (s1[0].trim().equals("NM1"))) {
/* 189 */       if (tagNM1.intValue() == 2) {
/* 190 */         In271RegafiUpdateAfiliado detalle = new In271RegafiUpdateAfiliado();
/*     */         
/* 192 */         if (!"".equals(s1[3].trim())) detalle.setApPaternoAfiliado(s1[3]);
/* 193 */         if (!"".equals(s1[4].trim())) detalle.setNoAfiliado1(s1[4]);
/* 194 */         if (!"".equals(s1[5].trim())) detalle.setNoAfiliado2(s1[5]);
/* 195 */         if (!"".equals(s1[12].trim())) { detalle.setApMaternoAfiliado(s1[12]);
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 201 */         arrayCadena.addDetalle(detalle);
/* 202 */         tagNM1 = Integer.valueOf(tagNM1.intValue() + 1);
/* 203 */       } else if (tagNM1.intValue() == 3) {
/* 204 */         tagNM1 = Integer.valueOf(tagNM1.intValue() + 1);
/* 205 */       } else if (tagNM1.intValue() == 4) {
/* 206 */         tagNM1 = Integer.valueOf(tagNM1.intValue() + 1);
/*     */       }
/* 208 */     } else if (("3".equals(tagHL)) && (s1[0].trim().equals("NM1"))) {
/* 209 */       if (tagNM1.intValue() == 5) {
/* 210 */         In271RegafiUpdateAfiliacion detalle1 = new In271RegafiUpdateAfiliacion();
/* 211 */         arrayCadena.addDetalle(detalle1);
/* 212 */         tagNM1 = Integer.valueOf(tagNM1.intValue() + 1);
/* 213 */       } else if (tagNM1.intValue() == 6) {
/* 214 */         if (!"".equals(s1[2].trim())) ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setTiContratante(s1[2]);
/* 215 */         if (!"".equals(s1[3].trim())) ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setApPaternoContratante(s1[3]);
/* 216 */         if (!"".equals(s1[4].trim())) ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setNoContratante1(s1[4]);
/* 217 */         if (!"".equals(s1[5].trim())) ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setNoContratante2(s1[5]);
/* 218 */         if (!"".equals(s1[6].trim())) ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setNoContratante3(s1[6]);
/* 219 */         if (!"".equals(s1[7].trim())) ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setNoContratante4(s1[7]);
/* 220 */         if (!"".equals(s1[12].trim())) { ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setApMaternoContratante(s1[12]);
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 228 */         tagNM1 = Integer.valueOf(tagNM1.intValue() + 1);
/*     */       }
/*     */     }
/* 231 */     return arrayCadena;
/*     */   }
/*     */   
/*     */   private static In271RegafiUpdate cargarCamposREF(String[] s1, In271RegafiUpdate arrayCadena, int can02)
/*     */   {
/* 236 */     if ((s1[0].trim().equals("REF")) && (tagREF.intValue() == 1)) {
/* 237 */       if (!"".equals(s1[2].trim())) { arrayCadena.setTiOperacion(s1[2]);
/*     */       }
/*     */       
/* 240 */       tagREF = Integer.valueOf(tagREF.intValue() + 1);
/* 241 */     } else if ((s1[0].trim().equals("REF")) && (tagREF.intValue() == 2)) {
/* 242 */       if (!"".equals(s1[2].trim())) { ((In271RegafiUpdateAfiliado)arrayCadena.getDetallesAfiliados().get(arrayCadena.getDetallesAfiliados().size() - 1)).setTiDocumentoAfil(s1[2]);
/*     */       }
/*     */       
/* 245 */       String[] ref04 = s1[4].split(":", 0);
/* 246 */       if (!"".equals(ref04[1].trim())) { ((In271RegafiUpdateAfiliado)arrayCadena.getDetallesAfiliados().get(arrayCadena.getDetallesAfiliados().size() - 1)).setNuDocumentoAfil(ref04[1]);
/*     */       }
/* 248 */       tagREF = Integer.valueOf(tagREF.intValue() + 1);
/* 249 */     } else if ((s1[0].trim().equals("REF")) && (tagREF.intValue() == 3)) {
/* 250 */       if (!"".equals(s1[2].trim())) { ((In271RegafiUpdateAfiliado)arrayCadena.getDetallesAfiliados().get(arrayCadena.getDetallesAfiliados().size() - 1)).setEstadoAfiliado(s1[2]);
/*     */       }
/*     */       
/* 253 */       tagREF = Integer.valueOf(tagREF.intValue() + 1);
/* 254 */     } else if ((s1[0].trim().equals("REF")) && (tagREF.intValue() == 4)) {
/* 255 */       if (!"".equals(s1[2].trim())) { ((In271RegafiUpdateAfiliado)arrayCadena.getDetallesAfiliados().get(arrayCadena.getDetallesAfiliados().size() - 1)).setTiDocumentoAct(s1[2]);
/*     */       }
/*     */       
/* 258 */       String[] ref04 = s1[4].split(":", 0);
/* 259 */       if (!"".equals(ref04[1].trim())) { ((In271RegafiUpdateAfiliado)arrayCadena.getDetallesAfiliados().get(arrayCadena.getDetallesAfiliados().size() - 1)).setNuDocumentoAct(ref04[1]);
/*     */       }
/* 261 */       tagREF = Integer.valueOf(tagREF.intValue() + 1);
/* 262 */     } else if ((s1[0].trim().equals("REF")) && (tagREF.intValue() == 5)) {
/* 263 */       if (!"".equals(s1[2].trim())) { ((In271RegafiUpdateAfiliado)arrayCadena.getDetallesAfiliados().get(arrayCadena.getDetallesAfiliados().size() - 1)).setIdAfiliadoNombre(s1[2]);
/*     */       }
/* 265 */       tagREF = Integer.valueOf(tagREF.intValue() + 1);
/* 266 */     } else if ((s1[0].trim().equals("REF")) && (tagREF.intValue() == 6)) {
/* 267 */       if (!"".equals(s1[2].trim())) { ((In271RegafiUpdateAfiliado)arrayCadena.getDetallesAfiliados().get(arrayCadena.getDetallesAfiliados().size() - 1)).setTiDocTutor(s1[2]);
/*     */       }
/*     */       
/* 270 */       String[] ref04 = s1[4].split(":", 0);
/* 271 */       if (!"".equals(ref04[1].trim())) { ((In271RegafiUpdateAfiliado)arrayCadena.getDetallesAfiliados().get(arrayCadena.getDetallesAfiliados().size() - 1)).setNuDocTutor(ref04[1]);
/*     */       }
/* 273 */       tagREF = Integer.valueOf(tagREF.intValue() + 1);
/* 274 */     } else if ((s1[0].trim().equals("REF")) && (tagREF.intValue() == 7)) {
/* 275 */       if (!"".equals(s1[2].trim())) { ((In271RegafiUpdateAfiliado)arrayCadena.getDetallesAfiliados().get(arrayCadena.getDetallesAfiliados().size() - 1)).setTiVinculoTutor(s1[2]);
/*     */       }
/*     */       
/* 278 */       tagREF = Integer.valueOf(tagREF.intValue() + 1);
/* 279 */     } else if ((s1[0].trim().equals("REF")) && (tagREF.intValue() == 8)) {
/* 280 */       if (!"".equals(s1[2].trim())) { ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setTiDocTitular(s1[2]);
/*     */       }
/*     */       
/* 283 */       String[] ref04 = s1[4].split(":", 0);
/* 284 */       if (!"".equals(ref04[1].trim())) { ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setNuDocTitular(ref04[1]);
/*     */       }
/* 286 */       tagREF = Integer.valueOf(tagREF.intValue() + 1);
/* 287 */     } else if ((s1[0].trim().equals("REF")) && (tagREF.intValue() == 9)) {
/* 288 */       if (!"".equals(s1[2].trim())) { ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setTiDocContratante(s1[2]);
/*     */       }
/*     */       
/* 291 */       String[] ref04 = s1[4].split(":", 0);
/* 292 */       if (!"".equals(ref04[1].trim())) { ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setNuDocContratante(ref04[1]);
/*     */       }
/* 294 */       tagREF = Integer.valueOf(tagREF.intValue() + 1);
/* 295 */     } else if ((s1[0].trim().equals("REF")) && (tagREF.intValue() == 10)) {
/* 296 */       if (!"".equals(s1[2].trim())) { ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setCoAfiliacion(s1[2]);
/*     */       }
/*     */       
/* 299 */       tagREF = Integer.valueOf(tagREF.intValue() + 1);
/* 300 */     } else if ((s1[0].trim().equals("REF")) && (tagREF.intValue() == 11)) {
/* 301 */       if (!"".equals(s1[2].trim())) { ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setCoContrato(s1[2]);
/*     */       }
/*     */       
/* 304 */       tagREF = Integer.valueOf(tagREF.intValue() + 1);
/* 305 */     } else if ((s1[0].trim().equals("REF")) && (tagREF.intValue() == 12)) {
/* 306 */       if (!"".equals(s1[2].trim())) { ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setCoUnicoMultisectorial(s1[2]);
/*     */       }
/*     */       
/* 309 */       tagREF = Integer.valueOf(tagREF.intValue() + 1);
/* 310 */     } else if ((s1[0].trim().equals("REF")) && (tagREF.intValue() == 13)) {
/* 311 */       if (!"".equals(s1[2].trim())) { ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setTiregimen(s1[2]);
/*     */       }
/*     */       
/* 314 */       tagREF = Integer.valueOf(tagREF.intValue() + 1);
/* 315 */     } else if ((s1[0].trim().equals("REF")) && (tagREF.intValue() == 14)) {
/* 316 */       if (!"".equals(s1[2].trim())) ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setEsAfiliacion(s1[2]);
/* 317 */       if (!"".equals(s1[3].trim())) { ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setCoCausalBaja(s1[3]);
/*     */       }
/*     */       
/*     */ 
/* 321 */       tagREF = Integer.valueOf(tagREF.intValue() + 1);
/* 322 */     } else if ((s1[0].trim().equals("REF")) && (tagREF.intValue() == 15)) {
/* 323 */       if (!"".equals(s1[2].trim())) ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setTiPlanSalud(s1[2]);
/* 324 */       if (!"".equals(s1[3].trim())) { ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setNoProductoSalud(s1[3]);
/*     */       }
/*     */       
/*     */ 
/* 328 */       tagREF = Integer.valueOf(tagREF.intValue() + 1);
/* 329 */     } else if ((s1[0].trim().equals("REF")) && (tagREF.intValue() == 16)) {
/* 330 */       if (!"".equals(s1[2].trim())) { ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setCoProducto(s1[2]);
/*     */       }
/*     */       
/* 333 */       tagREF = Integer.valueOf(tagREF.intValue() + 1);
/* 334 */     } else if ((s1[0].trim().equals("REF")) && (tagREF.intValue() == 17)) {
/* 335 */       if (!"".equals(s1[2].trim())) { ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setParentesco(s1[2]);
/*     */       }
/*     */       
/* 338 */       tagREF = Integer.valueOf(tagREF.intValue() + 1);
/* 339 */     } else if ((s1[0].trim().equals("REF")) && (tagREF.intValue() == 18)) {
/* 340 */       if (!"".equals(s1[2].trim())) { ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setCoRenipress(s1[2]);
/*     */       }
/* 342 */       tagREF = Integer.valueOf(tagREF.intValue() + 1);
/* 343 */     } else if ((s1[0].trim().equals("REF")) && (tagREF.intValue() == 19)) {
/* 344 */       if (!"".equals(s1[2].trim())) { ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setIdAfiliacionNombre(s1[2]);
/*     */       }
/* 346 */       con02 = Integer.valueOf(con02.intValue() + 1);
/*     */       
/* 348 */       if (con02.intValue() < can02) {
/* 349 */         tagNM1 = Integer.valueOf(5);
/* 350 */         tagREF = Integer.valueOf(8);
/* 351 */         tagN2 = Integer.valueOf(2);
/* 352 */         tagDMG = Integer.valueOf(4);
/* 353 */         tagDTP = Integer.valueOf(2);
/*     */       }
/*     */     }
/* 356 */     return arrayCadena;
/*     */   }
/*     */   
/*     */   private static In271RegafiUpdate cargarCamposN2(String[] s1, In271RegafiUpdate arrayCadena) {
/* 360 */     if ((s1[0].trim().equals("N2")) && (tagN2.intValue() == 1)) {
/* 361 */       if (!"".equals(s1[1].trim())) { ((In271RegafiUpdateAfiliado)arrayCadena.getDetallesAfiliados().get(arrayCadena.getDetallesAfiliados().size() - 1)).setApCasadaAfiliado(s1[1]);
/*     */       }
/*     */       
/* 364 */       tagN2 = Integer.valueOf(tagN2.intValue() + 1);
/* 365 */     } else if ((s1[0].trim().equals("N2")) && (tagN2.intValue() == 2) && 
/* 366 */       (!"".equals(s1[1].trim()))) { ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setApCasadaContratante(s1[1]);
/*     */     }
/*     */     
/* 369 */     return arrayCadena;
/*     */   }
/*     */   
/*     */   private static In271RegafiUpdate cargarCamposN4(String[] s1, In271RegafiUpdate arrayCadena) {
/* 373 */     if (s1[0].trim().equals("N4")) {
/* 374 */       if (!"".equals(s1[1].trim())) ((In271RegafiUpdateAfiliado)arrayCadena.getDetallesAfiliados().get(arrayCadena.getDetallesAfiliados().size() - 1)).setCoNacionalidad(s1[1]);
/* 375 */       if (!"".equals(s1[6].trim())) { ((In271RegafiUpdateAfiliado)arrayCadena.getDetallesAfiliados().get(arrayCadena.getDetallesAfiliados().size() - 1)).setUbigeo(s1[6]);
/*     */       }
/*     */     }
/*     */     
/* 379 */     return arrayCadena;
/*     */   }
/*     */   
/*     */   private static In271RegafiUpdate cargarCamposDMG(String[] s1, In271RegafiUpdate arrayCadena, int can01)
/*     */   {
/* 384 */     if ((s1[0].trim().equals("DMG")) && (tagDMG.intValue() == 1)) {
/* 385 */       if (!"".equals(s1[2].trim())) ((In271RegafiUpdateAfiliado)arrayCadena.getDetallesAfiliados().get(arrayCadena.getDetallesAfiliados().size() - 1)).setFeNacimiento(s1[2]);
/* 386 */       if (!"".equals(s1[3].trim())) ((In271RegafiUpdateAfiliado)arrayCadena.getDetallesAfiliados().get(arrayCadena.getDetallesAfiliados().size() - 1)).setGenero(s1[3]);
/* 387 */       if (!"".equals(s1[7].trim())) { ((In271RegafiUpdateAfiliado)arrayCadena.getDetallesAfiliados().get(arrayCadena.getDetallesAfiliados().size() - 1)).setCoPaisDoc(s1[7]);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 392 */       tagDMG = Integer.valueOf(tagDMG.intValue() + 1);
/* 393 */       con01 = Integer.valueOf(con01.intValue() + 1);
/*     */     }
/* 395 */     else if ((s1[0].trim().equals("DMG")) && (tagDMG.intValue() == 2)) {
/* 396 */       if (!"".equals(s1[2].trim())) ((In271RegafiUpdateAfiliado)arrayCadena.getDetallesAfiliados().get(arrayCadena.getDetallesAfiliados().size() - 1)).setFefallecimiento(s1[2]);
/* 397 */       if (!"".equals(s1[7].trim())) { ((In271RegafiUpdateAfiliado)arrayCadena.getDetallesAfiliados().get(arrayCadena.getDetallesAfiliados().size() - 1)).setCoPaisEmisorDocAct(s1[7]);
/*     */       }
/*     */       
/* 400 */       tagDMG = Integer.valueOf(tagDMG.intValue() + 1);
/*     */     }
/* 402 */     else if ((s1[0].trim().equals("DMG")) && (tagDMG.intValue() == 3)) {
/* 403 */       if (!"".equals(s1[2].trim())) ((In271RegafiUpdateAfiliado)arrayCadena.getDetallesAfiliados().get(arrayCadena.getDetallesAfiliados().size() - 1)).setFeValidacionReniec(s1[2]);
/* 404 */       if (!"".equals(s1[7].trim())) { ((In271RegafiUpdateAfiliado)arrayCadena.getDetallesAfiliados().get(arrayCadena.getDetallesAfiliados().size() - 1)).setCoPaisEmisorDocTutor(s1[7]);
/*     */       }
/*     */       
/*     */ 
/* 408 */       if (con01.intValue() == can01) {
/* 409 */         tagDMG = Integer.valueOf(tagDMG.intValue() + 1);
/*     */       } else {
/* 411 */         tagNM1 = Integer.valueOf(2);
/* 412 */         tagREF = Integer.valueOf(2);
/* 413 */         tagN2 = Integer.valueOf(1);
/* 414 */         tagDMG = Integer.valueOf(1);
/* 415 */         tagDTP = Integer.valueOf(1);
/*     */       }
/* 417 */     } else if ((s1[0].trim().equals("DMG")) && (tagDMG.intValue() == 4)) {
/* 418 */       if (!"".equals(s1[2].trim())) ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setFeNacimientoTitular(s1[2]);
/* 419 */       if (!"".equals(s1[7].trim())) { ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setCoPaisEmisorDocTitular(s1[7]);
/*     */       }
/*     */       
/* 422 */       tagDMG = Integer.valueOf(tagDMG.intValue() + 1);
/* 423 */     } else if ((s1[0].trim().equals("DMG")) && (tagDMG.intValue() == 5)) {
/* 424 */       if (!"".equals(s1[2].trim())) ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setFeNacimientoContratante(s1[2]);
/* 425 */       if (!"".equals(s1[7].trim())) { ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setCoPaisEmisorDocContratante(s1[7]);
/*     */       }
/*     */       
/* 428 */       tagDMG = Integer.valueOf(tagDMG.intValue() + 1);
/*     */     }
/* 430 */     return arrayCadena;
/*     */   }
/*     */   
/*     */   private static In271RegafiUpdate cargarCamposPRV(String[] s1, In271RegafiUpdate arrayCadena)
/*     */   {
/* 435 */     if ((s1[0].trim().equals("PRV")) && (tagPRV.intValue() == 1) && 
/* 436 */       (!"".equals(s1[3].trim()))) { ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setPkAfiliado(s1[3]);
/*     */     }
/*     */     
/* 439 */     return arrayCadena;
/*     */   }
/*     */   
/*     */   private static In271RegafiUpdate cargarCamposDTP(String[] s1, In271RegafiUpdate arrayCadena)
/*     */   {
/* 444 */     if ((s1[0].trim().equals("DTP")) && (tagDTP.intValue() == 1)) {
/* 445 */       if (!"".equals(s1[3].trim())) { ((In271RegafiUpdateAfiliado)arrayCadena.getIn271RegafiUpdateAfiliado().get(arrayCadena.getIn271RegafiUpdateAfiliado().size() - 1)).setFeActPersonaxIafas(s1[3]);
/*     */       }
/*     */       
/* 448 */       tagDTP = Integer.valueOf(tagDTP.intValue() + 1);
/* 449 */     } else if ((s1[0].trim().equals("DTP")) && (tagDTP.intValue() == 2)) {
/* 450 */       if (!"".equals(s1[3].trim())) { ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setFeActEstado(s1[3]);
/*     */       }
/*     */       
/* 453 */       tagDTP = Integer.valueOf(tagDTP.intValue() + 1);
/* 454 */     } else if ((s1[0].trim().equals("DTP")) && (tagDTP.intValue() == 3)) {
/* 455 */       if (!"".equals(s1[3].trim())) { ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setFeIniAfiliacion(s1[3]);
/*     */       }
/*     */       
/* 458 */       tagDTP = Integer.valueOf(tagDTP.intValue() + 1);
/* 459 */     } else if ((s1[0].trim().equals("DTP")) && (tagDTP.intValue() == 4)) {
/* 460 */       if (!"".equals(s1[3].trim())) { ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setFeFinAfiliacion(s1[3]);
/*     */       }
/*     */       
/* 463 */       tagDTP = Integer.valueOf(tagDTP.intValue() + 1);
/* 464 */     } else if ((s1[0].trim().equals("DTP")) && (tagDTP.intValue() == 5)) {
/* 465 */       if (!"".equals(s1[3].trim())) { ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setFeIniCobertura(s1[3]);
/*     */       }
/*     */       
/* 468 */       tagDTP = Integer.valueOf(tagDTP.intValue() + 1);
/* 469 */     } else if ((s1[0].trim().equals("DTP")) && (tagDTP.intValue() == 6)) {
/* 470 */       if (!"".equals(s1[3].trim())) { ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setFeFinCobertura(s1[3]);
/*     */       }
/*     */       
/* 473 */       tagDTP = Integer.valueOf(tagDTP.intValue() + 1);
/* 474 */     } else if ((s1[0].trim().equals("DTP")) && (tagDTP.intValue() == 7)) {
/* 475 */       if (!"".equals(s1[3].trim())) { ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setFeActOperacion(s1[3]);
/*     */       }
/*     */       
/* 478 */       tagDTP = Integer.valueOf(tagDTP.intValue() + 1);
/* 479 */     } else if ((s1[0].trim().equals("DTP")) && (tagDTP.intValue() == 8) && 
/* 480 */       (!"".equals(s1[3].trim()))) { ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setTiActOperacion(s1[3]);
/*     */     }
/*     */     
/* 483 */     return arrayCadena;
/*     */   }
/*     */   
/*     */   private static In271RegafiUpdate cargarCamposEB(String[] s1, In271RegafiUpdate arrayCadena, int can01, int can02) {
/* 487 */     if ((tagEB.intValue() == 1) && (s1[0].trim().equals("EB"))) {
/* 488 */       tagEB = Integer.valueOf(tagEB.intValue() + 1);
/* 489 */     } else if ((tagEB.intValue() == 2) && (s1[0].trim().equals("EB")) && 
/* 490 */       (!"".equals(s1[3].trim()))) { ((In271RegafiUpdateAfiliacion)arrayCadena.getIn271RegafiUpdateAfiliacion().get(arrayCadena.getIn271RegafiUpdateAfiliacion().size() - 1)).setCoTiCobertura(s1[3]);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 503 */     if ((can01 == con01.intValue()) && (can02 == con02.intValue())) {
/* 504 */       tagDTP = Integer.valueOf(1);
/* 505 */       flagISA = Boolean.valueOf(false);
/* 506 */       flaGS = Boolean.valueOf(false);
/* 507 */       flagST = Boolean.valueOf(false);
/* 508 */       flagBHT = Boolean.valueOf(false);
/* 509 */       flagNM1 = Boolean.valueOf(false);
/* 510 */       flagREF = Boolean.valueOf(false);
/* 511 */       flagN2 = Boolean.valueOf(false);
/* 512 */       flagN4 = Boolean.valueOf(false);
/* 513 */       flagDMG = Boolean.valueOf(false);
/* 514 */       flagPRV = Boolean.valueOf(false);
/* 515 */       flagDTP = Boolean.valueOf(false);
/* 516 */       flagEB = Boolean.valueOf(false);
/*     */     }
/*     */     
/* 519 */     return arrayCadena;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static String[] cantidaSegmentosTx(String cadena)
/*     */   {
/* 535 */     String[] arrayCadena1 = cadena.split("\\~");
/* 536 */     String canDetalle = null;
/* 537 */     String ST = "";String cant = "";
/* 538 */     int v1 = 0;int v2 = 0;int v3 = 0;
/* 539 */     String[] va1 = null;
/* 540 */     String[] va2 = null;
/*     */     
/* 542 */     if (arrayCadena1.length > 1)
/*     */     {
/*     */ 
/* 545 */       ST = arrayCadena1[2];
/* 546 */       va1 = ST.split("\\*");
/*     */       
/*     */ 
/* 549 */       cant = va1[3];
/* 550 */       va2 = cant.split("\\#");
/*     */       
/* 552 */       v1 = Integer.parseInt(va2[0].trim());
/* 553 */       v2 = Integer.parseInt(va2[1].trim());
/*     */       
/* 555 */       if (v1 == 0) {
/* 556 */         va2[0] = "1";
/*     */       }
/* 558 */       if (v2 == 0) {
/* 559 */         va2[1] = "1";
/*     */       }
/*     */     }
/* 562 */     return va2;
/*     */   }
/*     */ }
