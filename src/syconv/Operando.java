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
        int i, j, posi, posj, tam = cifraTemporal.size();        
        String numeroFabricado = "";
        boolean completado = false;
        ArrayList<String> resultadoTemporal = new ArrayList<String>();        
        for(int x = 0; x < tam; x++){ resultadoTemporal.add("O"); }
        
        if(this.racional){ //valores si el numero es racional
            i = this.posicionPunto; j = this.posicionPunto; posi = 0; posj = this.posicionPunto;            
        }else{ //valores si el numero es entero
            i = tam; j = tam; posi = 0; posj = tam;
        }        
        /*  Esta parte le da vuelta a la parte entera del numero(tenga parte decimal) */
        while(!completado){                
            if(i > 0){ resultadoTemporal.set(posi++, String.valueOf(cifraTemporal.get(--i))); }
            if(j < tam){ resultadoTemporal.set(posj++, String.valueOf(cifraTemporal.get(j++))); }
            if(i == 0 && j == tam) completado = true;                
        }  
        /*crea la cadena correspondiente al numero racional o entero*/
        while(i < tam){
            if(i == this.posicionPunto){ numeroFabricado = numeroFabricado + '.'; i++; }// si tiene parte decimal
            posi = Integer.parseInt(resultadoTemporal.get(i));
            numeroFabricado = numeroFabricado + sistema.getDigitos().get(posi);
            i++;
        } 
        
        return numeroFabricado;
    }
    
    /* FUNCION QUE DEVUELVE LA PARTE ENTERA DEL NUMERO PASADO COMO PARAMETRO
       SI EL NUMERO PASADO COMO PARAMETRO ES ENTERO ENTONCES LO RETORNA */
    public String obtenerEnteros(){
        int punto = this.valor.indexOf(".");
        if(punto == -1){ return this.valor; }        
        return this.valor.substring(0, punto);
    }
    
    /*FUNCION QUE DEVUELVE LA PARTE DECIMAL DEL NUMERO PASADO COMO PARAMETRO*/
    public String obtenerDecimales(){        
        int punto = this.valor.indexOf(".");
        if(punto == -1){ return "00"; }
        return this.valor.substring(punto+1);
    }    
    
    /*FUNCION QUE COMPRUEBA QUE LA BASE CORRESPONDE AL NUMERO*/
    public boolean baseCorrespondiente(){        
        boolean corresponde = true;
        for(int i = 0; i < this.valor.length(); i++){            
            if(i == this.posicionPunto) i++;
            if(this.sistema.getDigitos().indexOf(this.valor.charAt(i)) == -1){ corresponde = false; break; }            
        }//si hay un solo digito que no se encuentre en los digitos del sistema entonces el numero no corresponde
        return corresponde;
    }
}
