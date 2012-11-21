package LogicaNegocio;
public class NodoLista <T>{
	private T contenido;
	private NodoLista<T> ste;
	
	NodoLista(T x){
		
		contenido=x;
		ste=null;
	}
	
	public void Set_contenido(T x){
		contenido=x;
	}
	public void Set_ste(NodoLista<T> siguiente){
		ste=siguiente;
	}
	
	public T Get_contenido(){
		return contenido;
	}
	public NodoLista<T> Get_ste(){
		return ste;
	}
}
