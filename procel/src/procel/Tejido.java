package procel;

public class Tejido<T> {
    private Grafo<T> TejidoG;

    public Grafo<T> getTejidoG() {
        return TejidoG;
    }

    public void setTejidoG(Grafo<T> TejidoG) {
        this.TejidoG = TejidoG;
    }

    public Tejido(Grafo<T> TejidoG) {
        this.TejidoG = TejidoG;
    }
  
}
