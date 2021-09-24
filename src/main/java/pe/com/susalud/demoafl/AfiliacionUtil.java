package pe.com.susalud.demoafl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;

import org.apache.log4j.Logger;



import pe.gob.susalud.jr.transaccion.susalud.bean.In271RegafiUpdate;
import pe.gob.susalud.jr.transaccion.susalud.bean.In271RegafiUpdateAfiliacion;
import pe.gob.susalud.jr.transaccion.susalud.bean.In271RegafiUpdateAfiliado;
import pe.gob.susalud.jr.transaccion.susalud.bean.In997RegafiUpdate;
import pe.gob.susalud.jr.transaccion.susalud.bean.In997RegafiUpdateExcepcion;
import pe.gob.susalud.jr.transaccion.susalud.service.RegafiUpdate271Service;
import pe.gob.susalud.jr.transaccion.susalud.service.RegafiUpdate997Service;
import pe.gob.susalud.jr.transaccion.susalud.service.imp.RegafiUpdate271ServiceImpl;
import pe.gob.susalud.jr.transaccion.susalud.service.imp.RegafiUpdate997ServiceImpl;


public class AfiliacionUtil {
	
	private static final String SEPARADOR = "\\|";
	private static final String ERROR_CAMPO_CSV = "properties/errorCampo.csv";
	private static final String ERROR_DESCRIPCION_CSV = "properties/errorDescripcion.csv";
	private static String FILE_PROPERTIES = "properties/configurationMQ.properties";
	static protected HashMap<String, String> mapErrorDescripcion;
	static protected HashMap<String, String> mapErrorCampo;
	private static final String tag271 = "txPeticion";
	private static final String tag997 = "txRespuesta";
	
	static Logger logger = Logger.getLogger("AFILIACION");
	
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
	
	static public Trama271Bean procesarTramaX12(String tramaXML) throws Exception{
		
		Trama271Bean bean = null;
		try {
			
			//extraer X12n_271
			String tramax12 = ExtraerX12N(tramaXML,tag271);
			
			
			RegafiUpdate271Service obj = new RegafiUpdate271ServiceImpl();			
			In271RegafiUpdate dato = obj.x12NToBean(tramax12);
			
			if (dato!=null) {
				bean = new Trama271Bean();
				bean.setTiOperacion(dato.getTiOperacion());
				bean.setCaRemitente(dato.getCaRemitente());
				bean.setFeTransaccion(dato.getFeTransaccion());
				bean.setHoTransaccion(dato.getHoTransaccion());
				bean.setIdCorrelativo(dato.getIdCorrelativo());
				
				
				bean.setIdReceptor(dato.getIdReceptor());
				
				bean.setIdRemitente(dato.getIdRemitente());
				bean.setIdTransaccion(dato.getIdTransaccion());
				bean.setNoTransaccion(dato.getNoTransaccion());
				bean.setTiFinalidad(dato.getTiFinalidad());
				
				List<In271RegafiUpdateAfiliado> afiliados = dato.getDetallesAfiliados();
				
				Vector<Vector<String>> dataVector = new Vector<Vector<String>>();
				for (In271RegafiUpdateAfiliado afi : afiliados) {
					Vector<String> fila = new Vector<String>();
					/*					 
					"noAfiliado1",
					"noAfiliado2",
					"apPaternoAfiliado", 
					"apMaternoAfiliado",   
					"tiDocumentoAfil",   
					"nuDocumentoAfil",  
					"estadoAfiliado",
					"tiDocumentoAct",
					"nuDocumentoAct",
					"apCasadaAfiliado",
					"coNacionalidad",
					"ubigeo",
					"feNacimiento",
					"genero",
					"coPaisDoc",
					"fefallecimiento",
					"coPaisEmisorDocAct",
					"feActPersonaxIafas",
					"idAfiliadoNombre",
					"tiDocTutor",
					"nuDocTutor",
					"tiVinculoTutor",
					"feValidacionReniec",
					"coPaisEmisorDocTutor"
					 */
					
					
					String nombre =null;
					
					//nombre 1
					if (afi.getNoAfiliado1()!=null && !afi.getNoAfiliado1().trim().equals("")) {
						nombre=afi.getNoAfiliado1();
					}
					
					//aplicando logica para concatenar nombre 2
					//IdAfiliadoNombre: 0= SIN ESPACIOS; 1=CON ESPACIOS
					if (afi.getIdAfiliadoNombre()!=null && afi.getIdAfiliadoNombre().equals("1")) { 
						
						if (afi.getNoAfiliado2()!=null && !afi.getNoAfiliado2().trim().equals("")) {							
							nombre+=" "+afi.getNoAfiliado2();
						}

					}else{
						
						if (afi.getNoAfiliado2()!=null && !afi.getNoAfiliado2().trim().equals("")) {
							nombre+=afi.getNoAfiliado2();
						}
					}
					
					fila.add(nombre);
					
					fila.add(afi.getApPaternoAfiliado());
					fila.add(afi.getApMaternoAfiliado());
					fila.add(afi.getTiDocumentoAfil());
					fila.add(afi.getNuDocumentoAfil());
					fila.add(afi.getEstadoAfiliado());
					fila.add(afi.getTiDocumentoAct());
					fila.add(afi.getNuDocumentoAct());					
					fila.add(afi.getApCasadaAfiliado());					
					fila.add(afi.getCoNacionalidad());
					fila.add(afi.getUbigeo());
					fila.add(afi.getFeNacimiento());
					fila.add(afi.getGenero());					
					fila.add(afi.getCoPaisDoc());
					fila.add(afi.getFefallecimiento());					
					fila.add(afi.getCoPaisEmisorDocAct());
					fila.add(afi.getFeActPersonaxIafas());
					fila.add(afi.getTiDocTutor());
					fila.add(afi.getNuDocTutor());
					fila.add(afi.getTiVinculoTutor());
					fila.add(afi.getFeValidacionReniec());					
					fila.add(afi.getCoPaisEmisorDocTutor());		
					
					
					dataVector.add(fila);
				}
				bean.setDataVector(dataVector);
				
				List<In271RegafiUpdateAfiliacion> afiliaciones = dato.getDetallesAfiliaciones();
				Vector<Vector<String>> dataVector2 = new Vector<Vector<String>>();
				for (In271RegafiUpdateAfiliacion afiliacion : afiliaciones) {
					Vector<String> fila = new Vector<String>();
					
					/*
					"tiDocTitular",
					"nuDocTitular",
					"feNacimientoTitular", 
					"coPaisEmisorDocTitular",
					"tiContratante",
					"apPaternoContratante",
					"noContratante1",  
					"noContratante2",   
					"noContratante3",
					"noContratante4",
					"apMaternoContratante",
					"tiDocContratante",
					"nuDocContratante",
					"apCasadaContratante",
					"feNacimientoContratante",  
					"coPaisEmisorDocContratante",
					"coAfiliacion",
					"coContrato",
					"coUnicoMulisectorial",
					"tiregimen",
					"esAfiliacion",
					"coCausalBaja",
					"tiPlanSalud",
					"noProductoSalud",
					"coProducto",
					"parentesco",
					"coRenipress",
					"pkAfiliado",
					"feActEstado",
					"feIniAfiliacion",
					"feFinAfiliacion",
					"feIniCobertura",
					"feFinCobertura",
					"feActOperacion",
					"tiActOperacion",
					"coTiCobertura",
					"idAfiliacionNombre"
					 */
					fila.add(afiliacion.getTiDocTitular());
					fila.add(afiliacion.getNuDocTitular());
					fila.add(afiliacion.getFeNacimientoTitular());
					fila.add(afiliacion.getCoPaisEmisorDocTitular());
					fila.add(afiliacion.getTiContratante());					
					
					String nombre =null;
					
					//nombre 1
					if (afiliacion.getNoContratante1()!=null && !afiliacion.getNoContratante1().trim().equals("")) {
						nombre=afiliacion.getNoContratante1();
						
					}
					
					//aplicando logica para concatenar nombres 2, 3 y 4
					//idAfiliacionNombre: 0=SIN ESPACIOS; 1=CON ESPACIOS
										
					String IdAfiliacionNombre = afiliacion.getIdAfiliacionNombre().trim();
					
					for (int i = 0; i < 3; i++) {
						

						
						char char_ = IdAfiliacionNombre.charAt(i);
						
						switch (i) {
						
						case 0: //nombre 2
							
							if (char_=='1') {
								
								if (afiliacion.getNoContratante2()!=null && !afiliacion.getNoContratante2().trim().equals("")) {
									
									nombre+=" "+afiliacion.getNoContratante2();
								}
								
							}else /*if(char_=='0') */{
							
								if (afiliacion.getNoContratante2()!=null && !afiliacion.getNoContratante2().trim().equals("")) {
									
									nombre+=afiliacion.getNoContratante2();
								}
								
							}
							
							break;

						case 1: //nombre 3
							
							if (char_=='1') {
								
								if (afiliacion.getNoContratante3()!=null && !afiliacion.getNoContratante3().trim().equals("")) {
									
									nombre+=" "+afiliacion.getNoContratante3();
								}
								
							}else /*if(char_=='0')*/ {
								
								if (afiliacion.getNoContratante3()!=null && !afiliacion.getNoContratante3().trim().equals("")) {
									
									nombre+=afiliacion.getNoContratante3();
								}
								
							}	
							
							break;
							
						case 2: //nombre 4
							
							if (char_=='1') {
								
								if (afiliacion.getNoContratante4()!=null && !afiliacion.getNoContratante4().trim().equals("")) {
									
									nombre+=" "+afiliacion.getNoContratante4();
								}
								
							}else /*if(char_=='0')*/ {
								
								if (afiliacion.getNoContratante4()!=null && !afiliacion.getNoContratante4().trim().equals("")) {
									
									nombre+=afiliacion.getNoContratante4();
								}
								
							}
							
							break;	
						default:
							break;
						}				
					
						
					}			
					
					
				
					
					fila.add(nombre);
					fila.add(afiliacion.getApPaternoContratante());		
					fila.add(afiliacion.getApMaternoContratante());
					fila.add(afiliacion.getTiContratante());
					fila.add(afiliacion.getNuDocContratante());
					fila.add(afiliacion.getApCasadaContratante());
					fila.add(afiliacion.getFeNacimientoContratante());
					fila.add(afiliacion.getCoPaisEmisorDocContratante());
					fila.add(afiliacion.getCoAfiliacion());	
					fila.add(afiliacion.getCoContrato());
					fila.add(afiliacion.getCoUnicoMultisectorial() );
					fila.add(afiliacion.getTiregimen());
					fila.add(afiliacion.getEsAfiliacion());					
					fila.add(afiliacion.getCoCausalBaja());
					fila.add(afiliacion.getTiPlanSalud());
					fila.add(afiliacion.getNoProductoSalud());
					fila.add(afiliacion.getCoProducto());
					fila.add(afiliacion.getParentesco());
					fila.add(afiliacion.getCoRenipress());
					fila.add(afiliacion.getPkAfiliado());
					fila.add(afiliacion.getFeActEstado());
					fila.add(afiliacion.getFeIniAfiliacion());
					fila.add(afiliacion.getFeFinAfiliacion());
					fila.add(afiliacion.getFeIniCobertura());
					fila.add(afiliacion.getFeFinCobertura());
					fila.add(afiliacion.getFeActOperacion());
					fila.add(afiliacion.getCoTiCobertura());
					
					
					dataVector2.add(fila);
				}
				bean.setDataVector2(dataVector2);
				bean.setDato(dato);
			}
			
			
		} catch (Exception e) {
			throw e;
		}
		return bean;
	}
	
	static public Properties loadFileMQConfig() throws Exception{
		Properties prop = null;
		//InputStream input = null;
		FileInputStream Fileinput = null;
		try {
			
			//input =  ClassLoader.getSystemResourceAsStream(FILE_PROPERTIES);
			// input = AfiliacionUtil.class.getClassLoader().getResourceAsStream(FILE_PROPERTIES);
			Fileinput = new FileInputStream(FILE_PROPERTIES);
			if (Fileinput!=null) {
				prop = new Properties();
				prop.load(Fileinput);
				
			}
		} catch (Exception e) {
			throw e;
		}finally{
			
		}
		
		return prop;
	}
	
	static public Trama997Bean procesarTrama997(String trama) throws Exception {
		
		Trama997Bean bean = null;

    	
		try {
			
			
			if (mapErrorCampo == null) {
				mapErrorCampo = new HashMap<String, String>();
				leerArchivoCSV(ERROR_CAMPO_CSV, mapErrorCampo);
			}
			if (mapErrorDescripcion == null) {
				mapErrorDescripcion = new HashMap<String, String>();
				leerArchivoCSV(ERROR_DESCRIPCION_CSV, mapErrorDescripcion);
			}			
		
			logger.info("==========START CONNECTION MQ=========");
			ClsConnectionMQ cnxmq = new ClsConnectionMQ();
			HashMap<String, String> haspmap = cnxmq.SendMessageSyn(trama);
			logger.info("==========END CONNECTION MQ===========");
			
			String tramaXML = haspmap.get("Msg");
			String msgid = haspmap.get("MsgId");
			
			//extraer X12n_997
			String tramax12 = ExtraerX12N(tramaXML,tag997);
			
			
			RegafiUpdate997Service salida = new RegafiUpdate997ServiceImpl();					
			In997RegafiUpdate bo = salida.x12NToBean(tramax12);
			bo.setFlag(true);
			
			Vector<Vector<String>> dataVector = new Vector<Vector<String>>();
			List<In997RegafiUpdateExcepcion> excepciones = bo.getDetallesExcepcion();
			
			for (In997RegafiUpdateExcepcion ex : excepciones) {
				
				Vector<String> fila = new Vector<String>();
				String coCampoErr = ex.getCoCampoErr();
				fila.add(coCampoErr);
				fila.add(mapErrorCampo.get(coCampoErr));
				fila.add(String.valueOf(ex.isFlagExcepcion())); //flag
				String coDescripError = ex.getInCoErrorEncontrado();
				fila.add(coDescripError);
				fila.add(mapErrorDescripcion.get(coDescripError));
				fila.add(ex.getPkAfiliado());
				fila.add(ex.getPkAfiliadopkAfiliacion());						
				dataVector.add(fila);
			}
			
			bean = new Trama997Bean();
			bean.setFeTransaccion(bo.getFeTransaccion());
			bean.setHoTransaccion(bo.getHoTransaccion());
			bean.setIdCorrelativo(bo.getIdCorrelativo());
			bean.setIdReceptor(bo.getIdReceptor());
			bean.setIdRemitente(bo.getIdRemitente());
			bean.setIdTransaccion(bo.getIdTransaccion());
			bean.setNoTransaccion(bean.getNoTransaccion());
			
			//bean.setNuControl(bo.getNuControl());
			//bean.setNuControlST(bean.getNuControlST());
			bean.setNuControlST(tramaXML);
			bean.setNuControl(msgid);//msgid
			
			
			bean.setExcepciones(dataVector);
			bean.setDato(bo);
				
			
			
		} catch (Exception e) {
		
			throw e;
			
		} finally {
			
		   
		}
		
		return bean;
	}
	
	static protected void leerArchivoCSV(String archivo, Map<String, String> mapa) throws Exception {
		
		BufferedReader reader = null;
		try {
			FileInputStream Fileinput = new FileInputStream(archivo);
			reader = new BufferedReader(new InputStreamReader(Fileinput));
			
			String line = "";
			while ((line = reader.readLine()) != null) {
				String[] campos = line.split(SEPARADOR);
				mapa.put(campos[0], campos[1]);			
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
}

