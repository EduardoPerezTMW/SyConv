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
            case 1: base10_CualquierBase(); break;
            case 2: cualquierBase_Base10(); break;
            case 3: cualquierBase_CualquierBase(); break;
            case 4: this.numeroConvertir.getValor();
        }
        
        return this.resultadoConversion.getValor();
    }
    /*DETECTA EL CASO DE CONVERSION QUE SE PRESENTA*/
    public int casoConversion(int baseInicial, int baseFinal){
        int caso = 4; //si las bases son iguales
        if((baseInicial == 10) && (baseFinal != 10)){
            caso = 1; // de base 10 a cualquier otra
        }else{
            if((baseInicial != 10) && (baseFinal == 10)){
                caso = 2; // de cualquiera a base 10
            }else{
                if((baseInicial != 10) && (baseFinal != 10)){
                    caso = 3;// de cualquiera a cualquiera
                }
            }
        }
        return caso;
    }
    /*METODO QUE REALIZA LA CONVERSION DE BASE 10 A CUALQUIER BASE SOPORTADA*/
    public void base10_CualquierBase(){                        
        ArrayList cifraTemporal = new ArrayList();
        int dividendo = Integer.parseInt(this.numeroConvertir.getValor());                
        int divisor = this.resultadoConversion.getBase();
        int residuo = dividendo;
        int cociente = divisor;        
        /*calcula las cifras del resualtado*/
        while(cociente != 0){
            residuo = dividendo % divisor;
            cociente = dividendo / divisor;            
            cifraTemporal.add(residuo);
            dividendo = cociente;            
        }        
        /*crea el numero como tal y lo asigna como valor al resualtado final*/
        String resultadoTemporal = resultadoConversion.fabricarNumero(cifraTemporal, resultadoConversion.getSistema());
        resultadoConversion.setValor(resultadoTemporal);         
    }
    /*METODO QUE REALIZA LA CONVERSION DE CUALQUIER BASE SOPORTADA A BASE 10 */
    public void cualquierBase_Base10(){        
    }
    /*METODO QUE REALIZA LA CONVERSION DE CUALQUIER BASE SOPORTADA A OTRA BASE SOPORTADA QUE NO SEA 10*/
    public void cualquierBase_CualquierBase(){ 
    }   
}
