package pe.com.susalud.afiliacion.trama;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;

import org.apache.commons.codec.binary.Hex;
//import org.apache.log4j.Logger;

import com.ibm.mq.MQGetMessageOptions;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;
import com.ibm.mq.constants.CMQC;


public class ClsConnectionMQ {
    private String hostName = "localhost";
    private int port = 1414;
    private String channelName = "SYSTEM.DEF.SVRCONN";
    private String queueManagerName = null;
    private String queueNameIn = null;
    private String queueNameOut = null;
    static String FILE_PROPERTIES = "properties/configurationMQ.properties";		
    Logger logger = new  Logger();	
    public ClsConnectionMQ() {
	try {

		queueManagerName ="QM.002.999.AF";
		queueNameIn = "QL.CLI.FEBAN.SUSALUD.AF.REQ";
		queueNameOut ="QL.CLI.FEBAN.SUSALUD.AF.RES";
		channelName ="CH.CLIENTE.FEBAN";
		hostName = "170.79.38.205"; // prueba calidad			
		port =Integer.parseInt("21437");

/*

		queueManagerName ="QM.002.999.AF";
		queueNameIn = "QL.CLI.FEBAN.SUSALUD.AF.REQ";
		queueNameOut ="QL.CLI.FEBAN.SUSALUD.AF.RES";
		channelName ="CH.CLIENTE.FEBAN";
		hostName = "app23.susalud.gob.pe "; // produccion				
		port =Integer.parseInt("21437");
*/


	} catch (Exception e) {
		// TODO: handle exception
		logger.error("Exception", e);
	}
     }
	
	
	public HashMap<String, String> SendMessageSyn(String messageString) throws Exception{
		
		
		HashMap<String, String> haspMap = null;		
		MQQueueManager queueManager = null;
                MQQueue queueIn =null;
                MQQueue queueOut = null;
                Hashtable<String, Object> props = null;
                MQMessage putMsg =null;
                MQMessage getMsg =null;
                MQGetMessageOptions getMessageOptions =null;		
		try {		
			props = new Hashtable<String,Object>();				
			props.put(CMQC.CHANNEL_PROPERTY, channelName);
			props.put(CMQC.PORT_PROPERTY, port);
			props.put(CMQC.HOST_NAME_PROPERTY, hostName);
			props.put(CMQC.APPNAME_PROPERTY, "Aplicacion Afiliacion Online JAVA, SUSALUD V1.0");
			props.put(CMQC.TRANSPORT_PROPERTY, CMQC.TRANSPORT_MQSERIES_CLIENT);
                        queueManager = new MQQueueManager(queueManagerName,props);
			queueIn = queueManager.accessQueue(queueNameIn,  CMQC.MQOO_OUTPUT | CMQC.MQOO_FAIL_IF_QUIESCING);						
			putMsg = new MQMessage();
			putMsg.characterSet=819;//MQC.MQCCSI_Q_MGR;
			putMsg.encoding= 273;
			putMsg.format = CMQC.MQFMT_STRING;	
			putMsg.writeString(messageString);		
			System.out.println(messageString);	
			queueIn.put(putMsg);
			queueOut = queueManager.accessQueue(queueNameOut, CMQC.MQOO_INPUT_AS_Q_DEF | CMQC.MQOO_FAIL_IF_QUIESCING);	
			getMsg = new MQMessage();
			getMsg.characterSet=819;//MQC.MQCCSI_Q_MGR;
			getMsg.encoding= 273;
			getMsg.messageId = putMsg.messageId;		
			
			System.err.println("Identificador end envio :" + putMsg.messageId);	
			// Specify default get message options
			getMessageOptions= new MQGetMessageOptions();
			getMessageOptions.matchOptions = CMQC.MQMO_MATCH_MSG_ID;
			getMessageOptions.options = CMQC.MQGMO_WAIT;
			getMessageOptions.waitInterval = 1000;
			int isContinuar = 0;
			int numReIntentos =4; 
			do {				
				try {					
					// Get the message off the queue.					
					queueOut.get(getMsg, getMessageOptions);						
					break;
				} catch (Exception e) {
					//nothing
					isContinuar++; 
                        if (isContinuar <= numReIntentos)
                                            logger.info("...and getting the message back again: "+isContinuar);
                            }
				
			} while (isContinuar<=numReIntentos);				
			//logger.info("done");
			if (getMsg.getDataLength()>0) {				
				// And display the message text...
				//logger.info("ready message get");
				String tramaXML = getMsg.readStringOfByteLength(getMsg.getDataLength());
				//logger.info("Message got: " + tramaXML);
				String msgid = new String(Hex.encodeHex(getMsg.messageId));
				//logger.info("Msg Id: "+msgid);
				//logger.info("done");				
				haspMap = new HashMap<>();
				haspMap.put("MsgId", msgid);
				haspMap.put("Msg", tramaXML);
			}						
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
			
		} finally {			
			//clear messages
			if (putMsg!=null) {
				putMsg.clearMessage();
			}			
			if (getMsg!=null) {				
				getMsg.clearMessage();
			}
			
			// Close the queues
                        if (queueIn!=null) {	    		
                                queueIn.close();
                            }

                        if (queueOut!=null) {
                                queueOut.close();
                        }				    	
                        if (queueManager!=null) {								
                                queueManager.disconnect();
                        }		  
		}
		return haspMap;
	}
	
	private Properties loadFileMQConfig() throws Exception{
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
}
