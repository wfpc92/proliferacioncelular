/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Abstracto;

/**
 *
 * @author equipo scrum
 */
public abstract  class Observado {
    java.util.LinkedList<Observador> observadores;
    
    public void addObservador(Observador obs){
        if(observadores == null) observadores = new java.util.LinkedList<Observador>();
        observadores.add(obs);
    }
    
    public void notificarObservadores(){
        for(java.util.Iterator<Observador> e = observadores.iterator(); e.hasNext(); ){
           e.next().update(this);
        }
    }

    
}
