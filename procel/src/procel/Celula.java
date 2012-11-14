/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procel;

import java.util.ArrayList;

public class Celula {
    
    float longLado;  
    int numLado;
    ArrayList<Celula> vecinos;

    public ArrayList<Celula> getVecinos() {
        return vecinos;
    }

    public void setVecinos(ArrayList<Celula> vecinos) {
        this.vecinos = vecinos;
    }
    Celula(){}
    Celula(float longLado,int numLado){
        this.longLado=longLado;
        this.numLado=numLado; 
        vecinos=new ArrayList<Celula>();
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
