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
    
    /*  Este constructor puede cambiar debido que que existe la posibilidad de que el parametro
        Operando resultadoConversion no vaya y por lo tanto la creacion del objeto correspondiente se va 
        a hacer al obtener todos los datos necesarios, ademas en ves de ese argumento ira: int baseFinal
    */
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
    public void convertir(){        
        this.caso = casoConversion(this.numeroConvertir.getBase(), this.resultadoConversion.getBase());
        switch(this.caso){
            case 1: base10_CualquierBase(); break;
            case 2: cualquierBase_Base10(); break;
            case 3: cualquierBase_CualquierBase(); break;
            case 4: 
                this.resultadoConversion.setValor(this.numeroConvertir.getValor());
                this.resultadoConversion.setSistema(this.numeroConvertir.getSistema());
                this.resultadoConversion.setBase(this.numeroConvertir.getBase()); 
                this.resultadoConversion.setPosicionPunto(this.numeroConvertir.getPosicionPunto());
                this.resultadoConversion.setRacional(this.numeroConvertir.isRacional());
                this.resultadoConversion.setNegativo(this.numeroConvertir.isNegativo());
        }   
    }
    
    /*DETECTA EL CASO DE CONVERSION QUE SE PRESENTA*/
    public int casoConversion(int baseInicial, int baseFinal){        
        if(baseInicial == baseFinal){
            return 4;
        }else{
            if((baseInicial == 10) && (baseFinal != 10)){
                return 1; // de base 10 a cualquier otra
            }else{
                if((baseInicial != 10) && (baseFinal == 10)){
                    return 2; // de cualquiera a base 10
                }else{
                    if((baseInicial != 10) && (baseFinal != 10)){
                        return 3;// de cualquiera a cualquiera
                    }
                }
            }
        }
        return -1;
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
            for(int i = 0; i < 14; i++){//numeroDec.length(); i++){
                producto = multiplicando * multiplicador;
                cifraTemporal.add((int)producto);
                multiplicando = producto - (double)((int)producto);
            }            
            this.resultadoConversion.setPosicionPunto(cifraTemporal.indexOf('.'));
            this.resultadoConversion.setRacional(this.numeroConvertir.isRacional());
        }                
        
        /*crea el numero como tal y lo asigna como valor al resualtado final*/
        String resultadoTemporal = this.resultadoConversion.fabricarNumero(cifraTemporal, this.resultadoConversion.getSistema());        
        this.resultadoConversion.setNegativo(this.numeroConvertir.isNegativo());
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
            //int numeroDec = this.numeroConvertir.obtenerDecimales().length(); //resultadoTemporal = String.valueOf(sumatoria);
            resultadoTemporal = String.valueOf(sumatoria);
            this.resultadoConversion.setRacional(true);
            this.resultadoConversion.setPosicionPunto(resultadoTemporal.indexOf("."));
            //resultadoTemporal = resultadoTemporal.substring(0, this.resultadoConversion.getPosicionPunto() + numeroDec);            
        }else{
            resultadoTemporal = String.valueOf((int)sumatoria);
        }                
        this.resultadoConversion.setNegativo(this.numeroConvertir.isNegativo());
        this.resultadoConversion.setValor(resultadoTemporal);        
        int i1 = 0;
    }    
    /*METODO QUE REALIZA LA CONVERSION DE CUALQUIER BASE SOPORTADA A OTRA BASE SOPORTADA QUE NO SEA 10*/
    /*  Este metodo puede cambiar ya que la basetemp puede hacerse innecesaria, al cambiar los atributos de la
        clase, porque existe la posibilidad de que al crear el objeto conversion no sea tan necesario crear
        de un solo el objeto resultadoConversion, este puede crearse de un solo al obtener los resultados.
    */    
    public void cualquierBase_CualquierBase(){ 
        int baseTemp = this.resultadoConversion.getBase();//para recordar la base del resultado
        this.cualquierBase_Base10();        
        this.resultadoConversion.setBase(10); // para actualizar la base y obtener un resultado intermedio
        this.numeroConvertir = this.resultadoConversion; // el resultado de la conversion anterior se vuelve el nuevo numero a convertir
        this.resultadoConversion = new Operando("", baseTemp);// se actualiza el objeto resultado final para obtener el definitivo
        this.base10_CualquierBase(); //se obtiene el resultado de la conversion definitivo
    }
}