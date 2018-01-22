/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syconv;

/**
 *
 * @author Daniel
 */
public class Operacion {
    private Operando operando1;
    private Operando operando2;
    private String signoOperacion;
    private String resultadoOperacion;
    
    public Operacion(){
    }
    
    public Operacion(Operando operando1, Operando operando2, String signo){
        setOperando1(operando1);
        setOperando2(operando2);
        setSignoOperacion(signo);
    }

    public Operando getOperando1() {
        return operando1;
    }

    public void setOperando1(Operando operando1) {
        this.operando1 = operando1;
    }

    public Operando getOperando2() {
        return operando2;
    }

    public void setOperando2(Operando operando2) {
        this.operando2 = operando2;
    }

    public String getSignoOperacion() {
        return signoOperacion;
    }

    public void setSignoOperacion(String signoOperacion) {
        this.signoOperacion = signoOperacion;
    }

    public String getResultadoOperacion() {
        return resultadoOperacion;
    }

    public void setResultadoOperacion(String resultadoOperacion) {
        this.resultadoOperacion = resultadoOperacion;
    }
    
    
    
}
