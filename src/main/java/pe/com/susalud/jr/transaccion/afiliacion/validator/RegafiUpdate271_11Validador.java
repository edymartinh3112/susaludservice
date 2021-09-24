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
/*     */ public class RegafiUpdate271_11Validador
/*     */ {
/*     */   public In271RegafiUpdate ValidateBeanInRegafiUpdate271(In271RegafiUpdate in271RegafiUpdate)
/*     */   {
/*  18 */     List<In271RegafiUpdateAfiliado> listPer = new ArrayList();
/*  19 */     List<In271RegafiUpdateAfiliacion> listAfi = new ArrayList();
/*  20 */     String buscarPorDNI = "OK";
/*  21 */     Boolean flagApPaciente = Boolean.valueOf(false);
/*  22 */     String error = "0000";
/*     */     
/*  24 */     String tiOperacion = in271RegafiUpdate.getTiOperacion();
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
/*  51 */         error = "1081";
/*     */       } else {
/*  53 */         for (int i = 0; i < listPer.size(); i++) {
/*  54 */           in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/*     */           
/*  56 */           if ((("".equals(in271RegafiUpdateAfiliado.getApMaternoAfiliado().trim())) || (in271RegafiUpdateAfiliado.getApMaternoAfiliado() == null)) && (("".equals(in271RegafiUpdateAfiliado.getApCasadaAfiliado().trim())) || (in271RegafiUpdateAfiliado.getApCasadaAfiliado() == null)) && (("".equals(in271RegafiUpdateAfiliado.getApPaternoAfiliado().trim())) || (in271RegafiUpdateAfiliado.getApPaternoAfiliado() == null)))
/*     */           {
/*     */ 
/*  59 */             error = "1056";
/*  60 */             break; }
/*  61 */           if (("".equals(in271RegafiUpdateAfiliado.getNoAfiliado1().trim())) || (in271RegafiUpdateAfiliado.getNoAfiliado1() == null)) {
/*  62 */             error = "1081";
/*  63 */             break;
/*     */           }
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
/*  75 */             break; }
/*  76 */           if (("".equals(in271RegafiUpdateAfiliado.getTiDocumentoAct().trim())) || (in271RegafiUpdateAfiliado.getTiDocumentoAct() == null)) {
/*  77 */             error = "1201";
/*  78 */             break; }
/*  79 */           if (("".equals(in271RegafiUpdateAfiliado.getNuDocumentoAct().trim())) || (in271RegafiUpdateAfiliado.getNuDocumentoAct() == null)) {
/*  80 */             error = "1211";
/*  81 */             break;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  91 */           if (("".equals(in271RegafiUpdateAfiliado.getFeNacimiento().trim())) || (in271RegafiUpdateAfiliado.getFeNacimiento() == null)) {
/*  92 */             error = "1091";
/*  93 */             break; }
/*  94 */           if (("".equals(in271RegafiUpdateAfiliado.getGenero().trim())) || (in271RegafiUpdateAfiliado.getGenero() == null)) {
/*  95 */             error = "1111";
/*  96 */             break; }
/*  97 */           if (("".equals(in271RegafiUpdateAfiliado.getCoPaisDoc().trim())) || (in271RegafiUpdateAfiliado.getCoPaisDoc() == null)) {
/*  98 */             error = "1011";
/*  99 */             break;
/*     */           }
/*     */           
/*     */ 
/* 103 */           if (("".equals(in271RegafiUpdateAfiliado.getCoPaisEmisorDocAct().trim())) || (in271RegafiUpdateAfiliado.getCoPaisEmisorDocAct() == null)) {
/* 104 */             error = "1191";
/* 105 */             break; }
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
/* 134 */         error = "1001";
/*     */       } else {
/* 136 */         for (int i = 0; i < listAfi.size(); i++) {
/* 137 */           in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 214 */           if (("".equals(in271RegafiUpdateAfiliacion.getPkAfiliado().trim())) || (in271RegafiUpdateAfiliacion.getPkAfiliado() == null)) {
/* 215 */             error = "1001";
/* 216 */             break;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 245 */     if (error.equals("0000")) {
/* 246 */       if ((in271RegafiUpdate.getNoTransaccion().trim().length() < 1) || (in271RegafiUpdate.getNoTransaccion().trim().length() > 60))
/*     */       {
/* 248 */         error = "0012";
/* 249 */       } else if ((in271RegafiUpdate.getIdRemitente().trim().length() < 1) || (in271RegafiUpdate.getIdRemitente().trim().length() > 15))
/*     */       {
/* 251 */         error = "0022";
/* 252 */       } else if ((in271RegafiUpdate.getIdReceptor().trim().length() < 1) || (in271RegafiUpdate.getIdReceptor().trim().length() > 15))
/*     */       {
/* 254 */         error = "0032";
/* 255 */       } else if (in271RegafiUpdate.getFeTransaccion().trim().length() != 8) {
/* 256 */         error = "0042";
/* 257 */       } else if ((in271RegafiUpdate.getHoTransaccion().trim().length() < 4) || (in271RegafiUpdate.getHoTransaccion().trim().length() > 8))
/*     */       {
/* 259 */         error = "0052";
/* 260 */       } else if (in271RegafiUpdate.getIdCorrelativo().trim().length() != 9) {
/* 261 */         error = "0062";
/* 262 */       } else if (in271RegafiUpdate.getIdTransaccion().trim().length() != 3) {
/* 263 */         error = "0072";
/* 264 */       } else if (in271RegafiUpdate.getTiFinalidad().trim().length() != 2) {
/* 265 */         error = "0082";
/* 266 */       } else if (in271RegafiUpdate.getCaRemitente().trim().length() != 1) {
/* 267 */         error = "0092";
/* 268 */       } else if ((in271RegafiUpdate.getTiOperacion().trim().length() < 1) || (in271RegafiUpdate.getTiOperacion().trim().length() > 2))
/*     */       {
/* 270 */         error = "0102";
/*     */ 
/*     */       }
/* 273 */       else if ((in271RegafiUpdate.getDetallesAfiliados().size() >= 0) && (error.equals("0000"))) {
/* 274 */         listPer = in271RegafiUpdate.getDetallesAfiliados();
/* 275 */         In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();
/*     */         
/* 277 */         for (int i = 0; i < listPer.size(); i++) {
/* 278 */           in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/*     */           
/* 280 */           int NoAfiliado = 0;
/* 281 */           int nafi1; if (in271RegafiUpdateAfiliado.getNoAfiliado1().trim().length() > 0) nafi1 = in271RegafiUpdateAfiliado.getNoAfiliado1().length(); else nafi1 = 0;
/* 282 */           int nafi2; if (in271RegafiUpdateAfiliado.getNoAfiliado2().trim().length() > 0) nafi2 = in271RegafiUpdateAfiliado.getNoAfiliado2().length(); else { nafi2 = 0;
/*     */           }
/* 284 */           NoAfiliado = nafi1 + nafi2;
/*     */           
/* 286 */           if ((in271RegafiUpdateAfiliado.getApPaternoAfiliado().trim().length() != 0) && (in271RegafiUpdateAfiliado.getApPaternoAfiliado().length() > 50)) {
/* 287 */             error = "1052";
/* 288 */             break; }
/* 289 */           //if ((in271RegafiUpdateAfiliado.getNoAfiliado1().length() < 1) || (in271RegafiUpdateAfiliado.getNoAfiliado1().length() > 35))
/*     */           //{
/* 291 */             //error = "1082";
/* 292 */             //break; }
/* 293 */           if (in271RegafiUpdateAfiliado.getNoAfiliado2().length() > 25) {
/* 294 */             error = "1082";
/* 295 */             break; }
/* 296 */           //if ((NoAfiliado < 1) || (NoAfiliado > 60)) {
/* 297 */             //error = "1082";
/* 298 */             //break; }
/* 299 */           if ((in271RegafiUpdateAfiliado.getApMaternoAfiliado().trim().length() != 0) && (in271RegafiUpdateAfiliado.getApMaternoAfiliado().length() > 50)) {
/* 300 */             error = "1062";
/* 301 */             break; }
/* 302 */           if (in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim().length() != 1) {
/* 303 */             error = "1022";
/* 304 */             break; }
/* 305 */           if (((!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (in271RegafiUpdateAfiliado.getNuDocumentoAfil().trim().length() < 1)) || (in271RegafiUpdateAfiliado.getNuDocumentoAfil().trim().length() > 15))
/*     */           {
/* 307 */             error = "1032";
/* 308 */             break; }
/* 309 */           if (in271RegafiUpdateAfiliado.getEstadoAfiliado().trim().length() != 1) {
/* 310 */             error = "1122";
/* 311 */             break; }
/* 312 */           if (in271RegafiUpdateAfiliado.getTiDocumentoAct().trim().length() != 1) {
/* 313 */             error = "1202";
/* 314 */             break; }
/* 315 */           if ((in271RegafiUpdateAfiliado.getNuDocumentoAct().trim().length() < 1) || (in271RegafiUpdateAfiliado.getNuDocumentoAct().trim().length() > 15))
/*     */           {
/* 317 */             error = "1212";
/* 318 */             break; }
/* 319 */           if ((in271RegafiUpdateAfiliado.getApCasadaAfiliado().trim().length() != 0) && (in271RegafiUpdateAfiliado.getApCasadaAfiliado().trim().length() > 50)) {
/* 320 */             error = "1072";
/* 321 */             break; }
/* 322 */           if ((in271RegafiUpdateAfiliado.getCoNacionalidad().trim().length() != 0) && ((in271RegafiUpdateAfiliado.getCoNacionalidad().trim().length() < 2) || (in271RegafiUpdateAfiliado.getCoNacionalidad().trim().length() > 3))) {
/* 323 */             error = "1042";
/* 324 */             break; }
/* 325 */           if ((in271RegafiUpdateAfiliado.getUbigeo().trim().length() != 0) && (in271RegafiUpdateAfiliado.getUbigeo().trim().length() > 12)) {
/* 326 */             error = "1102";
/* 327 */             break; }
/* 328 */           if (in271RegafiUpdateAfiliado.getFeNacimiento().trim().length() != 8) {
/* 329 */             error = "1092";
/* 330 */             break; }
/* 331 */           if (in271RegafiUpdateAfiliado.getGenero().trim().length() != 1) {
/* 332 */             error = "1112";
/* 333 */             break; }
/* 334 */           if (in271RegafiUpdateAfiliado.getCoPaisDoc().trim().length() != 3) {
/* 335 */             error = "1012";
/* 336 */             break; }
/* 337 */           if ((in271RegafiUpdateAfiliado.getFefallecimiento().trim().length() != 0) && (in271RegafiUpdateAfiliado.getFefallecimiento().trim().length() != 8)) {
/* 338 */             error = "1132";
/* 339 */             break; }
/* 340 */           if (in271RegafiUpdateAfiliado.getCoPaisEmisorDocAct().trim().length() != 3) {
/* 341 */             error = "1192";
/* 342 */             break; }
/* 343 */           if (in271RegafiUpdateAfiliado.getFeActPersonaxIafas().trim().length() != 8) {
/* 344 */             error = "1222";
/* 345 */             break; }
/* 346 */           if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (in271RegafiUpdateAfiliado.getTiDocTutor().trim().length() > 1)) {
/* 347 */             error = "1162";
/* 348 */             break; }
/* 349 */           if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (in271RegafiUpdateAfiliado.getNuDocTutor().trim().length() > 15)) {
/* 350 */             error = "1172";
/* 351 */             break; }
/* 352 */           if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (in271RegafiUpdateAfiliado.getTiVinculoTutor().trim().length() > 2)) {
/* 353 */             error = "1182";
/* 354 */             break; }
/* 355 */           if ((in271RegafiUpdateAfiliado.getFeValidacionReniec().trim().length() != 0) && (in271RegafiUpdateAfiliado.getFeValidacionReniec().trim().length() != 8)) {
/* 356 */             error = "1142";
/* 357 */             break; }
/* 358 */           if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (in271RegafiUpdateAfiliado.getCoPaisEmisorDocTutor().trim().length() > 3)) {
/* 359 */             error = "1152";
/* 360 */             break;
/*     */           }
/*     */         }
/*     */       }
/* 364 */       if ((in271RegafiUpdate.getDetallesAfiliaciones().size() >= 0) && (error.equals("0000")))
/*     */       {
/* 366 */         listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/* 367 */         In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/*     */         
/* 369 */         for (int i = 0; i < listAfi.size(); i++) {
/* 370 */           in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/*     */           
/* 372 */           int NoContratante = 0;
/* 373 */           int ncontra1; if (in271RegafiUpdateAfiliacion.getNoContratante1().trim().length() > 0) ncontra1 = in271RegafiUpdateAfiliacion.getNoContratante1().length(); else ncontra1 = 0;
/* 374 */           int ncontra2; if (in271RegafiUpdateAfiliacion.getNoContratante2().trim().length() > 0) ncontra2 = in271RegafiUpdateAfiliacion.getNoContratante2().length(); else ncontra2 = 0;
/* 375 */           int ncontra3; if (in271RegafiUpdateAfiliacion.getNoContratante3().trim().length() > 0) ncontra3 = in271RegafiUpdateAfiliacion.getNoContratante3().length(); else ncontra3 = 0;
/* 376 */           int ncontra4; if (in271RegafiUpdateAfiliacion.getNoContratante4().trim().length() > 0) ncontra4 = in271RegafiUpdateAfiliacion.getNoContratante4().length(); else { ncontra4 = 0;
/*     */           }
/* 378 */           NoContratante = ncontra1 + ncontra2 + ncontra3 + ncontra4;
/*     */           
/* 380 */           if ((in271RegafiUpdateAfiliacion.getTiDocTitular().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getTiDocTitular().trim().length() != 1)) {
/* 381 */             error = "2222";
/* 382 */             break; }
/* 383 */           if (((in271RegafiUpdateAfiliacion.getNuDocTitular().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getNuDocTitular().trim().length() < 1)) || (in271RegafiUpdateAfiliacion.getNuDocTitular().trim().length() > 15))
/*     */           {
/* 385 */             error = "2232";
/* 386 */             break; }
/* 387 */           if ((in271RegafiUpdateAfiliacion.getFeNacimientoTitular().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getFeNacimientoTitular().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getFeNacimientoTitular().trim().length() != 8)) {
/* 388 */             error = "2242";
/* 389 */             break; }
/* 390 */           if ((in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular().trim().length() != 3)) {
/* 391 */             error = "2212";
/* 392 */             break; }
/* 393 */           if ((in271RegafiUpdateAfiliacion.getTiContratante().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getTiContratante().trim().length() > 1)) {
/* 394 */             error = "2252";
/* 395 */             break; }
/* 396 */           if ((in271RegafiUpdateAfiliacion.getApPaternoContratante().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getApPaternoContratante().trim().length() > 50)) {
/* 397 */             error = "2272";
/* 398 */             break; }
/* 399 */           if (NoContratante > 80) {
/* 400 */             error = "2262";
/* 401 */             break; }
/* 402 */           if ((in271RegafiUpdateAfiliacion.getApMaternoContratante().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getApMaternoContratante().trim().length() > 50)) {
/* 403 */             error = "2282";
/* 404 */             break; }
/* 405 */           if ((in271RegafiUpdateAfiliacion.getTiDocContratante().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getTiDocContratante().trim().length() > 1)) {
/* 406 */             error = "2072";
/* 407 */             break; }
/* 408 */           if ((in271RegafiUpdateAfiliacion.getNuDocContratante().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getNuDocContratante().trim().length() > 15)) {
/* 409 */             error = "2082";
/* 410 */             break; }
/* 411 */           if ((in271RegafiUpdateAfiliacion.getApCasadaContratante().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getApCasadaContratante().trim().length() > 50)) {
/* 412 */             error = "2292";
/* 413 */             break; }
/* 414 */           if ((in271RegafiUpdateAfiliacion.getFeNacimientoContratante().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getFeNacimientoContratante().trim().length() != 8)) {
/* 415 */             error = "2302";
/* 416 */             break; }
/* 417 */           if ((in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante().trim().length() > 3)) {
/* 418 */             error = "2062";
/* 419 */             break; }
/* 420 */           if ((in271RegafiUpdateAfiliacion.getCoAfiliacion().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getCoAfiliacion().trim().length() > 20)) {
/* 421 */             error = "2012";
/* 422 */             break; }
/* 423 */           if ((in271RegafiUpdateAfiliacion.getCoContrato().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getCoContrato().trim().length() > 30)) {
/* 424 */             error = "2022";
/* 425 */             break; }
/* 426 */           if ((in271RegafiUpdateAfiliacion.getCoUnicoMultisectorial().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getCoUnicoMultisectorial().trim().length() > 20)) {
/* 427 */             error = "2092";
/* 428 */             break; }
/* 429 */           if ((in271RegafiUpdateAfiliacion.getTiregimen().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getTiregimen().trim().length() > 1)) {
/* 430 */             error = "2102";
/* 431 */             break; }
/* 432 */           if ((in271RegafiUpdateAfiliacion.getEsAfiliacion().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getEsAfiliacion().trim().length() > 1)) {
/* 433 */             error = "2042";
/* 434 */             break; }
/* 435 */           if ((in271RegafiUpdateAfiliacion.getCoCausalBaja().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getCoCausalBaja().trim().length() > 20)) {
/* 436 */             error = "2122";
/* 437 */             break; }
/* 438 */           if ((in271RegafiUpdateAfiliacion.getTiPlanSalud().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getTiPlanSalud().trim().length() > 1)) {
/* 439 */             error = "2132";
/* 440 */             break; }
/* 441 */           if ((in271RegafiUpdateAfiliacion.getNoProductoSalud().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getNoProductoSalud().trim().length() > 50)) {
/* 442 */             error = "2142";
/* 443 */             break; }
/* 444 */           if ((in271RegafiUpdateAfiliacion.getCoProducto().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getCoProducto().trim().length() > 20)) {
/* 445 */             error = "2032";
/* 446 */             break; }
/* 447 */           if ((in271RegafiUpdateAfiliacion.getParentesco().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getParentesco().trim().length() > 2)) {
/* 448 */             error = "2052";
/* 449 */             break; }
/* 450 */           if ((in271RegafiUpdateAfiliacion.getCoRenipress().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getCoRenipress().trim().length() > 10)) {
/* 451 */             error = "2202";
/* 452 */             break; }
/* 453 */           if ((in271RegafiUpdateAfiliacion.getPkAfiliado().trim().length() < 12) || (in271RegafiUpdateAfiliacion.getPkAfiliado().trim().length() > 19))
/*     */           {
/* 455 */             error = "1002";
/* 456 */             break; }
/* 457 */           if ((in271RegafiUpdateAfiliacion.getFeActEstado().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getFeActEstado().trim().length() != 8)) {
/* 458 */             error = "2112";
/* 459 */             break; }
/* 460 */           if ((in271RegafiUpdateAfiliacion.getFeIniAfiliacion().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getFeIniAfiliacion().trim().length() != 8)) {
/* 461 */             error = "2152";
/* 462 */             break; }
/* 463 */           if ((in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim().length() != 8)) {
/* 464 */             error = "2162";
/* 465 */             break; }
/* 466 */           if ((in271RegafiUpdateAfiliacion.getFeIniCobertura().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getFeIniCobertura().trim().length() != 8)) {
/* 467 */             error = "2172";
/* 468 */             break; }
/* 469 */           if ((in271RegafiUpdateAfiliacion.getFeFinCobertura().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getFeFinCobertura().trim().length() != 8)) {
/* 470 */             error = "2182";
/* 471 */             break; }
/* 472 */           if ((in271RegafiUpdateAfiliacion.getFeActOperacion().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getFeActOperacion().trim().length() != 8)) {
/* 473 */             error = "2312";
/* 474 */             break; }
/* 475 */           if ((in271RegafiUpdateAfiliacion.getTiActOperacion().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getTiActOperacion().trim().length() > 6)) {
/* 476 */             error = "2322";
/* 477 */             break; }
/* 478 */           if ((in271RegafiUpdateAfiliacion.getCoTiCobertura().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getCoTiCobertura().trim().length() > 1)) {
/* 479 */             error = "2192";
/* 480 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 485 */     if (error.equals("0000")) {
/* 486 */       if (ManagerUtil.validaNombreTx(in271RegafiUpdate.getNoTransaccion()) != '0') {
/* 487 */         error = "0013";
/* 488 */       } else if (ManagerUtil.validaAlfanumerico(in271RegafiUpdate.getIdRemitente()) != '0') {
/* 489 */         error = "0023";
/* 490 */       } else if (ManagerUtil.validaAlfanumerico(in271RegafiUpdate.getIdReceptor()) != '0') {
/* 491 */         error = "0033";
/* 492 */       } else if ((ManagerUtil.validaSoloDigito(in271RegafiUpdate.getFeTransaccion()) != '0') || (in271RegafiUpdate.getFeTransaccion().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdate.getFeTransaccion()) != true))
/*     */       {
/*     */ 
/* 495 */         error = "0043";
/* 496 */       } else if (ManagerUtil.validaSoloDigito(in271RegafiUpdate.getHoTransaccion()) != '0') {
/* 497 */         error = "0053";
/* 498 */       } else if (ManagerUtil.validaSoloDigito(in271RegafiUpdate.getIdCorrelativo()) != '0') {
/* 499 */         error = "0063";
/* 500 */       } else if (ManagerUtil.validaSoloDigito(in271RegafiUpdate.getIdTransaccion()) != '0') {
/* 501 */         error = "0073";
/* 502 */       } else if (ManagerUtil.validaSoloDigito(in271RegafiUpdate.getTiFinalidad()) != '0') {
/* 503 */         error = "0083";
/* 504 */       } else if (ManagerUtil.validaSoloDigito(in271RegafiUpdate.getCaRemitente()) != '0') {
/* 505 */         error = "0093";
/* 506 */       } else if (ManagerUtil.validaAlfanumerico(in271RegafiUpdate.getTiOperacion()) != '0') {
/* 507 */         error = "0103";
/*     */ 
/*     */       }
/* 510 */       else if ((in271RegafiUpdate.getDetallesAfiliados().size() >= 0) && (error.equals("0000"))) {
/* 511 */         listPer = in271RegafiUpdate.getDetallesAfiliados();
/* 512 */         In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();
/*     */         
/* 514 */         for (int i = 0; i < listPer.size(); i++) {
/* 515 */           in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/*     */           
/* 517 */           if (((!"".equals(in271RegafiUpdateAfiliado.getApPaternoAfiliado().trim())) || (in271RegafiUpdateAfiliado.getApPaternoAfiliado() != null)) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliado.getApPaternoAfiliado()) != '0')) {
/* 518 */             error = "1053";
/* 519 */             break; }
/* 520 */           if (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliado.getNoAfiliado1()) != '0') {
/* 521 */             error = "1083";
/* 522 */             break; }
/* 523 */           if ((in271RegafiUpdateAfiliado.getNoAfiliado2().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliado.getNoAfiliado2()) != '0')) {
/* 524 */             error = "1083";
/* 525 */             break; }
/* 526 */           if ((in271RegafiUpdateAfiliado.getApMaternoAfiliado().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliado.getApMaternoAfiliado()) != '0')) {
/* 527 */             error = "1063";
/* 528 */             break; }
/* 529 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getTiDocumentoAfil()) != '0') {
/* 530 */             error = "1023";
/* 531 */             break; }
/* 532 */           if ((!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliado.getNuDocumentoAfil()) != '0')) {
/* 533 */             error = "1033";
/* 534 */             break; }
/* 535 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getEstadoAfiliado()) != '0') {
/* 536 */             error = "1123";
/* 537 */             break; }
/* 538 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getTiDocumentoAct()) != '0') {
/* 539 */             error = "1203";
/* 540 */             break; }
/* 541 */           if (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliado.getNuDocumentoAct()) != '0') {
/* 542 */             error = "1213";
/* 543 */             break; }
/* 544 */           if ((in271RegafiUpdateAfiliado.getApCasadaAfiliado().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliado.getApCasadaAfiliado()) != '0')) {
/* 545 */             error = "1073";
/* 546 */             break; }
/* 547 */           if ((in271RegafiUpdateAfiliado.getCoNacionalidad().trim().length() != 0) && (ManagerUtil.validaCaracterPalabra(in271RegafiUpdateAfiliado.getCoNacionalidad()) != '0')) {
/* 548 */             error = "1043";
/* 549 */             break; }
/* 550 */           if ((in271RegafiUpdateAfiliado.getUbigeo().trim().length() != 0) && (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getUbigeo()) != '0')) {
/* 551 */             error = "1103";
/* 552 */             break; }
/* 553 */           if ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getFeNacimiento()) != '0') || (in271RegafiUpdateAfiliado.getFeNacimiento().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliado.getFeNacimiento()) != true))
/*     */           {
/*     */ 
/* 556 */             error = "1093";
/* 557 */             break; }
/* 558 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getGenero()) != '0') {
/* 559 */             error = "1113";
/* 560 */             break; }
/* 561 */           if (ManagerUtil.validaCaracterPalabra(in271RegafiUpdateAfiliado.getCoPaisDoc()) != '0') {
/* 562 */             error = "1013";
/* 563 */             break; }
/* 564 */           if ((in271RegafiUpdateAfiliado.getFefallecimiento().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getFefallecimiento()) != '0') || (in271RegafiUpdateAfiliado.getFefallecimiento().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliado.getFefallecimiento()) != true)))
/*     */           {
/*     */ 
/* 567 */             error = "1133";
/* 568 */             break; }
/* 569 */           if (ManagerUtil.validaCaracterPalabra(in271RegafiUpdateAfiliado.getCoPaisEmisorDocAct()) != '0') {
/* 570 */             error = "1193";
/* 571 */             break; }
/* 572 */           if ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getFeActPersonaxIafas()) != '0') || (in271RegafiUpdateAfiliado.getFeActPersonaxIafas().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliado.getFeActPersonaxIafas()) != true))
/*     */           {
/*     */ 
/* 575 */             error = "1223";
/* 576 */             break; }
/* 577 */           if ((in271RegafiUpdateAfiliado.getTiDocTutor().trim().length() != 0) && (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getTiDocTutor()) != '0')) {
/* 578 */             error = "1163";
/* 579 */             break; }
/* 580 */           if ((in271RegafiUpdateAfiliado.getNuDocTutor().trim().length() != 0) && (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliado.getNuDocTutor()) != '0')) {
/* 581 */             error = "1173";
/* 582 */             break; }
/* 583 */           if ((in271RegafiUpdateAfiliado.getTiVinculoTutor().trim().length() != 0) && (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getTiVinculoTutor()) != '0')) {
/* 584 */             error = "1183";
/* 585 */             break; }
/* 586 */           if ((in271RegafiUpdateAfiliado.getFeValidacionReniec().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getFeValidacionReniec()) != '0') || (in271RegafiUpdateAfiliado.getFeValidacionReniec().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliado.getFeValidacionReniec()) != true)))
/*     */           {
/*     */ 
/* 589 */             error = "1143";
/* 590 */             break; }
/* 591 */           if ((in271RegafiUpdateAfiliado.getCoPaisEmisorDocTutor().trim().length() != 0) && (ManagerUtil.validaCaracterPalabra(in271RegafiUpdateAfiliado.getCoPaisEmisorDocTutor()) != '0')) {
/* 592 */             error = "1153";
/* 593 */             break;
/*     */           }
/*     */         }
/*     */       }
/* 597 */       if ((in271RegafiUpdate.getDetallesAfiliaciones().size() >= 0) && (error.equals("0000")))
/*     */       {
/* 599 */         listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/* 600 */         In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/*     */         
/* 602 */         for (int i = 0; i < listAfi.size(); i++) {
/* 603 */           in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/*     */           
/* 605 */           if ((in271RegafiUpdateAfiliacion.getTiDocTitular().trim().length() != 0) && (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getTiDocTitular()) != '0')) {
/* 606 */             error = "2223";
/* 607 */             break; }
/* 608 */           if ((in271RegafiUpdateAfiliacion.getNuDocTitular().trim().length() != 0) && (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getNuDocTitular()) != '0')) {
/* 609 */             error = "2233";
/* 610 */             break; }
/* 611 */           if ((in271RegafiUpdateAfiliacion.getFeNacimientoTitular().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeNacimientoTitular()) != '0') || (in271RegafiUpdateAfiliacion.getFeNacimientoTitular().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeNacimientoTitular()) != true)))
/*     */           {
/*     */ 
/* 614 */             error = "2243";
/* 615 */             break; }
/* 616 */           if ((in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular().trim().length() != 0) && (ManagerUtil.validaCaracterPalabra(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular()) != '0')) {
/* 617 */             error = "2213";
/* 618 */             break;
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
/* 655 */           if ((in271RegafiUpdateAfiliacion.getFeNacimientoContratante().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeNacimientoContratante()) != '0') || (in271RegafiUpdateAfiliacion.getFeNacimientoContratante().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeNacimientoContratante()) != true)))
/*     */           {
/*     */ 
/* 658 */             error = "2303";
/* 659 */             break;
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
/* 684 */           if ((in271RegafiUpdateAfiliacion.getNoProductoSalud().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getNoProductoSalud()) != '0')) {
/* 685 */             error = "2143";
/* 686 */             break;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 696 */           if (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getPkAfiliado()) != '0') {
/* 697 */             error = "1003";
/* 698 */             break; }
/* 699 */           if ((in271RegafiUpdateAfiliacion.getFeActEstado().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeActEstado()) != '0') || (in271RegafiUpdateAfiliacion.getFeActEstado().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeActEstado()) != true)))
/*     */           {
/*     */ 
/* 702 */             error = "2113";
/* 703 */             break; }
/* 704 */           if ((in271RegafiUpdateAfiliacion.getFeIniAfiliacion().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeIniAfiliacion()) != '0') || (in271RegafiUpdateAfiliacion.getFeIniAfiliacion().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeIniAfiliacion()) != true)))
/*     */           {
/*     */ 
/* 707 */             error = "2153";
/* 708 */             break;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 718 */           if ((in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeFinAfiliacion()) != '0') || (in271RegafiUpdateAfiliacion.getFeFinAfiliacion().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeFinAfiliacion()) != true)))
/*     */           {
/*     */ 
/* 721 */             error = "2163";
/* 722 */             break; }
/* 723 */           if ((in271RegafiUpdateAfiliacion.getFeIniCobertura().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeIniCobertura()) != '0') || (in271RegafiUpdateAfiliacion.getFeIniCobertura().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeIniCobertura()) != true)))
/*     */           {
/*     */ 
/* 726 */             error = "2173";
/* 727 */             break; }
/* 728 */           if ((in271RegafiUpdateAfiliacion.getFeFinCobertura().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeFinCobertura()) != '0') || (in271RegafiUpdateAfiliacion.getFeFinCobertura().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeFinCobertura()) != true)))
/*     */           {
/*     */ 
/* 731 */             error = "2183";
/* 732 */             break; }
/* 733 */           if ((in271RegafiUpdateAfiliacion.getFeActOperacion().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeActOperacion()) != '0') || (in271RegafiUpdateAfiliacion.getFeActOperacion().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeActOperacion()) != true)))
/*     */           {
/*     */ 
/* 736 */             error = "2313";
/* 737 */             break;
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
/* 751 */           if ((in271RegafiUpdateAfiliacion.getCoTiCobertura().trim().length() != 0) && (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getCoTiCobertura()) != '0')) {
/* 752 */             error = "2193";
/* 753 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 758 */     if (error.equals("0000"))
/*     */     {
/* 760 */       if (in271RegafiUpdate.getDetallesAfiliados().size() >= 0) {
/* 761 */         listPer = in271RegafiUpdate.getDetallesAfiliados();
/* 762 */         In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();
/*     */         
/* 764 */         for (int i = 0; i < listPer.size(); i++) {
/* 765 */           in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/*     */           
/* 767 */           if ("PER".equals(in271RegafiUpdateAfiliado.getCoPaisDoc().trim())) {
/* 768 */             if ((!"1".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"2".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"5".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"6".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"8".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())))
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 774 */               error = "1024";
/* 775 */               break;
/*     */             }
/* 777 */           } else if ((!"PER".equals(in271RegafiUpdateAfiliado.getCoPaisDoc().trim())) && 
/* 778 */             (!"3".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"4".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())))
/*     */           {
/*     */ 
/* 781 */             error = "1024";
/* 782 */             break;
/*     */           }
/* 784 */           if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && ("PER".equals(in271RegafiUpdateAfiliado.getCoPaisEmisorDocTutor().trim()))) {
/* 785 */             if ((!"1".equals(in271RegafiUpdateAfiliado.getTiDocTutor().trim())) && (!"2".equals(in271RegafiUpdateAfiliado.getTiDocTutor().trim())))
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 791 */               error = "1164";
/* 792 */               break;
/*     */             }
/* 794 */           } else if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"PER".equals(in271RegafiUpdateAfiliado.getCoPaisEmisorDocTutor().trim())) && 
/* 795 */             (!"3".equals(in271RegafiUpdateAfiliado.getTiDocTutor().trim())) && (!"4".equals(in271RegafiUpdateAfiliado.getTiDocTutor().trim())))
/*     */           {
/* 797 */             error = "1164";
/* 798 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 803 */       if ((in271RegafiUpdate.getDetallesAfiliaciones().size() >= 0) && (error.equals("0000")))
/*     */       {
/* 805 */         listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/* 806 */         In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/*     */         
/* 808 */         for (int i = 0; i < listAfi.size(); i++) {
/* 809 */           in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/*     */           
///* 811 */           if ((in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular().trim().length() != 0) && ("PER".equals(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular().trim()))) {
///* 812 */             if ((!"1".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"2".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"8".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"9".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())))
///*     */             {
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///* 819 */               error = "2224";
///* 820 */               break;
///*     */             }
///* 822 */           } else if ((!"PER".equals(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular().trim())) && 
///*  827 */                 (!"2".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"3".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"4".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"7".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())))
///*      */               {
///*      */                  System.out.println("Aqui55555");
///*  830 */                 error = "2224";
///*  831 */                 break;
///*      */               }
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
/*     */ 
/*     */ 
/* 849 */     if ((in271RegafiUpdate.getDetallesAfiliados().size() >= 0) && (error.equals("0000"))) {
/* 850 */       listPer = in271RegafiUpdate.getDetallesAfiliados();
/* 851 */       In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();
/*     */       
/* 853 */       for (int i = 0; i < listPer.size(); i++) {
/* 854 */         in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/*     */         
/* 856 */         if ((!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && ("1".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim()))) {
/* 857 */           if (in271RegafiUpdateAfiliado.getNuDocumentoAfil().trim().length() != 8) {
/* 858 */             error = "1035";
/* 859 */             break;
/*     */           }
/* 861 */         } else if ((!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && ("8".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && 
/* 862 */           (in271RegafiUpdateAfiliado.getNuDocumentoAfil().trim().length() != 11)) {
/* 863 */           error = "1035";
/* 864 */           break;
/*     */         }
/*     */         
/*     */ 
/* 868 */         if ((!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAct().trim())) && ("1".equals(in271RegafiUpdateAfiliado.getTiDocumentoAct().trim()))) {
/* 869 */           if (in271RegafiUpdateAfiliado.getNuDocumentoAct().trim().length() != 8) {
/* 870 */             error = "1215";
/* 871 */             break;
/*     */           }
/* 873 */         } else if ((!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAct().trim())) && ("8".equals(in271RegafiUpdateAfiliado.getTiDocumentoAct().trim())) && 
/* 874 */           (in271RegafiUpdateAfiliado.getNuDocumentoAct().trim().length() != 11)) {
/* 875 */           error = "1215";
/* 876 */           break;
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
/* 892 */         if ((!"0".equals(in271RegafiUpdateAfiliado.getIdAfiliadoNombre().trim())) && (!"1".equals(in271RegafiUpdateAfiliado.getIdAfiliadoNombre().trim()))) {
/* 893 */           error = "00039";
/* 894 */           break;
/*     */         }
/*     */       }
/*     */     }
/* 898 */     if ((in271RegafiUpdate.getDetallesAfiliaciones().size() >= 0) && (error.equals("0000")))
/*     */     {
/* 900 */       listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/* 901 */       In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/*     */       
/* 903 */       for (int i = 0; i < listAfi.size(); i++) {
/* 904 */         in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/*     */         
/* 906 */         if ((in271RegafiUpdateAfiliacion.getTiDocTitular().trim().length() != 0) && ("1".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim()))) {
/* 907 */           if (in271RegafiUpdateAfiliacion.getNuDocTitular().trim().length() != 8) {
/* 908 */             error = "2235";
/* 909 */             break;
/*     */           }
/* 911 */         } else if ((in271RegafiUpdateAfiliacion.getTiDocTitular().trim().length() != 0) && ("8".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && 
/* 912 */           (in271RegafiUpdateAfiliacion.getNuDocTitular().trim().length() != 11)) {
/* 913 */           error = "2235";
/* 914 */           break;
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
/* 928 */         if ((!"000".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"001".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"011".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"010".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"101".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"111".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"100".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"110".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())))
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
/* 939 */           error = "00040";
/* 940 */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 946 */     if ((in271RegafiUpdate.getDetallesAfiliados().size() >= 0) && (error.equals("0000"))) {
/* 947 */       listPer = in271RegafiUpdate.getDetallesAfiliados();
/* 948 */       In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();
/* 949 */       String feReniec = "";String feActualiza = "";String sError = "00";
/*     */       
/* 951 */       for (int i = 0; i < listPer.size(); i++) {
/* 952 */         in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/* 953 */         if ((in271RegafiUpdateAfiliado.getFeValidacionReniec().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliado.getFeValidacionReniec().trim())))
/*     */         {
/* 955 */           feReniec = in271RegafiUpdateAfiliado.getFeValidacionReniec();
/*     */         }
/*     */         else {
/* 958 */           sError = "01";
/*     */         }
/*     */       }
/* 961 */       listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/* 962 */       In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/* 963 */       for (int i = 0; i < listAfi.size(); i++) {
/* 964 */         in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/* 965 */         if ((in271RegafiUpdateAfiliacion.getFeActOperacion().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliacion.getFeActOperacion().trim())))
/*     */         {
/* 967 */           feActualiza = in271RegafiUpdateAfiliacion.getFeActOperacion();
/*     */         } else {
/* 969 */           sError = "02";
/*     */         }
/*     */         
/* 972 */         if ((in271RegafiUpdateAfiliacion.getFeIniAfiliacion().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliacion.getFeIniAfiliacion().trim())) && (in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim())))
/*     */         {
/*     */ 
/*     */ 
/* 976 */           if (Integer.parseInt(in271RegafiUpdateAfiliacion.getFeIniAfiliacion().trim()) > Integer.parseInt(in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim())) {
/* 977 */             error = "80028";
/*     */           }
/*     */         }
/*     */         
/* 981 */         if ((in271RegafiUpdateAfiliacion.getFeIniCobertura().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliacion.getFeIniCobertura().trim())) && (in271RegafiUpdateAfiliacion.getFeFinCobertura().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliacion.getFeFinCobertura().trim())))
/*     */         {
/*     */ 
/*     */ 
/* 985 */           if (Integer.parseInt(in271RegafiUpdateAfiliacion.getFeIniCobertura().trim()) > Integer.parseInt(in271RegafiUpdateAfiliacion.getFeFinCobertura().trim())) {
/* 986 */             error = "90028";
/*     */           }
/*     */         }
/*     */       }
/* 990 */       if ((sError.equals("00")) && 
/* 991 */         (Integer.parseInt(feReniec) > Integer.parseInt(feActualiza))) {
/* 992 */         error = "70043";
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 997 */     in271RegafiUpdate.setCoError(error);
/* 998 */     return in271RegafiUpdate;
/*     */   }
/*     */ }


/* Location:              D:\WorkSpace\Desarrollo Afiliacion On Linea\Fuentes\FebanAfiliacionesFH\lib\jr-afiliacion-susalud_v1.5.jar!\pe\gob\susalud\jr\transaccion\susalud\validator\RegafiUpdate271_11Validador.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */