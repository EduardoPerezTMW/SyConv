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
        Operando operando1 = new Operando("34485.0172", 12);
        //Operando operando1 = new Operando("34485", 12);
        Operando operando2  = new Operando("", 10);
        Conversion conversion = new Conversion(operando1, operando2);
        Operacion operacion; 
        String resultado = conversion.convertir();
        System.out.println(resultado);       
    
    }
}
