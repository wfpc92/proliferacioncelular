/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocio;

/**
 *
 * @author yohanna
 */
public class Vertice<T> {
        private T info;
	private boolean marca;
	private int subindice;
	
	Vertice(){
		this.marca=false;
                this.subindice=0;
	}
	Vertice(T x){
		info=x;
		marca=false;
	}
	
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	public boolean getMarca() {
		return marca;
	}
	public void setMarca(boolean marca) {
		this.marca = marca;
	}
	public int getSubindice() {
		return subindice;
	}
	public void setSubindice(int subindice) {
		this.subindice = subindice;
	}
}