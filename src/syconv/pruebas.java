/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syconv;

import java.text.DecimalFormat;
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
        Operando operando1 = new Operando("24568.2534", 10);
        Operando operando2  = new Operando("", 16);
        Conversion conversion = new Conversion(operando1, operando2);
        Operacion operacion;        
        //conversion.convertir();
        //System.out.println(operando2.getValor());        
        String enteros, decimales; 
        enteros = operando1.obtenerEnteros(operando1.getValor());
        decimales = operando1.obtenerDecimales(operando1.getValor());
        System.out.println(enteros + " . " + decimales); 
        
        double x = 0.14;
        int tam = 10;
        System.out.println((int)x); 
        System.out.println(x - (double)((int)x)); 
        ArrayList datosConversion = new ArrayList();
        for(int i = 0; i < tam; i++){
            datosConversion.add(null);
        }
        char cadena[] = new char[tam];
        
        for(int i = 10-1; i >= 0; i--){
            datosConversion.set(i, i+1);
        }
        
        for(int i = 0; i < 10; i++){
            System.out.println(datosConversion.get(i));
        }
        /*ArrayList<String> datosConversion;
        Integer prueba = new Integer(numeroInt);
        datosConversion = new ArrayList<String>();
        datosConversion.add("-3");
        datosConversion.add("4");
        datosConversion.add("5");
        datosConversion.add("8");
        
        String numero = "";
               
        String numeroTemp = operando1.getValor();
        
        for(int i = 0; i < numeroTemp.length(); i++){
            numero = numero + numeroTemp.charAt(i);
        }
        
        SistemaNumerico sistemaInicial = new SistemaNumerico(operando1.getBase());
        SistemaNumerico sistemaFinal = new SistemaNumerico(operando2.getBase());
        
        
        System.out.println(" " + operando1.getBase()
                           + " " + operando2.getBase() 
                           + " " + numero 
                           + " " + sistemaInicial.getDigitos().toString()
                           + " " + sistemaFinal.getDigitos().toString()
                           + " " + sistemaInicial.getValores().toString()
                           + " " + sistemaFinal.getValores().toString()                    
                           );*/
    }
    
}
