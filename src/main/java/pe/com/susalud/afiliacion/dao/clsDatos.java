/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.susalud.afiliacion.dao;
//import CapaEntidad.*;
/**
 *
 * @author fhuancco
 */

import java.sql.*;
import java.util.ArrayList;

import pe.com.susalud.afiliacion.entidad.bean.Afiliacion;
import pe.com.susalud.afiliacion.entidad.bean.AfiliacionData;
import pe.com.susalud.afiliacion.entidad.bean.AfiliacionDataDet;
import pe.com.susalud.afiliacion.entidad.bean.Afiliados;
import pe.com.susalud.afiliacion.entidad.bean.Constante;
import pe.com.susalud.afiliacion.entidad.bean.SusaludTrama;
import pe.com.susalud.afiliacion.entidad.bean.Tramax;
public class clsDatos {
    
    
    // Campos
    private String Driver;
    private String URL;
    private String Usuario;
    private String Password;
    private Connection Cn;
    private Statement Cmd;
    private ResultSet Rs;
    private CallableStatement Prm;
    
//        this.URL = "jdbc:jtds:sqlserver://172.16.16.8;DatabaseName=Feban_Web_prueba";
///        this.Usuario = "webs_prueba";
//        this.Password = "Ws123";    
    
    //
    
    //
    
    
    public clsDatos() {
        this.Driver = "net.sourceforge.jtds.jdbc.Driver";
    //  this.URL = "jdbc:jtds:sqlserver://10.10.0.84;DatabaseName=FEBAN_desarrollo";
        this.URL = "jdbc:jtds:sqlserver://fbsv10006;DatabaseName=FEBAN";
        this.Usuario = "UAfiliadosO";
        this.Password = "Ab123";
        try{
            Class.forName(Driver);
            Cn = DriverManager.getConnection(this.URL,
                    this.Usuario,
                    this.Password);
            Cmd = Cn.createStatement();
        }catch(Exception ex){
            System.out.println("*** ERROR:"+ex.getMessage());
        }
    }
    
    public ArrayList<Tramax> ListarRespuestaTrama(String nomArchivo) {
        ArrayList<Tramax> data = new ArrayList();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Tramax trama = new Tramax();
        try {
            String sql = "select * from TB_SUSALUDTRAMAX12";
            pstm = this.Cn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()) {
                trama.setC_c_afi(rs.getString("C_C_AFILIADO"));
                trama.setD_dt_envio(rs.getString("D_DT_ENVIO"));
                trama.setC_tenvio(rs.getString(""));
                data.add(trama);
            }
        } 
        catch (Exception e) {
        }
        return data;
    }
    
    public ArrayList ListarTrama(String cod) throws Exception {
        ArrayList data = new ArrayList();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            String sql = "select x_trama from TB_TRAMAX12_SUSALUD WHERE C_C_ID = '" + cod + "'";
            pstm = this.Cn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()) {
                String x12n = rs.getString("x_trama");
                //System.out.println("");
                data.add(x12n);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
    
    public ArrayList<AfiliacionDataDet> ListarAfiliacion(String fechaInicio, String fechaFin, int tipoAfi) throws Exception {
		ArrayList<AfiliacionDataDet> data = new ArrayList<AfiliacionDataDet>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			//String sql = "Exec sp_data_afi_susalud ?,?,?";
                        String sql = "Exec sp_data_afi_susalud_relacion ?,?,?";
			pstm = this.Cn.prepareCall(sql);
                        pstm.setInt(1, tipoAfi);
                        pstm.setString(2, fechaInicio);
			pstm.setString(3, fechaFin);
			rs = pstm.executeQuery();
			while(rs.next()) {
				AfiliacionDataDet oAfiliacion = new AfiliacionDataDet();
				oAfiliacion.setC_c_afiliado(rs.getString(1));
				oAfiliacion.setC_t_afiliado(rs.getString(2));
				oAfiliacion.setN_dni(rs.getString(3));
				oAfiliacion.setN_flg_tipo_afiliacion(rs.getInt(4));
				oAfiliacion.setC_c_motivo_afiliacion(rs.getString(5));
				oAfiliacion.setC_t_motivo_afiliacion(rs.getString(6));
                                oAfiliacion.setD_dt_doc(rs.getString(7));
				data.add(oAfiliacion);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {

			} 
			catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return data;
	}
	
	public boolean InsertarAfiliacion(AfiliacionData a) throws Exception {
            PreparedStatement pstm = null;
            boolean respuesta = true;
            boolean graba1 = false;
            boolean graba2 = false;
            String codEnvioSusalud = "";
		
            try {
                //
                CallableStatement cstmt = this.Cn.prepareCall(
                                            "{call SP_INSERT_TB_ENVIO_SUSALUD(?,?,?,?)}");
                cstmt.setInt(1, a.getC_tipo());
                cstmt.setString(2, a.getC_c_usuario());
                cstmt.setInt(3, a.getN_i_cantidad());
                cstmt.registerOutParameter(4, java.sql.Types.VARCHAR);
                graba1 = cstmt.execute();
                codEnvioSusalud = cstmt.getString(4);
                Constante.codigoEnvioSusalud = codEnvioSusalud;
                //System.out.println(codEnvioSusalud.trim());

                ArrayList<AfiliacionDataDet> listaAfiliacionDet = a.getLstAfiliacionDet();
                for(AfiliacionDataDet afi : listaAfiliacionDet) {
                //
                    CallableStatement cstmt2 = this.Cn.prepareCall(
                    "{call SP_INSERT_TB_ENVIO_SUSALUD_DET (?,?,?)}");
                    cstmt2.setString(1, codEnvioSusalud.trim());
                    cstmt2.setString(2, afi.getC_c_afiliado());
                    cstmt2.setString(3, afi.getN_dni());
                    graba2 = cstmt2.execute();
                }
                if (graba1 == true && graba2 == true){
                    respuesta = true;

                    // ListaAfiliadosParam(codEnvioSusalud);
                }
                else{
                    respuesta = false;
                }
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
            return respuesta;
	}
    
   public ArrayList VerAfiliado(){
        ArrayList Lista = new ArrayList();        
        try{
            Prm = this.Cn.prepareCall("{CALL VerAfiliados()}");
            Rs = Prm.executeQuery();
            while(Rs.next()){
                Afiliados ObjC = new Afiliados();
                ObjC.setC_c_afiliado(Rs.getString("c_c_afiliado"));
                ObjC.setC_t_afiliado(Rs.getString("c_t_afiliado"));
                ObjC.setFlg_pam(Rs.getInt("flg_pam"));                
                Lista.add(ObjC);
            }
        }catch(Exception ex){
            System.out.println("*** ERROR:"+ex.getMessage());
        }
        return Lista;
   }      
   public String SusaludConfirmacion(SusaludTrama susaludTrama ) throws Exception{
       String  sw="false";
       try {
            Prm = this.Cn.prepareCall("{CALL sp_ins_susaludtramax12(?,?,?,?,?,?,?,?)} ");
            
            Prm.setString(1,susaludTrama.getIdafiliado() );                                            
            Prm.setString(2, susaludTrama.getTtenvio());
            Prm.setString(3, susaludTrama.getIdconfirmacion());
            Prm.setString(4, susaludTrama.getIderror());
            Prm.setInt(5, susaludTrama.getNvector());
            Prm.setString(6, susaludTrama.getXerror());            
            Prm.setString(7, susaludTrama.getXtramaenvio());            
            Prm.setString(8, susaludTrama.getXtramaretorno());            
            //Rs = Prm.executeQuery();    
            Prm.execute();            
            sw="true";
            
       } catch (Exception e) {
            e.printStackTrace();
            throw e;
            //sw="false";
       }   
       
       return sw;
   }
   
   public String Ins_tramaX12(String susaludTrama) throws Exception{
       String  sw="false";
       try {
            Prm = this.Cn.prepareCall("{CALL sp_ins_tramax12_susalud(?)} ");
            Prm.setString(1,susaludTrama );
            Prm.execute();            
            sw="true";
            
       } catch (Exception e) {
            e.printStackTrace();
            throw e;
            //sw="false";
       }   
       
       return sw;
   }
   
   public String Ins_tramaX12Param(String susaludTrama, String id, String codAfi) throws Exception{
       String  sw="false";
       try {
            Prm = this.Cn.prepareCall("{CALL sp_ins_tramax12_susalud(?,?,?)} ");
            Prm.setString(1,susaludTrama );
            Prm.setString(2, id);
            Prm.setString(3, codAfi);
            Prm.execute();            
            sw="true";
            
       } catch (Exception e) {
            e.printStackTrace();
            throw e;
            //sw="false";
       }   
       
       return sw;
   }
   
   public ArrayList ListaAfiliadosParam(String cod){
           ArrayList Lista = new ArrayList();   
           int cont = 0;
           try{
               if(Constante.codTipo == 0) {
                   Prm = this.Cn.prepareCall("{CALL sp_afiliados_lineambatch_prm_bajas(" + cod + ")}");
                   System.out.print("SP->sp_afiliados_lineambatch_prm_bajas(" + cod + ")\n");
               }
               else if(Constante.codTipo == 1) {
                   Prm = this.Cn.prepareCall("{CALL sp_afiliados_lineambatch_prm(" + cod + ")}");
                   System.out.print("SP->sp_afiliados_lineambatch_prm(" + cod + ")\n");
               }
               
               Rs = Prm.executeQuery();
               while(Rs.next()){
                   Afiliacion ObjA = new Afiliacion();

                   ObjA.setIdRemitente(Rs.getString("IdRemitente"));
                   ObjA.setFeTransaccion(Rs.getString("FeTransaccion"));
                   ObjA.setHoTransaccion(Rs.getString("HoTransaccion"));
                   ObjA.setTiOperacion(Rs.getString("TiOperacion"));


                   ObjA.setApPaternoAfiliado(Rs.getString("ApPaternoAfiliado"));
                   ObjA.setNoAfiliado1(Rs.getString("NoAfiliado1"));
                   ObjA.setNoAfiliado2(Rs.getString("NoAfiliado2"));                   
                   ObjA.setApMaternoAfiliado(Rs.getString("ApMaternoAfiliado")); 
                   ObjA.setTiDocumentoAfil(Rs.getString("TiDocumentoAfil")); 
                   ObjA.setNuDocumentoAfil(Rs.getString("NuDocumentoAfil")); 
                   ObjA.setEstadoAfiliado(Rs.getString("EstadoAfiliado")); 
                   ObjA.setTiDocumentoAct(Rs.getString("TiDocumentoAct")); 
                   ObjA.setNuDocumentoAct(Rs.getString("NuDocumentoAct")); 
                   ObjA.setApCasadaAfiliado(Rs.getString("ApCasadaAfiliado")); 
                   ObjA.setCoNacionalidad(Rs.getString("CoNacionalidad")); 
                   ObjA.setUbigeo(Rs.getString("Ubigeo"));                
                   ObjA.setFeNacimiento(Rs.getString("FeNacimiento")); 
                   ObjA.setGenero(Rs.getString("Genero")); 
                   ObjA.setCoPaisDoc(Rs.getString("CoPaisDoc")); 
                   ObjA.setFeFallecimiento(Rs.getString("FeFallecimiento")); 
                   ObjA.setCoPaisEmisorDocAct(Rs.getString("CoPaisEmisorDocAct")); 
                   ObjA.setFeActPersonaxIafas(Rs.getString("FeActPersonaxIafas")); 
                   ObjA.setIdAfiliadoNombre(Rs.getString("IdAfiliadoNombre")); 
                   // Datos de la afiliacion

                   ObjA.setTiDocTutor(Rs.getString("TiDocTutor")); 
                   ObjA.setNuDocTutor(Rs.getString("NuDocTutor")); 
                   ObjA.setTiVinculoTutor(Rs.getString("TiVinculoTutor")); 
                   ObjA.setFeValidacionReniec(Rs.getString("FeValidacionReniec")); 
                   ObjA.setCoPaisEmisorDocTutor(Rs.getString("CoPaisEmisorDocTutor")); 
                   ObjA.setTiDocTitular(Rs.getString("TiDocTitular")); 
                   ObjA.setNuDocTitular(Rs.getString("NuDocTitular")); 
                   ObjA.setFeNacimientoTitular(Rs.getString("FeNacimientoTitular")); 

                   ObjA.setCoPaisEmisorDocTitular(Rs.getString("CoPaisEmisorDocTitular")); 
                   ObjA.setTiContratante(Rs.getString("TiContratante")); 
                   ObjA.setApPaternoContratante(Rs.getString("ApPaternoContratante")); 
                   ObjA.setNoContratante1(Rs.getString("NoContratante1")); 
                   ObjA.setNoContratante2(Rs.getString("NoContratante2")); 
                   ObjA.setNoContratante3(Rs.getString("NoContratante3")); 
                   ObjA.setNoContratante4(Rs.getString("NoContratante4")); 
                   ObjA.setApMaternoContratante(Rs.getString("ApMaternoContratante")); 
                   ObjA.setTiDocContratante(Rs.getString("TiDocContratante")); 
                   ObjA.setNuDocContratante(Rs.getString("NuDocContratante")); 
                   ObjA.setApCasadaContratante(Rs.getString("ApCasadaContratante")); 
                   ObjA.setFeNacimientoContratante(Rs.getString("FeNacimientoContratante"));  // la estructura esta distinto
                   ObjA.setCoPaisEmisorDocContratante(Rs.getString("CoPaisEmisorDocContratante")); 
                   ObjA.setCoAfiliacion(Rs.getString("CoAfiliacion")); 
                   ObjA.setCoContrato(Rs.getString("CoContrato")); 

                   //System.out.println(Rs.getString("CoContrato"));
                   ObjA.setCoUnicoMultisectorial(Rs.getString("CoUnicoMultisectorial")); 
                   ObjA.setTiRegimen(Rs.getString("TiRegimen")); 
                   ObjA.setEsAfiliacion(Rs.getString("EsAfiliacion")); 
                   ObjA.setCoCausalBaja(Rs.getString("CoCausalBaja")); 
                   ObjA.setTiPlanSalud(Rs.getString("TiPlanSalud")); 
                   ObjA.setNoProductoSalud(Rs.getString("NoProductoSalud")); 
                   ObjA.setCoProducto(Rs.getString("CoProducto")); 
                   ObjA.setParentesco(Rs.getString("Parentesco")); 
                   ObjA.setCoRenipress(Rs.getString("CoRenipress")); 
                   ObjA.setPkAfiliado(Rs.getString("PkAfiliado")); 
                   ObjA.setFeActEstado(Rs.getString("FeActEstado")); 
                   ObjA.setFeIniAfiliacion(Rs.getString("FeIniAfiliacion")); 
                   ObjA.setFeFinAfiliacion(Rs.getString("FeFinAfiliacion")); 
                   ObjA.setFeIniCobertura(Rs.getString("FeIniCobertura")); 
                   ObjA.setFeFinCobertura(Rs.getString("FeFinCobertura")); 
                   ObjA.setFeActOperacion(Rs.getString("FeActOperacion")); 
                   ObjA.setTiActOperacion(Rs.getString("TiActOperacion")); 
                   ObjA.setCoTiCobertura(Rs.getString("CoTiCobertura")); 
                   ObjA.setIdAfiliacionNombre(Rs.getString("IdAfiliacionNombre"));
                   ObjA.setCodAfiliado(Rs.getString("IdAfiliado"));
                   ObjA.setApCasadaAfiliado("");                  

                   Lista.add(ObjA);
                   cont++;
                   //System.out.println("Registro N°" + cont);
               }
           }catch(Exception ex){
               System.out.println("*** ERROR:"+ex.getMessage());
               ex.printStackTrace();
           }
           return Lista;
       } 
   
   public ArrayList ListaAfiliados(){
           ArrayList Lista = new ArrayList(); 
           
           try{
               //Prm = this.Cn.prepareCall("{CALL sp_afiliados_linea()}");
               Prm = this.Cn.prepareCall("{CALL sp_afiliados_lineambatch()}");            
               //Prm = this.Cn.prepareCall("{CALL sp_afiliadoslineamovi('16034320039116')}");
               //Prm = this.Cn.prepareCall("{CALL sp_afiliado_susalud_actu('FE10019800')}");
               Rs = Prm.executeQuery();
               while(Rs.next()){
                   Afiliacion ObjA = new Afiliacion();

                   ObjA.setIdRemitente(Rs.getString("IdRemitente"));
                   ObjA.setFeTransaccion(Rs.getString("FeTransaccion"));
                   ObjA.setHoTransaccion(Rs.getString("HoTransaccion"));
                   ObjA.setTiOperacion(Rs.getString("TiOperacion"));


                   ObjA.setApPaternoAfiliado(Rs.getString("ApPaternoAfiliado"));
                   ObjA.setNoAfiliado1(Rs.getString("NoAfiliado1"));
                   ObjA.setNoAfiliado2(Rs.getString("NoAfiliado2"));                   
                   ObjA.setApMaternoAfiliado(Rs.getString("ApMaternoAfiliado")); 
                   ObjA.setTiDocumentoAfil(Rs.getString("TiDocumentoAfil")); 
                   ObjA.setNuDocumentoAfil(Rs.getString("NuDocumentoAfil")); 
                   ObjA.setEstadoAfiliado(Rs.getString("EstadoAfiliado")); 
                   ObjA.setTiDocumentoAct(Rs.getString("TiDocumentoAct")); 
                   ObjA.setNuDocumentoAct(Rs.getString("NuDocumentoAct")); 
                   ObjA.setApCasadaAfiliado(Rs.getString("ApCasadaAfiliado")); 
                   ObjA.setCoNacionalidad(Rs.getString("CoNacionalidad")); 
                   ObjA.setUbigeo(Rs.getString("Ubigeo"));                
                   ObjA.setFeNacimiento(Rs.getString("FeNacimiento")); 
                   ObjA.setGenero(Rs.getString("Genero")); 
                   ObjA.setCoPaisDoc(Rs.getString("CoPaisDoc")); 
                   ObjA.setFeFallecimiento(Rs.getString("FeFallecimiento")); 
                   ObjA.setCoPaisEmisorDocAct(Rs.getString("CoPaisEmisorDocAct")); 
                   ObjA.setFeActPersonaxIafas(Rs.getString("FeActPersonaxIafas")); 
                   ObjA.setIdAfiliadoNombre(Rs.getString("IdAfiliadoNombre")); 
                   // Datos de la afiliacion

                   ObjA.setTiDocTutor(Rs.getString("TiDocTutor")); 
                   ObjA.setNuDocTutor(Rs.getString("NuDocTutor")); 
                   ObjA.setTiVinculoTutor(Rs.getString("TiVinculoTutor")); 
                   ObjA.setFeValidacionReniec(Rs.getString("FeValidacionReniec")); 
                   ObjA.setCoPaisEmisorDocTutor(Rs.getString("CoPaisEmisorDocTutor")); 
                   ObjA.setTiDocTitular(Rs.getString("TiDocTitular")); 
                   ObjA.setNuDocTitular(Rs.getString("NuDocTitular")); 
                   ObjA.setFeNacimientoTitular(Rs.getString("FeNacimientoTitular")); 

                   ObjA.setCoPaisEmisorDocTitular(Rs.getString("CoPaisEmisorDocTitular")); 
                   ObjA.setTiContratante(Rs.getString("TiContratante")); 
                   ObjA.setApPaternoContratante(Rs.getString("ApPaternoContratante")); 
                   ObjA.setNoContratante1(Rs.getString("NoContratante1")); 
                   ObjA.setNoContratante2(Rs.getString("NoContratante2")); 
                   ObjA.setNoContratante3(Rs.getString("NoContratante3")); 
                   ObjA.setNoContratante4(Rs.getString("NoContratante4")); 
                   ObjA.setApMaternoContratante(Rs.getString("ApMaternoContratante")); 
                   ObjA.setTiDocContratante(Rs.getString("TiDocContratante")); 
                   ObjA.setNuDocContratante(Rs.getString("NuDocContratante")); 
                   ObjA.setApCasadaContratante(Rs.getString("ApCasadaContratante")); 
                   ObjA.setFeNacimientoContratante(Rs.getString("FeNacimientoContratante"));  // la estructura esta distinto
                   ObjA.setCoPaisEmisorDocContratante(Rs.getString("CoPaisEmisorDocContratante")); 
                   ObjA.setCoAfiliacion(Rs.getString("CoAfiliacion")); 
                   ObjA.setCoContrato(Rs.getString("CoContrato")); 

                   //System.out.println(Rs.getString("CoContrato"));
                   ObjA.setCoUnicoMultisectorial(Rs.getString("CoUnicoMultisectorial")); 
                   ObjA.setTiRegimen(Rs.getString("TiRegimen")); 
                   ObjA.setEsAfiliacion(Rs.getString("EsAfiliacion")); 
                   ObjA.setCoCausalBaja(Rs.getString("CoCausalBaja")); 
                   ObjA.setTiPlanSalud(Rs.getString("TiPlanSalud")); 
                   ObjA.setNoProductoSalud(Rs.getString("NoProductoSalud")); 
                   ObjA.setCoProducto(Rs.getString("CoProducto")); 
                   ObjA.setParentesco(Rs.getString("Parentesco")); 
                   ObjA.setCoRenipress(Rs.getString("CoRenipress")); 
                   ObjA.setPkAfiliado(Rs.getString("PkAfiliado")); 
                   ObjA.setFeActEstado(Rs.getString("FeActEstado")); 
                   ObjA.setFeIniAfiliacion(Rs.getString("FeIniAfiliacion")); 
                   ObjA.setFeFinAfiliacion(Rs.getString("FeFinAfiliacion")); 
                   ObjA.setFeIniCobertura(Rs.getString("FeIniCobertura")); 
                   ObjA.setFeFinCobertura(Rs.getString("FeFinCobertura")); 
                   ObjA.setFeActOperacion(Rs.getString("FeActOperacion")); 
                   ObjA.setTiActOperacion(Rs.getString("TiActOperacion")); 
                   ObjA.setCoTiCobertura(Rs.getString("CoTiCobertura")); 
                   ObjA.setIdAfiliacionNombre(Rs.getString("IdAfiliacionNombre")); 
                   ObjA.setApCasadaAfiliado("");                  

                   Lista.add(ObjA);
                   
               }
           }catch(Exception ex){
               System.out.println("*** ERROR:"+ex.getMessage());
               ex.printStackTrace();
           }
           return Lista;
       }      
   public ArrayList ListaTrama997(){
           ArrayList Lista = new ArrayList();        
           try{
               
               Prm = this.Cn.prepareCall("{CALL sp_trama_997x()}");                                          
               Rs = Prm.executeQuery();
               while(Rs.next()){
                   Tramax ObjA = new Tramax();

                   ObjA.setDato(Rs.getString("dato"));
                   Lista.add(ObjA);
               }
           }catch(Exception ex){
               System.out.println("*** ERROR:"+ex.getMessage());
               ex.printStackTrace();
           }
           return Lista;
       }      
   
   public ArrayList ListaAfiliadosPrueba(){
           ArrayList Lista = new ArrayList();        
           try{
               //Prm = this.Cn.prepareCall("{CALL sp_afiliados_linea()}");
               Prm = this.Cn.prepareCall("{CALL sp_afiliados_lineambatch()}");            
               //Prm = this.Cn.prepareCall("{CALL sp_afiliadoslineamovi('16034320039369')}");
               //Prm = this.Cn.prepareCall("{CALL sp_afiliado_susalud_actu('FE10019800')}");
               Rs = Prm.executeQuery();
               while(Rs.next()){
                   Afiliacion ObjA = new Afiliacion();

                   ObjA.setIdRemitente(Rs.getString("IdRemitente"));
                   ObjA.setFeTransaccion(Rs.getString("FeTransaccion"));
                   ObjA.setHoTransaccion(Rs.getString("HoTransaccion"));
                   ObjA.setTiOperacion(Rs.getString("TiOperacion"));


                   ObjA.setApPaternoAfiliado(Rs.getString("ApPaternoAfiliado"));
                   ObjA.setNoAfiliado1(Rs.getString("NoAfiliado1"));
                   ObjA.setNoAfiliado2(Rs.getString("NoAfiliado2"));                   
                   ObjA.setApMaternoAfiliado(Rs.getString("ApMaternoAfiliado")); 
                   ObjA.setTiDocumentoAfil(Rs.getString("TiDocumentoAfil")); 
                   ObjA.setNuDocumentoAfil(Rs.getString("NuDocumentoAfil")); 
                   ObjA.setEstadoAfiliado(Rs.getString("EstadoAfiliado")); 
                   ObjA.setTiDocumentoAct(Rs.getString("TiDocumentoAct")); 
                   ObjA.setNuDocumentoAct(Rs.getString("NuDocumentoAct")); 
                   ObjA.setApCasadaAfiliado(Rs.getString("ApCasadaAfiliado")); 
                   ObjA.setCoNacionalidad(Rs.getString("CoNacionalidad")); 
                   ObjA.setUbigeo(Rs.getString("Ubigeo"));                
                   ObjA.setFeNacimiento(Rs.getString("FeNacimiento")); 
                   ObjA.setGenero(Rs.getString("Genero")); 
                   ObjA.setCoPaisDoc(Rs.getString("CoPaisDoc")); 
                   ObjA.setFeFallecimiento(Rs.getString("FeFallecimiento")); 
                   ObjA.setCoPaisEmisorDocAct(Rs.getString("CoPaisEmisorDocAct")); 
                   ObjA.setFeActPersonaxIafas(Rs.getString("FeActPersonaxIafas")); 
                   ObjA.setIdAfiliadoNombre(Rs.getString("IdAfiliadoNombre")); 
                   // Datos de la afiliacion

                   ObjA.setTiDocTutor(Rs.getString("TiDocTutor")); 
                   ObjA.setNuDocTutor(Rs.getString("NuDocTutor")); 
                   ObjA.setTiVinculoTutor(Rs.getString("TiVinculoTutor")); 
                   ObjA.setFeValidacionReniec(Rs.getString("FeValidacionReniec")); 
                   ObjA.setCoPaisEmisorDocTutor(Rs.getString("CoPaisEmisorDocTutor")); 
                   ObjA.setTiDocTitular(Rs.getString("TiDocTitular")); 
                   ObjA.setNuDocTitular(Rs.getString("NuDocTitular")); 
                   ObjA.setFeNacimientoTitular(Rs.getString("FeNacimientoTitular")); 

                   ObjA.setCoPaisEmisorDocTitular(Rs.getString("CoPaisEmisorDocTitular")); 
                   ObjA.setTiContratante(Rs.getString("TiContratante")); 
                   ObjA.setApPaternoContratante(Rs.getString("ApPaternoContratante")); 
                   ObjA.setNoContratante1(Rs.getString("NoContratante1")); 
                   ObjA.setNoContratante2(Rs.getString("NoContratante2")); 
                   ObjA.setNoContratante3(Rs.getString("NoContratante3")); 
                   ObjA.setNoContratante4(Rs.getString("NoContratante4")); 
                   ObjA.setApMaternoContratante(Rs.getString("ApMaternoContratante")); 
                   ObjA.setTiDocContratante(Rs.getString("TiDocContratante")); 
                   ObjA.setNuDocContratante(Rs.getString("NuDocContratante")); 
                   ObjA.setApCasadaContratante(Rs.getString("ApCasadaContratante")); 
                   ObjA.setFeNacimientoContratante(Rs.getString("FeNacimientoContratante"));  // la estructura esta distinto
                   ObjA.setCoPaisEmisorDocContratante(Rs.getString("CoPaisEmisorDocContratante")); 
                   ObjA.setCoAfiliacion(Rs.getString("CoAfiliacion")); 
                   ObjA.setCoContrato(Rs.getString("CoContrato")); 

                   //System.out.println(Rs.getString("CoContrato"));
                   ObjA.setCoUnicoMultisectorial(Rs.getString("CoUnicoMultisectorial")); 
                   ObjA.setTiRegimen(Rs.getString("TiRegimen")); 
                   ObjA.setEsAfiliacion(Rs.getString("EsAfiliacion")); 
                   ObjA.setCoCausalBaja(Rs.getString("CoCausalBaja")); 
                   ObjA.setTiPlanSalud(Rs.getString("TiPlanSalud")); 
                   ObjA.setNoProductoSalud(Rs.getString("NoProductoSalud")); 
                   ObjA.setCoProducto(Rs.getString("CoProducto")); 
                   ObjA.setParentesco(Rs.getString("Parentesco")); 
                   ObjA.setCoRenipress(Rs.getString("CoRenipress")); 
                   ObjA.setPkAfiliado(Rs.getString("PkAfiliado")); 
                   ObjA.setFeActEstado(Rs.getString("FeActEstado")); 
                   ObjA.setFeIniAfiliacion(Rs.getString("FeIniAfiliacion")); 
                   ObjA.setFeFinAfiliacion(Rs.getString("FeFinAfiliacion")); 
                   ObjA.setFeIniCobertura(Rs.getString("FeIniCobertura")); 
                   ObjA.setFeFinCobertura(Rs.getString("FeFinCobertura")); 
                   ObjA.setFeActOperacion(Rs.getString("FeActOperacion")); 
                   ObjA.setTiActOperacion(Rs.getString("TiActOperacion")); 
                   ObjA.setCoTiCobertura(Rs.getString("CoTiCobertura")); 
                   ObjA.setIdAfiliacionNombre(Rs.getString("IdAfiliacionNombre")); 
                   ObjA.setApCasadaAfiliado("");                  
                  
                   
                   
                   Lista.add(ObjA);
               }
           }catch(Exception ex){
               System.out.println("*** ERROR:"+ex.getMessage());
               ex.printStackTrace();
           }
           return Lista;
       }            
   public String errorCampo(String  vcod) throws Exception{
            String  ls_numeroexp = null;            
            ResultSet rs;            
            try{                
                PreparedStatement p = this.Cn.prepareStatement("Select codigo,descripcion from vErrorCampo  where codigo=?");                
                p.setString(1,vcod );
                rs=p.executeQuery();            
                while (rs.next()){                               
                     ls_numeroexp= rs.getString("descripcion");                       
                }                
            }catch(Exception e){            
                System.out.println("*** ERROR:"+e.getMessage());
                e.printStackTrace();
            } 
           return ls_numeroexp;     
    }    
   public String errorDescripcion(String  vcod) throws Exception{
            String  ls_numeroexp = null;
            ResultSet rs;
            try{
                              
                PreparedStatement p = this.Cn.prepareStatement("Select codigo,descripcion from vErrorDescripcion  where codigo=? ");                                
                p.setString(1, vcod);
                rs=p.executeQuery();            
                while (rs.next()){                               
                     ls_numeroexp= rs.getString("descripcion");  
                }                
            }catch(Exception e){            
                 System.out.println("*** ERROR:"+e.getMessage());
                 e.printStackTrace();
            }    
           return ls_numeroexp;     
    }   
   
}
 