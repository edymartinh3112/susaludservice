/*     */ package pe.com.susalud.jr.transaccion.afiliacion.util;
/*     */ 
/*     */ import java.util.List;

import pe.com.susalud.jr.transaccion.afiliacion.bean.In997RegafiUpdate;
import pe.com.susalud.jr.transaccion.afiliacion.bean.In997RegafiUpdateExcepcion;
import pe.com.susalud.jr.transaccion.afiliacion.trama.bean.SubTrama_AK1;
import pe.com.susalud.jr.transaccion.afiliacion.trama.bean.SubTrama_AK2;
import pe.com.susalud.jr.transaccion.afiliacion.trama.bean.SubTrama_AK3;
import pe.com.susalud.jr.transaccion.afiliacion.trama.bean.SubTrama_AK4;
import pe.com.susalud.jr.transaccion.afiliacion.trama.bean.SubTrama_AK5;
import pe.com.susalud.jr.transaccion.afiliacion.trama.bean.SubTrama_AK9;
import pe.com.susalud.jr.transaccion.afiliacion.trama.bean.SubTrama_GE;
import pe.com.susalud.jr.transaccion.afiliacion.trama.bean.SubTrama_GS;
import pe.com.susalud.jr.transaccion.afiliacion.trama.bean.SubTrama_IEA;
import pe.com.susalud.jr.transaccion.afiliacion.trama.bean.SubTrama_ISA;
import pe.com.susalud.jr.transaccion.afiliacion.trama.bean.SubTrama_SE;
import pe.com.susalud.jr.transaccion.afiliacion.trama.bean.SubTrama_ST;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.bean.In997RegafiUpdate;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.bean.In997RegafiUpdateExcepcion;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.trama.SubTrama_AK1;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.trama.SubTrama_AK2;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.trama.SubTrama_AK3;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.trama.SubTrama_AK4;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.trama.SubTrama_AK5;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.trama.SubTrama_AK9;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.trama.SubTrama_GE;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.trama.SubTrama_GS;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.trama.SubTrama_IEA;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.trama.SubTrama_ISA;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.trama.SubTrama_SE;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.trama.SubTrama_ST;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RegafiUpdate997_ToXs12N
/*     */ {
/*     */   public static String traducirEstructura997RegafiUpdate(In997RegafiUpdate in997ResgafiUpdate)
/*     */   {
/*  26 */     String sReturn = "";String sReturn01 = "";
/*  27 */     in997ResgafiUpdate.setNuControl(TransaccionUtil.generarAleatorio(1000000000, 8));
/*  28 */     in997ResgafiUpdate.setNuControlST(TransaccionUtil.generarAleatorioST(1000000000, 8));
/*     */     
/*     */ 
/*  31 */     SubTrama_ISA subTrama_ISA = new SubTrama_ISA();
/*  32 */     subTrama_ISA.generaSubTrama(in997ResgafiUpdate.getIdRemitente(), in997ResgafiUpdate.getIdReceptor(), in997ResgafiUpdate.getFeTransaccion(), in997ResgafiUpdate.getHoTransaccion(), in997ResgafiUpdate.getNuControlST());
/*     */     
/*     */ 
/*  35 */     subTrama_ISA.completaLongitud();
/*     */     
/*     */ 
/*  38 */     SubTrama_GS subTrama_GS = new SubTrama_GS();
/*  39 */     subTrama_GS.generaSubTrama("FA", in997ResgafiUpdate.getIdRemitente(), in997ResgafiUpdate.getIdReceptor(), in997ResgafiUpdate.getFeTransaccion(), in997ResgafiUpdate.getHoTransaccion(), in997ResgafiUpdate.getNuControl());
/*     */     
/*     */ 
/*  42 */     subTrama_GS.completaLongitud();
/*     */     
/*     */ 
/*  45 */     SubTrama_ST subTrama_ST = new SubTrama_ST();
/*  46 */     subTrama_ST.generaSubTrama(in997ResgafiUpdate.getIdTransaccion(), in997ResgafiUpdate.getNuControlST(), in997ResgafiUpdate.getExcProceso());
/*  47 */     subTrama_ST.completaLongitud();
/*     */     
/*     */ 
/*  50 */     SubTrama_AK1 subTrama_AK1 = new SubTrama_AK1();
/*  51 */     subTrama_AK1.generaSubTrama("PO", in997ResgafiUpdate.getNuControl(), "");
/*  52 */     subTrama_AK1.completaLongitud();
/*     */     
/*     */ 
/*  55 */     SubTrama_AK2 subTrama_AK2 = new SubTrama_AK2();
/*  56 */     subTrama_AK2.generaSubTrama(in997ResgafiUpdate.getIdTransaccion(), in997ResgafiUpdate.getIdCorrelativo(), "");
/*  57 */     subTrama_AK2.completaLongitud();
/*     */     
/*     */ 
/*  60 */     String sDetalle = "";
/*  61 */     for (int i = 0; i < in997ResgafiUpdate.getDetallesExcepcion().size(); i++)
/*     */     {
/*  63 */       SubTrama_AK3 subTrama_AK3 = new SubTrama_AK3();
/*  64 */       subTrama_AK3.generaSubTrama("AK5", ((In997RegafiUpdateExcepcion)in997ResgafiUpdate.getDetallesExcepcion().get(i)).getExcBD());
/*  65 */       subTrama_AK3.completaLongitud();
/*     */       
/*  67 */       SubTrama_AK4 subTrama_AK4 = new SubTrama_AK4();
/*  68 */       subTrama_AK4.generaSubTrama(((In997RegafiUpdateExcepcion)in997ResgafiUpdate.getDetallesExcepcion().get(i)).getCoCampoErr(), ((In997RegafiUpdateExcepcion)in997ResgafiUpdate.getDetallesExcepcion().get(i)).getInCoErrorEncontrado(), ((In997RegafiUpdateExcepcion)in997ResgafiUpdate.getDetallesExcepcion().get(i)).getPkAfiliado(), ((In997RegafiUpdateExcepcion)in997ResgafiUpdate.getDetallesExcepcion().get(i)).getPkAfiliadopkAfiliacion());
/*  69 */       subTrama_AK4.completaLongitud();
/*     */       
/*     */ 
/*  72 */       sDetalle = sDetalle + subTrama_AK3.returnComoString("AK3*", "*", "~") + subTrama_AK4.returnComoString("AK4*", "*", "~");
/*     */     }
/*     */     
/*     */ 
/*  76 */     if (in997ResgafiUpdate.getDetallesExcepcion().isEmpty())
/*     */     {
/*  78 */       SubTrama_AK3 subTrama_AK3 = new SubTrama_AK3();
/*  79 */       subTrama_AK3.generaSubTrama("AK5", "");
/*  80 */       subTrama_AK3.completaLongitud();
/*     */       
/*  82 */       SubTrama_AK4 subTrama_AK4 = new SubTrama_AK4();
/*  83 */       subTrama_AK4.generaSubTrama("", "", "", "");
/*  84 */       subTrama_AK4.completaLongitud();
/*     */       
/*     */ 
/*  87 */       sDetalle = sDetalle + subTrama_AK3.returnComoString("AK3*", "*", "~") + subTrama_AK4.returnComoString("AK4*", "*", "~");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  92 */     sReturn = subTrama_ISA.returnComoString("ISA*", "*", "~") + subTrama_GS.returnComoString("GS*", "*", "~") + subTrama_ST.returnComoString("ST*", "*", "~") + subTrama_AK1.returnComoString("AK1*", "*", "~") + subTrama_AK2.returnComoString("AK2*", "*", "~") + sDetalle;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  99 */     String canTxSE = cantidaSegementosTx(sReturn);
/*     */     
/*     */ 
/* 102 */     SubTrama_AK5 subTrama_AK5 = new SubTrama_AK5();
/* 103 */     subTrama_AK5.generaSubTrama("A");
/* 104 */     subTrama_AK5.completaLongitud();
/*     */     
/*     */ 
/* 107 */     SubTrama_AK9 subTrama_AK9 = new SubTrama_AK9();
/* 108 */     subTrama_AK9.generaSubTrama("A", "1", "1", "1");
/* 109 */     subTrama_AK9.completaLongitud();
/*     */     
/*     */ 
/* 112 */     SubTrama_SE subTrama_SE = new SubTrama_SE();
/* 113 */     subTrama_SE.generaSubTrama(canTxSE, in997ResgafiUpdate.getNuControlST());
/* 114 */     subTrama_SE.completaLongitud();
/*     */     
/*     */ 
/* 117 */     SubTrama_GE subTrama_GE = new SubTrama_GE();
/* 118 */     subTrama_GE.generaSubTrama(in997ResgafiUpdate.getNuControl());
/* 119 */     subTrama_GE.completaLongitud();
/*     */     
/*     */ 
/* 122 */     SubTrama_IEA subTrama_IEA = new SubTrama_IEA();
/* 123 */     subTrama_IEA.generaSubTrama(in997ResgafiUpdate.getIdCorrelativo());
/* 124 */     subTrama_IEA.completaLongitud();
/*     */     
/*     */ 
/* 127 */     sReturn01 = sReturn + subTrama_AK5.returnComoString("AK5*", "*", "~") + subTrama_AK9.returnComoString("AK9*", "*", "~") + subTrama_SE.returnComoString("SE*", "*", "~") + subTrama_GE.returnComoString("GE*", "*", "~") + subTrama_IEA.returnComoString("IEA*", "*", "~");
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 134 */     return sReturn01;
/*     */   }
/*     */   
/* 137 */   private static String cantidaSegementosTx(String sReturn) { String[] arrayCadena = sReturn.split("\\~");
/* 138 */     Integer longArray = Integer.valueOf(arrayCadena.length);
/* 139 */     return longArray.toString();
/*     */   }
/*     */ }

