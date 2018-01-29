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
    private ArrayList<Operando> operandos; //tienen que ser operando1, operando2, resualtado(este ultimo por ahorita no)
    private char signoOperacion;    
    private Operando resultadoOperacion;
    
    public Operacion(ArrayList<Operando> operandos, char signoOperacion, Operando resultadoOperacion){        
        for(Operando o : operandos){
            this.agregarOperandos(o);
        }        
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
    
    /*METODO QUE AGREGA LOS VALORES QUE SE VAN A OPERAR*/
    public void agregarOperandos(Operando operando){                
        this.operandos.add(operando);
    }
    
    /*FUNCION QUE VERIFICA EL TIPO DE OPERACION Y LA REALIZA*/
    public String Operar(){
        
        switch(this.signoOperacion){
            case '+': this.realizarSuma(); break;
            case '-': this.realizarResta(); break;
            case '*': this.realizarMultiplicacion(); break;
            case '/': this.realizarDivision(); break;
        }
        
        return this.resultadoOperacion.getValor();
    }
    /*OPERACION QUE REALIZA LA SUMA DE LOS NUMEROS*/
    public void realizarSuma(){
    }
    /*OPERACION QUE REALIZA LA RESTA DE LOS NUMEROS*/
    public void realizarResta(){
    }
    /*OPERACION QUE REALIZA LA MULTIPLICACION DE LOS NUMEROS*/
    public void realizarMultiplicacion(){
    }
    /*OPERACION QUE REALIZA LA DIVISION DE LOS NUMEROS*/
    public void realizarDivision(){
    }
}
