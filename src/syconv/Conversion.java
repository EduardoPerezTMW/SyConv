/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syconv;

/**
 *
 * @author Daniel
 */
public class Conversion {
    private String tipo;
    private int baseInicial;
    private int baseFinal;
    private String numeroConvertir;
    private String resultadoConversion;
    
    public Conversion(){
    }
    
    public Conversion(int baseIni, int baseFin, String numero){
        /*setBaseInicial(baseIni);
        setBaseFinal(baseFin); 
        setNumeroConvertir(numero);        */
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
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

    public String getNumeroConvertir() {
        return numeroConvertir;
    }

    public void setNumeroConvertir(String numeroConvertir) {
        this.numeroConvertir = numeroConvertir;
    }

    public String getResultadoConversion() {
        return resultadoConversion;
    }

    public void setResultadoConversion(String resultadoConversion) {
        this.resultadoConversion = resultadoConversion;
    }
    
    public String convertir(){
        String res = null;
        return res;
    }
    
    public int validarTipoConversion(){
        int tipo = 0;
        return tipo;
    }
    
    public String base10_CualquierBase(){
        return null;
    }
    
    public String cualquierBase_Base10(){
        return null;
    }
    
    public String CualquierBase_CualquierBase(){
        return null;
    }
    
}
