package pe.com.susalud.afiliacion.transaccion.bean;

import java.util.ArrayList;
import java.util.List;

public class In997RegafiUpdateExcepcion {
	/*    */   private String excBD;
	/*    */   
	/*    */   private String coCampoErr;
	/*    */   
	/*    */   private String inCoErrorEncontrado;
	/*    */   
	/*    */   private String pkAfiliado;
	/*    */   
	/*    */   private String pkAfiliadopkAfiliacion;
	/* 15 */   private boolean flagExcepcion = true;
	/*    */   
	/*    */   public String getExcBD() {
	/* 18 */     return this.excBD;
	/*    */   }
	/*    */   
	/*    */   public void setExcBD(String excBD) {
	/* 22 */     if (this.flagExcepcion) {
	/* 23 */       if (excBD != null) this.excBD = excBD.trim(); else this.excBD = "";
	/*    */     }
	/* 25 */     else if (excBD != null) this.excBD = excBD; else this.excBD = "";
	/*    */   }
	/*    */   
	/*    */   public String getCoCampoErr()
	/*    */   {
	/* 30 */     return this.coCampoErr;
	/*    */   }
	/*    */   
	/*    */   public void setCoCampoErr(String coCampoErr) {
	/* 34 */     if (this.flagExcepcion) {
	/* 35 */       if (coCampoErr != null) this.coCampoErr = coCampoErr.trim(); else this.coCampoErr = "";
	/*    */     }
	/* 37 */     else if (coCampoErr != null) this.coCampoErr = coCampoErr; else this.coCampoErr = "";
	/*    */   }
	/*    */   
	/*    */   public String getInCoErrorEncontrado()
	/*    */   {
	/* 42 */     return this.inCoErrorEncontrado;
	/*    */   }
	/*    */   
	/*    */   public void setInCoErrorEncontrado(String inCoErrorEncontrado) {
	/* 46 */     if (this.flagExcepcion) {
	/* 47 */       if (inCoErrorEncontrado != null) this.inCoErrorEncontrado = inCoErrorEncontrado.trim(); else this.inCoErrorEncontrado = "";
	/*    */     }
	/* 49 */     else if (inCoErrorEncontrado != null) this.inCoErrorEncontrado = inCoErrorEncontrado; else this.inCoErrorEncontrado = "";
	/*    */   }
	/*    */   
	/*    */   public String getPkAfiliado()
	/*    */   {
	/* 54 */     return this.pkAfiliado;
	/*    */   }
	/*    */   
	/*    */   public void setPkAfiliado(String pkAfiliado) {
	/* 58 */     if (this.flagExcepcion) {
	/* 59 */       if (pkAfiliado != null) this.pkAfiliado = pkAfiliado.trim(); else this.pkAfiliado = "";
	/*    */     }
	/* 61 */     else if (pkAfiliado != null) this.pkAfiliado = pkAfiliado; else this.pkAfiliado = "";
	/*    */   }
	/*    */   
	/*    */   public String getPkAfiliadopkAfiliacion()
	/*    */   {
	/* 66 */     return this.pkAfiliadopkAfiliacion;
	/*    */   }
	/*    */   
	/*    */   public void setPkAfiliadopkAfiliacion(String pkAfiliadopkAfiliacion) {
	/* 70 */     if (this.flagExcepcion) {
	/* 71 */       if (pkAfiliadopkAfiliacion != null) this.pkAfiliadopkAfiliacion = pkAfiliadopkAfiliacion.trim(); else this.pkAfiliadopkAfiliacion = "";
	/*    */     }
	/* 73 */     else if (pkAfiliadopkAfiliacion != null) this.pkAfiliadopkAfiliacion = pkAfiliadopkAfiliacion; else this.pkAfiliadopkAfiliacion = "";
	/*    */   }
	/*    */   
	/*    */   public boolean isFlagExcepcion()
	/*    */   {
	/* 78 */     return this.flagExcepcion;
	/*    */   }
	/*    */   
	/*    */   public void setFlagExcepcion(boolean flagExcepcion) {
	/* 82 */     this.flagExcepcion = flagExcepcion;
	/*    */   }
}
