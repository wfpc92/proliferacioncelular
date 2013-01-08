
package Comandos;

import Abstracto.Comando;
import Controlador.Controlador;

public class AbrirTejidoComando extends Comando{

    public AbrirTejidoComando(Controlador controlador){
        this.receptor = controlador;
    }
    
    @Override
    public void ejecutar() {
        receptor.abrirTejido();
    }
    
}
