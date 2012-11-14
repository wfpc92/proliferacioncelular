/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procel;

/**
 *
 * @author yohanna
 */
public class NodoVertice <T> {
    
	private Vertice vertice;
	private NodoVertice<T> ste;
	
	NodoVertice(Vertice x){
		vertice =x;
		ste=null;
	}

	public Vertice getVertice() {
		return vertice;
	}

	public void setVertice(Vertice vertice) {
		this.vertice = vertice;
	}

	public NodoVertice<T> getSte() {
		return ste;
	}

	public void setSte(NodoVertice<T> ste) {
		this.ste = ste;
	}
}
