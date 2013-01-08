package Modelo;

import java.util.ArrayList;

public class Grafo<T> {

    private ArrayList<Vertice<T>> listaVertices = new ArrayList<Vertice<T>>();
    private ArrayList<Arco> listaArcos = new ArrayList<Arco>();

    /**
     * se inicializa una lista de vertices y una lista de arcos.
     */
    public Grafo() {
        this.listaVertices = new ArrayList<Vertice<T>>();
        this.listaArcos = new ArrayList<Arco>();
    }

    /**
     * se inicializa una lista de vertices y arcos, tomando los valores de los
     * argumentos
     *
     * @param listaVertices
     * @param listaArcos
     */
    public Grafo(ArrayList<Vertice<T>> listaVertices,
            ArrayList<Arco> listaArcos) {
        this.listaVertices = listaVertices;
        this.listaArcos = listaArcos;
    }

    public ArrayList<Vertice<T>> getLista_vertices() {
        return listaVertices;
    }

    public void setLista_vertices(ArrayList<Vertice<T>> lista_vertices) {
        this.listaVertices = lista_vertices;
    }

    public ArrayList<Arco> getListaArcos() {
        return listaArcos;
    }

    public void setListaArcos(ArrayList<Arco> listaArcos) {
        this.listaArcos = listaArcos;
    }

    /**
     * con este metodo se adiciona un nuevo vertice al grafo
     *
     * @param celula
     * @param sub
     */
    public void AgregarVertice(T celula, long sub) {
        Vertice<T> obj = new Vertice<T>();
        obj.setInfo(celula);
        obj.setSubindice(sub);
        listaVertices.add(obj);
    }

    /**
     * con este metodo se adiciona un arco al grafo.
     *
     * @param vi
     * @param vj
     * @param costo
     */
    public void AgregarArco(long vi, long vj, int costo) {
        Arco obj_arco = new Arco(vi, vj, costo);
        //System.out.println("crea arco desde: " + vi + "hasta: " + vj);
        if (this.BuscarVertice(vi) && this.BuscarVertice(vj)) {
            this.listaArcos.add(obj_arco);
        } else {
            //System.out.println("NO ES POSIBLE AGREGAR EL ARCO ");
        }
    }

    /**
     * este metodo permite buscar un determinado vertice dentro del grafo.
     *
     * @param subindice
     * @return retona verdadero si halla el vertice, de lo contrario retorna
     * falso
     */
    public boolean BuscarVertice(long subindice) {
        if (this.listaVertices.isEmpty()) {
            return false;
        } else {
            for (int i = 0; i < this.listaVertices.size(); i++) {
                if (this.listaVertices.get(i).getSubindice() == subindice) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * elimina un determinado vertice del grafo.
     *
     * @param subIndice
     */
    public void ElimVertice(int subIndice) {
        int posicion;

        if (this.BuscarVertice(subIndice)) {
            if (!listaArcos.isEmpty()) {
                for (int i = 0; i < listaArcos.size(); i++) {
                    if (listaArcos.get(i).getVerticeInicial() == subIndice || listaArcos.get(i).getVerticeFinal() == subIndice) {
                        listaArcos.remove(i);
                    }
                }
            } else {
               // System.out.println("EL VERTICE NO EXISTE");
            }
        }
    }

    /**
     * elimina un determinado arco del grafo.
     *
     * @param vi
     * @param vj
     */
    public void ElimArco(int vi, int vj) {

        int posicion;

        posicion = this.posicionArcoCompleto(vi, vj);
        if (posicion != -1) {
            this.listaArcos.remove(posicion);
        } else {
            //System.out.println("EL ARCO NO EXISTE");
        }
    }

    /**
     * busca la posicion de un arco dentro del grafo.
     *
     * @param vi
     * @param vj
     * @return retorna la posicion del arco que se esta buscando, de lo
     * contrario retorna -1.
     */
    public int posicionArcoCompleto(long vi, long vj) {
        for (int i = 0; i < this.listaArcos.size(); i++) {
            if ((this.listaArcos.get(i).getVerticeInicial() == vi
                    && this.listaArcos.get(i).getVerticeFinal() == vj)
                    || this.listaArcos.get(i).getVerticeFinal() == vi
                    && this.listaArcos.get(i).getVerticeInicial() == vj) {
                return i;
            }
        }
        return -1;
    }

    /**
     * busca una conexion entre vi y vj.
     *
     * @param vi
     * @param vj
     * @return retorna verdadero en caso de que exista dicha conexion de lo
     * contrario retorna falso.
     */
    public boolean existeArco(long vi, long vj) {
        if (!this.listaArcos.isEmpty()) {
            int posicion = this.posicionArcoCompleto(vi, vj);
            if (posicion != -1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Averigia el numero de vertices que tiene el grafo.
     *
     * @return retorna el numero de vertices que tiene el grafo
     */
    public int ordenGrafo() {
        return this.listaVertices.size();
    }

    /**
     * busca vertice en la posicion subindice y lo marca.
     *
     * @param subIndice
     */
    public void MarcarVertice(int subIndice) {
        for (int i = 0; i < this.listaVertices.size(); i++) {
            if (this.listaVertices.get(i).getSubindice() == subIndice) {
                this.listaVertices.get(i).setMarca(true);
                break;
            }
        }
    }

    /**
     * busca vertice en la posicion subindice y lo desmarca.
     *
     * @param g
     * @param subIndice
     */
    public void DesmarcarVertice(int subIndice) {
        for (int i = 0; i < this.listaVertices.size(); i++) {
            if (this.listaVertices.get(i).getSubindice() == subIndice) {
                this.listaVertices.get(i).setMarca(false);
                break;
            }
        }
    }

    /**
     * averigua si el vertice esta marcado.
     *
     * @param g
     * @param subIndice
     * @return retorna verdadero si el vertice esta marcado, en caso contrario
     * retorna falso.
     */
    public boolean MarcadoVertice(int subIndice) {
        for (int i = 0; i < this.listaVertices.size(); i++) {
            if (this.listaVertices.get(i).getSubindice() == subIndice) {
                return this.listaVertices.get(i).getMarca();
            }
        }
       // System.out.println("La marca del vertice no ha sido encontrada");
        return false;
    }
}