
package Modelo;

/**
 *
 * @author equipo scrum
 */
public class Arco {

    private long verticeInicial;
    private long verticeFinal;
    private int costo;

    public Arco(long verticeInicial, long verticeFinal, int costo) {
        this.verticeInicial = verticeInicial;
        this.verticeFinal = verticeFinal;
        this.costo = costo;
    }
    
    public long getVerticeInicial() {
        return verticeInicial;
    }

    public void setVerticeInicial(long verticeInicial) {
        this.verticeInicial = verticeInicial;
    }

    public long getVerticeFinal() {
        return verticeFinal;
    }

    public void setVerticeFinal(long verticeFinal) {
        this.verticeFinal = verticeFinal;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
}
