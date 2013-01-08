package Modelo;

public class Vertice<T> {

    private T info;
    private boolean marca;
    private long subindice;

    public Vertice() {
        this.marca = false;
        this.subindice = 0;
    }
    
    public Vertice(T x) {
        info = x;
        marca = false;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public boolean getMarca() {
        return marca;
    }

    public void setMarca(boolean marca) {
        this.marca = marca;
    }

    public long getSubindice() {
        return subindice;
    }

    public void setSubindice(long subindice) {
        this.subindice = subindice;
    }
}