/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author yohanna
 */
public class Arco {
        private long vi;
		private long vj;
		private int costo;
        
	public Arco(long v1,long v2,int c){
		vi=v1;
		vj=v2;
	    costo=c;
	}
        public void imprimir(){
            System.out.println("  Desde: "+this.vi+"  Hasta: "+this.vj+"  Costo: "+costo);
        }
	public long getVi() {
		return vi;
	}
	public void setVi(int vi) {
		this.vi = vi;
	}
	public long getVj() {
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
