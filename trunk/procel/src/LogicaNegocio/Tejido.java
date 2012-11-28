package LogicaNegocio;

import java.util.ArrayList;
import java.util.Random;

public class Tejido<T> {
    private int id;
    private String nombre;
    private Grafo<T> TejidoG;
    private long con;
    private ArrayList<T> celulasIncompletas;
    private long tamMuestra;
    
     public Tejido(){
        this.id = 0;
        this.nombre = "";
        this.TejidoG = new Grafo<>();
        this.con=0;
        this.celulasIncompletas=new ArrayList<>();
    }
    public Tejido(int id, String nombre,T celIni,long tamanio) {
        this.id = id;
        this.nombre = nombre;
        this.TejidoG = new Grafo<>();
        this.con=0;
        this.celulasIncompletas=new ArrayList<>();
        this.tamMuestra=tamanio;
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
 
    public void abrirTejido() {
        ArrayList<T> lstAux=new ArrayList<>();
       for(int i=0;i<this.celulasIncompletas.size();i++)
       {
           while(!this.esCompleto(this.celulasIncompletas.get(i))&& this.TejidoG.getLista_vertices().size()<this.tamMuestra)
           {
               this.con++;
               Celula cel=new Celula(con,10,GenerarNumeroLados());
               lstAux.add((T)cel);
               this.TejidoG.AgregarVertice((T)cel,con);
               this.TejidoG.AgregarArco(((Celula)this.celulasIncompletas.get(i)).getId(),((Celula)cel).getId(),10);
           }
       }
       this.celulasIncompletas=lstAux;
    }
    public boolean esCompleto(T cel){
        int contadorLados=0;
        ArrayList<Arco> arcos=this.TejidoG.getListaArcos();
        for(int i=0;i<arcos.size() && contadorLados<((Celula)cel).getNumLado();i++){
            if(arcos.get(i).getVi()==((Celula)cel).getId()||arcos.get(i).getVj()==((Celula)cel).getId()){
                contadorLados++;
            }
        }
        if(contadorLados<((Celula)cel).getNumLado()){
            return false;
        }
        return true;
    }
    
    public int GenerarNumeroLados (){
        Random ran=new Random();
        int newLado=0;
        do{
             newLado=ran.nextInt(9);
        }while(newLado<=4);
        return newLado;
    }
    public void cerrarTejido(){
        int j;
        for(j=0;j< (celulasIncompletas.size())-1;j++){
            this.TejidoG.AgregarArco(((Celula)celulasIncompletas.get(j)).getId(), ((Celula)celulasIncompletas.get(j+1)).getId(),10);   
        }
        //conectando el ultimo con el primero
        this.TejidoG.AgregarArco(((Celula)celulasIncompletas.get(j)).getId(),((Celula)celulasIncompletas.get(0)).getId() ,10);
    }
    public void imprimirTejido()
    {
        ArrayList<Arco> arcos=this.TejidoG.getListaArcos();
        for(int i=0;i<this.TejidoG.getListaArcos().size();i++)
        {
            arcos.get(i).imprimir();
        }
    }
    public void triangularizacion() {
       while(this.TejidoG.getLista_vertices().size()<this.tamMuestra){
            this.abrirTejido();
            this.cerrarTejido();
       }
       this.imprimirTejido();
    }
}
