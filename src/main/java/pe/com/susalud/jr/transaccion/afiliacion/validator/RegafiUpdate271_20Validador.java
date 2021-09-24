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
/*     */ public class RegafiUpdate271_20Validador
/*     */ {
/*     */   public In271RegafiUpdate ValidateBeanInRegafiUpdate271(In271RegafiUpdate in271RegafiUpdate)
/*     */   {
/*  18 */     List<In271RegafiUpdateAfiliado> listPer = new ArrayList();
/*  19 */     List<In271RegafiUpdateAfiliacion> listAfi = new ArrayList();
/*  20 */     String buscarPorDNI = "OK";
/*  21 */     Boolean flagApPaciente = Boolean.valueOf(false);
/*  22 */     String error = "0000";
/*  23 */     String tiOperacion = in271RegafiUpdate.getTiOperacion();
/*     */     
/*     */ 
/*  26 */     if (("".equals(in271RegafiUpdate.getNoTransaccion())) || (in271RegafiUpdate.getNoTransaccion() == null)) {
/*  27 */       error = "0011";
/*  28 */     } else if (("".equals(in271RegafiUpdate.getIdRemitente())) || (in271RegafiUpdate.getIdRemitente() == null)) {
/*  29 */       error = "0021";
/*  30 */     } else if (("".equals(in271RegafiUpdate.getIdReceptor())) || (in271RegafiUpdate.getIdReceptor() == null)) {
/*  31 */       error = "0031";
/*  32 */     } else if (("".equals(in271RegafiUpdate.getFeTransaccion())) || (in271RegafiUpdate.getFeTransaccion() == null)) {
/*  33 */       error = "0041";
/*  34 */     } else if (("".equals(in271RegafiUpdate.getHoTransaccion())) || (in271RegafiUpdate.getHoTransaccion() == null)) {
/*  35 */       error = "0051";
/*  36 */     } else if (("".equals(in271RegafiUpdate.getIdCorrelativo())) || (in271RegafiUpdate.getIdCorrelativo() == null)) {
/*  37 */       error = "0061";
/*  38 */     } else if (("".equals(in271RegafiUpdate.getIdTransaccion())) || (in271RegafiUpdate.getIdTransaccion() == null)) {
/*  39 */       error = "0071";
/*  40 */     } else if (("".equals(in271RegafiUpdate.getTiFinalidad())) || (in271RegafiUpdate.getTiFinalidad() == null)) {
/*  41 */       error = "0081";
/*  42 */     } else if (("".equals(in271RegafiUpdate.getCaRemitente())) || (in271RegafiUpdate.getCaRemitente() == null)) {
/*  43 */       error = "0091";
/*     */     }
/*  45 */     else if ((in271RegafiUpdate.getDetallesAfiliados().size() >= 0) && (error.equals("0000")))
/*     */     {
/*  47 */       listPer = in271RegafiUpdate.getDetallesAfiliados();
/*  48 */       In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();
/*     */       
/*  50 */       if (listPer.size() == 0) {
/*  51 */         error = "1021";
/*     */       } else {
/*  53 */         for (int i = 0; i < listPer.size(); i++) {
/*  54 */           in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/*     */           
/*  56 */           if ((("".equals(in271RegafiUpdateAfiliado.getApMaternoAfiliado().trim())) || (in271RegafiUpdateAfiliado.getApMaternoAfiliado() == null)) && (("".equals(in271RegafiUpdateAfiliado.getApCasadaAfiliado().trim())) || (in271RegafiUpdateAfiliado.getApCasadaAfiliado() == null)) && (("".equals(in271RegafiUpdateAfiliado.getApPaternoAfiliado().trim())) || (in271RegafiUpdateAfiliado.getApPaternoAfiliado() == null)))
/*     */           {
/*     */ 
/*  59 */             error = "1056";
/*  60 */             break;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  67 */           if (("".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) || (in271RegafiUpdateAfiliado.getTiDocumentoAfil() == null)) {
/*  68 */             error = "1021";
/*  69 */             break; }
/*  70 */           if (((!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && ("".equals(in271RegafiUpdateAfiliado.getNuDocumentoAfil().trim()))) || (in271RegafiUpdateAfiliado.getNuDocumentoAfil() == null)) {
/*  71 */             error = "1031";
/*  72 */             break; }
/*  73 */           if (("".equals(in271RegafiUpdateAfiliado.getEstadoAfiliado().trim())) || (in271RegafiUpdateAfiliado.getEstadoAfiliado() == null)) {
/*  74 */             error = "1121";
/*  75 */             break;
/*     */           }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  97 */           if (("".equals(in271RegafiUpdateAfiliado.getCoPaisDoc().trim())) || (in271RegafiUpdateAfiliado.getCoPaisDoc() == null)) {
/*  98 */             error = "1011";
/*  99 */             break;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 106 */           if (("".equals(in271RegafiUpdateAfiliado.getFeActPersonaxIafas().trim())) || (in271RegafiUpdateAfiliado.getFeActPersonaxIafas() == null)) {
/* 107 */             error = "1221";
/* 108 */             break;
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
/* 128 */     if ((in271RegafiUpdate.getIn271RegafiUpdateAfiliacion().size() >= 0) && (error.equals("0000")))
/*     */     {
/* 130 */       listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/* 131 */       In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/*     */       
/* 133 */       if (listAfi.size() == 0) {
/* 134 */         error = "2221";
/*     */       } else {
/* 136 */         for (int i = 0; i < listAfi.size(); i++) {
/* 137 */           in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/*     */           
/* 139 */           if (("".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) || (in271RegafiUpdateAfiliacion.getTiDocTitular() == null)) {
/* 140 */             error = "2221";
/* 141 */             break; }
/* 142 */           if (("".equals(in271RegafiUpdateAfiliacion.getNuDocTitular().trim())) || (in271RegafiUpdateAfiliacion.getNuDocTitular() == null)) {
/* 143 */             error = "2231";
/* 144 */             break; }
/* 145 */           if (("".equals(in271RegafiUpdateAfiliacion.getFeNacimientoTitular().trim())) || (in271RegafiUpdateAfiliacion.getFeNacimientoTitular() == null)) {
/* 146 */             error = "2241";
/* 147 */             break; }
/* 148 */           if (("".equals(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular().trim())) || (in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular() == null)) {
/* 149 */             error = "2211";
/* 150 */             break; }
/* 151 */           if (("".equals(in271RegafiUpdateAfiliacion.getTiContratante().trim())) || (in271RegafiUpdateAfiliacion.getTiContratante() == null)) {
/* 152 */             error = "2251";
/* 153 */             break;
/*     */           }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 190 */           if (("".equals(in271RegafiUpdateAfiliacion.getEsAfiliacion().trim())) || (in271RegafiUpdateAfiliacion.getEsAfiliacion() == null)) {
/* 191 */             error = "2041";
/* 192 */             break; }
/* 193 */           if (("".equals(in271RegafiUpdateAfiliacion.getCoCausalBaja().trim())) || (in271RegafiUpdateAfiliacion.getCoCausalBaja() == null)) {
/* 194 */             error = "2121";
/* 195 */             break;
/*     */           }
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
/* 211 */           if (("".equals(in271RegafiUpdateAfiliacion.getPkAfiliado().trim())) || (in271RegafiUpdateAfiliacion.getPkAfiliado() == null)) {
/* 212 */             error = "1001";
/* 213 */             break; }
/* 214 */           if (("".equals(in271RegafiUpdateAfiliacion.getFeActEstado().trim())) || (in271RegafiUpdateAfiliacion.getFeActEstado() == null)) {
/* 215 */             error = "2111";
/* 216 */             break; }
/* 217 */           if (("".equals(in271RegafiUpdateAfiliacion.getFeIniAfiliacion().trim())) || (in271RegafiUpdateAfiliacion.getFeIniAfiliacion() == null)) {
/* 218 */             error = "2151";
/* 219 */             break; }
/* 220 */           if (("".equals(in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim())) || (in271RegafiUpdateAfiliacion.getFeFinAfiliacion() == null)) {
/* 221 */             error = "2161";
/* 222 */             break;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 229 */           if (("".equals(in271RegafiUpdateAfiliacion.getFeActOperacion().trim())) || (in271RegafiUpdateAfiliacion.getFeActOperacion() == null)) {
/* 230 */             error = "2311";
/* 231 */             break; }
/* 232 */           if (("".equals(in271RegafiUpdateAfiliacion.getTiActOperacion().trim())) || (in271RegafiUpdateAfiliacion.getTiActOperacion() == null)) {
/* 233 */             error = "2321";
/* 234 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 242 */     if (error.equals("0000")) {
/* 243 */       if ((in271RegafiUpdate.getNoTransaccion().trim().length() < 1) || (in271RegafiUpdate.getNoTransaccion().trim().length() > 60))
/*     */       {
/* 245 */         error = "0012";
/* 246 */       } else if ((in271RegafiUpdate.getIdRemitente().trim().length() < 1) || (in271RegafiUpdate.getIdRemitente().trim().length() > 15))
/*     */       {
/* 248 */         error = "0022";
/* 249 */       } else if ((in271RegafiUpdate.getIdReceptor().trim().length() < 1) || (in271RegafiUpdate.getIdReceptor().trim().length() > 15))
/*     */       {
/* 251 */         error = "0032";
/* 252 */       } else if (in271RegafiUpdate.getFeTransaccion().trim().length() != 8) {
/* 253 */         error = "0042";
/* 254 */       } else if ((in271RegafiUpdate.getHoTransaccion().trim().length() < 4) || (in271RegafiUpdate.getHoTransaccion().trim().length() > 8))
/*     */       {
/* 256 */         error = "0052";
/* 257 */       } else if (in271RegafiUpdate.getIdCorrelativo().trim().length() != 9) {
/* 258 */         error = "0062";
/* 259 */       } else if (in271RegafiUpdate.getIdTransaccion().trim().length() != 3) {
/* 260 */         error = "0072";
/* 261 */       } else if (in271RegafiUpdate.getTiFinalidad().trim().length() != 2) {
/* 262 */         error = "0082";
/* 263 */       } else if (in271RegafiUpdate.getCaRemitente().trim().length() != 1) {
/* 264 */         error = "0092";
/* 265 */       } else if ((in271RegafiUpdate.getTiOperacion().trim().length() < 1) || (in271RegafiUpdate.getTiOperacion().trim().length() > 2))
/*     */       {
/* 267 */         error = "0102";
/*     */ 
/*     */       }
/* 270 */       else if ((in271RegafiUpdate.getDetallesAfiliados().size() >= 0) && (error.equals("0000"))) {
/* 271 */         listPer = in271RegafiUpdate.getDetallesAfiliados();
/* 272 */         In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();
/*     */         
/* 274 */         for (int i = 0; i < listPer.size(); i++) {
/* 275 */           in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/*     */           
/* 277 */           int NoAfiliado = 0;
/* 278 */           int nafi1; if (in271RegafiUpdateAfiliado.getNoAfiliado1().trim().length() > 0) nafi1 = in271RegafiUpdateAfiliado.getNoAfiliado1().length(); else nafi1 = 0;
/* 279 */           int nafi2; if (in271RegafiUpdateAfiliado.getNoAfiliado2().trim().length() > 0) nafi2 = in271RegafiUpdateAfiliado.getNoAfiliado2().length(); else { nafi2 = 0;
/*     */           }
/* 281 */           NoAfiliado = nafi1 + nafi2;
/*     */           
/* 283 */           if ((in271RegafiUpdateAfiliado.getApPaternoAfiliado().trim().length() != 0) && (in271RegafiUpdateAfiliado.getApPaternoAfiliado().length() > 50)) {
/* 284 */             error = "1052";
/* 285 */             break; }
/* 286 */           //if (in271RegafiUpdateAfiliado.getNoAfiliado1().length() > 35) {
/* 287 */             //error = "1082";
/* 288 */             //break; }
/* 289 */           //if (in271RegafiUpdateAfiliado.getNoAfiliado2().length() > 25) {
/* 290 */             //error = "1082";
/* 291 */             //break; }
/* 292 */           //if (NoAfiliado > 60) {
/* 293 */             //error = "1082";
/* 294 */             //break; }
/* 295 */           if ((in271RegafiUpdateAfiliado.getApMaternoAfiliado().trim().length() != 0) && (in271RegafiUpdateAfiliado.getApMaternoAfiliado().length() > 50)) {
/* 296 */             error = "1062";
/* 297 */             break; }
/* 298 */           if (in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim().length() != 1) {
/* 299 */             error = "1022";
/* 300 */             break; }
/* 301 */           if (((!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (in271RegafiUpdateAfiliado.getNuDocumentoAfil().trim().length() < 1)) || (in271RegafiUpdateAfiliado.getNuDocumentoAfil().trim().length() > 15))
/*     */           {
/* 303 */             error = "1032";
/* 304 */             break; }
/* 305 */           if ((in271RegafiUpdateAfiliado.getEstadoAfiliado().trim().length() != 0) && (in271RegafiUpdateAfiliado.getEstadoAfiliado().trim().length() > 1)) {
/* 306 */             error = "1122";
/* 307 */             break; }
/* 308 */           if ((in271RegafiUpdateAfiliado.getTiDocumentoAct().trim().length() != 0) && (in271RegafiUpdateAfiliado.getTiDocumentoAct().trim().length() > 1)) {
/* 309 */             error = "1202";
/* 310 */             break; }
/* 311 */           if ((in271RegafiUpdateAfiliado.getNuDocumentoAct().trim().length() != 0) && (in271RegafiUpdateAfiliado.getNuDocumentoAct().trim().length() > 15)) {
/* 312 */             error = "1212";
/* 313 */             break; }
/* 314 */           if ((in271RegafiUpdateAfiliado.getApCasadaAfiliado().trim().length() != 0) && (in271RegafiUpdateAfiliado.getApCasadaAfiliado().trim().length() > 50)) {
/* 315 */             error = "1072";
/* 316 */             break; }
/* 317 */           if ((in271RegafiUpdateAfiliado.getCoNacionalidad().trim().length() != 0) && ((in271RegafiUpdateAfiliado.getCoNacionalidad().trim().length() < 2) || (in271RegafiUpdateAfiliado.getCoNacionalidad().trim().length() > 3))) {
/* 318 */             error = "1042";
/* 319 */             break; }
/* 320 */           if ((in271RegafiUpdateAfiliado.getUbigeo().trim().length() != 0) && (in271RegafiUpdateAfiliado.getUbigeo().trim().length() > 12)) {
/* 321 */             error = "1102";
/* 322 */             break; }
/* 323 */           if ((in271RegafiUpdateAfiliado.getFeNacimiento().trim().length() != 0) && (in271RegafiUpdateAfiliado.getFeNacimiento().trim().length() != 8)) {
/* 324 */             error = "1092";
/* 325 */             break; }
/* 326 */           if ((in271RegafiUpdateAfiliado.getGenero().trim().length() != 0) && (in271RegafiUpdateAfiliado.getGenero().trim().length() > 1)) {
/* 327 */             error = "1112";
/* 328 */             break; }
/* 329 */           if (in271RegafiUpdateAfiliado.getCoPaisDoc().trim().length() != 3) {
/* 330 */             error = "1012";
/* 331 */             break; }
/* 332 */           if ((in271RegafiUpdateAfiliado.getFefallecimiento().trim().length() != 0) && (in271RegafiUpdateAfiliado.getFefallecimiento().trim().length() != 8)) {
/* 333 */             error = "1132";
/* 334 */             break; }
/* 335 */           if ((in271RegafiUpdateAfiliado.getCoPaisEmisorDocAct().trim().length() != 0) && (in271RegafiUpdateAfiliado.getCoPaisEmisorDocAct().trim().length() > 3)) {
/* 336 */             error = "1192";
/* 337 */             break; }
/* 338 */           if (in271RegafiUpdateAfiliado.getFeActPersonaxIafas().trim().length() != 8) {
/* 339 */             error = "1222";
/* 340 */             break; }
/* 341 */           if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (in271RegafiUpdateAfiliado.getTiDocTutor().trim().length() > 1)) {
/* 342 */             error = "1162";
/* 343 */             break; }
/* 344 */           if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (in271RegafiUpdateAfiliado.getNuDocTutor().trim().length() > 15)) {
/* 345 */             error = "1172";
/* 346 */             break; }
/* 347 */           if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (in271RegafiUpdateAfiliado.getTiVinculoTutor().trim().length() > 2)) {
/* 348 */             error = "1182";
/* 349 */             break; }
/* 350 */           if ((in271RegafiUpdateAfiliado.getFeValidacionReniec().trim().length() != 0) && (in271RegafiUpdateAfiliado.getFeValidacionReniec().trim().length() != 8)) {
/* 351 */             error = "1142";
/* 352 */             break; }
/* 353 */           if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (in271RegafiUpdateAfiliado.getCoPaisEmisorDocTutor().trim().length() > 3)) {
/* 354 */             error = "1152";
/* 355 */             break;
/*     */           }
/*     */         }
/*     */       }
/* 359 */       if ((in271RegafiUpdate.getDetallesAfiliaciones().size() >= 0) && (error.equals("0000")))
/*     */       {
/* 361 */         listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/* 362 */         In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/*     */         
/* 364 */         for (int i = 0; i < listAfi.size(); i++) {
/* 365 */           in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/*     */           
/* 367 */           int NoContratante = 0;
/* 368 */           int ncontra1; if (in271RegafiUpdateAfiliacion.getNoContratante1().trim().length() > 0) ncontra1 = in271RegafiUpdateAfiliacion.getNoContratante1().length(); else ncontra1 = 0;
/* 369 */           int ncontra2; if (in271RegafiUpdateAfiliacion.getNoContratante2().trim().length() > 0) ncontra2 = in271RegafiUpdateAfiliacion.getNoContratante2().length(); else ncontra2 = 0;
/* 370 */           int ncontra3; if (in271RegafiUpdateAfiliacion.getNoContratante3().trim().length() > 0) ncontra3 = in271RegafiUpdateAfiliacion.getNoContratante3().length(); else ncontra3 = 0;
/* 371 */           int ncontra4; if (in271RegafiUpdateAfiliacion.getNoContratante4().trim().length() > 0) ncontra4 = in271RegafiUpdateAfiliacion.getNoContratante4().length(); else { ncontra4 = 0;
/*     */           }
/* 373 */           NoContratante = ncontra1 + ncontra2 + ncontra3 + ncontra4;
/*     */           
/* 375 */           if (in271RegafiUpdateAfiliacion.getTiDocTitular().trim().length() != 1) {
/* 376 */             error = "2222";
/* 377 */             break; }
/* 378 */           if ((in271RegafiUpdateAfiliacion.getNuDocTitular().trim().length() < 1) || (in271RegafiUpdateAfiliacion.getNuDocTitular().trim().length() > 15))
/*     */           {
/* 380 */             error = "2232";
/* 381 */             break; }
/* 382 */           if (in271RegafiUpdateAfiliacion.getFeNacimientoTitular().trim().length() != 8) {
/* 383 */             error = "2242";
/* 384 */             break; }
/* 385 */           if (in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular().trim().length() != 3) {
/* 386 */             error = "2212";
/* 387 */             break; }
/* 388 */           if (in271RegafiUpdateAfiliacion.getTiContratante().trim().length() != 1) {
/* 389 */             error = "2252";
/* 390 */             break; }
/* 391 */           if ((in271RegafiUpdateAfiliacion.getApPaternoContratante().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getApPaternoContratante().trim().length() > 50)) {
/* 392 */             error = "2272";
/* 393 */             break; }
/* 394 */           if (in271RegafiUpdateAfiliacion.getNoContratante1().trim().length() > 35) {
/* 395 */             error = "2262";
/* 396 */             break; }
/* 397 */           if (in271RegafiUpdateAfiliacion.getNoContratante2().trim().length() > 25) {
/* 398 */             error = "2262";
/* 399 */             break; }
/* 400 */           if (in271RegafiUpdateAfiliacion.getNoContratante3().trim().length() > 10) {
/* 401 */             error = "2262";
/* 402 */             break; }
/* 403 */           if (in271RegafiUpdateAfiliacion.getNoContratante4().trim().length() > 10) {
/* 404 */             error = "2262";
/* 405 */             break; }
/* 406 */           if (NoContratante > 80) {
/* 407 */             error = "2262";
/* 408 */             break; }
/* 409 */           if ((in271RegafiUpdateAfiliacion.getApMaternoContratante().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getApMaternoContratante().trim().length() > 50)) {
/* 410 */             error = "2282";
/* 411 */             break; }
/* 412 */           if ((in271RegafiUpdateAfiliacion.getTiDocContratante().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getTiDocContratante().trim().length() > 1)) {
/* 413 */             error = "2072";
/* 414 */             break; }
/* 415 */           if ((in271RegafiUpdateAfiliacion.getNuDocContratante().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getNuDocContratante().trim().length() > 15)) {
/* 416 */             error = "2082";
/* 417 */             break; }
/* 418 */           if ((in271RegafiUpdateAfiliacion.getApCasadaContratante().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getApCasadaContratante().trim().length() > 50)) {
/* 419 */             error = "2292";
/* 420 */             break; }
/* 421 */           if ((in271RegafiUpdateAfiliacion.getFeNacimientoContratante().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getFeNacimientoContratante().trim().length() != 8)) {
/* 422 */             error = "2302";
/* 423 */             break; }
/* 424 */           if ((in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante().trim().length() > 3)) {
/* 425 */             error = "2062";
/* 426 */             break; }
/* 427 */           if ((in271RegafiUpdateAfiliacion.getCoAfiliacion().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getCoAfiliacion().trim().length() > 20)) {
/* 428 */             error = "2012";
/* 429 */             break; }
/* 430 */           if ((in271RegafiUpdateAfiliacion.getCoContrato().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getCoContrato().trim().length() > 30)) {
/* 431 */             error = "2022";
/* 432 */             break; }
/* 433 */           if ((in271RegafiUpdateAfiliacion.getCoUnicoMultisectorial().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getCoUnicoMultisectorial().trim().length() > 20)) {
/* 434 */             error = "2092";
/* 435 */             break; }
/* 436 */           if ((in271RegafiUpdateAfiliacion.getTiregimen().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getTiregimen().trim().length() > 1)) {
/* 437 */             error = "2102";
/* 438 */             break; }
/* 439 */           if ((in271RegafiUpdateAfiliacion.getEsAfiliacion().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getEsAfiliacion().trim().length() > 1)) {
/* 440 */             error = "2042";
/* 441 */             break; }
/* 442 */           if ((in271RegafiUpdateAfiliacion.getCoCausalBaja().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getCoCausalBaja().trim().length() > 20)) {
/* 443 */             error = "2122";
/* 444 */             break; }
/* 445 */           if ((in271RegafiUpdateAfiliacion.getTiPlanSalud().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getTiPlanSalud().trim().length() > 1)) {
/* 446 */             error = "2132";
/* 447 */             break; }
/* 448 */           if ((in271RegafiUpdateAfiliacion.getNoProductoSalud().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getNoProductoSalud().trim().length() > 50)) {
/* 449 */             error = "2142";
/* 450 */             break; }
/* 451 */           if ((in271RegafiUpdateAfiliacion.getCoProducto().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getCoProducto().trim().length() > 20)) {
/* 452 */             error = "2032";
/* 453 */             break; }
/* 454 */           if ((in271RegafiUpdateAfiliacion.getParentesco().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getParentesco().trim().length() > 2)) {
/* 455 */             error = "2052";
/* 456 */             break; }
/* 457 */           if ((in271RegafiUpdateAfiliacion.getCoRenipress().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getCoRenipress().trim().length() > 10)) {
/* 458 */             error = "2202";
/* 459 */             break; }
/* 460 */           if ((in271RegafiUpdateAfiliacion.getPkAfiliado().trim().length() < 12) || (in271RegafiUpdateAfiliacion.getPkAfiliado().trim().length() > 19))
/*     */           {
/* 462 */             error = "1002";
/* 463 */             break; }
/* 464 */           if (in271RegafiUpdateAfiliacion.getFeActEstado().trim().length() != 8) {
/* 465 */             error = "2112";
/* 466 */             break; }
/* 467 */           if (in271RegafiUpdateAfiliacion.getFeIniAfiliacion().trim().length() != 8) {
/* 468 */             error = "2152";
/* 469 */             break; }
/* 470 */           if (in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim().length() != 8) {
/* 471 */             error = "2162";
/* 472 */             break; }
/* 473 */           if ((in271RegafiUpdateAfiliacion.getFeIniCobertura().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getFeIniCobertura().trim().length() != 8)) {
/* 474 */             error = "2172";
/* 475 */             break; }
/* 476 */           if ((in271RegafiUpdateAfiliacion.getFeFinCobertura().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getFeFinCobertura().trim().length() != 8)) {
/* 477 */             error = "2182";
/* 478 */             break; }
/* 479 */           if (in271RegafiUpdateAfiliacion.getFeActOperacion().trim().length() != 8) {
/* 480 */             error = "2312";
/* 481 */             break; }
/* 482 */           if (in271RegafiUpdateAfiliacion.getTiActOperacion().trim().length() != 6) {
/* 483 */             error = "2322";
/* 484 */             break; }
/* 485 */           if ((in271RegafiUpdateAfiliacion.getCoTiCobertura().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getCoTiCobertura().trim().length() > 1)) {
/* 486 */             error = "2192";
/* 487 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 492 */     if (error.equals("0000")) {
/* 493 */       if (ManagerUtil.validaNombreTx(in271RegafiUpdate.getNoTransaccion()) != '0') {
/* 494 */         error = "0013";
/* 495 */       } else if (ManagerUtil.validaAlfanumerico(in271RegafiUpdate.getIdRemitente()) != '0') {
/* 496 */         error = "0023";
/* 497 */       } else if (ManagerUtil.validaAlfanumerico(in271RegafiUpdate.getIdReceptor()) != '0') {
/* 498 */         error = "0033";
/* 499 */       } else if ((ManagerUtil.validaSoloDigito(in271RegafiUpdate.getFeTransaccion()) != '0') || (in271RegafiUpdate.getFeTransaccion().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdate.getFeTransaccion()) != true))
/*     */       {
/*     */ 
/* 502 */         error = "0043";
/* 503 */       } else if (ManagerUtil.validaSoloDigito(in271RegafiUpdate.getHoTransaccion()) != '0') {
/* 504 */         error = "0053";
/* 505 */       } else if (ManagerUtil.validaSoloDigito(in271RegafiUpdate.getIdCorrelativo()) != '0') {
/* 506 */         error = "0063";
/* 507 */       } else if (ManagerUtil.validaSoloDigito(in271RegafiUpdate.getIdTransaccion()) != '0') {
/* 508 */         error = "0073";
/* 509 */       } else if (ManagerUtil.validaSoloDigito(in271RegafiUpdate.getTiFinalidad()) != '0') {
/* 510 */         error = "0083";
/* 511 */       } else if (ManagerUtil.validaSoloDigito(in271RegafiUpdate.getCaRemitente()) != '0') {
/* 512 */         error = "0093";
/* 513 */       } else if (ManagerUtil.validaAlfanumerico(in271RegafiUpdate.getTiOperacion()) != '0') {
/* 514 */         error = "0103";
/*     */ 
/*     */       }
/* 517 */       else if ((in271RegafiUpdate.getDetallesAfiliados().size() >= 0) && (error.equals("0000"))) {
/* 518 */         listPer = in271RegafiUpdate.getDetallesAfiliados();
/* 519 */         In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();
/*     */         
/* 521 */         for (int i = 0; i < listPer.size(); i++) {
/* 522 */           in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/*     */           
/* 524 */           if (((!"".equals(in271RegafiUpdateAfiliado.getApPaternoAfiliado().trim())) || (in271RegafiUpdateAfiliado.getApPaternoAfiliado() != null)) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliado.getApPaternoAfiliado()) != '0')) {
/* 525 */             error = "1053";
/* 526 */             break; }
/* 527 */           if ((in271RegafiUpdateAfiliado.getNoAfiliado1().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliado.getNoAfiliado1()) != '0')) {
/* 528 */             error = "1083";
/* 529 */             break; }
/* 530 */           if ((in271RegafiUpdateAfiliado.getNoAfiliado2().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliado.getNoAfiliado2()) != '0')) {
/* 531 */             error = "1083";
/* 532 */             break; }
/* 533 */           if ((in271RegafiUpdateAfiliado.getApMaternoAfiliado().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliado.getApMaternoAfiliado()) != '0')) {
/* 534 */             error = "1063";
/* 535 */             break; }
/* 536 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getTiDocumentoAfil()) != '0') {
/* 537 */             error = "1023";
/* 538 */             break; }
/* 539 */           if ((!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliado.getNuDocumentoAfil()) != '0')) {
/* 540 */             error = "1033";
/* 541 */             break; }
/* 542 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getEstadoAfiliado()) != '0') {
/* 543 */             error = "1123";
/* 544 */             break; }
/* 545 */           if ((in271RegafiUpdateAfiliado.getTiDocumentoAct().trim().length() != 0) && (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getTiDocumentoAct()) != '0')) {
/* 546 */             error = "1203";
/* 547 */             break; }
/* 548 */           if ((in271RegafiUpdateAfiliado.getNuDocumentoAct().trim().length() != 0) && (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliado.getNuDocumentoAct()) != '0')) {
/* 549 */             error = "1213";
/* 550 */             break; }
/* 551 */           if ((in271RegafiUpdateAfiliado.getApCasadaAfiliado().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliado.getApCasadaAfiliado()) != '0')) {
/* 552 */             error = "1073";
/* 553 */             break; }
/* 554 */           if ((in271RegafiUpdateAfiliado.getCoNacionalidad().trim().length() != 0) && (ManagerUtil.validaCaracterPalabra(in271RegafiUpdateAfiliado.getCoNacionalidad()) != '0')) {
/* 555 */             error = "1043";
/* 556 */             break; }
/* 557 */           if ((in271RegafiUpdateAfiliado.getUbigeo().trim().length() != 0) && (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getUbigeo()) != '0')) {
/* 558 */             error = "1103";
/* 559 */             break; }
/* 560 */           if ((in271RegafiUpdateAfiliado.getFeNacimiento().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getFeNacimiento()) != '0') || (in271RegafiUpdateAfiliado.getFeNacimiento().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliado.getFeNacimiento()) != true)))
/*     */           {
/*     */ 
/* 563 */             error = "1093";
/* 564 */             break; }
/* 565 */           if ((in271RegafiUpdateAfiliado.getGenero().trim().length() != 0) && (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getGenero()) != '0')) {
/* 566 */             error = "1113";
/* 567 */             break; }
/* 568 */           if (ManagerUtil.validaCaracterPalabra(in271RegafiUpdateAfiliado.getCoPaisDoc()) != '0') {
/* 569 */             error = "1013";
/* 570 */             break; }
/* 571 */           if ((in271RegafiUpdateAfiliado.getFefallecimiento().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getFefallecimiento()) != '0') || (in271RegafiUpdateAfiliado.getFefallecimiento().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliado.getFefallecimiento()) != true)))
/*     */           {
/*     */ 
/* 574 */             error = "1133";
/* 575 */             break; }
/* 576 */           if ((in271RegafiUpdateAfiliado.getCoPaisEmisorDocAct().trim().length() != 0) && (ManagerUtil.validaCaracterPalabra(in271RegafiUpdateAfiliado.getCoPaisEmisorDocAct()) != '0')) {
/* 577 */             error = "1193";
/* 578 */             break; }
/* 579 */           if ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getFeActPersonaxIafas()) != '0') || (in271RegafiUpdateAfiliado.getFeActPersonaxIafas().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliado.getFeActPersonaxIafas()) != true))
/*     */           {
/*     */ 
/* 582 */             error = "1223";
/* 583 */             break; }
/* 584 */           if ((in271RegafiUpdateAfiliado.getTiDocTutor().trim().length() != 0) && (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getTiDocTutor()) != '0')) {
/* 585 */             error = "1163";
/* 586 */             break; }
/* 587 */           if ((in271RegafiUpdateAfiliado.getNuDocTutor().trim().length() != 0) && (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliado.getNuDocTutor()) != '0')) {
/* 588 */             error = "1173";
/* 589 */             break; }
/* 590 */           if ((in271RegafiUpdateAfiliado.getTiVinculoTutor().trim().length() != 0) && (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getTiVinculoTutor()) != '0')) {
/* 591 */             error = "1183";
/* 592 */             break; }
/* 593 */           if ((in271RegafiUpdateAfiliado.getFeValidacionReniec().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getFeValidacionReniec()) != '0') || (in271RegafiUpdateAfiliado.getFeValidacionReniec().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliado.getFeValidacionReniec()) != true)))
/*     */           {
/*     */ 
/* 596 */             error = "1143";
/* 597 */             break; }
/* 598 */           if ((in271RegafiUpdateAfiliado.getCoPaisEmisorDocTutor().trim().length() != 0) && (ManagerUtil.validaCaracterPalabra(in271RegafiUpdateAfiliado.getCoPaisEmisorDocTutor()) != '0')) {
/* 599 */             error = "1153";
/* 600 */             break;
/*     */           }
/*     */         }
/*     */       }
/* 604 */       if ((in271RegafiUpdate.getDetallesAfiliaciones().size() >= 0) && (error.equals("0000")))
/*     */       {
/* 606 */         listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/* 607 */         In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/*     */         
/* 609 */         for (int i = 0; i < listAfi.size(); i++) {
/* 610 */           in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/*     */           
/* 612 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getTiDocTitular()) != '0') {
/* 613 */             error = "2223";
/* 614 */             break; }
/* 615 */           if (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getNuDocTitular()) != '0') {
/* 616 */             error = "2233";
/* 617 */             break; }
/* 618 */           if ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeNacimientoTitular()) != '0') || (in271RegafiUpdateAfiliacion.getFeNacimientoTitular().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeNacimientoTitular()) != true))
/*     */           {
/*     */ 
/* 621 */             error = "2243";
/* 622 */             break; }
/* 623 */           if (ManagerUtil.validaCaracterPalabra(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular()) != '0') {
/* 624 */             error = "2213";
/* 625 */             break; }
/* 626 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getTiContratante()) != '0') {
/* 627 */             error = "2253";
/* 628 */             break; }
/* 629 */           if ((in271RegafiUpdateAfiliacion.getApPaternoContratante().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getApPaternoContratante()) != '0')) {
/* 630 */             error = "2273";
/* 631 */             break; }
/* 632 */           if ((in271RegafiUpdateAfiliacion.getNoContratante1().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getNoContratante1()) != '0')) {
/* 633 */             error = "2263";
/* 634 */             break; }
/* 635 */           if ((in271RegafiUpdateAfiliacion.getNoContratante2().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getNoContratante2()) != '0')) {
/* 636 */             error = "2263";
/* 637 */             break; }
/* 638 */           if ((in271RegafiUpdateAfiliacion.getNoContratante3().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getNoContratante3()) != '0')) {
/* 639 */             error = "2263";
/* 640 */             break; }
/* 641 */           if ((in271RegafiUpdateAfiliacion.getNoContratante4().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getNoContratante4()) != '0')) {
/* 642 */             error = "2263";
/* 643 */             break; }
/* 644 */           if ((in271RegafiUpdateAfiliacion.getApMaternoContratante().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getApMaternoContratante()) != '0')) {
/* 645 */             error = "2283";
/* 646 */             break; }
/* 647 */           if ((in271RegafiUpdateAfiliacion.getTiDocContratante().trim().length() != 0) && (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getTiDocContratante()) != '0')) {
/* 648 */             error = "2073";
/* 649 */             break; }
/* 650 */           if ((in271RegafiUpdateAfiliacion.getNuDocContratante().trim().length() != 0) && (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getNuDocContratante()) != '0')) {
/* 651 */             error = "2083";
/* 652 */             break; }
/* 653 */           if ((in271RegafiUpdateAfiliacion.getApCasadaContratante().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getApCasadaContratante()) != '0')) {
/* 654 */             error = "2293";
/* 655 */             break; }
/* 656 */           if ((in271RegafiUpdateAfiliacion.getFeNacimientoContratante().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeNacimientoContratante()) != '0') || (in271RegafiUpdateAfiliacion.getFeNacimientoContratante().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeNacimientoContratante()) != true)))
/*     */           {
/*     */ 
/* 659 */             error = "2303";
/* 660 */             break; }
/* 661 */           if ((in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante().trim().length() != 0) && (ManagerUtil.validaCaracterPalabra(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante()) != '0')) {
/* 662 */             error = "2063";
/* 663 */             break; }
/* 664 */           if ((in271RegafiUpdateAfiliacion.getCoAfiliacion().trim().length() != 0) && (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getCoAfiliacion()) != '0')) {
/* 665 */             error = "2013";
/* 666 */             break; }
/* 667 */           if ((in271RegafiUpdateAfiliacion.getCoContrato().trim().length() != 0) && (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getCoContrato()) != '0')) {
/* 668 */             error = "2023";
/* 669 */             break; }
/* 670 */           if ((in271RegafiUpdateAfiliacion.getCoUnicoMultisectorial().trim().length() != 0) && (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getCoUnicoMultisectorial()) != '0')) {
/* 671 */             error = "2093";
/* 672 */             break; }
/* 673 */           if ((in271RegafiUpdateAfiliacion.getTiregimen().trim().length() != 0) && (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getTiregimen()) != '0')) {
/* 674 */             error = "2103";
/* 675 */             break; }
/* 676 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getEsAfiliacion()) != '0') {
/* 677 */             error = "2043";
/* 678 */             break; }
/* 679 */           if (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getCoCausalBaja()) != '0') {
/* 680 */             error = "2123";
/* 681 */             break; }
/* 682 */           if ((in271RegafiUpdateAfiliacion.getTiPlanSalud().trim().length() != 0) && (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getTiPlanSalud()) != '0')) {
/* 683 */             error = "2133";
/* 684 */             break; }
/* 685 */           if ((in271RegafiUpdateAfiliacion.getNoProductoSalud().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getNoProductoSalud()) != '0')) {
/* 686 */             error = "2143";
/* 687 */             break; }
/* 688 */           if ((in271RegafiUpdateAfiliacion.getCoProducto().trim().length() != 0) && (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getCoProducto()) != '0')) {
/* 689 */             error = "2033";
/* 690 */             break; }
/* 691 */           if ((in271RegafiUpdateAfiliacion.getParentesco().trim().length() != 0) && (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getParentesco()) != '0')) {
/* 692 */             error = "2053";
/* 693 */             break; }
/* 694 */           if ((in271RegafiUpdateAfiliacion.getCoRenipress().trim().length() != 0) && (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getCoRenipress()) != '0')) {
/* 695 */             error = "2203";
/* 696 */             break; }
/* 697 */           if (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getPkAfiliado()) != '0') {
/* 698 */             error = "1003";
/* 699 */             break; }
/* 700 */           if ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeActEstado()) != '0') || (in271RegafiUpdateAfiliacion.getFeActEstado().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeActEstado()) != true))
/*     */           {
/*     */ 
/* 703 */             error = "2113";
/* 704 */             break; }
/* 705 */           if ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeIniAfiliacion()) != '0') || (in271RegafiUpdateAfiliacion.getFeIniAfiliacion().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeIniAfiliacion()) != true))
/*     */           {
/*     */ 
/* 708 */             error = "2153";
/* 709 */             break; }
/* 710 */           if ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeFinAfiliacion()) != '0') || (in271RegafiUpdateAfiliacion.getFeFinAfiliacion().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeFinAfiliacion()) != true))
/*     */           {
/*     */ 
/* 713 */             error = "2163";
/* 714 */             break; }
/* 715 */           if ((in271RegafiUpdateAfiliacion.getFeIniCobertura().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeIniCobertura()) != '0') || (in271RegafiUpdateAfiliacion.getFeIniCobertura().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeIniCobertura()) != true)))
/*     */           {
/*     */ 
/* 718 */             error = "2173";
/* 719 */             break; }
/* 720 */           if ((in271RegafiUpdateAfiliacion.getFeFinCobertura().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeFinCobertura()) != '0') || (in271RegafiUpdateAfiliacion.getFeFinCobertura().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeFinCobertura()) != true)))
/*     */           {
/*     */ 
/* 723 */             error = "2183";
/* 724 */             break; }
/* 725 */           if ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeActOperacion()) != '0') || (in271RegafiUpdateAfiliacion.getFeActOperacion().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeActOperacion()) != true))
/*     */           {
/*     */ 
/* 728 */             error = "2313";
/* 729 */             break; }
/* 730 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getTiActOperacion()) != '0') {
/* 731 */             error = "2323";
/* 732 */             break; }
/* 733 */           if ((in271RegafiUpdateAfiliacion.getCoTiCobertura().trim().length() != 0) && (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getCoTiCobertura()) != '0')) {
/* 734 */             error = "2193";
/* 735 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 740 */     if (error.equals("0000"))
/*     */     {
/* 742 */       if (in271RegafiUpdate.getDetallesAfiliados().size() >= 0) {
/* 743 */         listPer = in271RegafiUpdate.getDetallesAfiliados();
/* 744 */         In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();
/*     */         
/* 746 */         for (int i = 0; i < listPer.size(); i++) {
/* 747 */           in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/*     */           
/* 749 */           if ("PER".equals(in271RegafiUpdateAfiliado.getCoPaisDoc().trim())) {
/* 750 */             if ((!"1".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"2".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"5".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"6".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"8".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())))
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 756 */               error = "1024";
/* 757 */               break;
/*     */             }
/* 759 */           } else if ((!"PER".equals(in271RegafiUpdateAfiliado.getCoPaisDoc().trim())) && 
/* 760 */             (!"3".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"4".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())))
/*     */           {
/*     */ 
/* 763 */             error = "1024";
/* 764 */             break;
/*     */           }
/*     */         }
/*     */       }
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
/*     */ 
/* 784 */       if ((in271RegafiUpdate.getDetallesAfiliaciones().size() >= 0) && (error.equals("0000")))
/*     */       {
/* 786 */         listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/* 787 */         In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/*     */         
/* 789 */         for (int i = 0; i < listAfi.size(); i++) {
/* 790 */           in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/*     */           
///* 792 */           if ("PER".equals(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular().trim())) {
///* 793 */             if ((!"1".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"2".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"5".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"6".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"7".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"8".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())))
///*     */             {
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///* 799 */               error = "2224";
///* 800 */               break;
///*     */             }
///* 802 */           } else if ((!"PER".equals(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular().trim())) && 
///*  827 */                 (!"2".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"3".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"4".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"7".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())))
///*      */               {
///*      */                  System.out.println("Aqui888888");
///*  830 */                 error = "2224";
///*  831 */                 break;
///*      */               }
/* 809 */           if ((in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante().trim().length() != 0) && ("PER".equals(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante().trim()))) {
/* 810 */             if ((!"1".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())) && (!"2".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())) && (!"5".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())) && (!"6".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())) && (!"7".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())) && (!"8".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())))
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 816 */               error = "2074";
/* 817 */               break;
/*     */             }
/* 819 */           } else if ((in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante().trim().length() != 0) && (!"PER".equals(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante().trim())) && 
/* 820 */             (!"3".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())) && (!"4".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())))
/*     */           {
/* 822 */             error = "2074";
/* 823 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 830 */     if ((in271RegafiUpdate.getDetallesAfiliados().size() >= 0) && (error.equals("0000"))) {
/* 831 */       listPer = in271RegafiUpdate.getDetallesAfiliados();
/* 832 */       In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();
/*     */       
/* 834 */       for (int i = 0; i < listPer.size(); i++) {
/* 835 */         in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/*     */         
/* 837 */         if ((!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && ("1".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim()))) {
/* 838 */           if (in271RegafiUpdateAfiliado.getNuDocumentoAfil().trim().length() != 8) {
/* 839 */             error = "1035";
/* 840 */             break;
/*     */           }
/* 842 */         } else if ((!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && ("8".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && 
/* 843 */           (in271RegafiUpdateAfiliado.getNuDocumentoAfil().trim().length() != 11)) {
/* 844 */           error = "1035";
/* 845 */           break;
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
/* 859 */         if ((!"0".equals(in271RegafiUpdateAfiliado.getIdAfiliadoNombre().trim())) && (!"1".equals(in271RegafiUpdateAfiliado.getIdAfiliadoNombre().trim()))) {
/* 860 */           error = "00039";
/* 861 */           break;
/*     */         }
/*     */       }
/*     */     }
/* 865 */     if ((in271RegafiUpdate.getDetallesAfiliaciones().size() >= 0) && (error.equals("0000")))
/*     */     {
/* 867 */       listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/* 868 */       In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/*     */       
/* 870 */       for (int i = 0; i < listAfi.size(); i++) {
/* 871 */         in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/*     */         
/* 873 */         if ("1".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) {
/* 874 */           if (in271RegafiUpdateAfiliacion.getNuDocTitular().trim().length() != 8) {
/* 875 */             error = "2235";
/* 876 */             break;
/*     */           }
/* 878 */         } else if (("8".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && 
/* 879 */           (in271RegafiUpdateAfiliacion.getNuDocTitular().trim().length() != 11)) {
/* 880 */           error = "2235";
/* 881 */           break;
/*     */         }
/* 883 */         if ((in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante().trim().length() != 0) && ("1".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim()))) {
/* 884 */           if (in271RegafiUpdateAfiliacion.getNuDocContratante().trim().length() != 8) {
/* 885 */             error = "2085";
/* 886 */             break;
/*     */           }
/* 888 */         } else if ((in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante().trim().length() != 0) && ("8".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())) && 
/* 889 */           (in271RegafiUpdateAfiliacion.getNuDocContratante().trim().length() != 11)) {
/* 890 */           error = "2085";
/* 891 */           break;
/*     */         }
/*     */         
/*     */ 
/* 895 */         if ((!"000".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"001".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"011".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"010".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"101".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"111".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"100".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"110".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())))
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
/* 906 */           error = "00040";
/* 907 */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 913 */     if ((in271RegafiUpdate.getDetallesAfiliados().size() >= 0) && (error.equals("0000"))) {
/* 914 */       listPer = in271RegafiUpdate.getDetallesAfiliados();
/* 915 */       In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();
/* 916 */       String feReniec = "";String feActualiza = "";String sError = "00";
/*     */       
/* 918 */       for (int i = 0; i < listPer.size(); i++) {
/* 919 */         in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/* 920 */         if ((in271RegafiUpdateAfiliado.getFeValidacionReniec().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliado.getFeValidacionReniec().trim())))
/*     */         {
/* 922 */           feReniec = in271RegafiUpdateAfiliado.getFeValidacionReniec();
/*     */         }
/*     */         else {
/* 925 */           sError = "01";
/*     */         }
/*     */       }
/* 928 */       listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/* 929 */       In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/* 930 */       for (int i = 0; i < listAfi.size(); i++) {
/* 931 */         in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/* 932 */         if ((in271RegafiUpdateAfiliacion.getFeActOperacion().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliacion.getFeActOperacion().trim())))
/*     */         {
/* 934 */           feActualiza = in271RegafiUpdateAfiliacion.getFeActOperacion();
/*     */         } else {
/* 936 */           sError = "02";
/*     */         }
/*     */         
/* 939 */         if ((in271RegafiUpdateAfiliacion.getFeIniAfiliacion().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliacion.getFeIniAfiliacion().trim())) && (in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim())))
/*     */         {
/*     */ 
/*     */ 
/* 943 */           if (Integer.parseInt(in271RegafiUpdateAfiliacion.getFeIniAfiliacion().trim()) > Integer.parseInt(in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim())) {
/* 944 */             error = "80028";
/*     */           }
/*     */         }
/*     */         
/* 948 */         if ((in271RegafiUpdateAfiliacion.getFeIniCobertura().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliacion.getFeIniCobertura().trim())) && (in271RegafiUpdateAfiliacion.getFeFinCobertura().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliacion.getFeFinCobertura().trim())))
/*     */         {
/*     */ 
/*     */ 
/* 952 */           //if (Integer.parseInt(in271RegafiUpdateAfiliacion.getFeIniCobertura().trim()) > Integer.parseInt(in271RegafiUpdateAfiliacion.getFeFinCobertura().trim())) {
/* 953 */             //error = "90028";
/*     */           //}
/*     */         }
/*     */       }
/* 957 */       if ((sError.equals("00")) && 
/* 958 */         (Integer.parseInt(feReniec) > Integer.parseInt(feActualiza))) {
/* 959 */         error = "70043";
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 964 */     in271RegafiUpdate.setCoError(error);
/* 965 */     return in271RegafiUpdate;
/*     */   }
/*     */ }


/* Location:              D:\WorkSpace\Desarrollo Afiliacion On Linea\Fuentes\FebanAfiliacionesFH\lib\jr-afiliacion-susalud_v1.5.jar!\pe\gob\susalud\jr\transaccion\susalud\validator\RegafiUpdate271_20Validador.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */