/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class Vecindario extends ElementosCompuestos{

    @Override
    public void mostrar() {
        for(int i=0;i<hijo.size();i++){
            hijo.get(i).mostrar( );
        }
    }
    
    
    
}
