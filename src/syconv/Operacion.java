/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syconv;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Operacion {
    private ArrayList<Operando> operandos; //tienen que ser operando1, operando2, resualtado
    private char signoOperacion;    
    private Operando resultadoOperacion;
    
    public Operacion(Operando operando1, Operando operando2, char signoOperacion, Operando resultadoOperacion){
        this.operandos = new ArrayList<Operando>();
        this.signoOperacion = signoOperacion;
        this.resultadoOperacion = resultadoOperacion;        
    }

    public ArrayList<Operando> getOperandos() {
        return operandos;
    }

    public void setOperandos(ArrayList<Operando> operandos) {
        this.operandos = operandos;
    }

    public char getSignoOperacion() {
        return signoOperacion;
    }

    public void setSignoOperacion(char signoOperacion) {
        this.signoOperacion = signoOperacion;
    }

    public Operando getResultadoOperacion() {
        return resultadoOperacion;
    }

    public void setResultadoOperacion(Operando resultadoOperacion) {
        this.resultadoOperacion = resultadoOperacion;
    }
    
    
    
}
