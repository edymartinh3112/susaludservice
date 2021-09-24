package pe.com.susalud.afiliacion.trama;


import javax.swing.SwingWorker;


/**
 * Procesar trama 271 en background
 * @author user1
 *
 */
public class Afiliacion271Worker extends SwingWorker<Trama271Bean, String> {
	
	String trama = "";
	
	public Afiliacion271Worker(String trama) {
		this.trama = trama;

	}
	
	@Override
	protected Trama271Bean doInBackground() throws Exception {

		return AfiliacionUtil.procesarTramaX12(trama);
	}
}
