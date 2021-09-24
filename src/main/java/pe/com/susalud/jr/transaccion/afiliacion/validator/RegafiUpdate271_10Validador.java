/*     */ package pe.com.susalud.jr.transaccion.afiliacion.validator;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;

	import pe.com.susalud.jr.transaccion.afiliacion.bean.In271RegafiUpdate;
	import pe.com.susalud.jr.transaccion.afiliacion.bean.In271RegafiUpdateAfiliacion;
	import pe.com.susalud.jr.transaccion.afiliacion.bean.In271RegafiUpdateAfiliado;
	import pe.com.susalud.jr.transaccion.afiliacion.util.ManagerUtil;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.bean.In271RegafiUpdate;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.bean.In271RegafiUpdateAfiliacion;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.bean.In271RegafiUpdateAfiliado;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.util.ManagerUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RegafiUpdate271_10Validador
/*     */ {
/*     */   public In271RegafiUpdate ValidateBeanInRegafiUpdate271(In271RegafiUpdate in271RegafiUpdate)
/*     */   {
/*  18 */     List<In271RegafiUpdateAfiliado> listPer = new ArrayList();
/*  19 */     List<In271RegafiUpdateAfiliacion> listAfi = new ArrayList();
/*  20 */     String error = "0000";
/*     */     
/*  22 */     String tiOperacion = in271RegafiUpdate.getTiOperacion();
/*     */     
/*     */ 
/*  25 */     if (("".equals(in271RegafiUpdate.getNoTransaccion())) || (in271RegafiUpdate.getNoTransaccion() == null)) {
/*  26 */       error = "0011";
/*  27 */     } else if (("".equals(in271RegafiUpdate.getIdRemitente())) || (in271RegafiUpdate.getIdRemitente() == null)) {
/*  28 */       error = "0021";
/*  29 */     } else if (("".equals(in271RegafiUpdate.getIdReceptor())) || (in271RegafiUpdate.getIdReceptor() == null)) {
/*  30 */       error = "0031";
/*  31 */     } else if (("".equals(in271RegafiUpdate.getFeTransaccion())) || (in271RegafiUpdate.getFeTransaccion() == null)) {
/*  32 */       error = "0041";
/*  33 */     } else if (("".equals(in271RegafiUpdate.getHoTransaccion())) || (in271RegafiUpdate.getHoTransaccion() == null)) {
/*  34 */       error = "0051";
/*  35 */     } else if (("".equals(in271RegafiUpdate.getIdCorrelativo())) || (in271RegafiUpdate.getIdCorrelativo() == null)) {
/*  36 */       error = "0061";
/*  37 */     } else if (("".equals(in271RegafiUpdate.getIdTransaccion())) || (in271RegafiUpdate.getIdTransaccion() == null)) {
/*  38 */       error = "0071";
/*  39 */     } else if (("".equals(in271RegafiUpdate.getTiFinalidad())) || (in271RegafiUpdate.getTiFinalidad() == null)) {
/*  40 */       error = "0081";
/*  41 */     } else if (("".equals(in271RegafiUpdate.getCaRemitente())) || (in271RegafiUpdate.getCaRemitente() == null)) {
/*  42 */       error = "0091";
/*     */     }
/*  44 */     else if ((in271RegafiUpdate.getDetallesAfiliados().size() >= 0) && (error.equals("0000")))
/*     */     {
/*  46 */       listPer = in271RegafiUpdate.getDetallesAfiliados();
/*  47 */       In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();
/*     */       
/*  49 */       if (listPer.size() == 0) {
/*  50 */         error = "1081";
/*     */       } else {
/*  52 */         for (int i = 0; i < listPer.size(); i++) {
/*  53 */           in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/*     */           
/*  55 */           if ((("".equals(in271RegafiUpdateAfiliado.getApMaternoAfiliado().trim())) || (in271RegafiUpdateAfiliado.getApMaternoAfiliado() == null)) && (("".equals(in271RegafiUpdateAfiliado.getApCasadaAfiliado().trim())) || (in271RegafiUpdateAfiliado.getApCasadaAfiliado() == null)) && (("".equals(in271RegafiUpdateAfiliado.getApPaternoAfiliado().trim())) || (in271RegafiUpdateAfiliado.getApPaternoAfiliado() == null)))
/*     */           {
/*     */ 
/*  58 */             error = "1056";
/*  59 */             break;
/*     */           }
/*     */           
/*     */ 
/*  63 */           if (("".equals(in271RegafiUpdateAfiliado.getNoAfiliado1().trim())) || (in271RegafiUpdateAfiliado.getNoAfiliado1() == null)) {
/*  64 */             error = "1081";
/*  65 */             break;
/*     */           }
/*     */           
/*     */ 
/*  69 */           if (("".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) || (in271RegafiUpdateAfiliado.getTiDocumentoAfil() == null)) {
/*  70 */             error = "1021";
/*  71 */             break; }
/*  72 */           if (((!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && ("".equals(in271RegafiUpdateAfiliado.getNuDocumentoAfil().trim()))) || (in271RegafiUpdateAfiliado.getNuDocumentoAfil() == null)) {
/*  73 */             error = "1031";
/*  74 */             break; }
/*  75 */           if (("".equals(in271RegafiUpdateAfiliado.getEstadoAfiliado().trim())) || (in271RegafiUpdateAfiliado.getEstadoAfiliado() == null)) {
/*  76 */             error = "1121";
/*  77 */             break; }
/*  78 */           if (("".equals(in271RegafiUpdateAfiliado.getTiDocumentoAct().trim())) || (in271RegafiUpdateAfiliado.getTiDocumentoAct() == null)) {
/*  79 */             error = "1201";
/*  80 */             break; }
/*  81 */           if (("".equals(in271RegafiUpdateAfiliado.getNuDocumentoAct().trim())) || (in271RegafiUpdateAfiliado.getNuDocumentoAct() == null)) {
/*  82 */             error = "1211";
/*  83 */             break;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  93 */           if (("".equals(in271RegafiUpdateAfiliado.getFeNacimiento().trim())) || (in271RegafiUpdateAfiliado.getFeNacimiento() == null)) {
/*  94 */             error = "1091";
/*  95 */             break; }
/*  96 */           if (("".equals(in271RegafiUpdateAfiliado.getGenero().trim())) || (in271RegafiUpdateAfiliado.getGenero() == null)) {
/*  97 */             error = "1111";
/*  98 */             break; }
/*  99 */           if (("".equals(in271RegafiUpdateAfiliado.getCoPaisDoc().trim())) || (in271RegafiUpdateAfiliado.getCoPaisDoc() == null)) {
/* 100 */             error = "1011";
/* 101 */             break;
/*     */           }
/*     */           
/*     */ 
/* 105 */           if (("".equals(in271RegafiUpdateAfiliado.getCoPaisEmisorDocAct().trim())) || (in271RegafiUpdateAfiliado.getCoPaisEmisorDocAct() == null)) {
/* 106 */             error = "1191";
/* 107 */             break; }
/* 108 */           if (("".equals(in271RegafiUpdateAfiliado.getFeActPersonaxIafas().trim())) || (in271RegafiUpdateAfiliado.getFeActPersonaxIafas() == null)) {
/* 109 */             error = "1221";
/* 110 */             break;
/*     */           }
/*     */         }
/*     */       }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 130 */     if ((in271RegafiUpdate.getIn271RegafiUpdateAfiliacion().size() >= 0) && (error.equals("0000")))
/*     */     {
/* 132 */       listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/* 133 */       In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/*     */       
/* 135 */       if (listAfi.size() == 0) {
/* 136 */         error = "2221";
/*     */       } else {
/* 138 */         for (int i = 0; i < listAfi.size(); i++) {
/* 139 */           in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/*     */           
/* 141 */           if (("".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) || (in271RegafiUpdateAfiliacion.getTiDocTitular() == null)) {
/* 142 */             error = "2221";
/* 143 */             break; }
/* 144 */           if (("".equals(in271RegafiUpdateAfiliacion.getNuDocTitular().trim())) || (in271RegafiUpdateAfiliacion.getNuDocTitular() == null)) {
/* 145 */             error = "2231";
/* 146 */             break; }
/* 147 */           if (("".equals(in271RegafiUpdateAfiliacion.getFeNacimientoTitular().trim())) || (in271RegafiUpdateAfiliacion.getFeNacimientoTitular() == null)) {
/* 148 */             error = "2241";
/* 149 */             break; }
/* 150 */           if (("".equals(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular().trim())) || (in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular() == null)) {
/* 151 */             error = "2211";
/* 152 */             break; }
/* 153 */           if (("".equals(in271RegafiUpdateAfiliacion.getTiContratante().trim())) || (in271RegafiUpdateAfiliacion.getTiContratante() == null)) {
/* 154 */             error = "2251";
/* 155 */             break;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 165 */           if (("".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())) || (in271RegafiUpdateAfiliacion.getTiDocContratante() == null)) {
/* 166 */             error = "2071";
/* 167 */             break; }
/* 168 */           if (("".equals(in271RegafiUpdateAfiliacion.getNuDocContratante().trim())) || (in271RegafiUpdateAfiliacion.getNuDocContratante() == null)) {
/* 169 */             error = "2081";
/* 170 */             break;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 177 */           if (("".equals(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante().trim())) || (in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante() == null)) {
/* 178 */             error = "2061";
/* 179 */             break; }
/* 180 */           if (("".equals(in271RegafiUpdateAfiliacion.getCoAfiliacion().trim())) || (in271RegafiUpdateAfiliacion.getCoAfiliacion() == null)) {
/* 181 */             error = "2011";
/* 182 */             break; }
/* 183 */           if (("".equals(in271RegafiUpdateAfiliacion.getCoContrato().trim())) || (in271RegafiUpdateAfiliacion.getCoContrato() == null)) {
/* 184 */             error = "2021";
/* 185 */             break;
/*     */           }
/*     */           
/*     */ 
/* 189 */           if (("".equals(in271RegafiUpdateAfiliacion.getTiregimen().trim())) || (in271RegafiUpdateAfiliacion.getTiregimen() == null)) {
/* 190 */             error = "2101";
/* 191 */             break; }
/* 192 */           if (("".equals(in271RegafiUpdateAfiliacion.getEsAfiliacion().trim())) || (in271RegafiUpdateAfiliacion.getEsAfiliacion() == null)) {
/* 193 */             error = "2041";
/* 194 */             break;
/*     */           }
/*     */           
/*     */ 
/* 198 */           if (("".equals(in271RegafiUpdateAfiliacion.getTiPlanSalud().trim())) || (in271RegafiUpdateAfiliacion.getTiPlanSalud() == null)) {
/* 199 */             error = "2131";
/* 200 */             break; }
/* 201 */           if (("".equals(in271RegafiUpdateAfiliacion.getNoProductoSalud().trim())) || (in271RegafiUpdateAfiliacion.getNoProductoSalud() == null)) {
/* 202 */             error = "2141";
/* 203 */             break; }
/* 204 */           if (("".equals(in271RegafiUpdateAfiliacion.getCoProducto().trim())) || (in271RegafiUpdateAfiliacion.getCoProducto() == null)) {
/* 205 */             error = "2031";
/* 206 */             break; }
/* 207 */           if (("".equals(in271RegafiUpdateAfiliacion.getParentesco().trim())) || (in271RegafiUpdateAfiliacion.getParentesco() == null)) {
/* 208 */             error = "2051";
/* 209 */             break;
/*     */           }
/*     */           
/*     */ 
/* 213 */           if (("".equals(in271RegafiUpdateAfiliacion.getPkAfiliado().trim())) || (in271RegafiUpdateAfiliacion.getPkAfiliado() == null)) {
/* 214 */             error = "1001";
/* 215 */             break;
/*     */           }
/*     */           
/*     */ 
/* 219 */           if (("".equals(in271RegafiUpdateAfiliacion.getFeIniAfiliacion().trim())) || (in271RegafiUpdateAfiliacion.getFeIniAfiliacion() == null)) {
/* 220 */             error = "2151";
/* 221 */             break;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 231 */           if (("".equals(in271RegafiUpdateAfiliacion.getFeActOperacion().trim())) || (in271RegafiUpdateAfiliacion.getFeActOperacion() == null)) {
/* 232 */             error = "2311";
/* 233 */             break; }
/* 234 */           if (("".equals(in271RegafiUpdateAfiliacion.getTiActOperacion().trim())) || (in271RegafiUpdateAfiliacion.getTiActOperacion() == null)) {
/* 235 */             error = "2321";
/* 236 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 244 */     if (error.equals("0000")) {
/* 245 */       if ((in271RegafiUpdate.getNoTransaccion().trim().length() < 1) || (in271RegafiUpdate.getNoTransaccion().trim().length() > 60))
/*     */       {
/* 247 */         error = "0012";
/* 248 */       } else if ((in271RegafiUpdate.getIdRemitente().trim().length() < 1) || (in271RegafiUpdate.getIdRemitente().trim().length() > 15))
/*     */       {
/* 250 */         error = "0022";
/* 251 */       } else if ((in271RegafiUpdate.getIdReceptor().trim().length() < 1) || (in271RegafiUpdate.getIdReceptor().trim().length() > 15))
/*     */       {
/* 253 */         error = "0032";
/* 254 */       } else if (in271RegafiUpdate.getFeTransaccion().trim().length() != 8) {
/* 255 */         error = "0042";
/* 256 */       } else if ((in271RegafiUpdate.getHoTransaccion().trim().length() < 4) || (in271RegafiUpdate.getHoTransaccion().trim().length() > 8))
/*     */       {
/* 258 */         error = "0052";
/* 259 */       } else if (in271RegafiUpdate.getIdCorrelativo().trim().length() != 9) {
/* 260 */         error = "0062";
/* 261 */       } else if (in271RegafiUpdate.getIdTransaccion().trim().length() != 3) {
/* 262 */         error = "0072";
/* 263 */       } else if (in271RegafiUpdate.getTiFinalidad().trim().length() != 2) {
/* 264 */         error = "0082";
/* 265 */       } else if (in271RegafiUpdate.getCaRemitente().trim().length() != 1) {
/* 266 */         error = "0092";
/* 267 */       } else if ((in271RegafiUpdate.getTiOperacion().trim().length() < 1) || (in271RegafiUpdate.getTiOperacion().trim().length() > 2))
/*     */       {
/* 269 */         error = "0102";
/*     */ 
/*     */       }
/* 272 */       else if ((in271RegafiUpdate.getDetallesAfiliados().size() >= 0) && (error.equals("0000"))) {
/* 273 */         listPer = in271RegafiUpdate.getDetallesAfiliados();
/* 274 */         In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();
/*     */         
/* 276 */         for (int i = 0; i < listPer.size(); i++) {
/* 277 */           in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/*     */           
/* 279 */           int NoAfiliado = 0;
/* 280 */           int nafi1; if (in271RegafiUpdateAfiliado.getNoAfiliado1().trim().length() > 0) nafi1 = in271RegafiUpdateAfiliado.getNoAfiliado1().length(); else nafi1 = 0;
/* 281 */           int nafi2; if (in271RegafiUpdateAfiliado.getNoAfiliado2().trim().length() > 0) nafi2 = in271RegafiUpdateAfiliado.getNoAfiliado2().length(); else { nafi2 = 0;
/*     */           }
/* 283 */           NoAfiliado = nafi1 + nafi2;
/*     */           
/* 285 */           if ((in271RegafiUpdateAfiliado.getApPaternoAfiliado().trim().length() != 0) && (in271RegafiUpdateAfiliado.getApPaternoAfiliado().length() > 50)) {
/* 286 */             error = "1052";
/* 287 */             break; }
/* 288 */           //if ((in271RegafiUpdateAfiliado.getNoAfiliado1().length() < 1) || (in271RegafiUpdateAfiliado.getNoAfiliado1().length() > 35))
/*     */           //{
/* 290 */             //error = "1082";
/* 291 */             //break; }
/* 292 */           if (in271RegafiUpdateAfiliado.getNoAfiliado2().length() > 25) {
/* 293 */             error = "1082";
/* 294 */             break; }
/* 295 */           //if ((NoAfiliado < 1) || (NoAfiliado > 60)) {
/* 296 */             //error = "1082";
/* 297 */             //break; }
/* 298 */           if ((in271RegafiUpdateAfiliado.getApMaternoAfiliado().trim().length() != 0) && (in271RegafiUpdateAfiliado.getApMaternoAfiliado().length() > 50)) {
/* 299 */             error = "1062";
/* 300 */             break; }
/* 301 */           if (in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim().length() != 1) {
/* 302 */             error = "1022";
/* 303 */             break; }
/* 304 */           if (((!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (in271RegafiUpdateAfiliado.getNuDocumentoAfil().trim().length() < 1)) || (in271RegafiUpdateAfiliado.getNuDocumentoAfil().trim().length() > 15))
/*     */           {
/* 306 */             error = "1032";
/* 307 */             break; }
/* 308 */           if (in271RegafiUpdateAfiliado.getEstadoAfiliado().trim().length() != 1) {
/* 309 */             error = "1122";
/* 310 */             break; }
/* 311 */           if (in271RegafiUpdateAfiliado.getTiDocumentoAct().trim().length() != 1) {
/* 312 */             error = "1202";
/* 313 */             break; }
/* 314 */           if ((in271RegafiUpdateAfiliado.getNuDocumentoAct().trim().length() < 1) || (in271RegafiUpdateAfiliado.getNuDocumentoAct().trim().length() > 15))
/*     */           {
/* 316 */             error = "1212";
/* 317 */             break; }
/* 318 */           if ((in271RegafiUpdateAfiliado.getApCasadaAfiliado().trim().length() != 0) && (in271RegafiUpdateAfiliado.getApCasadaAfiliado().trim().length() > 50)) {
/* 319 */             error = "1072";
/* 320 */             break; }
/* 321 */           if ((in271RegafiUpdateAfiliado.getCoNacionalidad().trim().length() != 0) && ((in271RegafiUpdateAfiliado.getCoNacionalidad().trim().length() < 2) || (in271RegafiUpdateAfiliado.getCoNacionalidad().trim().length() > 3))) {
/* 322 */             error = "1042";
/* 323 */             break; }
/* 324 */           if ((in271RegafiUpdateAfiliado.getUbigeo().trim().length() != 0) && (in271RegafiUpdateAfiliado.getUbigeo().trim().length() > 12)) {
/* 325 */             error = "1102";
/* 326 */             break; }
/* 327 */           if (in271RegafiUpdateAfiliado.getFeNacimiento().trim().length() != 8) {
/* 328 */             error = "1092";
/* 329 */             break; }
/* 330 */           if (in271RegafiUpdateAfiliado.getGenero().trim().length() != 1) {
/* 331 */             error = "1112";
/* 332 */             break; }
/* 333 */           if (in271RegafiUpdateAfiliado.getCoPaisDoc().trim().length() != 3) {
/* 334 */             error = "1012";
/* 335 */             break; }
/* 336 */           if ((in271RegafiUpdateAfiliado.getFefallecimiento().trim().length() != 0) && (in271RegafiUpdateAfiliado.getFefallecimiento().trim().length() != 8)) {
/* 337 */             error = "1132";
/* 338 */             break; }
/* 339 */           if (in271RegafiUpdateAfiliado.getCoPaisEmisorDocAct().trim().length() != 3) {
/* 340 */             error = "1192";
/* 341 */             break; }
/* 342 */           if (in271RegafiUpdateAfiliado.getFeActPersonaxIafas().trim().length() != 8) {
/* 343 */             error = "1222";
/* 344 */             break; }
/* 345 */           if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (in271RegafiUpdateAfiliado.getTiDocTutor().trim().length() > 1)) {
/* 346 */             error = "1162";
/* 347 */             break; }
/* 348 */           if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (in271RegafiUpdateAfiliado.getNuDocTutor().trim().length() > 15)) {
/* 349 */             error = "1172";
/* 350 */             break; }
/* 351 */           if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (in271RegafiUpdateAfiliado.getTiVinculoTutor().trim().length() > 2)) {
/* 352 */             error = "1182";
/* 353 */             break; }
/* 354 */           if ((in271RegafiUpdateAfiliado.getFeValidacionReniec().trim().length() != 0) && (in271RegafiUpdateAfiliado.getFeValidacionReniec().trim().length() != 8)) {
/* 355 */             error = "1142";
/* 356 */             break; }
/* 357 */           if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (in271RegafiUpdateAfiliado.getCoPaisEmisorDocTutor().trim().length() > 3)) {
/* 358 */             error = "1152";
/* 359 */             break;
/*     */           }
/*     */         }
/*     */       }
/* 363 */       if ((in271RegafiUpdate.getDetallesAfiliaciones().size() >= 0) && (error.equals("0000")))
/*     */       {
/* 365 */         listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/* 366 */         In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/*     */         
/* 368 */         for (int i = 0; i < listAfi.size(); i++) {
/* 369 */           in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/*     */           
/* 371 */           int NoContratante = 0;
/* 372 */           int ncontra1; if (in271RegafiUpdateAfiliacion.getNoContratante1().trim().length() > 0) ncontra1 = in271RegafiUpdateAfiliacion.getNoContratante1().length(); else ncontra1 = 0;
/* 373 */           int ncontra2; if (in271RegafiUpdateAfiliacion.getNoContratante2().trim().length() > 0) ncontra2 = in271RegafiUpdateAfiliacion.getNoContratante2().length(); else ncontra2 = 0;
/* 374 */           int ncontra3; if (in271RegafiUpdateAfiliacion.getNoContratante3().trim().length() > 0) ncontra3 = in271RegafiUpdateAfiliacion.getNoContratante3().length(); else ncontra3 = 0;
/* 375 */           int ncontra4; if (in271RegafiUpdateAfiliacion.getNoContratante4().trim().length() > 0) ncontra4 = in271RegafiUpdateAfiliacion.getNoContratante4().length(); else { ncontra4 = 0;
/*     */           }
/* 377 */           NoContratante = ncontra1 + ncontra2 + ncontra3 + ncontra4;
/*     */           
/* 379 */           if (in271RegafiUpdateAfiliacion.getTiDocTitular().trim().length() != 1) {
/* 380 */             error = "2222";
/* 381 */             break; }
/* 382 */           if ((in271RegafiUpdateAfiliacion.getNuDocTitular().trim().length() < 1) || (in271RegafiUpdateAfiliacion.getNuDocTitular().trim().length() > 15))
/*     */           {
/* 384 */             error = "2232";
/* 385 */             break; }
/* 386 */           if (in271RegafiUpdateAfiliacion.getFeNacimientoTitular().trim().length() != 8) {
/* 387 */             error = "2242";
/* 388 */             break; }
/* 389 */           if (in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular().trim().length() != 3) {
/* 390 */             error = "2212";
/* 391 */             break; }
/* 392 */           if (in271RegafiUpdateAfiliacion.getTiContratante().trim().length() != 1) {
/* 393 */             error = "2252";
/* 394 */             break; }
/* 395 */           if ((in271RegafiUpdateAfiliacion.getApPaternoContratante().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getApPaternoContratante().trim().length() > 50)) {
/* 396 */             error = "2272";
/* 397 */             break; }
/* 398 */           if (in271RegafiUpdateAfiliacion.getNoContratante1().trim().length() > 35) {
/* 399 */             error = "2262";
/* 400 */             break; }
/* 401 */           if (in271RegafiUpdateAfiliacion.getNoContratante2().trim().length() > 25) {
/* 402 */             error = "2262";
/* 403 */             break; }
/* 404 */           if (in271RegafiUpdateAfiliacion.getNoContratante3().trim().length() > 10) {
/* 405 */             error = "2262";
/* 406 */             break; }
/* 407 */           if (in271RegafiUpdateAfiliacion.getNoContratante4().trim().length() > 10) {
/* 408 */             error = "2262";
/* 409 */             break; }
/* 410 */           if (NoContratante > 80) {
/* 411 */             error = "2262";
/* 412 */             break; }
/* 413 */           if ((in271RegafiUpdateAfiliacion.getApMaternoContratante().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getApMaternoContratante().trim().length() > 50)) {
/* 414 */             error = "2282";
/* 415 */             break; }
/* 416 */           if (in271RegafiUpdateAfiliacion.getTiDocContratante().trim().length() != 1) {
/* 417 */             error = "2072";
/* 418 */             break; }
/* 419 */           if ((in271RegafiUpdateAfiliacion.getNuDocContratante().trim().length() < 1) || (in271RegafiUpdateAfiliacion.getNuDocContratante().trim().length() > 15))
/*     */           {
/* 421 */             error = "2082";
/* 422 */             break; }
/* 423 */           if ((in271RegafiUpdateAfiliacion.getApCasadaContratante().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getApCasadaContratante().trim().length() > 50)) {
/* 424 */             error = "2292";
/* 425 */             break; }
/* 426 */           if ((in271RegafiUpdateAfiliacion.getFeNacimientoContratante().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getFeNacimientoContratante().trim().length() != 8)) {
/* 427 */             error = "2302";
/* 428 */             break; }
/* 429 */           if (in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante().trim().length() != 3) {
/* 430 */             error = "2062";
/* 431 */             break; }
/* 432 */           if ((in271RegafiUpdateAfiliacion.getCoAfiliacion().trim().length() < 1) || (in271RegafiUpdateAfiliacion.getCoAfiliacion().trim().length() > 20))
/*     */           {
/* 434 */             error = "2012";
/* 435 */             break; }
/* 436 */           if ((in271RegafiUpdateAfiliacion.getCoContrato().trim().length() < 1) || (in271RegafiUpdateAfiliacion.getCoContrato().trim().length() > 30))
/*     */           {
/* 438 */             error = "2022";
/* 439 */             break; }
/* 440 */           if ((in271RegafiUpdateAfiliacion.getCoUnicoMultisectorial().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getCoUnicoMultisectorial().trim().length() > 20)) {
/* 441 */             error = "2092";
/* 442 */             break; }
/* 443 */           if (in271RegafiUpdateAfiliacion.getTiregimen().trim().length() != 1) {
/* 444 */             error = "2102";
/* 445 */             break; }
/* 446 */           if (in271RegafiUpdateAfiliacion.getEsAfiliacion().trim().length() != 1) {
/* 447 */             error = "2042";
/* 448 */             break; }
/* 449 */           if ((in271RegafiUpdateAfiliacion.getCoCausalBaja().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getCoCausalBaja().trim().length() > 20)) {
/* 450 */             error = "2122";
/* 451 */             break; }
/* 452 */           if (in271RegafiUpdateAfiliacion.getTiPlanSalud().trim().length() != 1) {
/* 453 */             error = "2132";
/* 454 */             break; }
/* 455 */           if ((in271RegafiUpdateAfiliacion.getNoProductoSalud().trim().length() < 1) || (in271RegafiUpdateAfiliacion.getNoProductoSalud().trim().length() > 50))
/*     */           {
/* 457 */             error = "2142";
/* 458 */             break; }
/* 459 */           if ((in271RegafiUpdateAfiliacion.getCoProducto().trim().length() < 1) || (in271RegafiUpdateAfiliacion.getCoProducto().trim().length() > 20))
/*     */           {
/* 461 */             error = "2032";
/* 462 */             break; }
/* 463 */           if ((in271RegafiUpdateAfiliacion.getParentesco().trim().length() < 1) || (in271RegafiUpdateAfiliacion.getParentesco().trim().length() > 2))
/*     */           {
/* 465 */             error = "2052";
/* 466 */             break; }
/* 467 */           if ((in271RegafiUpdateAfiliacion.getCoRenipress().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getCoRenipress().trim().length() > 10)) {
/* 468 */             error = "2202";
/* 469 */             break; }
/* 470 */           if ((in271RegafiUpdateAfiliacion.getPkAfiliado().trim().length() < 12) || (in271RegafiUpdateAfiliacion.getPkAfiliado().trim().length() > 19))
/*     */           {
/* 472 */             error = "1002";
/* 473 */             break; }
/* 474 */           if ((in271RegafiUpdateAfiliacion.getFeActEstado().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getFeActEstado().trim().length() != 8)) {
/* 475 */             error = "2112";
/* 476 */             break; }
/* 477 */           if (in271RegafiUpdateAfiliacion.getFeIniAfiliacion().trim().length() != 8) {
/* 478 */             error = "2152";
/* 479 */             break; }
/* 480 */           if ((in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim().length() != 8)) {
/* 481 */             error = "2162";
/* 482 */             break; }
/* 483 */           if ((in271RegafiUpdateAfiliacion.getFeIniCobertura().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getFeIniCobertura().trim().length() != 8)) {
/* 484 */             error = "2172";
/* 485 */             break; }
/* 486 */           if ((in271RegafiUpdateAfiliacion.getFeFinCobertura().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getFeFinCobertura().trim().length() != 8)) {
/* 487 */             error = "2182";
/* 488 */             break; }
/* 489 */           if (in271RegafiUpdateAfiliacion.getFeActOperacion().trim().length() != 8) {
/* 490 */             error = "2312";
/* 491 */             break; }
/* 492 */           if (in271RegafiUpdateAfiliacion.getTiActOperacion().trim().length() != 6) {
/* 493 */             error = "2322";
/* 494 */             break; }
/* 495 */           if ((in271RegafiUpdateAfiliacion.getCoTiCobertura().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getCoTiCobertura().trim().length() > 1)) {
/* 496 */             error = "2192";
/* 497 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 502 */     if (error.equals("0000")) {
/* 503 */       if (ManagerUtil.validaNombreTx(in271RegafiUpdate.getNoTransaccion()) != '0') {
/* 504 */         error = "0013";
/* 505 */       } else if (ManagerUtil.validaAlfanumerico(in271RegafiUpdate.getIdRemitente()) != '0') {
/* 506 */         error = "0023";
/* 507 */       } else if (ManagerUtil.validaAlfanumerico(in271RegafiUpdate.getIdReceptor()) != '0') {
/* 508 */         error = "0033";
/* 509 */       } else if ((ManagerUtil.validaSoloDigito(in271RegafiUpdate.getFeTransaccion()) != '0') || (in271RegafiUpdate.getFeTransaccion().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdate.getFeTransaccion()) != true))
/*     */       {
/*     */ 
/* 512 */         error = "0043";
/* 513 */       } else if (ManagerUtil.validaSoloDigito(in271RegafiUpdate.getHoTransaccion()) != '0') {
/* 514 */         error = "0053";
/* 515 */       } else if (ManagerUtil.validaSoloDigito(in271RegafiUpdate.getIdCorrelativo()) != '0') {
/* 516 */         error = "0063";
/* 517 */       } else if (ManagerUtil.validaSoloDigito(in271RegafiUpdate.getIdTransaccion()) != '0') {
/* 518 */         error = "0073";
/* 519 */       } else if (ManagerUtil.validaSoloDigito(in271RegafiUpdate.getTiFinalidad()) != '0') {
/* 520 */         error = "0083";
/* 521 */       } else if (ManagerUtil.validaSoloDigito(in271RegafiUpdate.getCaRemitente()) != '0') {
/* 522 */         error = "0093";
/* 523 */       } else if (ManagerUtil.validaAlfanumerico(in271RegafiUpdate.getTiOperacion()) != '0') {
/* 524 */         error = "0103";
/*     */ 
/*     */       }
/* 527 */       else if ((in271RegafiUpdate.getDetallesAfiliados().size() >= 0) && (error.equals("0000"))) {
/* 528 */         listPer = in271RegafiUpdate.getDetallesAfiliados();
/* 529 */         In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();
/*     */         
/* 531 */         for (int i = 0; i < listPer.size(); i++) {
/* 532 */           in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/*     */           
/* 534 */           if (((!"".equals(in271RegafiUpdateAfiliado.getApPaternoAfiliado().trim())) || (in271RegafiUpdateAfiliado.getApPaternoAfiliado() != null)) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliado.getApPaternoAfiliado()) != '0')) {
/* 535 */             error = "1053";
/* 536 */             break; }
/* 537 */           if (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliado.getNoAfiliado1()) != '0') {
/* 538 */             error = "1083";
/* 539 */             break; }
/* 540 */           if ((in271RegafiUpdateAfiliado.getNoAfiliado2().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliado.getNoAfiliado2()) != '0')) {
/* 541 */             error = "1083";
/* 542 */             break; }
/* 543 */           if ((in271RegafiUpdateAfiliado.getApMaternoAfiliado().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliado.getApMaternoAfiliado()) != '0')) {
/* 544 */             error = "1063";
/* 545 */             break; }
/* 546 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getTiDocumentoAfil()) != '0') {
/* 547 */             error = "1023";
/* 548 */             break; }
/* 549 */           if ((!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliado.getNuDocumentoAfil()) != '0')) {
/* 550 */             error = "1033";
/* 551 */             break; }
/* 552 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getEstadoAfiliado()) != '0') {
/* 553 */             error = "1123";
/* 554 */             break; }
/* 555 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getTiDocumentoAct()) != '0') {
/* 556 */             error = "1203";
/* 557 */             break; }
/* 558 */           if (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliado.getNuDocumentoAct()) != '0') {
/* 559 */             error = "1213";
/* 560 */             break; }
/* 561 */           if ((in271RegafiUpdateAfiliado.getApCasadaAfiliado().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliado.getApCasadaAfiliado()) != '0')) {
/* 562 */             error = "1073";
/* 563 */             break; }
/* 564 */           if ((in271RegafiUpdateAfiliado.getCoNacionalidad().trim().length() != 0) && (ManagerUtil.validaCaracterPalabra(in271RegafiUpdateAfiliado.getCoNacionalidad()) != '0')) {
/* 565 */             error = "1043";
/* 566 */             break; }
/* 567 */           if ((in271RegafiUpdateAfiliado.getUbigeo().trim().length() != 0) && (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getUbigeo()) != '0')) {
/* 568 */             error = "1103";
/* 569 */             break; }
/* 570 */           if ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getFeNacimiento()) != '0') || (in271RegafiUpdateAfiliado.getFeNacimiento().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliado.getFeNacimiento()) != true))
/*     */           {
/*     */ 
/* 573 */             error = "1093";
/* 574 */             break; }
/* 575 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getGenero()) != '0') {
/* 576 */             error = "1113";
/* 577 */             break; }
/* 578 */           if (ManagerUtil.validaCaracterPalabra(in271RegafiUpdateAfiliado.getCoPaisDoc()) != '0') {
/* 579 */             error = "1013";
/* 580 */             break; }
/* 581 */           if ((in271RegafiUpdateAfiliado.getFefallecimiento().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getFefallecimiento()) != '0') || (in271RegafiUpdateAfiliado.getFefallecimiento().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliado.getFefallecimiento()) != true)))
/*     */           {
/*     */ 
/* 584 */             error = "1133";
/* 585 */             break; }
/* 586 */           if (ManagerUtil.validaCaracterPalabra(in271RegafiUpdateAfiliado.getCoPaisEmisorDocAct()) != '0') {
/* 587 */             error = "1193";
/* 588 */             break; }
/* 589 */           if ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getFeActPersonaxIafas()) != '0') || (in271RegafiUpdateAfiliado.getFeActPersonaxIafas().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliado.getFeActPersonaxIafas()) != true))
/*     */           {
/*     */ 
/* 592 */             error = "1223";
/* 593 */             break; }
/* 594 */           if ((in271RegafiUpdateAfiliado.getTiDocTutor().trim().length() != 0) && (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getTiDocTutor()) != '0')) {
/* 595 */             error = "1163";
/* 596 */             break; }
/* 597 */           if ((in271RegafiUpdateAfiliado.getNuDocTutor().trim().length() != 0) && (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliado.getNuDocTutor()) != '0')) {
/* 598 */             error = "1173";
/* 599 */             break; }
/* 600 */           if ((in271RegafiUpdateAfiliado.getTiVinculoTutor().trim().length() != 0) && (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getTiVinculoTutor()) != '0')) {
/* 601 */             error = "1183";
/* 602 */             break; }
/* 603 */           if ((in271RegafiUpdateAfiliado.getFeValidacionReniec().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getFeValidacionReniec()) != '0') || (in271RegafiUpdateAfiliado.getFeValidacionReniec().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliado.getFeValidacionReniec()) != true)))
/*     */           {
/*     */ 
/* 606 */             error = "1143";
/* 607 */             break; }
/* 608 */           if ((in271RegafiUpdateAfiliado.getCoPaisEmisorDocTutor().trim().length() != 0) && (ManagerUtil.validaCaracterPalabra(in271RegafiUpdateAfiliado.getCoPaisEmisorDocTutor()) != '0')) {
/* 609 */             error = "1153";
/* 610 */             break;
/*     */           }
/*     */         }
/*     */       }
/* 614 */       if ((in271RegafiUpdate.getDetallesAfiliaciones().size() >= 0) && (error.equals("0000")))
/*     */       {
/* 616 */         listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/* 617 */         In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/*     */         
/* 619 */         for (int i = 0; i < listAfi.size(); i++) {
/* 620 */           in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/*     */           
/* 622 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getTiDocTitular()) != '0') {
/* 623 */             error = "2223";
/* 624 */             break; }
/* 625 */           if (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getNuDocTitular()) != '0') {
/* 626 */             error = "2233";
/* 627 */             break; }
/* 628 */           if ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeNacimientoTitular()) != '0') || (in271RegafiUpdateAfiliacion.getFeNacimientoTitular().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeNacimientoTitular()) != true))
/*     */           {
/*     */ 
/* 631 */             error = "2243";
/* 632 */             break; }
/* 633 */           if (ManagerUtil.validaCaracterPalabra(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular()) != '0') {
/* 634 */             error = "2213";
/* 635 */             break; }
/* 636 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getTiContratante()) != '0') {
/* 637 */             error = "2253";
/* 638 */             break; }
/* 639 */           if ((in271RegafiUpdateAfiliacion.getApPaternoContratante().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getApPaternoContratante()) != '0')) {
/* 640 */             error = "2273";
/* 641 */             break; }
/* 642 */           if ((in271RegafiUpdateAfiliacion.getNoContratante1().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getNoContratante1()) != '0')) {
/* 643 */             error = "2263";
/* 644 */             break; }
/* 645 */           if ((in271RegafiUpdateAfiliacion.getNoContratante2().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getNoContratante2()) != '0')) {
/* 646 */             error = "2263";
/* 647 */             break; }
/* 648 */           if ((in271RegafiUpdateAfiliacion.getNoContratante3().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getNoContratante3()) != '0')) {
/* 649 */             error = "2263";
/* 650 */             break; }
/* 651 */           if ((in271RegafiUpdateAfiliacion.getNoContratante4().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getNoContratante4()) != '0')) {
/* 652 */             error = "2263";
/* 653 */             break; }
/* 654 */           if ((in271RegafiUpdateAfiliacion.getApMaternoContratante().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getApMaternoContratante()) != '0')) {
/* 655 */             error = "2283";
/* 656 */             break; }
/* 657 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getTiDocContratante()) != '0') {
/* 658 */             error = "2073";
/* 659 */             break; }
/* 660 */           if (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getNuDocContratante()) != '0') {
/* 661 */             error = "2083";
/* 662 */             break; }
/* 663 */           if ((in271RegafiUpdateAfiliacion.getApCasadaContratante().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getApCasadaContratante()) != '0')) {
/* 664 */             error = "2293";
/* 665 */             break; }
/* 666 */           if ((in271RegafiUpdateAfiliacion.getFeNacimientoContratante().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeNacimientoContratante()) != '0') || (in271RegafiUpdateAfiliacion.getFeNacimientoContratante().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeNacimientoContratante()) != true)))
/*     */           {
/*     */ 
/* 669 */             error = "2303";
/* 670 */             break; }
/* 671 */           if (ManagerUtil.validaCaracterPalabra(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante()) != '0') {
/* 672 */             error = "2063";
/* 673 */             break; }
/* 674 */           if (ManagerUtil.validaAlfanumericoGuion(in271RegafiUpdateAfiliacion.getCoAfiliacion()) != '0') {
/* 675 */             error = "2013";
/* 676 */             break; }
/* 677 */           if (ManagerUtil.validaAlfanumericoGuion(in271RegafiUpdateAfiliacion.getCoContrato()) != '0') {
/* 678 */             error = "2023";
/* 679 */             break; }
/* 680 */           if ((in271RegafiUpdateAfiliacion.getCoUnicoMultisectorial().trim().length() != 0) && (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getCoUnicoMultisectorial()) != '0')) {
/* 681 */             error = "2093";
/* 682 */             break; }
/* 683 */           if (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getTiregimen()) != '0') {
/* 684 */             error = "2103";
/* 685 */             break; }
/* 686 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getEsAfiliacion()) != '0') {
/* 687 */             error = "2043";
/* 688 */             break; }
/* 689 */           if ((in271RegafiUpdateAfiliacion.getCoCausalBaja().trim().length() != 0) && (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getCoCausalBaja()) != '0')) {
/* 690 */             error = "2123";
/* 691 */             break; }
/* 692 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getTiPlanSalud()) != '0') {
/* 693 */             error = "2133";
/* 694 */             break; }
/* 695 */           if (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getNoProductoSalud()) != '0') {
/* 696 */             error = "2143";
/* 697 */             break; }
/* 698 */           if (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getCoProducto()) != '0') {
/* 699 */             error = "2033";
/* 700 */             break; }
/* 701 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getParentesco()) != '0') {
/* 702 */             error = "2053";
/* 703 */             break; }
/* 704 */           if ((in271RegafiUpdateAfiliacion.getCoRenipress().trim().length() != 0) && (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getCoRenipress()) != '0')) {
/* 705 */             error = "2203";
/* 706 */             break; }
/* 707 */           if (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getPkAfiliado()) != '0') {
/* 708 */             error = "1003";
/* 709 */             break; }
/* 710 */           if ((in271RegafiUpdateAfiliacion.getFeActEstado().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeActEstado()) != '0') || (in271RegafiUpdateAfiliacion.getFeActEstado().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeActEstado()) != true)))
/*     */           {
/*     */ 
/* 713 */             error = "2113";
/* 714 */             break; }
/* 715 */           if ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeIniAfiliacion()) != '0') || (in271RegafiUpdateAfiliacion.getFeIniAfiliacion().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeIniAfiliacion()) != true))
/*     */           {
/*     */ 
/* 718 */             error = "2153";
/* 719 */             break; }
/* 720 */           if ((in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeFinAfiliacion()) != '0') || (in271RegafiUpdateAfiliacion.getFeFinAfiliacion().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeFinAfiliacion()) != true)))
/*     */           {
/*     */ 
/* 723 */             error = "2163";
/* 724 */             break; }
/* 725 */           if ((in271RegafiUpdateAfiliacion.getFeIniCobertura().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeIniCobertura()) != '0') || (in271RegafiUpdateAfiliacion.getFeIniCobertura().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeIniCobertura()) != true)))
/*     */           {
/*     */ 
/* 728 */             error = "2173";
/* 729 */             break; }
/* 730 */           if ((in271RegafiUpdateAfiliacion.getFeFinCobertura().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeFinCobertura()) != '0') || (in271RegafiUpdateAfiliacion.getFeFinCobertura().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeFinCobertura()) != true)))
/*     */           {
/*     */ 
/* 733 */             error = "2183";
/* 734 */             break; }
/* 735 */           if ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeActOperacion()) != '0') || (in271RegafiUpdateAfiliacion.getFeActOperacion().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeActOperacion()) != true))
/*     */           {
/*     */ 
/* 738 */             error = "2313";
/* 739 */             break; }
/* 740 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getTiActOperacion()) != '0') {
/* 741 */             error = "2323";
/* 742 */             break; }
/* 743 */           if ((in271RegafiUpdateAfiliacion.getCoTiCobertura().trim().length() != 0) && (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getCoTiCobertura()) != '0')) {
/* 744 */             error = "2193";
/* 745 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 750 */     if (error.equals("0000"))
/*     */     {
/* 752 */       if (in271RegafiUpdate.getDetallesAfiliados().size() >= 0) {
/* 753 */         listPer = in271RegafiUpdate.getDetallesAfiliados();
/* 754 */         In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();
/*     */         
/* 756 */         for (int i = 0; i < listPer.size(); i++) {
/* 757 */           in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/*     */           
/* 759 */           if ("PER".equals(in271RegafiUpdateAfiliado.getCoPaisDoc().trim())) {
/* 760 */             if ((!"1".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"2".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"5".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"6".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"8".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())))
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 766 */               error = "1024";
/* 767 */               break;
/*     */             }
/* 769 */           } else if ((!"PER".equals(in271RegafiUpdateAfiliado.getCoPaisDoc().trim())) && 
/* 770 */             (!"3".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"4".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())))
/*     */           {
/*     */ 
/* 773 */             error = "1024";
/* 774 */             break;
/*     */           }
/* 776 */           if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && ("PER".equals(in271RegafiUpdateAfiliado.getCoPaisEmisorDocTutor().trim()))) {
/* 777 */             if ((!"1".equals(in271RegafiUpdateAfiliado.getTiDocTutor().trim())) && (!"2".equals(in271RegafiUpdateAfiliado.getTiDocTutor().trim())))
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 783 */               error = "1164";
/* 784 */               break;
/*     */             }
/* 786 */           } else if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"PER".equals(in271RegafiUpdateAfiliado.getCoPaisEmisorDocTutor().trim())) && 
/* 787 */             (!"3".equals(in271RegafiUpdateAfiliado.getTiDocTutor().trim())) && (!"4".equals(in271RegafiUpdateAfiliado.getTiDocTutor().trim())))
/*     */           {
/* 789 */             error = "1164";
/* 790 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 795 */       if ((in271RegafiUpdate.getDetallesAfiliaciones().size() >= 0) && (error.equals("0000")))
/*     */       {
/* 797 */         listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/* 798 */         In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/*     */         
/* 800 */         for (int i = 0; i < listAfi.size(); i++) {
/* 801 */           in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/*     */           
///* 803 */           if ("PER".equals(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular().trim())) {
///* 804 */             if ((!"1".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"2".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"5".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"6".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"7".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"8".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())))
///*     */             {
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///* 810 */               error = "2224";
///* 811 */               break;
///*     */             }
///* 813 */           } else if ((!"PER".equals(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular().trim())) && 
///*  827 */                 (!"2".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"3".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"4".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"7".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())))
///*      */               {
///*      */                  System.out.println("Aqui4444");
///*  830 */                 error = "2224";
///*  831 */                 break;
///*      */               }
/* 820 */           if ("PER".equals(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante().trim())) {
/* 821 */             if ((!"1".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())) && (!"2".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())) && (!"8".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())) && (!"9".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())))
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 827 */               error = "2074";
/* 828 */               break;
/*     */             }
/* 830 */           } else if (!"PER".equals(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante().trim()))
/*     */           {
/*     */ 
/*     */ 
/* 834 */             error = "2074";
/* 835 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 842 */     if ((in271RegafiUpdate.getDetallesAfiliados().size() >= 0) && (error.equals("0000"))) {
/* 843 */       listPer = in271RegafiUpdate.getDetallesAfiliados();
/* 844 */       In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();
/*     */       
/* 846 */       for (int i = 0; i < listPer.size(); i++) {
/* 847 */         in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/*     */         
/* 849 */         if ((!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && ("1".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim()))) {
/* 850 */           if (in271RegafiUpdateAfiliado.getNuDocumentoAfil().trim().length() != 8) {
/* 851 */             error = "1035";
/* 852 */             break;
/*     */           }
/* 854 */         } else if ((!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && ("8".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && 
/* 855 */           (in271RegafiUpdateAfiliado.getNuDocumentoAfil().trim().length() != 11)) {
/* 856 */           error = "1035";
/* 857 */           break;
/*     */         }
/*     */         
/*     */ 
/* 861 */         if ((!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAct().trim())) && ("1".equals(in271RegafiUpdateAfiliado.getTiDocumentoAct().trim()))) {
/* 862 */           if (in271RegafiUpdateAfiliado.getNuDocumentoAct().trim().length() != 8) {
/* 863 */             error = "1215";
/* 864 */             break;
/*     */           }
/* 866 */         } else if ((!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAct().trim())) && ("8".equals(in271RegafiUpdateAfiliado.getTiDocumentoAct().trim())) && 
/* 867 */           (in271RegafiUpdateAfiliado.getNuDocumentoAct().trim().length() != 11)) {
/* 868 */           error = "1215";
/* 869 */           break;
/*     */         }
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
/*     */ 
/*     */ 
/* 885 */         if ((!"0".equals(in271RegafiUpdateAfiliado.getIdAfiliadoNombre().trim())) && (!"1".equals(in271RegafiUpdateAfiliado.getIdAfiliadoNombre().trim()))) {
/* 886 */           error = "00039";
/* 887 */           break;
/*     */         }
/*     */       }
/*     */     }
/* 891 */     if ((in271RegafiUpdate.getDetallesAfiliaciones().size() >= 0) && (error.equals("0000")))
/*     */     {
/* 893 */       listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/* 894 */       In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/*     */       
/* 896 */       for (int i = 0; i < listAfi.size(); i++) {
/* 897 */         in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/*     */         
/* 899 */         if ("1".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) {
/* 900 */           if (in271RegafiUpdateAfiliacion.getNuDocTitular().trim().length() != 8) {
/* 901 */             error = "2235";
/* 902 */             break;
/*     */           }
/* 904 */         } else if (("8".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && 
/* 905 */           (in271RegafiUpdateAfiliacion.getNuDocTitular().trim().length() != 11)) {
/* 906 */           error = "2235";
/* 907 */           break;
/*     */         }
/* 909 */         if ("1".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())) {
/* 910 */           if (in271RegafiUpdateAfiliacion.getNuDocContratante().trim().length() != 8) {
/* 911 */             error = "2085";
/* 912 */             break;
/*     */           }
/* 914 */         } else if (("8".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())) && 
/* 915 */           (in271RegafiUpdateAfiliacion.getNuDocContratante().trim().length() != 11)) {
/* 916 */           error = "2085";
/* 917 */           break;
/*     */         }
/*     */         
/* 920 */         if ((!"000".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"001".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"011".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"010".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"101".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"111".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"100".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"110".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 931 */           error = "00040";
/* 932 */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 938 */     if ((in271RegafiUpdate.getDetallesAfiliados().size() >= 0) && (error.equals("0000"))) {
/* 939 */       listPer = in271RegafiUpdate.getDetallesAfiliados();
/* 940 */       In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();
/* 941 */       String feReniec = "";String feActualiza = "";String sError = "00";
/*     */       
/* 943 */       for (int i = 0; i < listPer.size(); i++) {
/* 944 */         in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/* 945 */         if ((in271RegafiUpdateAfiliado.getFeValidacionReniec().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliado.getFeValidacionReniec().trim())))
/*     */         {
/* 947 */           feReniec = in271RegafiUpdateAfiliado.getFeValidacionReniec();
/*     */         }
/*     */         else {
/* 950 */           sError = "01";
/*     */         }
/*     */       }
/* 953 */       listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/* 954 */       In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/* 955 */       for (int i = 0; i < listAfi.size(); i++) {
/* 956 */         in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/* 957 */         if ((in271RegafiUpdateAfiliacion.getFeActOperacion().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliacion.getFeActOperacion().trim())))
/*     */         {
/* 959 */           feActualiza = in271RegafiUpdateAfiliacion.getFeActOperacion();
/*     */         } else {
/* 961 */           sError = "02";
/*     */         }
/*     */         
/* 964 */         if ((in271RegafiUpdateAfiliacion.getFeIniAfiliacion().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliacion.getFeIniAfiliacion().trim())) && (in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim())))
/*     */         {
/*     */ 
/*     */ 
/* 968 */           if (Integer.parseInt(in271RegafiUpdateAfiliacion.getFeIniAfiliacion().trim()) > Integer.parseInt(in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim())) {
/* 969 */             error = "80028";
/*     */           }
/*     */         }
/*     */         
/* 973 */         if ((in271RegafiUpdateAfiliacion.getFeIniCobertura().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliacion.getFeIniCobertura().trim())) && (in271RegafiUpdateAfiliacion.getFeFinCobertura().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliacion.getFeFinCobertura().trim())))
/*     */         {
/*     */ 
/*     */ 
/* 977 */           if (Integer.parseInt(in271RegafiUpdateAfiliacion.getFeIniCobertura().trim()) > Integer.parseInt(in271RegafiUpdateAfiliacion.getFeFinCobertura().trim())) {
/* 978 */             error = "90028";
/*     */           }
/*     */         }
/*     */       }
/* 982 */       if ((sError.equals("00")) && 
/* 983 */         (Integer.parseInt(feReniec) > Integer.parseInt(feActualiza))) {
/* 984 */         error = "70043";
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 989 */     in271RegafiUpdate.setCoError(error);
/* 990 */     return in271RegafiUpdate;
/*     */   }
/*     */ }


/* Location:              D:\WorkSpace\Desarrollo Afiliacion On Linea\Fuentes\FebanAfiliacionesFH\lib\jr-afiliacion-susalud_v1.5.jar!\pe\gob\susalud\jr\transaccion\susalud\validator\RegafiUpdate271_10Validador.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */