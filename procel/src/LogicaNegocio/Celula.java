/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocio; 

public class Celula {
    private int id;
    private double longLado;  
    private int numLado;    
    
    public Celula(){
        longLado=0;
        numLado=0;   
    }
    
    public Celula(int id, double longLado,int numLado){
        this.id = id;
        this.longLado=longLado;
        this.numLado=numLado; 
    }

    public double getLongLado() {
        return longLado;
    }

    public void setLongLado(double longLado) {
        this.longLado = longLado;
    }

    public int getNumLado() {
        return numLado;
    }

    public void setNumLado(int numLado) {
        this.numLado = numLado;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
       
}
