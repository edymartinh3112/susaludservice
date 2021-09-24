/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.susalud.afiliacion.dao;

import pe.com.susalud.afiliacion.entidad.bean.Tramax;

//import CapaEntidad.Tramax;

/**
 *
 * @author btorres
 */
public class conectar {

    public static void main(String arg[]){

        clsDatos datos = new clsDatos();

        System.out.print("------------------------------------------");

        for(Tramax a: datos.ListarRespuestaTrama("")){

            System.out.println(""+a.getC_c_afi());

        }
    }
}
