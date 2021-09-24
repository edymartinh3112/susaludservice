/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.susalud.afiliacion.business;

/**
 *
 * @author fhuancco
 */

import java.util.ArrayList;
//import CapaEntidad.Afiliacion;
//import tramasusalud.ClsConnectionMQ;
import pe.com.susalud.afiliacion.dao.clsDatos;
import pe.com.susalud.afiliacion.entidad.bean.Afiliacion;
import pe.com.susalud.afiliacion.entidad.bean.AfiliacionData;
import pe.com.susalud.afiliacion.entidad.bean.AfiliacionDataDet;
import pe.com.susalud.afiliacion.entidad.bean.Constante;
import pe.com.susalud.afiliacion.entidad.bean.SusaludTrama;
import pe.com.susalud.afiliacion.entidad.bean.Tramax;
import pe.com.susalud.afiliacion.trama.ClsConnectionMQ;
import pe.gob.susalud.jr.transaccion.susalud.bean.In271RegafiUpdate;
import pe.gob.susalud.jr.transaccion.susalud.bean.In271RegafiUpdateAfiliacion;
import pe.gob.susalud.jr.transaccion.susalud.bean.In271RegafiUpdateAfiliado;
import pe.gob.susalud.jr.transaccion.susalud.service.imp.RegafiUpdate271ServiceImpl;
//import CapaDatos.clsDatos;
//import CapaEntidad.AfiliacionData;
//import CapaEntidad.AfiliacionDataDet;
//import CapaEntidad.Constante;
//import CapaEntidad.In271RegafiUpdateAfiliacion2;
//import CapaEntidad.SusaludTrama;
////import CapaEntidad.Tramax;
//import afiliacionfeban.frmAfiliacion;
import com.ibm.mq.commonservices.internal.utils.CommonServices;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import pe.gob.susalud.jr.transaccion.susalud.bean.In997RegafiUpdate;
import pe.gob.susalud.jr.transaccion.susalud.bean.In997RegafiUpdateExcepcion;
import pe.gob.susalud.jr.transaccion.susalud.service.RegafiUpdate997Service;
import pe.gob.susalud.jr.transaccion.susalud.service.imp.RegafiUpdate997ServiceImpl;

public class clsNegocio {
        // Constructor
    private clsDatos ObjD;
    
    private final int TIEMPO_ESPERA_MILISEC_271 = 3000 ;
    private final int TIEMPO_ESPERA_MILISEC_997 = 10000;    
    private static final String tag271 = "txPeticion";
    private static final String tag997 = "txRespuesta";     
    
    public clsNegocio() {
        this.ObjD = new clsDatos();
    }
    public ArrayList VerAfiliados(){
        return this.ObjD.VerAfiliado();
    }
    public ArrayList ListaAfiliados(){
        return this.ObjD.ListaAfiliados();
    }
    public ArrayList ListaAfiliadosParam(String cod){
        return this.ObjD.ListaAfiliadosParam(cod);
    }
    public ArrayList ListaTrama997(){
        return this.ObjD.ListaTrama997();
    }
    
    public ArrayList ListaAfiliadosPrueba(){
        return this.ObjD.ListaAfiliadosPrueba();
    }
    
    public ArrayList ListarAfiliacion(String fechaInicio, String fechaFin, int tipoAfi) throws  Exception{
        return this.ObjD.ListarAfiliacion(fechaInicio, fechaFin, tipoAfi);
    }
    
    public ArrayList<AfiliacionDataDet> ListarTrama(String cod) throws Exception {
        return this.ObjD.ListarTrama(cod);
    }
    
    public boolean InsertarAfiliacion(AfiliacionData a) throws Exception{
        boolean respuesta = this.ObjD.InsertarAfiliacion(a);
        if(respuesta = true){
            
            //System.out.println("Codigo: " + Constante.codigoEnvioSusalud + "\n");
           // System.out.println("Codigo2: " + cod + "\n");
            //ActualizarafiliadosParam(Constante.codigoEnvioSusalud);
            System.out.println("*****COD:" + Constante.codigoEnvioSusalud);
            AfiliadosTramaX12Parm(Constante.codigoEnvioSusalud);
        }
        else{
            respuesta = false;
        }
        return respuesta;
    }
    
    public String ActualizarafiliadosParam(String cod) 
    {        
        int ll_noprocesados  = 0;
        int ll_procesados    = 0;        
        int li_vector        = 0;        
        /**mensaje de error**/
        String coExcBD      = null;
        String ls_respuesta = null;
        String ls_error     = ""  ;        
        String xcoDescripError;
        String xcoCampoErr ;        
        
        
        String sError = "9999";
        ArrayList<Afiliacion> listaAfiliacion = new ArrayList<Afiliacion>();                 
        List<String> listaResultado = new ArrayList();               
        listaAfiliacion = ListaAfiliadosParam(cod);       
        if(listaAfiliacion!=null){
            for(int i = 0; i < listaAfiliacion.size() ; i++){
                In271RegafiUpdate           rRegafi     = new In271RegafiUpdate();
                In271RegafiUpdateAfiliado   rAfiliado   = new In271RegafiUpdateAfiliado();
                In271RegafiUpdateAfiliacion rAfiliacion = new In271RegafiUpdateAfiliacion();                                
                Afiliacion afilia = listaAfiliacion.get(i);                                                
                // Datos de cabecera del formato X12N - Constantes
                rRegafi.setNoTransaccion("271_REGAFI_UPDATE");                
                rRegafi.setIdTransaccion("271");
                rRegafi.setIdReceptor("SUSALUD"); 
                rRegafi.setTiFinalidad("13");
                rRegafi.setCaRemitente("2");
                 // Datos de cabecera del formato X12N - Variables
                rRegafi.setIdCorrelativo(String.valueOf(i+100000000));
                rRegafi.setIdRemitente(afilia.getIdRemitente());
                rRegafi.setFeTransaccion(afilia.getFeTransaccion());
                rRegafi.setHoTransaccion(afilia.getHoTransaccion());
                rRegafi.setTiOperacion(afilia.getTiOperacion()); 
                /*****Si existe informacion*****/                             
                 // Datos del afiliado 
                if(afilia.getApPaternoAfiliado()!=null)    rAfiliado.setApPaternoAfiliado(afilia.getApPaternoAfiliado());// else rAfiliado.setApPaternoAfiliado(afilia.getApPaternoAfiliado());
                if(afilia.getNoAfiliado1()!=null)          rAfiliado.setNoAfiliado1(afilia.getNoAfiliado1());// else rAfiliado.setNoAfiliado1("");
                if(afilia.getNoAfiliado2()!=null)          rAfiliado.setNoAfiliado2(afilia.getNoAfiliado2()); //else rAfiliado.setNoAfiliado2("");
                if(afilia.getApMaternoAfiliado()!=null)    rAfiliado.setApMaternoAfiliado(afilia.getApMaternoAfiliado()); // else rAfiliado.setApMaternoAfiliado("");
                if(afilia.getTiDocumentoAfil()!=null)      rAfiliado.setTiDocumentoAfil(afilia.getTiDocumentoAfil()); //else rAfiliado.setTiDocumentoAfil("");
                if(afilia.getNuDocumentoAfil()!=null)      rAfiliado.setNuDocumentoAfil(afilia.getNuDocumentoAfil()); //else rAfiliado.setNuDocumentoAfil("");
                if(afilia.getEstadoAfiliado()!=null)       rAfiliado.setEstadoAfiliado(afilia.getEstadoAfiliado());  //else rAfiliado.setEstadoAfiliado("");                
                if(afilia.getTiDocumentoAct()!=null)       rAfiliado.setTiDocumentoAct(afilia.getTiDocumentoAct());    //    else rAfiliado.setTiDocumentoAct("1") ; 
                if(afilia.getNuDocumentoAct()!=null)       rAfiliado.setNuDocumentoAct(afilia.getNuDocumentoAct()); //else rAfiliado.setNuDocumentoAct("45722376") ;
                if(afilia.getApCasadaAfiliado()!=null)     rAfiliado.setApCasadaAfiliado(afilia.getApCasadaAfiliado()); //     else rAfiliado.setApCasadaAfiliado("") ;
                if(afilia.getCoNacionalidad()!=null)       rAfiliado.setCoNacionalidad(afilia.getCoNacionalidad());//       else rAfiliado.setCoNacionalidad("") ;
                if(afilia.getUbigeo()!=null)               rAfiliado.setUbigeo(afilia.getUbigeo());               // else rAfiliado.setUbigeo("0") ;
                if(afilia.getFeNacimiento()!=null)         rAfiliado.setFeNacimiento(afilia.getFeNacimiento());   //else rAfiliado.setFeNacimiento("19890304") ;
                if(afilia.getGenero()!=null)               rAfiliado.setGenero(afilia.getGenero());                //else rAfiliado.setGenero("1") ;
                if(afilia.getCoPaisDoc()!=null)            rAfiliado.setCoPaisDoc(afilia.getCoPaisDoc());           //else rAfiliado.setCoPaisDoc("PER") ;
                if(afilia.getFeFallecimiento()!=null)      rAfiliado.setFefallecimiento(afilia.getFeFallecimiento()); // else rAfiliado.setFefallecimiento("19000101") ;
                if(afilia.getCoPaisEmisorDocAct()!=null)   rAfiliado.setCoPaisEmisorDocAct(afilia.getCoPaisEmisorDocAct()); //    else rAfiliado.setCoPaisEmisorDocAct("") ;
                if(afilia.getFeActPersonaxIafas()!=null)   rAfiliado.setFeActPersonaxIafas(afilia.getFeActPersonaxIafas()); //else rAfiliado.setFeActPersonaxIafas("20150106") ;
                if(afilia.getIdAfiliadoNombre()!=null)     rAfiliado.setIdAfiliadoNombre(afilia.getIdAfiliadoNombre());     //    else rAfiliado.setIdAfiliadoNombre("0") ;
                if(afilia.getTiDocTutor()!=null)           rAfiliado.setTiDocTutor(afilia.getTiDocTutor());                //else rAfiliado.setTiDocTutor("1") ;
                if(afilia.getNuDocTutor()!=null)           rAfiliado.setNuDocTutor(afilia.getNuDocTutor());                //else rAfiliado.setNuDocTutor("45722376") ;
                if(afilia.getTiVinculoTutor()!=null)       rAfiliado.setTiVinculoTutor(afilia.getTiVinculoTutor());          // else rAfiliado.setTiVinculoTutor("17") ;
                if(afilia.getFeValidacionReniec()!=null)   rAfiliado.setFeValidacionReniec(afilia.getFeValidacionReniec());     //   else rAfiliado.setFeValidacionReniec("0");
                if(afilia.getCoPaisEmisorDocTutor()!=null) rAfiliado.setCoPaisEmisorDocTutor(afilia.getCoPaisEmisorDocTutor());   // else rAfiliado.setCoPaisEmisorDocTutor("PER") ;

                if(afilia.getTiDocTitular()!=null)          rAfiliacion.setTiDocTitular(afilia.getTiDocTitular());
                if(afilia.getNuDocTitular()!=null)          rAfiliacion.setNuDocTitular(afilia.getNuDocTitular());
                if(afilia.getFeNacimientoTitular()!=null)   rAfiliacion.setFeNacimientoTitular(afilia.getFeNacimientoTitular());
                if(afilia.getCoPaisEmisorDocTitular()!=null)rAfiliacion.setCoPaisEmisorDocTitular(afilia.getCoPaisEmisorDocTitular());
                
                if(afilia.getTiContratante()!=null)              rAfiliacion.setTiContratante(afilia.getTiContratante());                          else rAfiliacion.setTiContratante("2");
                if(afilia.getApPaternoContratante()!=null)       rAfiliacion.setApPaternoContratante(afilia.getApPaternoContratante());            else rAfiliacion.setApPaternoContratante(""); 
                if(afilia.getNoContratante1()!=null)             rAfiliacion.setNoContratante1(afilia.getNoContratante1());                        else rAfiliacion.setNoContratante1("");
                if(afilia.getNoContratante2()!=null)             rAfiliacion.setNoContratante2(afilia.getNoContratante2());                        else rAfiliacion.setNoContratante2("");
                if(afilia.getNoContratante3()!=null)             rAfiliacion.setNoContratante3(afilia.getNoContratante3());                        else rAfiliacion.setNoContratante3("");
                if(afilia.getNoContratante4()!=null)             rAfiliacion.setNoContratante4(afilia.getNoContratante4());                        else rAfiliacion.setNoContratante4("");
                if(afilia.getApMaternoContratante()!=null)       rAfiliacion.setApMaternoContratante(afilia.getApMaternoContratante());            else rAfiliacion.setApMaternoContratante("");
                if(afilia.getTiDocContratante()!=null)           rAfiliacion.setTiDocContratante(afilia.getTiDocContratante());                    else rAfiliacion.setTiDocContratante("1");
                if(afilia.getNuDocContratante()!=null)           rAfiliacion.setNuDocContratante(afilia.getNuDocContratante());                    else rAfiliacion.setNuDocContratante("45722376");
                if(afilia.getApCasadaContratante()!=null)        rAfiliacion.setApCasadaContratante(afilia.getApCasadaContratante());              else rAfiliacion.setApCasadaContratante("");
                if(afilia.getFeNacimientoContratante()!=null)    rAfiliacion.setFeNacimientoContratante(afilia.getFeNacimientoContratante());      else rAfiliacion.setFeNacimientoContratante("");
                if(afilia.getCoPaisEmisorDocContratante()!=null) rAfiliacion.setCoPaisEmisorDocContratante(afilia.getCoPaisEmisorDocContratante());else rAfiliacion.setCoPaisEmisorDocContratante("PER");
                if(afilia.getCoAfiliacion()!=null)               rAfiliacion.setCoAfiliacion(afilia.getCoAfiliacion());                            else rAfiliacion.setCoAfiliacion("40002");
                if(afilia.getCoContrato()!=null)                 rAfiliacion.setCoContrato(afilia.getCoContrato());                                else rAfiliacion.setCoContrato("163675");
                if(afilia.getCoUnicoMultisectorial()!=null)      rAfiliacion.setCoUnicoMultisectorial(afilia.getCoUnicoMultisectorial());          else rAfiliacion.setCoUnicoMultisectorial("");
                if(afilia.getTiRegimen()!=null)                  rAfiliacion.setTiregimen(afilia.getTiRegimen());                                  else rAfiliacion.setTiregimen("1");
                if(afilia.getEsAfiliacion()!=null)               rAfiliacion.setEsAfiliacion(afilia.getEsAfiliacion());                            else rAfiliacion.setEsAfiliacion("5");                                               
                
                if(afilia.getCoCausalBaja()!=null)               rAfiliacion.setCoCausalBaja(afilia.getCoCausalBaja());                            else rAfiliacion.setCoCausalBaja(""); // CAMPO 56
                if(afilia.getTiPlanSalud()!=null)                rAfiliacion.setTiPlanSalud(afilia.getTiPlanSalud());                              else rAfiliacion.setTiPlanSalud("7");   // CAMPO 57
                if(afilia.getNoProductoSalud()!=null)            rAfiliacion.setNoProductoSalud(afilia.getNoProductoSalud());                      else rAfiliacion.setNoProductoSalud("AutoSeguro FEBAN"); // CAMPO 58
                if(afilia.getCoProducto()!=null)                 rAfiliacion.setCoProducto(afilia.getCoProducto());                                else rAfiliacion.setCoProducto("01"); // CAMPO 59
                if(afilia.getParentesco()!=null)                 rAfiliacion.setParentesco(afilia.getParentesco());                                else rAfiliacion.setParentesco("1"); // CAMPO 60 
                if(afilia.getCoRenipress()!=null)                rAfiliacion.setCoRenipress(afilia.getCoRenipress());                              else rAfiliacion.setCoRenipress(""); // CAMPO 61
                if(afilia.getPkAfiliado()!=null)                 rAfiliacion.setPkAfiliado(afilia.getPkAfiliado());                                else rAfiliacion.setPkAfiliado("PER145722376"); // CAMPO 62
                   //System.out.println(afilia.getPkAfiliado()); 
                
                if(afilia.getFeActEstado()!=null)                rAfiliacion.setFeActEstado(afilia.getFeActEstado());                              else rAfiliacion.setFeActEstado("20160328"); // CAMPO 63
                if(afilia.getFeIniAfiliacion()!=null)            rAfiliacion.setFeIniAfiliacion(afilia.getFeIniAfiliacion()) ;                     else rAfiliacion.setFeIniAfiliacion("20141217");  // CAMPO 64
                if(afilia.getFeFinAfiliacion()!=null)            rAfiliacion.setFeFinAfiliacion(afilia.getFeFinAfiliacion());                      else rAfiliacion.setFeFinAfiliacion("");// CAMPO 65
                if(afilia.getFeIniCobertura()!=null)             rAfiliacion.setFeIniCobertura(afilia.getFeIniCobertura());                        else rAfiliacion.setFeIniCobertura("");  // CAMPO 66
                if(afilia.getFeFinCobertura()!=null)             rAfiliacion.setFeFinCobertura(afilia.getFeFinCobertura());                        else rAfiliacion.setFeFinCobertura(""); // CAMPO 67
                if(afilia.getFeActOperacion()!=null)             rAfiliacion.setFeActOperacion(afilia.getFeActOperacion());                        else rAfiliacion.setFeActOperacion("");    // CAMPO 68
                if(afilia.getTiActOperacion()!=null)             rAfiliacion.setTiActOperacion(afilia.getTiActOperacion());                        else rAfiliacion.setTiActOperacion("120339");   // CAMPO 69
                if(afilia.getCoTiCobertura()!=null)              rAfiliacion.setCoTiCobertura(afilia.getCoTiCobertura());                          else rAfiliacion.setCoTiCobertura("4");      // CAMPO 70
                if(afilia.getIdAfiliacionNombre()!=null)         rAfiliacion.setIdAfiliacionNombre(afilia.getIdAfiliacionNombre());                else rAfiliacion.setIdAfiliacionNombre("000"); // CAMPO 71
                
                
                rRegafi.addDetalle(rAfiliado);
                rRegafi.addDetalle(rAfiliacion);
                RegafiUpdate271ServiceImpl regafi = new RegafiUpdate271ServiceImpl();                                    
                try {                    
                    String sTrama = regafi.beanToX12N(rRegafi);                    
                    sError = rRegafi.getCoError();
                    if(sError.equals("0000")) {
                        listaResultado.add(sTrama);
                        ll_procesados++ ;
                        /************************ENVIO A SUSALUD**********************/
                        String trama="";
                        trama=this.xmlTrama2(sTrama);    			
                        ClsConnectionMQ cnxmq = new ClsConnectionMQ();			
                        HashMap<String, String> haspmap = cnxmq.SendMessageSyn(trama);			
			
			
                        String tramaXML = haspmap.get("Msg");
                        String msgid     = haspmap.get("MsgId");	
			System.out.println(" msgid   ........................."+msgid);
			
                        String tramax12 = ExtraerX12N(tramaXML,tag997);			
                        RegafiUpdate997Service salida = new RegafiUpdate997ServiceImpl();					
                        In997RegafiUpdate bo = salida.x12NToBean(tramax12);
			
			
                        bo.setFlag(true);             
                        Vector<Vector<String>> dataVector = new Vector<Vector<String>>();
                        List<In997RegafiUpdateExcepcion> excepciones = bo.getDetallesExcepcion();                                    
                        ls_error="";
                        li_vector=0;
                        for (In997RegafiUpdateExcepcion ex : excepciones) {                                
                                Vector<String> fila = new Vector<String>();                    
                                String coCampoErr = ex.getCoCampoErr();                    
                                coExcBD           = ex.getExcBD();                    
                                fila.add(coExcBD);
                                fila.add(coCampoErr);                               
                                xcoCampoErr=ObjD.errorCampo(coCampoErr);                                                                
                                fila.add(String.valueOf(ex.isFlagExcepcion())); 
                                String coDescripError = ex.getInCoErrorEncontrado();
                                fila.add(coDescripError);                                                               
                                xcoDescripError=ObjD.errorDescripcion(coDescripError);
                                fila.add(ex.getPkAfiliado());
                                fila.add(ex.getPkAfiliadopkAfiliacion());						
                                ls_error +=" Base Error:"+coExcBD+" Error Campo:"+coCampoErr+":"+xcoCampoErr+" "+" Descripcion Error:"+coDescripError+":"+xcoDescripError +"\n" ;                    
                                dataVector.add(fila);                    
                                li_vector++;                            
                        }                           
                        SusaludTrama susaludTrama;
                        susaludTrama= new SusaludTrama();                            
                        susaludTrama.setIdafiliado(afilia.getPkAfiliado());                        
                        susaludTrama.setTtenvio("mBatch");
                        susaludTrama.setIdconfirmacion(msgid);
                        susaludTrama.setIderror(coExcBD);                       
                        susaludTrama.setNvector(li_vector);
                        susaludTrama.setXerror(ls_error);
                        susaludTrama.setXtramaenvio(sTrama);
                        susaludTrama.setXtramaretorno(tramaXML);                                                                  
                        ls_respuesta=ObjD.SusaludConfirmacion(susaludTrama);                                                
                        if (ls_respuesta.equals("true")){
                           System.out.println("Se Grabo Correctamente y envia trama"  );
                        }else{
                            System.out.println("Se Enviado la trama pero no se actualizo la confirmación." ); 
                        }                                                   
                        if (li_vector==1  && coExcBD.equals("0000")  ){                                                              
                        } else{                            
                            System.out.println("ERROR EN GRABAR Y TRAMAS" +ls_error );
                        }                                                  
                    }
                    else {
                        listaResultado.add(sError);
                        ll_noprocesados++ ;
                    }
                } catch (Exception e) {
                                       
                    listaResultado.add("Error: Verificar especificaciones tecnicas");
                }                
            }
        }   
        System.out.println(" ll_procesados " +ll_procesados );
        System.out.println(" ll_noprocesados " +ll_noprocesados );        
        return "";        
    }
    
    
    
    public String Actualizarafiliados() 
    {        
        int ll_noprocesados  = 0;
        int ll_procesados    = 0;        
        int li_vector        = 0;        
        /**mensaje de error**/
        String coExcBD      = null;
        String ls_respuesta = null;
        String ls_error     = ""  ;        
        String xcoDescripError;
        String xcoCampoErr ;        
        
        
        String sError = "9999";
        ArrayList<Afiliacion> listaAfiliacion = new ArrayList<Afiliacion>();                 
        List<String> listaResultado = new ArrayList();               
        listaAfiliacion = ListaAfiliados();       
        if(listaAfiliacion!=null){
            for(int i = 0; i < listaAfiliacion.size() ; i++){
                In271RegafiUpdate           rRegafi     = new In271RegafiUpdate();
                In271RegafiUpdateAfiliado   rAfiliado   = new In271RegafiUpdateAfiliado();
                In271RegafiUpdateAfiliacion rAfiliacion = new In271RegafiUpdateAfiliacion();                                
                Afiliacion afilia = listaAfiliacion.get(i);                                                
                // Datos de cabecera del formato X12N - Constantes
                rRegafi.setNoTransaccion("271_REGAFI_UPDATE");                
                rRegafi.setIdTransaccion("271");
                rRegafi.setIdReceptor("SUSALUD"); 
                rRegafi.setTiFinalidad("13");
                rRegafi.setCaRemitente("2");
                 // Datos de cabecera del formato X12N - Variables
                rRegafi.setIdCorrelativo(String.valueOf(i+100000000));
                rRegafi.setIdRemitente(afilia.getIdRemitente());
                rRegafi.setFeTransaccion(afilia.getFeTransaccion());
                rRegafi.setHoTransaccion(afilia.getHoTransaccion());
                rRegafi.setTiOperacion(afilia.getTiOperacion()); 
                /*****Si existe informacion*****/                             
                 // Datos del afiliado 
                if(afilia.getApPaternoAfiliado()!=null)    rAfiliado.setApPaternoAfiliado(afilia.getApPaternoAfiliado());// else rAfiliado.setApPaternoAfiliado(afilia.getApPaternoAfiliado());
                if(afilia.getNoAfiliado1()!=null)          rAfiliado.setNoAfiliado1(afilia.getNoAfiliado1());// else rAfiliado.setNoAfiliado1("");
                if(afilia.getNoAfiliado2()!=null)          rAfiliado.setNoAfiliado2(afilia.getNoAfiliado2()); //else rAfiliado.setNoAfiliado2("");
                if(afilia.getApMaternoAfiliado()!=null)    rAfiliado.setApMaternoAfiliado(afilia.getApMaternoAfiliado()); // else rAfiliado.setApMaternoAfiliado("");
                if(afilia.getTiDocumentoAfil()!=null)      rAfiliado.setTiDocumentoAfil(afilia.getTiDocumentoAfil()); //else rAfiliado.setTiDocumentoAfil("");
                if(afilia.getNuDocumentoAfil()!=null)      rAfiliado.setNuDocumentoAfil(afilia.getNuDocumentoAfil()); //else rAfiliado.setNuDocumentoAfil("");
                if(afilia.getEstadoAfiliado()!=null)       rAfiliado.setEstadoAfiliado(afilia.getEstadoAfiliado());  //else rAfiliado.setEstadoAfiliado("");                
                if(afilia.getTiDocumentoAct()!=null)       rAfiliado.setTiDocumentoAct(afilia.getTiDocumentoAct());    //    else rAfiliado.setTiDocumentoAct("1") ; 
                if(afilia.getNuDocumentoAct()!=null)       rAfiliado.setNuDocumentoAct(afilia.getNuDocumentoAct()); //else rAfiliado.setNuDocumentoAct("45722376") ;
                if(afilia.getApCasadaAfiliado()!=null)     rAfiliado.setApCasadaAfiliado(afilia.getApCasadaAfiliado()); //     else rAfiliado.setApCasadaAfiliado("") ;
                if(afilia.getCoNacionalidad()!=null)       rAfiliado.setCoNacionalidad(afilia.getCoNacionalidad());//       else rAfiliado.setCoNacionalidad("") ;
                if(afilia.getUbigeo()!=null)               rAfiliado.setUbigeo(afilia.getUbigeo());               // else rAfiliado.setUbigeo("0") ;
                if(afilia.getFeNacimiento()!=null)         rAfiliado.setFeNacimiento(afilia.getFeNacimiento());   //else rAfiliado.setFeNacimiento("19890304") ;
                if(afilia.getGenero()!=null)               rAfiliado.setGenero(afilia.getGenero());                //else rAfiliado.setGenero("1") ;
                if(afilia.getCoPaisDoc()!=null)            rAfiliado.setCoPaisDoc(afilia.getCoPaisDoc());           //else rAfiliado.setCoPaisDoc("PER") ;
                if(afilia.getFeFallecimiento()!=null)      rAfiliado.setFefallecimiento(afilia.getFeFallecimiento()); // else rAfiliado.setFefallecimiento("19000101") ;
                if(afilia.getCoPaisEmisorDocAct()!=null)   rAfiliado.setCoPaisEmisorDocAct(afilia.getCoPaisEmisorDocAct()); //    else rAfiliado.setCoPaisEmisorDocAct("") ;
                if(afilia.getFeActPersonaxIafas()!=null)   rAfiliado.setFeActPersonaxIafas(afilia.getFeActPersonaxIafas()); //else rAfiliado.setFeActPersonaxIafas("20150106") ;
                if(afilia.getIdAfiliadoNombre()!=null)     rAfiliado.setIdAfiliadoNombre(afilia.getIdAfiliadoNombre());     //    else rAfiliado.setIdAfiliadoNombre("0") ;
                if(afilia.getTiDocTutor()!=null)           rAfiliado.setTiDocTutor(afilia.getTiDocTutor());                //else rAfiliado.setTiDocTutor("1") ;
                if(afilia.getNuDocTutor()!=null)           rAfiliado.setNuDocTutor(afilia.getNuDocTutor());                //else rAfiliado.setNuDocTutor("45722376") ;
                if(afilia.getTiVinculoTutor()!=null)       rAfiliado.setTiVinculoTutor(afilia.getTiVinculoTutor());          // else rAfiliado.setTiVinculoTutor("17") ;
                if(afilia.getFeValidacionReniec()!=null)   rAfiliado.setFeValidacionReniec(afilia.getFeValidacionReniec());     //   else rAfiliado.setFeValidacionReniec("0");
                if(afilia.getCoPaisEmisorDocTutor()!=null) rAfiliado.setCoPaisEmisorDocTutor(afilia.getCoPaisEmisorDocTutor());   // else rAfiliado.setCoPaisEmisorDocTutor("PER") ;

                if(afilia.getTiDocTitular()!=null)          rAfiliacion.setTiDocTitular(afilia.getTiDocTitular());
                if(afilia.getNuDocTitular()!=null)          rAfiliacion.setNuDocTitular(afilia.getNuDocTitular());
                if(afilia.getFeNacimientoTitular()!=null)   rAfiliacion.setFeNacimientoTitular(afilia.getFeNacimientoTitular());
                if(afilia.getCoPaisEmisorDocTitular()!=null)rAfiliacion.setCoPaisEmisorDocTitular(afilia.getCoPaisEmisorDocTitular());
                
                if(afilia.getTiContratante()!=null)              rAfiliacion.setTiContratante(afilia.getTiContratante());                          else rAfiliacion.setTiContratante("2");
                if(afilia.getApPaternoContratante()!=null)       rAfiliacion.setApPaternoContratante(afilia.getApPaternoContratante());            else rAfiliacion.setApPaternoContratante(""); 
                if(afilia.getNoContratante1()!=null)             rAfiliacion.setNoContratante1(afilia.getNoContratante1());                        else rAfiliacion.setNoContratante1("");
                if(afilia.getNoContratante2()!=null)             rAfiliacion.setNoContratante2(afilia.getNoContratante2());                        else rAfiliacion.setNoContratante2("");
                if(afilia.getNoContratante3()!=null)             rAfiliacion.setNoContratante3(afilia.getNoContratante3());                        else rAfiliacion.setNoContratante3("");
                if(afilia.getNoContratante4()!=null)             rAfiliacion.setNoContratante4(afilia.getNoContratante4());                        else rAfiliacion.setNoContratante4("");
                if(afilia.getApMaternoContratante()!=null)       rAfiliacion.setApMaternoContratante(afilia.getApMaternoContratante());            else rAfiliacion.setApMaternoContratante("");
                if(afilia.getTiDocContratante()!=null)           rAfiliacion.setTiDocContratante(afilia.getTiDocContratante());                    else rAfiliacion.setTiDocContratante("1");
                if(afilia.getNuDocContratante()!=null)           rAfiliacion.setNuDocContratante(afilia.getNuDocContratante());                    else rAfiliacion.setNuDocContratante("45722376");
                if(afilia.getApCasadaContratante()!=null)        rAfiliacion.setApCasadaContratante(afilia.getApCasadaContratante());              else rAfiliacion.setApCasadaContratante("");
                if(afilia.getFeNacimientoContratante()!=null)    rAfiliacion.setFeNacimientoContratante(afilia.getFeNacimientoContratante());      else rAfiliacion.setFeNacimientoContratante("");
                if(afilia.getCoPaisEmisorDocContratante()!=null) rAfiliacion.setCoPaisEmisorDocContratante(afilia.getCoPaisEmisorDocContratante());else rAfiliacion.setCoPaisEmisorDocContratante("PER");
                if(afilia.getCoAfiliacion()!=null)               rAfiliacion.setCoAfiliacion(afilia.getCoAfiliacion());                            else rAfiliacion.setCoAfiliacion("40002");
                if(afilia.getCoContrato()!=null)                 rAfiliacion.setCoContrato(afilia.getCoContrato());                                else rAfiliacion.setCoContrato("163675");
                if(afilia.getCoUnicoMultisectorial()!=null)      rAfiliacion.setCoUnicoMultisectorial(afilia.getCoUnicoMultisectorial());          else rAfiliacion.setCoUnicoMultisectorial("");
                if(afilia.getTiRegimen()!=null)                  rAfiliacion.setTiregimen(afilia.getTiRegimen());                                  else rAfiliacion.setTiregimen("1");
                if(afilia.getEsAfiliacion()!=null)               rAfiliacion.setEsAfiliacion(afilia.getEsAfiliacion());                            else rAfiliacion.setEsAfiliacion("5");                                               
                
                if(afilia.getCoCausalBaja()!=null)               rAfiliacion.setCoCausalBaja(afilia.getCoCausalBaja());                            else rAfiliacion.setCoCausalBaja(""); // CAMPO 56
                if(afilia.getTiPlanSalud()!=null)                rAfiliacion.setTiPlanSalud(afilia.getTiPlanSalud());                              else rAfiliacion.setTiPlanSalud("7");   // CAMPO 57
                if(afilia.getNoProductoSalud()!=null)            rAfiliacion.setNoProductoSalud(afilia.getNoProductoSalud());                      else rAfiliacion.setNoProductoSalud("AutoSeguro FEBAN"); // CAMPO 58
                if(afilia.getCoProducto()!=null)                 rAfiliacion.setCoProducto(afilia.getCoProducto());                                else rAfiliacion.setCoProducto("01"); // CAMPO 59
                if(afilia.getParentesco()!=null)                 rAfiliacion.setParentesco(afilia.getParentesco());                                else rAfiliacion.setParentesco("1"); // CAMPO 60 
                if(afilia.getCoRenipress()!=null)                rAfiliacion.setCoRenipress(afilia.getCoRenipress());                              else rAfiliacion.setCoRenipress(""); // CAMPO 61
                if(afilia.getPkAfiliado()!=null)                 rAfiliacion.setPkAfiliado(afilia.getPkAfiliado());                                else rAfiliacion.setPkAfiliado("PER145722376"); // CAMPO 62
                   //System.out.println(afilia.getPkAfiliado()); 
                
                if(afilia.getFeActEstado()!=null)                rAfiliacion.setFeActEstado(afilia.getFeActEstado());                              else rAfiliacion.setFeActEstado("20160328"); // CAMPO 63
                if(afilia.getFeIniAfiliacion()!=null)            rAfiliacion.setFeIniAfiliacion(afilia.getFeIniAfiliacion()) ;                     else rAfiliacion.setFeIniAfiliacion("20141217");  // CAMPO 64
                if(afilia.getFeFinAfiliacion()!=null)            rAfiliacion.setFeFinAfiliacion(afilia.getFeFinAfiliacion());                      else rAfiliacion.setFeFinAfiliacion("");// CAMPO 65
                if(afilia.getFeIniCobertura()!=null)             rAfiliacion.setFeIniCobertura(afilia.getFeIniCobertura());                        else rAfiliacion.setFeIniCobertura("");  // CAMPO 66
                if(afilia.getFeFinCobertura()!=null)             rAfiliacion.setFeFinCobertura(afilia.getFeFinCobertura());                        else rAfiliacion.setFeFinCobertura(""); // CAMPO 67
                if(afilia.getFeActOperacion()!=null)             rAfiliacion.setFeActOperacion(afilia.getFeActOperacion());                        else rAfiliacion.setFeActOperacion("");    // CAMPO 68
                if(afilia.getTiActOperacion()!=null)             rAfiliacion.setTiActOperacion(afilia.getTiActOperacion());                        else rAfiliacion.setTiActOperacion("120339");   // CAMPO 69
                if(afilia.getCoTiCobertura()!=null)              rAfiliacion.setCoTiCobertura(afilia.getCoTiCobertura());                          else rAfiliacion.setCoTiCobertura("4");      // CAMPO 70
                if(afilia.getIdAfiliacionNombre()!=null)         rAfiliacion.setIdAfiliacionNombre(afilia.getIdAfiliacionNombre());                else rAfiliacion.setIdAfiliacionNombre("000"); // CAMPO 71
                
                
                rRegafi.addDetalle(rAfiliado);
                rRegafi.addDetalle(rAfiliacion);
                RegafiUpdate271ServiceImpl regafi = new RegafiUpdate271ServiceImpl();                                    
                try {                    
                    String sTrama = regafi.beanToX12N(rRegafi);                    
                    sError = rRegafi.getCoError();
                    if(sError.equals("0000")) {
                        listaResultado.add(sTrama);
                        ll_procesados++ ;
                        /************************ENVIO A SUSALUD**********************/
                        String trama="";
                        trama=this.xmlTrama2(sTrama);    			
                        ClsConnectionMQ cnxmq = new ClsConnectionMQ();			
                        HashMap<String, String> haspmap = cnxmq.SendMessageSyn(trama);			
			
			
                        String tramaXML = haspmap.get("Msg");
                        String msgid     = haspmap.get("MsgId");	
			System.out.println(" msgid   ........................."+msgid);
			
                        String tramax12 = ExtraerX12N(tramaXML,tag997);			
                        RegafiUpdate997Service salida = new RegafiUpdate997ServiceImpl();					
                        In997RegafiUpdate bo = salida.x12NToBean(tramax12);
			
			
                        bo.setFlag(true);             
                        Vector<Vector<String>> dataVector = new Vector<Vector<String>>();
                        List<In997RegafiUpdateExcepcion> excepciones = bo.getDetallesExcepcion();                                    
                        ls_error="";
                        li_vector=0;
                        for (In997RegafiUpdateExcepcion ex : excepciones) {                                
                                Vector<String> fila = new Vector<String>();                    
                                String coCampoErr = ex.getCoCampoErr();                    
                                coExcBD           = ex.getExcBD();                    
                                fila.add(coExcBD);
                                fila.add(coCampoErr);                               
                                xcoCampoErr=ObjD.errorCampo(coCampoErr);                                                                
                                fila.add(String.valueOf(ex.isFlagExcepcion())); 
                                String coDescripError = ex.getInCoErrorEncontrado();
                                fila.add(coDescripError);                                                               
                                xcoDescripError=ObjD.errorDescripcion(coDescripError);
                                fila.add(ex.getPkAfiliado());
                                fila.add(ex.getPkAfiliadopkAfiliacion());						
                                ls_error +=" Base Error:"+coExcBD+" Error Campo:"+coCampoErr+":"+xcoCampoErr+" "+" Descripcion Error:"+coDescripError+":"+xcoDescripError +"\n" ;                    
                                dataVector.add(fila);                    
                                li_vector++;                            
                        }                           
                        SusaludTrama susaludTrama;
                        susaludTrama= new SusaludTrama();                            
                        susaludTrama.setIdafiliado(afilia.getPkAfiliado());                        
                        susaludTrama.setTtenvio("mBatch");
                        susaludTrama.setIdconfirmacion(msgid);
                        susaludTrama.setIderror(coExcBD);                       
                        susaludTrama.setNvector(li_vector);
                        susaludTrama.setXerror(ls_error);
                        susaludTrama.setXtramaenvio(sTrama);
                        susaludTrama.setXtramaretorno(tramaXML);                                                                  
                        ls_respuesta=ObjD.SusaludConfirmacion(susaludTrama);                                                
                        if (ls_respuesta.equals("true")){
                           System.out.println("Se Grabo Correctamente y envia trama"  );
                        }else{
                            System.out.println("Se Enviado la trama pero no se actualizo la confirmación." ); 
                        }                                                   
                        if (li_vector==1  && coExcBD.equals("0000")  ){                                                              
                        } else{                            
                            System.out.println("ERROR EN GRABAR Y TRAMAS" +ls_error );
                        }                                                  
                    }
                    else {
                        listaResultado.add(sError);
                        ll_noprocesados++ ;
                    }
                } catch (Exception e) {
                                       
                    listaResultado.add("Error: Verificar especificaciones tecnicas");
                }                
            }
        }   
        System.out.println(" ll_procesados " +ll_procesados );
        System.out.println(" ll_noprocesados " +ll_noprocesados );        
        return "";        
    }
    public String AfiliadosTramaX12()
    {        
        int ll_noprocesados  = 0;
        int ll_procesados    = 0;        
        int li_vector        = 0;        
        /**mensaje de error**/
        String coExcBD      = null;
        String ls_respuesta = null;
        String ls_error     = ""  ;        
        String xcoDescripError;
        String xcoCampoErr ;        
        
        
        String sError = "9999";
        ArrayList<Afiliacion> listaAfiliacion = new ArrayList<Afiliacion>();                 
        //List<String> listaResultado = new ArrayList();               
        listaAfiliacion = ListaAfiliados();       
        if(listaAfiliacion!=null){
	    int numero=0;
            for(int i = 0; i < listaAfiliacion.size() ; i++){
		numero++;
                In271RegafiUpdate           rRegafi     = new In271RegafiUpdate();
                In271RegafiUpdateAfiliado   rAfiliado   = new In271RegafiUpdateAfiliado();
                In271RegafiUpdateAfiliacion rAfiliacion = new In271RegafiUpdateAfiliacion();                                
                Afiliacion afilia = listaAfiliacion.get(i);                                                
                // Datos de cabecera del formato X12N - Constantes
                rRegafi.setNoTransaccion("271_REGAFI_UPDATE");                
                rRegafi.setIdTransaccion("271");
                rRegafi.setIdReceptor("SUSALUD"); 
                rRegafi.setTiFinalidad("13");
                rRegafi.setCaRemitente("2");
                 // Datos de cabecera del formato X12N - Variables
                rRegafi.setIdCorrelativo(String.valueOf((numero+ 100000000)));
                rRegafi.setIdRemitente(afilia.getIdRemitente());
                rRegafi.setFeTransaccion(afilia.getFeTransaccion());
                rRegafi.setHoTransaccion(afilia.getHoTransaccion());
                rRegafi.setTiOperacion(afilia.getTiOperacion()); 
                /*****Si existe informacion*****/                             
                 // Datos del afiliado 
                if(afilia.getApPaternoAfiliado()!=null)    rAfiliado.setApPaternoAfiliado(afilia.getApPaternoAfiliado());// else rAfiliado.setApPaternoAfiliado(afilia.getApPaternoAfiliado());
                if(afilia.getNoAfiliado1()!=null)          rAfiliado.setNoAfiliado1(afilia.getNoAfiliado1());// else rAfiliado.setNoAfiliado1("");
                if(afilia.getNoAfiliado2()!=null)          rAfiliado.setNoAfiliado2(afilia.getNoAfiliado2()); //else rAfiliado.setNoAfiliado2("");
                if(afilia.getApMaternoAfiliado()!=null)    rAfiliado.setApMaternoAfiliado(afilia.getApMaternoAfiliado()); // else rAfiliado.setApMaternoAfiliado("");
                if(afilia.getTiDocumentoAfil()!=null)      rAfiliado.setTiDocumentoAfil(afilia.getTiDocumentoAfil()); //else rAfiliado.setTiDocumentoAfil("");
                if(afilia.getNuDocumentoAfil()!=null)      rAfiliado.setNuDocumentoAfil(afilia.getNuDocumentoAfil()); //else rAfiliado.setNuDocumentoAfil("");
                if(afilia.getEstadoAfiliado()!=null)       rAfiliado.setEstadoAfiliado(afilia.getEstadoAfiliado());  //else rAfiliado.setEstadoAfiliado("");                
                if(afilia.getTiDocumentoAct()!=null)       rAfiliado.setTiDocumentoAct(afilia.getTiDocumentoAct());    //    else rAfiliado.setTiDocumentoAct("1") ; 
                if(afilia.getNuDocumentoAct()!=null)       rAfiliado.setNuDocumentoAct(afilia.getNuDocumentoAct()); //else rAfiliado.setNuDocumentoAct("45722376") ;
                if(afilia.getApCasadaAfiliado()!=null)     rAfiliado.setApCasadaAfiliado(afilia.getApCasadaAfiliado()); //     else rAfiliado.setApCasadaAfiliado("") ;
                if(afilia.getCoNacionalidad()!=null)       rAfiliado.setCoNacionalidad(afilia.getCoNacionalidad());//       else rAfiliado.setCoNacionalidad("") ;
                if(afilia.getUbigeo()!=null)               rAfiliado.setUbigeo(afilia.getUbigeo());               // else rAfiliado.setUbigeo("0") ;
                if(afilia.getFeNacimiento()!=null)         rAfiliado.setFeNacimiento(afilia.getFeNacimiento());   //else rAfiliado.setFeNacimiento("19890304") ;
                if(afilia.getGenero()!=null)               rAfiliado.setGenero(afilia.getGenero());                //else rAfiliado.setGenero("1") ;
                if(afilia.getCoPaisDoc()!=null)            rAfiliado.setCoPaisDoc(afilia.getCoPaisDoc());           //else rAfiliado.setCoPaisDoc("PER") ;
                if(afilia.getFeFallecimiento()!=null)      rAfiliado.setFefallecimiento(afilia.getFeFallecimiento()); // else rAfiliado.setFefallecimiento("19000101") ;
                if(afilia.getCoPaisEmisorDocAct()!=null)   rAfiliado.setCoPaisEmisorDocAct(afilia.getCoPaisEmisorDocAct()); //    else rAfiliado.setCoPaisEmisorDocAct("") ;
                if(afilia.getFeActPersonaxIafas()!=null)   rAfiliado.setFeActPersonaxIafas(afilia.getFeActPersonaxIafas()); //else rAfiliado.setFeActPersonaxIafas("20150106") ;
                if(afilia.getIdAfiliadoNombre()!=null)     rAfiliado.setIdAfiliadoNombre(afilia.getIdAfiliadoNombre());     //    else rAfiliado.setIdAfiliadoNombre("0") ;
                if(afilia.getTiDocTutor()!=null)           rAfiliado.setTiDocTutor(afilia.getTiDocTutor());                //else rAfiliado.setTiDocTutor("1") ;
                if(afilia.getNuDocTutor()!=null)           rAfiliado.setNuDocTutor(afilia.getNuDocTutor());                //else rAfiliado.setNuDocTutor("45722376") ;
                if(afilia.getTiVinculoTutor()!=null)       rAfiliado.setTiVinculoTutor(afilia.getTiVinculoTutor());          // else rAfiliado.setTiVinculoTutor("17") ;
                if(afilia.getFeValidacionReniec()!=null)   rAfiliado.setFeValidacionReniec(afilia.getFeValidacionReniec());     //   else rAfiliado.setFeValidacionReniec("0");
                if(afilia.getCoPaisEmisorDocTutor()!=null) rAfiliado.setCoPaisEmisorDocTutor(afilia.getCoPaisEmisorDocTutor());   // else rAfiliado.setCoPaisEmisorDocTutor("PER") ;

                if(afilia.getTiDocTitular()!=null)          rAfiliacion.setTiDocTitular(afilia.getTiDocTitular());
                if(afilia.getNuDocTitular()!=null)          rAfiliacion.setNuDocTitular(afilia.getNuDocTitular());
                if(afilia.getFeNacimientoTitular()!=null)   rAfiliacion.setFeNacimientoTitular(afilia.getFeNacimientoTitular());
                if(afilia.getCoPaisEmisorDocTitular()!=null)rAfiliacion.setCoPaisEmisorDocTitular(afilia.getCoPaisEmisorDocTitular());
                
                if(afilia.getTiContratante()!=null)              rAfiliacion.setTiContratante(afilia.getTiContratante());                          else rAfiliacion.setTiContratante("2");
                if(afilia.getApPaternoContratante()!=null)       rAfiliacion.setApPaternoContratante(afilia.getApPaternoContratante());            else rAfiliacion.setApPaternoContratante(""); 
                if(afilia.getNoContratante1()!=null)             rAfiliacion.setNoContratante1(afilia.getNoContratante1());                        else rAfiliacion.setNoContratante1("");
                if(afilia.getNoContratante2()!=null)             rAfiliacion.setNoContratante2(afilia.getNoContratante2());                        else rAfiliacion.setNoContratante2("");
                if(afilia.getNoContratante3()!=null)             rAfiliacion.setNoContratante3(afilia.getNoContratante3());                        else rAfiliacion.setNoContratante3("");
                if(afilia.getNoContratante4()!=null)             rAfiliacion.setNoContratante4(afilia.getNoContratante4());                        else rAfiliacion.setNoContratante4("");
                if(afilia.getApMaternoContratante()!=null)       rAfiliacion.setApMaternoContratante(afilia.getApMaternoContratante());            else rAfiliacion.setApMaternoContratante("");
                if(afilia.getTiDocContratante()!=null)           rAfiliacion.setTiDocContratante(afilia.getTiDocContratante());                    else rAfiliacion.setTiDocContratante("1");
                if(afilia.getNuDocContratante()!=null)           rAfiliacion.setNuDocContratante(afilia.getNuDocContratante());                    else rAfiliacion.setNuDocContratante("45722376");
                if(afilia.getApCasadaContratante()!=null)        rAfiliacion.setApCasadaContratante(afilia.getApCasadaContratante());              else rAfiliacion.setApCasadaContratante("");
                if(afilia.getFeNacimientoContratante()!=null)    rAfiliacion.setFeNacimientoContratante(afilia.getFeNacimientoContratante());      else rAfiliacion.setFeNacimientoContratante("");
                if(afilia.getCoPaisEmisorDocContratante()!=null) rAfiliacion.setCoPaisEmisorDocContratante(afilia.getCoPaisEmisorDocContratante());else rAfiliacion.setCoPaisEmisorDocContratante("PER");
                if(afilia.getCoAfiliacion()!=null)               rAfiliacion.setCoAfiliacion(afilia.getCoAfiliacion());                            else rAfiliacion.setCoAfiliacion("40002");
                if(afilia.getCoContrato()!=null)                 rAfiliacion.setCoContrato(afilia.getCoContrato());                                else rAfiliacion.setCoContrato("163675");
                if(afilia.getCoUnicoMultisectorial()!=null)      rAfiliacion.setCoUnicoMultisectorial(afilia.getCoUnicoMultisectorial());          else rAfiliacion.setCoUnicoMultisectorial("");
                if(afilia.getTiRegimen()!=null)                  rAfiliacion.setTiregimen(afilia.getTiRegimen());                                  else rAfiliacion.setTiregimen("1");
                if(afilia.getEsAfiliacion()!=null)               rAfiliacion.setEsAfiliacion(afilia.getEsAfiliacion());                            else rAfiliacion.setEsAfiliacion("5");                                               
                
                if(afilia.getCoCausalBaja()!=null)               rAfiliacion.setCoCausalBaja(afilia.getCoCausalBaja());                            else rAfiliacion.setCoCausalBaja(""); // CAMPO 56
                if(afilia.getTiPlanSalud()!=null)                rAfiliacion.setTiPlanSalud(afilia.getTiPlanSalud());                              else rAfiliacion.setTiPlanSalud("7");   // CAMPO 57
                if(afilia.getNoProductoSalud()!=null)            rAfiliacion.setNoProductoSalud(afilia.getNoProductoSalud());                      else rAfiliacion.setNoProductoSalud("AutoSeguro FEBAN"); // CAMPO 58
                if(afilia.getCoProducto()!=null)                 rAfiliacion.setCoProducto(afilia.getCoProducto());                                else rAfiliacion.setCoProducto("01"); // CAMPO 59
                if(afilia.getParentesco()!=null)                 rAfiliacion.setParentesco(afilia.getParentesco());                                else rAfiliacion.setParentesco("1"); // CAMPO 60 
                if(afilia.getCoRenipress()!=null)                rAfiliacion.setCoRenipress(afilia.getCoRenipress());                              else rAfiliacion.setCoRenipress(""); // CAMPO 61
                if(afilia.getPkAfiliado()!=null)                 rAfiliacion.setPkAfiliado(afilia.getPkAfiliado());                                else rAfiliacion.setPkAfiliado("PER145722376"); // CAMPO 62
                   //System.out.println(afilia.getPkAfiliado()); 
                
                if(afilia.getFeActEstado()!=null)                rAfiliacion.setFeActEstado(afilia.getFeActEstado());                              else rAfiliacion.setFeActEstado("20160328"); // CAMPO 63
                if(afilia.getFeIniAfiliacion()!=null)            rAfiliacion.setFeIniAfiliacion(afilia.getFeIniAfiliacion()) ;                     else rAfiliacion.setFeIniAfiliacion("20141217");  // CAMPO 64
                if(afilia.getFeFinAfiliacion()!=null)            rAfiliacion.setFeFinAfiliacion(afilia.getFeFinAfiliacion());                      else rAfiliacion.setFeFinAfiliacion("");// CAMPO 65
                if(afilia.getFeIniCobertura()!=null)             rAfiliacion.setFeIniCobertura(afilia.getFeIniCobertura());                        else rAfiliacion.setFeIniCobertura("");  // CAMPO 66
                if(afilia.getFeFinCobertura()!=null)             rAfiliacion.setFeFinCobertura(afilia.getFeFinCobertura());                        else rAfiliacion.setFeFinCobertura(""); // CAMPO 67
                if(afilia.getFeActOperacion()!=null)             rAfiliacion.setFeActOperacion(afilia.getFeActOperacion());                        else rAfiliacion.setFeActOperacion("");    // CAMPO 68
                if(afilia.getTiActOperacion()!=null)             rAfiliacion.setTiActOperacion(afilia.getTiActOperacion());                        else rAfiliacion.setTiActOperacion("120339");   // CAMPO 69
                if(afilia.getCoTiCobertura()!=null)              rAfiliacion.setCoTiCobertura(afilia.getCoTiCobertura());                          else rAfiliacion.setCoTiCobertura("4");      // CAMPO 70
                if(afilia.getIdAfiliacionNombre()!=null)         rAfiliacion.setIdAfiliacionNombre(afilia.getIdAfiliacionNombre());                else rAfiliacion.setIdAfiliacionNombre("000"); // CAMPO 71
                
                
                rRegafi.addDetalle(rAfiliado);
                rRegafi.addDetalle(rAfiliacion);
                RegafiUpdate271ServiceImpl regafi = new RegafiUpdate271ServiceImpl();                                    
                try {                    
                    String sTrama = regafi.beanToX12N(rRegafi);                    
                    sError = rRegafi.getCoError();
                    if(sError.equals("0000")) {
                        //listaResultado.add(sTrama);
                        ll_procesados++ ;                        
                         //System.out.println(sTrama);
                        ls_respuesta=ObjD.Ins_tramaX12(sTrama);                                                
                        if (ls_respuesta.equals("true")){
                           System.out.println("Se Grabo Correctamente y envia trama" + ll_procesados +" DNI:"+ afilia.getNuDocumentoAfil() );
                        }else{
                            System.out.println("Se Enviado la trama pero no se actualizo la confirmación." ); 
                        }                                                   
                                                
                    }
                    else {
                        //listaResultado.add(sError);
                        ll_noprocesados++ ;
                    }
                } catch (Exception e) {
                                       
                    //listaResultado.add("Error: Verificar especificaciones tecnicas");
                }                
            }
        }   
        System.out.println(" ll_procesados " +ll_procesados );
        System.out.println(" ll_noprocesados " +ll_noprocesados );        
        return "";        
    }
    public String AfiliadosTramaX12Parm( String cod)
    {        
        int ll_noprocesados  = 0;
        int ll_procesados    = 0;        
        int li_vector        = 0;        
        /**mensaje de error**/
        String coExcBD      = null;
        String ls_respuesta = null;
        String ls_error     = ""  ;        
        String xcoDescripError;
        String xcoCampoErr ;        
        
        
        String sError = "9999";
        ArrayList<Afiliacion> listaAfiliacion = new ArrayList<Afiliacion>();                
        //List<String> listaResultado = new ArrayList();               
        listaAfiliacion = ListaAfiliadosParam(cod);
        String codAfiliado = "";
        if(listaAfiliacion!=null){
	    int numero=0;
            for(int i = 0; i < listaAfiliacion.size() ; i++){
		numero++;
                In271RegafiUpdate           rRegafi     = new In271RegafiUpdate();
                In271RegafiUpdateAfiliado   rAfiliado   = new In271RegafiUpdateAfiliado();
                In271RegafiUpdateAfiliacion rAfiliacion = new In271RegafiUpdateAfiliacion();                                
                Afiliacion afilia = listaAfiliacion.get(i);                                                
                // Datos de cabecera del formato X12N - Constantes
                rRegafi.setNoTransaccion("271_REGAFI_UPDATE");
                System.out.println("Transaccion: " + rRegafi.getNoTransaccion());
                rRegafi.setIdRemitente(afilia.getIdRemitente());
                System.out.println("ID del remitente: " + rRegafi.getIdRemitente());
                rRegafi.setIdReceptor("SUSALUD");
                System.out.println("ID del receptor: " + rRegafi.getIdReceptor());
                rRegafi.setFeTransaccion(afilia.getFeTransaccion());
                System.out.println("Fecha Transaccion: " + rRegafi.getFeTransaccion());
                rRegafi.setHoTransaccion(afilia.getHoTransaccion());
                System.out.println("Hora Transaccion: " + rRegafi.getHoTransaccion());
                rRegafi.setIdCorrelativo(String.valueOf((numero+ 100000000)));
                System.out.println("Correlativo: " + rRegafi.getIdCorrelativo());
                rRegafi.setIdTransaccion("271");
                System.out.println("ID Transaccion: " + rRegafi.getIdTransaccion());
                rRegafi.setTiFinalidad("13");
                System.out.println("Finalidad: " + rRegafi.getTiFinalidad());
                rRegafi.setCaRemitente("2");
                System.out.println("Calificador: " + rRegafi.getCaRemitente());
                 // Datos de cabecera del formato X12N - Variables
                rRegafi.setTiOperacion(afilia.getTiOperacion());
                System.out.println("Tipo Operacion: " + rRegafi.getTiOperacion());
                /*****Si existe informacion*****/                             
                 // Datos del afiliado 
                 codAfiliado = afilia.getCodAfiliado();
                if(afilia.getApPaternoAfiliado()!=null)    rAfiliado.setApPaternoAfiliado(afilia.getApPaternoAfiliado());// else rAfiliado.setApPaternoAfiliado(afilia.getApPaternoAfiliado());
                System.out.println("Apellido Paterno: " + afilia.getApPaternoAfiliado());
                if(afilia.getNoAfiliado1()!=null)          rAfiliado.setNoAfiliado1(afilia.getNoAfiliado1());// else rAfiliado.setNoAfiliado1("");
                if(afilia.getNoAfiliado2()!=null)          rAfiliado.setNoAfiliado2(afilia.getNoAfiliado2()); //else rAfiliado.setNoAfiliado2("");
                if(afilia.getApMaternoAfiliado()!=null)    rAfiliado.setApMaternoAfiliado(afilia.getApMaternoAfiliado()); // else rAfiliado.setApMaternoAfiliado("");
                if(afilia.getTiDocumentoAfil()!=null)      rAfiliado.setTiDocumentoAfil(afilia.getTiDocumentoAfil()); //else rAfiliado.setTiDocumentoAfil("");
                System.out.println("Cod Tipo Documento: " + afilia.getTiDocumentoAfil());
                if(afilia.getNuDocumentoAfil()!=null)      rAfiliado.setNuDocumentoAfil(afilia.getNuDocumentoAfil()); //else rAfiliado.setNuDocumentoAfil("");
                System.out.println("Dni: " + afilia.getNuDocumentoAfil());
                if(afilia.getEstadoAfiliado()!=null)       rAfiliado.setEstadoAfiliado(afilia.getEstadoAfiliado());  //else rAfiliado.setEstadoAfiliado("");                
                if(afilia.getTiDocumentoAct()!=null)       rAfiliado.setTiDocumentoAct(afilia.getTiDocumentoAct());    //    else rAfiliado.setTiDocumentoAct("1") ; 
                if(afilia.getNuDocumentoAct()!=null)       rAfiliado.setNuDocumentoAct(afilia.getNuDocumentoAct()); //else rAfiliado.setNuDocumentoAct("45722376") ;
                if(afilia.getApCasadaAfiliado()!=null)     rAfiliado.setApCasadaAfiliado(afilia.getApCasadaAfiliado()); //     else rAfiliado.setApCasadaAfiliado("") ;
                if(afilia.getCoNacionalidad()!=null)       rAfiliado.setCoNacionalidad(afilia.getCoNacionalidad());//       else rAfiliado.setCoNacionalidad("") ;
                if(afilia.getUbigeo()!=null)               rAfiliado.setUbigeo(afilia.getUbigeo());               // else rAfiliado.setUbigeo("0") ;
                if(afilia.getFeNacimiento()!=null)         rAfiliado.setFeNacimiento(afilia.getFeNacimiento());   //else rAfiliado.setFeNacimiento("19890304") ;
                if(afilia.getGenero()!=null)               rAfiliado.setGenero(afilia.getGenero());                //else rAfiliado.setGenero("1") ;
                if(afilia.getCoPaisDoc()!=null)            rAfiliado.setCoPaisDoc(afilia.getCoPaisDoc());           //else rAfiliado.setCoPaisDoc("PER") ;
                System.out.println("Cod. Pais Documento: " + afilia.getCoPaisDoc());
                if(afilia.getFeFallecimiento()!=null)      rAfiliado.setFefallecimiento(afilia.getFeFallecimiento()); // else rAfiliado.setFefallecimiento("19000101") ;
                if(afilia.getCoPaisEmisorDocAct()!=null)   rAfiliado.setCoPaisEmisorDocAct(afilia.getCoPaisEmisorDocAct()); //    else rAfiliado.setCoPaisEmisorDocAct("") ;
                if(afilia.getFeActPersonaxIafas()!=null)   rAfiliado.setFeActPersonaxIafas(afilia.getFeActPersonaxIafas()); //else rAfiliado.setFeActPersonaxIafas("20150106") ;
                if(afilia.getIdAfiliadoNombre()!=null)     rAfiliado.setIdAfiliadoNombre(afilia.getIdAfiliadoNombre());     //    else rAfiliado.setIdAfiliadoNombre("0") ;
                System.out.println("Identificador Nombre 2: " + afilia.getIdAfiliadoNombre());
                if(afilia.getTiDocTutor()!=null)           rAfiliado.setTiDocTutor(afilia.getTiDocTutor());                //else rAfiliado.setTiDocTutor("1") ;
                if(afilia.getNuDocTutor()!=null)           rAfiliado.setNuDocTutor(afilia.getNuDocTutor());                //else rAfiliado.setNuDocTutor("45722376") ;
                if(afilia.getTiVinculoTutor()!=null)       rAfiliado.setTiVinculoTutor(afilia.getTiVinculoTutor());          // else rAfiliado.setTiVinculoTutor("17") ;
                if(afilia.getFeValidacionReniec()!=null)   rAfiliado.setFeValidacionReniec(afilia.getFeValidacionReniec());     //   else rAfiliado.setFeValidacionReniec("0");
                if(afilia.getCoPaisEmisorDocTutor()!=null) rAfiliado.setCoPaisEmisorDocTutor(afilia.getCoPaisEmisorDocTutor());   // else rAfiliado.setCoPaisEmisorDocTutor("PER") ;

                if(afilia.getTiDocTitular()!=null)          rAfiliacion.setTiDocTitular(afilia.getTiDocTitular());
                System.out.println("Tipo de Doc. del Titular: " + afilia.getTiDocTitular());
                if(afilia.getNuDocTitular()!=null)          rAfiliacion.setNuDocTitular(afilia.getNuDocTitular());
                System.out.println("Num. doc. de identidad del titular: " + afilia.getNuDocTitular());
                if(afilia.getFeNacimientoTitular()!=null)   rAfiliacion.setFeNacimientoTitular(afilia.getFeNacimientoTitular());
                System.out.println("Fecha de Nacimiento del titular: " + afilia.getFeNacimientoTitular());
                if(afilia.getCoPaisEmisorDocTitular()!=null)rAfiliacion.setCoPaisEmisorDocTitular(afilia.getCoPaisEmisorDocTitular());
                System.out.println("Cod. Pais Emisor: " + afilia.getCoPaisEmisorDocTitular());
                if(afilia.getTiContratante()!=null)              rAfiliacion.setTiContratante(afilia.getTiContratante());                          else rAfiliacion.setTiContratante("2");
                System.out.println("Calificador del contratante: " + afilia.getTiContratante());
                if(afilia.getApPaternoContratante()!=null)       rAfiliacion.setApPaternoContratante(afilia.getApPaternoContratante());            else rAfiliacion.setApPaternoContratante(""); 
                if(afilia.getNoContratante1()!=null)             rAfiliacion.setNoContratante1(afilia.getNoContratante1());                        else rAfiliacion.setNoContratante1("");
                if(afilia.getNoContratante2()!=null)             rAfiliacion.setNoContratante2(afilia.getNoContratante2());                        else rAfiliacion.setNoContratante2("");
                if(afilia.getNoContratante3()!=null)             rAfiliacion.setNoContratante3(afilia.getNoContratante3());                        else rAfiliacion.setNoContratante3("");
                if(afilia.getNoContratante4()!=null)             rAfiliacion.setNoContratante4(afilia.getNoContratante4());                        else rAfiliacion.setNoContratante4("");
                if(afilia.getApMaternoContratante()!=null)       rAfiliacion.setApMaternoContratante(afilia.getApMaternoContratante());            else rAfiliacion.setApMaternoContratante("");
                if(afilia.getTiDocContratante()!=null)           rAfiliacion.setTiDocContratante(afilia.getTiDocContratante());                    else rAfiliacion.setTiDocContratante("1");
                System.out.println("Tipo Doc. contratante: " + afilia.getTiDocContratante());
                if(afilia.getNuDocContratante()!=null)           rAfiliacion.setNuDocContratante(afilia.getNuDocContratante());                    else rAfiliacion.setNuDocContratante("45722376");
                System.out.println("Num. Doc. contratante: " + afilia.getNuDocContratante());
                if(afilia.getApCasadaContratante()!=null)        rAfiliacion.setApCasadaContratante(afilia.getApCasadaContratante());              else rAfiliacion.setApCasadaContratante("");
                if(afilia.getFeNacimientoContratante()!=null)    rAfiliacion.setFeNacimientoContratante(afilia.getFeNacimientoContratante());      else rAfiliacion.setFeNacimientoContratante("");
                if(afilia.getCoPaisEmisorDocContratante()!=null) rAfiliacion.setCoPaisEmisorDocContratante(afilia.getCoPaisEmisorDocContratante());else rAfiliacion.setCoPaisEmisorDocContratante("PER");
                System.out.println("Cod. Pais Emisor Contratante: " + afilia.getCoPaisEmisorDocContratante());
                if(afilia.getCoAfiliacion()!=null)               rAfiliacion.setCoAfiliacion(afilia.getCoAfiliacion());                            else rAfiliacion.setCoAfiliacion("40002");
                System.out.println("********Cod Afiliacion*******: " + afilia.getCoAfiliacion());
                if(afilia.getCoContrato()!=null)                 rAfiliacion.setCoContrato(afilia.getCoContrato());                                else rAfiliacion.setCoContrato("163675");
                System.out.println("Cod Contratante: " + afilia.getCoContrato());
                if(afilia.getCoUnicoMultisectorial()!=null)      rAfiliacion.setCoUnicoMultisectorial(afilia.getCoUnicoMultisectorial());          else rAfiliacion.setCoUnicoMultisectorial("");
                if(afilia.getTiRegimen()!=null)                  rAfiliacion.setTiregimen(afilia.getTiRegimen());                                  else rAfiliacion.setTiregimen("1");
                System.out.println("Tipo Regimen: " + afilia.getTiRegimen());
                if(afilia.getEsAfiliacion()!=null)               rAfiliacion.setEsAfiliacion(afilia.getEsAfiliacion());                            else rAfiliacion.setEsAfiliacion("5");                                               
                System.out.println("Estado de Afiliacion: " + afilia.getEsAfiliacion());
                if(afilia.getCoCausalBaja()!=null)               rAfiliacion.setCoCausalBaja(afilia.getCoCausalBaja());                            else rAfiliacion.setCoCausalBaja(""); // CAMPO 56
                System.out.println("Cod. Causal Baja: " + afilia.getCoCausalBaja());
                if(afilia.getTiPlanSalud()!=null)                rAfiliacion.setTiPlanSalud(afilia.getTiPlanSalud());                              else rAfiliacion.setTiPlanSalud("7");   // CAMPO 57
                System.out.println("Tipo plan salud: " + afilia.getTiPlanSalud());
                if(afilia.getNoProductoSalud()!=null)            rAfiliacion.setNoProductoSalud(afilia.getNoProductoSalud());                      else rAfiliacion.setNoProductoSalud("AutoSeguro FEBAN"); // CAMPO 58
                System.out.println("Nombre interno producto: " + afilia.getNoProductoSalud());
                if(afilia.getCoProducto()!=null)                 rAfiliacion.setCoProducto(afilia.getCoProducto());                                else rAfiliacion.setCoProducto("01"); // CAMPO 59
                System.out.println("Codigo interno producto: " + afilia.getCoProducto());
                if(afilia.getParentesco()!=null)                 rAfiliacion.setParentesco(afilia.getParentesco());                                else rAfiliacion.setParentesco("1"); // CAMPO 60 
                System.out.println("Tipo parentesco afiliado: " + afilia.getParentesco());
                if(afilia.getCoRenipress()!=null)                rAfiliacion.setCoRenipress(afilia.getCoRenipress());                              else rAfiliacion.setCoRenipress(""); // CAMPO 61
                if(afilia.getPkAfiliado()!=null)                 rAfiliacion.setPkAfiliado(afilia.getPkAfiliado());                                else rAfiliacion.setPkAfiliado("PER145722376"); // CAMPO 62
                System.out.println("PK Afiliado: " + afilia.getPkAfiliado()); 
                
                if(afilia.getFeActEstado()!=null)                rAfiliacion.setFeActEstado(afilia.getFeActEstado());                              else rAfiliacion.setFeActEstado("20160328"); // CAMPO 63
                System.out.println("Fecha Act. Estado: " + afilia.getFeActEstado()); 
                if(afilia.getFeIniAfiliacion()!=null)            rAfiliacion.setFeIniAfiliacion(afilia.getFeIniAfiliacion()) ;                     else rAfiliacion.setFeIniAfiliacion("20141217");  // CAMPO 64
                System.out.println("Fecha Inicio afiliacion: " + afilia.getFeIniAfiliacion());
                if(afilia.getFeFinAfiliacion()!=null)            rAfiliacion.setFeFinAfiliacion(afilia.getFeFinAfiliacion());                      else rAfiliacion.setFeFinAfiliacion("");// CAMPO 65
                System.out.println("Fecha fin afiliacion: " + afilia.getFeFinAfiliacion());
                if(afilia.getFeIniCobertura()!=null)             rAfiliacion.setFeIniCobertura(afilia.getFeIniCobertura());                        else rAfiliacion.setFeIniCobertura("");  // CAMPO 66
                System.out.println("Fecha Ini. Cobertura: " + afilia.getFeIniCobertura());
                if(afilia.getFeFinCobertura()!=null)             rAfiliacion.setFeFinCobertura(afilia.getFeFinCobertura());                        else rAfiliacion.setFeFinCobertura(""); // CAMPO 67
                System.out.println("Fecha Fin Cobertura: " + afilia.getFeFinCobertura());
                if(afilia.getFeActOperacion()!=null)             rAfiliacion.setFeActOperacion(afilia.getFeActOperacion());                        else rAfiliacion.setFeActOperacion("");    // CAMPO 68
                System.out.println("Fecha Act. Operacion: " + afilia.getFeActOperacion());
                if(afilia.getTiActOperacion()!=null)             rAfiliacion.setTiActOperacion(afilia.getTiActOperacion());                        else rAfiliacion.setTiActOperacion("120339");   // CAMPO 69
                if(afilia.getCoTiCobertura()!=null)              rAfiliacion.setCoTiCobertura(afilia.getCoTiCobertura());                          else rAfiliacion.setCoTiCobertura("4");      // CAMPO 70
                System.out.println("Codigo cobertura: " + afilia.getCoTiCobertura());
                if(afilia.getIdAfiliacionNombre()!=null)         rAfiliacion.setIdAfiliacionNombre(afilia.getIdAfiliacionNombre());                else rAfiliacion.setIdAfiliacionNombre("000"); // CAMPO 71
                System.out.println("Identificador de Contratante: " + afilia.getIdAfiliacionNombre());
                
                rRegafi.addDetalle(rAfiliado);
                rRegafi.addDetalle(rAfiliacion);
                RegafiUpdate271ServiceImpl regafi = new RegafiUpdate271ServiceImpl();                                    
                try {
                    String sTrama = regafi.beanToX12N(rRegafi);
                    sError = rRegafi.getCoError();
                    System.out.println(" Tramas : "+sTrama);
                    if(sError.equals("0000")) {
                        //listaResultado.add(sTrama);
                        ll_procesados++ ;                        
                         //System.out.println(sTrama);
                        ls_respuesta=ObjD.Ins_tramaX12Param(sTrama, cod, codAfiliado);                                                
                        if (ls_respuesta.equals("true")){
                           System.out.println("Se Grabo Correctamente y envia trama" + ll_procesados +" DNI:"+ afilia.getNuDocumentoAfil() );
                        }else{
                            System.out.println("Se Enviado la trama pero no se actualizo la confirmación." ); 
                        }                                                   
                                                
                    }
                    else {
                        //listaResultado.add(sError);
                        ll_noprocesados++ ;
                    }
                } catch (Exception e) {
                                       
                    //listaResultado.add("Error: Verificar especificaciones tecnicas");
                }                
            }
        }   
        System.out.println(" ll_procesados " +ll_procesados );
        System.out.println(" ll_noprocesados " +ll_noprocesados );        
        return "";        
    }

    
    public String AfiliadosTrama997()
    {        
        int ll_noprocesados  = 0;
        int ll_procesados    = 0;        
        int li_vector        = 0;        
        /**mensaje de error**/
        String coExcBD      = null;
        String ls_respuesta = null;
        String ls_error     = ""  ;        
        String xcoDescripError;
        String xcoCampoErr ;        
	String tramax12="";
        String ls_pk =""  ;
        String sError = "9999";
        ArrayList<Tramax> listaTramax = new ArrayList<Tramax>();                 
        //List<String> listaResultado = new ArrayList();               
        listaTramax = ListaTrama997();       
        if(listaTramax!=null){
	    int numero=0;
            for(int i = 0; i < listaTramax.size() ; i++){
		numero++;
                In271RegafiUpdate           rRegafi     = new In271RegafiUpdate();
                In271RegafiUpdateAfiliado   rAfiliado   = new In271RegafiUpdateAfiliado();
                In271RegafiUpdateAfiliacion rAfiliacion = new In271RegafiUpdateAfiliacion();                                
                Tramax tramax = listaTramax.get(i);
		tramax12=tramax.getDato();
		System.out.println(tramax.getDato());	
		
		try {
		    RegafiUpdate997Service salida = new RegafiUpdate997ServiceImpl();					
		    In997RegafiUpdate bo = salida.x12NToBean(tramax12);
		    bo.setFlag(true);             
		    Vector<Vector<String>> dataVector = new Vector<Vector<String>>();
		    List<In997RegafiUpdateExcepcion> excepciones = bo.getDetallesExcepcion();                                    
		    ls_error="";
		    li_vector=0;
                        for (In997RegafiUpdateExcepcion ex : excepciones) {                                
                                Vector<String> fila = new Vector<String>();                    
                                String coCampoErr = ex.getCoCampoErr();                    
                                coExcBD           = ex.getExcBD();                    
                                fila.add(coExcBD);
                                fila.add(coCampoErr);                               
                                xcoCampoErr=ObjD.errorCampo(coCampoErr);                                                                
                                fila.add(String.valueOf(ex.isFlagExcepcion())); 
                                String coDescripError = ex.getInCoErrorEncontrado();
                                fila.add(coDescripError);                                                               
                                xcoDescripError=ObjD.errorDescripcion(coDescripError);
                                fila.add(ex.getPkAfiliado());
                                fila.add(ex.getPkAfiliadopkAfiliacion());
                                ls_error +=" Base Error:"+coExcBD+" Error Campo:"+coCampoErr+":"+xcoCampoErr+" "+" Descripcion Error:"+coDescripError+":"+xcoDescripError +"\n" ;                    
                                dataVector.add(fila);                    
                                li_vector++;                            
				ls_pk=ex.getPkAfiliadopkAfiliacion();
				char buf[] = new char[20];
				ls_pk.getChars(1, 9, buf, 0);
				ls_pk=String.valueOf(buf);
				//System.out.println( ex.getPkAfiliado());
				System.out.println( ex.getPkAfiliadopkAfiliacion());				
                        }                           
                        SusaludTrama susaludTrama;
                        susaludTrama= new SusaludTrama();                            
                        susaludTrama.setIdafiliado(ls_pk);                        
                        susaludTrama.setTtenvio("File");
                        susaludTrama.setIdconfirmacion("0");
                        susaludTrama.setIderror(coExcBD);                       
                        susaludTrama.setNvector(li_vector);
                        susaludTrama.setXerror(ls_error);
                        susaludTrama.setXtramaenvio("");
                        susaludTrama.setXtramaretorno(tramax12);                                                                  
                        ls_respuesta=ObjD.SusaludConfirmacion(susaludTrama);                                                
                        if (ls_respuesta.equals("true")){
                           System.out.println("Se Grabo Correctamente y envia trama"  );
                        }else{
                            System.out.println("Se Enviado la trama pero no se actualizo la confirmación." ); 
                        }                                                   
                        if (li_vector==1  && coExcBD.equals("0000")  ){                                                              
                        } else{                            
                            System.out.println("ERROR EN GRABAR Y TRAMAS" +ls_error );
                        }                                                  
                  
		} catch (Exception e) {
			
		}
	    }          
        }   
        System.out.println(" ll_procesados " +ll_procesados );
        System.out.println(" ll_noprocesados " +ll_noprocesados );        
        return "";        
    }    
    
    public String AfiliadosTrama997x(String cadena, DefaultTableModel model)
    {        
        int ll_noprocesados  = 0;
        int ll_procesados    = 0;        
        int li_vector        = 0;        
        /**mensaje de error**/
        String coExcBD      = null;
        String ls_respuesta = null;
        String ls_error     = ""  ;        
        String xcoDescripError;
        String xcoCampoErr ;        
	String tramax12="";
        String ls_pk =""  ;
        String sError = "9999";
        java.util.Date fecha = new Date();
        
        if(cadena != null) {
            tramax12 = cadena.toString();
            
            try {
		    RegafiUpdate997Service salida = new RegafiUpdate997ServiceImpl();					
		    In997RegafiUpdate bo = salida.x12NToBean(tramax12);
		    bo.setFlag(true);             
		    Vector<Vector<String>> dataVector = new Vector<Vector<String>>();
		    List<In997RegafiUpdateExcepcion> excepciones = bo.getDetallesExcepcion();                                    
		    ls_error="";
		    li_vector=0;
                        for (In997RegafiUpdateExcepcion ex : excepciones) {                                
                                Vector<String> fila = new Vector<String>();                    
                                String coCampoErr = ex.getCoCampoErr();                    
                                coExcBD           = ex.getExcBD();                    
                                fila.add(coExcBD);
                                fila.add(coCampoErr);                               
                                xcoCampoErr=ObjD.errorCampo(coCampoErr);                                                                
                                fila.add(String.valueOf(ex.isFlagExcepcion())); 
                                String coDescripError = ex.getInCoErrorEncontrado();
                                fila.add(coDescripError);                                                               
                                xcoDescripError=ObjD.errorDescripcion(coDescripError);
                                fila.add(ex.getPkAfiliado());
                                fila.add(ex.getPkAfiliadopkAfiliacion());
                                ls_error +=" Base Error:"+coExcBD+" Error Campo:"+coCampoErr+":"+xcoCampoErr+" "+" Descripcion Error:"+coDescripError+":"+xcoDescripError +"\n" ;                    
                                dataVector.add(fila);                    
                                li_vector++;                            
				ls_pk=ex.getPkAfiliadopkAfiliacion();
				char buf[] = new char[20];
				ls_pk.getChars(1, 9, buf, 0);
				ls_pk=String.valueOf(buf);
				//System.out.println( ex.getPkAfiliado());
				System.out.println( ex.getPkAfiliadopkAfiliacion());				
                        }                           
                        SusaludTrama susaludTrama;
                        susaludTrama= new SusaludTrama();                            
                        susaludTrama.setIdafiliado(ls_pk);                        
                        susaludTrama.setTtenvio("File");
                        susaludTrama.setIdconfirmacion("0");
                        susaludTrama.setIderror(coExcBD);                       
                        susaludTrama.setNvector(li_vector);
                        susaludTrama.setXerror(ls_error);
                        susaludTrama.setXtramaenvio(Constante.nomFile);
                        susaludTrama.setXtramaretorno(tramax12);                                                                  
                        ls_respuesta=ObjD.SusaludConfirmacion(susaludTrama);                                                
                        if (ls_respuesta.equals("true")){
                           System.out.println("Se Grabo Correctamente y envia trama"  );
                        }else{
                            System.out.println("Se Enviado la trama pero no se actualizo la confirmación." );
                        }                                                   
                        if (li_vector==1  && coExcBD.equals("0000")  ){                                                              
                        } else{                            
                            System.out.println("ERROR EN GRABAR Y TRAMAS" +ls_error );
                        }  
                        
                        /*para mostrar los datos en la ventana DPM 21082020*/
                        String ls_iderror = "";
                        ls_iderror = String.valueOf(susaludTrama.getIderror()) ;
                        if (  !(ls_iderror.equals("0000")) ){
                            Object fila[] = {
                                            susaludTrama.getIdafiliado(),
                                            //fecha,
                                            //susaludTrama.getTtenvio(),
                                            susaludTrama.getIderror(),
                                            susaludTrama.getXerror()                                        
                            };
                            model.addRow(fila);
                            
                        }
		} catch (Exception e) {
			
		}
        }
        //System.out.println(" ll_procesados " +ll_procesados );
        //System.out.println(" ll_noprocesados " +ll_noprocesados );        
        return "";        
    }    
    
    public List<String> Actualizarafiliados_bk() {        
        int ll_noprocesados=0;
        int ll_procesados=0;
        
        String sError = "9999";
        ArrayList<Afiliacion> listaAfiliacion = new ArrayList<Afiliacion>();                 
        List<String> listaResultado = new ArrayList();               
        listaAfiliacion = ListaAfiliadosPrueba();       
        if(listaAfiliacion!=null){
            for(int i = 0; i < listaAfiliacion.size() ; i++){
                In271RegafiUpdate           rRegafi     = new In271RegafiUpdate();
                In271RegafiUpdateAfiliado   rAfiliado   = new In271RegafiUpdateAfiliado();
                In271RegafiUpdateAfiliacion rAfiliacion = new In271RegafiUpdateAfiliacion(); 
                Afiliacion afilia = listaAfiliacion.get(i);                                                
                // Datos de cabecera del formato X12N - Constantes
                rRegafi.setNoTransaccion("271_REGAFI_UPDATE");                
                rRegafi.setIdTransaccion("271");
                rRegafi.setIdReceptor("SUSALUD"); 
                rRegafi.setTiFinalidad("13");
                rRegafi.setCaRemitente("2");
                 // Datos de cabecera del formato X12N - Variables
                rRegafi.setIdCorrelativo(String.valueOf(i+100000000));
                rRegafi.setIdRemitente(afilia.getIdRemitente());
                rRegafi.setFeTransaccion(afilia.getFeTransaccion());
                rRegafi.setHoTransaccion(afilia.getHoTransaccion());
                rRegafi.setTiOperacion(afilia.getTiOperacion()); 
                
                /*****Si existe informacion*****/                             
                 // Datos del afiliado 
                if(afilia.getApPaternoAfiliado()!=null)    rAfiliado.setApPaternoAfiliado(afilia.getApPaternoAfiliado());// else rAfiliado.setApPaternoAfiliado(afilia.getApPaternoAfiliado()); //RR
                if(afilia.getNoAfiliado1()!=null)          rAfiliado.setNoAfiliado1(afilia.getNoAfiliado1());// else rAfiliado.setNoAfiliado1("");
                if(afilia.getNoAfiliado2()!=null)          rAfiliado.setNoAfiliado2(afilia.getNoAfiliado2()); //else rAfiliado.setNoAfiliado2("");
                if(afilia.getApMaternoAfiliado()!=null)    rAfiliado.setApMaternoAfiliado(afilia.getApMaternoAfiliado()); // else rAfiliado.setApMaternoAfiliado("");
                if(afilia.getTiDocumentoAfil()!=null)      rAfiliado.setTiDocumentoAfil(afilia.getTiDocumentoAfil()); //else rAfiliado.setTiDocumentoAfil("");  //RR
                if(afilia.getNuDocumentoAfil()!=null)      rAfiliado.setNuDocumentoAfil(afilia.getNuDocumentoAfil()); //else rAfiliado.setNuDocumentoAfil("");  //RR
                if(afilia.getEstadoAfiliado()!=null)       rAfiliado.setEstadoAfiliado(afilia.getEstadoAfiliado());  //else rAfiliado.setEstadoAfiliado("");                
                if(afilia.getTiDocumentoAct()!=null)       rAfiliado.setTiDocumentoAct(afilia.getTiDocumentoAct());    //    else rAfiliado.setTiDocumentoAct("1") ;  //CAMPO 15
                if(afilia.getNuDocumentoAct()!=null)       rAfiliado.setNuDocumentoAct(afilia.getNuDocumentoAct()); //else rAfiliado.setNuDocumentoAct("45722376") ;  //CAMPO 16
                if(afilia.getApCasadaAfiliado()!=null)     rAfiliado.setApCasadaAfiliado(afilia.getApCasadaAfiliado()); //     else rAfiliado.setApCasadaAfiliado("") ;
                if(afilia.getCoNacionalidad()!=null)       rAfiliado.setCoNacionalidad(afilia.getCoNacionalidad());//       else rAfiliado.setCoNacionalidad("") ;
                if(afilia.getUbigeo()!=null)               rAfiliado.setUbigeo(afilia.getUbigeo());               // else rAfiliado.setUbigeo("0") ;
                if(afilia.getFeNacimiento()!=null)         rAfiliado.setFeNacimiento(afilia.getFeNacimiento());   //else rAfiliado.setFeNacimiento("19890304") ;
                if(afilia.getGenero()!=null)               rAfiliado.setGenero(afilia.getGenero());                //else rAfiliado.setGenero("1") ;
                if(afilia.getCoPaisDoc()!=null)            rAfiliado.setCoPaisDoc(afilia.getCoPaisDoc());           //else rAfiliado.setCoPaisDoc("PER") ; //RR CAMPO 25
               if(afilia.getFeFallecimiento()!=null)      rAfiliado.setFefallecimiento(afilia.getFeFallecimiento()); // else rAfiliado.setFefallecimiento("19000101") ;
                if(afilia.getCoPaisEmisorDocAct()!=null)   rAfiliado.setCoPaisEmisorDocAct(afilia.getCoPaisEmisorDocAct()); //    else rAfiliado.setCoPaisEmisorDocAct("") ;
                if(afilia.getFeActPersonaxIafas()!=null)   rAfiliado.setFeActPersonaxIafas(afilia.getFeActPersonaxIafas()); //else rAfiliado.setFeActPersonaxIafas("20150106") ;//28
                if(afilia.getIdAfiliadoNombre()!=null)     rAfiliado.setIdAfiliadoNombre(afilia.getIdAfiliadoNombre());     //    else rAfiliado.setIdAfiliadoNombre("0") ; //RR
                if(afilia.getTiDocTutor()!=null)           rAfiliado.setTiDocTutor(afilia.getTiDocTutor());                //else rAfiliado.setTiDocTutor("1") ;
               if(afilia.getNuDocTutor()!=null)           rAfiliado.setNuDocTutor(afilia.getNuDocTutor());                //else rAfiliado.setNuDocTutor("45722376") ;
               if(afilia.getTiVinculoTutor()!=null)       rAfiliado.setTiVinculoTutor(afilia.getTiVinculoTutor());          // else rAfiliado.setTiVinculoTutor("17") ;
               if(afilia.getFeValidacionReniec()!=null)   rAfiliado.setFeValidacionReniec(afilia.getFeValidacionReniec());     //   else rAfiliado.setFeValidacionReniec("0");
                if(afilia.getCoPaisEmisorDocTutor()!=null) rAfiliado.setCoPaisEmisorDocTutor(afilia.getCoPaisEmisorDocTutor());   // else rAfiliado.setCoPaisEmisorDocTutor("PER") ;

                if(afilia.getTiDocTitular()!=null)          rAfiliacion.setTiDocTitular(afilia.getTiDocTitular()); //RR
                if(afilia.getNuDocTitular()!=null)          rAfiliacion.setNuDocTitular(afilia.getNuDocTitular()); //RR
                if(afilia.getFeNacimientoTitular()!=null)   rAfiliacion.setFeNacimientoTitular(afilia.getFeNacimientoTitular()); //RR
                if(afilia.getCoPaisEmisorDocTitular()!=null)rAfiliacion.setCoPaisEmisorDocTitular(afilia.getCoPaisEmisorDocTitular()); //RR
                
                if(afilia.getTiContratante()!=null)              rAfiliacion.setTiContratante(afilia.getTiContratante());                          else rAfiliacion.setTiContratante("2"); //RR
                
                if(afilia.getApPaternoContratante()!=null)       rAfiliacion.setApPaternoContratante(afilia.getApPaternoContratante());            else rAfiliacion.setApPaternoContratante(""); 
                if(afilia.getNoContratante1()!=null)             rAfiliacion.setNoContratante1(afilia.getNoContratante1());                        else rAfiliacion.setNoContratante1("");
                if(afilia.getNoContratante2()!=null)             rAfiliacion.setNoContratante2(afilia.getNoContratante2());                        else rAfiliacion.setNoContratante2("");
                if(afilia.getNoContratante3()!=null)             rAfiliacion.setNoContratante3(afilia.getNoContratante3());                        else rAfiliacion.setNoContratante3("");
                if(afilia.getNoContratante4()!=null)             rAfiliacion.setNoContratante4(afilia.getNoContratante4());                        else rAfiliacion.setNoContratante4("");
                if(afilia.getApMaternoContratante()!=null)       rAfiliacion.setApMaternoContratante(afilia.getApMaternoContratante());            else rAfiliacion.setApMaternoContratante("");
                
                if(afilia.getTiDocContratante()!=null)           rAfiliacion.setTiDocContratante(afilia.getTiDocContratante());                    else rAfiliacion.setTiDocContratante("1"); // RR
                if(afilia.getNuDocContratante()!=null)           rAfiliacion.setNuDocContratante(afilia.getNuDocContratante());                    else rAfiliacion.setNuDocContratante("45722376"); // RR
                if(afilia.getApCasadaContratante()!=null)        rAfiliacion.setApCasadaContratante(afilia.getApCasadaContratante());              else rAfiliacion.setApCasadaContratante("");
                if(afilia.getFeNacimientoContratante()!=null)    rAfiliacion.setFeNacimientoContratante(afilia.getFeNacimientoContratante());      else rAfiliacion.setFeNacimientoContratante("");
                if(afilia.getCoPaisEmisorDocContratante()!=null) rAfiliacion.setCoPaisEmisorDocContratante(afilia.getCoPaisEmisorDocContratante());else rAfiliacion.setCoPaisEmisorDocContratante("PER"); //RR
                if(afilia.getCoAfiliacion()!=null)               rAfiliacion.setCoAfiliacion(afilia.getCoAfiliacion());                            else rAfiliacion.setCoAfiliacion("40002"); //RR
                if(afilia.getCoContrato()!=null)                 rAfiliacion.setCoContrato(afilia.getCoContrato());                                else rAfiliacion.setCoContrato("163675");  //RR
                if(afilia.getCoUnicoMultisectorial()!=null)      rAfiliacion.setCoUnicoMultisectorial(afilia.getCoUnicoMultisectorial());          else rAfiliacion.setCoUnicoMultisectorial("");
                if(afilia.getTiRegimen()!=null)                  rAfiliacion.setTiregimen(afilia.getTiRegimen());                                  else rAfiliacion.setTiregimen("1"); //RR
                if(afilia.getEsAfiliacion()!=null)               rAfiliacion.setEsAfiliacion(afilia.getEsAfiliacion());                            else rAfiliacion.setEsAfiliacion("5");  //RR                                              
                
                if(afilia.getCoCausalBaja()!=null)               rAfiliacion.setCoCausalBaja(afilia.getCoCausalBaja());                            else rAfiliacion.setCoCausalBaja(""); // CAMPO 56 //RR
                if(afilia.getTiPlanSalud()!=null)                rAfiliacion.setTiPlanSalud(afilia.getTiPlanSalud());                              else rAfiliacion.setTiPlanSalud("7");   // CAMPO 57 //RR
                if(afilia.getNoProductoSalud()!=null)            rAfiliacion.setNoProductoSalud(afilia.getNoProductoSalud());                      else rAfiliacion.setNoProductoSalud("AutoSeguro FEBAN"); //RR // CAMPO 58
                if(afilia.getCoProducto()!=null)                 rAfiliacion.setCoProducto(afilia.getCoProducto());                                else rAfiliacion.setCoProducto("01"); // CAMPO 59//RR
                if(afilia.getParentesco()!=null)                 rAfiliacion.setParentesco(afilia.getParentesco());                                else rAfiliacion.setParentesco("1"); // CAMPO 60 //RR
                if(afilia.getCoRenipress()!=null)                rAfiliacion.setCoRenipress(afilia.getCoRenipress());                              else rAfiliacion.setCoRenipress(""); // CAMPO 61
                if(afilia.getPkAfiliado()!=null)                 rAfiliacion.setPkAfiliado(afilia.getPkAfiliado());                                else rAfiliacion.setPkAfiliado("PER145722376"); // CAMPO 62 //RR
                   
                
                if(afilia.getFeActEstado()!=null)                rAfiliacion.setFeActEstado(afilia.getFeActEstado());                              else rAfiliacion.setFeActEstado("20160328"); // CAMPO 63    //RR  
                if(afilia.getFeIniAfiliacion()!=null)            rAfiliacion.setFeIniAfiliacion(afilia.getFeIniAfiliacion()) ;                     else rAfiliacion.setFeIniAfiliacion("20141217");  // CAMPO 64 //RR
                if(afilia.getFeFinAfiliacion()!=null)            rAfiliacion.setFeFinAfiliacion(afilia.getFeFinAfiliacion());                      else rAfiliacion.setFeFinAfiliacion("");// CAMPO 65 //RR
                if(afilia.getFeIniCobertura()!=null)             rAfiliacion.setFeIniCobertura(afilia.getFeIniCobertura());                        else rAfiliacion.setFeIniCobertura("");  // CAMPO 66 
                if(afilia.getFeFinCobertura()!=null)             rAfiliacion.setFeFinCobertura(afilia.getFeFinCobertura());                        else rAfiliacion.setFeFinCobertura(""); // CAMPO 67
                if(afilia.getFeActOperacion()!=null)             rAfiliacion.setFeActOperacion(afilia.getFeActOperacion());                        else rAfiliacion.setFeActOperacion("");    // CAMPO 68      //RR
                if(afilia.getTiActOperacion()!=null)             rAfiliacion.setTiActOperacion(afilia.getTiActOperacion());                       // else rAfiliacion.setTiActOperacion("120339");   // CAMPO 69 //RR
                if(afilia.getCoTiCobertura()!=null)              rAfiliacion.setCoTiCobertura(afilia.getCoTiCobertura());                         // else rAfiliacion.setCoTiCobertura("4");      // CAMPO 70 
                if(afilia.getIdAfiliacionNombre()!=null)         rAfiliacion.setIdAfiliacionNombre(afilia.getIdAfiliacionNombre());               // else rAfiliacion.setIdAfiliacionNombre("000"); // CAMPO 71 //RR
                
                
                rRegafi.setNoTransaccion("271_REGAFI_UPDATE");                
                rRegafi.setIdTransaccion("271");
                rRegafi.setIdReceptor("SUSALUD"); 
                rRegafi.setTiFinalidad("13");
                rRegafi.setCaRemitente("2");
                 // Datos de cabecera del formato X12N - Variables
                rRegafi.setIdCorrelativo(String.valueOf(i+100000000));
                rRegafi.setIdRemitente(afilia.getIdRemitente());
                rRegafi.setFeTransaccion(afilia.getFeTransaccion());
                rRegafi.setHoTransaccion(afilia.getHoTransaccion());
                rRegafi.setTiOperacion(afilia.getTiOperacion()); 
                
                
                /*****************DATOS REQUERIDOS***************/
                System.out.println("getNoTransaccion: "+rRegafi.getNoTransaccion());
                System.out.println("getIdTransaccion: "+rRegafi.getIdTransaccion());
                System.out.println("getIdReceptor:  "+rRegafi.getIdReceptor());
                System.out.println("getTiFinalidad:  "+rRegafi.getTiFinalidad());
                System.out.println("getCaRemitente:  "+rRegafi.getCaRemitente());
                System.out.println("getIdCorrelativo:  "+rRegafi.getIdCorrelativo());
                System.out.println("getIdRemitente:  "+rRegafi.getIdRemitente());
                System.out.println("getFeTransaccion:  "+rRegafi.getFeTransaccion());
                System.out.println("getHoTransaccion:  "+rRegafi.getHoTransaccion());
                System.out.println("getTiOperacion:  "+rRegafi.getTiOperacion());
                
                
                
                
                System.out.println("getApPaternoAfiliado:  "+rAfiliado.getApPaternoAfiliado());
                System.out.println("getTiDocumentoAfil:  "+rAfiliado.getTiDocumentoAfil());
                System.out.println("getNuDocumentoAfil:  "+rAfiliado.getNuDocumentoAfil());
                System.out.println("getCoPaisDoc:  "+rAfiliado.getCoPaisDoc());
                System.out.println("getIdAfiliadoNombre:  "+rAfiliado.getIdAfiliadoNombre());
                System.out.println("getTiDocTitular:  "+rAfiliacion.getTiDocTitular());
                System.out.println("getNuDocTitular:  "+rAfiliacion.getNuDocTitular());
                System.out.println("getFeNacimientoTitular:  "+rAfiliacion.getFeNacimientoTitular());
                System.out.println("getCoPaisEmisorDocTitular:  "+rAfiliacion.getCoPaisEmisorDocTitular());
                System.out.println("getTiContratante:  "+rAfiliacion.getTiContratante());
                System.out.println("getTiDocContratante:  "+rAfiliacion.getTiDocContratante());
                System.out.println("getNuDocContratante:  "+rAfiliacion.getNuDocContratante());
                System.out.println("getCoPaisEmisorDocContratante:  "+rAfiliacion.getCoPaisEmisorDocContratante());
                System.out.println("getCoAfiliacion:  "+rAfiliacion.getCoAfiliacion());
                System.out.println("getCoContrato:  "+rAfiliacion.getCoContrato());
                System.out.println("getTiRegimen:  "+rAfiliacion.getTiregimen());
                System.out.println("getEsAfiliacion:  "+rAfiliacion.getEsAfiliacion());
                System.out.println("getCoCausalBaja:  "+rAfiliacion.getCoCausalBaja());
                System.out.println("getTiPlanSalud:  "+rAfiliacion.getTiPlanSalud());
                System.out.println("getNoProductoSalud:  "+rAfiliacion.getNoProductoSalud());
                System.out.println("getCoProducto:  "+rAfiliacion.getCoProducto());
                System.out.println("getParentesco:  "+rAfiliacion.getParentesco());
                System.out.println("getPkAfiliado:  "+rAfiliacion.getPkAfiliado());
                System.out.println("getFeActEstado:  "+rAfiliacion.getFeActEstado());
                System.out.println("getFeIniAfiliacion:  "+rAfiliacion.getFeIniAfiliacion());
                System.out.println("getFeFinAfiliacion:  "+rAfiliacion.getFeFinAfiliacion());
                System.out.println("getFeActOperacion:  "+rAfiliacion.getFeActOperacion());
                System.out.println("getTiActOperacion:  "+rAfiliacion.getTiActOperacion());
                System.out.println("getIdAfiliacionNombre:  "+rAfiliacion.getIdAfiliacionNombre());
                /*****************DATOS REQUERIDOS***************/                        
                
                
                
                
                
                
                rRegafi.addDetalle(rAfiliado);
                rRegafi.addDetalle(rAfiliacion);
                
                //System.out.println(rAfiliacion);
                
                
                RegafiUpdate271ServiceImpl regafi = new RegafiUpdate271ServiceImpl();                
                
                try {                    
                    System.out.println("iniciosss");                                    
                    String sTrama = regafi.beanToX12N(rRegafi);    
		    
                    System.out.println("finallll");                                                        
                    System.out.println(sTrama);                                    
                    sError = rRegafi.getCoError();
                    if(sError.equals("0000")) {
                        listaResultado.add(sTrama);
                        ll_procesados++ ;
                    }                  
                    else {
                        listaResultado.add(sError);
                        ll_noprocesados++ ;
                    }
                } catch (Exception e) {
                    listaResultado.add("Error: Verificar especificaciones tecnicas");
//                    String mensaje = "Parametros:\nItem(" + i + 1 + ")" + ManagerTrace.PilaToString(e);
//                    logger.error(mensaje);
                }
                
                 
                
                
            }
        }   
        System.out.println(" ll_procesados " +ll_procesados );
        System.out.println(" ll_noprocesados " +ll_noprocesados );
        return listaResultado;
    
    }        
    public static In271RegafiUpdate genera271RegafiUpdate() {
        In271RegafiUpdate In271RegafiUpdate = new In271RegafiUpdate();
        In271RegafiUpdateAfiliado in271RegafiUpdateAfiliado = new In271RegafiUpdateAfiliado();        
        In271RegafiUpdateAfiliacion in271RegafiUpdateAfiliacion = new In271RegafiUpdateAfiliacion();        
        
        In271RegafiUpdate.setNoTransaccion("271_REGAFI_UPDATE");
        In271RegafiUpdate.setIdRemitente("40002          ");
        In271RegafiUpdate.setIdReceptor("SUSALUD          ");
        In271RegafiUpdate.setFeTransaccion("20160328");
        In271RegafiUpdate.setHoTransaccion("120339");
        In271RegafiUpdate.setIdCorrelativo("000000752");
        In271RegafiUpdate.setIdTransaccion("271");
        In271RegafiUpdate.setTiFinalidad("13");
        In271RegafiUpdate.setCaRemitente("2");
        In271RegafiUpdate.setTiOperacion("00");
        
        in271RegafiUpdateAfiliado.setApPaternoAfiliado("SANCHEZ");
        in271RegafiUpdateAfiliado.setNoAfiliado1("MARCO ANTONIO");
        in271RegafiUpdateAfiliado.setNoAfiliado2("");
        in271RegafiUpdateAfiliado.setApMaternoAfiliado("SANCHEZ");
        in271RegafiUpdateAfiliado.setTiDocumentoAfil("1");
        in271RegafiUpdateAfiliado.setNuDocumentoAfil("45722376");
        in271RegafiUpdateAfiliado.setEstadoAfiliado("1");
        in271RegafiUpdateAfiliado.setTiDocumentoAct("1");
        in271RegafiUpdateAfiliado.setNuDocumentoAct("45722376");
        in271RegafiUpdateAfiliado.setApCasadaAfiliado("");
        in271RegafiUpdateAfiliado.setCoNacionalidad("");
        in271RegafiUpdateAfiliado.setUbigeo("0");
        in271RegafiUpdateAfiliado.setFeNacimiento("19890304");
        in271RegafiUpdateAfiliado.setGenero("1");
        in271RegafiUpdateAfiliado.setCoPaisDoc("PER");
        in271RegafiUpdateAfiliado.setFefallecimiento("19000101");
        in271RegafiUpdateAfiliado.setCoPaisEmisorDocAct("");
        in271RegafiUpdateAfiliado.setFeActPersonaxIafas("20150106");
        in271RegafiUpdateAfiliado.setIdAfiliadoNombre("0");
        in271RegafiUpdateAfiliado.setTiDocTutor("1");
        in271RegafiUpdateAfiliado.setNuDocTutor("45722376");
        in271RegafiUpdateAfiliado.setTiVinculoTutor("17");
        in271RegafiUpdateAfiliado.setFeValidacionReniec("0");
        in271RegafiUpdateAfiliado.setCoPaisEmisorDocTutor("PER");
        /********DATOS DE AFILIACION******/

        
        
        
        in271RegafiUpdateAfiliacion.setTiDocTitular("1");
        in271RegafiUpdateAfiliacion.setNuDocTitular("45722376");
        in271RegafiUpdateAfiliacion.setFeNacimientoTitular("19890304");
        in271RegafiUpdateAfiliacion.setCoPaisEmisorDocTitular("PER");
        in271RegafiUpdateAfiliacion.setTiContratante("2");
        in271RegafiUpdateAfiliacion.setApPaternoContratante("CUENCA");
        in271RegafiUpdateAfiliacion.setNoContratante1("MARCO ANTONIO");
        in271RegafiUpdateAfiliacion.setNoContratante2("");
        in271RegafiUpdateAfiliacion.setNoContratante3("");
        in271RegafiUpdateAfiliacion.setNoContratante4("");
        in271RegafiUpdateAfiliacion.setApMaternoContratante("SANCHEZ");
        in271RegafiUpdateAfiliacion.setTiDocContratante("1");
        in271RegafiUpdateAfiliacion.setNuDocContratante("45722376");
        in271RegafiUpdateAfiliacion.setApCasadaContratante("");
        in271RegafiUpdateAfiliacion.setFeNacimientoContratante("");
        in271RegafiUpdateAfiliacion.setCoPaisEmisorDocContratante("PER");
        in271RegafiUpdateAfiliacion.setCoAfiliacion("40002");
        in271RegafiUpdateAfiliacion.setCoContrato("163675");
        in271RegafiUpdateAfiliacion.setCoUnicoMultisectorial("");
        in271RegafiUpdateAfiliacion.setTiregimen("1");
        in271RegafiUpdateAfiliacion.setEsAfiliacion("5");
        in271RegafiUpdateAfiliacion.setCoCausalBaja("7");
        in271RegafiUpdateAfiliacion.setTiPlanSalud("2");
        in271RegafiUpdateAfiliacion.setNoProductoSalud("CS OncoClasico");
        in271RegafiUpdateAfiliacion.setCoProducto("1868");
        in271RegafiUpdateAfiliacion.setParentesco("1");
        in271RegafiUpdateAfiliacion.setCoRenipress("");
        in271RegafiUpdateAfiliacion.setPkAfiliado("PER145722376");
        in271RegafiUpdateAfiliacion.setFeActEstado("20160328");
        in271RegafiUpdateAfiliacion.setFeIniAfiliacion("20141217");
        in271RegafiUpdateAfiliacion.setFeFinAfiliacion("20141217");
        in271RegafiUpdateAfiliacion.setFeIniCobertura("20141217");
        in271RegafiUpdateAfiliacion.setFeFinCobertura("0");
        in271RegafiUpdateAfiliacion.setFeActOperacion("20160328");
        in271RegafiUpdateAfiliacion.setTiActOperacion("120339");
        in271RegafiUpdateAfiliacion.setCoTiCobertura("4");
        in271RegafiUpdateAfiliacion.setIdAfiliacionNombre("000");  
        
        
        
        In271RegafiUpdate.addDetalle(in271RegafiUpdateAfiliado);
        In271RegafiUpdate.addDetalle(in271RegafiUpdateAfiliacion);
        return In271RegafiUpdate;
        
        
        
    }
    public List<String> Actualizarafiliados2() {        
        String sError = "9999";
        ArrayList<Afiliacion> listaAfiliacion = new ArrayList<Afiliacion>();                 
        List<String> listaResultado = new ArrayList();               
        listaAfiliacion = ListaAfiliados();       
        if(listaAfiliacion!=null){
            for(int i = 0; i < listaAfiliacion.size() ; i++){
                In271RegafiUpdate           rRegafi     = new In271RegafiUpdate();
                In271RegafiUpdateAfiliado   rAfiliado   = new In271RegafiUpdateAfiliado();
                In271RegafiUpdateAfiliacion rAfiliacion = new In271RegafiUpdateAfiliacion();                                
                Afiliacion afilia = listaAfiliacion.get(i);                                                
                // Datos de cabecera del formato X12N - Constantes
                rRegafi.setNoTransaccion("271_REGAFI_UPDATE");                
                rRegafi.setIdTransaccion("271");
                rRegafi.setIdReceptor("SUSALUD"); 
                rRegafi.setTiFinalidad("13");
                rRegafi.setCaRemitente("2");
                 // Datos de cabecera del formato X12N - Variables
                rRegafi.setIdCorrelativo(String.valueOf(i+100000000));
                rRegafi.setIdRemitente(afilia.getIdRemitente());
                rRegafi.setFeTransaccion(afilia.getFeTransaccion());
                rRegafi.setHoTransaccion(afilia.getHoTransaccion());
                rRegafi.setTiOperacion(afilia.getTiOperacion()); 
                /*****Si existe informacion*****/                             
                 // Datos del afiliado
                if(afilia.getApPaternoAfiliado()!=null) rAfiliado.setApPaternoAfiliado(afilia.getApPaternoAfiliado());  // CAMPO 11
                if(afilia.getNoAfiliado1()!=null)       rAfiliado.setNoAfiliado1(afilia.getNoAfiliado1()); // CAMPO 12
                if(afilia.getNoAfiliado2()!=null)       rAfiliado.setNoAfiliado2(afilia.getNoAfiliado2()); // CAMPO 13
                if(afilia.getApMaternoAfiliado()!=null) rAfiliado.setApMaternoAfiliado(afilia.getApMaternoAfiliado());// CAMPO 14
                if(afilia.getTiDocumentoAfil()!=null)   rAfiliado.setTiDocumentoAfil(afilia.getTiDocumentoAfil());    // CAMPO 15
                if(afilia.getNuDocumentoAfil()!=null)   rAfiliado.setNuDocumentoAfil(afilia.getNuDocumentoAfil());    // CAMPO 16
                if(afilia.getEstadoAfiliado()!=null)    rAfiliado.setEstadoAfiliado(afilia.getEstadoAfiliado());      // CAMPO 17
                if(afilia.getTiDocumentoAct()!=null)    rAfiliado.setTiDocumentoAct(afilia.getTiDocumentoAct());      // CAMPO 18
                if(afilia.getNuDocumentoAct()!=null)    rAfiliado.setNuDocumentoAct(afilia.getNuDocumentoAct());      // CAMPO 19
                if(afilia.getApCasadaAfiliado()!=null)  rAfiliado.setApCasadaAfiliado(afilia.getApCasadaAfiliado());  // CAMPO 20
                if(afilia.getCoNacionalidad()!=null)    rAfiliado.setCoNacionalidad(afilia.getCoNacionalidad());      // CAMPO 21
                if(afilia.getUbigeo()!=null)            rAfiliado.setUbigeo(afilia.getUbigeo());                      // CAMPO 22
                if(afilia.getFeNacimiento()!=null)      rAfiliado.setFeNacimiento(afilia.getFeNacimiento());          // CAMPO 23 
                if(afilia.getGenero()!=null)            rAfiliado.setGenero(afilia.getGenero());                      // CAMPO 24
                if(afilia.getCoPaisDoc()!=null)         rAfiliado.setCoPaisDoc(afilia.getCoPaisDoc());                // CAMPO 25
                if(afilia.getFeFallecimiento()!=null)   rAfiliado.setFefallecimiento(afilia.getFeFallecimiento());    // CAMPO 26
                if(afilia.getCoPaisEmisorDocAct()!=null)rAfiliado.setCoPaisEmisorDocAct(afilia.getCoPaisEmisorDocAct());// CAMPO 27
                if(afilia.getFeActPersonaxIafas()!=null)rAfiliado.setFeActPersonaxIafas(afilia.getFeActPersonaxIafas());// CAMPO 28
                if(afilia.getIdAfiliadoNombre()!=null)  rAfiliado.setIdAfiliadoNombre(afilia.getIdAfiliadoNombre());    // CAMPO 29
                                
                // Datos de la afiliacion                
                if(afilia.getTiDocTutor()!=null)        rAfiliado.setTiDocTutor(afilia.getTiDocTutor());                // CAMPO 30
                if(afilia.getNuDocTutor()!=null)        rAfiliado.setNuDocTutor(afilia.getNuDocTutor());                // CAMPO 31
                if(afilia.getTiVinculoTutor()!=null)    rAfiliado.setTiVinculoTutor(afilia.getTiVinculoTutor());        // CAMPO 32
                if(afilia.getFeValidacionReniec()!=null)rAfiliado.setFeValidacionReniec(afilia.getFeValidacionReniec());// CAMPO 33                
                if(afilia.getCoPaisEmisorDocTutor()!=null) rAfiliado.setCoPaisEmisorDocTutor(afilia.getCoPaisEmisorDocTutor());// CAMPO 34
                
                if(afilia.getTiDocTitular()!=null) rAfiliacion.setTiDocTitular(afilia.getTiDocTitular());               // CAMPO 35
                if(afilia.getNuDocTitular()!=null) rAfiliacion.setNuDocTitular(afilia.getNuDocTitular());               // CAMPO 36
                if(afilia.getFeNacimientoTitular()!=null) rAfiliacion.setFeNacimientoTitular(afilia.getFeNacimientoTitular()); // CAMPO 37
                if(afilia.getCoPaisEmisorDocTitular()!=null) rAfiliacion.setCoPaisEmisorDocTitular(afilia.getCoPaisEmisorDocTitular()); // CAMPO 38
                if(afilia.getTiContratante()!=null) rAfiliacion.setTiContratante(afilia.getTiContratante());                     // CAMPO 39
                if(afilia.getApPaternoContratante()!=null) rAfiliacion.setApPaternoContratante(afilia.getApPaternoContratante());// CAMPO 40
                if(afilia.getNoContratante1()!=null) rAfiliacion.setNoContratante1(afilia.getNoContratante1());                  // CAMPO 41
                if(afilia.getNoContratante2()!=null) rAfiliacion.setNoContratante2(afilia.getNoContratante2());                  // CAMPO 42
                if(afilia.getNoContratante3()!=null) rAfiliacion.setNoContratante3(afilia.getNoContratante3());                  // CAMPO 43
                if(afilia.getNoContratante4()!=null) rAfiliacion.setNoContratante4(afilia.getNoContratante4());                  // CAMPO 44
                if(afilia.getApMaternoContratante()!=null) rAfiliacion.setApMaternoContratante(afilia.getApMaternoContratante()); // CAMPO 45
                
                if(afilia.getTiDocContratante()!=null) rAfiliacion.setTiDocContratante(afilia.getTiDocContratante()); // CAMPO 46
                if(afilia.getNuDocContratante()!=null) rAfiliacion.setNuDocContratante(afilia.getNuDocContratante()); // CAMPO 47
                if(afilia.getApCasadaContratante()!=null) rAfiliacion.setApCasadaContratante(afilia.getApCasadaContratante());// CAMPO 48
                if(afilia.getFeNacimientoContratante()!=null) rAfiliacion.setFeNacimientoContratante(afilia.getFeNacimientoContratante()); // CAMPO 49
                if(afilia.getCoPaisEmisorDocContratante()!=null) rAfiliacion.setCoPaisEmisorDocContratante(afilia.getCoPaisEmisorDocContratante());// CAMPO 50
                if(afilia.getCoAfiliacion()!=null) rAfiliacion.setCoAfiliacion(afilia.getCoAfiliacion()); // CAMPO 51
                if(afilia.getCoContrato()!=null) rAfiliacion.setCoContrato(afilia.getCoContrato());       // CAMPO 52
                if(afilia.getCoUnicoMultisectorial()!=null) rAfiliacion.setCoUnicoMultisectorial(afilia.getCoUnicoMultisectorial()); // CAMPO 53
                if(afilia.getTiRegimen()!=null) rAfiliacion.setTiregimen(afilia.getTiRegimen());   // CAMPO 54
                
                if(afilia.getEsAfiliacion()!=null) rAfiliacion.setEsAfiliacion(afilia.getEsAfiliacion()); // CAMPO 55
                if(afilia.getCoCausalBaja()!=null) rAfiliacion.setCoCausalBaja(afilia.getCoCausalBaja()); // CAMPO 56
                if(afilia.getTiPlanSalud()!=null) rAfiliacion.setTiPlanSalud(afilia.getTiPlanSalud());    // CAMPO 57
                if(afilia.getNoProductoSalud()!=null) rAfiliacion.setNoProductoSalud(afilia.getNoProductoSalud()); // CAMPO 58
                if(afilia.getCoProducto()!=null) rAfiliacion.setCoProducto(afilia.getCoProducto());  // CAMPO 59
                if(afilia.getParentesco()!=null) rAfiliacion.setParentesco(afilia.getParentesco());  // CAMPO 60 
                if(afilia.getCoRenipress()!=null) rAfiliacion.setCoRenipress(afilia.getCoRenipress());// CAMPO 61
                if(afilia.getPkAfiliado()!=null) rAfiliacion.setPkAfiliado(afilia.getPkAfiliado());   // CAMPO 62
                if(afilia.getFeActEstado()!=null) rAfiliacion.setFeActEstado(afilia.getFeActEstado()); // CAMPO 63
                if(afilia.getFeIniAfiliacion()!=null) rAfiliacion.setFeIniAfiliacion(afilia.getFeIniAfiliacion()); // CAMPO 64
                if(afilia.getFeFinAfiliacion()!=null) rAfiliacion.setFeFinAfiliacion(afilia.getFeFinAfiliacion()); // CAMPO 65
                if(afilia.getFeIniCobertura()!=null) rAfiliacion.setFeIniCobertura(afilia.getFeIniCobertura());    // CAMPO 66
                if(afilia.getFeFinCobertura()!=null) rAfiliacion.setFeFinCobertura(afilia.getFeFinCobertura());    // CAMPO 67
                if(afilia.getFeActOperacion()!=null) rAfiliacion.setFeActOperacion(afilia.getFeActOperacion());    // CAMPO 68
                if(afilia.getTiActOperacion()!=null) rAfiliacion.setTiActOperacion(afilia.getTiActOperacion());    // CAMPO 69
                if(afilia.getCoTiCobertura()!=null) rAfiliacion.setCoTiCobertura(afilia.getCoTiCobertura());       // CAMPO 70
                if(afilia.getIdAfiliacionNombre()!=null) rAfiliacion.setIdAfiliacionNombre(afilia.getIdAfiliacionNombre()); // CAMPO 71

                rRegafi.addDetalle(rAfiliado);
                rRegafi.addDetalle(rAfiliacion);
                RegafiUpdate271ServiceImpl regafi = new RegafiUpdate271ServiceImpl();                
                try {                    
                    String sTrama = regafi.beanToX12N(rRegafi);                    
                    //System.out.println(sTrama);                                    
                    sError = rRegafi.getCoError();
                    if(sError.equals("0000")) listaResultado.add(sTrama);
                    else listaResultado.add(sError);
                } catch (Exception e) {
                    listaResultado.add("Error: Verificar especificaciones tecnicas");
//                    String mensaje = "Parametros:\nItem(" + i + 1 + ")" + ManagerTrace.PilaToString(e);
//                    logger.error(mensaje);
                }
            }
        }                
        return listaResultado;
    
    }    
    public String xmlTrama(List<String> xmltrama){
        String ls_xmltrama;
        ls_xmltrama="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<sus:Online271RegafiUpdateRequest xmlns:sus=\"http://www.susalud.gob.pe/Afiliacion/Online271RegafiUpdateRequest.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.susalud.gob.pe/Afiliacion/Online271RegafiUpdateRequest.xsd ../MsgSetProjOnline271RegafiUpdateRequest/importFiles/Online271RegafiUpdateRequest.xsd \">\n" +
                    "  <txNombre>271_REGAFI_UPDATE</txNombre>\n" +
                    "  <txPeticion> "+xmltrama+" </txPeticion>\n" +
                    "</sus:Online271RegafiUpdateRequest>" ;
        return ls_xmltrama;
    }
    public String xmlTrama2(String xmltrama){
        String ls_xmltrama;
        ls_xmltrama="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<sus:Online271RegafiUpdateRequest xmlns:sus=\"http://www.susalud.gob.pe/Afiliacion/Online271RegafiUpdateRequest.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.susalud.gob.pe/Afiliacion/Online271RegafiUpdateRequest.xsd ../MsgSetProjOnline271RegafiUpdateRequest/importFiles/Online271RegafiUpdateRequest.xsd \">\n" +
                    "  <txNombre>271_REGAFI_UPDATE</txNombre>\n" +
                    "  <txPeticion> "+xmltrama+" </txPeticion>\n" +
                    "</sus:Online271RegafiUpdateRequest>" ;
        return ls_xmltrama;
    }    
    static public String ExtraerX12N(String tramaxml, String tag){		
		String cadenax12 = null;
		try {
			String [] p = tramaxml.split(tag);
			String t = p[1];	
			cadenax12 = t.substring(1, t.length()-2);
			
		} catch (Exception e) {
			throw e;
		}
		return cadenax12;
    }         
}