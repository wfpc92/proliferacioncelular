package Modelo;

import Abstracto.Componente;

public class Celula implements Componente{

    private long id;
    private double longLado;
    private int numLado;
    private Componente vecindario;
    public Celula() {
        
        longLado = 0;
        numLado = 0;
    }

    public Celula(long id, double longLado, int numLado) {
        
        this.id = id;
        this.longLado = longLado;
        this.numLado = numLado;
        this.vecindario = new Vecindario();
        //System.out.println("se creo la cel:" + id + "numero de Lados: " + numLado);
    }
    
    public void setVecindario(Vecindario vecindario){
        this.vecindario = vecindario;
    }
    
    public Componente getVecindario(){
        return this.vecindario;
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

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void mostrar() {
        vecindario.mostrar();
    }

    @Override
    public void add(Componente c) {    }

    @Override
    public void eliminar(Componente c) {    }

    @Override
    public Componente obtenerHijo(int num) {  return null;  }
}