
package Comandos;

import Abstracto.Comando;
import Controlador.Controlador;


public class GuardarTejidoComando extends Comando {
    
    public GuardarTejidoComando(Controlador controlador) {
        this.receptor=controlador;
    }

    @Override
    public void ejecutar() {
        receptor.guardarTejido();
    }
    
}
