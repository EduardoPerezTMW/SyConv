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
    private int baseOperacion;
    
    public Operacion(ArrayList<Operando> operandos, char signoOperacion, int baseOperacion){        
        /*for(Operando o : operandos){
            this.agregarOperandos(o);
        }    */
        this.operandos = operandos;
        this.signoOperacion = signoOperacion;
        this.baseOperacion = baseOperacion;               
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
        double op1, op2, r;
        Operando a = this.operandos.get(0), b = this.operandos.get(1), opaux = null;                        
        
        if(this.operandos.get(0).getBase() != 10){
            a = this.convertirOperando(this.operandos.get(0), 10);
        }                
        if(this.operandos.get(1).getBase() != 10){
            b = this.convertirOperando(this.operandos.get(1), 10);
        }                
        
        op1 = Double.parseDouble(a.getValor());
        op2 = Double.parseDouble(b.getValor());
        r = op1 + op2;        
        
        if(this.operandos.get(0).isRacional() || this.operandos.get(1).isRacional()){                                                
            opaux = new Operando(String.valueOf(r), 10);            
        }else{
            opaux = new Operando(String.valueOf((int)r), 10);                    
        }
        
        this.resultadoOperacion = convertirOperando(opaux, this.baseOperacion);
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
    
    public Operando convertirOperando(Operando original, int base){
        Conversion conversion = new Conversion(original, new Operando("", base));                
        
        return conversion.convertir2();        
    }
}
