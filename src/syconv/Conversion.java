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
    private int baseInicial;
    private int baseFinal;
    private ArrayList<String> numeroConvertir;    
    private String resultadoConversion;
    
    private ArrayList<String> sistemaNumerico;
    private ArrayList<String> cifrasDelSistema;
    
    public Conversion(){
    }
    
    public Conversion(String baseInicial, String baseFinal, String numeroConvertir, String resultadoConversion){
        this.baseInicial = Integer.parseInt(baseInicial);
        this.baseFinal = Integer.parseInt(baseFinal);
        //while(){
            this.numeroConvertir.add(numeroConvertir);
        //}
        
               
        this.resultadoConversion = resultadoConversion;
        this.tipo = 0;
    }
   
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getBaseInicial() {
        return baseInicial;
    }

    public void setBaseInicial(int baseInicial) {
        this.baseInicial = baseInicial;
    }

    public int getBaseFinal() {
        return baseFinal;
    }

    public void setBaseFinal(int baseFinal) {
        this.baseFinal = baseFinal;
    }

    public ArrayList<String> getNumeroConvertir() {
        return numeroConvertir;
    }

    public void setNumeroConvertir(ArrayList<String> numeroConvertir) {
        this.numeroConvertir = numeroConvertir;
    }

    public String getResultadoConversion() {
        return resultadoConversion;
    }

    public void setResultadoConversion(String resultadoConversion) {
        this.resultadoConversion = resultadoConversion;
    }

    public ArrayList<String> getSistemaNumerico() {
        return sistemaNumerico;
    }

    public void setSistemaNumerico(ArrayList<String> sistemaNumerico) {
        this.sistemaNumerico = sistemaNumerico;
    }

    public ArrayList<String> getCifrasDelSistema() {
        return cifrasDelSistema;
    }

    public void setCifrasDelSistema(ArrayList<String> cifrasDelSistema) {
        this.cifrasDelSistema = cifrasDelSistema;
    }
    
    public String convertir(){        
        this.tipo = validarTipoConversion(this.baseInicial, this.baseFinal);
        switch(this.tipo){
            case 1: this.resultadoConversion = base10_CualquierBase(); break;
            case 2: this.resultadoConversion = cualquierBase_Base10(); break;
            case 3: this.resultadoConversion = cualquierBase_CualquierBase(); break;
            //default: this.resultadoConversion = this.numeroConvertir;
        }
        
        return this.resultadoConversion;
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
        
        
        return null;
    }
    
    public String cualquierBase_Base10(){
        return null;
    }
    
    public String cualquierBase_CualquierBase(){
        return null;
    }   
}
