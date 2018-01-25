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
public class Operando {
    private String valor;
    private int base;
    private SistemaNumerico sistema;
    
    public Operando(String valor, int base){
        this.valor = valor;
        this.base = base;
        this.sistema = new SistemaNumerico(base);
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public SistemaNumerico getSistema() {
        return sistema;
    }

    public void setSistema(SistemaNumerico sistema) {
        this.sistema = sistema;
    }
    
    /*FUNCION QUE FABRICA EL NUMERO A PARTIR DE LAS CIFRAS MANDADAS COMO PARAMETRO Y EL SISTEMA CORRESPONDIENTE*/
    public String fabricarNumero(ArrayList cifraTemporal, SistemaNumerico sistema){
        String numeroFabricado = "";
        int tam = cifraTemporal.size();
        ArrayList resultadoTemporal = new ArrayList();                         
        /*le da la vuelta al array para que los valores de las cifras esten en la posicion correcta*/
        for(int i = tam-1; i >= 0; i--){
            resultadoTemporal.add(cifraTemporal.get(i));                         
        }
        /*crea la cadena de texto con las cifras del numero aplicando los digitos del sistema correspondiente*/
        for(int i = 0; i < tam; i++){            
            numeroFabricado = numeroFabricado + sistema.getDigitos().get((int)resultadoTemporal.get(i));
        }
        
        return numeroFabricado;
    }
    
    
        
}
