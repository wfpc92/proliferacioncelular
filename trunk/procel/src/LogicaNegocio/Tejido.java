package LogicaNegocio;

public class Tejido<T> {
    private int id;
    private String nombre;
    private Grafo<T> TejidoG;

    public Tejido(){
        id = 0;
        nombre = "";
        TejidoG = new Grafo<>();
    }
    public Tejido(int id, String nombre, Grafo<T> TejidoG) {
        this.id = id;
        this.nombre = nombre;
        this.TejidoG = TejidoG;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Grafo<T> getTejidoG() {
        return TejidoG;
    }

    public void setTejidoG(Grafo<T> TejidoG) {
        this.TejidoG = TejidoG;
    }
 
}
