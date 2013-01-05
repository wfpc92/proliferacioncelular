package Modelo;

import Abstracto.Observado;
import java.util.ArrayList;
import java.util.Random;

public class Tejido<T> extends Observado {

    private int id;
    private String nombre;
    private Grafo<T> TejidoG;
    private long con;
    private ArrayList<T> celulasIncompletas;
    private long tamMuestra;

    public Tejido() {
        this.id = 0;
        this.nombre = "";
        this.TejidoG = new Grafo<>();
        this.con = 0;
        this.celulasIncompletas = new ArrayList<>();
    }

    public Tejido(int id, String nombre, T celIni, long tamanio) {
        this.id = id;
        this.nombre = nombre;
        this.TejidoG = new Grafo<>();
        this.con = 0;
        this.celulasIncompletas = new ArrayList<>();
        this.tamMuestra = tamanio;
        this.celulasIncompletas.add(celIni);
        this.TejidoG.AgregarVertice(celIni, con);
    }

    public long getCon() {
        return con;
    }

    public void setCon(long con) {
        this.con = con;
    }

    public ArrayList<T> getCelulasIncompletas() {
        return celulasIncompletas;
    }

    public void setCelulasIncompletas(ArrayList<T> celulasIncompletas) {
        this.celulasIncompletas = celulasIncompletas;
    }

    public long getTamMuestra() {
        return tamMuestra;
    }

    public void setTamMuestra(long tamMuestra) {
        this.tamMuestra = tamMuestra;
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

    /**
     * da paso para que se puedan crear las conexiones entre celulas nuevas y
     * celulas ya existentes.
     *
     *
     */
    public void abrirTejido() {
        ArrayList<T> lstAux = new ArrayList<T>();
        for (int i = 0; i < this.celulasIncompletas.size(); i++) {
            System.out.println("al rededor de" + ((Celula) this.celulasIncompletas.get(i)).getId());
            while (!this.esCompleto(this.celulasIncompletas.get(i)) && this.TejidoG.getLista_vertices().size() <= this.tamMuestra) {
                this.con++;
                Celula cel = new Celula(con, 10, GenerarNumeroLados());
                System.out.println("se crea la celula:" + cel.getId());
                lstAux.add((T) cel);
                this.TejidoG.AgregarVertice((T) cel, con);
                this.TejidoG.AgregarArco(((Celula) this.celulasIncompletas.get(i)).getId(), ((Celula) cel).getId(), 10);
            }
        }
        this.celulasIncompletas = lstAux;
    }

    /**
     * averigua si la celula ya tiene todos sus lados.
     *
     * @param cel es la celula de la cual se desea saber si ya tiene su numero
     * de lados completos
     * @return se obtiene verdadero si el nuemro de lados esta completo, de lo
     * contrario se obtiene falso
     */
    public boolean esCompleto(T cel) {
        int contadorLados = 0;
        ArrayList<Arco> arcos = this.TejidoG.getListaArcos();
        for (int i = 0; i < arcos.size() && contadorLados < ((Celula) cel).getNumLado(); i++) {
            if (arcos.get(i).getVerticeInicial() == ((Celula) cel).getId() || arcos.get(i).getVerticeFinal() == ((Celula) cel).getId()) {
                contadorLados++;
            }
        }
        System.out.println("el Numero de lados de :" + ((Celula) cel).getId() + " es: " + contadorLados);
        if (contadorLados < ((Celula) cel).getNumLado()) {
            return false;
        }
        return true;
    }

    /**
     * se obtiene de manera aleatoria el numero de lados de una celula.
     *
     * @return retorna el numero de lados que va a tener la celula
     */
    public int GenerarNumeroLados() {
        Random ran = new Random();
        int newLado = 0;
        do {
            newLado = ran.nextInt(9);
        } while (newLado < 4);
        return newLado;
    }

    /**
     * con este metodo se realizan las conexiones entre entre una determinada
     * celula y sus vecinos.
     */
    public void cerrarTejido() {
        int j;
        for (j = 0; j < (celulasIncompletas.size()) - 1; j++) {
            this.TejidoG.AgregarArco(((Celula) celulasIncompletas.get(j)).getId(), ((Celula) celulasIncompletas.get(j + 1)).getId(), 10);
        }
        //conectando el ultimo con el primero
    }

    /**
     * evalula el numero de vecinos que tiene la celula y completa los
     * faltantes.
     *
     * @param cel es la celula que se va evaluar con el fin de saber si esta ya
     * tiene todos sus vecinos
     */
    public void completarTejido(Celula cel) {
        if (this.TejidoG.existeArco(cel.getId(), ((Celula) this.celulasIncompletas.get(this.celulasIncompletas.size() - 1)).getId())) {
            this.TejidoG.AgregarArco(((Celula) celulasIncompletas.get(this.celulasIncompletas.size() - 1)).getId(), ((Celula) celulasIncompletas.get(0)).getId(), 10);
        }
    }

    /**
     * Genera un grafo triangularizado.
     */
    public void triangularizacion() {
        while (this.TejidoG.getLista_vertices().size() < this.tamMuestra) {
            Celula cel = (Celula) this.celulasIncompletas.get(this.celulasIncompletas.size() - 1);
            this.abrirTejido();
            this.cerrarTejido();
            this.completarTejido(cel);
        }
    }
}
