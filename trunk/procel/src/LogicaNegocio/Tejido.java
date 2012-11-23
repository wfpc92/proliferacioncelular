package LogicaNegocio;

public class Tejido<T> {
    private int id;
    private Grafo<T> TejidoG;
  
    public Grafo<T> getTejidoG() {
        return TejidoG;
    }

    public void setTejidoG(Grafo<T> TejidoG) {
        this.TejidoG = TejidoG;
    }

    public Tejido(){
        this.TejidoG = null;
        this.id = 0;
    }
    public Tejido(Grafo<T> TejidoG, int id) {
        this.TejidoG = TejidoG;
        this.id = id;
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
