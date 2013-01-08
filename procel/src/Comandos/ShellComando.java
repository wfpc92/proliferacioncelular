
package Comandos;

import Abstracto.Comando;
import Controlador.Controlador;


public class ShellComando  extends Comando {

    public ShellComando(Controlador controlador) {
        this.receptor = controlador;
    }

    @Override
    public void ejecutar() {
        receptor.iniciarShell();
    }
    
}
