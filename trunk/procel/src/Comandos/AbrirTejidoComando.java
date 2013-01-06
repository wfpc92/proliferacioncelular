
package Comandos;

import Abstracto.Icomando;
import Controlador.Controlador;

public class AbrirTejidoComando implements Icomando{

    Controlador controlador;
    
    public AbrirTejidoComando(Controlador controlador){
        this.controlador = controlador;
    }
    
    @Override
    public void ejecutar() {
        controlador.abrirTejido();
    }
    
}
