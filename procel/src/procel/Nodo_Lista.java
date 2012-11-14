/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procel;

/**
 *
 * @author yohanna
 */
public class Nodo_Lista <T> {
    private T contenido;
	private Nodo_Lista<T> ste;
	
	Nodo_Lista(T x){
		
		contenido=x;
		ste=null;
	}
	
	public void Set_contenido(T x){
		contenido=x;
	}
	public void Set_ste(Nodo_Lista<T> siguiente){
		ste=siguiente;
	}
	
	public T Get_contenido(){
		return contenido;
	}
	public Nodo_Lista<T> Get_ste(){
		return ste;
	}
}
