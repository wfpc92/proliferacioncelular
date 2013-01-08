package Modelo;

public class Celula {

    private long id;
    private double longLado;
    private int numLado;

    public Celula() {
        longLado = 0;
        numLado = 0;
    }

    public Celula(long id, double longLado, int numLado) {
        this.id = id;
        this.longLado = longLado;
        this.numLado = numLado;
        //System.out.println("se creo la cel:" + id + "numero de Lados: " + numLado);
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
}