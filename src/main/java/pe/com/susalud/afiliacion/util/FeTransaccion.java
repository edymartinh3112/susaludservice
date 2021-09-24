/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.susalud.afiliacion.util;

import java.util.Calendar;

/**
 *
 * @author udesarrollo2
 */
public class FeTransaccion {
    
    private final int anio;
    private final int mes;
    private final int dia;
    private final String feTransaccion;

    public FeTransaccion() {
        Calendar fecha = Calendar.getInstance();

        anio = fecha.get(Calendar.YEAR);
        mes = fecha.get(Calendar.MONTH) + 1;
        dia = fecha.get(Calendar.DAY_OF_MONTH);
        String patron = "%04d%02d%02d";

        feTransaccion = String.format(patron, anio, mes, dia);
    }

    public String getFeTransaccion() {
        return feTransaccion;
    }

    public int getAnio() {
        return anio;
    }

    public int getMes() {
        return mes;
    }

    public int getdia() {
        return dia;
    }
}
