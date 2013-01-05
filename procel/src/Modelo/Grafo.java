package Modelo;

import java.util.ArrayList;

public class Grafo<T> {

    private ArrayList<Vertice<T>> listaVertices = new ArrayList<Vertice<T>>();
    private ArrayList<Arco> listaArcos = new ArrayList<Arco>();
    //public int costo1;

    public Grafo() {
        this.listaVertices = new ArrayList<Vertice<T>>();
        this.listaArcos = new ArrayList<Arco>();
    }

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

    public void AgregarVertice(T celula, long sub) {
        Vertice<T> obj = new Vertice<T>();
        obj.setInfo(celula);
        obj.setSubindice(sub);
        listaVertices.add(obj);
    }

    public void AgregarArco(long vi, long vj, int costo) {
        Arco obj_arco = new Arco(vi, vj, costo);
        System.out.println("crea arco desde: "+vi+"hasta: "+vj);
        if (this.BuscarVertice(vi) && this.BuscarVertice(vj)) {
            this.listaArcos.add(obj_arco);
        } else {
            System.out.println("NO ES POSIBLE AGREGAR EL ARCO ");
        }
    }

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

    public void ElimVertice(int subIndice) {
        int posicion;

        if (this.BuscarVertice(subIndice)) {
            if (!listaArcos.isEmpty()) {
                for (int i = 0; i < listaArcos.size(); i++) {
                    if (listaArcos.get(i).getVerticeInicial() == subIndice || listaArcos.get(i).getVerticeFinal() == subIndice) {
                        listaArcos.remove(i);
                    }
                }
                //aqui hay algo raro verificar posteriormente
			/*posicion=listaVertices.PosicionVertice(subindice, listaVertices);
                 listaVertices.Primero();
                 listaVertices.posLista(listaVertices, posicion, 0);
                 listaVertices.ElimLista();*/
            } else {
                System.out.println("EL VERTICE NO EXISTE");
            }
        }
    }

    public void ElimArco(int vi, int vj) {

        int posicion;

        posicion = this.posicionArcoCompleto(vi, vj);
        if (posicion != -1) {
            this.listaArcos.remove(posicion);
        } else {
            System.out.println("EL ARCO NO EXISTE");
        }
    }

    public int posicionArcoCompleto(long vi, long vj) {
        for (int i = 0; i < this.listaArcos.size(); i++) {
            if ((this.listaArcos.get(i).getVerticeInicial() == vi && 
                    this.listaArcos.get(i).getVerticeFinal() == vj)||
                    this.listaArcos.get(i).getVerticeFinal() == vj && 
                    this.listaArcos.get(i).getVerticeInicial()==vi) {
                return i;
            }
        }
        return -1;
    }

    public int CostoArco(int vi, int vj) {
        if (!this.listaArcos.isEmpty()) {
            int posicion = this.posicionArcoCompleto(vi, vj);
            if (posicion != -1) {
                return this.listaArcos.get(posicion).getCosto();
            }
        }
        return -1;
    }
    public boolean existeArco(long vi, long vj) {
        if (!this.listaArcos.isEmpty()) {
            int posicion = this.posicionArcoCompleto(vi, vj);
            if (posicion != -1) {
                return true;
            }
        }
        return false;
    }

    public T InfoVertice(int subIndice) {
        if (!this.listaVertices.isEmpty()) {
            for (int i = 0; i < this.listaVertices.size(); i++) {
                if (this.listaVertices.get(i).getSubindice() == subIndice) {
                    return this.listaVertices.get(i).getInfo();
                }
            }

        }
        return null;


    }

    public int ordenGrafo() {
        return this.listaVertices.size();
    }

    public void MarcarVertice(int subIndice) {
        for (int i = 0; i < this.listaVertices.size(); i++) {
            if (this.listaVertices.get(i).getSubindice() == subIndice) {
                this.listaVertices.get(i).setMarca(true);
                break;
            }
        }
    }

    public void DesmarcarVertice(Grafo<T> g, int subIndice) {
        for (int i = 0; i < this.listaVertices.size(); i++) {
            if (this.listaVertices.get(i).getSubindice() == subIndice) {
                this.listaVertices.get(i).setMarca(false);
                break;
            }
        }
    }

    public boolean MarcadoVertice(Grafo<T> g, int subIndice) {
        for (int i = 0; i < this.listaVertices.size(); i++) {
            if (this.listaVertices.get(i).getSubindice() == subIndice) {
                return this.listaVertices.get(i).getMarca();
            }
        }
        System.out.println("La marca del vertice no ha sido encontrada");
        return false;
    }
}