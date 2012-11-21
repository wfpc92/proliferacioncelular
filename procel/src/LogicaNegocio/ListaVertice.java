/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocio;

/**
 *
 * @author yohanna
 */
public class ListaVertice <T>{
    private NodoVertice<T> cabeza;
	private NodoVertice<T> ventana;
	
		ListaVertice(){              
			cabeza=null;
			ventana=null;
		}
		
		public boolean EsVacio(){
			if (cabeza==null){
				return true;
			}
			else{
				return false;
			}
		}
		
		public NodoVertice<T> crear_nodo(Vertice valor_nodo){
			NodoVertice<T> temp= new NodoVertice<T>(valor_nodo);
		    return temp;
	    }
		
		public void Anex_lista( Vertice conte){
			NodoVertice<T> conte1=crear_nodo(conte);
			
			if (EsVacio()){ 
				cabeza=conte1;
				ventana=conte1;
			}
			else{   
				conte1.setSte(ventana.getSte());
				ventana.setSte(conte1);
				ventana=ventana.getSte();
			} 
		}
		
		public void InsLista(Vertice conte){ 
			NodoVertice<T>conte1=crear_nodo(conte);
			if(EsVacio()){
				cabeza=conte1;
				ventana=conte1;
			}
			else{
				Vertice temp;
				if(ventana==cabeza){
					temp=ventana.getVertice();
					ventana.setVertice(conte1.getVertice());     //le asigno al contenido de venta en contenido de conte
					Anex_lista(temp);
					Anterior_lista();
					cabeza=ventana;
					
				}
				else{
					temp=ventana.getVertice();
					ventana.setVertice(conte1.getVertice());     //le asigno al contenido de venta en contenido de conte
					Anex_lista(temp);
					Anterior_lista();
				}	
			}
		}
		
		public void Siguiente_lista(){
			if(EsVacio()){
				ventana=null;
			}
			else{
				if(ventana.getSte()!=null){
					ventana=ventana.getSte();
				}
			}
		}
		
		public void Primero(){
			if(EsVacio()){
				ventana=null;
			}
			else{
				ventana=cabeza;
			}
		}
		
		public int LongLista(){
			int con=0;
			    NodoVertice<T>p=cabeza;
				while(p!=null){
					p=p.getSte();
					con++;
				}
			return con;
		}

		public void Mostrar(){
			if (!EsVacio()){
				NodoVertice<T> p=cabeza;
			    System.out.println("           VERTICES\n");
				while (p!=null){ 

					System.out.print("\n V"+p.getVertice().getSubindice()+" "+p.getVertice().getInfo()+" ");
					p=p.getSte();
				}
			}
		}

		public void Anterior_lista(){
			if(EsVacio()){
				ventana=null;
			}
			else{
				if(!(ventana==cabeza)){
					NodoVertice<T>z=cabeza;
					while(z.getSte()!=ventana){
						z=z.getSte();
					}
					ventana=z;
				}
		}
	 }
		
		public void posLista(ListaVertice<T> lista,int x,int con){
	    	if(con<x){
	    		lista.Siguiente_lista();
	    		posLista(lista,x,con+1);
	    	}
	    }
		
		public void ElimLista(){
			int ban=0;
			
			if(EsVacio()){
				System.out.println("Lista vacia");
			}
			else{
				NodoVertice<T> q=null;
				NodoVertice<T> p=cabeza;
				while(p != null && ban!=1 ){
					if(p==ventana){
						ban=1;
					}
					else{
						q=p;
						p=p.getSte();	
					}
						
				}
					if(q==null){
						if(p.getSte()==null){
							p=null;
							cabeza=null;
							ventana=null;
						}
						else{
							cabeza=cabeza.getSte();
							ventana=ventana.getSte();
							p=null;
						}
					}
					else{
						q.setSte(p.getSte());
						ventana=ventana.getSte();
						if(ventana==null){
							ultimoLista();
						}
						p=null;
					}
					System.out.println("\n VERTICE ELIMINADO\n");
				
			}
			
		}
		
		public void ultimoLista(){
			if(EsVacio()){
				System.out.println("lista vacia\n");
			}
			else
				Primero();
				while(ventana.getSte()!=null){
					ventana=ventana.getSte();
				}
			Siguiente_lista();
		}
		
		 public boolean finLista(){
		    	if(ventana.getSte()==null){
		    		return true;
		    	}
		    	else{
		    		return false;
		    	}
		    }
		
		public Vertice InfoLista(){
			return ventana.getVertice();
		}	
		
		public boolean BuscarVertice(int subindice,ListaVertice<T> lst){
			
			NodoVertice<T> p=cabeza;
			lst.Primero();
			if(lst.EsVacio()){
				return false;
			}
			else{
				while(!finLista()){
					if(lst.getVentana().getVertice().getSubindice()==subindice){
						return true;
					}
					p=p.getSte();
					ventana=ventana.getSte();
				}
				lst.ultimoLista();
				if(lst.getVentana().getVertice().getSubindice()==subindice){
					return true;
				}
				else{
					return false;
				}
			}	
		}
        
		public int PosicionVertice(int subindice,ListaVertice<T> lst){
			lst.Primero();
			NodoVertice<T> p=cabeza;
			int posicion=0;
			if(lst.EsVacio()){
				return -1;
			}
			else{
				while(!finLista()){
					if(lst.getVentana().getVertice().getSubindice()==subindice){
						return posicion;
					}
					p=p.getSte();
					ventana=ventana.getSte();
					posicion=posicion+1;
				}
				lst.ultimoLista();
				if(lst.getVentana().getVertice().getSubindice()==subindice){
					return posicion+1;
				}
				else{
					return -1;
				}
			}	
		}

		public NodoVertice<T> getCabeza() {
			return cabeza;
		}

		public void setCabeza(NodoVertice<T> cabeza) {
			this.cabeza = cabeza;
		}

		public NodoVertice<T> getVentana() {
			return ventana;
		}

		public void setVentana(NodoVertice<T> ventana) {
			this.ventana = ventana;
		}
}
