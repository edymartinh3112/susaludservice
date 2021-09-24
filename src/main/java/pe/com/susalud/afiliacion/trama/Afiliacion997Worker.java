package pe.com.susalud.afiliacion.trama;



import javax.swing.SwingWorker;



/**
 * Procesar trama 997 en background
 * @author user1
 *
 */
public class Afiliacion997Worker extends SwingWorker<Trama997Bean, String>{
	private String trama;
	
	public Afiliacion997Worker(String trama) {
		this.trama = trama;
	}
	
	@Override
	protected Trama997Bean doInBackground() throws Exception {

		return AfiliacionUtil.procesarTrama997(trama);
	}
}
