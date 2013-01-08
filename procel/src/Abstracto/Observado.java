
package Abstracto;


public abstract  class Observado {
    java.util.LinkedList<Observador> misObservadores;
    
    public void addObservador(Observador obs){
        if(misObservadores == null) {
            misObservadores = new java.util.LinkedList<Observador>();
        }
        misObservadores.add(obs);
    }
    
    public void notificarObservadores(){
        for(java.util.Iterator<Observador> e = misObservadores.iterator(); e.hasNext(); ){
           e.next().update(this);
        }
    }

    
}
