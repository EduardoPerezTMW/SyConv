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
        this.posicionPunto = valor.indexOf(".");
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
        int tam = cifraTemporal.size();        
        String numeroFabricado = "";
        ArrayList<String> resultadoTemporal = new ArrayList<String>();        
        for(int x = 0; x < tam; x++){ resultadoTemporal.add("O"); }
        int i = this.posicionPunto, j = this.posicionPunto, posi = 0, posj = j;
        
        if(this.racional){// tiene parte entera y fraccionaria &&
            /*le da la vuelta al array partiendo desde la posicion del punto para que los valores de las cifras esten en la posicion correcta*/
            boolean completado = false;
            while(!completado){                
                if(i > 0){ resultadoTemporal.set(posi++, String.valueOf(cifraTemporal.get(--i))); }
                if(j < tam){ resultadoTemporal.set(posj++, String.valueOf(cifraTemporal.get(j++))); }
                if(i == 0 && j == tam) completado = true;                
            }  
        }else{ // tiene solo parte entera
            /*le da la vuelta al array para que los valores de las cifras esten en la posicion correcta*/
            posi = 0; i = tam;
            while(i > 0){
                resultadoTemporal.set(posi++, String.valueOf(cifraTemporal.get(--i)));//--i                                         
            }
        }
        //i = 0;//PARA ASEGURARME LOL        
        /*crea la cadena de texto con del numero con las cifras de la parte decimal(si tiene) aplicando los digitos del sistema correspondiente*/
        while(i < tam){
            if(i == this.posicionPunto){ numeroFabricado = numeroFabricado + '.'; i++; }
            posi = Integer.parseInt(resultadoTemporal.get(i));
            numeroFabricado = numeroFabricado + sistema.getDigitos().get(posi);
            i++;
        } 
        
        return numeroFabricado;
    }
    
    /* FUNCION QUE DEVUELVE LA PARTE ENTERA DEL NUMERO PASADO COMO PARAMETRO
       SI EL NUMERO PASADO COMO PARAMETRO ES ENTERO ENTONCES SO DEBUELVE;
    */
    public String obtenerEnteros(String numero){
        int punto = numero.indexOf(".");
        if(punto == -1){ return numero; }        
        return numero.substring(0, punto);
    }
    
    /*FUNCION QUE DEVUELVE LA PARTE DECIMAL DEL NUMERO PASADO COMO PARAMETRO*/
    public String obtenerDecimales(String numero){        
        int punto = numero.indexOf(".");
        if(punto == -1){ return "00"; }
        return numero.substring(punto+1);
    }    
}
