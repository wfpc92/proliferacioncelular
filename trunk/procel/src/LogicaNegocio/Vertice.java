/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocio;

/**
 *
 * @author yohanna
 */
public class Vertice {
    private int info;
	private boolean marca;
	private int subindice;
	
	Vertice(){
		marca=false;
	}
	Vertice(int x){
		info=x;
		marca=false;
	}
	
	public int getInfo() {
		return info;
	}
	public void setInfo(int info) {
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
