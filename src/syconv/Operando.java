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
    private boolean racional;
    private int posicionPunto;
    
    public Operando(String valor, int base){
        this.valor = valor;
        this.base = base;
        this.sistema = new SistemaNumerico(base);
        this.posicionPunto = valor.indexOf('.');
        this.racional = (this.posicionPunto != -1);
        
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

    public boolean isRacional() {
        return racional;
    }

    public void setRacional(boolean racional) {
        this.racional = racional;
    }

    public int getPosicionPunto() {
        return posicionPunto;
    }

    public void setPosicionPunto(int posicionPunto) {
        this.posicionPunto = posicionPunto;
    }
    
    
    /*FUNCION QUE FABRICA EL NUMERO A PARTIR DE LAS CIFRAS MANDADAS COMO PARAMETRO Y EL SISTEMA CORRESPONDIENTE*/
    public String fabricarNumero(ArrayList cifraTemporal, SistemaNumerico sistema){
        String numeroFabricado = "";
        int tam = cifraTemporal.size();        
        ArrayList resultadoTemporal = new ArrayList();        
        for(int i = 0; i < tam; i++){ resultadoTemporal.add(null); }
        
        if(this.racional){// tiene parte entera y fraccionaria &&
            /*le da la vuelta al array partiendo desde la posicion del punto para que los valores de las cifras esten en la posicion correcta*/            
            int i = this.posicionPunto, j = this.posicionPunto;
            boolean completado = false;
            while(completado){                
                if(i > 0){ resultadoTemporal.add(cifraTemporal.get(--i)); }
                if(j < tam){ resultadoTemporal.add(cifraTemporal.get(j++)); }
                if(i == 0 && j == tam) completado = true;                
            }
            
            String digito = null;
            for(i = 0; i < tam; i++){ 
                digito = (String)resultadoTemporal.get(i);
                if(digito == "."){
                    numeroFabricado = numeroFabricado + sistema.getDigitos();                
                } 
                
            }
        }else{ // tiene solo parte entera
            /*le da la vuelta al array para que los valores de las cifras esten en la posicion correcta*/
            for(int i = tam; i >= 0; i--){
                resultadoTemporal.add(cifraTemporal.get(i));                                         
            }
            /*crea la cadena de texto con las cifras de la parte decimal aplicando los digitos del sistema correspondiente*/
            for(int i = 0; i < tam; i++){            
                numeroFabricado = numeroFabricado + sistema.getDigitos().get((int)resultadoTemporal.get(i));
            }
        }
        
        
        /*crea la cadena de texto con las cifras de la parte decimal aplicando los digitos del sistema correspondiente*/
        
        return numeroFabricado;
    }
    
    /*FUNCION QUE DEVUELVE LA PARTE ENTERA DEL NUMERO PASADO COMO PARAMETRO
      SI EL NUMERO PASADO COMO PARAMETRO ES ENTERO ENTONCES SO DEBUELVE;
    */
    public String obtenerEnteros(String numero){
        int punto = numero.indexOf('.');
        if(punto == -1){ return numero; }        
        return numero.substring(0, punto);
    }
    
    /*FUNCION QUE DEVUELVE LA PARTE DECIMAL DEL NUMERO PASADO COMO PARAMETRO*/
    public String obtenerDecimales(String numero){        
        int punto = numero.indexOf('.');
        if(punto == -1){ return "00"; }
        return numero.substring(punto+1);
    }    
}
