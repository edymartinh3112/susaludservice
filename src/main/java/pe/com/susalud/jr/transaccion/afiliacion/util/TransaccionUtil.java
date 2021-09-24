/*    */ package pe.com.susalud.jr.transaccion.afiliacion.util;
/*    */ 
/*    */ import java.util.Random;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TransaccionUtil
/*    */ {
/*    */   public static String generarAleatorio(int iLimite, int iLongitud)
/*    */   {
/* 11 */     String sRetorno = "";
/* 12 */     Random r = new Random();
/*    */     
/*    */ 
/* 15 */     boolean flag = true;
/* 16 */     while (flag) {
/* 17 */       sRetorno = String.valueOf(r.nextInt(iLimite + 1));
/* 18 */       if (sRetorno.length() != iLongitud) flag = true; else
/* 19 */         flag = false;
/*    */     }
/* 21 */     return sRetorno;
/*    */   }
/*    */   
/*    */   public static String generarAleatorioST(int iLimite, int iLongitud) {
/* 25 */     String sRetorno = "";
/* 26 */     Random r = new Random();
/*    */     
/*    */ 
/* 29 */     boolean flag = true;
/* 30 */     while (flag) {
/* 31 */       sRetorno = String.valueOf(r.nextInt(iLimite + 1));
/* 32 */       if (sRetorno.length() != iLongitud) flag = true; else
/* 33 */         flag = false;
/*    */     }
/* 35 */     return sRetorno;
/*    */   }
/*    */ }

