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
/*     */ public class RegafiUpdate271_21Validador
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
/*     */ 
/*  27 */     if (("".equals(in271RegafiUpdate.getNoTransaccion())) || (in271RegafiUpdate.getNoTransaccion() == null)) {
/*  28 */       error = "0011";
/*  29 */     } else if (("".equals(in271RegafiUpdate.getIdRemitente())) || (in271RegafiUpdate.getIdRemitente() == null)) {
/*  30 */       error = "0021";
/*  31 */     } else if (("".equals(in271RegafiUpdate.getIdReceptor())) || (in271RegafiUpdate.getIdReceptor() == null)) {
/*  32 */       error = "0031";
/*  33 */     } else if (("".equals(in271RegafiUpdate.getFeTransaccion())) || (in271RegafiUpdate.getFeTransaccion() == null)) {
/*  34 */       error = "0041";
/*  35 */     } else if (("".equals(in271RegafiUpdate.getHoTransaccion())) || (in271RegafiUpdate.getHoTransaccion() == null)) {
/*  36 */       error = "0051";
/*  37 */     } else if (("".equals(in271RegafiUpdate.getIdCorrelativo())) || (in271RegafiUpdate.getIdCorrelativo() == null)) {
/*  38 */       error = "0061";
/*  39 */     } else if (("".equals(in271RegafiUpdate.getIdTransaccion())) || (in271RegafiUpdate.getIdTransaccion() == null)) {
/*  40 */       error = "0071";
/*  41 */     } else if (("".equals(in271RegafiUpdate.getTiFinalidad())) || (in271RegafiUpdate.getTiFinalidad() == null)) {
/*  42 */       error = "0081";
/*  43 */     } else if (("".equals(in271RegafiUpdate.getCaRemitente())) || (in271RegafiUpdate.getCaRemitente() == null)) {
/*  44 */       error = "0091";
/*     */     }
/*  46 */     else if ((in271RegafiUpdate.getDetallesAfiliados().size() >= 0) && (error.equals("0000")))
/*     */     {
/*  48 */       listPer = in271RegafiUpdate.getDetallesAfiliados();
/*  49 */       In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();
/*     */       
/*  51 */       if (listPer.size() == 0 ) {
/*  52 */         error = "1021";
/*     */       } else {
    if (1==2){
/*  54 */         for (int i = 0; i < listPer.size(); i++) {
    
/*  55 */           in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/*     */           
/*  57 */           if ((("".equals(in271RegafiUpdateAfiliado.getApMaternoAfiliado().trim())) || (in271RegafiUpdateAfiliado.getApMaternoAfiliado() == null)) && (("".equals(in271RegafiUpdateAfiliado.getApCasadaAfiliado().trim())) || (in271RegafiUpdateAfiliado.getApCasadaAfiliado() == null)) && (("".equals(in271RegafiUpdateAfiliado.getApPaternoAfiliado().trim())) || (in271RegafiUpdateAfiliado.getApPaternoAfiliado() == null)))
/*     */           {
/*     */ 
/*  60 */           error = "1056";
/*  61 */           break;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  68 */           if (("".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) || (in271RegafiUpdateAfiliado.getTiDocumentoAfil() == null)) {
/*  69 */             error = "1021";
/*  70 */             break; }
/*  71 */           if (((!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && ("".equals(in271RegafiUpdateAfiliado.getNuDocumentoAfil().trim()))) || (in271RegafiUpdateAfiliado.getNuDocumentoAfil() == null)) {
/*  72 */             error = "1031";
/*  73 */             break;
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
/*  98 */           if (("".equals(in271RegafiUpdateAfiliado.getCoPaisDoc().trim())) || (in271RegafiUpdateAfiliado.getCoPaisDoc() == null)) {
/*  99 */             error = "1011";
/* 100 */             break;
/*     */           }
/*     */         }
/*     */       }

/*     */     }
}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 129 */     if ((in271RegafiUpdate.getIn271RegafiUpdateAfiliacion().size() >= 0) && (error.equals("0000")))
/*     */     {
/* 131 */       listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/* 132 */       In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/*     */       
/* 134 */       if (listAfi.size() == 0) {
/* 135 */         error = "2221";
/*     */       } else {
/* 137 */         for (int i = 0; i < listAfi.size(); i++) {
/* 138 */           in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/*     */           
/* 140 */           if (("".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) || (in271RegafiUpdateAfiliacion.getTiDocTitular() == null)) {
/* 141 */             error = "2221";
/* 142 */             break; }
/* 143 */           if (("".equals(in271RegafiUpdateAfiliacion.getNuDocTitular().trim())) || (in271RegafiUpdateAfiliacion.getNuDocTitular() == null)) {
/* 144 */             error = "2231";
/* 145 */             break; }
/* 146 */           if (("".equals(in271RegafiUpdateAfiliacion.getFeNacimientoTitular().trim())) || (in271RegafiUpdateAfiliacion.getFeNacimientoTitular() == null)) {
/* 147 */             error = "2241";
/* 148 */             break; }
/* 149 */           if (("".equals(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular().trim())) || (in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular() == null)) {
/* 150 */             error = "2211";
/* 151 */             break; }
/* 152 */           if (("".equals(in271RegafiUpdateAfiliacion.getTiContratante().trim())) || (in271RegafiUpdateAfiliacion.getTiContratante() == null)) {
/* 153 */             error = "2251";
/* 154 */             break;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 164 */           if (("".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())) || (in271RegafiUpdateAfiliacion.getTiDocContratante() == null)) {
/* 165 */             error = "2071";
/* 166 */             break; }
/* 167 */           if (("".equals(in271RegafiUpdateAfiliacion.getNuDocContratante().trim())) || (in271RegafiUpdateAfiliacion.getNuDocContratante() == null)) {
/* 168 */             error = "2081";
/* 169 */             break;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 176 */           if (("".equals(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante().trim())) || (in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante() == null)) {
/* 177 */             error = "2061";
/* 178 */             break; }
/* 179 */           if (("".equals(in271RegafiUpdateAfiliacion.getCoAfiliacion().trim())) || (in271RegafiUpdateAfiliacion.getCoAfiliacion() == null)) {
/* 180 */             error = "2011";
/* 181 */             break; }
/* 182 */           if (("".equals(in271RegafiUpdateAfiliacion.getCoContrato().trim())) || (in271RegafiUpdateAfiliacion.getCoContrato() == null)) {
/* 183 */             error = "2021";
/* 184 */             break;
/*     */           }
/*     */           
/*     */ 
/* 188 */           if (("".equals(in271RegafiUpdateAfiliacion.getTiregimen().trim())) || (in271RegafiUpdateAfiliacion.getTiregimen() == null)) {
/* 189 */             error = "2101";
/* 190 */             break; }
/* 191 */           if (("".equals(in271RegafiUpdateAfiliacion.getEsAfiliacion().trim())) || (in271RegafiUpdateAfiliacion.getEsAfiliacion() == null)) {
/* 192 */             error = "2041";
/* 193 */             break; }
/* 194 */           if (("".equals(in271RegafiUpdateAfiliacion.getCoCausalBaja().trim())) || (in271RegafiUpdateAfiliacion.getCoCausalBaja() == null)) {
/* 195 */             error = "2121";
/* 196 */             break; }
/* 197 */           if (("".equals(in271RegafiUpdateAfiliacion.getTiPlanSalud().trim())) || (in271RegafiUpdateAfiliacion.getTiPlanSalud() == null)) {
/* 198 */             error = "2131";
/* 199 */             break; }
/* 200 */           if (("".equals(in271RegafiUpdateAfiliacion.getNoProductoSalud().trim())) || (in271RegafiUpdateAfiliacion.getNoProductoSalud() == null)) {
/* 201 */             error = "2141";
/* 202 */             break; }
/* 203 */           if (("".equals(in271RegafiUpdateAfiliacion.getCoProducto().trim())) || (in271RegafiUpdateAfiliacion.getCoProducto() == null)) {
/* 204 */             error = "2031";
/* 205 */             break; }
/* 206 */           if (("".equals(in271RegafiUpdateAfiliacion.getParentesco().trim())) || (in271RegafiUpdateAfiliacion.getParentesco() == null)) {
/* 207 */             error = "2051";
/* 208 */             break;
/*     */           }
/*     */           
/*     */ 
/* 212 */           if (("".equals(in271RegafiUpdateAfiliacion.getPkAfiliado().trim())) || (in271RegafiUpdateAfiliacion.getPkAfiliado() == null)) {
/* 213 */             error = "1001";
/* 214 */             break; }
/* 215 */           if (("".equals(in271RegafiUpdateAfiliacion.getFeActEstado().trim())) || (in271RegafiUpdateAfiliacion.getFeActEstado() == null)) {
/* 216 */             error = "2111";
/* 217 */             break; }
/* 218 */           if (("".equals(in271RegafiUpdateAfiliacion.getFeIniAfiliacion().trim())) || (in271RegafiUpdateAfiliacion.getFeIniAfiliacion() == null)) {
/* 219 */             error = "2151";
/* 220 */             break; }
/* 221 */           if (("".equals(in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim())) || (in271RegafiUpdateAfiliacion.getFeFinAfiliacion() == null)) {
/* 222 */             error = "2161";
/* 223 */             break;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 230 */           if (("".equals(in271RegafiUpdateAfiliacion.getFeActOperacion().trim())) || (in271RegafiUpdateAfiliacion.getFeActOperacion() == null)) {
/* 231 */             error = "2311";
/* 232 */             break; }
/* 233 */           if (("".equals(in271RegafiUpdateAfiliacion.getTiActOperacion().trim())) || (in271RegafiUpdateAfiliacion.getTiActOperacion() == null)) {
/* 234 */             error = "2321";
/* 235 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 243 */     if (error.equals("0000")) {
/* 244 */       if ((in271RegafiUpdate.getNoTransaccion().trim().length() < 1) || (in271RegafiUpdate.getNoTransaccion().trim().length() > 60))
/*     */       {
/* 246 */         error = "0012";
/* 247 */       } else if ((in271RegafiUpdate.getIdRemitente().trim().length() < 1) || (in271RegafiUpdate.getIdRemitente().trim().length() > 15))
/*     */       {
/* 249 */         error = "0022";
/* 250 */       } else if ((in271RegafiUpdate.getIdReceptor().trim().length() < 1) || (in271RegafiUpdate.getIdReceptor().trim().length() > 15))
/*     */       {
/* 252 */         error = "0032";
/* 253 */       } else if (in271RegafiUpdate.getFeTransaccion().trim().length() != 8) {
/* 254 */         error = "0042";
/* 255 */       } else if ((in271RegafiUpdate.getHoTransaccion().trim().length() < 4) || (in271RegafiUpdate.getHoTransaccion().trim().length() > 8))
/*     */       {
/* 257 */         error = "0052";
/* 258 */       } else if (in271RegafiUpdate.getIdCorrelativo().trim().length() != 9) {
/* 259 */         error = "0062";
/* 260 */       } else if (in271RegafiUpdate.getIdTransaccion().trim().length() != 3) {
/* 261 */         error = "0072";
/* 262 */       } else if (in271RegafiUpdate.getTiFinalidad().trim().length() != 2) {
/* 263 */         error = "0082";
/* 264 */       } else if (in271RegafiUpdate.getCaRemitente().trim().length() != 1) {
/* 265 */         error = "0092";
/* 266 */       } else if ((in271RegafiUpdate.getTiOperacion().trim().length() < 1) || (in271RegafiUpdate.getTiOperacion().trim().length() > 2))
/*     */       {
/* 268 */         error = "0102";
/*     */ 
/*     */       }
/* 271 */       else if ((in271RegafiUpdate.getDetallesAfiliados().size() >= 0) && (error.equals("0000"))) {
/* 272 */         listPer = in271RegafiUpdate.getDetallesAfiliados();
/* 273 */         In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();
/*     */         
/* 275 */         for (int i = 0; i < listPer.size(); i++) {
/* 276 */           in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/*     */           
/* 278 */           int NoAfiliado = 0;
/* 279 */           int nafi1; if (in271RegafiUpdateAfiliado.getNoAfiliado1().trim().length() > 0) nafi1 = in271RegafiUpdateAfiliado.getNoAfiliado1().length(); else nafi1 = 0;
/* 280 */           int nafi2; if (in271RegafiUpdateAfiliado.getNoAfiliado2().trim().length() > 0) nafi2 = in271RegafiUpdateAfiliado.getNoAfiliado2().length(); else { nafi2 = 0;
/*     */           }
/* 282 */           NoAfiliado = nafi1 + nafi2;
/*     */           
/* 284 */           if ((in271RegafiUpdateAfiliado.getApPaternoAfiliado().trim().length() != 0) && (in271RegafiUpdateAfiliado.getApPaternoAfiliado().length() > 50)) {
/* 285 */             error = "1052";
/* 286 */             break; }
/* 287 */           //if (NoAfiliado > 60) {
/* 288 */             //error = "1082";
/* 289 */             //break; }
/* 290 */           if ((in271RegafiUpdateAfiliado.getApMaternoAfiliado().trim().length() != 0) && (in271RegafiUpdateAfiliado.getApMaternoAfiliado().length() > 50)) {
/* 291 */             error = "1062";
/* 292 */             break; }
/* 293 */           if (in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim().length() != 1) {
/* 294 */             error = "1022";
/* 295 */             break; }
/* 296 */           if (((!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (in271RegafiUpdateAfiliado.getNuDocumentoAfil().trim().length() < 1)) || (in271RegafiUpdateAfiliado.getNuDocumentoAfil().trim().length() > 15))
/*     */           {
/* 298 */             error = "1032";
/* 299 */             break; }
/* 300 */           if ((in271RegafiUpdateAfiliado.getEstadoAfiliado().trim().length() != 0) && (in271RegafiUpdateAfiliado.getEstadoAfiliado().trim().length() > 1)) {
/* 301 */             error = "1122";
/* 302 */             break; }
/* 303 */           if ((in271RegafiUpdateAfiliado.getTiDocumentoAct().trim().length() != 0) && (in271RegafiUpdateAfiliado.getTiDocumentoAct().trim().length() > 1)) {
/* 304 */             error = "1202";
/* 305 */             break; }
/* 306 */           if ((in271RegafiUpdateAfiliado.getNuDocumentoAct().trim().length() != 0) && (in271RegafiUpdateAfiliado.getNuDocumentoAct().trim().length() > 15)) {
/* 307 */             error = "1212";
/* 308 */             break; }
/* 309 */           if ((in271RegafiUpdateAfiliado.getApCasadaAfiliado().trim().length() != 0) && (in271RegafiUpdateAfiliado.getApCasadaAfiliado().trim().length() > 50)) {
/* 310 */             error = "1072";
/* 311 */             break; }
/* 312 */           if ((in271RegafiUpdateAfiliado.getCoNacionalidad().trim().length() != 0) && ((in271RegafiUpdateAfiliado.getCoNacionalidad().trim().length() < 2) || (in271RegafiUpdateAfiliado.getCoNacionalidad().trim().length() > 3))) {
/* 313 */             error = "1042";
/* 314 */             break; }
/* 315 */           if ((in271RegafiUpdateAfiliado.getUbigeo().trim().length() != 0) && (in271RegafiUpdateAfiliado.getUbigeo().trim().length() > 12)) {
/* 316 */             error = "1102";
/* 317 */             break; }
/* 318 */           if ((in271RegafiUpdateAfiliado.getFeNacimiento().trim().length() != 0) && (in271RegafiUpdateAfiliado.getFeNacimiento().trim().length() != 8)) {
/* 319 */             error = "1092";
/* 320 */             break; }
/* 321 */           if ((in271RegafiUpdateAfiliado.getGenero().trim().length() != 0) && (in271RegafiUpdateAfiliado.getGenero().trim().length() > 1)) {
/* 322 */             error = "1112";
/* 323 */             break; }
/* 324 */           if (in271RegafiUpdateAfiliado.getCoPaisDoc().trim().length() != 3) {
/* 325 */             error = "1012";
/* 326 */             break; }
/* 327 */           if ((in271RegafiUpdateAfiliado.getFefallecimiento().trim().length() != 0) && (in271RegafiUpdateAfiliado.getFefallecimiento().trim().length() != 8)) {
/* 328 */             error = "1132";
/* 329 */             break; }
/* 330 */           if (in271RegafiUpdateAfiliado.getCoPaisEmisorDocAct().trim().length() > 3) {
/* 331 */             error = "1192";
/* 332 */             break; }
/* 333 */           if ((in271RegafiUpdateAfiliado.getFeActPersonaxIafas().trim().length() != 0) && (in271RegafiUpdateAfiliado.getFeActPersonaxIafas().trim().length() != 8)) {
/* 334 */             error = "1222";
/* 335 */             break; }
/* 336 */           if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (in271RegafiUpdateAfiliado.getTiDocTutor().trim().length() > 1)) {
/* 337 */             error = "1162";
/* 338 */             break; }
/* 339 */           if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (in271RegafiUpdateAfiliado.getNuDocTutor().trim().length() > 15)) {
/* 340 */             error = "1172";
/* 341 */             break; }
/* 342 */           if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (in271RegafiUpdateAfiliado.getTiVinculoTutor().trim().length() > 2)) {
/* 343 */             error = "1182";
/* 344 */             break; }
/* 345 */           if ((in271RegafiUpdateAfiliado.getFeValidacionReniec().trim().length() != 0) && (in271RegafiUpdateAfiliado.getFeValidacionReniec().trim().length() != 8)) {
/* 346 */             error = "1142";
/* 347 */             break; }
/* 348 */           if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (in271RegafiUpdateAfiliado.getCoPaisEmisorDocTutor().trim().length() > 3)) {
/* 349 */             error = "1152";
/* 350 */             break;
/*     */           }
/*     */         }
/*     */       }
/* 354 */       if ((in271RegafiUpdate.getDetallesAfiliaciones().size() >= 0) && (error.equals("0000")))
/*     */       {
/* 356 */         listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/* 357 */         In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/*     */         
/* 359 */         for (int i = 0; i < listAfi.size(); i++) {
/* 360 */           in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/*     */           
/* 362 */           int NoContratante = 0;
/* 363 */           int ncontra1; if (in271RegafiUpdateAfiliacion.getNoContratante1().trim().length() > 0) ncontra1 = in271RegafiUpdateAfiliacion.getNoContratante1().length(); else ncontra1 = 0;
/* 364 */           int ncontra2; if (in271RegafiUpdateAfiliacion.getNoContratante2().trim().length() > 0) ncontra2 = in271RegafiUpdateAfiliacion.getNoContratante2().length(); else ncontra2 = 0;
/* 365 */           int ncontra3; if (in271RegafiUpdateAfiliacion.getNoContratante3().trim().length() > 0) ncontra3 = in271RegafiUpdateAfiliacion.getNoContratante3().length(); else ncontra3 = 0;
/* 366 */           int ncontra4; if (in271RegafiUpdateAfiliacion.getNoContratante4().trim().length() > 0) ncontra4 = in271RegafiUpdateAfiliacion.getNoContratante4().length(); else { ncontra4 = 0;
/*     */           }
/* 368 */           NoContratante = ncontra1 + ncontra2 + ncontra3 + ncontra4;
/*     */           
/* 370 */           if (in271RegafiUpdateAfiliacion.getTiDocTitular().trim().length() != 1) {
/* 371 */             error = "2222";
/* 372 */             break; }
/* 373 */           if ((in271RegafiUpdateAfiliacion.getNuDocTitular().trim().length() < 1) || (in271RegafiUpdateAfiliacion.getNuDocTitular().trim().length() > 15))
/*     */           {
/* 375 */             error = "2232";
/* 376 */             break; }
/* 377 */           if (in271RegafiUpdateAfiliacion.getFeNacimientoTitular().trim().length() != 8) {
/* 378 */             error = "2242";
/* 379 */             break; }
/* 380 */           if (in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular().trim().length() != 3) {
/* 381 */             error = "2212";
/* 382 */             break; }
/* 383 */           if (in271RegafiUpdateAfiliacion.getTiContratante().trim().length() != 1) {
/* 384 */             error = "2252";
/* 385 */             break; }
/* 386 */           if ((in271RegafiUpdateAfiliacion.getApPaternoContratante().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getApPaternoContratante().trim().length() > 50)) {
/* 387 */             error = "2272";
/* 388 */             break; }
/* 389 */           if (in271RegafiUpdateAfiliacion.getNoContratante1().trim().length() > 35) {
/* 390 */             error = "2262";
/* 391 */             break; }
/* 392 */           if (in271RegafiUpdateAfiliacion.getNoContratante2().trim().length() > 25) {
/* 393 */             error = "2262";
/* 394 */             break; }
/* 395 */           if (in271RegafiUpdateAfiliacion.getNoContratante3().trim().length() > 10) {
/* 396 */             error = "2262";
/* 397 */             break; }
/* 398 */           if (in271RegafiUpdateAfiliacion.getNoContratante4().trim().length() > 10) {
/* 399 */             error = "2262";
/* 400 */             break; }
/* 401 */           if (NoContratante > 80) {
/* 402 */             error = "2262";
/* 403 */             break; }
/* 404 */           if ((in271RegafiUpdateAfiliacion.getApMaternoContratante().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getApMaternoContratante().trim().length() > 50)) {
/* 405 */             error = "2282";
/* 406 */             break; }
/* 407 */           if (in271RegafiUpdateAfiliacion.getTiDocContratante().trim().length() != 1) {
/* 408 */             error = "2072";
/* 409 */             break; }
/* 410 */           if ((in271RegafiUpdateAfiliacion.getNuDocContratante().trim().length() < 1) || (in271RegafiUpdateAfiliacion.getNuDocContratante().trim().length() > 15))
/*     */           {
/* 412 */             error = "2082";
/* 413 */             break; }
/* 414 */           if ((in271RegafiUpdateAfiliacion.getApCasadaContratante().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getApCasadaContratante().trim().length() > 50)) {
/* 415 */             error = "2292";
/* 416 */             break; }
/* 417 */           if ((in271RegafiUpdateAfiliacion.getFeNacimientoContratante().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getFeNacimientoContratante().trim().length() != 8)) {
/* 418 */             error = "2302";
/* 419 */             break; }
/* 420 */           if (in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante().trim().length() != 3) {
/* 421 */             error = "2062";
/* 422 */             break; }
/* 423 */           if ((in271RegafiUpdateAfiliacion.getCoAfiliacion().trim().length() < 1) || (in271RegafiUpdateAfiliacion.getCoAfiliacion().trim().length() > 20))
/*     */           {
/* 425 */             error = "2012";
/* 426 */             break; }
/* 427 */           if ((in271RegafiUpdateAfiliacion.getCoContrato().trim().length() < 1) || (in271RegafiUpdateAfiliacion.getCoContrato().trim().length() > 30))
/*     */           {
/* 429 */             error = "2022";
/* 430 */             break; }
/* 431 */           if ((in271RegafiUpdateAfiliacion.getCoUnicoMultisectorial().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getCoUnicoMultisectorial().trim().length() > 20)) {
/* 432 */             error = "2092";
/* 433 */             break; }
/* 434 */           if (in271RegafiUpdateAfiliacion.getTiregimen().trim().length() != 1) {
/* 435 */             error = "2102";
/* 436 */             break; }
/* 437 */           if (in271RegafiUpdateAfiliacion.getEsAfiliacion().trim().length() != 1) {
/* 438 */             error = "2042";
/* 439 */             break; }
/* 440 */           if ((in271RegafiUpdateAfiliacion.getCoCausalBaja().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getCoCausalBaja().trim().length() > 20)) {
/* 441 */             error = "2122";
/* 442 */             break; }
/* 443 */           if (in271RegafiUpdateAfiliacion.getTiPlanSalud().trim().length() != 1) {
/* 444 */             error = "2132";
/* 445 */             break; }
/* 446 */           if ((in271RegafiUpdateAfiliacion.getNoProductoSalud().trim().length() < 1) || (in271RegafiUpdateAfiliacion.getNoProductoSalud().trim().length() > 50))
/*     */           {
/* 448 */             error = "2142";
/* 449 */             break; }
/* 450 */           if ((in271RegafiUpdateAfiliacion.getCoProducto().trim().length() < 1) || (in271RegafiUpdateAfiliacion.getCoProducto().trim().length() > 20))
/*     */           {
/* 452 */             error = "2032";
/* 453 */             break; }
/* 454 */           if ((in271RegafiUpdateAfiliacion.getParentesco().trim().length() < 1) || (in271RegafiUpdateAfiliacion.getParentesco().trim().length() > 2))
/*     */           {
/* 456 */             error = "2052";
/* 457 */             break; }
/* 458 */           if ((in271RegafiUpdateAfiliacion.getCoRenipress().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getCoRenipress().trim().length() > 10)) {
/* 459 */             error = "2202";
/* 460 */             break; }
/* 461 */           if ((in271RegafiUpdateAfiliacion.getPkAfiliado().trim().length() < 12) || (in271RegafiUpdateAfiliacion.getPkAfiliado().trim().length() > 19))
/*     */           {
/* 463 */             error = "1002";
/* 464 */             break; }
/* 465 */           if (in271RegafiUpdateAfiliacion.getFeActEstado().trim().length() != 8) {
/* 466 */             error = "2112";
/* 467 */             break; }
/* 468 */           if (in271RegafiUpdateAfiliacion.getFeIniAfiliacion().trim().length() != 8) {
/* 469 */             error = "2152";
/* 470 */             break; }
/* 471 */           if (in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim().length() != 8) {
/* 472 */             error = "2162";
/* 473 */             break; }
/* 474 */           if ((in271RegafiUpdateAfiliacion.getFeIniCobertura().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getFeIniCobertura().trim().length() != 8)) {
/* 475 */             error = "2172";
/* 476 */             break; }
/* 477 */           if ((in271RegafiUpdateAfiliacion.getFeFinCobertura().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getFeFinCobertura().trim().length() != 8)) {
/* 478 */             error = "2182";
/* 479 */             break; }
/* 480 */           if (in271RegafiUpdateAfiliacion.getFeActOperacion().trim().length() != 8) {
/* 481 */             error = "2312";
/* 482 */             break; }
/* 483 */           if (in271RegafiUpdateAfiliacion.getTiActOperacion().trim().length() != 6) {
/* 484 */             error = "2322";
/* 485 */             break; }
/* 486 */           if ((in271RegafiUpdateAfiliacion.getCoTiCobertura().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getCoTiCobertura().trim().length() > 1)) {
/* 487 */             error = "2192";
/* 488 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 493 */     if (error.equals("0000")) {
/* 494 */       if (ManagerUtil.validaNombreTx(in271RegafiUpdate.getNoTransaccion()) != '0') {
/* 495 */         error = "0013";
/* 496 */       } else if (ManagerUtil.validaAlfanumerico(in271RegafiUpdate.getIdRemitente()) != '0') {
/* 497 */         error = "0023";
/* 498 */       } else if (ManagerUtil.validaAlfanumerico(in271RegafiUpdate.getIdReceptor()) != '0') {
/* 499 */         error = "0033";
/* 500 */       } else if ((ManagerUtil.validaSoloDigito(in271RegafiUpdate.getFeTransaccion()) != '0') || (in271RegafiUpdate.getFeTransaccion().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdate.getFeTransaccion()) != true))
/*     */       {
/*     */ 
/* 503 */         error = "0043";
/* 504 */       } else if (ManagerUtil.validaSoloDigito(in271RegafiUpdate.getHoTransaccion()) != '0') {
/* 505 */         error = "0053";
/* 506 */       } else if (ManagerUtil.validaSoloDigito(in271RegafiUpdate.getIdCorrelativo()) != '0') {
/* 507 */         error = "0063";
/* 508 */       } else if (ManagerUtil.validaSoloDigito(in271RegafiUpdate.getIdTransaccion()) != '0') {
/* 509 */         error = "0073";
/* 510 */       } else if (ManagerUtil.validaSoloDigito(in271RegafiUpdate.getTiFinalidad()) != '0') {
/* 511 */         error = "0083";
/* 512 */       } else if (ManagerUtil.validaSoloDigito(in271RegafiUpdate.getCaRemitente()) != '0') {
/* 513 */         error = "0093";
/* 514 */       } else if (ManagerUtil.validaAlfanumerico(in271RegafiUpdate.getTiOperacion()) != '0') {
/* 515 */         error = "0103";
/*     */ 
/*     */       }
/* 518 */       else if ((in271RegafiUpdate.getDetallesAfiliados().size() >= 0) && (error.equals("0000"))) {
/* 519 */         listPer = in271RegafiUpdate.getDetallesAfiliados();
/* 520 */         In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();
/*     */         
/* 522 */         for (int i = 0; i < listPer.size(); i++) {
/* 523 */           in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/*     */           
/* 525 */           if (((!"".equals(in271RegafiUpdateAfiliado.getApPaternoAfiliado().trim())) || (in271RegafiUpdateAfiliado.getApPaternoAfiliado() != null)) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliado.getApPaternoAfiliado()) != '0')) {
/* 526 */             error = "1053";
/* 527 */             break;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 534 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getTiDocumentoAfil()) != '0') {
/* 535 */             error = "1023";
/* 536 */             break; }
/* 537 */           if ((!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliado.getNuDocumentoAfil()) != '0')) {
/* 538 */             error = "1033";
/* 539 */             break;
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
/* 558 */           if ((in271RegafiUpdateAfiliado.getFeNacimiento().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getFeNacimiento()) != '0') || (in271RegafiUpdateAfiliado.getFeNacimiento().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliado.getFeNacimiento()) != true)))
/*     */           {
/*     */ 
/* 561 */             error = "1093";
/* 562 */             break;
/*     */           }
/*     */           
/*     */ 
/* 566 */           if (ManagerUtil.validaCaracterPalabra(in271RegafiUpdateAfiliado.getCoPaisDoc()) != '0') {
/* 567 */             error = "1013";
/* 568 */             break; }
/* 569 */           if ((in271RegafiUpdateAfiliado.getFefallecimiento().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getFefallecimiento()) != '0') || (in271RegafiUpdateAfiliado.getFefallecimiento().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliado.getFefallecimiento()) != true)))
/*     */           {
/*     */ 
/* 572 */             error = "1133";
/* 573 */             break;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 580 */           if ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getFeActPersonaxIafas()) != '0') || (in271RegafiUpdateAfiliado.getFeActPersonaxIafas().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliado.getFeActPersonaxIafas()) != true))
/*     */           {
/*     */ 
/* 583 */             error = "1223";
/* 584 */             break;
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
/* 598 */           if ((in271RegafiUpdateAfiliado.getFeValidacionReniec().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getFeValidacionReniec()) != '0') || (in271RegafiUpdateAfiliado.getFeValidacionReniec().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliado.getFeValidacionReniec()) != true)))
/*     */           {
/*     */ 
/* 601 */             error = "1143";
/* 602 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 610 */       if ((in271RegafiUpdate.getDetallesAfiliaciones().size() >= 0) && (error.equals("0000")))
/*     */       {
/* 612 */         listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/* 613 */         In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/*     */         
/* 615 */         for (int i = 0; i < listAfi.size(); i++) {
/* 616 */           in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/*     */           
/* 618 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getTiDocTitular()) != '0') {
/* 619 */             error = "2223";
/* 620 */             break; }
/* 621 */           if (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getNuDocTitular()) != '0') {
/* 622 */             error = "2233";
/* 623 */             break; }
/* 624 */           if ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeNacimientoTitular()) != '0') || (in271RegafiUpdateAfiliacion.getFeNacimientoTitular().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeNacimientoTitular()) != true))
/*     */           {
/*     */ 
/* 627 */             error = "2243";
/* 628 */             break; }
/* 629 */           if (ManagerUtil.validaCaracterPalabra(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular()) != '0') {
/* 630 */             error = "2213";
/* 631 */             break; }
/* 632 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getTiContratante()) != '0') {
/* 633 */             error = "2253";
/* 634 */             break; }
/* 635 */           if ((in271RegafiUpdateAfiliacion.getApPaternoContratante().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getApPaternoContratante()) != '0')) {
/* 636 */             error = "2273";
/* 637 */             break; }
/* 638 */           if ((in271RegafiUpdateAfiliacion.getNoContratante1().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getNoContratante1()) != '0')) {
/* 639 */             error = "2263";
/* 640 */             break; }
/* 641 */           if ((in271RegafiUpdateAfiliacion.getNoContratante2().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getNoContratante2()) != '0')) {
/* 642 */             error = "2263";
/* 643 */             break; }
/* 644 */           if ((in271RegafiUpdateAfiliacion.getNoContratante3().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getNoContratante3()) != '0')) {
/* 645 */             error = "2263";
/* 646 */             break; }
/* 647 */           if ((in271RegafiUpdateAfiliacion.getNoContratante4().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getNoContratante4()) != '0')) {
/* 648 */             error = "2263";
/* 649 */             break; }
/* 650 */           if ((in271RegafiUpdateAfiliacion.getApMaternoContratante().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getApMaternoContratante()) != '0')) {
/* 651 */             error = "2283";
/* 652 */             break; }
/* 653 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getTiDocContratante()) != '0') {
/* 654 */             error = "2073";
/* 655 */             break; }
/* 656 */           if (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getNuDocContratante()) != '0') {
/* 657 */             error = "2083";
/* 658 */             break; }
/* 659 */           if ((in271RegafiUpdateAfiliacion.getApCasadaContratante().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getApCasadaContratante()) != '0')) {
/* 660 */             error = "2293";
/* 661 */             break; }
/* 662 */           if ((in271RegafiUpdateAfiliacion.getFeNacimientoContratante().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeNacimientoContratante()) != '0') || (in271RegafiUpdateAfiliacion.getFeNacimientoContratante().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeNacimientoContratante()) != true)))
/*     */           {
/*     */ 
/* 665 */             error = "2303";
/* 666 */             break; }
/* 667 */           if (ManagerUtil.validaCaracterPalabra(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante()) != '0') {
/* 668 */             error = "2063";
/* 669 */             break; }
/* 670 */           if (ManagerUtil.validaAlfanumericoGuion(in271RegafiUpdateAfiliacion.getCoAfiliacion()) != '0') {
/* 671 */             error = "2013";
/* 672 */             break; }
/* 673 */           if (ManagerUtil.validaAlfanumericoGuion(in271RegafiUpdateAfiliacion.getCoContrato()) != '0') {
/* 674 */             error = "2023";
/* 675 */             break; }
/* 676 */           if ((in271RegafiUpdateAfiliacion.getCoUnicoMultisectorial().trim().length() != 0) && (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getCoUnicoMultisectorial()) != '0')) {
/* 677 */             error = "2093";
/* 678 */             break; }
/* 679 */           if (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getTiregimen()) != '0') {
/* 680 */             error = "2103";
/* 681 */             break; }
/* 682 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getEsAfiliacion()) != '0') {
/* 683 */             error = "2043";
/* 684 */             break; }
/* 685 */           if (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getCoCausalBaja()) != '0') {
/* 686 */             error = "2123";
/* 687 */             break; }
/* 688 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getTiPlanSalud()) != '0') {
/* 689 */             error = "2133";
/* 690 */             break; }
/* 691 */           if (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getNoProductoSalud()) != '0') {
/* 692 */             error = "2143";
/* 693 */             break; }
/* 694 */           if (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getCoProducto()) != '0') {
/* 695 */             error = "2033";
/* 696 */             break; }
/* 697 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getParentesco()) != '0') {
/* 698 */             error = "2053";
/* 699 */             break; }
/* 700 */           if ((in271RegafiUpdateAfiliacion.getCoRenipress().trim().length() != 0) && (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getCoRenipress()) != '0')) {
/* 701 */             error = "2203";
/* 702 */             break; }
/* 703 */           if (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getPkAfiliado()) != '0') {
/* 704 */             error = "1003";
/* 705 */             break; }
/* 706 */           if ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeActEstado()) != '0') || (in271RegafiUpdateAfiliacion.getFeActEstado().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeActEstado()) != true))
/*     */           {
/*     */ 
/* 709 */             error = "2113";
/* 710 */             break; }
/* 711 */           if ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeIniAfiliacion()) != '0') || (in271RegafiUpdateAfiliacion.getFeIniAfiliacion().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeIniAfiliacion()) != true))
/*     */           {
/*     */ 
/* 714 */             error = "2153";
/* 715 */             break; }
/* 716 */           if ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeFinAfiliacion()) != '0') || (in271RegafiUpdateAfiliacion.getFeFinAfiliacion().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeFinAfiliacion()) != true))
/*     */           {
/*     */ 
/* 719 */             error = "2163";
/* 720 */             break; }
/* 721 */           if ((in271RegafiUpdateAfiliacion.getFeIniCobertura().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeIniCobertura()) != '0') || (in271RegafiUpdateAfiliacion.getFeIniCobertura().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeIniCobertura()) != true)))
/*     */           {
/*     */ 
/* 724 */             error = "2173";
/* 725 */             break; }
/* 726 */           if ((in271RegafiUpdateAfiliacion.getFeFinCobertura().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeFinCobertura()) != '0') || (in271RegafiUpdateAfiliacion.getFeFinCobertura().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeFinCobertura()) != true)))
/*     */           {
/*     */ 
/* 729 */             error = "2183";
/* 730 */             break; }
/* 731 */           if ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeActOperacion()) != '0') || (in271RegafiUpdateAfiliacion.getFeActOperacion().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeActOperacion()) != true))
/*     */           {
/*     */ 
/* 734 */             error = "2313";
/* 735 */             break; }
/* 736 */           if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getTiActOperacion()) != '0') {
/* 737 */             error = "2323";
/* 738 */             break; }
/* 739 */           if ((in271RegafiUpdateAfiliacion.getCoTiCobertura().trim().length() != 0) && (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getCoTiCobertura()) != '0')) {
/* 740 */             error = "2193";
/* 741 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 746 */     if (error.equals("0000"))
/*     */     {
/* 748 */       if (in271RegafiUpdate.getDetallesAfiliados().size() >= 0) {
/* 749 */         listPer = in271RegafiUpdate.getDetallesAfiliados();
/* 750 */         In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();
/*     */         
/* 752 */         for (int i = 0; i < listPer.size(); i++) {
/* 753 */           in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/*     */           
/* 755 */           if ("PER".equals(in271RegafiUpdateAfiliado.getCoPaisDoc().trim())) {
/* 756 */             if ((!"1".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"2".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"5".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"6".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"8".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())))
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 762 */               error = "1024";
/* 763 */               break;
/*     */             }
/* 765 */           } else if ((!"PER".equals(in271RegafiUpdateAfiliado.getCoPaisDoc().trim())) && 
/* 766 */             (!"3".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"4".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())))
/*     */           {
/*     */ 
/* 769 */             error = "1024";
/* 770 */             break;
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
/* 790 */       if ((in271RegafiUpdate.getDetallesAfiliaciones().size() >= 0) && (error.equals("0000")))
/*     */       {
/* 792 */         listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/* 793 */         In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/*     */         
/* 795 */         for (int i = 0; i < listAfi.size(); i++) {
/* 796 */           in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/*     */           
///* 798 */           if ("PER".equals(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular().trim())) {
///* 799 */             if ((!"1".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"2".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"5".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"6".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"7".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"8".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())))
///*     */             {
//                        
///* 805 */               error = "2224";
///* 806 */               break;
///*     */             }
///* 808 */           } else if ((!"PER".equals(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular().trim())) && 
///* 809 */             (!"2".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"3".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"4".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"7".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())))
///*     */           {
///*     */               System.out.println("aqui");
///* 812 */             error = "2224";
///* 813 */             break;
///*     */           }
/* 815 */           if ("PER".equals(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante().trim())) {
/* 816 */             if ((!"1".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())) && (!"2".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())) && (!"8".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())) && (!"9".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())))
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 822 */               error = "2074";
/* 823 */               break;
/*     */             }
/* 825 */           } else { if (!"PER".equals(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante().trim())) {
/*     */               break;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 837 */     if ((in271RegafiUpdate.getDetallesAfiliados().size() >= 0) && (error.equals("0000"))) {
/* 838 */       listPer = in271RegafiUpdate.getDetallesAfiliados();
/* 839 */       In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();
/*     */       
/* 841 */       for (int i = 0; i < listPer.size(); i++) {
/* 842 */         in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/*     */         
/* 844 */         if ((!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && ("1".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim()))) {
/* 845 */           if (in271RegafiUpdateAfiliado.getNuDocumentoAfil().trim().length() != 8) {
/* 846 */             error = "1035";
/* 847 */             break;
/*     */           }
/* 849 */         } else if ((!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && ("8".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && 
/* 850 */           (in271RegafiUpdateAfiliado.getNuDocumentoAfil().trim().length() != 11)) {
/* 851 */           error = "1035";
/* 852 */           break;
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
/* 866 */         if ((!"0".equals(in271RegafiUpdateAfiliado.getIdAfiliadoNombre().trim())) && (!"1".equals(in271RegafiUpdateAfiliado.getIdAfiliadoNombre().trim()))) {
/* 867 */           error = "00039";
/* 868 */           break;
/*     */         }
/*     */       }
/*     */     }
/* 872 */     if ((in271RegafiUpdate.getDetallesAfiliaciones().size() >= 0) && (error.equals("0000")))
/*     */     {
/* 874 */       listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/* 875 */       In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/*     */       
/* 877 */       for (int i = 0; i < listAfi.size(); i++) {
/* 878 */         in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/*     */         
/* 880 */         if ("1".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) {
/* 881 */           if (in271RegafiUpdateAfiliacion.getNuDocTitular().trim().length() != 8) {
/* 882 */             error = "2235";
/* 883 */             break;
/*     */           }
/* 885 */         } else if (("8".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && 
/* 886 */           (in271RegafiUpdateAfiliacion.getNuDocTitular().trim().length() != 11)) {
/* 887 */           error = "2235";
/* 888 */           break;
/*     */         }
/* 890 */         if ("1".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())) {
/* 891 */           if (in271RegafiUpdateAfiliacion.getNuDocContratante().trim().length() != 8) {
/* 892 */             error = "2085";
/* 893 */             break;
/*     */           }
/* 895 */         } else if (("8".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())) && 
/* 896 */           (in271RegafiUpdateAfiliacion.getNuDocContratante().trim().length() != 11)) {
/* 897 */           error = "2085";
/* 898 */           break;
/*     */         }
/*     */         
/* 901 */         if ((!"000".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"001".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"011".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"010".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"101".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"111".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"100".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"110".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())))
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
/* 912 */           error = "00040";
/* 913 */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 919 */     if ((in271RegafiUpdate.getDetallesAfiliados().size() >= 0) && (error.equals("0000"))) {
/* 920 */       listPer = in271RegafiUpdate.getDetallesAfiliados();
/* 921 */       In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();
/* 922 */       String feReniec = "";String feActualiza = "";String sError = "00";
/*     */       
/* 924 */       for (int i = 0; i < listPer.size(); i++) {
/* 925 */         in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/* 926 */         if ((in271RegafiUpdateAfiliado.getFeValidacionReniec().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliado.getFeValidacionReniec().trim())))
/*     */         {
/* 928 */           feReniec = in271RegafiUpdateAfiliado.getFeValidacionReniec();
/*     */         }
/*     */         else {
/* 931 */           sError = "01";
/*     */         }
/*     */       }
/* 934 */       listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/* 935 */       In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/* 936 */       for (int i = 0; i < listAfi.size(); i++) {
/* 937 */         in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/* 938 */         if ((in271RegafiUpdateAfiliacion.getFeActOperacion().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliacion.getFeActOperacion().trim())))
/*     */         {
/* 940 */           feActualiza = in271RegafiUpdateAfiliacion.getFeActOperacion();
/*     */         } else {
/* 942 */           sError = "02";
/*     */         }
/*     */         
/* 945 */         if ((in271RegafiUpdateAfiliacion.getFeIniAfiliacion().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliacion.getFeIniAfiliacion().trim())) && (in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim())))
/*     */         {
/*     */ 
/*     */ 
/* 949 */           if (Integer.parseInt(in271RegafiUpdateAfiliacion.getFeIniAfiliacion().trim()) > Integer.parseInt(in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim())) {
/* 950 */             error = "80028";
/*     */           }
/*     */         }
/*     */         
/* 954 */         if ((in271RegafiUpdateAfiliacion.getFeIniCobertura().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliacion.getFeIniCobertura().trim())) && (in271RegafiUpdateAfiliacion.getFeFinCobertura().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliacion.getFeFinCobertura().trim())))
/*     */         {
/*     */ 
/*     */ 
/* 958 */           //if (Integer.parseInt(in271RegafiUpdateAfiliacion.getFeIniCobertura().trim()) > Integer.parseInt(in271RegafiUpdateAfiliacion.getFeFinCobertura().trim())) {
/* 959 */             //error = "90028";
/*     */           //}
/*     */         }
/*     */       }
/* 963 */       if ((sError.equals("00")) && 
/* 964 */         (Integer.parseInt(feReniec) > Integer.parseInt(feActualiza))) {
/* 965 */         error = "70043";
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 970 */     in271RegafiUpdate.setCoError(error);
/* 971 */     return in271RegafiUpdate;
/*     */   }
/*     */ }


/* Location:              D:\WorkSpace\Desarrollo Afiliacion On Linea\Fuentes\FebanAfiliacionesFH\lib\jr-afiliacion-susalud_v1.5.jar!\pe\gob\susalud\jr\transaccion\susalud\validator\RegafiUpdate271_21Validador.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */