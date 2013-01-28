
package Comandos;

import Abstracto.Comando;
import Controlador.Controlador;
public class StrategyComando extends Comando{

    public StrategyComando(Controlador controlador) {
       this.receptor = controlador;
    }
    
    @Override
    public void ejecutar() {
        receptor.mostrarMensajeEsteril();
    }
    
}
