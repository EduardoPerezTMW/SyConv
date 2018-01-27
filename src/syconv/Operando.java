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
        String numeroFabricado = " ";
        ArrayList<String> resultadoTemporal = new ArrayList<String>();        
        for(int x = 0; x < tam; x++){ resultadoTemporal.add("O"); numeroFabricado = numeroFabricado + "O"; }
        
        if(this.racional){// tiene parte entera y fraccionaria &&
            /*le da la vuelta al array partiendo desde la posicion del punto para que los valores de las cifras esten en la posicion correcta*/            
            int i = this.posicionPunto, j = this.posicionPunto, posi = 0, posj = j;
            boolean completado = false;
            while(!completado){                
                if(i > 0){ 
                    //posi = --i;
                    resultadoTemporal.set(posi++, String.valueOf(cifraTemporal.get(--i))); 
                }//.add(cifraTemporal.get(--i)); }
                if(j < tam){ 
                    //posj = j++;
                    resultadoTemporal.set(posj++, String.valueOf(cifraTemporal.get(j++))); 
                }//.add(cifraTemporal.get(j++)); }
                if(i == 0 && j == tam) completado = true;                
            }            
            //numeroFabricado = numeroFabricado + sistema.getDigitos().get((int)resultadoTemporal.get(i));
            i = this.posicionPunto; j = this.posicionPunto; completado = false;            
            //numeroFabricado. = "."; //AQUI YA REEMPLAZASTE EL PUNTO PARA QUE TE SIRVA DE PIVOTE
            
            while(!completado){                                
                if(i > 0){ 
                    //posi = (int)resultadoTemporal.get(--i);
                    posi = resultadoTemporal.indexOf(resultadoTemporal.get(--i));
                    numeroFabricado = numeroFabricado + String.valueOf(sistema.getDigitos().get(posi)); 
                }
                if(j < tam-1){ 
                    posj = resultadoTemporal.indexOf(resultadoTemporal.get(++j));
                    numeroFabricado = numeroFabricado + String.valueOf(sistema.getDigitos().get(posj)); 
                }
                if(i == 0 && j == (tam-1)) completado = true;                
            }   
        }else{ // tiene solo parte entera
            /*le da la vuelta al array para que los valores de las cifras esten en la posicion correcta*/
            for(int i = tam; i >= 0; i--){
            //    resultadoTemporal.add(cifraTemporal.get(i));                                         
            }
            /*crea la cadena de texto con las cifras de la parte decimal aplicando los digitos del sistema correspondiente*/
            for(int i = 0; i < tam; i++){            
            //    numeroFabricado = numeroFabricado + sistema.getDigitos().get((int)resultadoTemporal.get(i));
            }
        }
        
        
        /*crea la cadena de texto con las cifras de la parte decimal aplicando los digitos del sistema correspondiente*/
        
        return numeroFabricado;
    }
    
    /*FUNCION QUE DEVUELVE LA PARTE ENTERA DEL NUMERO PASADO COMO PARAMETRO
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
