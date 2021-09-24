/*    */ package pe.com.susalud.jr.transaccion.afiliacion.service.impl;
/*    */ 
/*    */ import java.io.PrintStream;

		import pe.com.susalud.jr.transaccion.afiliacion.bean.In271RegafiUpdate;
		import pe.com.susalud.jr.transaccion.afiliacion.service.RegafiUpdate271Service;
		import pe.com.susalud.jr.transaccion.afiliacion.util.ReagfiUpdate271_ToX12N;
		import pe.com.susalud.jr.transaccion.afiliacion.util.RegafiUpdate271_ToBean;
		import pe.com.susalud.jr.transaccion.afiliacion.validator.RegafiUpdate271_00Validador;
/*    */ //import pe.gob.susalud.jr.transaccion.susalud.bean.In271RegafiUpdate;
/*    */ //import pe.gob.susalud.jr.transaccion.susalud.service.RegafiUpdate271Service;
/*    */ //import pe.gob.susalud.jr.transaccion.susalud.util.ReagfiUpdate271_ToX12N;
/*    */ //import pe.gob.susalud.jr.transaccion.susalud.util.RegafiUpdate271_ToBean;
/*    */ //import pe.gob.susalud.jr.transaccion.susalud.validator.RegafiUpdate271_00Validador;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RegafiUpdate271ServiceImpl
/*    */   implements RegafiUpdate271Service
/*    */ {
/*    */   public String beanToX12N(In271RegafiUpdate in271RegafiUpdate)
/*    */   {
/* 21 */     String sX12N = "";
/* 22 */     String validar = "";
/* 23 */     if (in271RegafiUpdate == null) {
/* 24 */ //      System.out.println("[Cod 0110] Bean in271RegafiUpdate nulo");
/* 26 */       sX12N = "0010";
/*    */     } else {
/* 28 */   //    System.out.println("El Bean in271RegafiUpdate es diferente a null000000");
/* 30 */       RegafiUpdate271_00Validador Validador = new RegafiUpdate271_00Validador();
/* 32 */       validar = Validador.ValidateBeanInRegafiUpdate271(in271RegafiUpdate);
/* 33 */       System.out.print("*****CODIGO ERROR <<" + in271RegafiUpdate.getCoError() + ">>\n");/*    */
/* 35 */       /*if (validar.equals("0000")) {*/
/* 36 */         sX12N = ReagfiUpdate271_ToX12N.traducirEstructura270(in271RegafiUpdate);
/*    */       //} else {
/* 38 */         //sX12N = "<< Validator Código >>[" + validar + "]";
/* 39 */         //in271RegafiUpdate.setCoError(validar);
/*    */       //}
/*    */     }
/* 42 */     return sX12N;
/*    */   }
/*    */   
/*    */   public In271RegafiUpdate x12NToBean(String sX12N)
/*    */   {
/* 47 */     RegafiUpdate271_ToBean regafiUpdate271_ToBean = new RegafiUpdate271_ToBean();
/* 48 */     In271RegafiUpdate in271RegafiUpdate = RegafiUpdate271_ToBean.traducirEstructura271(sX12N);
/* 49 */     return in271RegafiUpdate;
/*    */   }
/*    */ }

