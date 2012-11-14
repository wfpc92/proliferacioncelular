/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procel;

/**
 *
 * @author yohanna
 */
public class NodoArco <T>{
    private Arco arco;
	private NodoArco<T> ste;
	
	NodoArco(Arco x){
		arco =x;
		ste=null;
	}

	public Arco getArco() {
		return arco;
	}

	public void setArco(Arco arco) {
		this.arco = arco;
	}

	public NodoArco<T> getSte() {
		return ste;
	}

	public void setSte(NodoArco<T> ste) {
		this.ste = ste;
	}
}
