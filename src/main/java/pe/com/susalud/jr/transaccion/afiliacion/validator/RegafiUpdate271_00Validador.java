/*      */ package pe.com.susalud.jr.transaccion.afiliacion.validator;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;

import pe.com.susalud.jr.transaccion.afiliacion.bean.In271RegafiUpdate;
import pe.com.susalud.jr.transaccion.afiliacion.bean.In271RegafiUpdateAfiliacion;
import pe.com.susalud.jr.transaccion.afiliacion.bean.In271RegafiUpdateAfiliado;
import pe.com.susalud.jr.transaccion.afiliacion.util.ManagerUtil;
/*      */ //import pe.gob.susalud.jr.transaccion.susalud.bean.In271RegafiUpdate;
/*      */ //import pe.gob.susalud.jr.transaccion.susalud.bean.In271RegafiUpdateAfiliacion;
/*      */ //import pe.gob.susalud.jr.transaccion.susalud.bean.In271RegafiUpdateAfiliado;
/*      */ //import pe.gob.susalud.jr.transaccion.susalud.util.ManagerUtil;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class RegafiUpdate271_00Validador
/*      */ {
/*      */   public String ValidateBeanInRegafiUpdate271(In271RegafiUpdate in271RegafiUpdate)
/*      */   {
/*   23 */     List<In271RegafiUpdateAfiliado> listPer = new ArrayList();
/*   24 */     List<In271RegafiUpdateAfiliacion> listAfi = new ArrayList();
/*      */     
/*      */ 
/*   27 */     String error = "0000";
/*      */     
/*   29 */     if (("".equals(in271RegafiUpdate.getTiOperacion())) || (in271RegafiUpdate.getTiOperacion() == null)) {
/*   30 */       error = "0101";
/*      */     } else {
/*   32 */       String tiOperacion = in271RegafiUpdate.getTiOperacion();
/*      */       
/*   34 */       if (tiOperacion.trim().equalsIgnoreCase("00"))
/*      */       {
/*      */ 
/*   37 */         if (("".equals(in271RegafiUpdate.getNoTransaccion())) || (in271RegafiUpdate.getNoTransaccion() == null)) {
/*   38 */           error = "0011";
/*   39 */         } else if (("".equals(in271RegafiUpdate.getIdRemitente())) || (in271RegafiUpdate.getIdRemitente() == null)) {
/*   40 */           error = "0021";
/*   41 */         } else if (("".equals(in271RegafiUpdate.getIdReceptor())) || (in271RegafiUpdate.getIdReceptor() == null)) {
/*   42 */           error = "0031";
/*   43 */         } else if (("".equals(in271RegafiUpdate.getFeTransaccion())) || (in271RegafiUpdate.getFeTransaccion() == null)) {
/*   44 */           error = "0041";
/*   45 */         } else if (("".equals(in271RegafiUpdate.getHoTransaccion())) || (in271RegafiUpdate.getHoTransaccion() == null)) {
/*   46 */           error = "0051";
/*   47 */         } else if (("".equals(in271RegafiUpdate.getIdCorrelativo())) || (in271RegafiUpdate.getIdCorrelativo() == null)) {
/*   48 */           error = "0061";
/*   49 */         } else if (("".equals(in271RegafiUpdate.getIdTransaccion())) || (in271RegafiUpdate.getIdTransaccion() == null)) {
/*   50 */           error = "0071";
/*   51 */         } else if (("".equals(in271RegafiUpdate.getTiFinalidad())) || (in271RegafiUpdate.getTiFinalidad() == null)) {
/*   52 */           error = "0081";
/*   53 */         } else if (("".equals(in271RegafiUpdate.getCaRemitente())) || (in271RegafiUpdate.getCaRemitente() == null)) {
/*   54 */           error = "0091";
/*      */         }
/*   56 */         else if ((in271RegafiUpdate.getDetallesAfiliados().size() >= 0) && (error.equals("0000")))
/*      */         {
/*   58 */           listPer = in271RegafiUpdate.getDetallesAfiliados();
/*   59 */           In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();
/*      */           
/*   61 */           if (listPer.size() == 0) {
/*   62 */             error = "1081";
/*      */           } else {
/*   64 */             for (int i = 0; i < listPer.size(); i++) {
/*   65 */               in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/*      */               
/*   67 */               if ((("".equals(in271RegafiUpdateAfiliado.getApMaternoAfiliado().trim())) || (in271RegafiUpdateAfiliado.getApMaternoAfiliado() == null)) && (("".equals(in271RegafiUpdateAfiliado.getApCasadaAfiliado().trim())) || (in271RegafiUpdateAfiliado.getApCasadaAfiliado() == null)) && (("".equals(in271RegafiUpdateAfiliado.getApPaternoAfiliado().trim())) || (in271RegafiUpdateAfiliado.getApPaternoAfiliado() == null)))
/*      */               {
/*      */ 
/*   70 */                 error = "1056";
/*   71 */                 break; }
/*   72 */               if (("".equals(in271RegafiUpdateAfiliado.getNoAfiliado1().trim())) || (in271RegafiUpdateAfiliado.getNoAfiliado1() == null)) {
/*   73 */                 error = "1081";
/*   74 */                 break;
/*      */               }
/*      */               
/*      */ 
/*   78 */               if (("".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) || (in271RegafiUpdateAfiliado.getTiDocumentoAfil() == null)) {
/*   79 */                 error = "1021";
/*   80 */                 break; }
/*   81 */               if (((!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && ("".equals(in271RegafiUpdateAfiliado.getNuDocumentoAfil().trim()))) || (in271RegafiUpdateAfiliado.getNuDocumentoAfil() == null)) {
/*   82 */                 error = "1031";
/*   83 */                 break; }
/*   84 */               if (("".equals(in271RegafiUpdateAfiliado.getEstadoAfiliado().trim())) || (in271RegafiUpdateAfiliado.getEstadoAfiliado() == null)) {
/*   85 */                 error = "1121";
/*   86 */                 break;
/*      */               }
/*      */               
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  102 */               if (("".equals(in271RegafiUpdateAfiliado.getFeNacimiento().trim())) || (in271RegafiUpdateAfiliado.getFeNacimiento() == null)) {
/*  103 */                 error = "1091";
/*  104 */                 break; }
/*  105 */               if (("".equals(in271RegafiUpdateAfiliado.getGenero().trim())) || (in271RegafiUpdateAfiliado.getGenero() == null)) {
/*  106 */                 error = "1111";
/*  107 */                 break; }
/*  108 */               if (("".equals(in271RegafiUpdateAfiliado.getCoPaisDoc().trim())) || (in271RegafiUpdateAfiliado.getCoPaisDoc() == null)) {
/*  109 */                 error = "1011";
/*  110 */                 break;
/*      */               }
/*      */               
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  120 */               if ((("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && ("".equals(in271RegafiUpdateAfiliado.getTiDocTutor().trim()))) || (in271RegafiUpdateAfiliado.getTiDocTutor() == null)) {
/*  121 */                 error = "1161";
/*  122 */                 break; }
/*  123 */               if ((("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && ("".equals(in271RegafiUpdateAfiliado.getNuDocTutor().trim()))) || (in271RegafiUpdateAfiliado.getNuDocTutor() == null)) {
/*  124 */                 error = "1171";
/*  125 */                 break; }
/*  126 */               if ((("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && ("".equals(in271RegafiUpdateAfiliado.getTiVinculoTutor().trim()))) || (in271RegafiUpdateAfiliado.getTiVinculoTutor() == null)) {
/*  127 */                 error = "1181";
/*  128 */                 break;
/*      */               }
/*      */               
/*      */ 
/*  132 */               if ((("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && ("".equals(in271RegafiUpdateAfiliado.getCoPaisEmisorDocTutor().trim()))) || (in271RegafiUpdateAfiliado.getCoPaisEmisorDocTutor() == null)) {
/*  133 */                 error = "1151";
/*  134 */                 break;
/*      */               }
/*      */             }
/*      */           }
/*      */         }
/*  139 */         if ((in271RegafiUpdate.getIn271RegafiUpdateAfiliacion().size() >= 0) && (error.equals("0000")))
/*      */         {
/*  141 */           listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/*  142 */           In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/*      */           
/*  144 */           if (listAfi.size() == 0) {
/*  145 */             error = "2221";
/*      */           } else {
/*  147 */             for (int i = 0; i < listAfi.size(); i++) {
/*  148 */               in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/*      */               
/*  150 */               if (("".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) || (in271RegafiUpdateAfiliacion.getTiDocTitular() == null)) {
/*  151 */                 error = "2221";
/*  152 */                 break; }
/*  153 */               if (("".equals(in271RegafiUpdateAfiliacion.getNuDocTitular().trim())) || (in271RegafiUpdateAfiliacion.getNuDocTitular() == null)) {
/*  154 */                 error = "2231";
/*  155 */                 break; }
/*  156 */               if (("".equals(in271RegafiUpdateAfiliacion.getFeNacimientoTitular().trim())) || (in271RegafiUpdateAfiliacion.getFeNacimientoTitular() == null)) {
/*  157 */                 error = "2241";
/*  158 */                 break; }
/*  159 */               if (("".equals(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular().trim())) || (in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular() == null)) {
/*  160 */                 error = "2211";
/*  161 */                 break; }
/*  162 */               if (("".equals(in271RegafiUpdateAfiliacion.getTiContratante().trim())) || (in271RegafiUpdateAfiliacion.getTiContratante() == null)) {
/*  163 */                 error = "2251";
/*  164 */                 break;
/*      */               }
/*      */               
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  174 */               if (("".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())) || (in271RegafiUpdateAfiliacion.getTiDocContratante() == null)) {
/*  175 */                 error = "2071";
/*  176 */                 break; }
/*  177 */               if (("".equals(in271RegafiUpdateAfiliacion.getNuDocContratante().trim())) || (in271RegafiUpdateAfiliacion.getNuDocContratante() == null)) {
/*  178 */                 error = "2081";
/*  179 */                 break;
/*      */               }
/*      */               
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  186 */               if (("".equals(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante().trim())) || (in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante() == null)) {
/*  187 */                 error = "2061";
/*  188 */                 break; }
/*  189 */               if (("".equals(in271RegafiUpdateAfiliacion.getCoAfiliacion().trim())) || (in271RegafiUpdateAfiliacion.getCoAfiliacion() == null)) {
/*  190 */                 error = "2011";
/*  191 */                 break; }
/*  192 */               if (("".equals(in271RegafiUpdateAfiliacion.getCoContrato().trim())) || (in271RegafiUpdateAfiliacion.getCoContrato() == null)) {
/*  193 */                 error = "2021";
/*  194 */                 break;
/*      */               }
/*      */               
/*      */ 
/*  198 */               if (("".equals(in271RegafiUpdateAfiliacion.getTiregimen().trim())) || (in271RegafiUpdateAfiliacion.getTiregimen() == null)) {
/*  199 */                 error = "2101";
/*  200 */                 break; }
/*  201 */               if (("".equals(in271RegafiUpdateAfiliacion.getEsAfiliacion().trim())) || (in271RegafiUpdateAfiliacion.getEsAfiliacion() == null)) {
/*  202 */                 error = "2041";
/*  203 */                 break;
/*      */               }
/*      */               
/*      */ 
/*  207 */               if (("".equals(in271RegafiUpdateAfiliacion.getTiPlanSalud().trim())) || (in271RegafiUpdateAfiliacion.getTiPlanSalud() == null)) {
/*  208 */                 error = "2131";
/*  209 */                 break; }
/*  210 */               if (("".equals(in271RegafiUpdateAfiliacion.getNoProductoSalud().trim())) || (in271RegafiUpdateAfiliacion.getNoProductoSalud() == null)) {
/*  211 */                 error = "2141";
/*  212 */                 break; }
/*  213 */               if (("".equals(in271RegafiUpdateAfiliacion.getCoProducto().trim())) || (in271RegafiUpdateAfiliacion.getCoProducto() == null)) {
/*  214 */                 error = "2031";
/*  215 */                 break; }
/*  216 */               if (("".equals(in271RegafiUpdateAfiliacion.getParentesco().trim())) || (in271RegafiUpdateAfiliacion.getParentesco() == null)) {
/*  217 */                 error = "2051";
/*  218 */                 break;
/*      */               }
/*      */               
/*      */ 
/*  222 */               if (("".equals(in271RegafiUpdateAfiliacion.getPkAfiliado().trim())) || (in271RegafiUpdateAfiliacion.getPkAfiliado() == null)) {
/*  223 */                 error = "1001";
/*  224 */                 break;
/*      */               }
/*      */               
/*      */ 
/*  228 */               if (("".equals(in271RegafiUpdateAfiliacion.getFeIniAfiliacion().trim())) || (in271RegafiUpdateAfiliacion.getFeIniAfiliacion() == null)) {
/*  229 */                 error = "2151";
/*  230 */                 break;
/*      */               }
/*      */             }
/*      */           }
/*      */         }
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  253 */         if (error.equals("0000")) {
/*  254 */           if ((in271RegafiUpdate.getNoTransaccion().trim().length() < 1) || (in271RegafiUpdate.getNoTransaccion().trim().length() > 60))
/*      */           {
/*  256 */             error = "0012";
/*  257 */           } else if ((in271RegafiUpdate.getIdRemitente().trim().length() < 1) || (in271RegafiUpdate.getIdRemitente().trim().length() > 15))
/*      */           {
/*  259 */             error = "0022";
/*  260 */           } else if ((in271RegafiUpdate.getIdReceptor().trim().length() < 1) || (in271RegafiUpdate.getIdReceptor().trim().length() > 15))
/*      */           {
/*  262 */             error = "0032";
/*  263 */           } else if (in271RegafiUpdate.getFeTransaccion().trim().length() != 8) {
/*  264 */             error = "0042";
/*  265 */           } else if ((in271RegafiUpdate.getHoTransaccion().trim().length() < 4) || (in271RegafiUpdate.getHoTransaccion().trim().length() > 8))
/*      */           {
/*  267 */             error = "0052";
/*  268 */           } else if (in271RegafiUpdate.getIdCorrelativo().trim().length() != 9) {
/*  269 */             error = "0062";
/*  270 */           } else if (in271RegafiUpdate.getIdTransaccion().trim().length() != 3) {
/*  271 */             error = "0072";
/*  272 */           } else if (in271RegafiUpdate.getTiFinalidad().trim().length() != 2) {
/*  273 */             error = "0082";
/*  274 */           } else if (in271RegafiUpdate.getCaRemitente().trim().length() != 1) {
/*  275 */             error = "0092";
/*  276 */           } else if ((in271RegafiUpdate.getTiOperacion().trim().length() < 1) || (in271RegafiUpdate.getTiOperacion().trim().length() > 2))
/*      */           {
/*  278 */             error = "0102";
/*      */ 
/*      */           }
/*  281 */           else if ((in271RegafiUpdate.getDetallesAfiliados().size() >= 0) && (error.equals("0000"))) {
/*  282 */             listPer = in271RegafiUpdate.getDetallesAfiliados();
/*  283 */             In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();
/*      */             
/*  285 */             for (int i = 0; i < listPer.size(); i++) {
/*  286 */               in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/*      */               
/*  288 */               int NoAfiliado = 0;
/*  289 */               int nafi1;  if (in271RegafiUpdateAfiliado.getNoAfiliado1().trim().length() > 0) nafi1 = in271RegafiUpdateAfiliado.getNoAfiliado1().length(); else nafi1 = 0;
/*  290 */               int nafi2;  if (in271RegafiUpdateAfiliado.getNoAfiliado2().trim().length() > 0) nafi2 = in271RegafiUpdateAfiliado.getNoAfiliado2().length(); else { nafi2 = 0;
/*      */               }
/*  292 */               NoAfiliado = nafi1 + nafi2;
/*      */               
/*  294 */               if ((in271RegafiUpdateAfiliado.getApPaternoAfiliado().trim().length() != 0) && (in271RegafiUpdateAfiliado.getApPaternoAfiliado().length() > 50)) {
/*  295 */                 error = "1052";
/*  296 */                 break; }
/*  297 */               //if ((in271RegafiUpdateAfiliado.getNoAfiliado1().length() < 1) || (in271RegafiUpdateAfiliado.getNoAfiliado1().length() > 35))
/*      */               //{
/*  299 */                 //error = "1082";
/*  300 */                 //break; }
/*  301 */               if (in271RegafiUpdateAfiliado.getNoAfiliado2().length() > 25) {
/*  302 */                 error = "1082";
/*  303 */                 break; }
/*  304 */               if (NoAfiliado > 60) {
/*  305 */                 error = "1082";
/*  306 */                 break; }
/*  307 */               if ((in271RegafiUpdateAfiliado.getApMaternoAfiliado().trim().length() != 0) && (in271RegafiUpdateAfiliado.getApMaternoAfiliado().length() > 50)) {
/*  308 */                 error = "1062";
/*  309 */                 break; }
/*  310 */               if (in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim().length() != 1) {
/*  311 */                 error = "1022";
/*  312 */                 break; }
/*  313 */               if (((!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (in271RegafiUpdateAfiliado.getNuDocumentoAfil().trim().length() < 1)) || (in271RegafiUpdateAfiliado.getNuDocumentoAfil().trim().length() > 15))
/*      */               {
/*  315 */                 error = "1032";
/*  316 */                 break; }
/*  317 */               if (in271RegafiUpdateAfiliado.getEstadoAfiliado().trim().length() != 1) {
/*  318 */                 error = "1122";
/*  319 */                 break; }
/*  320 */               if ((in271RegafiUpdateAfiliado.getTiDocumentoAct().trim().length() != 0) && (in271RegafiUpdateAfiliado.getTiDocumentoAct().length() > 1)) {
/*  321 */                 error = "1202";
/*  322 */                 break; }
/*  323 */               if ((in271RegafiUpdateAfiliado.getNuDocumentoAct().trim().length() != 0) && (in271RegafiUpdateAfiliado.getNuDocumentoAct().length() > 15)) {
/*  324 */                 error = "1212";
/*  325 */                 break; }
/*  326 */               if ((in271RegafiUpdateAfiliado.getApCasadaAfiliado().trim().length() != 0) && (in271RegafiUpdateAfiliado.getApCasadaAfiliado().trim().length() > 50)) {
/*  327 */                 error = "1072";
/*  328 */                 break; }
/*  329 */               if ((in271RegafiUpdateAfiliado.getCoNacionalidad().trim().length() != 0) && ((in271RegafiUpdateAfiliado.getCoNacionalidad().trim().length() < 2) || (in271RegafiUpdateAfiliado.getCoNacionalidad().trim().length() > 3))) {
/*  330 */                 error = "1042";
/*  331 */                 break; }
/*  332 */               if ((in271RegafiUpdateAfiliado.getUbigeo().trim().length() != 0) && (in271RegafiUpdateAfiliado.getUbigeo().trim().length() > 12)) {
/*  333 */                 error = "1102";
/*  334 */                 break; }
/*  335 */               if (in271RegafiUpdateAfiliado.getFeNacimiento().trim().length() != 8) {
/*  336 */                 error = "1092";
/*  337 */                 break; }
/*  338 */               if (in271RegafiUpdateAfiliado.getGenero().trim().length() != 1) {
/*  339 */                 error = "1112";
/*  340 */                 break; }
/*  341 */               if (in271RegafiUpdateAfiliado.getCoPaisDoc().trim().length() != 3) {
/*  342 */                 error = "1012";
/*  343 */                 break; }
/*  344 */               if ((in271RegafiUpdateAfiliado.getFefallecimiento().trim().length() != 0) && (in271RegafiUpdateAfiliado.getFefallecimiento().trim().length() != 8)) {
/*  345 */                 error = "1132";
/*  346 */                 break; }
/*  347 */               if ((in271RegafiUpdateAfiliado.getCoPaisEmisorDocAct().trim().length() != 0) && (in271RegafiUpdateAfiliado.getCoPaisEmisorDocAct().trim().length() > 3)) {
/*  348 */                 error = "1192";
/*  349 */                 break; }
/*  350 */               if ((in271RegafiUpdateAfiliado.getFeActPersonaxIafas().trim().length() != 0) && (in271RegafiUpdateAfiliado.getFeActPersonaxIafas().trim().length() != 8)) {
/*  351 */                 error = "1222";
/*  352 */                 break; }
/*  353 */               if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (in271RegafiUpdateAfiliado.getTiDocTutor().trim().length() != 1)) {
/*  354 */                 error = "1162";
/*  355 */                 break; }
/*  356 */               if ((("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (in271RegafiUpdateAfiliado.getNuDocTutor().trim().length() < 1)) || (in271RegafiUpdateAfiliado.getNuDocTutor().trim().length() > 15))
/*      */               {
/*  358 */                 error = "1172";
/*  359 */                 break; }
/*  360 */               if ((("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (in271RegafiUpdateAfiliado.getTiVinculoTutor().trim().length() < 1)) || (in271RegafiUpdateAfiliado.getTiVinculoTutor().trim().length() > 2))
/*      */               {
/*  362 */                 error = "1182";
/*  363 */                 break; }
/*  364 */               if ((in271RegafiUpdateAfiliado.getFeValidacionReniec().trim().length() != 0) && (in271RegafiUpdateAfiliado.getFeValidacionReniec().trim().length() != 8)) {
/*  365 */                 error = "1142";
/*  366 */                 break; }
/*  367 */               if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (in271RegafiUpdateAfiliado.getCoPaisEmisorDocTutor().trim().length() != 3)) {
/*  368 */                 error = "1152";
/*  369 */                 break;
/*      */               }
/*      */             }
/*      */           }
/*  373 */           if ((in271RegafiUpdate.getDetallesAfiliaciones().size() >= 0) && (error.equals("0000")))
/*      */           {
/*  375 */             listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/*  376 */             In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/*      */             
/*  378 */             for (int i = 0; i < listAfi.size(); i++) {
/*  379 */               in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/*      */               
/*  381 */               int NoContratante = 0;
/*  382 */               int ncontra1;  if (in271RegafiUpdateAfiliacion.getNoContratante1().trim().length() > 0) ncontra1 = in271RegafiUpdateAfiliacion.getNoContratante1().length(); else ncontra1 = 0;
/*  383 */               int ncontra2; if (in271RegafiUpdateAfiliacion.getNoContratante2().trim().length() > 0) ncontra2 = in271RegafiUpdateAfiliacion.getNoContratante2().length(); else ncontra2 = 0;
/*  384 */               int ncontra3;  if (in271RegafiUpdateAfiliacion.getNoContratante3().trim().length() > 0) ncontra3 = in271RegafiUpdateAfiliacion.getNoContratante3().length(); else ncontra3 = 0;
/*  385 */               int ncontra4;  if (in271RegafiUpdateAfiliacion.getNoContratante4().trim().length() > 0) ncontra4 = in271RegafiUpdateAfiliacion.getNoContratante4().length(); else { ncontra4 = 0;
/*      */               }
/*  387 */               NoContratante = ncontra1 + ncontra2 + ncontra3 + ncontra4;
/*      */               
/*  389 */               if (in271RegafiUpdateAfiliacion.getTiDocTitular().trim().length() != 1) {
/*  390 */                 error = "2222";
/*  391 */                 break; }
/*  392 */               if ((in271RegafiUpdateAfiliacion.getNuDocTitular().trim().length() < 1) || (in271RegafiUpdateAfiliacion.getNuDocTitular().trim().length() > 15))
/*      */               {
/*  394 */                 error = "2232";
/*  395 */                 break; }
/*  396 */               if (in271RegafiUpdateAfiliacion.getFeNacimientoTitular().trim().length() != 8) {
/*  397 */                 error = "2242";
/*  398 */                 break; }
/*  399 */               if (in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular().trim().length() != 3) {
/*  400 */                 error = "2212";
/*  401 */                 break; }
/*  402 */               if (in271RegafiUpdateAfiliacion.getTiContratante().trim().length() != 1) {
/*  403 */                 error = "2252";
/*  404 */                 break; }
/*  405 */               if ((in271RegafiUpdateAfiliacion.getApPaternoContratante().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getApPaternoContratante().trim().length() > 50)) {
/*  406 */                 error = "2272";
/*  407 */                 break; }
/*  408 */               if (in271RegafiUpdateAfiliacion.getNoContratante1().trim().length() > 35) {
/*  409 */                 error = "2262";
/*  410 */                 break; }
/*  411 */               if (in271RegafiUpdateAfiliacion.getNoContratante2().trim().length() > 25) {
/*  412 */                 error = "2262";
/*  413 */                 break; }
/*  414 */               if (in271RegafiUpdateAfiliacion.getNoContratante3().trim().length() > 10) {
/*  415 */                 error = "2262";
/*  416 */                 break; }
/*  417 */               if (in271RegafiUpdateAfiliacion.getNoContratante4().trim().length() > 10) {
/*  418 */                 error = "2262";
/*  419 */                 break; }
/*  420 */               if (NoContratante > 80) {
/*  421 */                 error = "2262";
/*  422 */                 break; }
/*  423 */               if ((in271RegafiUpdateAfiliacion.getApMaternoContratante().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getApMaternoContratante().trim().length() > 50)) {
/*  424 */                 error = "2282";
/*  425 */                 break; }
/*  426 */               if (in271RegafiUpdateAfiliacion.getTiDocContratante().trim().length() != 1) {
/*  427 */                 error = "2072";
/*  428 */                 break; }
/*  429 */               if ((in271RegafiUpdateAfiliacion.getNuDocContratante().trim().length() < 1) || (in271RegafiUpdateAfiliacion.getNuDocContratante().trim().length() > 15))
/*      */               {
/*  431 */                 error = "2082";
/*  432 */                 break; }
/*  433 */               if ((in271RegafiUpdateAfiliacion.getApCasadaContratante().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getApCasadaContratante().trim().length() > 50)) {
/*  434 */                 error = "2292";
/*  435 */                 break; }
/*  436 */               if ((in271RegafiUpdateAfiliacion.getFeNacimientoContratante().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getFeNacimientoContratante().trim().length() != 8)) {
/*  437 */                 error = "2302";
/*  438 */                 break; }
/*  439 */               if (in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante().trim().length() != 3) {
/*  440 */                 error = "2062";
/*  441 */                 break; }
/*  442 */               if ((in271RegafiUpdateAfiliacion.getCoAfiliacion().trim().length() < 1) || (in271RegafiUpdateAfiliacion.getCoAfiliacion().trim().length() > 20))
/*      */               {
/*  444 */                 error = "2012";
/*  445 */                 break; }
/*  446 */               if ((in271RegafiUpdateAfiliacion.getCoContrato().trim().length() < 1) || (in271RegafiUpdateAfiliacion.getCoContrato().trim().length() > 30))
/*      */               {
/*  448 */                 error = "2022";
/*  449 */                 break; }
/*  450 */               if ((in271RegafiUpdateAfiliacion.getCoUnicoMultisectorial().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getCoUnicoMultisectorial().trim().length() > 20)) {
/*  451 */                 error = "2092";
/*  452 */                 break; }
/*  453 */               if (in271RegafiUpdateAfiliacion.getTiregimen().trim().length() != 1) {
/*  454 */                 error = "2102";
/*  455 */                 break; }
/*  456 */               if (in271RegafiUpdateAfiliacion.getEsAfiliacion().trim().length() != 1) {
/*  457 */                 error = "2042";
/*  458 */                 break; }
/*  459 */               if ((in271RegafiUpdateAfiliacion.getCoCausalBaja().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getCoCausalBaja().trim().length() > 20)) {
/*  460 */                 error = "2122";
/*  461 */                 break; }
/*  462 */               if (in271RegafiUpdateAfiliacion.getTiPlanSalud().trim().length() != 1) {
/*  463 */                 error = "2132";
/*  464 */                 break; }
/*  465 */               if ((in271RegafiUpdateAfiliacion.getNoProductoSalud().trim().length() < 1) || (in271RegafiUpdateAfiliacion.getNoProductoSalud().trim().length() > 50))
/*      */               {
/*  467 */                 error = "2142";
/*  468 */                 break; }
/*  469 */               if ((in271RegafiUpdateAfiliacion.getCoProducto().trim().length() < 1) || (in271RegafiUpdateAfiliacion.getCoProducto().trim().length() > 20))
/*      */               {
/*  471 */                 error = "2032";
/*  472 */                 break; }
/*  473 */               if ((in271RegafiUpdateAfiliacion.getParentesco().trim().length() < 1) || (in271RegafiUpdateAfiliacion.getParentesco().trim().length() > 2))
/*      */               {
/*  475 */                 error = "2052";
/*  476 */                 break; }
/*  477 */               if ((in271RegafiUpdateAfiliacion.getCoRenipress().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getCoRenipress().trim().length() > 10)) {
/*  478 */                 error = "2202";
/*  479 */                 break; }
/*  480 */               //if ((in271RegafiUpdateAfiliacion.getPkAfiliado().trim().length() < 12) || (in271RegafiUpdateAfiliacion.getPkAfiliado().trim().length() > 19))
                         if ((in271RegafiUpdateAfiliacion.getPkAfiliado().trim().length() < 11) || (in271RegafiUpdateAfiliacion.getPkAfiliado().trim().length() > 19))
/*      */               {
/*  482 */                 error = "1002";
/*  483 */                 break; }
/*  484 */               if ((in271RegafiUpdateAfiliacion.getFeActEstado().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getFeActEstado().trim().length() != 8)) {
/*  485 */                 error = "2112";
/*  486 */                 break; }
/*  487 */               if (in271RegafiUpdateAfiliacion.getFeIniAfiliacion().trim().length() != 8) {
/*  488 */                 error = "2152";
/*  489 */                 break; }
/*  490 */               if ((in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim().length() != 8)) {
/*  491 */                 error = "2162";
/*  492 */                 break; }
/*  493 */               if ((in271RegafiUpdateAfiliacion.getFeIniCobertura().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getFeIniCobertura().trim().length() != 8)) {
/*  494 */                 error = "2172";
/*  495 */                 break; }
/*  496 */               if ((in271RegafiUpdateAfiliacion.getFeFinCobertura().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getFeFinCobertura().trim().length() != 8)) {
/*  497 */                 error = "2182";
/*  498 */                 break; }
/*  499 */               if ((in271RegafiUpdateAfiliacion.getFeActOperacion().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getFeActOperacion().trim().length() != 8)) {
/*  500 */                 error = "2312";
/*  501 */                 break; }
/*  502 */               if ((in271RegafiUpdateAfiliacion.getTiActOperacion().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getTiActOperacion().trim().length() > 6)) {
/*  503 */                 error = "2322";
/*  504 */                 break; }
/*  505 */               if ((in271RegafiUpdateAfiliacion.getCoTiCobertura().trim().length() != 0) && (in271RegafiUpdateAfiliacion.getCoTiCobertura().trim().length() > 1)) {
/*  506 */                 error = "2192";
/*  507 */                 break;
/*      */               }
/*      */             }
/*      */           }
/*      */         }
/*  512 */         if (error.equals("0000")) {
/*  513 */           if (ManagerUtil.validaNombreTx(in271RegafiUpdate.getNoTransaccion()) != '0') {
/*  514 */             error = "0013";
/*  515 */           } else if (ManagerUtil.validaAlfanumerico(in271RegafiUpdate.getIdRemitente()) != '0') {
/*  516 */             error = "0023";
/*  517 */           } else if (ManagerUtil.validaAlfanumerico(in271RegafiUpdate.getIdReceptor()) != '0') {
/*  518 */             error = "0033";
/*  519 */           } else if ((ManagerUtil.validaSoloDigito(in271RegafiUpdate.getFeTransaccion()) != '0') || (in271RegafiUpdate.getFeTransaccion().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdate.getFeTransaccion()) != true))
/*      */           {
/*      */ 
/*  522 */             error = "0043";
/*  523 */           } else if (ManagerUtil.validaSoloDigito(in271RegafiUpdate.getHoTransaccion()) != '0') {
/*  524 */             error = "0053";
/*  525 */           } else if (ManagerUtil.validaSoloDigito(in271RegafiUpdate.getIdCorrelativo()) != '0') {
/*  526 */             error = "0063";
/*  527 */           } else if (ManagerUtil.validaSoloDigito(in271RegafiUpdate.getIdTransaccion()) != '0') {
/*  528 */             error = "0073";
/*  529 */           } else if (ManagerUtil.validaSoloDigito(in271RegafiUpdate.getTiFinalidad()) != '0') {
/*  530 */             error = "0083";
/*  531 */           } else if (ManagerUtil.validaSoloDigito(in271RegafiUpdate.getCaRemitente()) != '0') {
/*  532 */             error = "0093";
/*  533 */           } else if (ManagerUtil.validaAlfanumerico(in271RegafiUpdate.getTiOperacion()) != '0') {
/*  534 */             error = "0103";
/*      */ 
/*      */           }
/*  537 */           else if ((in271RegafiUpdate.getDetallesAfiliados().size() >= 0) && (error.equals("0000"))) {
/*  538 */             listPer = in271RegafiUpdate.getDetallesAfiliados();
/*  539 */             In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();
/*      */             
/*  541 */             for (int i = 0; i < listPer.size(); i++) {
/*  542 */               in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/*      */               
/*  544 */               if (((!"".equals(in271RegafiUpdateAfiliado.getApPaternoAfiliado().trim())) || (in271RegafiUpdateAfiliado.getApPaternoAfiliado() != null)) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliado.getApPaternoAfiliado()) != '0')) {
/*  545 */                 error = "1053";
/*  546 */                 break; }
/*  547 */               if (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliado.getNoAfiliado1()) != '0') {
/*  548 */                 error = "1083";
/*  549 */                 break; }
/*  550 */               if ((in271RegafiUpdateAfiliado.getNoAfiliado2().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliado.getNoAfiliado2()) != '0')) {
/*  551 */                 error = "1083";
/*  552 */                 break; }
/*  553 */               if ((in271RegafiUpdateAfiliado.getApMaternoAfiliado().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliado.getApMaternoAfiliado()) != '0')) {
/*  554 */                 error = "1063";
/*  555 */                 break; }
/*  556 */               if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getTiDocumentoAfil()) != '0') {
/*  557 */                 error = "1023";
/*  558 */                 break; }
/*  559 */               if ((!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliado.getNuDocumentoAfil()) != '0')) {
/*  560 */                 error = "1033";
/*  561 */                 break; }
/*  562 */               if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getEstadoAfiliado()) != '0') {
/*  563 */                 error = "1123";
/*  564 */                 break; }
/*  565 */               if ((in271RegafiUpdateAfiliado.getTiDocumentoAct().trim().length() != 0) && (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getTiDocumentoAct()) != '0')) {
/*  566 */                 error = "1203";
/*  567 */                 break; }
/*  568 */               if ((in271RegafiUpdateAfiliado.getNuDocumentoAct().trim().length() != 0) && (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliado.getNuDocumentoAct()) != '0')) {
/*  569 */                 error = "1213";
/*  570 */                 break; }
/*  571 */               if ((in271RegafiUpdateAfiliado.getApCasadaAfiliado().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliado.getApCasadaAfiliado()) != '0')) {
/*  572 */                 error = "1073";
/*  573 */                 break; }
/*  574 */               if ((in271RegafiUpdateAfiliado.getCoNacionalidad().trim().length() != 0) && (ManagerUtil.validaCaracterPalabra(in271RegafiUpdateAfiliado.getCoNacionalidad()) != '0')) {
/*  575 */                 error = "1043";
/*  576 */                 break; }
/*  577 */               if ((in271RegafiUpdateAfiliado.getUbigeo().trim().length() != 0) && (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getUbigeo()) != '0')) {
/*  578 */                 error = "1103";
/*  579 */                 break; }
/*  580 */               if ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getFeNacimiento()) != '0') || (in271RegafiUpdateAfiliado.getFeNacimiento().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliado.getFeNacimiento()) != true))
/*      */               {
/*      */ 
/*  583 */                 error = "1093";
/*  584 */                 break; }
/*  585 */               if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getGenero()) != '0') {
/*  586 */                 error = "1113";
/*  587 */                 break; }
/*  588 */               if (ManagerUtil.validaCaracterPalabra(in271RegafiUpdateAfiliado.getCoPaisDoc()) != '0') {
/*  589 */                 error = "1013";
/*  590 */                 break; }
/*  591 */               if ((in271RegafiUpdateAfiliado.getFefallecimiento().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getFefallecimiento()) != '0') || (in271RegafiUpdateAfiliado.getFefallecimiento().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliado.getFefallecimiento()) != true)))
/*      */               {
/*      */ 
/*  594 */                 error = "1133";
/*  595 */                 break; }
/*  596 */               if ((in271RegafiUpdateAfiliado.getCoPaisEmisorDocAct().trim().length() != 0) && (ManagerUtil.validaCaracterPalabra(in271RegafiUpdateAfiliado.getCoPaisEmisorDocAct()) != '0')) {
/*  597 */                 error = "1193";
/*  598 */                 break; }
/*  599 */               if ((in271RegafiUpdateAfiliado.getFeActPersonaxIafas().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getFeActPersonaxIafas()) != '0') || (in271RegafiUpdateAfiliado.getFeActPersonaxIafas().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliado.getFeActPersonaxIafas()) != true)))
/*      */               {
/*      */ 
/*  602 */                 error = "1223";
/*  603 */                 break; }
/*  604 */               if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getTiDocTutor()) != '0')) {
/*  605 */                 error = "1163";
/*  606 */                 break; }
/*  607 */               if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliado.getNuDocTutor()) != '0')) {
/*  608 */                 error = "1173";
/*  609 */                 break; }
/*  610 */               if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getTiVinculoTutor()) != '0')) {
/*  611 */                 error = "1183";
/*  612 */                 break; }
/*  613 */               if ((in271RegafiUpdateAfiliado.getFeValidacionReniec().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliado.getFeValidacionReniec()) != '0') || (in271RegafiUpdateAfiliado.getFeValidacionReniec().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliado.getFeValidacionReniec()) != true)))
/*      */               {
/*      */ 
/*  616 */                 error = "1143";
/*  617 */                 break; }
/*  618 */               if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (ManagerUtil.validaCaracterPalabra(in271RegafiUpdateAfiliado.getCoPaisEmisorDocTutor()) != '0')) {
/*  619 */                 error = "1153";
/*  620 */                 break;
/*      */               }
/*      */             }
/*      */           }
/*  624 */           if ((in271RegafiUpdate.getDetallesAfiliaciones().size() >= 0) && (error.equals("0000")))
/*      */           {
/*  626 */             listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/*  627 */             In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/*      */             
/*  629 */             for (int i = 0; i < listAfi.size(); i++) {
/*  630 */               in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/*      */               
/*  632 */               if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getTiDocTitular()) != '0') {
/*  633 */                 error = "2223";
/*  634 */                 break; }
/*  635 */               if (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getNuDocTitular()) != '0') {
/*  636 */                 error = "2233";
/*  637 */                 break; }
/*  638 */               if ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeNacimientoTitular()) != '0') || (in271RegafiUpdateAfiliacion.getFeNacimientoTitular().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeNacimientoTitular()) != true))
/*      */               {
/*      */ 
/*  641 */                 error = "2243";
/*  642 */                 break; }
/*  643 */               if (ManagerUtil.validaCaracterPalabra(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular()) != '0') {
/*  644 */                 error = "2213";
/*  645 */                 break; }
/*  646 */               if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getTiContratante()) != '0') {
/*  647 */                 error = "2253";
/*  648 */                 break; }
/*  649 */               if ((in271RegafiUpdateAfiliacion.getApPaternoContratante().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getApPaternoContratante()) != '0')) {
/*  650 */                 error = "2273";
/*  651 */                 break; }
/*  652 */               if ((in271RegafiUpdateAfiliacion.getNoContratante1().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getNoContratante1()) != '0')) {
/*  653 */                 error = "2263";
/*  654 */                 break; }
/*  655 */               if ((in271RegafiUpdateAfiliacion.getNoContratante2().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getNoContratante2()) != '0')) {
/*  656 */                 error = "2263";
/*  657 */                 break; }
/*  658 */               if ((in271RegafiUpdateAfiliacion.getNoContratante3().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getNoContratante3()) != '0')) {
/*  659 */                 error = "2263";
/*  660 */                 break; }
/*  661 */               if ((in271RegafiUpdateAfiliacion.getNoContratante4().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getNoContratante4()) != '0')) {
/*  662 */                 error = "2263";
/*  663 */                 break; }
/*  664 */               if ((in271RegafiUpdateAfiliacion.getApMaternoContratante().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getApMaternoContratante()) != '0')) {
/*  665 */                 error = "2283";
/*  666 */                 break; }
/*  667 */               if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getTiDocContratante()) != '0') {
/*  668 */                 error = "2073";
/*  669 */                 break; }
/*  670 */               if (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getNuDocContratante()) != '0') {
/*  671 */                 error = "2083";
/*  672 */                 break; }
/*  673 */               if ((in271RegafiUpdateAfiliacion.getApCasadaContratante().trim().length() != 0) && (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getApCasadaContratante()) != '0')) {
/*  674 */                 error = "2293";
/*  675 */                 break; }
/*  676 */               if ((in271RegafiUpdateAfiliacion.getFeNacimientoContratante().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeNacimientoContratante()) != '0') || (in271RegafiUpdateAfiliacion.getFeNacimientoContratante().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeNacimientoContratante()) != true)))
/*      */               {
/*      */ 
/*  679 */                 error = "2303";
/*  680 */                 break; }
/*  681 */               if (ManagerUtil.validaCaracterPalabra(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante()) != '0') {
/*  682 */                 error = "2063";
/*  683 */                 break; }
/*  684 */               if (ManagerUtil.validaAlfanumericoGuion(in271RegafiUpdateAfiliacion.getCoAfiliacion()) != '0') {
/*  685 */                 error = "2013";
/*  686 */                 break; }
/*  687 */               if (ManagerUtil.validaAlfanumericoGuion(in271RegafiUpdateAfiliacion.getCoContrato()) != '0') {
/*  688 */                 error = "2023";
/*  689 */                 break; }
/*  690 */               if ((in271RegafiUpdateAfiliacion.getCoUnicoMultisectorial().trim().length() != 0) && (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getCoUnicoMultisectorial()) != '0')) {
/*  691 */                 error = "2093";
/*  692 */                 break; }
/*  693 */               if (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getTiregimen()) != '0') {
/*  694 */                 error = "2103";
/*  695 */                 break; }
/*  696 */               if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getEsAfiliacion()) != '0') {
/*  697 */                 error = "2043";
/*  698 */                 break; }
/*  699 */               if ((in271RegafiUpdateAfiliacion.getCoCausalBaja().trim().length() != 0) && (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getCoCausalBaja()) != '0')) {
/*  700 */                 error = "2123";
/*  701 */                 break; }
/*  702 */               if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getTiPlanSalud()) != '0') {
/*  703 */                 error = "2133";
/*  704 */                 break; }
/*  705 */               if (ManagerUtil.validaAN_caracteres(in271RegafiUpdateAfiliacion.getNoProductoSalud()) != '0') {
/*  706 */                 error = "2143";
/*  707 */                 break; }
/*  708 */               if (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getCoProducto()) != '0') {
/*  709 */                 error = "2033";
/*  710 */                 break; }
/*  711 */               if (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getParentesco()) != '0') {
/*  712 */                 error = "2053";
/*  713 */                 break; }
/*  714 */               if ((in271RegafiUpdateAfiliacion.getCoRenipress().trim().length() != 0) && (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getCoRenipress()) != '0')) {
/*  715 */                 error = "2203";
/*  716 */                 break; }
/*  717 */               if (ManagerUtil.validaAlfanumerico(in271RegafiUpdateAfiliacion.getPkAfiliado()) != '0') {
/*  718 */                 error = "1003";
/*  719 */                 break; }
/*  720 */               if ((in271RegafiUpdateAfiliacion.getFeActEstado().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeActEstado()) != '0') || (in271RegafiUpdateAfiliacion.getFeActEstado().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeActEstado()) != true)))
/*      */               {
/*      */ 
/*  723 */                 error = "2113";
/*  724 */                 break; }
/*  725 */               if ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeIniAfiliacion()) != '0') || (in271RegafiUpdateAfiliacion.getFeIniAfiliacion().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeIniAfiliacion()) != true))
/*      */               {
/*      */ 
/*  728 */                 error = "2153";
/*  729 */                 break; }
/*  730 */               if ((in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeFinAfiliacion()) != '0') || (in271RegafiUpdateAfiliacion.getFeFinAfiliacion().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeFinAfiliacion()) != true)))
/*      */               {
/*      */ 
/*  733 */                 error = "2163";
/*  734 */                 break; }
/*  735 */               if ((in271RegafiUpdateAfiliacion.getFeIniCobertura().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeIniCobertura()) != '0') || (in271RegafiUpdateAfiliacion.getFeIniCobertura().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeIniCobertura()) != true)))
/*      */               {
/*      */ 
/*  738 */                 error = "2173";
/*  739 */                 break; }
/*  740 */               if ((in271RegafiUpdateAfiliacion.getFeFinCobertura().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeFinCobertura()) != '0') || (in271RegafiUpdateAfiliacion.getFeFinCobertura().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeFinCobertura()) != true)))
/*      */               {
/*      */ 
/*  743 */                 error = "2183";
/*  744 */                 break; }
/*  745 */               if ((in271RegafiUpdateAfiliacion.getFeActOperacion().trim().length() != 0) && ((ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getFeActOperacion()) != '0') || (in271RegafiUpdateAfiliacion.getFeActOperacion().equals("00000000")) || (ManagerUtil.validaFechaValores(in271RegafiUpdateAfiliacion.getFeActOperacion()) != true)))
/*      */               {
/*      */ 
/*  748 */                 error = "2313";
/*  749 */                 break; }
/*  750 */               if ((in271RegafiUpdateAfiliacion.getTiActOperacion().trim().length() != 0) && (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getTiActOperacion()) != '0')) {
/*  751 */                 error = "2323";
/*  752 */                 break; }
/*  753 */               if ((in271RegafiUpdateAfiliacion.getCoTiCobertura().trim().length() != 0) && (ManagerUtil.validaSoloDigito(in271RegafiUpdateAfiliacion.getCoTiCobertura()) != '0')) {
/*  754 */                 error = "2193";
/*  755 */                 break;
/*      */               }
/*      */             }
/*      */           }
/*      */         }
/*  760 */         if (error.equals("0000"))
/*      */         {
/*  762 */           if (in271RegafiUpdate.getDetallesAfiliados().size() >= 0) {
/*  763 */             listPer = in271RegafiUpdate.getDetallesAfiliados();
/*  764 */             In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();
/*      */             
/*  766 */             for (int i = 0; i < listPer.size(); i++) {
/*  767 */               in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/*      */               
/*  769 */               if ("PER".equals(in271RegafiUpdateAfiliado.getCoPaisDoc().trim())) {
/*  770 */                 if ((!"1".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"2".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"5".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"6".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"8".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())))
/*      */                 {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  776 */                   error = "1024(1)";
/*  777 */                   break;
/*      */                 }
/*  779 */               } else if ((!"PER".equals(in271RegafiUpdateAfiliado.getCoPaisDoc().trim())) && (!"2".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && 
/*  780 */                 (!"3".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"4".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())))
/*      */               {
/*      */ 
/*  783 */                 error = "1024(2)";
/*  784 */                 break;
/*      */               }
/*  786 */               if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && ("PER".equals(in271RegafiUpdateAfiliado.getCoPaisEmisorDocTutor().trim()))) {
/*  787 */                 if ((!"1".equals(in271RegafiUpdateAfiliado.getTiDocTutor().trim())) && (!"2".equals(in271RegafiUpdateAfiliado.getTiDocTutor().trim())))
/*      */                 {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  794 */                   error = "1164";
/*  795 */                   break;
/*      */                 }
/*  797 */               } else if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && (!"PER".equals(in271RegafiUpdateAfiliado.getCoPaisEmisorDocTutor().trim())) && 
/*  798 */                 (!"3".equals(in271RegafiUpdateAfiliado.getTiDocTutor().trim())) && (!"4".equals(in271RegafiUpdateAfiliado.getTiDocTutor().trim())))
/*      */               {
/*      */ 
/*      */ 
/*  802 */                 error = "1164";
/*  803 */                 break;
/*      */               }
/*      */             }
/*      */           }
/*      */           
/*  808 */           if ((in271RegafiUpdate.getDetallesAfiliaciones().size() >= 0) && (error.equals("0000")))
/*      */           {
/*  810 */             listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/*  811 */             In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/*      */             
/*  813 */             for (int i = 0; i < listAfi.size(); i++) {
/*  814 */               in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/*      */               
///*  816 */               if ("PER".equals(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular().trim())) {
///*  817 */                 if ((!"1".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"2".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"5".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"6".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"7".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"8".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())))
///*      */                 {
///*      */ 
///*      */ 
///*      */ 
///*      */ 
///*  823 */                   error = "2224";
///*  824 */                   break;
///*      */                 }
///*  826 */               } else if ((!"PER".equals(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocTitular().trim())) && 
///*  827 */                 (!"2".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"3".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"4".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && (!"7".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())))
///*      */               {
///*      */                  System.out.println("Aqui222222222222222");
///*  830 */                 error = "2224";
///*  831 */                 break;
///*      */               }
/*  833 */               if ("PER".equals(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante().trim())) {
/*  834 */                 if ((!"1".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())) && (!"2".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())) && (!"8".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())) && (!"9".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())))
/*      */                 {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  840 */                   error = "2074";
/*  841 */                   break;
/*      */                 }
/*  843 */               } else if (!"PER".equals(in271RegafiUpdateAfiliacion.getCoPaisEmisorDocContratante().trim()))
/*      */               {
/*      */ 
/*      */ 
/*  847 */                 error = "2074";
/*  848 */                 break;
/*      */               }
/*      */             }
/*      */           }
/*      */         }
/*      */         
/*      */ 
/*  855 */         if ((in271RegafiUpdate.getDetallesAfiliados().size() >= 0) && (error.equals("0000"))) {
/*  856 */           listPer = in271RegafiUpdate.getDetallesAfiliados();
/*  857 */           In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();
/*      */           
/*  859 */           for (int i = 0; i < listPer.size(); i++) {
/*  860 */             in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/*      */             
/*  862 */             if ((!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && ("1".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim()))) {
/*  863 */               if (in271RegafiUpdateAfiliado.getNuDocumentoAfil().trim().length() != 8) {
/*  864 */                 error = "1035";
/*  865 */                 break;
/*      */               }
/*  867 */             } else if ((!"7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && ("8".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && 
/*  868 */               (in271RegafiUpdateAfiliado.getNuDocumentoAfil().trim().length() != 11)) {
/*  869 */               error = "1035";
/*  870 */               break;
/*      */             }
/*      */             
/*  873 */             if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && ("1".equals(in271RegafiUpdateAfiliado.getTiDocTutor().trim()))) {
/*  874 */               if (in271RegafiUpdateAfiliado.getNuDocTutor().trim().length() != 8) {
/*  875 */                 error = "1175";
/*  876 */                 break;
/*      */               }
/*  878 */             } else if (("7".equals(in271RegafiUpdateAfiliado.getTiDocumentoAfil().trim())) && ("8".equals(in271RegafiUpdateAfiliado.getTiDocTutor().trim())) && 
/*  879 */               (in271RegafiUpdateAfiliado.getNuDocTutor().trim().length() != 11)) {
/*  880 */               error = "1175";
/*  881 */               break;
/*      */             }
/*      */             
/*  884 */             if ((!"0".equals(in271RegafiUpdateAfiliado.getIdAfiliadoNombre().trim())) && (!"1".equals(in271RegafiUpdateAfiliado.getIdAfiliadoNombre().trim()))) {
/*  885 */               error = "00039";
/*  886 */               break;
/*      */             }
/*      */           }
/*      */         }
/*  890 */         if ((in271RegafiUpdate.getDetallesAfiliaciones().size() >= 0) && (error.equals("0000")))
/*      */         {
/*  892 */           listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/*  893 */           In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/*      */           
/*  895 */           for (int i = 0; i < listAfi.size(); i++) {
/*  896 */             in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/*      */             
/*  898 */             if ("1".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) {
/*  899 */               if (in271RegafiUpdateAfiliacion.getNuDocTitular().trim().length() != 8) {
/*  900 */                 error = "2235";
/*  901 */                 break;
/*      */               }
/*  903 */             } else if (("8".equals(in271RegafiUpdateAfiliacion.getTiDocTitular().trim())) && 
/*  904 */               (in271RegafiUpdateAfiliacion.getNuDocTitular().trim().length() != 11)) {
/*  905 */               error = "2235";
/*  906 */               break;
/*      */             }
/*  908 */             if ("1".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())) {
/*  909 */               if (in271RegafiUpdateAfiliacion.getNuDocContratante().trim().length() != 8) {
/*  910 */                 error = "2085";
/*  911 */                 break;
/*      */               }
/*  913 */             } else if (("8".equals(in271RegafiUpdateAfiliacion.getTiDocContratante().trim())) && 
/*  914 */               (in271RegafiUpdateAfiliacion.getNuDocContratante().trim().length() != 11)) {
/*  915 */               error = "2085";
/*  916 */               break;
/*      */             }
/*      */             
/*  919 */             if ((!"000".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"001".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"011".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"010".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"101".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"111".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"100".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())) && (!"110".equals(in271RegafiUpdateAfiliacion.getIdAfiliacionNombre().trim())))
/*      */             {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  930 */               error = "00040";
/*  931 */               break;
/*      */             }
/*      */           }
/*      */         }
/*      */         
/*      */ 
/*  937 */         if ((in271RegafiUpdate.getDetallesAfiliados().size() >= 0) && (error.equals("0000"))) {
/*  938 */           listPer = in271RegafiUpdate.getDetallesAfiliados();
/*  939 */           In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();
/*  940 */           String feReniec = "";String feActualiza = "";String sError = "00";
/*      */           
/*  942 */           for (int i = 0; i < listPer.size(); i++) {
/*  943 */             in271RegafiUpdateAfiliado = (In271RegafiUpdateAfiliado)listPer.get(i);
/*  944 */             if ((in271RegafiUpdateAfiliado.getFeValidacionReniec().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliado.getFeValidacionReniec().trim())))
/*      */             {
/*  946 */               feReniec = in271RegafiUpdateAfiliado.getFeValidacionReniec();
/*      */             }
/*      */             else {
/*  949 */               sError = "01";
/*      */             }
/*      */           }
/*  952 */           listAfi = in271RegafiUpdate.getDetallesAfiliaciones();
/*  953 */           In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();
/*  954 */           for (int i = 0; i < listAfi.size(); i++) {
/*  955 */             in271RegafiUpdateAfiliacion = (In271RegafiUpdateAfiliacion)listAfi.get(i);
/*  956 */             if ((in271RegafiUpdateAfiliacion.getFeActOperacion().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliacion.getFeActOperacion().trim())))
/*      */             {
/*  958 */               feActualiza = in271RegafiUpdateAfiliacion.getFeActOperacion();
/*      */             } else {
/*  960 */               sError = "02";
/*      */             }
/*      */             
/*  963 */             if ((in271RegafiUpdateAfiliacion.getFeIniAfiliacion().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliacion.getFeIniAfiliacion().trim())) && (in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim())))
/*      */             {
/*      */ 
/*      */ 
/*  967 */               if (Integer.parseInt(in271RegafiUpdateAfiliacion.getFeIniAfiliacion().trim()) > Integer.parseInt(in271RegafiUpdateAfiliacion.getFeFinAfiliacion().trim())) {
/*  968 */                 error = "80028";
/*      */               }
/*      */             }
/*      */             
/*  972 */             if ((in271RegafiUpdateAfiliacion.getFeIniCobertura().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliacion.getFeIniCobertura().trim())) && (in271RegafiUpdateAfiliacion.getFeFinCobertura().trim().length() == 8) && (!"00000000".equals(in271RegafiUpdateAfiliacion.getFeFinCobertura().trim())))
/*      */             {
/*      */ 
/*      */ 
/*  976 */               if (Integer.parseInt(in271RegafiUpdateAfiliacion.getFeIniCobertura().trim()) > Integer.parseInt(in271RegafiUpdateAfiliacion.getFeFinCobertura().trim())) {
/*  977 */                 error = "90028";
/*      */               }
/*      */             }
/*      */           }
/*  981 */           if ((sError.equals("00")) && 
/*  982 */             (Integer.parseInt(feReniec) > Integer.parseInt(feActualiza))) {
/*  983 */             error = "70043";
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*  988 */       else if (tiOperacion.trim().equalsIgnoreCase("01")) {
/*  989 */         RegafiUpdate271_01Validador validador_01 = new RegafiUpdate271_01Validador();
/*  990 */         validador_01.ValidateBeanInRegafiUpdate271(in271RegafiUpdate);
/*  991 */       } else if (tiOperacion.trim().equalsIgnoreCase("10")) {
/*  992 */         RegafiUpdate271_10Validador validador_10 = new RegafiUpdate271_10Validador();
/*  993 */         validador_10.ValidateBeanInRegafiUpdate271(in271RegafiUpdate);
/*  994 */       } else if (tiOperacion.trim().equalsIgnoreCase("11")) {
/*  995 */         RegafiUpdate271_11Validador validador_11 = new RegafiUpdate271_11Validador();
/*  996 */         validador_11.ValidateBeanInRegafiUpdate271(in271RegafiUpdate);
/*  997 */       } else if (tiOperacion.trim().equalsIgnoreCase("12")) {
/*  998 */         RegafiUpdate271_12Validador validador_12 = new RegafiUpdate271_12Validador();
/*  999 */         validador_12.ValidateBeanInRegafiUpdate271(in271RegafiUpdate);
/* 1000 */       } else if (tiOperacion.trim().equalsIgnoreCase("20")) {
/* 1001 */         RegafiUpdate271_20Validador validador_20 = new RegafiUpdate271_20Validador();
/* 1002 */         validador_20.ValidateBeanInRegafiUpdate271(in271RegafiUpdate);
/* 1003 */       } else if (tiOperacion.trim().equalsIgnoreCase("21")) {
                    // System.out.println("aaaaa 1 ");
/* 1004 */         RegafiUpdate271_21Validador validador_21 = new RegafiUpdate271_21Validador();
/* 1005 */         validador_21.ValidateBeanInRegafiUpdate271(in271RegafiUpdate);
                   System.out.println("aaaaa 1 ");
/* 1006 */       } else if ((!"".equals(in271RegafiUpdate.getTiOperacion())) || (in271RegafiUpdate.getTiOperacion() != null)) {
/* 1007 */         error = "0101";
/* 1008 */         in271RegafiUpdate.setCoError(error);
/*      */       }
/*      */     }
/* 1011 */     if (in271RegafiUpdate.getTiOperacion().equals("00")) {
/* 1012 */       in271RegafiUpdate.setCoError(error);
/*      */     }
/* 1014 */     if (in271RegafiUpdate.getCoError() != null) {
/* 1015 */       error = in271RegafiUpdate.getCoError();
/*      */     }
/* 1017 */     return error;
/*      */   }
/*      */ }


/* Location:              D:\WorkSpace\Desarrollo Afiliacion On Linea\Fuentes\FebanAfiliacionesFH\lib\jr-afiliacion-susalud_v1.5.jar!\pe\gob\susalud\jr\transaccion\susalud\validator\RegafiUpdate271_00Validador.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
