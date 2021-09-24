/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.susalud.afiliacion.util;

//import CapaDatos.clsDatos;
//import CapaEntidad.AfiliacionDataDet;
//import CapaEntidad.Constante;
//import CapaNegocio.clsNegocio;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import pe.com.susalud.afiliacion.business.clsNegocio;
import pe.com.susalud.afiliacion.entidad.bean.AfiliacionDataDet;
import pe.com.susalud.afiliacion.entidad.bean.Constante;

/**
 *
 * @author udesarrollo2
 */
public class PruebaGenerarTramaTXT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        String result = "0";
        clsNegocio clsn = new clsNegocio();
        ArrayList<AfiliacionDataDet> contenido = new ArrayList<AfiliacionDataDet>();
        //ArrayList<AfiliacionDataDet> info = clsn.ListarTrama();
        
        
        contenido = clsn.ListarTrama(Constante.codigoEnvioSusalud);
        //datos nombre
        String codiIafa = "30004";
        FeTransaccion fecha = new FeTransaccion();
        String fechaEnvio = fecha.getFeTransaccion();
        String cantidad = null;
        String nombreArchivo = codiIafa + "_" + fechaEnvio + "_" + contenido.size() + ".txt";;
        JFileChooser file = new JFileChooser();
        
        // Construye archivo
        file.setName(nombreArchivo);
        creaArchivo setArchivo = new creaArchivo();
        file.setSelectedFile(new File(nombreArchivo));
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos txt", "txt", "TXT");
        file.setFileFilter(filtro);
        int seleccion = file.showSaveDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File guarda = file.getSelectedFile();
            nombreArchivo = guarda.toString();
            
            try {
                        setArchivo.creaArchivo(nombreArchivo, contenido);
                        result = "1";
                        try {
                            String rutaP = "C:\\Windows\\notepad.exe";
                            ProcessBuilder p = new ProcessBuilder();
                            p.command(rutaP, nombreArchivo);
                            p.start();
                        } catch (IOException ex) {
                            //Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                            ex.printStackTrace();
                        }
                } catch (Exception e) {
                    System.out.println("Error Crear Trama ");
                    JOptionPane.showMessageDialog(null, "Error Crear Trama " + e.getMessage());
                }
        }
    }
    
}
