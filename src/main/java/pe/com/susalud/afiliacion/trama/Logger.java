/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.susalud.afiliacion.trama;

/**
 *
 * @author fhuancco
 */
public class Logger {

    public Logger() {
    }
    
    public void info(String a ){
        System.out.println("info:"+a);
        
    }
 public void debug(String a ){
        System.out.println("debug:"+a);
        
    }    
 
 public void error(String a ,Exception e){
        System.out.println(a +" "+e);
        
    }    
 
    
}
