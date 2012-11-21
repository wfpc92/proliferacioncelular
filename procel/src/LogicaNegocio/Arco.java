/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocio;

/**
 *
 * @author yohanna
 */
public class Arco <T> {
    private int vi;
	private int vj;
	private int costo;
	
	
	Arco(int v1,int v2,int c){
		vi=v1;
		vj=v2;
	    costo=c;
	}
	
	public int getVi() {
		return vi;
	}
	public void setVi(int vi) {
		this.vi = vi;
	}
	public int getVj() {
		return vj;
	}
	public void setVj(int vj) {
		this.vj = vj;
	}
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}
}
