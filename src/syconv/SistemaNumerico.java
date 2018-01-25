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
public class SistemaNumerico {
    private int baseSistema;
    private ArrayList digitos;
    private ArrayList valores;    
    
    public SistemaNumerico(int baseSistema){        
        this.baseSistema = baseSistema;
        this.digitos = new ArrayList();
        this.valores = new ArrayList();
        generarDigitosValores();
    }
    /*FUNCION QUE GENERA LOS DIGITOS(REPRESENTACION SIMBOLICA) Y SUS CORRESPONDIENTES VALORES DEL SISTEMA CREADO*/
    public void generarDigitosValores(){
        char caracterTemporal = ' ';
        int j = 0;
        for(int i = 0; i < this.baseSistema; i++){
            this.valores.add(i);            
            if(i <= 9){                                
                this.digitos.add(i);
            }else{                 
                caracterTemporal = (char)(65+j);
                if(caracterTemporal == 'I' || caracterTemporal == 'O'){ j++; }
                this.digitos.add(caracterTemporal);
                j++;
            }            
        }
    }
    /*GETTERS Y SETTERS*/
    public int getBaseSistema() {
        return baseSistema;
    }

    public void setBaseSistema(int baseSistema) {
        this.baseSistema = baseSistema;
    }

    public ArrayList getValores() {
        return valores;
    }

    public void setValores(ArrayList valores) {
        this.valores = valores;
    }

    public ArrayList getDigitos() {
        return digitos;
    }

    public void setDigitos(ArrayList digitos) {
        this.digitos = digitos;
    }
    
    
}
