/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syconv;

import java.util.ArrayList;
import ventanas.Inicio;

/**
 *
 * @author Daniel
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conversion conversion = new Conversion();
        Operacion operacion;
        Operando operando1;
        Operando operando2;
        ArrayList<String> datosConversion;
        
        datosConversion = new ArrayList<String>();
        datosConversion.add("-3");
        datosConversion.add("4");
        datosConversion.add("5");
        datosConversion.add("8");
        
        System.out.println(java.lang.Integer.parseInt(datosConversion.get(0)) + java.lang.Integer.parseInt(datosConversion.get(1)));
        
        
    }
    
}
