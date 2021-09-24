package pe.com.susalud.afiliacion.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author edextre
 */
public class creaArchivo {

    public void creaArchivo(String archivo, ArrayList cadena) {

        //File outFile = new File("D:\\Registro\\salida.txt");
        File outFile = new File(archivo);
        int i = 0;
        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outFile))) {
                for (i = 0; i < cadena.size(); i++) {
                    writer.write(cadena.get(i).toString());
                    //System.out.println(cadena.get(i).toString());
                    writer.newLine();
                }
            }
            System.out.println("Archivo Generado");
            System.out.println(outFile);

        } catch (Exception e) {
            System.out.println("Archivo No Grabado");
            JOptionPane.showMessageDialog( null, "Error General Crear Archivo: " + e.getMessage());
        }
    }

    /**
     *
     * @param archivo
     * @param cadena
     */
    
}
