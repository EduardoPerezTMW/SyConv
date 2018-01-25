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
public class Operando {
    private String valor;
    private int base;
    private SistemaNumerico sistema;
    
    public Operando(String valor, int base){
        this.valor = valor;
        this.base = base;
        this.sistema = new SistemaNumerico(base);
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
        
}
