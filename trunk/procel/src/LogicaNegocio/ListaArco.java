/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocio;

/**
 *
 * @author yohanna
 */
public class ListaArco <T> {
    private NodoArco<T> cabeza;
	private NodoArco<T> ventana;
	
		ListaArco(){               //crear lista
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
		
		public NodoArco<T> crear_nodo(Arco<T> valor_nodo){
			NodoArco<T> temp= new NodoArco<T>(valor_nodo);
		    return temp;
	    }
		
		public void Anex_lista( Arco<T> conte){
			
			NodoArco<T> conte1=crear_nodo(conte);
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
		
		public void InsLista(Arco<T> conte){ 
			NodoArco<T>conte1=crear_nodo(conte);
			if(EsVacio()){
				cabeza=conte1;
				ventana=conte1;
			}
			else{
				Arco<T> temp;
				if(ventana==cabeza){
					temp=ventana.getArco();
					ventana.setArco(conte1.getArco());     //le asigno al contenido de venta en contenido de conte
					Anex_lista(temp);
					Anterior_lista();
					cabeza=ventana;
					
				}
				else{
					temp=ventana.getArco();
					ventana.setArco(conte1.getArco());     //le asigno al contenido de venta en contenido de conte
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
			    NodoArco<T>p=cabeza;
				while(p!=null){
					p=p.getSte();
					con++;
				}
			return con;
		}

		public void Mostrar(){
			if (!EsVacio()){
				NodoArco<T> p=cabeza;
			    System.out.println("           ARCOS\n");
				while (p!=null){          
					System.out.println("\n("+p.getArco().getVi()+","+p.getArco().getVj()+","+p.getArco().getCosto()+")");
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
					NodoArco<T>z=cabeza;
					while(z.getSte()!=ventana){
						z=z.getSte();
					}
					ventana=z;
				}
		}
	 }
		
		public void posLista(ListaArco<T> lista,int x,int con){
	    	if(con<x){
	    		lista.Siguiente_lista();
	    		posLista(lista,x,con+1);
	    	}
	    }
		
		public void ElimLista(){
			int ban=0;
			
			if(!EsVacio()){
				
				NodoArco<T> q=null;
				NodoArco<T> p=cabeza;
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
		
		public Arco<T> InfoLista(){
			return ventana.getArco();
		}
		
		public boolean BuscarArco(int subindice,ListaArco<T> lst){
			lst.Primero();
			NodoArco<T> p=cabeza;
			ventana=cabeza;
			if(lst.EsVacio()){
				return false;
			}
			else{
				while(!finLista()){
					if(lst.ventana.getArco().getVi()==subindice || lst.ventana.getArco().getVj()==subindice){
						return true;
					}
					p=p.getSte();
					ventana=ventana.getSte();
				}
				lst.ultimoLista();
				if(lst.ventana.getArco().getVi()==subindice || lst.ventana.getArco().getVj()==subindice){
					return true;
				}
				else{
					return false;
				}
			}	
		}
		
		public int PosicionArcoCompleto(int vi,int vj,ListaArco<T> lst){
			int posicion=0;
			NodoArco<T> p=cabeza;
			lst.Primero();
			ventana=cabeza;
			if(lst.EsVacio()){
				return -1;
			}
			else{
				while(!finLista()){
					if(lst.ventana.getArco().getVi()==vi && lst.ventana.getArco().getVj()==vj){
						return posicion;
					}
					p=p.getSte();
					ventana=ventana.getSte();
					posicion=posicion+1;
				}
				lst.ultimoLista();
				if(lst.ventana.getArco().getVi()==vi && lst.ventana.getArco().getVj()==vj){
					return posicion+1;
				}
				else{
					return -1;
				}
			}	
		}
		
		public int PosicionArco(int subindice,ListaArco<T> lst){
			lst.Primero();
			NodoArco<T> p=cabeza;
			int pos=0;
			ventana=cabeza;
			if(lst.EsVacio()){
				return -1;
			}
			else{
				while(!finLista()){
					if(lst.ventana.getArco().getVi()==subindice || lst.ventana.getArco().getVj()==subindice){
						return pos;
					}
					p=p.getSte();
					ventana=ventana.getSte();
					pos=pos+1;
				}
				lst.ultimoLista();
				if(lst.ventana.getArco().getVi()==subindice || lst.ventana.getArco().getVj()==subindice){
					return pos+1;
				}
				else{
					return -1;
				}
			}	
		}

		public NodoArco<T> getCabeza() {
			return cabeza;
		}

		public void setCabeza(NodoArco<T> cabeza) {
			this.cabeza = cabeza;
		}

		public NodoArco<T> getVentana() {
			return ventana;
		}

		public void setVentana(NodoArco<T> ventana) {
			this.ventana = ventana;
		}

}
