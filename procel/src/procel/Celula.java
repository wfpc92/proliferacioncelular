/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procel;

import java.util.ArrayList;

public class Celula {
    
    float longLado;  
    int numLado;
    
    
    public Celula(){
        longLado=0;
        numLado=0;
          
    }
    Celula(float longLado,int numLado){
        this.longLado=longLado;
        this.numLado=numLado; 
    }

    public float getLongLado() {
        return longLado;
    }

    public void setLongLado(float longLado) {
        this.longLado = longLado;
    }

    public int getNumLado() {
        return numLado;
    }

    public void setNumLado(int numLado) {
        this.numLado = numLado;
    }
    
       
}
