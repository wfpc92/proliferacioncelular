
package Comandos;

import Abstracto.Icomando;
import Controlador.Controlador;


public class ShellComando  implements Icomando {

    Controlador controlador;
    
    public ShellComando(Controlador controlador) {
        this.controlador = controlador;
    }

    @Override
    public void ejecutar() {
        controlador.iniciarShell();
    }
    
}
