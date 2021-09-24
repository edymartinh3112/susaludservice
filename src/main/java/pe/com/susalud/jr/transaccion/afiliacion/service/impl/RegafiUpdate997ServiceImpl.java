/*    */ package pe.com.susalud.jr.transaccion.afiliacion.service.impl;
		 import pe.com.susalud.jr.transaccion.afiliacion.bean.In997RegafiUpdate;
		 import pe.com.susalud.jr.transaccion.afiliacion.service.RegafiUpdate997Service;
		 import pe.com.susalud.jr.transaccion.afiliacion.util.RegafiUpdate997_ToBean;
		 import pe.com.susalud.jr.transaccion.afiliacion.util.RegafiUpdate997_ToXs12N;
/*    */ 
/*    */ //import pe.gob.susalud.jr.transaccion.susalud.bean.In997RegafiUpdate;
/*    */ //import pe.gob.susalud.jr.transaccion.susalud.service.RegafiUpdate997Service;
/*    */ //import pe.gob.susalud.jr.transaccion.susalud.util.RegafiUpdate997_ToBean;
/*    */ //import pe.gob.susalud.jr.transaccion.susalud.util.RegafiUpdate997_ToXs12N;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RegafiUpdate997ServiceImpl
/*    */   implements RegafiUpdate997Service
/*    */ {
/*    */   public String beanToX12N(In997RegafiUpdate in997RegafiUpdate)
/*    */   {
/* 18 */     String sX12N = "";
/* 19 */     sX12N = RegafiUpdate997_ToXs12N.traducirEstructura997RegafiUpdate(in997RegafiUpdate);
/*    */     
/* 21 */     return sX12N;
/*    */   }
/*    */   
/*    */   public In997RegafiUpdate x12NToBean(String sX12N)
/*    */   {
/* 26 */     RegafiUpdate997_ToBean regafiUpdate997_ToBean = new RegafiUpdate997_ToBean();
/* 27 */     In997RegafiUpdate in997RegafiUpdate = regafiUpdate997_ToBean.traducirEstructura997RegafiUpdate(sX12N);
/* 28 */     return in997RegafiUpdate;
/*    */   }
/*    */ }


/* Location:              D:\WorkSpace\Desarrollo Afiliacion On Linea\Fuentes\FebanAfiliacionesFH\lib\jr-afiliacion-susalud_v1.5.jar!\pe\gob\susalud\jr\transaccion\susalud\service\imp\RegafiUpdate997ServiceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */