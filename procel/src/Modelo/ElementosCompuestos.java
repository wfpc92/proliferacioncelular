/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Abstracto.Componente;
import java.util.ArrayList;


public  abstract class ElementosCompuestos implements Componente{

     protected ArrayList<Componente> hijo  =new ArrayList<>();
    @Override
    public void add(Componente c) {
        hijo.add(c);
    }

    @Override
    public void eliminar(Componente c) {
        hijo.remove(c);
    }

    @Override
    public Componente obtenerHijo(int num) {
        return hijo.get(num);
    }

    @Override
    public abstract void mostrar();   
    
}
