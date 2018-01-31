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
        Operando operando1 = new Operando("1", 10);
        Operando operando2 = new Operando("1", 10);
        Operando operando3  = new Operando("", 10);
        Conversion conversion = new Conversion(operando2, operando3);
        ArrayList<Operando> operandos = new ArrayList<Operando>();
        operandos.add(operando1);operandos.add(operando2);
        Operacion operacion = new Operacion(operandos, '+', 10); 
        //String resultado = conversion.convertir();
        //System.out.println(resultado);       
        
        System.out.println(operacion.Operar());
        
    
    }
}
