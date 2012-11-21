package LogicaNegocio;
public class Lista <T> {
   
	
    private NodoLista<Integer> ventana;
    private NodoLista<Integer> cabeza;
   
	
    Lista(){
		cabeza=null;
	    ventana=null;	
    }
	 
     public boolean EsVacio(){
		if (ventana==null){
			return true;
		}
		else{
			return false;
		}
     }
	
      public NodoLista<Integer> crear_nodo(Integer valor_nodo){
			NodoLista<Integer> temp= new NodoLista<Integer>(valor_nodo);
		    return temp;
        }
      //Agrega un valor a la derecha de la ventana
      public void anexarLista(int x){
       
    	NodoLista<Integer> valor;
      	valor=crear_nodo(x);
    	if(EsVacio()){
    		cabeza=valor;
    		ventana=cabeza;	
    	}
    	else{
    		if(ventana.Get_ste()!=null){
    			valor.Set_ste(ventana.Get_ste());
    			ventana.Set_ste(valor);
    			ventana=ventana.Get_ste();
    		}
    		else{
    			ventana.Set_ste(valor);
        		ventana=ventana.Get_ste();	
    		}	
    	}
     }
     
     //Ubica la ventana en el primer elemento de la lista
      public void primeroLista(){
    	  if(!EsVacio()){
    		  ventana=cabeza;	
    	  }
      }
      
     //Ubica la ventana en el elemento siguiente
      public void siguienteLista(){
    	  if(!EsVacio()){
    		  if(ventana.Get_ste()!=null){
    			  ventana=ventana.Get_ste();
    		  }
    	  }
      }
      
      
     //Agrega un elemento a la izquierda de la ventana
    public void insertarLista(int x){
    	  NodoLista<Integer> p=cabeza;
		  NodoLista<Integer> valor=crear_nodo(x);
    	  if(EsVacio()){
    		  cabeza=valor;
    		  ventana=cabeza;
    	  }
    	  else{
    		  if(ventana==cabeza){
    			  valor.Set_ste(cabeza);
    			  cabeza=valor;
    			  ventana=cabeza;
    		  }
    		  else{
    			  while(p.Get_ste()!=ventana){
        			  p=p.Get_ste();
        		  }
        		  valor.Set_ste(ventana);
        		  p.Set_ste(valor);
        		  ventana=valor;
    			  
    		  }
    	  }
      }
    
    //Elimina el elemento que se encuentra en la ventana
    
    public void elimLista(){
    	
    	
    	if(!EsVacio()){
    		if(ventana==cabeza){
    			if(ventana.Get_ste()==null){
    				cabeza=null;
    				ventana=null;
    			}
    			else{
    				ventana=cabeza.Get_ste();
    				cabeza=null;
    				cabeza=ventana;
    			}
    		}
    		else{
    			NodoLista<Integer> q=cabeza;
				while(q.Get_ste()!=ventana){
					q=q.Get_ste();
				}
    			if(ventana.Get_ste()!=null){
    				q.Set_ste(ventana.Get_ste());
    				ventana=q.Get_ste();
    			}
    			else{
    				ventana=null;
    				q.Set_ste(null);
    				ventana=q;	
    			}
    		}
    	}
    }
    
    //Retorna el valor del elemento en el que se encuentra la ventana
    public int infoLista(){
    	return ventana.Get_contenido(); 	
    }
    
    //Muestra los elementos de la lista y el elemento que se encuentra en la ventana
    public void mostrarLista(){
    	NodoLista<Integer> q=cabeza;
    	if(!EsVacio()){
    		System.out.println("\n " );
    		while(q!=null){
        		System.out.println(" "+q.Get_contenido());
        		q=q.Get_ste();
        	}
    	}
    }
    public boolean Buscar(int buscado,Lista<T> lst){
		
		NodoLista<Integer> p=cabeza;
		lst.primeroLista();
		if(lst.EsVacio()){
			return false;
		}
		else{
			while(!finLista()){
				if(lst.getVentana().Get_contenido()==buscado){
					return true;
				}
				p=p.Get_ste();
				ventana=ventana.Get_ste();
			}
			lst.ultimoLista();
			if(lst.getVentana().Get_contenido()==buscado){
				return true;
			}
			else{
				return false;
			}
		}	
	}
    //Ubica la ventana en el ultimo elemento de la lista
    public void ultimoLista(){
    	NodoLista<Integer> p=cabeza;
    	while(p.Get_ste()!=null){
    		p=p.Get_ste();
    	}
    	ventana=p;
    		
    }
    
    //Devueleve verdadero si la ventana esta en la ultima posicion de la lista
    
    public boolean finLista(){
    	if(ventana.Get_ste()==null){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    
    //Devuelve la longitud de la lista
    public int longLista(){
    	if(ventana==null){
    		return 0;
    	}
    	else{
    		if(finLista()){
    			return 1;
    		}
    		else{
    			siguienteLista();
        		return longLista()+1;
    		}
    	}
    }
    
    public void posLista(Lista<String> lista_expresion,int x,int con){
    	if(con<x){
    		lista_expresion.siguienteLista();
    		posLista(lista_expresion,x,con+1);
    	}
    }

	public NodoLista<Integer> getVentana() {
		return ventana;
	}

	public void setVentana(NodoLista<Integer> ventana) {
		this.ventana = ventana;
	}

	public NodoLista<Integer> getCabeza() {
		return cabeza;
	}

	public void setCabeza(NodoLista<Integer> cabeza) {
		this.cabeza = cabeza;
	}
}
