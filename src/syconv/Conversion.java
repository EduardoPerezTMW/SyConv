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
    private int valorConvertir;
    private int resultadoConversion;
    
    public Conversion(){
    }
    
    public Conversion(int baseIni, int baseFin, int valor, int resultado){
        setBaseInicial(baseIni);
        setBaseFinal(baseFin); 
        setValorConvertir(valor);        
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
    
    public int getBaseFinal(){
        return baseFinal;
    }
    
    public void setBaseFinal(int baseFinal){
        this.baseFinal = baseFinal;
    }
    
    public int getValorConvertir() {
        return valorConvertir;
    }

    public void setValorConvertir(int valorConvertir) {
        this.valorConvertir = valorConvertir;
    }

    public int getResultadoConversion() {
        return resultadoConversion;
    }

    public void setResultadoConversion(int resultadoConversion) {
        this.resultadoConversion = resultadoConversion;
    }
    
    public String convertir(String resultado){
        String res = resultado;
        return res;
    }
    
    public int validarTipoConversion(){
        return 0;
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
