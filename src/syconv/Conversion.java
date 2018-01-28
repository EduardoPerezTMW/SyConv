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
            case 4: return this.numeroConvertir.getValor();  
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
        String numeroDec = this.numeroConvertir.obtenerDecimales();
        ArrayList cifraTemporal = new ArrayList();                
        int dividendo = Integer.parseInt(this.numeroConvertir.obtenerEnteros());                
        int divisor = this.resultadoConversion.getBase(); 
        int residuo = dividendo;
        int cociente = divisor;                
        /*calcula las cifras enteras del resualtado*/
        while(cociente != 0){
            residuo = dividendo % divisor;
            cociente = dividendo / divisor;             
            cifraTemporal.add(residuo);
            dividendo = cociente;            
        }            
        /*calcula las cifras decimales del resutado y termina de completar el numero*/ 
        if(this.numeroConvertir.isRacional()){
            double multiplicando = Double.parseDouble("0." + numeroDec);
            int multiplicador = this.resultadoConversion.getBase();
            double producto = multiplicando;
            cifraTemporal.add('.');            
            for(int i = 0; i < numeroDec.length(); i++){
                producto = multiplicando * multiplicador;
                cifraTemporal.add((int)producto);
                multiplicando = producto - (double)((int)producto);
            }            
            this.resultadoConversion.setPosicionPunto(cifraTemporal.indexOf('.'));
            this.resultadoConversion.setRacional(this.numeroConvertir.isRacional());
        }                
        
        /*crea el numero como tal y lo asigna como valor al resualtado final*/
        String resultadoTemporal = this.resultadoConversion.fabricarNumero(cifraTemporal, this.resultadoConversion.getSistema());
        this.resultadoConversion.setValor(resultadoTemporal);   
    }
    /*METODO QUE REALIZA LA CONVERSION DE CUALQUIER BASE SOPORTADA A BASE 10 */
    public void cualquierBase_Base10(){                
        int tam = this.numeroConvertir.getValor().length() - 1, i, j, posi, posj;
        boolean completado = false;
        double sumatoria = 0;
        String resultadoTemporal = this.numeroConvertir.getValor();
        /*inicializa las variables de acuardo al tipo de numero ingresado*/
        if(this.numeroConvertir.isRacional()){ 
            i = this.numeroConvertir.getPosicionPunto(); j = this.numeroConvertir.getPosicionPunto();//variables controlan la posicion de partida para realizar las operaciones con cada digito
            posi = i-1; posj = j; //estas variables controlan el exponente al cual elevar la base del numero a convertir
        }else{ 
            i = tam + 1; j = tam; posi = tam; posj = j; 
        }
        /*calcula el resultado usando la base correspondiente y las cifras del numero a covertir*/
        while(!completado){                 
            if(i > 0){ sumatoria = sumatoria + (this.numeroConvertir.getSistema().getDigitos().indexOf(resultadoTemporal.charAt(--i)) * (int)(Math.pow(this.numeroConvertir.getBase(), (posi - i)))); }
            if(j < tam){ sumatoria = sumatoria + (this.numeroConvertir.getSistema().getDigitos().indexOf(resultadoTemporal.charAt(++j)) * (Math.pow(this.numeroConvertir.getBase(), (posi - (posj++))))); }
            if(i == 0 && j == tam) completado = true;
        }  
        /*termina de formar el numero si es racional y si no solo convierte el double a string sin decimales*/    
        if(this.numeroConvertir.isRacional()){
            this.resultadoConversion.setRacional(this.numeroConvertir.isRacional());
            this.resultadoConversion.setPosicionPunto(this.numeroConvertir.getPosicionPunto());   
            int numeroDec = this.numeroConvertir.obtenerDecimales().length() + 1; //resultadoTemporal = String.valueOf(sumatoria);
            resultadoTemporal = String.valueOf(sumatoria).substring(0, this.numeroConvertir.getPosicionPunto() + numeroDec);
        }else{
            resultadoTemporal = String.valueOf((int)sumatoria);
        }        
        
        this.resultadoConversion.setValor(resultadoTemporal);        
    }    
    /*METODO QUE REALIZA LA CONVERSION DE CUALQUIER BASE SOPORTADA A OTRA BASE SOPORTADA QUE NO SEA 10*/
    public void cualquierBase_CualquierBase(){ 
        this.cualquierBase_Base10();
        this.base10_CualquierBase();    
    }
}