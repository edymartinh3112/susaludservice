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
/*     */ public class RegafiUpdate271_01Validador
/*     */ {
/*     */   public In271RegafiUpdate ValidateBeanInRegafiUpdate271(In271RegafiUpdate in271RegafiUpdate)
/*     */   {
/*  18 */     List<In271RegafiUpdateAfiliado> listPer = new ArrayList();
/*  19 */     List<In271RegafiUpdateAfiliacion> listAfi = new ArrayList();
/*  20 */     String error = "0000";
/*     */     
/*     */ 
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
/*  50 */         error = "1021";
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
/*     */ 
/*     */ 
/*     */ 
/*  66 */           if (("".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) || (in271RegafiUpdateAfiliado.getTiDocumentoAfil() == null)) {
/*  67 */             error = "1021";
/*  68 */             break; }
/*  69 */           if (((!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && ("".equals(in271RegafiUpdateAfiliado.getNuDocumentoAfil().trim()))) || (in271RegafiUpdateAfiliado.getNuDocumentoAfil() == null)) {
/*  70 */             error = "1031";
/*  71 */             break;
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
/*  96 */           if (("".equals(in271RegafiUpdateAfiliado.getCoPaisDoc().trim())) || (in271RegafiUpdateAfiliado.getCoPaisDoc() == null)) {
/*  97 */             error = "1011";
/*  98 */             break;
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
/* 127 */     if ((in271RegafiUpdate.getIn271RegafiUpdateAfiliacion().size() >= 0) && (error.equals("0000")))
/*     */     {
/* 129 */       listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/* 130 */       In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/*     */       
/* 132 */       if (listAfi.size() == 0) {
/* 133 */         error = "2221";
/*     */       } else {
/* 135 */         for (int i = 0; i < listAfi.size(); i++) {
/* 136 */           in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/*     */           
/* 138 */           if (("".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) || (in271RegafiUpdateAfiliacion.getTiDocTitular() == null)) {
/* 139 */             error = "2221";
/* 140 */             break; }
/* 141 */           if (("".equals(in271RegafiUpdateAfiliacion.getNuDocTitular().trim())) || (in271RegafiUpdateAfiliacion.getNuDocTitular() == null)) {
/* 142 */             error = "2231";
/* 143 */             break; }
/* 144 */           if (("".equals(in271RegafiUpdateAfiliacion.getFeNacimientoTitular().trim())) || (in271RegafiUpdateAfiliacion.getFeNacimientoTitular() == null)) {
/* 145 */             error = "2241";
/* 146 */             break; }
/* 147 */           if (("".equals(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular().trim())) || (in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular() == null)) {
/* 148 */             error = "2211";
/* 149 */             break; }
/* 150 */           if (("".equals(in271RegafiUpdateAfiliacion.getTiContratante().trim())) || (in271RegafiUpdateAfiliacion.getTiContratante() == null)) {
/* 151 */             error = "2251";
/* 152 */             break;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 162 */           if (("".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())) || (in271RegafiUpdateAfiliacion.getTiDocContratante() == null)) {
/* 163 */             error = "2071";
/* 164 */             break; }
/* 165 */           if (("".equals(in271RegafiUpdateAfiliacion.getNuDocContratante().trim())) || (in271RegafiUpdateAfiliacion.getNuDocContratante() == null)) {
/* 166 */             error = "2081";
/* 167 */             break;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 174 */           if (("".equals(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante().trim())) || (in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante() == null)) {
/* 175 */             error = "2061";
/* 176 */             break; }
/* 177 */           if (("".equals(in271RegafiUpdateAfiliacion.getCoAfiliacion().trim())) || (in271RegafiUpdateAfiliacion.getCoAfiliacion() == null)) {
/* 178 */             error = "2011";
/* 179 */             break; }
/* 180 */           if (("".equals(in271RegafiUpdateAfiliacion.getCoContrato().trim())) || (in271RegafiUpdateAfiliacion.getCoContrato() == null)) {
/* 181 */             error = "2021";
/* 182 */             break;
/*     */           }
/*     */           
/*     */ 
/* 186 */           if (("".equals(in271RegafiUpdateAfiliacion.getTiregimen().trim())) || (in271RegafiUpdateAfiliacion.getTiregimen() == null)) {
/* 187 */             error = "2101";
/* 188 */             break; }
/* 189 */           if (("".equals(in271RegafiUpdateAfiliacion.getEsAfiliacion().trim())) || (in271RegafiUpdateAfiliacion.getEsAfiliacion() == null)) {
/* 190 */             error = "2041";
/* 191 */             break;
/*     */           }
/*     */           
/*     */ 
/* 195 */           if (("".equals(in271RegafiUpdateAfiliacion.getTiPlanSalud().trim())) || (in271RegafiUpdateAfiliacion.getTiPlanSalud() == null)) {
/* 196 */             error = "2131";
/* 197 */             break; }
/* 198 */           if (("".equals(in271RegafiUpdateAfiliacion.getNoProductoSalud().trim())) || (in271RegafiUpdateAfiliacion.getNoProductoSalud() == null)) {
/* 199 */             error = "2141";
/* 200 */             break; }
/* 201 */           if (("".equals(in271RegafiUpdateAfiliacion.getCoProducto().trim())) || (in271RegafiUpdateAfiliacion.getCoProducto() == null)) {
/* 202 */             error = "2031";
/* 203 */             break; }
/* 204 */           if (("".equals(in271RegafiUpdateAfiliacion.getParentesco().trim())) || (in271RegafiUpdateAfiliacion.getParentesco() == null)) {
/* 205 */             error = "2051";
/* 206 */             break;
/*     */           }
/*     */           
/*     */ 
/* 210 */           if (("".equals(in271RegafiUpdateAfiliacion.getPkAfiliado().trim())) || (in271RegafiUpdateAfiliacion.getPkAfiliado() == null)) {
/* 211 */             error = "1001";
/* 212 */             break;
/*     */           }
/*     */           
/*     */ 
/* 216 */           if (("".equals(in271RegafiUpdateAfiliacion.getFeIniAfiliacion().trim())) || (in271RegafiUpdateAfiliacion.getFeIniAfiliacion() == null)) {
/* 217 */             error = "2151";
/* 218 */             break;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 228 */           if (("".equals(in271RegafiUpdateAfiliacion.getFeActOperacion().trim())) || (in271RegafiUpdateAfiliacion.getFeActOperacion() == null)) {
/* 229 */             error = "2311";
/* 230 */             break; }
/* 231 */           if (("".equals(in271RegafiUpdateAfiliacion.getTiActOperacion().trim())) || (in271RegafiUpdateAfiliacion.getTiActOperacion() == null)) {
/* 232 */             error = "2321";
/* 233 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 241 */     if (error.equals("0000")) {
/* 242 */       if ((in271RegafiUpdate.getNoTransaccion().trim().length() < 1) || (in271RegafiUpdate.getNoTransaccion().trim().length() > 60))
/*     */       {
/* 244 */         error = "0012";
/* 245 */       } else if ((in271RegafiUpdate.getIdRemitente().trim().length() < 1) || (in271RegafiUpdate.getIdRemitente().trim().length() > 15))
/*     */       {
/* 247 */         error = "0022";
/* 248 */       } else if ((in271RegafiUpdate.getIdReceptor().trim().length() < 1) || (in271RegafiUpdate.getIdReceptor().trim().length() > 15))
/*     */       {
/* 250 */         error = "0032";
/* 251 */       } else if (in271RegafiUpdate.getFeTransaccion().trim().length() != 8) {
/* 252 */         error = "0042";
/* 253 */       } else if ((in271RegafiUpdate.getHoTransaccion().trim().length() < 4) || (in271RegafiUpdate.getHoTransaccion().trim().length() > 8))
/*     */       {
/* 255 */         error = "0052";
/* 256 */       } else if (in271RegafiUpdate.getIdCorrelativo().trim().length() != 9) {
/* 257 */         error = "0062";
/* 258 */       } else if (in271RegafiUpdate.getIdTransaccion().trim().length() != 3) {
/* 259 */         error = "0072";
/* 260 */       } else if (in271RegafiUpdate.getTiFinalidad().trim().length() != 2) {
/* 261 */         error = "0082";
/* 262 */       } else if (in271RegafiUpdate.getCaRemitente().trim().length() != 1) {
/* 263 */         error = "0092";
/* 264 */       } else if ((in271RegafiUpdate.getTiOperacion().trim().length() < 1) || (in271RegafiUpdate.getTiOperacion().trim().length() > 2))
/*     */       {
/* 266 */         error = "0102";
/*     */ 
/*     */       }
/* 269 */       else if ((in271RegafiUpdate.getDetallesAfiliados().size() >= 0) && (error.equals("0000"))) {
/* 270 */         listPer = in271RegafiUpdate.getDetallesAfiliados();
/* 271 */         In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();
/*     */         
/* 273 */         for (int i = 0; i < listPer.size(); i++) {
/* 274 */           in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/*     */           
/* 276 */           int NoAfiliado = 0;
/* 277 */           int nafi1;  if (in271RegafiUpdateAfiliado.getNoAfiliado1().trim().length() > 0) nafi1 = in271RegafiUpdateAfiliado.getNoAfiliado1().length(); else nafi1 = 0;
/* 278 */           int nafi2; if (in271RegafiUpdateAfiliado.getNoAfiliado2().trim().length() > 0) nafi2 = in271RegafiUpdateAfiliado.getNoAfiliado2().length(); else { nafi2 = 0;
/*     */           }
/* 280 */           NoAfiliado = nafi1 + nafi2;
/*     */           
/* 282 */           if ((in271RegafiUpdateAfiliado.getApPaternoAfiliado().trim().length() != 0) && (in271RegafiUpdateAfiliado.getApPaternoAfiliado().length() > 50)) {
/* 283 */             error = "1052";
/* 284 */             break; }
/* 285 */           if (NoAfiliado > 60) {
/* 286 */             error = "1082";
/* 287 */             break; }
/* 288 */           if ((in271RegafiUpdateAfiliado.getApMaternoAfiliado().trim().length() != 0) && (in271RegafiUpdateAfiliado.getApMaternoAfiliado().length() > 50)) {
/* 289 */             error = "1062";
/* 290 */             break; }
/* 291 */           if (in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim().length() != 1) {
/* 292 */             error = "1022";
/* 293 */             break; }
/* 294 */           if (((!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (in271RegafiUpdateAfiliado.getNuDocumentoAfil().trim().length() < 1)) || (in271RegafiUpdateAfiliado.getNuDocumentoAfil().trim().length() > 15))
/*     */           {
/* 296 */             error = "1032";
/* 297 */             break; }
/* 298 */           if ((in271RegafiUpdateAfiliado.getEstadoAfiliado().trim().length() != 0) && (in271RegafiUpdateAfiliado.getEstadoAfiliado().trim().length() > 1)) {
/* 299 */             error = "1122";
/* 300 */             break; }
/* 301 */           if ((in271RegafiUpdateAfiliado.getTiDocumentoAct().trim().length() != 0) && (in271RegafiUpdateAfiliado.getTiDocumentoAct().trim().length() > 1)) {
/* 302 */             error = "1202";
/* 303 */             break; }
/* 304 */           if ((in271RegafiUpdateAfiliado.getNuDocumentoAct().trim().length() != 0) && (in271RegafiUpdateAfiliado.getNuDocumentoAct().trim().length() > 15)) {
/* 305 */             error = "1212";
/* 306 */             break; }
/* 307 */           if ((in271RegafiUpdateAfiliado.getApCasadaAfiliado().trim().length() != 0) && (in271RegafiUpdateAfiliado.getApCasadaAfiliado().trim().length() > 50)) {
/* 308 */             error = "1072";
/* 309 */             break; }
/* 310 */           if ((in271RegafiUpdateAfiliado.getCoNacionalidad().trim().length() != 0) && ((in271RegafiUpdateAfiliado.getCoNacionalidad().trim().length() < 2) || (in271RegafiUpdateAfiliado.getCoNacionalidad().trim().length() > 3))) {
/* 311 */             error = "1042";
/* 312 */             break; }
/* 313 */           if ((in271RegafiUpdateAfiliado.getUbigeo().trim().length() != 0) && (in271RegafiUpdateAfiliado.getUbigeo().trim().length() > 12)) {
/* 314 */             error = "1102";
/* 315 */             break; }
/* 316 */           if ((in271RegafiUpdateAfiliado.getFeNacimiento().trim().length() != 0) && (in271RegafiUpdateAfiliado.getFeNacimiento().trim().length() != 8)) {
/* 317 */             error = "1092";
/* 318 */             break; }
/* 319 */           if ((in271RegafiUpdateAfiliado.getGenero().trim().length() != 0) && (in271RegafiUpdateAfiliado.getGenero().trim().length() > 1)) {
/* 320 */             error = "1112";
/* 321 */             break; }
/* 322 */           if (in271RegafiUpdateAfiliado.getCoPaisDoc().trim().length() != 3) {
/* 323 */             error = "1012";
/* 324 */             break; }
/* 325 */           if ((in271RegafiUpdateAfiliado.getFefallecimiento().trim().length() != 0) && (in271RegafiUpdateAfiliado.getFefallecimiento().trim().length() != 8)) {
/* 326 */             error = "1132";
/* 327 */             break; }
/* 328 */           if ((in271RegafiUpdateAfiliado.getCoPaisEmisorDocAct().trim().length() != 0) && (in271RegafiUpdateAfiliado.getCoPaisEmisorDocAct().trim().length() > 3)) {
/* 329 */             error = "1192";
/* 330 */             break; }
/* 331 */           if ((in271RegafiUpdateAfiliado.getFeActPersonaxIafas().trim().length() != 0) && (in271RegafiUpdateAfiliado.getFeActPersonaxIafas().trim().length() != 8)) {
/* 332 */             error = "1222";
/* 333 */             break; }
/* 334 */           if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (in271RegafiUpdateAfiliado.getTiDocTutor().trim().length() > 1)) {
/* 335 */             error = "1162";
/* 336 */             break; }
/* 337 */           if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (in271RegafiUpdateAfiliado.getNuDocTutor().trim().length() > 15)) {
/* 338 */             error = "1172";
/* 339 */             break; }
/* 340 */           if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (in271RegafiUpdateAfiliado.getTiVinculoTutor().trim().length() > 2)) {
/* 341 */             error = "1182";
/* 342 */             break; }
/* 343 */           if ((in271RegafiUpdateAfiliado.getFeValidacionReniec().trim().length() != 0) && (in271RegafiUpdateAfiliado.getFeValidacionReniec().trim().length() != 8)) {
/* 344 */             error = "1142";
/* 345 */             break; }
/* 346 */           if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (in271RegafiUpdateAfiliado.getCoPaisEmisorDocTutor().trim().length() > 3)) {
/* 347 */             error = "1152";
/* 348 */             break;
/*     */           }
/*     */         }
/*     */       }
/* 352 */       if ((in271RegafiUpdate.getDetallesAfiliaciones().size() >= 0) && (error.equals("0000")))
/*     */       {
/* 354 */         listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/* 355 */         In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/*     */         
/* 357 */         for (int i = 0; i < listAfi.size(); i++) {
/* 358 */           in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/*     */           
/* 360 */           int NoContratante = 0;
/* 361 */           int ncontra1; if (in271RegafiUpdateAfiliacion.getNoContratante1().trim().length() > 0) ncontra1 = in271RegafiUpdateAfiliacion.getNoContratante1().length(); else ncontra1 = 0;
/* 362 */           int ncontra2; if (in271RegafiUpdateAfiliacion.getNoContratante2().trim().length() > 0) ncontra2 = in271RegafiUpdateAfiliacion.getNoContratante2().length(); else ncontra2 = 0;
/* 363 */           int ncontra3; if (in271RegafiUpdateAfiliacion.getNoContratante3().trim().length() > 0) ncontra3 = in271RegafiUpdateAfiliacion.getNoContratante3().length(); else ncontra3 = 0;
/* 364 */           int ncontra4; if (in271RegafiUpdateAfiliacion.getNoContratante4().trim().length() > 0) ncontra4 = in271RegafiUpdateAfiliacion.getNoContratante4().length(); else { ncontra4 = 0;
/*     */           }
/* 366 */           NoContratante = ncontra1 + ncontra2 + ncontra3 + ncontra4;
/*     */           
/*     */ 
/* 369 */           if (in271RegafiUpdateAfiliacion.getTiDocTitular().trim().length() != 1) {
/* 370 */             error = "2222";
/* 371 */             break; }
/* 372 */           if ((in271RegafiUpdateAfiliacion.getNuDocTitular().trim().length() < 1) || (in271RegafiUpdateAfiliacion.getNuDocTitular().trim().length() > 15))
/*     */           {
/* 374 */             error = "2232";
/* 375 */             break; }
/* 376 */           if (in271RegafiUpdateAfiliacion.getFeNacimientoTitular().trim().length() != 8) {
/* 377 */             error = "2242";
/* 378 */             break; }
/* 379 */           if (in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular().trim().length() != 3) {
/* 380 */             error = "2212";
/* 381 */             break; }
/* 382 */           if (in271RegafiUpdateAfiliacion.getTiContratante().trim().length() != 1) {
/* 383 */             error = "2252";
/* 384 */             break; }
/* 385 */           if ((in271RegafiUpdateAfiliacion.getApPaternoContratante().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getApPaternoContratante().trim().length() > 50)) {
/* 386 */             error = "2272";
/* 387 */             break; }
/* 388 */           if (in271RegafiUpdateAfiliacion.getNoContratante1().trim().length() > 35) {
/* 389 */             error = "2262";
/* 390 */             break; }
/* 391 */           if (in271RegafiUpdateAfiliacion.getNoContratante2().trim().length() > 25) {
/* 392 */             error = "2262";
/* 393 */             break; }
/* 394 */           if (in271RegafiUpdateAfiliacion.getNoContratante3().trim().length() > 10) {
/* 395 */             error = "2262";
/* 396 */             break; }
/* 397 */           if (in271RegafiUpdateAfiliacion.getNoContratante4().trim().length() > 10) {
/* 398 */             error = "2262";
/* 399 */             break; }
/* 400 */           if (NoContratante > 80) {
/* 401 */             error = "2262";
/* 402 */             break; }
/* 403 */           if ((in271RegafiUpdateAfiliacion.getApMaternoContratante().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getApMaternoContratante().trim().length() > 50)) {
/* 404 */             error = "2282";
/* 405 */             break; }
/* 406 */           if (in271RegafiUpdateAfiliacion.getTiDocContratante().trim().length() != 1) {
/* 407 */             error = "2072";
/* 408 */             break; }
/* 409 */           if ((in271RegafiUpdateAfiliacion.getNuDocContratante().trim().length() < 1) || (in271RegafiUpdateAfiliacion.getNuDocContratante().trim().length() > 15))
/*     */           {
/* 411 */             error = "2082";
/* 412 */             break; }
/* 413 */           if ((in271RegafiUpdateAfiliacion.getApCasadaContratante().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getApCasadaContratante().trim().length() > 50)) {
/* 414 */             error = "2292";
/* 415 */             break; }
/* 416 */           if ((in271RegafiUpdateAfiliacion.getFeNacimientoContratante().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getFeNacimientoContratante().trim().length() != 8)) {
/* 417 */             error = "2302";
/* 418 */             break; }
/* 419 */           if (in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante().trim().length() != 3) {
/* 420 */             error = "2062";
/* 421 */             break; }
/* 422 */           if ((in271RegafiUpdateAfiliacion.getCoAfiliacion().trim().length() < 1) || (in271RegafiUpdateAfiliacion.getCoAfiliacion().trim().length() > 20))
/*     */           {
/* 424 */             error = "2012";
/* 425 */             break; }
/* 426 */           if ((in271RegafiUpdateAfiliacion.getCoContrato().trim().length() < 1) || (in271RegafiUpdateAfiliacion.getCoContrato().trim().length() > 30))
/*     */           {
/* 428 */             error = "2022";
/* 429 */             break; }
/* 430 */           if ((in271RegafiUpdateAfiliacion.getCoUnicoMultisectorial().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getCoUnicoMultisectorial().trim().length() > 20)) {
/* 431 */             error = "2092";
/* 432 */             break; }
/* 433 */           if (in271RegafiUpdateAfiliacion.getTiregimen().trim().length() != 1) {
/* 434 */             error = "2102";
/* 435 */             break; }
/* 436 */           if (in271RegafiUpdateAfiliacion.getEsAfiliacion().trim().length() != 1) {
/* 437 */             error = "2042";
/* 438 */             break; }
/* 439 */           if ((in271RegafiUpdateAfiliacion.getCoCausalBaja().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getCoCausalBaja().trim().length() > 20)) {
/* 440 */             error = "2122";
/* 441 */             break; }
/* 442 */           if (in271RegafiUpdateAfiliacion.getTiPlanSalud().trim().length() != 1) {
/* 443 */             error = "2132";
/* 444 */             break; }
/* 445 */           if ((in271RegafiUpdateAfiliacion.getNoProductoSalud().trim().length() < 1) || (in271RegafiUpdateAfiliacion.getNoProductoSalud().trim().length() > 50))
/*     */           {
/* 447 */             error = "2142";
/* 448 */             break; }
/* 449 */           if ((in271RegafiUpdateAfiliacion.getCoProducto().trim().length() < 1) || (in271RegafiUpdateAfiliacion.getCoProducto().trim().length() > 20))
/*     */           {
/* 451 */             error = "2032";
/* 452 */             break; }
/* 453 */           if ((in271RegafiUpdateAfiliacion.getParentesco().trim().length() < 1) || (in271RegafiUpdateAfiliacion.getParentesco().trim().length() > 2))
/*     */           {
/* 455 */             error = "2052";
/* 456 */             break; }
/* 457 */           if ((in271RegafiUpdateAfiliacion.getCoRenipress().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getCoRenipress().trim().length() > 10)) {
/* 458 */             error = "2202";
/* 459 */             break; }
/* 460 */           if ((in271RegafiUpdateAfiliacion.getPkAfiliado().trim().length() < 12) || (in271RegafiUpdateAfiliacion.getPkAfiliado().trim().length() > 19))
/*     */           {
/* 462 */             error = "1002";
/* 463 */             break; }
/* 464 */           if ((in271RegafiUpdateAfiliacion.getFeActEstado().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getFeActEstado().trim().length() != 8)) {
/* 465 */             error = "2112";
/* 466 */             break; }
/* 467 */           if (in271RegafiUpdateAfiliacion.getFeIniAfiliacion().trim().length() != 8) {
/* 468 */             error = "2152";
/* 469 */             break; }
/* 470 */           if ((in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim().length() != 8)) {
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
/* 526 */             break;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 533 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getTiDocumentoAfil()) != '0') {
/* 534 */             error = "1023";
/* 535 */             break; }
/* 536 */           if ((!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliado.getNuDocumentoAfil()) != '0')) {
/* 537 */             error = "1033";
/* 538 */             break;
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
/* 557 */           if ((in271RegafiUpdateAfiliado.getFeNacimiento().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getFeNacimiento()) != '0') || (in271RegafiUpdateAfiliado.getFeNacimiento().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliado.getFeNacimiento()) != true)))
/*     */           {
/*     */ 
/* 560 */             error = "1093";
/* 561 */             break;
/*     */           }
/*     */           
/*     */ 
/* 565 */           if (ManagerUtil.validaCaracterPalabra(in271RegafiUpdateAfiliado.getCoPaisDoc()) != '0') {
/* 566 */             error = "1013";
/* 567 */             break; }
/* 568 */           if ((in271RegafiUpdateAfiliado.getFefallecimiento().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getFefallecimiento()) != '0') || (in271RegafiUpdateAfiliado.getFefallecimiento().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliado.getFefallecimiento()) != true)))
/*     */           {
/*     */ 
/* 571 */             error = "1133";
/* 572 */             break;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 582 */           if ((in271RegafiUpdateAfiliado.getFeActPersonaxIafas().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getFeActPersonaxIafas()) != '0') || (in271RegafiUpdateAfiliado.getFeActPersonaxIafas().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliado.getFeActPersonaxIafas()) != true)))
/*     */           {
/*     */ 
/* 585 */             error = "1223";
/* 586 */             break;
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
/* 600 */           if ((in271RegafiUpdateAfiliado.getFeValidacionReniec().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getFeValidacionReniec()) != '0') || (in271RegafiUpdateAfiliado.getFeValidacionReniec().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliado.getFeValidacionReniec()) != true)))
/*     */           {
/*     */ 
/* 603 */             error = "1143";
/* 604 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 612 */       if ((in271RegafiUpdate.getDetallesAfiliaciones().size() >= 0) && (error.equals("0000")))
/*     */       {
/* 614 */         listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/* 615 */         In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/*     */         
/* 617 */         for (int i = 0; i < listAfi.size(); i++) {
/* 618 */           in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/*     */           
/* 620 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getTiDocTitular()) != '0') {
/* 621 */             error = "2223";
/* 622 */             break; }
/* 623 */           if (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getNuDocTitular()) != '0') {
/* 624 */             error = "2233";
/* 625 */             break; }
/* 626 */           if ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeNacimientoTitular()) != '0') || (in271RegafiUpdateAfiliacion.getFeNacimientoTitular().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeNacimientoTitular()) != true))
/*     */           {
/*     */ 
/* 629 */             error = "2243";
/* 630 */             break; }
/* 631 */           if (ManagerUtil.validaCaracterPalabra(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular()) != '0') {
/* 632 */             error = "2213";
/* 633 */             break; }
/* 634 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getTiContratante()) != '0') {
/* 635 */             error = "2253";
/* 636 */             break; }
/* 637 */           if ((in271RegafiUpdateAfiliacion.getApPaternoContratante().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getApPaternoContratante()) != '0')) {
/* 638 */             error = "2273";
/* 639 */             break; }
/* 640 */           if ((in271RegafiUpdateAfiliacion.getNoContratante1().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getNoContratante1()) != '0')) {
/* 641 */             error = "2263";
/* 642 */             break; }
/* 643 */           if ((in271RegafiUpdateAfiliacion.getNoContratante2().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getNoContratante2()) != '0')) {
/* 644 */             error = "2263";
/* 645 */             break; }
/* 646 */           if ((in271RegafiUpdateAfiliacion.getNoContratante3().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getNoContratante3()) != '0')) {
/* 647 */             error = "2263";
/* 648 */             break; }
/* 649 */           if ((in271RegafiUpdateAfiliacion.getNoContratante4().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getNoContratante4()) != '0')) {
/* 650 */             error = "2263";
/* 651 */             break; }
/* 652 */           if ((in271RegafiUpdateAfiliacion.getApMaternoContratante().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getApMaternoContratante()) != '0')) {
/* 653 */             error = "2283";
/* 654 */             break; }
/* 655 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getTiDocContratante()) != '0') {
/* 656 */             error = "2073";
/* 657 */             break; }
/* 658 */           if (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getNuDocContratante()) != '0') {
/* 659 */             error = "2083";
/* 660 */             break; }
/* 661 */           if ((in271RegafiUpdateAfiliacion.getApCasadaContratante().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getApCasadaContratante()) != '0')) {
/* 662 */             error = "2293";
/* 663 */             break; }
/* 664 */           if ((in271RegafiUpdateAfiliacion.getFeNacimientoContratante().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeNacimientoContratante()) != '0') || (in271RegafiUpdateAfiliacion.getFeNacimientoContratante().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeNacimientoContratante()) != true)))
/*     */           {
/*     */ 
/* 667 */             error = "2303";
/* 668 */             break; }
/* 669 */           if (ManagerUtil.validaCaracterPalabra(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante()) != '0') {
/* 670 */             error = "2063";
/* 671 */             break; }
/* 672 */           if (ManagerUtil.validaAlfanumericoGuion(in271RegafiUpdateAfiliacion.getCoAfiliacion()) != '0') {
/* 673 */             error = "2013";
/* 674 */             break; }
/* 675 */           if (ManagerUtil.validaAlfanumericoGuion(in271RegafiUpdateAfiliacion.getCoContrato()) != '0') {
/* 676 */             error = "2023";
/* 677 */             break; }
/* 678 */           if ((in271RegafiUpdateAfiliacion.getCoUnicoMultisectorial().trim().length() != 0) && (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getCoUnicoMultisectorial()) != '0')) {
/* 679 */             error = "2093";
/* 680 */             break; }
/* 681 */           if (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getTiregimen()) != '0') {
/* 682 */             error = "2103";
/* 683 */             break; }
/* 684 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getEsAfiliacion()) != '0') {
/* 685 */             error = "2043";
/* 686 */             break; }
/* 687 */           if ((in271RegafiUpdateAfiliacion.getCoCausalBaja().trim().length() != 0) && (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getCoCausalBaja()) != '0')) {
/* 688 */             error = "2123";
/* 689 */             break; }
/* 690 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getTiPlanSalud()) != '0') {
/* 691 */             error = "2133";
/* 692 */             break; }
/* 693 */           if (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getNoProductoSalud()) != '0') {
/* 694 */             error = "2143";
/* 695 */             break; }
/* 696 */           if (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getCoProducto()) != '0') {
/* 697 */             error = "2033";
/* 698 */             break; }
/* 699 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getParentesco()) != '0') {
/* 700 */             error = "2053";
/* 701 */             break; }
/* 702 */           if ((in271RegafiUpdateAfiliacion.getCoRenipress().trim().length() != 0) && (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getCoRenipress()) != '0')) {
/* 703 */             error = "2203";
/* 704 */             break; }
/* 705 */           if (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getPkAfiliado()) != '0') {
/* 706 */             error = "1003";
/* 707 */             break; }
/* 708 */           if ((in271RegafiUpdateAfiliacion.getFeActEstado().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeActEstado()) != '0') || (in271RegafiUpdateAfiliacion.getFeActEstado().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeActEstado()) != true)))
/*     */           {
/*     */ 
/* 711 */             error = "2113";
/* 712 */             break; }
/* 713 */           if ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeIniAfiliacion()) != '0') || (in271RegafiUpdateAfiliacion.getFeIniAfiliacion().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeIniAfiliacion()) != true))
/*     */           {
/*     */ 
/* 716 */             error = "2153";
/* 717 */             break; }
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
/* 732 */             break;
/*     */           }
/*     */           
/*     */ 
/* 736 */           if ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeActOperacion()) != '0') || (in271RegafiUpdateAfiliacion.getFeActOperacion().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeActOperacion()) != true))
/*     */           {
/*     */ 
/* 739 */             error = "2313";
/* 740 */             break; }
/* 741 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getTiActOperacion()) != '0') {
/* 742 */             error = "2323";
/* 743 */             break; }
/* 744 */           if ((in271RegafiUpdateAfiliacion.getCoTiCobertura().trim().length() != 0) && (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getCoTiCobertura()) != '0')) {
/* 745 */             error = "2193";
/* 746 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 751 */     if (error.equals("0000"))
/*     */     {
/* 753 */       if (in271RegafiUpdate.getDetallesAfiliados().size() >= 0) {
/* 754 */         listPer = in271RegafiUpdate.getDetallesAfiliados();
/* 755 */         In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();
/*     */         
/* 757 */         for (int i = 0; i < listPer.size(); i++) {
/* 758 */           in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/*     */           
/* 760 */           if ("PER".equals(in271RegafiUpdateAfiliado.getCoPaisDoc().trim())) {
/* 761 */             if ((!"1".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"2".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"5".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"6".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"8".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())))
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 767 */               error = "1024";
/* 768 */               break;
/*     */             }
/* 770 */           } else if ((!"PER".equals(in271RegafiUpdateAfiliado.getCoPaisDoc().trim())) && 
/* 771 */             (!"3".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"4".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())))
/*     */           {
/*     */ 
/* 774 */             error = "1024";
/* 775 */             break;
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
///*      */                  System.out.println("Aqui333333");
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 870 */         if ((!"0".equals(in271RegafiUpdateAfiliado.getIdAfiliadoNombre().trim())) && (!"1".equals(in271RegafiUpdateAfiliado.getIdAfiliadoNombre().trim()))) {
/* 871 */           error = "00039";
/* 872 */           break;
/*     */         }
/*     */       }
/*     */     }
/* 876 */     if ((in271RegafiUpdate.getDetallesAfiliaciones().size() >= 0) && (error.equals("0000")))
/*     */     {
/* 878 */       listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/* 879 */       In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/*     */       
/* 881 */       for (int i = 0; i < listAfi.size(); i++) {
/* 882 */         in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/*     */         
/* 884 */         if ("1".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) {
/* 885 */           if (in271RegafiUpdateAfiliacion.getNuDocTitular().trim().length() != 8) {
/* 886 */             error = "2235";
/* 887 */             break;
/*     */           }
/* 889 */         } else if (("8".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && 
/* 890 */           (in271RegafiUpdateAfiliacion.getNuDocTitular().trim().length() != 11)) {
/* 891 */           error = "2235";
/* 892 */           break;
/*     */         }
/* 894 */         if ("1".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())) {
/* 895 */           if (in271RegafiUpdateAfiliacion.getNuDocContratante().trim().length() != 8) {
/* 896 */             error = "2085";
/* 897 */             break;
/*     */           }
/* 899 */         } else if (("8".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())) && 
/* 900 */           (in271RegafiUpdateAfiliacion.getNuDocContratante().trim().length() != 11)) {
/* 901 */           error = "2085";
/* 902 */           break;
/*     */         }
/*     */         
/* 905 */         if ((!"000".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"001".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"011".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"010".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"101".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"111".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"100".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"110".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())))
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
/* 916 */           error = "00040";
/* 917 */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 923 */     if ((in271RegafiUpdate.getDetallesAfiliados().size() >= 0) && (error.equals("0000"))) {
/* 924 */       listPer = in271RegafiUpdate.getDetallesAfiliados();
/* 925 */       In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();
/* 926 */       String feReniec = "";String feActualiza = "";String sError = "00";
/*     */       
/* 928 */       for (int i = 0; i < listPer.size(); i++) {
/* 929 */         in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/* 930 */         if ((in271RegafiUpdateAfiliado.getFeValidacionReniec().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliado.getFeValidacionReniec().trim())))
/*     */         {
/* 932 */           feReniec = in271RegafiUpdateAfiliado.getFeValidacionReniec();
/*     */         }
/*     */         else {
/* 935 */           sError = "01";
/*     */         }
/*     */       }
/* 938 */       listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/* 939 */       In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/* 940 */       for (int i = 0; i < listAfi.size(); i++) {
/* 941 */         in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/* 942 */         if ((in271RegafiUpdateAfiliacion.getFeActOperacion().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliacion.getFeActOperacion().trim())))
/*     */         {
/* 944 */           feActualiza = in271RegafiUpdateAfiliacion.getFeActOperacion();
/*     */         } else {
/* 946 */           sError = "02";
/*     */         }
/*     */         
/* 949 */         if ((in271RegafiUpdateAfiliacion.getFeIniAfiliacion().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliacion.getFeIniAfiliacion().trim())) && (in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim())))
/*     */         {
/*     */ 
/*     */ 
/* 953 */           if (Integer.parseInt(in271RegafiUpdateAfiliacion.getFeIniAfiliacion().trim()) > Integer.parseInt(in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim())) {
/* 954 */             error = "80028";
/*     */           }
/*     */         }
/*     */         
/* 958 */         if ((in271RegafiUpdateAfiliacion.getFeIniCobertura().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliacion.getFeIniCobertura().trim())) && (in271RegafiUpdateAfiliacion.getFeFinCobertura().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliacion.getFeFinCobertura().trim())))
/*     */         {
/*     */ 
/*     */ 
/* 962 */           if (Integer.parseInt(in271RegafiUpdateAfiliacion.getFeIniCobertura().trim()) > Integer.parseInt(in271RegafiUpdateAfiliacion.getFeFinCobertura().trim())) {
/* 963 */             error = "90028";
/*     */           }
/*     */         }
/*     */       }
/* 967 */       if ((sError.equals("00")) && 
/* 968 */         (Integer.parseInt(feReniec) > Integer.parseInt(feActualiza))) {
/* 969 */         error = "70043";
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 974 */     in271RegafiUpdate.setCoError(error);
/* 975 */     return in271RegafiUpdate;
/*     */   }
/*     */ }


/* Location:              D:\WorkSpace\Desarrollo Afiliacion On Linea\Fuentes\FebanAfiliacionesFH\lib\jr-afiliacion-susalud_v1.5.jar!\pe\gob\susalud\jr\transaccion\susalud\validator\RegafiUpdate271_01Validador.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */