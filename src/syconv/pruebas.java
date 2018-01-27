/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syconv;

import static java.lang.System.gc;
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
        //Operando operando1 = new Operando("24568", 10);
        Operando operando2  = new Operando("", 2);
        Conversion conversion = new Conversion(operando1, operando2);
        Operacion operacion;        
        //operando2.setRacional(true);
        //conversion.convertir();
        //System.out.println(operando2.getValor());        
        String enteros, decimales; 
        enteros = operando1.obtenerEnteros(operando1.getValor());
        decimales = operando1.obtenerDecimales(operando1.getValor());
        System.out.println(enteros + "." + decimales); 
        
        
        String resultado = conversion.convertir();
        System.out.println(resultado);
        //System.out.println((int)x);         
        /*
        int tam = 9;        
        String numeroFabricado[] = new String[tam];
        ArrayList resultadoTemporal = new ArrayList();        
        for(int i = 0; i < tam; i++){ resultadoTemporal.add(null); numeroFabricado[i] = "O";}        
        for(int i = 0; i < tam; i++){ System.out.print(numeroFabricado[i]); }*/
        //numeroFabricado.replace(numeroFabricado.charAt(4), '.');
        //numeroFabricado[4] = ".";
        
        //System.out.println(numeroFabricado[4]);
        /*System.out.println(numeroFabricado.charAt(0)); 
        System.out.println(resultadoTemporal.size());*/
        
        
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
