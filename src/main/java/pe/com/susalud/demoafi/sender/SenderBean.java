package pe.com.susalud.demoafi.sender;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pe.com.susalud.demoafl.AfiliacionUtil;
import pe.com.susalud.demoafl.Trama997Bean;

public class SenderBean {

	private static final Logger LOGGER = LogManager.getLogger(SenderBean.class);

	public Trama997Bean enviar(final String trama) {
		Trama997Bean response = null;
		try {
			
			ExecutorService executorService = Executors.newFixedThreadPool(10);

			Runnable command = new Runnable() {
				@Override
				public void run() {
					try {
						AfiliacionUtil.procesarTrama997(trama);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};

			Future<Trama997Bean> future = (Future<Trama997Bean>) executorService.submit(command);
			Trama997Bean responseMq = future.get();
			

		} catch (Exception ex) {
			LOGGER.error(ex);
		}
		return response;
	}

}
