package pe.com.susalud.demoafl;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;

import org.apache.commons.codec.binary.Hex;
import org.apache.log4j.Logger;

import com.ibm.mq.MQGetMessageOptions;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;
import com.ibm.mq.constants.CMQC;


public class ClsConnectionMQ {
	
	
	/// <summary>
    /// Name of the host on which Queue manager is running 
    /// </summary>
    private String hostName = "localhost";
    /// <summary>
    /// Port number on which Queue manager is listening
    /// </summary>
    private int port = 1414;
    /// <summary>
    /// Name of the channel
    /// </summary>
    private String channelName = "SYSTEM.DEF.SVRCONN";
    /// <summary>
    /// Name of the Queue manager to connect to
    /// </summary>
    private String queueManagerName = null;
    /// <summary>
    /// Queue name in.
    /// </summary>
    private String queueNameIn = null;
    /// <summary>
    /// Queue name Out.
    /// </summary>
    private String queueNameOut = null;
    /// <summary>
	
	
	static String FILE_PROPERTIES = "properties/configurationMQ.properties";
	
	Logger logger = Logger.getLogger("AFILIACION");
	
	public ClsConnectionMQ() {
		
		// TODO Auto-generated constructor stub
			
		try {
			
			//init environment
			Properties prop = loadFileMQConfig();
			
			queueManagerName =(prop.getProperty("propiedad.MQ.QueueManager").trim());
			queueNameIn = (prop.getProperty("propiedad.MQ.queueIn").trim());
			queueNameOut =(prop.getProperty("propiedad.MQ.queueOut").trim());
			channelName =(prop.getProperty("propiedad.MQ.channel").trim());
			hostName = (prop.getProperty("propiedad.MQ.hostName").trim());
			port =Integer.parseInt(prop.getProperty("propiedad.MQ.port").trim());
			//String User = (prop.getProperty("propiedad.MQ.user").trim());
			//String Password =(prop.getProperty("propiedad.MQ.password").trim());
			
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
				
			
			 // mq properties			
			//MQEnvironment.channel = ChannelServer;
			//MQEnvironment.hostname = Hostname;
			//MQEnvironment.sslCipherSuite ="SSL_RSA_WITH_AES_256_CBC_SHA256";
			//MQEnvironment.sslCertStores
			//MQEnvironment.sslPeerName = "CN=IAFAS";
			//MQEnvironment.port = Port;
			//MQEnvironment.userID = User;
			//MQEnvironment.password =Password;
			//MQEnvironment.properties.put(TRANSPORT_PROPERTY, CMQC.TRANSPORT_MQSERIES_CLIENT);				
			//MQEnvironment.properties.put(CMQC.APPNAME_PROPERTY, "AFILIACION ONLINE");
			
			props = new Hashtable<String,Object>();				
			props.put(CMQC.CHANNEL_PROPERTY, channelName);
			props.put(CMQC.PORT_PROPERTY, port);
			props.put(CMQC.HOST_NAME_PROPERTY, hostName);
			props.put(CMQC.APPNAME_PROPERTY, "Aplicacion Afiliacion Online JAVA, SUSALUD V1.0");
			props.put(CMQC.TRANSPORT_PROPERTY, CMQC.TRANSPORT_MQSERIES_CLIENT);
			
			
			// display all details
            logger.debug("MQ Parameters");
            logger.info("1) queueNameIn = " + queueNameIn);
            logger.info("2) queueNameOut = " + queueNameOut);
            logger.info("3) host = " + hostName);
            logger.info("4) port = " + port);
            logger.info("5) channel = " + channelName);
            logger.info("");
			
            // create connection
            logger.info("Connecting to queue manager.. ");
            queueManager = new MQQueueManager(queueManagerName,props);
			logger.info("done");			
			
			// accessing queue for both putting message
			logger.info("Accessing queue " + queueNameIn + ".. ");            
			queueIn = queueManager.accessQueue(queueNameIn,  CMQC.MQOO_OUTPUT | CMQC.MQOO_FAIL_IF_QUIESCING);			
			logger.info("done");
			
			// creating a message to put
            // the message is related to a afiliacion
            // the message properties gives info about the afiliados availability,
            // price, author, number of pages, title etc
			putMsg = new MQMessage();
			putMsg.characterSet=819;//MQC.MQCCSI_Q_MGR;
			putMsg.encoding= 273;
			putMsg.format = CMQC.MQFMT_STRING;	
			//putMsg.write(messageString.getBytes());
			putMsg.writeString(messageString);
			
			 // message Properties MQ RFH2
            /*putMsg.setBooleanProperty("available", true);        // availability of the book
            putMsg.setByteProperty("rack", (byte) 6);                   // rack number
            putMsg.setDoubleProperty("price", 2837.50);          // price or cost of the book
            putMsg.setFloatProperty("weight", 472.61F);          // weight of the book in gms    
            putMsg.setShortProperty("chapters", (short) 22);             // number of chapters in the book
            putMsg.setIntProperty("year", 1987);                 // year of publication                
            putMsg.setLongProperty("pages", 3827);               // number of pages in the book
            Object shipping = "free shipping";
            putMsg.setObjectProperty("shipping", shipping);      // shipping type              
            putMsg.setStringProperty("language", "english");     // language of the book
            putMsg.setStringProperty("title", "philosophy");     // title of the book
            putMsg.setStringProperty("author", "isaac newton");  // author of the book
            putMsg.setStringProperty("publisher", "new lights"); // publisher of the book
			*/
			// Specify the default put message options
			//MQPutMessageOptions pmo = new MQPutMessageOptions();
			
            // putting a message
            logger.info("Message [" + messageString + "]");
            
            logger.info("put");
			queueIn.put(putMsg);
			logger.info("done");
			
			// accessing queue for both getting message
			logger.info("Accessing queue " + queueNameOut + ".. ");
			queueOut = queueManager.accessQueue(queueNameOut, CMQC.MQOO_INPUT_AS_Q_DEF | CMQC.MQOO_FAIL_IF_QUIESCING);
			logger.info("done");
			
			// Now get the message back again. First define a WebSphere MQ
			// message
			// to receive the data
			// creating a message to get
			getMsg = new MQMessage();
			getMsg.characterSet=819;//MQC.MQCCSI_Q_MGR;
			getMsg.encoding= 273;
			getMsg.messageId = putMsg.messageId;		
			
			
			// Specify default get message options
			getMessageOptions= new MQGetMessageOptions();
			getMessageOptions.matchOptions = CMQC.MQMO_MATCH_MSG_ID;
			getMessageOptions.options = CMQC.MQGMO_WAIT;
			getMessageOptions.waitInterval = 1000;
			
			logger.info("get");
			
			int isContinuar = 0;
			int numReIntentos =1; 
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
			
			logger.info("done");

			if (getMsg.getDataLength()>0) {
				
				// And display the message text...
				logger.info("ready message get");
				String tramaXML = getMsg.readStringOfByteLength(getMsg.getDataLength());
				logger.info("Message got: " + tramaXML);
				String msgid = new String(Hex.encodeHex(getMsg.messageId));
				logger.info("Msg Id: "+msgid);
				logger.info("done");
				
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
				logger.info("Clear message put");
				putMsg.clearMessage();
			}
			
			if (getMsg!=null) {
				logger.info("Clear message get");
				getMsg.clearMessage();
			}
			
			// Close the queues
	    	if (queueIn!=null) {	    		
		    	logger.info("Closing the queueIn");
	    		queueIn.close();
			}
			
	    	if (queueOut!=null) {
	    		logger.info("Closing the queueOut");
	    		queueOut.close();
	    	}
			
	    	// Disconnect from the QueueManager
			if (queueManager!=null) {
				
				logger.info("Disconnecting from the Queue Manager");
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
