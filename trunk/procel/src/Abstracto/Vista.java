
package Abstracto;

import Modelo.Celula;
import Modelo.Tejido;
import javax.swing.JFrame;



public abstract class Vista extends Observado implements Observador {
    protected JFrame interfaz = null;
    protected Tejido<Celula> tejido = null;
    public abstract void alistar();
    public abstract void arranca();
    public abstract void termina();
    
    /**
     * Actualizar observado.
     * @param o
     */
    @Override
    public abstract void update(Observado o);
}
