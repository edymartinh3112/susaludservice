/*     */ package pe.com.susalud.jr.transaccion.afiliacion.bean;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class In271RegafiUpdate
/*     */ {
/*     */   private String noTransaccion;
/*     */   private String idRemitente;
/*     */   private String idReceptor;
/*     */   private String feTransaccion;
/*     */   private String hoTransaccion;
/*     */   private String idCorrelativo;
/*     */   private String idTransaccion;
/*     */   private String tiFinalidad;
/*     */   private String caRemitente;
/*     */   private String tiOperacion;
/*     */   private ArrayList<In271RegafiUpdateAfiliado> in271RegafiUpdateAfiliado;
/*     */   private ArrayList<In271RegafiUpdateAfiliacion> in271RegafiUpdateAfiliacion;
/*     */   private String coError;
/*     */   private String nuControl;
/*     */   private String nuControlST;
/*     */   
/*     */   public In271RegafiUpdate()
/*     */   {
/*  32 */     this.in271RegafiUpdateAfiliado = new ArrayList();
/*  33 */     this.in271RegafiUpdateAfiliacion = new ArrayList();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getNoTransaccion()
/*     */   {
/*  42 */     return this.noTransaccion;
/*     */   }
/*     */   
/*     */   public void setNoTransaccion(String noTransaccion) {
/*  46 */     if (noTransaccion != null) this.noTransaccion = noTransaccion.trim(); else this.noTransaccion = "";
/*     */   }
/*     */   
/*     */   public String getIdRemitente() {
/*  50 */     return this.idRemitente;
/*     */   }
/*     */   
/*     */   public void setIdRemitente(String idRemitente) {
/*  54 */     if (idRemitente != null) this.idRemitente = idRemitente.trim(); else this.idRemitente = "";
/*     */   }
/*     */   
/*     */   public String getIdReceptor() {
/*  58 */     return this.idReceptor;
/*     */   }
/*     */   
/*     */   public void setIdReceptor(String idReceptor) {
/*  62 */     if (idReceptor != null) this.idReceptor = idReceptor.trim(); else this.idReceptor = "";
/*     */   }
/*     */   
/*     */   public String getFeTransaccion() {
/*  66 */     return this.feTransaccion;
/*     */   }
/*     */   
/*     */   public void setFeTransaccion(String feTransaccion) {
/*  70 */     if (feTransaccion != null) this.feTransaccion = feTransaccion.trim(); else this.feTransaccion = "";
/*     */   }
/*     */   
/*     */   public String getHoTransaccion() {
/*  74 */     return this.hoTransaccion;
/*     */   }
/*     */   
/*     */   public void setHoTransaccion(String hoTransaccion) {
/*  78 */     if (hoTransaccion != null) this.hoTransaccion = hoTransaccion.trim(); else this.hoTransaccion = "";
/*     */   }
/*     */   
/*     */   public String getIdCorrelativo() {
/*  82 */     return this.idCorrelativo;
/*     */   }
/*     */   
/*     */   public void setIdCorrelativo(String idCorrelativo) {
/*  86 */     if (idCorrelativo != null) this.idCorrelativo = idCorrelativo.trim(); else this.idCorrelativo = "";
/*     */   }
/*     */   
/*     */   public String getIdTransaccion() {
/*  90 */     return this.idTransaccion;
/*     */   }
/*     */   
/*     */   public void setIdTransaccion(String idTransaccion) {
/*  94 */     if (idTransaccion != null) this.idTransaccion = idTransaccion.trim(); else this.idTransaccion = "";
/*     */   }
/*     */   
/*     */   public String getTiFinalidad() {
/*  98 */     return this.tiFinalidad;
/*     */   }
/*     */   
/*     */   public void setTiFinalidad(String tiFinalidad) {
/* 102 */     if (tiFinalidad != null) this.tiFinalidad = tiFinalidad.trim(); else this.tiFinalidad = "";
/*     */   }
/*     */   
/*     */   public String getCaRemitente() {
/* 106 */     return this.caRemitente;
/*     */   }
/*     */   
/*     */   public void setCaRemitente(String caRemitente) {
/* 110 */     if (caRemitente != null) this.caRemitente = caRemitente.trim(); else this.caRemitente = "";
/*     */   }
/*     */   
/*     */   public String getTiOperacion() {
/* 114 */     return this.tiOperacion;
/*     */   }
/*     */   
/*     */   public void setTiOperacion(String tiOperacion) {
/* 118 */     if (tiOperacion != null) this.tiOperacion = tiOperacion.trim(); else this.tiOperacion = "";
/*     */   }
/*     */   
/*     */   public String getNuControl() {
/* 122 */     return this.nuControl;
/*     */   }
/*     */   
/*     */   public void setNuControl(String nuControl) {
/* 126 */     this.nuControl = nuControl.trim();
/*     */   }
/*     */   
/*     */   public String getNuControlST() {
/* 130 */     return this.nuControlST;
/*     */   }
/*     */   
/*     */   public void setNuControlST(String nuControlST) {
/* 134 */     this.nuControlST = nuControlST.trim();
/*     */   }
/*     */   
/*     */   public String getCoError() {
/* 138 */     return this.coError;
/*     */   }
/*     */   
/*     */   public void setCoError(String coError) {
/* 142 */     this.coError = coError.trim();
/*     */   }
/*     */   
/*     */ 
/*     */   public void addDetalle(In271RegafiUpdateAfiliado detalleAfiliado)
/*     */   {
/* 148 */     this.in271RegafiUpdateAfiliado.add(detalleAfiliado);
/*     */   }
/*     */   
/*     */   public List<In271RegafiUpdateAfiliado> getDetallesAfiliados() {
/* 152 */     return this.in271RegafiUpdateAfiliado;
/*     */   }
/*     */   
/*     */   public ArrayList<In271RegafiUpdateAfiliado> getIn271RegafiUpdateAfiliado() {
/* 156 */     return this.in271RegafiUpdateAfiliado;
/*     */   }
/*     */   
/*     */   public void setIn271RegafiUpdateAfiliado(ArrayList<In271RegafiUpdateAfiliado> in271RegafiUpdateAfiliado) {
/* 160 */     this.in271RegafiUpdateAfiliado = in271RegafiUpdateAfiliado;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void addDetalle(In271RegafiUpdateAfiliacion detalleAfiliacion)
/*     */   {
/* 167 */     this.in271RegafiUpdateAfiliacion.add(detalleAfiliacion);
/*     */   }
/*     */   
/*     */   public List<In271RegafiUpdateAfiliacion> getDetallesAfiliaciones() {
/* 171 */     return this.in271RegafiUpdateAfiliacion;
/*     */   }
/*     */   
/*     */   public ArrayList<In271RegafiUpdateAfiliacion> getIn271RegafiUpdateAfiliacion() {
/* 175 */     return this.in271RegafiUpdateAfiliacion;
/*     */   }
/*     */   
/*     */   public void setIn271ResSctrDetalle(ArrayList<In271RegafiUpdateAfiliacion> in271RegafiUpdateAfiliacion) {
/* 179 */     this.in271RegafiUpdateAfiliacion = in271RegafiUpdateAfiliacion;
/*     */   }
/*     */ }


/* Location:              D:\WorkSpace\Desarrollo Afiliacion On Linea\Fuentes\FebanAfiliacionesFH\lib\jr-afiliacion-susalud_v1.5.jar!\pe\gob\susalud\jr\transaccion\susalud\bean\In271RegafiUpdate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */