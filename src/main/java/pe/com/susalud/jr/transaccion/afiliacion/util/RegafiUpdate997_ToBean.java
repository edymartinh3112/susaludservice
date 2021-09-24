/*     */ package pe.com.susalud.jr.transaccion.afiliacion.util;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;

		import pe.com.susalud.jr.transaccion.afiliacion.bean.In997RegafiUpdate;
		import pe.com.susalud.jr.transaccion.afiliacion.bean.In997RegafiUpdateExcepcion;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.bean.In997RegafiUpdate;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.bean.In997RegafiUpdateExcepcion;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RegafiUpdate997_ToBean
/*     */ {
/*  14 */   private static Boolean flagISA = Boolean.valueOf(true);
/*  15 */   private static Boolean flaGS = Boolean.valueOf(true);
/*  16 */   private static Boolean flagST = Boolean.valueOf(true);
/*  17 */   private static Boolean flagAK4 = Boolean.valueOf(true);
/*  18 */   private static Boolean flagAK2 = Boolean.valueOf(true);
/*  19 */   private static Boolean flagAK3 = Boolean.valueOf(true);
/*     */   
/*     */   public In997RegafiUpdate traducirEstructura997RegafiUpdate(String cadena) {
/*  22 */     flagISA = Boolean.valueOf(true);
/*  23 */     flaGS = Boolean.valueOf(true);
/*  24 */     flagST = Boolean.valueOf(true);
/*  25 */     flagAK4 = Boolean.valueOf(true);
/*  26 */     flagAK2 = Boolean.valueOf(true);
/*  27 */     flagAK3 = Boolean.valueOf(true);
/*     */     
/*  29 */     In997RegafiUpdate in997ResAut = new In997RegafiUpdate();
/*  30 */     String[] arrayCadena = cadena.split("\\~");
/*     */     
/*  32 */     for (String s2 : arrayCadena) {
/*  33 */       String dataCadena = s2;
/*  34 */       String[] s1 = dataCadena.split("\\*");
/*     */       
/*  36 */       if (s1[0].trim().equals("ISA")) {
/*  37 */         if (flagISA.booleanValue()) {
/*  38 */           cargarCamposISA(s1, in997ResAut);
/*     */         }
/*  40 */       } else if (s1[0].trim().equals("GS")) {
/*  41 */         if (flaGS.booleanValue()) {
/*  42 */           cargarCamposGS(s1, in997ResAut);
/*     */         }
/*  44 */       } else if (s1[0].trim().equals("ST")) {
/*  45 */         if (flagST.booleanValue()) {
/*  46 */           cargarCamposST(s1, in997ResAut);
/*     */         }
/*  48 */       } else if (s1[0].trim().equals("AK2")) {
/*  49 */         if (flagAK2.booleanValue()) {
/*  50 */           cargarCamposAK2(s1, in997ResAut);
/*     */         }
/*  52 */       } else if (s1[0].trim().equals("AK3")) {
/*  53 */         if (flagAK3.booleanValue()) {
/*  54 */           cargarCamposAK3(s1, in997ResAut);
/*     */         }
/*  56 */       } else if ((s1[0].trim().equals("AK4")) && 
/*  57 */         (flagAK4.booleanValue())) {
/*  58 */         cargarCamposAK4(s1, in997ResAut);
/*     */       }
/*     */     }
/*     */     
/*  62 */     return in997ResAut;
/*     */   }
/*     */   
/*     */   private static In997RegafiUpdate cargarCamposISA(String[] s1, In997RegafiUpdate arrayCadena) {
/*  66 */     arrayCadena.setNoTransaccion("997_REGAFI_UPDATE");
/*  67 */     if (!"".equals(s1[6].trim())) arrayCadena.setIdRemitente(s1[6]);
/*  68 */     if (!"".equals(s1[8].trim())) { arrayCadena.setIdReceptor(s1[8]);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  73 */     flagISA = Boolean.valueOf(false);
/*  74 */     return arrayCadena;
/*     */   }
/*     */   
/*     */   private static In997RegafiUpdate cargarCamposGS(String[] s1, In997RegafiUpdate arrayCadena) {
/*  78 */     if (!"".equals(s1[4].trim())) arrayCadena.setFeTransaccion(s1[4]);
/*  79 */     if (!"".equals(s1[5].trim())) { arrayCadena.setHoTransaccion(s1[5]);
/*     */     }
/*     */     
/*  82 */     flaGS = Boolean.valueOf(false);
/*  83 */     return arrayCadena;
/*     */   }
/*     */   
/*     */   private static In997RegafiUpdate cargarCamposST(String[] s1, In997RegafiUpdate arrayCadena) {
/*  87 */     if (!"".equals(s1[1].trim())) arrayCadena.setIdTransaccion(s1[1]);
/*  88 */     if (!"".equals(s1[2].trim())) { arrayCadena.setExcProceso(s1[3]);
/*     */     }
/*  90 */     flagST = Boolean.valueOf(false);
/*  91 */     return arrayCadena;
/*     */   }
/*     */   
/*     */   private static In997RegafiUpdate cargarCamposAK2(String[] s1, In997RegafiUpdate arrayCadena) {
/*  95 */     if (!"".equals(s1[2].trim())) { arrayCadena.setIdCorrelativo(s1[2]);
/*     */     }
/*  97 */     return arrayCadena;
/*     */   }
/*     */   
/*     */   private static In997RegafiUpdate cargarCamposAK3(String[] s1, In997RegafiUpdate arrayCadena) {
/* 101 */     In997RegafiUpdateExcepcion detalle = new In997RegafiUpdateExcepcion();
/* 102 */     if (!"".equals(s1[1].trim())) { detalle.setExcBD(s1[2]);
/*     */     }
/* 104 */     arrayCadena.addDetalle(detalle);
/* 105 */     return arrayCadena;
/*     */   }
/*     */   
/*     */   private static In997RegafiUpdate cargarCamposAK4(String[] s1, In997RegafiUpdate arrayCadena)
/*     */   {
/* 110 */     if (!"".equals(s1[1].trim())) ((In997RegafiUpdateExcepcion)arrayCadena.getDetallesExcepcion().get(arrayCadena.getDetallesExcepcion().size() - 1)).setCoCampoErr(s1[1]);
/* 111 */     if (!"".equals(s1[2].trim())) ((In997RegafiUpdateExcepcion)arrayCadena.getDetallesExcepcion().get(arrayCadena.getDetallesExcepcion().size() - 1)).setInCoErrorEncontrado(s1[2]);
/* 112 */     if (!"".equals(s1[3].trim())) ((In997RegafiUpdateExcepcion)arrayCadena.getDetallesExcepcion().get(arrayCadena.getDetallesExcepcion().size() - 1)).setPkAfiliado(s1[3]);
/* 113 */     if (!"".equals(s1[4].trim())) { ((In997RegafiUpdateExcepcion)arrayCadena.getDetallesExcepcion().get(arrayCadena.getDetallesExcepcion().size() - 1)).setPkAfiliadopkAfiliacion(s1[4]);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 118 */     return arrayCadena;
/*     */   }
/*     */   
/*     */   private void Limpiarbean(In997RegafiUpdate in997ResAut)
/*     */   {
/* 123 */     ArrayList thisArrayList = new ArrayList();
/*     */     
/* 125 */     thisArrayList.add(in997ResAut.getNoTransaccion().trim());
/* 126 */     thisArrayList.add(in997ResAut.getIdRemitente().trim());
/* 127 */     thisArrayList.add(in997ResAut.getIdReceptor().trim());
/* 128 */     thisArrayList.add(in997ResAut.getFeTransaccion().trim());
/* 129 */     thisArrayList.add(in997ResAut.getHoTransaccion().trim());
/* 130 */     thisArrayList.add(in997ResAut.getIdCorrelativo().trim());
/* 131 */     thisArrayList.add(in997ResAut.getIdTransaccion().trim());
/*     */     
/* 133 */     for (int i = 0; i < in997ResAut.getIn271RegafiUpdateExcepcion().size(); i++) {
/* 134 */       thisArrayList.add(((In997RegafiUpdateExcepcion)in997ResAut.getIn271RegafiUpdateExcepcion().get(i)).getCoCampoErr().trim());
/* 135 */       thisArrayList.add(((In997RegafiUpdateExcepcion)in997ResAut.getIn271RegafiUpdateExcepcion().get(i)).getInCoErrorEncontrado().trim());
/* 136 */       thisArrayList.add(((In997RegafiUpdateExcepcion)in997ResAut.getIn271RegafiUpdateExcepcion().get(i)).getPkAfiliado().trim());
/* 137 */       thisArrayList.add(((In997RegafiUpdateExcepcion)in997ResAut.getIn271RegafiUpdateExcepcion().get(i)).getPkAfiliadopkAfiliacion().trim());
/*     */     }
/*     */     
/*     */ 
/* 141 */     in997ResAut.setNoTransaccion(thisArrayList.get(0).toString());
/* 142 */     in997ResAut.setIdRemitente(thisArrayList.get(1).toString());
/* 143 */     in997ResAut.setIdReceptor(thisArrayList.get(2).toString());
/* 144 */     in997ResAut.setFeTransaccion(thisArrayList.get(3).toString());
/* 145 */     in997ResAut.setHoTransaccion(thisArrayList.get(4).toString());
/* 146 */     in997ResAut.setIdCorrelativo(thisArrayList.get(5).toString());
/* 147 */     in997ResAut.setIdTransaccion(thisArrayList.get(6).toString());
/*     */     
/* 149 */     for (int j = 7; j < thisArrayList.size(); j++) { In997RegafiUpdateExcepcion in997RegafiUpdateExcepcion;
/* 150 */       for (int y = 0; y < 4; y++) {
/* 151 */         in997RegafiUpdateExcepcion = new In997RegafiUpdateExcepcion();
/*     */       }
/*     */     }
/*     */   }
/*     */ }

