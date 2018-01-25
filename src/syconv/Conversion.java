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
public class Conversion {
    private int tipo;
    private Operando numeroConvertir;
    private Operando resultadoConversion;
    
    public Conversion(Operando numeroConvertir, Operando resultadoConversion){
        this.tipo = 0;
        this.numeroConvertir = numeroConvertir;
        this.resultadoConversion = resultadoConversion;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Operando getNumeroConvertir() {
        return numeroConvertir;
    }

    public void setNumeroConvertir(Operando numeroConvertir) {
        this.numeroConvertir = numeroConvertir;
    }

    public Operando getResultadoConversion() {
        return resultadoConversion;
    }

    public void setResultadoConversion(Operando resultadoConversion) {
        this.resultadoConversion = resultadoConversion;
    }
    
    
    
    public String convertir(){        
        this.tipo = validarTipoConversion(this.numeroConvertir.getBase(), this.resultadoConversion.getBase());
        switch(this.tipo){
            case 1: this.resultadoConversion.setValor(base10_CualquierBase()); break;
            case 2: this.resultadoConversion.setValor(cualquierBase_Base10()); break;
            case 3: this.resultadoConversion.setValor(cualquierBase_CualquierBase()); break;
            case 4: this.resultadoConversion.setValor(this.numeroConvertir.getValor());
        }
        
        return this.resultadoConversion.getValor();
    }
    
    public int validarTipoConversion(int baseInicial, int baseFinal){
        int tipo = 4;
        if((baseInicial == 10) && (baseFinal != 10)){
            tipo = 1;
        }else{
            if((baseInicial != 10) && (baseFinal == 10)){
                tipo = 2;
            }else{
                if((baseInicial != 10) && (baseFinal != 10)){
                    tipo = 3;
                }
            }
        }
        return tipo;
    }
    
    public String base10_CualquierBase(){
        int numero = Integer.parseInt(this.numeroConvertir.getValor());
        ArrayList resultadoTemp = new ArrayList();
        ArrayList cifras = new ArrayList();
        
        /*for(int i = 0; i < numeroConvertir.length(); i++){
            this.numeroConvertir.add(numeroConvertir.charAt(i));
        }*/
        return null;
    }
    
    public String cualquierBase_Base10(){
        return null;
    }
    
    public String cualquierBase_CualquierBase(){
        return null;
    }   
}
