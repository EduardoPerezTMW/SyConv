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
        Operando operando1 = new Operando("2158.23158546845", 5);
        Operando operando2 = new Operando("2", 10);
        Operando operando3  = new Operando("", 10);
        Conversion conversion = new Conversion(new Operando("B1", 16), new Operando("", 2));
        ArrayList<Operando> operandos = new ArrayList<Operando>();
        operandos.add(operando1);operandos.add(operando2);
        Operacion operacion = new Operacion(operandos, '+', 10); 
        //conversion.convertir();
        //System.out.println(conversion.getResultadoConversion().getValor());       
        //operacion.Operar();
        //System.out.println(operacion.getResultadoOperacion().getValor());       
        
        
        double prueba = Double.parseDouble("-" + operando1.getValor());
        System.out.println(operando1.isNegativo() + " " + operando1.getValor() + prueba);
        double a,b,c;
        a = 0; b = 1.254;
        c = a-b;
        System.out.println(String.valueOf(c));
    }
}
