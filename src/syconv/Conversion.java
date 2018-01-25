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
    private int caso;
    private Operando numeroConvertir;
    private Operando resultadoConversion;
    
    public Conversion(Operando numeroConvertir, Operando resultadoConversion){
        this.caso = 0;
        this.numeroConvertir = numeroConvertir;
        this.resultadoConversion = resultadoConversion;
    }
    /*GETTERS Y SETTERS*/
    public int getCaso() {
        return caso;
    }

    public void setCaso(int caso) {
        this.caso = caso;
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
        
    /*FUNCION PRINCIPAL QUE CONTROLA EL FLUJO DE LA CONVERSION*/
    public String convertir(){        
        this.caso = casoConversion(this.numeroConvertir.getBase(), this.resultadoConversion.getBase());
        switch(this.caso){
            case 1: this.resultadoConversion.setValor(base10_CualquierBase()); break;
            case 2: this.resultadoConversion.setValor(cualquierBase_Base10()); break;
            case 3: this.resultadoConversion.setValor(cualquierBase_CualquierBase()); break;
            case 4: this.resultadoConversion.setValor(this.numeroConvertir.getValor());
        }
        
        return this.resultadoConversion.getValor();
    }
    /*DETECTA EL CASO DE CONVERSION QUE SE PRESENTA*/
    public int casoConversion(int baseInicial, int baseFinal){
        int caso = 4; //SI LAS BASES SON IGUALES
        if((baseInicial == 10) && (baseFinal != 10)){
            caso = 1; // DE BASE 10 A CUALQUIER OTRA
        }else{
            if((baseInicial != 10) && (baseFinal == 10)){
                caso = 2; // DE CUALQUIERA A BASE 10
            }else{
                if((baseInicial != 10) && (baseFinal != 10)){
                    caso = 3;// DE CUALQUIERA A CUALQUIERA
                }
            }
        }
        return caso;
    }
    /*METODO QUE REALIZA LA CONVERSION DE BASE 10 A CUALQUIER BASE SOPORTADA*/
    public String base10_CualquierBase(){
        int numero = Integer.parseInt(this.numeroConvertir.getValor());
        ArrayList resultadoTemp = new ArrayList();
        ArrayList cifras = new ArrayList();
        
        /*for(int i = 0; i < numeroConvertir.length(); i++){
            this.numeroConvertir.add(numeroConvertir.charAt(i));
        }*/
        return null;
    }
    /*METODO QUE REALIZA LA CONVERSION DE CUALQUIER BASE SOPORTADA A BASE 10 */
    public String cualquierBase_Base10(){
        return null;
    }
    /*METODO QUE REALIZA LA CONVERSION DE CUALQUIER BASE SOPORTADA A OTRA BASE SOPORTADA QUE NO SEA 10*/
    public String cualquierBase_CualquierBase(){
        return null;
    }   
}
