/*     */ package pe.com.susalud.jr.transaccion.afiliacion.util;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;

import pe.com.susalud.jr.transaccion.afiliacion.bean.In271RegafiUpdate;
import pe.com.susalud.jr.transaccion.afiliacion.bean.In271RegafiUpdateAfiliacion;
import pe.com.susalud.jr.transaccion.afiliacion.bean.In271RegafiUpdateAfiliado;
import pe.com.susalud.jr.transaccion.afiliacion.trama.bean.SubTrama_BHT;
import pe.com.susalud.jr.transaccion.afiliacion.trama.bean.SubTrama_DMG;
import pe.com.susalud.jr.transaccion.afiliacion.trama.bean.SubTrama_DTP;
import pe.com.susalud.jr.transaccion.afiliacion.trama.bean.SubTrama_EB;
import pe.com.susalud.jr.transaccion.afiliacion.trama.bean.SubTrama_GE;
import pe.com.susalud.jr.transaccion.afiliacion.trama.bean.SubTrama_GS;
import pe.com.susalud.jr.transaccion.afiliacion.trama.bean.SubTrama_HL;
import pe.com.susalud.jr.transaccion.afiliacion.trama.bean.SubTrama_IEA;
import pe.com.susalud.jr.transaccion.afiliacion.trama.bean.SubTrama_ISA;
import pe.com.susalud.jr.transaccion.afiliacion.trama.bean.SubTrama_N2;
import pe.com.susalud.jr.transaccion.afiliacion.trama.bean.SubTrama_N4;
import pe.com.susalud.jr.transaccion.afiliacion.trama.bean.SubTrama_NM1;
import pe.com.susalud.jr.transaccion.afiliacion.trama.bean.SubTrama_PRV;
import pe.com.susalud.jr.transaccion.afiliacion.trama.bean.SubTrama_REF;
import pe.com.susalud.jr.transaccion.afiliacion.trama.bean.SubTrama_REF4;
import pe.com.susalud.jr.transaccion.afiliacion.trama.bean.SubTrama_SE;
import pe.com.susalud.jr.transaccion.afiliacion.trama.bean.SubTrama_ST;

/*     */ //import pe.gob.susalud.jr.transaccion.susalud.bean.In271RegafiUpdate;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.bean.In271RegafiUpdateAfiliacion;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.bean.In271RegafiUpdateAfiliado;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.trama.SubTrama_BHT;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.trama.SubTrama_DMG;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.trama.SubTrama_DTP;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.trama.SubTrama_EB;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.trama.SubTrama_GE;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.trama.SubTrama_GS;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.trama.SubTrama_HL;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.trama.SubTrama_IEA;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.trama.SubTrama_ISA;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.trama.SubTrama_N2;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.trama.SubTrama_N4;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.trama.SubTrama_NM1;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.trama.SubTrama_PRV;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.trama.SubTrama_REF;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.trama.SubTrama_REF4;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.trama.SubTrama_SE;
/*     */ //import pe.gob.susalud.jr.transaccion.susalud.trama.SubTrama_ST;
/*     */ 
/*     */ public class ReagfiUpdate271_ToX12N
/*     */ {
/*     */   public static String traducirEstructura270(In271RegafiUpdate inRegafiUpdate)
/*     */   {
/*  30 */     String sReturn = "";String sReturn01 = "";
/*  31 */     inRegafiUpdate.setNuControl(TransaccionUtil.generarAleatorio(1000000000, 8));
/*  32 */     inRegafiUpdate.setNuControlST(TransaccionUtil.generarAleatorioST(1000000000, 8));
/*     */     
/*     */ 
/*  35 */     String canDetalleTot = inRegafiUpdate.getDetallesAfiliados().size() + "#" + inRegafiUpdate.getIn271RegafiUpdateAfiliacion().size();
/*     */     
/*     */ 
/*  38 */     SubTrama_ISA subTrama_ISA = new SubTrama_ISA();
/*  39 */     subTrama_ISA.generaSubTrama(inRegafiUpdate.getIdRemitente(), inRegafiUpdate.getIdReceptor(), inRegafiUpdate.getFeTransaccion(), inRegafiUpdate.getHoTransaccion(), inRegafiUpdate.getIdCorrelativo());
/*  40 */     subTrama_ISA.completaLongitud();
/*     */     
/*     */ 
/*  43 */     SubTrama_GS subTrama_GS = new SubTrama_GS();
/*  44 */     subTrama_GS.generaSubTrama("HS", inRegafiUpdate.getIdRemitente(), inRegafiUpdate.getIdReceptor(), inRegafiUpdate.getFeTransaccion(), inRegafiUpdate.getHoTransaccion(), inRegafiUpdate.getNuControl());
/*  45 */     subTrama_GS.completaLongitud();
/*     */     
/*     */ 
/*  48 */     SubTrama_ST subTrama_ST = new SubTrama_ST();
/*  49 */     subTrama_ST.generaSubTrama(inRegafiUpdate.getIdTransaccion(), inRegafiUpdate.getNuControlST(), canDetalleTot);
/*  50 */     subTrama_ST.completaLongitud();
/*     */     
/*     */ 
/*  53 */     SubTrama_BHT subTrama_BHT = new SubTrama_BHT();
/*  54 */     subTrama_BHT.generaSubTrama("0022", inRegafiUpdate.getTiFinalidad());
/*  55 */     subTrama_BHT.completaLongitud();
/*     */     
/*     */ 
/*  58 */     SubTrama_HL subTrama_HL1 = new SubTrama_HL();
/*  59 */     subTrama_HL1.generaSubTrama("1", "20", "1");
/*  60 */     subTrama_HL1.completaLongitud();
/*     */     
/*     */ 
/*  63 */     SubTrama_NM1 subTrama_NM11 = new SubTrama_NM1();
/*  64 */     subTrama_NM11.generaSubTrama("PR", inRegafiUpdate.getCaRemitente(), "PI", inRegafiUpdate.getIdRemitente());
/*  65 */     subTrama_NM11.completaLongitud();
/*     */     
/*     */ 
/*  68 */     SubTrama_REF subTrama_REF1 = new SubTrama_REF();
/*  69 */     subTrama_REF1.generaSubTrama("8X", inRegafiUpdate.getTiOperacion());
/*  70 */     subTrama_REF1.completaLongitud();
/*     */     
/*     */ 
/*     */ 
/*  74 */     SubTrama_HL subTrama_HL2 = new SubTrama_HL();
/*  75 */     subTrama_HL2.generaSubTrama("2", "1", "21", "1");
/*  76 */     subTrama_HL2.completaLongitud();
/*     */     
/*     */ 
/*  79 */     String sDetalle = "";
/*  80 */     for (int i = 0; i < inRegafiUpdate.getDetallesAfiliados().size(); i++)
/*     */     {
/*  82 */       SubTrama_NM1 subTrama_NM12 = new SubTrama_NM1();
/*  83 */       subTrama_NM12.generaSubTrama("IL", "1", ((In271RegafiUpdateAfiliado)inRegafiUpdate.getDetallesAfiliados().get(i)).getApPaternoAfiliado(), ((In271RegafiUpdateAfiliado)inRegafiUpdate.getDetallesAfiliados().get(i)).getNoAfiliado1(), ((In271RegafiUpdateAfiliado)inRegafiUpdate.getDetallesAfiliados().get(i)).getNoAfiliado2(), "", "", "MI", "", ((In271RegafiUpdateAfiliado)inRegafiUpdate.getDetallesAfiliados().get(i)).getApMaternoAfiliado());
/*     */       
/*  85 */       subTrama_NM12.completaLongitud();
/*     */       
/*     */ 
/*  88 */       SubTrama_REF subTrama_REF2 = new SubTrama_REF();
/*  89 */       subTrama_REF2.generaSubTrama("DD", ((In271RegafiUpdateAfiliado)inRegafiUpdate.getDetallesAfiliados().get(i)).getTiDocumentoAfil());
/*  90 */       subTrama_REF2.completaLongitud();
/*     */       
/*     */ 
/*  93 */       SubTrama_REF4 subTrama_REF24 = new SubTrama_REF4();
/*  94 */       subTrama_REF24.generaSubTrama("4A", ((In271RegafiUpdateAfiliado)inRegafiUpdate.getDetallesAfiliados().get(i)).getNuDocumentoAfil());
/*  95 */       subTrama_REF24.completaLongitud();
/*     */       
/*     */ 
/*  98 */       SubTrama_REF subTrama_REF3 = new SubTrama_REF();
/*  99 */       subTrama_REF3.generaSubTrama("ACC", ((In271RegafiUpdateAfiliado)inRegafiUpdate.getDetallesAfiliados().get(i)).getEstadoAfiliado());
/* 100 */       subTrama_REF3.completaLongitud();
/*     */       
/*     */ 
/* 103 */       SubTrama_REF subTrama_REF4 = new SubTrama_REF();
/* 104 */       subTrama_REF4.generaSubTrama("DD", ((In271RegafiUpdateAfiliado)inRegafiUpdate.getDetallesAfiliados().get(i)).getTiDocumentoAct());
/* 105 */       subTrama_REF4.completaLongitud();
/*     */       
/*     */ 
/* 108 */       SubTrama_REF4 subTrama_REF44 = new SubTrama_REF4();
/* 109 */       subTrama_REF44.generaSubTrama("4A", ((In271RegafiUpdateAfiliado)inRegafiUpdate.getDetallesAfiliados().get(i)).getNuDocumentoAct());
/* 110 */       subTrama_REF44.completaLongitud();
/*     */       
/*     */ 
/* 113 */       SubTrama_N2 subTrama_N2 = new SubTrama_N2();
/* 114 */       subTrama_N2.generaSubTrama(((In271RegafiUpdateAfiliado)inRegafiUpdate.getDetallesAfiliados().get(i)).getApCasadaAfiliado());
/* 115 */       subTrama_N2.completaLongitud();
/*     */       
/*     */ 
/* 118 */       SubTrama_N4 subTrama_N4 = new SubTrama_N4();
/* 119 */       subTrama_N4.generaSubTrama(((In271RegafiUpdateAfiliado)inRegafiUpdate.getDetallesAfiliados().get(i)).getCoNacionalidad(), "W", ((In271RegafiUpdateAfiliado)inRegafiUpdate.getDetallesAfiliados().get(i)).getUbigeo());
/* 120 */       subTrama_N4.completaLongitud();
/*     */       
/*     */ 
/* 123 */       SubTrama_DMG subTrama_DMG1 = new SubTrama_DMG();
/* 124 */       subTrama_DMG1.generaSubTrama("D8", ((In271RegafiUpdateAfiliado)inRegafiUpdate.getDetallesAfiliados().get(i)).getFeNacimiento(), ((In271RegafiUpdateAfiliado)inRegafiUpdate.getDetallesAfiliados().get(i)).getGenero(), "", ((In271RegafiUpdateAfiliado)inRegafiUpdate.getDetallesAfiliados().get(i)).getCoPaisDoc());
/* 125 */       subTrama_DMG1.completaLongitud();
/*     */       
/*     */ 
/* 128 */       SubTrama_NM1 subTrama_NM13 = new SubTrama_NM1();
/* 129 */       subTrama_NM13.generaSubTrama("IL", "1", "", "");
/* 130 */       subTrama_NM13.completaLongitud();
/*     */       
/*     */ 
/* 133 */       SubTrama_DMG subTrama_DMG2 = new SubTrama_DMG();
/* 134 */       subTrama_DMG2.generaSubTrama("D8", ((In271RegafiUpdateAfiliado)inRegafiUpdate.getDetallesAfiliados().get(i)).getFefallecimiento(), "", "", ((In271RegafiUpdateAfiliado)inRegafiUpdate.getDetallesAfiliados().get(i)).getCoPaisEmisorDocAct());
/* 135 */       subTrama_DMG2.completaLongitud();
/*     */       
/*     */ 
/* 138 */       SubTrama_DTP subTrama_DTP1 = new SubTrama_DTP();
/* 139 */       subTrama_DTP1.generaSubTrama("ZZZ", "D8", ((In271RegafiUpdateAfiliado)inRegafiUpdate.getDetallesAfiliados().get(i)).getFeActPersonaxIafas());
/* 140 */       subTrama_DTP1.completaLongitud();
/*     */       
/*     */ 
/* 143 */       SubTrama_EB subTrama_EB1 = new SubTrama_EB();
/* 144 */       subTrama_EB1.generaSubTrama("W", "");
/* 145 */       subTrama_EB1.completaLongitud();
/*     */       
/* 147 */       SubTrama_REF subTrama_REF5 = new SubTrama_REF();
/* 148 */       subTrama_REF5.generaSubTrama("ZZ", ((In271RegafiUpdateAfiliado)inRegafiUpdate.getDetallesAfiliados().get(i)).getIdAfiliadoNombre());
/* 149 */       subTrama_REF5.completaLongitud();
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 155 */       SubTrama_NM1 subTrama_NM14 = new SubTrama_NM1();
/* 156 */       subTrama_NM14.generaSubTrama("IL", "1", "", "");
/* 157 */       subTrama_NM14.completaLongitud();
/*     */       
/*     */ 
/* 160 */       SubTrama_REF subTrama_REF6 = new SubTrama_REF();
/* 161 */       subTrama_REF6.generaSubTrama("DD", ((In271RegafiUpdateAfiliado)inRegafiUpdate.getDetallesAfiliados().get(i)).getTiDocTutor());
/* 162 */       subTrama_REF6.completaLongitud();
/*     */       
/*     */ 
/* 165 */       SubTrama_REF4 subTrama_REF64 = new SubTrama_REF4();
/* 166 */       subTrama_REF64.generaSubTrama("4A", ((In271RegafiUpdateAfiliado)inRegafiUpdate.getDetallesAfiliados().get(i)).getNuDocTutor());
/* 167 */       subTrama_REF64.completaLongitud();
/*     */       
/*     */ 
/* 170 */       SubTrama_REF subTrama_REF7 = new SubTrama_REF();
/* 171 */       subTrama_REF7.generaSubTrama("ZZ", ((In271RegafiUpdateAfiliado)inRegafiUpdate.getDetallesAfiliados().get(i)).getTiVinculoTutor());
/* 172 */       subTrama_REF7.completaLongitud();
/*     */       
/*     */ 
/* 175 */       SubTrama_DMG subTrama_DMG3 = new SubTrama_DMG();
/* 176 */       subTrama_DMG3.generaSubTrama("D8", ((In271RegafiUpdateAfiliado)inRegafiUpdate.getDetallesAfiliados().get(i)).getFeValidacionReniec(), "", "", ((In271RegafiUpdateAfiliado)inRegafiUpdate.getDetallesAfiliados().get(i)).getCoPaisEmisorDocTutor());
/* 177 */       subTrama_DMG3.completaLongitud();
/*     */       
/*     */ 
/* 180 */       sDetalle = sDetalle + subTrama_NM12.returnComoString("NM1*", "*", "~") + subTrama_REF2.returnComoString("REF*", "*", new StringBuilder().append("*").append(subTrama_REF24.returnComoString("", ":", "~")).toString()) + subTrama_REF3.returnComoString("REF*", "*", "~") + subTrama_REF4.returnComoString("REF*", "*", new StringBuilder().append("*").append(subTrama_REF44.returnComoString("", ":", "~")).toString()) + subTrama_N2.returnComoString("N2*", "*", "~") + subTrama_N4.returnComoString("N4*", "*", "~") + subTrama_DMG1.returnComoString("DMG*", "*", "~") + subTrama_NM13.returnComoString("NM1*", "*", "~") + subTrama_DMG2.returnComoString("DMG*", "*", "~") + subTrama_DTP1.returnComoString("DTP*", "*", "~") + subTrama_EB1.returnComoString("EB*", "*", "~") + subTrama_REF5.returnComoString("REF*", "*", "~") + subTrama_NM14.returnComoString("NM1*", "*", "~") + subTrama_REF6.returnComoString("REF*", "*", new StringBuilder().append("*").append(subTrama_REF64.returnComoString("", ":", "~")).toString()) + subTrama_REF7.returnComoString("REF*", "*", "~") + subTrama_DMG3.returnComoString("DMG*", "*", "~");
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
/* 198 */     if (inRegafiUpdate.getDetallesAfiliados().isEmpty())
/*     */     {
/* 200 */       SubTrama_NM1 subTrama_NM12 = new SubTrama_NM1();
/* 201 */       subTrama_NM12.generaSubTrama("IL", "1", "", "", "", "", "", "MI", "", "");
/* 202 */       subTrama_NM12.completaLongitud();
/*     */       
/*     */ 
/* 205 */       SubTrama_REF subTrama_REF2 = new SubTrama_REF();
/* 206 */       subTrama_REF2.generaSubTrama("DD", "");
/* 207 */       subTrama_REF2.completaLongitud();
/*     */       
/*     */ 
/* 210 */       SubTrama_REF4 subTrama_REF24 = new SubTrama_REF4();
/* 211 */       subTrama_REF24.generaSubTrama("4A", "");
/* 212 */       subTrama_REF24.completaLongitud();
/*     */       
/*     */ 
/* 215 */       SubTrama_REF subTrama_REF3 = new SubTrama_REF();
/* 216 */       subTrama_REF3.generaSubTrama("ZZ", "");
/* 217 */       subTrama_REF3.completaLongitud();
/*     */       
/*     */ 
/* 220 */       SubTrama_REF subTrama_REF4 = new SubTrama_REF();
/* 221 */       subTrama_REF4.generaSubTrama("DD", "");
/* 222 */       subTrama_REF4.completaLongitud();
/*     */       
/*     */ 
/* 225 */       SubTrama_REF4 subTrama_REF44 = new SubTrama_REF4();
/* 226 */       subTrama_REF44.generaSubTrama("4A", "");
/* 227 */       subTrama_REF44.completaLongitud();
/*     */       
/*     */ 
/* 230 */       SubTrama_N2 subTrama_N2 = new SubTrama_N2();
/* 231 */       subTrama_N2.generaSubTrama("");
/* 232 */       subTrama_N2.completaLongitud();
/*     */       
/*     */ 
/* 235 */       SubTrama_N4 subTrama_N4 = new SubTrama_N4();
/* 236 */       subTrama_N4.generaSubTrama("", "W", "");
/* 237 */       subTrama_N4.completaLongitud();
/*     */       
/*     */ 
/* 240 */       SubTrama_DMG subTrama_DMG1 = new SubTrama_DMG();
/* 241 */       subTrama_DMG1.generaSubTrama("D8", "", "", "", "");
/* 242 */       subTrama_DMG1.completaLongitud();
/*     */       
/*     */ 
/* 245 */       SubTrama_NM1 subTrama_NM13 = new SubTrama_NM1();
/* 246 */       subTrama_NM13.generaSubTrama("IL", "1", "", "");
/* 247 */       subTrama_NM13.completaLongitud();
/*     */       
/*     */ 
/* 250 */       SubTrama_DMG subTrama_DMG2 = new SubTrama_DMG();
/* 251 */       subTrama_DMG2.generaSubTrama("D8", "", "", "", "");
/* 252 */       subTrama_DMG2.completaLongitud();
/*     */       
/*     */ 
/* 255 */       SubTrama_DTP subTrama_DTP1 = new SubTrama_DTP();
/* 256 */       subTrama_DTP1.generaSubTrama("ZZZ", "D8", "");
/* 257 */       subTrama_DTP1.completaLongitud();
/*     */       
/*     */ 
/* 260 */       SubTrama_EB subTrama_EB1 = new SubTrama_EB();
/* 261 */       subTrama_EB1.generaSubTrama("W", "");
/* 262 */       subTrama_EB1.completaLongitud();
/*     */       
/* 264 */       SubTrama_REF subTrama_REF5 = new SubTrama_REF();
/* 265 */       subTrama_REF5.generaSubTrama("ZZ", "");
/* 266 */       subTrama_REF5.completaLongitud();
/*     */       
/* 268 */       SubTrama_NM1 subTrama_NM14 = new SubTrama_NM1();
/* 269 */       subTrama_NM14.generaSubTrama("IL", "1", "", "");
/* 270 */       subTrama_NM14.completaLongitud();
/*     */       
/*     */ 
/* 273 */       SubTrama_REF subTrama_REF6 = new SubTrama_REF();
/* 274 */       subTrama_REF6.generaSubTrama("DD", "");
/* 275 */       subTrama_REF6.completaLongitud();
/*     */       
/*     */ 
/* 278 */       SubTrama_REF4 subTrama_REF64 = new SubTrama_REF4();
/* 279 */       subTrama_REF64.generaSubTrama("4A", "");
/* 280 */       subTrama_REF64.completaLongitud();
/*     */       
/*     */ 
/* 283 */       SubTrama_REF subTrama_REF7 = new SubTrama_REF();
/* 284 */       subTrama_REF7.generaSubTrama("ZZ", "");
/* 285 */       subTrama_REF7.completaLongitud();
/*     */       
/*     */ 
/* 288 */       SubTrama_DMG subTrama_DMG3 = new SubTrama_DMG();
/* 289 */       subTrama_DMG3.generaSubTrama("D8", "", "", "", "");
/* 290 */       subTrama_DMG3.completaLongitud();
/*     */       
/*     */ 
/* 293 */       sDetalle = sDetalle + subTrama_NM12.returnComoString("NM1*", "*", "~") + subTrama_REF2.returnComoString("REF*", "*", new StringBuilder().append("*").append(subTrama_REF24.returnComoString("", ":", "~")).toString()) + subTrama_REF3.returnComoString("REF*", "*", "~") + subTrama_REF4.returnComoString("REF*", "*", new StringBuilder().append("*").append(subTrama_REF44.returnComoString("", ":", "~")).toString()) + subTrama_N2.returnComoString("N2*", "*", "~") + subTrama_N4.returnComoString("N4*", "*", "~") + subTrama_DMG1.returnComoString("DMG*", "*", "~") + subTrama_NM13.returnComoString("NM1*", "*", "~") + subTrama_DMG2.returnComoString("DMG*", "*", "~") + subTrama_DTP1.returnComoString("DTP*", "*", "~") + subTrama_EB1.returnComoString("EB*", "*", "~") + subTrama_REF5.returnComoString("REF*", "*", "~") + subTrama_NM14.returnComoString("NM1*", "*", "~") + subTrama_REF6.returnComoString("REF*", "*", new StringBuilder().append("*").append(subTrama_REF64.returnComoString("", ":", "~")).toString()) + subTrama_REF7.returnComoString("REF*", "*", "~") + subTrama_DMG3.returnComoString("DMG*", "*", "~");
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
/* 311 */     SubTrama_HL subTrama_HL3 = new SubTrama_HL();
/* 312 */     subTrama_HL3.generaSubTrama("3", "2", "22", "0");
/* 313 */     subTrama_HL3.completaLongitud();
/*     */     
/*     */ 
/* 316 */     String sDetalle1 = "";
/* 317 */     for (int i = 0; i < inRegafiUpdate.getDetallesAfiliaciones().size(); i++)
/*     */     {
/* 319 */       SubTrama_NM1 subTrama_NM15 = new SubTrama_NM1();
/* 320 */       subTrama_NM15.generaSubTrama("07", "1", "", "");
/* 321 */       subTrama_NM15.completaLongitud();
/*     */       
/*     */ 
/* 324 */       SubTrama_REF subTrama_REF8 = new SubTrama_REF();
/* 325 */       subTrama_REF8.generaSubTrama("DD", ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getTiDocTitular());
/* 326 */       subTrama_REF8.completaLongitud();
/*     */       
/*     */ 
/* 329 */       SubTrama_REF4 subTrama_REF84 = new SubTrama_REF4();
/* 330 */       subTrama_REF84.generaSubTrama("4A", ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getNuDocTitular());
/* 331 */       subTrama_REF84.completaLongitud();
/*     */       
/*     */ 
/* 334 */       SubTrama_DMG subTrama_DMG4 = new SubTrama_DMG();
/* 335 */       subTrama_DMG4.generaSubTrama("D8", ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getFeNacimientoTitular(), "", "", ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getCoPaisEmisorDocTitular());
/* 336 */       subTrama_DMG4.completaLongitud();
/*     */       
/*     */ 
/* 339 */       SubTrama_NM1 subTrama_NM16 = new SubTrama_NM1();
/* 340 */       subTrama_NM16.generaSubTrama("C9", ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getTiContratante(), ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getApPaternoContratante(), ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getNoContratante1(), ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getNoContratante2(), ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getNoContratante3(), ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getNoContratante4(), "MI", "", ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getApMaternoContratante());
/*     */       
/*     */ 
/*     */ 
/* 344 */       subTrama_NM16.completaLongitud();
/*     */       
/*     */ 
/* 347 */       SubTrama_REF subTrama_REF9 = new SubTrama_REF();
/* 348 */       subTrama_REF9.generaSubTrama("DD", ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getTiDocContratante());
/* 349 */       subTrama_REF9.completaLongitud();
/*     */       
/*     */ 
/* 352 */       SubTrama_REF4 subTrama_REF94 = new SubTrama_REF4();
/* 353 */       subTrama_REF94.generaSubTrama("4A", ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getNuDocContratante());
/* 354 */       subTrama_REF94.completaLongitud();
/*     */       
/*     */ 
/* 357 */       SubTrama_N2 subTrama_N21 = new SubTrama_N2();
/* 358 */       subTrama_N21.generaSubTrama(((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getApCasadaContratante());
/* 359 */       subTrama_N21.completaLongitud();
/*     */       
/*     */ 
/* 362 */       SubTrama_DMG subTrama_DMG5 = new SubTrama_DMG();
/* 363 */       subTrama_DMG5.generaSubTrama("D8", ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getFeNacimientoContratante(), "", "", ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getCoPaisEmisorDocContratante());
/* 364 */       subTrama_DMG5.completaLongitud();
/*     */       
/*     */ 
/* 367 */       SubTrama_NM1 subTrama_NM17 = new SubTrama_NM1();
/* 368 */       subTrama_NM17.generaSubTrama("ACV", "2", "", "");
/* 369 */       subTrama_NM17.completaLongitud();
/*     */       
/*     */ 
/* 372 */       SubTrama_REF subTrama_REF10 = new SubTrama_REF();
/* 373 */       subTrama_REF10.generaSubTrama("18", ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getCoAfiliacion());
/* 374 */       subTrama_REF10.completaLongitud();
/*     */       
/*     */ 
/* 377 */       SubTrama_REF subTrama_REF11 = new SubTrama_REF();
/* 378 */       subTrama_REF11.generaSubTrama("CT", ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getCoContrato());
/* 379 */       subTrama_REF11.completaLongitud();
/*     */       
/*     */ 
/* 382 */       SubTrama_REF subTrama_REF12 = new SubTrama_REF();
/* 383 */       subTrama_REF12.generaSubTrama("OF", ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getCoUnicoMultisectorial());
/* 384 */       subTrama_REF12.completaLongitud();
/*     */       
/*     */ 
/* 387 */       SubTrama_REF subTrama_REF13 = new SubTrama_REF();
/* 388 */       subTrama_REF13.generaSubTrama("BLT", ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getTiregimen());
/* 389 */       subTrama_REF13.completaLongitud();
/*     */       
/*     */ 
/* 392 */       SubTrama_REF subTrama_REF14 = new SubTrama_REF();
/* 393 */       subTrama_REF14.generaSubTrama("ACC", ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getEsAfiliacion(), ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getCoCausalBaja());
/* 394 */       subTrama_REF14.completaLongitud();
/*     */       
/*     */ 
/* 397 */       SubTrama_REF subTrama_REF15 = new SubTrama_REF();
/* 398 */       subTrama_REF15.generaSubTrama("6P", ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getTiPlanSalud(), ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getNoProductoSalud());
/* 399 */       subTrama_REF15.completaLongitud();
/*     */       
/*     */ 
/* 402 */       SubTrama_REF subTrama_REF16 = new SubTrama_REF();
/* 403 */       subTrama_REF16.generaSubTrama("OZ", ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getCoProducto());
/* 404 */       subTrama_REF16.completaLongitud();
/*     */       
/*     */ 
/* 407 */       SubTrama_REF subTrama_REF17 = new SubTrama_REF();
/* 408 */       subTrama_REF17.generaSubTrama("ACD", ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getParentesco());
/* 409 */       subTrama_REF17.completaLongitud();
/*     */       
/*     */ 
/* 412 */       SubTrama_REF subTrama_REF18 = new SubTrama_REF();
/* 413 */       subTrama_REF18.generaSubTrama("AEC", ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getCoRenipress());
/* 414 */       subTrama_REF18.completaLongitud();
/*     */       
/*     */ 
/* 417 */       SubTrama_PRV subTrama_PRV1 = new SubTrama_PRV();
/* 418 */       subTrama_PRV1.generaSubTrama("SU", "", ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getPkAfiliado());
/* 419 */       subTrama_PRV1.completaLongitud();
/*     */       
/*     */ 
/* 422 */       SubTrama_DTP subTrama_DTP2 = new SubTrama_DTP();
/* 423 */       subTrama_DTP2.generaSubTrama("W02", "D8", ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getFeActEstado());
/* 424 */       subTrama_DTP2.completaLongitud();
/*     */       
/*     */ 
/* 427 */       SubTrama_DTP subTrama_DTP3 = new SubTrama_DTP();
/* 428 */       subTrama_DTP3.generaSubTrama("276", "D8", ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getFeIniAfiliacion());
/* 429 */       subTrama_DTP3.completaLongitud();
/*     */       
/*     */ 
/* 432 */       SubTrama_DTP subTrama_DTP4 = new SubTrama_DTP();
/* 433 */       subTrama_DTP4.generaSubTrama("093", "D8", ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getFeFinAfiliacion());
/* 434 */       subTrama_DTP4.completaLongitud();
/*     */       
/*     */ 
/* 437 */       SubTrama_DTP subTrama_DTP5 = new SubTrama_DTP();
/* 438 */       subTrama_DTP5.generaSubTrama("150", "D8", ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getFeIniCobertura());
/* 439 */       subTrama_DTP5.completaLongitud();
/*     */       
/*     */ 
/* 442 */       SubTrama_DTP subTrama_DTP6 = new SubTrama_DTP();
/* 443 */       subTrama_DTP6.generaSubTrama("151", "D8", ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getFeFinCobertura());
/* 444 */       subTrama_DTP6.completaLongitud();
/*     */       
/*     */ 
/* 447 */       SubTrama_DTP subTrama_DTP7 = new SubTrama_DTP();
/* 448 */       subTrama_DTP7.generaSubTrama("636", "D8", ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getFeActOperacion());
/* 449 */       subTrama_DTP7.completaLongitud();
/*     */       
/*     */ 
/* 452 */       SubTrama_DTP subTrama_DTP8 = new SubTrama_DTP();
/* 453 */       subTrama_DTP8.generaSubTrama("636", "TS", ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getTiActOperacion());
/* 454 */       subTrama_DTP8.completaLongitud();
/*     */       
/*     */ 
/* 457 */       SubTrama_EB subTrama_EB2 = new SubTrama_EB();
/* 458 */       subTrama_EB2.generaSubTrama("1", ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getCoTiCobertura());
/* 459 */       subTrama_EB2.completaLongitud();
/*     */       
/*     */ 
/* 462 */       SubTrama_REF subTrama_REF19 = new SubTrama_REF();
/* 463 */       subTrama_REF19.generaSubTrama("ZZ", ((In271RegafiUpdateAfiliacion)inRegafiUpdate.getDetallesAfiliaciones().get(i)).getIdAfiliacionNombre());
/* 464 */       subTrama_REF19.completaLongitud();
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 470 */       sDetalle1 = sDetalle1 + subTrama_NM15.returnComoString("NM1*", "*", "~") + subTrama_REF8.returnComoString("REF*", "*", new StringBuilder().append("*").append(subTrama_REF84.returnComoString("", ":", "~")).toString()) + subTrama_DMG4.returnComoString("DMG*", "*", "~") + subTrama_NM16.returnComoString("NM1*", "*", "~") + subTrama_REF9.returnComoString("REF*", "*", new StringBuilder().append("*").append(subTrama_REF94.returnComoString("", ":", "~")).toString()) + subTrama_N21.returnComoString("N2*", "*", "~") + subTrama_DMG5.returnComoString("DMG*", "*", "~") + subTrama_NM17.returnComoString("NM1*", "*", "~") + subTrama_REF10.returnComoString("REF*", "*", "~") + subTrama_REF11.returnComoString("REF*", "*", "~") + subTrama_REF12.returnComoString("REF*", "*", "~") + subTrama_REF13.returnComoString("REF*", "*", "~") + subTrama_REF14.returnComoString("REF*", "*", "~") + subTrama_REF15.returnComoString("REF*", "*", "~") + subTrama_REF16.returnComoString("REF*", "*", "~") + subTrama_REF17.returnComoString("REF*", "*", "~") + subTrama_REF18.returnComoString("REF*", "*", "~") + subTrama_PRV1.returnComoString("PRV*", "*", "~") + subTrama_DTP2.returnComoString("DTP*", "*", "~") + subTrama_DTP3.returnComoString("DTP*", "*", "~") + subTrama_DTP4.returnComoString("DTP*", "*", "~") + subTrama_DTP5.returnComoString("DTP*", "*", "~") + subTrama_DTP6.returnComoString("DTP*", "*", "~") + subTrama_DTP7.returnComoString("DTP*", "*", "~") + subTrama_DTP8.returnComoString("DTP*", "*", "~") + subTrama_EB2.returnComoString("EB*", "*", "~") + subTrama_REF19.returnComoString("REF*", "*", "~");
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
/*     */ 
/*     */ 
/*     */ 
/* 499 */     if (inRegafiUpdate.getDetallesAfiliaciones().isEmpty())
/*     */     {
/* 501 */       SubTrama_NM1 subTrama_NM15 = new SubTrama_NM1();
/* 502 */       subTrama_NM15.generaSubTrama("07", "1", "", "");
/* 503 */       subTrama_NM15.completaLongitud();
/*     */       
/*     */ 
/* 506 */       SubTrama_REF subTrama_REF8 = new SubTrama_REF();
/* 507 */       subTrama_REF8.generaSubTrama("DD", "");
/* 508 */       subTrama_REF8.completaLongitud();
/*     */       
/*     */ 
/* 511 */       SubTrama_REF4 subTrama_REF84 = new SubTrama_REF4();
/* 512 */       subTrama_REF84.generaSubTrama("4A", "");
/* 513 */       subTrama_REF84.completaLongitud();
/*     */       
/*     */ 
/* 516 */       SubTrama_DMG subTrama_DMG4 = new SubTrama_DMG();
/* 517 */       subTrama_DMG4.generaSubTrama("D8", "", "", "", "");
/* 518 */       subTrama_DMG4.completaLongitud();
/*     */       
/*     */ 
/* 521 */       SubTrama_NM1 subTrama_NM16 = new SubTrama_NM1();
/* 522 */       subTrama_NM16.generaSubTrama("C9", "", "", "", "", "", "", "MI", "", "");
/* 523 */       subTrama_NM16.completaLongitud();
/*     */       
/*     */ 
/* 526 */       SubTrama_REF subTrama_REF9 = new SubTrama_REF();
/* 527 */       subTrama_REF9.generaSubTrama("DD", "");
/* 528 */       subTrama_REF9.completaLongitud();
/*     */       
/*     */ 
/* 531 */       SubTrama_REF4 subTrama_REF94 = new SubTrama_REF4();
/* 532 */       subTrama_REF94.generaSubTrama("4A", "");
/* 533 */       subTrama_REF94.completaLongitud();
/*     */       
/*     */ 
/* 536 */       SubTrama_N2 subTrama_N21 = new SubTrama_N2();
/* 537 */       subTrama_N21.generaSubTrama("");
/* 538 */       subTrama_N21.completaLongitud();
/*     */       
/*     */ 
/* 541 */       SubTrama_DMG subTrama_DMG5 = new SubTrama_DMG();
/* 542 */       subTrama_DMG5.generaSubTrama("D8", "", "", "", "");
/* 543 */       subTrama_DMG5.completaLongitud();
/*     */       
/*     */ 
/* 546 */       SubTrama_NM1 subTrama_NM17 = new SubTrama_NM1();
/* 547 */       subTrama_NM17.generaSubTrama("ACV", "2", "", "");
/* 548 */       subTrama_NM17.completaLongitud();
/*     */       
/*     */ 
/* 551 */       SubTrama_REF subTrama_REF10 = new SubTrama_REF();
/* 552 */       subTrama_REF10.generaSubTrama("18", "");
/* 553 */       subTrama_REF10.completaLongitud();
/*     */       
/*     */ 
/* 556 */       SubTrama_REF subTrama_REF11 = new SubTrama_REF();
/* 557 */       subTrama_REF11.generaSubTrama("CT", "");
/* 558 */       subTrama_REF11.completaLongitud();
/*     */       
/*     */ 
/* 561 */       SubTrama_REF subTrama_REF12 = new SubTrama_REF();
/* 562 */       subTrama_REF12.generaSubTrama("OF", "");
/* 563 */       subTrama_REF12.completaLongitud();
/*     */       
/*     */ 
/* 566 */       SubTrama_REF subTrama_REF13 = new SubTrama_REF();
/* 567 */       subTrama_REF13.generaSubTrama("BLT", "");
/* 568 */       subTrama_REF13.completaLongitud();
/*     */       
/*     */ 
/* 571 */       SubTrama_REF subTrama_REF14 = new SubTrama_REF();
/* 572 */       subTrama_REF14.generaSubTrama("ACC", "", "");
/* 573 */       subTrama_REF14.completaLongitud();
/*     */       
/*     */ 
/* 576 */       SubTrama_REF subTrama_REF15 = new SubTrama_REF();
/* 577 */       subTrama_REF15.generaSubTrama("6P", "", "");
/* 578 */       subTrama_REF15.completaLongitud();
/*     */       
/*     */ 
/* 581 */       SubTrama_REF subTrama_REF16 = new SubTrama_REF();
/* 582 */       subTrama_REF16.generaSubTrama("OZ", "");
/* 583 */       subTrama_REF16.completaLongitud();
/*     */       
/*     */ 
/* 586 */       SubTrama_REF subTrama_REF17 = new SubTrama_REF();
/* 587 */       subTrama_REF17.generaSubTrama("ACD", "");
/* 588 */       subTrama_REF17.completaLongitud();
/*     */       
/*     */ 
/* 591 */       SubTrama_REF subTrama_REF18 = new SubTrama_REF();
/* 592 */       subTrama_REF18.generaSubTrama("AEC", "");
/* 593 */       subTrama_REF18.completaLongitud();
/*     */       
/*     */ 
/* 596 */       SubTrama_PRV subTrama_PRV1 = new SubTrama_PRV();
/* 597 */       subTrama_PRV1.generaSubTrama("SU", "", "");
/* 598 */       subTrama_PRV1.completaLongitud();
/*     */       
/*     */ 
/* 601 */       SubTrama_DTP subTrama_DTP2 = new SubTrama_DTP();
/* 602 */       subTrama_DTP2.generaSubTrama("W02", "D8", "");
/* 603 */       subTrama_DTP2.completaLongitud();
/*     */       
/*     */ 
/* 606 */       SubTrama_DTP subTrama_DTP3 = new SubTrama_DTP();
/* 607 */       subTrama_DTP3.generaSubTrama("276", "D8", "");
/* 608 */       subTrama_DTP3.completaLongitud();
/*     */       
/*     */ 
/* 611 */       SubTrama_DTP subTrama_DTP4 = new SubTrama_DTP();
/* 612 */       subTrama_DTP4.generaSubTrama("093", "D8", "");
/* 613 */       subTrama_DTP4.completaLongitud();
/*     */       
/*     */ 
/* 616 */       SubTrama_DTP subTrama_DTP5 = new SubTrama_DTP();
/* 617 */       subTrama_DTP5.generaSubTrama("150", "D8", "");
/* 618 */       subTrama_DTP5.completaLongitud();
/*     */       
/*     */ 
/* 621 */       SubTrama_DTP subTrama_DTP6 = new SubTrama_DTP();
/* 622 */       subTrama_DTP6.generaSubTrama("151", "D8", "");
/* 623 */       subTrama_DTP6.completaLongitud();
/*     */       
/*     */ 
/* 626 */       SubTrama_DTP subTrama_DTP7 = new SubTrama_DTP();
/* 627 */       subTrama_DTP7.generaSubTrama("636", "D8", "");
/* 628 */       subTrama_DTP7.completaLongitud();
/*     */       
/*     */ 
/* 631 */       SubTrama_DTP subTrama_DTP8 = new SubTrama_DTP();
/* 632 */       subTrama_DTP8.generaSubTrama("636", "TS", "");
/* 633 */       subTrama_DTP8.completaLongitud();
/*     */       
/*     */ 
/* 636 */       SubTrama_EB subTrama_EB1 = new SubTrama_EB();
/* 637 */       subTrama_EB1.generaSubTrama("1", "");
/* 638 */       subTrama_EB1.completaLongitud();
/*     */       
/*     */ 
/* 641 */       SubTrama_REF subTrama_REF19 = new SubTrama_REF();
/* 642 */       subTrama_REF19.generaSubTrama("ZZ", "");
/* 643 */       subTrama_REF19.completaLongitud();
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 649 */       sDetalle1 = sDetalle1 + subTrama_NM15.returnComoString("NM1*", "*", "~") + subTrama_REF8.returnComoString("REF*", "*", new StringBuilder().append("*").append(subTrama_REF84.returnComoString("", ":", "~")).toString()) + subTrama_DMG4.returnComoString("DMG*", "*", "~") + subTrama_NM16.returnComoString("NM1*", "*", "~") + subTrama_REF9.returnComoString("REF*", "*", new StringBuilder().append("*").append(subTrama_REF94.returnComoString("", ":", "~")).toString()) + subTrama_N21.returnComoString("N2*", "*", "~") + subTrama_DMG5.returnComoString("DMG*", "*", "~") + subTrama_NM17.returnComoString("NM1*", "*", "~") + subTrama_REF10.returnComoString("REF*", "*", "~") + subTrama_REF11.returnComoString("REF*", "*", "~") + subTrama_REF12.returnComoString("REF*", "*", "~") + subTrama_REF13.returnComoString("REF*", "*", "~") + subTrama_REF14.returnComoString("REF*", "*", "~") + subTrama_REF15.returnComoString("REF*", "*", "~") + subTrama_REF16.returnComoString("REF*", "*", "~") + subTrama_REF17.returnComoString("REF*", "*", "~") + subTrama_REF18.returnComoString("REF*", "*", "~") + subTrama_PRV1.returnComoString("PRV*", "*", "~") + subTrama_DTP2.returnComoString("DTP*", "*", "~") + subTrama_DTP3.returnComoString("DTP*", "*", "~") + subTrama_DTP4.returnComoString("DTP*", "*", "~") + subTrama_DTP5.returnComoString("DTP*", "*", "~") + subTrama_DTP6.returnComoString("DTP*", "*", "~") + subTrama_DTP7.returnComoString("DTP*", "*", "~") + subTrama_DTP8.returnComoString("DTP*", "*", "~") + subTrama_EB1.returnComoString("EB*", "*", "~") + subTrama_REF19.returnComoString("REF*", "*", "~");
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 679 */     sReturn = subTrama_ISA.returnComoString("ISA*", "*", "~") + subTrama_GS.returnComoString("GS*", "*", "~") + subTrama_ST.returnComoString("ST*", "*", "~") + subTrama_BHT.returnComoString("BHT*", "*", "~") + subTrama_HL1.returnComoString("HL*", "*", "~") + subTrama_NM11.returnComoString("NM1*", "*", "~") + subTrama_REF1.returnComoString("REF*", "*", "~") + subTrama_HL2.returnComoString("HL*", "*", "~") + sDetalle + subTrama_HL3.returnComoString("HL*", "*", "~") + sDetalle1;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 691 */     String canTxSE = cantidaSegementosTx(sReturn);
/*     */     
/*     */ 
/* 694 */     SubTrama_SE subTrama_SE = new SubTrama_SE();
/* 695 */     subTrama_SE.generaSubTrama(canTxSE, inRegafiUpdate.getNuControlST());
/* 696 */     subTrama_SE.completaLongitud();
/*     */     
/*     */ 
/* 699 */     SubTrama_GE subTrama_GE = new SubTrama_GE();
/* 700 */     subTrama_GE.generaSubTrama(inRegafiUpdate.getNuControl());
/* 701 */     subTrama_GE.completaLongitud();
/*     */     
/*     */ 
/* 704 */     SubTrama_IEA subTrama_IEA = new SubTrama_IEA();
/* 705 */     subTrama_IEA.generaSubTrama(inRegafiUpdate.getIdCorrelativo());
/* 706 */     subTrama_IEA.completaLongitud();
/*     */     
/*     */ 
/* 709 */     sReturn01 = sReturn + subTrama_SE.returnComoString("SE*", "*", "~") + subTrama_GE.returnComoString("GE*", "*", "~") + subTrama_IEA.returnComoString("IEA*", "*", "~");
/*     */     
/*     */ 
/*     */ 
/* 713 */     return sReturn01;
/*     */   }
/*     */   
/*     */   private static String cantidaSegementosTx(String sReturn) {
/* 717 */     String[] arrayCadena = sReturn.split("\\~");
/* 718 */     Integer longArray = Integer.valueOf(arrayCadena.length);
/* 719 */     return longArray.toString();
/*     */   }
/*     */ }


