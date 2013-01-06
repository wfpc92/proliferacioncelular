
package Comandos;

import Abstracto.Icomando;
import Controlador.Controlador;


public class GuardarTejidoComando implements Icomando {
    Controlador controlador;
    
    public GuardarTejidoComando(Controlador controlador) {
        this.controlador=controlador;
    }

    @Override
    public void ejecutar() {
        controlador.guardarTejido();
    }
    
}
