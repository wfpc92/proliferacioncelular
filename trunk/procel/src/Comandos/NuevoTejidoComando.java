
package Comandos;

import Abstracto.Icomando;
import Controlador.Controlador;


public class NuevoTejidoComando implements Icomando {

    Controlador controlador;
    
    public NuevoTejidoComando(Controlador controlador){
        this.controlador = controlador;
    }
    
    @Override
    public void ejecutar() {
        controlador.nuevoTejido();       
    }
    
    
}
